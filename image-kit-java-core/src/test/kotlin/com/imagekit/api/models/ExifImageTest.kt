// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExifImageTest {

    @Test
    fun create() {
        val exifImage =
            ExifImage.builder()
                .exifOffset(0L)
                .gpsInfo(0L)
                .make("Make")
                .model("Model")
                .modifyDate("ModifyDate")
                .orientation(0L)
                .resolutionUnit(0L)
                .software("Software")
                .xResolution(0L)
                .yCbCrPositioning(0L)
                .yResolution(0L)
                .build()

        assertThat(exifImage.exifOffset()).contains(0L)
        assertThat(exifImage.gpsInfo()).contains(0L)
        assertThat(exifImage.make()).contains("Make")
        assertThat(exifImage.model()).contains("Model")
        assertThat(exifImage.modifyDate()).contains("ModifyDate")
        assertThat(exifImage.orientation()).contains(0L)
        assertThat(exifImage.resolutionUnit()).contains(0L)
        assertThat(exifImage.software()).contains("Software")
        assertThat(exifImage.xResolution()).contains(0L)
        assertThat(exifImage.yCbCrPositioning()).contains(0L)
        assertThat(exifImage.yResolution()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val exifImage =
            ExifImage.builder()
                .exifOffset(0L)
                .gpsInfo(0L)
                .make("Make")
                .model("Model")
                .modifyDate("ModifyDate")
                .orientation(0L)
                .resolutionUnit(0L)
                .software("Software")
                .xResolution(0L)
                .yCbCrPositioning(0L)
                .yResolution(0L)
                .build()

        val roundtrippedExifImage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(exifImage),
                jacksonTypeRef<ExifImage>(),
            )

        assertThat(roundtrippedExifImage).isEqualTo(exifImage)
    }
}
