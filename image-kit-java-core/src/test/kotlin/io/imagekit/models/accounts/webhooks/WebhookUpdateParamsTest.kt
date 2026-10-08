// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.webhooks

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookUpdateParamsTest {

    @Test
    fun create() {
        WebhookUpdateParams.builder()
            .id("65f1c2a9e4b0a1b2c3d4e5f6")
            .enabled(false)
            .endpoint("https://example.com/imagekit/webhooks")
            .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_READY)
            .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_ERROR)
            .build()
    }

    @Test
    fun pathParams() {
        val params = WebhookUpdateParams.builder().id("65f1c2a9e4b0a1b2c3d4e5f6").build()

        assertThat(params._pathParam(0)).isEqualTo("65f1c2a9e4b0a1b2c3d4e5f6")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            WebhookUpdateParams.builder()
                .id("65f1c2a9e4b0a1b2c3d4e5f6")
                .enabled(false)
                .endpoint("https://example.com/imagekit/webhooks")
                .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_READY)
                .addEvent(WebhookEventType.VIDEO_TRANSFORMATION_ERROR)
                .build()

        val body = params._body()

        assertThat(body.enabled()).contains(false)
        assertThat(body.endpoint()).contains("https://example.com/imagekit/webhooks")
        assertThat(body.events().getOrNull())
            .containsExactly(
                WebhookEventType.VIDEO_TRANSFORMATION_READY,
                WebhookEventType.VIDEO_TRANSFORMATION_ERROR,
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = WebhookUpdateParams.builder().id("65f1c2a9e4b0a1b2c3d4e5f6").build()

        val body = params._body()
    }
}
