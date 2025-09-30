// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldCreateParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldListParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CustomMetadataFieldServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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
                            .defaultValue("string")
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

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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
                            .defaultValue("string")
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

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val customMetadataFieldServiceAsync = client.customMetadataFields()

        val customMetadataFieldFuture = customMetadataFieldServiceAsync.delete("id")

        val customMetadataField = customMetadataFieldFuture.get()
        customMetadataField.validate()
    }
}
