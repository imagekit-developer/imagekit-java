// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.namedtransformations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamedTransformationUpdateParamsTest {

    @Test
    fun create() {
        NamedTransformationUpdateParams.builder()
            .id("6bZ9x2ZUx")
            .enabled(false)
            .name("small_thumbnail")
            .transformation("w-200,h-200,fo-center,cm-pad_resize")
            .build()
    }

    @Test
    fun pathParams() {
        val params = NamedTransformationUpdateParams.builder().id("6bZ9x2ZUx").build()

        assertThat(params._pathParam(0)).isEqualTo("6bZ9x2ZUx")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamedTransformationUpdateParams.builder()
                .id("6bZ9x2ZUx")
                .enabled(false)
                .name("small_thumbnail")
                .transformation("w-200,h-200,fo-center,cm-pad_resize")
                .build()

        val body = params._body()

        assertThat(body.enabled()).contains(false)
        assertThat(body.name()).contains("small_thumbnail")
        assertThat(body.transformation()).contains("w-200,h-200,fo-center,cm-pad_resize")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamedTransformationUpdateParams.builder().id("6bZ9x2ZUx").build()

        val body = params._body()
    }
}
