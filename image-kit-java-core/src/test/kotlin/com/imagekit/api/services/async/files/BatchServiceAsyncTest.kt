// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.files

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.files.batch.BatchDeleteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BatchServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val batchServiceAsync = client.files().batch()

        val batchFuture =
            batchServiceAsync.delete(
                BatchDeleteParams.builder()
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .build()
            )

        val batch = batchFuture.get()
        batch.validate()
    }
}
