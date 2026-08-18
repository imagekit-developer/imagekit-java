// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import io.imagekit.models.aifiltersearch.AiFilterSearchCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AiFilterSearchServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val aiFilterSearchService = client.aiFilterSearch()

        val aiFilterSearch =
            aiFilterSearchService.create(
                AiFilterSearchCreateParams.builder()
                    .prompt("red dresses tagged summer uploaded last month")
                    .currentFolder("/products")
                    .timezone("Asia/Kolkata")
                    .build()
            )

        aiFilterSearch.validate()
    }
}
