// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BaseWebhookEventTest {

    @Test
    fun create() {
        val baseWebhookEvent = BaseWebhookEvent.builder().id("id").type("type").build()

        assertThat(baseWebhookEvent.id()).isEqualTo("id")
        assertThat(baseWebhookEvent.type()).isEqualTo("type")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val baseWebhookEvent = BaseWebhookEvent.builder().id("id").type("type").build()

        val roundtrippedBaseWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(baseWebhookEvent),
                jacksonTypeRef<BaseWebhookEvent>(),
            )

        assertThat(roundtrippedBaseWebhookEvent).isEqualTo(baseWebhookEvent)
    }
}
