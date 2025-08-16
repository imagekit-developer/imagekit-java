// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts

import com.imagekit.api.core.http.QueryParams
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountGetUsageParamsTest {

    @Test
    fun create() {
        AccountGetUsageParams.builder()
            .endDate(LocalDate.parse("2019-12-27"))
            .startDate(LocalDate.parse("2019-12-27"))
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            AccountGetUsageParams.builder()
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
