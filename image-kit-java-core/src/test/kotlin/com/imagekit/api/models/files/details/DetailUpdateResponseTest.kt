// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.details

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DetailUpdateResponseTest {

    @Test
    fun create() {
        val detailUpdateResponse =
            DetailUpdateResponse.builder()
                .addAiTag(
                    DetailUpdateResponse.AiTag.builder()
                        .confidence(0.0)
                        .name("name")
                        .source("source")
                        .build()
                )
                .createdAt("createdAt")
                .customCoordinates("customCoordinates")
                .customMetadata(JsonValue.from(mapOf<String, Any>()))
                .extensionStatus(
                    DetailUpdateResponse.ExtensionStatus.builder()
                        .awsAutoTagging(DetailUpdateResponse.ExtensionStatus.AwsAutoTagging.SUCCESS)
                        .googleAutoTagging(
                            DetailUpdateResponse.ExtensionStatus.GoogleAutoTagging.SUCCESS
                        )
                        .removeBg(DetailUpdateResponse.ExtensionStatus.RemoveBg.SUCCESS)
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
                .versionInfo(
                    DetailUpdateResponse.VersionInfo.builder().id("id").name("name").build()
                )
                .width(0.0)
                .build()

        assertThat(detailUpdateResponse.aiTags().getOrNull())
            .containsExactly(
                DetailUpdateResponse.AiTag.builder()
                    .confidence(0.0)
                    .name("name")
                    .source("source")
                    .build()
            )
        assertThat(detailUpdateResponse.createdAt()).contains("createdAt")
        assertThat(detailUpdateResponse.customCoordinates()).contains("customCoordinates")
        assertThat(detailUpdateResponse._customMetadata())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(detailUpdateResponse.extensionStatus())
            .contains(
                DetailUpdateResponse.ExtensionStatus.builder()
                    .awsAutoTagging(DetailUpdateResponse.ExtensionStatus.AwsAutoTagging.SUCCESS)
                    .googleAutoTagging(
                        DetailUpdateResponse.ExtensionStatus.GoogleAutoTagging.SUCCESS
                    )
                    .removeBg(DetailUpdateResponse.ExtensionStatus.RemoveBg.SUCCESS)
                    .build()
            )
        assertThat(detailUpdateResponse.fileId()).contains("fileId")
        assertThat(detailUpdateResponse.filePath()).contains("filePath")
        assertThat(detailUpdateResponse.fileType()).contains("fileType")
        assertThat(detailUpdateResponse.hasAlpha()).contains(true)
        assertThat(detailUpdateResponse.height()).contains(0.0)
        assertThat(detailUpdateResponse.isPrivateFile()).contains(true)
        assertThat(detailUpdateResponse.isPublished()).contains(true)
        assertThat(detailUpdateResponse.mime()).contains("mime")
        assertThat(detailUpdateResponse.name()).contains("name")
        assertThat(detailUpdateResponse.size()).contains(0.0)
        assertThat(detailUpdateResponse.tags().getOrNull()).containsExactly("string")
        assertThat(detailUpdateResponse.thumbnail()).contains("thumbnail")
        assertThat(detailUpdateResponse.type()).contains("type")
        assertThat(detailUpdateResponse.updatedAt()).contains("updatedAt")
        assertThat(detailUpdateResponse.url()).contains("url")
        assertThat(detailUpdateResponse.versionInfo())
            .contains(DetailUpdateResponse.VersionInfo.builder().id("id").name("name").build())
        assertThat(detailUpdateResponse.width()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val detailUpdateResponse =
            DetailUpdateResponse.builder()
                .addAiTag(
                    DetailUpdateResponse.AiTag.builder()
                        .confidence(0.0)
                        .name("name")
                        .source("source")
                        .build()
                )
                .createdAt("createdAt")
                .customCoordinates("customCoordinates")
                .customMetadata(JsonValue.from(mapOf<String, Any>()))
                .extensionStatus(
                    DetailUpdateResponse.ExtensionStatus.builder()
                        .awsAutoTagging(DetailUpdateResponse.ExtensionStatus.AwsAutoTagging.SUCCESS)
                        .googleAutoTagging(
                            DetailUpdateResponse.ExtensionStatus.GoogleAutoTagging.SUCCESS
                        )
                        .removeBg(DetailUpdateResponse.ExtensionStatus.RemoveBg.SUCCESS)
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
                .versionInfo(
                    DetailUpdateResponse.VersionInfo.builder().id("id").name("name").build()
                )
                .width(0.0)
                .build()

        val roundtrippedDetailUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(detailUpdateResponse),
                jacksonTypeRef<DetailUpdateResponse>(),
            )

        assertThat(roundtrippedDetailUpdateResponse).isEqualTo(detailUpdateResponse)
    }
}
