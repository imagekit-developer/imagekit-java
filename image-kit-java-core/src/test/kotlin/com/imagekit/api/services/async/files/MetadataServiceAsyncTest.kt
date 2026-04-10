// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.files

import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.files.metadata.MetadataGetFromUrlParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MetadataServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client = ImageKitOkHttpClientAsync.builder().privateKey("My Private Key").build()
        val metadataServiceAsync = client.files().metadata()

        val metadataFuture = metadataServiceAsync.get("fileId")

        val metadata = metadataFuture.get()
        metadata.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getFromUrl() {
        val client = ImageKitOkHttpClientAsync.builder().privateKey("My Private Key").build()
        val metadataServiceAsync = client.files().metadata()

        val metadataFuture =
            metadataServiceAsync.getFromUrl(
                MetadataGetFromUrlParams.builder().url("https://example.com").build()
            )

        val metadata = metadataFuture.get()
        metadata.validate()
    }
}
