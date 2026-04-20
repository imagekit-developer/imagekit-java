// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.folders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderMoveResponseTest {

    @Test
    fun create() {
        val folderMoveResponse = FolderMoveResponse.builder().jobId("jobId").build()

        assertThat(folderMoveResponse.jobId()).isEqualTo("jobId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val folderMoveResponse = FolderMoveResponse.builder().jobId("jobId").build()

        val roundtrippedFolderMoveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(folderMoveResponse),
                jacksonTypeRef<FolderMoveResponse>(),
            )

        assertThat(roundtrippedFolderMoveResponse).isEqualTo(folderMoveResponse)
    }
}
