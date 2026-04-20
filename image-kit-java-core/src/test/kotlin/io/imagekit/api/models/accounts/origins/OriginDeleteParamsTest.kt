// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.accounts.origins

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OriginDeleteParamsTest {

    @Test
    fun create() {
        OriginDeleteParams.builder().id("id").build()
    }

    @Test
    fun pathParams() {
        val params = OriginDeleteParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
