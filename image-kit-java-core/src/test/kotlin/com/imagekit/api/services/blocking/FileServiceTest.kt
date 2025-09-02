// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
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
internal class FileServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val file =
            fileService.update(
                FileUpdateParams.builder()
                    .fileId("fileId")
                    .update(
                        FileUpdateParams.Update.UpdateFileDetails.builder()
                            .customCoordinates("10,10,100,100")
                            .customMetadata(
                                FileUpdateParams.Update.UpdateFileDetails.CustomMetadata.builder()
                                    .putAdditionalProperty("brand", JsonValue.from("bar"))
                                    .putAdditionalProperty("color", JsonValue.from("bar"))
                                    .build()
                            )
                            .description("description")
                            .extensions(
                                listOf(
                                    FileUpdateParams.Update.UpdateFileDetails.Extension.ofRemoveBg(
                                        FileUpdateParams.Update.UpdateFileDetails.Extension.RemoveBg
                                            .builder()
                                            .options(
                                                FileUpdateParams.Update.UpdateFileDetails.Extension
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
                                    FileUpdateParams.Update.UpdateFileDetails.Extension
                                        .ofAutoTagging(
                                            FileUpdateParams.Update.UpdateFileDetails.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(10L)
                                                .minConfidence(80L)
                                                .name(
                                                    FileUpdateParams.Update.UpdateFileDetails
                                                        .Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                    FileUpdateParams.Update.UpdateFileDetails.Extension
                                        .ofAutoTagging(
                                            FileUpdateParams.Update.UpdateFileDetails.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(10L)
                                                .minConfidence(80L)
                                                .name(
                                                    FileUpdateParams.Update.UpdateFileDetails
                                                        .Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .AWS_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                    FileUpdateParams.Update.UpdateFileDetails.Extension
                                        .ofAiAutoDescription(),
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

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        fileService.delete("fileId")
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun copy() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
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

    @Disabled("Prism tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val file = fileService.get("fileId")

        file.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun move() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
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

    @Disabled("Prism tests are disabled")
    @Test
    fun rename() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
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

    @Disabled("Prism tests are disabled")
    @Test
    fun upload() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val response =
            fileService.upload(
                FileUploadParams.builder()
                    .file("file")
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
                            FileUploadParams.Extension.ofRemoveBg(
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
                            FileUploadParams.Extension.ofAiAutoDescription(),
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

        response.validate()
    }
}
