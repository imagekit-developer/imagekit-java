// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.usageanalytics

import io.imagekit.core.http.QueryParams
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageAnalyticsGetParamsTest {

    @Test
    fun create() {
        UsageAnalyticsGetParams.builder()
            .endDate(LocalDate.parse("2019-12-27"))
            .startDate(LocalDate.parse("2019-12-27"))
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            UsageAnalyticsGetParams.builder()
                .endDate(LocalDate.parse("2019-12-27"))
                .startDate(LocalDate.parse("2019-12-27"))
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("endDate", "2019-12-27")
                    .put("startDate", "2019-12-27")
                    .build()
            )
    }
}
