// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import io.imagekit.models.tags.TagListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TagServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val tagService = client.tags()

        val tags =
            tagService.list(
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

        tags.validate()
    }
}
