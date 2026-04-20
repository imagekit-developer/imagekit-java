// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.savedextensions

import io.imagekit.api.models.ExtensionConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SavedExtensionCreateParamsTest {

    @Test
    fun create() {
        SavedExtensionCreateParams.builder()
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
            .description("Analyzes vehicle images for type, condition, and quality assessment")
            .name("Car Quality Analysis")
            .build()
    }

    @Test
    fun body() {
        val params =
            SavedExtensionCreateParams.builder()
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
                .description("Analyzes vehicle images for type, condition, and quality assessment")
                .name("Car Quality Analysis")
                .build()

        val body = params._body()

        assertThat(body.config())
            .isEqualTo(
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
        assertThat(body.description())
            .isEqualTo("Analyzes vehicle images for type, condition, and quality assessment")
        assertThat(body.name()).isEqualTo("Car Quality Analysis")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SavedExtensionCreateParams.builder()
                .config(ExtensionConfig.RemoveBg.builder().build())
                .description("Analyzes vehicle images for type, condition, and quality assessment")
                .name("Car Quality Analysis")
                .build()

        val body = params._body()

        assertThat(body.config())
            .isEqualTo(ExtensionConfig.ofRemoveBg(ExtensionConfig.RemoveBg.builder().build()))
        assertThat(body.description())
            .isEqualTo("Analyzes vehicle images for type, condition, and quality assessment")
        assertThat(body.name()).isEqualTo("Car Quality Analysis")
    }
}
