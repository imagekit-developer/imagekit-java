// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.usageanalytics

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RequestBandwidthEntryTest {

    @Test
    fun create() {
        val requestBandwidthEntry =
            RequestBandwidthEntry.builder().bandwidthBytes(0.0).requestCount(0.0).build()

        assertThat(requestBandwidthEntry.bandwidthBytes()).isEqualTo(0.0)
        assertThat(requestBandwidthEntry.requestCount()).isEqualTo(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val requestBandwidthEntry =
            RequestBandwidthEntry.builder().bandwidthBytes(0.0).requestCount(0.0).build()

        val roundtrippedRequestBandwidthEntry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(requestBandwidthEntry),
                jacksonTypeRef<RequestBandwidthEntry>(),
            )

        assertThat(roundtrippedRequestBandwidthEntry).isEqualTo(requestBandwidthEntry)
    }
}
