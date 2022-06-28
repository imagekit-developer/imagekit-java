package io.imagekit.sdk;

import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.tasks.RestClient;
import io.imagekit.sdk.utils.Utils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PurgeCacheTest {

	private ImageKit SUT;

	@Before
	public void setUp() throws Exception {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
	}

	@Test(expected = BadRequestException.class)
	public void imageKit_purgeCache_404Expected()
			throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException,
			BadRequestException, UnknownException, InterruptedException, IOException {
		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"message\": \"Invalid url\"\n" + "}";
		server.enqueue(new MockResponse().setResponseCode(400).setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.purgeCache("url");

		server.takeRequest();
	}

	@Test
	public void imageKit_purgeCache_successExpected()
			throws IOException, ForbiddenException, TooManyRequestsException, InternalServerException,
			UnauthorizedException, BadRequestException, UnknownException, InterruptedException {
		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"requestId\": \"62b01f15214dfbdf3692dd0a\"\n" + "}";
		server.enqueue(new MockResponse().setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.purgeCache("https://ik.imagekit.io/zv3rkhsym/sample-image11_g1Qv0wpqP.jpg");

		RecordedRequest request = server.takeRequest();
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals("{\"url\":\"https://ik.imagekit.io/zv3rkhsym/sample-image11_g1Qv0wpqP.jpg\"}", utf8RequestBody);
		assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
		assertEquals("POST /v1/files/purge HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/files/purge"), request.getRequestUrl().toString());
	}

	@Test(expected = BadRequestException.class)
	public void imageKit_getPurgeCacheStatus_400Expected()
			throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException,
			BadRequestException, UnknownException, InterruptedException, IOException {
		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"message\": \"No request found for this requestId.\",\n"
				+ "    \"help\": \"For support kindly contact us at support@imagekit.io .\"\n" + "}";
		server.enqueue(new MockResponse().setResponseCode(400).setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.getPurgeCacheStatus("62b01f15214dfbdf3692dd0b");

		server.takeRequest();
	}

	@Test
	public void imageKit_getPurgeCacheStatus_successExpected()
			throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException,
			BadRequestException, UnknownException, InterruptedException, IOException {
		MockWebServer server = new MockWebServer();
		String responseJson = "{\n" + "    \"status\": \"Completed\"\n" + "}";
		server.enqueue(new MockResponse().setBody(responseJson));
		server.start();
		RestClient.API_BASE_URL = server.url("/").toString();
		SUT.getPurgeCacheStatus("62b01f15214dfbdf3692dd0a");

		RecordedRequest request = server.takeRequest();
		String utf8RequestBody = request.getBody().readUtf8();
		assertEquals("", utf8RequestBody);
		assertEquals("application/json", request.getHeader("Content-Type"));
		assertEquals("GET /v1/files/purge/62b01f15214dfbdf3692dd0a HTTP/1.1", request.getRequestLine());
		assertEquals(RestClient.API_BASE_URL.concat("v1/files/purge/62b01f15214dfbdf3692dd0a"),
				request.getRequestUrl().toString());
	}
}
