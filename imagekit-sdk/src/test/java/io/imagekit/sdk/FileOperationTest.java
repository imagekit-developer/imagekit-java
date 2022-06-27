package io.imagekit.sdk;

import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ConflictException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.NotFoundException;
import io.imagekit.sdk.exceptions.PartialSuccessException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.CopyFileRequest;
import io.imagekit.sdk.models.MoveFileRequest;
import io.imagekit.sdk.models.RenameFileRequest;
import io.imagekit.sdk.tasks.RestClient;
import io.imagekit.sdk.utils.Utils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileOperationTest {
    private ImageKit SUT;

    @Before
    public void setUp() throws Exception {
        SUT = ImageKit.getInstance();
        SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
    }

    @Test(expected = NotFoundException.class)
    public void copyFile_404_Expected()
            throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
            UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

        CopyFileRequest copyFileRequest = new CopyFileRequest();
        copyFileRequest.setSourceFilePath("/sample_image.jpg");
        copyFileRequest.setDestinationPath("/Gallery/");
        copyFileRequest.setIncludeVersions(true);

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(404)
                .setBody("{\n" + "    \"message\": \"No file found with filePath /sample_image.jpg\",\n"
                        + "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
                        + "    \"reason\": \"SOURCE_FILE_MISSING\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.copyFile(copyFileRequest);
        server.takeRequest();
    }

    @Test
    public void copyFile_successExpected()
            throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
            UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

        CopyFileRequest copyFileRequest = new CopyFileRequest();
        copyFileRequest.setSourceFilePath("/car_false.jpeg");
        copyFileRequest.setDestinationPath("/Gallery/");
        copyFileRequest.setIncludeVersions(true);

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(204).setBody(""));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.copyFile(copyFileRequest);
        RecordedRequest request = server.takeRequest();

        String copyFileRequestJson = "{\"sourceFilePath\":\"/car_false.jpeg\",\"destinationPath\":\"/Gallery/\",\"includeVersions\":true}";
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals(copyFileRequestJson, utf8RequestBody);
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals("POST /v1/files/copy HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/copy"), request.getRequestUrl().toString());
    }

    @Test(expected = NotFoundException.class)
    public void moveFile_404_Expected()
            throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
            UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

        MoveFileRequest moveFileRequest = new MoveFileRequest();
        moveFileRequest.setSourceFilePath("/demo1/sample_image_th.jpg");
        moveFileRequest.setDestinationPath("/");

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(404)
                .setBody("{\n" + "    \"message\": \"No file found with filePath /demo1/sample_image_th.jpg\",\n"
                        + "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
                        + "    \"reason\": \"SOURCE_FILE_MISSING\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.moveFile(moveFileRequest);
        server.takeRequest();
    }

    @Test
    public void moveFile_successExpected()
            throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
            UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

        MoveFileRequest moveFileRequest = new MoveFileRequest();
        moveFileRequest.setSourceFilePath("/new_la.jpg");
        moveFileRequest.setDestinationPath("test");

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(204).setBody(""));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.moveFile(moveFileRequest);
        RecordedRequest request = server.takeRequest();

        String moveFileRequestJson = "{\"sourceFilePath\":\"/new_la.jpg\",\"destinationPath\":\"test\"}";
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals(moveFileRequestJson, utf8RequestBody);
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals("POST /v1/files/move HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/move"), request.getRequestUrl().toString());
    }

    @Test(expected = NotFoundException.class)
    public void renameFile_404_Expected() throws InterruptedException, IOException, ConflictException,
            PartialSuccessException, NotFoundException, BadRequestException, InternalServerException, UnknownException,
            ForbiddenException, TooManyRequestsException, UnauthorizedException {

        RenameFileRequest renameFileRequest = new RenameFileRequest();
        renameFileRequest.setFilePath("/sample_image_th.jpg");
        renameFileRequest.setNewFileName("new_car.jpg");
        renameFileRequest.setPurgeCache(true);

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(404)
                .setBody("{\n"
                        + "    \"message\": \"No file found in media library with filePath /sample_image_th.jpg\",\n"
                        + "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
                        + "    \"reason\": \"FILE_MISSING\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.renameFile(renameFileRequest);
        server.takeRequest();
    }

    @Test(expected = ConflictException.class)
    public void renameFile_409_Expected() throws InterruptedException, IOException, ConflictException,
            PartialSuccessException, NotFoundException, BadRequestException, InternalServerException, UnknownException,
            ForbiddenException, TooManyRequestsException, UnauthorizedException {

        RenameFileRequest renameFileRequest = new RenameFileRequest();
        renameFileRequest.setFilePath("/new1.jpg");
        renameFileRequest.setNewFileName("new_car.jpg");
        renameFileRequest.setPurgeCache(true);

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(409)
                .setBody("{\n"
                        + "    \"message\": \"File with name new_car.jpg already exists at the same location.\",\n"
                        + "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
                        + "    \"reason\": \"FILE_ALREADY_EXISTS\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.renameFile(renameFileRequest);
        server.takeRequest();
    }

    @Test
    public void renameFile_successExpected() throws InterruptedException, IOException, ConflictException,
            PartialSuccessException, NotFoundException, BadRequestException, InternalServerException, UnknownException,
            ForbiddenException, TooManyRequestsException, UnauthorizedException {

        RenameFileRequest renameFileRequest = new RenameFileRequest();
        renameFileRequest.setFilePath("/car_false.jpeg");
        renameFileRequest.setNewFileName("new_car.jpeg");
        renameFileRequest.setPurgeCache(true);

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.renameFile(renameFileRequest);
        RecordedRequest request = server.takeRequest();

        String renameFileRequestJson = "{\"filePath\":\"/car_false.jpeg\",\"newFileName\":\"new_car.jpeg\",\"purgeCache\":true}";
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals(renameFileRequestJson, utf8RequestBody);
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals("PUT /v1/files/rename HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/rename"), request.getRequestUrl().toString());
    }

    @Test(expected = InternalServerException.class)
    public void getBulkJobStatus_500_Expected()
            throws InterruptedException, IOException, ForbiddenException, TooManyRequestsException,
            InternalServerException, UnauthorizedException, BadRequestException, UnknownException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(500).setBody(
                "{\n" + "    \"message\": \"We have experienced an internal error while processing your request.\",\n"
                        + "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getBulkJobStatus("jobId");
        server.takeRequest();
    }

    @Test
    public void getBulkJobStatus_successExpected()
            throws InterruptedException, IOException, ForbiddenException, TooManyRequestsException,
            InternalServerException, UnauthorizedException, BadRequestException, UnknownException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\n" + "    \"jobId\": \"629f44ac7eb0fe8173622d4b\",\n"
                + "    \"type\": \"MOVE_FOLDER\",\n" + "    \"status\": \"Completed\"\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getBulkJobStatus("629f44ac7eb0fe8173622d4b");
        RecordedRequest request = server.takeRequest();

        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("GET /v1/bulkJobs/629f44ac7eb0fe8173622d4b HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/bulkJobs/629f44ac7eb0fe8173622d4b"),
                request.getRequestUrl().toString());
    }
}
