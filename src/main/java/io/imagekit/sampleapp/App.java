package io.imagekit.sampleapp;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.ImageKit;
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
import io.imagekit.sdk.utils.Utils;

import java.io.File;
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
//        getBulkJobStatus();
//        deleteFileVersion();
//        getFileVersions();
//        getFileVersionDetails();
//        copyFile();
//        moveFile();
//        renameFile();
//        createFolder();
//        deleteFolder();
//        copyFolder();
//        moveFolder();
//        addTags();
//        removeTags();
//        removeAITags();
//        createCustomMetaDataFields();
//        updateCustomMetaDataFields();
//        deleteCustomMetaDataField("6296f91191fa57ccc36b15cf");
        getCustomMetaDataFields();
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
        System.out.println(result.getResponseMetaData().getMap());
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
        System.out.println(result.getResponseMetaData().getMap());
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
        System.out.println(result.getResponseMetaData().getMap());
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
        System.out.println(result.getResponseMetaData().getMap());
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
        System.out.println(result.getResponseMetaData().getMap());
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
        System.out.println(result.getResponseMetaData().getMap());
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
        System.out.println(result.getResponseMetaData().getMap());
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
        System.out.println(result.getResponseMetaData().getMap());
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
        System.out.println(resultList.getResponseMetaData().getMap());
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
        System.out.println(result.getResponseMetaData().getMap());
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
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void uploadFromBytes() {
        System.out.println(Color.ANSI_CYAN+">> Uploading Image from file:"+Color.ANSI_RESET);
        System.out.println(">> Start uploading...");
        URL url = App.class.getClassLoader().getResource("sample1.jpg");
        File file=new File(url.getPath());
        byte[] bytes= Utils.fileToBytes(file);
        FileCreateRequest fileCreateRequest =new FileCreateRequest(bytes, "sample_image_th.jpg");
        fileCreateRequest.setUseUniqueFileName(false);
        JsonObject optionsInnerObject = new JsonObject();
        optionsInnerObject.addProperty("add_shadow", true);
        optionsInnerObject.addProperty("bg_colour", "green");
        JsonObject innerObject1 = new JsonObject();
        innerObject1.addProperty("name", "remove-bg");
        innerObject1.add("options", optionsInnerObject);
        JsonObject innerObject2 = new JsonObject();
        innerObject2.addProperty("name", "google-auto-tagging");
        innerObject2.addProperty("minConfidence", 5);
        innerObject2.addProperty("maxTags", 95);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(innerObject1);
        jsonArray.add(innerObject2);
        fileCreateRequest.setExtensions(jsonArray);
        fileCreateRequest.setWebhookUrl("https://webhook.site/c78d617f-33bc-40d9-9e61-608999721e2e");
        fileCreateRequest.setOverwriteFile(true);
        fileCreateRequest.setOverwriteAITags(true);
        fileCreateRequest.setOverwriteTags(true);
        fileCreateRequest.setOverwriteCustomMetadata(true);
        JsonObject jsonObjectCustomMetadata = new JsonObject();
        jsonObjectCustomMetadata.addProperty("test1", 10);
        fileCreateRequest.setCustomMetadata(jsonObjectCustomMetadata);
        Result result = ImageKit.getInstance().upload(fileCreateRequest);
        System.out.println(">> Uploading done.");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void addTags() {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("629f3de17eb0fe4053615450");
        List<String> tags = new ArrayList<>();
        tags.add("tag3");
        tags.add("tag4");
        TagsRequest tagsRequest =new TagsRequest(fileIds, tags);
        tagsRequest.setFileIds(fileIds);
        tagsRequest.setTags(tags);
        Result result = ImageKit.getInstance().addTags(tagsRequest);
        System.out.println(">> Add Tags done.");
        System.out.println(Color.ANSI_GREEN+">> Response add tags:"+Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println(result);
        System.out.println("\n\n");
    }

    private static void removeTags() {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("629f3de17eb0fe4053615450");
        List<String> tags = new ArrayList<>();
        tags.add("tag3");
        tags.add("tag4");
        TagsRequest tagsRequest =new TagsRequest(fileIds, tags);
        Result result = ImageKit.getInstance().removeTags(tagsRequest);
        System.out.println(">> remove Tags done.");
        System.out.println(Color.ANSI_GREEN+">> Response remove tags:"+Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println(result);
        System.out.println("\n\n");
    }

    private static void removeAITags() {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("629f3de17eb0fe4053615450");
        List<String> aiTags = new ArrayList<>();
        aiTags.add("Rectangle");
        AITagsRequest aiTagsRequest =new AITagsRequest();
        aiTagsRequest.setFileIds(fileIds);
        aiTagsRequest.setAITags(aiTags);
        Result result = ImageKit.getInstance().removeAITags(aiTagsRequest);
        System.out.println(">> remove Tags done.");
        System.out.println(Color.ANSI_GREEN+">> Response remove aiTags:"+Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println(result);
        System.out.println("\n\n");
    }

    private static void getCustomMetaDataFields() {
        Result result = ImageKit.getInstance().getCustomMetaDataFields(false);
        System.out.println(">> Fetch CustomMetaDataFields done.");
        System.out.println(Color.ANSI_GREEN+">> Fetch CustomMetaDataFields Response:"+Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getList());
        System.out.println(result);
        System.out.println("\n\n");
    }

    private static void createCustomMetaDataFields() {
        CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
        customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Number);
        customMetaDataFieldSchemaObject.setValueRequired(false);
        customMetaDataFieldSchemaObject.setMaxValue(2);
        customMetaDataFieldSchemaObject.setMinValue(29);

        CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
        customMetaDataFieldCreateRequest.setName("NameCus2");
        customMetaDataFieldCreateRequest.setLabel("LabelCm2");
        customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);

        Result result = ImageKit.getInstance().createCustomMetaDataFields(customMetaDataFieldCreateRequest);
        System.out.println(">> Create CustomMetaDataFields done.");
        System.out.println(Color.ANSI_GREEN+">> Response create CustomMetaDataFields :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
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
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void updateCustomMetaDataFields() {
        CustomMetaDataFieldSchemaObject schemaObject = new CustomMetaDataFieldSchemaObject();
        schemaObject.setMinValue(1);
        schemaObject.setMaxValue(200);

        CustomMetaDataFieldUpdateRequest customMetaDataFieldUpdateRequest = new CustomMetaDataFieldUpdateRequest();
        customMetaDataFieldUpdateRequest.setId("62a0425ac10d49989f6d1996");
        customMetaDataFieldUpdateRequest.setLabel("LabelCM200");
        customMetaDataFieldUpdateRequest.setSchema(schemaObject);

        Result result = ImageKit.getInstance().updateCustomMetaDataFields(customMetaDataFieldUpdateRequest);
        System.out.println(">> Edit CustomMetaDataFields done.");
        System.out.println(Color.ANSI_GREEN+">> Response edit CustomMetaDataFields :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void deleteFileVersion() {
        DeleteFileVersionRequest deleteFileVersionRequest = new DeleteFileVersionRequest();
        deleteFileVersionRequest.setFileId("629d95278482ba129fd17c97");
        deleteFileVersionRequest.setVersionId("629d953ebd24e8ceca911a66");
        Result result = ImageKit.getInstance().deleteFileVersion(deleteFileVersionRequest);
        System.out.println(">> delete file version done.");
        System.out.println(Color.ANSI_GREEN+">> Response delete File version :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void copyFile() {
        CopyFileRequest copyFileRequest = new CopyFileRequest();
        copyFileRequest.setSourceFilePath("/w2_image.png");
        copyFileRequest.setDestinationPath("/Gallery/");
        copyFileRequest.setIncludeVersions(true);
        Result result = ImageKit.getInstance().copyFile(copyFileRequest);
        System.out.println(">> Copy file done.");
        System.out.println(Color.ANSI_GREEN+">> Response Copy File :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void moveFile() {
        MoveFileRequest moveFileRequest = new MoveFileRequest();
        moveFileRequest.setSourceFilePath("/Gallery/w2_image.png");
        moveFileRequest.setDestinationPath("/");
        Result result = ImageKit.getInstance().moveFile(moveFileRequest);
        System.out.println(">> Move File done.");
        System.out.println(Color.ANSI_GREEN+">> Response Move File :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void renameFile() {
        RenameFileRequest renameFileRequest = new RenameFileRequest();
        renameFileRequest.setFilePath("/w2_image.png");
        renameFileRequest.setNewFileName("w2_image_s.png");
        renameFileRequest.setPurgeCache(true);
        Result result = ImageKit.getInstance().renameFile(renameFileRequest);
        System.out.println(">> Rename file done.");
        System.out.println(Color.ANSI_GREEN+">> Response Rename File :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void createFolder() {
        CreateFolderRequest createFolderRequest = new CreateFolderRequest();
        createFolderRequest.setFolderName("test1");
        createFolderRequest.setParentFolderPath("/");
        Result result = ImageKit.getInstance().createFolder(createFolderRequest);
        System.out.println(">> Create folder done.");
        System.out.println(Color.ANSI_GREEN+">> Response Create Folder :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void deleteFolder() {
        String folderPath="/test1";
        DeleteFolderRequest deleteFolderRequest = new DeleteFolderRequest();
        deleteFolderRequest.setFolderPath(folderPath);
        Result result = ImageKit.getInstance().deleteFolder(deleteFolderRequest);
        System.out.println(">> Delete folder done.");
        System.out.println(Color.ANSI_GREEN+">> Response Delete Folder :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void copyFolder() {
        CopyFolderRequest copyFolderRequest = new CopyFolderRequest();
        copyFolderRequest.setSourceFolderPath("/Gallery/test");
        copyFolderRequest.setDestinationPath("/");
        Result result = ImageKit.getInstance().copyFolder(copyFolderRequest);
        System.out.println(">> Copy folder done.");
        System.out.println(Color.ANSI_GREEN+">> Response Bulk job status :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void moveFolder() {
        MoveFolderRequest moveFolderRequest = new MoveFolderRequest();
        moveFolderRequest.setSourceFolderPath("/Gallery/test");
        moveFolderRequest.setDestinationPath("/");
        Result result = ImageKit.getInstance().moveFolder(moveFolderRequest);
        System.out.println(">>Move folder done.");
        System.out.println(Color.ANSI_GREEN+">> Response Bulk job status :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void getBulkJobStatus() {
        String jobId = "629f44ac7eb0fe8173622d4b";
        Result result = ImageKit.getInstance().getBulkJobStatus(jobId);
        System.out.println(">> Fetch Bulk job status done.");
        System.out.println(Color.ANSI_GREEN+">> Response Bulk job status :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void getFileVersions() {
        String fileId = "62a04834c10d49825c6de9e8";
        Result result = ImageKit.getInstance().getFileVersions(fileId);
        System.out.println(">> Fetch Get file versions done.");
        System.out.println(Color.ANSI_GREEN+">> Response Get file versions :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getList());
        System.out.println("\n\n");
    }

    private static void getFileVersionDetails() {
        String fileId = "62a04834c10d49825c6de9e8";
        String versionId = "62a04834c10d49825c6de9e8";
        Result result = ImageKit.getInstance().getFileVersionDetails(fileId, versionId);
        System.out.println(">> Fetch Get file versions details done.");
        System.out.println(Color.ANSI_GREEN+">> Response Get file versions details :"+Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }
}
