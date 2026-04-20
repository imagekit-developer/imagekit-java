// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AiTagTest {

    @Test
    fun create() {
        val aiTag = AiTag.builder().confidence(0.0).name("name").source("source").build()

        assertThat(aiTag.confidence()).contains(0.0)
        assertThat(aiTag.name()).contains("name")
        assertThat(aiTag.source()).contains("source")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val aiTag = AiTag.builder().confidence(0.0).name("name").source("source").build()

        val roundtrippedAiTag =
            jsonMapper.readValue(jsonMapper.writeValueAsString(aiTag), jacksonTypeRef<AiTag>())

        assertThat(roundtrippedAiTag).isEqualTo(aiTag)
    }
}
