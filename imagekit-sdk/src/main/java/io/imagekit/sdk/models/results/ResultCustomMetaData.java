package io.imagekit.sdk.models.results;

import java.util.ArrayList;
import java.util.List;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultCustomMetaData {
    private boolean isSuccessful;
    private String message;
    private ResponseMetaData responseMetaData = new ResponseMetaData();
    private List<ResultCustomMetaDataField> resultCustomMetaDataFields = new ArrayList<>();

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

    public List<io.imagekit.sdk.models.results.ResultCustomMetaDataField> getResultCustomMetaDataFields() {
        return resultCustomMetaDataFields;
    }

    public void setResultCustomMetaDataFields(List<io.imagekit.sdk.models.results.ResultCustomMetaDataField> resultCustomMetaDataFields) {
        this.resultCustomMetaDataFields = resultCustomMetaDataFields;
    }

    @Override
    public String toString() {
        return "Result{" +
                "isSuccessful=" + isSuccessful +
                ", message='" + message + '\'' +
                '}';
    }
}
