package io.imagekit.sdk.models.results;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

import io.imagekit.sdk.models.MetaData;
import io.imagekit.sdk.models.ResponseMetaData;

public class ResultMetaData {
	private boolean isSuccessful;
	private String message;
	private String help;
	@Deprecated
	private String raw;
	private MetaData results;
	private ResponseMetaData responseMetaData = new ResponseMetaData();

	public ResultMetaData() {
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean successful) {
		isSuccessful = successful;
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

	public String getRaw() {
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}

	@Deprecated
	public Map<String, Object> getMap() {
		if (null != raw) {
			return new Gson().fromJson(raw, new TypeToken<Map<String, Object>>() {
			}.getType());
		}
		return new HashMap<>();
	}

	public MetaData getResults() {
		return results;
	}

	public void setResults(MetaData results) {
		this.results = results;
	}

	public ResponseMetaData getResponseMetaData() {
		return responseMetaData;
	}

	public void setResponseMetaData(ResponseMetaData responseMetaData) {
		this.responseMetaData = responseMetaData;
	}

	@Override
	public String toString() {
		return "ResultMetaData{" + "isSuccessful=" + isSuccessful + ", message='" + message + '\'' + ", help='" + help
				+ '\'' + ", results=" + results + '}';
	}
}
