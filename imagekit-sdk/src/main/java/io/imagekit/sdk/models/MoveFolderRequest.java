package io.imagekit.sdk.models;

public class MoveFolderRequest {
	public String sourceFolderPath;
	public String destinationPath;

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

	@Override
	public String toString() {
		return "MoveFolderRequest{" + "sourceFolderPath=" + sourceFolderPath + ", destinationPath=" + destinationPath
				+ '}';
	}
}
