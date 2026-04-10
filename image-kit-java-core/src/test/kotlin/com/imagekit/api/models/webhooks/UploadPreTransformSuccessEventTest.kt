// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.models.files.Metadata
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadPreTransformSuccessEventTest {

    @Test
    fun create() {
        val uploadPreTransformSuccessEvent =
            UploadPreTransformSuccessEvent.builder()
                .id("id")
                .type("upload.pre-transform.success")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    UploadPreTransformSuccessEvent.Data.builder()
                        .addAiTag(
                            UploadPreTransformSuccessEvent.Data.AiTag.builder()
                                .confidence(0.0)
                                .name("name")
                                .source("source")
                                .build()
                        )
                        .audioCodec("audioCodec")
                        .bitRate(0L)
                        .customCoordinates("customCoordinates")
                        .customMetadata(
                            UploadPreTransformSuccessEvent.Data.CustomMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .duration(0L)
                        .embeddedMetadata(
                            UploadPreTransformSuccessEvent.Data.EmbeddedMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .extensionStatus(
                            UploadPreTransformSuccessEvent.Data.ExtensionStatus.builder()
                                .aiAutoDescription(
                                    UploadPreTransformSuccessEvent.Data.ExtensionStatus
                                        .AiAutoDescription
                                        .SUCCESS
                                )
                                .aiTasks(
                                    UploadPreTransformSuccessEvent.Data.ExtensionStatus.AiTasks
                                        .SUCCESS
                                )
                                .awsAutoTagging(
                                    UploadPreTransformSuccessEvent.Data.ExtensionStatus
                                        .AwsAutoTagging
                                        .SUCCESS
                                )
                                .googleAutoTagging(
                                    UploadPreTransformSuccessEvent.Data.ExtensionStatus
                                        .GoogleAutoTagging
                                        .SUCCESS
                                )
                                .removeBg(
                                    UploadPreTransformSuccessEvent.Data.ExtensionStatus.RemoveBg
                                        .SUCCESS
                                )
                                .build()
                        )
                        .fileId("fileId")
                        .filePath("filePath")
                        .fileType("fileType")
                        .height(0.0)
                        .isPrivateFile(true)
                        .isPublished(true)
                        .metadata(
                            Metadata.builder()
                                .audioCodec("audioCodec")
                                .bitRate(0L)
                                .density(0L)
                                .duration(0L)
                                .exif(
                                    Metadata.Exif.builder()
                                        .exif(
                                            Metadata.Exif.InnerExif.builder()
                                                .apertureValue(0.0)
                                                .colorSpace(0L)
                                                .createDate("CreateDate")
                                                .customRendered(0L)
                                                .dateTimeOriginal("DateTimeOriginal")
                                                .exifImageHeight(0L)
                                                .exifImageWidth(0L)
                                                .exifVersion("ExifVersion")
                                                .exposureCompensation(0.0)
                                                .exposureMode(0L)
                                                .exposureProgram(0L)
                                                .exposureTime(0.0)
                                                .flash(0L)
                                                .flashpixVersion("FlashpixVersion")
                                                .fNumber(0.0)
                                                .focalLength(0L)
                                                .focalPlaneResolutionUnit(0L)
                                                .focalPlaneXResolution(0.0)
                                                .focalPlaneYResolution(0.0)
                                                .interopOffset(0L)
                                                .iso(0L)
                                                .meteringMode(0L)
                                                .sceneCaptureType(0L)
                                                .shutterSpeedValue(0.0)
                                                .subSecTime("SubSecTime")
                                                .whiteBalance(0L)
                                                .build()
                                        )
                                        .gps(
                                            Metadata.Exif.Gps.builder().addGpsVersionId(0L).build()
                                        )
                                        .image(
                                            Metadata.Exif.Image.builder()
                                                .exifOffset(0L)
                                                .gpsInfo(0L)
                                                .make("Make")
                                                .model("Model")
                                                .modifyDate("ModifyDate")
                                                .orientation(0L)
                                                .resolutionUnit(0L)
                                                .software("Software")
                                                .xResolution(0L)
                                                .yCbCrPositioning(0L)
                                                .yResolution(0L)
                                                .build()
                                        )
                                        .interoperability(
                                            Metadata.Exif.Interoperability.builder()
                                                .interopIndex("InteropIndex")
                                                .interopVersion("InteropVersion")
                                                .build()
                                        )
                                        .makernote(
                                            Metadata.Exif.Makernote.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .thumbnail(
                                            Metadata.Exif.Thumbnail.builder()
                                                .compression(0L)
                                                .resolutionUnit(0L)
                                                .thumbnailLength(0L)
                                                .thumbnailOffset(0L)
                                                .xResolution(0L)
                                                .yResolution(0L)
                                                .build()
                                        )
                                        .build()
                                )
                                .format("format")
                                .hasColorProfile(true)
                                .hasTransparency(true)
                                .height(0L)
                                .pHash("pHash")
                                .quality(0L)
                                .size(0L)
                                .videoCodec("videoCodec")
                                .width(0L)
                                .build()
                        )
                        .name("name")
                        .selectedFieldsSchema(
                            UploadPreTransformSuccessEvent.Data.SelectedFieldsSchema.builder()
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
                        .thumbnailUrl("thumbnailUrl")
                        .url("url")
                        .versionInfo(
                            UploadPreTransformSuccessEvent.Data.VersionInfo.builder()
                                .id("id")
                                .name("name")
                                .build()
                        )
                        .videoCodec("videoCodec")
                        .width(0.0)
                        .build()
                )
                .request(
                    UploadPreTransformSuccessEvent.Request.builder()
                        .transformation("transformation")
                        .xRequestId("x_request_id")
                        .build()
                )
                .build()

        assertThat(uploadPreTransformSuccessEvent.id()).isEqualTo("id")
        assertThat(uploadPreTransformSuccessEvent.type()).isEqualTo("upload.pre-transform.success")
        assertThat(uploadPreTransformSuccessEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(uploadPreTransformSuccessEvent.data())
            .isEqualTo(
                UploadPreTransformSuccessEvent.Data.builder()
                    .addAiTag(
                        UploadPreTransformSuccessEvent.Data.AiTag.builder()
                            .confidence(0.0)
                            .name("name")
                            .source("source")
                            .build()
                    )
                    .audioCodec("audioCodec")
                    .bitRate(0L)
                    .customCoordinates("customCoordinates")
                    .customMetadata(
                        UploadPreTransformSuccessEvent.Data.CustomMetadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .description("description")
                    .duration(0L)
                    .embeddedMetadata(
                        UploadPreTransformSuccessEvent.Data.EmbeddedMetadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .extensionStatus(
                        UploadPreTransformSuccessEvent.Data.ExtensionStatus.builder()
                            .aiAutoDescription(
                                UploadPreTransformSuccessEvent.Data.ExtensionStatus
                                    .AiAutoDescription
                                    .SUCCESS
                            )
                            .aiTasks(
                                UploadPreTransformSuccessEvent.Data.ExtensionStatus.AiTasks.SUCCESS
                            )
                            .awsAutoTagging(
                                UploadPreTransformSuccessEvent.Data.ExtensionStatus.AwsAutoTagging
                                    .SUCCESS
                            )
                            .googleAutoTagging(
                                UploadPreTransformSuccessEvent.Data.ExtensionStatus
                                    .GoogleAutoTagging
                                    .SUCCESS
                            )
                            .removeBg(
                                UploadPreTransformSuccessEvent.Data.ExtensionStatus.RemoveBg.SUCCESS
                            )
                            .build()
                    )
                    .fileId("fileId")
                    .filePath("filePath")
                    .fileType("fileType")
                    .height(0.0)
                    .isPrivateFile(true)
                    .isPublished(true)
                    .metadata(
                        Metadata.builder()
                            .audioCodec("audioCodec")
                            .bitRate(0L)
                            .density(0L)
                            .duration(0L)
                            .exif(
                                Metadata.Exif.builder()
                                    .exif(
                                        Metadata.Exif.InnerExif.builder()
                                            .apertureValue(0.0)
                                            .colorSpace(0L)
                                            .createDate("CreateDate")
                                            .customRendered(0L)
                                            .dateTimeOriginal("DateTimeOriginal")
                                            .exifImageHeight(0L)
                                            .exifImageWidth(0L)
                                            .exifVersion("ExifVersion")
                                            .exposureCompensation(0.0)
                                            .exposureMode(0L)
                                            .exposureProgram(0L)
                                            .exposureTime(0.0)
                                            .flash(0L)
                                            .flashpixVersion("FlashpixVersion")
                                            .fNumber(0.0)
                                            .focalLength(0L)
                                            .focalPlaneResolutionUnit(0L)
                                            .focalPlaneXResolution(0.0)
                                            .focalPlaneYResolution(0.0)
                                            .interopOffset(0L)
                                            .iso(0L)
                                            .meteringMode(0L)
                                            .sceneCaptureType(0L)
                                            .shutterSpeedValue(0.0)
                                            .subSecTime("SubSecTime")
                                            .whiteBalance(0L)
                                            .build()
                                    )
                                    .gps(Metadata.Exif.Gps.builder().addGpsVersionId(0L).build())
                                    .image(
                                        Metadata.Exif.Image.builder()
                                            .exifOffset(0L)
                                            .gpsInfo(0L)
                                            .make("Make")
                                            .model("Model")
                                            .modifyDate("ModifyDate")
                                            .orientation(0L)
                                            .resolutionUnit(0L)
                                            .software("Software")
                                            .xResolution(0L)
                                            .yCbCrPositioning(0L)
                                            .yResolution(0L)
                                            .build()
                                    )
                                    .interoperability(
                                        Metadata.Exif.Interoperability.builder()
                                            .interopIndex("InteropIndex")
                                            .interopVersion("InteropVersion")
                                            .build()
                                    )
                                    .makernote(
                                        Metadata.Exif.Makernote.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .thumbnail(
                                        Metadata.Exif.Thumbnail.builder()
                                            .compression(0L)
                                            .resolutionUnit(0L)
                                            .thumbnailLength(0L)
                                            .thumbnailOffset(0L)
                                            .xResolution(0L)
                                            .yResolution(0L)
                                            .build()
                                    )
                                    .build()
                            )
                            .format("format")
                            .hasColorProfile(true)
                            .hasTransparency(true)
                            .height(0L)
                            .pHash("pHash")
                            .quality(0L)
                            .size(0L)
                            .videoCodec("videoCodec")
                            .width(0L)
                            .build()
                    )
                    .name("name")
                    .selectedFieldsSchema(
                        UploadPreTransformSuccessEvent.Data.SelectedFieldsSchema.builder()
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
                    .thumbnailUrl("thumbnailUrl")
                    .url("url")
                    .versionInfo(
                        UploadPreTransformSuccessEvent.Data.VersionInfo.builder()
                            .id("id")
                            .name("name")
                            .build()
                    )
                    .videoCodec("videoCodec")
                    .width(0.0)
                    .build()
            )
        assertThat(uploadPreTransformSuccessEvent.request())
            .isEqualTo(
                UploadPreTransformSuccessEvent.Request.builder()
                    .transformation("transformation")
                    .xRequestId("x_request_id")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val uploadPreTransformSuccessEvent =
            UploadPreTransformSuccessEvent.builder()
                .id("id")
                .type("upload.pre-transform.success")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    UploadPreTransformSuccessEvent.Data.builder()
                        .addAiTag(
                            UploadPreTransformSuccessEvent.Data.AiTag.builder()
                                .confidence(0.0)
                                .name("name")
                                .source("source")
                                .build()
                        )
                        .audioCodec("audioCodec")
                        .bitRate(0L)
                        .customCoordinates("customCoordinates")
                        .customMetadata(
                            UploadPreTransformSuccessEvent.Data.CustomMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .duration(0L)
                        .embeddedMetadata(
                            UploadPreTransformSuccessEvent.Data.EmbeddedMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .extensionStatus(
                            UploadPreTransformSuccessEvent.Data.ExtensionStatus.builder()
                                .aiAutoDescription(
                                    UploadPreTransformSuccessEvent.Data.ExtensionStatus
                                        .AiAutoDescription
                                        .SUCCESS
                                )
                                .aiTasks(
                                    UploadPreTransformSuccessEvent.Data.ExtensionStatus.AiTasks
                                        .SUCCESS
                                )
                                .awsAutoTagging(
                                    UploadPreTransformSuccessEvent.Data.ExtensionStatus
                                        .AwsAutoTagging
                                        .SUCCESS
                                )
                                .googleAutoTagging(
                                    UploadPreTransformSuccessEvent.Data.ExtensionStatus
                                        .GoogleAutoTagging
                                        .SUCCESS
                                )
                                .removeBg(
                                    UploadPreTransformSuccessEvent.Data.ExtensionStatus.RemoveBg
                                        .SUCCESS
                                )
                                .build()
                        )
                        .fileId("fileId")
                        .filePath("filePath")
                        .fileType("fileType")
                        .height(0.0)
                        .isPrivateFile(true)
                        .isPublished(true)
                        .metadata(
                            Metadata.builder()
                                .audioCodec("audioCodec")
                                .bitRate(0L)
                                .density(0L)
                                .duration(0L)
                                .exif(
                                    Metadata.Exif.builder()
                                        .exif(
                                            Metadata.Exif.InnerExif.builder()
                                                .apertureValue(0.0)
                                                .colorSpace(0L)
                                                .createDate("CreateDate")
                                                .customRendered(0L)
                                                .dateTimeOriginal("DateTimeOriginal")
                                                .exifImageHeight(0L)
                                                .exifImageWidth(0L)
                                                .exifVersion("ExifVersion")
                                                .exposureCompensation(0.0)
                                                .exposureMode(0L)
                                                .exposureProgram(0L)
                                                .exposureTime(0.0)
                                                .flash(0L)
                                                .flashpixVersion("FlashpixVersion")
                                                .fNumber(0.0)
                                                .focalLength(0L)
                                                .focalPlaneResolutionUnit(0L)
                                                .focalPlaneXResolution(0.0)
                                                .focalPlaneYResolution(0.0)
                                                .interopOffset(0L)
                                                .iso(0L)
                                                .meteringMode(0L)
                                                .sceneCaptureType(0L)
                                                .shutterSpeedValue(0.0)
                                                .subSecTime("SubSecTime")
                                                .whiteBalance(0L)
                                                .build()
                                        )
                                        .gps(
                                            Metadata.Exif.Gps.builder().addGpsVersionId(0L).build()
                                        )
                                        .image(
                                            Metadata.Exif.Image.builder()
                                                .exifOffset(0L)
                                                .gpsInfo(0L)
                                                .make("Make")
                                                .model("Model")
                                                .modifyDate("ModifyDate")
                                                .orientation(0L)
                                                .resolutionUnit(0L)
                                                .software("Software")
                                                .xResolution(0L)
                                                .yCbCrPositioning(0L)
                                                .yResolution(0L)
                                                .build()
                                        )
                                        .interoperability(
                                            Metadata.Exif.Interoperability.builder()
                                                .interopIndex("InteropIndex")
                                                .interopVersion("InteropVersion")
                                                .build()
                                        )
                                        .makernote(
                                            Metadata.Exif.Makernote.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .thumbnail(
                                            Metadata.Exif.Thumbnail.builder()
                                                .compression(0L)
                                                .resolutionUnit(0L)
                                                .thumbnailLength(0L)
                                                .thumbnailOffset(0L)
                                                .xResolution(0L)
                                                .yResolution(0L)
                                                .build()
                                        )
                                        .build()
                                )
                                .format("format")
                                .hasColorProfile(true)
                                .hasTransparency(true)
                                .height(0L)
                                .pHash("pHash")
                                .quality(0L)
                                .size(0L)
                                .videoCodec("videoCodec")
                                .width(0L)
                                .build()
                        )
                        .name("name")
                        .selectedFieldsSchema(
                            UploadPreTransformSuccessEvent.Data.SelectedFieldsSchema.builder()
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
                        .thumbnailUrl("thumbnailUrl")
                        .url("url")
                        .versionInfo(
                            UploadPreTransformSuccessEvent.Data.VersionInfo.builder()
                                .id("id")
                                .name("name")
                                .build()
                        )
                        .videoCodec("videoCodec")
                        .width(0.0)
                        .build()
                )
                .request(
                    UploadPreTransformSuccessEvent.Request.builder()
                        .transformation("transformation")
                        .xRequestId("x_request_id")
                        .build()
                )
                .build()

        val roundtrippedUploadPreTransformSuccessEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(uploadPreTransformSuccessEvent),
                jacksonTypeRef<UploadPreTransformSuccessEvent>(),
            )

        assertThat(roundtrippedUploadPreTransformSuccessEvent)
            .isEqualTo(uploadPreTransformSuccessEvent)
    }
}
