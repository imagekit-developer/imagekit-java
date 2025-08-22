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

internal class OriginListResponseTest {

    @Test
    fun ofS3() {
        val s3 =
            OriginListResponse.S3.builder()
                .id("id")
                .bucket("product-images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("raw-assets")
                .type(OriginListResponse.S3.Type.S3)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originListResponse = OriginListResponse.ofS3(s3)

        assertThat(originListResponse.s3()).contains(s3)
        assertThat(originListResponse.s3Compatible()).isEmpty
        assertThat(originListResponse.cloudinaryBackup()).isEmpty
        assertThat(originListResponse.webFolder()).isEmpty
        assertThat(originListResponse.webProxy()).isEmpty
        assertThat(originListResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originListResponse.azureBlobStorage()).isEmpty
        assertThat(originListResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3Roundtrip() {
        val jsonMapper = jsonMapper()
        val originListResponse =
            OriginListResponse.ofS3(
                OriginListResponse.S3.builder()
                    .id("id")
                    .bucket("product-images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("raw-assets")
                    .type(OriginListResponse.S3.Type.S3)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originListResponse),
                jacksonTypeRef<OriginListResponse>(),
            )

        assertThat(roundtrippedOriginListResponse).isEqualTo(originListResponse)
    }

    @Test
    fun ofS3Compatible() {
        val s3Compatible =
            OriginListResponse.S3Compatible.builder()
                .id("id")
                .bucket("product-images")
                .endpoint("https://s3.eu-central-1.wasabisys.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("raw-assets")
                .s3ForcePathStyle(true)
                .type(OriginListResponse.S3Compatible.Type.S3_COMPATIBLE)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originListResponse = OriginListResponse.ofS3Compatible(s3Compatible)

        assertThat(originListResponse.s3()).isEmpty
        assertThat(originListResponse.s3Compatible()).contains(s3Compatible)
        assertThat(originListResponse.cloudinaryBackup()).isEmpty
        assertThat(originListResponse.webFolder()).isEmpty
        assertThat(originListResponse.webProxy()).isEmpty
        assertThat(originListResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originListResponse.azureBlobStorage()).isEmpty
        assertThat(originListResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3CompatibleRoundtrip() {
        val jsonMapper = jsonMapper()
        val originListResponse =
            OriginListResponse.ofS3Compatible(
                OriginListResponse.S3Compatible.builder()
                    .id("id")
                    .bucket("product-images")
                    .endpoint("https://s3.eu-central-1.wasabisys.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("raw-assets")
                    .s3ForcePathStyle(true)
                    .type(OriginListResponse.S3Compatible.Type.S3_COMPATIBLE)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originListResponse),
                jacksonTypeRef<OriginListResponse>(),
            )

        assertThat(roundtrippedOriginListResponse).isEqualTo(originListResponse)
    }

    @Test
    fun ofCloudinaryBackup() {
        val cloudinaryBackup =
            OriginListResponse.CloudinaryBackup.builder()
                .id("id")
                .bucket("product-images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("raw-assets")
                .type(OriginListResponse.CloudinaryBackup.Type.CLOUDINARY_BACKUP)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originListResponse = OriginListResponse.ofCloudinaryBackup(cloudinaryBackup)

        assertThat(originListResponse.s3()).isEmpty
        assertThat(originListResponse.s3Compatible()).isEmpty
        assertThat(originListResponse.cloudinaryBackup()).contains(cloudinaryBackup)
        assertThat(originListResponse.webFolder()).isEmpty
        assertThat(originListResponse.webProxy()).isEmpty
        assertThat(originListResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originListResponse.azureBlobStorage()).isEmpty
        assertThat(originListResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofCloudinaryBackupRoundtrip() {
        val jsonMapper = jsonMapper()
        val originListResponse =
            OriginListResponse.ofCloudinaryBackup(
                OriginListResponse.CloudinaryBackup.builder()
                    .id("id")
                    .bucket("product-images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("raw-assets")
                    .type(OriginListResponse.CloudinaryBackup.Type.CLOUDINARY_BACKUP)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originListResponse),
                jacksonTypeRef<OriginListResponse>(),
            )

        assertThat(roundtrippedOriginListResponse).isEqualTo(originListResponse)
    }

    @Test
    fun ofWebFolder() {
        val webFolder =
            OriginListResponse.WebFolder.builder()
                .id("id")
                .baseUrl("https://images.example.com/assets")
                .forwardHostHeaderToOrigin(false)
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .type(OriginListResponse.WebFolder.Type.WEB_FOLDER)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originListResponse = OriginListResponse.ofWebFolder(webFolder)

        assertThat(originListResponse.s3()).isEmpty
        assertThat(originListResponse.s3Compatible()).isEmpty
        assertThat(originListResponse.cloudinaryBackup()).isEmpty
        assertThat(originListResponse.webFolder()).contains(webFolder)
        assertThat(originListResponse.webProxy()).isEmpty
        assertThat(originListResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originListResponse.azureBlobStorage()).isEmpty
        assertThat(originListResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebFolderRoundtrip() {
        val jsonMapper = jsonMapper()
        val originListResponse =
            OriginListResponse.ofWebFolder(
                OriginListResponse.WebFolder.builder()
                    .id("id")
                    .baseUrl("https://images.example.com/assets")
                    .forwardHostHeaderToOrigin(false)
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .type(OriginListResponse.WebFolder.Type.WEB_FOLDER)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originListResponse),
                jacksonTypeRef<OriginListResponse>(),
            )

        assertThat(roundtrippedOriginListResponse).isEqualTo(originListResponse)
    }

    @Test
    fun ofWebProxy() {
        val webProxy =
            OriginListResponse.WebProxy.builder()
                .id("id")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .type(OriginListResponse.WebProxy.Type.WEB_PROXY)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originListResponse = OriginListResponse.ofWebProxy(webProxy)

        assertThat(originListResponse.s3()).isEmpty
        assertThat(originListResponse.s3Compatible()).isEmpty
        assertThat(originListResponse.cloudinaryBackup()).isEmpty
        assertThat(originListResponse.webFolder()).isEmpty
        assertThat(originListResponse.webProxy()).contains(webProxy)
        assertThat(originListResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originListResponse.azureBlobStorage()).isEmpty
        assertThat(originListResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebProxyRoundtrip() {
        val jsonMapper = jsonMapper()
        val originListResponse =
            OriginListResponse.ofWebProxy(
                OriginListResponse.WebProxy.builder()
                    .id("id")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .type(OriginListResponse.WebProxy.Type.WEB_PROXY)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originListResponse),
                jacksonTypeRef<OriginListResponse>(),
            )

        assertThat(roundtrippedOriginListResponse).isEqualTo(originListResponse)
    }

    @Test
    fun ofGoogleCloudStorageGcs() {
        val googleCloudStorageGcs =
            OriginListResponse.GoogleCloudStorageGcs.builder()
                .id("id")
                .bucket("gcs-media")
                .clientEmail("service-account@project.iam.gserviceaccount.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("products")
                .type(OriginListResponse.GoogleCloudStorageGcs.Type.GCS)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originListResponse = OriginListResponse.ofGoogleCloudStorageGcs(googleCloudStorageGcs)

        assertThat(originListResponse.s3()).isEmpty
        assertThat(originListResponse.s3Compatible()).isEmpty
        assertThat(originListResponse.cloudinaryBackup()).isEmpty
        assertThat(originListResponse.webFolder()).isEmpty
        assertThat(originListResponse.webProxy()).isEmpty
        assertThat(originListResponse.googleCloudStorageGcs()).contains(googleCloudStorageGcs)
        assertThat(originListResponse.azureBlobStorage()).isEmpty
        assertThat(originListResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofGoogleCloudStorageGcsRoundtrip() {
        val jsonMapper = jsonMapper()
        val originListResponse =
            OriginListResponse.ofGoogleCloudStorageGcs(
                OriginListResponse.GoogleCloudStorageGcs.builder()
                    .id("id")
                    .bucket("gcs-media")
                    .clientEmail("service-account@project.iam.gserviceaccount.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("products")
                    .type(OriginListResponse.GoogleCloudStorageGcs.Type.GCS)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originListResponse),
                jacksonTypeRef<OriginListResponse>(),
            )

        assertThat(roundtrippedOriginListResponse).isEqualTo(originListResponse)
    }

    @Test
    fun ofAzureBlobStorage() {
        val azureBlobStorage =
            OriginListResponse.AzureBlobStorage.builder()
                .id("id")
                .accountName("account123")
                .container("images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("uploads")
                .type(OriginListResponse.AzureBlobStorage.Type.AZURE_BLOB)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originListResponse = OriginListResponse.ofAzureBlobStorage(azureBlobStorage)

        assertThat(originListResponse.s3()).isEmpty
        assertThat(originListResponse.s3Compatible()).isEmpty
        assertThat(originListResponse.cloudinaryBackup()).isEmpty
        assertThat(originListResponse.webFolder()).isEmpty
        assertThat(originListResponse.webProxy()).isEmpty
        assertThat(originListResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originListResponse.azureBlobStorage()).contains(azureBlobStorage)
        assertThat(originListResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofAzureBlobStorageRoundtrip() {
        val jsonMapper = jsonMapper()
        val originListResponse =
            OriginListResponse.ofAzureBlobStorage(
                OriginListResponse.AzureBlobStorage.builder()
                    .id("id")
                    .accountName("account123")
                    .container("images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("uploads")
                    .type(OriginListResponse.AzureBlobStorage.Type.AZURE_BLOB)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originListResponse),
                jacksonTypeRef<OriginListResponse>(),
            )

        assertThat(roundtrippedOriginListResponse).isEqualTo(originListResponse)
    }

    @Test
    fun ofAkeneoPim() {
        val akeneoPim =
            OriginListResponse.AkeneoPim.builder()
                .id("id")
                .baseUrl("https://akeneo.company.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .type(OriginListResponse.AkeneoPim.Type.AKENEO_PIM)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originListResponse = OriginListResponse.ofAkeneoPim(akeneoPim)

        assertThat(originListResponse.s3()).isEmpty
        assertThat(originListResponse.s3Compatible()).isEmpty
        assertThat(originListResponse.cloudinaryBackup()).isEmpty
        assertThat(originListResponse.webFolder()).isEmpty
        assertThat(originListResponse.webProxy()).isEmpty
        assertThat(originListResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originListResponse.azureBlobStorage()).isEmpty
        assertThat(originListResponse.akeneoPim()).contains(akeneoPim)
    }

    @Test
    fun ofAkeneoPimRoundtrip() {
        val jsonMapper = jsonMapper()
        val originListResponse =
            OriginListResponse.ofAkeneoPim(
                OriginListResponse.AkeneoPim.builder()
                    .id("id")
                    .baseUrl("https://akeneo.company.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .type(OriginListResponse.AkeneoPim.Type.AKENEO_PIM)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originListResponse),
                jacksonTypeRef<OriginListResponse>(),
            )

        assertThat(roundtrippedOriginListResponse).isEqualTo(originListResponse)
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
        val originListResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<OriginListResponse>())

        val e = assertThrows<ImageKitInvalidDataException> { originListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
