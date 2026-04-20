// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.folders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.io.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderRenameResponseTest {

    @Test
    fun create() {
        val folderRenameResponse = FolderRenameResponse.builder().jobId("jobId").build()

        assertThat(folderRenameResponse.jobId()).isEqualTo("jobId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val folderRenameResponse = FolderRenameResponse.builder().jobId("jobId").build()

        val roundtrippedFolderRenameResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(folderRenameResponse),
                jacksonTypeRef<FolderRenameResponse>(),
            )

        assertThat(roundtrippedFolderRenameResponse).isEqualTo(folderRenameResponse)
    }
}
