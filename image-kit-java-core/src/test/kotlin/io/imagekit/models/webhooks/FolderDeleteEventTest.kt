// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderDeleteEventTest {

    @Test
    fun create() {
        val folderDeleteEvent =
            FolderDeleteEvent.builder()
                .id("id")
                .type("folder.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(FolderDeleteEvent.Data.builder().id("id").build())
                .build()

        assertThat(folderDeleteEvent.id()).isEqualTo("id")
        assertThat(folderDeleteEvent.type()).isEqualTo("folder.deleted")
        assertThat(folderDeleteEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(folderDeleteEvent.data())
            .isEqualTo(FolderDeleteEvent.Data.builder().id("id").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val folderDeleteEvent =
            FolderDeleteEvent.builder()
                .id("id")
                .type("folder.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(FolderDeleteEvent.Data.builder().id("id").build())
                .build()

        val roundtrippedFolderDeleteEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(folderDeleteEvent),
                jacksonTypeRef<FolderDeleteEvent>(),
            )

        assertThat(roundtrippedFolderDeleteEvent).isEqualTo(folderDeleteEvent)
    }
}
