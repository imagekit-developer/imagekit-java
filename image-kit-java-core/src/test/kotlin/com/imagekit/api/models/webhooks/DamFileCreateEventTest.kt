// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.models.files.File
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DamFileCreateEventTest {

    @Test
    fun create() {
        val damFileCreateEvent =
            DamFileCreateEvent.builder()
                .id("id")
                .type("file.created")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    File.builder()
                        .addAiTag(
                            File.AiTag.builder()
                                .confidence(0.0)
                                .name("name")
                                .source("source")
                                .build()
                        )
                        .audioCodec("audioCodec")
                        .bitRate(0L)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customCoordinates("customCoordinates")
                        .customMetadata(
                            File.CustomMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .duration(0L)
                        .embeddedMetadata(
                            File.EmbeddedMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .fileId("fileId")
                        .filePath("filePath")
                        .fileType("fileType")
                        .hasAlpha(true)
                        .height(0.0)
                        .isPrivateFile(true)
                        .isPublished(true)
                        .mime("mime")
                        .name("name")
                        .selectedFieldsSchema(
                            File.SelectedFieldsSchema.builder()
                                .putAdditionalProperty(
                                    "foo",
                                    JsonValue.from(
                                        mapOf(
                                            "type" to "Text",
                                            "defaultValue" to "string",
                                            "isValueRequired" to true,
                                            "maxLength" to 0,
                                            "maxValue" to "string",
                                            "minLength" to 0,
                                            "minValue" to "string",
                                            "readOnly" to true,
                                            "selectOptions" to
                                                listOf("small", "medium", "large", 30, 40, true),
                                            "selectOptionsTruncated" to true,
                                        )
                                    ),
                                )
                                .build()
                        )
                        .size(0.0)
                        .addTag("string")
                        .thumbnail("https://example.com")
                        .type(File.Type.FILE)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .url("https://example.com")
                        .versionInfo(File.VersionInfo.builder().id("id").name("name").build())
                        .videoCodec("videoCodec")
                        .width(0.0)
                        .build()
                )
                .build()

        assertThat(damFileCreateEvent.id()).isEqualTo("id")
        assertThat(damFileCreateEvent.type()).isEqualTo("file.created")
        assertThat(damFileCreateEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(damFileCreateEvent.data())
            .isEqualTo(
                File.builder()
                    .addAiTag(
                        File.AiTag.builder().confidence(0.0).name("name").source("source").build()
                    )
                    .audioCodec("audioCodec")
                    .bitRate(0L)
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .customCoordinates("customCoordinates")
                    .customMetadata(
                        File.CustomMetadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .description("description")
                    .duration(0L)
                    .embeddedMetadata(
                        File.EmbeddedMetadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .fileId("fileId")
                    .filePath("filePath")
                    .fileType("fileType")
                    .hasAlpha(true)
                    .height(0.0)
                    .isPrivateFile(true)
                    .isPublished(true)
                    .mime("mime")
                    .name("name")
                    .selectedFieldsSchema(
                        File.SelectedFieldsSchema.builder()
                            .putAdditionalProperty(
                                "foo",
                                JsonValue.from(
                                    mapOf(
                                        "type" to "Text",
                                        "defaultValue" to "string",
                                        "isValueRequired" to true,
                                        "maxLength" to 0,
                                        "maxValue" to "string",
                                        "minLength" to 0,
                                        "minValue" to "string",
                                        "readOnly" to true,
                                        "selectOptions" to
                                            listOf("small", "medium", "large", 30, 40, true),
                                        "selectOptionsTruncated" to true,
                                    )
                                ),
                            )
                            .build()
                    )
                    .size(0.0)
                    .addTag("string")
                    .thumbnail("https://example.com")
                    .type(File.Type.FILE)
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .url("https://example.com")
                    .versionInfo(File.VersionInfo.builder().id("id").name("name").build())
                    .videoCodec("videoCodec")
                    .width(0.0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val damFileCreateEvent =
            DamFileCreateEvent.builder()
                .id("id")
                .type("file.created")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    File.builder()
                        .addAiTag(
                            File.AiTag.builder()
                                .confidence(0.0)
                                .name("name")
                                .source("source")
                                .build()
                        )
                        .audioCodec("audioCodec")
                        .bitRate(0L)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customCoordinates("customCoordinates")
                        .customMetadata(
                            File.CustomMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .duration(0L)
                        .embeddedMetadata(
                            File.EmbeddedMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .fileId("fileId")
                        .filePath("filePath")
                        .fileType("fileType")
                        .hasAlpha(true)
                        .height(0.0)
                        .isPrivateFile(true)
                        .isPublished(true)
                        .mime("mime")
                        .name("name")
                        .selectedFieldsSchema(
                            File.SelectedFieldsSchema.builder()
                                .putAdditionalProperty(
                                    "foo",
                                    JsonValue.from(
                                        mapOf(
                                            "type" to "Text",
                                            "defaultValue" to "string",
                                            "isValueRequired" to true,
                                            "maxLength" to 0,
                                            "maxValue" to "string",
                                            "minLength" to 0,
                                            "minValue" to "string",
                                            "readOnly" to true,
                                            "selectOptions" to
                                                listOf("small", "medium", "large", 30, 40, true),
                                            "selectOptionsTruncated" to true,
                                        )
                                    ),
                                )
                                .build()
                        )
                        .size(0.0)
                        .addTag("string")
                        .thumbnail("https://example.com")
                        .type(File.Type.FILE)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .url("https://example.com")
                        .versionInfo(File.VersionInfo.builder().id("id").name("name").build())
                        .videoCodec("videoCodec")
                        .width(0.0)
                        .build()
                )
                .build()

        val roundtrippedDamFileCreateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(damFileCreateEvent),
                jacksonTypeRef<DamFileCreateEvent>(),
            )

        assertThat(roundtrippedDamFileCreateEvent).isEqualTo(damFileCreateEvent)
    }
}
