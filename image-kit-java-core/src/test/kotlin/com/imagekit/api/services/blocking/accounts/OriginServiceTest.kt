// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.accounts

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.accounts.origins.OriginRequest
import com.imagekit.api.models.accounts.origins.OriginUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OriginServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = ImageKitOkHttpClient.builder().privateKey("My Private Key").build()
        val originService = client.accounts().origins()

        val originResponse =
            originService.create(
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

        originResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = ImageKitOkHttpClient.builder().privateKey("My Private Key").build()
        val originService = client.accounts().origins()

        val originResponse =
            originService.update(
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

        originResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = ImageKitOkHttpClient.builder().privateKey("My Private Key").build()
        val originService = client.accounts().origins()

        val originResponses = originService.list()

        originResponses.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = ImageKitOkHttpClient.builder().privateKey("My Private Key").build()
        val originService = client.accounts().origins()

        originService.delete("id")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client = ImageKitOkHttpClient.builder().privateKey("My Private Key").build()
        val originService = client.accounts().origins()

        val originResponse = originService.get("id")

        originResponse.validate()
    }
}
