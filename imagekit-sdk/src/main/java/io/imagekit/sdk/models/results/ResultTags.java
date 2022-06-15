package io.imagekit.sdk.models.results;

import java.util.List;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultTags {
    private List<String> successfullyUpdatedFileIds;
    private ResponseMetaData responseMetaData = new ResponseMetaData();

    public List<String> getSuccessfullyUpdatedFileIds() {
        return successfullyUpdatedFileIds;
    }

    public void setSuccessfullyUpdatedFileIds(List<String> successfullyUpdatedFileIds) {
        this.successfullyUpdatedFileIds = successfullyUpdatedFileIds;
    }

    public ResponseMetaData getResponseMetaData() {
        return responseMetaData;
    }

    public void setResponseMetaData(ResponseMetaData responseMetaData) {
        this.responseMetaData = responseMetaData;
    }

    @Override
    public String toString() {
        return "ResultTags{" +
                "successfullyUpdatedFileIds=" + successfullyUpdatedFileIds +
                ", responseMetaData=" + responseMetaData +
                '}';
    }
}
