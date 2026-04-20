// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.accounts

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.models.accounts.urlendpoints.UrlEndpointRequest
import io.imagekit.models.accounts.urlendpoints.UrlEndpointUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UrlEndpointServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val urlEndpointServiceAsync = client.accounts().urlEndpoints()

        val urlEndpointResponseFuture =
            urlEndpointServiceAsync.create(
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

        val urlEndpointResponse = urlEndpointResponseFuture.get()
        urlEndpointResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val urlEndpointServiceAsync = client.accounts().urlEndpoints()

        val urlEndpointResponseFuture =
            urlEndpointServiceAsync.update(
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

        val urlEndpointResponse = urlEndpointResponseFuture.get()
        urlEndpointResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val urlEndpointServiceAsync = client.accounts().urlEndpoints()

        val urlEndpointResponsesFuture = urlEndpointServiceAsync.list()

        val urlEndpointResponses = urlEndpointResponsesFuture.get()
        urlEndpointResponses.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val urlEndpointServiceAsync = client.accounts().urlEndpoints()

        val future = urlEndpointServiceAsync.delete("id")

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val urlEndpointServiceAsync = client.accounts().urlEndpoints()

        val urlEndpointResponseFuture = urlEndpointServiceAsync.get("id")

        val urlEndpointResponse = urlEndpointResponseFuture.get()
        urlEndpointResponse.validate()
    }
}
