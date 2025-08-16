// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.custommetadatafields

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomMetadataFieldUpdateResponseTest {

    @Test
    fun create() {
        val customMetadataFieldUpdateResponse =
            CustomMetadataFieldUpdateResponse.builder()
                .id("id")
                .label("label")
                .name("name")
                .schema(
                    CustomMetadataFieldUpdateResponse.Schema.builder()
                        .type(CustomMetadataFieldUpdateResponse.Schema.Type.TEXT)
                        .defaultValue("string")
                        .isValueRequired(true)
                        .maxLength(0.0)
                        .maxValue("string")
                        .minLength(0.0)
                        .minValue("string")
                        .selectOptions(
                            listOf(
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofString(
                                    "small"
                                ),
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofString(
                                    "medium"
                                ),
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofString(
                                    "large"
                                ),
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofNumber(
                                    30.0
                                ),
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofNumber(
                                    40.0
                                ),
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofBool(true),
                            )
                        )
                        .build()
                )
                .build()

        assertThat(customMetadataFieldUpdateResponse.id()).isEqualTo("id")
        assertThat(customMetadataFieldUpdateResponse.label()).isEqualTo("label")
        assertThat(customMetadataFieldUpdateResponse.name()).isEqualTo("name")
        assertThat(customMetadataFieldUpdateResponse.schema())
            .isEqualTo(
                CustomMetadataFieldUpdateResponse.Schema.builder()
                    .type(CustomMetadataFieldUpdateResponse.Schema.Type.TEXT)
                    .defaultValue("string")
                    .isValueRequired(true)
                    .maxLength(0.0)
                    .maxValue("string")
                    .minLength(0.0)
                    .minValue("string")
                    .selectOptions(
                        listOf(
                            CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofString("small"),
                            CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofString(
                                "medium"
                            ),
                            CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofString("large"),
                            CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofNumber(30.0),
                            CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofNumber(40.0),
                            CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofBool(true),
                        )
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val customMetadataFieldUpdateResponse =
            CustomMetadataFieldUpdateResponse.builder()
                .id("id")
                .label("label")
                .name("name")
                .schema(
                    CustomMetadataFieldUpdateResponse.Schema.builder()
                        .type(CustomMetadataFieldUpdateResponse.Schema.Type.TEXT)
                        .defaultValue("string")
                        .isValueRequired(true)
                        .maxLength(0.0)
                        .maxValue("string")
                        .minLength(0.0)
                        .minValue("string")
                        .selectOptions(
                            listOf(
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofString(
                                    "small"
                                ),
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofString(
                                    "medium"
                                ),
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofString(
                                    "large"
                                ),
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofNumber(
                                    30.0
                                ),
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofNumber(
                                    40.0
                                ),
                                CustomMetadataFieldUpdateResponse.Schema.SelectOption.ofBool(true),
                            )
                        )
                        .build()
                )
                .build()

        val roundtrippedCustomMetadataFieldUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(customMetadataFieldUpdateResponse),
                jacksonTypeRef<CustomMetadataFieldUpdateResponse>(),
            )

        assertThat(roundtrippedCustomMetadataFieldUpdateResponse)
            .isEqualTo(customMetadataFieldUpdateResponse)
    }
}
