// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.JsonValue
import io.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmbeddedMetadataTest {

    @Test
    fun create() {
        val embeddedMetadata =
            EmbeddedMetadata.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val embeddedMetadata =
            EmbeddedMetadata.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()

        val roundtrippedEmbeddedMetadata =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(embeddedMetadata),
                jacksonTypeRef<EmbeddedMetadata>(),
            )

        assertThat(roundtrippedEmbeddedMetadata).isEqualTo(embeddedMetadata)
    }
}
