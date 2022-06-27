package io.imagekit.sdk.manage;

import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.ImageKitTest;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.NotFoundException;
import io.imagekit.sdk.exceptions.PartialSuccessException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.FileUpdateRequest;
import io.imagekit.sdk.tasks.RestClient;
import io.imagekit.sdk.utils.Utils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FileTest {

    private ImageKit SUT;

    @Before
    public void setUp() throws Exception {
        SUT = ImageKit.getInstance();
        SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
    }

    @Test(expected = UnknownException.class)
    public void imageKit_updateDetails_expected_404()
            throws IOException, InterruptedException, BadRequestException, InternalServerException, UnknownException,
            ForbiddenException, TooManyRequestsException, UnauthorizedException {

        FileUpdateRequest fileUpdateRequest = new FileUpdateRequest("62a9c3ccd875ec6fd658c804");
        MockWebServer server = new MockWebServer();
        String responseJson = "{\n" + "    \"message\": \"The requested file does not exist.\",\n"
                + "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}";
        server.enqueue(new MockResponse().setResponseCode(404).setBody(responseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.updateFileDetail(fileUpdateRequest);
        server.takeRequest();
    }

    @Test(expected = UnknownException.class)
    public void imageKit_updateDetails_expected_400()
            throws IOException, InterruptedException, BadRequestException, InternalServerException, UnknownException,
            ForbiddenException, TooManyRequestsException, UnauthorizedException {

        FileUpdateRequest fileUpdateRequest = new FileUpdateRequest("62a9c3ccd875ec6fd658c804");
        MockWebServer server = new MockWebServer();
        String responseJson = "{\n" + "    \"message\": \"The requested file does not exist.\",\n"
                + "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}";
        server.enqueue(new MockResponse().setResponseCode(404).setBody(responseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.updateFileDetail(fileUpdateRequest);
        server.takeRequest();
    }

    @Test
    public void imageKit_updateDetails_returnTrue()
            throws IOException, InterruptedException, BadRequestException, InternalServerException, UnknownException,
            ForbiddenException, TooManyRequestsException, UnauthorizedException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\n" + "    \"type\": \"file\",\n"
                + "    \"name\": \"new_car.jpg\",\n" + "    \"createdAt\": \"2022-06-15T11:34:36.294Z\",\n"
                + "    \"updatedAt\": \"2022-06-18T12:14:07.070Z\",\n"
                + "    \"fileId\": \"62a9c3ccd875ec6fd658c854\",\n" + "    \"tags\": [\n" + "        \"tagg\",\n"
                + "        \"tagg1\"\n" + "    ],\n" + "    \"AITags\": null,\n" + "    \"versionInfo\": {\n"
                + "        \"id\": \"62a9c3ccd875ec6fd658c854\",\n" + "        \"name\": \"Version 1\"\n" + "    },\n"
                + "    \"embeddedMetadata\": {\n" + "        \"XResolution\": 250,\n"
                + "        \"YResolution\": 250,\n" + "        \"DateCreated\": \"2022-06-15T11:34:36.702Z\",\n"
                + "        \"DateTimeCreated\": \"2022-06-15T11:34:36.702Z\"\n" + "    },\n"
                + "    \"customCoordinates\": \"10,10,20,20\",\n" + "    \"customMetadata\": {\n"
                + "        \"test100\": 10\n" + "    },\n" + "    \"isPrivateFile\": false,\n"
                + "    \"url\": \"https://ik.imagekit.io/zv3rkhsym/new_car.jpg\",\n"
                + "    \"thumbnail\": \"https://ik.imagekit.io/zv3rkhsym/tr:n-ik_ml_thumbnail/new_car.jpg\",\n"
                + "    \"fileType\": \"image\",\n" + "    \"filePath\": \"/new_car.jpg\",\n" + "    \"height\": 354,\n"
                + "    \"width\": 236,\n" + "    \"size\": 23023,\n" + "    \"hasAlpha\": false,\n"
                + "    \"mime\": \"image/jpeg\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        FileUpdateRequest fileUpdateRequest = new FileUpdateRequest("62a9c3ccd875ec6fd658c854");
        List<String> tags = new ArrayList<>();
        tags.add("Software");
        tags.add("Developer");
        tags.add("Engineer");
        fileUpdateRequest.setTags(tags);

        SUT.updateFileDetail(fileUpdateRequest);
        RecordedRequest request = server.takeRequest();

        String requestJson = "{\"fileId\":\"62a9c3ccd875ec6fd658c854\",\"tags\":[\"Software\",\"Developer\",\"Engineer\"]}";
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals(requestJson, utf8RequestBody);
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals("PATCH /v1/files/62a9c3ccd875ec6fd658c854/details HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/62a9c3ccd875ec6fd658c854/details"),
                request.getRequestUrl().toString());
    }

    @Test
    public void imageKit_getFileList_returnList()
            throws InterruptedException, ForbiddenException, TooManyRequestsException, InternalServerException,
            UnauthorizedException, BadRequestException, UnknownException, IOException {

        MockWebServer server = new MockWebServer();
        String responseJson = "[\n" + "    {\n" + "        \"type\": \"file\",\n"
                + "        \"name\": \"default-image.jpg\",\n"
                + "        \"createdAt\": \"2022-06-11T07:26:19.294Z\",\n"
                + "        \"updatedAt\": \"2022-06-11T07:26:19.600Z\",\n"
                + "        \"fileId\": \"62a4439bce686814dfcce65c\",\n" + "        \"tags\": null,\n"
                + "        \"AITags\": null,\n" + "        \"versionInfo\": {\n"
                + "            \"id\": \"62a4439bce686814dfcce65c\",\n" + "            \"name\": \"Version 1\"\n"
                + "        },\n" + "        \"embeddedMetadata\": {\n"
                + "            \"DateCreated\": \"2022-06-11T07:26:19.599Z\",\n"
                + "            \"DateTimeCreated\": \"2022-06-11T07:26:19.600Z\"\n" + "        },\n"
                + "        \"customCoordinates\": null,\n" + "        \"customMetadata\": {},\n"
                + "        \"isPrivateFile\": false,\n"
                + "        \"url\": \"https://ik.imagekit.io/zv3rkhsym/default-image.jpg\",\n"
                + "        \"thumbnail\": \"https://ik.imagekit.io/zv3rkhsym/tr:n-ik_ml_thumbnail/default-image.jpg\",\n"
                + "        \"fileType\": \"image\",\n" + "        \"filePath\": \"/default-image.jpg\",\n"
                + "        \"height\": 1000,\n" + "        \"width\": 1000,\n" + "        \"size\": 147022,\n"
                + "        \"hasAlpha\": false,\n" + "        \"mime\": \"image/jpeg\"\n" + "    }\n" + "]";
        server.enqueue(new MockResponse().setBody(responseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        Map<String, String> options = new HashMap<>();
        options.put("limit", "" + 1);
        SUT.getFileList(options);

        RecordedRequest request = server.takeRequest();
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals("", utf8RequestBody);
        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("GET /v1/files?limit=1 HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files?limit=1"), request.getRequestUrl().toString());

    }

    @Test(expected = BadRequestException.class)
    public void imageKit_getFileDetail__expected_400()
            throws IOException, InterruptedException, BadRequestException, InternalServerException, UnknownException,
            ForbiddenException, TooManyRequestsException, UnauthorizedException {

        MockWebServer server = new MockWebServer();
        String responseJson = "{\n" +
                "    \"message\": \"Your request contains invalid fileId parameter.\",\n" +
                "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" +
                "}";
        server.enqueue(new MockResponse().setResponseCode(400).setBody(responseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getFileDetail("fileId");

        server.takeRequest();
    }

    @Test
    public void imageKit_getFileDetail_successExpected()
            throws IOException, ForbiddenException, TooManyRequestsException, InternalServerException,
            UnauthorizedException, BadRequestException, UnknownException, InterruptedException {
        MockWebServer server = new MockWebServer();
        String responseJson = "{\n" + "    \"type\": \"file\",\n" + "    \"name\": \"sample-image11_g1Qv0wpqP.jpg\",\n"
                + "    \"createdAt\": \"2022-06-20T05:00:41.830Z\",\n"
                + "    \"updatedAt\": \"2022-06-20T05:00:43.263Z\",\n"
                + "    \"fileId\": \"62affef97db937b028f3b47a\",\n" + "    \"tags\": [\n" + "        \"Software\",\n"
                + "        \"Developer\",\n" + "        \"Engineer\"\n" + "    ],\n" + "    \"AITags\": null,\n"
                + "    \"versionInfo\": {\n" + "        \"id\": \"62affef97db937b028f3b47a\",\n"
                + "        \"name\": \"Version 1\"\n" + "    },\n" + "    \"embeddedMetadata\": {},\n"
                + "    \"customCoordinates\": null,\n" + "    \"customMetadata\": {},\n"
                + "    \"isPrivateFile\": false,\n"
                + "    \"url\": \"https://ik.imagekit.io/zv3rkhsym/sample-image11_g1Qv0wpqP.jpg\",\n"
                + "    \"thumbnail\": \"https://ik.imagekit.io/demo/img/static-file-1.png\",\n"
                + "    \"fileType\": \"non-image\",\n" + "    \"filePath\": \"/sample-image11_g1Qv0wpqP.jpg\",\n"
                + "    \"size\": 169170\n" + "}";
        server.enqueue(new MockResponse().setBody(responseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getFileDetail("62affef97db937b028f3b47a");

        RecordedRequest request = server.takeRequest();
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals("", utf8RequestBody);
        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("GET /v1/files/62affef97db937b028f3b47a/details HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/62affef97db937b028f3b47a/details"),
                request.getRequestUrl().toString());
    }

    @Test
    public void imageKit_getFileMetaData_successExpected()
            throws IOException, ForbiddenException, TooManyRequestsException, InternalServerException,
            UnauthorizedException, BadRequestException, UnknownException, InterruptedException {
        MockWebServer server = new MockWebServer();
        String responseJson = "{\n" + "    \"height\": 1000,\n" + "    \"width\": 1000,\n" + "    \"size\": 147022,\n"
                + "    \"format\": \"jpg\",\n" + "    \"hasColorProfile\": false,\n" + "    \"quality\": 0,\n"
                + "    \"density\": 72,\n" + "    \"hasTransparency\": false,\n" + "    \"exif\": {},\n"
                + "    \"pHash\": \"e0d52b612ad538f6\"\n" + "}";
        server.enqueue(new MockResponse().setBody(responseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getRemoteFileMetadata("https://ik.imagekit.io/zv3rkhsym/default-image.jpg");

        RecordedRequest request = server.takeRequest();
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals("", utf8RequestBody);
        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("GET /v1/metadata?url=https://ik.imagekit.io/zv3rkhsym/default-image.jpg HTTP/1.1",
                request.getRequestLine());
        assertEquals(
                RestClient.API_BASE_URL.concat("v1/metadata?url=https://ik.imagekit.io/zv3rkhsym/default-image.jpg"),
                request.getRequestUrl().toString());

    }

    @Test(expected = BadRequestException.class)
    public void imageKit_getRemoteFileMetaData_400_Expected()
            throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException,
            BadRequestException, UnknownException, InterruptedException, IOException {
        MockWebServer server = new MockWebServer();
        String responseJson = "{\n" +
                "    \"message\": \"remote_url should be accessible using your ImageKit.io account.\",\n" +
                "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" +
                "}";
        server.enqueue(new MockResponse().setResponseCode(400).setBody(responseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getRemoteFileMetadata("remote_url");

        server.takeRequest();
    }

    @Test(expected = BadRequestException.class)
    public void imageKit_deleteFile_400_Expected()
            throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException,
            BadRequestException, UnknownException, InterruptedException, IOException {
        MockWebServer server = new MockWebServer();
        String responseJson = "{\n" +
                "    \"message\": \"Your request contains invalid fileId parameter.\",\n" +
                "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" +
                "}";
        server.enqueue(new MockResponse().setResponseCode(400).setBody(responseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.deleteFile("629f3de17eb0fe4053615450");

        server.takeRequest();
    }

    @Test
    public void imageKit_deleteFile_successExpected()
            throws IOException, ForbiddenException, TooManyRequestsException, InternalServerException,
            UnauthorizedException, BadRequestException, UnknownException, InterruptedException {
        MockWebServer server = new MockWebServer();
        String responseJson = "";
        server.enqueue(new MockResponse().setResponseCode(204).setBody(responseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.deleteFile("62affef97db937b028f3b47a");

        RecordedRequest request = server.takeRequest();
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals("", utf8RequestBody);
        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("DELETE /v1/files/62affef97db937b028f3b47a HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/62affef97db937b028f3b47a"),
                request.getRequestUrl().toString());
    }

    @Test(expected = NotFoundException.class)
    public void imageKit_bulkDeleteFiles_404Expected() throws ForbiddenException, TooManyRequestsException,
            InternalServerException, PartialSuccessException, UnauthorizedException, NotFoundException,
            BadRequestException, UnknownException, IOException, InterruptedException {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("file_id_1");
        fileIds.add("file_id_2");
        fileIds.add("file_id_3");
        MockWebServer server = new MockWebServer();
        String responseJson = "{\n" + "    \"message\": \"The requested file(s) does not exist.\",\n"
                + "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
                + "    \"missingFileIds\": [\n" + "        \"62ad9ece7db937e35ef18dda\"\n" + "    ]\n" + "}";
        server.enqueue(new MockResponse().setResponseCode(404).setBody(responseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.bulkDeleteFiles(fileIds);

        server.takeRequest();
    }

    @Test
    public void imageKit_bulkDeleteFiles_successExpected() throws ForbiddenException, TooManyRequestsException,
            InternalServerException, PartialSuccessException, UnauthorizedException, NotFoundException,
            BadRequestException, UnknownException, IOException, InterruptedException {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("62ad9ece7db937e35ef18dda");
        MockWebServer server = new MockWebServer();
        String responseJson = "{\n" + "    \"successfullyDeletedFileIds\": [\n"
                + "        \"62ad9ece7db937e35ef18dda\"\n" + "    ]\n" + "}";
        server.enqueue(new MockResponse().setBody(responseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.bulkDeleteFiles(fileIds);

        RecordedRequest request = server.takeRequest();
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals("{\"fileIds\":[\"62ad9ece7db937e35ef18dda\"]}", utf8RequestBody);
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals("POST /v1/files/batch/deleteByFileIds HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/batch/deleteByFileIds"),
                request.getRequestUrl().toString());
    }
}
