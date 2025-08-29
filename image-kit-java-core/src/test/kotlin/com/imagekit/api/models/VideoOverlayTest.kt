// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoOverlayTest {

    @Test
    fun create() {
        val videoOverlay =
            VideoOverlay.builder()
                .position(
                    OverlayPosition.builder()
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .y(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .input("input")
                .type(VideoOverlay.Type.VIDEO)
                .encoding(VideoOverlay.Encoding.AUTO)
                .transformation(listOf())
                .build()

        assertThat(videoOverlay.position())
            .contains(
                OverlayPosition.builder().focus(OverlayPosition.Focus.CENTER).x(0.0).y(0.0).build()
            )
        assertThat(videoOverlay.timing())
            .contains(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
        assertThat(videoOverlay.input()).isEqualTo("input")
        assertThat(videoOverlay.type()).isEqualTo(VideoOverlay.Type.VIDEO)
        assertThat(videoOverlay.encoding()).contains(VideoOverlay.Encoding.AUTO)
        assertThat(videoOverlay.transformation().getOrNull()).containsExactly()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val videoOverlay =
            VideoOverlay.builder()
                .position(
                    OverlayPosition.builder()
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .y(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .input("input")
                .type(VideoOverlay.Type.VIDEO)
                .encoding(VideoOverlay.Encoding.AUTO)
                .transformation(listOf())
                .build()

        val roundtrippedVideoOverlay =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(videoOverlay),
                jacksonTypeRef<VideoOverlay>(),
            )

        assertThat(roundtrippedVideoOverlay).isEqualTo(videoOverlay)
    }
}
