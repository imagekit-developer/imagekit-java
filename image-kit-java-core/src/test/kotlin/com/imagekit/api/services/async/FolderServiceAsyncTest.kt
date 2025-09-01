// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.folders.FolderCopyParams
import com.imagekit.api.models.folders.FolderCreateParams
import com.imagekit.api.models.folders.FolderDeleteParams
import com.imagekit.api.models.folders.FolderMoveParams
import com.imagekit.api.models.folders.FolderRenameParams
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
        val folderServiceAsync = client.folders()

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
        val folderServiceAsync = client.folders()

        val folderFuture =
            folderServiceAsync.delete(
                FolderDeleteParams.builder().folderPath("/folder/to/delete/").build()
            )

        val folder = folderFuture.get()
        folder.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun copy() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val folderServiceAsync = client.folders()

        val responseFuture =
            folderServiceAsync.copy(
                FolderCopyParams.builder()
                    .destinationPath("/path/of/destination/folder")
                    .sourceFolderPath("/path/of/source/folder")
                    .includeVersions(true)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun move() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val folderServiceAsync = client.folders()

        val responseFuture =
            folderServiceAsync.move(
                FolderMoveParams.builder()
                    .destinationPath("/path/of/destination/folder")
                    .sourceFolderPath("/path/of/source/folder")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun rename() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val folderServiceAsync = client.folders()

        val responseFuture =
            folderServiceAsync.rename(
                FolderRenameParams.builder()
                    .folderPath("/path/of/folder")
                    .newFolderName("new-folder-name")
                    .purgeCache(true)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
