package io.imagekit.sdk.models;

public class DeleteFolderRequest {
	public String folderPath;

	public String getFolderPath() {
		return folderPath;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}

	@Override
	public String toString() {
		return "DeleteFolderRequest{" + "folderPath=" + folderPath + '}';
	}
}
