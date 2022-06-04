package io.imagekit.sdk.models;

import java.util.List;

public class AITagsRequest {
    public List<String> fileIds;
    public List<String> AITags;

    public List<String> getFileIds() {
        return fileIds;
    }

    public void setFileIds(List<String> fileIds) {
        this.fileIds = fileIds;
    }

    public List<String> getAITags() {
        return AITags;
    }

    public void setAITags(List<String> AITags) {
        this.AITags = AITags;
    }

    @Override
    public String toString() {
        return "AITagsRequest{" +
                "fileIds=" + fileIds +
                ", AITags=" + AITags +
                '}';
    }
}
