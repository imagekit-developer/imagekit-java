package io.imagekit.sdk.models.results;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.imagekit.sdk.models.BaseFile;
import io.imagekit.sdk.models.ResponseMetaData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result extends BaseFile {
    private boolean isSuccessful;
    private String message;
    private String help;
    private ResponseMetaData responseMetaData = new ResponseMetaData();

    public Result() {
    }

    public Result(String fileId, String name, String url, String thumbnail, int height, int width, long size, String filePath, List<String> tags, boolean isPrivateFile, String customCoordinates, String fileType) {
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

    public ResponseMetaData getResponseMetaData() {
        return responseMetaData;
    }

    public void setResponseMetaData(ResponseMetaData responseMetaData) {
        this.responseMetaData = responseMetaData;
    }

    @Override
    public String toString() {
        return "Result{" +
                "isSuccessful=" + isSuccessful +
                ", message='" + message + '\'' +
                ", help='" + help + '\'' +
                ", fileId='" + fileId + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", size=" + size +
                ", filePath='" + filePath + '\'' +
                ", tags='" + tags +'\''+
                ", isPrivateFile=" + isPrivateFile +
                ", customCoordinates='" + customCoordinates +'\''+
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
