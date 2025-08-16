// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.files.metadata.MetadataFromUrlParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MetadataServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val metadataService = client.files().metadata()

        val metadata = metadataService.retrieve("fileId")

        metadata.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun fromUrl() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val metadataService = client.files().metadata()

        val response = metadataService.fromUrl(MetadataFromUrlParams.builder().url("url").build())

        response.validate()
    }
}
