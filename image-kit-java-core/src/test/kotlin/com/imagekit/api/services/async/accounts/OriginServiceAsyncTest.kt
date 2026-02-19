// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.accounts

import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.accounts.origins.OriginRequest
import com.imagekit.api.models.accounts.origins.OriginUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OriginServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val originServiceAsync = client.accounts().origins()

        val originResponseFuture =
            originServiceAsync.create(
                OriginRequest.S3.builder()
                    .accessKey("AKIATEST123")
                    .bucket("test-bucket")
                    .name("My S3 Origin")
                    .secretKey("secrettest123")
                    .baseUrlForCanonicalHeader("https://cdn.example.com")
                    .includeCanonicalHeader(false)
                    .prefix("images")
                    .build()
            )

        val originResponse = originResponseFuture.get()
        originResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val originServiceAsync = client.accounts().origins()

        val originResponseFuture =
            originServiceAsync.update(
                OriginUpdateParams.builder()
                    .id("id")
                    .originRequest(
                        OriginRequest.S3.builder()
                            .accessKey("AKIATEST123")
                            .bucket("test-bucket")
                            .name("My S3 Origin")
                            .secretKey("secrettest123")
                            .baseUrlForCanonicalHeader("https://cdn.example.com")
                            .includeCanonicalHeader(false)
                            .prefix("images")
                            .build()
                    )
                    .build()
            )

        val originResponse = originResponseFuture.get()
        originResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val originServiceAsync = client.accounts().origins()

        val originResponsesFuture = originServiceAsync.list()

        val originResponses = originResponsesFuture.get()
        originResponses.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val originServiceAsync = client.accounts().origins()

        val future = originServiceAsync.delete("id")

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
        val originServiceAsync = client.accounts().origins()

        val originResponseFuture = originServiceAsync.get("id")

        val originResponse = originResponseFuture.get()
        originResponse.validate()
    }
}
