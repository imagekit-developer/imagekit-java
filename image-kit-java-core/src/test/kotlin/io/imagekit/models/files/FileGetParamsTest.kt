// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileGetParamsTest {

    @Test
    fun create() {
        FileGetParams.builder().fileId("fileId").build()
    }

    @Test
    fun pathParams() {
        val params = FileGetParams.builder().fileId("fileId").build()

        assertThat(params._pathParam(0)).isEqualTo("fileId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
