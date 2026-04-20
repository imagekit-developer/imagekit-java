// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.custommetadatafields

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.io.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomMetadataFieldDeleteResponseTest {

    @Test
    fun create() {
        val customMetadataFieldDeleteResponse = CustomMetadataFieldDeleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val customMetadataFieldDeleteResponse = CustomMetadataFieldDeleteResponse.builder().build()

        val roundtrippedCustomMetadataFieldDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(customMetadataFieldDeleteResponse),
                jacksonTypeRef<CustomMetadataFieldDeleteResponse>(),
            )

        assertThat(roundtrippedCustomMetadataFieldDeleteResponse)
            .isEqualTo(customMetadataFieldDeleteResponse)
    }
}
