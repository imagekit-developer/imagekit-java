// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.origins

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OriginCreateParamsTest {

    @Test
    fun create() {
        OriginCreateParams.builder()
            .name("name")
            .type(OriginCreateParams.Type.S3)
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
    fun body() {
        val params =
            OriginCreateParams.builder()
                .name("name")
                .type(OriginCreateParams.Type.S3)
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
        assertThat(body.type()).isEqualTo(OriginCreateParams.Type.S3)
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
            OriginCreateParams.builder().name("name").type(OriginCreateParams.Type.S3).build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.type()).isEqualTo(OriginCreateParams.Type.S3)
    }
}
