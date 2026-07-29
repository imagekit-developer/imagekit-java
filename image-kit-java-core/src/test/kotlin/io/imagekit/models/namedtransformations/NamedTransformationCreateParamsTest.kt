// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.namedtransformations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamedTransformationCreateParamsTest {

    @Test
    fun create() {
        NamedTransformationCreateParams.builder()
            .name("small_thumbnail")
            .transformation("tr:w-150,h-150,fo-center,cm-resize")
            .disabled(false)
            .build()
    }

    @Test
    fun body() {
        val params =
            NamedTransformationCreateParams.builder()
                .name("small_thumbnail")
                .transformation("tr:w-150,h-150,fo-center,cm-resize")
                .disabled(false)
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("small_thumbnail")
        assertThat(body.transformation()).isEqualTo("tr:w-150,h-150,fo-center,cm-resize")
        assertThat(body.disabled()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            NamedTransformationCreateParams.builder()
                .name("small_thumbnail")
                .transformation("tr:w-150,h-150,fo-center,cm-resize")
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("small_thumbnail")
        assertThat(body.transformation()).isEqualTo("tr:w-150,h-150,fo-center,cm-resize")
    }
}
