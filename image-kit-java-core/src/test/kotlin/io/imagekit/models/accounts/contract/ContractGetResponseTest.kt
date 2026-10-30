// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.contract

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import java.time.LocalDate
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContractGetResponseTest {

    @Test
    fun create() {
        val contractGetResponse =
            ContractGetResponse.builder()
                .hasContract(true)
                .asOf(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .consumed(
                    ContractUnits.builder()
                        .bandwidthBytes(0L)
                        .extensionUnitsCount(0L)
                        .purgeCacheRequests(0L)
                        .videoProcessingUnitsCount(0L)
                        .build()
                )
                .contractMonths(0L)
                .effectiveContractEndDate(LocalDate.parse("2019-12-27"))
                .effectiveContractStartDate(LocalDate.parse("2019-12-27"))
                .originalContractStartDate(LocalDate.parse("2019-12-27"))
                .quota(
                    ContractUnits.builder()
                        .bandwidthBytes(0L)
                        .extensionUnitsCount(0L)
                        .purgeCacheRequests(0L)
                        .videoProcessingUnitsCount(0L)
                        .build()
                )
                .build()

        assertThat(contractGetResponse.hasContract()).isEqualTo(true)
        assertThat(contractGetResponse.asOf())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(contractGetResponse.consumed())
            .contains(
                ContractUnits.builder()
                    .bandwidthBytes(0L)
                    .extensionUnitsCount(0L)
                    .purgeCacheRequests(0L)
                    .videoProcessingUnitsCount(0L)
                    .build()
            )
        assertThat(contractGetResponse.contractMonths()).contains(0L)
        assertThat(contractGetResponse.effectiveContractEndDate())
            .contains(LocalDate.parse("2019-12-27"))
        assertThat(contractGetResponse.effectiveContractStartDate())
            .contains(LocalDate.parse("2019-12-27"))
        assertThat(contractGetResponse.originalContractStartDate())
            .contains(LocalDate.parse("2019-12-27"))
        assertThat(contractGetResponse.quota())
            .contains(
                ContractUnits.builder()
                    .bandwidthBytes(0L)
                    .extensionUnitsCount(0L)
                    .purgeCacheRequests(0L)
                    .videoProcessingUnitsCount(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contractGetResponse =
            ContractGetResponse.builder()
                .hasContract(true)
                .asOf(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .consumed(
                    ContractUnits.builder()
                        .bandwidthBytes(0L)
                        .extensionUnitsCount(0L)
                        .purgeCacheRequests(0L)
                        .videoProcessingUnitsCount(0L)
                        .build()
                )
                .contractMonths(0L)
                .effectiveContractEndDate(LocalDate.parse("2019-12-27"))
                .effectiveContractStartDate(LocalDate.parse("2019-12-27"))
                .originalContractStartDate(LocalDate.parse("2019-12-27"))
                .quota(
                    ContractUnits.builder()
                        .bandwidthBytes(0L)
                        .extensionUnitsCount(0L)
                        .purgeCacheRequests(0L)
                        .videoProcessingUnitsCount(0L)
                        .build()
                )
                .build()

        val roundtrippedContractGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contractGetResponse),
                jacksonTypeRef<ContractGetResponse>(),
            )

        assertThat(roundtrippedContractGetResponse).isEqualTo(contractGetResponse)
    }
}
