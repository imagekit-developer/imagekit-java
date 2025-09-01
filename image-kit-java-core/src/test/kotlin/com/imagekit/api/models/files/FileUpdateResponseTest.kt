// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileUpdateResponseTest {

    @Test
    fun create() {
        val fileUpdateResponse =
            FileUpdateResponse.builder()
                .addAiTag(
                    File.AiTag.builder().confidence(0.0).name("name").source("source").build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customCoordinates("customCoordinates")
                .customMetadata(
                    File.CustomMetadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
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
                .type(File.Type.FILE)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .url("https://example.com")
                .versionInfo(File.VersionInfo.builder().id("id").name("name").build())
                .width(0.0)
                .extensionStatus(
                    FileUpdateResponse.ExtensionStatus.builder()
                        .aiAutoDescription(
                            FileUpdateResponse.ExtensionStatus.AiAutoDescription.SUCCESS
                        )
                        .awsAutoTagging(FileUpdateResponse.ExtensionStatus.AwsAutoTagging.SUCCESS)
                        .googleAutoTagging(
                            FileUpdateResponse.ExtensionStatus.GoogleAutoTagging.SUCCESS
                        )
                        .removeBg(FileUpdateResponse.ExtensionStatus.RemoveBg.SUCCESS)
                        .build()
                )
                .build()

        assertThat(fileUpdateResponse.aiTags().getOrNull())
            .containsExactly(
                File.AiTag.builder().confidence(0.0).name("name").source("source").build()
            )
        assertThat(fileUpdateResponse.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileUpdateResponse.customCoordinates()).contains("customCoordinates")
        assertThat(fileUpdateResponse.customMetadata())
            .contains(
                File.CustomMetadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(fileUpdateResponse.description()).contains("description")
        assertThat(fileUpdateResponse.fileId()).contains("fileId")
        assertThat(fileUpdateResponse.filePath()).contains("filePath")
        assertThat(fileUpdateResponse.fileType()).contains("fileType")
        assertThat(fileUpdateResponse.hasAlpha()).contains(true)
        assertThat(fileUpdateResponse.height()).contains(0.0)
        assertThat(fileUpdateResponse.isPrivateFile()).contains(true)
        assertThat(fileUpdateResponse.isPublished()).contains(true)
        assertThat(fileUpdateResponse.mime()).contains("mime")
        assertThat(fileUpdateResponse.name()).contains("name")
        assertThat(fileUpdateResponse.size()).contains(0.0)
        assertThat(fileUpdateResponse.tags().getOrNull()).containsExactly("string")
        assertThat(fileUpdateResponse.thumbnail()).contains("https://example.com")
        assertThat(fileUpdateResponse.type()).contains(File.Type.FILE)
        assertThat(fileUpdateResponse.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileUpdateResponse.url()).contains("https://example.com")
        assertThat(fileUpdateResponse.versionInfo())
            .contains(File.VersionInfo.builder().id("id").name("name").build())
        assertThat(fileUpdateResponse.width()).contains(0.0)
        assertThat(fileUpdateResponse.extensionStatus())
            .contains(
                FileUpdateResponse.ExtensionStatus.builder()
                    .aiAutoDescription(FileUpdateResponse.ExtensionStatus.AiAutoDescription.SUCCESS)
                    .awsAutoTagging(FileUpdateResponse.ExtensionStatus.AwsAutoTagging.SUCCESS)
                    .googleAutoTagging(FileUpdateResponse.ExtensionStatus.GoogleAutoTagging.SUCCESS)
                    .removeBg(FileUpdateResponse.ExtensionStatus.RemoveBg.SUCCESS)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileUpdateResponse =
            FileUpdateResponse.builder()
                .addAiTag(
                    File.AiTag.builder().confidence(0.0).name("name").source("source").build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customCoordinates("customCoordinates")
                .customMetadata(
                    File.CustomMetadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
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
                .type(File.Type.FILE)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .url("https://example.com")
                .versionInfo(File.VersionInfo.builder().id("id").name("name").build())
                .width(0.0)
                .extensionStatus(
                    FileUpdateResponse.ExtensionStatus.builder()
                        .aiAutoDescription(
                            FileUpdateResponse.ExtensionStatus.AiAutoDescription.SUCCESS
                        )
                        .awsAutoTagging(FileUpdateResponse.ExtensionStatus.AwsAutoTagging.SUCCESS)
                        .googleAutoTagging(
                            FileUpdateResponse.ExtensionStatus.GoogleAutoTagging.SUCCESS
                        )
                        .removeBg(FileUpdateResponse.ExtensionStatus.RemoveBg.SUCCESS)
                        .build()
                )
                .build()

        val roundtrippedFileUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileUpdateResponse),
                jacksonTypeRef<FileUpdateResponse>(),
            )

        assertThat(roundtrippedFileUpdateResponse).isEqualTo(fileUpdateResponse)
    }
}
