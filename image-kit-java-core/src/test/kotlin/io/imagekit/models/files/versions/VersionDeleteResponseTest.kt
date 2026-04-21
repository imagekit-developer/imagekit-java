// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files.versions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VersionDeleteResponseTest {

    @Test
    fun create() {
        val versionDeleteResponse = VersionDeleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val versionDeleteResponse = VersionDeleteResponse.builder().build()

        val roundtrippedVersionDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(versionDeleteResponse),
                jacksonTypeRef<VersionDeleteResponse>(),
            )

        assertThat(roundtrippedVersionDeleteResponse).isEqualTo(versionDeleteResponse)
    }
}
