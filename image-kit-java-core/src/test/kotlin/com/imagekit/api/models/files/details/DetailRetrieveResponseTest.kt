// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.details

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DetailRetrieveResponseTest {

    @Test
    fun create() {
        val detailRetrieveResponse =
            DetailRetrieveResponse.builder()
                .addAiTag(
                    DetailRetrieveResponse.AiTag.builder()
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
                    DetailRetrieveResponse.VersionInfo.builder().id("id").name("name").build()
                )
                .width(0.0)
                .build()

        assertThat(detailRetrieveResponse.aiTags().getOrNull())
            .containsExactly(
                DetailRetrieveResponse.AiTag.builder()
                    .confidence(0.0)
                    .name("name")
                    .source("source")
                    .build()
            )
        assertThat(detailRetrieveResponse.createdAt()).contains("createdAt")
        assertThat(detailRetrieveResponse.customCoordinates()).contains("customCoordinates")
        assertThat(detailRetrieveResponse._customMetadata())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(detailRetrieveResponse.fileId()).contains("fileId")
        assertThat(detailRetrieveResponse.filePath()).contains("filePath")
        assertThat(detailRetrieveResponse.fileType()).contains("fileType")
        assertThat(detailRetrieveResponse.hasAlpha()).contains(true)
        assertThat(detailRetrieveResponse.height()).contains(0.0)
        assertThat(detailRetrieveResponse.isPrivateFile()).contains(true)
        assertThat(detailRetrieveResponse.isPublished()).contains(true)
        assertThat(detailRetrieveResponse.mime()).contains("mime")
        assertThat(detailRetrieveResponse.name()).contains("name")
        assertThat(detailRetrieveResponse.size()).contains(0.0)
        assertThat(detailRetrieveResponse.tags().getOrNull()).containsExactly("string")
        assertThat(detailRetrieveResponse.thumbnail()).contains("thumbnail")
        assertThat(detailRetrieveResponse.type()).contains("type")
        assertThat(detailRetrieveResponse.updatedAt()).contains("updatedAt")
        assertThat(detailRetrieveResponse.url()).contains("url")
        assertThat(detailRetrieveResponse.versionInfo())
            .contains(DetailRetrieveResponse.VersionInfo.builder().id("id").name("name").build())
        assertThat(detailRetrieveResponse.width()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val detailRetrieveResponse =
            DetailRetrieveResponse.builder()
                .addAiTag(
                    DetailRetrieveResponse.AiTag.builder()
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
                    DetailRetrieveResponse.VersionInfo.builder().id("id").name("name").build()
                )
                .width(0.0)
                .build()

        val roundtrippedDetailRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(detailRetrieveResponse),
                jacksonTypeRef<DetailRetrieveResponse>(),
            )

        assertThat(roundtrippedDetailRetrieveResponse).isEqualTo(detailRetrieveResponse)
    }
}
