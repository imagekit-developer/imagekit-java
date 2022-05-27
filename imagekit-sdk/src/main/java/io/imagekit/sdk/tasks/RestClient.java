package io.imagekit.sdk.tasks;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.models.BaseFile;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.MetaData;
import io.imagekit.sdk.models.FileUpdateRequest;
import io.imagekit.sdk.models.results.*;
import okhttp3.*;

import java.io.IOException;
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
            if (response.code()==200){
                String resp=response.body().string();
                result=new Gson().fromJson(resp,Result.class);
                result.setSuccessful(true);
                result.setRaw(resp);
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
            if (response.headers()!=null) {
            	result.setHeaders(response.headers().toMultimap());
            }
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
            if (response.code()==200){
                String resp=response.body().string();
                result=new Gson().fromJson(resp,Result.class);
                result.setSuccessful(true);
                result.setRaw(resp);
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
            if (response.code()==200){
                String resp=response.body().string();
                List<BaseFile> files=new Gson().fromJson(resp,new TypeToken<List<BaseFile>>() {}.getType());
                resultList.setResults(files);
                resultList.setSuccessful(true);
                resultList.responseMetaData.setRaw(resp);
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
            if (response.headers()!=null) {
                Map<String, String> mappedHeader = new HashMap<>();
                response.headers().toMultimap().forEach((key, value) -> value.forEach(k -> mappedHeader.put(key, k)));
                resultList.responseMetaData.setHeaders(mappedHeader);
            }
            resultList.responseMetaData.setHttpStatusCode(response.code());
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
            if (response.code()==200){
                String resp=response.body().string();
                result=new Gson().fromJson(resp,Result.class);
                result.setSuccessful(true);
                result.setRaw(resp);
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
            if (response.code()==200){
                String resp=response.body().string();
                MetaData metaData =new Gson().fromJson(resp,MetaData.class);
                result.setResults(metaData);
                result.setSuccessful(true);
                result.setRaw(resp);
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
            if (response.code()==200){
                String resp=response.body().string();
                MetaData metaData =new Gson().fromJson(resp,MetaData.class);
                result.setResults(metaData);
                result.setSuccessful(true);
                result.setRaw(resp);
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
            if (response.code()==204){
                result.setMessage("File deleted successfully!");
                result.setFileId(fileId);
                result.setSuccessful(true);
                result.setRaw(response.body().string());
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
            if (response.code()==200){
                String resp=response.body().string();
                result=new Gson().fromJson(resp,ResultFileDelete.class);
                result.setMessage("File deleted successfully!");
                result.setSuccessful(true);
                result.setRaw(resp);
            }
            else if (response.code()==404){
                String resp=response.body().string();
                result=new Gson().fromJson(resp,ResultFileDelete.class);
                result.setRaw(resp);
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
            if (response.code()==200 || response.code()==201){
                String resp=response.body().string();
                result =new Gson().fromJson(resp,ResultCache.class);
                result.setSuccessful(true);
                result.setRaw(resp);
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
            if (response.code()==200){
                String resp=response.body().string();
                result =new Gson().fromJson(resp,ResultCacheStatus.class);
                result.setSuccessful(true);
                result.setRaw(resp);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
