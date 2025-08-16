// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.bulkjobs.BulkJobCopyFolderParams
import com.imagekit.api.models.bulkjobs.BulkJobMoveFolderParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkJobServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun copyFolder() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val bulkJobServiceAsync = client.bulkJobs()

        val responseFuture =
            bulkJobServiceAsync.copyFolder(
                BulkJobCopyFolderParams.builder()
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
    fun moveFolder() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val bulkJobServiceAsync = client.bulkJobs()

        val responseFuture =
            bulkJobServiceAsync.moveFolder(
                BulkJobMoveFolderParams.builder()
                    .destinationPath("/path/of/destination/folder")
                    .sourceFolderPath("/path/of/source/folder")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveStatus() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val bulkJobServiceAsync = client.bulkJobs()

        val responseFuture = bulkJobServiceAsync.retrieveStatus("jobId")

        val response = responseFuture.get()
        response.validate()
    }
}
