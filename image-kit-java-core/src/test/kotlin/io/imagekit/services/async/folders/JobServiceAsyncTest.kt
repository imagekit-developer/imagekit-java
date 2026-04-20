// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.folders

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class JobServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val jobServiceAsync = client.folders().job()

        val jobFuture = jobServiceAsync.get("jobId")

        val job = jobFuture.get()
        job.validate()
    }
}
