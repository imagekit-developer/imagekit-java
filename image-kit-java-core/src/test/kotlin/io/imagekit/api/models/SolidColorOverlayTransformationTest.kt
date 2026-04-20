// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SolidColorOverlayTransformationTest {

    @Test
    fun create() {
        val solidColorOverlayTransformation =
            SolidColorOverlayTransformation.builder()
                .alpha(1.0)
                .background("background")
                .gradientTrue()
                .height(0.0)
                .radiusMax()
                .width(0.0)
                .build()

        assertThat(solidColorOverlayTransformation.alpha()).contains(1.0)
        assertThat(solidColorOverlayTransformation.background()).contains("background")
        assertThat(solidColorOverlayTransformation.gradient())
            .contains(SolidColorOverlayTransformation.Gradient.ofTrue())
        assertThat(solidColorOverlayTransformation.height())
            .contains(SolidColorOverlayTransformation.Height.ofNumber(0.0))
        assertThat(solidColorOverlayTransformation.radius())
            .contains(SolidColorOverlayTransformation.Radius.ofMax())
        assertThat(solidColorOverlayTransformation.width())
            .contains(SolidColorOverlayTransformation.Width.ofNumber(0.0))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val solidColorOverlayTransformation =
            SolidColorOverlayTransformation.builder()
                .alpha(1.0)
                .background("background")
                .gradientTrue()
                .height(0.0)
                .radiusMax()
                .width(0.0)
                .build()

        val roundtrippedSolidColorOverlayTransformation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(solidColorOverlayTransformation),
                jacksonTypeRef<SolidColorOverlayTransformation>(),
            )

        assertThat(roundtrippedSolidColorOverlayTransformation)
            .isEqualTo(solidColorOverlayTransformation)
    }
}
