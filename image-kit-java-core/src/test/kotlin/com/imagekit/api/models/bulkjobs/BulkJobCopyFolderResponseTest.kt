// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.bulkjobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkJobCopyFolderResponseTest {

    @Test
    fun create() {
        val bulkJobCopyFolderResponse = BulkJobCopyFolderResponse.builder().jobId("jobId").build()

        assertThat(bulkJobCopyFolderResponse.jobId()).contains("jobId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkJobCopyFolderResponse = BulkJobCopyFolderResponse.builder().jobId("jobId").build()

        val roundtrippedBulkJobCopyFolderResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkJobCopyFolderResponse),
                jacksonTypeRef<BulkJobCopyFolderResponse>(),
            )

        assertThat(roundtrippedBulkJobCopyFolderResponse).isEqualTo(bulkJobCopyFolderResponse)
    }
}
