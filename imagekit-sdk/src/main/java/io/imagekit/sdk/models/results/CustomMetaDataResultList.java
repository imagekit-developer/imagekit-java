package io.imagekit.sdk.models.results;

import io.imagekit.sdk.models.CustomMetaDataFieldRequest;
import io.imagekit.sdk.models.ResponseMetaData;

public class CustomMetaDataResultList {
    private boolean isSuccessful;
    private String message;
    private CustomMetaDataFieldRequest customMetaDataFieldRequest = new CustomMetaDataFieldRequest();
    private ResponseMetaData responseMetaData = new ResponseMetaData();

    public CustomMetaDataResultList() {

    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseMetaData getResponseMetaData() {
        return responseMetaData;
    }

    public void setResponseMetaData(ResponseMetaData responseMetaData) {
        this.responseMetaData = responseMetaData;
    }

    public CustomMetaDataFieldRequest getCustomMetaDataFieldRequest() {
        return customMetaDataFieldRequest;
    }

    public void setCustomMetaDataFieldRequest(CustomMetaDataFieldRequest customMetaDataFieldRequest) {
        this.customMetaDataFieldRequest = customMetaDataFieldRequest;
    }

    @Override
    public String toString() {
        return "Result{" +
                "isSuccessful=" + isSuccessful +
                ", message='" + message + '\'' +
                '}';
    }
}
