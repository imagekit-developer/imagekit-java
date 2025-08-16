// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.versions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VersionListResponseTest {

    @Test
    fun create() {
        val versionListResponse =
            VersionListResponse.builder()
                .addAiTag(
                    VersionListResponse.AiTag.builder()
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
                .versionInfo(
                    VersionListResponse.VersionInfo.builder().id("id").name("name").build()
                )
                .width(0.0)
                .build()

        assertThat(versionListResponse.aiTags().getOrNull())
            .containsExactly(
                VersionListResponse.AiTag.builder()
                    .confidence(0.0)
                    .name("name")
                    .source("source")
                    .build()
            )
        assertThat(versionListResponse.createdAt()).contains("createdAt")
        assertThat(versionListResponse.customCoordinates()).contains("customCoordinates")
        assertThat(versionListResponse._customMetadata())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(versionListResponse.fileId()).contains("fileId")
        assertThat(versionListResponse.filePath()).contains("filePath")
        assertThat(versionListResponse.fileType()).contains("fileType")
        assertThat(versionListResponse.hasAlpha()).contains(true)
        assertThat(versionListResponse.height()).contains(0.0)
        assertThat(versionListResponse.isPrivateFile()).contains(true)
        assertThat(versionListResponse.isPublished()).contains(true)
        assertThat(versionListResponse.mime()).contains("mime")
        assertThat(versionListResponse.name()).contains("name")
        assertThat(versionListResponse.size()).contains(0.0)
        assertThat(versionListResponse.tags().getOrNull()).containsExactly("string")
        assertThat(versionListResponse.thumbnail()).contains("thumbnail")
        assertThat(versionListResponse.type()).contains("type")
        assertThat(versionListResponse.updatedAt()).contains("updatedAt")
        assertThat(versionListResponse.url()).contains("url")
        assertThat(versionListResponse.versionInfo())
            .contains(VersionListResponse.VersionInfo.builder().id("id").name("name").build())
        assertThat(versionListResponse.width()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val versionListResponse =
            VersionListResponse.builder()
                .addAiTag(
                    VersionListResponse.AiTag.builder()
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
                .versionInfo(
                    VersionListResponse.VersionInfo.builder().id("id").name("name").build()
                )
                .width(0.0)
                .build()

        val roundtrippedVersionListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(versionListResponse),
                jacksonTypeRef<VersionListResponse>(),
            )

        assertThat(roundtrippedVersionListResponse).isEqualTo(versionListResponse)
    }
}
