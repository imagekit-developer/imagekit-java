// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.assets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AssetListResponseTest {

    @Test
    fun ofFileDetails() {
        val fileDetails =
            AssetListResponse.FileDetails.builder()
                .addAiTag(
                    AssetListResponse.FileDetails.AiTag.builder()
                        .confidence(0.0)
                        .name("name")
                        .source("source")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customCoordinates("customCoordinates")
                .customMetadata(
                    AssetListResponse.FileDetails.CustomMetadata.builder()
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
                .type(AssetListResponse.FileDetails.Type.FILE)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .url("https://example.com")
                .versionInfo(
                    AssetListResponse.FileDetails.VersionInfo.builder()
                        .id("id")
                        .name("name")
                        .build()
                )
                .width(0.0)
                .build()

        val assetListResponse = AssetListResponse.ofFileDetails(fileDetails)

        assertThat(assetListResponse.fileDetails()).contains(fileDetails)
        assertThat(assetListResponse.folder()).isEmpty
    }

    @Test
    fun ofFileDetailsRoundtrip() {
        val jsonMapper = jsonMapper()
        val assetListResponse =
            AssetListResponse.ofFileDetails(
                AssetListResponse.FileDetails.builder()
                    .addAiTag(
                        AssetListResponse.FileDetails.AiTag.builder()
                            .confidence(0.0)
                            .name("name")
                            .source("source")
                            .build()
                    )
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .customCoordinates("customCoordinates")
                    .customMetadata(
                        AssetListResponse.FileDetails.CustomMetadata.builder()
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
                    .type(AssetListResponse.FileDetails.Type.FILE)
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .url("https://example.com")
                    .versionInfo(
                        AssetListResponse.FileDetails.VersionInfo.builder()
                            .id("id")
                            .name("name")
                            .build()
                    )
                    .width(0.0)
                    .build()
            )

        val roundtrippedAssetListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assetListResponse),
                jacksonTypeRef<AssetListResponse>(),
            )

        assertThat(roundtrippedAssetListResponse).isEqualTo(assetListResponse)
    }

    @Test
    fun ofFolder() {
        val folder =
            AssetListResponse.Folder.builder()
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .folderId("folderId")
                .folderPath("folderPath")
                .name("name")
                .type(AssetListResponse.Folder.Type.FOLDER)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val assetListResponse = AssetListResponse.ofFolder(folder)

        assertThat(assetListResponse.fileDetails()).isEmpty
        assertThat(assetListResponse.folder()).contains(folder)
    }

    @Test
    fun ofFolderRoundtrip() {
        val jsonMapper = jsonMapper()
        val assetListResponse =
            AssetListResponse.ofFolder(
                AssetListResponse.Folder.builder()
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .folderId("folderId")
                    .folderPath("folderPath")
                    .name("name")
                    .type(AssetListResponse.Folder.Type.FOLDER)
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )

        val roundtrippedAssetListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assetListResponse),
                jacksonTypeRef<AssetListResponse>(),
            )

        assertThat(roundtrippedAssetListResponse).isEqualTo(assetListResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val assetListResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AssetListResponse>())

        val e = assertThrows<ImageKitInvalidDataException> { assetListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
