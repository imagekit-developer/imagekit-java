// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.batch

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchDeleteResponseTest {

    @Test
    fun create() {
        val batchDeleteResponse =
            BatchDeleteResponse.builder().addSuccessfullyDeletedFileId("string").build()

        assertThat(batchDeleteResponse.successfullyDeletedFileIds().getOrNull())
            .containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchDeleteResponse =
            BatchDeleteResponse.builder().addSuccessfullyDeletedFileId("string").build()

        val roundtrippedBatchDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchDeleteResponse),
                jacksonTypeRef<BatchDeleteResponse>(),
            )

        assertThat(roundtrippedBatchDeleteResponse).isEqualTo(batchDeleteResponse)
    }
}
