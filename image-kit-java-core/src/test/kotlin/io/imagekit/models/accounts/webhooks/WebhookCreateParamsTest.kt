// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.webhooks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateParamsTest {

    @Test
    fun create() {
        WebhookCreateParams.builder()
            .endpoint("https://example.com/imagekit/webhooks")
            .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_READY)
            .addEvent(WebhookEventType.FILE_CREATED)
            .enabled(true)
            .build()
    }

    @Test
    fun body() {
        val params =
            WebhookCreateParams.builder()
                .endpoint("https://example.com/imagekit/webhooks")
                .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_READY)
                .addEvent(WebhookEventType.FILE_CREATED)
                .enabled(true)
                .build()

        val body = params._body()

        assertThat(body.endpoint()).isEqualTo("https://example.com/imagekit/webhooks")
        assertThat(body.events())
            .containsExactly(
                WebhookEventType.VIDEO_TRANSFORMATION_READY,
                WebhookEventType.FILE_CREATED,
            )
        assertThat(body.enabled()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            WebhookCreateParams.builder()
                .endpoint("https://example.com/imagekit/webhooks")
                .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_READY)
                .addEvent(WebhookEventType.FILE_CREATED)
                .build()

        val body = params._body()

        assertThat(body.endpoint()).isEqualTo("https://example.com/imagekit/webhooks")
        assertThat(body.events())
            .containsExactly(
                WebhookEventType.VIDEO_TRANSFORMATION_READY,
                WebhookEventType.FILE_CREATED,
            )
    }
}
