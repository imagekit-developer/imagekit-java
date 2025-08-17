// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutoTaggingExtensionTest {

    @Test
    fun create() {
        val autoTaggingExtension =
            AutoTaggingExtension.builder()
                .maxTags(0L)
                .minConfidence(0L)
                .name(AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING)
                .build()

        assertThat(autoTaggingExtension.maxTags()).isEqualTo(0L)
        assertThat(autoTaggingExtension.minConfidence()).isEqualTo(0L)
        assertThat(autoTaggingExtension.name())
            .isEqualTo(AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val autoTaggingExtension =
            AutoTaggingExtension.builder()
                .maxTags(0L)
                .minConfidence(0L)
                .name(AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING)
                .build()

        val roundtrippedAutoTaggingExtension =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(autoTaggingExtension),
                jacksonTypeRef<AutoTaggingExtension>(),
            )

        assertThat(roundtrippedAutoTaggingExtension).isEqualTo(autoTaggingExtension)
    }
}
