// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.accounts.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.io.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageGetResponseTest {

    @Test
    fun create() {
        val usageGetResponse =
            UsageGetResponse.builder()
                .bandwidthBytes(0L)
                .extensionUnitsCount(0L)
                .mediaLibraryStorageBytes(0L)
                .originalCacheStorageBytes(0L)
                .videoProcessingUnitsCount(0L)
                .build()

        assertThat(usageGetResponse.bandwidthBytes()).contains(0L)
        assertThat(usageGetResponse.extensionUnitsCount()).contains(0L)
        assertThat(usageGetResponse.mediaLibraryStorageBytes()).contains(0L)
        assertThat(usageGetResponse.originalCacheStorageBytes()).contains(0L)
        assertThat(usageGetResponse.videoProcessingUnitsCount()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageGetResponse =
            UsageGetResponse.builder()
                .bandwidthBytes(0L)
                .extensionUnitsCount(0L)
                .mediaLibraryStorageBytes(0L)
                .originalCacheStorageBytes(0L)
                .videoProcessingUnitsCount(0L)
                .build()

        val roundtrippedUsageGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageGetResponse),
                jacksonTypeRef<UsageGetResponse>(),
            )

        assertThat(roundtrippedUsageGetResponse).isEqualTo(usageGetResponse)
    }
}
