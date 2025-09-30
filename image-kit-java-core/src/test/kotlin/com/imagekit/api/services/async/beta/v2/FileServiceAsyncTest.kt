// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.beta.v2

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.UnnamedSchemaWithArrayParent1
import com.imagekit.api.models.beta.v2.files.FileUploadParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FileServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun upload() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val fileServiceAsync = client.beta().v2().files()

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
                    .responseFields(
                        listOf(
                            FileUploadParams.ResponseField.TAGS,
                            FileUploadParams.ResponseField.CUSTOM_COORDINATES,
                            FileUploadParams.ResponseField.IS_PRIVATE_FILE,
                        )
                    )
                    .selectedFieldsSchema(
                        FileUploadParams.SelectedFieldsSchema.builder()
                            .putAdditionalProperty(
                                "foo",
                                JsonValue.from(
                                    mapOf(
                                        "type" to "Text",
                                        "defaultValue" to "string",
                                        "isValueRequired" to true,
                                        "maxLength" to 0,
                                        "maxValue" to "string",
                                        "minLength" to 0,
                                        "minValue" to "string",
                                        "readOnly" to true,
                                        "selectOptions" to
                                            listOf("small", "medium", "large", 30, 40, true),
                                        "selectOptionsTruncated" to true,
                                    )
                                ),
                            )
                            .build()
                    )
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
