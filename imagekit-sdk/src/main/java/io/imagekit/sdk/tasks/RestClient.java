package io.imagekit.sdk.tasks;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ConflictException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.NotFoundException;
import io.imagekit.sdk.exceptions.PartialSuccessException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.AITagsRequest;
import io.imagekit.sdk.models.BaseFile;
import io.imagekit.sdk.models.CopyFileRequest;
import io.imagekit.sdk.models.CopyFolderRequest;
import io.imagekit.sdk.models.CreateFolderRequest;
import io.imagekit.sdk.models.CustomMetaDataFieldCreateRequest;
import io.imagekit.sdk.models.CustomMetaDataFieldUpdateRequest;
import io.imagekit.sdk.models.DeleteFileVersionRequest;
import io.imagekit.sdk.models.DeleteFolderRequest;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.MoveFileRequest;
import io.imagekit.sdk.models.MoveFolderRequest;
import io.imagekit.sdk.models.MetaData;
import io.imagekit.sdk.models.FileUpdateRequest;
import io.imagekit.sdk.models.RenameFileRequest;
import io.imagekit.sdk.models.TagsRequest;
import io.imagekit.sdk.models.results.*;
import io.imagekit.sdk.utils.Utils;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RestClient {

	public static String API_BASE_URL = "https://api.imagekit.io/";
	public static String UPLOAD_BASE_URL = "https://upload.imagekit.io/";

	private ImageKit imageKit;
	Request request;
	OkHttpClient client;
	MultipartBuilder multipartBuilder;

	public RestClient(ImageKit imageKit) {
		this.imageKit = imageKit;
		this.client = new OkHttpClient();
		this.multipartBuilder = new MultipartBuilder();
	}

	public Result upload(FileCreateRequest fileCreateRequest) throws InternalServerException, BadRequestException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {
		Result result = null;
		Map<String, String> headers = Utils.getHeaders(imageKit);

		MultipartBody body = multipartBuilder.build(fileCreateRequest);

		request = new Request.Builder().url(UPLOAD_BASE_URL.concat("api/v1/files/upload")).post(body)
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				result = new Gson().fromJson(respBody, Result.class);
				result.setRaw(respBody);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return result;
	}

	public Result updateFileDetail(FileUpdateRequest fileUpdateRequest)
			throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException,
			BadRequestException, UnknownException {
		Result result = null;
		Map<String, String> headers = Utils.getHeaders(imageKit);
		String url = String.format(Locale.US, API_BASE_URL.concat("v1/files/%s/details"),
				fileUpdateRequest.getFileId());
		request = new Request.Builder().url(url).patch(multipartBuilder.build(fileUpdateRequest))
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				result = new Gson().fromJson(respBody, Result.class);
				result.setRaw(respBody);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return result;
	}

	public ResultList getFileList(Map<String, String> options) throws ForbiddenException, TooManyRequestsException,
			InternalServerException, UnauthorizedException, BadRequestException, UnknownException {
		ResultList resultList = new ResultList();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		QueryMaker queryMaker = new QueryMaker();

		for (Map.Entry<String, String> entry : options.entrySet()) {
			queryMaker.put(String.format("%s=%s", entry.getKey(), entry.getValue()));
		}

		String url = String.format(Locale.US, API_BASE_URL.concat("v1/files?%s"), queryMaker.get());

		request = new Request.Builder().url(url).get().headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				List<BaseFile> files = new Gson().fromJson(respBody, new TypeToken<List<BaseFile>>() {
				}.getType());
				resultList.setResults(files);
				resultList.setRaw(respBody);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultList.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultList;
	}

	public Result getFileDetail(String fileId) throws ForbiddenException, TooManyRequestsException,
			InternalServerException, UnauthorizedException, BadRequestException, UnknownException {
		Result result = new Result();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		String url = String.format(Locale.US, API_BASE_URL.concat("v1/files/%s/details"), fileId);

		request = new Request.Builder().url(url).get().headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				result = new Gson().fromJson(respBody, Result.class);
				result.setRaw(respBody);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return result;
	}

	public ResultMetaData getFileMetaData(String fileId) throws ForbiddenException, TooManyRequestsException,
			InternalServerException, UnauthorizedException, BadRequestException, UnknownException {
		ResultMetaData result = new ResultMetaData();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		String url = String.format(Locale.US, API_BASE_URL.concat("v1/files/%s/metadata"), fileId);

		request = new Request.Builder().url(url).get().headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				MetaData metaData = new Gson().fromJson(respBody, MetaData.class);
				result.setResults(metaData);
				result.setRaw(respBody);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return result;
	}

	public ResultMetaData getRemoteFileMetaData(String url) throws ForbiddenException, TooManyRequestsException,
			InternalServerException, UnauthorizedException, BadRequestException, UnknownException {
		ResultMetaData result = new ResultMetaData();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		String apiURL = API_BASE_URL.concat("v1/metadata?url=") + url;

		request = new Request.Builder().url(apiURL).get().headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				MetaData metaData = new Gson().fromJson(respBody, MetaData.class);
				result.setResults(metaData);
				result.setRaw(respBody);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return result;
	}

	public Result deleteFile(String fileId) throws ForbiddenException, TooManyRequestsException,
			InternalServerException, UnauthorizedException, BadRequestException, UnknownException {
		Result result = new Result();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		String url = String.format(Locale.US, API_BASE_URL.concat("v1/files/%s"), fileId);

		request = new Request.Builder().url(url).delete().headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 204) {
				respBody = response.body().string();
				result.setFileId(fileId);
				result.setRaw(respBody);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return result;
	}

	public ResultFileDelete bulkDeleteFiles(List<String> fileIds)
			throws ForbiddenException, TooManyRequestsException, InternalServerException, PartialSuccessException,
			UnauthorizedException, NotFoundException, BadRequestException, UnknownException {
		ResultFileDelete result = new ResultFileDelete();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		String url = API_BASE_URL.concat("v1/files/batch/deleteByFileIds");

		request = new Request.Builder().url(url)
				.post(multipartBuilder.build(String.format("{\"fileIds\":%s}", new Gson().toJson(fileIds))))
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				result = new Gson().fromJson(respBody, ResultFileDelete.class);
				result.setRaw(respBody);
			} else if (response.code() == 207 || response.code() == 404) {
				Utils.throwOtherException(response);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return result;
	}

	public ResultCache purgeCache(String url) throws ForbiddenException, TooManyRequestsException,
			InternalServerException, UnauthorizedException, BadRequestException, UnknownException {
		ResultCache result = new ResultCache();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		request = new Request.Builder().url(API_BASE_URL.concat("v1/files/purge"))
				.post(multipartBuilder.build(String.format("{\"url\":\"%s\"}", url))).headers(Headers.of(headers))
				.build();

		try {
			Response response = client.newCall(request).execute();
			System.out.println("res:==> " + response.request().body());
			String respBody = "";
			if (response.code() == 200 || response.code() == 201) {
				respBody = response.body().string();
				result = new Gson().fromJson(respBody, ResultCache.class);
				result.setRaw(respBody);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return result;
	}

	public ResultCacheStatus getPurgeCacheStatus(String requestId) throws ForbiddenException, TooManyRequestsException,
			InternalServerException, UnauthorizedException, BadRequestException, UnknownException {
		ResultCacheStatus result = new ResultCacheStatus();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		String url = String.format(Locale.US, API_BASE_URL.concat("v1/files/purge/%s"), requestId);

		request = new Request.Builder().url(url).get().headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				result = new Gson().fromJson(respBody, ResultCacheStatus.class);
				result.setRaw(respBody);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, result.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return result;
	}

	private ResultTags manageTags(TagsRequest tagsRequest, String action)
			throws NotFoundException, PartialSuccessException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {
		ResultTags resultTags = new ResultTags();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"),
				new Gson().toJson(tagsRequest));
		request = new Request.Builder()
				.url(action.equals("removeTags") ? API_BASE_URL.concat("v1/files/removeTags")
						: API_BASE_URL.concat("v1/files/addTags"))
				.post(requestBody).headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				resultTags = new Gson().fromJson(respBody, ResultTags.class);
			} else if (response.code() == 207 || response.code() == 404) {
				Utils.throwOtherException(response);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultTags.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultTags;
	}

	public ResultTags removeAITags(AITagsRequest aiTagsRequest)
			throws PartialSuccessException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {
		ResultTags resultTags = new ResultTags();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"),
				new Gson().toJson(aiTagsRequest));
		request = new Request.Builder().url(API_BASE_URL.concat("v1/files/removeAITags")).post(requestBody)
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				resultTags = new Gson().fromJson(respBody, ResultTags.class);
			} else if (response.code() == 207 || response.code() == 404) {
				Utils.throwOtherException(response);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultTags.getResponseMetaData(), response.code(),
					response.headers().toMultimap());

		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultTags;
	}

	public ResultCustomMetaDataFieldList getCustomMetaDataFields(boolean includeDeleted) throws UnknownException {
		ResultCustomMetaDataFieldList resultCustomMetaDataFieldList = new ResultCustomMetaDataFieldList();

		Map<String, String> headers = Utils.getHeaders(imageKit);

		request = new Request.Builder()
				.url(API_BASE_URL.concat("v1/customMetadataFields?includeDeleted=" + includeDeleted)).get()
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				List<ResultCustomMetaDataField> resultCustomMetaDataFields = new Gson().fromJson(respBody,
						new TypeToken<List<ResultCustomMetaDataField>>() {
						}.getType());
				resultCustomMetaDataFieldList.setResultCustomMetaDataFieldList(resultCustomMetaDataFields);
			}
			Utils.populateResponseMetadata(respBody, resultCustomMetaDataFieldList.getResponseMetaData(),
					response.code(), response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultCustomMetaDataFieldList;
	}

	public ResultCustomMetaDataField createCustomMetaDataFields(
			CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest)
			throws BadRequestException, UnknownException {
		if (customMetaDataFieldCreateRequest.getName() == null) {
			throw new RuntimeException("Error: Name not provided.");
		}
		if (customMetaDataFieldCreateRequest.getLabel() == null) {
			throw new RuntimeException("Error: Label not provided.");
		}
		ResultCustomMetaDataField resultCustomMetaDataField = new ResultCustomMetaDataField();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"),
				new Gson().toJson(customMetaDataFieldCreateRequest));
		request = new Request.Builder().url(API_BASE_URL.concat("v1/customMetadataFields")).post(requestBody)
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 201) {
				respBody = response.body().string();
				JsonElement responseBody = new JsonParser().parse(respBody);
				resultCustomMetaDataField = new Gson().fromJson(responseBody, ResultCustomMetaDataField.class);
			} else {
				if (response.code() == 400) {
					ResultException result = Utils.populateResult(response);
					throw new BadRequestException(result.getMessage(), null, false, false, result.getMessage(),
							result.getHelp(), result.getResponseMetaData());
				}
			}
			Utils.populateResponseMetadata(respBody, resultCustomMetaDataField.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultCustomMetaDataField;
	}

	public ResultNoContent deleteCustomMetaDataField(String id) throws NotFoundException, UnknownException {
		ResultNoContent resultNoContent = new ResultNoContent();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		String url = String.format(Locale.US, API_BASE_URL.concat("v1/customMetadataFields/%s"), id);

		request = new Request.Builder().url(url).delete().headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 204) {
				String respString = response.body().string();
				respBody = respString == null ? "" : respString;
			} else {
				if (response.code() == 404) {
					ResultException result = Utils.populateResult(response);
					throw new NotFoundException(result.getMessage(), null, false, false, result.getMessage(),
							result.getHelp(), result.getResponseMetaData());
				}
			}
			Utils.populateResponseMetadata(respBody, resultNoContent.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultNoContent;
	}

	public ResultCustomMetaDataField updateCustomMetaDataFields(
			CustomMetaDataFieldUpdateRequest customMetaDataFieldUpdateRequest)
			throws BadRequestException, NotFoundException, UnknownException {
		ResultCustomMetaDataField resultCustomMetaDataField = new ResultCustomMetaDataField();

		Map<String, String> headers = Utils.getHeaders(imageKit);

		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"),
				new Gson().toJson(customMetaDataFieldUpdateRequest));
		String url = String.format(Locale.US, API_BASE_URL.concat("v1/customMetadataFields/%s"),
				customMetaDataFieldUpdateRequest.getId());
		request = new Request.Builder().url(url).patch(requestBody).headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				JsonElement responseBody = new JsonParser().parse(respBody);
				resultCustomMetaDataField = new Gson().fromJson(responseBody, ResultCustomMetaDataField.class);
			} else {
				if (response.code() == 400 || response.code() == 404) {
					ResultException result = Utils.populateResult(response);
					if (response.code() == 400) {
						throw new BadRequestException(result.getMessage(), null, false, false, result.getMessage(),
								result.getHelp(), result.getResponseMetaData());
					} else {
						throw new NotFoundException(result.getMessage(), null, false, false, result.getMessage(),
								result.getHelp(), result.getResponseMetaData());
					}
				}
			}
			Utils.populateResponseMetadata(respBody, resultCustomMetaDataField.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultCustomMetaDataField;
	}

	public ResultNoContent deleteFileVersion(DeleteFileVersionRequest deleteFileVersionRequest)
			throws BadRequestException, NotFoundException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {
		ResultNoContent resultNoContent = new ResultNoContent();

		Map<String, String> headers = Utils.getHeaders(imageKit);

		String url = String.format(Locale.US, API_BASE_URL.concat("v1/files/%s/versions/%s"),
				deleteFileVersionRequest.getFileId(), deleteFileVersionRequest.getVersionId());
		request = new Request.Builder().url(url).delete().headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 204) {
				String respString = response.body().string();
				respBody = respString == null ? "" : respString;
			} else if (response.code() == 400 || response.code() == 404) {
				ResultException result = Utils.populateResult(response);
				if (response.code() == 400) {
					throw new BadRequestException(result.getMessage(), null, false, false, result.getMessage(),
							result.getHelp(), result.getResponseMetaData());
				} else {
					throw new NotFoundException(result.getMessage(), null, false, false, result.getMessage(),
							result.getHelp(), result.getResponseMetaData());
				}
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultNoContent.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultNoContent;
	}

	public ResultNoContent copyFile(CopyFileRequest copyFileRequest)
			throws NotFoundException, BadRequestException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {
		ResultNoContent resultNoContent = new ResultNoContent();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"),
				new Gson().toJson(copyFileRequest));
		request = new Request.Builder().url(API_BASE_URL.concat("v1/files/copy")).post(requestBody)
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 204) {
				String respString = response.body().string();
				respBody = respString == null ? "" : respString;
			} else if (response.code() == 404) {
				ResultException result = Utils.populateResult(response);
				throw new NotFoundException(result.getMessage(), null, false, false, result.getMessage(),
						result.getHelp(), result.getResponseMetaData());
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultNoContent.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultNoContent;
	}

	public ResultNoContent moveFile(MoveFileRequest moveFileRequest)
			throws NotFoundException, BadRequestException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {
		ResultNoContent resultNoContent = new ResultNoContent();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"),
				new Gson().toJson(moveFileRequest));
		request = new Request.Builder().url(API_BASE_URL.concat("v1/files/move")).post(requestBody)
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 204) {
				String respString = response.body().string();
				respBody = respString == null ? "" : respString;
			} else if (response.code() == 404) {
				ResultException result = Utils.populateResult(response);
				throw new NotFoundException(result.getMessage(), null, false, false, result.getMessage(),
						result.getHelp(), result.getResponseMetaData());
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultNoContent.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultNoContent;
	}

	public ResultRenameFile renameFile(RenameFileRequest renameFileRequest) throws PartialSuccessException,
			ConflictException, NotFoundException, BadRequestException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {
		ResultRenameFile resultRenameFile = new ResultRenameFile();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"),
				new Gson().toJson(renameFileRequest));
		request = new Request.Builder().url(API_BASE_URL.concat("v1/files/rename")).put(requestBody)
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				String respString = response.body().string();
				respBody = respString == null || respString.equals("") ? "{}" : respString;
				resultRenameFile = new Gson().fromJson(respBody, ResultRenameFile.class);
			} else if (response.code() == 207 || response.code() == 404) {
				Utils.throwOtherException(response);
			} else if (response.code() == 409) {
				ResultException result = Utils.populateResult(response);
				throw new ConflictException(result.getMessage(), null, false, false, result.getMessage(),
						result.getHelp(), result.getResponseMetaData());
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultRenameFile.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultRenameFile;
	}

	public Result restoreFileVersion(String fileId, String versionId)
			throws NotFoundException, BadRequestException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {
		Result resultFileVersionDetails = new Result();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		String url = String.format(Locale.US, API_BASE_URL.concat("v1/files/%s/versions/%s/restore"), fileId,
				versionId);
		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"), "");
		request = new Request.Builder().url(url).put(requestBody).headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				System.out.println("20000000000000");
				respBody = response.body().string();
				resultFileVersionDetails = new Gson().fromJson(respBody, Result.class);
			} else if (response.code() == 404) {
				System.out.println("400000000000004");
				ResultException result = Utils.populateResult(response);
				throw new NotFoundException(result.getMessage(), null, false, false, result.getMessage(),
						result.getHelp(), result.getResponseMetaData());
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultFileVersionDetails.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultFileVersionDetails;
	}

	public ResultEmptyBlock createFolder(CreateFolderRequest createFolderRequest) throws UnknownException {
		ResultEmptyBlock resultEmptyBlock = new ResultEmptyBlock();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"),
				new Gson().toJson(createFolderRequest));
		request = new Request.Builder().url(API_BASE_URL.concat("v1/folder/")).post(requestBody)
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 201) {
				String respString = response.body().string();
				respBody = respString == null || respString.equals("") ? "{}" : respString;
			}
			Utils.populateResponseMetadata(respBody, resultEmptyBlock.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultEmptyBlock;
	}

	public ResultNoContent deleteFolder(DeleteFolderRequest deleteFolderRequest)
			throws NotFoundException, BadRequestException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {
		ResultNoContent resultNoContent = new ResultNoContent();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"),
				new Gson().toJson(deleteFolderRequest));
		request = new Request.Builder().url(API_BASE_URL.concat("v1/folder/")).delete(requestBody)
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 204) {
				String respString = response.body().string();
				respBody = respString == null ? "" : respString;
			} else if (response.code() == 404) {
				ResultException result = Utils.populateResult(response);
				throw new NotFoundException(result.getMessage(), null, false, false, result.getMessage(),
						result.getHelp(), result.getResponseMetaData());
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultNoContent.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultNoContent;
	}

	public ResultOfFolderActions copyFolder(CopyFolderRequest copyFolderRequest)
			throws NotFoundException, BadRequestException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {
		ResultOfFolderActions resultOfFolderActions = new ResultOfFolderActions();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"),
				new Gson().toJson(copyFolderRequest));

		request = new Request.Builder().url(API_BASE_URL.concat("v1/bulkJobs/moveFolder")).post(requestBody)
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				resultOfFolderActions = new Gson().fromJson(respBody, ResultOfFolderActions.class);
			} else if (response.code() == 404) {
				ResultException result = Utils.populateResult(response);
				throw new NotFoundException(result.getMessage(), null, false, false, result.getMessage(),
						result.getHelp(), result.getResponseMetaData());
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultOfFolderActions.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultOfFolderActions;
	}

	public ResultOfFolderActions moveFolder(MoveFolderRequest moveFolderRequest)
			throws NotFoundException, BadRequestException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {
		ResultOfFolderActions resultOfFolderActions = new ResultOfFolderActions();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"),
				new Gson().toJson(moveFolderRequest));

		request = new Request.Builder().url(API_BASE_URL.concat("v1/bulkJobs/moveFolder")).post(requestBody)
				.headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				resultOfFolderActions = new Gson().fromJson(respBody, ResultOfFolderActions.class);
			} else if (response.code() == 404) {
				ResultException result = Utils.populateResult(response);
				throw new NotFoundException(result.getMessage(), null, false, false, result.getMessage(),
						result.getHelp(), result.getResponseMetaData());
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultOfFolderActions.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultOfFolderActions;
	}

	public ResultBulkJobStatus getBulkJobStatus(String jobId) throws ForbiddenException, TooManyRequestsException,
			InternalServerException, UnauthorizedException, BadRequestException, UnknownException {
		ResultBulkJobStatus resultBulkJobStatus = new ResultBulkJobStatus();

		Map<String, String> headers = Utils.getHeaders(imageKit);

		String url = String.format(Locale.US, API_BASE_URL.concat("v1/bulkJobs/%s"), jobId);

		request = new Request.Builder().url(url).get().headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				resultBulkJobStatus = new Gson().fromJson(respBody, ResultBulkJobStatus.class);
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultBulkJobStatus.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultBulkJobStatus;
	}

	public ResultFileVersions getFileVersions(String fileId)
			throws NotFoundException, BadRequestException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {
		ResultFileVersions resultFileVersions = new ResultFileVersions();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		String url = String.format(Locale.US, API_BASE_URL.concat("v1/files/%s/versions"), fileId);

		request = new Request.Builder().url(url).get().headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				List<ResultFileVersionDetails> resultFileVersionDetailsList = new Gson().fromJson(respBody,
						new TypeToken<List<ResultFileVersionDetails>>() {
						}.getType());
				resultFileVersions.setResultFileVersionDetailsList(resultFileVersionDetailsList);
			} else if (response.code() == 404) {
				ResultException result = Utils.populateResult(response);
				throw new NotFoundException(result.getMessage(), null, false, false, result.getMessage(),
						result.getHelp(), result.getResponseMetaData());
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultFileVersions.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultFileVersions;
	}

	public ResultFileVersionDetails getFileVersionDetails(String fileId, String versionId)
			throws NotFoundException, BadRequestException, InternalServerException, UnknownException,
			ForbiddenException, TooManyRequestsException, UnauthorizedException {
		if (fileId == null) {
			throw new RuntimeException("Error: FileId not provided.");
		}
		if (versionId == null) {
			throw new RuntimeException("Error: versionId not provided.");
		}
		ResultFileVersionDetails resultFileVersionDetails = new ResultFileVersionDetails();
		Map<String, String> headers = Utils.getHeaders(imageKit);

		String url = String.format(Locale.US, API_BASE_URL.concat("v1/files/%s/versions/%s"), fileId, versionId);

		request = new Request.Builder().url(url).get().headers(Headers.of(headers)).build();

		try {
			Response response = client.newCall(request).execute();
			String respBody = "";
			if (response.code() == 200) {
				respBody = response.body().string();
				resultFileVersionDetails = new Gson().fromJson(respBody, ResultFileVersionDetails.class);
			} else if (response.code() == 404) {
				ResultException result = Utils.populateResult(response);
				throw new NotFoundException(result.getMessage(), null, false, false, result.getMessage(),
						result.getHelp(), result.getResponseMetaData());
			} else {
				Utils.generalApiThrowException(response);
			}
			Utils.populateResponseMetadata(respBody, resultFileVersionDetails.getResponseMetaData(), response.code(),
					response.headers().toMultimap());
		} catch (IOException e) {
			throw new UnknownException(e.getMessage(), e.getCause());
		}
		return resultFileVersionDetails;
	}
}
