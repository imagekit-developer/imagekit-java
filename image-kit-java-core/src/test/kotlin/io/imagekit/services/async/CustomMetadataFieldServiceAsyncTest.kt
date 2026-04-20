// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.models.custommetadatafields.CustomMetadataFieldCreateParams
import io.imagekit.models.custommetadatafields.CustomMetadataFieldListParams
import io.imagekit.models.custommetadatafields.CustomMetadataFieldUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CustomMetadataFieldServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val customMetadataFieldServiceAsync = client.customMetadataFields()

        val customMetadataFieldFuture =
            customMetadataFieldServiceAsync.create(
                CustomMetadataFieldCreateParams.builder()
                    .label("price")
                    .name("price")
                    .schema(
                        CustomMetadataFieldCreateParams.Schema.builder()
                            .type(CustomMetadataFieldCreateParams.Schema.Type.NUMBER)
                            .defaultValueOfMixed(
                                listOf(
                                    CustomMetadataFieldCreateParams.Schema.DefaultValue
                                        .DefaultValueItem
                                        .ofBool(true),
                                    CustomMetadataFieldCreateParams.Schema.DefaultValue
                                        .DefaultValueItem
                                        .ofNumber(10.0),
                                    CustomMetadataFieldCreateParams.Schema.DefaultValue
                                        .DefaultValueItem
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

        val customMetadataField = customMetadataFieldFuture.get()
        customMetadataField.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val customMetadataFieldServiceAsync = client.customMetadataFields()

        val customMetadataFieldFuture =
            customMetadataFieldServiceAsync.update(
                CustomMetadataFieldUpdateParams.builder()
                    .id("id")
                    .label("price")
                    .schema(
                        CustomMetadataFieldUpdateParams.Schema.builder()
                            .defaultValueOfMixed(
                                listOf(
                                    CustomMetadataFieldUpdateParams.Schema.DefaultValue
                                        .DefaultValueItem
                                        .ofBool(true),
                                    CustomMetadataFieldUpdateParams.Schema.DefaultValue
                                        .DefaultValueItem
                                        .ofNumber(10.0),
                                    CustomMetadataFieldUpdateParams.Schema.DefaultValue
                                        .DefaultValueItem
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

        val customMetadataField = customMetadataFieldFuture.get()
        customMetadataField.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val customMetadataFieldServiceAsync = client.customMetadataFields()

        val customMetadataFieldsFuture =
            customMetadataFieldServiceAsync.list(
                CustomMetadataFieldListParams.builder()
                    .folderPath("folderPath")
                    .includeDeleted(true)
                    .build()
            )

        val customMetadataFields = customMetadataFieldsFuture.get()
        customMetadataFields.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val customMetadataFieldServiceAsync = client.customMetadataFields()

        val customMetadataFieldFuture = customMetadataFieldServiceAsync.delete("id")

        val customMetadataField = customMetadataFieldFuture.get()
        customMetadataField.validate()
    }
}
