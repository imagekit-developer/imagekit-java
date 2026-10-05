// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.webhooks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookGetParamsTest {

    @Test
    fun create() {
        WebhookGetParams.builder().id("65f1c2a9e4b0a1b2c3d4e5f6").build()
    }

    @Test
    fun pathParams() {
        val params = WebhookGetParams.builder().id("65f1c2a9e4b0a1b2c3d4e5f6").build()

        assertThat(params._pathParam(0)).isEqualTo("65f1c2a9e4b0a1b2c3d4e5f6")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
