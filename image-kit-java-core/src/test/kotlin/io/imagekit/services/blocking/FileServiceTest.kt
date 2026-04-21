// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import io.imagekit.core.JsonValue
import io.imagekit.models.ExtensionItem
import io.imagekit.models.files.FileCopyParams
import io.imagekit.models.files.FileMoveParams
import io.imagekit.models.files.FileRenameParams
import io.imagekit.models.files.FileUpdateParams
import io.imagekit.models.files.FileUploadParams
import io.imagekit.models.files.UpdateFileRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FileServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val file =
            fileService.update(
                FileUpdateParams.builder()
                    .fileId("fileId")
                    .updateFileRequest(
                        UpdateFileRequest.UpdateFileDetails.builder()
                            .customCoordinates("10,10,100,100")
                            .customMetadata(
                                UpdateFileRequest.UpdateFileDetails.CustomMetadata.builder()
                                    .putAdditionalProperty("brand", JsonValue.from("bar"))
                                    .putAdditionalProperty("color", JsonValue.from("bar"))
                                    .build()
                            )
                            .description("description")
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
                                            .maxTags(10L)
                                            .minConfidence(80L)
                                            .name(
                                                ExtensionItem.AutoTaggingExtension.Name
                                                    .GOOGLE_AUTO_TAGGING
                                            )
                                            .build()
                                    ),
                                    ExtensionItem.ofAutoTaggingExtension(
                                        ExtensionItem.AutoTaggingExtension.builder()
                                            .maxTags(10L)
                                            .minConfidence(80L)
                                            .name(
                                                ExtensionItem.AutoTaggingExtension.Name
                                                    .AWS_AUTO_TAGGING
                                            )
                                            .build()
                                    ),
                                    ExtensionItem.ofAiAutoDescription(),
                                    ExtensionItem.ofAiTasks(
                                        ExtensionItem.AiTasks.builder()
                                            .addTask(
                                                ExtensionItem.AiTasks.Task.SelectTags.builder()
                                                    .instruction(
                                                        "What types of clothing items are visible?"
                                                    )
                                                    .maxSelections(1L)
                                                    .minSelections(0L)
                                                    .vocabulary(listOf("shirt", "dress", "jacket"))
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
                            )
                            .removeAiTagsOfStrings(listOf("car", "vehicle", "motorsports"))
                            .addTag("tag1")
                            .addTag("tag2")
                            .webhookUrl("https://webhook.site/0d6b6c7a-8e5a-4b3a-8b7c-0d6b6c7a8e5a")
                            .build()
                    )
                    .build()
            )

        file.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        fileService.delete("fileId")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun copy() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val response =
            fileService.copy(
                FileCopyParams.builder()
                    .destinationPath("/folder/to/copy/into/")
                    .sourceFilePath("/path/to/file.jpg")
                    .includeFileVersions(false)
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val file = fileService.get("fileId")

        file.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun move() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val response =
            fileService.move(
                FileMoveParams.builder()
                    .destinationPath("/folder/to/move/into/")
                    .sourceFilePath("/path/to/file.jpg")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun rename() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val response =
            fileService.rename(
                FileRenameParams.builder()
                    .filePath("/path/to/file.jpg")
                    .newFileName("newFileName.jpg")
                    .purgeCache(true)
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun upload() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val response =
            fileService.upload(
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
                                    .name(
                                        ExtensionItem.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING
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
            )

        response.validate()
    }
}
