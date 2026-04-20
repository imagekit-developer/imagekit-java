// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.urlendpoints

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlEndpointRequestTest {

    @Test
    fun create() {
        val urlEndpointRequest =
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

        assertThat(urlEndpointRequest.description()).isEqualTo("My custom URL endpoint")
        assertThat(urlEndpointRequest.origins().getOrNull()).containsExactly("origin-id-1")
        assertThat(urlEndpointRequest.urlPrefix()).contains("product-images")
        assertThat(urlEndpointRequest.urlRewriter())
            .contains(
                UrlEndpointRequest.UrlRewriter.ofCloudinary(
                    UrlEndpointRequest.UrlRewriter.Cloudinary.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val urlEndpointRequest =
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

        val roundtrippedUrlEndpointRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(urlEndpointRequest),
                jacksonTypeRef<UrlEndpointRequest>(),
            )

        assertThat(roundtrippedUrlEndpointRequest).isEqualTo(urlEndpointRequest)
    }
}
