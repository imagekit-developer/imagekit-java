// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.savedextensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SavedExtensionDeleteParamsTest {

    @Test
    fun create() {
        SavedExtensionDeleteParams.builder().id("id").build()
    }

    @Test
    fun pathParams() {
        val params = SavedExtensionDeleteParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
