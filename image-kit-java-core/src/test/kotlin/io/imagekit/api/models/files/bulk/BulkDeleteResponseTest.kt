// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.files.bulk

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkDeleteResponseTest {

    @Test
    fun create() {
        val bulkDeleteResponse =
            BulkDeleteResponse.builder().addSuccessfullyDeletedFileId("string").build()

        assertThat(bulkDeleteResponse.successfullyDeletedFileIds().getOrNull())
            .containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkDeleteResponse =
            BulkDeleteResponse.builder().addSuccessfullyDeletedFileId("string").build()

        val roundtrippedBulkDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkDeleteResponse),
                jacksonTypeRef<BulkDeleteResponse>(),
            )

        assertThat(roundtrippedBulkDeleteResponse).isEqualTo(bulkDeleteResponse)
    }
}
