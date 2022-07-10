package io.imagekit.sdk;

import io.imagekit.sdk.utils.Utils;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GetUrlTest {
	private static final Pattern IMAGEKIT_SIGNED_URL_PATTERN = Pattern.compile("(https://.*)\\?ik-s=(.*)&ik-t=(.*)");
	private ImageKit SUT;

	@Before
	public void setUp() throws Exception {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
	}

	private void assertSignedUrl(String expectedBaseUrl, String actualUrl) {
		java.util.regex.Matcher matcher = IMAGEKIT_SIGNED_URL_PATTERN.matcher(actualUrl);
		assertTrue(actualUrl + " does not look like a signed url", matcher.matches());
		assertEquals(expectedBaseUrl, matcher.group(1));
		assertFalse(matcher.group(2).trim().isEmpty());
		assertFalse(matcher.group(3).trim().isEmpty());
	}

	@Test
	public void getUrl_with_height_width_options() {
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

	@Test
	public void getUrl_with_height_width_options_url_version_check() {
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

	@Test
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

	@Test
	public void getUrl_with_slash_in_path() {
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

	@Test
	public void getUrl_without_slash_in_path() {
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

	@Test
	public void getUrl_with_overriding_urlEndpoint() {
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
		assertThat(
				"https://ik.imagekit.io/your_imagekit_id/different-url-endpoint-prefix/tr:w-400,h-600/default-image.jpg",
				is(url));
	}

	@Test
	public void getUrl_with_transformation_parameters() {
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
		scale.put("overlayImage", "oi");
		scale.put("overlayImageTrim", "oit");
		scale.put("overlayImageAspectRatio", "oiar");
		scale.put("overlayImageBackground", "oibg");
		scale.put("overlayImageBorder", "oib");
		scale.put("overlayImageDPR", "oidpr");
		scale.put("overlayImageQuality", "oiq");
		scale.put("overlayImageCropping", "oic");
		scale.put("overlayImageFocus", "oifo");

		transformation.add(scale);

		Map<String, Object> options = new HashMap<>();
		options.put("path", "/default-image.jpg");
		options.put("urlEndpoint", "https://ik.imagekit.io/your_imagekit_id/");
		options.put("transformation", transformation);

		String url = SUT.getUrl(options);
		assertThat(
				"https://ik.imagekit.io/your_imagekit_id/tr:cm-extract,ofo-top,n-any_name,md-true,ow-20,e-contrast-1,oiar-oiar,fo-left,bl-10,ar-4-3,oit-oit,e-usm-,oidpr-oidpr,oa-,obg-00AAFF55,ots-18,t-5,oh-20,oic-oic,cp-true,r-20,ox-20,ot-Image%20Text,oy-10,otc-00FFFF,di-folder@@file.jpg,h-600,b-5-A94D34,orig-true,rt-90,dpr-3,f-png,raw-w-200,h-200,lo-true,e-grayscale-,oibg-oibg,q-40,ott-b,oib-oib,oiq-oiq,bg-A94D34,w-400,pr-true,e-sharpen,oi-oi,oifo-oifo,c-force,otf-Open%20Sans/default-image.jpg",
				is(url));
	}

	@Test
	public void getUrl_with_overriding_urlEndpoint_double_slash_tests() {
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

	@Test
	public void getUrl_with_options_as_query() {
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

	@Test()
	public void getUrl_with_options_as_path() {
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

	@Test
	public void getUrl_with_chained_transformation_options_as_query() {
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

	@Test
	public void getUrl_with_chained_transformation_options_as_path() {
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

	@Test
	public void getUrl_with_multiple_query_params_addition_check() {
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
		assertThat(
				"https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?q=abc&v=123&z=234&tr=w-400,h-600",
				is(url));
	}

	@Test
	public void getUrl_with_double_and_check() {
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
		assertThat(
				"https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?q=abc&v=123&z=234&tr=w-400,h-600",
				is(url));
	}

	@Test
	public void getUrl_with_double_question_mark_check() {
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
		assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?v=123&z=234&tr=w-400,h-600",
				is(url));
	}

	@Test
	public void getUrl_with_src() {
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

	@Test
	public void getUrl_src_with_query_params() {
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
		assertThat(
				"https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?srcParam=srcParamValue&v=123&z=234&tr=w-400,h-600",
				is(url));
	}

	@Test
	public void getUrl_src_with_query_params_but_transformationPosition_is_path() {
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
		assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?v=123&z=234&tr=w-400,h-600",
				is(url));
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

		assertSignedUrl("https://ik.imagekit.io/imagekit_id/tr:w-100/test-signed-url.png", url);
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
}
