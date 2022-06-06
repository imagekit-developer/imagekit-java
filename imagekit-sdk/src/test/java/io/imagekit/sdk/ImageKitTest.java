package io.imagekit.sdk;

import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.constants.Version;
import io.imagekit.sdk.models.BaseFile;
import io.imagekit.sdk.models.CustomMetaDataFieldCreateRequest;
import io.imagekit.sdk.models.CustomMetaDataFieldSchemaObject;
import io.imagekit.sdk.models.CustomMetaDataFieldUpdateRequest;
import io.imagekit.sdk.models.CustomMetaDataTypeEnum;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.FileUpdateRequest;
import io.imagekit.sdk.models.TagsRequest;
import io.imagekit.sdk.models.results.*;
import io.imagekit.sdk.tasks.RestClient;
import io.imagekit.sdk.utils.Utils;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

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
    public void imageKit_upload_returnSuccess() {
        FileCreateRequest fileCreateRequest =mock(FileCreateRequest.class);
        Result result=new Result();
        result.setSuccessful(true);
        result.setFilePath("/myfile.jpg");
        when(restClient.upload(any(FileCreateRequest.class))).thenReturn(result);
        Result result1 = SUT.upload(fileCreateRequest);
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
    }

    @Test
    public void imageKit_imageUpload_returnFalse() {
        FileCreateRequest fileCreateRequest =mock(FileCreateRequest.class);
        Result result=new Result();
        result.setSuccessful(false);
        when(restClient.upload(any(FileCreateRequest.class))).thenReturn(result);
        Result result1 = SUT.upload(fileCreateRequest);
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
    }

    @Test(expected = RuntimeException.class)
    public void imageKit_imageUpload_throwNetworkException() {
        FileCreateRequest fileCreateRequest =mock(FileCreateRequest.class);
        Result result=new Result();
        result.setSuccessful(false);
        when(restClient.upload(any(FileCreateRequest.class))).thenThrow(new RuntimeException());
        Result result1 = SUT.upload(fileCreateRequest);
        assertThat(result1.isSuccessful(),is(result.isSuccessful()));
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
        HttpUrl baseUrl = server.url("/");
        Configuration config = SUT.getConfig();
        config.setUrlEndpoint(String.valueOf(baseUrl));
        SUT.setConfig(config);
        SUT.addTags(tagsRequest);
        RecordedRequest request1 = server.takeRequest();
        assertEquals("application/json; charset=utf-8", request1.getHeader("Content-Type"));
    }

    @Test
    public void remove_tags_expectedSuccessWith() {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("62958deef33aa80bdadf7533");
        List<String> tags = new ArrayList<>();
        tags.add("tag1");

        TagsRequest tagsRequest = new TagsRequest(fileIds, tags);

        Result mockResult=new Result();
        mockResult.setSuccessful(true);
        mockResult.setMessage("Removed Tags SuccessFully.");
        mockResult.getResponseMetaData().setHttpStatusCode(200);
        when(restClient.manageTags(tagsRequest, "removeTags")).thenReturn(mockResult);

        Result result = SUT.removeTags(tagsRequest);
        assertTrue(result.isSuccessful());
        assertEquals(result.getResponseMetaData().getHttpStatusCode(), 200);
        assertEquals(mockResult.getMessage(), "Removed Tags SuccessFully.");
    }

    @Test
    public void get_custom_metadata_fields_expectedSuccessWith() {
        CustomMetaDataFieldSchemaObject mockCustomMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
        mockCustomMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Number);
        mockCustomMetaDataFieldSchemaObject.setDefaultValue("defaultValue");
        mockCustomMetaDataFieldSchemaObject.setMinLength(10);
        mockCustomMetaDataFieldSchemaObject.setMaxLength(10);

        Result mockResult=new Result();
        mockResult.setSuccessful(true);
        mockResult.setMessage("Fetched CustomMetaData SuccessFully.");
        mockResult.getResponseMetaData().setHttpStatusCode(200);

        when(restClient.getCustomMetaDataFields()).thenReturn(mockResult);

        Result result = SUT.getCustomMetaDataFields();
        assertTrue(result.isSuccessful());
        assertEquals(result.getResponseMetaData().getHttpStatusCode(), 200);
        assertEquals(mockResult.getMessage(), "Fetched CustomMetaData SuccessFully.");
    }

    @Test
    public void createCustomMetaDataFields_successExpected() {
        CustomMetaDataFieldSchemaObject mockCustomMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
        mockCustomMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Number);
        mockCustomMetaDataFieldSchemaObject.setMinValue(10);
        mockCustomMetaDataFieldSchemaObject.setMaxValue(100);

        CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
        customMetaDataFieldCreateRequest.setName("mockName");
        customMetaDataFieldCreateRequest.setLabel("mockLabel");
        customMetaDataFieldCreateRequest.setSchema(mockCustomMetaDataFieldSchemaObject);

        Result mockResult = new Result();
        mockResult.setSuccessful(true);
        mockResult.setMessage("CustomMetaData created...");
        mockResult.getResponseMetaData().setHttpStatusCode(200);

        when(restClient.createCustomMetaDataFields(customMetaDataFieldCreateRequest)).thenReturn(mockResult);

        Result result=SUT.createCustomMetaDataFields(customMetaDataFieldCreateRequest);
        assertThat(result.isSuccessful(),is(mockResult.isSuccessful()));
        assertEquals(result.getResponseMetaData().getHttpStatusCode(), mockResult.getResponseMetaData().getHttpStatusCode());
        assertEquals(result.getMessage(), mockResult.getMessage());
    }

    @Test
    public void deleteCustomMetaDataField_successExpected() {
        Result mockResult=new Result();
        mockResult.setSuccessful(true);
        mockResult.getResponseMetaData().setHttpStatusCode(204);
        when(restClient.deleteCustomMetaDataField(any(String.class))).thenReturn(mockResult);

        Result result=SUT.deleteCustomMetaDataField("id");
        assertThat(result.isSuccessful(),is(mockResult.isSuccessful()));
        assertEquals(result.getResponseMetaData().getHttpStatusCode(), 204);
    }

    @Test
    public void updateCustomMetaDataFields_successExpected() {
        CustomMetaDataFieldSchemaObject mockCustomMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
        mockCustomMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Number);
        mockCustomMetaDataFieldSchemaObject.setMinValue(10);
        mockCustomMetaDataFieldSchemaObject.setMaxValue(100);

        CustomMetaDataFieldUpdateRequest customMetaDataFieldUpdateRequest = new CustomMetaDataFieldUpdateRequest();
        customMetaDataFieldUpdateRequest.setId("6296fd7091fa5768106b808d");
        customMetaDataFieldUpdateRequest.setLabel("mockEditLabel");
        customMetaDataFieldUpdateRequest.setSchema(mockCustomMetaDataFieldSchemaObject);

        Result mockResult = new Result();
        mockResult.setSuccessful(true);
        mockResult.setMessage("CustomMetaData updated...");
        mockResult.getResponseMetaData().setHttpStatusCode(200);

        when(restClient.updateCustomMetaDataFields(customMetaDataFieldUpdateRequest)).thenReturn(mockResult);

        Result result=SUT.updateCustomMetaDataFields(customMetaDataFieldUpdateRequest);
        assertThat(result.isSuccessful(),is(mockResult.isSuccessful()));
        assertEquals(result.getResponseMetaData().getHttpStatusCode(), mockResult.getResponseMetaData().getHttpStatusCode());
        assertEquals(result.getMessage(), mockResult.getMessage());
    }
}