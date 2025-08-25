// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.urlendpoints

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlEndpointTest {

    @Test
    fun create() {
        val urlEndpoint =
            UrlEndpoint.builder()
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpoint.UrlRewriter.Cloudinary.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
                .build()

        assertThat(urlEndpoint.description()).isEqualTo("My custom URL endpoint")
        assertThat(urlEndpoint.origins().getOrNull()).containsExactly("origin-id-1")
        assertThat(urlEndpoint.urlPrefix()).contains("product-images")
        assertThat(urlEndpoint.urlRewriter())
            .contains(
                UrlEndpoint.UrlRewriter.ofCloudinary(
                    UrlEndpoint.UrlRewriter.Cloudinary.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val urlEndpoint =
            UrlEndpoint.builder()
                .description("My custom URL endpoint")
                .addOrigin("origin-id-1")
                .urlPrefix("product-images")
                .urlRewriter(
                    UrlEndpoint.UrlRewriter.Cloudinary.builder()
                        .preserveAssetDeliveryTypes(true)
                        .build()
                )
                .build()

        val roundtrippedUrlEndpoint =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(urlEndpoint),
                jacksonTypeRef<UrlEndpoint>(),
            )

        assertThat(roundtrippedUrlEndpoint).isEqualTo(urlEndpoint)
    }
}
