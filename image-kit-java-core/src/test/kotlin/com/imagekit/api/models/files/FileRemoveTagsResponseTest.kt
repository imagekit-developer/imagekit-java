// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileRemoveTagsResponseTest {

    @Test
    fun create() {
        val fileRemoveTagsResponse =
            FileRemoveTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        assertThat(fileRemoveTagsResponse.successfullyUpdatedFileIds().getOrNull())
            .containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileRemoveTagsResponse =
            FileRemoveTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        val roundtrippedFileRemoveTagsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileRemoveTagsResponse),
                jacksonTypeRef<FileRemoveTagsResponse>(),
            )

        assertThat(roundtrippedFileRemoveTagsResponse).isEqualTo(fileRemoveTagsResponse)
    }
}
