// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileCopyParamsTest {

    @Test
    fun create() {
        FileCopyParams.builder()
            .destinationPath("/folder/to/copy/into/")
            .sourceFilePath("/path/to/file.jpg")
            .includeFileVersions(false)
            .build()
    }

    @Test
    fun body() {
        val params =
            FileCopyParams.builder()
                .destinationPath("/folder/to/copy/into/")
                .sourceFilePath("/path/to/file.jpg")
                .includeFileVersions(false)
                .build()

        val body = params._body()

        assertThat(body.destinationPath()).isEqualTo("/folder/to/copy/into/")
        assertThat(body.sourceFilePath()).isEqualTo("/path/to/file.jpg")
        assertThat(body.includeFileVersions()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FileCopyParams.builder()
                .destinationPath("/folder/to/copy/into/")
                .sourceFilePath("/path/to/file.jpg")
                .build()

        val body = params._body()

        assertThat(body.destinationPath()).isEqualTo("/folder/to/copy/into/")
        assertThat(body.sourceFilePath()).isEqualTo("/path/to/file.jpg")
    }
}
