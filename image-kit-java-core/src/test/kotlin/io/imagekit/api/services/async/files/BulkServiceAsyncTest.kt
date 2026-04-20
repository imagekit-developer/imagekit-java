// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.async.files

import io.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.api.models.files.bulk.BulkAddTagsParams
import io.imagekit.api.models.files.bulk.BulkDeleteParams
import io.imagekit.api.models.files.bulk.BulkRemoveAiTagsParams
import io.imagekit.api.models.files.bulk.BulkRemoveTagsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class BulkServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val bulkServiceAsync = client.files().bulk()

        val bulkFuture =
            bulkServiceAsync.delete(
                BulkDeleteParams.builder()
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .build()
            )

        val bulk = bulkFuture.get()
        bulk.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun addTags() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val bulkServiceAsync = client.files().bulk()

        val responseFuture =
            bulkServiceAsync.addTags(
                BulkAddTagsParams.builder()
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .tags(listOf("t-shirt", "round-neck", "sale2019"))
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun removeAiTags() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val bulkServiceAsync = client.files().bulk()

        val responseFuture =
            bulkServiceAsync.removeAiTags(
                BulkRemoveAiTagsParams.builder()
                    .aiTags(listOf("t-shirt", "round-neck", "sale2019"))
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun removeTags() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val bulkServiceAsync = client.files().bulk()

        val responseFuture =
            bulkServiceAsync.removeTags(
                BulkRemoveTagsParams.builder()
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .tags(listOf("t-shirt", "round-neck", "sale2019"))
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
