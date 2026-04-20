// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.io.core.JsonValue
import io.imagekit.io.core.jsonMapper
import io.imagekit.io.errors.ImageKitInvalidDataException
import io.imagekit.io.models.ExtensionItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class UpdateFileRequestTest {

    @Test
    fun ofDetails() {
        val details =
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
                .removeAiTagsAll()
                .addTag("tag1")
                .addTag("tag2")
                .webhookUrl("https://example.com")
                .build()

        val updateFileRequest = UpdateFileRequest.ofDetails(details)

        assertThat(updateFileRequest.details()).contains(details)
        assertThat(updateFileRequest.changePublicationStatus()).isEmpty
    }

    @Test
    fun ofDetailsRoundtrip() {
        val jsonMapper = jsonMapper()
        val updateFileRequest =
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
                                    .name(
                                        ExtensionItem.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING
                                    )
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
                                                listOf(
                                                    "shirt",
                                                    "tshirt",
                                                    "dress",
                                                    "trousers",
                                                    "jacket",
                                                )
                                            )
                                            .build()
                                    )
                                    .addTask(
                                        ExtensionItem.AiTasks.Task.YesNo.builder()
                                            .instruction(
                                                "Is this a luxury or high-end fashion item?"
                                            )
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
                    .removeAiTagsAll()
                    .addTag("tag1")
                    .addTag("tag2")
                    .webhookUrl("https://example.com")
                    .build()
            )

        val roundtrippedUpdateFileRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(updateFileRequest),
                jacksonTypeRef<UpdateFileRequest>(),
            )

        assertThat(roundtrippedUpdateFileRequest).isEqualTo(updateFileRequest)
    }

    @Test
    fun ofChangePublicationStatus() {
        val changePublicationStatus =
            UpdateFileRequest.ChangePublicationStatus.builder()
                .publish(
                    UpdateFileRequest.ChangePublicationStatus.Publish.builder()
                        .isPublished(true)
                        .includeFileVersions(true)
                        .build()
                )
                .build()

        val updateFileRequest = UpdateFileRequest.ofChangePublicationStatus(changePublicationStatus)

        assertThat(updateFileRequest.details()).isEmpty
        assertThat(updateFileRequest.changePublicationStatus()).contains(changePublicationStatus)
    }

    @Test
    fun ofChangePublicationStatusRoundtrip() {
        val jsonMapper = jsonMapper()
        val updateFileRequest =
            UpdateFileRequest.ofChangePublicationStatus(
                UpdateFileRequest.ChangePublicationStatus.builder()
                    .publish(
                        UpdateFileRequest.ChangePublicationStatus.Publish.builder()
                            .isPublished(true)
                            .includeFileVersions(true)
                            .build()
                    )
                    .build()
            )

        val roundtrippedUpdateFileRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(updateFileRequest),
                jacksonTypeRef<UpdateFileRequest>(),
            )

        assertThat(roundtrippedUpdateFileRequest).isEqualTo(updateFileRequest)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val updateFileRequest =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<UpdateFileRequest>())

        val e = assertThrows<ImageKitInvalidDataException> { updateFileRequest.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
