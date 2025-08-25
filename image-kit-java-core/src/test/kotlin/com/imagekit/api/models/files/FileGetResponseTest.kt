// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileGetResponseTest {

    @Test
    fun create() {
        val fileGetResponse =
            FileGetResponse.builder()
                .addAiTag(
                    FileGetResponse.AiTag.builder()
                        .confidence(0.0)
                        .name("name")
                        .source("source")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customCoordinates("customCoordinates")
                .customMetadata(
                    FileGetResponse.CustomMetadata.builder()
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
                .size(0.0)
                .addTag("string")
                .thumbnail("https://example.com")
                .type(FileGetResponse.Type.FILE)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .url("https://example.com")
                .versionInfo(FileGetResponse.VersionInfo.builder().id("id").name("name").build())
                .width(0.0)
                .build()

        assertThat(fileGetResponse.aiTags().getOrNull())
            .containsExactly(
                FileGetResponse.AiTag.builder()
                    .confidence(0.0)
                    .name("name")
                    .source("source")
                    .build()
            )
        assertThat(fileGetResponse.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileGetResponse.customCoordinates()).contains("customCoordinates")
        assertThat(fileGetResponse.customMetadata())
            .contains(
                FileGetResponse.CustomMetadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(fileGetResponse.fileId()).contains("fileId")
        assertThat(fileGetResponse.filePath()).contains("filePath")
        assertThat(fileGetResponse.fileType()).contains("fileType")
        assertThat(fileGetResponse.hasAlpha()).contains(true)
        assertThat(fileGetResponse.height()).contains(0.0)
        assertThat(fileGetResponse.isPrivateFile()).contains(true)
        assertThat(fileGetResponse.isPublished()).contains(true)
        assertThat(fileGetResponse.mime()).contains("mime")
        assertThat(fileGetResponse.name()).contains("name")
        assertThat(fileGetResponse.size()).contains(0.0)
        assertThat(fileGetResponse.tags().getOrNull()).containsExactly("string")
        assertThat(fileGetResponse.thumbnail()).contains("https://example.com")
        assertThat(fileGetResponse.type()).contains(FileGetResponse.Type.FILE)
        assertThat(fileGetResponse.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileGetResponse.url()).contains("https://example.com")
        assertThat(fileGetResponse.versionInfo())
            .contains(FileGetResponse.VersionInfo.builder().id("id").name("name").build())
        assertThat(fileGetResponse.width()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileGetResponse =
            FileGetResponse.builder()
                .addAiTag(
                    FileGetResponse.AiTag.builder()
                        .confidence(0.0)
                        .name("name")
                        .source("source")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customCoordinates("customCoordinates")
                .customMetadata(
                    FileGetResponse.CustomMetadata.builder()
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
                .size(0.0)
                .addTag("string")
                .thumbnail("https://example.com")
                .type(FileGetResponse.Type.FILE)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .url("https://example.com")
                .versionInfo(FileGetResponse.VersionInfo.builder().id("id").name("name").build())
                .width(0.0)
                .build()

        val roundtrippedFileGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileGetResponse),
                jacksonTypeRef<FileGetResponse>(),
            )

        assertThat(roundtrippedFileGetResponse).isEqualTo(fileGetResponse)
    }
}
