// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.imagekit.api.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileUploadV1ParamsTest {

    @Test
    fun create() {
        FileUploadV1Params.builder()
            .file("https://www.example.com/rest-of-the-image-path.jpg")
            .fileName("fileName")
            .token("token")
            .checks("\"request.folder\" : \"marketing/\"\n")
            .customCoordinates("customCoordinates")
            .customMetadata("\"\n  {\n    \"brand\": \"Nike\",\n    \"color\":\"red\"\n  }\n\"\n")
            .expire("expire")
            .extensions(
                "\"\n[\n  {\"name\":\"remove-bg\",\"options\":{\"add_shadow\":true,\"bg_colour\":\"green\"}},\n  {\"name\":\"google-auto-tagging\",\"maxTags\":5,\"minConfidence\":95}\n]\n\"\n"
            )
            .folder("folder")
            .isPrivateFile(FileUploadV1Params.IsPrivateFile.TRUE)
            .isPublished(FileUploadV1Params.IsPublished.TRUE)
            .overwriteAiTags(FileUploadV1Params.OverwriteAiTags.TRUE)
            .overwriteCustomMetadata(FileUploadV1Params.OverwriteCustomMetadata.TRUE)
            .overwriteFile("overwriteFile")
            .overwriteTags(FileUploadV1Params.OverwriteTags.TRUE)
            .publicKey("publicKey")
            .responseFields("responseFields")
            .signature("signature")
            .tags("t-shirt,round-neck,men")
            .transformation(
                "'{\"pre\":\"width:300,height:300,quality:80\",\"post\":[{\"type\":\"thumbnail\",\"value\":\"width:100,height:100\"}]}'\n"
            )
            .useUniqueFileName(FileUploadV1Params.UseUniqueFileName.TRUE)
            .webhookUrl("webhookUrl")
            .build()
    }

    @Test
    fun body() {
        val params =
            FileUploadV1Params.builder()
                .file("https://www.example.com/rest-of-the-image-path.jpg")
                .fileName("fileName")
                .token("token")
                .checks("\"request.folder\" : \"marketing/\"\n")
                .customCoordinates("customCoordinates")
                .customMetadata(
                    "\"\n  {\n    \"brand\": \"Nike\",\n    \"color\":\"red\"\n  }\n\"\n"
                )
                .expire("expire")
                .extensions(
                    "\"\n[\n  {\"name\":\"remove-bg\",\"options\":{\"add_shadow\":true,\"bg_colour\":\"green\"}},\n  {\"name\":\"google-auto-tagging\",\"maxTags\":5,\"minConfidence\":95}\n]\n\"\n"
                )
                .folder("folder")
                .isPrivateFile(FileUploadV1Params.IsPrivateFile.TRUE)
                .isPublished(FileUploadV1Params.IsPublished.TRUE)
                .overwriteAiTags(FileUploadV1Params.OverwriteAiTags.TRUE)
                .overwriteCustomMetadata(FileUploadV1Params.OverwriteCustomMetadata.TRUE)
                .overwriteFile("overwriteFile")
                .overwriteTags(FileUploadV1Params.OverwriteTags.TRUE)
                .publicKey("publicKey")
                .responseFields("responseFields")
                .signature("signature")
                .tags("t-shirt,round-neck,men")
                .transformation(
                    "'{\"pre\":\"width:300,height:300,quality:80\",\"post\":[{\"type\":\"thumbnail\",\"value\":\"width:100,height:100\"}]}'\n"
                )
                .useUniqueFileName(FileUploadV1Params.UseUniqueFileName.TRUE)
                .webhookUrl("webhookUrl")
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
                        "file" to
                            MultipartField.of("https://www.example.com/rest-of-the-image-path.jpg"),
                        "fileName" to MultipartField.of("fileName"),
                        "token" to MultipartField.of("token"),
                        "checks" to MultipartField.of("\"request.folder\" : \"marketing/\"\n"),
                        "customCoordinates" to MultipartField.of("customCoordinates"),
                        "customMetadata" to
                            MultipartField.of(
                                "\"\n  {\n    \"brand\": \"Nike\",\n    \"color\":\"red\"\n  }\n\"\n"
                            ),
                        "expire" to MultipartField.of("expire"),
                        "extensions" to
                            MultipartField.of(
                                "\"\n[\n  {\"name\":\"remove-bg\",\"options\":{\"add_shadow\":true,\"bg_colour\":\"green\"}},\n  {\"name\":\"google-auto-tagging\",\"maxTags\":5,\"minConfidence\":95}\n]\n\"\n"
                            ),
                        "folder" to MultipartField.of("folder"),
                        "isPrivateFile" to MultipartField.of(FileUploadV1Params.IsPrivateFile.TRUE),
                        "isPublished" to MultipartField.of(FileUploadV1Params.IsPublished.TRUE),
                        "overwriteAITags" to
                            MultipartField.of(FileUploadV1Params.OverwriteAiTags.TRUE),
                        "overwriteCustomMetadata" to
                            MultipartField.of(FileUploadV1Params.OverwriteCustomMetadata.TRUE),
                        "overwriteFile" to MultipartField.of("overwriteFile"),
                        "overwriteTags" to MultipartField.of(FileUploadV1Params.OverwriteTags.TRUE),
                        "publicKey" to MultipartField.of("publicKey"),
                        "responseFields" to MultipartField.of("responseFields"),
                        "signature" to MultipartField.of("signature"),
                        "tags" to MultipartField.of("t-shirt,round-neck,men"),
                        "transformation" to
                            MultipartField.of(
                                "'{\"pre\":\"width:300,height:300,quality:80\",\"post\":[{\"type\":\"thumbnail\",\"value\":\"width:100,height:100\"}]}'\n"
                            ),
                        "useUniqueFileName" to
                            MultipartField.of(FileUploadV1Params.UseUniqueFileName.TRUE),
                        "webhookUrl" to MultipartField.of("webhookUrl"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FileUploadV1Params.builder()
                .file("https://www.example.com/rest-of-the-image-path.jpg")
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
                        "file" to
                            MultipartField.of("https://www.example.com/rest-of-the-image-path.jpg"),
                        "fileName" to MultipartField.of("fileName"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
