package io.imagekit.sdk;

import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.constants.Version;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ConflictException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.NotFoundException;
import io.imagekit.sdk.exceptions.PartialSuccessException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.AITagsRequest;
import io.imagekit.sdk.models.CopyFileRequest;
import io.imagekit.sdk.models.CopyFolderRequest;
import io.imagekit.sdk.models.CreateFolderRequest;
import io.imagekit.sdk.models.CustomMetaDataFieldCreateRequest;
import io.imagekit.sdk.models.CustomMetaDataFieldSchemaObject;
import io.imagekit.sdk.models.CustomMetaDataFieldUpdateRequest;
import io.imagekit.sdk.models.CustomMetaDataTypeEnum;
import io.imagekit.sdk.models.DeleteFileVersionRequest;
import io.imagekit.sdk.models.DeleteFolderRequest;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.FileUpdateRequest;
import io.imagekit.sdk.models.MoveFileRequest;
import io.imagekit.sdk.models.MoveFolderRequest;
import io.imagekit.sdk.models.RenameFileRequest;
import io.imagekit.sdk.models.TagsRequest;
import io.imagekit.sdk.models.results.*;
import io.imagekit.sdk.tasks.RestClient;
import io.imagekit.sdk.utils.Utils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.*;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ImageKitTest {
	private static final Pattern IMAGEKIT_SIGNED_URL_PATTERN = Pattern
			.compile("(https://.*)\\?ik-s=(.*)&ik-t=(.*)");

	private ImageKit SUT;

	RestClient restClient;

	@Before
	public void setUp() throws Exception {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		restClient = new RestClient(SUT);
		SUT.setRestClient(restClient);
	}

	@Test
	public void imageKit_configurationTest() {
		Configuration config = new Configuration();
		config.setPrivateKey("private_Key");
		config.setPublicKey("public_key");
		config.setUrlEndpoint("url_end_point");
		ImageKit.getInstance().setConfig(config);
		assertEquals(config.toString(), ImageKit.getInstance().getConfig().toString());
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_height_width_options() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("transformation", transformation);
		String url = SUT.getUrl(options);

		assertThat(SUT.getConfig().getUrlEndpoint() + "/tr:w-400,h-600/default-image.jpg", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_height_width_options_url_version_check() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);
		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("transformation", transformation);
		String url = SUT.getUrl(options);
		assertThat(SUT.getConfig().getUrlEndpoint() + "/tr:w-400,h-600/default-image.jpg", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_new_transformation_params_options() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);
		Map<String, String> newParams = new HashMap<>();
		newParams.put("myparam", "40");
		transformation.add(newParams);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("transformation", transformation);
		String url = SUT.getUrl(options);
		assertThat(SUT.getConfig().getUrlEndpoint() + "/tr:w-400,h-600:myparam-40/default-image.jpg", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_slash_in_path() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("transformation", transformation);
		String url = SUT.getUrl(options);
		assertThat(SUT.getConfig().getUrlEndpoint() + "/tr:w-400,h-600/default-image.jpg", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_without_slash_in_path() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);
		Map<String, Object> options = new HashMap<>();
		options.put("path", "default-image.jpg");
		options.put("transformation", transformation);
		String url = SUT.getUrl(options);
		assertThat(SUT.getConfig().getUrlEndpoint() + "/tr:w-400,h-600/default-image.jpg", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_overriding_urlEndpoint() {
		SUT = ImageKit.getInstance();
		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("urlEndpoint", "https://ik.imagekit.io/your_imagekit_id/different-url-endpoint-prefix");
		options.put("transformation", transformation);

		String url = SUT.getUrl(options);
		assertThat("https://ik.imagekit.io/your_imagekit_id/different-url-endpoint-prefix/tr:w-400,h-600/default-image.jpg", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_transformation_parameters() {
		SUT = ImageKit.getInstance();
		List<Map<String, String>> transformation = new ArrayList<Map<String, String>>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		scale.put("aspectRatio", "4-3");
		scale.put("quality", "40");
		scale.put("crop", "force");
		scale.put("cropMode", "extract");
		scale.put("focus", "left");
		scale.put("format", "png");
		scale.put("radius", "20");
		scale.put("background", "A94D34");
		scale.put("border", "5-A94D34");
		scale.put("rotation", "90");
		scale.put("blur", "10");
		scale.put("named", "any_name");
		scale.put("overlayImage", "/folder/file.jpg");
		scale.put("overlayX", "20");
		scale.put("overlayY", "10");
		scale.put("overlayFocus", "top");
		scale.put("overlayHeight", "20");
		scale.put("overlayWidth", "20");
		scale.put("overlayText", "Image Text");
		scale.put("overlayTextFontSize", "18");
		scale.put("overlayTextFontFamily", "Open Sans");
		scale.put("overlayTextColor", "00FFFF");
		scale.put("overlayAlpha", "");
		scale.put("overlayTextTypography", "b");
		scale.put("overlayBackground", "00AAFF55");
		scale.put("overlayImageTrim", String.valueOf(false));
		scale.put("progressive", String.valueOf(true));
		scale.put("lossless", String.valueOf(true));
		scale.put("trim", "5");
		scale.put("metadata", String.valueOf(true));
		scale.put("colorProfile", String.valueOf(true));
		scale.put("defaultImage", "/folder/file.jpg");
		scale.put("dpr", "3");
		scale.put("effectSharpen", "-");
		scale.put("effectUSM", "");
		scale.put("effectContrast", "1");
		scale.put("effectGray", "");
		scale.put("original", String.valueOf(true));
		scale.put("raw", "w-200,h-200");

		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("urlEndpoint", "https://ik.imagekit.io/your_imagekit_id/");
		options.put("transformation", transformation);

		String url = SUT.getUrl(options);
		assertThat("https://ik.imagekit.io/your_imagekit_id/tr:cm-extract,ofo-top,n-any_name,md-true,ow-20,e-contrast-1,fo-left,bl-10,ar-4-3,oit-false,e-usm-,oa-,obg-00AAFF55,ots-18,t-5,oh-20,cp-true,r-20,ox-20,ot-Image%20Text,oy-10,otc-00FFFF,di-folder@@file.jpg,h-600,bo-5-A94D34,orig-true,rt-90,dpr-3,f-png,raw-w-200,h-200,lo-true,e-grayscale-,q-40,ott-b,bg-A94D34,w-400,pr-true,e-sharpen,oi-folder@@file.jpg,c-force,otf-Open%20Sans/default-image.jpg", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_overriding_urlEndpoint_double_slash_tests() {
		SUT = ImageKit.getInstance();
		List<Map<String, String>> transformation = new ArrayList<Map<String, String>>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("urlEndpoint", "https://ik.imagekit.io/your_imagekit_id/");
		options.put("transformation", transformation);

		String url = SUT.getUrl(options);
		assertThat("https://ik.imagekit.io/your_imagekit_id/tr:w-400,h-600/default-image.jpg", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_options_as_query() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("v", "123");

		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("queryParameters", queryParams);
		options.put("transformation", transformation);
		options.put("transformationPosition", "query");

		String url = SUT.getUrl(options);
		MatcherAssert.assertThat(SUT.getConfig().getUrlEndpoint() + "/default-image.jpg?v=123&tr=w-400,h-600", is(url));
	}

	@org.junit.jupiter.api.Test()
	public void getUrl_with_options_as_path() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("v", "123");

		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("queryParameters", queryParams);
		options.put("transformation", transformation);

		String url = SUT.getUrl(options);
		assertThat(SUT.getConfig().getUrlEndpoint() + "/tr:w-400,h-600/default-image.jpg?v=123", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_chained_transformation_options_as_query() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("v", "123");

		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);
		Map<String, String> rotate = new HashMap<>();
		rotate.put("rotation", "90");
		transformation.add(rotate);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("queryParameters", queryParams);
		options.put("transformation", transformation);
		options.put("transformationPosition", "query");

		String url = SUT.getUrl(options);
		assertThat(SUT.getConfig().getUrlEndpoint() + "/default-image.jpg?v=123&tr=w-400,h-600:rt-90", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_chained_transformation_options_as_path() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("v", "123");

		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);
		Map<String, String> rotate = new HashMap<>();
		rotate.put("rotation", "90");
		transformation.add(rotate);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("queryParameters", queryParams);
		options.put("transformation", transformation);

		String url = SUT.getUrl(options);
		assertThat(SUT.getConfig().getUrlEndpoint() + "/tr:w-400,h-600:rt-90/default-image.jpg?v=123", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_multiple_query_params_addition_check() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("v", "123");
		queryParams.put("z", "234");

		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("src", "https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?q=abc");
		options.put("queryParameters", queryParams);
		options.put("transformation", transformation);

		String url = SUT.getUrl(options);
		assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?q=abc&v=123&z=234&tr=w-400,h-600", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_double_and_check() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("v", "123");
		queryParams.put("z", "234");

		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("src", "https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?q=abc&&");
		options.put("queryParameters", queryParams);
		options.put("transformation", transformation);

		String url = SUT.getUrl(options);
		assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?q=abc&v=123&z=234&tr=w-400,h-600", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_double_question_mark_check() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("v", "123");
		queryParams.put("z", "234");

		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("src", "https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg??");
		options.put("queryParameters", queryParams);
		options.put("transformation", transformation);

		String url = SUT.getUrl(options);
		assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?v=123&z=234&tr=w-400,h-600", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_with_src() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("src", "https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg");
		options.put("transformation", transformation);

		String url = SUT.getUrl(options);
		assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?tr=w-400,h-600", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_src_with_query_params() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("v", "123");
		queryParams.put("z", "234");

		List<Map<String, String>> transformation = new ArrayList<>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("src", "https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?srcParam=srcParamValue");
		options.put("queryParameters", queryParams);
		options.put("transformation", transformation);

		String url = SUT.getUrl(options);
		assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?srcParam=srcParamValue&v=123&z=234&tr=w-400,h-600", is(url));
	}

	@org.junit.jupiter.api.Test
	public void getUrl_src_with_query_params_but_transformationPosition_is_path() throws IOException {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
		Map<String, String> queryParam = new HashMap<>();
		queryParam.put("v", "123");
		queryParam.put("z", "234");

		List<Map<String, String>> transformation = new ArrayList<Map<String, String>>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("src", "https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg");
		options.put("queryParameters", queryParam);
		options.put("transformation", transformation);
		options.put("transformationPosition", "path");

		String url = SUT.getUrl(options);
		assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?v=123&z=234&tr=w-400,h-600", is(url));
	}

	@Test
	public void getUrl_with_signature() {
		List<Map<String, String>> transformation = new ArrayList<Map<String, String>>();
		Map<String, String> scale = new HashMap<>();
		scale.put("width", "100");
		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/test-signed-url.png");
		options.put("transformation", transformation);
		options.put("signed", true);
		options.put("expireSeconds", 1000);

		String url = SUT.getUrl(options);

		assertSignedUrl("https://test-domain.com/test-endpoint/tr:w-100/test-signed-url.png", url);
	}

	@Test
	public void getUrl_with_signature_src_noTransform() {
		Map<String, Object> options = new HashMap<>();
		options.put("src", "https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg");
		options.put("transformation", Collections.emptyList());
		options.put("signed", true);
		options.put("expireSeconds", 1000);

		String url = SUT.getUrl(options);

		assertSignedUrl("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg", url);
	}

	@Test
	public void getUrl_with_time_expire() {
		List<Map<String, String>> transformation = new ArrayList<Map<String, String>>();
		Map<String, String> scale = new HashMap<>();
		scale.put("height", "600");
		scale.put("width", "400");
		transformation.add(scale);
		Map<String, String> rotate = new HashMap<>();
		rotate.put("rotation", "90");
		transformation.add(rotate);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("transformation", transformation);
		options.put("expireSeconds", 100);
		options.put("signed", true);

		String url = SUT.getUrl(options);
		assertTrue(url.contains("ik-t"));
	}

	// Test Case for Upload

	@Test(expected = UnknownHostException.class)
	public void imageKit_upload_expect_UnknownHostException() throws IOException {
		String imageUrl = "https://homepagesabc.cae.wisc.edu/~ece533/images/12.png";
		URL url = new URL(imageUrl);
		HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
		urlConnect.getContent();
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
		fileCreateRequest.setUseUniqueFileName(false);
		fileCreateRequest.setPrivateFile(false);
		fileCreateRequest.setOverwriteFile(true);
		fileCreateRequest.setOverwriteAITags(false);
		fileCreateRequest.setOverwriteTags(false);
		fileCreateRequest.setOverwriteCustomMetadata(true);
		JsonObject jsonObjectCustomMetadata = new JsonObject();
		jsonObjectCustomMetadata.addProperty("test1", 10);
		fileCreateRequest.setCustomMetadata(jsonObjectCustomMetadata);

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\n" + "    \"fileId\": \"62a465d245a84a0ef3852968\",\n"
				+ "    \"name\": \"sample-cat-image_GG0_X8GOn.jpg\",\n" + "    \"size\": 23023,\n"
				+ "    \"versionInfo\": {\n" + "        \"id\": \"62a465d245a84a0ef3852968\",\n"
				+ "        \"name\": \"Version 1\"\n" + "    },\n"
				+ "    \"filePath\": \"/demo1/sample-cat-image_GG0_X8GOn.jpg\",\n"
				+ "    \"url\": \"https://ik.imagekit.io/zv3rkhsym/demo1/sample-cat-image_GG0_X8GOn.jpg\",\n"
				+ "    \"fileType\": \"image\",\n" + "    \"height\": 354,\n" + "    \"width\": 236,\n"
				+ "    \"thumbnailUrl\": \"https://ik.imagekit.io/zv3rkhsym/tr:n-ik_ml_thumbnail/demo1/sample-cat-image_GG0_X8GOn.jpg\",\n"
				+ "    \"AITags\": [\n" + "        {\n" + "            \"name\": \"Clothing\",\n"
				+ "            \"confidence\": 98.77,\n" + "            \"source\": \"google-auto-tagging\"\n"
				+ "        },\n" + "        {\n" + "            \"name\": \"Plant\",\n"
				+ "            \"confidence\": 96.51,\n" + "            \"source\": \"google-auto-tagging\"\n"
				+ "        },\n" + "        {\n" + "            \"name\": \"Smile\",\n"
				+ "            \"confidence\": 95.31,\n" + "            \"source\": \"google-auto-tagging\"\n"
				+ "        },\n" + "        {\n" + "            \"name\": \"Shoe\",\n"
				+ "            \"confidence\": 95.2,\n" + "            \"source\": \"google-auto-tagging\"\n"
				+ "        },\n" + "        {\n" + "            \"name\": \"Street light\",\n"
				+ "            \"confidence\": 91.05,\n" + "            \"source\": \"google-auto-tagging\"\n"
				+ "        }\n" + "    ],\n" + "    \"extensionStatus\": {\n" + "        \"remove-bg\": \"pending\",\n"
				+ "        \"google-auto-tagging\": \"success\"\n" + "    }\n" + "}"));
		server.start();
		RestClient.UPLOAD_BASE_URL = server.url("/").toString();
		SUT.upload(fileCreateRequest);
		RecordedRequest request = server.takeRequest();
		String json = "--randomBoundary-------------------\r\n" + "Content-Disposition: form-data; name=\"file\"\r\n"
				+ "Content-Length: 53\r\n" + "\r\n" + "https://homepages.cae.wisc.edu/~ece533/images/cat.png\r\n"
				+ "--randomBoundary-------------------\r\n" + "Content-Disposition: form-data; name=\"fileName\"\r\n"
				+ "Content-Length: 20\r\n" + "\r\n" + "sample-cat-image.png\r\n"
				+ "--randomBoundary-------------------\r\n"
				+ "Content-Disposition: form-data; name=\"useUniqueFileName\"\r\n" + "Content-Length: 5\r\n" + "\r\n"
				+ "false\r\n" + "--randomBoundary-------------------\r\n"
				+ "Content-Disposition: form-data; name=\"tags\"\r\n" + "Content-Length: 27\r\n" + "\r\n"
				+ "Software,Developer,Engineer\r\n" + "--randomBoundary-------------------\r\n"
				+ "Content-Disposition: form-data; name=\"folder\"\r\n" + "Content-Length: 5\r\n" + "\r\n" + "demo1\r\n"
				+ "--randomBoundary-------------------\r\n"
				+ "Content-Disposition: form-data; name=\"customCoordinates\"\r\n" + "Content-Length: 11\r\n" + "\r\n"
				+ "10,10,20,20\r\n" + "--randomBoundary-------------------\r\n"
				+ "Content-Disposition: form-data; name=\"responseFields\"\r\n" + "Content-Length: 32\r\n" + "\r\n"
				+ "thumbnail,tags,customCoordinates\r\n" + "--randomBoundary-------------------\r\n"
				+ "Content-Disposition: form-data; name=\"overwriteFile\"\r\n" + "Content-Length: 4\r\n" + "\r\n"
				+ "true\r\n" + "--randomBoundary-------------------\r\n"
				+ "Content-Disposition: form-data; name=\"overwriteAITags\"\r\n" + "Content-Length: 4\r\n" + "\r\n"
				+ "true\r\n" + "--randomBoundary-------------------\r\n"
				+ "Content-Disposition: form-data; name=\"overwriteTags\"\r\n" + "Content-Length: 4\r\n" + "\r\n"
				+ "true\r\n" + "--randomBoundary-------------------\r\n"
				+ "Content-Disposition: form-data; name=\"overwriteCustomMetadata\"\r\n" + "Content-Length: 4\r\n"
				+ "\r\n" + "true\r\n" + "--randomBoundary-------------------\r\n"
				+ "Content-Disposition: form-data; name=\"extensions\"\r\n" + "Content-Length: 114\r\n" + "\r\n"
				+ "[{\"name\":\"remove-bg\",\"options\":{\"add_shadow\":true}},{\"name\":\"google-auto-tagging\",\"minConfidence\":10,\"maxTags\":5}]\r\n"
				+ "--randomBoundary-------------------\r\n" + "Content-Disposition: form-data; name=\"webhookUrl\"\r\n"
				+ "Content-Length: 57\r\n" + "\r\n" + "https://webhook.site/c78d617f-33bc-40d9-9e61-608999721e2e\r\n"
				+ "--randomBoundary-------------------\r\n"
				+ "Content-Disposition: form-data; name=\"customMetadata\"\r\n" + "Content-Length: 12\r\n" + "\r\n"
				+ "{\"test1\":10}\r\n" + "--randomBoundary---------------------";
		assertEquals(json, request.getBody().readUtf8().trim());
		assertEquals("POST /api/v1/files/upload HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.UPLOAD_BASE_URL.concat("api/v1/files/upload"), request.getRequestUrl().toString());
	}

	@Test(expected = NotFoundException.class)
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

	@Test(expected = NotFoundException.class)
	public void imageKit_getFileDetail__expected_404()
			throws IOException, InterruptedException, BadRequestException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {

		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"message\": \"The requested file does not exist.\",\n"
				+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}";
		server.enqueue(new MockResponse().setResponseCode(404).setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.getFileDetail("629f3de17eb0fe4053615450");

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

	@Test(expected = NotFoundException.class)
	public void imageKit_getRemoteFileMetaData_404_Expected()
			throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException,
			BadRequestException, UnknownException, InterruptedException, IOException {
		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"message\": \"The requested file(s) does not exist.\",\n"
				+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
				+ "    \"missingFileIds\": [\n" + "        \"629f3de17eb0fe4053615450\"\n" + "    ]\n" + "}";
		server.enqueue(new MockResponse().setResponseCode(404).setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.getRemoteFileMetadata("remote_url");

		server.takeRequest();
	}

	@Test(expected = NotFoundException.class)
	public void imageKit_deleteFile_404_Expected()
			throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException,
			BadRequestException, UnknownException, InterruptedException, IOException {
		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"message\": \"The requested file does not exist.\",\n"
				+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}";
		server.enqueue(new MockResponse().setResponseCode(404).setBody(responseJson));
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

	@Test(expected = BadRequestException.class)
	public void imageKit_purgeCache_404Expected()
			throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException,
			BadRequestException, UnknownException, InterruptedException, IOException {
		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"message\": \"Invalid url\"\n" + "}";
		server.enqueue(new MockResponse().setResponseCode(400).setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.purgeCache("url");

		server.takeRequest();
	}

	@Test
	public void imageKit_purgeCache_successExpected()
			throws IOException, ForbiddenException, TooManyRequestsException, InternalServerException,
			UnauthorizedException, BadRequestException, UnknownException, InterruptedException {
		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"requestId\": \"62b01f15214dfbdf3692dd0a\"\n" + "}";
		server.enqueue(new MockResponse().setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.purgeCache("https://ik.imagekit.io/zv3rkhsym/sample-image11_g1Qv0wpqP.jpg");

		RecordedRequest request = server.takeRequest();
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals("{\"url\":\"https://ik.imagekit.io/zv3rkhsym/sample-image11_g1Qv0wpqP.jpg\"}", utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/files/purge HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/files/purge"), request.getRequestUrl().toString());
	}

	@Test(expected = BadRequestException.class)
	public void imageKit_getPurgeCacheStatus_400Expected()
			throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException,
			BadRequestException, UnknownException, InterruptedException, IOException {
		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"message\": \"No request found for this requestId.\",\n"
				+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}";
		server.enqueue(new MockResponse().setResponseCode(400).setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.getPurgeCacheStatus("62b01f15214dfbdf3692dd0b");

		server.takeRequest();
	}

	@Test
	public void imageKit_getPurgeCacheStatus_successExpected()
			throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException,
			BadRequestException, UnknownException, InterruptedException, IOException {
		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"status\": \"Completed\"\n" + "}";
		server.enqueue(new MockResponse().setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.getPurgeCacheStatus("62b01f15214dfbdf3692dd0a");

		RecordedRequest request = server.takeRequest();
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals("", utf8RequestBody);
		assertEquals("application/json", request.getHeader("Content-Type"));
		assertEquals("GET /v1/files/purge/62b01f15214dfbdf3692dd0a HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/files/purge/62b01f15214dfbdf3692dd0a"),
				request.getRequestUrl().toString());
	}

	@Test
	public void withoutToken_getAuthenticationParameters_successExpected() {
		Map<String, String> auth = SUT.getAuthenticationParameters();
		assertNotNull(auth);
	}

	@Test(expected = RuntimeException.class)
	public void withoutPrivateKey_getAuthenticationParameters_successExpected() {
		SUT.getConfig().setPrivateKey(null);
		Map<String, String> auth = SUT.getAuthenticationParameters();
		assertNotNull(auth);
	}

	@Test
	public void withTokenAndExpire_getAuthenticationParameters_successExpected() {
		Map<String, String> auth = SUT.getAuthenticationParameters("your_token", 1582269249);
		assertNotNull(auth);
		assertEquals("your_token", auth.get("token"));
		assertEquals("1582269249", auth.get("expire"));
		assertEquals("e71bcd6031016b060d349d212e23e85c791decdd", auth.get("signature"));
	}

	@Test
	public void sameImage_getHammingDistance_expectedSuccessWith() {
		int hammingDistance = SUT.pHashDistance("f06830ca9f1e3e90", "f06830ca9f1e3e90");
		assertEquals(0, hammingDistance);
	}

	@Test
	public void similarImage_getHammingDistance_expectedSuccessWith() {
		int hammingDistance = SUT.pHashDistance("33699c96619cc69e", "968e978414fe04ea");
		assertEquals(30, hammingDistance);
	}

	@Test
	public void dissimilarImage_getHammingDistance_expectedSuccessWith() {
		int hammingDistance = SUT.pHashDistance("a4a65595ac94518b", "7838873e791f8400");
		assertEquals(37, hammingDistance);
	}

	@Test(expected = RuntimeException.class)
	public void invalidHash_getHammingDistance_throwException() {
		int hammingDistance = SUT.pHashDistance("a4a65595ac94518Z", "7838873e791f8400");
	}

	@Test(expected = RuntimeException.class)
	public void differentLength_getHammingDistance_throwException() {
		int hammingDistance = SUT.pHashDistance("a4a65595ac94518b3", "7838873e791f8400");
	}

	private void assertSignedUrl(String expectedBaseUrl, String actualUrl) {
		java.util.regex.Matcher matcher = IMAGEKIT_SIGNED_URL_PATTERN.matcher(actualUrl);
		assertTrue(actualUrl + " does not look like a signed url", matcher.matches());
		assertEquals(expectedBaseUrl, matcher.group(1));
		assertEquals(Version.VERSION_CODE, matcher.group(2));
		assertFalse(matcher.group(3).trim().isEmpty());
		assertFalse(matcher.group(4).trim().isEmpty());
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
		server.enqueue(new MockResponse().setBody(""));
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
		server.enqueue(new MockResponse().setBody(""));
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

	@Test
	public void createFolder_400_Expected() throws InterruptedException, IOException, UnknownException {

		CreateFolderRequest createFolderRequest = new CreateFolderRequest();
		createFolderRequest.setFolderName("/testFolder");
		createFolderRequest.setParentFolderPath("/");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(400));
		server.enqueue(
				new MockResponse().setBody("{\n" + "    \"message\": \"folderName parameter cannot have a slash.\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.createFolder(createFolderRequest);
		server.takeRequest();
	}

	@Test
	public void createFolder_successExpected() throws InterruptedException, IOException, UnknownException {

		CreateFolderRequest createFolderRequest = new CreateFolderRequest();
		createFolderRequest.setFolderName("testFolder");
		createFolderRequest.setParentFolderPath("/");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.createFolder(createFolderRequest);
		RecordedRequest request = server.takeRequest();

		String createFolderRequestJson = "{\"folderName\":\"testFolder\",\"parentFolderPath\":\"/\"}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(createFolderRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/folder/ HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/folder/"), request.getRequestUrl().toString());
	}

	@Test(expected = NotFoundException.class)
	public void deleteFolder_404_Expected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		DeleteFolderRequest deleteFolderRequest = new DeleteFolderRequest();
		deleteFolderRequest.setFolderPath("/testFolder");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(404)
				.setBody("{\n" + "    \"message\": \"No folder found with folderPath testFolder/\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
						+ "    \"reason\": \"FOLDER_NOT_FOUND\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.deleteFolder(deleteFolderRequest);
		server.takeRequest();
	}

	@Test
	public void deleteFolder_successExpected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		DeleteFolderRequest deleteFolderRequest = new DeleteFolderRequest();
		deleteFolderRequest.setFolderPath("testFolder");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody(""));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.deleteFolder(deleteFolderRequest);
		RecordedRequest request = server.takeRequest();

		String deleteFolderRequestJson = "{\"folderPath\":\"testFolder\"}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(deleteFolderRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("DELETE /v1/folder/ HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/folder/"), request.getRequestUrl().toString());
	}

	@Test(expected = NotFoundException.class)
	public void copyFolder_404_Expected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		CopyFolderRequest copyFolderRequest = new CopyFolderRequest();
		copyFolderRequest.setSourceFolderPath("/testFolder");
		copyFolderRequest.setDestinationPath("/test");
		copyFolderRequest.setIncludeVersions(true);

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(404)
				.setBody("{\n" + "    \"message\": \"No files & folder found at sourceFolderPath /testFolder\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
						+ "    \"reason\": \"NO_FILES_FOLDER\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.copyFolder(copyFolderRequest);
		server.takeRequest();
	}

	@Test
	public void copyFolder_successExpected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		CopyFolderRequest copyFolderRequest = new CopyFolderRequest();
		copyFolderRequest.setSourceFolderPath("/testFolder");
		copyFolderRequest.setDestinationPath("/Gallery");
		copyFolderRequest.setIncludeVersions(true);

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\n" + "    \"jobId\": \"629f43017eb0feff5c61f83c\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.copyFolder(copyFolderRequest);
		RecordedRequest request = server.takeRequest();

		String copyFolderRequestJson = "{\"sourceFolderPath\":\"/testFolder\",\"destinationPath\":\"/Gallery\",\"includeVersions\":true}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(copyFolderRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/bulkJobs/moveFolder HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/bulkJobs/moveFolder"), request.getRequestUrl().toString());
	}

	@Test(expected = NotFoundException.class)
	public void moveFolder_404_Expected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		MoveFolderRequest moveFolderRequest = new MoveFolderRequest();
		moveFolderRequest.setSourceFolderPath("/testFolder/");
		moveFolderRequest.setDestinationPath("/Gallery");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(404)
				.setBody("{\n" + "    \"message\": \"No files & folder found at sourceFolderPath /testFolder\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
						+ "    \"reason\": \"NO_FILES_FOLDER\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.moveFolder(moveFolderRequest);
		server.takeRequest();
	}

	@Test
	public void moveFolder_successExpected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		MoveFolderRequest moveFolderRequest = new MoveFolderRequest();
		moveFolderRequest.setSourceFolderPath("/testFolder");
		moveFolderRequest.setDestinationPath("/Gallery");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\n" + "    \"jobId\": \"629f44ac7eb0fe8173622d4b\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.moveFolder(moveFolderRequest);
		RecordedRequest request = server.takeRequest();

		String moveFolderRequestJson = "{\"sourceFolderPath\":\"/testFolder\",\"destinationPath\":\"/Gallery\"}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(moveFolderRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/bulkJobs/moveFolder HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/bulkJobs/moveFolder"), request.getRequestUrl().toString());
	}

	@Test
	public void getBulkJobStatus_500_Expected()
			throws InterruptedException, IOException, ForbiddenException, TooManyRequestsException,
			InternalServerException, UnauthorizedException, BadRequestException, UnknownException {

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(500));
		server.enqueue(new MockResponse().setBody(
				"{\n" + "    \"message\": \"We have experienced an internal error while processing your request.\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		ResultBulkJobStatus resultBulkJobStatus = SUT.getBulkJobStatus("jobId");
		RecordedRequest request = server.takeRequest();

		assertEquals(500, resultBulkJobStatus.getResponseMetaData().getHttpStatusCode());
		assertEquals("application/json", request.getHeader("Content-Type"));
		assertEquals("GET /v1/bulkJobs/jobId HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/bulkJobs/jobId"), request.getRequestUrl().toString());
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
		server.enqueue(new MockResponse().setBody(""));
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