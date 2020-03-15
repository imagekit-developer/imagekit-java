package io.imagekit.sdk.models;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.util.List;

public class FileUpdateRequest {
    private String fileId;
    private List<String> tags;
    private String customCoordinates;

    public FileUpdateRequest(String fileId) {
        this.fileId = fileId;
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

    public String getCustomCoordinates() {
        return customCoordinates;
    }

    public void setCustomCoordinates(String customCoordinates) {
        this.customCoordinates = customCoordinates;
    }

    @Override
    public String toString() {
        return "FileUpdateRequest{" +
                "fileId='" + fileId + '\'' +
                ", tags=" + tags +
                ", customCoordinates='" + customCoordinates + '\'' +
                '}';
    }
}
