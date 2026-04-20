// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.blocking

import io.imagekit.io.client.okhttp.ImageKitOkHttpClient
import io.imagekit.io.models.folders.FolderCopyParams
import io.imagekit.io.models.folders.FolderCreateParams
import io.imagekit.io.models.folders.FolderDeleteParams
import io.imagekit.io.models.folders.FolderMoveParams
import io.imagekit.io.models.folders.FolderRenameParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FolderServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val folderService = client.folders()

        val folder =
            folderService.create(
                FolderCreateParams.builder()
                    .folderName("summer")
                    .parentFolderPath("/product/images/")
                    .build()
            )

        folder.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val folderService = client.folders()

        val folder =
            folderService.delete(
                FolderDeleteParams.builder().folderPath("/folder/to/delete/").build()
            )

        folder.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun copy() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val folderService = client.folders()

        val response =
            folderService.copy(
                FolderCopyParams.builder()
                    .destinationPath("/path/of/destination/folder")
                    .sourceFolderPath("/path/of/source/folder")
                    .includeVersions(true)
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun move() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val folderService = client.folders()

        val response =
            folderService.move(
                FolderMoveParams.builder()
                    .destinationPath("/path/of/destination/folder")
                    .sourceFolderPath("/path/of/source/folder")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun rename() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val folderService = client.folders()

        val response =
            folderService.rename(
                FolderRenameParams.builder()
                    .folderPath("/path/of/folder")
                    .newFolderName("new-folder-name")
                    .purgeCache(true)
                    .build()
            )

        response.validate()
    }
}
