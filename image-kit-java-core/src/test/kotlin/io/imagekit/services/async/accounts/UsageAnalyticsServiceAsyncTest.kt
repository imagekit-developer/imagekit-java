// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.accounts

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.models.accounts.usageanalytics.UsageAnalyticsGetParams
import java.time.LocalDate
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UsageAnalyticsServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val usageAnalyticsServiceAsync = client.accounts().usageAnalytics()

        val usageAnalyticsResponseFuture =
            usageAnalyticsServiceAsync.get(
                UsageAnalyticsGetParams.builder()
                    .endDate(LocalDate.parse("2019-12-27"))
                    .startDate(LocalDate.parse("2019-12-27"))
                    .build()
            )

        val usageAnalyticsResponse = usageAnalyticsResponseFuture.get()
        usageAnalyticsResponse.validate()
    }
}
