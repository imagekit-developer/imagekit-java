package io.imagekit.sdk;

import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.utils.Utils;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ImageKitTest {
	private ImageKit SUT;

	@Before
	public void setUp() throws Exception {
		SUT = ImageKit.getInstance();
		SUT.setConfig(Utils.getSystemConfig(ImageKitTest.class));
	}

	@Test
	public void imageKit_configurationTest() {
		Configuration config = new Configuration();
		config.setPrivateKey("private_Key");
		config.setPublicKey("public_key");
		config.setUrlEndpoint("url_end_point");
		ImageKit.getInstance().setConfig(config);
		assertEquals(config.toString(), ImageKit.getInstance().getConfig().toString());
	}

	@Test
	public void withoutToken_getAuthenticationParameters_successExpected() {
		Map<String, String> auth = SUT.getAuthenticationParameters();
		assertNotNull(auth);
	}

	@Test(expected = RuntimeException.class)
	public void withoutPrivateKey_getAuthenticationParameters_successExpected() {
		SUT.getConfig().setPrivateKey(null);
		Map<String, String> auth = SUT.getAuthenticationParameters();
		assertNotNull(auth);
	}

	@Test
	public void withTokenAndExpire_getAuthenticationParameters_successExpected() {
		Map<String, String> auth = SUT.getAuthenticationParameters("your_token", 1582269249);
		assertNotNull(auth);
		assertEquals("your_token", auth.get("token"));
		assertEquals("1582269249", auth.get("expire"));
		assertEquals("98598e12a8eec9fedc883df4ae598618aaf24d87", auth.get("signature"));
	}

	@Test
	public void sameImage_getHammingDistance_expectedSuccessWith() {
		int hammingDistance = SUT.pHashDistance("f06830ca9f1e3e90", "f06830ca9f1e3e90");
		assertEquals(0, hammingDistance);
	}

	@Test
	public void similarImage_getHammingDistance_expectedSuccessWith() {
		int hammingDistance = SUT.pHashDistance("33699c96619cc69e", "968e978414fe04ea");
		assertEquals(30, hammingDistance);
	}

	@Test
	public void dissimilarImage_getHammingDistance_expectedSuccessWith() {
		int hammingDistance = SUT.pHashDistance("a4a65595ac94518b", "7838873e791f8400");
		assertEquals(37, hammingDistance);
	}

	@Test(expected = RuntimeException.class)
	public void invalidHash_getHammingDistance_throwException() {
		int hammingDistance = SUT.pHashDistance("a4a65595ac94518Z", "7838873e791f8400");
	}

	@Test(expected = RuntimeException.class)
	public void differentLength_getHammingDistance_throwException() {
		int hammingDistance = SUT.pHashDistance("a4a65595ac94518b3", "7838873e791f8400");
	}

}