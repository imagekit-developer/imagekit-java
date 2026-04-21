// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponsiveImageAttributesTest {

    @Test
    fun create() {
        val responsiveImageAttributes =
            ResponsiveImageAttributes.builder()
                .src("https://ik.imagekit.io/demo/image.jpg?tr=w-3840")
                .sizes("100vw")
                .srcSet(
                    "https://ik.imagekit.io/demo/image.jpg?tr=w-640 640w, https://ik.imagekit.io/demo/image.jpg?tr=w-1080 1080w, https://ik.imagekit.io/demo/image.jpg?tr=w-1920 1920w"
                )
                .width(400.0)
                .build()

        assertThat(responsiveImageAttributes.src())
            .isEqualTo("https://ik.imagekit.io/demo/image.jpg?tr=w-3840")
        assertThat(responsiveImageAttributes.sizes()).contains("100vw")
        assertThat(responsiveImageAttributes.srcSet())
            .contains(
                "https://ik.imagekit.io/demo/image.jpg?tr=w-640 640w, https://ik.imagekit.io/demo/image.jpg?tr=w-1080 1080w, https://ik.imagekit.io/demo/image.jpg?tr=w-1920 1920w"
            )
        assertThat(responsiveImageAttributes.width()).contains(400.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responsiveImageAttributes =
            ResponsiveImageAttributes.builder()
                .src("https://ik.imagekit.io/demo/image.jpg?tr=w-3840")
                .sizes("100vw")
                .srcSet(
                    "https://ik.imagekit.io/demo/image.jpg?tr=w-640 640w, https://ik.imagekit.io/demo/image.jpg?tr=w-1080 1080w, https://ik.imagekit.io/demo/image.jpg?tr=w-1920 1920w"
                )
                .width(400.0)
                .build()

        val roundtrippedResponsiveImageAttributes =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsiveImageAttributes),
                jacksonTypeRef<ResponsiveImageAttributes>(),
            )

        assertThat(roundtrippedResponsiveImageAttributes).isEqualTo(responsiveImageAttributes)
    }
}
