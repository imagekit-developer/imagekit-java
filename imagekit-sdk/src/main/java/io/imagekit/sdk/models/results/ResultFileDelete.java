package io.imagekit.sdk.models.results;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultFileDelete {
	private String help;
	@Deprecated
	private String raw;
	private List<String> successfullyDeletedFileIds;
	private List<String> missingFileIds;
	private ResponseMetaData responseMetaData = new ResponseMetaData();

	public ResultFileDelete() {
		successfullyDeletedFileIds = new ArrayList<>();
		missingFileIds = new ArrayList<>();
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

	public List<String> getSuccessfullyDeletedFileIds() {
		return successfullyDeletedFileIds;
	}

	public void setSuccessfullyDeletedFileIds(List<String> successfullyDeletedFileIds) {
		this.successfullyDeletedFileIds = successfullyDeletedFileIds;
	}

	public List<String> getMissingFileIds() {
		return missingFileIds;
	}

	public void setMissingFileIds(List<String> missingFileIds) {
		this.missingFileIds = missingFileIds;
	}

	public ResponseMetaData getResponseMetaData() {
		return responseMetaData;
	}

	public void setResponseMetaData(ResponseMetaData responseMetaData) {
		this.responseMetaData = responseMetaData;
	}

	@Override
	public String toString() {
		return "ResultFileDelete{" +
				"help='" + help + '\'' +
				", raw='" + raw + '\'' +
				", successfullyDeletedFileIds=" + successfullyDeletedFileIds +
				", missingFileIds=" + missingFileIds +
				", responseMetaData=" + responseMetaData +
				'}';
	}
}
