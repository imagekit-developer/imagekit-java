// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileRemoveAiTagsResponseTest {

    @Test
    fun create() {
        val fileRemoveAiTagsResponse =
            FileRemoveAiTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        assertThat(fileRemoveAiTagsResponse.successfullyUpdatedFileIds().getOrNull())
            .containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileRemoveAiTagsResponse =
            FileRemoveAiTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        val roundtrippedFileRemoveAiTagsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileRemoveAiTagsResponse),
                jacksonTypeRef<FileRemoveAiTagsResponse>(),
            )

        assertThat(roundtrippedFileRemoveAiTagsResponse).isEqualTo(fileRemoveAiTagsResponse)
    }
}
