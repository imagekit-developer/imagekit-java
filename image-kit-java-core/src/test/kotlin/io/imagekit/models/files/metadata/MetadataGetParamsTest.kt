// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files.metadata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MetadataGetParamsTest {

    @Test
    fun create() {
        MetadataGetParams.builder().fileId("fileId").build()
    }

    @Test
    fun pathParams() {
        val params = MetadataGetParams.builder().fileId("fileId").build()

        assertThat(params._pathParam(0)).isEqualTo("fileId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
