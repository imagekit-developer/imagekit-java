package io.imagekit.sdk.manage;

import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.ImageKitTest;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.NotFoundException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.CustomMetaDataFieldCreateRequest;
import io.imagekit.sdk.models.CustomMetaDataFieldSchemaObject;
import io.imagekit.sdk.models.CustomMetaDataFieldUpdateRequest;
import io.imagekit.sdk.models.CustomMetaDataTypeEnum;
import io.imagekit.sdk.models.results.ResultCustomMetaDataField;
import io.imagekit.sdk.tasks.RestClient;
import io.imagekit.sdk.utils.Utils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CustomMetaDataFieldTest {

	private ImageKit SUT;

	@Before
	public void setUp() throws Exception {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
	}

	@Test
	public void get_custom_metadata_fields_expectedSuccessWith()
			throws IOException, InterruptedException, UnknownException {

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("[\n" + "    {\n" + "        \"id\": \"6291f00890ba008cc27f64d1\",\n"
				+ "        \"name\": \"price\",\n" + "        \"label\": \"Amount\",\n" + "        \"schema\": {\n"
				+ "            \"minValue\": 10,\n" + "            \"maxValue\": 200,\n"
				+ "            \"type\": \"Number\"\n" + "        }\n" + "    },\n" + "    {\n"
				+ "        \"id\": \"6296f91191fa57ccc36b15cf\",\n" + "        \"name\": \"Amount2\",\n"
				+ "        \"label\": \"Amouunt\",\n" + "        \"schema\": {\n"
				+ "            \"type\": \"Number\",\n" + "            \"minValue\": 10,\n"
				+ "            \"maxValue\": 1000\n" + "        }\n" + "    }\n" + "]"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.getCustomMetaDataFields(false);
		RecordedRequest request = server.takeRequest();
		assertEquals("application/json", request.getHeader("Content-Type"));
		assertEquals("GET /v1/customMetadataFields?includeDeleted=false HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields?includeDeleted=false"),
				request.getRequestUrl().toString());
	}

	@Test(expected = BadRequestException.class)
	public void createCustomMetaDataFields_expected_400()
			throws InterruptedException, IOException, BadRequestException, UnknownException {

		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"message\": \"Invalid schema object\",\n"
				+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n" + "    \"errors\": {\n"
				+ "        \"minValue\": \"not allowed for this type\",\n"
				+ "        \"maxValue\": \"not allowed for this type\"\n" + "    }\n" + "}";
		server.enqueue(new MockResponse().setResponseCode(400).setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		CustomMetaDataFieldSchemaObject mockCustomMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
		mockCustomMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Text);
		mockCustomMetaDataFieldSchemaObject.setMinValue(10);
		mockCustomMetaDataFieldSchemaObject.setMaxValue(100);

		CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
		customMetaDataFieldCreateRequest.setName("mockName");
		customMetaDataFieldCreateRequest.setLabel("mockLabel");
		customMetaDataFieldCreateRequest.setSchema(mockCustomMetaDataFieldSchemaObject);

		ResultCustomMetaDataField resultCustomMetaDataField = SUT
				.createCustomMetaDataFields(customMetaDataFieldCreateRequest);
		RecordedRequest request = server.takeRequest();
		String customMetaDataFieldCreateRequestJson = "{\"name\":\"mockName\",\"label\":\"mockLabel\",\"schema\":{\"type\":\"Number\",\"minValue\":10,\"maxValue\":100}}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(400, resultCustomMetaDataField.getResponseMetaData().getHttpStatusCode());
		assertEquals(customMetaDataFieldCreateRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/customMetadataFields HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields"), request.getRequestUrl().toString());
	}

	@Test
	public void createCustomMetaDataFields_successExpected()
			throws InterruptedException, IOException, BadRequestException, UnknownException {

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\n" + "    \"id\": \"629f2e2f7eb0fe2eb25f9988\",\n"
				+ "    \"name\": \"test1\",\n" + "    \"label\": \"test1\",\n" + "    \"schema\": {\n"
				+ "        \"type\": \"Number\",\n" + "        \"isValueRequired\": false,\n"
				+ "        \"minValue\": 10,\n" + "        \"maxValue\": 1000\n" + "    }\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		CustomMetaDataFieldSchemaObject mockCustomMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
		mockCustomMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Number);
		mockCustomMetaDataFieldSchemaObject.setMinValue(10);
		mockCustomMetaDataFieldSchemaObject.setMaxValue(100);

		CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
		customMetaDataFieldCreateRequest.setName("mockName");
		customMetaDataFieldCreateRequest.setLabel("mockLabel");
		customMetaDataFieldCreateRequest.setSchema(mockCustomMetaDataFieldSchemaObject);

		SUT.createCustomMetaDataFields(customMetaDataFieldCreateRequest);
		RecordedRequest request = server.takeRequest();

		String customMetaDataFieldCreateRequestJson = "{\"name\":\"mockName\",\"label\":\"mockLabel\",\"schema\":{\"type\":\"Number\",\"minValue\":10,\"maxValue\":100}}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(customMetaDataFieldCreateRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/customMetadataFields HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields"), request.getRequestUrl().toString());
	}

	@Test(expected = NotFoundException.class)
	public void deleteCustomMetaDataField_404_Expected()
			throws IOException, InterruptedException, NotFoundException, UnknownException {
		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(404)
				.setBody("{\n" + "    \"message\": \"No such custom metadata field exists\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		SUT.deleteCustomMetaDataField("6296fd7091fa5768106b808E");
		server.takeRequest();
	}

	@Test
	public void deleteCustomMetaDataField_successExpected()
			throws IOException, InterruptedException, NotFoundException, UnknownException {
		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody(""));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		SUT.deleteCustomMetaDataField("629f2e2f7eb0fe2eb25f9988");
		RecordedRequest request = server.takeRequest();

		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals("", utf8RequestBody);
		assertEquals("application/json", request.getHeader("Content-Type"));
		assertEquals("DELETE /v1/customMetadataFields/629f2e2f7eb0fe2eb25f9988 HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields/629f2e2f7eb0fe2eb25f9988"),
				request.getRequestUrl().toString());
	}

	@Test(expected = NotFoundException.class)
	public void updateCustomMetaDataFields_404_Expected()
			throws InterruptedException, IOException, BadRequestException, NotFoundException, UnknownException {

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(404)
				.setBody("{\n" + "    \"message\": \"No such custom metadata field exists\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		CustomMetaDataFieldSchemaObject mockCustomMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
		mockCustomMetaDataFieldSchemaObject.setMinLength(10);

		CustomMetaDataFieldUpdateRequest customMetaDataFieldUpdateRequest = new CustomMetaDataFieldUpdateRequest();
		customMetaDataFieldUpdateRequest.setId("6296fd7091fa5768106b808E");
		customMetaDataFieldUpdateRequest.setLabel("mockEditLabel");
		customMetaDataFieldUpdateRequest.setSchema(mockCustomMetaDataFieldSchemaObject);

		SUT.updateCustomMetaDataFields(customMetaDataFieldUpdateRequest);
		server.takeRequest();
	}

	@Test(expected = BadRequestException.class)
	public void updateCustomMetaDataFields_400_Expected()
			throws InterruptedException, IOException, BadRequestException, NotFoundException, UnknownException {

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(400)
				.setBody("{\n" + "    \"message\": \"Invalid schema object\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
						+ "    \"errors\": {\n" + "        \"minLength\": \"not allowed for this type\"\n" + "    }\n"
						+ "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		CustomMetaDataFieldSchemaObject mockCustomMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
		mockCustomMetaDataFieldSchemaObject.setMinLength(10);

		CustomMetaDataFieldUpdateRequest customMetaDataFieldUpdateRequest = new CustomMetaDataFieldUpdateRequest();
		customMetaDataFieldUpdateRequest.setId("628f189d4e4ea318b69efa9d");
		customMetaDataFieldUpdateRequest.setLabel("mockEditLabel");
		customMetaDataFieldUpdateRequest.setSchema(mockCustomMetaDataFieldSchemaObject);

		SUT.updateCustomMetaDataFields(customMetaDataFieldUpdateRequest);
		server.takeRequest();
	}

	@Test
	public void updateCustomMetaDataFields_successExpected()
			throws InterruptedException, IOException, BadRequestException, NotFoundException, UnknownException {

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse()
				.setBody("{\n" + "    \"id\": \"6296fd7091fa5768106b808d\",\n" + "    \"name\": \"Amount3\",\n"
						+ "    \"label\": \"testPrices\",\n" + "    \"schema\": {\n" + "        \"minValue\": 0,\n"
						+ "        \"maxValue\": 10,\n" + "        \"type\": \"Number\"\n" + "    }\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		CustomMetaDataFieldSchemaObject mockCustomMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
		mockCustomMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Number);
		mockCustomMetaDataFieldSchemaObject.setMinValue(10);
		mockCustomMetaDataFieldSchemaObject.setMaxValue(100);

		CustomMetaDataFieldUpdateRequest customMetaDataFieldUpdateRequest = new CustomMetaDataFieldUpdateRequest();
		customMetaDataFieldUpdateRequest.setId("628f189d4e4ea318b69efa9d");
		customMetaDataFieldUpdateRequest.setLabel("mockEditLabel");
		customMetaDataFieldUpdateRequest.setSchema(mockCustomMetaDataFieldSchemaObject);

		SUT.updateCustomMetaDataFields(customMetaDataFieldUpdateRequest);
		RecordedRequest request = server.takeRequest();

		String customMetaDataFieldUpdateRequestJson = "{\"id\":\"628f189d4e4ea318b69efa9d\",\"label\":\"mockEditLabel\",\"schema\":{\"type\":\"Number\",\"minValue\":10,\"maxValue\":100}}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(customMetaDataFieldUpdateRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("PATCH /v1/customMetadataFields/628f189d4e4ea318b69efa9d HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields/628f189d4e4ea318b69efa9d"),
				request.getRequestUrl().toString());
	}
}
