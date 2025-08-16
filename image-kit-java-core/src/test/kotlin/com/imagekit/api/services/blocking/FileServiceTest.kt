// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.files.FileAddTagsParams
import com.imagekit.api.models.files.FileCopyParams
import com.imagekit.api.models.files.FileListParams
import com.imagekit.api.models.files.FileMoveParams
import com.imagekit.api.models.files.FileRemoveAiTagsParams
import com.imagekit.api.models.files.FileRemoveTagsParams
import com.imagekit.api.models.files.FileRenameParams
import com.imagekit.api.models.files.FileUploadV1Params
import com.imagekit.api.models.files.FileUploadV2Params
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FileServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val files =
            fileService.list(
                FileListParams.builder()
                    .fileType("fileType")
                    .limit("limit")
                    .path("path")
                    .searchQuery("searchQuery")
                    .skip("skip")
                    .sort("sort")
                    .type(FileListParams.Type.FILE)
                    .build()
            )

        files.forEach { it.validate() }
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
    fun addTags() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val response =
            fileService.addTags(
                FileAddTagsParams.builder()
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .tags(listOf("t-shirt", "round-neck", "sale2019"))
                    .build()
            )

        response.validate()
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
    fun removeAiTags() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val response =
            fileService.removeAiTags(
                FileRemoveAiTagsParams.builder()
                    .aiTags(listOf("t-shirt", "round-neck", "sale2019"))
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .build()
            )

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun removeTags() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val response =
            fileService.removeTags(
                FileRemoveTagsParams.builder()
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .tags(listOf("t-shirt", "round-neck", "sale2019"))
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
    fun uploadV1() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val response =
            fileService.uploadV1(
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
            )

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun uploadV2() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileService = client.files()

        val response =
            fileService.uploadV2(
                FileUploadV2Params.builder()
                    .file("https://www.example.com/rest-of-the-image-path.jpg")
                    .fileName("fileName")
                    .token("token")
                    .checks("\"request.folder\" : \"marketing/\"\n")
                    .customCoordinates("customCoordinates")
                    .customMetadata(
                        "\"\n  {\n    \"brand\": \"Nike\",\n    \"color\":\"red\"\n  }\n\"\n"
                    )
                    .extensions(
                        "\"\n[\n  {\"name\":\"remove-bg\",\"options\":{\"add_shadow\":true,\"bg_colour\":\"green\"}},\n  {\"name\":\"google-auto-tagging\",\"maxTags\":5,\"minConfidence\":95}\n]\n\"\n"
                    )
                    .folder("folder")
                    .isPrivateFile(FileUploadV2Params.IsPrivateFile.TRUE)
                    .isPublished(FileUploadV2Params.IsPublished.TRUE)
                    .overwriteAiTags(FileUploadV2Params.OverwriteAiTags.TRUE)
                    .overwriteCustomMetadata(FileUploadV2Params.OverwriteCustomMetadata.TRUE)
                    .overwriteFile("overwriteFile")
                    .overwriteTags(FileUploadV2Params.OverwriteTags.TRUE)
                    .responseFields("responseFields")
                    .tags("t-shirt,round-neck,men")
                    .transformation(
                        "'{\"pre\":\"width:300,height:300,quality:80\",\"post\":[{\"type\":\"thumbnail\",\"value\":\"width:100,height:100\"}]}'\n"
                    )
                    .useUniqueFileName(FileUploadV2Params.UseUniqueFileName.TRUE)
                    .webhookUrl("webhookUrl")
                    .build()
            )

        response.validate()
    }
}
