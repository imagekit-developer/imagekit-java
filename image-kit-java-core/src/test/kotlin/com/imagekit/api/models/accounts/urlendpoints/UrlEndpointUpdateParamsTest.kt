// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.urlendpoints

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlEndpointUpdateParamsTest {

    @Test
    fun create() {
        UrlEndpointUpdateParams.builder()
            .id("id")
            .description("My custom URL endpoint")
            .addOrigin("origin-id-1")
            .urlPrefix("product-images")
            .urlRewriter(
                UrlEndpointUpdateParams.UrlRewriter.Cloudinary.builder()
                    .preserveAssetDeliveryTypes(true)
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UrlEndpointUpdateParams.builder().id("id").description("My custom URL endpoint").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            UrlEndpointUpdateParams.builder()
                .id("id")
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpointUpdateParams.UrlRewriter.Cloudinary.builder()
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
                UrlEndpointUpdateParams.UrlRewriter.ofCloudinary(
                    UrlEndpointUpdateParams.UrlRewriter.Cloudinary.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UrlEndpointUpdateParams.builder().id("id").description("My custom URL endpoint").build()

        val body = params._body()

        assertThat(body.description()).isEqualTo("My custom URL endpoint")
    }
}
