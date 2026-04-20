// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.MultipartField
import com.imagekit.api.models.ExtensionItem
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileUploadParamsTest {

    @Test
    fun create() {
        FileUploadParams.builder()
            .file("Example data".byteInputStream())
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
            .expire(0L)
            .extensions(
                listOf(
                    ExtensionItem.ofRemoveBg(
                        ExtensionItem.RemoveBg.builder()
                            .options(
                                ExtensionItem.RemoveBg.Options.builder()
                                    .addShadow(true)
                                    .bgColor("bg_color")
                                    .bgImageUrl("bg_image_url")
                                    .semitransparency(true)
                                    .build()
                            )
                            .build()
                    ),
                    ExtensionItem.ofAutoTaggingExtension(
                        ExtensionItem.AutoTaggingExtension.builder()
                            .maxTags(5L)
                            .minConfidence(95L)
                            .name(ExtensionItem.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING)
                            .build()
                    ),
                    ExtensionItem.ofAiAutoDescription(),
                    ExtensionItem.ofAiTasks(
                        ExtensionItem.AiTasks.builder()
                            .addTask(
                                ExtensionItem.AiTasks.Task.SelectTags.builder()
                                    .instruction(
                                        "What types of clothing items are visible in this image?"
                                    )
                                    .maxSelections(1L)
                                    .minSelections(0L)
                                    .vocabulary(
                                        listOf("shirt", "tshirt", "dress", "trousers", "jacket")
                                    )
                                    .build()
                            )
                            .addTask(
                                ExtensionItem.AiTasks.Task.YesNo.builder()
                                    .instruction("Is this a luxury or high-end fashion item?")
                                    .onNo(
                                        ExtensionItem.AiTasks.Task.YesNo.OnNo.builder()
                                            .addAddTag("luxury")
                                            .addAddTag("premium")
                                            .addRemoveTag("budget")
                                            .addRemoveTag("affordable")
                                            .addSetMetadata(
                                                ExtensionItem.AiTasks.Task.YesNo.OnNo.SetMetadata
                                                    .builder()
                                                    .field("price_range")
                                                    .value("premium")
                                                    .build()
                                            )
                                            .addUnsetMetadata(
                                                ExtensionItem.AiTasks.Task.YesNo.OnNo.UnsetMetadata
                                                    .builder()
                                                    .field("price_range")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .onUnknown(
                                        ExtensionItem.AiTasks.Task.YesNo.OnUnknown.builder()
                                            .addAddTag("luxury")
                                            .addAddTag("premium")
                                            .addRemoveTag("budget")
                                            .addRemoveTag("affordable")
                                            .addSetMetadata(
                                                ExtensionItem.AiTasks.Task.YesNo.OnUnknown
                                                    .SetMetadata
                                                    .builder()
                                                    .field("price_range")
                                                    .value("premium")
                                                    .build()
                                            )
                                            .addUnsetMetadata(
                                                ExtensionItem.AiTasks.Task.YesNo.OnUnknown
                                                    .UnsetMetadata
                                                    .builder()
                                                    .field("price_range")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .onYes(
                                        ExtensionItem.AiTasks.Task.YesNo.OnYes.builder()
                                            .addAddTag("luxury")
                                            .addAddTag("premium")
                                            .addRemoveTag("budget")
                                            .addRemoveTag("affordable")
                                            .addSetMetadata(
                                                ExtensionItem.AiTasks.Task.YesNo.OnYes.SetMetadata
                                                    .builder()
                                                    .field("price_range")
                                                    .value("premium")
                                                    .build()
                                            )
                                            .addUnsetMetadata(
                                                ExtensionItem.AiTasks.Task.YesNo.OnYes.UnsetMetadata
                                                    .builder()
                                                    .field("price_range")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    ),
                    ExtensionItem.ofSavedExtension(
                        ExtensionItem.SavedExtension.builder().id("ext_abc123").build()
                    ),
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
                    FileUploadParams.ResponseField.TAGS,
                    FileUploadParams.ResponseField.CUSTOM_COORDINATES,
                    FileUploadParams.ResponseField.IS_PRIVATE_FILE,
                )
            )
            .signature("signature")
            .tags(listOf("t-shirt", "round-neck", "men"))
            .transformation(
                FileUploadParams.UploadTransformation.builder()
                    .addPost(
                        FileUploadParams.UploadTransformation.Post.Thumbnail.builder()
                            .value("w-150,h-150")
                            .build()
                    )
                    .addPost(
                        FileUploadParams.UploadTransformation.Post.Abs.builder()
                            .protocol(FileUploadParams.UploadTransformation.Post.Abs.Protocol.DASH)
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
                .file("Example data".byteInputStream())
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
                .expire(0L)
                .extensions(
                    listOf(
                        ExtensionItem.ofRemoveBg(
                            ExtensionItem.RemoveBg.builder()
                                .options(
                                    ExtensionItem.RemoveBg.Options.builder()
                                        .addShadow(true)
                                        .bgColor("bg_color")
                                        .bgImageUrl("bg_image_url")
                                        .semitransparency(true)
                                        .build()
                                )
                                .build()
                        ),
                        ExtensionItem.ofAutoTaggingExtension(
                            ExtensionItem.AutoTaggingExtension.builder()
                                .maxTags(5L)
                                .minConfidence(95L)
                                .name(ExtensionItem.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING)
                                .build()
                        ),
                        ExtensionItem.ofAiAutoDescription(),
                        ExtensionItem.ofAiTasks(
                            ExtensionItem.AiTasks.builder()
                                .addTask(
                                    ExtensionItem.AiTasks.Task.SelectTags.builder()
                                        .instruction(
                                            "What types of clothing items are visible in this image?"
                                        )
                                        .maxSelections(1L)
                                        .minSelections(0L)
                                        .vocabulary(
                                            listOf("shirt", "tshirt", "dress", "trousers", "jacket")
                                        )
                                        .build()
                                )
                                .addTask(
                                    ExtensionItem.AiTasks.Task.YesNo.builder()
                                        .instruction("Is this a luxury or high-end fashion item?")
                                        .onNo(
                                            ExtensionItem.AiTasks.Task.YesNo.OnNo.builder()
                                                .addAddTag("luxury")
                                                .addAddTag("premium")
                                                .addRemoveTag("budget")
                                                .addRemoveTag("affordable")
                                                .addSetMetadata(
                                                    ExtensionItem.AiTasks.Task.YesNo.OnNo
                                                        .SetMetadata
                                                        .builder()
                                                        .field("price_range")
                                                        .value("premium")
                                                        .build()
                                                )
                                                .addUnsetMetadata(
                                                    ExtensionItem.AiTasks.Task.YesNo.OnNo
                                                        .UnsetMetadata
                                                        .builder()
                                                        .field("price_range")
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .onUnknown(
                                            ExtensionItem.AiTasks.Task.YesNo.OnUnknown.builder()
                                                .addAddTag("luxury")
                                                .addAddTag("premium")
                                                .addRemoveTag("budget")
                                                .addRemoveTag("affordable")
                                                .addSetMetadata(
                                                    ExtensionItem.AiTasks.Task.YesNo.OnUnknown
                                                        .SetMetadata
                                                        .builder()
                                                        .field("price_range")
                                                        .value("premium")
                                                        .build()
                                                )
                                                .addUnsetMetadata(
                                                    ExtensionItem.AiTasks.Task.YesNo.OnUnknown
                                                        .UnsetMetadata
                                                        .builder()
                                                        .field("price_range")
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .onYes(
                                            ExtensionItem.AiTasks.Task.YesNo.OnYes.builder()
                                                .addAddTag("luxury")
                                                .addAddTag("premium")
                                                .addRemoveTag("budget")
                                                .addRemoveTag("affordable")
                                                .addSetMetadata(
                                                    ExtensionItem.AiTasks.Task.YesNo.OnYes
                                                        .SetMetadata
                                                        .builder()
                                                        .field("price_range")
                                                        .value("premium")
                                                        .build()
                                                )
                                                .addUnsetMetadata(
                                                    ExtensionItem.AiTasks.Task.YesNo.OnYes
                                                        .UnsetMetadata
                                                        .builder()
                                                        .field("price_range")
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        ),
                        ExtensionItem.ofSavedExtension(
                            ExtensionItem.SavedExtension.builder().id("ext_abc123").build()
                        ),
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
                        FileUploadParams.ResponseField.TAGS,
                        FileUploadParams.ResponseField.CUSTOM_COORDINATES,
                        FileUploadParams.ResponseField.IS_PRIVATE_FILE,
                    )
                )
                .signature("signature")
                .tags(listOf("t-shirt", "round-neck", "men"))
                .transformation(
                    FileUploadParams.UploadTransformation.builder()
                        .addPost(
                            FileUploadParams.UploadTransformation.Post.Thumbnail.builder()
                                .value("w-150,h-150")
                                .build()
                        )
                        .addPost(
                            FileUploadParams.UploadTransformation.Post.Abs.builder()
                                .protocol(
                                    FileUploadParams.UploadTransformation.Post.Abs.Protocol.DASH
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
                        "file" to MultipartField.of("Example data".byteInputStream()),
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
                        "expire" to MultipartField.of(0L),
                        "extensions" to
                            MultipartField.of(
                                listOf(
                                    ExtensionItem.ofRemoveBg(
                                        ExtensionItem.RemoveBg.builder()
                                            .options(
                                                ExtensionItem.RemoveBg.Options.builder()
                                                    .addShadow(true)
                                                    .bgColor("bg_color")
                                                    .bgImageUrl("bg_image_url")
                                                    .semitransparency(true)
                                                    .build()
                                            )
                                            .build()
                                    ),
                                    ExtensionItem.ofAutoTaggingExtension(
                                        ExtensionItem.AutoTaggingExtension.builder()
                                            .maxTags(5L)
                                            .minConfidence(95L)
                                            .name(
                                                ExtensionItem.AutoTaggingExtension.Name
                                                    .GOOGLE_AUTO_TAGGING
                                            )
                                            .build()
                                    ),
                                    ExtensionItem.ofAiAutoDescription(),
                                    ExtensionItem.ofAiTasks(
                                        ExtensionItem.AiTasks.builder()
                                            .addTask(
                                                ExtensionItem.AiTasks.Task.SelectTags.builder()
                                                    .instruction(
                                                        "What types of clothing items are visible in this image?"
                                                    )
                                                    .maxSelections(1L)
                                                    .minSelections(0L)
                                                    .vocabulary(
                                                        listOf(
                                                            "shirt",
                                                            "tshirt",
                                                            "dress",
                                                            "trousers",
                                                            "jacket",
                                                        )
                                                    )
                                                    .build()
                                            )
                                            .addTask(
                                                ExtensionItem.AiTasks.Task.YesNo.builder()
                                                    .instruction(
                                                        "Is this a luxury or high-end fashion item?"
                                                    )
                                                    .onNo(
                                                        ExtensionItem.AiTasks.Task.YesNo.OnNo
                                                            .builder()
                                                            .addAddTag("luxury")
                                                            .addAddTag("premium")
                                                            .addRemoveTag("budget")
                                                            .addRemoveTag("affordable")
                                                            .addSetMetadata(
                                                                ExtensionItem.AiTasks.Task.YesNo
                                                                    .OnNo
                                                                    .SetMetadata
                                                                    .builder()
                                                                    .field("price_range")
                                                                    .value("premium")
                                                                    .build()
                                                            )
                                                            .addUnsetMetadata(
                                                                ExtensionItem.AiTasks.Task.YesNo
                                                                    .OnNo
                                                                    .UnsetMetadata
                                                                    .builder()
                                                                    .field("price_range")
                                                                    .build()
                                                            )
                                                            .build()
                                                    )
                                                    .onUnknown(
                                                        ExtensionItem.AiTasks.Task.YesNo.OnUnknown
                                                            .builder()
                                                            .addAddTag("luxury")
                                                            .addAddTag("premium")
                                                            .addRemoveTag("budget")
                                                            .addRemoveTag("affordable")
                                                            .addSetMetadata(
                                                                ExtensionItem.AiTasks.Task.YesNo
                                                                    .OnUnknown
                                                                    .SetMetadata
                                                                    .builder()
                                                                    .field("price_range")
                                                                    .value("premium")
                                                                    .build()
                                                            )
                                                            .addUnsetMetadata(
                                                                ExtensionItem.AiTasks.Task.YesNo
                                                                    .OnUnknown
                                                                    .UnsetMetadata
                                                                    .builder()
                                                                    .field("price_range")
                                                                    .build()
                                                            )
                                                            .build()
                                                    )
                                                    .onYes(
                                                        ExtensionItem.AiTasks.Task.YesNo.OnYes
                                                            .builder()
                                                            .addAddTag("luxury")
                                                            .addAddTag("premium")
                                                            .addRemoveTag("budget")
                                                            .addRemoveTag("affordable")
                                                            .addSetMetadata(
                                                                ExtensionItem.AiTasks.Task.YesNo
                                                                    .OnYes
                                                                    .SetMetadata
                                                                    .builder()
                                                                    .field("price_range")
                                                                    .value("premium")
                                                                    .build()
                                                            )
                                                            .addUnsetMetadata(
                                                                ExtensionItem.AiTasks.Task.YesNo
                                                                    .OnYes
                                                                    .UnsetMetadata
                                                                    .builder()
                                                                    .field("price_range")
                                                                    .build()
                                                            )
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    ),
                                    ExtensionItem.ofSavedExtension(
                                        ExtensionItem.SavedExtension.builder()
                                            .id("ext_abc123")
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
                        "publicKey" to MultipartField.of("publicKey"),
                        "responseFields" to
                            MultipartField.of(
                                listOf(
                                    FileUploadParams.ResponseField.TAGS,
                                    FileUploadParams.ResponseField.CUSTOM_COORDINATES,
                                    FileUploadParams.ResponseField.IS_PRIVATE_FILE,
                                )
                            ),
                        "signature" to MultipartField.of("signature"),
                        "tags" to MultipartField.of(listOf("t-shirt", "round-neck", "men")),
                        "transformation" to
                            MultipartField.of(
                                FileUploadParams.UploadTransformation.builder()
                                    .addPost(
                                        FileUploadParams.UploadTransformation.Post.Thumbnail
                                            .builder()
                                            .value("w-150,h-150")
                                            .build()
                                    )
                                    .addPost(
                                        FileUploadParams.UploadTransformation.Post.Abs.builder()
                                            .protocol(
                                                FileUploadParams.UploadTransformation.Post.Abs
                                                    .Protocol
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
                .file("Example data".byteInputStream())
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
                        "file" to MultipartField.of("Example data".byteInputStream()),
                        "fileName" to MultipartField.of("fileName"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
