// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.origins

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OriginUpdateParamsTest {

    @Test
    fun create() {
        OriginUpdateParams.builder()
            .id("id")
            .name("name")
            .type(OriginUpdateParams.Type.S3)
            .accessKey("x")
            .accountName("x")
            .baseUrl("https://example.com")
            .baseUrlForCanonicalHeader("https://example.com")
            .bucket("x")
            .clientEmail("dev@stainless.com")
            .clientId("x")
            .clientSecret("x")
            .container("x")
            .endpoint("https://example.com")
            .forwardHostHeaderToOrigin(true)
            .includeCanonicalHeader(true)
            .password("x")
            .prefix("prefix")
            .privateKey("x")
            .s3ForcePathStyle(true)
            .sasToken("x")
            .secretKey("x")
            .username("x")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            OriginUpdateParams.builder()
                .id("id")
                .name("name")
                .type(OriginUpdateParams.Type.S3)
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
                .name("name")
                .type(OriginUpdateParams.Type.S3)
                .accessKey("x")
                .accountName("x")
                .baseUrl("https://example.com")
                .baseUrlForCanonicalHeader("https://example.com")
                .bucket("x")
                .clientEmail("dev@stainless.com")
                .clientId("x")
                .clientSecret("x")
                .container("x")
                .endpoint("https://example.com")
                .forwardHostHeaderToOrigin(true)
                .includeCanonicalHeader(true)
                .password("x")
                .prefix("prefix")
                .privateKey("x")
                .s3ForcePathStyle(true)
                .sasToken("x")
                .secretKey("x")
                .username("x")
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.type()).isEqualTo(OriginUpdateParams.Type.S3)
        assertThat(body.accessKey()).contains("x")
        assertThat(body.accountName()).contains("x")
        assertThat(body.baseUrl()).contains("https://example.com")
        assertThat(body.baseUrlForCanonicalHeader()).contains("https://example.com")
        assertThat(body.bucket()).contains("x")
        assertThat(body.clientEmail()).contains("dev@stainless.com")
        assertThat(body.clientId()).contains("x")
        assertThat(body.clientSecret()).contains("x")
        assertThat(body.container()).contains("x")
        assertThat(body.endpoint()).contains("https://example.com")
        assertThat(body.forwardHostHeaderToOrigin()).contains(true)
        assertThat(body.includeCanonicalHeader()).contains(true)
        assertThat(body.password()).contains("x")
        assertThat(body.prefix()).contains("prefix")
        assertThat(body.privateKey()).contains("x")
        assertThat(body.s3ForcePathStyle()).contains(true)
        assertThat(body.sasToken()).contains("x")
        assertThat(body.secretKey()).contains("x")
        assertThat(body.username()).contains("x")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OriginUpdateParams.builder()
                .id("id")
                .name("name")
                .type(OriginUpdateParams.Type.S3)
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.type()).isEqualTo(OriginUpdateParams.Type.S3)
    }
}
