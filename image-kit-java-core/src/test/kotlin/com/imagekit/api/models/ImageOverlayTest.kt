// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageOverlayTest {

    @Test
    fun create() {
        val imageOverlay =
            ImageOverlay.builder()
                .position(
                    OverlayPosition.builder()
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .y(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .input("input")
                .type(ImageOverlay.Type.IMAGE)
                .encoding(ImageOverlay.Encoding.AUTO)
                .transformation(listOf())
                .build()

        assertThat(imageOverlay.position())
            .contains(
                OverlayPosition.builder().focus(OverlayPosition.Focus.CENTER).x(0.0).y(0.0).build()
            )
        assertThat(imageOverlay.timing())
            .contains(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
        assertThat(imageOverlay.input()).isEqualTo("input")
        assertThat(imageOverlay.type()).isEqualTo(ImageOverlay.Type.IMAGE)
        assertThat(imageOverlay.encoding()).contains(ImageOverlay.Encoding.AUTO)
        assertThat(imageOverlay.transformation().getOrNull()).containsExactly()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageOverlay =
            ImageOverlay.builder()
                .position(
                    OverlayPosition.builder()
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .y(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .input("input")
                .type(ImageOverlay.Type.IMAGE)
                .encoding(ImageOverlay.Encoding.AUTO)
                .transformation(listOf())
                .build()

        val roundtrippedImageOverlay =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageOverlay),
                jacksonTypeRef<ImageOverlay>(),
            )

        assertThat(roundtrippedImageOverlay).isEqualTo(imageOverlay)
    }
}
