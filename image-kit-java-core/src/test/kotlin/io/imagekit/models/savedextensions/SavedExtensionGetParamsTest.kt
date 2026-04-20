// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.savedextensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SavedExtensionGetParamsTest {

    @Test
    fun create() {
        SavedExtensionGetParams.builder().id("id").build()
    }

    @Test
    fun pathParams() {
        val params = SavedExtensionGetParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
