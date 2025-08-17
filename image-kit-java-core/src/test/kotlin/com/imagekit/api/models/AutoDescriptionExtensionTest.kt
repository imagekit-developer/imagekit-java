// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutoDescriptionExtensionTest {

    @Test
    fun create() {
        val autoDescriptionExtension =
            AutoDescriptionExtension.builder()
                .name(AutoDescriptionExtension.Name.AI_AUTO_DESCRIPTION)
                .build()

        assertThat(autoDescriptionExtension.name())
            .isEqualTo(AutoDescriptionExtension.Name.AI_AUTO_DESCRIPTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val autoDescriptionExtension =
            AutoDescriptionExtension.builder()
                .name(AutoDescriptionExtension.Name.AI_AUTO_DESCRIPTION)
                .build()

        val roundtrippedAutoDescriptionExtension =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(autoDescriptionExtension),
                jacksonTypeRef<AutoDescriptionExtension>(),
            )

        assertThat(roundtrippedAutoDescriptionExtension).isEqualTo(autoDescriptionExtension)
    }
}
