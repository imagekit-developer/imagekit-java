// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.files

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.files.purge.PurgeExecuteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class PurgeServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun execute() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val purgeServiceAsync = client.files().purge()

        val responseFuture =
            purgeServiceAsync.execute(
                PurgeExecuteParams.builder()
                    .url("https://ik.imagekit.io/your_imagekit_id/default-image.jpg")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun status() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val purgeServiceAsync = client.files().purge()

        val responseFuture = purgeServiceAsync.status("requestId")

        val response = responseFuture.get()
        response.validate()
    }
}
