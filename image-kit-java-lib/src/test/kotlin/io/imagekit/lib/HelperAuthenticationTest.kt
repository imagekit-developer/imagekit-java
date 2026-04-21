package io.imagekit.lib

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import kotlin.test.assertFailsWith
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelperAuthenticationTest {

    private val privateKey = "private_key_test"
    private val client = ImageKitOkHttpClient.builder().privateKey(privateKey).build()

    @Test
    fun `should return correct authentication parameters with provided token and expire`() {
        val token = "your_token"
        val expire = 1582269249L

        val params = client.helper().getAuthenticationParameters(token, expire)

        // Expected exact match with Node.js/Go SDK output
        val expectedSignature = "e71bcd6031016b060d349d212e23e85c791decdd"

        assertThat(params["token"]).isEqualTo(token)
        assertThat(params["expire"]).isEqualTo(expire)
        assertThat(params["signature"]).isEqualTo(expectedSignature)
    }

    @Test
    fun `should return authentication parameters with required properties when no params provided`() {
        val params = client.helper().getAuthenticationParameters(null, null)

        // Check that all required properties exist
        assertThat(params).containsKeys("token", "expire", "signature")

        // Token should be a 32-character hex string (16 bytes as hex)
        val token = params["token"] as String
        assertThat(token).matches("^[0-9a-f]{32}$")

        // Expire should be a number greater than current time
        val expire = params["expire"] as Long
        val currentTime = System.currentTimeMillis() / 1000
        assertThat(expire).isGreaterThan(currentTime)

        // Signature should be a hex string (40 characters for HMAC-SHA1)
        val signature = params["signature"] as String
        assertThat(signature).matches("^[a-f0-9]{40}$")
    }

    @Test
    fun `should handle edge case with expire time 0`() {
        val token = "test-token"
        val expire = 0L

        val params = client.helper().getAuthenticationParameters(token, expire)

        assertThat(params["token"]).isEqualTo(token)

        // When expire is 0 (falsy), it should use default expire time (30 minutes from now)
        val expireResult = params["expire"] as Long
        val expectedExpire = System.currentTimeMillis() / 1000 + 60 * 30

        // Allow a 10 second tolerance for test execution time
        assertThat(expireResult).isBetween(expectedExpire - 10, expectedExpire + 10)

        // Signature should be a hex string (40 characters for HMAC-SHA1)
        val signature = params["signature"] as String
        assertThat(signature).matches("^[a-f0-9]{40}$")
    }

    @Test
    fun `should handle empty string token`() {
        val token = "" // Empty string is falsy
        val expire = 1582269249L

        val params = client.helper().getAuthenticationParameters(token, expire)

        // Since empty string is falsy, it should generate a hex token
        val tokenResult = params["token"] as String
        assertThat(tokenResult).isNotEmpty()
        assertThat(tokenResult).matches("^[0-9a-f]{32}$")

        assertThat(params["expire"]).isEqualTo(expire)

        // Signature should be a hex string (40 characters for HMAC-SHA1)
        val signature = params["signature"] as String
        assertThat(signature).matches("^[a-f0-9]{40}$")
    }

    @Test
    fun `should return error when private key is not provided`() {
        val emptyKeyClient = ImageKitOkHttpClient.builder().privateKey("").build()

        val exception =
            assertFailsWith<IllegalStateException> {
                emptyKeyClient.helper().getAuthenticationParameters("test", 123L)
            }

        assertThat(exception.message)
            .isEqualTo("private API key is required for authentication parameters generation")
    }
}
