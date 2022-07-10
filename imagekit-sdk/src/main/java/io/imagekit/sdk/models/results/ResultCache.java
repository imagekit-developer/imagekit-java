package io.imagekit.sdk.models.results;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultCache {
	private String help;
	private String requestId;
	@Deprecated
	private String raw;
	private ResponseMetaData responseMetaData = new ResponseMetaData();

	public ResultCache() {
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

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public ResponseMetaData getResponseMetaData() {
		return responseMetaData;
	}

	public void setResponseMetaData(ResponseMetaData responseMetaData) {
		this.responseMetaData = responseMetaData;
	}

	@Override
	public String toString() {
		return "ResultCache{" + "help='" + help + '\'' + ", requestId='" + requestId + '\'' + ", raw='" + raw + '\''
				+ ", responseMetaData=" + responseMetaData + '}';
	}
}
