// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InteroperabilityTest {

    @Test
    fun create() {
        val interoperability =
            Interoperability.builder()
                .interopIndex("InteropIndex")
                .interopVersion("InteropVersion")
                .build()

        assertThat(interoperability.interopIndex()).contains("InteropIndex")
        assertThat(interoperability.interopVersion()).contains("InteropVersion")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val interoperability =
            Interoperability.builder()
                .interopIndex("InteropIndex")
                .interopVersion("InteropVersion")
                .build()

        val roundtrippedInteroperability =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(interoperability),
                jacksonTypeRef<Interoperability>(),
            )

        assertThat(roundtrippedInteroperability).isEqualTo(interoperability)
    }
}
