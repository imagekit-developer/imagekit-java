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
import java.util.ArrayList;
import java.util.List;

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

	@Test
	public void createCustomMetaDataFields_successExpected_type_Textarea()
			throws InterruptedException, IOException, BadRequestException, UnknownException {

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\n" +
				"    \"name\": \"mockName\",\n" +
				"    \"label\": \"mockLabel\",\n" +
				"    \"schema\": {\n" +
				"        \"isValueRequired\": true,\n" +
				"        \"defaultValue\": \"default value of test\",\n" +
				"        \"type\": \"Textarea\",\n" +
				"        \"minLength\": 10,\n" +
				"        \"maxLength\": 1000\n" +
				"    }\n" +
				"}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		CustomMetaDataFieldSchemaObject mockCustomMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
		mockCustomMetaDataFieldSchemaObject.setValueRequired(true);
		mockCustomMetaDataFieldSchemaObject.setDefaultValue("default value of test");
		mockCustomMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Textarea);
		mockCustomMetaDataFieldSchemaObject.setMinLength(10);
		mockCustomMetaDataFieldSchemaObject.setMaxLength(100);

		CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
		customMetaDataFieldCreateRequest.setName("mockName");
		customMetaDataFieldCreateRequest.setLabel("mockLabel");
		customMetaDataFieldCreateRequest.setSchema(mockCustomMetaDataFieldSchemaObject);

		SUT.createCustomMetaDataFields(customMetaDataFieldCreateRequest);
		RecordedRequest request = server.takeRequest();

		String customMetaDataFieldCreateRequestJson = "{\"name\":\"mockName\",\"label\":\"mockLabel\",\"schema\":{\"type\":\"Textarea\",\"defaultValue\":\"default value of test\",\"isValueRequired\":true,\"minLength\":10,\"maxLength\":100}}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(customMetaDataFieldCreateRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/customMetadataFields HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields"), request.getRequestUrl().toString());
	}

	@Test
	public void createCustomMetaDataFields_successExpected_type_Date()
			throws InterruptedException, IOException, BadRequestException, UnknownException {

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\n" +
				"    \"id\": \"62c2d18da6f0abb293b3941a\",\n" +
				"    \"name\": \"name\",\n" +
				"    \"label\": \"label\",\n" +
				"    \"schema\": {\n" +
				"        \"type\": \"Date\",\n" +
				"        \"minValue\": \"2022-11-30T10:11:10+00:00\",\n" +
				"        \"maxValue\": \"2022-12-30T10:11:10+00:00\"\n" +
				"    }\n" +
				"}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
		customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Date);
		customMetaDataFieldSchemaObject.setMinValue("2022-11-30T10:11:10+00:00");
		customMetaDataFieldSchemaObject.setMaxValue("2022-12-30T10:11:10+00:00");

		CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
		customMetaDataFieldCreateRequest.setName("Name");
		customMetaDataFieldCreateRequest.setLabel("Label");
		customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);

		SUT.createCustomMetaDataFields(customMetaDataFieldCreateRequest);
		RecordedRequest request = server.takeRequest();

		String customMetaDataFieldCreateRequestJson = "{\"name\":\"Name\",\"label\":\"Label\",\"schema\":{\"type\":\"Date\",\"minValue\":\"2022-11-30T10:11:10+00:00\",\"maxValue\":\"2022-12-30T10:11:10+00:00\"}}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(customMetaDataFieldCreateRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/customMetadataFields HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields"), request.getRequestUrl().toString());
	}

	@Test
	public void createCustomMetaDataFields_successExpected_type_Boolean()
			throws InterruptedException, IOException, BadRequestException, UnknownException {

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\n" +
				"    \"id\": \"62c2e4268eed64d4a80c585a\",\n" +
				"    \"name\": \"Name\",\n" +
				"    \"label\": \"Label\",\n" +
				"    \"schema\": {\n" +
				"        \"type\": \"Boolean\",\n" +
				"        \"isValueRequired\": true,\n" +
				"        \"defaultValue\": true\n" +
				"    }\n" +
				"}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
		customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Boolean);
		customMetaDataFieldSchemaObject.setValueRequired(true);
		customMetaDataFieldSchemaObject.setDefaultValue(true);

		CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
		customMetaDataFieldCreateRequest.setName("Name");
		customMetaDataFieldCreateRequest.setLabel("Label");
		customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);

		SUT.createCustomMetaDataFields(customMetaDataFieldCreateRequest);
		RecordedRequest request = server.takeRequest();

		String customMetaDataFieldCreateRequestJson = "{\"name\":\"Name\",\"label\":\"Label\",\"schema\":{\"type\":\"Boolean\",\"defaultValue\":true,\"isValueRequired\":true}}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(customMetaDataFieldCreateRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/customMetadataFields HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields"), request.getRequestUrl().toString());
	}

	@Test
	public void createCustomMetaDataFields_successExpected_type_SingleSelect()
			throws InterruptedException, IOException, BadRequestException, UnknownException {

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\n" +
				"    \"id\": \"62c2cfe2a6f0ab95fcb3640f\",\n" +
				"    \"name\": \"Name\",\n" +
				"    \"label\": \"Label\",\n" +
				"    \"schema\": {\n" +
				"        \"type\": \"SingleSelect\",\n" +
				"        \"selectOptions\": [\n" +
				"            \"small\",\n" +
				"            \"medium\",\n" +
				"            \"large\",\n" +
				"            30,\n" +
				"            40,\n" +
				"            true\n" +
				"        ]\n" +
				"    }\n" +
				"}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		List<Object> objectList = new ArrayList<>();
		objectList.add("small");
		objectList.add("medium");
		objectList.add("large");
		objectList.add(30);
		objectList.add(40);
		objectList.add(true);
		CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
		customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.SingleSelect);
		customMetaDataFieldSchemaObject.setSelectOptions(objectList);

		CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
		customMetaDataFieldCreateRequest.setName("Name");
		customMetaDataFieldCreateRequest.setLabel("Label");
		customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);

		SUT.createCustomMetaDataFields(customMetaDataFieldCreateRequest);
		RecordedRequest request = server.takeRequest();

		String customMetaDataFieldCreateRequestJson = "{\"name\":\"Name\",\"label\":\"Label\",\"schema\":{\"type\":\"SingleSelect\",\"selectOptions\":[\"small\",\"medium\",\"large\",30,40,true]}}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(customMetaDataFieldCreateRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/customMetadataFields HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields"), request.getRequestUrl().toString());
	}

	@Test
	public void createCustomMetaDataFields_successExpected_type_MultiSelect()
			throws InterruptedException, IOException, BadRequestException, UnknownException {

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\n" +
				"    \"id\": \"62c2d3c5a6f0ab2330b3b0b2\",\n" +
				"    \"name\": \"Name\",\n" +
				"    \"label\": \"Label\",\n" +
				"    \"schema\": {\n" +
				"        \"isValueRequired\": true,\n" +
				"        \"defaultValue\": [\n" +
				"            \"small\",\n" +
				"            30,\n" +
				"            true\n" +
				"        ],\n" +
				"        \"type\": \"MultiSelect\",\n" +
				"        \"selectOptions\": [\n" +
				"            \"small\",\n" +
				"            \"medium\",\n" +
				"            \"large\",\n" +
				"            30,\n" +
				"            40,\n" +
				"            true\n" +
				"        ]\n" +
				"    }\n" +
				"}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();

		List<Object> objectList = new ArrayList<>();
		objectList.add("small");
		objectList.add("medium");
		objectList.add("large");
		objectList.add(30);
		objectList.add(40);
		objectList.add(true);

		List<Object> defaultValueObject = new ArrayList<>();
		defaultValueObject.add("small");
		defaultValueObject.add(30);
		defaultValueObject.add(true);
		CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
		customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.MultiSelect);
		customMetaDataFieldSchemaObject.setValueRequired(true);
		customMetaDataFieldSchemaObject.setDefaultValue(defaultValueObject);
		customMetaDataFieldSchemaObject.setSelectOptions(objectList);

		CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
		customMetaDataFieldCreateRequest.setName("Name");
		customMetaDataFieldCreateRequest.setLabel("Label");
		customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);

		SUT.createCustomMetaDataFields(customMetaDataFieldCreateRequest);
		RecordedRequest request = server.takeRequest();

		String customMetaDataFieldCreateRequestJson = "{\"name\":\"Name\",\"label\":\"Label\",\"schema\":{\"type\":\"MultiSelect\",\"selectOptions\":[\"small\",\"medium\",\"large\",30,40,true],\"defaultValue\":[\"small\",30,true],\"isValueRequired\":true}}";
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
