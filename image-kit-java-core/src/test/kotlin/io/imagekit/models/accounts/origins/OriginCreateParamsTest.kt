// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.origins

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OriginCreateParamsTest {

    @Test
    fun create() {
        OriginCreateParams.builder()
            .originRequest(
                OriginRequest.S3.builder()
                    .accessKey("AKIATEST123")
                    .bucket("test-bucket")
                    .name("My S3 Origin")
                    .secretKey("secrettest123")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("images")
                    .useIamRole(true)
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            OriginCreateParams.builder()
                .originRequest(
                    OriginRequest.S3.builder()
                        .accessKey("AKIATEST123")
                        .bucket("test-bucket")
                        .name("My S3 Origin")
                        .secretKey("secrettest123")
                        .baseUrlForCanonicalHeader("https://cdn.example.com")
                        .includeCanonicalHeader(false)
                        .prefix("images")
                        .useIamRole(true)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OriginRequest.ofS3(
                    OriginRequest.S3.builder()
                        .accessKey("AKIATEST123")
                        .bucket("test-bucket")
                        .name("My S3 Origin")
                        .secretKey("secrettest123")
                        .baseUrlForCanonicalHeader("https://cdn.example.com")
                        .includeCanonicalHeader(false)
                        .prefix("images")
                        .useIamRole(true)
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OriginCreateParams.builder()
                .originRequest(
                    OriginRequest.S3.builder()
                        .accessKey("AKIATEST123")
                        .bucket("test-bucket")
                        .name("My S3 Origin")
                        .secretKey("secrettest123")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OriginRequest.ofS3(
                    OriginRequest.S3.builder()
                        .accessKey("AKIATEST123")
                        .bucket("test-bucket")
                        .name("My S3 Origin")
                        .secretKey("secrettest123")
                        .build()
                )
            )
    }
}
