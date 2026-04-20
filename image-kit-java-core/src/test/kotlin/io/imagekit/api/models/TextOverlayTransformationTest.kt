// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TextOverlayTransformationTest {

    @Test
    fun create() {
        val textOverlayTransformation =
            TextOverlayTransformation.builder()
                .alpha(1.0)
                .background("background")
                .flip(TextOverlayTransformation.Flip.H)
                .fontColor("fontColor")
                .fontFamily("fontFamily")
                .fontSize(0.0)
                .innerAlignment(TextOverlayTransformation.InnerAlignment.LEFT)
                .lineHeight(0.0)
                .padding(0.0)
                .radiusMax()
                .rotation(0.0)
                .typography("typography")
                .width(0.0)
                .build()

        assertThat(textOverlayTransformation.alpha()).contains(1.0)
        assertThat(textOverlayTransformation.background()).contains("background")
        assertThat(textOverlayTransformation.flip()).contains(TextOverlayTransformation.Flip.H)
        assertThat(textOverlayTransformation.fontColor()).contains("fontColor")
        assertThat(textOverlayTransformation.fontFamily()).contains("fontFamily")
        assertThat(textOverlayTransformation.fontSize())
            .contains(TextOverlayTransformation.FontSize.ofNumber(0.0))
        assertThat(textOverlayTransformation.innerAlignment())
            .contains(TextOverlayTransformation.InnerAlignment.LEFT)
        assertThat(textOverlayTransformation.lineHeight())
            .contains(TextOverlayTransformation.LineHeight.ofNumber(0.0))
        assertThat(textOverlayTransformation.padding())
            .contains(TextOverlayTransformation.Padding.ofNumber(0.0))
        assertThat(textOverlayTransformation.radius())
            .contains(TextOverlayTransformation.Radius.ofMax())
        assertThat(textOverlayTransformation.rotation())
            .contains(TextOverlayTransformation.Rotation.ofNumber(0.0))
        assertThat(textOverlayTransformation.typography()).contains("typography")
        assertThat(textOverlayTransformation.width())
            .contains(TextOverlayTransformation.Width.ofNumber(0.0))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val textOverlayTransformation =
            TextOverlayTransformation.builder()
                .alpha(1.0)
                .background("background")
                .flip(TextOverlayTransformation.Flip.H)
                .fontColor("fontColor")
                .fontFamily("fontFamily")
                .fontSize(0.0)
                .innerAlignment(TextOverlayTransformation.InnerAlignment.LEFT)
                .lineHeight(0.0)
                .padding(0.0)
                .radiusMax()
                .rotation(0.0)
                .typography("typography")
                .width(0.0)
                .build()

        val roundtrippedTextOverlayTransformation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(textOverlayTransformation),
                jacksonTypeRef<TextOverlayTransformation>(),
            )

        assertThat(roundtrippedTextOverlayTransformation).isEqualTo(textOverlayTransformation)
    }
}
