package io.imagekit.sdk.models.results;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultRenameFile {
    private String purgeRequestId;
    private ResponseMetaData responseMetaData = new ResponseMetaData();

    public String getPurgeRequestId() {
        return purgeRequestId;
    }

    public void setPurgeRequestId(String purgeRequestId) {
        this.purgeRequestId = purgeRequestId;
    }

    public ResponseMetaData getResponseMetaData() {
        return responseMetaData;
    }

    public void setResponseMetaData(ResponseMetaData responseMetaData) {
        this.responseMetaData = responseMetaData;
    }

    @Override
    public String toString() {
        return "ResultRenameFile{" +
                "purgeRequestId='" + purgeRequestId + '\'' +
                ", responseMetaData=" + responseMetaData +
                '}';
    }
}
