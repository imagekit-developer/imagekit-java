// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.accounts

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.accounts.urlendpoints.UrlEndpoint
import com.imagekit.api.models.accounts.urlendpoints.UrlEndpointCreateParams
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

        val urlEndpointFuture =
            urlEndpointServiceAsync.create(
                UrlEndpointCreateParams.builder()
                    .urlEndpoint(
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
                    )
                    .build()
            )

        val urlEndpoint = urlEndpointFuture.get()
        urlEndpoint.validate()
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

        val urlEndpointFuture =
            urlEndpointServiceAsync.update(
                UrlEndpointUpdateParams.builder()
                    .id("id")
                    .urlEndpoint(
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
                    )
                    .build()
            )

        val urlEndpoint = urlEndpointFuture.get()
        urlEndpoint.validate()
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

        val urlEndpointsFuture = urlEndpointServiceAsync.list()

        val urlEndpoints = urlEndpointsFuture.get()
        urlEndpoints.forEach { it.validate() }
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

        val urlEndpointFuture = urlEndpointServiceAsync.get("id")

        val urlEndpoint = urlEndpointFuture.get()
        urlEndpoint.validate()
    }
}
