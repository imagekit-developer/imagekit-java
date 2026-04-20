// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.cache.invalidation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvalidationGetParamsTest {

    @Test
    fun create() {
        InvalidationGetParams.builder().requestId("requestId").build()
    }

    @Test
    fun pathParams() {
        val params = InvalidationGetParams.builder().requestId("requestId").build()

        assertThat(params._pathParam(0)).isEqualTo("requestId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
