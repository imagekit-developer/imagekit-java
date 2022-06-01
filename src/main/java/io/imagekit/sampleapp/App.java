package io.imagekit.sampleapp;


import com.google.gson.Gson;
import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.models.BaseFile;
import io.imagekit.sdk.models.CustomMetaDataFieldRequest;
import io.imagekit.sdk.models.CustomMetaDataFieldSchemaObject;
import io.imagekit.sdk.models.CustomMetaDataTypeEnum;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.FileUpdateRequest;
import io.imagekit.sdk.models.TagsRequest;
import io.imagekit.sdk.models.results.*;
import io.imagekit.sdk.tasks.UrlGen;
import io.imagekit.sdk.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

class App{
    public static void main(String[] args) throws Exception{
        ImageKit imageKit=ImageKit.getInstance();
        //getSystemConfig(Class<?> cls) method need current class as parameter
        Configuration config = Utils.getSystemConfig(App.class);
        imageKit.setConfig(config);

//        uploadFromURL();
//        uploadFromBase64();
//        uploadFromBytes();
        addTags();
//        removeTags();
        createCustomMetaDataFields();
//        deleteCustomMetaDataField("6296138e91fa57897758dc37");
//        getCustomMetaDataFields();
//
//        calculateDistance();
//        generatingAuthParams();
//
//        List<BaseFile> files=getList(0,10);
//        if(null!=files && files.size()>0){
//            getFileDetail(files.get(0).getFileId());
//            getFileMetaData(files.get(0).getFileId());
//            getRemoteFileMetaData(files.get(1).getUrl());
//            updateDetails(files.get(0).getFileId());
//            ResultCache resultCache = purgeCache(files.get(0).getUrl());
//            getPurgeCacheStatus(resultCache.getRequestId());
//            generateUrl(files.get(0));
//
//    //        System.out.println(Color.ANSI_CYAN+"Do you want to delete uploaded files? (yes/No): "+Color.ANSI_BLUE);
//    //        String choice=new Scanner(System.in).nextLine();
//    //        if (!"yes".equalsIgnoreCase(choice.trim().toLowerCase())){
//    //            System.exit(0);
//    //        }
//             System.out.println(Color.ANSI_RESET);
//            deleteFile(files.get(0).getFileId());
//            files.remove(0);
//            deleteFiles(files);
//        }
        
        System.exit(0);
    }

    private static void generatingAuthParams() {
        System.out.println(Color.ANSI_CYAN+">> Generating Authentication Parameters:"+Color.ANSI_RESET);
        Map<String, String> authenticationParameters = ImageKit.getInstance().getAuthenticationParameters();
        System.out.println(Color.ANSI_GREEN+">> Results:"+Color.ANSI_RESET);
        System.out.println(authenticationParameters);
        System.out.println("\n\n");
    }

    private static void generateUrl(BaseFile baseFile) {
        System.out.println(Color.ANSI_CYAN+">> URL Generation:"+Color.ANSI_RESET);
//        String urlEndpoint=ImageKit.getInstance().getConfig().getUrlEndpoint();
        String urlEndpoint="https://ik.imagekit.io/bowstring/";

        Map<String, String> queryParam=new HashMap<>();
        queryParam.put("v","123");

        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","600");
        scale.put("width","400");
        transformation.add(scale);
        Map<String, String> rotate=new HashMap<>();
        rotate.put("rotation","90");
        transformation.add(rotate);

        Map<String, String> format=new HashMap<>();
        format.put("format","jpg");
        format.put("progressive","true");
        format.put("effectSharpen","-");
        format.put("effectContrast","1");
        format.put("blur","5%");

        transformation.add(format);


        Map<String, Object> options=new HashMap();
        options.put("path",baseFile.getFilePath());
        options.put("transformation", transformation);

        String url1=ImageKit.getInstance().getUrl(options);

        options.clear();
        options.put("path",baseFile.getFilePath());
        options.put("urlEndpoint",urlEndpoint);
        options.put("queryParameters",queryParam);
        options.put("transformation", transformation);
        options.put("transformationPosition", "query");
        options.put("signed",true);
        options.put("expireSeconds",10);

        String url2 = ImageKit.getInstance().getUrl(options);

        options.remove("transformationPosition");
        String url3 = ImageKit.getInstance().getUrl(options);

        options.clear();
        options.put("src",baseFile.getUrl());
        options.put("queryParameters",queryParam);
        options.put("transformation",transformation);

        String url4 = ImageKit.getInstance().getUrl(options);


        System.out.println(">> Generated URL #1:\t"+url1);
        System.out.println(">> Generated URL #2:\t"+url2);
        System.out.println(">> Generated URL #3:\t"+url3);
        System.out.println(">> Generated URL #4:\t"+url4);
        System.out.println("\n\n");
    }

