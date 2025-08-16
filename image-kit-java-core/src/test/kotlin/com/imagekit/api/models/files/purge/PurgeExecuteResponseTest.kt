// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.purge

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PurgeExecuteResponseTest {

    @Test
    fun create() {
        val purgeExecuteResponse = PurgeExecuteResponse.builder().requestId("requestId").build()

        assertThat(purgeExecuteResponse.requestId()).contains("requestId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val purgeExecuteResponse = PurgeExecuteResponse.builder().requestId("requestId").build()

        val roundtrippedPurgeExecuteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(purgeExecuteResponse),
                jacksonTypeRef<PurgeExecuteResponse>(),
            )

        assertThat(roundtrippedPurgeExecuteResponse).isEqualTo(purgeExecuteResponse)
    }
}
