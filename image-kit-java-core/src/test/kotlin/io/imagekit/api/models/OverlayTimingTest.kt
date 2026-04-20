// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OverlayTimingTest {

    @Test
    fun create() {
        val overlayTiming = OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build()

        assertThat(overlayTiming.duration()).contains(OverlayTiming.Duration.ofNumber(0.0))
        assertThat(overlayTiming.end()).contains(OverlayTiming.End.ofNumber(0.0))
        assertThat(overlayTiming.start()).contains(OverlayTiming.Start.ofNumber(0.0))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val overlayTiming = OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build()

        val roundtrippedOverlayTiming =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(overlayTiming),
                jacksonTypeRef<OverlayTiming>(),
            )

        assertThat(roundtrippedOverlayTiming).isEqualTo(overlayTiming)
    }
}
