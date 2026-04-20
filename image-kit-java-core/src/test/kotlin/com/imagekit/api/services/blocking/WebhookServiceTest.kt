// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.core.UnwrapWebhookParams
import com.imagekit.api.core.http.Headers
import com.imagekit.api.errors.ImageKitWebhookException
import com.standardwebhooks.Webhook
import java.time.Instant
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WebhookServiceTest {

    @Test
    fun unsafeUnwrap() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookService = client.webhooks()

        val payload =
            "{\"id\":\"id\",\"type\":\"video.transformation.accepted\",\"created_at\":\"2019-12-27T18:11:19.117Z\",\"data\":{\"asset\":{\"url\":\"https://example.com\"},\"transformation\":{\"type\":\"video-transformation\",\"options\":{\"audio_codec\":\"aac\",\"auto_rotate\":true,\"format\":\"mp4\",\"quality\":0,\"stream_protocol\":\"HLS\",\"variants\":[\"string\"],\"video_codec\":\"h264\"}}},\"request\":{\"url\":\"https://example.com\",\"x_request_id\":\"x_request_id\",\"user_agent\":\"user_agent\"}}"
        val webhookSecret = "whsec_c2VjcmV0Cg=="
        val headers = Headers.builder().build()

        webhookService.unsafeUnwrap(payload).validate()
    }

    @Test
    fun unwrap() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookService = client.webhooks()

        val payload =
            "{\"id\":\"id\",\"type\":\"video.transformation.accepted\",\"created_at\":\"2019-12-27T18:11:19.117Z\",\"data\":{\"asset\":{\"url\":\"https://example.com\"},\"transformation\":{\"type\":\"video-transformation\",\"options\":{\"audio_codec\":\"aac\",\"auto_rotate\":true,\"format\":\"mp4\",\"quality\":0,\"stream_protocol\":\"HLS\",\"variants\":[\"string\"],\"video_codec\":\"h264\"}}},\"request\":{\"url\":\"https://example.com\",\"x_request_id\":\"x_request_id\",\"user_agent\":\"user_agent\"}}"
        val webhookSecret = "whsec_c2VjcmV0Cg=="
        val messageId = "1"
        val timestampSeconds = Instant.now().epochSecond
        val webhook = Webhook(webhookSecret)
        val signature = webhook.sign(messageId, timestampSeconds, payload)
        val headers =
            Headers.builder()
                .putAll(
                    mapOf(
                        "webhook-signature" to listOf(signature),
                        "webhook-id" to listOf(messageId),
                        "webhook-timestamp" to listOf(timestampSeconds.toString()),
                    )
                )
                .build()

        // Correct key should not throw
        webhookService.unwrap(
            UnwrapWebhookParams.builder()
                .body(payload)
                .headers(headers)
                .secret(webhookSecret)
                .build()
        )
        webhookService
            .withOptions { it.webhookSecret(webhookSecret) }
            .unwrap(UnwrapWebhookParams.builder().body(payload).headers(headers).build())

        // Secret in method takes precedence to secret on client
        val wrongKey = "whsec_aaaaaaaaaa"
        webhookService
            .withOptions { it.webhookSecret(wrongKey) }
            .unwrap(
                UnwrapWebhookParams.builder()
                    .body(payload)
                    .headers(headers)
                    .secret(webhookSecret)
                    .build()
            )

        // Wrong key should throw
        assertThrows<ImageKitWebhookException> {
            val wrongKey = "whsec_aaaaaaaaaa"
            webhookService.unwrap(
                UnwrapWebhookParams.builder()
                    .body(payload)
                    .headers(headers)
                    .secret(wrongKey)
                    .build()
            )
        }
        assertThrows<ImageKitWebhookException> {
            val wrongKey = "whsec_aaaaaaaaaa"
            webhookService
                .withOptions { it.webhookSecret(wrongKey) }
                .unwrap(UnwrapWebhookParams.builder().body(payload).headers(headers).build())
        }

        assertThrows<ImageKitWebhookException> {
            val wrongKey = "whsec_aaaaaaaaaa"
            webhookService.unwrap(
                UnwrapWebhookParams.builder()
                    .body(payload)
                    .headers(headers)
                    .secret(wrongKey)
                    .build()
            )
        }
        assertThrows<ImageKitWebhookException> {
            val wrongKey = "whsec_aaaaaaaaaa"
            webhookService
                .withOptions { it.webhookSecret(wrongKey) }
                .unwrap(UnwrapWebhookParams.builder().body(payload).headers(headers).build())
        }

        // Bad signature should throw
        assertThrows<ImageKitWebhookException> {
            val badSig = webhook.sign(messageId, timestampSeconds, "some other payload")
            val badHeaders =
                headers.toBuilder().replace("webhook-signature", listOf(badSig)).build()
            webhookService.unwrap(
                UnwrapWebhookParams.builder()
                    .body(payload)
                    .headers(badHeaders)
                    .secret(webhookSecret)
                    .build()
            )
        }
        assertThrows<ImageKitWebhookException> {
            val badSig = webhook.sign(messageId, timestampSeconds, "some other payload")
            val badHeaders =
                headers.toBuilder().replace("webhook-signature", listOf(badSig)).build()
            webhookService
                .withOptions { it.webhookSecret(webhookSecret) }
                .unwrap(UnwrapWebhookParams.builder().body(payload).headers(badHeaders).build())
        }

        // Old timestamp should throw
        assertThrows<ImageKitWebhookException> {
            val oldHeaders = headers.toBuilder().replace("webhook-timestamp", listOf("5")).build()
            webhookService.unwrap(
                UnwrapWebhookParams.builder()
                    .body(payload)
                    .headers(oldHeaders)
                    .secret(webhookSecret)
                    .build()
            )
        }
        assertThrows<ImageKitWebhookException> {
            val oldHeaders = headers.toBuilder().replace("webhook-timestamp", listOf("5")).build()
            webhookService
                .withOptions { it.webhookSecret(webhookSecret) }
                .unwrap(UnwrapWebhookParams.builder().body(payload).headers(oldHeaders).build())
        }

        // Wrong message ID should throw
        assertThrows<ImageKitWebhookException> {
            val wrongIdHeaders = headers.toBuilder().replace("webhook-id", listOf("wrong")).build()
            webhookService.unwrap(
                UnwrapWebhookParams.builder()
                    .body(payload)
                    .headers(wrongIdHeaders)
                    .secret(webhookSecret)
                    .build()
            )
        }
        assertThrows<ImageKitWebhookException> {
            val wrongIdHeaders = headers.toBuilder().replace("webhook-id", listOf("wrong")).build()
            webhookService
                .withOptions { it.webhookSecret(webhookSecret) }
                .unwrap(UnwrapWebhookParams.builder().body(payload).headers(wrongIdHeaders).build())
        }
    }
}
