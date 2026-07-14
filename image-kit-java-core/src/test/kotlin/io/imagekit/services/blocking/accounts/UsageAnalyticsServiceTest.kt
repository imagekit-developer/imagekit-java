// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking.accounts

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import io.imagekit.models.accounts.usageanalytics.UsageAnalyticsGetParams
import java.time.LocalDate
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UsageAnalyticsServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val usageAnalyticsService = client.accounts().usageAnalytics()

        val usageAnalyticsResponse =
            usageAnalyticsService.get(
                UsageAnalyticsGetParams.builder()
                    .endDate(LocalDate.parse("2019-12-27"))
                    .startDate(LocalDate.parse("2019-12-27"))
                    .build()
            )

        usageAnalyticsResponse.validate()
    }
}
