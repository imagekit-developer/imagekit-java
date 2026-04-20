// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileRenameParamsTest {

    @Test
    fun create() {
        FileRenameParams.builder()
            .filePath("/path/to/file.jpg")
            .newFileName("newFileName.jpg")
            .purgeCache(true)
            .build()
    }

    @Test
    fun body() {
        val params =
            FileRenameParams.builder()
                .filePath("/path/to/file.jpg")
                .newFileName("newFileName.jpg")
                .purgeCache(true)
                .build()

        val body = params._body()

        assertThat(body.filePath()).isEqualTo("/path/to/file.jpg")
        assertThat(body.newFileName()).isEqualTo("newFileName.jpg")
        assertThat(body.purgeCache()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FileRenameParams.builder()
                .filePath("/path/to/file.jpg")
                .newFileName("newFileName.jpg")
                .build()

        val body = params._body()

        assertThat(body.filePath()).isEqualTo("/path/to/file.jpg")
        assertThat(body.newFileName()).isEqualTo("newFileName.jpg")
    }
}
