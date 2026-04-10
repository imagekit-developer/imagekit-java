// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.UnnamedSchemaWithArrayParent4
import com.imagekit.api.models.files.FileCopyParams
import com.imagekit.api.models.files.FileMoveParams
import com.imagekit.api.models.files.FileRenameParams
import com.imagekit.api.models.files.FileUpdateParams
import com.imagekit.api.models.files.FileUploadParams
import com.imagekit.api.models.files.UpdateFileRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FileServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val fileFuture =
            fileServiceAsync.update(
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
                                    UnnamedSchemaWithArrayParent4.ofRemoveBg(
                                        UnnamedSchemaWithArrayParent4.RemoveBg.builder()
                                            .options(
                                                UnnamedSchemaWithArrayParent4.RemoveBg.Options
                                                    .builder()
                                                    .addShadow(true)
                                                    .bgColor("bg_color")
                                                    .bgImageUrl("bg_image_url")
                                                    .semitransparency(true)
                                                    .build()
                                            )
                                            .build()
                                    ),
                                    UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(
                                        UnnamedSchemaWithArrayParent4.AutoTaggingExtension.builder()
                                            .maxTags(10L)
                                            .minConfidence(80L)
                                            .name(
                                                UnnamedSchemaWithArrayParent4.AutoTaggingExtension
                                                    .Name
                                                    .GOOGLE_AUTO_TAGGING
                                            )
                                            .build()
                                    ),
                                    UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(
                                        UnnamedSchemaWithArrayParent4.AutoTaggingExtension.builder()
                                            .maxTags(10L)
                                            .minConfidence(80L)
                                            .name(
                                                UnnamedSchemaWithArrayParent4.AutoTaggingExtension
                                                    .Name
                                                    .AWS_AUTO_TAGGING
                                            )
                                            .build()
                                    ),
                                    UnnamedSchemaWithArrayParent4.ofAiAutoDescription(),
                                    UnnamedSchemaWithArrayParent4.ofAiTasks(
                                        UnnamedSchemaWithArrayParent4.AiTasks.builder()
                                            .addTask(
                                                UnnamedSchemaWithArrayParent4.AiTasks.Task
                                                    .SelectTags
                                                    .builder()
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
                                    UnnamedSchemaWithArrayParent4.ofSavedExtension(
                                        UnnamedSchemaWithArrayParent4.SavedExtension.builder()
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

        val file = fileFuture.get()
        file.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val future = fileServiceAsync.delete("fileId")

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun copy() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val responseFuture =
            fileServiceAsync.copy(
                FileCopyParams.builder()
                    .destinationPath("/folder/to/copy/into/")
                    .sourceFilePath("/path/to/file.jpg")
                    .includeFileVersions(false)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val fileFuture = fileServiceAsync.get("fileId")

        val file = fileFuture.get()
        file.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun move() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val responseFuture =
            fileServiceAsync.move(
                FileMoveParams.builder()
                    .destinationPath("/folder/to/move/into/")
                    .sourceFilePath("/path/to/file.jpg")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun rename() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val responseFuture =
            fileServiceAsync.rename(
                FileRenameParams.builder()
                    .filePath("/path/to/file.jpg")
                    .newFileName("newFileName.jpg")
                    .purgeCache(true)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun upload() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val responseFuture =
            fileServiceAsync.upload(
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
                            UnnamedSchemaWithArrayParent4.ofRemoveBg(
                                UnnamedSchemaWithArrayParent4.RemoveBg.builder()
                                    .options(
                                        UnnamedSchemaWithArrayParent4.RemoveBg.Options.builder()
                                            .addShadow(true)
                                            .bgColor("bg_color")
                                            .bgImageUrl("bg_image_url")
                                            .semitransparency(true)
                                            .build()
                                    )
                                    .build()
                            ),
                            UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(
                                UnnamedSchemaWithArrayParent4.AutoTaggingExtension.builder()
                                    .maxTags(5L)
                                    .minConfidence(95L)
                                    .name(
                                        UnnamedSchemaWithArrayParent4.AutoTaggingExtension.Name
                                            .GOOGLE_AUTO_TAGGING
                                    )
                                    .build()
                            ),
                            UnnamedSchemaWithArrayParent4.ofAiAutoDescription(),
                            UnnamedSchemaWithArrayParent4.ofAiTasks(
                                UnnamedSchemaWithArrayParent4.AiTasks.builder()
                                    .addTask(
                                        UnnamedSchemaWithArrayParent4.AiTasks.Task.SelectTags
                                            .builder()
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
                                        UnnamedSchemaWithArrayParent4.AiTasks.Task.YesNo.builder()
                                            .instruction(
                                                "Is this a luxury or high-end fashion item?"
                                            )
                                            .onNo(
                                                UnnamedSchemaWithArrayParent4.AiTasks.Task.YesNo
                                                    .OnNo
                                                    .builder()
                                                    .addAddTag("luxury")
                                                    .addAddTag("premium")
                                                    .addRemoveTag("budget")
                                                    .addRemoveTag("affordable")
                                                    .addSetMetadata(
                                                        UnnamedSchemaWithArrayParent4.AiTasks.Task
                                                            .YesNo
                                                            .OnNo
                                                            .SetMetadata
                                                            .builder()
                                                            .field("price_range")
                                                            .value("premium")
                                                            .build()
                                                    )
                                                    .addUnsetMetadata(
                                                        UnnamedSchemaWithArrayParent4.AiTasks.Task
                                                            .YesNo
                                                            .OnNo
                                                            .UnsetMetadata
                                                            .builder()
                                                            .field("price_range")
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .onUnknown(
                                                UnnamedSchemaWithArrayParent4.AiTasks.Task.YesNo
                                                    .OnUnknown
                                                    .builder()
                                                    .addAddTag("luxury")
                                                    .addAddTag("premium")
                                                    .addRemoveTag("budget")
                                                    .addRemoveTag("affordable")
                                                    .addSetMetadata(
                                                        UnnamedSchemaWithArrayParent4.AiTasks.Task
                                                            .YesNo
                                                            .OnUnknown
                                                            .SetMetadata
                                                            .builder()
                                                            .field("price_range")
                                                            .value("premium")
                                                            .build()
                                                    )
                                                    .addUnsetMetadata(
                                                        UnnamedSchemaWithArrayParent4.AiTasks.Task
                                                            .YesNo
                                                            .OnUnknown
                                                            .UnsetMetadata
                                                            .builder()
                                                            .field("price_range")
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .onYes(
                                                UnnamedSchemaWithArrayParent4.AiTasks.Task.YesNo
                                                    .OnYes
                                                    .builder()
                                                    .addAddTag("luxury")
                                                    .addAddTag("premium")
                                                    .addRemoveTag("budget")
                                                    .addRemoveTag("affordable")
                                                    .addSetMetadata(
                                                        UnnamedSchemaWithArrayParent4.AiTasks.Task
                                                            .YesNo
                                                            .OnYes
                                                            .SetMetadata
                                                            .builder()
                                                            .field("price_range")
                                                            .value("premium")
                                                            .build()
                                                    )
                                                    .addUnsetMetadata(
                                                        UnnamedSchemaWithArrayParent4.AiTasks.Task
                                                            .YesNo
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
                            UnnamedSchemaWithArrayParent4.ofSavedExtension(
                                UnnamedSchemaWithArrayParent4.SavedExtension.builder()
                                    .id("ext_abc123")
                                    .build()
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
                        FileUploadParams.Transformation.builder()
                            .addPost(
                                FileUploadParams.Transformation.Post.Thumbnail.builder()
                                    .value("w-150,h-150")
                                    .build()
                            )
                            .addPost(
                                FileUploadParams.Transformation.Post.Abs.builder()
                                    .protocol(
                                        FileUploadParams.Transformation.Post.Abs.Protocol.DASH
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

        val response = responseFuture.get()
        response.validate()
    }
}
