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

internal class OriginRequestTest {

    @Test
    fun ofS3() {
        val s3 =
            OriginRequest.S3.builder()
                .accessKey("AKIAIOSFODNN7EXAMPLE")
                .bucket("product-images")
                .name("US S3 Storage")
                .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("raw-assets")
                .build()

        val originRequest = OriginRequest.ofS3(s3)

        assertThat(originRequest.s3()).contains(s3)
        assertThat(originRequest.s3Compatible()).isEmpty
        assertThat(originRequest.cloudinaryBackup()).isEmpty
        assertThat(originRequest.webFolder()).isEmpty
        assertThat(originRequest.webProxy()).isEmpty
        assertThat(originRequest.gcs()).isEmpty
        assertThat(originRequest.azureBlob()).isEmpty
        assertThat(originRequest.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3Roundtrip() {
        val jsonMapper = jsonMapper()
        val originRequest =
            OriginRequest.ofS3(
                OriginRequest.S3.builder()
                    .accessKey("AKIAIOSFODNN7EXAMPLE")
                    .bucket("product-images")
                    .name("US S3 Storage")
                    .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("raw-assets")
                    .build()
            )

        val roundtrippedOriginRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originRequest),
                jacksonTypeRef<OriginRequest>(),
            )

        assertThat(roundtrippedOriginRequest).isEqualTo(originRequest)
    }

    @Test
    fun ofS3Compatible() {
        val s3Compatible =
            OriginRequest.S3Compatible.builder()
                .accessKey("AKIAIOSFODNN7EXAMPLE")
                .bucket("product-images")
                .endpoint("https://s3.eu-central-1.wasabisys.com")
                .name("US S3 Storage")
                .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("raw-assets")
                .s3ForcePathStyle(true)
                .build()

        val originRequest = OriginRequest.ofS3Compatible(s3Compatible)

        assertThat(originRequest.s3()).isEmpty
        assertThat(originRequest.s3Compatible()).contains(s3Compatible)
        assertThat(originRequest.cloudinaryBackup()).isEmpty
        assertThat(originRequest.webFolder()).isEmpty
        assertThat(originRequest.webProxy()).isEmpty
        assertThat(originRequest.gcs()).isEmpty
        assertThat(originRequest.azureBlob()).isEmpty
        assertThat(originRequest.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3CompatibleRoundtrip() {
        val jsonMapper = jsonMapper()
        val originRequest =
            OriginRequest.ofS3Compatible(
                OriginRequest.S3Compatible.builder()
                    .accessKey("AKIAIOSFODNN7EXAMPLE")
                    .bucket("product-images")
                    .endpoint("https://s3.eu-central-1.wasabisys.com")
                    .name("US S3 Storage")
                    .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("raw-assets")
                    .s3ForcePathStyle(true)
                    .build()
            )

        val roundtrippedOriginRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originRequest),
                jacksonTypeRef<OriginRequest>(),
            )

        assertThat(roundtrippedOriginRequest).isEqualTo(originRequest)
    }

    @Test
    fun ofCloudinaryBackup() {
        val cloudinaryBackup =
            OriginRequest.CloudinaryBackup.builder()
                .accessKey("AKIAIOSFODNN7EXAMPLE")
                .bucket("product-images")
                .name("US S3 Storage")
                .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("raw-assets")
                .build()

        val originRequest = OriginRequest.ofCloudinaryBackup(cloudinaryBackup)

        assertThat(originRequest.s3()).isEmpty
        assertThat(originRequest.s3Compatible()).isEmpty
        assertThat(originRequest.cloudinaryBackup()).contains(cloudinaryBackup)
        assertThat(originRequest.webFolder()).isEmpty
        assertThat(originRequest.webProxy()).isEmpty
        assertThat(originRequest.gcs()).isEmpty
        assertThat(originRequest.azureBlob()).isEmpty
        assertThat(originRequest.akeneoPim()).isEmpty
    }

