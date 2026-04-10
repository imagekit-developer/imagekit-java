// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.custommetadatafields

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomMetadataFieldTest {

    @Test
    fun create() {
        val customMetadataField =
            CustomMetadataField.builder()
                .id("id")
                .label("label")
                .name("name")
                .schema(
                    CustomMetadataField.Schema.builder()
                        .type(CustomMetadataField.Schema.Type.TEXT)
                        .defaultValueOfMixed(
                            listOf(
                                CustomMetadataField.Schema.DefaultValue
                                    .UnnamedSchemaWithArrayParent3
                                    .ofBool(true),
                                CustomMetadataField.Schema.DefaultValue
                                    .UnnamedSchemaWithArrayParent3
                                    .ofNumber(10.0),
                                CustomMetadataField.Schema.DefaultValue
                                    .UnnamedSchemaWithArrayParent3
                                    .ofString("Hello"),
                            )
                        )
                        .isValueRequired(true)
                        .maxLength(0.0)
                        .maxValue("string")
                        .minLength(0.0)
                        .minValue("string")
                        .selectOptions(
                            listOf(
                                CustomMetadataField.Schema.SelectOption.ofString("small"),
                                CustomMetadataField.Schema.SelectOption.ofString("medium"),
                                CustomMetadataField.Schema.SelectOption.ofString("large"),
                                CustomMetadataField.Schema.SelectOption.ofNumber(30.0),
                                CustomMetadataField.Schema.SelectOption.ofNumber(40.0),
                                CustomMetadataField.Schema.SelectOption.ofBool(true),
                            )
                        )
                        .build()
                )
                .build()

        assertThat(customMetadataField.id()).isEqualTo("id")
        assertThat(customMetadataField.label()).isEqualTo("label")
        assertThat(customMetadataField.name()).isEqualTo("name")
        assertThat(customMetadataField.schema())
            .isEqualTo(
                CustomMetadataField.Schema.builder()
                    .type(CustomMetadataField.Schema.Type.TEXT)
                    .defaultValueOfMixed(
                        listOf(
                            CustomMetadataField.Schema.DefaultValue.UnnamedSchemaWithArrayParent3
                                .ofBool(true),
                            CustomMetadataField.Schema.DefaultValue.UnnamedSchemaWithArrayParent3
                                .ofNumber(10.0),
                            CustomMetadataField.Schema.DefaultValue.UnnamedSchemaWithArrayParent3
                                .ofString("Hello"),
                        )
                    )
                    .isValueRequired(true)
                    .maxLength(0.0)
                    .maxValue("string")
                    .minLength(0.0)
                    .minValue("string")
                    .selectOptions(
                        listOf(
                            CustomMetadataField.Schema.SelectOption.ofString("small"),
                            CustomMetadataField.Schema.SelectOption.ofString("medium"),
                            CustomMetadataField.Schema.SelectOption.ofString("large"),
                            CustomMetadataField.Schema.SelectOption.ofNumber(30.0),
                            CustomMetadataField.Schema.SelectOption.ofNumber(40.0),
                            CustomMetadataField.Schema.SelectOption.ofBool(true),
                        )
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val customMetadataField =
            CustomMetadataField.builder()
                .id("id")
                .label("label")
                .name("name")
                .schema(
                    CustomMetadataField.Schema.builder()
                        .type(CustomMetadataField.Schema.Type.TEXT)
                        .defaultValueOfMixed(
                            listOf(
                                CustomMetadataField.Schema.DefaultValue
                                    .UnnamedSchemaWithArrayParent3
                                    .ofBool(true),
                                CustomMetadataField.Schema.DefaultValue
                                    .UnnamedSchemaWithArrayParent3
                                    .ofNumber(10.0),
                                CustomMetadataField.Schema.DefaultValue
                                    .UnnamedSchemaWithArrayParent3
                                    .ofString("Hello"),
                            )
                        )
                        .isValueRequired(true)
                        .maxLength(0.0)
                        .maxValue("string")
                        .minLength(0.0)
                        .minValue("string")
                        .selectOptions(
                            listOf(
                                CustomMetadataField.Schema.SelectOption.ofString("small"),
                                CustomMetadataField.Schema.SelectOption.ofString("medium"),
                                CustomMetadataField.Schema.SelectOption.ofString("large"),
                                CustomMetadataField.Schema.SelectOption.ofNumber(30.0),
                                CustomMetadataField.Schema.SelectOption.ofNumber(40.0),
                                CustomMetadataField.Schema.SelectOption.ofBool(true),
                            )
                        )
                        .build()
                )
                .build()

        val roundtrippedCustomMetadataField =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(customMetadataField),
                jacksonTypeRef<CustomMetadataField>(),
            )

        assertThat(roundtrippedCustomMetadataField).isEqualTo(customMetadataField)
    }
}
