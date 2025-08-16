// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.files

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.files.metadata.MetadataFromUrlParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MetadataServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val metadataServiceAsync = client.files().metadata()

        val metadataFuture = metadataServiceAsync.retrieve("fileId")

        val metadata = metadataFuture.get()
        metadata.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun fromUrl() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val metadataServiceAsync = client.files().metadata()

        val responseFuture =
            metadataServiceAsync.fromUrl(MetadataFromUrlParams.builder().url("url").build())

        val response = responseFuture.get()
        response.validate()
    }
}
