package io.imagekit.sdk.config;

/**
 * Configuration class contains sdk configuration
 */
public class Configuration {
	private String publicKey;
	private String privateKey;
	private String urlEndpoint;

	public Configuration() {

	}

	public Configuration(String publicKey, String privateKey, String urlEndpoint) {
		this.publicKey = publicKey;
		this.privateKey = privateKey;
		this.urlEndpoint = urlEndpoint;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getUrlEndpoint() {
		return urlEndpoint;
	}

	public void setUrlEndpoint(String urlEndpoint) {
		this.urlEndpoint = urlEndpoint;
	}

	@Override
	public String toString() {
		return "Configuration{" + "publicKey='" + publicKey + '\'' + ", privateKey='" + privateKey + '\''
				+ ", urlEndpoint='" + urlEndpoint + '\'' + '}';
	}

	public boolean validate() {
		if (urlEndpoint == null) {
			throw new RuntimeException("UrlEndpoint not found in config.properties");
		}
		if (privateKey == null) {
			throw new RuntimeException("PrivateKey not found in config.properties");
		}
		if (publicKey == null) {
			throw new RuntimeException("PublicKey not found in config.properties");
		}
		return true;
	}
}
