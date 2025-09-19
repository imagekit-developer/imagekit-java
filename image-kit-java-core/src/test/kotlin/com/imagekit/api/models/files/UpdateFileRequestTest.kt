// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.models.UnnamedSchemaWithArrayParent1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
        val changePublicationStatus = JsonValue.from(mapOf<String, Any>())

        val updateFileRequest = UpdateFileRequest.ofChangePublicationStatus(changePublicationStatus)

        assertThat(updateFileRequest.details()).isEmpty
        assertThat(updateFileRequest.changePublicationStatus()).contains(changePublicationStatus)
    }

    @Test
    fun ofChangePublicationStatusRoundtrip() {
        val jsonMapper = jsonMapper()
        val updateFileRequest =
            UpdateFileRequest.ofChangePublicationStatus(JsonValue.from(mapOf<String, Any>()))

        val roundtrippedUpdateFileRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(updateFileRequest),
                jacksonTypeRef<UpdateFileRequest>(),
            )

        assertThat(roundtrippedUpdateFileRequest).isEqualTo(updateFileRequest)
    }
}
