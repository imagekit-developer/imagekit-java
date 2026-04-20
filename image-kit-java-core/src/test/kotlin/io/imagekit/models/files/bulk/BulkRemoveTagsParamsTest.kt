// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files.bulk

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkRemoveTagsParamsTest {

    @Test
    fun create() {
        BulkRemoveTagsParams.builder()
            .addFileId("598821f949c0a938d57563bd")
            .addFileId("598821f949c0a938d57563be")
            .tags(listOf("t-shirt", "round-neck", "sale2019"))
            .build()
    }

    @Test
    fun body() {
        val params =
            BulkRemoveTagsParams.builder()
                .addFileId("598821f949c0a938d57563bd")
                .addFileId("598821f949c0a938d57563be")
                .tags(listOf("t-shirt", "round-neck", "sale2019"))
                .build()

        val body = params._body()

        assertThat(body.fileIds())
            .containsExactly("598821f949c0a938d57563bd", "598821f949c0a938d57563be")
        assertThat(body.tags()).containsExactly("t-shirt", "round-neck", "sale2019")
    }
}
