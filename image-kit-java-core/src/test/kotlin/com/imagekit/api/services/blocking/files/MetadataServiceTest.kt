// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.files.metadata.MetadataGetFromUrlParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MetadataServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val metadataService = client.files().metadata()

        val metadata = metadataService.get("fileId")

        metadata.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun getFromUrl() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val metadataService = client.files().metadata()

        val metadata =
            metadataService.getFromUrl(
                MetadataGetFromUrlParams.builder().url("https://example.com").build()
            )

        metadata.validate()
    }
}
