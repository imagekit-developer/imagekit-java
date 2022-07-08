package io.imagekit.sdk.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class FileUpdateRequest {
    private String fileId;
    public List<String> removeAITags;

    public String webhookUrl;

    public JsonArray extensions;

    private List<String> tags;
    private String customCoordinates;

    public JsonObject customMetadata;

    public FileUpdateRequest(String fileId) {
        this.fileId = fileId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public List<String> getRemoveAITags() {
        return removeAITags;
    }

    public void setRemoveAITags(List<String> removeAITags) {
        this.removeAITags = removeAITags;
    }

    public String getWebhookUrl() {
        return webhookUrl;
    }

    public void setWebhookUrl(String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    public JsonArray getExtensions() {
        return extensions;
    }

    public void setExtensions(JsonArray extensions) {
        this.extensions = extensions;
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

    public JsonObject getCustomMetadata() {
        return customMetadata;
    }

    public void setCustomMetadata(JsonObject customMetadata) {
        this.customMetadata = customMetadata;
    }

    @Override
    public String toString() {
        return "FileUpdateRequest{" +
                "fileId='" + fileId + '\'' +
                ", removeAITags=" + removeAITags +
                ", webhookUrl='" + webhookUrl + '\'' +
                ", extensions=" + extensions +
                ", tags=" + tags +
                ", customCoordinates='" + customCoordinates + '\'' +
                ", customMetadata=" + customMetadata +
                '}';
    }
}
