// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AsyncBulkJobResponseTest {

    @Test
    fun create() {
        val asyncBulkJobResponse = AsyncBulkJobResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val asyncBulkJobResponse = AsyncBulkJobResponse.builder().build()

        val roundtrippedAsyncBulkJobResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(asyncBulkJobResponse),
                jacksonTypeRef<AsyncBulkJobResponse>(),
            )

        assertThat(roundtrippedAsyncBulkJobResponse).isEqualTo(asyncBulkJobResponse)
    }
}
