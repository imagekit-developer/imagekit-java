// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.errors.ImageKitInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class OverlayTest {

    @Test
    fun ofText() {
        val text =
            TextOverlay.builder()
                .position(
                    OverlayPosition.builder()
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .y(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .text("text")
                .encoding(TextOverlay.Encoding.AUTO)
                .addTransformation(
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
                        .radius(0.0)
                        .rotation(0.0)
                        .typography("typography")
                        .width(0.0)
                        .build()
                )
                .build()

        val overlay = Overlay.ofText(text)

        assertThat(overlay.text()).contains(text)
        assertThat(overlay.image()).isEmpty
        assertThat(overlay.video()).isEmpty
        assertThat(overlay.subtitle()).isEmpty
        assertThat(overlay.solidColor()).isEmpty
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val overlay =
            Overlay.ofText(
                TextOverlay.builder()
                    .position(
                        OverlayPosition.builder()
                            .focus(OverlayPosition.Focus.CENTER)
                            .x(0.0)
                            .y(0.0)
                            .build()
                    )
                    .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                    .text("text")
                    .encoding(TextOverlay.Encoding.AUTO)
                    .addTransformation(
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
                            .radius(0.0)
                            .rotation(0.0)
                            .typography("typography")
                            .width(0.0)
                            .build()
                    )
                    .build()
            )

        val roundtrippedOverlay =
            jsonMapper.readValue(jsonMapper.writeValueAsString(overlay), jacksonTypeRef<Overlay>())

        assertThat(roundtrippedOverlay).isEqualTo(overlay)
    }

    @Test
    fun ofImage() {
        val image =
            ImageOverlay.builder()
                .position(
                    OverlayPosition.builder()
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .y(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .input("input")
                .encoding(ImageOverlay.Encoding.AUTO)
                .transformation(listOf())
                .build()

        val overlay = Overlay.ofImage(image)

        assertThat(overlay.text()).isEmpty
        assertThat(overlay.image()).contains(image)
        assertThat(overlay.video()).isEmpty
        assertThat(overlay.subtitle()).isEmpty
        assertThat(overlay.solidColor()).isEmpty
    }

    @Test
    fun ofImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val overlay =
            Overlay.ofImage(
                ImageOverlay.builder()
                    .position(
                        OverlayPosition.builder()
                            .focus(OverlayPosition.Focus.CENTER)
                            .x(0.0)
                            .y(0.0)
                            .build()
                    )
                    .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                    .input("input")
                    .encoding(ImageOverlay.Encoding.AUTO)
                    .transformation(listOf())
                    .build()
            )

        val roundtrippedOverlay =
            jsonMapper.readValue(jsonMapper.writeValueAsString(overlay), jacksonTypeRef<Overlay>())

        assertThat(roundtrippedOverlay).isEqualTo(overlay)
    }

    @Test
    fun ofVideo() {
        val video =
            VideoOverlay.builder()
                .position(
                    OverlayPosition.builder()
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .y(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .input("input")
                .encoding(VideoOverlay.Encoding.AUTO)
                .transformation(listOf())
                .build()

        val overlay = Overlay.ofVideo(video)

        assertThat(overlay.text()).isEmpty
        assertThat(overlay.image()).isEmpty
        assertThat(overlay.video()).contains(video)
        assertThat(overlay.subtitle()).isEmpty
        assertThat(overlay.solidColor()).isEmpty
    }

    @Test
    fun ofVideoRoundtrip() {
        val jsonMapper = jsonMapper()
        val overlay =
            Overlay.ofVideo(
                VideoOverlay.builder()
                    .position(
                        OverlayPosition.builder()
                            .focus(OverlayPosition.Focus.CENTER)
                            .x(0.0)
                            .y(0.0)
                            .build()
                    )
                    .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                    .input("input")
                    .encoding(VideoOverlay.Encoding.AUTO)
                    .transformation(listOf())
                    .build()
            )

        val roundtrippedOverlay =
            jsonMapper.readValue(jsonMapper.writeValueAsString(overlay), jacksonTypeRef<Overlay>())

        assertThat(roundtrippedOverlay).isEqualTo(overlay)
    }

    @Test
    fun ofSubtitle() {
        val subtitle =
            SubtitleOverlay.builder()
                .position(
                    OverlayPosition.builder()
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .y(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .input("input")
                .encoding(SubtitleOverlay.Encoding.AUTO)
                .addTransformation(
                    SubtitleOverlayTransformation.builder()
                        .background("background")
                        .color("color")
                        .fontFamily("fontFamily")
                        .fontOutline("fontOutline")
                        .fontShadow("fontShadow")
                        .fontSize(0.0)
                        .typography(SubtitleOverlayTransformation.Typography.B)
                        .build()
                )
                .build()

        val overlay = Overlay.ofSubtitle(subtitle)

        assertThat(overlay.text()).isEmpty
        assertThat(overlay.image()).isEmpty
        assertThat(overlay.video()).isEmpty
        assertThat(overlay.subtitle()).contains(subtitle)
        assertThat(overlay.solidColor()).isEmpty
    }

    @Test
    fun ofSubtitleRoundtrip() {
        val jsonMapper = jsonMapper()
        val overlay =
            Overlay.ofSubtitle(
                SubtitleOverlay.builder()
                    .position(
                        OverlayPosition.builder()
                            .focus(OverlayPosition.Focus.CENTER)
                            .x(0.0)
                            .y(0.0)
                            .build()
                    )
                    .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                    .input("input")
                    .encoding(SubtitleOverlay.Encoding.AUTO)
                    .addTransformation(
                        SubtitleOverlayTransformation.builder()
                            .background("background")
                            .color("color")
                            .fontFamily("fontFamily")
                            .fontOutline("fontOutline")
                            .fontShadow("fontShadow")
                            .fontSize(0.0)
                            .typography(SubtitleOverlayTransformation.Typography.B)
                            .build()
                    )
                    .build()
            )

        val roundtrippedOverlay =
            jsonMapper.readValue(jsonMapper.writeValueAsString(overlay), jacksonTypeRef<Overlay>())

        assertThat(roundtrippedOverlay).isEqualTo(overlay)
    }

    @Test
    fun ofSolidColor() {
        val solidColor =
            SolidColorOverlay.builder()
                .position(
                    OverlayPosition.builder()
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .y(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .color("color")
                .addTransformation(
                    SolidColorOverlayTransformation.builder()
                        .alpha(1.0)
                        .background("background")
                        .gradientTrue()
                        .height(0.0)
                        .radius(0.0)
                        .width(0.0)
                        .build()
                )
                .build()

        val overlay = Overlay.ofSolidColor(solidColor)

        assertThat(overlay.text()).isEmpty
        assertThat(overlay.image()).isEmpty
        assertThat(overlay.video()).isEmpty
        assertThat(overlay.subtitle()).isEmpty
        assertThat(overlay.solidColor()).contains(solidColor)
    }

    @Test
    fun ofSolidColorRoundtrip() {
        val jsonMapper = jsonMapper()
        val overlay =
            Overlay.ofSolidColor(
                SolidColorOverlay.builder()
                    .position(
                        OverlayPosition.builder()
                            .focus(OverlayPosition.Focus.CENTER)
                            .x(0.0)
                            .y(0.0)
                            .build()
                    )
                    .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                    .color("color")
                    .addTransformation(
                        SolidColorOverlayTransformation.builder()
                            .alpha(1.0)
                            .background("background")
                            .gradientTrue()
                            .height(0.0)
                            .radius(0.0)
                            .width(0.0)
                            .build()
                    )
                    .build()
            )

        val roundtrippedOverlay =
            jsonMapper.readValue(jsonMapper.writeValueAsString(overlay), jacksonTypeRef<Overlay>())

        assertThat(roundtrippedOverlay).isEqualTo(overlay)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val overlay = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Overlay>())

        val e = assertThrows<ImageKitInvalidDataException> { overlay.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
