// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.beta.v2.files

import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileUploadParamsTest {

    @Test
    fun create() {
        FileUploadParams.builder()
            .file("some content".byteInputStream())
            .fileName("fileName")
            .token("token")
            .checks("\"request.folder\" : \"marketing/\"\n")
            .customCoordinates("customCoordinates")
            .customMetadata(
                FileUploadParams.CustomMetadata.builder()
                    .putAdditionalProperty("brand", JsonValue.from("bar"))
                    .putAdditionalProperty("color", JsonValue.from("bar"))
                    .build()
            )
            .description("Running shoes")
            .addExtension(
                FileUploadParams.Extension.RemoveBg.builder()
                    .options(
                        FileUploadParams.Extension.RemoveBg.Options.builder()
                            .addShadow(true)
                            .bgColor("bg_color")
                            .bgImageUrl("bg_image_url")
                            .semitransparency(true)
                            .build()
                    )
                    .build()
            )
            .addExtension(
                FileUploadParams.Extension.AutoTaggingExtension.builder()
                    .maxTags(5L)
                    .minConfidence(95L)
                    .name(FileUploadParams.Extension.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING)
                    .build()
            )
            .folder("folder")
            .isPrivateFile(true)
            .isPublished(true)
            .overwriteAiTags(true)
            .overwriteCustomMetadata(true)
            .overwriteFile(true)
            .overwriteTags(true)
            .responseFields(
                listOf(
                    FileUploadParams.ResponseField.TAGS,
                    FileUploadParams.ResponseField.CUSTOM_COORDINATES,
                    FileUploadParams.ResponseField.IS_PRIVATE_FILE,
                )
            )
            .tags(listOf("t-shirt", "round-neck", "men"))
            .transformation(
                FileUploadParams.Transformation.builder()
                    .addPost(
                        FileUploadParams.Transformation.Post.Thumbnail.builder()
                            .value("w-150,h-150")
                            .build()
                    )
                    .addPost(
                        FileUploadParams.Transformation.Post.Abs.builder()
                            .protocol(FileUploadParams.Transformation.Post.Abs.Protocol.DASH)
                            .value("sr-240_360_480_720_1080")
                            .build()
                    )
                    .pre("w-300,h-300,q-80")
                    .build()
            )
            .useUniqueFileName(true)
            .webhookUrl("https://example.com")
            .build()
    }

    @Test
    fun body() {
        val params =
            FileUploadParams.builder()
                .file("some content".byteInputStream())
                .fileName("fileName")
                .token("token")
                .checks("\"request.folder\" : \"marketing/\"\n")
                .customCoordinates("customCoordinates")
                .customMetadata(
                    FileUploadParams.CustomMetadata.builder()
                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                        .putAdditionalProperty("color", JsonValue.from("bar"))
                        .build()
                )
                .description("Running shoes")
                .addExtension(
                    FileUploadParams.Extension.RemoveBg.builder()
                        .options(
                            FileUploadParams.Extension.RemoveBg.Options.builder()
                                .addShadow(true)
                                .bgColor("bg_color")
                                .bgImageUrl("bg_image_url")
                                .semitransparency(true)
                                .build()
                        )
                        .build()
                )
                .addExtension(
                    FileUploadParams.Extension.AutoTaggingExtension.builder()
                        .maxTags(5L)
                        .minConfidence(95L)
                        .name(
                            FileUploadParams.Extension.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING
                        )
                        .build()
                )
                .folder("folder")
                .isPrivateFile(true)
                .isPublished(true)
                .overwriteAiTags(true)
                .overwriteCustomMetadata(true)
                .overwriteFile(true)
                .overwriteTags(true)
                .responseFields(
                    listOf(
                        FileUploadParams.ResponseField.TAGS,
                        FileUploadParams.ResponseField.CUSTOM_COORDINATES,
                        FileUploadParams.ResponseField.IS_PRIVATE_FILE,
                    )
                )
                .tags(listOf("t-shirt", "round-neck", "men"))
                .transformation(
                    FileUploadParams.Transformation.builder()
                        .addPost(
                            FileUploadParams.Transformation.Post.Thumbnail.builder()
                                .value("w-150,h-150")
                                .build()
                        )
                        .addPost(
                            FileUploadParams.Transformation.Post.Abs.builder()
                                .protocol(FileUploadParams.Transformation.Post.Abs.Protocol.DASH)
                                .value("sr-240_360_480_720_1080")
                                .build()
                        )
                        .pre("w-300,h-300,q-80")
                        .build()
                )
                .useUniqueFileName(true)
                .webhookUrl("https://example.com")
                .build()

        val body = params._body()

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
                        "file" to MultipartField.of("some content".byteInputStream()),
                        "fileName" to MultipartField.of("fileName"),
                        "token" to MultipartField.of("token"),
                        "checks" to MultipartField.of("\"request.folder\" : \"marketing/\"\n"),
                        "customCoordinates" to MultipartField.of("customCoordinates"),
                        "customMetadata" to
                            MultipartField.of(
                                FileUploadParams.CustomMetadata.builder()
                                    .putAdditionalProperty("brand", JsonValue.from("bar"))
                                    .putAdditionalProperty("color", JsonValue.from("bar"))
                                    .build()
                            ),
                        "description" to MultipartField.of("Running shoes"),
                        "extensions" to
                            MultipartField.of(
                                listOf(
                                    FileUploadParams.Extension.ofRemoveBg(
                                        FileUploadParams.Extension.RemoveBg.builder()
                                            .options(
                                                FileUploadParams.Extension.RemoveBg.Options
                                                    .builder()
                                                    .addShadow(true)
                                                    .bgColor("bg_color")
                                                    .bgImageUrl("bg_image_url")
                                                    .semitransparency(true)
                                                    .build()
                                            )
                                            .build()
                                    ),
                                    FileUploadParams.Extension.ofAutoTagging(
                                        FileUploadParams.Extension.AutoTaggingExtension.builder()
                                            .maxTags(5L)
                                            .minConfidence(95L)
                                            .name(
                                                FileUploadParams.Extension.AutoTaggingExtension.Name
                                                    .GOOGLE_AUTO_TAGGING
                                            )
                                            .build()
                                    ),
                                )
                            ),
                        "folder" to MultipartField.of("folder"),
                        "isPrivateFile" to MultipartField.of(true),
                        "isPublished" to MultipartField.of(true),
                        "overwriteAITags" to MultipartField.of(true),
                        "overwriteCustomMetadata" to MultipartField.of(true),
                        "overwriteFile" to MultipartField.of(true),
                        "overwriteTags" to MultipartField.of(true),
                        "responseFields" to
                            MultipartField.of(
                                listOf(
                                    FileUploadParams.ResponseField.TAGS,
                                    FileUploadParams.ResponseField.CUSTOM_COORDINATES,
                                    FileUploadParams.ResponseField.IS_PRIVATE_FILE,
                                )
                            ),
                        "tags" to MultipartField.of(listOf("t-shirt", "round-neck", "men")),
                        "transformation" to
                            MultipartField.of(
                                FileUploadParams.Transformation.builder()
                                    .addPost(
                                        FileUploadParams.Transformation.Post.Thumbnail.builder()
                                            .value("w-150,h-150")
                                            .build()
                                    )
                                    .addPost(
                                        FileUploadParams.Transformation.Post.Abs.builder()
                                            .protocol(
                                                FileUploadParams.Transformation.Post.Abs.Protocol
                                                    .DASH
                                            )
                                            .value("sr-240_360_480_720_1080")
                                            .build()
                                    )
                                    .pre("w-300,h-300,q-80")
                                    .build()
                            ),
                        "useUniqueFileName" to MultipartField.of(true),
                        "webhookUrl" to MultipartField.of("https://example.com"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FileUploadParams.builder()
                .file("some content".byteInputStream())
                .fileName("fileName")
                .build()

        val body = params._body()

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
                        "file" to MultipartField.of("some content".byteInputStream()),
                        "fileName" to MultipartField.of("fileName"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
