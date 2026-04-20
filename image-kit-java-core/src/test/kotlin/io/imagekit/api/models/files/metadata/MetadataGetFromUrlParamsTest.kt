// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.files.metadata

import io.imagekit.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MetadataGetFromUrlParamsTest {

    @Test
    fun create() {
        MetadataGetFromUrlParams.builder().url("https://example.com").build()
    }

    @Test
    fun queryParams() {
        val params = MetadataGetFromUrlParams.builder().url("https://example.com").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("url", "https://example.com").build())
    }
}
