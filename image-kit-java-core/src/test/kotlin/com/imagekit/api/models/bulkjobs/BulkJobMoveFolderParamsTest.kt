// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.bulkjobs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkJobMoveFolderParamsTest {

    @Test
    fun create() {
        BulkJobMoveFolderParams.builder()
            .destinationPath("/path/of/destination/folder")
            .sourceFolderPath("/path/of/source/folder")
            .build()
    }

    @Test
    fun body() {
        val params =
            BulkJobMoveFolderParams.builder()
                .destinationPath("/path/of/destination/folder")
                .sourceFolderPath("/path/of/source/folder")
                .build()

        val body = params._body()

        assertThat(body.destinationPath()).isEqualTo("/path/of/destination/folder")
        assertThat(body.sourceFolderPath()).isEqualTo("/path/of/source/folder")
    }
}
