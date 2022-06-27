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
import io.imagekit.sdk.models.AITagsRequest;
import io.imagekit.sdk.models.TagsRequest;
import io.imagekit.sdk.tasks.RestClient;
import io.imagekit.sdk.utils.Utils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TagsTest {

    private ImageKit SUT;

    @Before
    public void setUp() throws Exception {
        SUT = ImageKit.getInstance();
        SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
    }

    @Test(expected = NotFoundException.class)
    public void add_tags_expected_404() throws IOException, InterruptedException, NotFoundException,
            PartialSuccessException, BadRequestException, InternalServerException, UnknownException, ForbiddenException,
            TooManyRequestsException, UnauthorizedException {

        List<String> fileIds = new ArrayList<>();
        fileIds.add("629f3de17eb0fe4053615450");
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");

        TagsRequest tagsRequest = new TagsRequest(fileIds, tags);

        MockWebServer server = new MockWebServer();
        String tagsResponseJson = "{\n" + "    \"message\": \"The requested file(s) does not exist.\",\n"
                + "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
                + "    \"missingFileIds\": [\n" + "        \"629f3de17eb0fe4053615450\"\n" + "    ]\n" + "}";
        server.enqueue(new MockResponse().setResponseCode(404).setBody(tagsResponseJson));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.addTags(tagsRequest);

        server.takeRequest();
    }

    @Test
    public void add_tags_expectedSuccessWith() throws IOException, InterruptedException, NotFoundException,
            PartialSuccessException, BadRequestException, InternalServerException, UnknownException, ForbiddenException,
            TooManyRequestsException, UnauthorizedException {

        List<String> fileIds = new ArrayList<>();
        fileIds.add("62958deef33aa80bdadf7533");
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");

        TagsRequest tagsRequest = new TagsRequest(fileIds, tags);

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\"successfullyUpdatedFileIds\": [\"62958deef33aa80bdadf7533\"]}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.addTags(tagsRequest);
        RecordedRequest request = server.takeRequest();

        String tagsRequestJson = "{\"fileIds\":[\"62958deef33aa80bdadf7533\"],\"tags\":[\"tag1\",\"tag2\"]}";
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals(tagsRequestJson, utf8RequestBody);
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals("POST /v1/files/addTags HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/addTags"), request.getRequestUrl().toString());
    }

    @Test(expected = NotFoundException.class)
    public void remove_tags_expected_404_bad_request() throws InterruptedException, NotFoundException,
            PartialSuccessException, BadRequestException, InternalServerException, UnknownException, ForbiddenException,
            TooManyRequestsException, UnauthorizedException {

        List<String> fileIds = new ArrayList<>();
        fileIds.add("629f3de17eb0fe4053615450");
        List<String> tags = new ArrayList<>();
        tags.add("tag1");

        TagsRequest tagsRequest = new TagsRequest(fileIds, tags);

        MockWebServer server = new MockWebServer();
        String tagsResponseJson = "{\n" + "    \"message\": \"The requested file(s) does not exist.\",\n"
                + "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
                + "    \"missingFileIds\": [\n" + "        \"629f3de17eb0fe4053615450\"\n" + "    ]\n" + "}";
        server.enqueue(new MockResponse().setResponseCode(404).setBody(tagsResponseJson));
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.removeTags(tagsRequest);
        server.takeRequest();
    }

    @Test
    public void remove_tags_expectedSuccessWith() throws IOException, InterruptedException, NotFoundException,
            PartialSuccessException, BadRequestException, InternalServerException, UnknownException, ForbiddenException,
            TooManyRequestsException, UnauthorizedException {

        List<String> fileIds = new ArrayList<>();
        fileIds.add("62958deef33aa80bdadf7533");
        List<String> tags = new ArrayList<>();
        tags.add("tag1");

        TagsRequest tagsRequest = new TagsRequest(fileIds, tags);

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\"successfullyUpdatedFileIds\": [\"62958deef33aa80bdadf7533\"]}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.removeTags(tagsRequest);
        RecordedRequest request = server.takeRequest();

        String tagsRequestJson = "{\"fileIds\":[\"62958deef33aa80bdadf7533\"],\"tags\":[\"tag1\"]}";
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals(tagsRequestJson, utf8RequestBody);
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals("POST /v1/files/removeTags HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/removeTags"), request.getRequestUrl().toString());
    }

    @Test(expected = NotFoundException.class)
    public void removeAITags_404_Expected() throws InterruptedException, IOException, PartialSuccessException,
            NotFoundException, BadRequestException, InternalServerException, UnknownException, ForbiddenException,
            TooManyRequestsException, UnauthorizedException {

        List<String> fileIds = new ArrayList<>();
        fileIds.add("629f3de17eb0fe4053615450");
        List<String> aiTags = new ArrayList<>();
        aiTags.add("Font");

        AITagsRequest aiTagsRequest = new AITagsRequest();
        aiTagsRequest.setFileIds(fileIds);
        aiTagsRequest.setAITags(aiTags);

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(404)
                .setBody("{\n" + "    \"message\": \"The requested file(s) does not exist.\",\n"
                        + "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
                        + "    \"missingFileIds\": [\n" + "        \"629f3de17eb0fe4053615450\"\n" + "    ]\n" + "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.removeAITags(aiTagsRequest);
        server.takeRequest();
    }

    @Test
    public void removeAITags_successExpected() throws InterruptedException, IOException, PartialSuccessException,
            NotFoundException, BadRequestException, InternalServerException, UnknownException, ForbiddenException,
            TooManyRequestsException, UnauthorizedException {

        List<String> fileIds = new ArrayList<>();
        fileIds.add("62958deef33aa80bdadf7533");
        List<String> aiTags = new ArrayList<>();
        aiTags.add("Font");

        AITagsRequest aiTagsRequest = new AITagsRequest();
        aiTagsRequest.setFileIds(fileIds);
        aiTagsRequest.setAITags(aiTags);

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\"successfullyUpdatedFileIds\": [\"62958deef33aa80bdadf7533\"]}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.removeAITags(aiTagsRequest);
        RecordedRequest request = server.takeRequest();

        String aiTagsRequestJson = "{\"fileIds\":[\"62958deef33aa80bdadf7533\"],\"AITags\":[\"Font\"]}";
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals(aiTagsRequestJson, utf8RequestBody);
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals("POST /v1/files/removeAITags HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/removeAITags"), request.getRequestUrl().toString());
    }
}
