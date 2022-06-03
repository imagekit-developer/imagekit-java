package io.imagekit.sdk.models;

public class RenameFileRequest {
    public String filePath;
    public String newFileName;
    public Boolean purgeCache;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public Boolean getPurgeCache() {
        return purgeCache;
    }

    public void setPurgeCache(Boolean purgeCache) {
        this.purgeCache = purgeCache;
    }

    @Override
    public String toString() {
        return "RenameFileRequest{" +
                "filePath=" + filePath +
                ", newFileName=" + newFileName +
                ", purgeCache=" + purgeCache +
                '}';
    }
}
