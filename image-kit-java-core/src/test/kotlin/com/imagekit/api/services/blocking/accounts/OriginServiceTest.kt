// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.accounts

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.accounts.origins.OriginCreateParams
import com.imagekit.api.models.accounts.origins.OriginUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OriginServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val originService = client.accounts().origins()

        val origin =
            originService.create(
                OriginCreateParams.builder()
                    .body(
                        OriginCreateParams.Body.S3Origin.builder()
                            .accessKey("AKIAIOSFODNN7EXAMPLE")
                            .bucket("product-images")
                            .name("US S3 Storage")
                            .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                            .type(OriginCreateParams.Body.S3Origin.Type.S3)
                            .baseUrlForCanonicalHeader("https://cdn.example.com")
                            .includeCanonicalHeader(false)
                            .prefix("raw-assets")
                            .build()
                    )
                    .build()
            )

        origin.validate()
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
        val originService = client.accounts().origins()

        val origin =
            originService.update(
                OriginUpdateParams.builder()
                    .id("id")
                    .body(
                        OriginUpdateParams.Body.S3Origin.builder()
                            .accessKey("AKIAIOSFODNN7EXAMPLE")
                            .bucket("product-images")
                            .name("US S3 Storage")
                            .secretKey("wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
                            .type(OriginUpdateParams.Body.S3Origin.Type.S3)
                            .baseUrlForCanonicalHeader("https://cdn.example.com")
                            .includeCanonicalHeader(false)
                            .prefix("raw-assets")
                            .build()
                    )
                    .build()
            )

        origin.validate()
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
        val originService = client.accounts().origins()

        val origins = originService.list()

        origins.forEach { it.validate() }
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
        val originService = client.accounts().origins()

        originService.delete("id")
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
        val originService = client.accounts().origins()

        val origin = originService.get("id")

        origin.validate()
    }
}
