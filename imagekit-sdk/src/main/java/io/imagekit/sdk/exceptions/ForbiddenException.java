package io.imagekit.sdk.exceptions;

import io.imagekit.sdk.models.ResponseMetaData;

public class ForbiddenException extends Exception {

	private String message;
	private String help;
	private ResponseMetaData responseMetaData;

	public ForbiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
			String message1, String help, ResponseMetaData responseMetaData) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message1;
		this.help = help;
		this.responseMetaData = responseMetaData;
	}

	public ResponseMetaData getResponseMetaData() {
		return responseMetaData;
	}

	public void setResponseMetaData(ResponseMetaData responseMetaData) {
		this.responseMetaData = responseMetaData;
	}

	@Override
	public String toString() {
		return "ForbiddenException{" + "message='" + message + '\'' + ", help='" + help + '\'' + ", responseMetaData="
				+ responseMetaData + '}';
	}
}
