// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileRenameResponseTest {

    @Test
    fun create() {
        val fileRenameResponse =
            FileRenameResponse.builder().purgeRequestId("purgeRequestId").build()

        assertThat(fileRenameResponse.purgeRequestId()).contains("purgeRequestId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileRenameResponse =
            FileRenameResponse.builder().purgeRequestId("purgeRequestId").build()

        val roundtrippedFileRenameResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileRenameResponse),
                jacksonTypeRef<FileRenameResponse>(),
            )

        assertThat(roundtrippedFileRenameResponse).isEqualTo(fileRenameResponse)
    }
}
