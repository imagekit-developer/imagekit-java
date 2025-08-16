// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.folder.FolderCreateParams
import com.imagekit.api.models.folder.FolderDeleteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FolderServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val folderServiceAsync = client.folder()

        val folderFuture =
            folderServiceAsync.create(
                FolderCreateParams.builder()
                    .folderName("summer")
                    .parentFolderPath("/product/images/")
                    .build()
            )

        val folder = folderFuture.get()
        folder.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val folderServiceAsync = client.folder()

        val folderFuture =
            folderServiceAsync.delete(
                FolderDeleteParams.builder().folderPath("/folder/to/delete/").build()
            )

        val folder = folderFuture.get()
        folder.validate()
    }
}
