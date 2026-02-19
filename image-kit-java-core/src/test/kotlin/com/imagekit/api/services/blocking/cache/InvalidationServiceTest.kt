// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.cache

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.cache.invalidation.InvalidationCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class InvalidationServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val invalidationService = client.cache().invalidation()

        val invalidation =
            invalidationService.create(
                InvalidationCreateParams.builder()
                    .url("https://ik.imagekit.io/your_imagekit_id/default-image.jpg")
                    .build()
            )

        invalidation.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val invalidationService = client.cache().invalidation()

        val invalidation = invalidationService.get("requestId")

        invalidation.validate()
    }
}
