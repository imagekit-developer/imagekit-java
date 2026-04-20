// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.accounts.urlendpoints

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlEndpointUpdateParamsTest {

    @Test
    fun create() {
        UrlEndpointUpdateParams.builder()
            .id("id")
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
    fun pathParams() {
        val params =
            UrlEndpointUpdateParams.builder()
                .id("id")
                .urlEndpointRequest(
                    UrlEndpointRequest.builder().description("My custom URL endpoint").build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            UrlEndpointUpdateParams.builder()
                .id("id")
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
            UrlEndpointUpdateParams.builder()
                .id("id")
                .urlEndpointRequest(
                    UrlEndpointRequest.builder().description("My custom URL endpoint").build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(UrlEndpointRequest.builder().description("My custom URL endpoint").build())
    }
}
