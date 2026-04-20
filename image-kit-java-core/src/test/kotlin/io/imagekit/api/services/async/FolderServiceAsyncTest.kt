// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.async

import io.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.api.models.folders.FolderCopyParams
import io.imagekit.api.models.folders.FolderCreateParams
import io.imagekit.api.models.folders.FolderDeleteParams
import io.imagekit.api.models.folders.FolderMoveParams
import io.imagekit.api.models.folders.FolderRenameParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FolderServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun copy() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun move() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun rename() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
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
