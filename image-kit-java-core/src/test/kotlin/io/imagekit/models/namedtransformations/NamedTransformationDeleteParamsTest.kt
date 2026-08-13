// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.namedtransformations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamedTransformationDeleteParamsTest {

    @Test
    fun create() {
        NamedTransformationDeleteParams.builder().id("6bZ9x2ZUx").build()
    }

    @Test
    fun pathParams() {
        val params = NamedTransformationDeleteParams.builder().id("6bZ9x2ZUx").build()

        assertThat(params._pathParam(0)).isEqualTo("6bZ9x2ZUx")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
