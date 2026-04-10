// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DamFileVersionDeleteEventTest {

    @Test
    fun create() {
        val damFileVersionDeleteEvent =
            DamFileVersionDeleteEvent.builder()
                .id("id")
                .type("file-version.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    DamFileVersionDeleteEvent.Data.builder()
                        .fileId("fileId")
                        .versionId("versionId")
                        .build()
                )
                .build()

        assertThat(damFileVersionDeleteEvent.id()).isEqualTo("id")
        assertThat(damFileVersionDeleteEvent.type()).isEqualTo("file-version.deleted")
        assertThat(damFileVersionDeleteEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(damFileVersionDeleteEvent.data())
            .isEqualTo(
                DamFileVersionDeleteEvent.Data.builder()
                    .fileId("fileId")
                    .versionId("versionId")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val damFileVersionDeleteEvent =
            DamFileVersionDeleteEvent.builder()
                .id("id")
                .type("file-version.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    DamFileVersionDeleteEvent.Data.builder()
                        .fileId("fileId")
                        .versionId("versionId")
                        .build()
                )
                .build()

        val roundtrippedDamFileVersionDeleteEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(damFileVersionDeleteEvent),
                jacksonTypeRef<DamFileVersionDeleteEvent>(),
            )

        assertThat(roundtrippedDamFileVersionDeleteEvent).isEqualTo(damFileVersionDeleteEvent)
    }
}
