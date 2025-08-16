// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.purge

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PurgeStatusResponseTest {

    @Test
    fun create() {
        val purgeStatusResponse =
            PurgeStatusResponse.builder().status(PurgeStatusResponse.Status.COMPLETED).build()

        assertThat(purgeStatusResponse.status()).contains(PurgeStatusResponse.Status.COMPLETED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val purgeStatusResponse =
            PurgeStatusResponse.builder().status(PurgeStatusResponse.Status.COMPLETED).build()

        val roundtrippedPurgeStatusResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(purgeStatusResponse),
                jacksonTypeRef<PurgeStatusResponse>(),
            )

        assertThat(roundtrippedPurgeStatusResponse).isEqualTo(purgeStatusResponse)
    }
}
