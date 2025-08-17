// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.files.FileCopyParams
import com.imagekit.api.models.files.FileMoveParams
import com.imagekit.api.models.files.FileRenameParams
import com.imagekit.api.models.files.FileUpdateParams
import com.imagekit.api.models.files.FileUploadParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FileServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val fileFuture =
            fileServiceAsync.update(
                FileUpdateParams.builder()
                    .fileId("fileId")
                    .body(
                        FileUpdateParams.Body.UpdateFileDetails.builder()
                            .customCoordinates("10,10,100,100")
                            .customMetadata(
                                JsonValue.from(mapOf("brand" to "Nike", "color" to "red"))
                            )
                            .description("description")
                            .extensions(
                                listOf(
                                    FileUpdateParams.Body.UpdateFileDetails.Extension.ofRemovedotBg(
                                        FileUpdateParams.Body.UpdateFileDetails.Extension
                                            .RemovedotBgExtension
                                            .builder()
                                            .name(
                                                FileUpdateParams.Body.UpdateFileDetails.Extension
                                                    .RemovedotBgExtension
                                                    .Name
                                                    .REMOVE_BG
                                            )
                                            .options(
                                                FileUpdateParams.Body.UpdateFileDetails.Extension
                                                    .RemovedotBgExtension
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
                                    FileUpdateParams.Body.UpdateFileDetails.Extension.ofAutoTagging(
                                        FileUpdateParams.Body.UpdateFileDetails.Extension
                                            .AutoTaggingExtension
                                            .builder()
                                            .maxTags(10L)
                                            .minConfidence(80L)
                                            .name(
                                                FileUpdateParams.Body.UpdateFileDetails.Extension
                                                    .AutoTaggingExtension
                                                    .Name
                                                    .GOOGLE_AUTO_TAGGING
                                            )
                                            .build()
                                    ),
                                    FileUpdateParams.Body.UpdateFileDetails.Extension.ofAutoTagging(
                                        FileUpdateParams.Body.UpdateFileDetails.Extension
                                            .AutoTaggingExtension
                                            .builder()
                                            .maxTags(10L)
                                            .minConfidence(80L)
                                            .name(
                                                FileUpdateParams.Body.UpdateFileDetails.Extension
                                                    .AutoTaggingExtension
                                                    .Name
                                                    .AWS_AUTO_TAGGING
                                            )
                                            .build()
                                    ),
                                    FileUpdateParams.Body.UpdateFileDetails.Extension
                                        .ofAutoDescription(
                                            FileUpdateParams.Body.UpdateFileDetails.Extension
                                                .AutoDescriptionExtension
                                                .builder()
                                                .name(
                                                    FileUpdateParams.Body.UpdateFileDetails
                                                        .Extension
                                                        .AutoDescriptionExtension
                                                        .Name
                                                        .AI_AUTO_DESCRIPTION
                                                )
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

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val future = fileServiceAsync.delete("fileId")

        val response = future.get()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun copy() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
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

    @Disabled("Prism tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val fileFuture = fileServiceAsync.get("fileId")

        val file = fileFuture.get()
        file.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun move() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
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

    @Disabled("Prism tests are disabled")
    @Test
    fun rename() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
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

    @Disabled("Prism tests are disabled")
    @Test
    fun upload() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val responseFuture =
            fileServiceAsync.upload(
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
                    .expire(0L)
                    .addExtension(
                        FileUploadParams.Extension.RemovedotBgExtension.builder()
                            .name(FileUploadParams.Extension.RemovedotBgExtension.Name.REMOVE_BG)
                            .options(
                                FileUploadParams.Extension.RemovedotBgExtension.Options.builder()
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
                                FileUploadParams.Extension.AutoTaggingExtension.Name
                                    .GOOGLE_AUTO_TAGGING
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
                                FileUploadParams.Transformation.Post.GenerateAThumbnail.builder()
                                    .type(
                                        FileUploadParams.Transformation.Post.GenerateAThumbnail.Type
                                            .THUMBNAIL
                                    )
                                    .value("w-150,h-150")
                                    .build()
                            )
                            .addPost(
                                FileUploadParams.Transformation.Post.AdaptiveBitrateStreaming
                                    .builder()
                                    .protocol(
                                        FileUploadParams.Transformation.Post
                                            .AdaptiveBitrateStreaming
                                            .Protocol
                                            .DASH
                                    )
                                    .type(
                                        FileUploadParams.Transformation.Post
                                            .AdaptiveBitrateStreaming
                                            .Type
                                            .ABS
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
