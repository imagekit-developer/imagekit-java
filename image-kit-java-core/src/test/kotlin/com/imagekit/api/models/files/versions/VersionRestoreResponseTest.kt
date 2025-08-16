// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.versions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VersionRestoreResponseTest {

    @Test
    fun create() {
        val versionRestoreResponse =
            VersionRestoreResponse.builder()
                .addAiTag(
                    VersionRestoreResponse.AiTag.builder()
                        .confidence(90.12)
                        .name("Shirt")
                        .source("google-auto-tagging")
                        .build()
                )
                .addAiTag(
                    VersionRestoreResponse.AiTag.builder()
                        .confidence(80.12)
                        .name("T-shirt")
                        .source("aws-auto-tagging")
                        .build()
                )
                .createdAt("2019-08-24T06:14:41.313Z")
                .customCoordinates(null)
                .customMetadata(JsonValue.from(mapOf("brand" to "Nike", "color" to "red")))
                .fileId("598821f949c0a938d57563bd")
                .filePath("/images/products/file.jpg")
                .fileType("image")
                .hasAlpha(false)
                .height(100.0)
                .isPrivateFile(false)
                .isPublished(true)
                .mime("image/jpeg")
                .name("file.jpg")
                .size(100.0)
                .tags(listOf("t-shirt", "round-neck", "sale2019"))
                .thumbnail(
                    "https://ik.imagekit.io/your_imagekit_id/images/products/file.jpg?updatedAt=1566630881313&tr=n-ik_ml_thumbnail"
                )
                .type("file")
                .updatedAt("2019-08-24T06:14:41.313Z")
                .url(
                    "https://ik.imagekit.io/your_imagekit_id/images/products/file.jpg?updatedAt=1566630881313"
                )
                .versionInfo(
                    VersionRestoreResponse.VersionInfo.builder()
                        .id("598821f949c0a938d57563bd")
                        .name("Version 2")
                        .build()
                )
                .width(100.0)
                .build()

        assertThat(versionRestoreResponse.aiTags().getOrNull())
            .containsExactly(
                VersionRestoreResponse.AiTag.builder()
                    .confidence(90.12)
                    .name("Shirt")
                    .source("google-auto-tagging")
                    .build(),
                VersionRestoreResponse.AiTag.builder()
                    .confidence(80.12)
                    .name("T-shirt")
                    .source("aws-auto-tagging")
                    .build(),
            )
        assertThat(versionRestoreResponse.createdAt()).contains("2019-08-24T06:14:41.313Z")
        assertThat(versionRestoreResponse.customCoordinates()).isEmpty
        assertThat(versionRestoreResponse._customMetadata())
            .isEqualTo(JsonValue.from(mapOf("brand" to "Nike", "color" to "red")))
        assertThat(versionRestoreResponse.fileId()).contains("598821f949c0a938d57563bd")
        assertThat(versionRestoreResponse.filePath()).contains("/images/products/file.jpg")
        assertThat(versionRestoreResponse.fileType()).contains("image")
        assertThat(versionRestoreResponse.hasAlpha()).contains(false)
        assertThat(versionRestoreResponse.height()).contains(100.0)
        assertThat(versionRestoreResponse.isPrivateFile()).contains(false)
        assertThat(versionRestoreResponse.isPublished()).contains(true)
        assertThat(versionRestoreResponse.mime()).contains("image/jpeg")
        assertThat(versionRestoreResponse.name()).contains("file.jpg")
        assertThat(versionRestoreResponse.size()).contains(100.0)
        assertThat(versionRestoreResponse.tags().getOrNull())
            .containsExactly("t-shirt", "round-neck", "sale2019")
        assertThat(versionRestoreResponse.thumbnail())
            .contains(
                "https://ik.imagekit.io/your_imagekit_id/images/products/file.jpg?updatedAt=1566630881313&tr=n-ik_ml_thumbnail"
            )
        assertThat(versionRestoreResponse.type()).contains("file")
        assertThat(versionRestoreResponse.updatedAt()).contains("2019-08-24T06:14:41.313Z")
        assertThat(versionRestoreResponse.url())
            .contains(
                "https://ik.imagekit.io/your_imagekit_id/images/products/file.jpg?updatedAt=1566630881313"
            )
        assertThat(versionRestoreResponse.versionInfo())
            .contains(
                VersionRestoreResponse.VersionInfo.builder()
                    .id("598821f949c0a938d57563bd")
                    .name("Version 2")
                    .build()
            )
        assertThat(versionRestoreResponse.width()).contains(100.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val versionRestoreResponse =
            VersionRestoreResponse.builder()
                .addAiTag(
                    VersionRestoreResponse.AiTag.builder()
                        .confidence(90.12)
                        .name("Shirt")
                        .source("google-auto-tagging")
                        .build()
                )
                .addAiTag(
                    VersionRestoreResponse.AiTag.builder()
                        .confidence(80.12)
                        .name("T-shirt")
                        .source("aws-auto-tagging")
                        .build()
                )
                .createdAt("2019-08-24T06:14:41.313Z")
                .customCoordinates(null)
                .customMetadata(JsonValue.from(mapOf("brand" to "Nike", "color" to "red")))
                .fileId("598821f949c0a938d57563bd")
                .filePath("/images/products/file.jpg")
                .fileType("image")
                .hasAlpha(false)
                .height(100.0)
                .isPrivateFile(false)
                .isPublished(true)
                .mime("image/jpeg")
                .name("file.jpg")
                .size(100.0)
                .tags(listOf("t-shirt", "round-neck", "sale2019"))
                .thumbnail(
                    "https://ik.imagekit.io/your_imagekit_id/images/products/file.jpg?updatedAt=1566630881313&tr=n-ik_ml_thumbnail"
                )
                .type("file")
                .updatedAt("2019-08-24T06:14:41.313Z")
                .url(
                    "https://ik.imagekit.io/your_imagekit_id/images/products/file.jpg?updatedAt=1566630881313"
                )
                .versionInfo(
                    VersionRestoreResponse.VersionInfo.builder()
                        .id("598821f949c0a938d57563bd")
                        .name("Version 2")
                        .build()
                )
                .width(100.0)
                .build()

        val roundtrippedVersionRestoreResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(versionRestoreResponse),
                jacksonTypeRef<VersionRestoreResponse>(),
            )

        assertThat(roundtrippedVersionRestoreResponse).isEqualTo(versionRestoreResponse)
    }
}
