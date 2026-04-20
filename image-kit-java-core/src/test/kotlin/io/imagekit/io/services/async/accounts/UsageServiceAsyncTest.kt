// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.async.accounts

import io.imagekit.io.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.io.models.accounts.usage.UsageGetParams
import java.time.LocalDate
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UsageServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val usageServiceAsync = client.accounts().usage()

        val usageFuture =
            usageServiceAsync.get(
                UsageGetParams.builder()
                    .endDate(LocalDate.parse("2019-12-27"))
                    .startDate(LocalDate.parse("2019-12-27"))
                    .build()
            )

        val usage = usageFuture.get()
        usage.validate()
    }
}
