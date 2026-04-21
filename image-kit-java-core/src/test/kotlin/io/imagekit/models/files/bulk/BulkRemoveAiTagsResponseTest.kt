// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files.bulk

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkRemoveAiTagsResponseTest {

    @Test
    fun create() {
        val bulkRemoveAiTagsResponse =
            BulkRemoveAiTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        assertThat(bulkRemoveAiTagsResponse.successfullyUpdatedFileIds().getOrNull())
            .containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkRemoveAiTagsResponse =
            BulkRemoveAiTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        val roundtrippedBulkRemoveAiTagsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkRemoveAiTagsResponse),
                jacksonTypeRef<BulkRemoveAiTagsResponse>(),
            )

        assertThat(roundtrippedBulkRemoveAiTagsResponse).isEqualTo(bulkRemoveAiTagsResponse)
    }
}
