// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.aifiltersearch

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AiFilterSearchCreateResponseTest {

    @Test
    fun create() {
        val aiFilterSearchCreateResponse =
            AiFilterSearchCreateResponse.builder()
                .fileType(AiFilterSearchCreateResponse.FileType.EMPTY)
                .isVersionIncludedInSearch(true)
                .searchQuery("searchQuery")
                .build()

        assertThat(aiFilterSearchCreateResponse.fileType())
            .contains(AiFilterSearchCreateResponse.FileType.EMPTY)
        assertThat(aiFilterSearchCreateResponse.isVersionIncludedInSearch()).contains(true)
        assertThat(aiFilterSearchCreateResponse.searchQuery()).contains("searchQuery")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val aiFilterSearchCreateResponse =
            AiFilterSearchCreateResponse.builder()
                .fileType(AiFilterSearchCreateResponse.FileType.EMPTY)
                .isVersionIncludedInSearch(true)
                .searchQuery("searchQuery")
                .build()

        val roundtrippedAiFilterSearchCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(aiFilterSearchCreateResponse),
                jacksonTypeRef<AiFilterSearchCreateResponse>(),
            )

        assertThat(roundtrippedAiFilterSearchCreateResponse).isEqualTo(aiFilterSearchCreateResponse)
    }
}
