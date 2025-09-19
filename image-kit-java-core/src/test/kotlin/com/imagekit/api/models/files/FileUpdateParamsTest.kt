// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.UnnamedSchemaWithArrayParent1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileUpdateParamsTest {

    @Test
    fun create() {
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
                    .removeAiTagsOfStrings(listOf("string"))
                    .tags(listOf("car", "vehicle", "motorsports"))
                    .webhookUrl("https://example.com")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            FileUpdateParams.builder()
                .fileId("fileId")
                .updateFileRequest(UpdateFileRequest.UpdateFileDetails.builder().build())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("fileId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
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
                        .removeAiTagsOfStrings(listOf("string"))
                        .tags(listOf("car", "vehicle", "motorsports"))
                        .webhookUrl("https://example.com")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                UpdateFileRequest.ofDetails(
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
                        .removeAiTagsOfStrings(listOf("string"))
                        .tags(listOf("car", "vehicle", "motorsports"))
                        .webhookUrl("https://example.com")
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FileUpdateParams.builder()
                .fileId("fileId")
                .updateFileRequest(UpdateFileRequest.UpdateFileDetails.builder().build())
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                UpdateFileRequest.ofDetails(UpdateFileRequest.UpdateFileDetails.builder().build())
            )
    }
}
