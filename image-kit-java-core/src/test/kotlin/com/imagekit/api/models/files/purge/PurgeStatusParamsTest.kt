// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.purge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PurgeStatusParamsTest {

    @Test
    fun create() {
        PurgeStatusParams.builder().requestId("requestId").build()
    }

    @Test
    fun pathParams() {
        val params = PurgeStatusParams.builder().requestId("requestId").build()

        assertThat(params._pathParam(0)).isEqualTo("requestId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
