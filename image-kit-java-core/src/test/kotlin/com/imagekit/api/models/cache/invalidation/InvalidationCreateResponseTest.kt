// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.cache.invalidation

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvalidationCreateResponseTest {

    @Test
    fun create() {
        val invalidationCreateResponse =
            InvalidationCreateResponse.builder().requestId("requestId").build()

        assertThat(invalidationCreateResponse.requestId()).contains("requestId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invalidationCreateResponse =
            InvalidationCreateResponse.builder().requestId("requestId").build()

        val roundtrippedInvalidationCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invalidationCreateResponse),
                jacksonTypeRef<InvalidationCreateResponse>(),
            )

        assertThat(roundtrippedInvalidationCreateResponse).isEqualTo(invalidationCreateResponse)
    }
}
