// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.folders.FolderCopyParams
import com.imagekit.api.models.folders.FolderCreateParams
import com.imagekit.api.models.folders.FolderDeleteParams
import com.imagekit.api.models.folders.FolderMoveParams
import com.imagekit.api.models.folders.FolderRenameParams
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

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val folderService = client.folders()

        val folder =
            folderService.delete(
                FolderDeleteParams.builder().folderPath("/folder/to/delete/").build()
            )

        folder.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun copy() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val folderService = client.folders()

        val jobResponse =
            folderService.copy(
                FolderCopyParams.builder()
                    .destinationPath("/path/of/destination/folder")
                    .sourceFolderPath("/path/of/source/folder")
                    .includeVersions(true)
                    .build()
            )

        jobResponse.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun move() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val folderService = client.folders()

        val jobResponse =
            folderService.move(
                FolderMoveParams.builder()
                    .destinationPath("/path/of/destination/folder")
                    .sourceFolderPath("/path/of/source/folder")
                    .build()
            )

        jobResponse.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun rename() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val folderService = client.folders()

        val jobResponse =
            folderService.rename(
                FolderRenameParams.builder()
                    .folderPath("/path/of/folder")
                    .newFolderName("new-folder-name")
                    .purgeCache(true)
                    .build()
            )

        jobResponse.validate()
    }
}
