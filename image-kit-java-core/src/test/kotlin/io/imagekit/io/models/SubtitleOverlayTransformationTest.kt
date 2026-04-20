// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.io.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SubtitleOverlayTransformationTest {

    @Test
    fun create() {
        val subtitleOverlayTransformation =
            SubtitleOverlayTransformation.builder()
                .background("background")
                .color("color")
                .fontFamily("fontFamily")
                .fontOutline("fontOutline")
                .fontShadow("fontShadow")
                .fontSize(0.0)
                .typography(SubtitleOverlayTransformation.Typography.B)
                .build()

        assertThat(subtitleOverlayTransformation.background()).contains("background")
        assertThat(subtitleOverlayTransformation.color()).contains("color")
        assertThat(subtitleOverlayTransformation.fontFamily()).contains("fontFamily")
        assertThat(subtitleOverlayTransformation.fontOutline()).contains("fontOutline")
        assertThat(subtitleOverlayTransformation.fontShadow()).contains("fontShadow")
        assertThat(subtitleOverlayTransformation.fontSize()).contains(0.0)
        assertThat(subtitleOverlayTransformation.typography())
            .contains(SubtitleOverlayTransformation.Typography.B)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val subtitleOverlayTransformation =
            SubtitleOverlayTransformation.builder()
                .background("background")
                .color("color")
                .fontFamily("fontFamily")
                .fontOutline("fontOutline")
                .fontShadow("fontShadow")
                .fontSize(0.0)
                .typography(SubtitleOverlayTransformation.Typography.B)
                .build()

        val roundtrippedSubtitleOverlayTransformation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(subtitleOverlayTransformation),
                jacksonTypeRef<SubtitleOverlayTransformation>(),
            )

        assertThat(roundtrippedSubtitleOverlayTransformation)
            .isEqualTo(subtitleOverlayTransformation)
    }
}
