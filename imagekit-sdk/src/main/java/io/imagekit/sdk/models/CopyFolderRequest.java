package io.imagekit.sdk.models;

public class CopyFolderRequest {
    public String sourceFolderPath;
    public String destinationPath;
    public Boolean includeVersions;

    public String getSourceFolderPath() {
        return sourceFolderPath;
    }

    public void setSourceFolderPath(String sourceFolderPath) {
        this.sourceFolderPath = sourceFolderPath;
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    public Boolean getIncludeVersions() {
        return includeVersions;
    }

    public void setIncludeVersions(Boolean includeVersions) {
        this.includeVersions = includeVersions;
    }

    @Override
    public String toString() {
        return "TagsRequest{" +
                "sourceFolderPath=" + sourceFolderPath +
                ", destinationPath=" + destinationPath +
                ", includeVersions=" + includeVersions +
                '}';
    }
}
