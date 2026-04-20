// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.ExtensionItem
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
                                    .maxTags(10L)
                                    .minConfidence(80L)
                                    .name(
                                        ExtensionItem.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING
                                    )
                                    .build()
                            ),
                            ExtensionItem.ofAutoTaggingExtension(
                                ExtensionItem.AutoTaggingExtension.builder()
                                    .maxTags(10L)
                                    .minConfidence(80L)
                                    .name(ExtensionItem.AutoTaggingExtension.Name.AWS_AUTO_TAGGING)
                                    .build()
                            ),
                            ExtensionItem.ofAiAutoDescription(),
                            ExtensionItem.ofAiTasks(
                                ExtensionItem.AiTasks.builder()
                                    .addTask(
                                        ExtensionItem.AiTasks.Task.SelectTags.builder()
                                            .instruction(
                                                "What types of clothing items are visible?"
                                            )
                                            .maxSelections(1L)
                                            .minSelections(0L)
                                            .vocabulary(listOf("shirt", "dress", "jacket"))
                                            .build()
                                    )
                                    .build()
                            ),
                            ExtensionItem.ofSavedExtension(
                                ExtensionItem.SavedExtension.builder().id("ext_abc123").build()
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
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            ExtensionItem.AutoTaggingExtension.Name
                                                .GOOGLE_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                ExtensionItem.ofAutoTaggingExtension(
                                    ExtensionItem.AutoTaggingExtension.builder()
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            ExtensionItem.AutoTaggingExtension.Name.AWS_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                ExtensionItem.ofAiAutoDescription(),
                                ExtensionItem.ofAiTasks(
                                    ExtensionItem.AiTasks.builder()
                                        .addTask(
                                            ExtensionItem.AiTasks.Task.SelectTags.builder()
                                                .instruction(
                                                    "What types of clothing items are visible?"
                                                )
                                                .maxSelections(1L)
                                                .minSelections(0L)
                                                .vocabulary(listOf("shirt", "dress", "jacket"))
                                                .build()
                                        )
                                        .build()
                                ),
                                ExtensionItem.ofSavedExtension(
                                    ExtensionItem.SavedExtension.builder().id("ext_abc123").build()
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
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            ExtensionItem.AutoTaggingExtension.Name
                                                .GOOGLE_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                ExtensionItem.ofAutoTaggingExtension(
                                    ExtensionItem.AutoTaggingExtension.builder()
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            ExtensionItem.AutoTaggingExtension.Name.AWS_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                ExtensionItem.ofAiAutoDescription(),
                                ExtensionItem.ofAiTasks(
                                    ExtensionItem.AiTasks.builder()
                                        .addTask(
                                            ExtensionItem.AiTasks.Task.SelectTags.builder()
                                                .instruction(
                                                    "What types of clothing items are visible?"
                                                )
                                                .maxSelections(1L)
                                                .minSelections(0L)
                                                .vocabulary(listOf("shirt", "dress", "jacket"))
                                                .build()
                                        )
                                        .build()
                                ),
                                ExtensionItem.ofSavedExtension(
                                    ExtensionItem.SavedExtension.builder().id("ext_abc123").build()
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
