// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.namedtransformations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamedTransformationUpdateParamsTest {

    @Test
    fun create() {
        NamedTransformationUpdateParams.builder()
            .id("id")
            .enabled(true)
            .name("small_thumbnail")
            .transformation("w-200,h-200,fo-center,cm-resize")
            .build()
    }

    @Test
    fun pathParams() {
        val params = NamedTransformationUpdateParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamedTransformationUpdateParams.builder()
                .id("id")
                .enabled(true)
                .name("small_thumbnail")
                .transformation("w-200,h-200,fo-center,cm-resize")
                .build()

        val body = params._body()

        assertThat(body.enabled()).contains(true)
        assertThat(body.name()).contains("small_thumbnail")
        assertThat(body.transformation()).contains("w-200,h-200,fo-center,cm-resize")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamedTransformationUpdateParams.builder().id("id").build()

        val body = params._body()
    }
}
