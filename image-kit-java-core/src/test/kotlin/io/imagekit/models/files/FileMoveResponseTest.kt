// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileMoveResponseTest {

    @Test
    fun create() {
        val fileMoveResponse = FileMoveResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileMoveResponse = FileMoveResponse.builder().build()

        val roundtrippedFileMoveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileMoveResponse),
                jacksonTypeRef<FileMoveResponse>(),
            )

        assertThat(roundtrippedFileMoveResponse).isEqualTo(fileMoveResponse)
    }
}
