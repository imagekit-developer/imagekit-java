// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.io.core.JsonValue
import io.imagekit.io.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomMetadataTest {

    @Test
    fun create() {
        val customMetadata =
            CustomMetadata.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val customMetadata =
            CustomMetadata.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()

        val roundtrippedCustomMetadata =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(customMetadata),
                jacksonTypeRef<CustomMetadata>(),
            )

        assertThat(roundtrippedCustomMetadata).isEqualTo(customMetadata)
    }
}
