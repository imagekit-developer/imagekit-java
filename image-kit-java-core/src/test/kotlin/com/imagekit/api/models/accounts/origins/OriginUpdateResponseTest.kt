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

internal class OriginUpdateResponseTest {

    @Test
    fun ofS3() {
        val s3 =
            OriginUpdateResponse.S3.builder()
                .id("id")
                .bucket("product-images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix(JsonValue.from("raw-assets"))
                .type(OriginUpdateResponse.S3.Type.S3)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originUpdateResponse = OriginUpdateResponse.ofS3(s3)

        assertThat(originUpdateResponse.s3()).contains(s3)
        assertThat(originUpdateResponse.s3Compatible()).isEmpty
        assertThat(originUpdateResponse.cloudinaryBackup()).isEmpty
        assertThat(originUpdateResponse.webFolder()).isEmpty
        assertThat(originUpdateResponse.webProxy()).isEmpty
        assertThat(originUpdateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originUpdateResponse.azureBlobStorage()).isEmpty
        assertThat(originUpdateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3Roundtrip() {
        val jsonMapper = jsonMapper()
        val originUpdateResponse =
            OriginUpdateResponse.ofS3(
                OriginUpdateResponse.S3.builder()
                    .id("id")
                    .bucket("product-images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix(JsonValue.from("raw-assets"))
                    .type(OriginUpdateResponse.S3.Type.S3)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originUpdateResponse),
                jacksonTypeRef<OriginUpdateResponse>(),
            )

        assertThat(roundtrippedOriginUpdateResponse).isEqualTo(originUpdateResponse)
    }

    @Test
    fun ofS3Compatible() {
        val s3Compatible =
            OriginUpdateResponse.S3Compatible.builder()
                .id("id")
                .bucket("product-images")
                .endpoint("https://s3.eu-central-1.wasabisys.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix(JsonValue.from("raw-assets"))
                .s3ForcePathStyle(true)
                .type(OriginUpdateResponse.S3Compatible.Type.S3_COMPATIBLE)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originUpdateResponse = OriginUpdateResponse.ofS3Compatible(s3Compatible)

        assertThat(originUpdateResponse.s3()).isEmpty
        assertThat(originUpdateResponse.s3Compatible()).contains(s3Compatible)
        assertThat(originUpdateResponse.cloudinaryBackup()).isEmpty
        assertThat(originUpdateResponse.webFolder()).isEmpty
        assertThat(originUpdateResponse.webProxy()).isEmpty
        assertThat(originUpdateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originUpdateResponse.azureBlobStorage()).isEmpty
        assertThat(originUpdateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3CompatibleRoundtrip() {
        val jsonMapper = jsonMapper()
        val originUpdateResponse =
            OriginUpdateResponse.ofS3Compatible(
                OriginUpdateResponse.S3Compatible.builder()
                    .id("id")
                    .bucket("product-images")
                    .endpoint("https://s3.eu-central-1.wasabisys.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix(JsonValue.from("raw-assets"))
                    .s3ForcePathStyle(true)
                    .type(OriginUpdateResponse.S3Compatible.Type.S3_COMPATIBLE)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originUpdateResponse),
                jacksonTypeRef<OriginUpdateResponse>(),
            )

        assertThat(roundtrippedOriginUpdateResponse).isEqualTo(originUpdateResponse)
    }

    @Test
    fun ofCloudinaryBackup() {
        val cloudinaryBackup =
            OriginUpdateResponse.CloudinaryBackup.builder()
                .id("id")
                .bucket("product-images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix(JsonValue.from("raw-assets"))
                .type(OriginUpdateResponse.CloudinaryBackup.Type.CLOUDINARY_BACKUP)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originUpdateResponse = OriginUpdateResponse.ofCloudinaryBackup(cloudinaryBackup)

        assertThat(originUpdateResponse.s3()).isEmpty
        assertThat(originUpdateResponse.s3Compatible()).isEmpty
        assertThat(originUpdateResponse.cloudinaryBackup()).contains(cloudinaryBackup)
        assertThat(originUpdateResponse.webFolder()).isEmpty
        assertThat(originUpdateResponse.webProxy()).isEmpty
        assertThat(originUpdateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originUpdateResponse.azureBlobStorage()).isEmpty
        assertThat(originUpdateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofCloudinaryBackupRoundtrip() {
        val jsonMapper = jsonMapper()
        val originUpdateResponse =
            OriginUpdateResponse.ofCloudinaryBackup(
                OriginUpdateResponse.CloudinaryBackup.builder()
                    .id("id")
                    .bucket("product-images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix(JsonValue.from("raw-assets"))
                    .type(OriginUpdateResponse.CloudinaryBackup.Type.CLOUDINARY_BACKUP)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originUpdateResponse),
                jacksonTypeRef<OriginUpdateResponse>(),
            )

        assertThat(roundtrippedOriginUpdateResponse).isEqualTo(originUpdateResponse)
    }

    @Test
    fun ofWebFolder() {
        val webFolder =
            OriginUpdateResponse.WebFolder.builder()
                .id("id")
                .baseUrl(JsonValue.from("https://images.example.com/assets"))
                .forwardHostHeaderToOrigin(false)
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .type(OriginUpdateResponse.WebFolder.Type.WEB_FOLDER)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originUpdateResponse = OriginUpdateResponse.ofWebFolder(webFolder)

        assertThat(originUpdateResponse.s3()).isEmpty
        assertThat(originUpdateResponse.s3Compatible()).isEmpty
        assertThat(originUpdateResponse.cloudinaryBackup()).isEmpty
        assertThat(originUpdateResponse.webFolder()).contains(webFolder)
        assertThat(originUpdateResponse.webProxy()).isEmpty
        assertThat(originUpdateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originUpdateResponse.azureBlobStorage()).isEmpty
        assertThat(originUpdateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebFolderRoundtrip() {
        val jsonMapper = jsonMapper()
        val originUpdateResponse =
            OriginUpdateResponse.ofWebFolder(
                OriginUpdateResponse.WebFolder.builder()
                    .id("id")
                    .baseUrl(JsonValue.from("https://images.example.com/assets"))
                    .forwardHostHeaderToOrigin(false)
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .type(OriginUpdateResponse.WebFolder.Type.WEB_FOLDER)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originUpdateResponse),
                jacksonTypeRef<OriginUpdateResponse>(),
            )

        assertThat(roundtrippedOriginUpdateResponse).isEqualTo(originUpdateResponse)
    }

    @Test
    fun ofWebProxy() {
        val webProxy =
            OriginUpdateResponse.WebProxy.builder()
                .id("id")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .type(OriginUpdateResponse.WebProxy.Type.WEB_PROXY)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originUpdateResponse = OriginUpdateResponse.ofWebProxy(webProxy)

        assertThat(originUpdateResponse.s3()).isEmpty
        assertThat(originUpdateResponse.s3Compatible()).isEmpty
        assertThat(originUpdateResponse.cloudinaryBackup()).isEmpty
        assertThat(originUpdateResponse.webFolder()).isEmpty
        assertThat(originUpdateResponse.webProxy()).contains(webProxy)
        assertThat(originUpdateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originUpdateResponse.azureBlobStorage()).isEmpty
        assertThat(originUpdateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebProxyRoundtrip() {
        val jsonMapper = jsonMapper()
        val originUpdateResponse =
            OriginUpdateResponse.ofWebProxy(
                OriginUpdateResponse.WebProxy.builder()
                    .id("id")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .type(OriginUpdateResponse.WebProxy.Type.WEB_PROXY)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originUpdateResponse),
                jacksonTypeRef<OriginUpdateResponse>(),
            )

        assertThat(roundtrippedOriginUpdateResponse).isEqualTo(originUpdateResponse)
    }

    @Test
    fun ofGoogleCloudStorageGcs() {
        val googleCloudStorageGcs =
            OriginUpdateResponse.GoogleCloudStorageGcs.builder()
                .id("id")
                .bucket("gcs-media")
                .clientEmail("service-account@project.iam.gserviceaccount.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix(JsonValue.from("products"))
                .type(OriginUpdateResponse.GoogleCloudStorageGcs.Type.GCS)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originUpdateResponse =
            OriginUpdateResponse.ofGoogleCloudStorageGcs(googleCloudStorageGcs)

        assertThat(originUpdateResponse.s3()).isEmpty
        assertThat(originUpdateResponse.s3Compatible()).isEmpty
        assertThat(originUpdateResponse.cloudinaryBackup()).isEmpty
        assertThat(originUpdateResponse.webFolder()).isEmpty
        assertThat(originUpdateResponse.webProxy()).isEmpty
        assertThat(originUpdateResponse.googleCloudStorageGcs()).contains(googleCloudStorageGcs)
        assertThat(originUpdateResponse.azureBlobStorage()).isEmpty
        assertThat(originUpdateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofGoogleCloudStorageGcsRoundtrip() {
        val jsonMapper = jsonMapper()
        val originUpdateResponse =
            OriginUpdateResponse.ofGoogleCloudStorageGcs(
                OriginUpdateResponse.GoogleCloudStorageGcs.builder()
                    .id("id")
                    .bucket("gcs-media")
                    .clientEmail("service-account@project.iam.gserviceaccount.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix(JsonValue.from("products"))
                    .type(OriginUpdateResponse.GoogleCloudStorageGcs.Type.GCS)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originUpdateResponse),
                jacksonTypeRef<OriginUpdateResponse>(),
            )

        assertThat(roundtrippedOriginUpdateResponse).isEqualTo(originUpdateResponse)
    }

    @Test
    fun ofAzureBlobStorage() {
        val azureBlobStorage =
            OriginUpdateResponse.AzureBlobStorage.builder()
                .id("id")
                .accountName("account123")
                .container("images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix(JsonValue.from("uploads"))
                .type(OriginUpdateResponse.AzureBlobStorage.Type.AZURE_BLOB)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originUpdateResponse = OriginUpdateResponse.ofAzureBlobStorage(azureBlobStorage)

        assertThat(originUpdateResponse.s3()).isEmpty
        assertThat(originUpdateResponse.s3Compatible()).isEmpty
        assertThat(originUpdateResponse.cloudinaryBackup()).isEmpty
        assertThat(originUpdateResponse.webFolder()).isEmpty
        assertThat(originUpdateResponse.webProxy()).isEmpty
        assertThat(originUpdateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originUpdateResponse.azureBlobStorage()).contains(azureBlobStorage)
        assertThat(originUpdateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofAzureBlobStorageRoundtrip() {
        val jsonMapper = jsonMapper()
        val originUpdateResponse =
            OriginUpdateResponse.ofAzureBlobStorage(
                OriginUpdateResponse.AzureBlobStorage.builder()
                    .id("id")
                    .accountName("account123")
                    .container("images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix(JsonValue.from("uploads"))
                    .type(OriginUpdateResponse.AzureBlobStorage.Type.AZURE_BLOB)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originUpdateResponse),
                jacksonTypeRef<OriginUpdateResponse>(),
            )

        assertThat(roundtrippedOriginUpdateResponse).isEqualTo(originUpdateResponse)
    }

    @Test
    fun ofAkeneoPim() {
        val akeneoPim =
            OriginUpdateResponse.AkeneoPim.builder()
                .id("id")
                .baseUrl(JsonValue.from("https://akeneo.company.com"))
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .type(OriginUpdateResponse.AkeneoPim.Type.AKENEO_PIM)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originUpdateResponse = OriginUpdateResponse.ofAkeneoPim(akeneoPim)

        assertThat(originUpdateResponse.s3()).isEmpty
        assertThat(originUpdateResponse.s3Compatible()).isEmpty
        assertThat(originUpdateResponse.cloudinaryBackup()).isEmpty
        assertThat(originUpdateResponse.webFolder()).isEmpty
        assertThat(originUpdateResponse.webProxy()).isEmpty
        assertThat(originUpdateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originUpdateResponse.azureBlobStorage()).isEmpty
        assertThat(originUpdateResponse.akeneoPim()).contains(akeneoPim)
    }

    @Test
    fun ofAkeneoPimRoundtrip() {
        val jsonMapper = jsonMapper()
        val originUpdateResponse =
            OriginUpdateResponse.ofAkeneoPim(
                OriginUpdateResponse.AkeneoPim.builder()
                    .id("id")
                    .baseUrl(JsonValue.from("https://akeneo.company.com"))
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .type(OriginUpdateResponse.AkeneoPim.Type.AKENEO_PIM)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originUpdateResponse),
                jacksonTypeRef<OriginUpdateResponse>(),
            )

        assertThat(roundtrippedOriginUpdateResponse).isEqualTo(originUpdateResponse)
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
        val originUpdateResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<OriginUpdateResponse>())

        val e = assertThrows<ImageKitInvalidDataException> { originUpdateResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
