// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.custommetadatafields

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomMetadataFieldCreateResponseTest {

    @Test
    fun create() {
        val customMetadataFieldCreateResponse =
            CustomMetadataFieldCreateResponse.builder()
                .id("id")
                .label("label")
                .name("name")
                .schema(
                    CustomMetadataFieldCreateResponse.Schema.builder()
                        .type(CustomMetadataFieldCreateResponse.Schema.Type.TEXT)
                        .defaultValue(
                            CustomMetadataFieldCreateResponse.Schema.DefaultValue.UnionMember0
                                .ofJsonScalar("Hello")
                        )
                        .isValueRequired(true)
                        .maxLength(0.0)
                        .maxValue("string")
                        .minLength(0.0)
                        .minValue("string")
                        .selectOptions(
                            listOf(
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofString(
                                    "small"
                                ),
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofString(
                                    "medium"
                                ),
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofString(
                                    "large"
                                ),
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofNumber(
                                    30.0
                                ),
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofNumber(
                                    40.0
                                ),
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofBool(true),
                            )
                        )
                        .build()
                )
                .build()

        assertThat(customMetadataFieldCreateResponse.id()).isEqualTo("id")
        assertThat(customMetadataFieldCreateResponse.label()).isEqualTo("label")
        assertThat(customMetadataFieldCreateResponse.name()).isEqualTo("name")
        assertThat(customMetadataFieldCreateResponse.schema())
            .isEqualTo(
                CustomMetadataFieldCreateResponse.Schema.builder()
                    .type(CustomMetadataFieldCreateResponse.Schema.Type.TEXT)
                    .defaultValue(
                        CustomMetadataFieldCreateResponse.Schema.DefaultValue.UnionMember0
                            .ofJsonScalar("Hello")
                    )
                    .isValueRequired(true)
                    .maxLength(0.0)
                    .maxValue("string")
                    .minLength(0.0)
                    .minValue("string")
                    .selectOptions(
                        listOf(
                            CustomMetadataFieldCreateResponse.Schema.SelectOption.ofString("small"),
                            CustomMetadataFieldCreateResponse.Schema.SelectOption.ofString(
                                "medium"
                            ),
                            CustomMetadataFieldCreateResponse.Schema.SelectOption.ofString("large"),
                            CustomMetadataFieldCreateResponse.Schema.SelectOption.ofNumber(30.0),
                            CustomMetadataFieldCreateResponse.Schema.SelectOption.ofNumber(40.0),
                            CustomMetadataFieldCreateResponse.Schema.SelectOption.ofBool(true),
                        )
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val customMetadataFieldCreateResponse =
            CustomMetadataFieldCreateResponse.builder()
                .id("id")
                .label("label")
                .name("name")
                .schema(
                    CustomMetadataFieldCreateResponse.Schema.builder()
                        .type(CustomMetadataFieldCreateResponse.Schema.Type.TEXT)
                        .defaultValue(
                            CustomMetadataFieldCreateResponse.Schema.DefaultValue.UnionMember0
                                .ofJsonScalar("Hello")
                        )
                        .isValueRequired(true)
                        .maxLength(0.0)
                        .maxValue("string")
                        .minLength(0.0)
                        .minValue("string")
                        .selectOptions(
                            listOf(
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofString(
                                    "small"
                                ),
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofString(
                                    "medium"
                                ),
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofString(
                                    "large"
                                ),
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofNumber(
                                    30.0
                                ),
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofNumber(
                                    40.0
                                ),
                                CustomMetadataFieldCreateResponse.Schema.SelectOption.ofBool(true),
                            )
                        )
                        .build()
                )
                .build()

        val roundtrippedCustomMetadataFieldCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(customMetadataFieldCreateResponse),
                jacksonTypeRef<CustomMetadataFieldCreateResponse>(),
            )

        assertThat(roundtrippedCustomMetadataFieldCreateResponse)
            .isEqualTo(customMetadataFieldCreateResponse)
    }
}
