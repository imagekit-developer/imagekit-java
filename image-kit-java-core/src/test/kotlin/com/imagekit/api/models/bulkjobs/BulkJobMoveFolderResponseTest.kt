// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.bulkjobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkJobMoveFolderResponseTest {

    @Test
    fun create() {
        val bulkJobMoveFolderResponse = BulkJobMoveFolderResponse.builder().jobId("jobId").build()

        assertThat(bulkJobMoveFolderResponse.jobId()).contains("jobId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkJobMoveFolderResponse = BulkJobMoveFolderResponse.builder().jobId("jobId").build()

        val roundtrippedBulkJobMoveFolderResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkJobMoveFolderResponse),
                jacksonTypeRef<BulkJobMoveFolderResponse>(),
            )

        assertThat(roundtrippedBulkJobMoveFolderResponse).isEqualTo(bulkJobMoveFolderResponse)
    }
}
