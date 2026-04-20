// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileMoveParamsTest {

    @Test
    fun create() {
        FileMoveParams.builder()
            .destinationPath("/folder/to/move/into/")
            .sourceFilePath("/path/to/file.jpg")
            .build()
    }

    @Test
    fun body() {
        val params =
            FileMoveParams.builder()
                .destinationPath("/folder/to/move/into/")
                .sourceFilePath("/path/to/file.jpg")
                .build()

        val body = params._body()

        assertThat(body.destinationPath()).isEqualTo("/folder/to/move/into/")
        assertThat(body.sourceFilePath()).isEqualTo("/path/to/file.jpg")
    }
}
