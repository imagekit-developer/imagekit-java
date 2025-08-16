// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.bulkjobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkJobRetrieveStatusResponseTest {

    @Test
    fun create() {
        val bulkJobRetrieveStatusResponse =
            BulkJobRetrieveStatusResponse.builder()
                .jobId("5d5b1a9b4c8c4c0001f3e4a2")
                .status("Completed")
                .type("COPY_FOLDER")
                .build()

        assertThat(bulkJobRetrieveStatusResponse.jobId()).contains("5d5b1a9b4c8c4c0001f3e4a2")
        assertThat(bulkJobRetrieveStatusResponse.status()).contains("Completed")
        assertThat(bulkJobRetrieveStatusResponse.type()).contains("COPY_FOLDER")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkJobRetrieveStatusResponse =
            BulkJobRetrieveStatusResponse.builder()
                .jobId("5d5b1a9b4c8c4c0001f3e4a2")
                .status("Completed")
                .type("COPY_FOLDER")
                .build()

        val roundtrippedBulkJobRetrieveStatusResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkJobRetrieveStatusResponse),
                jacksonTypeRef<BulkJobRetrieveStatusResponse>(),
            )

        assertThat(roundtrippedBulkJobRetrieveStatusResponse)
            .isEqualTo(bulkJobRetrieveStatusResponse)
    }
}
