// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.accounts

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.accounts.urlendpoints.UrlEndpointCreateParams
import com.imagekit.api.models.accounts.urlendpoints.UrlEndpointRequest
import com.imagekit.api.models.accounts.urlendpoints.UrlEndpointUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UrlEndpointServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val urlEndpointServiceAsync = client.accounts().urlEndpoints()

        val urlEndpointResponseFuture =
            urlEndpointServiceAsync.create(
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
            )

        val urlEndpointResponse = urlEndpointResponseFuture.get()
        urlEndpointResponse.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
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

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val urlEndpointServiceAsync = client.accounts().urlEndpoints()

        val urlEndpointResponsesFuture = urlEndpointServiceAsync.list()

        val urlEndpointResponses = urlEndpointResponsesFuture.get()
        urlEndpointResponses.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val urlEndpointServiceAsync = client.accounts().urlEndpoints()

        val future = urlEndpointServiceAsync.delete("id")

        val response = future.get()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val urlEndpointServiceAsync = client.accounts().urlEndpoints()

        val urlEndpointResponseFuture = urlEndpointServiceAsync.get("id")

        val urlEndpointResponse = urlEndpointResponseFuture.get()
        urlEndpointResponse.validate()
    }
}
