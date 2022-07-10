package io.imagekit.sdk;

import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.NotFoundException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.CopyFolderRequest;
import io.imagekit.sdk.models.CreateFolderRequest;
import io.imagekit.sdk.models.DeleteFolderRequest;
import io.imagekit.sdk.models.MoveFolderRequest;
import io.imagekit.sdk.tasks.RestClient;
import io.imagekit.sdk.utils.Utils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FolderOperationTest {
	private ImageKit SUT;

	@Before
	public void setUp() throws Exception {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
	}

	@Test
	public void createFolder_400_Expected() throws InterruptedException, IOException, UnknownException {

		CreateFolderRequest createFolderRequest = new CreateFolderRequest();
		createFolderRequest.setFolderName("/testFolder");
		createFolderRequest.setParentFolderPath("/");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(400));
		server.enqueue(
				new MockResponse().setBody("{\n" + "    \"message\": \"folderName parameter cannot have a slash.\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.createFolder(createFolderRequest);
		server.takeRequest();
	}

	@Test
	public void createFolder_successExpected() throws InterruptedException, IOException, UnknownException {

		CreateFolderRequest createFolderRequest = new CreateFolderRequest();
		createFolderRequest.setFolderName("testFolder");
		createFolderRequest.setParentFolderPath("/");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.createFolder(createFolderRequest);
		RecordedRequest request = server.takeRequest();

		String createFolderRequestJson = "{\"folderName\":\"testFolder\",\"parentFolderPath\":\"/\"}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(createFolderRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/folder/ HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/folder/"), request.getRequestUrl().toString());
	}

	@Test(expected = NotFoundException.class)
	public void deleteFolder_404_Expected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		DeleteFolderRequest deleteFolderRequest = new DeleteFolderRequest();
		deleteFolderRequest.setFolderPath("/testFolder");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(404)
				.setBody("{\n" + "    \"message\": \"No folder found with folderPath testFolder/\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
						+ "    \"reason\": \"FOLDER_NOT_FOUND\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.deleteFolder(deleteFolderRequest);
		server.takeRequest();
	}

	@Test
	public void deleteFolder_successExpected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		DeleteFolderRequest deleteFolderRequest = new DeleteFolderRequest();
		deleteFolderRequest.setFolderPath("testFolder");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(204).setBody(""));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.deleteFolder(deleteFolderRequest);
		RecordedRequest request = server.takeRequest();

		String deleteFolderRequestJson = "{\"folderPath\":\"testFolder\"}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(deleteFolderRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("DELETE /v1/folder/ HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/folder/"), request.getRequestUrl().toString());
	}

	@Test(expected = BadRequestException.class)
	public void copyFolder_400_Expected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		CopyFolderRequest copyFolderRequest = new CopyFolderRequest();
		copyFolderRequest.setSourceFolderPath("/");
		copyFolderRequest.setDestinationPath("/test");
		copyFolderRequest.setIncludeFileVersions(false);

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(400)
				.setBody("{\n" + "    \"message\": \"sourceFolderPath cannot be root\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
						+ "    \"reason\": \"SOURCE_IS_ROOT\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.copyFolder(copyFolderRequest);
		server.takeRequest();
	}

	@Test(expected = NotFoundException.class)
	public void copyFolder_404_Expected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		CopyFolderRequest copyFolderRequest = new CopyFolderRequest();
		copyFolderRequest.setSourceFolderPath("/testFolder");
		copyFolderRequest.setDestinationPath("/test");
		copyFolderRequest.setIncludeFileVersions(true);

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(404)
				.setBody("{\n" + "    \"message\": \"No files & folder found at sourceFolderPath /testFolder\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
						+ "    \"reason\": \"NO_FILES_FOLDER\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.copyFolder(copyFolderRequest);
		server.takeRequest();
	}

	@Test
	public void copyFolder_successExpected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		CopyFolderRequest copyFolderRequest = new CopyFolderRequest();
		copyFolderRequest.setSourceFolderPath("/testFolder");
		copyFolderRequest.setDestinationPath("/Gallery");
		copyFolderRequest.setIncludeFileVersions(true);

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\n" + "    \"jobId\": \"629f43017eb0feff5c61f83c\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.copyFolder(copyFolderRequest);
		RecordedRequest request = server.takeRequest();

		String copyFolderRequestJson = "{\"sourceFolderPath\":\"/testFolder\",\"destinationPath\":\"/Gallery\",\"includeFileVersions\":true}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(copyFolderRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/bulkJobs/moveFolder HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/bulkJobs/moveFolder"), request.getRequestUrl().toString());
	}

	@Test(expected = NotFoundException.class)
	public void moveFolder_404_Expected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		MoveFolderRequest moveFolderRequest = new MoveFolderRequest();
		moveFolderRequest.setSourceFolderPath("/testFolder/");
		moveFolderRequest.setDestinationPath("/Gallery");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setResponseCode(404)
				.setBody("{\n" + "    \"message\": \"No files & folder found at sourceFolderPath /testFolder\",\n"
						+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\",\n"
						+ "    \"reason\": \"NO_FILES_FOLDER\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.moveFolder(moveFolderRequest);
		server.takeRequest();
	}

	@Test
	public void moveFolder_successExpected()
			throws InterruptedException, IOException, NotFoundException, BadRequestException, InternalServerException,
			UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException {

		MoveFolderRequest moveFolderRequest = new MoveFolderRequest();
		moveFolderRequest.setSourceFolderPath("/testFolder");
		moveFolderRequest.setDestinationPath("/Gallery");

		MockWebServer server = new MockWebServer();
		server.enqueue(new MockResponse().setBody("{\n" + "    \"jobId\": \"629f44ac7eb0fe8173622d4b\"\n" + "}"));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.moveFolder(moveFolderRequest);
		RecordedRequest request = server.takeRequest();

		String moveFolderRequestJson = "{\"sourceFolderPath\":\"/testFolder\",\"destinationPath\":\"/Gallery\"}";
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals(moveFolderRequestJson, utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/bulkJobs/moveFolder HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/bulkJobs/moveFolder"), request.getRequestUrl().toString());
	}
}
