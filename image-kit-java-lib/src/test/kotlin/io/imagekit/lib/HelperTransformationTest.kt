package io.imagekit.lib

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import io.imagekit.core.JsonValue
import io.imagekit.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelperTransformationTest {

    private val privateKey = "test-key"
    private val client = ImageKitOkHttpClient.builder().privateKey(privateKey).build()

    @Test
    fun `should return empty string for empty transformation array`() {
        val result = client.helper().buildTransformationString(null)
        assertThat(result).isEmpty()

        val result2 = client.helper().buildTransformationString(emptyList())
        assertThat(result2).isEmpty()
    }

    @Test
    fun `should generate transformation string for width only`() {
        val transformation = listOf(Transformation.builder().width(300.0).build())

        val result = client.helper().buildTransformationString(transformation)
        assertThat(result).isEqualTo("w-300")
    }

    @Test
    fun `should generate transformation string for multiple parameters`() {
        val transformation = listOf(Transformation.builder().width(300.0).height(200.0).build())

        val result = client.helper().buildTransformationString(transformation)
        assertThat(result).isEqualTo("w-300,h-200")
    }

    @Test
    fun `should generate transformation string for chained transformations`() {
        val transformation =
            listOf(
                Transformation.builder().width(300.0).build(),
                Transformation.builder().height(200.0).build(),
            )

        val result = client.helper().buildTransformationString(transformation)
        assertThat(result).isEqualTo("w-300:h-200")
    }

    @Test
    fun `should handle empty transformation object`() {
        val transformation = listOf(Transformation.builder().build())

        val result = client.helper().buildTransformationString(transformation)
        assertThat(result).isEmpty()
    }

    @Test
    fun `should handle transformation with overlay`() {
        val transformation =
            listOf(
                Transformation.builder()
                    .overlay(
                        Overlay.ofText(
                            TextOverlay.builder().text("Hello").type(JsonValue.from("text")).build()
                        )
                    )
                    .build()
            )

        val result = client.helper().buildTransformationString(transformation)
        assertThat(result).isEqualTo("l-text,i-Hello,l-end")
    }

    @Test
    fun `should handle raw transformation parameter`() {
        val transformation = listOf(Transformation.builder().raw("custom-transform-123").build())

        val result = client.helper().buildTransformationString(transformation)
        assertThat(result).isEqualTo("custom-transform-123")
    }

    @Test
    fun `should handle mixed parameters with raw`() {
        val transformation =
            listOf(Transformation.builder().width(300.0).raw("custom-param-123").build())

        val result = client.helper().buildTransformationString(transformation)
        assertThat(result).isEqualTo("w-300,custom-param-123")
    }

    @Test
    fun `should handle quality parameter`() {
        val transformation = listOf(Transformation.builder().quality(80.0).build())

        val result = client.helper().buildTransformationString(transformation)
        assertThat(result).isEqualTo("q-80")
    }

    @Test
    fun `should handle aspect ratio parameter`() {
        val transformation = listOf(Transformation.builder().aspectRatio("4:3").build())

        val result = client.helper().buildTransformationString(transformation)
        assertThat(result).isEqualTo("ar-4:3")
    }
}
