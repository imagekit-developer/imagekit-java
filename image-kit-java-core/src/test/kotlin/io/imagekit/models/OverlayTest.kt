// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.JsonValue
import io.imagekit.core.jsonMapper
import io.imagekit.errors.ImageKitInvalidDataException
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
                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                .position(
                    OverlayPosition.builder()
                        .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .xCenter(0.0)
                        .y(0.0)
                        .yCenter(0.0)
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
                        .radiusMax()
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
                    .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                    .position(
                        OverlayPosition.builder()
                            .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                            .focus(OverlayPosition.Focus.CENTER)
                            .x(0.0)
                            .xCenter(0.0)
                            .y(0.0)
                            .yCenter(0.0)
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
                            .radiusMax()
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
                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                .position(
                    OverlayPosition.builder()
                        .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .xCenter(0.0)
                        .y(0.0)
                        .yCenter(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .input("input")
                .encoding(ImageOverlay.Encoding.AUTO)
                .addTransformation(
                    Transformation.builder()
                        .aiChangeBackground("aiChangeBackground")
                        .aiDropShadowTrue()
                        .aiEdit("aiEdit")
                        .aiRemoveBackground(Transformation.AiRemoveBackground.TRUE)
                        .aiRemoveBackgroundExternal(Transformation.AiRemoveBackgroundExternal.TRUE)
                        .aiRetouch(Transformation.AiRetouch.TRUE)
                        .aiUpscale(Transformation.AiUpscale.TRUE)
                        .aiVariation(Transformation.AiVariation.TRUE)
                        .aspectRatio("4:3")
                        .audioCodec(Transformation.AudioCodec.AAC)
                        .background("red")
                        .blur(10.0)
                        .border("5_FF0000")
                        .colorProfile(true)
                        .colorReplace("colorReplace")
                        .contrastStretch(Transformation.ContrastStretch.TRUE)
                        .crop(Transformation.Crop.FORCE)
                        .cropMode(Transformation.CropMode.PAD_RESIZE)
                        .defaultImage("defaultImage")
                        .distort("distort")
                        .dpr(2.0)
                        .duration(0.0)
                        .endOffset(0.0)
                        .flip(Transformation.Flip.H)
                        .focus("center")
                        .format(Transformation.Format.AUTO)
                        .gradientTrue()
                        .grayscale(Transformation.Grayscale.TRUE)
                        .height(200.0)
                        .lossless(true)
                        .metadata(true)
                        .named("named")
                        .opacity(0.0)
                        .original(true)
                        .overlay(
                            TextOverlay.builder()
                                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                                .position(
                                    OverlayPosition.builder()
                                        .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                                        .focus(OverlayPosition.Focus.CENTER)
                                        .x(0.0)
                                        .xCenter(0.0)
                                        .y(0.0)
                                        .yCenter(0.0)
                                        .build()
                                )
                                .timing(
                                    OverlayTiming.builder()
                                        .duration(0.0)
                                        .end(0.0)
                                        .start(0.0)
                                        .build()
                                )
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
                                        .innerAlignment(
                                            TextOverlayTransformation.InnerAlignment.LEFT
                                        )
                                        .lineHeight(0.0)
                                        .padding(0.0)
                                        .radiusMax()
                                        .rotation(0.0)
                                        .typography("typography")
                                        .width(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .page(0.0)
                        .progressive(true)
                        .quality(80.0)
                        .radius(20.0)
                        .raw("raw")
                        .rotation(90.0)
                        .shadowTrue()
                        .sharpenTrue()
                        .startOffset(0.0)
                        .addStreamingResolution(StreamingResolution._240)
                        .trimTrue()
                        .unsharpMaskTrue()
                        .videoCodec(Transformation.VideoCodec.H264)
                        .width(300.0)
                        .x(0.0)
                        .xCenter(0.0)
                        .y(0.0)
                        .yCenter(0.0)
                        .zoom(0.0)
                        .build()
                )
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
                    .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                    .position(
                        OverlayPosition.builder()
                            .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                            .focus(OverlayPosition.Focus.CENTER)
                            .x(0.0)
                            .xCenter(0.0)
                            .y(0.0)
                            .yCenter(0.0)
                            .build()
                    )
                    .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                    .input("input")
                    .encoding(ImageOverlay.Encoding.AUTO)
                    .addTransformation(
                        Transformation.builder()
                            .aiChangeBackground("aiChangeBackground")
                            .aiDropShadowTrue()
                            .aiEdit("aiEdit")
                            .aiRemoveBackground(Transformation.AiRemoveBackground.TRUE)
                            .aiRemoveBackgroundExternal(
                                Transformation.AiRemoveBackgroundExternal.TRUE
                            )
                            .aiRetouch(Transformation.AiRetouch.TRUE)
                            .aiUpscale(Transformation.AiUpscale.TRUE)
                            .aiVariation(Transformation.AiVariation.TRUE)
                            .aspectRatio("4:3")
                            .audioCodec(Transformation.AudioCodec.AAC)
                            .background("red")
                            .blur(10.0)
                            .border("5_FF0000")
                            .colorProfile(true)
                            .colorReplace("colorReplace")
                            .contrastStretch(Transformation.ContrastStretch.TRUE)
                            .crop(Transformation.Crop.FORCE)
                            .cropMode(Transformation.CropMode.PAD_RESIZE)
                            .defaultImage("defaultImage")
                            .distort("distort")
                            .dpr(2.0)
                            .duration(0.0)
                            .endOffset(0.0)
                            .flip(Transformation.Flip.H)
                            .focus("center")
                            .format(Transformation.Format.AUTO)
                            .gradientTrue()
                            .grayscale(Transformation.Grayscale.TRUE)
                            .height(200.0)
                            .lossless(true)
                            .metadata(true)
                            .named("named")
                            .opacity(0.0)
                            .original(true)
                            .overlay(
                                TextOverlay.builder()
                                    .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                                    .position(
                                        OverlayPosition.builder()
                                            .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                                            .focus(OverlayPosition.Focus.CENTER)
                                            .x(0.0)
                                            .xCenter(0.0)
                                            .y(0.0)
                                            .yCenter(0.0)
                                            .build()
                                    )
                                    .timing(
                                        OverlayTiming.builder()
                                            .duration(0.0)
                                            .end(0.0)
                                            .start(0.0)
                                            .build()
                                    )
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
                                            .innerAlignment(
                                                TextOverlayTransformation.InnerAlignment.LEFT
                                            )
                                            .lineHeight(0.0)
                                            .padding(0.0)
                                            .radiusMax()
                                            .rotation(0.0)
                                            .typography("typography")
                                            .width(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .page(0.0)
                            .progressive(true)
                            .quality(80.0)
                            .radius(20.0)
                            .raw("raw")
                            .rotation(90.0)
                            .shadowTrue()
                            .sharpenTrue()
                            .startOffset(0.0)
                            .addStreamingResolution(StreamingResolution._240)
                            .trimTrue()
                            .unsharpMaskTrue()
                            .videoCodec(Transformation.VideoCodec.H264)
                            .width(300.0)
                            .x(0.0)
                            .xCenter(0.0)
                            .y(0.0)
                            .yCenter(0.0)
                            .zoom(0.0)
                            .build()
                    )
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
                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                .position(
                    OverlayPosition.builder()
                        .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .xCenter(0.0)
                        .y(0.0)
                        .yCenter(0.0)
                        .build()
                )
                .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                .input("input")
                .encoding(VideoOverlay.Encoding.AUTO)
                .addTransformation(
                    Transformation.builder()
                        .aiChangeBackground("aiChangeBackground")
                        .aiDropShadowTrue()
                        .aiEdit("aiEdit")
                        .aiRemoveBackground(Transformation.AiRemoveBackground.TRUE)
                        .aiRemoveBackgroundExternal(Transformation.AiRemoveBackgroundExternal.TRUE)
                        .aiRetouch(Transformation.AiRetouch.TRUE)
                        .aiUpscale(Transformation.AiUpscale.TRUE)
                        .aiVariation(Transformation.AiVariation.TRUE)
                        .aspectRatio("4:3")
                        .audioCodec(Transformation.AudioCodec.AAC)
                        .background("red")
                        .blur(10.0)
                        .border("5_FF0000")
                        .colorProfile(true)
                        .colorReplace("colorReplace")
                        .contrastStretch(Transformation.ContrastStretch.TRUE)
                        .crop(Transformation.Crop.FORCE)
                        .cropMode(Transformation.CropMode.PAD_RESIZE)
                        .defaultImage("defaultImage")
                        .distort("distort")
                        .dpr(2.0)
                        .duration(0.0)
                        .endOffset(0.0)
                        .flip(Transformation.Flip.H)
                        .focus("center")
                        .format(Transformation.Format.AUTO)
                        .gradientTrue()
                        .grayscale(Transformation.Grayscale.TRUE)
                        .height(200.0)
                        .lossless(true)
                        .metadata(true)
                        .named("named")
                        .opacity(0.0)
                        .original(true)
                        .overlay(
                            TextOverlay.builder()
                                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                                .position(
                                    OverlayPosition.builder()
                                        .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                                        .focus(OverlayPosition.Focus.CENTER)
                                        .x(0.0)
                                        .xCenter(0.0)
                                        .y(0.0)
                                        .yCenter(0.0)
                                        .build()
                                )
                                .timing(
                                    OverlayTiming.builder()
                                        .duration(0.0)
                                        .end(0.0)
                                        .start(0.0)
                                        .build()
                                )
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
                                        .innerAlignment(
                                            TextOverlayTransformation.InnerAlignment.LEFT
                                        )
                                        .lineHeight(0.0)
                                        .padding(0.0)
                                        .radiusMax()
                                        .rotation(0.0)
                                        .typography("typography")
                                        .width(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .page(0.0)
                        .progressive(true)
                        .quality(80.0)
                        .radius(20.0)
                        .raw("raw")
                        .rotation(90.0)
                        .shadowTrue()
                        .sharpenTrue()
                        .startOffset(0.0)
                        .addStreamingResolution(StreamingResolution._240)
                        .trimTrue()
                        .unsharpMaskTrue()
                        .videoCodec(Transformation.VideoCodec.H264)
                        .width(300.0)
                        .x(0.0)
                        .xCenter(0.0)
                        .y(0.0)
                        .yCenter(0.0)
                        .zoom(0.0)
                        .build()
                )
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
                    .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                    .position(
                        OverlayPosition.builder()
                            .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                            .focus(OverlayPosition.Focus.CENTER)
                            .x(0.0)
                            .xCenter(0.0)
                            .y(0.0)
                            .yCenter(0.0)
                            .build()
                    )
                    .timing(OverlayTiming.builder().duration(0.0).end(0.0).start(0.0).build())
                    .input("input")
                    .encoding(VideoOverlay.Encoding.AUTO)
                    .addTransformation(
                        Transformation.builder()
                            .aiChangeBackground("aiChangeBackground")
                            .aiDropShadowTrue()
                            .aiEdit("aiEdit")
                            .aiRemoveBackground(Transformation.AiRemoveBackground.TRUE)
                            .aiRemoveBackgroundExternal(
                                Transformation.AiRemoveBackgroundExternal.TRUE
                            )
                            .aiRetouch(Transformation.AiRetouch.TRUE)
                            .aiUpscale(Transformation.AiUpscale.TRUE)
                            .aiVariation(Transformation.AiVariation.TRUE)
                            .aspectRatio("4:3")
                            .audioCodec(Transformation.AudioCodec.AAC)
                            .background("red")
                            .blur(10.0)
                            .border("5_FF0000")
                            .colorProfile(true)
                            .colorReplace("colorReplace")
                            .contrastStretch(Transformation.ContrastStretch.TRUE)
                            .crop(Transformation.Crop.FORCE)
                            .cropMode(Transformation.CropMode.PAD_RESIZE)
                            .defaultImage("defaultImage")
                            .distort("distort")
                            .dpr(2.0)
                            .duration(0.0)
                            .endOffset(0.0)
                            .flip(Transformation.Flip.H)
                            .focus("center")
                            .format(Transformation.Format.AUTO)
                            .gradientTrue()
                            .grayscale(Transformation.Grayscale.TRUE)
                            .height(200.0)
                            .lossless(true)
                            .metadata(true)
                            .named("named")
                            .opacity(0.0)
                            .original(true)
                            .overlay(
                                TextOverlay.builder()
                                    .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                                    .position(
                                        OverlayPosition.builder()
                                            .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                                            .focus(OverlayPosition.Focus.CENTER)
                                            .x(0.0)
                                            .xCenter(0.0)
                                            .y(0.0)
                                            .yCenter(0.0)
                                            .build()
                                    )
                                    .timing(
                                        OverlayTiming.builder()
                                            .duration(0.0)
                                            .end(0.0)
                                            .start(0.0)
                                            .build()
                                    )
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
                                            .innerAlignment(
                                                TextOverlayTransformation.InnerAlignment.LEFT
                                            )
                                            .lineHeight(0.0)
                                            .padding(0.0)
                                            .radiusMax()
                                            .rotation(0.0)
                                            .typography("typography")
                                            .width(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .page(0.0)
                            .progressive(true)
                            .quality(80.0)
                            .radius(20.0)
                            .raw("raw")
                            .rotation(90.0)
                            .shadowTrue()
                            .sharpenTrue()
                            .startOffset(0.0)
                            .addStreamingResolution(StreamingResolution._240)
                            .trimTrue()
                            .unsharpMaskTrue()
                            .videoCodec(Transformation.VideoCodec.H264)
                            .width(300.0)
                            .x(0.0)
                            .xCenter(0.0)
                            .y(0.0)
                            .yCenter(0.0)
                            .zoom(0.0)
                            .build()
                    )
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
                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                .position(
                    OverlayPosition.builder()
                        .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .xCenter(0.0)
                        .y(0.0)
                        .yCenter(0.0)
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
                    .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                    .position(
                        OverlayPosition.builder()
                            .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                            .focus(OverlayPosition.Focus.CENTER)
                            .x(0.0)
                            .xCenter(0.0)
                            .y(0.0)
                            .yCenter(0.0)
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
                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                .position(
                    OverlayPosition.builder()
                        .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                        .focus(OverlayPosition.Focus.CENTER)
                        .x(0.0)
                        .xCenter(0.0)
                        .y(0.0)
                        .yCenter(0.0)
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
                        .radiusMax()
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
                    .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                    .position(
                        OverlayPosition.builder()
                            .anchorPoint(OverlayPosition.AnchorPoint.TOP)
                            .focus(OverlayPosition.Focus.CENTER)
                            .x(0.0)
                            .xCenter(0.0)
                            .y(0.0)
                            .yCenter(0.0)
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
                            .radiusMax()
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
