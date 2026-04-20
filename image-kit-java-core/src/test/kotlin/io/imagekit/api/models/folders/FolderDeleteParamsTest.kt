// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.folders

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderDeleteParamsTest {

    @Test
    fun create() {
        FolderDeleteParams.builder().folderPath("/folder/to/delete/").build()
    }

    @Test
    fun body() {
        val params = FolderDeleteParams.builder().folderPath("/folder/to/delete/").build()

        val body = params._body()

        assertThat(body.folderPath()).isEqualTo("/folder/to/delete/")
    }
}
