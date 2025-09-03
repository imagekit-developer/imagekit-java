// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.imagekit.api.client.ImageKitClient
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.files.FileUploadParams
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

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

    @Disabled("Prism tests are disabled")
    @Test
    fun upload() {
        val fileService = client.files()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

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
                                    FileUploadParams.Body.FileUploadV1.Extension.RemoveBg.builder()
                                        .options(
                                            FileUploadParams.Body.FileUploadV1.Extension.RemoveBg
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
                                FileUploadParams.Body.FileUploadV1.Extension.ofAiAutoDescription(),
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
                                FileUploadParams.Body.FileUploadV1.ResponseField.CUSTOM_COORDINATES,
                                FileUploadParams.Body.FileUploadV1.ResponseField.IS_PRIVATE_FILE,
                            )
                        )
                        .signature("signature")
                        .tags(listOf("t-shirt", "round-neck", "men"))
                        .transformation(
                            FileUploadParams.Body.FileUploadV1.Transformation.builder()
                                .addPost(
                                    FileUploadParams.Body.FileUploadV1.Transformation.Post.Thumbnail
                                        .builder()
                                        .value("w-150,h-150")
                                        .build()
                                )
                                .addPost(
                                    FileUploadParams.Body.FileUploadV1.Transformation.Post.Abs
                                        .builder()
                                        .protocol(
                                            FileUploadParams.Body.FileUploadV1.Transformation.Post
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
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
        )
    }
}
