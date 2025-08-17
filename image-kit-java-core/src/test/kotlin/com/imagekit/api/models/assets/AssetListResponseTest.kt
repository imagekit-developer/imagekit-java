// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.assets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.errors.ImageKitInvalidDataException
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
                .createdAt("createdAt")
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
                .thumbnail("thumbnail")
                .type("type")
                .updatedAt("updatedAt")
                .url("url")
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
        assertThat(assetListResponse.folderDetails()).isEmpty
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
                    .createdAt("createdAt")
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
                    .thumbnail("thumbnail")
                    .type("type")
                    .updatedAt("updatedAt")
                    .url("url")
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
    fun ofFolderDetails() {
        val folderDetails =
            AssetListResponse.FolderDetails.builder()
                .createdAt("createdAt")
                .folderId("folderId")
                .folderPath("folderPath")
                .name("name")
                .type(AssetListResponse.FolderDetails.Type.FOLDER)
                .updatedAt("updatedAt")
                .build()

        val assetListResponse = AssetListResponse.ofFolderDetails(folderDetails)

        assertThat(assetListResponse.fileDetails()).isEmpty
        assertThat(assetListResponse.folderDetails()).contains(folderDetails)
    }

    @Test
    fun ofFolderDetailsRoundtrip() {
        val jsonMapper = jsonMapper()
        val assetListResponse =
            AssetListResponse.ofFolderDetails(
                AssetListResponse.FolderDetails.builder()
                    .createdAt("createdAt")
                    .folderId("folderId")
                    .folderPath("folderPath")
                    .name("name")
                    .type(AssetListResponse.FolderDetails.Type.FOLDER)
                    .updatedAt("updatedAt")
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
