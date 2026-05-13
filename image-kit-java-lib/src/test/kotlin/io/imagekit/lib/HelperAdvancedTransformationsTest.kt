package io.imagekit.lib

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import io.imagekit.models.SrcOptions
import io.imagekit.models.StreamingResolution
import io.imagekit.models.Transformation
import io.imagekit.models.TransformationPosition
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelperAdvancedTransformationsTest {

    private val privateKey = "My Private API Key"
    private val client = ImageKitOkHttpClient.builder().privateKey(privateKey).build()

    // AI Transformation Tests
    @Test
    fun `should generate the correct URL for AI background removal when set to true`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .aiRemoveBackground(Transformation.AiRemoveBackground.TRUE)
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=e-bgremove")
    }

    @Test
    fun `should generate the correct URL for external AI background removal when set to true`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .aiRemoveBackgroundExternal(Transformation.AiRemoveBackgroundExternal.TRUE)
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=e-removedotbg")
    }

    @Test
    fun `should generate the correct URL when AI drop shadow transformation is set to true`() {
        val transformation = listOf(Transformation.builder().aiDropShadowTrue().build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=e-dropshadow")
    }

    @Test
    fun `should generate the correct URL when gradient transformation is set to true`() {
        val transformation = listOf(Transformation.builder().gradientTrue().build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=e-gradient")
    }

    @Test
    fun `should not apply AI background removal when value is not true`() {
        val transformation = listOf(Transformation.builder().build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg")
    }

    @Test
    fun `should not apply external AI background removal when value is not true`() {
        val transformation = listOf(Transformation.builder().build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg")
    }

    @Test
    fun `should handle AI transformations with parameters`() {
        val transformation =
            listOf(Transformation.builder().aiDropShadow("custom-shadow-params").build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=e-dropshadow-custom-shadow-params"
            )
    }

    @Test
    fun `should handle gradient with parameters`() {
        val transformation =
            listOf(Transformation.builder().gradient("ld-top_from-green_to-00FF0010_sp-1").build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=e-gradient-ld-top_from-green_to-00FF0010_sp-1"
            )
    }

    @Test
    fun `should combine AI transformations with regular transformations`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .width(300.0)
                    .height(200.0)
                    .aiRemoveBackground(Transformation.AiRemoveBackground.TRUE)
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=w-300,h-200,e-bgremove"
            )
    }

    @Test
    fun `should handle multiple AI transformations`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .aiRemoveBackground(Transformation.AiRemoveBackground.TRUE)
                    .aiDropShadowTrue()
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=e-bgremove,e-dropshadow"
            )
    }

    // Parameter-specific tests
    @Test
    fun `should generate the correct URL for width transformation when provided with a number value`() {
        val transformation = listOf(Transformation.builder().width(400.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=w-400")
    }

    @Test
    fun `should generate the correct URL for height transformation when provided with a string value`() {
        val transformation = listOf(Transformation.builder().height("300").build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=h-300")
    }

    @Test
    fun `should generate the correct URL for aspectRatio transformation when provided with colon format`() {
        val transformation = listOf(Transformation.builder().aspectRatio("4:3").build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=ar-4:3")
    }

    @Test
    fun `should generate the correct URL for quality transformation when provided with a number value`() {
        val transformation = listOf(Transformation.builder().quality(80.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=q-80")
    }

    @Test
    fun `should skip transformation parameters that are undefined or empty`() {
        val transformation = listOf(Transformation.builder().width(300.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=w-300")
    }

    @Test
    fun `should handle boolean transformation values`() {
        val transformation = listOf(Transformation.builder().trimTrue().build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=t-true")
    }

    @Test
    fun `should handle transformation parameter with empty string value`() {
        val transformation = listOf(Transformation.builder().defaultImage("").build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg")
    }

    @Test
    fun `should handle complex transformation combinations`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .width(300.0)
                    .height(200.0)
                    .quality(85.0)
                    .border("5_FF0000")
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=w-300,h-200,q-85,b-5_FF0000"
            )
    }

    @Test
    fun `should generate the correct URL for radius transformation with string value for per corner radius`() {
        val transformation = listOf(Transformation.builder().radius("10_10_max_10").build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path1.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path1.jpg?tr=r-10_10_max_10")
    }

    @Test
    fun `should generate the correct URL with many transformations, including video and AI transforms`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .height(300.0)
                    .width(400.0)
                    .aspectRatio("4-3")
                    .quality(40.0)
                    .crop(Transformation.Crop.FORCE)
                    .cropMode(Transformation.CropMode.EXTRACT)
                    .focus("left")
                    .format(Transformation.Format.JPEG)
                    .radius(50.0)
                    .background("A94D34")
                    .border("5-A94D34")
                    .rotation(90.0)
                    .blur(10.0)
                    .named("some_name")
                    .progressive(true)
                    .lossless(true)
                    .trim(5.0)
                    .metadata(true)
                    .colorProfile(true)
                    .defaultImage("/folder/file.jpg/")
                    .dpr(3.0)
                    .x(10.0)
                    .y(20.0)
                    .xCenter(30.0)
                    .yCenter(40.0)
                    .flip(Transformation.Flip.H)
                    .opacity(0.8)
                    .zoom(2.0)
                    .videoCodec(Transformation.VideoCodec.H264)
                    .audioCodec(Transformation.AudioCodec.AAC)
                    .startOffset(5.0)
                    .endOffset(15.0)
                    .duration(10.0)
                    .streamingResolutions(
                        listOf(StreamingResolution._1440, StreamingResolution._1080)
                    )
                    .grayscale(Transformation.Grayscale.TRUE)
                    .aiUpscale(Transformation.AiUpscale.TRUE)
                    .aiRetouch(Transformation.AiRetouch.TRUE)
                    .aiVariation(Transformation.AiVariation.TRUE)
                    .aiDropShadowTrue()
                    .aiChangeBackground("prompt-car")
                    .aiEdit("prompt-make it vintage")
                    .aiRemoveBackground(Transformation.AiRemoveBackground.TRUE)
                    .contrastStretch(Transformation.ContrastStretch.TRUE)
                    .shadow("bl-15_st-40_x-10_y-N5")
                    .sharpen(10.0)
                    .unsharpMask("2-2-0.8-0.024")
                    .gradient("from-red_to-white")
                    .colorize("co-FF0000_in-15")
                    .colorReplace("FF0000_100_0000FF")
                    .distort("a-45")
                    .original(true)
                    .page("2_4")
                    .raw("h-200,w-300,l-image,i-logo.png,l-end")
                    .build()
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path.jpg")
                        .transformation(transformation as List<Transformation>)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/test_path.jpg?tr=w-400,h-300,q-40,ar-4-3,c-force,cm-extract,fo-left,f-jpeg,r-50,bg-A94D34,b-5-A94D34,cr-FF0000_100_0000FF,di-folder@@file.jpg,dpr-3,x-10,y-20,xc-30,yc-40,o-0.8,z-2,rt-90,bl-10,n-some_name,pr-true,lo-true,fl-h,t-5,md-true,cp-true,vc-h264,ac-aac,so-5,eo-15,du-10,sr-1440_1080,e-grayscale,e-upscale,e-retouch,e-genvar,e-bgremove,e-contrast,e-dropshadow,e-changebg-prompt-car,e-edit-prompt-make it vintage,e-shadow-bl-15_st-40_x-10_y-N5,e-sharpen-10,e-usm-2-2-0.8-0.024,e-gradient-from-red_to-white,e-colorize-co-FF0000_in-15,e-distort-a-45,orig-true,pg-2_4,h-200,w-300,l-image,i-logo.png,l-end"
            )
    }
}
