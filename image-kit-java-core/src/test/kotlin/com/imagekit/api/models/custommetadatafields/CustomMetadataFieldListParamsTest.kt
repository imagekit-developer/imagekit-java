// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.custommetadatafields

import com.imagekit.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomMetadataFieldListParamsTest {

    @Test
    fun create() {
        CustomMetadataFieldListParams.builder().includeDeleted(true).build()
    }

    @Test
    fun queryParams() {
        val params = CustomMetadataFieldListParams.builder().includeDeleted(true).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("includeDeleted", "true").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = CustomMetadataFieldListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
