// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.urlendpoints

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlEndpointUpdateResponseTest {

    @Test
    fun create() {
        val urlEndpointUpdateResponse =
            UrlEndpointUpdateResponse.builder()
                .id("id")
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .addOrigin("origin-id-2")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpointUpdateResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
                .build()

        assertThat(urlEndpointUpdateResponse.id()).isEqualTo("id")
        assertThat(urlEndpointUpdateResponse.description()).isEqualTo("My custom URL endpoint")
        assertThat(urlEndpointUpdateResponse.origins())
            .containsExactly("origin-id-1", "origin-id-2")
        assertThat(urlEndpointUpdateResponse.urlPrefix()).isEqualTo("product-images")
        assertThat(urlEndpointUpdateResponse.urlRewriter())
            .contains(
                UrlEndpointUpdateResponse.UrlRewriter.ofCloudinary(
                    UrlEndpointUpdateResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val urlEndpointUpdateResponse =
            UrlEndpointUpdateResponse.builder()
                .id("id")
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .addOrigin("origin-id-2")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpointUpdateResponse.UrlRewriter.CloudinaryUrlRewriter.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
                .build()

        val roundtrippedUrlEndpointUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(urlEndpointUpdateResponse),
                jacksonTypeRef<UrlEndpointUpdateResponse>(),
            )

        assertThat(roundtrippedUrlEndpointUpdateResponse).isEqualTo(urlEndpointUpdateResponse)
    }
}
