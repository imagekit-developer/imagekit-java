// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files.bulk

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkRemoveTagsResponseTest {

    @Test
    fun create() {
        val bulkRemoveTagsResponse =
            BulkRemoveTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        assertThat(bulkRemoveTagsResponse.successfullyUpdatedFileIds().getOrNull())
            .containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkRemoveTagsResponse =
            BulkRemoveTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        val roundtrippedBulkRemoveTagsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkRemoveTagsResponse),
                jacksonTypeRef<BulkRemoveTagsResponse>(),
            )

        assertThat(roundtrippedBulkRemoveTagsResponse).isEqualTo(bulkRemoveTagsResponse)
    }
}
