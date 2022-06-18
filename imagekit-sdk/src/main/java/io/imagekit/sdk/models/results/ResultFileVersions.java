package io.imagekit.sdk.models.results;

import java.util.ArrayList;
import java.util.List;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultFileVersions {
	List<ResultFileVersionDetails> resultFileVersionDetailsList = new ArrayList<>();
	private ResponseMetaData responseMetaData = new ResponseMetaData();

	public List<ResultFileVersionDetails> getResultFileVersionDetailsList() {
		return resultFileVersionDetailsList;
	}

	public void setResultFileVersionDetailsList(List<ResultFileVersionDetails> resultFileVersionDetailsList) {
		this.resultFileVersionDetailsList = resultFileVersionDetailsList;
	}

	public ResponseMetaData getResponseMetaData() {
		return responseMetaData;
	}

	public void setResponseMetaData(ResponseMetaData responseMetaData) {
		this.responseMetaData = responseMetaData;
	}

	@Override
	public String toString() {
		return "ResultFileVersions{" + "resultFileVersionDetailsList=" + resultFileVersionDetailsList
				+ ", responseMetaData=" + responseMetaData + '}';
	}
}
