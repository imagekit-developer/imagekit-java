// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.origins

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OriginCreateParamsTest {

    @Test
    fun create() {
        OriginCreateParams.builder()
            .origin(
                Origin.S3.builder()
                    .bucket("test-bucket")
                    .name("My S3 Origin")
                    .id("id")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("images")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            OriginCreateParams.builder()
                .origin(
                    Origin.S3.builder()
                        .bucket("test-bucket")
                        .name("My S3 Origin")
                        .id("id")
                        .baseUrlForCanonicalHeader("https://cdn.example.com")
                        .includeCanonicalHeader(false)
                        .prefix("images")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                Origin.ofS3(
                    Origin.S3.builder()
                        .bucket("test-bucket")
                        .name("My S3 Origin")
                        .id("id")
                        .baseUrlForCanonicalHeader("https://cdn.example.com")
                        .includeCanonicalHeader(false)
                        .prefix("images")
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OriginCreateParams.builder()
                .origin(Origin.S3.builder().bucket("test-bucket").name("My S3 Origin").build())
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                Origin.ofS3(Origin.S3.builder().bucket("test-bucket").name("My S3 Origin").build())
            )
    }
}
