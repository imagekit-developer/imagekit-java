package io.imagekit.sdk.tasks;

import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.constants.Transformer;
import io.imagekit.sdk.constants.Version;
import org.apache.commons.codec.digest.HmacUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class UrlGen {

    private static final long DEFAULT_TIMESTAMP=9999999999L;

    public static String getUrl(Map<String,Object> options){
        String path= (String) options.get("path");
        String urlEndpoint= (String) options.get("urlEndpoint");
        String src= (String) options.get("src");
        Map<String,String> queryParams= (Map<String, String>) options.get("queryParameters");
        List<Map<String,String>> transformation= (List<Map<String, String>>) options.get("transformation");
        String transformationPosition= (String) options.get("transformationPosition");
        boolean signed=false;
        if (null!=options.get("signed")) {
            signed = (boolean) options.get("signed");
        }
        long expire=0;
        if (null!=options.get("expireSeconds")) {
            expire = (long) (int)options.get("expireSeconds");
        }
        return UrlGen.generateUrl(path,urlEndpoint,src,queryParams,transformation,transformationPosition,signed,expire);
    }

    private static String generateUrl(
            String path,
            String urlEndpoint,
            String src,
            Map<String,String> queryParameters,
            List<Map<String, String>> transformation,
            String transformationPosition,
            boolean signed,
            long expireSeconds
    ){
        Configuration config=ImageKit.getInstance().getConfig();
        if (urlEndpoint==null){
            urlEndpoint= config.getUrlEndpoint();
        }
        if (urlEndpoint.charAt(urlEndpoint.length()-1)!='/'){
            urlEndpoint+="/";
        }
        String newUrl=null;
        if (null!=src){
            newUrl=buildFullUrl(src,queryParameters,transformation,transformationPosition,signed,expireSeconds);
        }
        else {
            if ("query".equalsIgnoreCase(transformationPosition)){
                newUrl=buildFullUrl(urlEndpoint+(path.charAt(0)=='/'?path.substring(1,path.length()):path),queryParameters,transformation,transformationPosition,signed,expireSeconds);
            }
            else {
                newUrl = buildPathUrl(path.charAt(0)=='/'?path:"/"+path, urlEndpoint, queryParameters, transformation, transformationPosition, signed, expireSeconds, config.getPrivateKey());
            }
        }
        return newUrl;
    }

    private static String buildPathUrl(String path, String urlEndpoint, Map<String, String> queryParameters, List<Map<String, String>> transformation, String transformationPosition, boolean signed, long expireSeconds, String privateKey) {

        StringBuilder tr= new StringBuilder("");
        if (transformation.size()>0) {
            tr.append("tr");
            for (Map<String, String> map : transformation) {
                Set<Map.Entry<String, String>> entries = map.entrySet();
                tr.append(":");
                int i = 0;
                for (Map.Entry<String, String> entry : entries) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    String element = Transformer.getInstance().transform(key) + (value.equalsIgnoreCase("-") ? "" : "-" + value);
                    tr.append(element);
                    if (i < entries.size() - 1) {
                        tr.append(",");
                    }
                    i++;
                }
            }
        }

        QueryMaker queryMaker=new QueryMaker();
        queryMaker.put(String.format(Locale.US,"%s=%s","ik-sdk-version", Version.VERSION_CODE));
        if (null!=queryParameters){
            for (Map.Entry<String,String> entry:queryParameters.entrySet()){
                queryMaker.put(String.format(Locale.US,"%s=%s",entry.getKey(),entry.getValue()));
            }
        }

        URI baseUrl=URI.create(urlEndpoint);
        URI newUri= null;
        try {
            String newPath=baseUrl.getPath();
            if (tr.toString().equalsIgnoreCase("")){
                newPath+=path.substring(1,path.length());
            }
            else {
                newPath+=tr+path;
            }

            URI tmpUri = new URI(baseUrl.getScheme(),baseUrl.getUserInfo(),baseUrl.getHost(),baseUrl.getPort(),
                    newPath,
                    queryMaker.get(),null);

            if (signed){
                long expiryTimestamp =  DEFAULT_TIMESTAMP;
                if (expireSeconds > 0){
                    expiryTimestamp = ((Calendar.getInstance().getTimeInMillis()/1000)+expireSeconds);
                    String signature = signUrl(privateKey,tmpUri.toString(),urlEndpoint,expiryTimestamp);
                    queryMaker.put("ik-s=" + signature);
                    queryMaker.put("ik-t=" + expiryTimestamp);
                }
            }

            newUri = new URI(baseUrl.getScheme(),baseUrl.getUserInfo(),baseUrl.getHost(),baseUrl.getPort(),
                    newPath,
                    queryMaker.get(),null);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return newUri.toString();
    }

    private static String buildFullUrl(String src, Map<String, String> queryParameters, List<Map<String, String>> transformation, String transformationPosition, boolean signed, long expireSeconds) {
        StringBuilder tr= new StringBuilder("");
        if (transformation.size()>0) {
            tr.append("tr=");
            for (Map<String, String> map : transformation) {
                Set<Map.Entry<String, String>> entries = map.entrySet();
                if (!tr.toString().equalsIgnoreCase("tr="))
                    tr.append(":");
                int i = 0;
                for (Map.Entry<String, String> entry : entries) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    String element = Transformer.getInstance().transform(key) + (value.equalsIgnoreCase("-") ? "" : "-" + value);
                    tr.append(element);
                    if (i < entries.size() - 1) {
                        tr.append(",");
                    }
                    i++;
                }
            }
        }

        QueryMaker queryMaker=new QueryMaker();
        queryMaker.put(String.format(Locale.US,"%s=%s","ik-sdk-version", Version.VERSION_CODE));

        // check existing query params
        if (null!=src){
            String[] parts=src.split("\\?");
            if (parts.length>1){
                String[] queries=parts[1].split("&");
                for (String query:queries){
                    queryMaker.put(query);
                }
            }
        }

        if (null!=queryParameters){
            for (Map.Entry<String,String> entry:queryParameters.entrySet()){
                queryMaker.put(String.format(Locale.US,"%s=%s",entry.getKey(),entry.getValue()));
            }
        }
        if (!tr.toString().equalsIgnoreCase("")){
            queryMaker.put(tr.toString());
        }

        URI baseUrl=URI.create(src);
        URI newUri= null;
        try {
            String newPath=baseUrl.getPath();
            newUri = new URI(baseUrl.getScheme(),baseUrl.getUserInfo(),baseUrl.getHost(),baseUrl.getPort(),
                    newPath,
                    queryMaker.get(),null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return newUri.toString();
    }

    public static String signUrl(String privateKey, String url, String urlEndpoint, long expiryTimestamp){
        if (expiryTimestamp < 1){
            expiryTimestamp = DEFAULT_TIMESTAMP;
        }
        if (urlEndpoint.charAt(urlEndpoint.length()-1)!='/'){
            urlEndpoint+="/";
        }
        String replaceUrl=url.replace(urlEndpoint,"")+expiryTimestamp;
        return HmacUtils.hmacSha1Hex(privateKey, replaceUrl);
    }
}
