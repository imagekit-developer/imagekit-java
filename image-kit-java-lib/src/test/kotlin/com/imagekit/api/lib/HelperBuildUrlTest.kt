package com.imagekit.api.lib

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.SrcOptions
import com.imagekit.api.models.Transformation
import com.imagekit.api.models.TransformationPosition
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelperBuildUrlTest {

    private val privateKey = "My Private API Key"
    private val client = ImageKitOkHttpClient.builder().privateKey(privateKey).build()

    @Test
    fun `should throw exception when src is not provided`() {
        org.junit.jupiter.api.assertThrows<IllegalStateException> {
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .build()
                )
        }
    }

    @Test
    fun `should generate a valid URL when src is slash`() {
        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/")
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/")
    }

    @Test
    fun `should generate a valid URL when src is provided without transformation`() {
        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path.jpg")
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path.jpg")
    }

    @Test
    fun `should generate a valid URL when absolute URL is provided without transformation`() {
        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("https://ik.imagekit.io/test_url_endpoint/test_path_alt.jpg")
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path_alt.jpg")
    }

    @Test
    fun `should generate valid URL when undefined transformation parameters are provided with path`() {
        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .src("/test_path_alt.jpg")
                        .transformationPosition(TransformationPosition.QUERY)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path_alt.jpg")
    }

    @Test
    fun `by default transformationPosition should be query`() {
        val transformation =
            listOf(
                Transformation.builder().height(300.0).width(400.0).build(),
                Transformation.builder().rotation(90.0).build(),
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .src("/test_path.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/test_path.jpg?tr=w-400,h-300:rt-90"
            )
    }

    @Test
    fun `should generate the URL without sdk version`() {
        val transformation = listOf(Transformation.builder().height(300.0).width(400.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .src("/test_path.jpg")
                        .transformation(transformation)
                        .transformationPosition(TransformationPosition.PATH)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/tr:w-400,h-300/test_path.jpg")
    }

    @Test
    fun `should generate the correct URL with a valid src and transformation`() {
        val transformation = listOf(Transformation.builder().height(300.0).width(400.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path.jpg?tr=w-400,h-300")
    }

    @Test
    fun `should add transformation as query when src has absolute url even if transformationPosition is path`() {
        val transformation = listOf(Transformation.builder().height(300.0).width(400.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.PATH)
                        .src("https://my.custom.domain.com/test_path.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url).isEqualTo("https://my.custom.domain.com/test_path.jpg?tr=w-400,h-300")
    }

    @Test
    fun `handle non-default url-endpoint case`() {
        val transformation = listOf(Transformation.builder().height(300.0).width(400.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/imagekit_id/new-endpoint/")
                        .src("/test_path.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/imagekit_id/new-endpoint/test_path.jpg?tr=w-400,h-300"
            )
    }

    @Test
    fun `should generate the correct URL when the provided path contains multiple leading slashes`() {
        val transformation = listOf(Transformation.builder().height(300.0).width(400.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("///test_path.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path.jpg?tr=w-400,h-300")
    }

    @Test
    fun `should generate the correct URL when the urlEndpoint is overridden`() {
        val transformation = listOf(Transformation.builder().height(300.0).width(400.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint_alt")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint_alt/test_path.jpg?tr=w-400,h-300")
    }

    @Test
    fun `should generate the correct URL with transformationPosition as query parameter when src is provided`() {
        val transformation = listOf(Transformation.builder().height(300.0).width(400.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .src("/test_path.jpg")
                        .transformationPosition(TransformationPosition.QUERY)
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path.jpg?tr=w-400,h-300")
    }

    @Test
    fun `should generate the correct URL with a valid src parameter and transformation`() {
        val transformation = listOf(Transformation.builder().height(300.0).width(400.0).build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("https://ik.imagekit.io/test_url_endpoint/test_path_alt.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path_alt.jpg?tr=w-400,h-300")
    }

    @Test
    fun `should merge query parameters correctly in the generated URL`() {
        val transformation = listOf(Transformation.builder().height(300.0).width(400.0).build())

        val queryParams =
            SrcOptions.QueryParameters.builder()
                .putAdditionalProperty("t2", JsonValue.from("v2"))
                .putAdditionalProperty("t3", JsonValue.from("v3"))
                .build()

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("https://ik.imagekit.io/test_url_endpoint/test_path_alt.jpg?t1=v1")
                        .queryParameters(queryParams)
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/test_path_alt.jpg?t1=v1&t2=v2&t3=v3&tr=w-400,h-300"
            )
    }

    @Test
    fun `should generate the correct URL with chained transformations`() {
        val transformation =
            listOf(
                Transformation.builder().height(300.0).width(400.0).build(),
                Transformation.builder().rotation(90.0).build(),
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/test_path.jpg?tr=w-400,h-300:rt-90"
            )
    }

    @Test
    fun `should generate the correct URL with chained transformations including raw transformation`() {
        val transformation =
            listOf(
                Transformation.builder().height(300.0).width(400.0).build(),
                Transformation.builder().raw("rndm_trnsf-abcd").build(),
            )

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/test_path.jpg?tr=w-400,h-300:rndm_trnsf-abcd"
            )
    }

    @Test
    fun `should generate the correct URL when border transformation is applied`() {
        val transformation =
            listOf(Transformation.builder().height(300.0).width(400.0).border("20_FF0000").build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url)
            .isEqualTo(
                "https://ik.imagekit.io/test_url_endpoint/test_path.jpg?tr=w-400,h-300,b-20_FF0000"
            )
    }

    @Test
    fun `should generate the correct URL when transformation has empty key and value`() {
        val transformation = listOf(Transformation.builder().raw("").build())

        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://ik.imagekit.io/test_url_endpoint")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path.jpg")
                        .transformation(transformation)
                        .build()
                )

        assertThat(url).isEqualTo("https://ik.imagekit.io/test_url_endpoint/test_path.jpg")
    }

    @Test
    fun `should generate a valid URL when cname is used`() {
        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://custom.domain.com")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path.jpg")
                        .build()
                )

        assertThat(url).isEqualTo("https://custom.domain.com/test_path.jpg")
    }

    @Test
    fun `should generate a valid URL when cname is used with a url-pattern`() {
        val url =
            client
                .helper()
                .buildUrl(
                    SrcOptions.builder()
                        .urlEndpoint("https://custom.domain.com/url-pattern")
                        .transformationPosition(TransformationPosition.QUERY)
                        .src("/test_path.jpg")
                        .build()
                )

        assertThat(url).isEqualTo("https://custom.domain.com/url-pattern/test_path.jpg")
    }
}
