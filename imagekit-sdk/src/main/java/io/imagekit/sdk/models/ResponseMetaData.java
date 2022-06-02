package io.imagekit.sdk.models;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;

public class ResponseMetaData {

    private String raw;
    private int httpStatusCode;
    private Map<String, String> headers;

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String,Object> getMap() {
        if (null!=raw) {
            return new Gson().fromJson(raw, new TypeToken<Map<String, Object>>() {
            }.getType());
        }
        return new HashMap<>();
    }
}
