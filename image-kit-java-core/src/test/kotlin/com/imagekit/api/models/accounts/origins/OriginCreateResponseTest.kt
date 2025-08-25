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

internal class OriginCreateResponseTest {

    @Test
    fun ofS3() {
        val s3 =
            OriginCreateResponse.S3.builder()
                .accessKey("AKIAIOSFODNN7EXAMPLE")
                .bucket("product-images")
                .name("US S3 Storage")
                .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("raw-assets")
                .build()

        val originCreateResponse = OriginCreateResponse.ofS3(s3)

        assertThat(originCreateResponse.s3()).contains(s3)
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originCreateResponse.azureBlobStorage()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3Roundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofS3(
                OriginCreateResponse.S3.builder()
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

        val roundtrippedOriginCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originCreateResponse),
                jacksonTypeRef<OriginCreateResponse>(),
            )

        assertThat(roundtrippedOriginCreateResponse).isEqualTo(originCreateResponse)
    }

    @Test
    fun ofS3Compatible() {
        val s3Compatible =
            OriginCreateResponse.S3Compatible.builder()
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

        val originCreateResponse = OriginCreateResponse.ofS3Compatible(s3Compatible)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).contains(s3Compatible)
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originCreateResponse.azureBlobStorage()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3CompatibleRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofS3Compatible(
                OriginCreateResponse.S3Compatible.builder()
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

        val roundtrippedOriginCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originCreateResponse),
                jacksonTypeRef<OriginCreateResponse>(),
            )

        assertThat(roundtrippedOriginCreateResponse).isEqualTo(originCreateResponse)
    }

    @Test
    fun ofCloudinaryBackup() {
        val cloudinaryBackup =
            OriginCreateResponse.CloudinaryBackup.builder()
                .accessKey("AKIAIOSFODNN7EXAMPLE")
                .bucket("product-images")
                .name("US S3 Storage")
                .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("raw-assets")
                .build()

        val originCreateResponse = OriginCreateResponse.ofCloudinaryBackup(cloudinaryBackup)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).contains(cloudinaryBackup)
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originCreateResponse.azureBlobStorage()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofCloudinaryBackupRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofCloudinaryBackup(
                OriginCreateResponse.CloudinaryBackup.builder()
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

        val roundtrippedOriginCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originCreateResponse),
                jacksonTypeRef<OriginCreateResponse>(),
            )

        assertThat(roundtrippedOriginCreateResponse).isEqualTo(originCreateResponse)
    }

    @Test
    fun ofWebFolder() {
        val webFolder =
            OriginCreateResponse.WebFolder.builder()
                .baseUrl("https://images.example.com/assets")
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .forwardHostHeaderToOrigin(false)
                .includeCanonicalHeader(false)
                .build()

        val originCreateResponse = OriginCreateResponse.ofWebFolder(webFolder)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).contains(webFolder)
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originCreateResponse.azureBlobStorage()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebFolderRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofWebFolder(
                OriginCreateResponse.WebFolder.builder()
                    .baseUrl("https://images.example.com/assets")
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .forwardHostHeaderToOrigin(false)
                    .includeCanonicalHeader(false)
                    .build()
            )

        val roundtrippedOriginCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originCreateResponse),
                jacksonTypeRef<OriginCreateResponse>(),
            )

        assertThat(roundtrippedOriginCreateResponse).isEqualTo(originCreateResponse)
    }

    @Test
    fun ofWebProxy() {
        val webProxy =
            OriginCreateResponse.WebProxy.builder()
                .name("US S3 Storage")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .build()

        val originCreateResponse = OriginCreateResponse.ofWebProxy(webProxy)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).contains(webProxy)
        assertThat(originCreateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originCreateResponse.azureBlobStorage()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebProxyRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofWebProxy(
                OriginCreateResponse.WebProxy.builder()
                    .name("US S3 Storage")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .build()
            )

        val roundtrippedOriginCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originCreateResponse),
                jacksonTypeRef<OriginCreateResponse>(),
            )

        assertThat(roundtrippedOriginCreateResponse).isEqualTo(originCreateResponse)
    }

    @Test
    fun ofGoogleCloudStorageGcs() {
        val googleCloudStorageGcs =
            OriginCreateResponse.GoogleCloudStorageGcs.builder()
                .bucket("gcs-media")
                .clientEmail("service-account@project.iam.gserviceaccount.com")
                .name("US S3 Storage")
                .privateKey("-----BEGIN PRIVATE KEY-----\\nMIIEv...")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("products")
                .build()

        val originCreateResponse =
            OriginCreateResponse.ofGoogleCloudStorageGcs(googleCloudStorageGcs)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.googleCloudStorageGcs()).contains(googleCloudStorageGcs)
        assertThat(originCreateResponse.azureBlobStorage()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofGoogleCloudStorageGcsRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofGoogleCloudStorageGcs(
                OriginCreateResponse.GoogleCloudStorageGcs.builder()
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

        val roundtrippedOriginCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originCreateResponse),
                jacksonTypeRef<OriginCreateResponse>(),
            )

        assertThat(roundtrippedOriginCreateResponse).isEqualTo(originCreateResponse)
    }

    @Test
    fun ofAzureBlobStorage() {
        val azureBlobStorage =
            OriginCreateResponse.AzureBlobStorage.builder()
                .accountName("account123")
                .container("images")
                .name("US S3 Storage")
                .sasToken("?sv=2023-01-03&sr=c&sig=abc123")
                .id("id")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("uploads")
                .build()

        val originCreateResponse = OriginCreateResponse.ofAzureBlobStorage(azureBlobStorage)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originCreateResponse.azureBlobStorage()).contains(azureBlobStorage)
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofAzureBlobStorageRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofAzureBlobStorage(
                OriginCreateResponse.AzureBlobStorage.builder()
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

        val roundtrippedOriginCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originCreateResponse),
                jacksonTypeRef<OriginCreateResponse>(),
            )

        assertThat(roundtrippedOriginCreateResponse).isEqualTo(originCreateResponse)
    }

    @Test
    fun ofAkeneoPim() {
        val akeneoPim =
            OriginCreateResponse.AkeneoPim.builder()
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

        val originCreateResponse = OriginCreateResponse.ofAkeneoPim(akeneoPim)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.googleCloudStorageGcs()).isEmpty
        assertThat(originCreateResponse.azureBlobStorage()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).contains(akeneoPim)
    }

    @Test
    fun ofAkeneoPimRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofAkeneoPim(
                OriginCreateResponse.AkeneoPim.builder()
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

        val roundtrippedOriginCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originCreateResponse),
                jacksonTypeRef<OriginCreateResponse>(),
            )

        assertThat(roundtrippedOriginCreateResponse).isEqualTo(originCreateResponse)
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
        val originCreateResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<OriginCreateResponse>())

        val e = assertThrows<ImageKitInvalidDataException> { originCreateResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
