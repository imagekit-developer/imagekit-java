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
import com.imagekit.api.models.files.FileUploadParams
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
    fun filesUpload400() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload400WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload401() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload401WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload403() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload403WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload404() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload404WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload422() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload422WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload429() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload429WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload500() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload500WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload999() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUpload999WithRawResponse() {
        val fileService = client.files().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun filesUploadInvalidJsonBody() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<ImageKitException> {
                fileService.upload(
                    FileUploadParams.builder()
                        .body(
                            FileUploadParams.Body.FileUploadV1.builder()
                                .file("some content".byteInputStream())
                                .fileName("fileName")
                                .token("token")
                                .checks("\"request.folder\" : \"marketing/\"\n")
                                .customCoordinates("customCoordinates")
                                .customMetadata(
                                    FileUploadParams.Body.FileUploadV1.CustomMetadata.builder()
                                        .putAdditionalProperty("brand", JsonValue.from("bar"))
                                        .putAdditionalProperty("color", JsonValue.from("bar"))
                                        .build()
                                )
                                .description("Running shoes")
                                .expire(0L)
                                .extensions(
                                    listOf(
                                        FileUploadParams.Body.FileUploadV1.Extension.ofRemoveBg(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
                                                .builder()
                                                .options(
                                                    FileUploadParams.Body.FileUploadV1.Extension
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
                                        FileUploadParams.Body.FileUploadV1.Extension.ofAutoTagging(
                                            FileUploadParams.Body.FileUploadV1.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(5L)
                                                .minConfidence(95L)
                                                .name(
                                                    FileUploadParams.Body.FileUploadV1.Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                        FileUploadParams.Body.FileUploadV1.Extension
                                            .ofAiAutoDescription(),
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
                                        FileUploadParams.Body.FileUploadV1.ResponseField.TAGS,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .CUSTOM_COORDINATES,
                                        FileUploadParams.Body.FileUploadV1.ResponseField
                                            .IS_PRIVATE_FILE,
                                    )
                                )
                                .signature("signature")
                                .tags(listOf("t-shirt", "round-neck", "men"))
                                .transformation(
                                    FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Thumbnail
                                                .builder()
                                                .value("w-150,h-150")
                                                .build()
                                        )
                                        .addPost(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
                                                .Abs
                                                .builder()
                                                .protocol(
                                                    FileUploadParams.Body.FileUploadV1
                                                        .Transformation
                                                        .Post
                                                        .Abs
                                                        .Protocol
                                                        .DASH
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
