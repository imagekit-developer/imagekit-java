// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.origins

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.JsonValue
import io.imagekit.core.jsonMapper
import io.imagekit.errors.ImageKitInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class OriginResponseTest {

    @Test
    fun ofS3() {
        val s3 =
            OriginResponse.S3.builder()
                .id("id")
                .bucket("product-images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("raw-assets")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originResponse = OriginResponse.ofS3(s3)

        assertThat(originResponse.s3()).contains(s3)
        assertThat(originResponse.s3Compatible()).isEmpty
        assertThat(originResponse.cloudinaryBackup()).isEmpty
        assertThat(originResponse.webFolder()).isEmpty
        assertThat(originResponse.webProxy()).isEmpty
        assertThat(originResponse.gcs()).isEmpty
        assertThat(originResponse.azureBlob()).isEmpty
        assertThat(originResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3Roundtrip() {
        val jsonMapper = jsonMapper()
        val originResponse =
            OriginResponse.ofS3(
                OriginResponse.S3.builder()
                    .id("id")
                    .bucket("product-images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("raw-assets")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originResponse),
                jacksonTypeRef<OriginResponse>(),
            )

        assertThat(roundtrippedOriginResponse).isEqualTo(originResponse)
    }

    @Test
    fun ofS3Compatible() {
        val s3Compatible =
            OriginResponse.S3Compatible.builder()
                .id("id")
                .bucket("product-images")
                .endpoint("https://s3.eu-central-1.wasabisys.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("raw-assets")
                .s3ForcePathStyle(true)
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originResponse = OriginResponse.ofS3Compatible(s3Compatible)

        assertThat(originResponse.s3()).isEmpty
        assertThat(originResponse.s3Compatible()).contains(s3Compatible)
        assertThat(originResponse.cloudinaryBackup()).isEmpty
        assertThat(originResponse.webFolder()).isEmpty
        assertThat(originResponse.webProxy()).isEmpty
        assertThat(originResponse.gcs()).isEmpty
        assertThat(originResponse.azureBlob()).isEmpty
        assertThat(originResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofS3CompatibleRoundtrip() {
        val jsonMapper = jsonMapper()
        val originResponse =
            OriginResponse.ofS3Compatible(
                OriginResponse.S3Compatible.builder()
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

        val roundtrippedOriginResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originResponse),
                jacksonTypeRef<OriginResponse>(),
            )

        assertThat(roundtrippedOriginResponse).isEqualTo(originResponse)
    }

    @Test
    fun ofCloudinaryBackup() {
        val cloudinaryBackup =
            OriginResponse.CloudinaryBackup.builder()
                .id("id")
                .bucket("product-images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("raw-assets")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originResponse = OriginResponse.ofCloudinaryBackup(cloudinaryBackup)

        assertThat(originResponse.s3()).isEmpty
        assertThat(originResponse.s3Compatible()).isEmpty
        assertThat(originResponse.cloudinaryBackup()).contains(cloudinaryBackup)
        assertThat(originResponse.webFolder()).isEmpty
        assertThat(originResponse.webProxy()).isEmpty
        assertThat(originResponse.gcs()).isEmpty
        assertThat(originResponse.azureBlob()).isEmpty
        assertThat(originResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofCloudinaryBackupRoundtrip() {
        val jsonMapper = jsonMapper()
        val originResponse =
            OriginResponse.ofCloudinaryBackup(
                OriginResponse.CloudinaryBackup.builder()
                    .id("id")
                    .bucket("product-images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("raw-assets")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originResponse),
                jacksonTypeRef<OriginResponse>(),
            )

        assertThat(roundtrippedOriginResponse).isEqualTo(originResponse)
    }

    @Test
    fun ofWebFolder() {
        val webFolder =
            OriginResponse.WebFolder.builder()
                .id("id")
                .baseUrl("https://images.example.com/assets")
                .forwardHostHeaderToOrigin(false)
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originResponse = OriginResponse.ofWebFolder(webFolder)

        assertThat(originResponse.s3()).isEmpty
        assertThat(originResponse.s3Compatible()).isEmpty
        assertThat(originResponse.cloudinaryBackup()).isEmpty
        assertThat(originResponse.webFolder()).contains(webFolder)
        assertThat(originResponse.webProxy()).isEmpty
        assertThat(originResponse.gcs()).isEmpty
        assertThat(originResponse.azureBlob()).isEmpty
        assertThat(originResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebFolderRoundtrip() {
        val jsonMapper = jsonMapper()
        val originResponse =
            OriginResponse.ofWebFolder(
                OriginResponse.WebFolder.builder()
                    .id("id")
                    .baseUrl("https://images.example.com/assets")
                    .forwardHostHeaderToOrigin(false)
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originResponse),
                jacksonTypeRef<OriginResponse>(),
            )

        assertThat(roundtrippedOriginResponse).isEqualTo(originResponse)
    }

    @Test
    fun ofWebProxy() {
        val webProxy =
            OriginResponse.WebProxy.builder()
                .id("id")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originResponse = OriginResponse.ofWebProxy(webProxy)

        assertThat(originResponse.s3()).isEmpty
        assertThat(originResponse.s3Compatible()).isEmpty
        assertThat(originResponse.cloudinaryBackup()).isEmpty
        assertThat(originResponse.webFolder()).isEmpty
        assertThat(originResponse.webProxy()).contains(webProxy)
        assertThat(originResponse.gcs()).isEmpty
        assertThat(originResponse.azureBlob()).isEmpty
        assertThat(originResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofWebProxyRoundtrip() {
        val jsonMapper = jsonMapper()
        val originResponse =
            OriginResponse.ofWebProxy(
                OriginResponse.WebProxy.builder()
                    .id("id")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originResponse),
                jacksonTypeRef<OriginResponse>(),
            )

        assertThat(roundtrippedOriginResponse).isEqualTo(originResponse)
    }

    @Test
    fun ofGcs() {
        val gcs =
            OriginResponse.Gcs.builder()
                .id("id")
                .bucket("gcs-media")
                .clientEmail("service-account@project.iam.gserviceaccount.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("products")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originResponse = OriginResponse.ofGcs(gcs)

        assertThat(originResponse.s3()).isEmpty
        assertThat(originResponse.s3Compatible()).isEmpty
        assertThat(originResponse.cloudinaryBackup()).isEmpty
        assertThat(originResponse.webFolder()).isEmpty
        assertThat(originResponse.webProxy()).isEmpty
        assertThat(originResponse.gcs()).contains(gcs)
        assertThat(originResponse.azureBlob()).isEmpty
        assertThat(originResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofGcsRoundtrip() {
        val jsonMapper = jsonMapper()
        val originResponse =
            OriginResponse.ofGcs(
                OriginResponse.Gcs.builder()
                    .id("id")
                    .bucket("gcs-media")
                    .clientEmail("service-account@project.iam.gserviceaccount.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("products")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originResponse),
                jacksonTypeRef<OriginResponse>(),
            )

        assertThat(roundtrippedOriginResponse).isEqualTo(originResponse)
    }

    @Test
    fun ofAzureBlob() {
        val azureBlob =
            OriginResponse.AzureBlob.builder()
                .id("id")
                .accountName("account123")
                .container("images")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .prefix("uploads")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originResponse = OriginResponse.ofAzureBlob(azureBlob)

        assertThat(originResponse.s3()).isEmpty
        assertThat(originResponse.s3Compatible()).isEmpty
        assertThat(originResponse.cloudinaryBackup()).isEmpty
        assertThat(originResponse.webFolder()).isEmpty
        assertThat(originResponse.webProxy()).isEmpty
        assertThat(originResponse.gcs()).isEmpty
        assertThat(originResponse.azureBlob()).contains(azureBlob)
        assertThat(originResponse.akeneoPim()).isEmpty
    }

    @Test
    fun ofAzureBlobRoundtrip() {
        val jsonMapper = jsonMapper()
        val originResponse =
            OriginResponse.ofAzureBlob(
                OriginResponse.AzureBlob.builder()
                    .id("id")
                    .accountName("account123")
                    .container("images")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .prefix("uploads")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originResponse),
                jacksonTypeRef<OriginResponse>(),
            )

        assertThat(roundtrippedOriginResponse).isEqualTo(originResponse)
    }

    @Test
    fun ofAkeneoPim() {
        val akeneoPim =
            OriginResponse.AkeneoPim.builder()
                .id("id")
                .baseUrl("https://akeneo.company.com")
                .includeCanonicalHeader(false)
                .name("US S3 Storage")
                .baseUrlForCanonicalHeader("https://cdn.example.com")
                .build()

        val originResponse = OriginResponse.ofAkeneoPim(akeneoPim)

        assertThat(originResponse.s3()).isEmpty
        assertThat(originResponse.s3Compatible()).isEmpty
        assertThat(originResponse.cloudinaryBackup()).isEmpty
        assertThat(originResponse.webFolder()).isEmpty
        assertThat(originResponse.webProxy()).isEmpty
        assertThat(originResponse.gcs()).isEmpty
        assertThat(originResponse.azureBlob()).isEmpty
        assertThat(originResponse.akeneoPim()).contains(akeneoPim)
    }

    @Test
    fun ofAkeneoPimRoundtrip() {
        val jsonMapper = jsonMapper()
        val originResponse =
            OriginResponse.ofAkeneoPim(
                OriginResponse.AkeneoPim.builder()
                    .id("id")
                    .baseUrl("https://akeneo.company.com")
                    .includeCanonicalHeader(false)
                    .name("US S3 Storage")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .build()
            )

        val roundtrippedOriginResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(originResponse),
                jacksonTypeRef<OriginResponse>(),
            )

        assertThat(roundtrippedOriginResponse).isEqualTo(originResponse)
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
        val originResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<OriginResponse>())

        val e = assertThrows<ImageKitInvalidDataException> { originResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