    @Test
    fun ofCloudinaryBackupRoundtrip() {
        val jsonMapper = jsonMapper()
        val originRequest =
            OriginRequest.ofCloudinaryBackup(
                OriginRequest.CloudinaryBackup.builder()
                    .accessKey("AKIAIOSFODNN7EXAMPLE")
                    .bucket("product-images")
                    .name("US S3 Storage")
                    .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("raw-assets")
                    .build()
            )

        val roundtrippedOriginRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originRequest),
                jacksonTypeRef<OriginRequest>(),
            )

        assertThat(roundtrippedOriginRequest).isEqualTo(originRequest)
    }

    @Test
    fun ofWebFolder() {
        val webFolder =
            OriginRequest.WebFolder.builder()
                .baseUrl("https://images.example.com/assets")
                .name("US S3 Storage")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .forwardHostHeaderToOrigin(false)
                .includeCanonicalHeader(false)
                .build()

        val originRequest = OriginRequest.ofWebFolder(webFolder)

        assertThat(originRequest.s3()).isEmpty
        assertThat(originRequest.s3Compatible()).isEmpty
        assertThat(originRequest.cloudinaryBackup()).isEmpty
        assertThat(originRequest.webFolder()).contains(webFolder)
        assertThat(originRequest.webProxy()).isEmpty
        assertThat(originRequest.gcs()).isEmpty
        assertThat(originRequest.azureBlob()).isEmpty
        assertThat(originRequest.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebFolderRoundtrip() {
        val jsonMapper = jsonMapper()
        val originRequest =
            OriginRequest.ofWebFolder(
                OriginRequest.WebFolder.builder()
                    .baseUrl("https://images.example.com/assets")
                    .name("US S3 Storage")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .forwardHostHeaderToOrigin(false)
                    .includeCanonicalHeader(false)
                    .build()
            )

        val roundtrippedOriginRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originRequest),
                jacksonTypeRef<OriginRequest>(),
            )

        assertThat(roundtrippedOriginRequest).isEqualTo(originRequest)
    }

    @Test
    fun ofWebProxy() {
        val webProxy =
            OriginRequest.WebProxy.builder()
                .name("US S3 Storage")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .build()

        val originRequest = OriginRequest.ofWebProxy(webProxy)

        assertThat(originRequest.s3()).isEmpty
        assertThat(originRequest.s3Compatible()).isEmpty
        assertThat(originRequest.cloudinaryBackup()).isEmpty
        assertThat(originRequest.webFolder()).isEmpty
        assertThat(originRequest.webProxy()).contains(webProxy)
        assertThat(originRequest.gcs()).isEmpty
        assertThat(originRequest.azureBlob()).isEmpty
        assertThat(originRequest.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebProxyRoundtrip() {
        val jsonMapper = jsonMapper()
        val originRequest =
            OriginRequest.ofWebProxy(
                OriginRequest.WebProxy.builder()
                    .name("US S3 Storage")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .build()
            )

        val roundtrippedOriginRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originRequest),
                jacksonTypeRef<OriginRequest>(),
            )

        assertThat(roundtrippedOriginRequest).isEqualTo(originRequest)
    }

    @Test
    fun ofGcs() {
        val gcs =
            OriginRequest.Gcs.builder()
                .bucket("gcs-media")
                .clientEmail("service-account@project.iam.gserviceaccount.com")
                .name("US S3 Storage")
                .privateKey("-----BEGIN PRIVATE KEY-----\\nMIIEv...")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("products")
                .build()

        val originRequest = OriginRequest.ofGcs(gcs)

        assertThat(originRequest.s3()).isEmpty
        assertThat(originRequest.s3Compatible()).isEmpty
        assertThat(originRequest.cloudinaryBackup()).isEmpty
        assertThat(originRequest.webFolder()).isEmpty
        assertThat(originRequest.webProxy()).isEmpty
        assertThat(originRequest.gcs()).contains(gcs)
        assertThat(originRequest.azureBlob()).isEmpty
        assertThat(originRequest.akeneoPim()).isEmpty
    }

    @Test
    fun ofGcsRoundtrip() {
        val jsonMapper = jsonMapper()
        val originRequest =
            OriginRequest.ofGcs(
                OriginRequest.Gcs.builder()
                    .bucket("gcs-media")
                    .clientEmail("service-account@project.iam.gserviceaccount.com")
                    .name("US S3 Storage")
                    .privateKey("-----BEGIN PRIVATE KEY-----\\nMIIEv...")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("products")
                    .build()
            )

        val roundtrippedOriginRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originRequest),
                jacksonTypeRef<OriginRequest>(),
            )

        assertThat(roundtrippedOriginRequest).isEqualTo(originRequest)
    }

    @Test
    fun ofAzureBlob() {
        val azureBlob =
            OriginRequest.AzureBlob.builder()
                .accountName("account123")
                .container("images")
                .name("US S3 Storage")
                .sasToken("?sv=2023-01-03&sr=c&sig=abc123")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .prefix("uploads")
                .build()

        val originRequest = OriginRequest.ofAzureBlob(azureBlob)

        assertThat(originRequest.s3()).isEmpty
        assertThat(originRequest.s3Compatible()).isEmpty
        assertThat(originRequest.cloudinaryBackup()).isEmpty
        assertThat(originRequest.webFolder()).isEmpty
        assertThat(originRequest.webProxy()).isEmpty
        assertThat(originRequest.gcs()).isEmpty
        assertThat(originRequest.azureBlob()).contains(azureBlob)
        assertThat(originRequest.akeneoPim()).isEmpty
    }

    @Test
    fun ofAzureBlobRoundtrip() {
        val jsonMapper = jsonMapper()
        val originRequest =
            OriginRequest.ofAzureBlob(
                OriginRequest.AzureBlob.builder()
                    .accountName("account123")
                    .container("images")
                    .name("US S3 Storage")
                    .sasToken("?sv=2023-01-03&sr=c&sig=abc123")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("uploads")
                    .build()
            )

        val roundtrippedOriginRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originRequest),
                jacksonTypeRef<OriginRequest>(),
            )

        assertThat(roundtrippedOriginRequest).isEqualTo(originRequest)
    }

    @Test
    fun ofAkeneoPim() {
        val akeneoPim =
            OriginRequest.AkeneoPim.builder()
                .baseUrl("https://akeneo.company.com")
                .clientId("akeneo-client-id")
                .clientSecret("akeneo-client-secret")
                .name("US S3 Storage")
                .password("strongpassword123")
                .username("integration-user")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .includeCanonicalHeader(false)
                .build()

        val originRequest = OriginRequest.ofAkeneoPim(akeneoPim)

        assertThat(originRequest.s3()).isEmpty
        assertThat(originRequest.s3Compatible()).isEmpty
        assertThat(originRequest.cloudinaryBackup()).isEmpty
        assertThat(originRequest.webFolder()).isEmpty
        assertThat(originRequest.webProxy()).isEmpty
        assertThat(originRequest.gcs()).isEmpty
        assertThat(originRequest.azureBlob()).isEmpty
        assertThat(originRequest.akeneoPim()).contains(akeneoPim)
    }

    @Test
    fun ofAkeneoPimRoundtrip() {
        val jsonMapper = jsonMapper()
        val originRequest =
            OriginRequest.ofAkeneoPim(
                OriginRequest.AkeneoPim.builder()
                    .baseUrl("https://akeneo.company.com")
                    .clientId("akeneo-client-id")
                    .clientSecret("akeneo-client-secret")
                    .name("US S3 Storage")
                    .password("strongpassword123")
                    .username("integration-user")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .build()
            )

        val roundtrippedOriginRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originRequest),
                jacksonTypeRef<OriginRequest>(),
            )

        assertThat(roundtrippedOriginRequest).isEqualTo(originRequest)
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
        val originRequest =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<OriginRequest>())

        val e = assertThrows<ImageKitInvalidDataException> { originRequest.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
