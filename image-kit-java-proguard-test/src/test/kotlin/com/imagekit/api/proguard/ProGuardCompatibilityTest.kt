// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.models.files.ExifDetails
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/image-kit-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()

        assertThat(client).isNotNull()
        assertThat(client.customMetadataFields()).isNotNull()
        assertThat(client.files()).isNotNull()
        assertThat(client.folder()).isNotNull()
        assertThat(client.bulkJobs()).isNotNull()
        assertThat(client.accounts()).isNotNull()
    }

    @Test
    fun exifDetailsRoundtrip() {
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
