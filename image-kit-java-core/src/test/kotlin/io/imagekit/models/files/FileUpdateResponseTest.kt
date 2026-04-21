// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.JsonValue
import io.imagekit.core.jsonMapper
import io.imagekit.models.AiTag
import io.imagekit.models.CustomMetadata
import io.imagekit.models.EmbeddedMetadata
import io.imagekit.models.SelectedFieldsSchema
import io.imagekit.models.VersionInfo
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileUpdateResponseTest {

    @Test
    fun create() {
        val fileUpdateResponse =
            FileUpdateResponse.builder()
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
                .extensionStatus(
                    FileUpdateResponse.ExtensionStatus.builder()
                        .aiAutoDescription(
                            FileUpdateResponse.ExtensionStatus.AiAutoDescription.SUCCESS
                        )
                        .aiTasks(FileUpdateResponse.ExtensionStatus.AiTasks.SUCCESS)
                        .awsAutoTagging(FileUpdateResponse.ExtensionStatus.AwsAutoTagging.SUCCESS)
                        .googleAutoTagging(
                            FileUpdateResponse.ExtensionStatus.GoogleAutoTagging.SUCCESS
                        )
                        .removeBg(FileUpdateResponse.ExtensionStatus.RemoveBg.SUCCESS)
                        .build()
                )
                .build()

        assertThat(fileUpdateResponse.aiTags().getOrNull())
            .containsExactly(AiTag.builder().confidence(0.0).name("name").source("source").build())
        assertThat(fileUpdateResponse.audioCodec()).contains("audioCodec")
        assertThat(fileUpdateResponse.bitRate()).contains(0L)
        assertThat(fileUpdateResponse.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileUpdateResponse.customCoordinates()).contains("customCoordinates")
        assertThat(fileUpdateResponse.customMetadata())
            .contains(
                CustomMetadata.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
            )
        assertThat(fileUpdateResponse.description()).contains("description")
        assertThat(fileUpdateResponse.duration()).contains(0L)
        assertThat(fileUpdateResponse.embeddedMetadata())
            .contains(
                EmbeddedMetadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(fileUpdateResponse.fileId()).contains("fileId")
        assertThat(fileUpdateResponse.filePath()).contains("filePath")
        assertThat(fileUpdateResponse.fileType()).contains("fileType")
        assertThat(fileUpdateResponse.hasAlpha()).contains(true)
        assertThat(fileUpdateResponse.height()).contains(0.0)
        assertThat(fileUpdateResponse.isPrivateFile()).contains(true)
        assertThat(fileUpdateResponse.isPublished()).contains(true)
        assertThat(fileUpdateResponse.mime()).contains("mime")
        assertThat(fileUpdateResponse.name()).contains("name")
        assertThat(fileUpdateResponse.selectedFieldsSchema())
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
        assertThat(fileUpdateResponse.size()).contains(0.0)
        assertThat(fileUpdateResponse.tags().getOrNull()).containsExactly("string")
        assertThat(fileUpdateResponse.thumbnail()).contains("https://example.com")
        assertThat(fileUpdateResponse.type()).contains(File.Type.FILE)
        assertThat(fileUpdateResponse.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileUpdateResponse.url()).contains("https://example.com")
        assertThat(fileUpdateResponse.versionInfo())
            .contains(VersionInfo.builder().id("id").name("name").build())
        assertThat(fileUpdateResponse.videoCodec()).contains("videoCodec")
        assertThat(fileUpdateResponse.width()).contains(0.0)
        assertThat(fileUpdateResponse.extensionStatus())
            .contains(
                FileUpdateResponse.ExtensionStatus.builder()
                    .aiAutoDescription(FileUpdateResponse.ExtensionStatus.AiAutoDescription.SUCCESS)
                    .aiTasks(FileUpdateResponse.ExtensionStatus.AiTasks.SUCCESS)
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
                .extensionStatus(
                    FileUpdateResponse.ExtensionStatus.builder()
                        .aiAutoDescription(
                            FileUpdateResponse.ExtensionStatus.AiAutoDescription.SUCCESS
                        )
                        .aiTasks(FileUpdateResponse.ExtensionStatus.AiTasks.SUCCESS)
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
