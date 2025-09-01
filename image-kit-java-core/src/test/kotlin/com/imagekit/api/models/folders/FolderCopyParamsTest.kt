// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.folders

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderCopyParamsTest {

    @Test
    fun create() {
        FolderCopyParams.builder()
            .destinationPath("/path/of/destination/folder")
            .sourceFolderPath("/path/of/source/folder")
            .includeVersions(true)
            .build()
    }

    @Test
    fun body() {
        val params =
            FolderCopyParams.builder()
                .destinationPath("/path/of/destination/folder")
                .sourceFolderPath("/path/of/source/folder")
                .includeVersions(true)
                .build()

        val body = params._body()

        assertThat(body.destinationPath()).isEqualTo("/path/of/destination/folder")
        assertThat(body.sourceFolderPath()).isEqualTo("/path/of/source/folder")
        assertThat(body.includeVersions()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FolderCopyParams.builder()
                .destinationPath("/path/of/destination/folder")
                .sourceFolderPath("/path/of/source/folder")
                .build()

        val body = params._body()

        assertThat(body.destinationPath()).isEqualTo("/path/of/destination/folder")
        assertThat(body.sourceFolderPath()).isEqualTo("/path/of/source/folder")
    }
}
