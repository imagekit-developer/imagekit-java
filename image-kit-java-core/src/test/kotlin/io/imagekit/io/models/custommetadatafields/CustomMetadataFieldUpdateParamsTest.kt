// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.custommetadatafields

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomMetadataFieldUpdateParamsTest {

    @Test
    fun create() {
        CustomMetadataFieldUpdateParams.builder()
            .id("id")
            .label("price")
            .schema(
                CustomMetadataFieldUpdateParams.Schema.builder()
                    .defaultValueOfMixed(
                        listOf(
                            CustomMetadataFieldUpdateParams.Schema.DefaultValue.DefaultValueItem
                                .ofBool(true),
                            CustomMetadataFieldUpdateParams.Schema.DefaultValue.DefaultValueItem
                                .ofNumber(10.0),
                            CustomMetadataFieldUpdateParams.Schema.DefaultValue.DefaultValueItem
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
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofString("small"),
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofString("medium"),
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofString("large"),
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofNumber(30.0),
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofNumber(40.0),
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofBool(true),
                        )
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params = CustomMetadataFieldUpdateParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            CustomMetadataFieldUpdateParams.builder()
                .id("id")
                .label("price")
                .schema(
                    CustomMetadataFieldUpdateParams.Schema.builder()
                        .defaultValueOfMixed(
                            listOf(
                                CustomMetadataFieldUpdateParams.Schema.DefaultValue.DefaultValueItem
                                    .ofBool(true),
                                CustomMetadataFieldUpdateParams.Schema.DefaultValue.DefaultValueItem
                                    .ofNumber(10.0),
                                CustomMetadataFieldUpdateParams.Schema.DefaultValue.DefaultValueItem
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
                                CustomMetadataFieldUpdateParams.Schema.SelectOption.ofString(
                                    "small"
                                ),
                                CustomMetadataFieldUpdateParams.Schema.SelectOption.ofString(
                                    "medium"
                                ),
                                CustomMetadataFieldUpdateParams.Schema.SelectOption.ofString(
                                    "large"
                                ),
                                CustomMetadataFieldUpdateParams.Schema.SelectOption.ofNumber(30.0),
                                CustomMetadataFieldUpdateParams.Schema.SelectOption.ofNumber(40.0),
                                CustomMetadataFieldUpdateParams.Schema.SelectOption.ofBool(true),
                            )
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.label()).contains("price")
        assertThat(body.schema())
            .contains(
                CustomMetadataFieldUpdateParams.Schema.builder()
                    .defaultValueOfMixed(
                        listOf(
                            CustomMetadataFieldUpdateParams.Schema.DefaultValue.DefaultValueItem
                                .ofBool(true),
                            CustomMetadataFieldUpdateParams.Schema.DefaultValue.DefaultValueItem
                                .ofNumber(10.0),
                            CustomMetadataFieldUpdateParams.Schema.DefaultValue.DefaultValueItem
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
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofString("small"),
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofString("medium"),
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofString("large"),
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofNumber(30.0),
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofNumber(40.0),
                            CustomMetadataFieldUpdateParams.Schema.SelectOption.ofBool(true),
                        )
                    )
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = CustomMetadataFieldUpdateParams.builder().id("id").build()

        val body = params._body()
    }
}
