package io.imagekit.sdk.tasks;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.models.CustomMetaDataFieldRequest;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.FileUpdateRequest;
import io.imagekit.sdk.models.TagsRequest;
import io.imagekit.sdk.models.results.*;
import io.imagekit.sdk.utils.Utils;
import okhttp3.*;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class RestClientTest {

    RestClient SUT;

    @Before
    public void setUp() throws Exception {
        ImageKit imageKit=ImageKit.getInstance();
        imageKit.setConfig(Utils.getSystemConfig(RestClientTest.class));
        SUT=new RestClient(imageKit);
    }

    @Test
    public void valid_upload_expectSuccess() {
        OkHttpClientStub clientStub= new OkHttpClientStub("{}", 200, "Ok");
        SUT.setClient(clientStub);

        MultipartBuilder multipartBuilder=mock(MultipartBuilder.class);
        MultipartBody body=new MultipartBody.Builder().addFormDataPart("","").build();
        ArgumentCaptor<FileCreateRequest> ac=ArgumentCaptor.forClass(FileCreateRequest.class);
        when(multipartBuilder.build(ac.capture())).thenReturn(body);
        SUT.setMultipartBuilder(multipartBuilder);

        FileCreateRequest fileCreateRequest=new FileCreateRequest("f06830ca9f1e3e90","demo.jpg");
        fileCreateRequest.setPrivateFile(true);
        Result result = SUT.upload(fileCreateRequest);
        assertEquals(fileCreateRequest,ac.getValue());
    }

    @Test
    public void valid_upload_with_all_params_expectSuccess() {
        String resp="{\n" +
                "    \"fileId\" : \"598821f949c0a938d57563bd\"," +
                "    \"name\": \"demo.jpg\"," +
                "    \"url\": \"https://ik.imagekit.io/your_imagekit_id/images/products/demo_xdf231.jpg\"," +
                "    \"thumbnail\": \"https://ik.imagekit.io/your_imagekit_id/tr:n-media_library_thumbnail/images/products/demo_xdf231.jpg\"," +
                "    \"height\" : \"200\"," +
                "    \"width\" : \"200\"," +
                "    \"size\" : \"83622\"," +
                "    \"filePath\": \"/images/products/demo.jpg\"," +
                "    \"tags\": [\"t-shirt\",\"round-neck\",\"sale2020\"]," +
                "    \"isPrivateFile\" : true," +
                "    \"customCoordinates\" : \"10,10,200,200\"," +
                "    \"fileType\": \"image\"" +
                "}";

        OkHttpClientStub clientStub= new OkHttpClientStub(resp, 200, "Ok");
        SUT.setClient(clientStub);

        MultipartBuilder multipartBuilder=mock(MultipartBuilder.class);
        MultipartBody body=new MultipartBody.Builder().addFormDataPart("","").build();
        ArgumentCaptor<FileCreateRequest> ac=ArgumentCaptor.forClass(FileCreateRequest.class);
        when(multipartBuilder.build(ac.capture())).thenReturn(body);
        SUT.setMultipartBuilder(multipartBuilder);

        FileCreateRequest fileCreateRequest=new FileCreateRequest("f06830ca9f1e3e90","demo.jpg");
        fileCreateRequest.setFolder("/images/products");
        fileCreateRequest.setPrivateFile(true);
        fileCreateRequest.setCustomCoordinates("10,10,200,200");
        List<String> tags=new ArrayList<>();
        tags.add("t-shirt");
        tags.add("round-neck");
        tags.add("sale2020");
        fileCreateRequest.setTags(tags);

        Result result = SUT.upload(fileCreateRequest);
        assertEquals(fileCreateRequest,ac.getValue());
    }

    @Test
    public void invalid_upload_expectFailed() {
        JsonObject json=new JsonObject();
        json.addProperty("message","Un-processable Entity");
        OkHttpClientStub clientStub= new OkHttpClientStub(json.toString(),
                422, "Un-processable Entity");
        SUT.setClient(clientStub);
        FileCreateRequest fileCreateRequest=new FileCreateRequest("http://localhost","demo.jpg");
        Result result = SUT.upload(fileCreateRequest);
        assertThat("Un-processable Entity",is(result.getMessage()));
    }

    @Test
    public void internalServerError_upload_expectFailed() {
        JsonObject json=new JsonObject();
        json.addProperty("message","Error: Internal server error.");
        OkHttpClientStub clientStub= new OkHttpClientStub(json.toString(),
                500, "Internal Server Error.");
        SUT.setClient(clientStub);
        FileCreateRequest fileCreateRequest=new FileCreateRequest("http://localhost","demo.jpg");
        Result result = SUT.upload(fileCreateRequest);
        assertThat("Error: Internal server error.",is(result.getMessage()));
    }

    @Test(expected = RuntimeException.class)
    public void ioException_upload_with_empty_file_expectFailed() {
        JsonObject json=new JsonObject();
        json.addProperty("message","Error message");
        OkHttpClientStub clientStub= new OkHttpClientStub(json.toString(),
                500, "Internal Server Error");
        SUT.setClient(clientStub);

        MultipartBuilder multipartBuilder=mock(MultipartBuilder.class);
        MultipartBody body=new MultipartBody.Builder().addFormDataPart("","").build();
        ArgumentCaptor<FileCreateRequest> ac=ArgumentCaptor.forClass(FileCreateRequest.class);
        doThrow(new IOException()).when(multipartBuilder.build(ac.capture()));
        SUT.setMultipartBuilder(multipartBuilder);

        FileCreateRequest fileCreateRequest=new FileCreateRequest("","");
        Result result = SUT.upload(fileCreateRequest);
        assertNotNull(result.getMessage());
    }

    @Test(expected = RuntimeException.class)
    public void valid_upload_with_network_issue_expectException() {
        String resp="{\n" +
                "    \"fileId\" : \"598821f949c0a938d57563bd\"," +
                "    \"name\": \"demo.jpg\"," +
                "    \"url\": \"https://ik.imagekit.io/your_imagekit_id/demo_xdf231.jpg\"," +
                "    \"thumbnail\": \"https://ik.imagekit.io/your_imagekit_id/tr:n-media_library_thumbnail/demo_xdf231.jpg\"," +
                "    \"height\" : \"300\"," +
                "    \"width\" : \"200\"," +
                "    \"size\" : \"83622\"," +
                "    \"filePath\": \"/demo.jpg\"," +
                "    \"tags\": null," +
                "    \"isPrivateFile\" : false," +
                "    \"customCoordinates\" : null," +
                "    \"fileType\": \"image\"" +
                "}";
        OkHttpClientStub clientStub= new OkHttpClientStub(resp,
                200, "Ok");
        SUT.setClient(clientStub);
        FileCreateRequest fileCreateRequest=new FileCreateRequest("f06830ca9f1e3e90","demo.jpg");
        clientStub.setTimeoutException();
        Result result = SUT.upload(fileCreateRequest);
        assertEquals(resp,result.getResponseMetaData().getRaw());
    }

    @Test
    public void valid_updateDetail_expectSuccess() {
        String resp="{\n" +
                "    \"fileId\" : \"598821f949c0a938d57563bd\"," +
                "    \"type\": \"file\"," +
                "    \"name\": \"demo.jpg\",\n" +
                "    \"filePath\": \"/demo.jpg\",\n" +
                "    \"tags\": [\"t-shirt\",\"round-neck\",\"sale2019\"],\n" +
                "    \"isPrivateFile\" : false,\n" +
                "    \"customCoordinates\" : null,\n" +
                "    \"url\": \"https://ik.imagekit.io/your_imagekit_id/demo.jpg\",\n" +
                "    \"thumbnail\": \"https://ik.imagekit.io/your_imagekit_id/tr:n-media_library_thumbnail/demo.jpg\",\n" +
                "    \"fileType\": \"image\"\n" +
                "}";
        OkHttpClientStub clientStub= new OkHttpClientStub(resp,
                200, "Ok");
        SUT.setClient(clientStub);

        MultipartBuilder multipartBuilder=mock(MultipartBuilder.class);
        MultipartBody body=new MultipartBody.Builder().addFormDataPart("","").build();
        ArgumentCaptor<FileUpdateRequest> ac=ArgumentCaptor.forClass(FileUpdateRequest.class);
        when(multipartBuilder.build(ac.capture())).thenReturn(body);
        SUT.setMultipartBuilder(multipartBuilder);

        FileUpdateRequest fileUpdateRequest=new FileUpdateRequest("598821f949c0a938d57563bd");
        List<String> tags=new ArrayList<>();
        tags.add("t-shirt");
        tags.add("round-neck");
        tags.add("sale2020");
        fileUpdateRequest.setTags(tags);
        Result result = SUT.updateDetail(fileUpdateRequest);
        assertEquals(fileUpdateRequest,ac.getValue());
    }

    @Test
    public void internalServerError_updateDetail_expectFailed() {
        JsonObject json=new JsonObject();
        json.addProperty("message","Internal Server Error");
        OkHttpClientStub clientStub= new OkHttpClientStub(json.toString(),
                500, "Internal Server Error");
        SUT.setClient(clientStub);
        FileUpdateRequest fileUpdateRequest=new FileUpdateRequest("my_file_id");
        Result result = SUT.updateDetail(fileUpdateRequest);
        assertNotNull(result.getMessage());
    }

    @Test
    public void unprocessable_updateDetail_expectFailed() {
        JsonObject json=new JsonObject();
        json.addProperty("message","Internal Server Error");
        OkHttpClientStub clientStub= new OkHttpClientStub(json.toString(),
                422, "Un-processable Entity");
        SUT.setClient(clientStub);
        FileUpdateRequest fileUpdateRequest=new FileUpdateRequest("my_file_id");
        Result result = SUT.updateDetail(fileUpdateRequest);
        assertNotNull(result.getMessage());
    }

    @Test(expected = RuntimeException.class)
    public void timeOutException_updateDetail_expectFailed() {
        JsonObject json=new JsonObject();
        json.addProperty("message","Internal Server Error");
        OkHttpClientStub clientStub= new OkHttpClientStub(json.toString(),
                422, "Un-processable Entity");
        SUT.setClient(clientStub);
        clientStub.setTimeoutException();
        FileUpdateRequest fileUpdateRequest=new FileUpdateRequest("my_file_id");
        Result result = SUT.updateDetail(fileUpdateRequest);
        assertNotNull(result.getMessage());
    }

    @Test
    public void valid_getFileList_expectSuccess() {
        String resp="[\n" +
                "\t{\n" +
                "\t    \"fileId\" : \"598821f949c0a938d57563bd\",\n" +
                "        \"type\": \"file\",\n" +
                "        \"name\": \"demo.jpg\",\n" +
                "        \"filePath\": \"/demo.jpg\",\n" +
                "        \"tags\": [\"t-shirt\",\"round-neck\",\"sale2019\"],\n" +
                "        \"isPrivateFile\" : false,\n" +
                "        \"customCoordinates\" : null,\n" +
                "        \"url\": \"https://ik.imagekit.io/your_imagekit_id/demo.jpg\",\n" +
                "        \"thumbnail\": \"https://ik.imagekit.io/your_imagekit_id/tr:n-media_library_thumbnail/demo.jpg\"," +
                "        \"fileType\": \"image\"" +
                "    }" +
                "]";

        OkHttpClientStub clientStub= new OkHttpClientStub(resp, 200, "Ok");

        SUT.setClient(clientStub);

        Map<String , String> options=new HashMap<>();
        options.put("skip","0");
        options.put("limit", "10");

        ResultList result = SUT.getFileList(options);


        assertEquals("https://api.imagekit.io/v1/files?limit=10&skip=0",SUT.request.url().toString());

        assertThat(resp,is(result.getResponseMetaData().getRaw()));
    }

    @Test
    public void unProcessableEntity_getFileList_expectFailed() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","Un-processable Entity");

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                422, "Un-processable Entity");
        SUT.setClient(clientStub);
        Map<String , String> options=new HashMap<>();
        options.put("skip","0");
        options.put("limit", "10");
        ResultList result = SUT.getFileList(options);
        assertNotNull(result.getMessage());
    }

    @Test
    public void internalServerError_getFileList_expectFailed() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","Internal Server Error");

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                500, "Internal Server Error");
        SUT.setClient(clientStub);
        Map<String , String> options=new HashMap<>();
        options.put("skip","0");
        options.put("limit", "10");
        ResultList result = SUT.getFileList(options);
        assertNotNull(result.getMessage());
    }

    @Test
    public void getFileDetails_valid_request_expect_success() {
        String resp="{\n" +
                "    \"fileId\" : \"598821f949c0a938d57563bd\"," +
                "    \"type\": \"file\"," +
                "    \"name\": \"demo.jpg\",\n" +
                "    \"filePath\": \"/demo.jpg\",\n" +
                "    \"tags\": [\"t-shirt\",\"round-neck\",\"sale2019\"],\n" +
                "    \"isPrivateFile\" : false,\n" +
                "    \"customCoordinates\" : null,\n" +
                "    \"url\": \"https://ik.imagekit.io/your_imagekit_id/demo.jpg\",\n" +
                "    \"thumbnail\": \"https://ik.imagekit.io/your_imagekit_id/tr:n-media_library_thumbnail/demo.jpg\",\n" +
                "    \"fileType\": \"image\"\n" +
                "}";

        OkHttpClientStub clientStub= new OkHttpClientStub(resp,
                200, "Ok");
        SUT.setClient(clientStub);
        Result result = SUT.getFileDetail("598821f949c0a938d57563bd");
        // Asserting endpoint sending to server
        assertEquals("https://api.imagekit.io/v1/files/598821f949c0a938d57563bd/details",SUT.request.url().toString());
        // Asserting mock response getting from server.
        assertThat(resp, is(result.getResponseMetaData().getRaw()));
    }

    @Test
    public void getFileDetails_internal_server_error() {
        JsonObject obj=new JsonObject();

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                500, "Internal Server Error");
        SUT.setClient(clientStub);
        Result result = SUT.getFileDetail("fileId");
        assertNotNull( result.getMessage());
    }

    @Test
    public void getFileDetails_un_processable_entity() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","Un-processable Entity.");

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                433, "Un-processable Entity");
        SUT.setClient(clientStub);
        Result result = SUT.getFileDetail("fileId");
        assertNotNull( result.getMessage());
    }

    @Test
    public void getFileMetaData_valid_request_expect_success() {
        String resp="{" +
                "\"height\":68, \"width\":100, \"size\":7749, \"format\":\"jpg\", \"hasColorProfile\":true, \"quality\":0, \"density\":72, \"hasTransparency\":false, \"pHash\":\"f06830ca9f1e3e90\", \"exif\":{" +
                "\"image\":{" +
                "\"Make\":\"Canon\", \"Model\":\"CanonEOS40D\", \"Orientation\":1, \"XResolution\":72, \"YResolution\":72, \"ResolutionUnit\":2, \"Software\":\"GIMP2.4.5\", \"ModifyDate\":\"2008:07:3110:38:11\", \"YCbCrPositioning\":2, \"ExifOffset\":214, \"GPSInfo\":978" +
                "}, \"thumbnail\":{" +
                "\"Compression\":6, \"XResolution\":72, \"YResolution\":72, \"ResolutionUnit\":2, \"ThumbnailOffset\":1090, \"ThumbnailLength\":1378" +
                "}, \"exif\":{" +
                "\"ExposureTime\":0.00625, \"FNumber\":7.1, \"ExposureProgram\":1, \"ISO\":100, \"ExifVersion\":\"0221\", \"DateTimeOriginal\":\"2008:05:3015:56:01\", \"CreateDate\":\"2008:05:3015:56:01\", \"ShutterSpeedValue\":7.375, \"ApertureValue\":5.625, \"ExposureCompensation\":0, \"MeteringMode\":5, \"Flash\":9, \"FocalLength\":135, \"SubSecTime\":\"00\", \"SubSecTimeOriginal\":\"00\", \"SubSecTimeDigitized\":\"00\", \"FlashpixVersion\":\"0100\", \"ColorSpace\":1, \"ExifImageWidth\":100, \"ExifImageHeight\":68, \"InteropOffset\":948, \"FocalPlaneXResolution\":4438.356164383562, \"FocalPlaneYResolution\":4445.969125214408, \"FocalPlaneResolutionUnit\":2, \"CustomRendered\":0, \"ExposureMode\":1, \"WhiteBalance\":0, \"SceneCaptureType\":0" +
                "}, \"gps\":{" +
                "\"GPSVersionID\":[" + "2, 2, 0, 0" + "]" +
                "}, \"interoperability\":{" + "\"InteropIndex\":\"R98\", \"InteropVersion\":\"0100\"" + "}, \"makernote\":{}" + "}" + "}";

        OkHttpClientStub clientStub= new OkHttpClientStub(resp,
                200, "Ok");
        SUT.setClient(clientStub);
        ResultMetaData result = SUT.getFileMetaData("598821f949c0a938d57563bd");
        assertEquals("https://api.imagekit.io/v1/files/598821f949c0a938d57563bd/metadata",SUT.request.url().toString());
        assertThat(resp, is(result.getResponseMetaData().getRaw()));
    }

    @Test
    public void getFileMetaData_internal_server_error() {
        JsonObject obj=new JsonObject();

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                500, "Internal Server Error");
        SUT.setClient(clientStub);
        ResultMetaData result = SUT.getFileMetaData("fileId");
        assertNotNull( result.getMessage());
    }

    @Test
    public void getFileMetaData_un_processable_entity() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","Un-processable Entity.");

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                433, "Un-processable Entity");
        SUT.setClient(clientStub);
        ResultMetaData result = SUT.getFileMetaData("fileId");
        assertNotNull( result.getMessage());
    }

    @Test
    public void getRemoteFileMetaData_valid_request_expect_success() {
        String resp="{" +
                "\"height\":68, \"width\":100, \"size\":7749, \"format\":\"jpg\", \"hasColorProfile\":true, \"quality\":0, \"density\":72, \"hasTransparency\":false, \"pHash\":\"f06830ca9f1e3e90\", \"exif\":{" +
                "\"image\":{" +
                "\"Make\":\"Canon\", \"Model\":\"CanonEOS40D\", \"Orientation\":1, \"XResolution\":72, \"YResolution\":72, \"ResolutionUnit\":2, \"Software\":\"GIMP2.4.5\", \"ModifyDate\":\"2008:07:3110:38:11\", \"YCbCrPositioning\":2, \"ExifOffset\":214, \"GPSInfo\":978" +
                "}, \"thumbnail\":{" +
                "\"Compression\":6, \"XResolution\":72, \"YResolution\":72, \"ResolutionUnit\":2, \"ThumbnailOffset\":1090, \"ThumbnailLength\":1378" +
                "}, \"exif\":{" +
                "\"ExposureTime\":0.00625, \"FNumber\":7.1, \"ExposureProgram\":1, \"ISO\":100, \"ExifVersion\":\"0221\", \"DateTimeOriginal\":\"2008:05:3015:56:01\", \"CreateDate\":\"2008:05:3015:56:01\", \"ShutterSpeedValue\":7.375, \"ApertureValue\":5.625, \"ExposureCompensation\":0, \"MeteringMode\":5, \"Flash\":9, \"FocalLength\":135, \"SubSecTime\":\"00\", \"SubSecTimeOriginal\":\"00\", \"SubSecTimeDigitized\":\"00\", \"FlashpixVersion\":\"0100\", \"ColorSpace\":1, \"ExifImageWidth\":100, \"ExifImageHeight\":68, \"InteropOffset\":948, \"FocalPlaneXResolution\":4438.356164383562, \"FocalPlaneYResolution\":4445.969125214408, \"FocalPlaneResolutionUnit\":2, \"CustomRendered\":0, \"ExposureMode\":1, \"WhiteBalance\":0, \"SceneCaptureType\":0" +
                "}, \"gps\":{" +
                "\"GPSVersionID\":[" + "2, 2, 0, 0" + "]" +
                "}, \"interoperability\":{" + "\"InteropIndex\":\"R98\", \"InteropVersion\":\"0100\"" + "}, \"makernote\":{}" + "}" + "}";

        OkHttpClientStub clientStub= new OkHttpClientStub(resp,
                200, "Ok");
        SUT.setClient(clientStub);
        ResultMetaData result = SUT.getRemoteFileMetaData("http://remote_url.example.com/demo.png");

        assertEquals("https://api.imagekit.io/v1/metadata?url=http://remote_url.example.com/demo.png",SUT.request.url().toString());
        assertThat(resp, is(result.getResponseMetaData().getRaw()));
    }

    @Test
    public void getRemoteFileMetaData_internal_server_error() {
        JsonObject obj=new JsonObject();

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                500, "Internal Server Error");
        SUT.setClient(clientStub);
        ResultMetaData result = SUT.getRemoteFileMetaData("remote_url");
        assertNotNull( result.getMessage());
    }

    @Test
    public void getRemoteFileMetaData_un_processable_entity() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","Un-processable Entity.");

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                433, "Un-processable Entity");
        SUT.setClient(clientStub);
        ResultMetaData result = SUT.getRemoteFileMetaData("remote_url");
        assertNotNull( result.getMessage());
    }

    @Test
    public void deleteFile_valid_request_expect_success() {
        JsonObject obj=new JsonObject();

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                204, "Ok");
        SUT.setClient(clientStub);
        Result result = SUT.deleteFile("598821f949c0a938d57563bd");

        assertEquals("https://api.imagekit.io/v1/files/598821f949c0a938d57563bd",SUT.request.url().toString());
        assertThat("File deleted successfully!", is(result.getMessage()));
    }

    @Test
    public void deleteFile_internal_server_error() {
        JsonObject obj=new JsonObject();

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                500, "Internal Server Error");
        SUT.setClient(clientStub);
        Result result = SUT.deleteFile("fileId");
        assertThat("Error: Internal server error.", is(result.getMessage()));
    }

    @Test
    public void deleteFile_un_processable_entity() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","Un-processable Entity.");

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                433, "Un-processable Entity");
        SUT.setClient(clientStub);
        Result result = SUT.deleteFile("fileId");
        assertNotNull( result.getMessage());
    }

    @Test
    public void bulkDeleteFiles_valid_request_expect_success() {
        String resp="{\n" +
                "    \"successfullyDeletedFileIds\": [\n" +
                "        \"5e1c13d0c55ec3437c451406\",\n" +
                "        \"561c13d0c533c3437x434409\",\n" +
                "        \"561c13d0c533c3437x434411\",\n" +
                "    ]\n" +
                "}";
        List<String> fileIds = new ArrayList<>();
        fileIds.add("5e1c13d0c55ec3437c451406");
        fileIds.add("561c13d0c533c3437x434409");
        fileIds.add("561c13d0c533c3437x434411");
        OkHttpClientStub clientStub= new OkHttpClientStub(resp,
                200, "Ok");
        SUT.setClient(clientStub);
        ResultFileDelete result = SUT.bulkDeleteFiles(fileIds);
        assertThat("File deleted successfully!", is(result.getMessage()));
        assertThat(resp,is(result.getResponseMetaData().getRaw()));
    }

    @Test
    public void bulkDeleteFiles_file_id_not_found() {
        String resp="{\n" +
                "    \"message\": \"The requested file(s) does not exist.\",\n" +
                "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n" +
                "    \"missingFileIds\": [\n" +
                "        \"5e1c13d0c55ec3437c451406\",\n" +
                "        \"561c13d0c533c3437x434409\",\n" +
                "        \"561c13d0c533c3437x434411\"\n" +
                "    ]" +
                "}";
        List<String> fileIds = new ArrayList<>();
        fileIds.add("5e1c13d0c55ec3437c451406");
        fileIds.add("561c13d0c533c3437x434409");
        fileIds.add("561c13d0c533c3437x434411");
        OkHttpClientStub clientStub= new OkHttpClientStub(resp,
                404, "Not found");
        SUT.setClient(clientStub);
        ResultFileDelete result = SUT.bulkDeleteFiles(fileIds);
        assertThat("The requested file(s) does not exist.", is(result.getMessage()));
        assertThat(resp,is(result.getResponseMetaData().getRaw()));
    }

    @Test
    public void bulkDeleteFiles_internal_server_error() {
        JsonObject obj=new JsonObject();
        List<String> fileIds = new ArrayList<>();
        fileIds.add("file_id_1");
        fileIds.add("file_id_2");
        fileIds.add("file_id_3");
        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                500, "Ok");
        SUT.setClient(clientStub);
        ResultFileDelete result = SUT.bulkDeleteFiles(fileIds);
        assertThat("Error: Internal server error.", is(result.getMessage()));
    }

    @Test
    public void purgeCache_valid_request_expect_success() {
        JsonObject obj=new JsonObject();
        obj.addProperty("requestId","my_request_id");
        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                200, "Ok");
        SUT.setClient(clientStub);
        ResultCache result = SUT.purgeCache("https://ik.imagekit.io/your_imagekit_id/default-image.jpg");
        assertThat("my_request_id", is(result.getRequestId()));
    }

    @Test
    public void purgeCache_internal_server_error() {
        JsonObject obj=new JsonObject();

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                500, "Internal Server Error");
        SUT.setClient(clientStub);
        ResultCache result = SUT.purgeCache("https://ik.imagekit.io/your_imagekit_id/default-image.jpg");
        assertThat("Error: Internal server error.", is(result.getMessage()));
    }

    @Test
    public void purgeCache_un_processable_entity() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","Un-processable Entity.");

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                433, "Un-processable Entity");
        SUT.setClient(clientStub);
        ResultCache result = SUT.purgeCache("https://ik.imagekit.io/your_imagekit_id/default-image.jpg");
        assertNotNull( result.getMessage());
    }

    @Test
    public void getPurgeCacheStatus_valid_request_expect_success() {
        JsonObject obj=new JsonObject();
        obj.addProperty("status","Complete");
        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                200, "Ok");
        SUT.setClient(clientStub);
        ResultCacheStatus result = SUT.getPurgeCacheStatus("requestId");

        assertEquals("https://api.imagekit.io/v1/files/purge/requestId",SUT.request.url().toString());
        assertThat("Complete", is(result.getStatus()));
    }

    @Test
    public void getPurgeCacheStatus_internal_server_error() {
        JsonObject obj=new JsonObject();

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                500, "Internal Server Error");
        SUT.setClient(clientStub);
        ResultCacheStatus result = SUT.getPurgeCacheStatus("requestId");
        assertThat("Error: Internal server error.", is(result.getMessage()));
    }

    @Test
    public void getPurgeCacheStatus_un_processable_entity() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","Un-processable Entity.");

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                433, "Un-processable Entity");
        SUT.setClient(clientStub);
        ResultCacheStatus result = SUT.getPurgeCacheStatus("requestId");
        assertNotNull(result.getMessage());
    }

    @Test
    public void add_tags() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","Tags added SuccessFully");

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),200, "Tags added SuccessFully");
        SUT.setClient(clientStub);
        List<String> fileIds = new ArrayList<>();
        fileIds.add("62958deef33aa80bdadf7533");
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");
        ResultTags result = SUT.manageTags(new TagsRequest(fileIds, tags), "addTags");
        assertNotNull(result.getMessage());
        assertEquals(result.getMessage(), "Tags added SuccessFully");
        assertTrue(result.isSuccessful());
    }

    @Test
    public void remove_tags() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","Tags removed SuccessFully");

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),200, "Tags removed SuccessFully");
        SUT.setClient(clientStub);
        List<String> fileIds = new ArrayList<>();
        fileIds.add("62958deef33aa80bdadf7533");
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        ResultTags result = SUT.manageTags(new TagsRequest(fileIds, tags), "removeTags");
        assertNotNull(result.getMessage());
        assertEquals(result.getMessage(), "Tags removed SuccessFully");
        assertTrue(result.isSuccessful());
    }

    @Test
    public void getCustomMetaDataFields() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","Fetched CustomMetaData SuccessFully");
        obj.addProperty("id", "id");
        obj.addProperty("name", "name");
        obj.addProperty("label", "label");

        JsonArray jsonArray = new JsonArray();
        jsonArray.add(obj);

        OkHttpClientStub clientStub= new OkHttpClientStub(jsonArray.toString(),200, "ok");
        SUT.setClient(clientStub);
        ResultCustomMetaData resultCustomMetaData = SUT.getCustomMetaDataFields();
        assertNotNull(resultCustomMetaData.getMessage());
        assertEquals(resultCustomMetaData.getMessage(), "Fetched CustomMetaData SuccessFully");
        assertTrue(resultCustomMetaData.isSuccessful());
        assertEquals(resultCustomMetaData.getResponseMetaData().getHttpStatusCode(), 200);
    }

    @Test
    public void createCustomMetaDataFields_valid_request_expect_success() {
        JsonObject obj=new JsonObject();
        obj.addProperty("message","CustomMetaData created SuccessFully");

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                201, "ok");
        SUT.setClient(clientStub);

        CustomMetaDataFieldRequest customMetaDataFieldRequest = new CustomMetaDataFieldRequest();
        ResultCustomMetaData resultCustomMetaData = SUT.createCustomMetaDataFields(customMetaDataFieldRequest);

        assertEquals("https://api.imagekit.io/v1/customMetadataFields",SUT.request.url().toString());
        System.out.println("resultCustomMetaData.getMessage():-->" + resultCustomMetaData.getMessage());
        assertEquals("CustomMetaData created SuccessFully", resultCustomMetaData.getMessage());
        assertEquals(resultCustomMetaData.getResponseMetaData().getHttpStatusCode(), 201);
    }

    @Test
    public void deleteCustomMetaDataField_valid_request_expect_success() {
        JsonObject obj=new JsonObject();

        OkHttpClientStub clientStub= new OkHttpClientStub(obj.toString(),
                204, "Ok");
        SUT.setClient(clientStub);
        Result result = SUT.deleteCustomMetaDataField("id");

        assertEquals("https://api.imagekit.io/v1/customMetadataFields/id",SUT.request.url().toString());
        assertThat("CustomMetaDataField deleted successfully!", is(result.getMessage()));
        assertEquals(result.getResponseMetaData().getHttpStatusCode(), 204);
    }

    /**
     * Stub OkHttpClient for fake api call
     */
    private static class OkHttpClientStub extends OkHttpClient{
        private Response.Builder builder;
        private boolean timeout;

        public OkHttpClientStub(String response, int code, String message) {
            this.builder=new Response.Builder();
            builder.code(code)
                    .message(message)
                    .protocol(Protocol.HTTP_1_1)
                    .body(ResponseBody.create(MediaType.parse("application/json"),response));
        }
        @Override
        public Call newCall(Request request) {
            Call call=new Call() {
                @Override
                public Request request() {
                    return request;
                }

                @Override
                public Response execute() throws IOException {
                    String credential=request.headers().get("Authorization");
                    if (credential==null){
                        builder.body(ResponseBody.create(MediaType.parse("application/json"),"{\"message\":\"Your request does not contain private API key.\",\"help\":\"For support kindly contact us at support@imagekit.io .\"}"));
                    }
                    else if (!credential.contains("Basic")){
                        builder.body(ResponseBody.create(MediaType.parse("application/json"),"{\"message\":\"Your request does not contain private API key.\",\"help\":\"For support kindly contact us at support@imagekit.io .\"}"));
                    }

                    builder.request(request);
                    if (timeout) {
                        throw new RuntimeException(new SocketTimeoutException());
                    }
                    return builder.build();
                }

                @Override
                public void enqueue(Callback callback) {

                }

                @Override
                public void cancel() {

                }

                @Override
                public boolean isExecuted() {
                    return false;
                }

                @Override
                public boolean isCanceled() {
                    return false;
                }

                @Override
                public Call clone() {
                    return null;
                }
            };
            return call;
        }
        public void setTimeoutException() {
            this.timeout = true;
        }
    }
}