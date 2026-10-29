// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.tags

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TagListResponseTest {

    @Test
    fun create() {
        val tagListResponse =
            TagListResponse.builder()
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

        assertThat(tagListResponse.nextCursor()).contains("nextCursor")
        assertThat(tagListResponse.tags())
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
        val tagListResponse =
            TagListResponse.builder()
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

        val roundtrippedTagListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tagListResponse),
                jacksonTypeRef<TagListResponse>(),
            )

        assertThat(roundtrippedTagListResponse).isEqualTo(tagListResponse)
    }
}
