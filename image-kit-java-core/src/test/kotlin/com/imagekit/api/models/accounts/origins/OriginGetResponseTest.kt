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
                .accessKey("AKIAIOSFODNN7EXAMPLE")
                .bucket("product-images")
                .name("US S3 Storage")
                .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("raw-assets")
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
                    .accessKey("AKIAIOSFODNN7EXAMPLE")
                    .bucket("product-images")
                    .name("US S3 Storage")
                    .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("raw-assets")
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
                .accessKey("AKIAIOSFODNN7EXAMPLE")
                .bucket("product-images")
                .endpoint("https://s3.eu-central-1.wasabisys.com")
                .name("US S3 Storage")
                .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("raw-assets")
                .s3ForcePathStyle(true)
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
                    .accessKey("AKIAIOSFODNN7EXAMPLE")
                    .bucket("product-images")
                    .endpoint("https://s3.eu-central-1.wasabisys.com")
                    .name("US S3 Storage")
                    .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("raw-assets")
                    .s3ForcePathStyle(true)
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
                .accessKey("AKIAIOSFODNN7EXAMPLE")
                .bucket("product-images")
                .name("US S3 Storage")
                .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("raw-assets")
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
                    .accessKey("AKIAIOSFODNN7EXAMPLE")
                    .bucket("product-images")
                    .name("US S3 Storage")
                    .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("raw-assets")
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
                .baseUrl("https://images.example.com/assets")
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .forwardHostHeaderToOrigin(false)
                .includeCanonicalHeader(false)
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
                    .baseUrl("https://images.example.com/assets")
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .forwardHostHeaderToOrigin(false)
                    .includeCanonicalHeader(false)
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
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
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
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
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
                .bucket("gcs-media")
                .clientEmail("service-account@project.iam.gserviceaccount.com")
                .name("US S3 Storage")
                .privateKey("-----BEGIN PRIVATE KEY-----\\nMIIEv...")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("products")
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
                    .bucket("gcs-media")
                    .clientEmail("service-account@project.iam.gserviceaccount.com")
                    .name("US S3 Storage")
                    .privateKey("-----BEGIN PRIVATE KEY-----\\nMIIEv...")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("products")
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
                .accountName("account123")
                .container("images")
                .name("US S3 Storage")
                .sasToken("?sv=2023-01-03&sr=c&sig=abc123")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("uploads")
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
                    .accountName("account123")
                    .container("images")
                    .name("US S3 Storage")
                    .sasToken("?sv=2023-01-03&sr=c&sig=abc123")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("uploads")
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
                .baseUrl("https://akeneo.company.com")
                .clientId("akeneo-client-id")
                .clientSecret("akeneo-client-secret")
                .name("US S3 Storage")
                .password("strongpassword123")
                .username("integration-user")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
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
                    .baseUrl("https://akeneo.company.com")
                    .clientId("akeneo-client-id")
                    .clientSecret("akeneo-client-secret")
                    .name("US S3 Storage")
                    .password("strongpassword123")
                    .username("integration-user")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
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
