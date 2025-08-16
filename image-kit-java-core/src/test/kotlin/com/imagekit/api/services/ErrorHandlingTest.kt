// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.imagekit.api.client.ImageKitClient
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.http.Headers
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.errors.BadRequestException
import com.imagekit.api.errors.ImageKitException
import com.imagekit.api.errors.InternalServerException
import com.imagekit.api.errors.NotFoundException
import com.imagekit.api.errors.PermissionDeniedException
import com.imagekit.api.errors.RateLimitException
import com.imagekit.api.errors.UnauthorizedException
import com.imagekit.api.errors.UnexpectedStatusCodeException
import com.imagekit.api.errors.UnprocessableEntityException
import com.imagekit.api.models.files.FileUploadV1Params
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: ImageKitClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            ImageKitOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
    }

    @Test
    fun filesUploadV1_400() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_400WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_401() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_401WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_403() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_403WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_404() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_404WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_422() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_422WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_429() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_429WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_500() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_500WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_999() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1_999WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadV1InvalidJsonBody() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<ImageKitException> {
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
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
