// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.folders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderCopyResponseTest {

    @Test
    fun create() {
        val folderCopyResponse = FolderCopyResponse.builder().jobId("jobId").build()

        assertThat(folderCopyResponse.jobId()).isEqualTo("jobId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val folderCopyResponse = FolderCopyResponse.builder().jobId("jobId").build()

        val roundtrippedFolderCopyResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(folderCopyResponse),
                jacksonTypeRef<FolderCopyResponse>(),
            )

        assertThat(roundtrippedFolderCopyResponse).isEqualTo(folderCopyResponse)
    }
}
