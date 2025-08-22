// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.urlendpoints

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlEndpointCreateParamsTest {

    @Test
    fun create() {
        UrlEndpointCreateParams.builder()
            .description("My custom URL endpoint")
            .addOrigin("origin-id-1")
            .urlPrefix("product-images")
            .urlRewriter(
                UrlEndpointCreateParams.UrlRewriter.Cloudinary.builder()
                    .preserveAssetDeliveryTypes(true)
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            UrlEndpointCreateParams.builder()
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpointCreateParams.UrlRewriter.Cloudinary.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.description()).isEqualTo("My custom URL endpoint")
        assertThat(body.origins().getOrNull()).containsExactly("origin-id-1")
        assertThat(body.urlPrefix()).contains("product-images")
        assertThat(body.urlRewriter())
            .contains(
                UrlEndpointCreateParams.UrlRewriter.ofCloudinary(
                    UrlEndpointCreateParams.UrlRewriter.Cloudinary.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = UrlEndpointCreateParams.builder().description("My custom URL endpoint").build()

        val body = params._body()

        assertThat(body.description()).isEqualTo("My custom URL endpoint")
    }
}
