package io.imagekit.sdk.models;

public class DeleteFileVersionRequest {
    public String fileId;
    public String versionId;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    @Override
    public String toString() {
        return "DeleteFileVersionRequest{" +
                "fileId='" + fileId + '\'' +
                ", versionId='" + versionId + '\'' +
                '}';
    }
}
