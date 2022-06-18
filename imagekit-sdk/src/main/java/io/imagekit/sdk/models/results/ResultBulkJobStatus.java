package io.imagekit.sdk.models.results;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultBulkJobStatus {
	private String jobId;
	private String type;
	private String status;
	private ResponseMetaData responseMetaData = new ResponseMetaData();

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ResponseMetaData getResponseMetaData() {
		return responseMetaData;
	}

	public void setResponseMetaData(ResponseMetaData responseMetaData) {
		this.responseMetaData = responseMetaData;
	}

	@Override
	public String toString() {
		return "ResultBulkJobStatus{" + "jobId='" + jobId + '\'' + ", type='" + type + '\'' + ", status='" + status
				+ '\'' + ", responseMetaData=" + responseMetaData + '}';
	}
}
