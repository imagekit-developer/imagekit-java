// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
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
internal class FileServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val filesFuture =
            fileServiceAsync.list(
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

        val files = filesFuture.get()
        files.forEach { it.validate() }
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
    fun addTags() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val responseFuture =
            fileServiceAsync.addTags(
                FileAddTagsParams.builder()
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .tags(listOf("t-shirt", "round-neck", "sale2019"))
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
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
    fun removeAiTags() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val responseFuture =
            fileServiceAsync.removeAiTags(
                FileRemoveAiTagsParams.builder()
                    .aiTags(listOf("t-shirt", "round-neck", "sale2019"))
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun removeTags() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val responseFuture =
            fileServiceAsync.removeTags(
                FileRemoveTagsParams.builder()
                    .addFileId("598821f949c0a938d57563bd")
                    .addFileId("598821f949c0a938d57563be")
                    .tags(listOf("t-shirt", "round-neck", "sale2019"))
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
    fun uploadV1() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val responseFuture =
            fileServiceAsync.uploadV1(
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

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun uploadV2() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.files()

        val responseFuture =
            fileServiceAsync.uploadV2(
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

        val response = responseFuture.get()
        response.validate()
    }
}
