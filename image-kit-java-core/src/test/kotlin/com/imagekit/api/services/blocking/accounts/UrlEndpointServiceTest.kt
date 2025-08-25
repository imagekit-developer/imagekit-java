// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.accounts

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.accounts.urlendpoints.UrlEndpoint
import com.imagekit.api.models.accounts.urlendpoints.UrlEndpointCreateParams
import com.imagekit.api.models.accounts.urlendpoints.UrlEndpointUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UrlEndpointServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val urlEndpointService = client.accounts().urlEndpoints()

        val urlEndpoint =
            urlEndpointService.create(
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

        urlEndpoint.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val urlEndpointService = client.accounts().urlEndpoints()

        val urlEndpoint =
            urlEndpointService.update(
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

        urlEndpoint.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val urlEndpointService = client.accounts().urlEndpoints()

        val urlEndpoints = urlEndpointService.list()

        urlEndpoints.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val urlEndpointService = client.accounts().urlEndpoints()

        urlEndpointService.delete("id")
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val urlEndpointService = client.accounts().urlEndpoints()

        val urlEndpoint = urlEndpointService.get("id")

        urlEndpoint.validate()
    }
}
