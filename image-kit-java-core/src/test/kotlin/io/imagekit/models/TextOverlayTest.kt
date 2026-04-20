// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TextOverlayTest {

    @Test
    fun create() {
        val textOverlay =
            TextOverlay.builder()
                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                .position(
                    OverlayPosition.builder()
                        .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .xCenter(0.0)
                        .y(0.0)
                        .yCenter(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .text("text")
                .encoding(TextOverlay.Encoding.AUTO)
                .addTransformation(
                    TextOverlayTransformation.builder()
                        .alpha(1.0)
                        .background("background")
                        .flip(TextOverlayTransformation.Flip.H)
                        .fontColor("fontColor")
                        .fontFamily("fontFamily")
                        .fontSize(0.0)
                        .innerAlignment(TextOverlayTransformation.InnerAlignment.LEFT)
                        .lineHeight(0.0)
                        .padding(0.0)
                        .radiusMax()
                        .rotation(0.0)
                        .typography("typography")
                        .width(0.0)
                        .build()
                )
                .build()

        assertThat(textOverlay.layerMode()).contains(BaseOverlay.LayerMode.MULTIPLY)
        assertThat(textOverlay.position())
            .contains(
                OverlayPosition.builder()
                    .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                    .focus(OverlayPosition.Focus.CENTER)
                    .x(0.0)
                    .xCenter(0.0)
                    .y(0.0)
                    .yCenter(0.0)
                    .build()
            )
        assertThat(textOverlay.timing())
            .contains(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
        assertThat(textOverlay.text()).isEqualTo("text")
        assertThat(textOverlay.encoding()).contains(TextOverlay.Encoding.AUTO)
        assertThat(textOverlay.transformation().getOrNull())
            .containsExactly(
                TextOverlayTransformation.builder()
                    .alpha(1.0)
                    .background("background")
                    .flip(TextOverlayTransformation.Flip.H)
                    .fontColor("fontColor")
                    .fontFamily("fontFamily")
                    .fontSize(0.0)
                    .innerAlignment(TextOverlayTransformation.InnerAlignment.LEFT)
                    .lineHeight(0.0)
                    .padding(0.0)
                    .radiusMax()
                    .rotation(0.0)
                    .typography("typography")
                    .width(0.0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val textOverlay =
            TextOverlay.builder()
                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                .position(
                    OverlayPosition.builder()
                        .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .xCenter(0.0)
                        .y(0.0)
                        .yCenter(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .text("text")
                .encoding(TextOverlay.Encoding.AUTO)
                .addTransformation(
                    TextOverlayTransformation.builder()
                        .alpha(1.0)
                        .background("background")
                        .flip(TextOverlayTransformation.Flip.H)
                        .fontColor("fontColor")
                        .fontFamily("fontFamily")
                        .fontSize(0.0)
                        .innerAlignment(TextOverlayTransformation.InnerAlignment.LEFT)
                        .lineHeight(0.0)
                        .padding(0.0)
                        .radiusMax()
                        .rotation(0.0)
                        .typography("typography")
                        .width(0.0)
                        .build()
                )
                .build()

        val roundtrippedTextOverlay =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(textOverlay),
                jacksonTypeRef<TextOverlay>(),
            )

        assertThat(roundtrippedTextOverlay).isEqualTo(textOverlay)
    }
}
