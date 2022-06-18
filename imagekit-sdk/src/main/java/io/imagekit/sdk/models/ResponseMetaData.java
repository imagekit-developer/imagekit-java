package io.imagekit.sdk.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseMetaData {

	private String raw;
	private int httpStatusCode;
	private Map<String, String> headers;

	public String getRaw() {
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, Object> getMap() {
		if (null != raw) {
			return new Gson().fromJson(raw, new TypeToken<Map<String, Object>>() {
			}.getType());
		}
		return new HashMap<>();
	}

	public <T> List<T> getList() {
		if (null != raw) {
			return new Gson().fromJson(raw, new TypeToken<T>() {
			}.getType());
		}
		return new ArrayList<>();
	}

	@Override
	public String toString() {
		return "ResponseMetaData{" + "raw='" + raw + '\'' + ", httpStatusCode=" + httpStatusCode + ", headers="
				+ headers + '}';
	}
}
