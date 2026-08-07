// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamedTransformationTest {

    @Test
    fun create() {
        val namedTransformation =
            NamedTransformation.builder()
                .id("6bZ9x2ZUx")
                .createdAt(OffsetDateTime.parse("2024-01-10T09:00:00.000Z"))
                .enabled(true)
                .name("small_thumbnail")
                .transformation("tr:w-150,h-150,fo-center,cm-resize")
                .build()

        assertThat(namedTransformation.id()).contains("6bZ9x2ZUx")
        assertThat(namedTransformation.createdAt())
            .contains(OffsetDateTime.parse("2024-01-10T09:00:00.000Z"))
        assertThat(namedTransformation.enabled()).contains(true)
        assertThat(namedTransformation.name()).contains("small_thumbnail")
        assertThat(namedTransformation.transformation())
            .contains("tr:w-150,h-150,fo-center,cm-resize")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namedTransformation =
            NamedTransformation.builder()
                .id("6bZ9x2ZUx")
                .createdAt(OffsetDateTime.parse("2024-01-10T09:00:00.000Z"))
                .enabled(true)
                .name("small_thumbnail")
                .transformation("tr:w-150,h-150,fo-center,cm-resize")
                .build()

        val roundtrippedNamedTransformation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namedTransformation),
                jacksonTypeRef<NamedTransformation>(),
            )

        assertThat(roundtrippedNamedTransformation).isEqualTo(namedTransformation)
    }
}
