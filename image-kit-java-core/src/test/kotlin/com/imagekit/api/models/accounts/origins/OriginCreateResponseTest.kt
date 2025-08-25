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
                .id("id")
                .bucket("product-images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("raw-assets")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originCreateResponse = OriginCreateResponse.ofS3(s3)

        assertThat(originCreateResponse.s3()).contains(s3)
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.gcs()).isEmpty
        assertThat(originCreateResponse.azureBlob()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3Roundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofS3(
                OriginCreateResponse.S3.builder()
                    .id("id")
                    .bucket("product-images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("raw-assets")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
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
                .id("id")
                .bucket("product-images")
                .endpoint("https://s3.eu-central-1.wasabisys.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("raw-assets")
                .s3ForcePathStyle(true)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originCreateResponse = OriginCreateResponse.ofS3Compatible(s3Compatible)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).contains(s3Compatible)
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.gcs()).isEmpty
        assertThat(originCreateResponse.azureBlob()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3CompatibleRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofS3Compatible(
                OriginCreateResponse.S3Compatible.builder()
                    .id("id")
                    .bucket("product-images")
                    .endpoint("https://s3.eu-central-1.wasabisys.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("raw-assets")
                    .s3ForcePathStyle(true)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
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
                .id("id")
                .bucket("product-images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("raw-assets")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originCreateResponse = OriginCreateResponse.ofCloudinaryBackup(cloudinaryBackup)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).contains(cloudinaryBackup)
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.gcs()).isEmpty
        assertThat(originCreateResponse.azureBlob()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofCloudinaryBackupRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofCloudinaryBackup(
                OriginCreateResponse.CloudinaryBackup.builder()
                    .id("id")
                    .bucket("product-images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("raw-assets")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
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
                .id("id")
                .baseUrl("https://images.example.com/assets")
                .forwardHostHeaderToOrigin(false)
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originCreateResponse = OriginCreateResponse.ofWebFolder(webFolder)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).contains(webFolder)
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.gcs()).isEmpty
        assertThat(originCreateResponse.azureBlob()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebFolderRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofWebFolder(
                OriginCreateResponse.WebFolder.builder()
                    .id("id")
                    .baseUrl("https://images.example.com/assets")
                    .forwardHostHeaderToOrigin(false)
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
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
                .id("id")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originCreateResponse = OriginCreateResponse.ofWebProxy(webProxy)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).contains(webProxy)
        assertThat(originCreateResponse.gcs()).isEmpty
        assertThat(originCreateResponse.azureBlob()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebProxyRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofWebProxy(
                OriginCreateResponse.WebProxy.builder()
                    .id("id")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
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
    fun ofGcs() {
        val gcs =
            OriginCreateResponse.Gcs.builder()
                .id("id")
                .bucket("gcs-media")
                .clientEmail("service-account@project.iam.gserviceaccount.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("products")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originCreateResponse = OriginCreateResponse.ofGcs(gcs)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.gcs()).contains(gcs)
        assertThat(originCreateResponse.azureBlob()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofGcsRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofGcs(
                OriginCreateResponse.Gcs.builder()
                    .id("id")
                    .bucket("gcs-media")
                    .clientEmail("service-account@project.iam.gserviceaccount.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("products")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
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
    fun ofAzureBlob() {
        val azureBlob =
            OriginCreateResponse.AzureBlob.builder()
                .id("id")
                .accountName("account123")
                .container("images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("uploads")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originCreateResponse = OriginCreateResponse.ofAzureBlob(azureBlob)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.gcs()).isEmpty
        assertThat(originCreateResponse.azureBlob()).contains(azureBlob)
        assertThat(originCreateResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofAzureBlobRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofAzureBlob(
                OriginCreateResponse.AzureBlob.builder()
                    .id("id")
                    .accountName("account123")
                    .container("images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("uploads")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
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
                .id("id")
                .baseUrl("https://akeneo.company.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originCreateResponse = OriginCreateResponse.ofAkeneoPim(akeneoPim)

        assertThat(originCreateResponse.s3()).isEmpty
        assertThat(originCreateResponse.s3Compatible()).isEmpty
        assertThat(originCreateResponse.cloudinaryBackup()).isEmpty
        assertThat(originCreateResponse.webFolder()).isEmpty
        assertThat(originCreateResponse.webProxy()).isEmpty
        assertThat(originCreateResponse.gcs()).isEmpty
        assertThat(originCreateResponse.azureBlob()).isEmpty
        assertThat(originCreateResponse.akeneoPim()).contains(akeneoPim)
    }

    @Test
    fun ofAkeneoPimRoundtrip() {
        val jsonMapper = jsonMapper()
        val originCreateResponse =
            OriginCreateResponse.ofAkeneoPim(
                OriginCreateResponse.AkeneoPim.builder()
                    .id("id")
                    .baseUrl("https://akeneo.company.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
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
