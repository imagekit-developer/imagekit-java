// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.namedtransformations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamedTransformationDeleteResponseTest {

    @Test
    fun create() {
        val namedTransformationDeleteResponse = NamedTransformationDeleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namedTransformationDeleteResponse = NamedTransformationDeleteResponse.builder().build()

        val roundtrippedNamedTransformationDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namedTransformationDeleteResponse),
                jacksonTypeRef<NamedTransformationDeleteResponse>(),
            )

        assertThat(roundtrippedNamedTransformationDeleteResponse)
            .isEqualTo(namedTransformationDeleteResponse)
    }
}
