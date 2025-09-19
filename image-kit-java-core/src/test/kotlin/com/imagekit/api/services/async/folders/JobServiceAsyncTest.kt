// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.folders

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class JobServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val jobServiceAsync = client.folders().job()

        val jobFuture = jobServiceAsync.get("jobId")

        val job = jobFuture.get()
        job.validate()
    }
}
