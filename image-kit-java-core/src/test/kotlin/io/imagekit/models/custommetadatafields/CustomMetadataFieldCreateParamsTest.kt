// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.custommetadatafields

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomMetadataFieldCreateParamsTest {

    @Test
    fun create() {
        CustomMetadataFieldCreateParams.builder()
            .label("price")
            .name("price")
            .schema(
                CustomMetadataFieldCreateParams.Schema.builder()
                    .type(CustomMetadataFieldCreateParams.Schema.Type.NUMBER)
                    .defaultValueOfMixed(
                        listOf(
                            CustomMetadataFieldCreateParams.Schema.DefaultValue.DefaultValueItem
                                .ofBool(true),
                            CustomMetadataFieldCreateParams.Schema.DefaultValue.DefaultValueItem
                                .ofNumber(10.0),
                            CustomMetadataFieldCreateParams.Schema.DefaultValue.DefaultValueItem
                                .ofString("Hello"),
                        )
                    )
                    .isValueRequired(true)
                    .maxLength(0.0)
                    .maxValue(3000.0)
                    .minLength(0.0)
                    .minValue(1000.0)
                    .selectOptions(
                        listOf(
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofString("small"),
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofString("medium"),
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofString("large"),
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofNumber(30.0),
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofNumber(40.0),
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofBool(true),
                        )
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            CustomMetadataFieldCreateParams.builder()
                .label("price")
                .name("price")
                .schema(
                    CustomMetadataFieldCreateParams.Schema.builder()
                        .type(CustomMetadataFieldCreateParams.Schema.Type.NUMBER)
                        .defaultValueOfMixed(
                            listOf(
                                CustomMetadataFieldCreateParams.Schema.DefaultValue.DefaultValueItem
                                    .ofBool(true),
                                CustomMetadataFieldCreateParams.Schema.DefaultValue.DefaultValueItem
                                    .ofNumber(10.0),
                                CustomMetadataFieldCreateParams.Schema.DefaultValue.DefaultValueItem
                                    .ofString("Hello"),
                            )
                        )
                        .isValueRequired(true)
                        .maxLength(0.0)
                        .maxValue(3000.0)
                        .minLength(0.0)
                        .minValue(1000.0)
                        .selectOptions(
                            listOf(
                                CustomMetadataFieldCreateParams.Schema.SelectOption.ofString(
                                    "small"
                                ),
                                CustomMetadataFieldCreateParams.Schema.SelectOption.ofString(
                                    "medium"
                                ),
                                CustomMetadataFieldCreateParams.Schema.SelectOption.ofString(
                                    "large"
                                ),
                                CustomMetadataFieldCreateParams.Schema.SelectOption.ofNumber(30.0),
                                CustomMetadataFieldCreateParams.Schema.SelectOption.ofNumber(40.0),
                                CustomMetadataFieldCreateParams.Schema.SelectOption.ofBool(true),
                            )
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.label()).isEqualTo("price")
        assertThat(body.name()).isEqualTo("price")
        assertThat(body.schema())
            .isEqualTo(
                CustomMetadataFieldCreateParams.Schema.builder()
                    .type(CustomMetadataFieldCreateParams.Schema.Type.NUMBER)
                    .defaultValueOfMixed(
                        listOf(
                            CustomMetadataFieldCreateParams.Schema.DefaultValue.DefaultValueItem
                                .ofBool(true),
                            CustomMetadataFieldCreateParams.Schema.DefaultValue.DefaultValueItem
                                .ofNumber(10.0),
                            CustomMetadataFieldCreateParams.Schema.DefaultValue.DefaultValueItem
                                .ofString("Hello"),
                        )
                    )
                    .isValueRequired(true)
                    .maxLength(0.0)
                    .maxValue(3000.0)
                    .minLength(0.0)
                    .minValue(1000.0)
                    .selectOptions(
                        listOf(
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofString("small"),
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofString("medium"),
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofString("large"),
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofNumber(30.0),
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofNumber(40.0),
                            CustomMetadataFieldCreateParams.Schema.SelectOption.ofBool(true),
                        )
                    )
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CustomMetadataFieldCreateParams.builder()
                .label("price")
                .name("price")
                .schema(
                    CustomMetadataFieldCreateParams.Schema.builder()
                        .type(CustomMetadataFieldCreateParams.Schema.Type.NUMBER)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.label()).isEqualTo("price")
        assertThat(body.name()).isEqualTo("price")
        assertThat(body.schema())
            .isEqualTo(
                CustomMetadataFieldCreateParams.Schema.builder()
                    .type(CustomMetadataFieldCreateParams.Schema.Type.NUMBER)
                    .build()
            )
    }
}
