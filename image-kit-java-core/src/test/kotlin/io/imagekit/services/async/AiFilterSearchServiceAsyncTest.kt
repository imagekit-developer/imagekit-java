// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.models.aifiltersearch.AiFilterSearchCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AiFilterSearchServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val aiFilterSearchServiceAsync = client.aiFilterSearch()

        val aiFilterSearchFuture =
            aiFilterSearchServiceAsync.create(
                AiFilterSearchCreateParams.builder()
                    .prompt("red dresses tagged summer uploaded last month")
                    .currentFolder("/products")
                    .timezone("Asia/Kolkata")
                    .build()
            )

        val aiFilterSearch = aiFilterSearchFuture.get()
        aiFilterSearch.validate()
    }
}
