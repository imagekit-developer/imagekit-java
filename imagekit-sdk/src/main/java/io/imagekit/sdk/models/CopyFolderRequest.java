package io.imagekit.sdk.models;

public class CopyFolderRequest {
	public String sourceFolderPath;
	public String destinationPath;
	public Boolean includeFileVersions;

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

	public Boolean getIncludeFileVersions() {
		return includeFileVersions;
	}

	public void setIncludeFileVersions(Boolean includeFileVersions) {
		this.includeFileVersions = includeFileVersions;
	}

	@Override
	public String toString() {
		return "CopyFolderRequest{" + "sourceFolderPath=" + sourceFolderPath + ", destinationPath=" + destinationPath
				+ ", includeFileVersions=" + includeFileVersions + '}';
	}
}
