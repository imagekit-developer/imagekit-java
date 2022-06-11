package io.imagekit.sdk;

import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.constants.Version;
import io.imagekit.sdk.models.AITagsRequest;
import io.imagekit.sdk.models.BaseFile;
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

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ImageKitTest {
    private static final Pattern IMAGEKIT_SIGNED_URL_PATTERN = Pattern.compile("(https://.*)\\?ik-sdk-version=(.*)&ik-s=(.*)&ik-t=(.*)");

    private ImageKit SUT;
    
    RestClient restClient;
    @Before
    public void setUp() throws Exception {
        SUT=ImageKit.getInstance();
        SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
        restClient = new RestClient(SUT);
        SUT.setRestClient(restClient);
    }

    @Test
    public void imageKit_configurationTest() {
        Configuration config=new Configuration();
        config.setPrivateKey("private_Key");
        config.setPublicKey("public_key");
        config.setUrlEndpoint("url_end_point");
        ImageKit.getInstance().setConfig(config);
        assertEquals(config.toString(),ImageKit.getInstance().getConfig().toString());
    }

    @Test
    public void getUrl_with_height_width_options() {
        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String,Object> options=new HashMap<>();
        options.put("path","/default-image.jpg");
        options.put("transformation",transformation);
        String url=SUT.getUrl(options);

        assertThat(SUT.getConfig().getUrlEndpoint()+"tr:w-400,h-600/default-image.jpg?ik-sdk-version="+ Version.VERSION_CODE,is(url));
    }

    @Test
    public void getUrl_with_height_width_options_url_version_check() {
        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);
        Map<String,Object> options=new HashMap<>();
        options.put("path","/default-image.jpg");
        options.put("transformation",transformation);
        String url=SUT.getUrl(options);
        assertThat(SUT.getConfig().getUrlEndpoint()+"tr:w-400,h-600/default-image.jpg?ik-sdk-version="+ Version.VERSION_CODE,is(url));
        assertTrue(url.contains("ik-sdk-version="+Version.VERSION_CODE));
    }

    @Test
    public void getUrl_with_new_transformation_params_options() {
        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);
        Map<String, String> newParams=new HashMap<>();
        newParams.put("myparam","40");
        transformation.add(newParams);

        Map<String,Object> options=new HashMap<>();
        options.put("path","/default-image.jpg");
        options.put("transformation",transformation);
        String url=SUT.getUrl(options);
        assertThat(SUT.getConfig().getUrlEndpoint()+"tr:w-400,h-600:myparam-40/default-image.jpg?ik-sdk-version="+ Version.VERSION_CODE,is(url));
    }

    @Test
    public void getUrl_with_slash_in_path() {
        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String,Object> options=new HashMap<>();
        options.put("path","/default-image.jpg");
        options.put("transformation",transformation);
        String url=SUT.getUrl(options);
        assertThat(SUT.getConfig().getUrlEndpoint()+"tr:w-400,h-600/default-image.jpg?ik-sdk-version="+ Version.VERSION_CODE,is(url));
    }

    @Test
    public void getUrl_without_slash_in_path() {
        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);
        Map<String,Object> options=new HashMap<>();
        options.put("path","default-image.jpg");
        options.put("transformation",transformation);
        String url=SUT.getUrl(options);
        assertThat(SUT.getConfig().getUrlEndpoint()+"tr:w-400,h-600/default-image.jpg?ik-sdk-version="+ Version.VERSION_CODE,is(url));
    }

    @Test
    public void getUrl_with_overriding_urlEndpoint() {
        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String,Object> options=new HashMap<>();
        options.put("path","/default-image.jpg");
        options.put("urlEndpoint","https://ik.imagekit.io/your_override_imagekit_id");
        options.put("transformation",transformation);

        String url=SUT.getUrl(options);
        assertThat("https://ik.imagekit.io/your_override_imagekit_id/tr:w-400,h-600/default-image.jpg?ik-sdk-version="+ Version.VERSION_CODE,is(url));
    }

    @Test
    public void getUrl_with_overriding_urlEndpoint_double_slash_tests() {
        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String,Object> options=new HashMap<>();
        options.put("path","/default-image.jpg");
        options.put("urlEndpoint","https://ik.imagekit.io/your_override_imagekit_id");
        options.put("transformation",transformation);

        String url=SUT.getUrl(options);
        assertThat("https://ik.imagekit.io/your_override_imagekit_id/tr:w-400,h-600/default-image.jpg?ik-sdk-version="+ Version.VERSION_CODE,is(url));
    }

    @Test
    public void getUrl_with_options_as_query() {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("v","123");

        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String, Object> options=new HashMap<>();
        options.put("path","/default-image.jpg");
        options.put("queryParameters",queryParams);
        options.put("transformation",transformation);
        options.put("transformationPosition","query");

        String url=SUT.getUrl(options);
        assertThat(SUT.getConfig().getUrlEndpoint()+"default-image.jpg?ik-sdk-version="+ Version.VERSION_CODE+"&v=123&tr=w-400,h-600",is(url));
    }

    @Test
    public void getUrl_with_options_as_path() {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("v","123");

        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String, Object> options=new HashMap<>();
        options.put("path","/default-image.jpg");
        options.put("queryParameters",queryParams);
        options.put("transformation",transformation);

        String url=SUT.getUrl(options);
        assertThat(SUT.getConfig().getUrlEndpoint()+"tr:w-400,h-600/default-image.jpg?ik-sdk-version="+ Version.VERSION_CODE+"&v=123",is(url));
    }

    @Test
    public void getUrl_with_chained_transformation_options_as_query() {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("v","123");

        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);
        Map<String, String> rotate=new HashMap<>();
        rotate.put("rotation","90");
        transformation.add(rotate);

        Map<String, Object> options=new HashMap<>();
        options.put("path","/default-image.jpg");
        options.put("queryParameters",queryParams);
        options.put("transformation",transformation);
        options.put("transformationPosition","query");

        String url=SUT.getUrl(options);
        assertThat(SUT.getConfig().getUrlEndpoint()+"default-image.jpg?ik-sdk-version="+ Version.VERSION_CODE+"&v=123&tr=w-400,h-600:rt-90",is(url));
    }

    @Test
    public void getUrl_with_chained_transformation_options_as_path() {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("v","123");

        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);
        Map<String, String> rotate=new HashMap<>();
        rotate.put("rotation","90");
        transformation.add(rotate);

        Map<String, Object> options=new HashMap<>();
        options.put("path","/default-image.jpg");
        options.put("queryParameters",queryParams);
        options.put("transformation",transformation);

        String url=SUT.getUrl(options);
        assertThat(SUT.getConfig().getUrlEndpoint()+"tr:w-400,h-600:rt-90/default-image.jpg?ik-sdk-version="+ Version.VERSION_CODE+"&v=123",is(url));
    }

    @Test
    public void getUrl_with_multiple_query_params_addition_check() {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("v","123");
        queryParams.put("z","234");

        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String, Object> options=new HashMap<>();
        options.put("src","https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?q=abc");
        options.put("queryParameters",queryParams);
        options.put("transformation",transformation);

        String url=SUT.getUrl(options);
        assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?ik-sdk-version="+Version.VERSION_CODE+"&q=abc&v=123&z=234&tr=w-400,h-600",is(url));
    }

    @Test
    public void getUrl_with_double_and_check() {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("v","123");
        queryParams.put("z","234");

        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String, Object> options=new HashMap<>();
        options.put("src","https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?q=abc&&");
        options.put("queryParameters",queryParams);
        options.put("transformation",transformation);

        String url=SUT.getUrl(options);
        assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?ik-sdk-version="+Version.VERSION_CODE+"&q=abc&v=123&z=234&tr=w-400,h-600",is(url));
    }

    @Test
    public void getUrl_with_double_question_mark_check() {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("v","123");
        queryParams.put("z","234");

        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String, Object> options=new HashMap<>();
        options.put("src","https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg??");
        options.put("queryParameters",queryParams);
        options.put("transformation",transformation);

        String url=SUT.getUrl(options);
        assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?ik-sdk-version="+Version.VERSION_CODE+"&v=123&z=234&tr=w-400,h-600",is(url));
    }

    @Test
    public void getUrl_with_src() {
        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String, Object> options=new HashMap<>();
        options.put("src","https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg");
        options.put("transformation",transformation);

        String url=SUT.getUrl(options);
        assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?ik-sdk-version="+Version.VERSION_CODE+"&tr=w-400,h-600",is(url));
    }

    @Test
    public void getUrl_src_with_query_params() {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("v","123");
        queryParams.put("z","234");

        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String, Object> options=new HashMap<>();
        options.put("src","https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?srcParam=srcParamValue");
        options.put("queryParameters",queryParams);
        options.put("transformation",transformation);

        String url=SUT.getUrl(options);
        assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?ik-sdk-version="+Version.VERSION_CODE+"&srcParam=srcParamValue&v=123&z=234&tr=w-400,h-600",is(url));
    }

    @Test
    public void getUrl_src_with_query_params_but_transformationPosition_is_path() {
        Map<String, String> queryParam=new HashMap<>();
        queryParam.put("v","123");
        queryParam.put("z","234");

        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);

        Map<String,Object> options=new HashMap<>();
        options.put("src","https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg");
        options.put("queryParameters",queryParam);
        options.put("transformation",transformation);
        options.put("transformationPosition","path");

        String url=SUT.getUrl(options);
        assertThat("https://ik.imagekit.io/your_imagekit_id/endpoint/default-image.jpg?ik-sdk-version="+Version.VERSION_CODE+"&v=123&z=234&tr=w-400,h-600",is(url));
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
        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);
        Map<String, String> rotate=new HashMap<>();
        rotate.put("rotation","90");
        transformation.add(rotate);

        Map<String, Object> options=new HashMap<>();
        options.put("path","/default-image.jpg");
        options.put("transformation",transformation);
        options.put("expireSeconds",100);
        options.put("signed",true);

        String url=SUT.getUrl(options);
        assertTrue(url.contains("ik-t"));
    }

    // Test Case for Upload

    @Test
    public void imageKit_upload_returnSuccess() throws IOException, InterruptedException {
        String imageUrl="https://homepages.cae.wisc.edu/~ece533/images/cat.png";
        URL url = URI.create(imageUrl).toURL();
        FileCreateRequest fileCreateRequest = new FileCreateRequest(url, "sample-cat-image.png");
        List<String> tags=new ArrayList<>();
        tags.add("Software");
        tags.add("Developer");
        tags.add("Engineer");
        fileCreateRequest.setTags(tags);
        fileCreateRequest.setFolder("demo1");
        String customCoordinates="10,10,20,20";
        fileCreateRequest.setCustomCoordinates(customCoordinates);

        List<String> responseFields=new ArrayList<>();
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
        fileCreateRequest.setOverwriteCustomMetadata(false);
        JsonObject jsonObjectCustomMetadata = new JsonObject();
        jsonObjectCustomMetadata.addProperty("test1", 10);
        fileCreateRequest.setCustomMetadata(jsonObjectCustomMetadata);

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\n" +
                "    \"fileId\": \"62a465d245a84a0ef3852968\",\n" +
                "    \"name\": \"sample-cat-image_GG0_X8GOn.jpg\",\n" +
                "    \"size\": 23023,\n" +
                "    \"versionInfo\": {\n" +
                "        \"id\": \"62a465d245a84a0ef3852968\",\n" +
                "        \"name\": \"Version 1\"\n" +
                "    },\n" +
                "    \"filePath\": \"/demo1/sample-cat-image_GG0_X8GOn.jpg\",\n" +
                "    \"url\": \"https://ik.imagekit.io/zv3rkhsym/demo1/sample-cat-image_GG0_X8GOn.jpg\",\n" +
                "    \"fileType\": \"image\",\n" +
                "    \"height\": 354,\n" +
                "    \"width\": 236,\n" +
                "    \"thumbnailUrl\": \"https://ik.imagekit.io/zv3rkhsym/tr:n-ik_ml_thumbnail/demo1/sample-cat-image_GG0_X8GOn.jpg\",\n" +
                "    \"AITags\": [\n" +
                "        {\n" +
                "            \"name\": \"Clothing\",\n" +
                "            \"confidence\": 98.77,\n" +
                "            \"source\": \"google-auto-tagging\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Plant\",\n" +
                "            \"confidence\": 96.51,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"extensionStatus\": {\n" +
                "        \"remove-bg\": \"pending\",\n" +
                "        \"google-auto-tagging\": \"success\"\n" +
                "    }\n" +
                "}"));
        server.start();
        RestClient.UPLOAD_BASE_URL = server.url("/").toString();
        SUT.upload(fileCreateRequest);
        RecordedRequest request = server.takeRequest();
        String json = "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"file\"\r\n" +
                "Content-Length: 53\r\n" +
                "\r\n" +
                "https://homepages.cae.wisc.edu/~ece533/images/cat.png\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"fileName\"\r\n" +
                "Content-Length: 20\r\n" +
                "\r\n" +
                "sample-cat-image.png\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"useUniqueFileName\"\r\n" +
                "Content-Length: 5\r\n" +
                "\r\n" +
                "false\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"tags\"\r\n" +
                "Content-Length: 27\r\n" +
                "\r\n" +
                "Software,Developer,Engineer\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"folder\"\r\n" +
                "Content-Length: 5\r\n" +
                "\r\n" +
                "demo1\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"customCoordinates\"\r\n" +
                "Content-Length: 11\r\n" +
                "\r\n" +
                "10,10,20,20\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"responseFields\"\r\n" +
                "Content-Length: 32\r\n" +
                "\r\n" +
                "thumbnail,tags,customCoordinates\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"overwriteFile\"\r\n" +
                "Content-Length: 4\r\n" +
                "\r\n" +
                "true\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"overwriteAITags\"\r\n" +
                "Content-Length: 4\r\n" +
                "\r\n" +
                "true\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"overwriteTags\"\r\n" +
                "Content-Length: 4\r\n" +
                "\r\n" +
                "true\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"overwriteCustomMetadata\"\r\n" +
                "Content-Length: 4\r\n" +
                "\r\n" +
                "true\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"extensions\"\r\n" +
                "Content-Length: 114\r\n" +
                "\r\n" +
                "[{\"name\":\"remove-bg\",\"options\":{\"add_shadow\":true}},{\"name\":\"google-auto-tagging\",\"minConfidence\":10,\"maxTags\":5}]\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"webhookUrl\"\r\n" +
                "Content-Length: 57\r\n" +
                "\r\n" +
                "https://webhook.site/c78d617f-33bc-40d9-9e61-608999721e2e\r\n" +
                "--boundary\r\n" +
                "Content-Disposition: form-data; name=\"customMetadata\"\r\n" +
                "Content-Length: 12\r\n" +
                "\r\n" +
                "{\"test1\":10}\r\n" +
                "--boundary--";
        assertEquals(json, request.getBody().readUtf8().trim());
