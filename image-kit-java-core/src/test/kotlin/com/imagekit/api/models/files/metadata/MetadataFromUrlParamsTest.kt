// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.metadata

import com.imagekit.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MetadataFromUrlParamsTest {

    @Test
    fun create() {
        MetadataFromUrlParams.builder().url("url").build()
    }

    @Test
    fun queryParams() {
        val params = MetadataFromUrlParams.builder().url("url").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("url", "url").build())
    }
}
