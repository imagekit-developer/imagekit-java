// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileListResponseTest {

    @Test
    fun create() {
        val fileListResponse =
            FileListResponse.builder()
                .addAiTag(
                    FileListResponse.AiTag.builder()
                        .confidence(0.0)
                        .name("name")
                        .source("source")
                        .build()
                )
                .createdAt("createdAt")
                .customCoordinates("customCoordinates")
                .customMetadata(JsonValue.from(mapOf<String, Any>()))
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
                .thumbnail("thumbnail")
                .type("type")
                .updatedAt("updatedAt")
                .url("url")
                .versionInfo(FileListResponse.VersionInfo.builder().id("id").name("name").build())
                .width(0.0)
                .build()

        assertThat(fileListResponse.aiTags().getOrNull())
            .containsExactly(
                FileListResponse.AiTag.builder()
                    .confidence(0.0)
                    .name("name")
                    .source("source")
                    .build()
            )
        assertThat(fileListResponse.createdAt()).contains("createdAt")
        assertThat(fileListResponse.customCoordinates()).contains("customCoordinates")
        assertThat(fileListResponse._customMetadata())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(fileListResponse.fileId()).contains("fileId")
        assertThat(fileListResponse.filePath()).contains("filePath")
        assertThat(fileListResponse.fileType()).contains("fileType")
        assertThat(fileListResponse.hasAlpha()).contains(true)
        assertThat(fileListResponse.height()).contains(0.0)
        assertThat(fileListResponse.isPrivateFile()).contains(true)
        assertThat(fileListResponse.isPublished()).contains(true)
        assertThat(fileListResponse.mime()).contains("mime")
        assertThat(fileListResponse.name()).contains("name")
        assertThat(fileListResponse.size()).contains(0.0)
        assertThat(fileListResponse.tags().getOrNull()).containsExactly("string")
        assertThat(fileListResponse.thumbnail()).contains("thumbnail")
        assertThat(fileListResponse.type()).contains("type")
        assertThat(fileListResponse.updatedAt()).contains("updatedAt")
        assertThat(fileListResponse.url()).contains("url")
        assertThat(fileListResponse.versionInfo())
            .contains(FileListResponse.VersionInfo.builder().id("id").name("name").build())
        assertThat(fileListResponse.width()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileListResponse =
            FileListResponse.builder()
                .addAiTag(
                    FileListResponse.AiTag.builder()
                        .confidence(0.0)
                        .name("name")
                        .source("source")
                        .build()
                )
                .createdAt("createdAt")
                .customCoordinates("customCoordinates")
                .customMetadata(JsonValue.from(mapOf<String, Any>()))
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
                .thumbnail("thumbnail")
                .type("type")
                .updatedAt("updatedAt")
                .url("url")
                .versionInfo(FileListResponse.VersionInfo.builder().id("id").name("name").build())
                .width(0.0)
                .build()

        val roundtrippedFileListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileListResponse),
                jacksonTypeRef<FileListResponse>(),
            )

        assertThat(roundtrippedFileListResponse).isEqualTo(fileListResponse)
    }
}
