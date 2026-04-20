// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.blocking.files

import io.imagekit.io.client.okhttp.ImageKitOkHttpClient
import io.imagekit.io.models.files.bulk.BulkAddTagsParams
import io.imagekit.io.models.files.bulk.BulkDeleteParams
import io.imagekit.io.models.files.bulk.BulkRemoveAiTagsParams
import io.imagekit.io.models.files.bulk.BulkRemoveTagsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class BulkServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val bulkService = client.files().bulk()

        val bulk =
            bulkService.delete(
                BulkDeleteParams.builder()
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .build()
            )

        bulk.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun addTags() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val bulkService = client.files().bulk()

        val response =
            bulkService.addTags(
                BulkAddTagsParams.builder()
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .tags(listOf("t-shirt", "round-neck", "sale2019"))
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun removeAiTags() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val bulkService = client.files().bulk()

        val response =
            bulkService.removeAiTags(
                BulkRemoveAiTagsParams.builder()
                    .aiTags(listOf("t-shirt", "round-neck", "sale2019"))
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun removeTags() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val bulkService = client.files().bulk()

        val response =
            bulkService.removeTags(
                BulkRemoveTagsParams.builder()
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .tags(listOf("t-shirt", "round-neck", "sale2019"))
                    .build()
            )

        response.validate()
    }
}
