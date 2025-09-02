// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.MultipartField
import java.io.InputStream
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileUploadParamsTest {

    @Test
    fun create() {
        FileUploadParams.builder()
            .body(
                FileUploadParams.Body.FileUploadV1.builder()
                    .file("some content".byteInputStream())
                    .fileName("fileName")
                    .token("token")
                    .checks("\"request.folder\" : \"marketing/\"\n")
                    .customCoordinates("customCoordinates")
                    .customMetadata(
                        FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                            .putAdditionalProperty("brand", JsonValue.from("bar"))
                            .putAdditionalProperty("color", JsonValue.from("bar"))
                            .build()
                    )
                    .description("Running shoes")
                    .expire(0L)
                    .extensions(
                        listOf(
                            FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                FileUploadParams.Body.FileUploadV1.Extension.RemoveBg.builder()
                                    .options(
                                        FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                            .Options
                                            .builder()
                                            .addShadow(true)
                                            .bgColor("bg_color")
                                            .bgImageUrl("bg_image_url")
                                            .semitransparency(true)
                                            .build()
                                    )
                                    .build()
                            ),
                            FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                FileUploadParams.Body.FileUploadV1.Extension.AutoTaggingExtension
                                    .builder()
                                    .maxTags(5L)
                                    .minConfidence(95L)
                                    .name(
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .AutoTaggingExtension
                                            .Name
                                            .GOOGLE_AUTO_TAGGING
                                    )
                                    .build()
                            ),
                            FileUploadParams.Body.FileUploadV1.Extension.ofAiAutoDescription(),
                        )
                    )
                    .folder("folder")
                    .isPrivateFile(true)
                    .isPublished(true)
                    .overwriteAiTags(true)
                    .overwriteCustomMetadata(true)
                    .overwriteFile(true)
                    .overwriteTags(true)
                    .publicKey("publicKey")
                    .responseFields(
                        listOf(
                            FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                            FileUploadParams.Body.FileUploadV1.ResponseField.CUSTOM_COORDINATES,
                            FileUploadParams.Body.FileUploadV1.ResponseField.IS_PRIVATE_FILE,
                        )
                    )
                    .signature("signature")
                    .tags(listOf("t-shirt", "round-neck", "men"))
                    .transformation(
                        FileUploadParams.Body.FileUploadV1.Transformation.builder()
                            .addPost(
                                FileUploadParams.Body.FileUploadV1.Transformation.Post.Thumbnail
                                    .builder()
                                    .value("w-150,h-150")
                                    .build()
                            )
                            .addPost(
                                FileUploadParams.Body.FileUploadV1.Transformation.Post.Abs.builder()
                                    .protocol(
                                        FileUploadParams.Body.FileUploadV1.Transformation.Post.Abs
                                            .Protocol
                                            .DASH
                                    )
                                    .value("sr-240_360_480_720_1080")
                                    .build()
                            )
                            .pre("w-300,h-300,q-80")
                            .build()
                    )
                    .useUniqueFileName(true)
                    .webhookUrl("https://example.com")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            FileUploadParams.builder()
                .body(
                    FileUploadParams.Body.FileUploadV1.builder()
                        .file("some content".byteInputStream())
                        .fileName("fileName")
                        .token("token")
                        .checks("\"request.folder\" : \"marketing/\"\n")
                        .customCoordinates("customCoordinates")
                        .customMetadata(
                            FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                .putAdditionalProperty("brand", JsonValue.from("bar"))
                                .putAdditionalProperty("color", JsonValue.from("bar"))
                                .build()
                        )
                        .description("Running shoes")
                        .expire(0L)
                        .extensions(
                            listOf(
                                FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                    FileUploadParams.Body.FileUploadV1.Extension.RemoveBg.builder()
                                        .options(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .Options
                                                .builder()
                                                .addShadow(true)
                                                .bgColor("bg_color")
                                                .bgImageUrl("bg_image_url")
                                                .semitransparency(true)
                                                .build()
                                        )
                                        .build()
                                ),
                                FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                    FileUploadParams.Body.FileUploadV1.Extension
                                        .AutoTaggingExtension
                                        .builder()
                                        .maxTags(5L)
                                        .minConfidence(95L)
                                        .name(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .Name
                                                .GOOGLE_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                FileUploadParams.Body.FileUploadV1.Extension.ofAiAutoDescription(),
                            )
                        )
                        .folder("folder")
                        .isPrivateFile(true)
                        .isPublished(true)
                        .overwriteAiTags(true)
                        .overwriteCustomMetadata(true)
                        .overwriteFile(true)
                        .overwriteTags(true)
                        .publicKey("publicKey")
                        .responseFields(
                            listOf(
                                FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                FileUploadParams.Body.FileUploadV1.ResponseField.CUSTOM_COORDINATES,
                                FileUploadParams.Body.FileUploadV1.ResponseField.IS_PRIVATE_FILE,
                            )
                        )
                        .signature("signature")
                        .tags(listOf("t-shirt", "round-neck", "men"))
                        .transformation(
                            FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                .addPost(
                                    FileUploadParams.Body.FileUploadV1.Transformation.Post.Thumbnail
                                        .builder()
                                        .value("w-150,h-150")
                                        .build()
                                )
                                .addPost(
                                    FileUploadParams.Body.FileUploadV1.Transformation.Post.Abs
                                        .builder()
                                        .protocol(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .Protocol
                                                .DASH
                                        )
                                        .value("sr-240_360_480_720_1080")
                                        .build()
                                )
                                .pre("w-300,h-300,q-80")
                                .build()
                        )
                        .useUniqueFileName(true)
                        .webhookUrl("https://example.com")
                        .build()
                )
                .build()

        val body = params._body().getOrNull()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf(
                        "body" to
                            MultipartField.builder<FileUploadParams.Body>()
                                .value(
                                    FileUploadParams.Body.ofFileUploadV1(
                                        FileUploadParams.Body.FileUploadV1.builder()
                                            .file("some content".byteInputStream())
                                            .fileName("fileName")
                                            .token("token")
                                            .checks("\"request.folder\" : \"marketing/\"\n")
                                            .customCoordinates("customCoordinates")
                                            .customMetadata(
                                                FileUploadParams.Body.FileUploadV1.CustomMetadata
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "brand",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .putAdditionalProperty(
                                                        "color",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .description("Running shoes")
                                            .expire(0L)
                                            .extensions(
                                                listOf(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .ofRemoveBg(
                                                            FileUploadParams.Body.FileUploadV1
                                                                .Extension
                                                                .RemoveBg
                                                                .builder()
                                                                .options(
                                                                    FileUploadParams.Body
                                                                        .FileUploadV1
                                                                        .Extension
                                                                        .RemoveBg
                                                                        .Options
                                                                        .builder()
                                                                        .addShadow(true)
                                                                        .bgColor("bg_color")
                                                                        .bgImageUrl("bg_image_url")
                                                                        .semitransparency(true)
                                                                        .build()
                                                                )
                                                                .build()
                                                        ),
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .ofAutoTagging(
                                                            FileUploadParams.Body.FileUploadV1
                                                                .Extension
                                                                .AutoTaggingExtension
                                                                .builder()
                                                                .maxTags(5L)
                                                                .minConfidence(95L)
                                                                .name(
                                                                    FileUploadParams.Body
                                                                        .FileUploadV1
                                                                        .Extension
                                                                        .AutoTaggingExtension
                                                                        .Name
                                                                        .GOOGLE_AUTO_TAGGING
                                                                )
                                                                .build()
                                                        ),
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .ofAiAutoDescription(),
                                                )
                                            )
                                            .folder("folder")
                                            .isPrivateFile(true)
                                            .isPublished(true)
                                            .overwriteAiTags(true)
                                            .overwriteCustomMetadata(true)
                                            .overwriteFile(true)
                                            .overwriteTags(true)
                                            .publicKey("publicKey")
                                            .responseFields(
                                                listOf(
                                                    FileUploadParams.Body.FileUploadV1.ResponseField
                                                        .TAGS,
                                                    FileUploadParams.Body.FileUploadV1.ResponseField
                                                        .CUSTOM_COORDINATES,
                                                    FileUploadParams.Body.FileUploadV1.ResponseField
                                                        .IS_PRIVATE_FILE,
                                                )
                                            )
                                            .signature("signature")
                                            .tags(listOf("t-shirt", "round-neck", "men"))
                                            .transformation(
                                                FileUploadParams.Body.FileUploadV1.Transformation
                                                    .builder()
                                                    .addPost(
                                                        FileUploadParams.Body.FileUploadV1
                                                            .Transformation
                                                            .Post
                                                            .Thumbnail
                                                            .builder()
                                                            .value("w-150,h-150")
                                                            .build()
                                                    )
                                                    .addPost(
                                                        FileUploadParams.Body.FileUploadV1
                                                            .Transformation
                                                            .Post
                                                            .Abs
                                                            .builder()
                                                            .protocol(
                                                                FileUploadParams.Body.FileUploadV1
                                                                    .Transformation
                                                                    .Post
                                                                    .Abs
                                                                    .Protocol
                                                                    .DASH
                                                            )
                                                            .value("sr-240_360_480_720_1080")
                                                            .build()
                                                    )
                                                    .pre("w-300,h-300,q-80")
                                                    .build()
                                            )
                                            .useUniqueFileName(true)
                                            .webhookUrl("https://example.com")
                                            .build()
                                    )
                                )
                                .contentType("application/octet-stream")
                                .build()
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = FileUploadParams.builder().build()

        val body = params._body().getOrNull()

        assertThat(body.filterValues { !it.value.isNull() }).isEmpty()
    }
}
