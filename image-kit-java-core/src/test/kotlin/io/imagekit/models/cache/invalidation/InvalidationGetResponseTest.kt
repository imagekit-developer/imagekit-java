// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.cache.invalidation

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvalidationGetResponseTest {

    @Test
    fun create() {
        val invalidationGetResponse =
            InvalidationGetResponse.builder()
                .status(InvalidationGetResponse.Status.COMPLETED)
                .build()

        assertThat(invalidationGetResponse.status())
            .contains(InvalidationGetResponse.Status.COMPLETED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invalidationGetResponse =
            InvalidationGetResponse.builder()
                .status(InvalidationGetResponse.Status.COMPLETED)
                .build()

        val roundtrippedInvalidationGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invalidationGetResponse),
                jacksonTypeRef<InvalidationGetResponse>(),
            )

        assertThat(roundtrippedInvalidationGetResponse).isEqualTo(invalidationGetResponse)
    }
}
