package io.imagekit.sdk.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.imagekit.sdk.utils.Utils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.net.URL;
import java.util.List;

public class FileCreateRequest {
	public URL url;
	public String base64;
	public byte[] bytes;
	public String fileName;
	public boolean useUniqueFileName;
	public List<String> tags;
	public String folder;
	public boolean isPrivateFile;
	public String customCoordinates;
	public List<String> responseFields;
	public JsonArray extensions;
	public String webhookUrl;
	public Boolean overwriteFile;
	public Boolean overwriteAITags;
	public Boolean overwriteTags;
	public Boolean overwriteCustomMetadata;
	public JsonObject customMetadata;

	public FileCreateRequest(URL url, String fileName) {
		this.url = url;
		this.fileName = fileName;
		this.useUniqueFileName = true;
	}

	public FileCreateRequest(String base64, String fileName) {
		this.base64 = base64;
		this.fileName = fileName;
		this.useUniqueFileName = true;
	}

	public FileCreateRequest(byte[] bytes, String fileName) {
		this.bytes = bytes;
		this.fileName = fileName;
		this.useUniqueFileName = true;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isUseUniqueFileName() {
		return useUniqueFileName;
	}

	public void setUseUniqueFileName(boolean useUniqueFileName) {
		this.useUniqueFileName = useUniqueFileName;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public boolean isPrivateFile() {
		return isPrivateFile;
	}

	public void setPrivateFile(boolean privateFile) {
		isPrivateFile = privateFile;
	}

	public String getCustomCoordinates() {
		return customCoordinates;
	}

	public void setCustomCoordinates(String customCoordinates) {
		this.customCoordinates = customCoordinates;
	}

	public List<String> getResponseFields() {
		return responseFields;
	}

	public void setResponseFields(List<String> responseFields) {
		this.responseFields = responseFields;
	}

	public JsonArray getExtensions() {
		return extensions;
	}

	public void setExtensions(JsonArray extensions) {
		this.extensions = extensions;
	}

	public String getWebhookUrl() {
		return webhookUrl;
	}

	public void setWebhookUrl(String webhookUrl) {
		this.webhookUrl = webhookUrl;
	}

	public Boolean isOverwriteFile() {
		return overwriteFile;
	}

	public void setOverwriteFile(Boolean overwriteFile) {
		this.overwriteFile = overwriteFile;
	}

	public Boolean isOverwriteAITags() {
		return overwriteAITags;
	}

	public void setOverwriteAITags(Boolean overwriteAITags) {
		this.overwriteAITags = overwriteAITags;
	}

	public Boolean isOverwriteTags() {
		return overwriteTags;
	}

	public void setOverwriteTags(Boolean overwriteTags) {
		this.overwriteTags = overwriteTags;
	}

	public Boolean isOverwriteCustomMetadata() {
		return overwriteCustomMetadata;
	}

	public void setOverwriteCustomMetadata(Boolean overwriteCustomMetadata) {
		this.overwriteCustomMetadata = overwriteCustomMetadata;
	}

	public JsonObject getCustomMetadata() {
		return customMetadata;
	}

	public void setCustomMetadata(JsonObject customMetadata) {
		this.customMetadata = customMetadata;
	}

	@Override
	public String toString() {
		return "FileCreateRequest{" + "fileName='" + fileName + '\'' + ", useUniqueFileName=" + useUniqueFileName
				+ ", tags=" + tags + ", folder='" + folder + '\'' + ", isPrivateFile=" + isPrivateFile
				+ ", customCoordinates=" + customCoordinates + ", responseFields=" + responseFields + ", extensions="
				+ extensions + ", webhookUrl='" + webhookUrl + '\'' + ", overwriteFile=" + overwriteFile
				+ ", overwriteAITags=" + overwriteAITags + ", overwriteTags=" + overwriteTags
				+ ", overwriteCustomMetadata=" + overwriteCustomMetadata + ", customMetadata=" + customMetadata + '}';
	}
}
