package io.imagekit.sdk.manage;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
import io.imagekit.sdk.models.GetFileListRequest;
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
		server.enqueue(new MockResponse().setBody("{\n" +
				"    \"type\": \"file\",\n" +
				"    \"name\": \"new_car.jpg\",\n" +
				"    \"createdAt\": \"2022-06-15T11:34:36.294Z\",\n" +
				"    \"updatedAt\": \"2022-07-04T10:15:50.067Z\",\n" +
				"    \"fileId\": \"62a9c3ccd875ec6fd658c854\",\n" +
				"    \"tags\": [\n" +
				"        \"Software\",\n" +
				"        \"Developer\",\n" +
				"        \"Engineer\"\n" +
				"    ],\n" +
				"    \"AITags\": [\n" +
				"        {\n" +
				"            \"name\": \"Clothing\",\n" +
				"            \"confidence\": 98.77,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Smile\",\n" +
				"            \"confidence\": 95.31,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Shoe\",\n" +
				"            \"confidence\": 95.2,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Street light\",\n" +
				"            \"confidence\": 91.05,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Person\",\n" +
				"            \"confidence\": 96.5,\n" +
				"            \"source\": \"aws-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Female\",\n" +
				"            \"confidence\": 91.27,\n" +
				"            \"source\": \"aws-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Flyer\",\n" +
				"            \"confidence\": 90.62,\n" +
				"            \"source\": \"aws-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Poster\",\n" +
				"            \"confidence\": 90.62,\n" +
				"            \"source\": \"aws-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Advertisement\",\n" +
				"            \"confidence\": 90.62,\n" +
				"            \"source\": \"aws-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Plant\",\n" +
				"            \"confidence\": 96.51,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Street fashion\",\n" +
				"            \"confidence\": 89.1,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Fashion\",\n" +
				"            \"confidence\": 88.46,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Tree\",\n" +
				"            \"confidence\": 87.62,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Yellow\",\n" +
				"            \"confidence\": 85.76,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Happy\",\n" +
				"            \"confidence\": 84.01,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Grass\",\n" +
				"            \"confidence\": 82.89,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Leisure\",\n" +
				"            \"confidence\": 81.19,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Morning\",\n" +
				"            \"confidence\": 79.09,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Summer\",\n" +
				"            \"confidence\": 78.87,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"People\",\n" +
				"            \"confidence\": 77.9,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Electric blue\",\n" +
				"            \"confidence\": 75.57,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Beauty\",\n" +
				"            \"confidence\": 75.22,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Denim\",\n" +
				"            \"confidence\": 74.91,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Recreation\",\n" +
				"            \"confidence\": 74.33,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"name\": \"Publication\",\n" +
				"            \"confidence\": 74.24,\n" +
				"            \"source\": \"google-auto-tagging\"\n" +
				"        }\n" +
				"    ],\n" +
				"    \"versionInfo\": {\n" +
				"        \"id\": \"62b97749f63122840530fda9\",\n" +
				"        \"name\": \"Version 4\"\n" +
				"    },\n" +
				"    \"embeddedMetadata\": {\n" +
				"        \"DateCreated\": \"2022-07-04T10:15:50.066Z\",\n" +
				"        \"DateTimeCreated\": \"2022-07-04T10:15:50.066Z\"\n" +
				"    },\n" +
				"    \"customCoordinates\": null,\n" +
				"    \"customMetadata\": {\n" +
				"        \"test100\": 10,\n" +
				"        \"test10\": 11\n" +
				"    },\n" +
				"    \"isPrivateFile\": false,\n" +
				"    \"url\": \"https://ik.imagekit.io/zv3rkhsym/new_car.jpg\",\n" +
				"    \"thumbnail\": \"https://ik.imagekit.io/zv3rkhsym/tr:n-ik_ml_thumbnail/new_car.jpg\",\n" +
				"    \"fileType\": \"image\",\n" +
				"    \"filePath\": \"/new_car.jpg\",\n" +
				"    \"height\": 354,\n" +
				"    \"width\": 236,\n" +
				"    \"size\": 7390,\n" +
				"    \"hasAlpha\": false,\n" +
				"    \"mime\": \"image/jpeg\"\n" +
				"}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		List<String> tags = new ArrayList<>();
		tags.add("Software");
		tags.add("Developer");
		tags.add("Engineer");

		List<String> aiTags = new ArrayList<>();
		aiTags.add("Plant");
		FileUpdateRequest fileUpdateRequest = new FileUpdateRequest("62a9c3ccd875ec6fd658c854");
		fileUpdateRequest.setRemoveAITags(aiTags);
		fileUpdateRequest.setWebhookUrl("https://webhook.site/c78d617f-33bc-40d9-9e61-608999721e2e");

		JsonObject optionsInnerObject = new JsonObject();
		optionsInnerObject.addProperty("add_shadow", true);
		optionsInnerObject.addProperty("bg_color", "yellow");
		JsonObject innerObject1 = new JsonObject();
		innerObject1.addProperty("name", "remove-bg");
		innerObject1.add("options", optionsInnerObject);
		JsonObject innerObject2 = new JsonObject();
		innerObject2.addProperty("name", "google-auto-tagging");
		innerObject2.addProperty("minConfidence", 15);
		innerObject2.addProperty("maxTags", 20);
		JsonArray jsonArray = new JsonArray();
		jsonArray.add(innerObject1);
		jsonArray.add(innerObject2);

		fileUpdateRequest.setExtensions(jsonArray);
		fileUpdateRequest.setTags(tags);
		fileUpdateRequest.setCustomCoordinates("10,10,40,40");
		JsonObject jsonObjectCustomMetadata = new JsonObject();
		jsonObjectCustomMetadata.addProperty("test10", 11);
		fileUpdateRequest.setCustomMetadata(jsonObjectCustomMetadata);

		SUT.updateFileDetail(fileUpdateRequest);
		RecordedRequest request = server.takeRequest();

		String requestJson = "{\"fileId\":\"62a9c3ccd875ec6fd658c854\",\"removeAITags\":[\"Plant\"],\"webhookUrl\":\"https://webhook.site/c78d617f-33bc-40d9-9e61-608999721e2e\",\"extensions\":[{\"name\":\"remove-bg\",\"options\":{\"add_shadow\":true,\"bg_color\":\"yellow\"}},{\"name\":\"google-auto-tagging\",\"minConfidence\":15,\"maxTags\":20}],\"tags\":[\"Software\",\"Developer\",\"Engineer\"],\"customCoordinates\":\"10,10,40,40\",\"customMetadata\":{\"test10\":11}}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(requestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("PATCH /v1/files/62a9c3ccd875ec6fd658c854/details HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/files/62a9c3ccd875ec6fd658c854/details"),
				request.getRequestUrl().toString());
	}

	@Test
	public void imageKit_getFileList_returnList()
			throws InterruptedException, IOException, ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException, BadRequestException, UnknownException, IllegalAccessException, InstantiationException {

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
		String[] tags = new String[3];
		tags[0] = "Software";
		tags[1] = "Developer";
		tags[2] = "Engineer";
		GetFileListRequest getFileListRequest = new GetFileListRequest();
		getFileListRequest.setType("file");
		getFileListRequest.setSort("ASC_CREATED");
		getFileListRequest.setPath("/");
		getFileListRequest.setSearchQuery("createdAt >= '2d' OR size < '2mb' OR format='png'");
		getFileListRequest.setFileType("all");
		getFileListRequest.setLimit("1");
		getFileListRequest.setSkip("0");
		getFileListRequest.setTags(tags);
		SUT.getFileList(getFileListRequest);

		RecordedRequest request = server.takeRequest();
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals("", utf8RequestBody);
		assertEquals("application/json", request.getHeader("Content-Type"));
		assertEquals(
				"GET /v1/files?path=/&searchQuery=createdAt%20%3E=%20%272d%27%20OR%20size%20%3C%20%272mb%27%20OR%20format=%27png%27&limit=1&skip=0&sort=ASC_CREATED&type=file&fileType=all&tags=[Software,%20Developer,%20Engineer] HTTP/1.1",
				request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat(
				"v1/files?path=/&searchQuery=createdAt%20%3E=%20%272d%27%20OR%20size%20%3C%20%272mb%27%20OR%20format=%27png%27&limit=1&skip=0&sort=ASC_CREATED&type=file&fileType=all&tags=[Software,%20Developer,%20Engineer]"),
				request.getRequestUrl().toString());

	}

	@Test(expected = BadRequestException.class)
	public void imageKit_getFileList_400_expected()
			throws InterruptedException, ForbiddenException, TooManyRequestsException, InternalServerException,
			UnauthorizedException, BadRequestException, UnknownException, IOException, IllegalAccessException, InstantiationException {

		MockWebServer server = new MockWebServer();
		String responseJson = "{\n"
				+ "    \"message\": \"Invalid search query - createdAt field must have a valid date value. Make sure the value is enclosed within quotes. Please refer to the documentation for syntax specification.\",\n"
				+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}";
		server.enqueue(new MockResponse().setResponseCode(400).setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		String[] tags = new String[3];
		tags[0] = "Software";
		tags[1] = "Developer";
		tags[2] = "Engineer";
		GetFileListRequest getFileListRequest = new GetFileListRequest();
		getFileListRequest.setType("file");
		getFileListRequest.setSort("ASC_CREATED");
		getFileListRequest.setPath("/");
		getFileListRequest.setSearchQuery("createdAt >= '2d' OR size < '2mb' OR format='png'");
		getFileListRequest.setFileType("all");
		getFileListRequest.setLimit("1");
		getFileListRequest.setSkip("0");
		getFileListRequest.setTags(tags);
		SUT.getFileList(getFileListRequest);

		server.takeRequest();
	}

	@Test(expected = BadRequestException.class)
	public void imageKit_getFileDetail__expected_400()
			throws IOException, InterruptedException, BadRequestException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {

		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"message\": \"Your request contains invalid fileId parameter.\",\n"
				+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}";
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
		String responseJson = "{\n" + "    \"height\": 300,\n" + "    \"width\": 300,\n" + "    \"size\": 51085,\n"
				+ "    \"format\": \"jpg\",\n" + "    \"hasColorProfile\": false,\n" + "    \"quality\": 0,\n"
				+ "    \"density\": 300,\n" + "    \"hasTransparency\": false,\n" + "    \"exif\": {\n"
				+ "        \"image\": {\n" + "            \"Orientation\": 1,\n" + "            \"XResolution\": 300,\n"
				+ "            \"YResolution\": 300,\n" + "            \"ResolutionUnit\": 2,\n"
				+ "            \"Software\": \"Adobe Photoshop CS5 (12.0x20100115 [20100115.m.998 2010/01/15:02:00:00 cutoff; m branch])  Windows\",\n"
				+ "            \"ModifyDate\": \"2017:09:11 22:15:46\",\n" + "            \"ExifOffset\": 236\n"
				+ "        },\n" + "        \"thumbnail\": {\n" + "            \"Compression\": 6,\n"
				+ "            \"XResolution\": 72,\n" + "            \"YResolution\": 72,\n"
				+ "            \"ResolutionUnit\": 2,\n" + "            \"ThumbnailOffset\": 374,\n"
				+ "            \"ThumbnailLength\": 4083\n" + "        },\n" + "        \"exif\": {\n"
				+ "            \"ColorSpace\": 65535,\n" + "            \"ExifImageWidth\": 300,\n"
				+ "            \"ExifImageHeight\": 300\n" + "        },\n" + "        \"gps\": {},\n"
				+ "        \"interoperability\": {},\n" + "        \"makernote\": {}\n" + "    },\n"
				+ "    \"pHash\": \"2df5da2dd63c6926\"\n" + "}";
		server.enqueue(new MockResponse().setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.getFileMetadata("62b43109d23153217b8b8a36");

		RecordedRequest request = server.takeRequest();
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals("", utf8RequestBody);
		assertEquals("application/json", request.getHeader("Content-Type"));
		assertEquals("GET /v1/files/62b43109d23153217b8b8a36/metadata HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/files/62b43109d23153217b8b8a36/metadata"),
				request.getRequestUrl().toString());

	}

	@Test(expected = BadRequestException.class)
	public void imageKit_getFileMetaData_400_Expected()
			throws IOException, ForbiddenException, TooManyRequestsException, InternalServerException,
			UnauthorizedException, BadRequestException, UnknownException, InterruptedException {
		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"message\": \"Your request contains invalid fileId parameter.\",\n"
				+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
				+ "    \"type\": \"INVALID_PARAM_ERROR\"\n" + "}";
		server.enqueue(new MockResponse().setResponseCode(400).setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.getFileMetadata("fileId");
		server.takeRequest();
	}

	@Test
	public void imageKit_getRemoteFileMetaData_successExpected()
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
		String responseJson = "{\n"
				+ "    \"message\": \"remote_url should be accessible using your ImageKit.io account.\",\n"
				+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}";
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
		String responseJson = "{\n" + "    \"message\": \"Your request contains invalid fileId parameter.\",\n"
				+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}";
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
