package io.imagekit.sdk.models.results;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.imagekit.sdk.models.BaseFile;
import io.imagekit.sdk.models.ResponseMetaData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultList {
	private String help;
	@Deprecated
	private String raw;
	private List<BaseFile> results;
	private ResponseMetaData responseMetaData = new ResponseMetaData();

	public ResultList() {
	}

	public ResultList(List<BaseFile> results) {
		this.results = results;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getRaw() {
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}

	@Deprecated
	public List<Map<String, Object>> getMap() {
		if (null != raw) {
			return new Gson().fromJson(raw, new TypeToken<List<Map<String, Object>>>() {
			}.getType());
		}
		return new ArrayList<Map<String, Object>>();
	}

	public ResponseMetaData getResponseMetaData() {
		return responseMetaData;
	}

	public void setResponseMetaData(ResponseMetaData responseMetaData) {
		this.responseMetaData = responseMetaData;
	}

	public List<BaseFile> getResults() {
		return results;
	}

	public void setResults(List<BaseFile> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "ResultList{" + "help='" + help + '\'' + ", raw='" + raw + '\'' + ", results=" + results
				+ ", responseMetaData=" + responseMetaData + '}';
	}
}
