// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.folders.job

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobGetResponseTest {

    @Test
    fun create() {
        val jobGetResponse =
            JobGetResponse.builder()
                .jobId("5d5b1a9b4c8c4c0001f3e4a2")
                .purgeRequestId("purgeRequestId")
                .status(JobGetResponse.Status.COMPLETED)
                .type(JobGetResponse.Type.COPY_FOLDER)
                .build()

        assertThat(jobGetResponse.jobId()).contains("5d5b1a9b4c8c4c0001f3e4a2")
        assertThat(jobGetResponse.purgeRequestId()).contains("purgeRequestId")
        assertThat(jobGetResponse.status()).contains(JobGetResponse.Status.COMPLETED)
        assertThat(jobGetResponse.type()).contains(JobGetResponse.Type.COPY_FOLDER)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val jobGetResponse =
            JobGetResponse.builder()
                .jobId("5d5b1a9b4c8c4c0001f3e4a2")
                .purgeRequestId("purgeRequestId")
                .status(JobGetResponse.Status.COMPLETED)
                .type(JobGetResponse.Type.COPY_FOLDER)
                .build()

        val roundtrippedJobGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jobGetResponse),
                jacksonTypeRef<JobGetResponse>(),
            )

        assertThat(roundtrippedJobGetResponse).isEqualTo(jobGetResponse)
    }
}
