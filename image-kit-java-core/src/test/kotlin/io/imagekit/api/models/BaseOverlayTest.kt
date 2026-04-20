// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BaseOverlayTest {

    @Test
    fun create() {
        val baseOverlay =
            BaseOverlay.builder()
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
                .build()

        assertThat(baseOverlay.layerMode()).contains(BaseOverlay.LayerMode.MULTIPLY)
        assertThat(baseOverlay.position())
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
        assertThat(baseOverlay.timing())
            .contains(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val baseOverlay =
            BaseOverlay.builder()
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
                .build()

        val roundtrippedBaseOverlay =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(baseOverlay),
                jacksonTypeRef<BaseOverlay>(),
            )

        assertThat(roundtrippedBaseOverlay).isEqualTo(baseOverlay)
    }
}
