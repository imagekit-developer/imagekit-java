// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DamFileVersionCreateEventTest {

    @Test
    fun create() {
        val damFileVersionCreateEvent =
            DamFileVersionCreateEvent.builder()
                .id("id")
                .type("file-version.created")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(damFileVersionCreateEvent.id()).isEqualTo("id")
        assertThat(damFileVersionCreateEvent.type()).isEqualTo("file-version.created")
        assertThat(damFileVersionCreateEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(damFileVersionCreateEvent._data())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val damFileVersionCreateEvent =
            DamFileVersionCreateEvent.builder()
                .id("id")
                .type("file-version.created")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedDamFileVersionCreateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(damFileVersionCreateEvent),
                jacksonTypeRef<DamFileVersionCreateEvent>(),
            )

        assertThat(roundtrippedDamFileVersionCreateEvent).isEqualTo(damFileVersionCreateEvent)
    }
}
