// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.models.AiTag
import com.imagekit.api.models.CustomMetadata
import com.imagekit.api.models.EmbeddedMetadata
import com.imagekit.api.models.SelectedFieldsSchema
import com.imagekit.api.models.VersionInfo
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileTest {

    @Test
    fun create() {
        val file =
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

        assertThat(file.aiTags().getOrNull())
            .containsExactly(AiTag.builder().confidence(0.0).name("name").source("source").build())
        assertThat(file.audioCodec()).contains("audioCodec")
        assertThat(file.bitRate()).contains(0L)
        assertThat(file.createdAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(file.customCoordinates()).contains("customCoordinates")
        assertThat(file.customMetadata())
            .contains(
                CustomMetadata.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
            )
        assertThat(file.description()).contains("description")
        assertThat(file.duration()).contains(0L)
        assertThat(file.embeddedMetadata())
            .contains(
                EmbeddedMetadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(file.fileId()).contains("fileId")
        assertThat(file.filePath()).contains("filePath")
        assertThat(file.fileType()).contains("fileType")
        assertThat(file.hasAlpha()).contains(true)
        assertThat(file.height()).contains(0.0)
        assertThat(file.isPrivateFile()).contains(true)
        assertThat(file.isPublished()).contains(true)
        assertThat(file.mime()).contains("mime")
        assertThat(file.name()).contains("name")
        assertThat(file.selectedFieldsSchema())
            .contains(
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
            )
        assertThat(file.size()).contains(0.0)
        assertThat(file.tags().getOrNull()).containsExactly("string")
        assertThat(file.thumbnail()).contains("https://example.com")
        assertThat(file.type()).contains(File.Type.FILE)
        assertThat(file.updatedAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(file.url()).contains("https://example.com")
        assertThat(file.versionInfo()).contains(VersionInfo.builder().id("id").name("name").build())
        assertThat(file.videoCodec()).contains("videoCodec")
        assertThat(file.width()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val file =
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

        val roundtrippedFile =
            jsonMapper.readValue(jsonMapper.writeValueAsString(file), jacksonTypeRef<File>())

        assertThat(roundtrippedFile).isEqualTo(file)
    }
}
