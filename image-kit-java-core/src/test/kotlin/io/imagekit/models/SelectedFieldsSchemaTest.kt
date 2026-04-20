// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.JsonValue
import io.imagekit.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SelectedFieldsSchemaTest {

    @Test
    fun create() {
        val selectedFieldsSchema =
            SelectedFieldsSchema.builder()
                .putAdditionalProperty(
                    "foo",
                    JsonValue.from(
                        mapOf(
                            "type" to "Text",
                            "defaultValue" to listOf(true, 10, "Hello"),
                            "isValueRequired" to true,
                            "maxLength" to 0,
                            "maxValue" to "string",
                            "minLength" to 0,
                            "minValue" to "string",
                            "readOnly" to true,
                            "selectOptions" to listOf("small", "medium", "large", 30, 40, true),
                            "selectOptionsTruncated" to true,
                        )
                    ),
                )
                .build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val selectedFieldsSchema =
            SelectedFieldsSchema.builder()
                .putAdditionalProperty(
                    "foo",
                    JsonValue.from(
                        mapOf(
                            "type" to "Text",
                            "defaultValue" to listOf(true, 10, "Hello"),
                            "isValueRequired" to true,
                            "maxLength" to 0,
                            "maxValue" to "string",
                            "minLength" to 0,
                            "minValue" to "string",
                            "readOnly" to true,
                            "selectOptions" to listOf("small", "medium", "large", 30, 40, true),
                            "selectOptionsTruncated" to true,
                        )
                    ),
                )
                .build()

        val roundtrippedSelectedFieldsSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(selectedFieldsSchema),
                jacksonTypeRef<SelectedFieldsSchema>(),
            )

        assertThat(roundtrippedSelectedFieldsSchema).isEqualTo(selectedFieldsSchema)
    }
}
