// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SubtitleOverlayTest {

    @Test
    fun create() {
        val subtitleOverlay =
            SubtitleOverlay.builder()
                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                .position(
                    OverlayPosition.builder()
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .y(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .input("input")
                .encoding(SubtitleOverlay.Encoding.AUTO)
                .addTransformation(
                    SubtitleOverlayTransformation.builder()
                        .background("background")
                        .color("color")
                        .fontFamily("fontFamily")
                        .fontOutline("fontOutline")
                        .fontShadow("fontShadow")
                        .fontSize(0.0)
                        .typography(SubtitleOverlayTransformation.Typography.B)
                        .build()
                )
                .build()

        assertThat(subtitleOverlay.layerMode()).contains(BaseOverlay.LayerMode.MULTIPLY)
        assertThat(subtitleOverlay.position())
            .contains(
                OverlayPosition.builder().focus(OverlayPosition.Focus.CENTER).x(0.0).y(0.0).build()
            )
        assertThat(subtitleOverlay.timing())
            .contains(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
        assertThat(subtitleOverlay.input()).isEqualTo("input")
        assertThat(subtitleOverlay.encoding()).contains(SubtitleOverlay.Encoding.AUTO)
        assertThat(subtitleOverlay.transformation().getOrNull())
            .containsExactly(
                SubtitleOverlayTransformation.builder()
                    .background("background")
                    .color("color")
                    .fontFamily("fontFamily")
                    .fontOutline("fontOutline")
                    .fontShadow("fontShadow")
                    .fontSize(0.0)
                    .typography(SubtitleOverlayTransformation.Typography.B)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val subtitleOverlay =
            SubtitleOverlay.builder()
                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                .position(
                    OverlayPosition.builder()
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .y(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .input("input")
                .encoding(SubtitleOverlay.Encoding.AUTO)
                .addTransformation(
                    SubtitleOverlayTransformation.builder()
                        .background("background")
                        .color("color")
                        .fontFamily("fontFamily")
                        .fontOutline("fontOutline")
                        .fontShadow("fontShadow")
                        .fontSize(0.0)
                        .typography(SubtitleOverlayTransformation.Typography.B)
                        .build()
                )
                .build()

        val roundtrippedSubtitleOverlay =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(subtitleOverlay),
                jacksonTypeRef<SubtitleOverlay>(),
            )

        assertThat(roundtrippedSubtitleOverlay).isEqualTo(subtitleOverlay)
    }
}
