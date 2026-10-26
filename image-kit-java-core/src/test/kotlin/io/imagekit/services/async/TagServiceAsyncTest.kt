// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.models.tags.TagListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TagServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val tagServiceAsync = client.tags()

        val tagsFuture =
            tagServiceAsync.list(
                TagListParams.builder()
                    .cursor("cursor")
                    .fileType(TagListParams.FileType.IMAGE)
                    .limit(1L)
                    .prefix("prefix")
                    .search("search")
                    .sort(TagListParams.Sort.ASC_NAME)
                    .tagSource(TagListParams.TagSource.USER)
                    .build()
            )

        val tags = tagsFuture.get()
        tags.validate()
    }
}