    private static void calculateDistance() {
        System.out.println(Color.ANSI_CYAN+">> Calculating pHash Distance:"+Color.ANSI_RESET);
        int d1 = ImageKit.getInstance().pHashDistance("f06830ca9f1e3e90", "f06830ca9f1e3e90");
        System.out.println(">> Distance 1: "+d1);
        // output: 0 (same images)

        int d2 = ImageKit.getInstance().pHashDistance("2d5ad3936d2e015b", "2d6ed293db36a4fb");
        System.out.println(">> Distance 2: "+d2);
        // output: 17 (similar images)

        int d3 = ImageKit.getInstance().pHashDistance("a4a65595ac94518b", "7838873e791f8400");
        System.out.println(">> Distance 3: "+d3);
        // output: 37 (dissimilar images)
        System.out.println("\n\n");
    }


    private static void getPurgeCacheStatus(String requestId) {
        System.out.println(Color.ANSI_CYAN+">> Fetching cache status:"+Color.ANSI_RESET);
        System.out.println(">> Sending request...");
        ResultCacheStatus result=ImageKit.getInstance().getPurgeCacheStatus(requestId);
        System.out.println(">> Request complete...");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
    }

    private static ResultCache purgeCache(String filePath) {
        System.out.println(Color.ANSI_CYAN+">> Purging cache:"+Color.ANSI_RESET);
        System.out.println(">> Sending request...");
        ResultCache result=ImageKit.getInstance().purgeCache(filePath);
        System.out.println(">> Request complete...");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
        return result;
    }

    private static void deleteFile(String fileId) {
        System.out.println(Color.ANSI_CYAN+">> Deleting file:"+Color.ANSI_RESET);
        System.out.println(">> Sending file id: "+fileId);
        Result result=ImageKit.getInstance().deleteFile(fileId);
        System.out.println(">> File deleted...");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
    }

    private static void deleteFiles(List<BaseFile> files) {
        List<String> fileIds=files.stream().map(baseFile -> baseFile.getFileId()).collect(Collectors.toList());
        System.out.println(Color.ANSI_CYAN+">> Deleting file:"+Color.ANSI_RESET);
        System.out.println(">> Sending file id: "+fileIds);
        ResultFileDelete result=ImageKit.getInstance().bulkDeleteFiles(fileIds);
        System.out.println(">> File deleted...");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
    }

    private static void updateDetails(String fileId) {
        System.out.println(Color.ANSI_CYAN+">> Updating file details:"+Color.ANSI_RESET);
        System.out.println(">> Updating file details...");
        List<String> tags=new ArrayList<>();
        tags.add("Software");
        tags.add("Developer");
        tags.add("Engineer");
        FileUpdateRequest fileUpdateRequest =new FileUpdateRequest(fileId);
        fileUpdateRequest.setTags(tags);
        fileUpdateRequest.setCustomCoordinates("10,10,40,40");
        Result result=ImageKit.getInstance().updateFileDetail(fileUpdateRequest);
        System.out.println(">> Updating done...");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
    }

    private static void getFileMetaData(String fileId) {
        System.out.println(Color.ANSI_CYAN+">> Get file Metadata:"+Color.ANSI_RESET);
        System.out.println(">> Fetching Metadata...");
        ResultMetaData result=ImageKit.getInstance().getFileMetadata(fileId);
        System.out.println(">> Fetching done...");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
    }

    private static void getRemoteFileMetaData(String url) {
        System.out.println(Color.ANSI_CYAN+">> Get Remote file Metadata:"+Color.ANSI_RESET);
        System.out.println(">> Fetching Metadata...");
        ResultMetaData result=ImageKit.getInstance().getRemoteFileMetadata(url);
        System.out.println(">> Fetching done...");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
    }

    private static void getFileDetail(String fileId) {
        System.out.println(Color.ANSI_CYAN+">> Get file details:"+Color.ANSI_RESET);
        System.out.println(">> Fetching details...");
        Result result=ImageKit.getInstance().getFileDetail(fileId);
        System.out.println(">> Fetching done...");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
    }

    private static List<BaseFile> getList(int skip, int limit) {
        System.out.println(Color.ANSI_CYAN+">> Get Uploaded file as List:"+Color.ANSI_RESET);
        System.out.println(">> Fetching list...");
        Map<String , String> options=new HashMap<>();
        options.put("skip",""+skip);
        options.put("limit", ""+limit);
        ResultList resultList=ImageKit.getInstance().getFileList(options);
        System.out.println(">> Fetching done...");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(">> No. of files in server: "+resultList.getResults().size());
        System.out.println(">> FileIds: "+resultList.getResults().stream().map(baseFile -> baseFile.getFileId()).collect(Collectors.toList()));
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(resultList.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultList.getMap());
        System.out.println("\n\n");
        return resultList.getResults();
    }

