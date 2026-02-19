// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.folders

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class JobServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val jobService = client.folders().job()

        val job = jobService.get("jobId")

        job.validate()
    }
}
