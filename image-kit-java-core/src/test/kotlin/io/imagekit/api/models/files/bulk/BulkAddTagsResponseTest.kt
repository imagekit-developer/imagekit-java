// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.files.bulk

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkAddTagsResponseTest {

    @Test
    fun create() {
        val bulkAddTagsResponse =
            BulkAddTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        assertThat(bulkAddTagsResponse.successfullyUpdatedFileIds().getOrNull())
            .containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkAddTagsResponse =
            BulkAddTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        val roundtrippedBulkAddTagsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkAddTagsResponse),
                jacksonTypeRef<BulkAddTagsResponse>(),
            )

        assertThat(roundtrippedBulkAddTagsResponse).isEqualTo(bulkAddTagsResponse)
    }
}
