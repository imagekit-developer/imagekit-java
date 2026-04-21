package io.imagekit.lib

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import io.imagekit.core.JsonValue
import io.imagekit.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelperSigningTest {

    private val privateKey = "dummy-key"
    private val client = ImageKitOkHttpClient.builder().privateKey(privateKey).build()

    @Test
    fun `should generate a signed URL when signed is true without expiresIn`() {
        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo/")
                        .src("sdk-testing-files/future-search.png")
                        .signed(true)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/sdk-testing-files/future-search.png?ik-s=32dbbbfc5f945c0403c71b54c38e76896ef2d6b0"
            )
    }

    @Test
    fun `should generate a signed URL when signed is true with expiresIn`() {
        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo/")
                        .src("sdk-testing-files/future-search.png")
                        .signed(true)
                        .expiresIn(3600.0)
                        .build()
                )

        // Expect ik-t exist in the URL. We don't assert signature because it will keep changing.
        assertThat(url).contains("ik-t")
    }

    @Test
    fun `should generate a signed URL when expiresIn is above 0 and even if signed is false`() {
        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo/")
                        .src("sdk-testing-files/future-search.png")
                        .signed(false)
                        .expiresIn(3600.0)
                        .build()
                )

        // Expect ik-t exist in the URL. We don't assert signature because it will keep changing.
        assertThat(url).contains("ik-t")
    }

    @Test
    fun `should generate signed URL with special characters in filename`() {
        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo/")
                        .src("sdk-testing-files/हिन्दी.png")
                        .signed(true)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/sdk-testing-files/%E0%A4%B9%E0%A4%BF%E0%A4%A8%E0%A5%8D%E0%A4%A6%E0%A5%80.png?ik-s=3fff2f31da1f45e007adcdbe95f88c8c330e743c"
            )
    }

    @Test
    fun `should generate signed URL with text overlay containing special characters`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("हिन्दी")
                                .type(JsonValue.from("text"))
                                .transformation(
                                    listOf(
                                        TextOverlayTransformation.builder()
                                            .fontColor("red")
                                            .fontSize("32")
                                            .fontFamily(
                                                "sdk-testing-files/Poppins-Regular_Q15GrYWmL.ttf"
                                            )
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
                        .urlEndpoint("https://ik.imagekit.io/demo/")
                        .src("sdk-testing-files/हिन्दी.png")
                        .transformation(transformation)
                        .signed(true)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/sdk-testing-files/%E0%A4%B9%E0%A4%BF%E0%A4%A8%E0%A5%8D%E0%A4%A6%E0%A5%80.png?tr=l-text,ie-4KS54KS%2F4KSo4KWN4KSm4KWA,fs-32,ff-sdk-testing-files@@Poppins-Regular_Q15GrYWmL.ttf,co-red,l-end&ik-s=705e41579d368caa6530a4375355325277fcfe5c"
            )
    }

    @Test
    fun `should generate signed URL with text overlay and special characters using path transformation position`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder()
                                .text("हिन्दी")
                                .type(JsonValue.from("text"))
                                .transformation(
                                    listOf(
                                        TextOverlayTransformation.builder()
                                            .fontColor("red")
                                            .fontSize("32")
                                            .fontFamily(
                                                "sdk-testing-files/Poppins-Regular_Q15GrYWmL.ttf"
                                            )
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
                        .urlEndpoint("https://ik.imagekit.io/demo/")
                        .src("sdk-testing-files/हिन्दी.png")
                        .transformationPosition(TransformationPosition.PATH)
                        .transformation(transformation)
                        .signed(true)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:l-text,ie-4KS54KS%2F4KSo4KWN4KSm4KWA,fs-32,ff-sdk-testing-files@@Poppins-Regular_Q15GrYWmL.ttf,co-red,l-end/sdk-testing-files/%E0%A4%B9%E0%A4%BF%E0%A4%A8%E0%A5%8D%E0%A4%A6%E0%A5%80.png?ik-s=20958f6126fd67c90653f55a49f2b7bb938d9d1c"
            )
    }

    @Test
    fun `should generate signed URL with query parameters`() {
        val queryParams =
            SrcOptions.QueryParameters.builder()
                .putAdditionalProperty("version", JsonValue.from("1.0"))
                .putAdditionalProperty("cache", JsonValue.from("false"))
                .build()

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo/")
                        .src("sdk-testing-files/future-search.png")
                        .queryParameters(queryParams)
                        .signed(true)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/sdk-testing-files/future-search.png?cache=false&version=1.0&ik-s=03767bb6f0898c04e42f65714af65d937c696d66"
            )
    }

    @Test
    fun `should generate signed URL with transformations and query parameters`() {
        val transformation = listOf(Transformation.builder().width(300.0).height(200.0).build())

        val queryParams =
            SrcOptions.QueryParameters.builder()
                .putAdditionalProperty("version", JsonValue.from("2.0"))
                .build()

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo/")
                        .src("sdk-testing-files/future-search.png")
                        .transformation(transformation)
                        .queryParameters(queryParams)
                        .signed(true)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/sdk-testing-files/future-search.png?version=2.0&tr=w-300,h-200&ik-s=601d97a7834b7554f4dabf0d3fc3a219ceeb6b31"
            )
    }

    @Test
    fun `should not sign URL when signed is false`() {
        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo/")
                        .src("sdk-testing-files/future-search.png")
                        .signed(false)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/demo/sdk-testing-files/future-search.png")
        assertThat(url).doesNotContain("ik-s=")
        assertThat(url).doesNotContain("ik-t=")
    }

    @Test
    fun `should generate signed URL with transformations in path position and query parameters`() {
        val transformation = listOf(Transformation.builder().width(300.0).height(200.0).build())

        val queryParams =
            SrcOptions.QueryParameters.builder()
                .putAdditionalProperty("version", JsonValue.from("2.0"))
                .build()

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/demo/")
                        .src("sdk-testing-files/future-search.png")
                        .transformation(transformation)
                        .transformationPosition(TransformationPosition.PATH)
                        .queryParameters(queryParams)
                        .signed(true)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/demo/tr:w-300,h-200/sdk-testing-files/future-search.png?version=2.0&ik-s=dd1ee8f83d019bc59fd57a5fc4674a11eb8a3496"
            )
    }
}
