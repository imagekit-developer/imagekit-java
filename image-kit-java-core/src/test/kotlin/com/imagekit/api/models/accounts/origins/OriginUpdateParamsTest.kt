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
                OriginUpdateParams.Body.S3Origin.builder()
                    .accessKey("AKIAIOSFODNN7EXAMPLE")
                    .bucket("product-images")
                    .name("US S3 Storage")
                    .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                    .type(OriginUpdateParams.Body.S3Origin.Type.S3)
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("raw-assets")
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
                    OriginUpdateParams.Body.S3Origin.builder()
                        .accessKey("AKIAIOSFODNN7EXAMPLE")
                        .bucket("product-images")
                        .name("US S3 Storage")
                        .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                        .type(OriginUpdateParams.Body.S3Origin.Type.S3)
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
                    OriginUpdateParams.Body.S3Origin.builder()
                        .accessKey("AKIAIOSFODNN7EXAMPLE")
                        .bucket("product-images")
                        .name("US S3 Storage")
                        .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                        .type(OriginUpdateParams.Body.S3Origin.Type.S3)
                        .baseUrlForCanonicalHeader("https://cdn.example.com")
                        .includeCanonicalHeader(false)
                        .prefix("raw-assets")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OriginUpdateParams.Body.ofS3Origin(
                    OriginUpdateParams.Body.S3Origin.builder()
                        .accessKey("AKIAIOSFODNN7EXAMPLE")
                        .bucket("product-images")
                        .name("US S3 Storage")
                        .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                        .type(OriginUpdateParams.Body.S3Origin.Type.S3)
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
            OriginUpdateParams.builder()
                .id("id")
                .body(
                    OriginUpdateParams.Body.S3Origin.builder()
                        .accessKey("AKIAIOSFODNN7EXAMPLE")
                        .bucket("product-images")
                        .name("US S3 Storage")
                        .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                        .type(OriginUpdateParams.Body.S3Origin.Type.S3)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OriginUpdateParams.Body.ofS3Origin(
                    OriginUpdateParams.Body.S3Origin.builder()
                        .accessKey("AKIAIOSFODNN7EXAMPLE")
                        .bucket("product-images")
                        .name("US S3 Storage")
                        .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                        .type(OriginUpdateParams.Body.S3Origin.Type.S3)
                        .build()
                )
            )
    }
}
