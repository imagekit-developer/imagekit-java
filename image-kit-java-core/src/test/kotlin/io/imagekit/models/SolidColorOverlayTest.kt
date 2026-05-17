// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SolidColorOverlayTest {

    @Test
    fun create() {
        val solidColorOverlay =
            SolidColorOverlay.builder()
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
                .color("color")
                .addTransformation(
                    SolidColorOverlayTransformation.builder()
                        .alpha(1.0)
                        .background("background")
                        .gradientTrue()
                        .height(0.0)
                        .radiusMax()
                        .width(0.0)
                        .build()
                )
                .build()

        assertThat(solidColorOverlay.layerMode()).contains(BaseOverlay.LayerMode.MULTIPLY)
        assertThat(solidColorOverlay.position())
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
        assertThat(solidColorOverlay.timing())
            .contains(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
        assertThat(solidColorOverlay.color()).isEqualTo("color")
        assertThat(solidColorOverlay.transformation().getOrNull())
            .containsExactly(
                SolidColorOverlayTransformation.builder()
                    .alpha(1.0)
                    .background("background")
                    .gradientTrue()
                    .height(0.0)
                    .radiusMax()
                    .width(0.0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val solidColorOverlay =
            SolidColorOverlay.builder()
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
                .color("color")
                .addTransformation(
                    SolidColorOverlayTransformation.builder()
                        .alpha(1.0)
                        .background("background")
                        .gradientTrue()
                        .height(0.0)
                        .radiusMax()
                        .width(0.0)
                        .build()
                )
                .build()

        val roundtrippedSolidColorOverlay =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(solidColorOverlay),
                jacksonTypeRef<SolidColorOverlay>(),
            )

        assertThat(roundtrippedSolidColorOverlay).isEqualTo(solidColorOverlay)
    }
}
