// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.versions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VersionGetResponseTest {

    @Test
    fun create() {
        val versionGetResponse =
            VersionGetResponse.builder()
                .addAiTag(
                    VersionGetResponse.AiTag.builder()
                        .confidence(0.0)
                        .name("name")
                        .source("source")
                        .build()
                )
                .createdAt("createdAt")
                .customCoordinates("customCoordinates")
                .customMetadata(
                    VersionGetResponse.CustomMetadata.builder()
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
                .thumbnail("thumbnail")
                .type("type")
                .updatedAt("updatedAt")
                .url("url")
                .versionInfo(VersionGetResponse.VersionInfo.builder().id("id").name("name").build())
                .width(0.0)
                .build()

        assertThat(versionGetResponse.aiTags().getOrNull())
            .containsExactly(
                VersionGetResponse.AiTag.builder()
                    .confidence(0.0)
                    .name("name")
                    .source("source")
                    .build()
            )
        assertThat(versionGetResponse.createdAt()).contains("createdAt")
        assertThat(versionGetResponse.customCoordinates()).contains("customCoordinates")
        assertThat(versionGetResponse.customMetadata())
            .contains(
                VersionGetResponse.CustomMetadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(versionGetResponse.fileId()).contains("fileId")
        assertThat(versionGetResponse.filePath()).contains("filePath")
        assertThat(versionGetResponse.fileType()).contains("fileType")
        assertThat(versionGetResponse.hasAlpha()).contains(true)
        assertThat(versionGetResponse.height()).contains(0.0)
        assertThat(versionGetResponse.isPrivateFile()).contains(true)
        assertThat(versionGetResponse.isPublished()).contains(true)
        assertThat(versionGetResponse.mime()).contains("mime")
        assertThat(versionGetResponse.name()).contains("name")
        assertThat(versionGetResponse.size()).contains(0.0)
        assertThat(versionGetResponse.tags().getOrNull()).containsExactly("string")
        assertThat(versionGetResponse.thumbnail()).contains("thumbnail")
        assertThat(versionGetResponse.type()).contains("type")
        assertThat(versionGetResponse.updatedAt()).contains("updatedAt")
        assertThat(versionGetResponse.url()).contains("url")
        assertThat(versionGetResponse.versionInfo())
            .contains(VersionGetResponse.VersionInfo.builder().id("id").name("name").build())
        assertThat(versionGetResponse.width()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val versionGetResponse =
            VersionGetResponse.builder()
                .addAiTag(
                    VersionGetResponse.AiTag.builder()
                        .confidence(0.0)
                        .name("name")
                        .source("source")
                        .build()
                )
                .createdAt("createdAt")
                .customCoordinates("customCoordinates")
                .customMetadata(
                    VersionGetResponse.CustomMetadata.builder()
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
                .thumbnail("thumbnail")
                .type("type")
                .updatedAt("updatedAt")
                .url("url")
                .versionInfo(VersionGetResponse.VersionInfo.builder().id("id").name("name").build())
                .width(0.0)
                .build()

        val roundtrippedVersionGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(versionGetResponse),
                jacksonTypeRef<VersionGetResponse>(),
            )

        assertThat(roundtrippedVersionGetResponse).isEqualTo(versionGetResponse)
    }
}
