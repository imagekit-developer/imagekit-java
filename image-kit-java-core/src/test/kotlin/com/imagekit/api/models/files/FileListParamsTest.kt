// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.imagekit.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileListParamsTest {

    @Test
    fun create() {
        FileListParams.builder()
            .fileType("fileType")
            .limit("limit")
            .path("path")
            .searchQuery("searchQuery")
            .skip("skip")
            .sort("sort")
            .type(FileListParams.Type.FILE)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            FileListParams.builder()
                .fileType("fileType")
                .limit("limit")
                .path("path")
                .searchQuery("searchQuery")
                .skip("skip")
                .sort("sort")
                .type(FileListParams.Type.FILE)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("fileType", "fileType")
                    .put("limit", "limit")
                    .put("path", "path")
                    .put("searchQuery", "searchQuery")
                    .put("skip", "skip")
                    .put("sort", "sort")
                    .put("type", "file")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = FileListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
