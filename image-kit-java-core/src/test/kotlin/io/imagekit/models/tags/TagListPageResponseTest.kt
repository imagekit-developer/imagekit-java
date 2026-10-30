// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.tags

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TagListPageResponseTest {

    @Test
    fun create() {
        val tagListPageResponse =
            TagListPageResponse.builder()
                .nextCursor("nextCursor")
                .addTag(
                    Tag.builder()
                        .assetCount(0L)
                        .label("label")
                        .lastUsedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .name("name")
                        .build()
                )
                .build()

        assertThat(tagListPageResponse.nextCursor()).contains("nextCursor")
        assertThat(tagListPageResponse.tags())
            .containsExactly(
                Tag.builder()
                    .assetCount(0L)
                    .label("label")
                    .lastUsedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .name("name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tagListPageResponse =
            TagListPageResponse.builder()
                .nextCursor("nextCursor")
                .addTag(
                    Tag.builder()
                        .assetCount(0L)
                        .label("label")
                        .lastUsedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .name("name")
                        .build()
                )
                .build()

        val roundtrippedTagListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tagListPageResponse),
                jacksonTypeRef<TagListPageResponse>(),
            )

        assertThat(roundtrippedTagListPageResponse).isEqualTo(tagListPageResponse)
    }
}
