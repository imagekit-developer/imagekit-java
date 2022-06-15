package io.imagekit.sdk.models.results;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultOfFolderActions {
    private String jobId;
    private ResponseMetaData responseMetaData = new ResponseMetaData();

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public ResponseMetaData getResponseMetaData() {
        return responseMetaData;
    }

    public void setResponseMetaData(ResponseMetaData responseMetaData) {
        this.responseMetaData = responseMetaData;
    }

    @Override
    public String toString() {
        return "ResultOfFolderActions{" +
                "jobId='" + jobId + '\'' +
                ", responseMetaData=" + responseMetaData +
                '}';
    }
}
