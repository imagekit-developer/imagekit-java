// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.folders

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderRenameParamsTest {

    @Test
    fun create() {
        FolderRenameParams.builder()
            .folderPath("/path/of/folder")
            .newFolderName("new-folder-name")
            .purgeCache(true)
            .build()
    }

    @Test
    fun body() {
        val params =
            FolderRenameParams.builder()
                .folderPath("/path/of/folder")
                .newFolderName("new-folder-name")
                .purgeCache(true)
                .build()

        val body = params._body()

        assertThat(body.folderPath()).isEqualTo("/path/of/folder")
        assertThat(body.newFolderName()).isEqualTo("new-folder-name")
        assertThat(body.purgeCache()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FolderRenameParams.builder()
                .folderPath("/path/of/folder")
                .newFolderName("new-folder-name")
                .build()

        val body = params._body()

        assertThat(body.folderPath()).isEqualTo("/path/of/folder")
        assertThat(body.newFolderName()).isEqualTo("new-folder-name")
    }
}
