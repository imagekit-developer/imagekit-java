// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.files.bulk

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkDeleteParamsTest {

    @Test
    fun create() {
        BulkDeleteParams.builder()
            .addFileId("598821f949c0a938d57563bd")
            .addFileId("598821f949c0a938d57563be")
            .build()
    }

    @Test
    fun body() {
        val params =
            BulkDeleteParams.builder()
                .addFileId("598821f949c0a938d57563bd")
                .addFileId("598821f949c0a938d57563be")
                .build()

        val body = params._body()

        assertThat(body.fileIds())
            .containsExactly("598821f949c0a938d57563bd", "598821f949c0a938d57563be")
    }
}
