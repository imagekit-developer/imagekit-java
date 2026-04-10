// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileVersionDeletedWebhookEventTest {

    @Test
    fun create() {
        val fileVersionDeletedWebhookEvent =
            FileVersionDeletedWebhookEvent.builder()
                .id("id")
                .type("file-version.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    FileVersionDeletedWebhookEvent.Data.builder()
                        .fileId("fileId")
                        .versionId("versionId")
                        .build()
                )
                .build()

        assertThat(fileVersionDeletedWebhookEvent.id()).isEqualTo("id")
        assertThat(fileVersionDeletedWebhookEvent.type()).isEqualTo("file-version.deleted")
        assertThat(fileVersionDeletedWebhookEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileVersionDeletedWebhookEvent.data())
            .isEqualTo(
                FileVersionDeletedWebhookEvent.Data.builder()
                    .fileId("fileId")
                    .versionId("versionId")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileVersionDeletedWebhookEvent =
            FileVersionDeletedWebhookEvent.builder()
                .id("id")
                .type("file-version.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    FileVersionDeletedWebhookEvent.Data.builder()
                        .fileId("fileId")
                        .versionId("versionId")
                        .build()
                )
                .build()

        val roundtrippedFileVersionDeletedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileVersionDeletedWebhookEvent),
                jacksonTypeRef<FileVersionDeletedWebhookEvent>(),
            )

        assertThat(roundtrippedFileVersionDeletedWebhookEvent)
            .isEqualTo(fileVersionDeletedWebhookEvent)
    }
}
