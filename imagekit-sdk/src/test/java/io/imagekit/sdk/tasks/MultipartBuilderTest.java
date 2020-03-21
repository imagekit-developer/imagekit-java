package io.imagekit.sdk.tasks;

import com.google.gson.Gson;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.FileUpdateRequest;
import okhttp3.*;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;


public class MultipartBuilderTest {
    MockWebServer server;
    Map<String, String> headers;
    OkHttpClient okHttpClient;
    MultipartBuilder SUT;

    @Before
    public void setUp() throws Exception {
        SUT=new MultipartBuilder();

        String credential = Credentials.basic("private_key_test","");
        headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        server = new MockWebServer();
        MockResponse response=new MockResponse()
                .setResponseCode(200)
                .setBody("{isSuccessful=true, message='Your request contains invalid file.', help='For support kindly contact us at support@imagekit.io .', fileId='null', name='null', url='null', thumbnail='null', height=0, width=0, size=0, filePath='null', tags='null', isPrivateFile=false, customCoordinates='null', fileType='null'}");

        server.setDispatcher(new Dispatcher() {
            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
                return response;
            }
        });
        server.start();

        okHttpClient= new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .writeTimeout(2, TimeUnit.SECONDS)
                .build();

    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void build_test_with_FileCreateRequest() throws Exception{

        FileCreateRequest fileCreateRequest=new FileCreateRequest("f06830ca9f1e3e90","demo.jpg");
        fileCreateRequest.setPrivateFile(true);

        MultipartBody body = SUT.build(fileCreateRequest);

        HttpUrl baseUrl = server.url("/api/v1/files/upload");
        Request request=new Request.Builder()
                .url(baseUrl)
                .post(body)
                .headers(Headers.of(headers))
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String boundary=body.boundary();

        String expectedMultipartData="--"+boundary+"\r\n" +
                "Content-Disposition: form-data; name=\"file\"\r\n" +
                "Content-Length: 16\r\n\r\n" +
                "f06830ca9f1e3e90\r\n" +
                "--"+boundary+"\r\n" +
                "Content-Disposition: form-data; name=\"fileName\"\r\n" +
                "Content-Length: 8\r\n\r\n" +
                "demo.jpg\r\n" +
                "--"+boundary+"\r\n" +
                "Content-Disposition: form-data; name=\"useUniqueFileName\"\r\n" +
                "Content-Length: 4\r\n\r\n" +
                "true\r\n" +
                "--"+boundary+"\r\n" +
                "Content-Disposition: form-data; name=\"isPrivateFile\"\r\n" +
                "Content-Length: 4\r\n\r\n" +
                "true\r\n" +
                "--"+boundary+"--\r\n";

        // It's capture multipart request
        RecordedRequest recordedRequest=server.takeRequest();

        String data=recordedRequest.getBody().readUtf8();

        assertEquals(expectedMultipartData, data);
    }

    @Test
    public void build_test_with_FileUpdateRequest() throws Exception{

        FileUpdateRequest fileUpdateRequest=new FileUpdateRequest("598821f949c0a938d57563bd");
        List<String> tags=new ArrayList<>();
        tags.add("t-shirt");
        tags.add("round-neck");
        tags.add("sale2020");
        fileUpdateRequest.setTags(tags);

        RequestBody body=SUT.build(fileUpdateRequest);

        HttpUrl baseUrl = server.url(String.format("/v1/files/%s/details",fileUpdateRequest.getFileId()));
        Request request=new Request.Builder()
                .url(baseUrl)
                .post(body)
                .headers(Headers.of(headers))
                .build();

        Response response = okHttpClient.newCall(request).execute();


        String expectedRequestObject="{\"fileId\":\"598821f949c0a938d57563bd\",\"tags\":[\"t-shirt\",\"round-neck\",\"sale2020\"]}";

        // It's capture multipart request
        RecordedRequest recordedRequest=server.takeRequest();

        String data=recordedRequest.getBody().readUtf8();

        assertEquals(expectedRequestObject, data);
    }

    @Test
    public void build_test_with_From_Json_String() throws Exception{

        String json="{\"fileIds\":[\"598821f949c0a938d57534bd\",\"338821f949c0a938d57563bz\",\"987821f949c0a938d57563rt\"]}";

        RequestBody body=SUT.build(json);

        HttpUrl baseUrl = server.url("/v1/files/batch/deleteByFileIds");
        Request request=new Request.Builder()
                .url(baseUrl)
                .post(body)
                .headers(Headers.of(headers))
                .build();

        Response response = okHttpClient.newCall(request).execute();


        String expectedRequestObject="{\"fileIds\":[\"598821f949c0a938d57534bd\",\"338821f949c0a938d57563bz\",\"987821f949c0a938d57563rt\"]}";

        // It's capture multipart request
        RecordedRequest recordedRequest=server.takeRequest();

        String data=recordedRequest.getBody().readUtf8();

        assertEquals(expectedRequestObject, data);
    }
}