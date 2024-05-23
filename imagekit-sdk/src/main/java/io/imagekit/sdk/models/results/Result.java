package io.imagekit.sdk.models.results;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import io.imagekit.sdk.models.BaseFile;
import io.imagekit.sdk.models.ResponseMetaData;
import io.imagekit.sdk.utils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result extends BaseFile {
	private BufferedImage image;
	private String help;
	@Deprecated
	private String raw;
	private ResponseMetaData responseMetaData = new ResponseMetaData();

	public Result() {
	}

	public Result(String fileId, String name, String url, String thumbnail, int height, int width, long size,
			String filePath, List<String> tags, boolean isPrivateFile, String customCoordinates, String fileType,
			JsonArray aiTags, JsonObject versionInfo, JsonObject customMetadata, JsonObject embeddedMetadata,
			JsonObject extensionStatus, String type, String mime, Boolean hasAlpha, Date createdAt, Date updatedAt) {
		this.fileId = fileId;
		this.name = name;
		this.url = url;
		this.thumbnail = thumbnail;
		this.height = height;
		this.width = width;
		this.size = size;
		this.filePath = filePath;
		this.tags = tags;
		this.isPrivateFile = isPrivateFile;
		this.customCoordinates = customCoordinates;
		this.fileType = fileType;
		this.aiTags = aiTags;
		this.versionInfo = versionInfo;
		this.customMetadata = customMetadata;
		this.embeddedMetadata = embeddedMetadata;
		this.extensionStatus = extensionStatus;
		this.type = type;
		this.mime = mime;
		this.hasAlpha = hasAlpha;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getHelp() {
		return help;
	}

	public String getRaw() {
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}

	@Deprecated
	public Map<String, Object> getMap() {
		if (null != raw) {
			return new Gson().fromJson(raw, new TypeToken<Map<String, Object>>() {
			}.getType());
		}
		return new HashMap<>();
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public boolean isPrivateFile() {
		return isPrivateFile;
	}

	public void setPrivateFile(boolean privateFile) {
		isPrivateFile = privateFile;
	}

	public String getCustomCoordinates() {
		return customCoordinates;
	}

	public void setCustomCoordinates(String customCoordinates) {
		this.customCoordinates = customCoordinates;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public ResponseMetaData getResponseMetaData() {
		return responseMetaData;
	}

	public void setResponseMetaData(ResponseMetaData responseMetaData) {
		this.responseMetaData = responseMetaData;
	}

	@Override
	public String toString() {
		return "Result{" + "fileId='" + fileId + '\'' + ", name='" + name + '\'' + ", url='" + url + '\''
				+ ", thumbnail='" + thumbnail + '\'' + ", height=" + height + ", width=" + width + ", size=" + size
				+ ", filePath='" + filePath + '\'' + ", tags=" + tags + ", isPrivateFile=" + isPrivateFile
				+ ", customCoordinates='" + customCoordinates + '\'' + ", fileType='" + fileType + '\'' + ", aiTags="
				+ aiTags + ", versionInfo=" + versionInfo + ", customMetadata=" + customMetadata + ", embeddedMetadata="
				+ embeddedMetadata + ", extensionStatus=" + extensionStatus + ", type='" + type + '\'' + ", mime='"
				+ mime + '\'' + ", hasAlpha=" + hasAlpha + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", help='" + help + '\'' + ", raw='" + raw + '\'' + ", responseMetaData=" + responseMetaData + '}';
	}
}
