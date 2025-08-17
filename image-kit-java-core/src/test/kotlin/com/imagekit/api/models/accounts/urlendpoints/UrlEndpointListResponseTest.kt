// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.urlendpoints

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlEndpointListResponseTest {

    @Test
    fun create() {
        val urlEndpointListResponse =
            UrlEndpointListResponse.builder()
                .id("id")
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .addOrigin("origin-id-2")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpointListResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .type(
                            UrlEndpointListResponse.UrlRewriter.CloudinaryUrlRewriter.Type
                                .CLOUDINARY
                        )
                        .build()
                )
                .build()

        assertThat(urlEndpointListResponse.id()).isEqualTo("id")
        assertThat(urlEndpointListResponse.description()).isEqualTo("My custom URL endpoint")
        assertThat(urlEndpointListResponse.origins()).containsExactly("origin-id-1", "origin-id-2")
        assertThat(urlEndpointListResponse.urlPrefix()).isEqualTo("product-images")
        assertThat(urlEndpointListResponse.urlRewriter())
            .contains(
                UrlEndpointListResponse.UrlRewriter.ofCloudinary(
                    UrlEndpointListResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .type(
                            UrlEndpointListResponse.UrlRewriter.CloudinaryUrlRewriter.Type
                                .CLOUDINARY
                        )
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val urlEndpointListResponse =
            UrlEndpointListResponse.builder()
                .id("id")
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .addOrigin("origin-id-2")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpointListResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .type(
                            UrlEndpointListResponse.UrlRewriter.CloudinaryUrlRewriter.Type
                                .CLOUDINARY
                        )
                        .build()
                )
                .build()

        val roundtrippedUrlEndpointListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(urlEndpointListResponse),
                jacksonTypeRef<UrlEndpointListResponse>(),
            )

        assertThat(roundtrippedUrlEndpointListResponse).isEqualTo(urlEndpointListResponse)
    }
}
