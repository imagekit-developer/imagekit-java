package io.imagekit.sampleapp;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ConflictException;
import io.imagekit.sdk.exceptions.NotFoundException;
import io.imagekit.sdk.exceptions.PartialSuccessException;
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

//        generateUrl();
        uploadFromURL();
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
//        deleteCustomMetaDataField("629f3de17eb0fe4053615450");
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

    //        System.out.println(Color.ANSI_CYAN+"Do you want to delete uploaded files? (yes/No): "+Color.ANSI_BLUE);
    //        String choice=new Scanner(System.in).nextLine();
    //        if (!"yes".equalsIgnoreCase(choice.trim().toLowerCase())){
    //            System.exit(0);
    //        }
//             System.out.println(Color.ANSI_RESET);
//            deleteFile(files.get(0).getFileId());
//            files.remove(0);
//            deleteFiles(files);
//        }
        
//        System.exit(0);
    }

    private static void generatingAuthParams() {
        System.out.println(Color.ANSI_CYAN+">> Generating Authentication Parameters:"+Color.ANSI_RESET);
        Map<String, String> authenticationParameters = ImageKit.getInstance().getAuthenticationParameters();
        System.out.println(Color.ANSI_GREEN+">> Results:"+Color.ANSI_RESET);
        System.out.println(authenticationParameters);
        System.out.println("\n\n");
    }

    private static void generateUrl() {
        System.out.println(Color.ANSI_CYAN+">> URL Generation:"+Color.ANSI_RESET);
        String urlEndpoint=ImageKit.getInstance().getConfig().getUrlEndpoint();
//        String urlEndpoint="https://ik.imagekit.io/bowstring/";

        Map<String, String> queryParam=new HashMap<>();
        queryParam.put("v","123");

        List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
        Map<String, String> scale=new HashMap<>();
        scale.put("height","300");
        scale.put("width","300");
        transformation.add(scale);
        Map<String, String> overlay=new HashMap<>();
        overlay.put("overlayImage","logo-white_SJwqB4Nfe.png");
        transformation.add(overlay);
        Map<String, Object> options=new HashMap();
        options.put("path", "/default-image.jpg");
        options.put("transformation", transformation);

        String image_url=ImageKit.getInstance().getUrl(options);

        System.out.println("url1:==> " + image_url);
        options.clear();
        options.put("path", "/default-image.jpg");
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
        options.put("src","https://ik.imagekit.io/zv3rkhsym/default-image.jpg");
        options.put("queryParameters",queryParam);
        options.put("transformation",transformation);

        String url4 = ImageKit.getInstance().getUrl(options);


        System.out.println(">> Generated URL #1:\t"+image_url);
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
        FileCreateRequest fileCreateRequest = new FileCreateRequest(url, "sample-image11.jpg");
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

    private static void addTags() throws NotFoundException, PartialSuccessException, BadRequestException, ConflictException {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("62a9b446663ef7b5c15951ba");
        List<String> tags = new ArrayList<>();
        tags.add("tag-to-add-4");
        TagsRequest tagsRequest =new TagsRequest(fileIds, tags);
        tagsRequest.setFileIds(fileIds);
        tagsRequest.setTags(tags);
        ResultTags resultTags = ImageKit.getInstance().addTags(tagsRequest);
        System.out.println(">> Add Tags done.");
        System.out.println(Color.ANSI_GREEN+">> Response add tags:"+Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultTags.getResponseMetaData().getMap());
        System.out.println(resultTags);
        System.out.println("\n\n");
    }

    private static void removeTags() throws NotFoundException, PartialSuccessException, BadRequestException, ConflictException {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("629f3de17eb0fe4053615450");
        List<String> tags = new ArrayList<>();
        tags.add("tag-to-add-4");
        TagsRequest tagsRequest =new TagsRequest(fileIds, tags);
        ResultTags resultTags = ImageKit.getInstance().removeTags(tagsRequest);
        System.out.println(">> remove Tags done.");
        System.out.println(Color.ANSI_GREEN+">> Response remove tags:"+Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultTags.getResponseMetaData().getMap());
        System.out.println(resultTags);
        System.out.println("\n\n");
    }

    private static void removeAITags() throws PartialSuccessException, NotFoundException, BadRequestException, ConflictException {
        List<String> fileIds = new ArrayList<>();
        fileIds.add("62a9b446663ef7b5c15951ba");
        List<String> aiTags = new ArrayList<>();
        aiTags.add("Shoe");
        AITagsRequest aiTagsRequest =new AITagsRequest();
        aiTagsRequest.setFileIds(fileIds);
        aiTagsRequest.setAITags(aiTags);
        ResultTags resultTags = ImageKit.getInstance().removeAITags(aiTagsRequest);
        System.out.println(">> remove Tags done.");
        System.out.println(Color.ANSI_GREEN+">> Response remove aiTags:"+Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultTags.getResponseMetaData().getMap());
        System.out.println(resultTags);
        System.out.println("\n\n");
    }

    private static void getCustomMetaDataFields() {
        ResultCustomMetaDataFieldList resultCustomMetaDataFieldList = ImageKit.getInstance().getCustomMetaDataFields(false);
        System.out.println(">> Fetch CustomMetaDataFields done.");
        System.out.println(Color.ANSI_GREEN+">> Fetch CustomMetaDataFields Response:"+Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultCustomMetaDataFieldList.getResponseMetaData().getList());
        System.out.println(resultCustomMetaDataFieldList);
        System.out.println("\n\n");
    }

    private static void createCustomMetaDataFields() throws BadRequestException, PartialSuccessException, NotFoundException, ConflictException {
        CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
        customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Number);
        customMetaDataFieldSchemaObject.setValueRequired(false);
        customMetaDataFieldSchemaObject.setMinValue(10);
        customMetaDataFieldSchemaObject.setMaxValue(100);

        CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
        customMetaDataFieldCreateRequest.setName("NameHe1");
        customMetaDataFieldCreateRequest.setLabel("LabelHe1");
        customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);

        ResultCustomMetaDataField resultCustomMetaDataField = ImageKit.getInstance().createCustomMetaDataFields(customMetaDataFieldCreateRequest);
        System.out.println(">> Create CustomMetaDataFields done.");
        System.out.println(Color.ANSI_GREEN+">> Response create CustomMetaDataFields :"+Color.ANSI_RESET);
        System.out.println(resultCustomMetaDataField);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultCustomMetaDataField.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void deleteCustomMetaDataField(String id) throws NotFoundException, PartialSuccessException, BadRequestException, ConflictException {
        ResultNoContent resultNoContent=ImageKit.getInstance().deleteCustomMetaDataField(id);
        System.out.println(">> CustomMetaDataField deleted...");
        System.out.println(Color.ANSI_GREEN+">> Response:"+Color.ANSI_RESET);
        System.out.println(resultNoContent);
        System.out.println(Color.ANSI_GREEN+">> Raw Response:"+Color.ANSI_RESET);
        System.out.println(resultNoContent.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultNoContent.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void updateCustomMetaDataFields() throws BadRequestException, NotFoundException, PartialSuccessException, ConflictException {
        CustomMetaDataFieldSchemaObject schemaObject = new CustomMetaDataFieldSchemaObject();
        schemaObject.setMinValue(1);
        schemaObject.setMaxValue(200);
        schemaObject.setMinLength(1);

        CustomMetaDataFieldUpdateRequest customMetaDataFieldUpdateRequest = new CustomMetaDataFieldUpdateRequest();
        customMetaDataFieldUpdateRequest.setId("62aab5a9db4851797a8f8ff9");
        customMetaDataFieldUpdateRequest.setLabel("LabelHE100");
        customMetaDataFieldUpdateRequest.setSchema(schemaObject);

        ResultCustomMetaDataField resultCustomMetaDataField = ImageKit.getInstance().updateCustomMetaDataFields(customMetaDataFieldUpdateRequest);
        System.out.println(">> Edit CustomMetaDataFields done.");
        System.out.println(Color.ANSI_GREEN+">> Response edit CustomMetaDataFields :"+Color.ANSI_RESET);
        System.out.println(resultCustomMetaDataField);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultCustomMetaDataField.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void deleteFileVersion() throws BadRequestException, NotFoundException, PartialSuccessException, ConflictException {
        DeleteFileVersionRequest deleteFileVersionRequest = new DeleteFileVersionRequest();
        deleteFileVersionRequest.setFileId("62a9b446663ef7b5c15951ba");
        deleteFileVersionRequest.setVersionId("62aac9b47db937233eee762f");
        ResultNoContent resultNoContent = ImageKit.getInstance().deleteFileVersion(deleteFileVersionRequest);
        System.out.println(">> delete file version done.");
        System.out.println(Color.ANSI_GREEN+">> Response delete File version :"+Color.ANSI_RESET);
        System.out.println(resultNoContent);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultNoContent.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void copyFile() throws NotFoundException, PartialSuccessException, BadRequestException, ConflictException {
        CopyFileRequest copyFileRequest = new CopyFileRequest();
        copyFileRequest.setSourceFilePath("/new_car11.jpg");
        copyFileRequest.setDestinationPath("/demo1/");
        copyFileRequest.setIncludeVersions(true);
        ResultNoContent resultNoContent = ImageKit.getInstance().copyFile(copyFileRequest);
        System.out.println(">> Copy file done.");
        System.out.println(Color.ANSI_GREEN+">> Response Copy File :"+Color.ANSI_RESET);
        System.out.println(resultNoContent);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultNoContent.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void moveFile() throws NotFoundException, PartialSuccessException, BadRequestException, ConflictException {
        MoveFileRequest moveFileRequest = new MoveFileRequest();
        moveFileRequest.setSourceFilePath("/new_car11.jpg");
        moveFileRequest.setDestinationPath("/demo1");
        ResultNoContent resultNoContent = ImageKit.getInstance().moveFile(moveFileRequest);
        System.out.println(">> Move File done.");
        System.out.println(Color.ANSI_GREEN+">> Response Move File :"+Color.ANSI_RESET);
        System.out.println(resultNoContent);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultNoContent.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void renameFile() throws ConflictException, PartialSuccessException, NotFoundException, BadRequestException {
        RenameFileRequest renameFileRequest = new RenameFileRequest();
        renameFileRequest.setFilePath("/new12.jpg");
        renameFileRequest.setNewFileName("new_car.jpg");
        renameFileRequest.setPurgeCache(true);
        ResultRenameFile resultRenameFile = ImageKit.getInstance().renameFile(renameFileRequest);
        System.out.println(">> Rename file done.");
        System.out.println(Color.ANSI_GREEN+">> Response Rename File :"+Color.ANSI_RESET);
        System.out.println(resultRenameFile);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultRenameFile.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void createFolder() {
        CreateFolderRequest createFolderRequest = new CreateFolderRequest();
        createFolderRequest.setFolderName("test1");
        createFolderRequest.setParentFolderPath("/");
        ResultEmptyBlock resultEmptyBlock = ImageKit.getInstance().createFolder(createFolderRequest);
        System.out.println(">> Create folder done.");
        System.out.println(Color.ANSI_GREEN+">> Response Create Folder :"+Color.ANSI_RESET);
        System.out.println(resultEmptyBlock);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultEmptyBlock.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void deleteFolder() throws NotFoundException, ConflictException, PartialSuccessException, BadRequestException {
        String folderPath="/test1";
        DeleteFolderRequest deleteFolderRequest = new DeleteFolderRequest();
        deleteFolderRequest.setFolderPath(folderPath);
        ResultNoContent resultNoContent = ImageKit.getInstance().deleteFolder(deleteFolderRequest);
        System.out.println(">> Delete folder done.");
        System.out.println(Color.ANSI_GREEN+">> Response Delete Folder :"+Color.ANSI_RESET);
        System.out.println(resultNoContent);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultNoContent.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void copyFolder() throws NotFoundException, ConflictException, PartialSuccessException, BadRequestException {
        CopyFolderRequest copyFolderRequest = new CopyFolderRequest();
        copyFolderRequest.setSourceFolderPath("/test1");
        copyFolderRequest.setDestinationPath("/demo1");
        ResultOfFolderActions resultOfFolderActions = ImageKit.getInstance().copyFolder(copyFolderRequest);
        System.out.println(">> Copy folder done.");
        System.out.println(Color.ANSI_GREEN+">> Response Bulk job status :"+Color.ANSI_RESET);
        System.out.println(resultOfFolderActions);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultOfFolderActions.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void moveFolder() throws NotFoundException, ConflictException, PartialSuccessException, BadRequestException {
        MoveFolderRequest moveFolderRequest = new MoveFolderRequest();
        moveFolderRequest.setSourceFolderPath("/demo1/test1");
        moveFolderRequest.setDestinationPath("/");
        ResultOfFolderActions resultOfFolderActions = ImageKit.getInstance().moveFolder(moveFolderRequest);
        System.out.println(">>Move folder done.");
        System.out.println(Color.ANSI_GREEN+">> Response Bulk job status :"+Color.ANSI_RESET);
        System.out.println(resultOfFolderActions);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultOfFolderActions.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void getBulkJobStatus() {
        String jobId = "62a9b9d5663ef7fd985c6fcb";
        ResultBulkJobStatus resultBulkJobStatus = ImageKit.getInstance().getBulkJobStatus(jobId);
        System.out.println(">> Fetch Bulk job status done.");
        System.out.println(Color.ANSI_GREEN+">> Response Bulk job status :"+Color.ANSI_RESET);
        System.out.println(resultBulkJobStatus);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultBulkJobStatus.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }

    private static void getFileVersions() throws NotFoundException, ConflictException, PartialSuccessException, BadRequestException {
        String fileId = "629f3de17eb0fe4053615450";
        ResultFileVersions resultFileVersions = ImageKit.getInstance().getFileVersions(fileId);
        System.out.println(">> Fetch Get file versions done.");
        System.out.println(Color.ANSI_GREEN+">> Response Get file versions :"+Color.ANSI_RESET);
        System.out.println(resultFileVersions);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultFileVersions.getResponseMetaData().getList());
        System.out.println("\n\n");
    }

    private static void getFileVersionDetails() throws NotFoundException, ConflictException, PartialSuccessException, BadRequestException {
        String fileId = "62a9b446663ef7b5c15951ba";
        String versionId = "62a9b446663ef7b5c15951ba";
        ResultFileVersionDetails resultFileVersionDetails = ImageKit.getInstance().getFileVersionDetails(fileId, versionId);
        System.out.println(">> Fetch Get file versions details done.");
        System.out.println(Color.ANSI_GREEN+">> Response Get file versions details :"+Color.ANSI_RESET);
        System.out.println(resultFileVersionDetails);
        System.out.println(Color.ANSI_GREEN+">> Map Response:"+Color.ANSI_RESET);
        System.out.println(resultFileVersionDetails.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }
}
