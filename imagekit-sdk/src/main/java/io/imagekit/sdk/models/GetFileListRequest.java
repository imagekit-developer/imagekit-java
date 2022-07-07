package io.imagekit.sdk.models;

import java.util.Arrays;

public class GetFileListRequest {
	public String type;
	public String sort;
	public String path;
	public String searchQuery;
	public String fileType;
	public String limit;
	public String skip;
	public String[] tags;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getSkip() {
		return skip;
	}

	public void setSkip(String skip) {
		this.skip = skip;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "GetFileListRequest{" +
				"type='" + type + '\'' +
				", sort='" + sort + '\'' +
				", path='" + path + '\'' +
				", searchQuery='" + searchQuery + '\'' +
				", fileType='" + fileType + '\'' +
				", limit='" + limit + '\'' +
				", skip='" + skip + '\'' +
				", tags=" + Arrays.toString(tags) +
				'}';
	}
}
