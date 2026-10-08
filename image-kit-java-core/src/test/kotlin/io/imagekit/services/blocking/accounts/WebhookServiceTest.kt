// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking.accounts

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import io.imagekit.models.accounts.webhooks.WebhookCreateParams
import io.imagekit.models.accounts.webhooks.WebhookEventType
import io.imagekit.models.accounts.webhooks.WebhookUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WebhookServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookService = client.accounts().webhooks()

        val webhook =
            webhookService.create(
                WebhookCreateParams.builder()
                    .endpoint("https://example.com/imagekit/webhooks")
                    .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_READY)
                    .addEvent(WebhookEventType.FILE_CREATED)
                    .enabled(true)
                    .build()
            )

        webhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookService = client.accounts().webhooks()

        val webhook =
            webhookService.update(
                WebhookUpdateParams.builder()
                    .id("65f1c2a9e4b0a1b2c3d4e5f6")
                    .enabled(false)
                    .endpoint("https://example.com/imagekit/webhooks")
                    .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_READY)
                    .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_ERROR)
                    .build()
            )

        webhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookService = client.accounts().webhooks()

        val webhooks = webhookService.list()

        webhooks.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookService = client.accounts().webhooks()

        webhookService.delete("65f1c2a9e4b0a1b2c3d4e5f6")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val webhookService = client.accounts().webhooks()

        val webhook = webhookService.get("65f1c2a9e4b0a1b2c3d4e5f6")

        webhook.validate()
    }
}
