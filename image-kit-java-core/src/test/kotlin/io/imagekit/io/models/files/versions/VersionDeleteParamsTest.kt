// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.files.versions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VersionDeleteParamsTest {

    @Test
    fun create() {
        VersionDeleteParams.builder().fileId("fileId").versionId("versionId").build()
    }

    @Test
    fun pathParams() {
        val params = VersionDeleteParams.builder().fileId("fileId").versionId("versionId").build()

        assertThat(params._pathParam(0)).isEqualTo("fileId")
        assertThat(params._pathParam(1)).isEqualTo("versionId")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
