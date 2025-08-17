// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExifDetailsTest {

    @Test
    fun create() {
        val exifDetails =
            ExifDetails.builder()
                .apertureValue(0.0)
                .colorSpace(0L)
                .createDate("CreateDate")
                .customRendered(0L)
                .dateTimeOriginal("DateTimeOriginal")
                .exifImageHeight(0L)
                .exifImageWidth(0L)
                .exifVersion("ExifVersion")
                .exposureCompensation(0.0)
                .exposureMode(0L)
                .exposureProgram(0L)
                .exposureTime(0.0)
                .flash(0L)
                .flashpixVersion("FlashpixVersion")
                .fNumber(0.0)
                .focalLength(0L)
                .focalPlaneResolutionUnit(0L)
                .focalPlaneXResolution(0.0)
                .focalPlaneYResolution(0.0)
                .interopOffset(0L)
                .iso(0L)
                .meteringMode(0L)
                .sceneCaptureType(0L)
                .shutterSpeedValue(0.0)
                .subSecTime("SubSecTime")
                .whiteBalance(0L)
                .build()

        assertThat(exifDetails.apertureValue()).contains(0.0)
        assertThat(exifDetails.colorSpace()).contains(0L)
        assertThat(exifDetails.createDate()).contains("CreateDate")
        assertThat(exifDetails.customRendered()).contains(0L)
        assertThat(exifDetails.dateTimeOriginal()).contains("DateTimeOriginal")
        assertThat(exifDetails.exifImageHeight()).contains(0L)
        assertThat(exifDetails.exifImageWidth()).contains(0L)
        assertThat(exifDetails.exifVersion()).contains("ExifVersion")
        assertThat(exifDetails.exposureCompensation()).contains(0.0)
        assertThat(exifDetails.exposureMode()).contains(0L)
        assertThat(exifDetails.exposureProgram()).contains(0L)
        assertThat(exifDetails.exposureTime()).contains(0.0)
        assertThat(exifDetails.flash()).contains(0L)
        assertThat(exifDetails.flashpixVersion()).contains("FlashpixVersion")
        assertThat(exifDetails.fNumber()).contains(0.0)
        assertThat(exifDetails.focalLength()).contains(0L)
        assertThat(exifDetails.focalPlaneResolutionUnit()).contains(0L)
        assertThat(exifDetails.focalPlaneXResolution()).contains(0.0)
        assertThat(exifDetails.focalPlaneYResolution()).contains(0.0)
        assertThat(exifDetails.interopOffset()).contains(0L)
        assertThat(exifDetails.iso()).contains(0L)
        assertThat(exifDetails.meteringMode()).contains(0L)
        assertThat(exifDetails.sceneCaptureType()).contains(0L)
        assertThat(exifDetails.shutterSpeedValue()).contains(0.0)
        assertThat(exifDetails.subSecTime()).contains("SubSecTime")
        assertThat(exifDetails.whiteBalance()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val exifDetails =
            ExifDetails.builder()
                .apertureValue(0.0)
                .colorSpace(0L)
                .createDate("CreateDate")
                .customRendered(0L)
                .dateTimeOriginal("DateTimeOriginal")
                .exifImageHeight(0L)
                .exifImageWidth(0L)
                .exifVersion("ExifVersion")
                .exposureCompensation(0.0)
                .exposureMode(0L)
                .exposureProgram(0L)
                .exposureTime(0.0)
                .flash(0L)
                .flashpixVersion("FlashpixVersion")
                .fNumber(0.0)
                .focalLength(0L)
                .focalPlaneResolutionUnit(0L)
                .focalPlaneXResolution(0.0)
                .focalPlaneYResolution(0.0)
                .interopOffset(0L)
                .iso(0L)
                .meteringMode(0L)
                .sceneCaptureType(0L)
                .shutterSpeedValue(0.0)
                .subSecTime("SubSecTime")
                .whiteBalance(0L)
                .build()

        val roundtrippedExifDetails =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(exifDetails),
                jacksonTypeRef<ExifDetails>(),
            )

        assertThat(roundtrippedExifDetails).isEqualTo(exifDetails)
    }
}
