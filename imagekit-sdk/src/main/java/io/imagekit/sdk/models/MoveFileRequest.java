package io.imagekit.sdk.models;

public class MoveFileRequest {
    public String sourceFilePath;
    public String destinationPath;

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    @Override
    public String toString() {
        return "MoveFileRequest{" +
                "sourceFilePath=" + sourceFilePath +
                ", destinationPath=" + destinationPath +
                '}';
    }
}
