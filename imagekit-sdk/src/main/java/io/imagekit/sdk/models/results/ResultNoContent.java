package io.imagekit.sdk.models.results;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultNoContent {
    private ResponseMetaData responseMetaData = new ResponseMetaData();

    public ResponseMetaData getResponseMetaData() {
        return responseMetaData;
    }

    public void setResponseMetaData(ResponseMetaData responseMetaData) {
        this.responseMetaData = responseMetaData;
    }

    @Override
    public String toString() {
        return "ResultNoContent{" +
                "responseMetaData=" + responseMetaData +
                '}';
    }
}
