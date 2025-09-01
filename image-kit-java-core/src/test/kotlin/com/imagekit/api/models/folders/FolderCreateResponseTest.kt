// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.folders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderCreateResponseTest {

    @Test
    fun create() {
        val folderCreateResponse = FolderCreateResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val folderCreateResponse = FolderCreateResponse.builder().build()

        val roundtrippedFolderCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(folderCreateResponse),
                jacksonTypeRef<FolderCreateResponse>(),
            )

        assertThat(roundtrippedFolderCreateResponse).isEqualTo(folderCreateResponse)
    }
}
