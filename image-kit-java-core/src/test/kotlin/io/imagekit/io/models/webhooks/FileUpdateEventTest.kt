// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.io.core.JsonValue
import io.imagekit.io.core.jsonMapper
import io.imagekit.io.models.AiTag
import io.imagekit.io.models.CustomMetadata
import io.imagekit.io.models.EmbeddedMetadata
import io.imagekit.io.models.SelectedFieldsSchema
import io.imagekit.io.models.VersionInfo
import io.imagekit.io.models.files.File
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileUpdateEventTest {

    @Test
    fun create() {
        val fileUpdateEvent =
            FileUpdateEvent.builder()
                .id("id")
                .type("file.updated")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    File.builder()
                        .addAiTag(
                            AiTag.builder().confidence(0.0).name("name").source("source").build()
                        )
                        .audioCodec("audioCodec")
                        .bitRate(0L)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customCoordinates("customCoordinates")
                        .customMetadata(
                            CustomMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .duration(0L)
                        .embeddedMetadata(
                            EmbeddedMetadata.builder()
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
                        .versionInfo(VersionInfo.builder().id("id").name("name").build())
                        .videoCodec("videoCodec")
                        .width(0.0)
                        .build()
                )
                .build()

        assertThat(fileUpdateEvent.id()).isEqualTo("id")
        assertThat(fileUpdateEvent.type()).isEqualTo("file.updated")
        assertThat(fileUpdateEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileUpdateEvent.data())
            .isEqualTo(
                File.builder()
                    .addAiTag(AiTag.builder().confidence(0.0).name("name").source("source").build())
                    .audioCodec("audioCodec")
                    .bitRate(0L)
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .customCoordinates("customCoordinates")
                    .customMetadata(
                        CustomMetadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .description("description")
                    .duration(0L)
                    .embeddedMetadata(
                        EmbeddedMetadata.builder()
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
                    .versionInfo(VersionInfo.builder().id("id").name("name").build())
                    .videoCodec("videoCodec")
                    .width(0.0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileUpdateEvent =
            FileUpdateEvent.builder()
                .id("id")
                .type("file.updated")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    File.builder()
                        .addAiTag(
                            AiTag.builder().confidence(0.0).name("name").source("source").build()
                        )
                        .audioCodec("audioCodec")
                        .bitRate(0L)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customCoordinates("customCoordinates")
                        .customMetadata(
                            CustomMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .duration(0L)
                        .embeddedMetadata(
                            EmbeddedMetadata.builder()
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
                        .versionInfo(VersionInfo.builder().id("id").name("name").build())
                        .videoCodec("videoCodec")
                        .width(0.0)
                        .build()
                )
                .build()

        val roundtrippedFileUpdateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileUpdateEvent),
                jacksonTypeRef<FileUpdateEvent>(),
            )

        assertThat(roundtrippedFileUpdateEvent).isEqualTo(fileUpdateEvent)
    }
}
