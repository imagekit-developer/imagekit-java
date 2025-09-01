// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.urlendpoints

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlEndpointCreateParamsTest {

    @Test
    fun create() {
        UrlEndpointCreateParams.builder()
            .urlEndpointRequest(
                UrlEndpointRequest.builder()
                    .description("My custom URL endpoint")
                    .addOrigin("origin-id-1")
                    .urlPrefix("product-images")
                    .urlRewriter(
                        UrlEndpointRequest.UrlRewriter.Cloudinary.builder()
                            .preserveAssetDeliveryTypes(true)
                            .build()
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            UrlEndpointCreateParams.builder()
                .urlEndpointRequest(
                    UrlEndpointRequest.builder()
                        .description("My custom URL endpoint")
                        .addOrigin("origin-id-1")
                        .urlPrefix("product-images")
                        .urlRewriter(
                            UrlEndpointRequest.UrlRewriter.Cloudinary.builder()
                                .preserveAssetDeliveryTypes(true)
                                .build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                UrlEndpointRequest.builder()
                    .description("My custom URL endpoint")
                    .addOrigin("origin-id-1")
                    .urlPrefix("product-images")
                    .urlRewriter(
                        UrlEndpointRequest.UrlRewriter.Cloudinary.builder()
                            .preserveAssetDeliveryTypes(true)
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UrlEndpointCreateParams.builder()
                .urlEndpointRequest(
                    UrlEndpointRequest.builder().description("My custom URL endpoint").build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(UrlEndpointRequest.builder().description("My custom URL endpoint").build())
    }
}
