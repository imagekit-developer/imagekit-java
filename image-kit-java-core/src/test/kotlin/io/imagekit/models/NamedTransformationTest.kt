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
                .transformation("w-150,h-150,fo-center,cm-pad_resize")
                .build()

        assertThat(namedTransformation.id()).isEqualTo("6bZ9x2ZUx")
        assertThat(namedTransformation.createdAt())
            .isEqualTo(OffsetDateTime.parse("2024-01-10T09:00:00.000Z"))
        assertThat(namedTransformation.enabled()).isEqualTo(true)
        assertThat(namedTransformation.name()).isEqualTo("small_thumbnail")
        assertThat(namedTransformation.transformation())
            .isEqualTo("w-150,h-150,fo-center,cm-pad_resize")
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
                .transformation("w-150,h-150,fo-center,cm-pad_resize")
                .build()

        val roundtrippedNamedTransformation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namedTransformation),
                jacksonTypeRef<NamedTransformation>(),
            )

        assertThat(roundtrippedNamedTransformation).isEqualTo(namedTransformation)
    }
}
