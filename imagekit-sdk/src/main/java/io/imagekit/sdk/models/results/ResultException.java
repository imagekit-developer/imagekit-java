package io.imagekit.sdk.models.results;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultException {
	private String message;
	private String help;
	private ResponseMetaData responseMetaData = new ResponseMetaData();

	public ResultException() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public ResponseMetaData getResponseMetaData() {
		return responseMetaData;
	}

	public void setResponseMetaData(ResponseMetaData responseMetaData) {
		this.responseMetaData = responseMetaData;
	}

	@Override
	public String toString() {
		return "ResultException{" +
				"message='" + message + '\'' +
				", help='" + help + '\'' +
				", responseMetaData=" + responseMetaData +
				'}';
	}
}
