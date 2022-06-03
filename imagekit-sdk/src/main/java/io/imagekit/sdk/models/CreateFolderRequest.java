package io.imagekit.sdk.models;

public class CreateFolderRequest {
    public String folderName;
    public String parentFolderPath;

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getParentFolderPath() {
        return parentFolderPath;
    }

    public void setParentFolderPath(String parentFolderPath) {
        this.parentFolderPath = parentFolderPath;
    }

    @Override
    public String toString() {
        return "DeleteFolderRequest{" +
                "folderName=" + folderName +
                "parentFolderPath=" + parentFolderPath +
                '}';
    }
}
