// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.savedextensions

import io.imagekit.api.models.ExtensionConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SavedExtensionUpdateParamsTest {

    @Test
    fun create() {
        SavedExtensionUpdateParams.builder()
            .id("id")
            .config(
                ExtensionConfig.RemoveBg.builder()
                    .options(
                        ExtensionConfig.RemoveBg.Options.builder()
                            .addShadow(true)
                            .bgColor("bg_color")
                            .bgImageUrl("bg_image_url")
                            .semitransparency(true)
                            .build()
                    )
                    .build()
            )
            .description("x")
            .name("x")
            .build()
    }

    @Test
    fun pathParams() {
        val params = SavedExtensionUpdateParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            SavedExtensionUpdateParams.builder()
                .id("id")
                .config(
                    ExtensionConfig.RemoveBg.builder()
                        .options(
                            ExtensionConfig.RemoveBg.Options.builder()
                                .addShadow(true)
                                .bgColor("bg_color")
                                .bgImageUrl("bg_image_url")
                                .semitransparency(true)
                                .build()
                        )
                        .build()
                )
                .description("x")
                .name("x")
                .build()

        val body = params._body()

        assertThat(body.config())
            .contains(
                ExtensionConfig.ofRemoveBg(
                    ExtensionConfig.RemoveBg.builder()
                        .options(
                            ExtensionConfig.RemoveBg.Options.builder()
                                .addShadow(true)
                                .bgColor("bg_color")
                                .bgImageUrl("bg_image_url")
                                .semitransparency(true)
                                .build()
                        )
                        .build()
                )
            )
        assertThat(body.description()).contains("x")
        assertThat(body.name()).contains("x")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = SavedExtensionUpdateParams.builder().id("id").build()

        val body = params._body()
    }
}
