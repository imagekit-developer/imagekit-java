// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TagServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val tagServiceAsync = client.tags()

        val pageFuture = tagServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }
}
