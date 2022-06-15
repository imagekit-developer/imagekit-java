package io.imagekit.sdk.models.results;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultFileVersionDetails {

    protected String type;
    protected String name;
    protected String createdAt;
    protected String updatedAt;
    protected String fileId;
    protected List<String> tags;
    protected JsonArray aiTags;
    protected JsonObject versionInfo;
    protected JsonObject embeddedMetadata;
    protected String customCoordinates;
    protected JsonObject customMetadata;
    protected boolean isPrivateFile;
    protected String url;
    protected String thumbnail;
    protected String fileType;
    protected String filePath;
    protected int height;
    protected int width;
    protected long size;
    protected Boolean hasAlpha;
    protected String mime;
    private ResponseMetaData responseMetaData = new ResponseMetaData();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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

    public JsonObject getEmbeddedMetadata() {
        return embeddedMetadata;
    }

    public void setEmbeddedMetadata(JsonObject embeddedMetadata) {
        this.embeddedMetadata = embeddedMetadata;
    }

    public String getCustomCoordinates() {
        return customCoordinates;
    }

    public void setCustomCoordinates(String customCoordinates) {
        this.customCoordinates = customCoordinates;
    }

    public JsonObject getCustomMetadata() {
        return customMetadata;
    }

    public void setCustomMetadata(JsonObject customMetadata) {
        this.customMetadata = customMetadata;
    }

    public boolean isPrivateFile() {
        return isPrivateFile;
    }

    public void setPrivateFile(boolean privateFile) {
        isPrivateFile = privateFile;
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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public Boolean getHasAlpha() {
        return hasAlpha;
    }

    public void setHasAlpha(Boolean hasAlpha) {
        this.hasAlpha = hasAlpha;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public ResponseMetaData getResponseMetaData() {
        return responseMetaData;
    }

    public void setResponseMetaData(ResponseMetaData responseMetaData) {
        this.responseMetaData = responseMetaData;
    }

    @Override
    public String toString() {
        return "ResultFileVersion{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", fileId='" + fileId + '\'' +
                ", tags=" + tags +
                ", aiTags=" + aiTags +
                ", versionInfo=" + versionInfo +
                ", embeddedMetadata=" + embeddedMetadata +
                ", customCoordinates='" + customCoordinates + '\'' +
                ", customMetadata=" + customMetadata +
                ", isPrivateFile=" + isPrivateFile +
                ", url='" + url + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", fileType='" + fileType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", size=" + size +
                ", hasAlpha=" + hasAlpha +
                ", mime='" + mime + '\'' +
                ", responseMetaData=" + responseMetaData +
                '}';
    }
}
