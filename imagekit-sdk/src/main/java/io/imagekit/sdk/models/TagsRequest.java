package io.imagekit.sdk.models;

import java.util.List;
import java.util.stream.Collectors;

public class TagsRequest {
	public List<String> fileIds;
	public List<String> tags;

	public TagsRequest(List<String> fileIds, List<String> tags) {
		this.fileIds = fileIds;
		this.tags = tags;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getFileIds() {
		return fileIds;
	}

	public void setFileIds(List<String> fileIds) {
		this.fileIds = fileIds;
	}

	@Override
	public String toString() {
		return "TagsRequest{" + "fileIds=" + fileIds + ", tags=" + tags + '}';
	}
}
