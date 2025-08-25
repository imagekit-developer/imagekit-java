// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.folders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobResponseTest {

    @Test
    fun create() {
        val jobResponse = JobResponse.builder().jobId("jobId").build()

        assertThat(jobResponse.jobId()).isEqualTo("jobId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val jobResponse = JobResponse.builder().jobId("jobId").build()

        val roundtrippedJobResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jobResponse),
                jacksonTypeRef<JobResponse>(),
            )

        assertThat(roundtrippedJobResponse).isEqualTo(jobResponse)
    }
}
