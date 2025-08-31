// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.errors.ImageKitInvalidDataException
import com.imagekit.api.models.files.Metadata
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class UnwrapWebhookEventTest {

    @Test
    fun ofVideoTransformationAccepted() {
        val videoTransformationAccepted =
            VideoTransformationAcceptedEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    VideoTransformationAcceptedEvent.Data.builder()
                        .asset(
                            VideoTransformationAcceptedEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            VideoTransformationAcceptedEvent.Data.Transformation.builder()
                                .type(
                                    VideoTransformationAcceptedEvent.Data.Transformation.Type
                                        .VIDEO_TRANSFORMATION
                                )
                                .options(
                                    VideoTransformationAcceptedEvent.Data.Transformation.Options
                                        .builder()
                                        .audioCodec(
                                            VideoTransformationAcceptedEvent.Data.Transformation
                                                .Options
                                                .AudioCodec
                                                .AAC
                                        )
                                        .autoRotate(true)
                                        .format(
                                            VideoTransformationAcceptedEvent.Data.Transformation
                                                .Options
                                                .Format
                                                .MP4
                                        )
                                        .quality(0L)
                                        .streamProtocol(
                                            VideoTransformationAcceptedEvent.Data.Transformation
                                                .Options
                                                .StreamProtocol
                                                .HLS
                                        )
                                        .addVariant("string")
                                        .videoCodec(
                                            VideoTransformationAcceptedEvent.Data.Transformation
                                                .Options
                                                .VideoCodec
                                                .H264
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .request(
                    VideoTransformationAcceptedEvent.Request.builder()
                        .url("https://example.com")
                        .xRequestId("x_request_id")
                        .userAgent("user_agent")
                        .build()
                )
                .build()

        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationAccepted(videoTransformationAccepted)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted())
            .contains(videoTransformationAccepted)
        assertThat(unwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).isEmpty
    }

    @Test
    fun ofVideoTransformationAcceptedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationAccepted(
                VideoTransformationAcceptedEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        VideoTransformationAcceptedEvent.Data.builder()
                            .asset(
                                VideoTransformationAcceptedEvent.Data.Asset.builder()
                                    .url("https://example.com")
                                    .build()
                            )
                            .transformation(
                                VideoTransformationAcceptedEvent.Data.Transformation.builder()
                                    .type(
                                        VideoTransformationAcceptedEvent.Data.Transformation.Type
                                            .VIDEO_TRANSFORMATION
                                    )
                                    .options(
                                        VideoTransformationAcceptedEvent.Data.Transformation.Options
                                            .builder()
                                            .audioCodec(
                                                VideoTransformationAcceptedEvent.Data.Transformation
                                                    .Options
                                                    .AudioCodec
                                                    .AAC
                                            )
                                            .autoRotate(true)
                                            .format(
                                                VideoTransformationAcceptedEvent.Data.Transformation
                                                    .Options
                                                    .Format
                                                    .MP4
                                            )
                                            .quality(0L)
                                            .streamProtocol(
                                                VideoTransformationAcceptedEvent.Data.Transformation
                                                    .Options
                                                    .StreamProtocol
                                                    .HLS
                                            )
                                            .addVariant("string")
                                            .videoCodec(
                                                VideoTransformationAcceptedEvent.Data.Transformation
                                                    .Options
                                                    .VideoCodec
                                                    .H264
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .request(
                        VideoTransformationAcceptedEvent.Request.builder()
                            .url("https://example.com")
                            .xRequestId("x_request_id")
                            .userAgent("user_agent")
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofVideoTransformationReady() {
        val videoTransformationReady =
            VideoTransformationReadyEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    VideoTransformationReadyEvent.Data.builder()
                        .asset(
                            VideoTransformationReadyEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            VideoTransformationReadyEvent.Data.Transformation.builder()
                                .type(
                                    VideoTransformationReadyEvent.Data.Transformation.Type
                                        .VIDEO_TRANSFORMATION
                                )
                                .options(
                                    VideoTransformationReadyEvent.Data.Transformation.Options
                                        .builder()
                                        .audioCodec(
                                            VideoTransformationReadyEvent.Data.Transformation
                                                .Options
                                                .AudioCodec
                                                .AAC
                                        )
                                        .autoRotate(true)
                                        .format(
                                            VideoTransformationReadyEvent.Data.Transformation
                                                .Options
                                                .Format
                                                .MP4
                                        )
                                        .quality(0L)
                                        .streamProtocol(
                                            VideoTransformationReadyEvent.Data.Transformation
                                                .Options
                                                .StreamProtocol
                                                .HLS
                                        )
                                        .addVariant("string")
                                        .videoCodec(
                                            VideoTransformationReadyEvent.Data.Transformation
                                                .Options
                                                .VideoCodec
                                                .H264
                                        )
                                        .build()
                                )
                                .output(
                                    VideoTransformationReadyEvent.Data.Transformation.Output
                                        .builder()
                                        .url("https://example.com")
                                        .videoMetadata(
                                            VideoTransformationReadyEvent.Data.Transformation.Output
                                                .VideoMetadata
                                                .builder()
                                                .bitrate(0L)
                                                .duration(0.0)
                                                .height(0L)
                                                .width(0L)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .request(
                    VideoTransformationReadyEvent.Request.builder()
                        .url("https://example.com")
                        .xRequestId("x_request_id")
                        .userAgent("user_agent")
                        .build()
                )
                .timings(
                    VideoTransformationReadyEvent.Timings.builder()
                        .downloadDuration(0L)
                        .encodingDuration(0L)
                        .build()
                )
                .build()

        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationReady(videoTransformationReady)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationReady()).contains(videoTransformationReady)
        assertThat(unwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).isEmpty
    }

    @Test
    fun ofVideoTransformationReadyRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationReady(
                VideoTransformationReadyEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        VideoTransformationReadyEvent.Data.builder()
                            .asset(
                                VideoTransformationReadyEvent.Data.Asset.builder()
                                    .url("https://example.com")
                                    .build()
                            )
                            .transformation(
                                VideoTransformationReadyEvent.Data.Transformation.builder()
                                    .type(
                                        VideoTransformationReadyEvent.Data.Transformation.Type
                                            .VIDEO_TRANSFORMATION
                                    )
                                    .options(
                                        VideoTransformationReadyEvent.Data.Transformation.Options
                                            .builder()
                                            .audioCodec(
                                                VideoTransformationReadyEvent.Data.Transformation
                                                    .Options
                                                    .AudioCodec
                                                    .AAC
                                            )
                                            .autoRotate(true)
                                            .format(
                                                VideoTransformationReadyEvent.Data.Transformation
                                                    .Options
                                                    .Format
                                                    .MP4
                                            )
                                            .quality(0L)
                                            .streamProtocol(
                                                VideoTransformationReadyEvent.Data.Transformation
                                                    .Options
                                                    .StreamProtocol
                                                    .HLS
                                            )
                                            .addVariant("string")
                                            .videoCodec(
                                                VideoTransformationReadyEvent.Data.Transformation
                                                    .Options
                                                    .VideoCodec
                                                    .H264
                                            )
                                            .build()
                                    )
                                    .output(
                                        VideoTransformationReadyEvent.Data.Transformation.Output
                                            .builder()
                                            .url("https://example.com")
                                            .videoMetadata(
                                                VideoTransformationReadyEvent.Data.Transformation
                                                    .Output
                                                    .VideoMetadata
                                                    .builder()
                                                    .bitrate(0L)
                                                    .duration(0.0)
                                                    .height(0L)
                                                    .width(0L)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .request(
                        VideoTransformationReadyEvent.Request.builder()
                            .url("https://example.com")
                            .xRequestId("x_request_id")
                            .userAgent("user_agent")
                            .build()
                    )
                    .timings(
                        VideoTransformationReadyEvent.Timings.builder()
                            .downloadDuration(0L)
                            .encodingDuration(0L)
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofVideoTransformationError() {
        val videoTransformationError =
            VideoTransformationErrorEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    VideoTransformationErrorEvent.Data.builder()
                        .asset(
                            VideoTransformationErrorEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            VideoTransformationErrorEvent.Data.Transformation.builder()
                                .type(
                                    VideoTransformationErrorEvent.Data.Transformation.Type
                                        .VIDEO_TRANSFORMATION
                                )
                                .error(
                                    VideoTransformationErrorEvent.Data.Transformation.Error
                                        .builder()
                                        .reason(
                                            VideoTransformationErrorEvent.Data.Transformation.Error
                                                .Reason
                                                .ENCODING_FAILED
                                        )
                                        .build()
                                )
                                .options(
                                    VideoTransformationErrorEvent.Data.Transformation.Options
                                        .builder()
                                        .audioCodec(
                                            VideoTransformationErrorEvent.Data.Transformation
                                                .Options
                                                .AudioCodec
                                                .AAC
                                        )
                                        .autoRotate(true)
                                        .format(
                                            VideoTransformationErrorEvent.Data.Transformation
                                                .Options
                                                .Format
                                                .MP4
                                        )
                                        .quality(0L)
                                        .streamProtocol(
                                            VideoTransformationErrorEvent.Data.Transformation
                                                .Options
                                                .StreamProtocol
                                                .HLS
                                        )
                                        .addVariant("string")
                                        .videoCodec(
                                            VideoTransformationErrorEvent.Data.Transformation
                                                .Options
                                                .VideoCodec
                                                .H264
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .request(
                    VideoTransformationErrorEvent.Request.builder()
                        .url("https://example.com")
                        .xRequestId("x_request_id")
                        .userAgent("user_agent")
                        .build()
                )
                .build()

        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationError(videoTransformationError)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationError()).contains(videoTransformationError)
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).isEmpty
    }

    @Test
    fun ofVideoTransformationErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationError(
                VideoTransformationErrorEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        VideoTransformationErrorEvent.Data.builder()
                            .asset(
                                VideoTransformationErrorEvent.Data.Asset.builder()
                                    .url("https://example.com")
                                    .build()
                            )
                            .transformation(
                                VideoTransformationErrorEvent.Data.Transformation.builder()
                                    .type(
                                        VideoTransformationErrorEvent.Data.Transformation.Type
                                            .VIDEO_TRANSFORMATION
                                    )
                                    .error(
                                        VideoTransformationErrorEvent.Data.Transformation.Error
                                            .builder()
                                            .reason(
                                                VideoTransformationErrorEvent.Data.Transformation
                                                    .Error
                                                    .Reason
                                                    .ENCODING_FAILED
                                            )
                                            .build()
                                    )
                                    .options(
                                        VideoTransformationErrorEvent.Data.Transformation.Options
                                            .builder()
                                            .audioCodec(
                                                VideoTransformationErrorEvent.Data.Transformation
                                                    .Options
                                                    .AudioCodec
                                                    .AAC
                                            )
                                            .autoRotate(true)
                                            .format(
                                                VideoTransformationErrorEvent.Data.Transformation
                                                    .Options
                                                    .Format
                                                    .MP4
                                            )
                                            .quality(0L)
                                            .streamProtocol(
                                                VideoTransformationErrorEvent.Data.Transformation
                                                    .Options
                                                    .StreamProtocol
                                                    .HLS
                                            )
                                            .addVariant("string")
                                            .videoCodec(
                                                VideoTransformationErrorEvent.Data.Transformation
                                                    .Options
                                                    .VideoCodec
                                                    .H264
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .request(
                        VideoTransformationErrorEvent.Request.builder()
                            .url("https://example.com")
                            .xRequestId("x_request_id")
                            .userAgent("user_agent")
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofUploadPreTransformSuccess() {
        val uploadPreTransformSuccess =
            UploadPreTransformSuccessWebhookEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    UploadPreTransformSuccessWebhookEvent.Data.builder()
                        .addAiTag(
                            UploadPreTransformSuccessWebhookEvent.Data.AiTag.builder()
                                .confidence(0.0)
                                .name("name")
                                .source("source")
                                .build()
                        )
                        .audioCodec("audioCodec")
                        .bitRate(0L)
                        .customCoordinates("customCoordinates")
                        .customMetadata(
                            UploadPreTransformSuccessWebhookEvent.Data.CustomMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .duration(0L)
                        .embeddedMetadata(
                            UploadPreTransformSuccessWebhookEvent.Data.EmbeddedMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .extensionStatus(
                            UploadPreTransformSuccessWebhookEvent.Data.ExtensionStatus.builder()
                                .awsAutoTagging(
                                    UploadPreTransformSuccessWebhookEvent.Data.ExtensionStatus
                                        .AwsAutoTagging
                                        .SUCCESS
                                )
                                .googleAutoTagging(
                                    UploadPreTransformSuccessWebhookEvent.Data.ExtensionStatus
                                        .GoogleAutoTagging
                                        .SUCCESS
                                )
                                .removeBg(
                                    UploadPreTransformSuccessWebhookEvent.Data.ExtensionStatus
                                        .RemoveBg
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
                        .size(0.0)
                        .addTag("string")
                        .thumbnailUrl("thumbnailUrl")
                        .url("url")
                        .versionInfo(
                            UploadPreTransformSuccessWebhookEvent.Data.VersionInfo.builder()
                                .id("id")
                                .name("name")
                                .build()
                        )
                        .videoCodec("videoCodec")
                        .width(0.0)
                        .build()
                )
                .request(
                    UploadPreTransformSuccessWebhookEvent.Request.builder()
                        .transformation("transformation")
                        .xRequestId("x_request_id")
                        .build()
                )
                .build()

        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPreTransformSuccess(uploadPreTransformSuccess)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess())
            .contains(uploadPreTransformSuccess)
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).isEmpty
    }

    @Test
    fun ofUploadPreTransformSuccessRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPreTransformSuccess(
                UploadPreTransformSuccessWebhookEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        UploadPreTransformSuccessWebhookEvent.Data.builder()
                            .addAiTag(
                                UploadPreTransformSuccessWebhookEvent.Data.AiTag.builder()
                                    .confidence(0.0)
                                    .name("name")
                                    .source("source")
                                    .build()
                            )
                            .audioCodec("audioCodec")
                            .bitRate(0L)
                            .customCoordinates("customCoordinates")
                            .customMetadata(
                                UploadPreTransformSuccessWebhookEvent.Data.CustomMetadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .description("description")
                            .duration(0L)
                            .embeddedMetadata(
                                UploadPreTransformSuccessWebhookEvent.Data.EmbeddedMetadata
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .extensionStatus(
                                UploadPreTransformSuccessWebhookEvent.Data.ExtensionStatus.builder()
                                    .awsAutoTagging(
                                        UploadPreTransformSuccessWebhookEvent.Data.ExtensionStatus
                                            .AwsAutoTagging
                                            .SUCCESS
                                    )
                                    .googleAutoTagging(
                                        UploadPreTransformSuccessWebhookEvent.Data.ExtensionStatus
                                            .GoogleAutoTagging
                                            .SUCCESS
                                    )
                                    .removeBg(
                                        UploadPreTransformSuccessWebhookEvent.Data.ExtensionStatus
                                            .RemoveBg
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
                                                Metadata.Exif.Gps.builder()
                                                    .addGpsVersionId(0L)
                                                    .build()
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                            .size(0.0)
                            .addTag("string")
                            .thumbnailUrl("thumbnailUrl")
                            .url("url")
                            .versionInfo(
                                UploadPreTransformSuccessWebhookEvent.Data.VersionInfo.builder()
                                    .id("id")
                                    .name("name")
                                    .build()
                            )
                            .videoCodec("videoCodec")
                            .width(0.0)
                            .build()
                    )
                    .request(
                        UploadPreTransformSuccessWebhookEvent.Request.builder()
                            .transformation("transformation")
                            .xRequestId("x_request_id")
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofUploadPreTransformError() {
        val uploadPreTransformError =
            UploadPreTransformErrorWebhookEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    UploadPreTransformErrorWebhookEvent.Data.builder()
                        .name("name")
                        .path("path")
                        .transformation(
                            UploadPreTransformErrorWebhookEvent.Data.Transformation.builder()
                                .error(
                                    UploadPreTransformErrorWebhookEvent.Data.Transformation.Error
                                        .builder()
                                        .reason("encoding_failed")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .request(
                    UploadPreTransformErrorWebhookEvent.Request.builder()
                        .transformation("transformation")
                        .xRequestId("x_request_id")
                        .build()
                )
                .build()

        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPreTransformError(uploadPreTransformError)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).contains(uploadPreTransformError)
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).isEmpty
    }

    @Test
    fun ofUploadPreTransformErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPreTransformError(
                UploadPreTransformErrorWebhookEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        UploadPreTransformErrorWebhookEvent.Data.builder()
                            .name("name")
                            .path("path")
                            .transformation(
                                UploadPreTransformErrorWebhookEvent.Data.Transformation.builder()
                                    .error(
                                        UploadPreTransformErrorWebhookEvent.Data.Transformation
                                            .Error
                                            .builder()
                                            .reason("encoding_failed")
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .request(
                        UploadPreTransformErrorWebhookEvent.Request.builder()
                            .transformation("transformation")
                            .xRequestId("x_request_id")
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofUploadPostTransformSuccess() {
        val uploadPostTransformSuccess =
            UploadPostTransformSuccessWebhookEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    UploadPostTransformSuccessWebhookEvent.Data.builder()
                        .fileId("fileId")
                        .name("name")
                        .url("https://example.com")
                        .build()
                )
                .request(
                    UploadPostTransformSuccessWebhookEvent.Request.builder()
                        .transformation(
                            UploadPostTransformSuccessWebhookEvent.Request.Transformation.builder()
                                .type(
                                    UploadPostTransformSuccessWebhookEvent.Request.Transformation
                                        .Type
                                        .TRANSFORMATION
                                )
                                .protocol(
                                    UploadPostTransformSuccessWebhookEvent.Request.Transformation
                                        .Protocol
                                        .HLS
                                )
                                .value("value")
                                .build()
                        )
                        .xRequestId("x_request_id")
                        .build()
                )
                .build()

        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPostTransformSuccess(uploadPostTransformSuccess)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess())
            .contains(uploadPostTransformSuccess)
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).isEmpty
    }

    @Test
    fun ofUploadPostTransformSuccessRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPostTransformSuccess(
                UploadPostTransformSuccessWebhookEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        UploadPostTransformSuccessWebhookEvent.Data.builder()
                            .fileId("fileId")
                            .name("name")
                            .url("https://example.com")
                            .build()
                    )
                    .request(
                        UploadPostTransformSuccessWebhookEvent.Request.builder()
                            .transformation(
                                UploadPostTransformSuccessWebhookEvent.Request.Transformation
                                    .builder()
                                    .type(
                                        UploadPostTransformSuccessWebhookEvent.Request
                                            .Transformation
                                            .Type
                                            .TRANSFORMATION
                                    )
                                    .protocol(
                                        UploadPostTransformSuccessWebhookEvent.Request
                                            .Transformation
                                            .Protocol
                                            .HLS
                                    )
                                    .value("value")
                                    .build()
                            )
                            .xRequestId("x_request_id")
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofUploadPostTransformError() {
        val uploadPostTransformError =
            UploadPostTransformErrorWebhookEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    UploadPostTransformErrorWebhookEvent.Data.builder()
                        .fileId("fileId")
                        .name("name")
                        .path("path")
                        .transformation(
                            UploadPostTransformErrorWebhookEvent.Data.Transformation.builder()
                                .error(
                                    UploadPostTransformErrorWebhookEvent.Data.Transformation.Error
                                        .builder()
                                        .reason("encoding_failed")
                                        .build()
                                )
                                .build()
                        )
                        .url("https://example.com")
                        .build()
                )
                .request(
                    UploadPostTransformErrorWebhookEvent.Request.builder()
                        .transformation(
                            UploadPostTransformErrorWebhookEvent.Request.Transformation.builder()
                                .type(
                                    UploadPostTransformErrorWebhookEvent.Request.Transformation.Type
                                        .TRANSFORMATION
                                )
                                .protocol(
                                    UploadPostTransformErrorWebhookEvent.Request.Transformation
                                        .Protocol
                                        .HLS
                                )
                                .value("value")
                                .build()
                        )
                        .xRequestId("x_request_id")
                        .build()
                )
                .build()

        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPostTransformError(uploadPostTransformError)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).contains(uploadPostTransformError)
    }

    @Test
    fun ofUploadPostTransformErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPostTransformError(
                UploadPostTransformErrorWebhookEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        UploadPostTransformErrorWebhookEvent.Data.builder()
                            .fileId("fileId")
                            .name("name")
                            .path("path")
                            .transformation(
                                UploadPostTransformErrorWebhookEvent.Data.Transformation.builder()
                                    .error(
                                        UploadPostTransformErrorWebhookEvent.Data.Transformation
                                            .Error
                                            .builder()
                                            .reason("encoding_failed")
                                            .build()
                                    )
                                    .build()
                            )
                            .url("https://example.com")
                            .build()
                    )
                    .request(
                        UploadPostTransformErrorWebhookEvent.Request.builder()
                            .transformation(
                                UploadPostTransformErrorWebhookEvent.Request.Transformation
                                    .builder()
                                    .type(
                                        UploadPostTransformErrorWebhookEvent.Request.Transformation
                                            .Type
                                            .TRANSFORMATION
                                    )
                                    .protocol(
                                        UploadPostTransformErrorWebhookEvent.Request.Transformation
                                            .Protocol
                                            .HLS
                                    )
                                    .value("value")
                                    .build()
                            )
                            .xRequestId("x_request_id")
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
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
        val unwrapWebhookEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<UnwrapWebhookEvent>())

        val e = assertThrows<ImageKitInvalidDataException> { unwrapWebhookEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
