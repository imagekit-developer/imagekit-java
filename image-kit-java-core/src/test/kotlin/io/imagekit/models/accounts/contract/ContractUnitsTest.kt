// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.contract

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContractUnitsTest {

    @Test
    fun create() {
        val contractUnits =
            ContractUnits.builder()
                .bandwidthBytes(0L)
                .extensionUnitsCount(0L)
                .purgeCacheRequests(0L)
                .videoProcessingUnitsCount(0L)
                .build()

        assertThat(contractUnits.bandwidthBytes()).isEqualTo(0L)
        assertThat(contractUnits.extensionUnitsCount()).isEqualTo(0L)
        assertThat(contractUnits.purgeCacheRequests()).isEqualTo(0L)
        assertThat(contractUnits.videoProcessingUnitsCount()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contractUnits =
            ContractUnits.builder()
                .bandwidthBytes(0L)
                .extensionUnitsCount(0L)
                .purgeCacheRequests(0L)
                .videoProcessingUnitsCount(0L)
                .build()

        val roundtrippedContractUnits =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contractUnits),
                jacksonTypeRef<ContractUnits>(),
            )

        assertThat(roundtrippedContractUnits).isEqualTo(contractUnits)
    }
}
