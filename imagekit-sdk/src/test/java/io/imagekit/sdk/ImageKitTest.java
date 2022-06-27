package io.imagekit.sdk;

import io.imagekit.sdk.config.Configuration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImageKitTest {

	@Test
	public void imageKit_configurationTest() {
		Configuration config = new Configuration();
		config.setPrivateKey("private_Key");
		config.setPublicKey("public_key");
		config.setUrlEndpoint("url_end_point");
		ImageKit.getInstance().setConfig(config);
		assertEquals(config.toString(), ImageKit.getInstance().getConfig().toString());
	}

}