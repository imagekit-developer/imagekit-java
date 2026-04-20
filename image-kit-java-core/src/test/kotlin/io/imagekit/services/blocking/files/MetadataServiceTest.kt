// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking.files

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import io.imagekit.models.files.metadata.MetadataGetFromUrlParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MetadataServiceTest {

    @Disabled("Mock server tests are disabled")
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

    @Disabled("Mock server tests are disabled")
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
