// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.versions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VersionRetrieveResponseTest {

    @Test
    fun create() {
        val versionRetrieveResponse =
            VersionRetrieveResponse.builder()
                .addAiTag(
                    VersionRetrieveResponse.AiTag.builder()
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
                    VersionRetrieveResponse.VersionInfo.builder().id("id").name("name").build()
                )
                .width(0.0)
                .build()

        assertThat(versionRetrieveResponse.aiTags().getOrNull())
            .containsExactly(
                VersionRetrieveResponse.AiTag.builder()
                    .confidence(0.0)
                    .name("name")
                    .source("source")
                    .build()
            )
        assertThat(versionRetrieveResponse.createdAt()).contains("createdAt")
        assertThat(versionRetrieveResponse.customCoordinates()).contains("customCoordinates")
        assertThat(versionRetrieveResponse._customMetadata())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(versionRetrieveResponse.fileId()).contains("fileId")
        assertThat(versionRetrieveResponse.filePath()).contains("filePath")
        assertThat(versionRetrieveResponse.fileType()).contains("fileType")
        assertThat(versionRetrieveResponse.hasAlpha()).contains(true)
        assertThat(versionRetrieveResponse.height()).contains(0.0)
        assertThat(versionRetrieveResponse.isPrivateFile()).contains(true)
        assertThat(versionRetrieveResponse.isPublished()).contains(true)
        assertThat(versionRetrieveResponse.mime()).contains("mime")
        assertThat(versionRetrieveResponse.name()).contains("name")
        assertThat(versionRetrieveResponse.size()).contains(0.0)
        assertThat(versionRetrieveResponse.tags().getOrNull()).containsExactly("string")
        assertThat(versionRetrieveResponse.thumbnail()).contains("thumbnail")
        assertThat(versionRetrieveResponse.type()).contains("type")
        assertThat(versionRetrieveResponse.updatedAt()).contains("updatedAt")
        assertThat(versionRetrieveResponse.url()).contains("url")
        assertThat(versionRetrieveResponse.versionInfo())
            .contains(VersionRetrieveResponse.VersionInfo.builder().id("id").name("name").build())
        assertThat(versionRetrieveResponse.width()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val versionRetrieveResponse =
            VersionRetrieveResponse.builder()
                .addAiTag(
                    VersionRetrieveResponse.AiTag.builder()
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
                    VersionRetrieveResponse.VersionInfo.builder().id("id").name("name").build()
                )
                .width(0.0)
                .build()

        val roundtrippedVersionRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(versionRetrieveResponse),
                jacksonTypeRef<VersionRetrieveResponse>(),
            )

        assertThat(roundtrippedVersionRetrieveResponse).isEqualTo(versionRetrieveResponse)
    }
}
