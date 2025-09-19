// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.UnnamedSchemaWithArrayParent1
import com.imagekit.api.models.files.FileCopyParams
import com.imagekit.api.models.files.FileMoveParams
import com.imagekit.api.models.files.FileRenameParams
import com.imagekit.api.models.files.FileUpdateParams
import com.imagekit.api.models.files.FileUploadParams
import com.imagekit.api.models.files.UpdateFileRequest
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
                    .updateFileRequest(
                        UpdateFileRequest.UpdateFileDetails.builder()
                            .customCoordinates("customCoordinates")
                            .customMetadata(
                                UpdateFileRequest.UpdateFileDetails.CustomMetadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .description("description")
                            .extensions(
                                listOf(
                                    UnnamedSchemaWithArrayParent1.ofRemoveBg(
                                        UnnamedSchemaWithArrayParent1.RemoveBg.builder()
                                            .options(
                                                UnnamedSchemaWithArrayParent1.RemoveBg.Options
                                                    .builder()
                                                    .addShadow(true)
                                                    .bgColor("bg_color")
                                                    .bgImageUrl("bg_image_url")
                                                    .semitransparency(true)
                                                    .build()
                                            )
                                            .build()
                                    ),
                                    UnnamedSchemaWithArrayParent1.ofAutoTaggingExtension(
                                        UnnamedSchemaWithArrayParent1.AutoTaggingExtension.builder()
                                            .maxTags(5L)
                                            .minConfidence(95L)
                                            .name(
                                                UnnamedSchemaWithArrayParent1.AutoTaggingExtension
                                                    .Name
                                                    .GOOGLE_AUTO_TAGGING
                                            )
                                            .build()
                                    ),
                                    UnnamedSchemaWithArrayParent1.ofAiAutoDescription(),
                                )
                            )
                            .removeAiTagsOfStrings(listOf("string"))
                            .tags(listOf("car", "vehicle", "motorsports"))
                            .webhookUrl("https://example.com")
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
                    .extensions(
                        listOf(
                            UnnamedSchemaWithArrayParent1.ofRemoveBg(
                                UnnamedSchemaWithArrayParent1.RemoveBg.builder()
                                    .options(
                                        UnnamedSchemaWithArrayParent1.RemoveBg.Options.builder()
                                            .addShadow(true)
                                            .bgColor("bg_color")
                                            .bgImageUrl("bg_image_url")
                                            .semitransparency(true)
                                            .build()
                                    )
                                    .build()
                            ),
                            UnnamedSchemaWithArrayParent1.ofAutoTaggingExtension(
                                UnnamedSchemaWithArrayParent1.AutoTaggingExtension.builder()
                                    .maxTags(5L)
                                    .minConfidence(95L)
                                    .name(
                                        UnnamedSchemaWithArrayParent1.AutoTaggingExtension.Name
                                            .GOOGLE_AUTO_TAGGING
                                    )
                                    .build()
                            ),
                            UnnamedSchemaWithArrayParent1.ofAiAutoDescription(),
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
