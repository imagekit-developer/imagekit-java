package io.imagekit.sdk.models;

public class CopyFileRequest {
	public String sourceFilePath;
	public String destinationPath;
	public Boolean includeVersions;

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

	public Boolean getIncludeVersions() {
		return includeVersions;
	}

	public void setIncludeVersions(Boolean includeVersions) {
		this.includeVersions = includeVersions;
	}

	@Override
	public String toString() {
		return "CopyFileRequest{" + "sourceFilePath=" + sourceFilePath + ", destinationPath=" + destinationPath
				+ ", includeVersions=" + includeVersions + '}';
	}
}
