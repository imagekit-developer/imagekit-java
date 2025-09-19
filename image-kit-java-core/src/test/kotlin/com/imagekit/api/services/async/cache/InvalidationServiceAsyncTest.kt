// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.cache

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.cache.invalidation.InvalidationCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InvalidationServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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

    @Disabled("Prism tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val invalidationServiceAsync = client.cache().invalidation()

        val invalidationFuture = invalidationServiceAsync.get("requestId")

        val invalidation = invalidationFuture.get()
        invalidation.validate()
    }
}
