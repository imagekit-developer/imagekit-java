// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
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
import com.imagekit.api.models.ExtensionItem
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
                .privateKey("My Private Key")
                .password("My Password")
                .build()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun upload() {
        val fileService = client.files()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

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
                                .name(ExtensionItem.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING)
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
                                            listOf("shirt", "tshirt", "dress", "trousers", "jacket")
                                        )
                                        .build()
                                )
                                .addTask(
                                    ExtensionItem.AiTasks.Task.YesNo.builder()
                                        .instruction("Is this a luxury or high-end fashion item?")
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
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
