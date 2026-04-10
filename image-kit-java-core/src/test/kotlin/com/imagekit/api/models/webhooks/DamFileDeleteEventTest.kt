// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DamFileDeleteEventTest {

    @Test
    fun create() {
        val damFileDeleteEvent =
            DamFileDeleteEvent.builder()
                .id("id")
                .type("file.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(DamFileDeleteEvent.Data.builder().fileId("fileId").build())
                .build()

        assertThat(damFileDeleteEvent.id()).isEqualTo("id")
        assertThat(damFileDeleteEvent.type()).isEqualTo("file.deleted")
        assertThat(damFileDeleteEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(damFileDeleteEvent.data())
            .isEqualTo(DamFileDeleteEvent.Data.builder().fileId("fileId").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val damFileDeleteEvent =
            DamFileDeleteEvent.builder()
                .id("id")
                .type("file.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(DamFileDeleteEvent.Data.builder().fileId("fileId").build())
                .build()

        val roundtrippedDamFileDeleteEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(damFileDeleteEvent),
                jacksonTypeRef<DamFileDeleteEvent>(),
            )

        assertThat(roundtrippedDamFileDeleteEvent).isEqualTo(damFileDeleteEvent)
    }
}
