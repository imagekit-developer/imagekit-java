package io.imagekit.sdk.tasks;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.FileUpdateRequest;
import io.imagekit.sdk.utils.Utils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MultipartBuilder {
	private static final String RANDOM_BOUNDARY = "randomBoundary-------------------";
	public MultipartBody build(FileCreateRequest fileCreateRequest) {
		MultipartBody.Builder builder = new MultipartBody.Builder(RANDOM_BOUNDARY).setType(MultipartBody.FORM);

		if (null != fileCreateRequest.url) {
			builder.addFormDataPart("file", fileCreateRequest.url.toString());
		} else if (null != fileCreateRequest.base64) {
			builder.addFormDataPart("file", fileCreateRequest.base64);
		} else if (null != fileCreateRequest.bytes) {
			builder.addFormDataPart("file", Utils.bytesToBase64(fileCreateRequest.bytes));
		} else {
			throw new RuntimeException("Error: File not provided.");
		}
		if (null != fileCreateRequest.fileName) {
			builder.addFormDataPart("fileName", fileCreateRequest.fileName);
		} else {
			throw new RuntimeException("Error: Filename not provided");
		}
		if (fileCreateRequest.useUniqueFileName) {
			builder.addFormDataPart("useUniqueFileName", "true");
		} else {
			builder.addFormDataPart("useUniqueFileName", "false");
		}
		if (null != fileCreateRequest.tags) {
			builder.addFormDataPart("tags", Utils.listToString(fileCreateRequest.tags));
		}
		if (null != fileCreateRequest.folder) {
			builder.addFormDataPart("folder", fileCreateRequest.folder);
		}
		if (fileCreateRequest.isPrivateFile) {
			builder.addFormDataPart("isPrivateFile", "true");
		}
		if (null != fileCreateRequest.customCoordinates) {
			builder.addFormDataPart("customCoordinates", fileCreateRequest.customCoordinates);
		}
		if (null != fileCreateRequest.responseFields) {
			builder.addFormDataPart("responseFields", Utils.listToString(fileCreateRequest.responseFields));
		}
		if (fileCreateRequest.overwriteFile != null && !fileCreateRequest.overwriteFile) {
			builder.addFormDataPart("overwriteFile", String.valueOf(true));
		}
		if (fileCreateRequest.overwriteAITags != null && !fileCreateRequest.overwriteAITags) {
			builder.addFormDataPart("overwriteAITags", String.valueOf(Boolean.TRUE));
		}
		if (fileCreateRequest.overwriteTags != null && !fileCreateRequest.overwriteTags) {
			builder.addFormDataPart("overwriteTags", "true");
		}
		if (fileCreateRequest.overwriteCustomMetadata != null && !fileCreateRequest.overwriteCustomMetadata) {
			builder.addFormDataPart("overwriteCustomMetadata", "true");
		}
		if (null != fileCreateRequest.extensions) {
			builder.addFormDataPart("extensions", fileCreateRequest.extensions.toString());
		}
		if (null != fileCreateRequest.webhookUrl) {
			builder.addFormDataPart("webhookUrl", fileCreateRequest.webhookUrl);
		}
		if (null != fileCreateRequest.customMetadata) {
			builder.addFormDataPart("customMetadata",
					String.valueOf(new JsonParser().parse(String.valueOf(fileCreateRequest.customMetadata))));
		}
		return builder.build();
	}

	public RequestBody build(FileUpdateRequest fileUpdateRequest) {
		if (fileUpdateRequest.getFileId() == null) {
			throw new RuntimeException("Error: File Id not provided.");
		}
		if (fileUpdateRequest.getFileId().trim().length() < 1) {
			throw new RuntimeException("Error: File Id not provided.");
		}
		return RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
				new Gson().toJson(fileUpdateRequest));
	}

	public RequestBody build(String json) {
		if (json == null) {
			throw new RuntimeException("Error: You can't send null body.");
		} else {
			return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
		}
	}
}
