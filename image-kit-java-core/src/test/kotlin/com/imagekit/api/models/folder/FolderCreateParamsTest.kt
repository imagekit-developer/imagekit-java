// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.folder

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderCreateParamsTest {

    @Test
    fun create() {
        FolderCreateParams.builder()
            .folderName("summer")
            .parentFolderPath("/product/images/")
            .build()
    }

    @Test
    fun body() {
        val params =
            FolderCreateParams.builder()
                .folderName("summer")
                .parentFolderPath("/product/images/")
                .build()

        val body = params._body()

        assertThat(body.folderName()).isEqualTo("summer")
        assertThat(body.parentFolderPath()).isEqualTo("/product/images/")
    }
}
