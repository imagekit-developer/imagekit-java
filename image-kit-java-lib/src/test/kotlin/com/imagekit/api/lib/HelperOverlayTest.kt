package com.imagekit.api.lib

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelperOverlayTest {

    private val privateKey = "My Private API Key"
    private val client = ImageKitOkHttpClient.builder().privateKey(privateKey).build()

    // ========================================
    // TestOverlayTransformations - 12 tests
    // ========================================

    @Test
    fun `should ignore overlay when type property is missing`() {
        val transformation = listOf(Transformation.builder().width(300.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/tr:w-300/base-image.jpg")
    }

    @Test
    fun `should ignore text overlay when text property is missing`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder().text("").type(JsonValue.from("text")).build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/base-image.jpg")
    }

    @Test
    fun `should ignore image overlay when input property is missing`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder().input("").type(JsonValue.from("image")).build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/base-image.jpg")
    }

    @Test
    fun `should ignore video overlay when input property is missing`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofVideo(
                            VideoOverlay.builder().input("").type(JsonValue.from("video")).build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/base-image.jpg")
    }

    @Test
    fun `should ignore subtitle overlay when input property is missing`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofSubtitle(
                            SubtitleOverlay.builder()
                                .input("")
                                .type(JsonValue.from("subtitle"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/base-image.jpg")
    }

    @Test
    fun `should ignore solid color overlay when color property is missing`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofSolidColor(
                            SolidColorOverlay.builder()
                                .color("")
                                .type(JsonValue.from("solidColor"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/base-image.jpg")
    }

    @Test
    fun `should generate URL with text overlay using URL encoding`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("Minimal Text")
                                .type(JsonValue.from("text"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-text,i-Minimal%20Text,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should generate URL with image overlay from input file`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("logo.png")
                                .type(JsonValue.from("image"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-image,i-logo.png,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should generate URL with video overlay from input file`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofVideo(
                            VideoOverlay.builder()
                                .input("play-pause-loop.mp4")
                                .type(JsonValue.from("video"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-video.mp4")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-video,i-play-pause-loop.mp4,l-end/base-video.mp4"
            )
    }

    @Test
    fun `should generate URL with subtitle overlay from input file`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofSubtitle(
                            SubtitleOverlay.builder()
                                .input("subtitle.srt")
                                .type(JsonValue.from("subtitle"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-video.mp4")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-subtitles,i-subtitle.srt,l-end/base-video.mp4"
            )
    }

    @Test
    fun `should generate URL with solid color overlay using background color`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofSolidColor(
                            SolidColorOverlay.builder()
                                .color("FF0000")
                                .type(JsonValue.from("solidColor"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-image,i-ik_canvas,bg-FF0000,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should generate URL with multiple complex overlays including nested transformations`() {
        val transformation =
            listOf(
                // Text overlay with complex transformations
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("Every thing")
                                .type(JsonValue.from("text"))
                                .position(
                                    OverlayPosition.builder()
                                        .x("10")
                                        .y("20")
                                        .focus(OverlayPosition.Focus.CENTER)
                                        .build()
                                )
                                .timing(
                                    OverlayTiming.builder()
                                        .start(5.0)
                                        .duration("10")
                                        .end(15.0)
                                        .build()
                                )
                                .transformation(
                                    listOf(
                                        TextOverlayTransformation.builder()
                                            .width("bw_mul_0.5")
                                            .fontSize(20.0)
                                            .fontFamily("Arial")
                                            .fontColor("0000ff")
                                            .innerAlignment(
                                                TextOverlayTransformation.InnerAlignment.LEFT
                                            )
                                            .padding(5.0)
                                            .alpha(7.0)
                                            .typography("b")
                                            .background("red")
                                            .radius(10.0)
                                            .rotation("N45")
                                            .flip(TextOverlayTransformation.Flip.H)
                                            .lineHeight(20.0)
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build(),
                // Image overlay with nested transformations including nested text overlay
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("logo.png")
                                .type(JsonValue.from("image"))
                                .position(
                                    OverlayPosition.builder()
                                        .x("10")
                                        .y("20")
                                        .focus(OverlayPosition.Focus.CENTER)
                                        .build()
                                )
                                .timing(
                                    OverlayTiming.builder()
                                        .start(5.0)
                                        .duration("10")
                                        .end(15.0)
                                        .build()
                                )
                                .transformation(
                                    listOf(
                                        Transformation.builder()
                                            .width("bw_mul_0.5")
                                            .height("bh_mul_0.5")
                                            .rotation("N45")
                                            .flip(Transformation.Flip.H)
                                            .overlay(
                                                Overlay.ofText(
                                                    TextOverlay.builder()
                                                        .text("Nested text overlay")
                                                        .type(JsonValue.from("text"))
                                                        .build()
                                                )
                                            )
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build(),
                // Video overlay
                Transformation.builder()
                    .overlay(
                        Overlay.ofVideo(
                            VideoOverlay.builder()
                                .input("play-pause-loop.mp4")
                                .type(JsonValue.from("video"))
                                .position(
                                    OverlayPosition.builder()
                                        .x("10")
                                        .y("20")
                                        .focus(OverlayPosition.Focus.CENTER)
                                        .build()
                                )
                                .timing(
                                    OverlayTiming.builder()
                                        .start(5.0)
                                        .duration("10")
                                        .end(15.0)
                                        .build()
                                )
                                .transformation(
                                    listOf(
                                        Transformation.builder()
                                            .width("bw_mul_0.5")
                                            .height("bh_mul_0.5")
                                            .rotation("N45")
                                            .flip(Transformation.Flip.H)
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build(),
                // Subtitle overlay
                Transformation.builder()
                    .overlay(
                        Overlay.ofSubtitle(
                            SubtitleOverlay.builder()
                                .input("subtitle.srt")
                                .type(JsonValue.from("subtitle"))
                                .position(
                                    OverlayPosition.builder()
                                        .x("10")
                                        .y("20")
                                        .focus(OverlayPosition.Focus.CENTER)
                                        .build()
                                )
                                .timing(
                                    OverlayTiming.builder()
                                        .start(5.0)
                                        .duration("10")
                                        .end(15.0)
                                        .build()
                                )
                                .transformation(
                                    listOf(
                                        SubtitleOverlayTransformation.builder()
                                            .background("red")
                                            .color("0000ff")
                                            .fontFamily("Arial")
                                            .fontOutline("2_A1CCDD50")
                                            .fontShadow("A1CCDD_3")
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build(),
                // Solid color overlay
                Transformation.builder()
                    .overlay(
                        Overlay.ofSolidColor(
                            SolidColorOverlay.builder()
                                .color("FF0000")
                                .type(JsonValue.from("solidColor"))
                                .position(
                                    OverlayPosition.builder()
                                        .x("10")
                                        .y("20")
                                        .focus(OverlayPosition.Focus.CENTER)
                                        .build()
                                )
                                .timing(
                                    OverlayTiming.builder()
                                        .start(5.0)
                                        .duration("10")
                                        .end(15.0)
                                        .build()
                                )
                                .transformation(
                                    listOf(
                                        SolidColorOverlayTransformation.builder()
                                            .width("bw_mul_0.5")
                                            .height("bh_mul_0.5")
                                            .alpha(0.5)
                                            .background("red")
                                            .gradientTrue()
                                            .radiusMax()
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build(),
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-text,i-Every%20thing,lx-10,ly-20,lfo-center,lso-5,leo-15,ldu-10,w-bw_mul_0.5,fs-20,ff-Arial,co-0000ff,ia-left,pa-5,al-7,tg-b,bg-red,r-10,rt-N45,fl-h,lh-20,l-end:l-image,i-logo.png,lx-10,ly-20,lfo-center,lso-5,leo-15,ldu-10,w-bw_mul_0.5,h-bh_mul_0.5,rt-N45,fl-h,l-text,i-Nested%20text%20overlay,l-end,l-end:l-video,i-play-pause-loop.mp4,lx-10,ly-20,lfo-center,lso-5,leo-15,ldu-10,w-bw_mul_0.5,h-bh_mul_0.5,rt-N45,fl-h,l-end:l-subtitles,i-subtitle.srt,lx-10,ly-20,lfo-center,lso-5,leo-15,ldu-10,bg-red,co-0000ff,ff-Arial,fol-2_A1CCDD50,fsh-A1CCDD_3,l-end:l-image,i-ik_canvas,bg-FF0000,lx-10,ly-20,lfo-center,lso-5,leo-15,ldu-10,w-bw_mul_0.5,h-bh_mul_0.5,al-0.5,bg-red,e-gradient,r-max,l-end/base-image.jpg"
            )
    }

    // ========================================
    // TestOverlayEncoding - 19 tests
    // ========================================

    @Test
    fun `should use plain encoding for simple image paths with slashes converted to @@`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("/customer_logo/nykaa.png")
                                .type(JsonValue.from("image"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/medium_cafe_B1iTdD0C.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-image,i-customer_logo@@nykaa.png,l-end/medium_cafe_B1iTdD0C.jpg"
            )
    }

    @Test
    fun `should use base64 encoding for image paths containing special characters`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("/customer_logo/Ñykaa.png")
                                .type(JsonValue.from("image"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/medium_cafe_B1iTdD0C.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-image,ie-Y3VzdG9tZXJfbG9nby%2FDkXlrYWEucG5n,l-end/medium_cafe_B1iTdD0C.jpg"
            )
    }

    @Test
    fun `should use plain encoding for simple text overlays`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder().text("Manu").type(JsonValue.from("text")).build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/medium_cafe_B1iTdD0C.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-text,i-Manu,l-end/medium_cafe_B1iTdD0C.jpg"
            )
    }

    @Test
    fun `should convert slashes to @@ in fontFamily paths for custom fonts`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("Manu")
                                .type(JsonValue.from("text"))
                                .transformation(
                                    listOf(
                                        TextOverlayTransformation.builder()
                                            .fontFamily("nested-path/Poppins-Regular_Q15GrYWmL.ttf")
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/medium_cafe_B1iTdD0C.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-text,i-Manu,ff-nested-path@@Poppins-Regular_Q15GrYWmL.ttf,l-end/medium_cafe_B1iTdD0C.jpg"
            )
    }

    @Test
    fun `should use URL encoding for text overlays with spaces and safe characters`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("alnum123-._ ")
                                .type(JsonValue.from("text"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/medium_cafe_B1iTdD0C.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-text,i-alnum123-._%20,l-end/medium_cafe_B1iTdD0C.jpg"
            )
    }

    @Test
    fun `should use base64 encoding for text overlays with special unicode characters`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("Let's use ©, ®, ™, etc")
                                .type(JsonValue.from("text"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/medium_cafe_B1iTdD0C.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-text,ie-TGV0J3MgdXNlIMKpLCDCriwg4oSiLCBldGM%3D,l-end/medium_cafe_B1iTdD0C.jpg"
            )
    }

    @Test
    fun `should use plain encoding when explicitly specified for text overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("HelloWorld")
                                .type(JsonValue.from("text"))
                                .encoding(TextOverlay.Encoding.PLAIN)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/sample.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/demo/tr:l-text,i-HelloWorld,l-end/sample.jpg")
    }

    @Test
    fun `should use base64 encoding when explicitly specified for text overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("HelloWorld")
                                .type(JsonValue.from("text"))
                                .encoding(TextOverlay.Encoding.BASE64)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/sample.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-text,ie-SGVsbG9Xb3JsZA%3D%3D,l-end/sample.jpg"
            )
    }

    @Test
    fun `should use plain encoding when explicitly specified for image overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("/customer/logo.png")
                                .type(JsonValue.from("image"))
                                .encoding(ImageOverlay.Encoding.PLAIN)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/sample.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-image,i-customer@@logo.png,l-end/sample.jpg"
            )
    }

    @Test
    fun `should use base64 encoding when explicitly specified for image overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("/customer/logo.png")
                                .type(JsonValue.from("image"))
                                .encoding(ImageOverlay.Encoding.BASE64)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/sample.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-image,ie-Y3VzdG9tZXIvbG9nby5wbmc%3D,l-end/sample.jpg"
            )
    }

    @Test
    fun `should use base64 encoding when explicitly specified for video overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofVideo(
                            VideoOverlay.builder()
                                .input("/path/to/video.mp4")
                                .type(JsonValue.from("video"))
                                .encoding(VideoOverlay.Encoding.BASE64)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/sample.mp4")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-video,ie-cGF0aC90by92aWRlby5tcDQ%3D,l-end/sample.mp4"
            )
    }

    @Test
    fun `should use plain encoding when explicitly specified for subtitle overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofSubtitle(
                            SubtitleOverlay.builder()
                                .input("/sub.srt")
                                .type(JsonValue.from("subtitle"))
                                .encoding(SubtitleOverlay.Encoding.PLAIN)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/sample.mp4")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/demo/tr:l-subtitles,i-sub.srt,l-end/sample.mp4")
    }

    @Test
    fun `should use base64 encoding when explicitly specified for subtitle overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofSubtitle(
                            SubtitleOverlay.builder()
                                .input("sub.srt")
                                .type(JsonValue.from("subtitle"))
                                .encoding(SubtitleOverlay.Encoding.BASE64)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/sample.mp4")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-subtitles,ie-c3ViLnNydA%3D%3D,l-end/sample.mp4"
            )
    }

    @Test
    fun `should properly encode overlay text when transformations are in query parameters`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("Minimal Text")
                                .type(JsonValue.from("text"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/sample.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/demo/sample.jpg?tr=l-text,i-Minimal%20Text,l-end")
    }

    @Test
    fun `should generate URL with image overlay using layerMode multiply`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("logo.png")
                                .type(JsonValue.from("image"))
                                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-image,i-logo.png,lm-multiply,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should generate URL with image overlay using layerMode cutter`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("mask.png")
                                .type(JsonValue.from("image"))
                                .layerMode(BaseOverlay.LayerMode.CUTTER)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-image,i-mask.png,lm-cutter,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should generate URL with image overlay using layerMode cutout`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("shape.png")
                                .type(JsonValue.from("image"))
                                .layerMode(BaseOverlay.LayerMode.CUTOUT)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-image,i-shape.png,lm-cutout,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should generate URL with image overlay using layerMode displace`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("displacement.png")
                                .type(JsonValue.from("image"))
                                .layerMode(BaseOverlay.LayerMode.DISPLACE)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-image,i-displacement.png,lm-displace,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should generate URL with image overlay using xCenter yCenter and anchorPoint`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("logo.png")
                                .type(JsonValue.from("image"))
                                .position(
                                    OverlayPosition.builder()
                                        .xCenter(50.0)
                                        .yCenter("bh_mul_0.5")
                                        .anchorPoint(OverlayPosition.AnchorPoint.TOP_LEFT)
                                        .build()
                                )
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-image,i-logo.png,lxc-50,lyc-bh_mul_0.5,lap-top_left,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should generate layerMode on text overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("Hello")
                                .type(JsonValue.from("text"))
                                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-text,i-Hello,lm-multiply,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should generate layerMode on video overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofVideo(
                            VideoOverlay.builder()
                                .input("video.mp4")
                                .type(JsonValue.from("video"))
                                .layerMode(BaseOverlay.LayerMode.MULTIPLY)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-video,i-video.mp4,lm-multiply,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should generate layerMode on subtitle overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofSubtitle(
                            SubtitleOverlay.builder()
                                .input("subtitle.srt")
                                .type(JsonValue.from("subtitle"))
                                .layerMode(BaseOverlay.LayerMode.CUTTER)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-subtitles,i-subtitle.srt,lm-cutter,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should generate layerMode on solid color overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofSolidColor(
                            SolidColorOverlay.builder()
                                .color("FF0000")
                                .type(JsonValue.from("solidColor"))
                                .layerMode(BaseOverlay.LayerMode.CUTOUT)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-image,i-ik_canvas,bg-FF0000,lm-cutout,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should strip leading and trailing slashes from image overlay input path`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("/path/to/logo.png/")
                                .type(JsonValue.from("image"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-image,i-path@@to@@logo.png,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should strip leading and trailing slashes from fontFamily in text overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("Hello")
                                .type(JsonValue.from("text"))
                                .transformation(
                                    listOf(
                                        TextOverlayTransformation.builder()
                                            .fontFamily("/sdk-testing-files/Poppins-Regular.ttf/")
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-text,i-Hello,ff-sdk-testing-files@@Poppins-Regular.ttf,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should use processInputPath for subtitle overlay with slashes`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofSubtitle(
                            SubtitleOverlay.builder()
                                .input("/path/to/subtitle.srt")
                                .type(JsonValue.from("subtitle"))
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-subtitles,i-path@@to@@subtitle.srt,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should order anchorPoint before focus in overlay position`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofImage(
                            ImageOverlay.builder()
                                .input("logo.png")
                                .type(JsonValue.from("image"))
                                .position(
                                    OverlayPosition.builder()
                                        .focus(OverlayPosition.Focus.CENTER)
                                        .anchorPoint(OverlayPosition.AnchorPoint.BOTTOM_RIGHT)
                                        .build()
                                )
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-image,i-logo.png,lap-bottom_right,lfo-center,l-end/base-image.jpg"
            )
    }

    @Test
    fun `should properly path-escape special characters in plain text overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("Hello World")
                                .type(JsonValue.from("text"))
                                .encoding(TextOverlay.Encoding.PLAIN)
                                .build()
                        )
                    )
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("/base-image.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/tr:l-text,i-Hello%20World,l-end/base-image.jpg"
            )
    }
}
