// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileRemoveAiTagsParamsTest {

    @Test
    fun create() {
        FileRemoveAiTagsParams.builder()
            .aiTags(listOf("t-shirt", "round-neck", "sale2019"))
            .addFileId("598821f949c0a938d57563bd")
            .addFileId("598821f949c0a938d57563be")
            .build()
    }

    @Test
    fun body() {
        val params =
            FileRemoveAiTagsParams.builder()
                .aiTags(listOf("t-shirt", "round-neck", "sale2019"))
                .addFileId("598821f949c0a938d57563bd")
                .addFileId("598821f949c0a938d57563be")
                .build()

        val body = params._body()

        assertThat(body.aiTags()).containsExactly("t-shirt", "round-neck", "sale2019")
        assertThat(body.fileIds())
            .containsExactly("598821f949c0a938d57563bd", "598821f949c0a938d57563be")
    }
}
