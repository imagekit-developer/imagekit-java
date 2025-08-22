// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.custommetadatafields

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomMetadataFieldListResponseTest {

    @Test
    fun create() {
        val customMetadataFieldListResponse =
            CustomMetadataFieldListResponse.builder()
                .id("id")
                .label("label")
                .name("name")
                .schema(
                    CustomMetadataFieldListResponse.Schema.builder()
                        .type(CustomMetadataFieldListResponse.Schema.Type.TEXT)
                        .defaultValue("string")
                        .isValueRequired(true)
                        .maxLength(0.0)
                        .maxValue("string")
                        .minLength(0.0)
                        .minValue("string")
                        .selectOptions(
                            listOf(
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofString(
                                    "small"
                                ),
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofString(
                                    "medium"
                                ),
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofString(
                                    "large"
                                ),
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofNumber(30.0),
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofNumber(40.0),
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofBool(true),
                            )
                        )
                        .build()
                )
                .build()

        assertThat(customMetadataFieldListResponse.id()).isEqualTo("id")
        assertThat(customMetadataFieldListResponse.label()).isEqualTo("label")
        assertThat(customMetadataFieldListResponse.name()).isEqualTo("name")
        assertThat(customMetadataFieldListResponse.schema())
            .isEqualTo(
                CustomMetadataFieldListResponse.Schema.builder()
                    .type(CustomMetadataFieldListResponse.Schema.Type.TEXT)
                    .defaultValue("string")
                    .isValueRequired(true)
                    .maxLength(0.0)
                    .maxValue("string")
                    .minLength(0.0)
                    .minValue("string")
                    .selectOptions(
                        listOf(
                            CustomMetadataFieldListResponse.Schema.SelectOption.ofString("small"),
                            CustomMetadataFieldListResponse.Schema.SelectOption.ofString("medium"),
                            CustomMetadataFieldListResponse.Schema.SelectOption.ofString("large"),
                            CustomMetadataFieldListResponse.Schema.SelectOption.ofNumber(30.0),
                            CustomMetadataFieldListResponse.Schema.SelectOption.ofNumber(40.0),
                            CustomMetadataFieldListResponse.Schema.SelectOption.ofBool(true),
                        )
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val customMetadataFieldListResponse =
            CustomMetadataFieldListResponse.builder()
                .id("id")
                .label("label")
                .name("name")
                .schema(
                    CustomMetadataFieldListResponse.Schema.builder()
                        .type(CustomMetadataFieldListResponse.Schema.Type.TEXT)
                        .defaultValue("string")
                        .isValueRequired(true)
                        .maxLength(0.0)
                        .maxValue("string")
                        .minLength(0.0)
                        .minValue("string")
                        .selectOptions(
                            listOf(
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofString(
                                    "small"
                                ),
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofString(
                                    "medium"
                                ),
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofString(
                                    "large"
                                ),
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofNumber(30.0),
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofNumber(40.0),
                                CustomMetadataFieldListResponse.Schema.SelectOption.ofBool(true),
                            )
                        )
                        .build()
                )
                .build()

        val roundtrippedCustomMetadataFieldListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(customMetadataFieldListResponse),
                jacksonTypeRef<CustomMetadataFieldListResponse>(),
            )

        assertThat(roundtrippedCustomMetadataFieldListResponse)
            .isEqualTo(customMetadataFieldListResponse)
    }
}
