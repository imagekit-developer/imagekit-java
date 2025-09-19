// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.errors.ImageKitInvalidDataException
import com.imagekit.api.models.UnnamedSchemaWithArrayParent1
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
