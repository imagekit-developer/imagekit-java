// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.urlendpoints

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlEndpointCreateResponseTest {

    @Test
    fun create() {
        val urlEndpointCreateResponse =
            UrlEndpointCreateResponse.builder()
                .id("id")
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .addOrigin("origin-id-2")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpointCreateResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
                .build()

        assertThat(urlEndpointCreateResponse.id()).isEqualTo("id")
        assertThat(urlEndpointCreateResponse.description()).isEqualTo("My custom URL endpoint")
        assertThat(urlEndpointCreateResponse.origins())
            .containsExactly("origin-id-1", "origin-id-2")
        assertThat(urlEndpointCreateResponse.urlPrefix()).isEqualTo("product-images")
        assertThat(urlEndpointCreateResponse.urlRewriter())
            .contains(
                UrlEndpointCreateResponse.UrlRewriter.ofCloudinary(
                    UrlEndpointCreateResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val urlEndpointCreateResponse =
            UrlEndpointCreateResponse.builder()
                .id("id")
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .addOrigin("origin-id-2")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpointCreateResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
                .build()

        val roundtrippedUrlEndpointCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(urlEndpointCreateResponse),
                jacksonTypeRef<UrlEndpointCreateResponse>(),
            )

        assertThat(roundtrippedUrlEndpointCreateResponse).isEqualTo(urlEndpointCreateResponse)
    }
}
