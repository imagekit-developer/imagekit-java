// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.assets

import com.imagekit.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssetListParamsTest {

    @Test
    fun create() {
        AssetListParams.builder()
            .fileType(AssetListParams.FileType.ALL)
            .limit(1L)
            .path("path")
            .searchQuery("searchQuery")
            .skip(0L)
            .sort(AssetListParams.Sort.ASC_NAME)
            .type(AssetListParams.Type.FILE)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            AssetListParams.builder()
                .fileType(AssetListParams.FileType.ALL)
                .limit(1L)
                .path("path")
                .searchQuery("searchQuery")
                .skip(0L)
                .sort(AssetListParams.Sort.ASC_NAME)
                .type(AssetListParams.Type.FILE)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("fileType", "all")
                    .put("limit", "1")
                    .put("path", "path")
                    .put("searchQuery", "searchQuery")
                    .put("skip", "0")
                    .put("sort", "ASC_NAME")
                    .put("type", "file")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = AssetListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
