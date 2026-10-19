// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookTest {

    @Test
    fun create() {
        val webhook =
            Webhook.builder()
                .id("65f1c2a9e4b0a1b2c3d4e5f6")
                .createdAt(OffsetDateTime.parse("2024-01-10T09:00:00.000Z"))
                .enabled(true)
                .endpoint("https://example.com/imagekit/webhooks")
                .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_READY)
                .addEvent(WebhookEventType.FILE_CREATED)
                .secret("whsec_WvVlXdM3rcNkRNJ1u4H8Qq0GmZ2FEb7p")
                .updatedAt(OffsetDateTime.parse("2024-01-10T09:00:00.000Z"))
                .build()

        assertThat(webhook.id()).isEqualTo("65f1c2a9e4b0a1b2c3d4e5f6")
        assertThat(webhook.createdAt()).isEqualTo(OffsetDateTime.parse("2024-01-10T09:00:00.000Z"))
        assertThat(webhook.enabled()).isEqualTo(true)
        assertThat(webhook.endpoint()).isEqualTo("https://example.com/imagekit/webhooks")
        assertThat(webhook.events())
            .containsExactly(
                WebhookEventType.VIDEO_TRANSFORMATION_READY,
                WebhookEventType.FILE_CREATED,
            )
        assertThat(webhook.secret()).isEqualTo("whsec_WvVlXdM3rcNkRNJ1u4H8Qq0GmZ2FEb7p")
        assertThat(webhook.updatedAt()).isEqualTo(OffsetDateTime.parse("2024-01-10T09:00:00.000Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhook =
            Webhook.builder()
                .id("65f1c2a9e4b0a1b2c3d4e5f6")
                .createdAt(OffsetDateTime.parse("2024-01-10T09:00:00.000Z"))
                .enabled(true)
                .endpoint("https://example.com/imagekit/webhooks")
                .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_READY)
                .addEvent(WebhookEventType.FILE_CREATED)
                .secret("whsec_WvVlXdM3rcNkRNJ1u4H8Qq0GmZ2FEb7p")
                .updatedAt(OffsetDateTime.parse("2024-01-10T09:00:00.000Z"))
                .build()

        val roundtrippedWebhook =
            jsonMapper.readValue(jsonMapper.writeValueAsString(webhook), jacksonTypeRef<Webhook>())

        assertThat(roundtrippedWebhook).isEqualTo(webhook)
    }
}
