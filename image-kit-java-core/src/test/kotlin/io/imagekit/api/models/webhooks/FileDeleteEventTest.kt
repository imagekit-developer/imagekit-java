// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileDeleteEventTest {

    @Test
    fun create() {
        val fileDeleteEvent =
            FileDeleteEvent.builder()
                .id("id")
                .type("file.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(FileDeleteEvent.Data.builder().fileId("fileId").build())
                .build()

        assertThat(fileDeleteEvent.id()).isEqualTo("id")
        assertThat(fileDeleteEvent.type()).isEqualTo("file.deleted")
        assertThat(fileDeleteEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileDeleteEvent.data())
            .isEqualTo(FileDeleteEvent.Data.builder().fileId("fileId").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileDeleteEvent =
            FileDeleteEvent.builder()
                .id("id")
                .type("file.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(FileDeleteEvent.Data.builder().fileId("fileId").build())
                .build()

        val roundtrippedFileDeleteEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileDeleteEvent),
                jacksonTypeRef<FileDeleteEvent>(),
            )

        assertThat(roundtrippedFileDeleteEvent).isEqualTo(fileDeleteEvent)
    }
}
