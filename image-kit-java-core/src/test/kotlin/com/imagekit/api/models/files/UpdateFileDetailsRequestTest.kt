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

internal class UpdateFileDetailsRequestTest {

    @Test
    fun ofUpdateFileDetails() {
        val updateFileDetails =
            UpdateFileDetailsRequest.UpdateFileDetails.builder()
                .customCoordinates("customCoordinates")
                .customMetadata(
                    UpdateFileDetailsRequest.UpdateFileDetails.CustomMetadata.builder()
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

        val updateFileDetailsRequest =
            UpdateFileDetailsRequest.ofUpdateFileDetails(updateFileDetails)

        assertThat(updateFileDetailsRequest.updateFileDetails()).contains(updateFileDetails)
        assertThat(updateFileDetailsRequest.changePublicationStatus()).isEmpty
    }

    @Test
    fun ofUpdateFileDetailsRoundtrip() {
        val jsonMapper = jsonMapper()
        val updateFileDetailsRequest =
            UpdateFileDetailsRequest.ofUpdateFileDetails(
                UpdateFileDetailsRequest.UpdateFileDetails.builder()
                    .customCoordinates("customCoordinates")
                    .customMetadata(
                        UpdateFileDetailsRequest.UpdateFileDetails.CustomMetadata.builder()
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

        val roundtrippedUpdateFileDetailsRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(updateFileDetailsRequest),
                jacksonTypeRef<UpdateFileDetailsRequest>(),
            )

        assertThat(roundtrippedUpdateFileDetailsRequest).isEqualTo(updateFileDetailsRequest)
    }

    @Test
    fun ofChangePublicationStatus() {
        val changePublicationStatus =
            UpdateFileDetailsRequest.ChangePublicationStatus.builder()
                .publish(
                    UpdateFileDetailsRequest.ChangePublicationStatus.Publish.builder()
                        .isPublished(true)
                        .includeFileVersions(true)
                        .build()
                )
                .build()

        val updateFileDetailsRequest =
            UpdateFileDetailsRequest.ofChangePublicationStatus(changePublicationStatus)

        assertThat(updateFileDetailsRequest.updateFileDetails()).isEmpty
        assertThat(updateFileDetailsRequest.changePublicationStatus())
            .contains(changePublicationStatus)
    }

    @Test
    fun ofChangePublicationStatusRoundtrip() {
        val jsonMapper = jsonMapper()
        val updateFileDetailsRequest =
            UpdateFileDetailsRequest.ofChangePublicationStatus(
                UpdateFileDetailsRequest.ChangePublicationStatus.builder()
                    .publish(
                        UpdateFileDetailsRequest.ChangePublicationStatus.Publish.builder()
                            .isPublished(true)
                            .includeFileVersions(true)
                            .build()
                    )
                    .build()
            )

        val roundtrippedUpdateFileDetailsRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(updateFileDetailsRequest),
                jacksonTypeRef<UpdateFileDetailsRequest>(),
            )

        assertThat(roundtrippedUpdateFileDetailsRequest).isEqualTo(updateFileDetailsRequest)
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
        val updateFileDetailsRequest =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<UpdateFileDetailsRequest>())

        val e = assertThrows<ImageKitInvalidDataException> { updateFileDetailsRequest.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
