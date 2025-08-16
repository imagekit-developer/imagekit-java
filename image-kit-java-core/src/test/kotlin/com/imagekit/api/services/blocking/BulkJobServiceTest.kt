// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.bulkjobs.BulkJobCopyFolderParams
import com.imagekit.api.models.bulkjobs.BulkJobMoveFolderParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkJobServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun copyFolder() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val bulkJobService = client.bulkJobs()

        val response =
            bulkJobService.copyFolder(
                BulkJobCopyFolderParams.builder()
                    .destinationPath("/path/of/destination/folder")
                    .sourceFolderPath("/path/of/source/folder")
                    .includeVersions(true)
                    .build()
            )

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun moveFolder() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val bulkJobService = client.bulkJobs()

        val response =
            bulkJobService.moveFolder(
                BulkJobMoveFolderParams.builder()
                    .destinationPath("/path/of/destination/folder")
                    .sourceFolderPath("/path/of/source/folder")
                    .build()
            )

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveStatus() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val bulkJobService = client.bulkJobs()

        val response = bulkJobService.retrieveStatus("jobId")

        response.validate()
    }
}
