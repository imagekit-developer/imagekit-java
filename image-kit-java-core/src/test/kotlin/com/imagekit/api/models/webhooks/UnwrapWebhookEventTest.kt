// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.errors.ImageKitInvalidDataException
import com.imagekit.api.models.AiTag
import com.imagekit.api.models.CustomMetadata
import com.imagekit.api.models.EmbeddedMetadata
import com.imagekit.api.models.SelectedFieldsSchema
import com.imagekit.api.models.VersionInfo
import com.imagekit.api.models.files.File
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
                .type("video.transformation.accepted")
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
        assertThat(unwrapWebhookEvent.fileCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileUpdate()).isEmpty
        assertThat(unwrapWebhookEvent.fileDelete()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionDelete()).isEmpty
    }

    @Test
    fun ofVideoTransformationAcceptedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationAccepted(
                VideoTransformationAcceptedEvent.builder()
                    .id("id")
                    .type("video.transformation.accepted")
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
                .type("video.transformation.ready")
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
        assertThat(unwrapWebhookEvent.fileCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileUpdate()).isEmpty
        assertThat(unwrapWebhookEvent.fileDelete()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionDelete()).isEmpty
    }

    @Test
    fun ofVideoTransformationReadyRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationReady(
                VideoTransformationReadyEvent.builder()
                    .id("id")
                    .type("video.transformation.ready")
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
                .type("video.transformation.error")
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
        assertThat(unwrapWebhookEvent.fileCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileUpdate()).isEmpty
        assertThat(unwrapWebhookEvent.fileDelete()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionDelete()).isEmpty
    }

    @Test
    fun ofVideoTransformationErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationError(
                VideoTransformationErrorEvent.builder()
                    .id("id")
                    .type("video.transformation.error")
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
            UploadPreTransformSuccessEvent.builder()
                .id("id")
                .type("upload.pre-transform.success")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    UploadPreTransformSuccessEvent.Data.builder()
                        .addAiTag(
                            AiTag.builder().confidence(0.0).name("name").source("source").build()
                        )
                        .audioCodec("audioCodec")
                        .bitRate(0L)
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
                                            Metadata.Exif.ExifDetails.builder()
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
                        .thumbnailUrl("thumbnailUrl")
                        .url("url")
                        .versionInfo(VersionInfo.builder().id("id").name("name").build())
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
        assertThat(unwrapWebhookEvent.fileCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileUpdate()).isEmpty
        assertThat(unwrapWebhookEvent.fileDelete()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionDelete()).isEmpty
    }

    @Test
    fun ofUploadPreTransformSuccessRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPreTransformSuccess(
                UploadPreTransformSuccessEvent.builder()
                    .id("id")
                    .type("upload.pre-transform.success")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        UploadPreTransformSuccessEvent.Data.builder()
                            .addAiTag(
                                AiTag.builder()
                                    .confidence(0.0)
                                    .name("name")
                                    .source("source")
                                    .build()
                            )
                            .audioCodec("audioCodec")
                            .bitRate(0L)
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
                                                Metadata.Exif.ExifDetails.builder()
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
                                                    listOf(
                                                        "small",
                                                        "medium",
                                                        "large",
                                                        30,
                                                        40,
                                                        true,
                                                    ),
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
                            .versionInfo(VersionInfo.builder().id("id").name("name").build())
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
            UploadPreTransformErrorEvent.builder()
                .id("id")
                .type("upload.pre-transform.error")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    UploadPreTransformErrorEvent.Data.builder()
                        .name("name")
                        .path("path")
                        .transformation(
                            UploadPreTransformErrorEvent.Data.Transformation.builder()
                                .error(
                                    UploadPreTransformErrorEvent.Data.Transformation.Error.builder()
                                        .reason("encoding_failed")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .request(
                    UploadPreTransformErrorEvent.Request.builder()
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
        assertThat(unwrapWebhookEvent.fileCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileUpdate()).isEmpty
        assertThat(unwrapWebhookEvent.fileDelete()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionDelete()).isEmpty
    }

    @Test
    fun ofUploadPreTransformErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPreTransformError(
                UploadPreTransformErrorEvent.builder()
                    .id("id")
                    .type("upload.pre-transform.error")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        UploadPreTransformErrorEvent.Data.builder()
                            .name("name")
                            .path("path")
                            .transformation(
                                UploadPreTransformErrorEvent.Data.Transformation.builder()
                                    .error(
                                        UploadPreTransformErrorEvent.Data.Transformation.Error
                                            .builder()
                                            .reason("encoding_failed")
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .request(
                        UploadPreTransformErrorEvent.Request.builder()
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
            UploadPostTransformSuccessEvent.builder()
                .id("id")
                .type("upload.post-transform.success")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    UploadPostTransformSuccessEvent.Data.builder()
                        .fileId("fileId")
                        .name("name")
                        .url("https://example.com")
                        .build()
                )
                .request(
                    UploadPostTransformSuccessEvent.Request.builder()
                        .transformation(
                            UploadPostTransformSuccessEvent.Request.Transformation.builder()
                                .type(
                                    UploadPostTransformSuccessEvent.Request.Transformation.Type
                                        .TRANSFORMATION
                                )
                                .protocol(
                                    UploadPostTransformSuccessEvent.Request.Transformation.Protocol
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
        assertThat(unwrapWebhookEvent.fileCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileUpdate()).isEmpty
        assertThat(unwrapWebhookEvent.fileDelete()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionDelete()).isEmpty
    }

    @Test
    fun ofUploadPostTransformSuccessRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPostTransformSuccess(
                UploadPostTransformSuccessEvent.builder()
                    .id("id")
                    .type("upload.post-transform.success")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        UploadPostTransformSuccessEvent.Data.builder()
                            .fileId("fileId")
                            .name("name")
                            .url("https://example.com")
                            .build()
                    )
                    .request(
                        UploadPostTransformSuccessEvent.Request.builder()
                            .transformation(
                                UploadPostTransformSuccessEvent.Request.Transformation.builder()
                                    .type(
                                        UploadPostTransformSuccessEvent.Request.Transformation.Type
                                            .TRANSFORMATION
                                    )
                                    .protocol(
                                        UploadPostTransformSuccessEvent.Request.Transformation
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
            UploadPostTransformErrorEvent.builder()
                .id("id")
                .type("upload.post-transform.error")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    UploadPostTransformErrorEvent.Data.builder()
                        .fileId("fileId")
                        .name("name")
                        .path("path")
                        .transformation(
                            UploadPostTransformErrorEvent.Data.Transformation.builder()
                                .error(
                                    UploadPostTransformErrorEvent.Data.Transformation.Error
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
                    UploadPostTransformErrorEvent.Request.builder()
                        .transformation(
                            UploadPostTransformErrorEvent.Request.Transformation.builder()
                                .type(
                                    UploadPostTransformErrorEvent.Request.Transformation.Type
                                        .TRANSFORMATION
                                )
                                .protocol(
                                    UploadPostTransformErrorEvent.Request.Transformation.Protocol
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
        assertThat(unwrapWebhookEvent.fileCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileUpdate()).isEmpty
        assertThat(unwrapWebhookEvent.fileDelete()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionDelete()).isEmpty
    }

    @Test
    fun ofUploadPostTransformErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofUploadPostTransformError(
                UploadPostTransformErrorEvent.builder()
                    .id("id")
                    .type("upload.post-transform.error")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        UploadPostTransformErrorEvent.Data.builder()
                            .fileId("fileId")
                            .name("name")
                            .path("path")
                            .transformation(
                                UploadPostTransformErrorEvent.Data.Transformation.builder()
                                    .error(
                                        UploadPostTransformErrorEvent.Data.Transformation.Error
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
                        UploadPostTransformErrorEvent.Request.builder()
                            .transformation(
                                UploadPostTransformErrorEvent.Request.Transformation.builder()
                                    .type(
                                        UploadPostTransformErrorEvent.Request.Transformation.Type
                                            .TRANSFORMATION
                                    )
                                    .protocol(
                                        UploadPostTransformErrorEvent.Request.Transformation
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
    fun ofFileCreate() {
        val fileCreate =
            FileCreateEvent.builder()
                .id("id")
                .type("file.created")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    File.builder()
                        .addAiTag(
                            AiTag.builder().confidence(0.0).name("name").source("source").build()
                        )
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
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofFileCreate(fileCreate)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.fileCreate()).contains(fileCreate)
        assertThat(unwrapWebhookEvent.fileUpdate()).isEmpty
        assertThat(unwrapWebhookEvent.fileDelete()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionDelete()).isEmpty
    }

    @Test
    fun ofFileCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofFileCreate(
                FileCreateEvent.builder()
                    .id("id")
                    .type("file.created")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        File.builder()
                            .addAiTag(
                                AiTag.builder()
                                    .confidence(0.0)
                                    .name("name")
                                    .source("source")
                                    .build()
                            )
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
                                                    listOf(
                                                        "small",
                                                        "medium",
                                                        "large",
                                                        30,
                                                        40,
                                                        true,
                                                    ),
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
    fun ofFileUpdate() {
        val fileUpdate =
            FileUpdateEvent.builder()
                .id("id")
                .type("file.updated")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    File.builder()
                        .addAiTag(
                            AiTag.builder().confidence(0.0).name("name").source("source").build()
                        )
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
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofFileUpdate(fileUpdate)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.fileCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileUpdate()).contains(fileUpdate)
        assertThat(unwrapWebhookEvent.fileDelete()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionDelete()).isEmpty
    }

    @Test
    fun ofFileUpdateRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofFileUpdate(
                FileUpdateEvent.builder()
                    .id("id")
                    .type("file.updated")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        File.builder()
                            .addAiTag(
                                AiTag.builder()
                                    .confidence(0.0)
                                    .name("name")
                                    .source("source")
                                    .build()
                            )
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
                                                    listOf(
                                                        "small",
                                                        "medium",
                                                        "large",
                                                        30,
                                                        40,
                                                        true,
                                                    ),
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
    fun ofFileDelete() {
        val fileDelete =
            FileDeleteEvent.builder()
                .id("id")
                .type("file.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(FileDeleteEvent.Data.builder().fileId("fileId").build())
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofFileDelete(fileDelete)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.fileCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileUpdate()).isEmpty
        assertThat(unwrapWebhookEvent.fileDelete()).contains(fileDelete)
        assertThat(unwrapWebhookEvent.fileVersionCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionDelete()).isEmpty
    }

    @Test
    fun ofFileDeleteRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofFileDelete(
                FileDeleteEvent.builder()
                    .id("id")
                    .type("file.deleted")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(FileDeleteEvent.Data.builder().fileId("fileId").build())
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
    fun ofFileVersionCreate() {
        val fileVersionCreate =
            FileVersionCreateEvent.builder()
                .id("id")
                .type("file-version.created")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    File.builder()
                        .addAiTag(
                            AiTag.builder().confidence(0.0).name("name").source("source").build()
                        )
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
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofFileVersionCreate(fileVersionCreate)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.fileCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileUpdate()).isEmpty
        assertThat(unwrapWebhookEvent.fileDelete()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionCreate()).contains(fileVersionCreate)
        assertThat(unwrapWebhookEvent.fileVersionDelete()).isEmpty
    }

    @Test
    fun ofFileVersionCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofFileVersionCreate(
                FileVersionCreateEvent.builder()
                    .id("id")
                    .type("file-version.created")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        File.builder()
                            .addAiTag(
                                AiTag.builder()
                                    .confidence(0.0)
                                    .name("name")
                                    .source("source")
                                    .build()
                            )
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
                                                    listOf(
                                                        "small",
                                                        "medium",
                                                        "large",
                                                        30,
                                                        40,
                                                        true,
                                                    ),
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
    fun ofFileVersionDelete() {
        val fileVersionDelete =
            FileVersionDeleteEvent.builder()
                .id("id")
                .type("file-version.deleted")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    FileVersionDeleteEvent.Data.builder()
                        .fileId("fileId")
                        .versionId("versionId")
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofFileVersionDelete(fileVersionDelete)

        assertThat(unwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unwrapWebhookEvent.fileCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileUpdate()).isEmpty
        assertThat(unwrapWebhookEvent.fileDelete()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionCreate()).isEmpty
        assertThat(unwrapWebhookEvent.fileVersionDelete()).contains(fileVersionDelete)
    }

    @Test
    fun ofFileVersionDeleteRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofFileVersionDelete(
                FileVersionDeleteEvent.builder()
                    .id("id")
                    .type("file-version.deleted")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        FileVersionDeleteEvent.Data.builder()
                            .fileId("fileId")
                            .versionId("versionId")
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
