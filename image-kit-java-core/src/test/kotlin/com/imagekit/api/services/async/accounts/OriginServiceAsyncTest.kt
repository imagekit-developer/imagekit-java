// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.accounts

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.accounts.origins.OriginCreateParams
import com.imagekit.api.models.accounts.origins.OriginUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OriginServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val originServiceAsync = client.accounts().origins()

        val originFuture =
            originServiceAsync.create(
                OriginCreateParams.builder()
                    .body(
                        OriginCreateParams.Body.S3.builder()
                            .accessKey("AKIATEST123")
                            .bucket("test-bucket")
                            .name("My S3 Origin")
                            .secretKey("secrettest123")
                            .type(OriginCreateParams.Body.S3.Type.S3)
                            .baseUrlForCanonicalHeader("https://cdn.example.com")
                            .includeCanonicalHeader(false)
                            .prefix("images")
                            .build()
                    )
                    .build()
            )

        val origin = originFuture.get()
        origin.validate()
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
        val originServiceAsync = client.accounts().origins()

        val originFuture =
            originServiceAsync.update(
                OriginUpdateParams.builder()
                    .id("id")
                    .body(
                        OriginUpdateParams.Body.S3.builder()
                            .accessKey("AKIATEST123")
                            .bucket("test-bucket")
                            .name("My S3 Origin")
                            .secretKey("secrettest123")
                            .type(OriginUpdateParams.Body.S3.Type.S3)
                            .baseUrlForCanonicalHeader("https://cdn.example.com")
                            .includeCanonicalHeader(false)
                            .prefix("images")
                            .build()
                    )
                    .build()
            )

        val origin = originFuture.get()
        origin.validate()
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
        val originServiceAsync = client.accounts().origins()

        val originsFuture = originServiceAsync.list()

        val origins = originsFuture.get()
        origins.forEach { it.validate() }
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
        val originServiceAsync = client.accounts().origins()

        val future = originServiceAsync.delete("id")

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
        val originServiceAsync = client.accounts().origins()

        val originFuture = originServiceAsync.get("id")

        val origin = originFuture.get()
        origin.validate()
    }
}
