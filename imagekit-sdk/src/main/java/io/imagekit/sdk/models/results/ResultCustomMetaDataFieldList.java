package io.imagekit.sdk.models.results;

import java.util.List;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultCustomMetaDataFieldList {

	private List<ResultCustomMetaDataField> resultCustomMetaDataFieldList;
	private ResponseMetaData responseMetaData = new ResponseMetaData();

	public List<ResultCustomMetaDataField> getResultCustomMetaDataFieldList() {
		return resultCustomMetaDataFieldList;
	}

	public void setResultCustomMetaDataFieldList(List<ResultCustomMetaDataField> resultCustomMetaDataFieldList) {
		this.resultCustomMetaDataFieldList = resultCustomMetaDataFieldList;
	}

	public ResponseMetaData getResponseMetaData() {
		return responseMetaData;
	}

	public void setResponseMetaData(ResponseMetaData responseMetaData) {
		this.responseMetaData = responseMetaData;
	}

	@Override
	public String toString() {
		return "ResultCustomMetaDataFieldList{" + "resultCustomMetaDataFieldList=" + resultCustomMetaDataFieldList
				+ ", responseMetaData=" + responseMetaData + '}';
	}
}
