// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SavedExtensionTest {

    @Test
    fun create() {
        val savedExtension =
            SavedExtension.builder()
                .id("ext_abc123")
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
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("Analyzes vehicle images for type, condition, and quality assessment")
                .name("Car Quality Analysis")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(savedExtension.id()).contains("ext_abc123")
        assertThat(savedExtension.config())
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
        assertThat(savedExtension.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(savedExtension.description())
            .contains("Analyzes vehicle images for type, condition, and quality assessment")
        assertThat(savedExtension.name()).contains("Car Quality Analysis")
        assertThat(savedExtension.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val savedExtension =
            SavedExtension.builder()
                .id("ext_abc123")
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
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("Analyzes vehicle images for type, condition, and quality assessment")
                .name("Car Quality Analysis")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedSavedExtension =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(savedExtension),
                jacksonTypeRef<SavedExtension>(),
            )

        assertThat(roundtrippedSavedExtension).isEqualTo(savedExtension)
    }
}
