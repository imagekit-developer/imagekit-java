// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VersionInfoTest {

    @Test
    fun create() {
        val versionInfo = VersionInfo.builder().id("id").name("name").build()

        assertThat(versionInfo.id()).contains("id")
        assertThat(versionInfo.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val versionInfo = VersionInfo.builder().id("id").name("name").build()

        val roundtrippedVersionInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(versionInfo),
                jacksonTypeRef<VersionInfo>(),
            )

        assertThat(roundtrippedVersionInfo).isEqualTo(versionInfo)
    }
}
