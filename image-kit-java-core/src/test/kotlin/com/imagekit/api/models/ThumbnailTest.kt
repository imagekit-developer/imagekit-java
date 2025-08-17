// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThumbnailTest {

    @Test
    fun create() {
        val thumbnail =
            Thumbnail.builder()
                .compression(0L)
                .resolutionUnit(0L)
                .thumbnailLength(0L)
                .thumbnailOffset(0L)
                .xResolution(0L)
                .yResolution(0L)
                .build()

        assertThat(thumbnail.compression()).contains(0L)
        assertThat(thumbnail.resolutionUnit()).contains(0L)
        assertThat(thumbnail.thumbnailLength()).contains(0L)
        assertThat(thumbnail.thumbnailOffset()).contains(0L)
        assertThat(thumbnail.xResolution()).contains(0L)
        assertThat(thumbnail.yResolution()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val thumbnail =
            Thumbnail.builder()
                .compression(0L)
                .resolutionUnit(0L)
                .thumbnailLength(0L)
                .thumbnailOffset(0L)
                .xResolution(0L)
                .yResolution(0L)
                .build()

        val roundtrippedThumbnail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(thumbnail),
                jacksonTypeRef<Thumbnail>(),
            )

        assertThat(roundtrippedThumbnail).isEqualTo(thumbnail)
    }
}
