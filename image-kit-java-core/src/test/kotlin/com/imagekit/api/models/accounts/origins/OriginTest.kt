// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.origins

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.errors.ImageKitInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class OriginTest {

    @Test
    fun ofS3() {
        val s3 =
            Origin.S3.builder()
                .bucket("product-images")
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("raw-assets")
                .build()

        val origin = Origin.ofS3(s3)

        assertThat(origin.s3()).contains(s3)
        assertThat(origin.s3Compatible()).isEmpty
        assertThat(origin.cloudinaryBackup()).isEmpty
        assertThat(origin.webFolder()).isEmpty
        assertThat(origin.webProxy()).isEmpty
        assertThat(origin.gcs()).isEmpty
        assertThat(origin.azureBlob()).isEmpty
        assertThat(origin.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3Roundtrip() {
        val jsonMapper = jsonMapper()
        val origin =
            Origin.ofS3(
                Origin.S3.builder()
                    .bucket("product-images")
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("raw-assets")
                    .build()
            )

        val roundtrippedOrigin =
            jsonMapper.readValue(jsonMapper.writeValueAsString(origin), jacksonTypeRef<Origin>())

        assertThat(roundtrippedOrigin).isEqualTo(origin)
    }

    @Test
    fun ofS3Compatible() {
        val s3Compatible =
            Origin.S3Compatible.builder()
                .bucket("product-images")
                .endpoint("https://s3.eu-central-1.wasabisys.com")
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("raw-assets")
                .s3ForcePathStyle(true)
                .build()

        val origin = Origin.ofS3Compatible(s3Compatible)

        assertThat(origin.s3()).isEmpty
        assertThat(origin.s3Compatible()).contains(s3Compatible)
        assertThat(origin.cloudinaryBackup()).isEmpty
        assertThat(origin.webFolder()).isEmpty
        assertThat(origin.webProxy()).isEmpty
        assertThat(origin.gcs()).isEmpty
        assertThat(origin.azureBlob()).isEmpty
        assertThat(origin.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3CompatibleRoundtrip() {
        val jsonMapper = jsonMapper()
        val origin =
            Origin.ofS3Compatible(
                Origin.S3Compatible.builder()
                    .bucket("product-images")
                    .endpoint("https://s3.eu-central-1.wasabisys.com")
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("raw-assets")
                    .s3ForcePathStyle(true)
                    .build()
            )

        val roundtrippedOrigin =
            jsonMapper.readValue(jsonMapper.writeValueAsString(origin), jacksonTypeRef<Origin>())

        assertThat(roundtrippedOrigin).isEqualTo(origin)
    }

    @Test
    fun ofCloudinaryBackup() {
        val cloudinaryBackup =
            Origin.CloudinaryBackup.builder()
                .bucket("product-images")
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("raw-assets")
                .build()

        val origin = Origin.ofCloudinaryBackup(cloudinaryBackup)

        assertThat(origin.s3()).isEmpty
        assertThat(origin.s3Compatible()).isEmpty
        assertThat(origin.cloudinaryBackup()).contains(cloudinaryBackup)
        assertThat(origin.webFolder()).isEmpty
        assertThat(origin.webProxy()).isEmpty
        assertThat(origin.gcs()).isEmpty
        assertThat(origin.azureBlob()).isEmpty
        assertThat(origin.akeneoPim()).isEmpty
    }

    @Test
    fun ofCloudinaryBackupRoundtrip() {
        val jsonMapper = jsonMapper()
        val origin =
            Origin.ofCloudinaryBackup(
                Origin.CloudinaryBackup.builder()
                    .bucket("product-images")
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("raw-assets")
                    .build()
            )

        val roundtrippedOrigin =
            jsonMapper.readValue(jsonMapper.writeValueAsString(origin), jacksonTypeRef<Origin>())

        assertThat(roundtrippedOrigin).isEqualTo(origin)
    }

    @Test
    fun ofWebFolder() {
        val webFolder =
            Origin.WebFolder.builder()
                .baseUrl("https://images.example.com/assets")
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .forwardHostHeaderToOrigin(false)
                .includeCanonicalHeader(false)
                .build()

        val origin = Origin.ofWebFolder(webFolder)

        assertThat(origin.s3()).isEmpty
        assertThat(origin.s3Compatible()).isEmpty
        assertThat(origin.cloudinaryBackup()).isEmpty
        assertThat(origin.webFolder()).contains(webFolder)
        assertThat(origin.webProxy()).isEmpty
        assertThat(origin.gcs()).isEmpty
        assertThat(origin.azureBlob()).isEmpty
        assertThat(origin.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebFolderRoundtrip() {
        val jsonMapper = jsonMapper()
        val origin =
            Origin.ofWebFolder(
                Origin.WebFolder.builder()
                    .baseUrl("https://images.example.com/assets")
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .forwardHostHeaderToOrigin(false)
                    .includeCanonicalHeader(false)
                    .build()
            )

        val roundtrippedOrigin =
            jsonMapper.readValue(jsonMapper.writeValueAsString(origin), jacksonTypeRef<Origin>())

        assertThat(roundtrippedOrigin).isEqualTo(origin)
    }

    @Test
    fun ofWebProxy() {
        val webProxy =
            Origin.WebProxy.builder()
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .build()

        val origin = Origin.ofWebProxy(webProxy)

        assertThat(origin.s3()).isEmpty
        assertThat(origin.s3Compatible()).isEmpty
        assertThat(origin.cloudinaryBackup()).isEmpty
        assertThat(origin.webFolder()).isEmpty
        assertThat(origin.webProxy()).contains(webProxy)
        assertThat(origin.gcs()).isEmpty
        assertThat(origin.azureBlob()).isEmpty
        assertThat(origin.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebProxyRoundtrip() {
        val jsonMapper = jsonMapper()
        val origin =
            Origin.ofWebProxy(
                Origin.WebProxy.builder()
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .build()
            )

        val roundtrippedOrigin =
            jsonMapper.readValue(jsonMapper.writeValueAsString(origin), jacksonTypeRef<Origin>())

        assertThat(roundtrippedOrigin).isEqualTo(origin)
    }

    @Test
    fun ofGcs() {
        val gcs =
            Origin.Gcs.builder()
                .bucket("gcs-media")
                .clientEmail("service-account@project.iam.gserviceaccount.com")
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("products")
                .build()

        val origin = Origin.ofGcs(gcs)

        assertThat(origin.s3()).isEmpty
        assertThat(origin.s3Compatible()).isEmpty
        assertThat(origin.cloudinaryBackup()).isEmpty
        assertThat(origin.webFolder()).isEmpty
        assertThat(origin.webProxy()).isEmpty
        assertThat(origin.gcs()).contains(gcs)
        assertThat(origin.azureBlob()).isEmpty
        assertThat(origin.akeneoPim()).isEmpty
    }

    @Test
    fun ofGcsRoundtrip() {
        val jsonMapper = jsonMapper()
        val origin =
            Origin.ofGcs(
                Origin.Gcs.builder()
                    .bucket("gcs-media")
                    .clientEmail("service-account@project.iam.gserviceaccount.com")
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("products")
                    .build()
            )

        val roundtrippedOrigin =
            jsonMapper.readValue(jsonMapper.writeValueAsString(origin), jacksonTypeRef<Origin>())

        assertThat(roundtrippedOrigin).isEqualTo(origin)
    }

    @Test
    fun ofAzureBlob() {
        val azureBlob =
            Origin.AzureBlob.builder()
                .accountName("account123")
                .container("images")
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("uploads")
                .build()

        val origin = Origin.ofAzureBlob(azureBlob)

        assertThat(origin.s3()).isEmpty
        assertThat(origin.s3Compatible()).isEmpty
        assertThat(origin.cloudinaryBackup()).isEmpty
        assertThat(origin.webFolder()).isEmpty
        assertThat(origin.webProxy()).isEmpty
        assertThat(origin.gcs()).isEmpty
        assertThat(origin.azureBlob()).contains(azureBlob)
        assertThat(origin.akeneoPim()).isEmpty
    }

    @Test
    fun ofAzureBlobRoundtrip() {
        val jsonMapper = jsonMapper()
        val origin =
            Origin.ofAzureBlob(
                Origin.AzureBlob.builder()
                    .accountName("account123")
                    .container("images")
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("uploads")
                    .build()
            )

        val roundtrippedOrigin =
            jsonMapper.readValue(jsonMapper.writeValueAsString(origin), jacksonTypeRef<Origin>())

        assertThat(roundtrippedOrigin).isEqualTo(origin)
    }

    @Test
    fun ofAkeneoPim() {
        val akeneoPim =
            Origin.AkeneoPim.builder()
                .baseUrl("https://akeneo.company.com")
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .build()

        val origin = Origin.ofAkeneoPim(akeneoPim)

        assertThat(origin.s3()).isEmpty
        assertThat(origin.s3Compatible()).isEmpty
        assertThat(origin.cloudinaryBackup()).isEmpty
        assertThat(origin.webFolder()).isEmpty
        assertThat(origin.webProxy()).isEmpty
        assertThat(origin.gcs()).isEmpty
        assertThat(origin.azureBlob()).isEmpty
        assertThat(origin.akeneoPim()).contains(akeneoPim)
    }

    @Test
    fun ofAkeneoPimRoundtrip() {
        val jsonMapper = jsonMapper()
        val origin =
            Origin.ofAkeneoPim(
                Origin.AkeneoPim.builder()
                    .baseUrl("https://akeneo.company.com")
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .build()
            )

        val roundtrippedOrigin =
            jsonMapper.readValue(jsonMapper.writeValueAsString(origin), jacksonTypeRef<Origin>())

        assertThat(roundtrippedOrigin).isEqualTo(origin)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val origin = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Origin>())

        val e = assertThrows<ImageKitInvalidDataException> { origin.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
