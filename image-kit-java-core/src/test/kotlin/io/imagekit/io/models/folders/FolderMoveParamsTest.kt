// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.folders

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderMoveParamsTest {

    @Test
    fun create() {
        FolderMoveParams.builder()
            .destinationPath("/path/of/destination/folder")
            .sourceFolderPath("/path/of/source/folder")
            .build()
    }

    @Test
    fun body() {
        val params =
            FolderMoveParams.builder()
                .destinationPath("/path/of/destination/folder")
                .sourceFolderPath("/path/of/source/folder")
                .build()

        val body = params._body()

        assertThat(body.destinationPath()).isEqualTo("/path/of/destination/folder")
        assertThat(body.sourceFolderPath()).isEqualTo("/path/of/source/folder")
    }
}
