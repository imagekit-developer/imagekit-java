package io.imagekit.sdk.models;

public class CopyFileRequest {
	public String sourceFilePath;
	public String destinationPath;
	public Boolean includeFileVersions;

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

	public Boolean getIncludeFileVersions() {
		return includeFileVersions;
	}

	public void setIncludeFileVersions(Boolean includeFileVersions) {
		this.includeFileVersions = includeFileVersions;
	}

	@Override
	public String toString() {
		return "CopyFileRequest{" + "sourceFilePath=" + sourceFilePath + ", destinationPath=" + destinationPath
				+ ", includeFileVersions=" + includeFileVersions + '}';
	}
}
