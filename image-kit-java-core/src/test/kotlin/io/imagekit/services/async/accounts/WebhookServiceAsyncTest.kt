// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.accounts

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.models.accounts.webhooks.WebhookCreateParams
import io.imagekit.models.accounts.webhooks.WebhookEventType
import io.imagekit.models.accounts.webhooks.WebhookUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WebhookServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookServiceAsync = client.accounts().webhooks()

        val webhookFuture =
            webhookServiceAsync.create(
                WebhookCreateParams.builder()
                    .endpoint("https://example.com/imagekit/webhooks")
                    .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_READY)
                    .addEvent(WebhookEventType.FILE_CREATED)
                    .enabled(true)
                    .build()
            )

        val webhook = webhookFuture.get()
        webhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookServiceAsync = client.accounts().webhooks()

        val webhookFuture =
            webhookServiceAsync.update(
                WebhookUpdateParams.builder()
                    .id("65f1c2a9e4b0a1b2c3d4e5f6")
                    .enabled(false)
                    .endpoint("https://example.com/imagekit/webhooks")
                    .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_READY)
                    .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_ERROR)
                    .build()
            )

        val webhook = webhookFuture.get()
        webhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookServiceAsync = client.accounts().webhooks()

        val webhooksFuture = webhookServiceAsync.list()

        val webhooks = webhooksFuture.get()
        webhooks.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookServiceAsync = client.accounts().webhooks()

        val future = webhookServiceAsync.delete("65f1c2a9e4b0a1b2c3d4e5f6")

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookServiceAsync = client.accounts().webhooks()

        val webhookFuture = webhookServiceAsync.get("65f1c2a9e4b0a1b2c3d4e5f6")

        val webhook = webhookFuture.get()
        webhook.validate()
    }
}