    private static void uploadFromURL() {
        System.out.println(Color.ANSI_CYAN+">> Uploading from URL:"+Color.ANSI_RESET);
        System.out.println(">> Start uploading...");
        String imageUrl="https://homepages.cae.wisc.edu/~ece533/images/cat.png";
        URL url= null;
        try {
            url = URI.create(imageUrl).toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        FileCreateRequest fileCreateRequest = new FileCreateRequest(url, "sample-image.jpg");
        fileCreateRequest.setFolder("demo1");
        String customCoordinates="10,10,20,20";
        fileCreateRequest.setCustomCoordinates(customCoordinates);
        List<String> tags=new ArrayList<>();
        tags.add("Software");
        tags.add("Developer");
        tags.add("Engineer");
        fileCreateRequest.setTags(tags);

        List<String> responseFields=new ArrayList<>();
        responseFields.add("thumbnail");
        responseFields.add("tags");
        responseFields.add("customCoordinates");

        fileCreateRequest.setResponseFields(responseFields);
        System.out.println(">> Ref: URL= "+imageUrl);
        Result result = ImageKit.getInstance().upload(fileCreateRequest);
        System.out.println(">> Uploading done.");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
    }

    private static void uploadFromBase64() {
        System.out.println(Color.ANSI_CYAN+">> Uploading Base64 Image:"+Color.ANSI_RESET);
        System.out.println(">> Start uploading...");
        URL url = App.class.getClassLoader().getResource("sample1.jpg");
        File file=new File(url.getPath());
        String base64= Utils.fileToBase64(file);
        FileCreateRequest fileCreateRequest =new FileCreateRequest(base64, "sample_base64_image.jpg");
        Result result = ImageKit.getInstance().upload(fileCreateRequest);
        System.out.println(">> Uploading done.");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
    }

    private static void uploadFromBytes() {
        System.out.println(Color.ANSI_CYAN+">> Uploading Image from file:"+Color.ANSI_RESET);
        System.out.println(">> Start uploading...");
        URL url = App.class.getClassLoader().getResource("sample1.jpg");
        File file=new File(url.getPath());
        byte[] bytes= Utils.fileToBytes(file);
        FileCreateRequest fileCreateRequest =new FileCreateRequest(bytes, "sample_image.jpg");
        fileCreateRequest.setUseUniqueFileName(false);
        Result result = ImageKit.getInstance().upload(fileCreateRequest);
        System.out.println(">> Uploading done.");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
    }

    private static void addTags() {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("62958deef33aa80bdadf7533");
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");
        TagsRequest tagsRequest =new TagsRequest(fileIds, tags);
        ResultTags result = ImageKit.getInstance().addTags(tagsRequest);
        System.out.println(">> Add Tags done.");
        System.out.println(Color.ANSI_GREEN+">> Response add tags:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println("\n\n");
    }

    private static void removeTags() {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("62958deef33aa80bdadf7533");
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        TagsRequest tagsRequest =new TagsRequest(fileIds, tags);
        ResultTags result = ImageKit.getInstance().removeTags(tagsRequest);
        System.out.println(">> remove Tags done.");
        System.out.println(Color.ANSI_GREEN+">> Response remove tags:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println("\n\n");
    }

    private static void getCustomMetaDataFields() {
        ResultCustomMetaData result = ImageKit.getInstance().getCustomMetaDataFields();
        System.out.println(">> Fetch CustomMetaDataFields done.");
        System.out.println(Color.ANSI_GREEN+">> Fetch CustomMetaDataFields Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println("\n\n");
    }

    private static void createCustomMetaDataFields() {
        CustomMetaDataFieldSchemaObject schemaObject = new CustomMetaDataFieldSchemaObject(CustomMetaDataTypeEnum.Number, false, 0, 100);

        CustomMetaDataFieldRequest customMetaDataFieldRequest = new CustomMetaDataFieldRequest();
        customMetaDataFieldRequest.setName("NameCustom8");
        customMetaDataFieldRequest.setLabel("LabelCustom8");
        customMetaDataFieldRequest.setSchema(new CustomMetaDataFieldSchemaObject(CustomMetaDataTypeEnum.Number, false, 0, 100));

        ResultCustomMetaData resultCustomMetaData = ImageKit.getInstance().createCustomMetaDataFields(customMetaDataFieldRequest);
        System.out.println(">> remove Tags done.");
        System.out.println(Color.ANSI_GREEN+">> Response remove tags:"+Color.ANSI_RESET);
        System.out.println(resultCustomMetaData);
        System.out.println(resultCustomMetaData.getResultCustomMetaDataFields());
        System.out.println("\n\n");
    }

    private static void deleteCustomMetaDataField(String id) {
        Result result=ImageKit.getInstance().deleteCustomMetaDataField(id);
        System.out.println(">> CustomMetaDataField deleted...");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getMap());
        System.out.println("\n\n");
    }
}
