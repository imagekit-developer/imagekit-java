package io.imagekit.sdk.manage;

import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.ImageKitTest;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.NotFoundException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.DeleteFileVersionRequest;
import io.imagekit.sdk.tasks.RestClient;
import io.imagekit.sdk.utils.Utils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileVersionTest {

    private ImageKit SUT;

    @Before
    public void setUp() throws Exception {
        SUT = ImageKit.getInstance();
        SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
    }

    @Test(expected = NotFoundException.class)
    public void getFileVersions_404_Expected()
            throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
            UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(404)
                .setBody("{\n" + "    \"message\": \"The requested asset does not exist.\",\n"
                        + "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getFileVersions("id");
        server.takeRequest();
    }

    @Test
    public void getFileVersions_successExpected()
            throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
            UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("[\n" + "    {\n" + "        \"type\": \"file\",\n"
                + "        \"name\": \"w2_image.png\",\n" + "        \"createdAt\": \"2022-06-07T12:00:33.825Z\",\n"
                + "        \"updatedAt\": \"2022-06-07T12:00:33.828Z\",\n"
                + "        \"fileId\": \"629f3de17eb0fe4053615450\",\n" + "        \"tags\": [\n"
                + "            \"tag10\"\n" + "        ],\n" + "        \"AITags\": [\n" + "            {\n"
                + "                \"name\": \"Colorfulness\",\n" + "                \"confidence\": 96.19,\n"
                + "                \"source\": \"google-auto-tagging\"\n" + "            },\n" + "            {\n"
                + "                \"name\": \"Purple\",\n" + "                \"confidence\": 86.05,\n"
                + "                \"source\": \"google-auto-tagging\"\n" + "            },\n" + "            {\n"
                + "                \"name\": \"Violet\",\n" + "                \"confidence\": 81.08,\n"
                + "                \"source\": \"google-auto-tagging\"\n" + "            },\n" + "            {\n"
                + "                \"name\": \"Rectangle\",\n" + "                \"confidence\": 80.99,\n"
                + "                \"source\": \"google-auto-tagging\"\n" + "            }\n" + "        ],\n"
                + "        \"versionInfo\": {\n" + "            \"id\": \"629f3de17eb0fe4053615450\",\n"
                + "            \"name\": \"Version 1\"\n" + "        },\n" + "        \"embeddedMetadata\": {\n"
                + "            \"DateCreated\": \"2022-05-26T06:05:18.087Z\",\n" + "            \"ImageWidth\": 1006,\n"
                + "            \"ImageHeight\": 467,\n"
                + "            \"DateTimeCreated\": \"2022-05-26T06:05:18.088Z\"\n" + "        },\n"
                + "        \"customCoordinates\": null,\n" + "        \"customMetadata\": {},\n"
                + "        \"isPrivateFile\": false,\n"
                + "        \"url\": \"https://ik.imagekit.io/xyxt2lnil/w2_image.png\",\n"
                + "        \"thumbnail\": \"https://ik.imagekit.io/xyxt2lnil/tr:n-ik_ml_thumbnail/w2_image.png\",\n"
                + "        \"fileType\": \"image\",\n" + "        \"filePath\": \"/w2_image.png\",\n"
                + "        \"height\": 467,\n" + "        \"width\": 1006,\n" + "        \"size\": 47579,\n"
                + "        \"hasAlpha\": true,\n" + "        \"mime\": \"image/png\"\n" + "    }\n" + "]"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getFileVersions("629f3de17eb0fe4053615450");
        RecordedRequest request = server.takeRequest();

        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("GET /v1/files/629f3de17eb0fe4053615450/versions HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/629f3de17eb0fe4053615450/versions"),
                request.getRequestUrl().toString());
    }

    @Test(expected = NotFoundException.class)
    public void getFileVersionDetails_404_Expected()
            throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
            UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(404)
                .setBody("{\n" + "    \"message\": \"The requested asset does not exist.\",\n"
                        + "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getFileVersionDetails("629f3de17eb0fe4053615450", "629f3de17eb0fe4053615450");
        server.takeRequest();
    }

    @Test
    public void getFileVersionDetails_successExpected()
            throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
            UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\n" + "    \"type\": \"file\",\n"
                + "    \"name\": \"w2_image.png\",\n" + "    \"createdAt\": \"2022-06-07T12:00:33.825Z\",\n"
                + "    \"updatedAt\": \"2022-06-07T12:00:33.828Z\",\n"
                + "    \"fileId\": \"629f3de17eb0fe4053615450\",\n" + "    \"tags\": [\n" + "        \"tag10\"\n"
                + "    ],\n" + "    \"AITags\": [\n" + "        {\n" + "            \"name\": \"Colorfulness\",\n"
                + "            \"confidence\": 96.19,\n" + "            \"source\": \"google-auto-tagging\"\n"
                + "        },\n" + "        {\n" + "            \"name\": \"Purple\",\n"
                + "            \"confidence\": 86.05,\n" + "            \"source\": \"google-auto-tagging\"\n"
                + "        },\n" + "        {\n" + "            \"name\": \"Violet\",\n"
                + "            \"confidence\": 81.08,\n" + "            \"source\": \"google-auto-tagging\"\n"
                + "        },\n" + "        {\n" + "            \"name\": \"Rectangle\",\n"
                + "            \"confidence\": 80.99,\n" + "            \"source\": \"google-auto-tagging\"\n"
                + "        }\n" + "    ],\n" + "    \"versionInfo\": {\n"
                + "        \"id\": \"629f3de17eb0fe4053615450\",\n" + "        \"name\": \"Version 1\"\n" + "    },\n"
                + "    \"embeddedMetadata\": {\n" + "        \"DateCreated\": \"2022-05-26T06:05:18.087Z\",\n"
                + "        \"ImageWidth\": 1006,\n" + "        \"ImageHeight\": 467,\n"
                + "        \"DateTimeCreated\": \"2022-05-26T06:05:18.088Z\"\n" + "    },\n"
                + "    \"customCoordinates\": null,\n" + "    \"customMetadata\": {},\n"
                + "    \"isPrivateFile\": false,\n"
                + "    \"url\": \"https://ik.imagekit.io/xyxt2lnil/w2_image.png\",\n"
                + "    \"thumbnail\": \"https://ik.imagekit.io/xyxt2lnil/tr:n-ik_ml_thumbnail/w2_image.png\",\n"
                + "    \"fileType\": \"image\",\n" + "    \"filePath\": \"/w2_image.png\",\n" + "    \"height\": 467,\n"
                + "    \"width\": 1006,\n" + "    \"size\": 47579,\n" + "    \"hasAlpha\": true,\n"
                + "    \"mime\": \"image/png\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getFileVersionDetails("629f3de17eb0fe4053615450", "629f3de17eb0fe4053615450");
        RecordedRequest request = server.takeRequest();

        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("GET /v1/files/629f3de17eb0fe4053615450/versions/629f3de17eb0fe4053615450 HTTP/1.1",
                request.getRequestLine());
        assertEquals(
                RestClient.API_BASE_URL.concat("v1/files/629f3de17eb0fe4053615450/versions/629f3de17eb0fe4053615450"),
                request.getRequestUrl().toString());
    }

    @Test(expected = BadRequestException.class)
    public void deleteFileVersion_400_SuccessWith()
            throws IOException, InterruptedException, BadRequestException, NotFoundException, InternalServerException,
            UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

        DeleteFileVersionRequest deleteFileVersionRequest = new DeleteFileVersionRequest();
        deleteFileVersionRequest.setFileId("629d90768482ba272ed17628");
        deleteFileVersionRequest.setVersionId("id");

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(400)
                .setBody("{\n" + "    \"message\": \"Your request contains invalid versionId parameter.\",\n"
                        + "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.deleteFileVersion(deleteFileVersionRequest);
        server.takeRequest();
    }

    @Test(expected = NotFoundException.class)
    public void deleteFileVersion_404_SuccessWith()
            throws IOException, InterruptedException, BadRequestException, NotFoundException, InternalServerException,
            UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

        DeleteFileVersionRequest deleteFileVersionRequest = new DeleteFileVersionRequest();
        deleteFileVersionRequest.setFileId("629d90768482ba272ed17628");
        deleteFileVersionRequest.setVersionId("62a9c403d89eedb81721102b");

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(404)
                .setBody("{\n" + "    \"message\": \"The requested file version does not exist.\",\n"
                        + "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.deleteFileVersion(deleteFileVersionRequest);
        server.takeRequest();
    }

    @Test
    public void deleteFileVersion_expectedSuccessWith()
            throws IOException, InterruptedException, BadRequestException, NotFoundException, InternalServerException,
            UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

        DeleteFileVersionRequest deleteFileVersionRequest = new DeleteFileVersionRequest();
        deleteFileVersionRequest.setFileId("629d90768482ba272ed17628");
        deleteFileVersionRequest.setVersionId("629d91878482bae8bed177f2");

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(204).setBody(""));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.deleteFileVersion(deleteFileVersionRequest);
        RecordedRequest request = server.takeRequest();

        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals("", utf8RequestBody);
        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("DELETE /v1/files/629d90768482ba272ed17628/versions/629d91878482bae8bed177f2 HTTP/1.1",
                request.getRequestLine());
        assertEquals(
                RestClient.API_BASE_URL.concat("v1/files/629d90768482ba272ed17628/versions/629d91878482bae8bed177f2"),
                request.getRequestUrl().toString());
    }
}
