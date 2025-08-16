// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileAddTagsResponseTest {

    @Test
    fun create() {
        val fileAddTagsResponse =
            FileAddTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        assertThat(fileAddTagsResponse.successfullyUpdatedFileIds().getOrNull())
            .containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileAddTagsResponse =
            FileAddTagsResponse.builder().addSuccessfullyUpdatedFileId("string").build()

        val roundtrippedFileAddTagsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileAddTagsResponse),
                jacksonTypeRef<FileAddTagsResponse>(),
            )

        assertThat(roundtrippedFileAddTagsResponse).isEqualTo(fileAddTagsResponse)
    }
}
