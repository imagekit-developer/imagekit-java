// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.folders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderDeleteResponseTest {

    @Test
    fun create() {
        val folderDeleteResponse = FolderDeleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val folderDeleteResponse = FolderDeleteResponse.builder().build()

        val roundtrippedFolderDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(folderDeleteResponse),
                jacksonTypeRef<FolderDeleteResponse>(),
            )

        assertThat(roundtrippedFolderDeleteResponse).isEqualTo(folderDeleteResponse)
    }
}
