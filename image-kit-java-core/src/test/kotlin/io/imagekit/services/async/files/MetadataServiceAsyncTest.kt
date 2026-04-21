// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.files

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.models.files.metadata.MetadataGetFromUrlParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MetadataServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val metadataServiceAsync = client.files().metadata()

        val metadataFuture = metadataServiceAsync.get("fileId")

        val metadata = metadataFuture.get()
        metadata.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getFromUrl() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val metadataServiceAsync = client.files().metadata()

        val metadataFuture =
            metadataServiceAsync.getFromUrl(
                MetadataGetFromUrlParams.builder().url("https://example.com").build()
            )

        val metadata = metadataFuture.get()
        metadata.validate()
    }
}
