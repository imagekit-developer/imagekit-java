// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.io.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OverlayPositionTest {

    @Test
    fun create() {
        val overlayPosition =
            OverlayPosition.builder()
                .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                .focus(OverlayPosition.Focus.CENTER)
                .x(0.0)
                .xCenter(0.0)
                .y(0.0)
                .yCenter(0.0)
                .build()

        assertThat(overlayPosition.anchorPoint()).contains(OverlayPosition.AnchorPoint.TOP)
        assertThat(overlayPosition.focus()).contains(OverlayPosition.Focus.CENTER)
        assertThat(overlayPosition.x()).contains(OverlayPosition.X.ofNumber(0.0))
        assertThat(overlayPosition.xCenter()).contains(OverlayPosition.XCenter.ofNumber(0.0))
        assertThat(overlayPosition.y()).contains(OverlayPosition.Y.ofNumber(0.0))
        assertThat(overlayPosition.yCenter()).contains(OverlayPosition.YCenter.ofNumber(0.0))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val overlayPosition =
            OverlayPosition.builder()
                .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                .focus(OverlayPosition.Focus.CENTER)
                .x(0.0)
                .xCenter(0.0)
                .y(0.0)
                .yCenter(0.0)
                .build()

        val roundtrippedOverlayPosition =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(overlayPosition),
                jacksonTypeRef<OverlayPosition>(),
            )

        assertThat(roundtrippedOverlayPosition).isEqualTo(overlayPosition)
    }
}
