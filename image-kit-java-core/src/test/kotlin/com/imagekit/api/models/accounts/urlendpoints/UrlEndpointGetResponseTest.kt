// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.urlendpoints

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlEndpointGetResponseTest {

    @Test
    fun create() {
        val urlEndpointGetResponse =
            UrlEndpointGetResponse.builder()
                .id("id")
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .addOrigin("origin-id-2")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpointGetResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .type(
                            UrlEndpointGetResponse.UrlRewriter.CloudinaryUrlRewriter.Type.CLOUDINARY
                        )
                        .build()
                )
                .build()

        assertThat(urlEndpointGetResponse.id()).isEqualTo("id")
        assertThat(urlEndpointGetResponse.description()).isEqualTo("My custom URL endpoint")
        assertThat(urlEndpointGetResponse.origins()).containsExactly("origin-id-1", "origin-id-2")
        assertThat(urlEndpointGetResponse.urlPrefix()).isEqualTo("product-images")
        assertThat(urlEndpointGetResponse.urlRewriter())
            .contains(
                UrlEndpointGetResponse.UrlRewriter.ofCloudinary(
                    UrlEndpointGetResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .type(
                            UrlEndpointGetResponse.UrlRewriter.CloudinaryUrlRewriter.Type.CLOUDINARY
                        )
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val urlEndpointGetResponse =
            UrlEndpointGetResponse.builder()
                .id("id")
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .addOrigin("origin-id-2")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpointGetResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .type(
                            UrlEndpointGetResponse.UrlRewriter.CloudinaryUrlRewriter.Type.CLOUDINARY
                        )
                        .build()
                )
                .build()

        val roundtrippedUrlEndpointGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(urlEndpointGetResponse),
                jacksonTypeRef<UrlEndpointGetResponse>(),
            )

        assertThat(roundtrippedUrlEndpointGetResponse).isEqualTo(urlEndpointGetResponse)
    }
}
