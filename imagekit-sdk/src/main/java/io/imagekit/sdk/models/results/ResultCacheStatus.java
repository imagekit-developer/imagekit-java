package io.imagekit.sdk.models.results;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultCacheStatus {
	private String help;
	private String status;
	@Deprecated
	private String raw;
	private ResponseMetaData responseMetaData = new ResponseMetaData();

	public ResultCacheStatus() {
	}

	public String getHelp() {
		return help;
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

	public void setHelp(String help) {
		this.help = help;
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
		return "ResultCacheStatus{" +
				"help='" + help + '\'' +
				", status='" + status + '\'' +
				", raw='" + raw + '\'' +
				", responseMetaData=" + responseMetaData +
				'}';
	}
}
