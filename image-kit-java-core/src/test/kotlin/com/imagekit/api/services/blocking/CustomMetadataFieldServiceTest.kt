// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldCreateParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldListParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CustomMetadataFieldServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val customMetadataFieldService = client.customMetadataFields()

        val customMetadataField =
            customMetadataFieldService.create(
                CustomMetadataFieldCreateParams.builder()
                    .label("price")
                    .name("price")
                    .schema(
                        CustomMetadataFieldCreateParams.Schema.builder()
                            .type(CustomMetadataFieldCreateParams.Schema.Type.NUMBER)
                            .defaultValueOfMixed(
                                listOf(
                                    CustomMetadataFieldCreateParams.Schema.DefaultValue
                                        .UnnamedSchemaWithArrayParent8
                                        .ofBool(true),
                                    CustomMetadataFieldCreateParams.Schema.DefaultValue
                                        .UnnamedSchemaWithArrayParent8
                                        .ofNumber(10.0),
                                    CustomMetadataFieldCreateParams.Schema.DefaultValue
                                        .UnnamedSchemaWithArrayParent8
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
                                    CustomMetadataFieldCreateParams.Schema.SelectOption.ofNumber(
                                        30.0
                                    ),
                                    CustomMetadataFieldCreateParams.Schema.SelectOption.ofNumber(
                                        40.0
                                    ),
                                    CustomMetadataFieldCreateParams.Schema.SelectOption.ofBool(true),
                                )
                            )
                            .build()
                    )
                    .build()
            )

        customMetadataField.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val customMetadataFieldService = client.customMetadataFields()

        val customMetadataField =
            customMetadataFieldService.update(
                CustomMetadataFieldUpdateParams.builder()
                    .id("id")
                    .label("price")
                    .schema(
                        CustomMetadataFieldUpdateParams.Schema.builder()
                            .defaultValueOfMixed(
                                listOf(
                                    CustomMetadataFieldUpdateParams.Schema.DefaultValue
                                        .UnnamedSchemaWithArrayParent9
                                        .ofBool(true),
                                    CustomMetadataFieldUpdateParams.Schema.DefaultValue
                                        .UnnamedSchemaWithArrayParent9
                                        .ofNumber(10.0),
                                    CustomMetadataFieldUpdateParams.Schema.DefaultValue
                                        .UnnamedSchemaWithArrayParent9
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
                                    CustomMetadataFieldUpdateParams.Schema.SelectOption.ofNumber(
                                        30.0
                                    ),
                                    CustomMetadataFieldUpdateParams.Schema.SelectOption.ofNumber(
                                        40.0
                                    ),
                                    CustomMetadataFieldUpdateParams.Schema.SelectOption.ofBool(true),
                                )
                            )
                            .build()
                    )
                    .build()
            )

        customMetadataField.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val customMetadataFieldService = client.customMetadataFields()

        val customMetadataFields =
            customMetadataFieldService.list(
                CustomMetadataFieldListParams.builder()
                    .folderPath("folderPath")
                    .includeDeleted(true)
                    .build()
            )

        customMetadataFields.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val customMetadataFieldService = client.customMetadataFields()

        val customMetadataField = customMetadataFieldService.delete("id")

        customMetadataField.validate()
    }
}
