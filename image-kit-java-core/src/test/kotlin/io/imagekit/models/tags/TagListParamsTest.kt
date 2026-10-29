// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.tags

import io.imagekit.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TagListParamsTest {

    @Test
    fun create() {
        TagListParams.builder()
            .cursor("cursor")
            .fileType(TagListParams.FileType.IMAGE)
            .limit(1L)
            .prefix("prefix")
            .search("search")
            .sort(TagListParams.Sort.ASC_NAME)
            .tagSource(TagListParams.TagSource.USER)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            TagListParams.builder()
                .cursor("cursor")
                .fileType(TagListParams.FileType.IMAGE)
                .limit(1L)
                .prefix("prefix")
                .search("search")
                .sort(TagListParams.Sort.ASC_NAME)
                .tagSource(TagListParams.TagSource.USER)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("cursor", "cursor")
                    .put("fileType", "image")
                    .put("limit", "1")
                    .put("prefix", "prefix")
                    .put("search", "search")
                    .put("sort", "ASC_NAME")
                    .put("tagSource", "user")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TagListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
