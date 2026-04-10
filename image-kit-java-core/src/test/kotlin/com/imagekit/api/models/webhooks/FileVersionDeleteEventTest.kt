// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileVersionDeleteEventTest {

    @Test
    fun create() {
        val fileVersionDeleteEvent =
            FileVersionDeleteEvent.builder()
                .id("id")
                .type("file-version.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    FileVersionDeleteEvent.Data.builder()
                        .fileId("fileId")
                        .versionId("versionId")
                        .build()
                )
                .build()

        assertThat(fileVersionDeleteEvent.id()).isEqualTo("id")
        assertThat(fileVersionDeleteEvent.type()).isEqualTo("file-version.deleted")
        assertThat(fileVersionDeleteEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileVersionDeleteEvent.data())
            .isEqualTo(
                FileVersionDeleteEvent.Data.builder()
                    .fileId("fileId")
                    .versionId("versionId")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileVersionDeleteEvent =
            FileVersionDeleteEvent.builder()
                .id("id")
                .type("file-version.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    FileVersionDeleteEvent.Data.builder()
                        .fileId("fileId")
                        .versionId("versionId")
                        .build()
                )
                .build()

        val roundtrippedFileVersionDeleteEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileVersionDeleteEvent),
                jacksonTypeRef<FileVersionDeleteEvent>(),
            )

        assertThat(roundtrippedFileVersionDeleteEvent).isEqualTo(fileVersionDeleteEvent)
    }
}
