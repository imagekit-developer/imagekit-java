package io.imagekit.sampleapp;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.NotFoundException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.CustomMetaDataFieldCreateRequest;
import io.imagekit.sdk.models.CustomMetaDataFieldSchemaObject;
import io.imagekit.sdk.models.CustomMetaDataTypeEnum;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.FileUpdateRequest;
//import io.imagekit.sdk.models.GetFileListRequest;
import io.imagekit.sdk.models.GetFileListRequest;
import io.imagekit.sdk.models.results.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;

class App {
    public static void main(String[] args) throws Exception {
        ImageKit imageKit = ImageKit.getInstance();
        //getSystemConfig(Class<?> cls) method need current class as parameter
        Configuration config = new Configuration("public_SSvmi6RknpNXj9x1cQnra1sYpJg=", "private_kwTU4AR9Ei5hBoTIuxCW63Dg2jM=", "https://ik.imagekit.io/zv3rkhsym");
        imageKit.setConfig(config);

        getFileList();
//        uploadFromURL();
//        updateDetails("62a9c3ccd875ec6fd658c854");
//        createCustomMetaDataFields_Number();
//        restoreFileVersion();
//        uploadFromURL();
//        uploadFromBase64();
//        uploadFromBytes();
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


    private static void getFileList() throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException, NotFoundException, BadRequestException, UnknownException, IllegalAccessException, InstantiationException {
        System.out.println(Color.ANSI_CYAN + ">> Uploading Image from file:" + Color.ANSI_RESET);
        System.out.println(">> Start uploading...");
        String[] tags = new String[3];
        tags[0] = "Software";
        tags[1] = "Developer";
        tags[2] = "Engineer";
        Map<String, String> options = new HashMap<>();
//        options.put("skip", "" + 0);
//        options.put("limit", "" + 2);
//        options.put("type", "file");
//        options.put("sort", "ASC_CREATED");
//        options.put("path", "/");
//        options.put("fileType", "non-image"); // 62ac1b71759bcd0f9156d137
//        options.put("searchQuery", "format='jpg'");
//        options.put("tags", Arrays.toString(tags));
        GetFileListRequest getFileListRequest = new GetFileListRequest();
        getFileListRequest.setFileType("all");
        getFileListRequest.setTags(tags);
        getFileListRequest.setLimit("4");
        ResultList resultList = ImageKit.getInstance().getFileList(getFileListRequest);
        System.out.println(">> Uploading done.");
        System.out.println(Color.ANSI_GREEN + ">> Response:" + Color.ANSI_RESET);
        System.out.println(resultList);
        System.out.println(Color.ANSI_GREEN + ">> Raw Response:" + Color.ANSI_RESET);
        System.out.println(resultList.getRaw());
        System.out.println(Color.ANSI_GREEN + ">> Map Response:" + Color.ANSI_RESET);
        System.out.println(resultList.getMap());
        System.out.println("\n\n");
    }



    private static void uploadFromURL() throws InternalServerException, BadRequestException, UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {
        System.out.println(Color.ANSI_CYAN + ">> Uploading from URL:" + Color.ANSI_RESET);
        System.out.println(">> Start uploading...");
        String imageUrl = "https://ik.imagekit.io/ikmedia/IPTC-PhotometadataRef-Std2019.1_8O33PO0Jjss.jpg?tr=md-true";
        URL url = null;
        try {
            url = URI.create(imageUrl).toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        FileCreateRequest fileCreateRequest = new FileCreateRequest(url, "new-image-2.jpg");
        List<String> tags = new ArrayList<>();
        tags.add("Software");
        tags.add("Developer");
        tags.add("Engineer");
        fileCreateRequest.setTags(tags);

        List<String> responseFields = new ArrayList<>();
        responseFields.add("thumbnail");
        responseFields.add("tags");
        responseFields.add("customCoordinates");
//        responseFields.add("embeddedMetadata");

        fileCreateRequest.setResponseFields(responseFields);
        System.out.println(">> Ref: URL= " + imageUrl);
        Result result = ImageKit.getInstance().upload(fileCreateRequest);
        System.out.println(">> Uploading done.");
        System.out.println(Color.ANSI_GREEN + ">> Response:" + Color.ANSI_RESET);
        System.out.println(result);
        System.out.println(Color.ANSI_GREEN + ">> Raw Response:" + Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getRaw());
        System.out.println(Color.ANSI_GREEN + ">> Map Response:" + Color.ANSI_RESET);
        System.out.println(result.getResponseMetaData().getMap());
        System.out.println("\n\n");
    }


//    private static void createCustomMetaDataFields_Text()
//            throws BadRequestException, UnknownException {
//
//        CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
//        customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Text);
//        customMetaDataFieldSchemaObject.setValueRequired(true);
//        customMetaDataFieldSchemaObject.setDefaultValue(20);
//        customMetaDataFieldSchemaObject.setMinLength(10);
//        customMetaDataFieldSchemaObject.setMaxLength(100);
//
//
//        CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
//        customMetaDataFieldCreateRequest.setName("Name");
//        customMetaDataFieldCreateRequest.setLabel("Label");
//        customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);
//
//        ResultCustomMetaDataField resultCustomMetaDataField = ImageKit.getInstance()
//                .createCustomMetaDataFields(customMetaDataFieldCreateRequest);
//        System.out.println(">> Create CustomMetaDataFields done.");
//        System.out.println(Color.ANSI_GREEN + ">> Response create CustomMetaDataFields :" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField);
//        System.out.println(Color.ANSI_GREEN + ">> Map Response:" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField.getResponseMetaData().getMap());
//        System.out.println("\n\n");
//    }
//
//
//    private static void createCustomMetaDataFields_Textarea()
//            throws BadRequestException, UnknownException {
//
//        CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
//        customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Textarea);
//        customMetaDataFieldSchemaObject.setValueRequired(true);
//        customMetaDataFieldSchemaObject.setDefaultValue(20);
//        customMetaDataFieldSchemaObject.setMinLength(10);
//        customMetaDataFieldSchemaObject.setMaxLength(100);
//
//
//
//        CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
//        customMetaDataFieldCreateRequest.setName("Name");
//        customMetaDataFieldCreateRequest.setLabel("Label");
//        customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);
//
//        ResultCustomMetaDataField resultCustomMetaDataField = ImageKit.getInstance()
//                .createCustomMetaDataFields(customMetaDataFieldCreateRequest);
//        System.out.println(">> Create CustomMetaDataFields done.");
//        System.out.println(Color.ANSI_GREEN + ">> Response create CustomMetaDataFields :" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField);
//        System.out.println(Color.ANSI_GREEN + ">> Map Response:" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField.getResponseMetaData().getMap());
//        System.out.println("\n\n");
//    }
//
//
//    private static void createCustomMetaDataFields_Date()
//            throws BadRequestException, UnknownException {
//
//        CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
//        customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Date);
//        customMetaDataFieldSchemaObject.setValueRequired(true);
//        customMetaDataFieldSchemaObject.setDefaultValue("2022-11-30T10:11:10+00:00");
//        customMetaDataFieldSchemaObject.setMinValue("2022-11-30T10:11:10+00:00");
//        customMetaDataFieldSchemaObject.setMaxValue("2022-12-30T10:11:10+00:00");
//
//        CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
//        customMetaDataFieldCreateRequest.setName("Name");
//        customMetaDataFieldCreateRequest.setLabel("Label");
//        customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);
//
//        ResultCustomMetaDataField resultCustomMetaDataField = ImageKit.getInstance()
//                .createCustomMetaDataFields(customMetaDataFieldCreateRequest);
//        System.out.println(">> Create CustomMetaDataFields done.");
//        System.out.println(Color.ANSI_GREEN + ">> Response create CustomMetaDataFields :" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField);
//        System.out.println(Color.ANSI_GREEN + ">> Map Response:" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField.getResponseMetaData().getMap());
//        System.out.println("\n\n");
//    }
//
//    private static void createCustomMetaDataFields_SingleSelect()
//            throws BadRequestException, UnknownException {
//        List<Object> objectList = new ArrayList<>();
//        objectList.add("small");
//        objectList.add("medium");
//        objectList.add("large");
//        objectList.add(30);
//        objectList.add(40);
//        objectList.add(true);
//        CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
//        customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.SingleSelect);
//        customMetaDataFieldSchemaObject.setValueRequired(true);
//        customMetaDataFieldSchemaObject.setDefaultValue("small");
//        customMetaDataFieldSchemaObject.setSelectOptions(objectList);
//
//        CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
//        customMetaDataFieldCreateRequest.setName("Name");
//        customMetaDataFieldCreateRequest.setLabel("Label");
//        customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);
//
//        ResultCustomMetaDataField resultCustomMetaDataField = ImageKit.getInstance()
//                .createCustomMetaDataFields(customMetaDataFieldCreateRequest);
//        System.out.println(">> Create CustomMetaDataFields done.");
//        System.out.println(Color.ANSI_GREEN + ">> Response create CustomMetaDataFields :" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField);
//        System.out.println(Color.ANSI_GREEN + ">> Map Response:" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField.getResponseMetaData().getMap());
//        System.out.println("\n\n");
//    }
//
//
//    private static void createCustomMetaDataFields_Number()
//            throws BadRequestException, UnknownException {
//
//        CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
//        customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Number);
//        customMetaDataFieldSchemaObject.setValueRequired(true);
//        customMetaDataFieldSchemaObject.setDefaultValue(10);
//        customMetaDataFieldSchemaObject.setMinValue(1);
//        customMetaDataFieldSchemaObject.setMaxValue(20);
//
//        CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
//        customMetaDataFieldCreateRequest.setName("Name");
//        customMetaDataFieldCreateRequest.setLabel("Label");
//        customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);
//
//        ResultCustomMetaDataField resultCustomMetaDataField = ImageKit.getInstance()
//                .createCustomMetaDataFields(customMetaDataFieldCreateRequest);
//        System.out.println(">> Create CustomMetaDataFields done.");
//        System.out.println(Color.ANSI_GREEN + ">> Response create CustomMetaDataFields :" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField);
//        System.out.println(Color.ANSI_GREEN + ">> Map Response:" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField.getResponseMetaData().getMap());
//        System.out.println("\n\n");
//    }
//
//    private static void createCustomMetaDataFields_MultiSelect()
//            throws BadRequestException, UnknownException {
//
//        List<Object> objectList = new ArrayList<>();
//        objectList.add("small");
//        objectList.add("medium");
//        objectList.add("large");
//        objectList.add(30);
//        objectList.add(40);
//        objectList.add(true);
//
//        List<Object> defaultValueObject = new ArrayList<>();
//        defaultValueObject.add("small");
//        defaultValueObject.add(30);
//        defaultValueObject.add(true);
//        CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
//        customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.MultiSelect);
//        customMetaDataFieldSchemaObject.setValueRequired(true);
//        customMetaDataFieldSchemaObject.setDefaultValue(defaultValueObject);
//        customMetaDataFieldSchemaObject.setSelectOptions(objectList);
//
//        CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
//        customMetaDataFieldCreateRequest.setName("Name");
//        customMetaDataFieldCreateRequest.setLabel("Label");
//        customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);
//
//        ResultCustomMetaDataField resultCustomMetaDataField = ImageKit.getInstance()
//                .createCustomMetaDataFields(customMetaDataFieldCreateRequest);
//        System.out.println(">> Create CustomMetaDataFields done.");
//        System.out.println(Color.ANSI_GREEN + ">> Response create CustomMetaDataFields :" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField);
//        System.out.println(Color.ANSI_GREEN + ">> Map Response:" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField.getResponseMetaData().getMap());
//        System.out.println("\n\n");
//    }
//
//
//    private static void createCustomMetaDataFields_Boolean()
//            throws BadRequestException, UnknownException {
//
//        CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
//        customMetaDataFieldSchemaObject.setType(CustomMetaDataTypeEnum.Boolean);
//        customMetaDataFieldSchemaObject.setValueRequired(true);
//        customMetaDataFieldSchemaObject.setDefaultValue(true);
//
//        CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
//        customMetaDataFieldCreateRequest.setName("Name");
//        customMetaDataFieldCreateRequest.setLabel("Label");
//        customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);
//
//        ResultCustomMetaDataField resultCustomMetaDataField = ImageKit.getInstance()
//                .createCustomMetaDataFields(customMetaDataFieldCreateRequest);
//        System.out.println(">> Create CustomMetaDataFields done.");
//        System.out.println(Color.ANSI_GREEN + ">> Response create CustomMetaDataFields :" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField);
//        System.out.println(Color.ANSI_GREEN + ">> Map Response:" + Color.ANSI_RESET);
//        System.out.println(resultCustomMetaDataField.getResponseMetaData().getMap());
//        System.out.println("\n\n");
//    }
//
//    private static void updateDetails(String fileId) throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException, BadRequestException, UnknownException {
//        System.out.println(Color.ANSI_CYAN + ">> Updating file details:" + Color.ANSI_RESET);
//        System.out.println(">> Updating file details...");
//        List<String> tags = new ArrayList<>();
//        tags.add("Software");
//        tags.add("Developer");
//        tags.add("Engineer");
//
//        List<String> aiTags = new ArrayList<>();
//        aiTags.add("Plant");
//        FileUpdateRequest fileUpdateRequest = new FileUpdateRequest(fileId);
//        fileUpdateRequest.setTags(tags);
//        fileUpdateRequest.setRemoveAITags(aiTags);
//        fileUpdateRequest.setWebhookUrl("https://webhook.site/c78d617f-33bc-40d9-9e61-608999721e2e");
//
//        JsonObject optionsInnerObject = new JsonObject();
//        optionsInnerObject.addProperty("add_shadow", true);
//        optionsInnerObject.addProperty("bg_color", "yellow");
//        JsonObject innerObject1 = new JsonObject();
//        innerObject1.addProperty("name", "remove-bg");
//        innerObject1.add("options", optionsInnerObject);
//        JsonObject innerObject2 = new JsonObject();
//        innerObject2.addProperty("name", "google-auto-tagging");
//        innerObject2.addProperty("minConfidence", 15);
//        innerObject2.addProperty("maxTags", 20);
//        JsonArray jsonArray = new JsonArray();
//        jsonArray.add(innerObject1);
//        jsonArray.add(innerObject2);
//
//        fileUpdateRequest.setExtensions(jsonArray);
//        fileUpdateRequest.setCustomCoordinates("10,10,40,40");
//        JsonObject jsonObjectCustomMetadata = new JsonObject();
//        jsonObjectCustomMetadata.addProperty("test10", 11);
//        fileUpdateRequest.setCustomMetadata(jsonObjectCustomMetadata);
//        Result result = ImageKit.getInstance().updateFileDetail(fileUpdateRequest);
//        System.out.println(">> Updating done...");
//        System.out.println(Color.ANSI_GREEN + ">> Response:" + Color.ANSI_RESET);
//        System.out.println(result);
//        System.out.println(Color.ANSI_GREEN + ">> Raw Response:" + Color.ANSI_RESET);
//        System.out.println(result.getResponseMetaData().getRaw());
//        System.out.println(Color.ANSI_GREEN + ">> Map Response:" + Color.ANSI_RESET);
//        System.out.println(result.getResponseMetaData().getMap());
//        System.out.println("\n\n");
//    }
}
