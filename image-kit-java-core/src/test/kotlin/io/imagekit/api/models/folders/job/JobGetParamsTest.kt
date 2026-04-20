// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.folders.job

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobGetParamsTest {

    @Test
    fun create() {
        JobGetParams.builder().jobId("jobId").build()
    }

    @Test
    fun pathParams() {
        val params = JobGetParams.builder().jobId("jobId").build()

        assertThat(params._pathParam(0)).isEqualTo("jobId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
