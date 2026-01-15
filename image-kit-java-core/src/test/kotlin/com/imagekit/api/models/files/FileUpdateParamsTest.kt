// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.UnnamedSchemaWithArrayParent4
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileUpdateParamsTest {

    @Test
    fun create() {
        FileUpdateParams.builder()
            .fileId("fileId")
            .updateFileRequest(
                UpdateFileRequest.UpdateFileDetails.builder()
                    .customCoordinates("10,10,100,100")
                    .customMetadata(
                        UpdateFileRequest.UpdateFileDetails.CustomMetadata.builder()
                            .putAdditionalProperty("brand", JsonValue.from("bar"))
                            .putAdditionalProperty("color", JsonValue.from("bar"))
                            .build()
                    )
                    .description("description")
                    .extensions(
                        listOf(
                            UnnamedSchemaWithArrayParent4.ofRemoveBg(
                                UnnamedSchemaWithArrayParent4.RemoveBg.builder()
                                    .options(
                                        UnnamedSchemaWithArrayParent4.RemoveBg.Options.builder()
                                            .addShadow(true)
                                            .bgColor("bg_color")
                                            .bgImageUrl("bg_image_url")
                                            .semitransparency(true)
                                            .build()
                                    )
                                    .build()
                            ),
                            UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(
                                UnnamedSchemaWithArrayParent4.AutoTaggingExtension.builder()
                                    .maxTags(10L)
                                    .minConfidence(80L)
                                    .name(
                                        UnnamedSchemaWithArrayParent4.AutoTaggingExtension.Name
                                            .GOOGLE_AUTO_TAGGING
                                    )
                                    .build()
                            ),
                            UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(
                                UnnamedSchemaWithArrayParent4.AutoTaggingExtension.builder()
                                    .maxTags(10L)
                                    .minConfidence(80L)
                                    .name(
                                        UnnamedSchemaWithArrayParent4.AutoTaggingExtension.Name
                                            .AWS_AUTO_TAGGING
                                    )
                                    .build()
                            ),
                            UnnamedSchemaWithArrayParent4.ofAiAutoDescription(),
                            UnnamedSchemaWithArrayParent4.ofAiTasks(
                                UnnamedSchemaWithArrayParent4.AiTasks.builder()
                                    .addTask(
                                        UnnamedSchemaWithArrayParent4.AiTasks.Task.SelectTags
                                            .builder()
                                            .instruction(
                                                "What types of clothing items are visible?"
                                            )
                                            .vocabulary(listOf("shirt", "dress", "jacket"))
                                            .maxSelections(1L)
                                            .minSelections(0L)
                                            .build()
                                    )
                                    .build()
                            ),
                            UnnamedSchemaWithArrayParent4.ofSavedExtension(
                                UnnamedSchemaWithArrayParent4.SavedExtension.builder()
                                    .id("ext_abc123")
                                    .build()
                            ),
                        )
                    )
                    .removeAiTagsOfStrings(listOf("car", "vehicle", "motorsports"))
                    .addTag("tag1")
                    .addTag("tag2")
                    .webhookUrl("https://webhook.site/0d6b6c7a-8e5a-4b3a-8b7c-0d6b6c7a8e5a")
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
                        .customCoordinates("10,10,100,100")
                        .customMetadata(
                            UpdateFileRequest.UpdateFileDetails.CustomMetadata.builder()
                                .putAdditionalProperty("brand", JsonValue.from("bar"))
                                .putAdditionalProperty("color", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .extensions(
                            listOf(
                                UnnamedSchemaWithArrayParent4.ofRemoveBg(
                                    UnnamedSchemaWithArrayParent4.RemoveBg.builder()
                                        .options(
                                            UnnamedSchemaWithArrayParent4.RemoveBg.Options.builder()
                                                .addShadow(true)
                                                .bgColor("bg_color")
                                                .bgImageUrl("bg_image_url")
                                                .semitransparency(true)
                                                .build()
                                        )
                                        .build()
                                ),
                                UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(
                                    UnnamedSchemaWithArrayParent4.AutoTaggingExtension.builder()
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            UnnamedSchemaWithArrayParent4.AutoTaggingExtension.Name
                                                .GOOGLE_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(
                                    UnnamedSchemaWithArrayParent4.AutoTaggingExtension.builder()
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            UnnamedSchemaWithArrayParent4.AutoTaggingExtension.Name
                                                .AWS_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                UnnamedSchemaWithArrayParent4.ofAiAutoDescription(),
                                UnnamedSchemaWithArrayParent4.ofAiTasks(
                                    UnnamedSchemaWithArrayParent4.AiTasks.builder()
                                        .addTask(
                                            UnnamedSchemaWithArrayParent4.AiTasks.Task.SelectTags
                                                .builder()
                                                .instruction(
                                                    "What types of clothing items are visible?"
                                                )
                                                .vocabulary(listOf("shirt", "dress", "jacket"))
                                                .maxSelections(1L)
                                                .minSelections(0L)
                                                .build()
                                        )
                                        .build()
                                ),
                                UnnamedSchemaWithArrayParent4.ofSavedExtension(
                                    UnnamedSchemaWithArrayParent4.SavedExtension.builder()
                                        .id("ext_abc123")
                                        .build()
                                ),
                            )
                        )
                        .removeAiTagsOfStrings(listOf("car", "vehicle", "motorsports"))
                        .addTag("tag1")
                        .addTag("tag2")
                        .webhookUrl("https://webhook.site/0d6b6c7a-8e5a-4b3a-8b7c-0d6b6c7a8e5a")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                UpdateFileRequest.ofDetails(
                    UpdateFileRequest.UpdateFileDetails.builder()
                        .customCoordinates("10,10,100,100")
                        .customMetadata(
                            UpdateFileRequest.UpdateFileDetails.CustomMetadata.builder()
                                .putAdditionalProperty("brand", JsonValue.from("bar"))
                                .putAdditionalProperty("color", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .extensions(
                            listOf(
                                UnnamedSchemaWithArrayParent4.ofRemoveBg(
                                    UnnamedSchemaWithArrayParent4.RemoveBg.builder()
                                        .options(
                                            UnnamedSchemaWithArrayParent4.RemoveBg.Options.builder()
                                                .addShadow(true)
                                                .bgColor("bg_color")
                                                .bgImageUrl("bg_image_url")
                                                .semitransparency(true)
                                                .build()
                                        )
                                        .build()
                                ),
                                UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(
                                    UnnamedSchemaWithArrayParent4.AutoTaggingExtension.builder()
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            UnnamedSchemaWithArrayParent4.AutoTaggingExtension.Name
                                                .GOOGLE_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(
                                    UnnamedSchemaWithArrayParent4.AutoTaggingExtension.builder()
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            UnnamedSchemaWithArrayParent4.AutoTaggingExtension.Name
                                                .AWS_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                UnnamedSchemaWithArrayParent4.ofAiAutoDescription(),
                                UnnamedSchemaWithArrayParent4.ofAiTasks(
                                    UnnamedSchemaWithArrayParent4.AiTasks.builder()
                                        .addTask(
                                            UnnamedSchemaWithArrayParent4.AiTasks.Task.SelectTags
                                                .builder()
                                                .instruction(
                                                    "What types of clothing items are visible?"
                                                )
                                                .vocabulary(listOf("shirt", "dress", "jacket"))
                                                .maxSelections(1L)
                                                .minSelections(0L)
                                                .build()
                                        )
                                        .build()
                                ),
                                UnnamedSchemaWithArrayParent4.ofSavedExtension(
                                    UnnamedSchemaWithArrayParent4.SavedExtension.builder()
                                        .id("ext_abc123")
                                        .build()
                                ),
                            )
                        )
                        .removeAiTagsOfStrings(listOf("car", "vehicle", "motorsports"))
                        .addTag("tag1")
                        .addTag("tag2")
                        .webhookUrl("https://webhook.site/0d6b6c7a-8e5a-4b3a-8b7c-0d6b6c7a8e5a")
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