//        System.out.println("request.getBody().readUtf8().trim():==> " + request.getBody().readUtf8().trim());
        assertEquals("POST /api/v1/files/upload HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.UPLOAD_BASE_URL.concat("api/v1/files/upload"),  request.getRequestUrl().toString());
    }

    @Test
    public void imageKit_updateDetails_returnTrue() {
        FileUpdateRequest fileUpdateRequest=new FileUpdateRequest("file_id");
        Result result=new Result();
        result.setSuccessful(true);
        when(restClient.updateDetail(any(FileUpdateRequest.class))).thenReturn(result);

        Result result1=SUT.updateFileDetail(fileUpdateRequest);
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
    }

    @Test(expected = NullPointerException.class)
    public void imageKit_updateDetails_throwException() {
        FileUpdateRequest fileUpdateRequest=new FileUpdateRequest("file_id");
        Result result=new Result();
        result.setSuccessful(true);
        when(restClient.updateDetail(any(FileUpdateRequest.class))).thenThrow(new NullPointerException());

        Result result1=SUT.updateFileDetail(fileUpdateRequest);
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
    }

    @Test
    public void imageKit_getFileList_returnList() {
        ResultList resultList=new ResultList();
        List<BaseFile> list= new ArrayList<>(10);
        resultList.setResults(list);
        when(restClient.getFileList(any())).thenReturn(resultList);

        Map<String , String> options=new HashMap<>();
        options.put("skip","0");
        options.put("limit", "10");

        ResultList resultList1=SUT.getFileList(options);
        assertThat(resultList1.getResults().size(),is(resultList.getResults().size()));
    }

    @Test
    public void imageKit_getFileDetail_successExpected() {
        Result result=new Result();
        result.setSuccessful(true);
        when(restClient.getFileDetail(any(String.class))).thenReturn(result);

        Result result1=SUT.getFileDetail("fileId");
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
    }

    @Test
    public void imageKit_getFileMetaData_successExpected() {
        ResultMetaData result=new ResultMetaData();
        result.setSuccessful(true);
        when(restClient.getFileMetaData(any(String.class))).thenReturn(result);

        ResultMetaData result1=SUT.getFileMetadata("fileId");
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
    }

    @Test
    public void imageKit_getRemoteFileMetaData_successExpected() {
        ResultMetaData result=new ResultMetaData();
        result.setSuccessful(true);
        when(restClient.getRemoteFileMetaData(any(String.class))).thenReturn(result);

        ResultMetaData result1=SUT.getRemoteFileMetadata("remote_url");
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
    }

    @Test
    public void imageKit_deleteFile_successExpected() {
        Result result=new Result();
        result.setSuccessful(true);
        when(restClient.deleteFile(any(String.class))).thenReturn(result);

        Result result1=SUT.deleteFile("fileId");
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
    }

    @Test
    public void imageKit_bulkDeleteFiles_successExpected() {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("file_id_1");
        fileIds.add("file_id_2");
        fileIds.add("file_id_3");

        ResultFileDelete result=new ResultFileDelete();
        result.setSuccessfullyDeletedFileIds(fileIds);
        result.setSuccessful(true);
        when(restClient.bulkDeleteFiles(any())).thenReturn(result);
        ResultFileDelete result1=SUT.bulkDeleteFiles(fileIds);
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
    }

    @Test
    public void imageKit_purgeCache_successExpected() {
        ResultCache result=new ResultCache();
        result.setSuccessful(true);
        result.setRequestId("requestId");
        when(restClient.purgeCache(any(String.class))).thenReturn(result);

        ResultCache result1=SUT.purgeCache("fileId");
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
        assertThat(result1.getRequestId(),is(result.getRequestId()));
    }

    @Test
    public void imageKit_getPurgeCacheStatus_successExpected() {
        ResultCacheStatus result=new ResultCacheStatus();
        result.setSuccessful(true);
        result.setStatus("Complete");
        when(restClient.getPurgeCacheStatus(any(String.class))).thenReturn(result);

        ResultCacheStatus result1=SUT.getPurgeCacheStatus("requestId");
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
        assertThat(result1.getStatus(),is(result.getStatus()));
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
        Map<String, String> auth = SUT.getAuthenticationParameters("your_token",1582269249);
        assertNotNull(auth);
        assertEquals("your_token",auth.get("token"));
        assertEquals("1582269249",auth.get("expire"));
        assertEquals("e71bcd6031016b060d349d212e23e85c791decdd",auth.get("signature"));
    }

    @Test
    public void sameImage_getHammingDistance_expectedSuccessWith() {
        int hammingDistance = SUT.pHashDistance("f06830ca9f1e3e90", "f06830ca9f1e3e90");
        assertEquals(0,hammingDistance);
    }

    @Test
    public void similarImage_getHammingDistance_expectedSuccessWith() {
        int hammingDistance = SUT.pHashDistance("33699c96619cc69e", "968e978414fe04ea");
        assertEquals(30,hammingDistance);
    }

    @Test
    public void dissimilarImage_getHammingDistance_expectedSuccessWith() {
        int hammingDistance = SUT.pHashDistance("a4a65595ac94518b", "7838873e791f8400");
        assertEquals(37,hammingDistance);
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

    @Test
    public void add_tags_expectedSuccessWith() throws IOException, InterruptedException {

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
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/addTags"),  request.getRequestUrl().toString());
    }

    @Test
    public void remove_tags_expectedSuccessWith() throws IOException, InterruptedException {

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
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/removeTags"),  request.getRequestUrl().toString());
    }

    @Test
    public void get_custom_metadata_fields_expectedSuccessWith() throws IOException, InterruptedException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("[\n" +
                "    {\n" +
                "        \"id\": \"6291f00890ba008cc27f64d1\",\n" +
                "        \"name\": \"price\",\n" +
                "        \"label\": \"Amount\",\n" +
                "        \"schema\": {\n" +
                "            \"minValue\": 10,\n" +
                "            \"maxValue\": 200,\n" +
                "            \"type\": \"Number\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"6296f91191fa57ccc36b15cf\",\n" +
                "        \"name\": \"Amount2\",\n" +
                "        \"label\": \"Amouunt\",\n" +
                "        \"schema\": {\n" +
                "            \"type\": \"Number\",\n" +
                "            \"minValue\": 10,\n" +
                "            \"maxValue\": 1000\n" +
                "        }\n" +
                "    }\n" +
                "]"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getCustomMetaDataFields();
        RecordedRequest request = server.takeRequest();
        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("GET /v1/customMetadataFields HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields"),  request.getRequestUrl().toString());
    }

    @Test
    public void createCustomMetaDataFields_successExpected() throws InterruptedException, IOException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\n" +
                "    \"id\": \"629f2e2f7eb0fe2eb25f9988\",\n" +
                "    \"name\": \"test1\",\n" +
                "    \"label\": \"test1\",\n" +
                "    \"schema\": {\n" +
                "        \"type\": \"Number\",\n" +
                "        \"isValueRequired\": false,\n" +
                "        \"minValue\": 10,\n" +
                "        \"maxValue\": 1000\n" +
                "    }\n" +
                "}"));
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
        assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields"),  request.getRequestUrl().toString());
    }

    @Test
    public void deleteCustomMetaDataField_successExpected() throws IOException, InterruptedException {
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
        assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields/629f2e2f7eb0fe2eb25f9988"),  request.getRequestUrl().toString());
    }

    @Test
    public void updateCustomMetaDataFields_successExpected() throws InterruptedException, IOException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\n" +
                "    \"id\": \"6296fd7091fa5768106b808d\",\n" +
                "    \"name\": \"Amount3\",\n" +
                "    \"label\": \"testPrices\",\n" +
                "    \"schema\": {\n" +
                "        \"minValue\": 0,\n" +
                "        \"maxValue\": 10,\n" +
                "        \"type\": \"Number\"\n" +
                "    }\n" +
                "}"));
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
        assertEquals(RestClient.API_BASE_URL.concat("v1/customMetadataFields/628f189d4e4ea318b69efa9d"),  request.getRequestUrl().toString());
    }

    @Test
    public void removeAITags_successExpected() throws InterruptedException, IOException {

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
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/removeAITags"),  request.getRequestUrl().toString());
    }

    @Test
    public void copyFile_successExpected() throws InterruptedException, IOException {

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
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/copy"),  request.getRequestUrl().toString());
    }

    @Test
    public void moveFile_successExpected() throws InterruptedException, IOException {

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
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/move"),  request.getRequestUrl().toString());
    }

    @Test
    public void renameFile_successExpected() throws InterruptedException, IOException {

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
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/rename"),  request.getRequestUrl().toString());
    }

    @Test
    public void createFolder_successExpected() throws InterruptedException, IOException {

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
        assertEquals(RestClient.API_BASE_URL.concat("v1/folder/"),  request.getRequestUrl().toString());
    }

    @Test
    public void deleteFolder_successExpected() throws InterruptedException, IOException {

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
        assertEquals(RestClient.API_BASE_URL.concat("v1/folder/"),  request.getRequestUrl().toString());
    }

    @Test
    public void copyFolder_successExpected() throws InterruptedException, IOException {

        CopyFolderRequest copyFolderRequest = new CopyFolderRequest();
        copyFolderRequest.setSourceFolderPath("/testFolder");
        copyFolderRequest.setDestinationPath("/Gallery");
        copyFolderRequest.setIncludeVersions(true);

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\n" +
                "    \"jobId\": \"629f43017eb0feff5c61f83c\"\n" +
                "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.copyFolder(copyFolderRequest);
        RecordedRequest request = server.takeRequest();

        String copyFolderRequestJson = "{\"sourceFolderPath\":\"/testFolder\",\"destinationPath\":\"/Gallery\",\"includeVersions\":true}";
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals(copyFolderRequestJson, utf8RequestBody);
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals("POST /v1/bulkJobs/moveFolder HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/bulkJobs/moveFolder"),  request.getRequestUrl().toString());
    }

    @Test
    public void moveFolder_successExpected() throws InterruptedException, IOException {

        MoveFolderRequest moveFolderRequest = new MoveFolderRequest();
        moveFolderRequest.setSourceFolderPath("/testFolder");
        moveFolderRequest.setDestinationPath("/Gallery");

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\n" +
                "    \"jobId\": \"629f44ac7eb0fe8173622d4b\"\n" +
                "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.moveFolder(moveFolderRequest);
        RecordedRequest request = server.takeRequest();

        String moveFolderRequestJson = "{\"sourceFolderPath\":\"/testFolder\",\"destinationPath\":\"/Gallery\"}";
        String utf8RequestBody = request.getBody().readUtf8();
        assertEquals(moveFolderRequestJson, utf8RequestBody);
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals("POST /v1/bulkJobs/moveFolder HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/bulkJobs/moveFolder"),  request.getRequestUrl().toString());
    }

    @Test
    public void getBulkJobStatus_successExpected() throws InterruptedException, IOException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\n" +
                "    \"jobId\": \"629f44ac7eb0fe8173622d4b\",\n" +
                "    \"type\": \"MOVE_FOLDER\",\n" +
                "    \"status\": \"Completed\"\n" +
                "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getBulkJobStatus("629f44ac7eb0fe8173622d4b");
        RecordedRequest request = server.takeRequest();

        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("GET /v1/bulkJobs/629f44ac7eb0fe8173622d4b HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/bulkJobs/629f44ac7eb0fe8173622d4b"),  request.getRequestUrl().toString());
    }

    @Test
    public void getFileVersions_successExpected() throws InterruptedException, IOException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("[\n" +
                "    {\n" +
                "        \"type\": \"file\",\n" +
                "        \"name\": \"w2_image.png\",\n" +
                "        \"createdAt\": \"2022-06-07T12:00:33.825Z\",\n" +
                "        \"updatedAt\": \"2022-06-07T12:00:33.828Z\",\n" +
                "        \"fileId\": \"629f3de17eb0fe4053615450\",\n" +
                "        \"tags\": [\n" +
                "            \"tag10\"\n" +
                "        ],\n" +
                "        \"AITags\": [\n" +
                "            {\n" +
                "                \"name\": \"Colorfulness\",\n" +
                "                \"confidence\": 96.19,\n" +
                "                \"source\": \"google-auto-tagging\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Purple\",\n" +
                "                \"confidence\": 86.05,\n" +
                "                \"source\": \"google-auto-tagging\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Violet\",\n" +
                "                \"confidence\": 81.08,\n" +
                "                \"source\": \"google-auto-tagging\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Rectangle\",\n" +
                "                \"confidence\": 80.99,\n" +
                "                \"source\": \"google-auto-tagging\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"versionInfo\": {\n" +
                "            \"id\": \"629f3de17eb0fe4053615450\",\n" +
                "            \"name\": \"Version 1\"\n" +
                "        },\n" +
                "        \"embeddedMetadata\": {\n" +
                "            \"DateCreated\": \"2022-05-26T06:05:18.087Z\",\n" +
                "            \"ImageWidth\": 1006,\n" +
                "            \"ImageHeight\": 467,\n" +
                "            \"DateTimeCreated\": \"2022-05-26T06:05:18.088Z\"\n" +
                "        },\n" +
                "        \"customCoordinates\": null,\n" +
                "        \"customMetadata\": {},\n" +
                "        \"isPrivateFile\": false,\n" +
                "        \"url\": \"https://ik.imagekit.io/xyxt2lnil/w2_image.png\",\n" +
                "        \"thumbnail\": \"https://ik.imagekit.io/xyxt2lnil/tr:n-ik_ml_thumbnail/w2_image.png\",\n" +
                "        \"fileType\": \"image\",\n" +
                "        \"filePath\": \"/w2_image.png\",\n" +
                "        \"height\": 467,\n" +
                "        \"width\": 1006,\n" +
                "        \"size\": 47579,\n" +
                "        \"hasAlpha\": true,\n" +
                "        \"mime\": \"image/png\"\n" +
                "    }\n" +
                "]"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getFileVersions("629f3de17eb0fe4053615450");
        RecordedRequest request = server.takeRequest();

        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("GET /v1/files/629f3de17eb0fe4053615450/versions HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/629f3de17eb0fe4053615450/versions"),  request.getRequestUrl().toString());
    }

    @Test
    public void getFileVersionDetails_successExpected() throws InterruptedException, IOException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("{\n" +
                "    \"type\": \"file\",\n" +
                "    \"name\": \"w2_image.png\",\n" +
                "    \"createdAt\": \"2022-06-07T12:00:33.825Z\",\n" +
                "    \"updatedAt\": \"2022-06-07T12:00:33.828Z\",\n" +
                "    \"fileId\": \"629f3de17eb0fe4053615450\",\n" +
                "    \"tags\": [\n" +
                "        \"tag10\"\n" +
                "    ],\n" +
                "    \"AITags\": [\n" +
                "        {\n" +
                "            \"name\": \"Colorfulness\",\n" +
                "            \"confidence\": 96.19,\n" +
                "            \"source\": \"google-auto-tagging\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Purple\",\n" +
                "            \"confidence\": 86.05,\n" +
                "            \"source\": \"google-auto-tagging\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Violet\",\n" +
                "            \"confidence\": 81.08,\n" +
                "            \"source\": \"google-auto-tagging\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Rectangle\",\n" +
                "            \"confidence\": 80.99,\n" +
                "            \"source\": \"google-auto-tagging\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"versionInfo\": {\n" +
                "        \"id\": \"629f3de17eb0fe4053615450\",\n" +
                "        \"name\": \"Version 1\"\n" +
                "    },\n" +
                "    \"embeddedMetadata\": {\n" +
                "        \"DateCreated\": \"2022-05-26T06:05:18.087Z\",\n" +
                "        \"ImageWidth\": 1006,\n" +
                "        \"ImageHeight\": 467,\n" +
                "        \"DateTimeCreated\": \"2022-05-26T06:05:18.088Z\"\n" +
                "    },\n" +
                "    \"customCoordinates\": null,\n" +
                "    \"customMetadata\": {},\n" +
                "    \"isPrivateFile\": false,\n" +
                "    \"url\": \"https://ik.imagekit.io/xyxt2lnil/w2_image.png\",\n" +
                "    \"thumbnail\": \"https://ik.imagekit.io/xyxt2lnil/tr:n-ik_ml_thumbnail/w2_image.png\",\n" +
                "    \"fileType\": \"image\",\n" +
                "    \"filePath\": \"/w2_image.png\",\n" +
                "    \"height\": 467,\n" +
                "    \"width\": 1006,\n" +
                "    \"size\": 47579,\n" +
                "    \"hasAlpha\": true,\n" +
                "    \"mime\": \"image/png\"\n" +
                "}"));
        server.start();
        RestClient.API_BASE_URL = server.url("/").toString();
        SUT.getFileVersionDetails("629f3de17eb0fe4053615450", "629f3de17eb0fe4053615450");
        RecordedRequest request = server.takeRequest();

        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("GET /v1/files/629f3de17eb0fe4053615450/versions/629f3de17eb0fe4053615450 HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/629f3de17eb0fe4053615450/versions/629f3de17eb0fe4053615450"),  request.getRequestUrl().toString());
    }

    @Test
    public void deleteFileVersion_expectedSuccessWith() throws IOException, InterruptedException {

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
        assertEquals("DELETE /v1/files/629d90768482ba272ed17628/versions/629d91878482bae8bed177f2 HTTP/1.1", request.getRequestLine());
        assertEquals(RestClient.API_BASE_URL.concat("v1/files/629d90768482ba272ed17628/versions/629d91878482bae8bed177f2"),  request.getRequestUrl().toString());
    }



}