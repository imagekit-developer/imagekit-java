// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileCopyResponseTest {

    @Test
    fun create() {
        val fileCopyResponse = FileCopyResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileCopyResponse = FileCopyResponse.builder().build()

        val roundtrippedFileCopyResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileCopyResponse),
                jacksonTypeRef<FileCopyResponse>(),
            )

        assertThat(roundtrippedFileCopyResponse).isEqualTo(fileCopyResponse)
    }
}
