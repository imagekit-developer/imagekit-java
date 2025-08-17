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

internal class OriginGetResponseTest {

    @Test
    fun ofS3() {
        val s3 =
            OriginGetResponse.S3.builder()
                .id("id")
                .bucket("product-images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix(JsonValue.from("raw-assets"))
                .type(OriginGetResponse.S3.Type.S3)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originGetResponse = OriginGetResponse.ofS3(s3)

        assertThat(originGetResponse.s3()).contains(s3)
        assertThat(originGetResponse.s3Compatible()).isEmpty
        assertThat(originGetResponse.cloudinaryBackup()).isEmpty
        assertThat(originGetResponse.webFolder()).isEmpty
        assertThat(originGetResponse.webProxy()).isEmpty
        assertThat(originGetResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originGetResponse.azureBlobStorage()).isEmpty
        assertThat(originGetResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3Roundtrip() {
        val jsonMapper = jsonMapper()
        val originGetResponse =
            OriginGetResponse.ofS3(
                OriginGetResponse.S3.builder()
                    .id("id")
                    .bucket("product-images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix(JsonValue.from("raw-assets"))
                    .type(OriginGetResponse.S3.Type.S3)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originGetResponse),
                jacksonTypeRef<OriginGetResponse>(),
            )

        assertThat(roundtrippedOriginGetResponse).isEqualTo(originGetResponse)
    }

    @Test
    fun ofS3Compatible() {
        val s3Compatible =
            OriginGetResponse.S3Compatible.builder()
                .id("id")
                .bucket("product-images")
                .endpoint("https://s3.eu-central-1.wasabisys.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix(JsonValue.from("raw-assets"))
                .s3ForcePathStyle(true)
                .type(OriginGetResponse.S3Compatible.Type.S3_COMPATIBLE)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originGetResponse = OriginGetResponse.ofS3Compatible(s3Compatible)

        assertThat(originGetResponse.s3()).isEmpty
        assertThat(originGetResponse.s3Compatible()).contains(s3Compatible)
        assertThat(originGetResponse.cloudinaryBackup()).isEmpty
        assertThat(originGetResponse.webFolder()).isEmpty
        assertThat(originGetResponse.webProxy()).isEmpty
        assertThat(originGetResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originGetResponse.azureBlobStorage()).isEmpty
        assertThat(originGetResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3CompatibleRoundtrip() {
        val jsonMapper = jsonMapper()
        val originGetResponse =
            OriginGetResponse.ofS3Compatible(
                OriginGetResponse.S3Compatible.builder()
                    .id("id")
                    .bucket("product-images")
                    .endpoint("https://s3.eu-central-1.wasabisys.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix(JsonValue.from("raw-assets"))
                    .s3ForcePathStyle(true)
                    .type(OriginGetResponse.S3Compatible.Type.S3_COMPATIBLE)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originGetResponse),
                jacksonTypeRef<OriginGetResponse>(),
            )

        assertThat(roundtrippedOriginGetResponse).isEqualTo(originGetResponse)
    }

    @Test
    fun ofCloudinaryBackup() {
        val cloudinaryBackup =
            OriginGetResponse.CloudinaryBackup.builder()
                .id("id")
                .bucket("product-images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix(JsonValue.from("raw-assets"))
                .type(OriginGetResponse.CloudinaryBackup.Type.CLOUDINARY_BACKUP)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originGetResponse = OriginGetResponse.ofCloudinaryBackup(cloudinaryBackup)

        assertThat(originGetResponse.s3()).isEmpty
        assertThat(originGetResponse.s3Compatible()).isEmpty
        assertThat(originGetResponse.cloudinaryBackup()).contains(cloudinaryBackup)
        assertThat(originGetResponse.webFolder()).isEmpty
        assertThat(originGetResponse.webProxy()).isEmpty
        assertThat(originGetResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originGetResponse.azureBlobStorage()).isEmpty
        assertThat(originGetResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofCloudinaryBackupRoundtrip() {
        val jsonMapper = jsonMapper()
        val originGetResponse =
            OriginGetResponse.ofCloudinaryBackup(
                OriginGetResponse.CloudinaryBackup.builder()
                    .id("id")
                    .bucket("product-images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix(JsonValue.from("raw-assets"))
                    .type(OriginGetResponse.CloudinaryBackup.Type.CLOUDINARY_BACKUP)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originGetResponse),
                jacksonTypeRef<OriginGetResponse>(),
            )

        assertThat(roundtrippedOriginGetResponse).isEqualTo(originGetResponse)
    }

    @Test
    fun ofWebFolder() {
        val webFolder =
            OriginGetResponse.WebFolder.builder()
                .id("id")
                .baseUrl(JsonValue.from("https://images.example.com/assets"))
                .forwardHostHeaderToOrigin(false)
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .type(OriginGetResponse.WebFolder.Type.WEB_FOLDER)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originGetResponse = OriginGetResponse.ofWebFolder(webFolder)

        assertThat(originGetResponse.s3()).isEmpty
        assertThat(originGetResponse.s3Compatible()).isEmpty
        assertThat(originGetResponse.cloudinaryBackup()).isEmpty
        assertThat(originGetResponse.webFolder()).contains(webFolder)
        assertThat(originGetResponse.webProxy()).isEmpty
        assertThat(originGetResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originGetResponse.azureBlobStorage()).isEmpty
        assertThat(originGetResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebFolderRoundtrip() {
        val jsonMapper = jsonMapper()
        val originGetResponse =
            OriginGetResponse.ofWebFolder(
                OriginGetResponse.WebFolder.builder()
                    .id("id")
                    .baseUrl(JsonValue.from("https://images.example.com/assets"))
                    .forwardHostHeaderToOrigin(false)
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .type(OriginGetResponse.WebFolder.Type.WEB_FOLDER)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originGetResponse),
                jacksonTypeRef<OriginGetResponse>(),
            )

        assertThat(roundtrippedOriginGetResponse).isEqualTo(originGetResponse)
    }

    @Test
    fun ofWebProxy() {
        val webProxy =
            OriginGetResponse.WebProxy.builder()
                .id("id")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .type(OriginGetResponse.WebProxy.Type.WEB_PROXY)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originGetResponse = OriginGetResponse.ofWebProxy(webProxy)

        assertThat(originGetResponse.s3()).isEmpty
        assertThat(originGetResponse.s3Compatible()).isEmpty
        assertThat(originGetResponse.cloudinaryBackup()).isEmpty
        assertThat(originGetResponse.webFolder()).isEmpty
        assertThat(originGetResponse.webProxy()).contains(webProxy)
        assertThat(originGetResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originGetResponse.azureBlobStorage()).isEmpty
        assertThat(originGetResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebProxyRoundtrip() {
        val jsonMapper = jsonMapper()
        val originGetResponse =
            OriginGetResponse.ofWebProxy(
                OriginGetResponse.WebProxy.builder()
                    .id("id")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .type(OriginGetResponse.WebProxy.Type.WEB_PROXY)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originGetResponse),
                jacksonTypeRef<OriginGetResponse>(),
            )

        assertThat(roundtrippedOriginGetResponse).isEqualTo(originGetResponse)
    }

    @Test
    fun ofGoogleCloudStorageGcs() {
        val googleCloudStorageGcs =
            OriginGetResponse.GoogleCloudStorageGcs.builder()
                .id("id")
                .bucket("gcs-media")
                .clientEmail("service-account@project.iam.gserviceaccount.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix(JsonValue.from("products"))
                .type(OriginGetResponse.GoogleCloudStorageGcs.Type.GCS)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originGetResponse = OriginGetResponse.ofGoogleCloudStorageGcs(googleCloudStorageGcs)

        assertThat(originGetResponse.s3()).isEmpty
        assertThat(originGetResponse.s3Compatible()).isEmpty
        assertThat(originGetResponse.cloudinaryBackup()).isEmpty
        assertThat(originGetResponse.webFolder()).isEmpty
        assertThat(originGetResponse.webProxy()).isEmpty
        assertThat(originGetResponse.googleCloudStorageGcs()).contains(googleCloudStorageGcs)
        assertThat(originGetResponse.azureBlobStorage()).isEmpty
        assertThat(originGetResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofGoogleCloudStorageGcsRoundtrip() {
        val jsonMapper = jsonMapper()
        val originGetResponse =
            OriginGetResponse.ofGoogleCloudStorageGcs(
                OriginGetResponse.GoogleCloudStorageGcs.builder()
                    .id("id")
                    .bucket("gcs-media")
                    .clientEmail("service-account@project.iam.gserviceaccount.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix(JsonValue.from("products"))
                    .type(OriginGetResponse.GoogleCloudStorageGcs.Type.GCS)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originGetResponse),
                jacksonTypeRef<OriginGetResponse>(),
            )

        assertThat(roundtrippedOriginGetResponse).isEqualTo(originGetResponse)
    }

    @Test
    fun ofAzureBlobStorage() {
        val azureBlobStorage =
            OriginGetResponse.AzureBlobStorage.builder()
                .id("id")
                .accountName("account123")
                .container("images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix(JsonValue.from("uploads"))
                .type(OriginGetResponse.AzureBlobStorage.Type.AZURE_BLOB)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originGetResponse = OriginGetResponse.ofAzureBlobStorage(azureBlobStorage)

        assertThat(originGetResponse.s3()).isEmpty
        assertThat(originGetResponse.s3Compatible()).isEmpty
        assertThat(originGetResponse.cloudinaryBackup()).isEmpty
        assertThat(originGetResponse.webFolder()).isEmpty
        assertThat(originGetResponse.webProxy()).isEmpty
        assertThat(originGetResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originGetResponse.azureBlobStorage()).contains(azureBlobStorage)
        assertThat(originGetResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofAzureBlobStorageRoundtrip() {
        val jsonMapper = jsonMapper()
        val originGetResponse =
            OriginGetResponse.ofAzureBlobStorage(
                OriginGetResponse.AzureBlobStorage.builder()
                    .id("id")
                    .accountName("account123")
                    .container("images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix(JsonValue.from("uploads"))
                    .type(OriginGetResponse.AzureBlobStorage.Type.AZURE_BLOB)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originGetResponse),
                jacksonTypeRef<OriginGetResponse>(),
            )

        assertThat(roundtrippedOriginGetResponse).isEqualTo(originGetResponse)
    }

    @Test
    fun ofAkeneoPim() {
        val akeneoPim =
            OriginGetResponse.AkeneoPim.builder()
                .id("id")
                .baseUrl(JsonValue.from("https://akeneo.company.com"))
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .type(OriginGetResponse.AkeneoPim.Type.AKENEO_PIM)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originGetResponse = OriginGetResponse.ofAkeneoPim(akeneoPim)

        assertThat(originGetResponse.s3()).isEmpty
        assertThat(originGetResponse.s3Compatible()).isEmpty
        assertThat(originGetResponse.cloudinaryBackup()).isEmpty
        assertThat(originGetResponse.webFolder()).isEmpty
        assertThat(originGetResponse.webProxy()).isEmpty
        assertThat(originGetResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originGetResponse.azureBlobStorage()).isEmpty
        assertThat(originGetResponse.akeneoPim()).contains(akeneoPim)
    }

    @Test
    fun ofAkeneoPimRoundtrip() {
        val jsonMapper = jsonMapper()
        val originGetResponse =
            OriginGetResponse.ofAkeneoPim(
                OriginGetResponse.AkeneoPim.builder()
                    .id("id")
                    .baseUrl(JsonValue.from("https://akeneo.company.com"))
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .type(OriginGetResponse.AkeneoPim.Type.AKENEO_PIM)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originGetResponse),
                jacksonTypeRef<OriginGetResponse>(),
            )

        assertThat(roundtrippedOriginGetResponse).isEqualTo(originGetResponse)
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
        val originGetResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<OriginGetResponse>())

        val e = assertThrows<ImageKitInvalidDataException> { originGetResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
