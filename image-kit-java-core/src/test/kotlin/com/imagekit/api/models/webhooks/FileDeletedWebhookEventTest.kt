// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileDeletedWebhookEventTest {

    @Test
    fun create() {
        val fileDeletedWebhookEvent =
            FileDeletedWebhookEvent.builder()
                .id("id")
                .type("file.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(FileDeletedWebhookEvent.Data.builder().fileId("fileId").build())
                .build()

        assertThat(fileDeletedWebhookEvent.id()).isEqualTo("id")
        assertThat(fileDeletedWebhookEvent.type()).isEqualTo("file.deleted")
        assertThat(fileDeletedWebhookEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileDeletedWebhookEvent.data())
            .isEqualTo(FileDeletedWebhookEvent.Data.builder().fileId("fileId").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileDeletedWebhookEvent =
            FileDeletedWebhookEvent.builder()
                .id("id")
                .type("file.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(FileDeletedWebhookEvent.Data.builder().fileId("fileId").build())
                .build()

        val roundtrippedFileDeletedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileDeletedWebhookEvent),
                jacksonTypeRef<FileDeletedWebhookEvent>(),
            )

        assertThat(roundtrippedFileDeletedWebhookEvent).isEqualTo(fileDeletedWebhookEvent)
    }
}
