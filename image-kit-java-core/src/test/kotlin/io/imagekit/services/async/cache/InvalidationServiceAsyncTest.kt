// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.cache

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.models.cache.invalidation.InvalidationCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class InvalidationServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val invalidationServiceAsync = client.cache().invalidation()

        val invalidationFuture =
            invalidationServiceAsync.create(
                InvalidationCreateParams.builder()
                    .url("https://ik.imagekit.io/your_imagekit_id/default-image.jpg")
                    .build()
            )

        val invalidation = invalidationFuture.get()
        invalidation.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val invalidationServiceAsync = client.cache().invalidation()

        val invalidationFuture = invalidationServiceAsync.get("requestId")

        val invalidation = invalidationFuture.get()
        invalidation.validate()
    }
}
