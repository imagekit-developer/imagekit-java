package io.imagekit.sdk.models.results;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultTags {
    private boolean isSuccessful;
    private String message;
    private ResponseMetaData responseMetaData = new ResponseMetaData();

    public ResultTags() {
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

    @Override
    public String toString() {
        return "ResultList{" +
                "isSuccessful=" + isSuccessful +
                ", message='" + message + '\'' +
                '}';
    }
}
