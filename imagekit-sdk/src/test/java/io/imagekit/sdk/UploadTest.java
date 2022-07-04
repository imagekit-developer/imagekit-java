package io.imagekit.sdk;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.tasks.RestClient;
import io.imagekit.sdk.utils.Utils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UploadTest {
	private ImageKit SUT;

	@Before
	public void setUp() throws Exception {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
	}

	@Test(expected = UnknownHostException.class)
	public void imageKit_upload_expect_UnknownHostException() throws IOException {
		String imageUrl = "https://homepagesabc.cae.wisc.edu/~ece533/images/12.png";
		URL url = new URL(imageUrl);
		HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
		urlConnect.getContent();
	}

	@Test(expected = RuntimeException.class)
	public void imageKit_upload_expected_RuntimeException_for_file()
			throws IOException, InterruptedException, InternalServerException, BadRequestException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {
		FileCreateRequest fileCreateRequest = new FileCreateRequest((String) null, "sample-cat-image.png");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("java.lang.RuntimeException: Error: File not provided."));
		server.start();
		RestClient.UPLOAD_BASE_URL = server.url("/").toString();
		SUT.upload(fileCreateRequest);
		RecordedRequest request = server.takeRequest();
	}

	@Test
	public void imageKit_upload_returnSuccess() throws IOException, InterruptedException, InternalServerException,
			BadRequestException, UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {
		String imageUrl = "https://homepages.cae.wisc.edu/~ece533/images/cat.png";
		URL url = new URL(imageUrl);
		FileCreateRequest fileCreateRequest = new FileCreateRequest(url, "sample-cat-image.png");
		List<String> tags = new ArrayList<>();
		tags.add("Software");
		tags.add("Developer");
		tags.add("Engineer");
		fileCreateRequest.setTags(tags);
		fileCreateRequest.setFolder("demo1");
		String customCoordinates = "10,10,20,20";
		fileCreateRequest.setCustomCoordinates(customCoordinates);

		List<String> responseFields = new ArrayList<>();
		responseFields.add("thumbnail");
		responseFields.add("tags");
		responseFields.add("customCoordinates");

		fileCreateRequest.setResponseFields(responseFields);
		JsonObject optionsInnerObject = new JsonObject();
		optionsInnerObject.addProperty("add_shadow", true);
		JsonObject innerObject1 = new JsonObject();
		innerObject1.addProperty("name", "remove-bg");
		innerObject1.add("options", optionsInnerObject);
		JsonObject innerObject2 = new JsonObject();
		innerObject2.addProperty("name", "google-auto-tagging");
		innerObject2.addProperty("minConfidence", 10);
		innerObject2.addProperty("maxTags", 5);
		JsonArray jsonArray = new JsonArray();
		jsonArray.add(innerObject1);
		jsonArray.add(innerObject2);
		fileCreateRequest.setExtensions(jsonArray);
		fileCreateRequest.setWebhookUrl("https://webhook.site/c78d617f-33bc-40d9-9e61-608999721e2e");
		fileCreateRequest.setOverwriteFile(true);
		fileCreateRequest.setUseUniqueFileName(false);
		fileCreateRequest.setPrivateFile(false);
		fileCreateRequest.setOverwriteAITags(false);
		fileCreateRequest.setOverwriteTags(false);
		fileCreateRequest.setOverwriteCustomMetadata(true);
		JsonObject jsonObjectCustomMetadata = new JsonObject();
		jsonObjectCustomMetadata.addProperty("test1", 10);
		fileCreateRequest.setCustomMetadata(jsonObjectCustomMetadata);

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\r\n" + "    \"fileId\": \"62a465d245a84a0ef3852968\",\r\n"
				+ "    \"name\": \"sample-cat-image_GG0_X8GOn.jpg\",\r\n" + "    \"size\": 23023,\r\n"
				+ "    \"versionInfo\": {\r\n" + "        \"id\": \"62a465d245a84a0ef3852968\",\r\n"
				+ "        \"name\": \"Version 1\"\r\n" + "    },\r\n"
				+ "    \"filePath\": \"/demo1/sample-cat-image_GG0_X8GOn.jpg\",\r\n"
				+ "    \"url\": \"https://ik.imagekit.io/zv3rkhsym/demo1/sample-cat-image_GG0_X8GOn.jpg\",\r\n"
				+ "    \"fileType\": \"image\",\r\n" + "    \"height\": 354,\r\n" + "    \"width\": 236,\r\n"
				+ "    \"thumbnailUrl\": \"https://ik.imagekit.io/zv3rkhsym/tr:n-ik_ml_thumbnail/demo1/sample-cat-image_GG0_X8GOn.jpg\",\r\n"
				+ "    \"AITags\": [\r\n" + "        {\r\n" + "            \"name\": \"Clothing\",\r\n"
				+ "            \"confidence\": 98.77,\r\n" + "            \"source\": \"google-auto-tagging\"\r\n"
				+ "        },\r\n" + "        {\r\n" + "            \"name\": \"Plant\",\r\n"
				+ "            \"confidence\": 96.51,\r\n" + "            \"source\": \"google-auto-tagging\"\r\n"
				+ "        },\r\n" + "        {\r\n" + "            \"name\": \"Smile\",\r\n"
				+ "            \"confidence\": 95.31,\r\n" + "            \"source\": \"google-auto-tagging\"\r\n"
				+ "        },\r\n" + "        {\r\n" + "            \"name\": \"Shoe\",\r\n"
				+ "            \"confidence\": 95.2,\r\n" + "            \"source\": \"google-auto-tagging\"\r\n"
				+ "        },\r\n" + "        {\r\n" + "            \"name\": \"Street light\",\r\n"
				+ "            \"confidence\": 91.05,\r\n" + "            \"source\": \"google-auto-tagging\"\r\n"
				+ "        }\r\n" + "    ],\r\n" + "    \"extensionStatus\": {\r\n" + "        \"remove-bg\": \"pending\",\r\n"
				+ "        \"google-auto-tagging\": \"success\"\r\n" + "    }\r\n" + "}"));
		server.start();
		RestClient.UPLOAD_BASE_URL = server.url("/").toString();
		SUT.upload(fileCreateRequest);
		RecordedRequest request = server.takeRequest();
		String json = "--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"file\"\r\n" +
				"Content-Length: 53\r\n" +
				"\r\n" +
				"https://homepages.cae.wisc.edu/~ece533/images/cat.png\r\n" +
				"--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"fileName\"\r\n" +
				"Content-Length: 20\r\n" +
				"\r\n" +
				"sample-cat-image.png\r\n" +
				"--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"useUniqueFileName\"\r\n" +
				"Content-Length: 5\r\n" +
				"\r\n" +
				"false\r\n" +
				"--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"tags\"\r\n" +
				"Content-Length: 27\r\n" +
				"\r\n" +
				"Software,Developer,Engineer\r\n" +
				"--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"folder\"\r\n" +
				"Content-Length: 5\r\n" +
				"\r\n" +
				"demo1\r\n" +
				"--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"customCoordinates\"\r\n" +
				"Content-Length: 11\r\n" +
				"\r\n" +
				"10,10,20,20\r\n" +
				"--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"responseFields\"\r\n" +
				"Content-Length: 32\r\n" +
				"\r\n" +
				"thumbnail,tags,customCoordinates\r\n" +
				"--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"overwriteFile\"\r\n" +
				"Content-Length: 4\r\n" +
				"\r\n" +
				"true\r\n" +
				"--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"overwriteCustomMetadata\"\r\n" +
				"Content-Length: 4\r\n" +
				"\r\n" +
				"true\r\n" +
				"--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"extensions\"\r\n" +
				"Content-Length: 114\r\n" +
				"\r\n" +
				"[{\"name\":\"remove-bg\",\"options\":{\"add_shadow\":true}},{\"name\":\"google-auto-tagging\",\"minConfidence\":10,\"maxTags\":5}]\r\n" +
				"--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"webhookUrl\"\r\n" +
				"Content-Length: 57\r\n" +
				"\r\n" +
				"https://webhook.site/c78d617f-33bc-40d9-9e61-608999721e2e\r\n" +
				"--randomBoundary-------------------\r\n" +
				"Content-Disposition: form-data; name=\"customMetadata\"\r\n" +
				"Content-Length: 12\r\n" +
				"\r\n" +
				"{\"test1\":10}\r\n" +
				"--randomBoundary---------------------";
		assertEquals(json, request.getBody().readUtf8().trim());
		assertEquals("POST /api/v1/files/upload HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.UPLOAD_BASE_URL.concat("api/v1/files/upload"), request.getRequestUrl().toString());
	}

	@Test(expected = BadRequestException.class)
	public void imageKit_upload_400_expected() throws IOException, InterruptedException, InternalServerException,
			BadRequestException, UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {
		String imageUrl = "https://homepages.cae.wisc.edu/~ece533/images/cat.png";
		URL url = new URL(imageUrl);
		FileCreateRequest fileCreateRequest = new FileCreateRequest(url, "sample-cat-image.png");
		List<String> tags = new ArrayList<>();
		tags.add("Software");
		tags.add("Developer");
		tags.add("Engineer");
		fileCreateRequest.setTags(tags);
		fileCreateRequest.setFolder("demo1");
		String customCoordinates = "10,10,20,20";
		fileCreateRequest.setCustomCoordinates(customCoordinates);

		List<String> responseFields = new ArrayList<>();
		responseFields.add("thumbnail");
		responseFields.add("tags");
		responseFields.add("customCoordinates");

		fileCreateRequest.setResponseFields(responseFields);
		JsonObject optionsInnerObject = new JsonObject();
		optionsInnerObject.addProperty("add_shadow", true);
		JsonObject innerObject1 = new JsonObject();
		innerObject1.addProperty("name", "remove-bg");
		innerObject1.add("options", optionsInnerObject);
		JsonObject innerObject2 = new JsonObject();
		innerObject2.addProperty("name", "google-auto-tagging");
		innerObject2.addProperty("minConfidence", 10);
		innerObject2.addProperty("maxTags", 5);
		JsonArray jsonArray = new JsonArray();
		jsonArray.add(innerObject1);
		jsonArray.add(innerObject2);
		fileCreateRequest.setExtensions(jsonArray);
		fileCreateRequest.setWebhookUrl("https://webhook.site/c78d617f-33bc-40d9-9e61-608999721e2e");
		fileCreateRequest.setUseUniqueFileName(false);
		fileCreateRequest.setPrivateFile(false);
		fileCreateRequest.setOverwriteFile(false);
		fileCreateRequest.setOverwriteAITags(false);
		fileCreateRequest.setOverwriteTags(false);
		fileCreateRequest.setOverwriteCustomMetadata(true);
		JsonObject jsonObjectCustomMetadata = new JsonObject();
		jsonObjectCustomMetadata.addProperty("test1", 10);
		fileCreateRequest.setCustomMetadata(jsonObjectCustomMetadata);

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(400).setBody("{\r\n"
				+ "    \"message\": \"A file with the same name already exists at the exact location. We could not overwrite it because both overwriteFile and useUniqueFileName are set to false.\"\r\n"
				+ "}"));
		server.start();
		RestClient.UPLOAD_BASE_URL = server.url("/").toString();
		SUT.upload(fileCreateRequest);
		server.takeRequest();
	}

}