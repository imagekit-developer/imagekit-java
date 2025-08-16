// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GpsTest {

    @Test
    fun create() {
        val gps = Gps.builder().addGpsVersionId(0L).build()

        assertThat(gps.gpsVersionId().getOrNull()).containsExactly(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val gps = Gps.builder().addGpsVersionId(0L).build()

        val roundtrippedGps =
            jsonMapper.readValue(jsonMapper.writeValueAsString(gps), jacksonTypeRef<Gps>())

        assertThat(roundtrippedGps).isEqualTo(gps)
    }
}
