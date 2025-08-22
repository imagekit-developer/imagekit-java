// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.origins

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OriginCreateParamsTest {

    @Test
    fun create() {
        OriginCreateParams.builder()
            .body(
                OriginCreateParams.Body.S3Origin.builder()
                    .accessKey("AKIAIOSFODNN7EXAMPLE")
                    .bucket("product-images")
                    .name("US S3 Storage")
                    .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                    .type(OriginCreateParams.Body.S3Origin.Type.S3)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("raw-assets")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            OriginCreateParams.builder()
                .body(
                    OriginCreateParams.Body.S3Origin.builder()
                        .accessKey("AKIAIOSFODNN7EXAMPLE")
                        .bucket("product-images")
                        .name("US S3 Storage")
                        .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                        .type(OriginCreateParams.Body.S3Origin.Type.S3)
                        .baseUrlForCanonicalHeader("https://cdn.example.com")
                        .includeCanonicalHeader(false)
                        .prefix("raw-assets")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OriginCreateParams.Body.ofS3Origin(
                    OriginCreateParams.Body.S3Origin.builder()
                        .accessKey("AKIAIOSFODNN7EXAMPLE")
                        .bucket("product-images")
                        .name("US S3 Storage")
                        .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                        .type(OriginCreateParams.Body.S3Origin.Type.S3)
                        .baseUrlForCanonicalHeader("https://cdn.example.com")
                        .includeCanonicalHeader(false)
                        .prefix("raw-assets")
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OriginCreateParams.builder()
                .body(
                    OriginCreateParams.Body.S3Origin.builder()
                        .accessKey("AKIAIOSFODNN7EXAMPLE")
                        .bucket("product-images")
                        .name("US S3 Storage")
                        .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                        .type(OriginCreateParams.Body.S3Origin.Type.S3)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OriginCreateParams.Body.ofS3Origin(
                    OriginCreateParams.Body.S3Origin.builder()
                        .accessKey("AKIAIOSFODNN7EXAMPLE")
                        .bucket("product-images")
                        .name("US S3 Storage")
                        .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                        .type(OriginCreateParams.Body.S3Origin.Type.S3)
                        .build()
                )
            )
    }
}
