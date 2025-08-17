// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RemovedotBgExtensionTest {

    @Test
    fun create() {
        val removedotBgExtension =
            RemovedotBgExtension.builder()
                .name(RemovedotBgExtension.Name.REMOVE_BG)
                .options(
                    RemovedotBgExtension.Options.builder()
                        .addShadow(true)
                        .bgColor("bg_color")
                        .bgImageUrl("bg_image_url")
                        .semitransparency(true)
                        .build()
                )
                .build()

        assertThat(removedotBgExtension.name()).isEqualTo(RemovedotBgExtension.Name.REMOVE_BG)
        assertThat(removedotBgExtension.options())
            .contains(
                RemovedotBgExtension.Options.builder()
                    .addShadow(true)
                    .bgColor("bg_color")
                    .bgImageUrl("bg_image_url")
                    .semitransparency(true)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val removedotBgExtension =
            RemovedotBgExtension.builder()
                .name(RemovedotBgExtension.Name.REMOVE_BG)
                .options(
                    RemovedotBgExtension.Options.builder()
                        .addShadow(true)
                        .bgColor("bg_color")
                        .bgImageUrl("bg_image_url")
                        .semitransparency(true)
                        .build()
                )
                .build()

        val roundtrippedRemovedotBgExtension =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(removedotBgExtension),
                jacksonTypeRef<RemovedotBgExtension>(),
            )

        assertThat(roundtrippedRemovedotBgExtension).isEqualTo(removedotBgExtension)
    }
}
