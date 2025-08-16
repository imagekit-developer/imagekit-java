// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountGetUsageResponseTest {

    @Test
    fun create() {
        val accountGetUsageResponse =
            AccountGetUsageResponse.builder()
                .bandwidthBytes(0L)
                .extensionUnitsCount(0L)
                .mediaLibraryStorageBytes(0L)
                .originalCacheStorageBytes(0L)
                .videoProcessingUnitsCount(0L)
                .build()

        assertThat(accountGetUsageResponse.bandwidthBytes()).contains(0L)
        assertThat(accountGetUsageResponse.extensionUnitsCount()).contains(0L)
        assertThat(accountGetUsageResponse.mediaLibraryStorageBytes()).contains(0L)
        assertThat(accountGetUsageResponse.originalCacheStorageBytes()).contains(0L)
        assertThat(accountGetUsageResponse.videoProcessingUnitsCount()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountGetUsageResponse =
            AccountGetUsageResponse.builder()
                .bandwidthBytes(0L)
                .extensionUnitsCount(0L)
                .mediaLibraryStorageBytes(0L)
                .originalCacheStorageBytes(0L)
                .videoProcessingUnitsCount(0L)
                .build()

        val roundtrippedAccountGetUsageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountGetUsageResponse),
                jacksonTypeRef<AccountGetUsageResponse>(),
            )

        assertThat(roundtrippedAccountGetUsageResponse).isEqualTo(accountGetUsageResponse)
    }
}
