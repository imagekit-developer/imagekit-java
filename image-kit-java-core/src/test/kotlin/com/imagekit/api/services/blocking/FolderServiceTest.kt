// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.folder.FolderCreateParams
import com.imagekit.api.models.folder.FolderDeleteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FolderServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val folderService = client.folder()

        val folder =
            folderService.create(
                FolderCreateParams.builder()
                    .folderName("summer")
                    .parentFolderPath("/product/images/")
                    .build()
            )

        folder.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val folderService = client.folder()

        val folder =
            folderService.delete(
                FolderDeleteParams.builder().folderPath("/folder/to/delete/").build()
            )

        folder.validate()
    }
}
