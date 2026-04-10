// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.accounts

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.accounts.urlendpoints.UrlEndpointRequest
import com.imagekit.api.models.accounts.urlendpoints.UrlEndpointUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UrlEndpointServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val urlEndpointService = client.accounts().urlEndpoints()

        val urlEndpointResponse =
            urlEndpointService.create(
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

        urlEndpointResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val urlEndpointService = client.accounts().urlEndpoints()

        val urlEndpointResponse =
            urlEndpointService.update(
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
            )

        urlEndpointResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val urlEndpointService = client.accounts().urlEndpoints()

        val urlEndpointResponses = urlEndpointService.list()

        urlEndpointResponses.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val urlEndpointService = client.accounts().urlEndpoints()

        urlEndpointService.delete("id")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val urlEndpointService = client.accounts().urlEndpoints()

        val urlEndpointResponse = urlEndpointService.get("id")

        urlEndpointResponse.validate()
    }
}
