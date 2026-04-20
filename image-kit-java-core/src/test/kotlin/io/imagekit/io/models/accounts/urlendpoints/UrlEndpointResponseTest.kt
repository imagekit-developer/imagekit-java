// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.accounts.urlendpoints

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.io.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlEndpointResponseTest {

    @Test
    fun create() {
        val urlEndpointResponse =
            UrlEndpointResponse.builder()
                .id("id")
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .addOrigin("origin-id-2")
                .urlPrefix("product-images")
                .cloudinaryUrlRewriter(true)
                .build()

        assertThat(urlEndpointResponse.id()).isEqualTo("id")
        assertThat(urlEndpointResponse.description()).isEqualTo("My custom URL endpoint")
        assertThat(urlEndpointResponse.origins()).containsExactly("origin-id-1", "origin-id-2")
        assertThat(urlEndpointResponse.urlPrefix()).isEqualTo("product-images")
        assertThat(urlEndpointResponse.urlRewriter())
            .contains(
                UrlEndpointResponse.UrlRewriter.ofCloudinary(
                    UrlEndpointResponse.UrlRewriter.Cloudinary.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val urlEndpointResponse =
            UrlEndpointResponse.builder()
                .id("id")
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .addOrigin("origin-id-2")
                .urlPrefix("product-images")
                .cloudinaryUrlRewriter(true)
                .build()

        val roundtrippedUrlEndpointResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(urlEndpointResponse),
                jacksonTypeRef<UrlEndpointResponse>(),
            )

        assertThat(roundtrippedUrlEndpointResponse).isEqualTo(urlEndpointResponse)
    }
}
