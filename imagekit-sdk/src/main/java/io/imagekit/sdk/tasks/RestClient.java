package io.imagekit.sdk.tasks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.models.BaseFile;
import io.imagekit.sdk.models.CustomMetaDataFieldRequest;
import io.imagekit.sdk.models.results.ResultCustomMetaDataField;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.MetaData;
import io.imagekit.sdk.models.FileUpdateRequest;
import io.imagekit.sdk.models.TagsRequest;
import io.imagekit.sdk.models.results.*;
import io.imagekit.sdk.utils.Utils;
import okhttp3.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RestClient {
    private ImageKit imageKit;
    Request request;
    OkHttpClient client;
    MultipartBuilder multipartBuilder;

    public RestClient(ImageKit imageKit) {
        this.imageKit=imageKit;
        this.client=new OkHttpClient();
        this.multipartBuilder=new MultipartBuilder();
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }

    public void setMultipartBuilder(MultipartBuilder builder){
        this.multipartBuilder=builder;
    }

    public Result upload(FileCreateRequest fileCreateRequest){
        Result result=null;
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        MultipartBody body=multipartBuilder.build(fileCreateRequest);

        request=new Request.Builder()
                .url("https://upload.imagekit.io/api/v1/files/upload")
                .post(body)
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String respBody="";
            if (response.code()==200){
                respBody = response.body().string();
                result=new Gson().fromJson(respBody,Result.class);
                result.setSuccessful(true);
            }
            else if (response.code()==500) {
                result=new Result();
                result.setSuccessful(false);
                result.setMessage("Error: Internal server error.");
            }
            else {
                String resp=response.body().string();
                result=new Gson().fromJson(resp,Result.class);
                result.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result updateDetail(FileUpdateRequest fileUpdateRequest){
        Result result=null;
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);
        String url=String.format(Locale.US,"https://api.imagekit.io/v1/files/%s/details",fileUpdateRequest.getFileId());
        request=new Request.Builder()
                .url(url)
                .patch(multipartBuilder.build(fileUpdateRequest))
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String respBody="";
            if (response.code()==200){
                respBody=response.body().string();
                result=new Gson().fromJson(respBody,Result.class);
                result.setSuccessful(true);
            }
            else if (response.code()==500) {
                result=new Result();
                result.setSuccessful(false);
                result.setMessage("Error: Internal server error.");
            }
            else {
                String resp=response.body().string();
                result=new Gson().fromJson(resp,Result.class);
                result.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultList getFileList(Map<String, String> options){
        ResultList resultList=new ResultList();
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        QueryMaker queryMaker=new QueryMaker();

        for (Map.Entry<String,String> entry:options.entrySet()){
            queryMaker.put(String.format("%s=%s",entry.getKey(),entry.getValue()));
        }



        String url=String.format(Locale.US,"https://api.imagekit.io/v1/files?%s",queryMaker.get());
//        System.out.println(url);

        request=new Request.Builder()
                .url(url)
                .get()
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String respBody="";
            if (response.code()==200){
                respBody=response.body().string();
                List<BaseFile> files=new Gson().fromJson(respBody,new TypeToken<List<BaseFile>>() {}.getType());
                resultList.setResults(files);
                resultList.setSuccessful(true);
            }
            else if (response.code()==500) {
                resultList.setSuccessful(false);
                resultList.setMessage("Error: Internal server error.");
            }
            else {
                String resp=response.body().string();
                resultList=new Gson().fromJson(resp,ResultList.class);
                resultList.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, resultList.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public Result getFileDetail(String fileId){
        Result result=new Result();
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        String url=String.format(Locale.US,"https://api.imagekit.io/v1/files/%s/details",fileId);

        request=new Request.Builder()
                .url(url)
                .get()
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String respBody="";
            if (response.code()==200){
                respBody=response.body().string();
                result=new Gson().fromJson(respBody,Result.class);
                result.setSuccessful(true);
            }
            else if (response.code()==500) {
                result.setSuccessful(false);
                result.setMessage("Error: Internal server error.");
            }
            else {
                String resp=response.body().string();
                result=new Gson().fromJson(resp,Result.class);
                result.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultMetaData getFileMetaData(String fileId){
        ResultMetaData result=new ResultMetaData();
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        String url=String.format(Locale.US,"https://api.imagekit.io/v1/files/%s/metadata",fileId);

        request=new Request.Builder()
                .url(url)
                .get()
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String respBody="";
            if (response.code()==200){
                respBody = response.body().string();
                MetaData metaData =new Gson().fromJson(respBody,MetaData.class);
                result.setResults(metaData);
                result.setSuccessful(true);
            }
            else if (response.code()==500) {
                result.setSuccessful(false);
                result.setMessage("Error: Internal server error.");
            }
            else {
                String resp=response.body().string();
                result=new Gson().fromJson(resp,ResultMetaData.class);
                result.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultMetaData getRemoteFileMetaData(String url){
        ResultMetaData result=new ResultMetaData();
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        String apiURL="https://api.imagekit.io/v1/metadata?url="+url;

        request=new Request.Builder()
                .url(apiURL)
                .get()
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String respBody="";
            if (response.code()==200){
                respBody=response.body().string();
                MetaData metaData =new Gson().fromJson(respBody,MetaData.class);
                result.setResults(metaData);
                result.setSuccessful(true);
            }
            else if (response.code()==500) {
                result.setSuccessful(false);
                result.setMessage("Error: Internal server error.");
            }
            else {
                String resp=response.body().string();
                result=new Gson().fromJson(resp,ResultMetaData.class);
                result.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result deleteFile(String fileId){
        Result result=new Result();
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        String url=String.format(Locale.US,"https://api.imagekit.io/v1/files/%s",fileId);

        request=new Request.Builder()
                .url(url)
                .delete()
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String respBody="";
            if (response.code()==204){
                respBody = response.body().string();
                result.setMessage("File deleted successfully!");
                result.setFileId(fileId);
                result.setSuccessful(true);
            }
            else if (response.code()==500) {
                result.setSuccessful(false);
                result.setMessage("Error: Internal server error.");
            }
            else {
                String resp=response.body().string();
                result=new Gson().fromJson(resp,Result.class);
                result.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultFileDelete bulkDeleteFiles(List<String> fileIds){
        ResultFileDelete result=new ResultFileDelete();
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        String url="https://api.imagekit.io/v1/files/batch/deleteByFileIds";

        request=new Request.Builder()
                .url(url)
                .post(
                        multipartBuilder.build(String.format("{\"fileIds\":%s}",new Gson().toJson(fileIds)))
                )
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String respBody="";
            if (response.code()==200){
                respBody=response.body().string();
                result=new Gson().fromJson(respBody,ResultFileDelete.class);
                result.setMessage("File deleted successfully!");
                result.setSuccessful(true);
            }
            else if (response.code()==404){
                String resp=response.body().string();
                result=new Gson().fromJson(resp,ResultFileDelete.class);
                result.getResponseMetaData().setRaw(resp);
                result.setSuccessful(false);
            }
            else if (response.code()==500) {
                result.setSuccessful(false);
                result.setMessage("Error: Internal server error.");
            }
            else {
                String resp=response.body().string();
                result=new Gson().fromJson(resp,ResultFileDelete.class);
                result.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultCache purgeCache(String url){
        ResultCache result=new ResultCache();
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        request=new Request.Builder()
                .url("https://api.imagekit.io/v1/files/purge")
                .post(
                        multipartBuilder.build(String.format("{\"url\":\"%s\"}",url))
                )
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String respBody="";
            if (response.code()==200 || response.code()==201){
                respBody=response.body().string();
                result =new Gson().fromJson(respBody,ResultCache.class);
                result.setSuccessful(true);
            }
            else if (response.code()==500) {
                result.setSuccessful(false);
                result.setMessage("Error: Internal server error.");
            }
            else {
                String resp=response.body().string();
                result=new Gson().fromJson(resp,ResultCache.class);
                result.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultCacheStatus getPurgeCacheStatus(String requestId){
        ResultCacheStatus result=new ResultCacheStatus();
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        String url=String.format(Locale.US,"https://api.imagekit.io/v1/files/purge/%s",requestId);

        request=new Request.Builder()
                .url(url)
                .get()
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String respBody="";
            if (response.code()==200){
                respBody=response.body().string();
                result =new Gson().fromJson(respBody,ResultCacheStatus.class);
                result.setSuccessful(true);
            }
            else if (response.code()==500) {
                result.setSuccessful(false);
                result.setMessage("Error: Internal server error.");
            }
            else {
                String resp=response.body().string();
                result=new Gson().fromJson(resp,ResultCacheStatus.class);
                result.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultTags manageTags(TagsRequest tagsRequest, String action) {
        ResultTags result = new ResultTags();
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"), new Gson().toJson(tagsRequest));
        request=new Request.Builder()
                .url(action.equals("removeTags") ? "https://api.imagekit.io/v1/files/removeTags" : "https://api.imagekit.io/v1/files/addTags")
                .post(requestBody)
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();

            String respBody = response.body().string();
            result = new Gson().fromJson(respBody, ResultTags.class);
            if (response.code() == 200) {
                result =new Gson().fromJson(respBody, ResultTags.class);
                result.setSuccessful(true);
                result.setMessage(response.message().equals("") ? action.equals("removeTags") ? "Removed Tags SuccessFully." : "Added Tags SuccessFully." : response.message());
            } else {
                result.setSuccessful(false);
                result.setMessage("Error: Internal server error.");
            }
            Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(), response.headers().toMultimap());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultCustomMetaData getCustomMetaDataFields() {
        ResultCustomMetaData resultCustomMetaData = new ResultCustomMetaData();

        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        request=new Request.Builder()
                .url("https://api.imagekit.io/v1/customMetadataFields")
                .get()
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String respBody="";
            if (response.code()==200){
                respBody=response.body().string();
                ResultCustomMetaDataField[] requests = new Gson().fromJson(respBody, ResultCustomMetaDataField[].class);
                List<ResultCustomMetaDataField> resultCustomMetaDataFields = Arrays.asList(requests);
                resultCustomMetaData.setResultCustomMetaDataFields(resultCustomMetaDataFields);
                resultCustomMetaData.setSuccessful(true);
                resultCustomMetaData.getResponseMetaData().setRaw(respBody);
                resultCustomMetaData.setMessage(response.message().equals("") ? "Fetched customMetadata successFully" : response.message());
            } else {
                resultCustomMetaData.setSuccessful(false);
                resultCustomMetaData.setMessage("Error: Internal server error.");
            }
            Utils.populateResponseMetadata(respBody, resultCustomMetaData.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Here:==> " + resultCustomMetaData.getResultCustomMetaDataFields());
        return resultCustomMetaData;
    }

    public ResultCustomMetaData createCustomMetaDataFields(CustomMetaDataFieldRequest customMetaDataFieldRequest) {
        ResultCustomMetaData resultCustomMetaData = new ResultCustomMetaData();

        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"), new Gson().toJson(customMetaDataFieldRequest));
        request=new Request.Builder()
                .url("https://api.imagekit.io/v1/customMetadataFields")
                .post(requestBody)
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            JsonElement responseBody = new JsonParser().parse(response.body().string());
            resultCustomMetaData = new Gson().fromJson(responseBody, ResultCustomMetaData.class);
            String respBody="";
            if (response.code()==200){
                respBody=response.body().string();
                ResultCustomMetaDataField requests = new Gson().fromJson(respBody, ResultCustomMetaDataField.class);
                List<ResultCustomMetaDataField> resultCustomMetaDataFields = Collections.singletonList(requests);
                resultCustomMetaData.setResultCustomMetaDataFields(resultCustomMetaDataFields);
                resultCustomMetaData.setSuccessful(true);
                resultCustomMetaData.getResponseMetaData().setRaw(respBody);
            } else {
                resultCustomMetaData.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, resultCustomMetaData.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultCustomMetaData;
    }

    public Result deleteCustomMetaDataField(String id) {
        Result result=new Result();
        String credential = Credentials.basic(imageKit.getConfig().getPrivateKey(),"");
        Map<String, String> headers=new HashMap<>();
        headers.put("Accept-Encoding","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization",credential);

        String url=String.format(Locale.US,"https://api.imagekit.io/v1/customMetadataFields/%s",id);

        request=new Request.Builder()
                .url(url)
                .delete()
                .headers(Headers.of(headers))
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println("response:===> " + response);
            String respBody="";
            if (response.code()==204){
                respBody = response.body().string();
                System.out.println("respBody:====> " + respBody);
                result.setSuccessful(true);
                result.setMessage("CustomMetaDataField deleted successfully!");
            }
            else if (response.code()==500) {
                result.setSuccessful(false);
                result.setMessage("Error: Internal server error.");
            }
            else {
                String resp=response.body().string();
                result=new Gson().fromJson(resp,Result.class);
                result.setSuccessful(false);
            }
            Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(), response.headers().toMultimap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
