// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.origins

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OriginUpdateParamsTest {

    @Test
    fun create() {
        OriginUpdateParams.builder()
            .id("id")
            .body(
                OriginUpdateParams.Body.S3.builder()
                    .accessKey("AKIATEST123")
                    .bucket("test-bucket")
                    .name("My S3 Origin")
                    .secretKey("secrettest123")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("images")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            OriginUpdateParams.builder()
                .id("id")
                .body(
                    OriginUpdateParams.Body.S3.builder()
                        .accessKey("AKIATEST123")
                        .bucket("test-bucket")
                        .name("My S3 Origin")
                        .secretKey("secrettest123")
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            OriginUpdateParams.builder()
                .id("id")
                .body(
                    OriginUpdateParams.Body.S3.builder()
                        .accessKey("AKIATEST123")
                        .bucket("test-bucket")
                        .name("My S3 Origin")
                        .secretKey("secrettest123")
                        .baseUrlForCanonicalHeader("https://cdn.example.com")
                        .includeCanonicalHeader(false)
                        .prefix("images")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OriginUpdateParams.Body.ofS3(
                    OriginUpdateParams.Body.S3.builder()
                        .accessKey("AKIATEST123")
                        .bucket("test-bucket")
                        .name("My S3 Origin")
                        .secretKey("secrettest123")
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
            OriginUpdateParams.builder()
                .id("id")
                .body(
                    OriginUpdateParams.Body.S3.builder()
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
                OriginUpdateParams.Body.ofS3(
                    OriginUpdateParams.Body.S3.builder()
                        .accessKey("AKIATEST123")
                        .bucket("test-bucket")
                        .name("My S3 Origin")
                        .secretKey("secrettest123")
                        .build()
                )
            )
    }
}
