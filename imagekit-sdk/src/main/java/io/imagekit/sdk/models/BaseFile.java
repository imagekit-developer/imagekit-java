package io.imagekit.sdk.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Date;
import java.util.List;

public class BaseFile {
	protected String fileId;
	protected String name;
	protected String url;
	protected String thumbnail;
	protected int height;
	protected int width;
	protected long size;
	protected String filePath;
	protected List<String> tags;
	protected boolean isPrivateFile;
	protected String customCoordinates;
	protected String fileType;
	protected JsonArray aiTags;
	protected JsonObject versionInfo;
	protected JsonObject customMetadata;
	protected JsonObject embeddedMetadata;
	protected JsonObject extensionStatus;
	protected String type;
	protected String mime;
	protected Boolean hasAlpha;
	protected Date createdAt;
	protected Date updatedAt;

	public BaseFile() {
	}

	public BaseFile(String fileId, String name, String url, String thumbnail, int height, int width, long size,
			String filePath, List<String> tags, boolean isPrivateFile, String customCoordinates, String fileType,
			JsonArray aiTags, JsonObject versionInfo, JsonObject customMetadata, JsonObject embeddedMetadata,
			JsonObject extensionStatus, String type, String mime, Boolean hasAlpha, Date createdAt, Date updatedAt) {
		this.fileId = fileId;
		this.name = name;
		this.url = url;
		this.thumbnail = thumbnail;
		this.height = height;
		this.width = width;
		this.size = size;
		this.filePath = filePath;
		this.tags = tags;
		this.isPrivateFile = isPrivateFile;
		this.customCoordinates = customCoordinates;
		this.fileType = fileType;
		this.aiTags = aiTags;
		this.versionInfo = versionInfo;
		this.customMetadata = customMetadata;
		this.embeddedMetadata = embeddedMetadata;
		this.extensionStatus = extensionStatus;
		this.type = type;
		this.mime = mime;
		this.hasAlpha = hasAlpha;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
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

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public JsonArray getAiTags() {
		return aiTags;
	}

	public void setAiTags(JsonArray aiTags) {
		this.aiTags = aiTags;
	}

	public JsonObject getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(JsonObject versionInfo) {
		this.versionInfo = versionInfo;
	}

	public JsonObject getCustomMetadata() {
		return customMetadata;
	}

	public void setCustomMetadata(JsonObject customMetadata) {
		this.customMetadata = customMetadata;
	}

	public JsonObject getEmbeddedMetadata() {
		return embeddedMetadata;
	}

	public void setEmbeddedMetadata(JsonObject embeddedMetadata) {
		this.embeddedMetadata = embeddedMetadata;
	}

	public JsonObject getExtensionStatus() {
		return extensionStatus;
	}

	public void setExtensionStatus(JsonObject extensionStatus) {
		this.extensionStatus = extensionStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public Boolean getHasAlpha() {
		return hasAlpha;
	}

	public void setHasAlpha(Boolean hasAlpha) {
		this.hasAlpha = hasAlpha;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "BaseFile{" + "fileId='" + fileId + '\'' + ", name='" + name + '\'' + ", url='" + url + '\''
				+ ", thumbnail='" + thumbnail + '\'' + ", height=" + height + ", width=" + width + ", size=" + size
				+ ", filePath='" + filePath + '\'' + ", tags='" + tags + '\'' + ", isPrivateFile=" + isPrivateFile
				+ ", customCoordinates='" + customCoordinates + '\'' + ", fileType='" + fileType + '\'' + ", aiTags="
				+ aiTags + ", versionInfo=" + versionInfo + ", customMetadata=" + customMetadata + ", embeddedMetadata="
				+ embeddedMetadata + ", extensionStatus=" + extensionStatus + ", type='" + type + '\'' + ", mime='"
				+ mime + '\'' + ", hasAlpha=" + hasAlpha + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ '}';
	}

}
