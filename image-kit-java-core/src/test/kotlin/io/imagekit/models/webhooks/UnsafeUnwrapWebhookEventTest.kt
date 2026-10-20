// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.JsonValue
import io.imagekit.core.jsonMapper
import io.imagekit.errors.ImageKitInvalidDataException
import io.imagekit.models.AiTag
import io.imagekit.models.CustomMetadata
import io.imagekit.models.EmbeddedMetadata
import io.imagekit.models.SelectedFieldsSchema
import io.imagekit.models.VersionInfo
import io.imagekit.models.files.File
import io.imagekit.models.files.Folder
import io.imagekit.models.files.Metadata
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class UnsafeUnwrapWebhookEventTest {

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

        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofVideoTransformationAccepted(videoTransformationAccepted)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted())
            .contains(videoTransformationAccepted)
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofVideoTransformationAcceptedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofVideoTransformationAccepted(
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

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
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

        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofVideoTransformationReady(videoTransformationReady)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady())
            .contains(videoTransformationReady)
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofVideoTransformationReadyRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofVideoTransformationReady(
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

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
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

        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofVideoTransformationError(videoTransformationError)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError())
            .contains(videoTransformationError)
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofVideoTransformationErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofVideoTransformationError(
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

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofUploadPreTransformSuccess() {
        val uploadPreTransformSuccess =
            UploadPreTransformSuccessEvent.builder()
                .id("id")
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
                                                .brightnessValue(0.0)
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
                                                .focalLength(0.0)
                                                .focalLengthIn35mmFormat(0L)
                                                .focalPlaneResolutionUnit(0L)
                                                .focalPlaneXResolution(0.0)
                                                .focalPlaneYResolution(0.0)
                                                .interopOffset(0L)
                                                .iso(0L)
                                                .lensModel("LensModel")
                                                .lightSource(0L)
                                                .maxApertureValue(0.0)
                                                .meteringMode(0L)
                                                .sceneCaptureType(0L)
                                                .sceneType("SceneType")
                                                .sensingMethod(0L)
                                                .shutterSpeedValue(0.0)
                                                .subSecTime("SubSecTime")
                                                .userComment("UserComment")
                                                .whiteBalance(0L)
                                                .build()
                                        )
                                        .gps(
                                            Metadata.Exif.Gps.builder()
                                                .gpsAltitude(0.0)
                                                .gpsAltitudeRef(0L)
                                                .gpsDateStamp("GPSDateStamp")
                                                .gpsImgDirection(0.0)
                                                .gpsImgDirectionRef("GPSImgDirectionRef")
                                                .addGpsLatitude(0.0)
                                                .gpsLatitudeRef("GPSLatitudeRef")
                                                .addGpsLongitude(0.0)
                                                .gpsLongitudeRef("GPSLongitudeRef")
                                                .addGpsTimeStamp(0.0)
                                                .addGpsVersionId(0L)
                                                .build()
                                        )
                                        .image(
                                            Metadata.Exif.Image.builder()
                                                .artist("Artist")
                                                .copyright("Copyright")
                                                .exifOffset(0L)
                                                .gpsInfo(0L)
                                                .imageDescription("ImageDescription")
                                                .make("Make")
                                                .model("Model")
                                                .modifyDate("ModifyDate")
                                                .orientation(0L)
                                                .resolutionUnit(0L)
                                                .software("Software")
                                                .xResolution(0.0)
                                                .yCbCrPositioning(0L)
                                                .yResolution(0.0)
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
                                                .xResolution(0.0)
                                                .yResolution(0.0)
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

        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofUploadPreTransformSuccess(uploadPreTransformSuccess)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess())
            .contains(uploadPreTransformSuccess)
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofUploadPreTransformSuccessRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofUploadPreTransformSuccess(
                UploadPreTransformSuccessEvent.builder()
                    .id("id")
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
                                                    .brightnessValue(0.0)
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
                                                    .focalLength(0.0)
                                                    .focalLengthIn35mmFormat(0L)
                                                    .focalPlaneResolutionUnit(0L)
                                                    .focalPlaneXResolution(0.0)
                                                    .focalPlaneYResolution(0.0)
                                                    .interopOffset(0L)
                                                    .iso(0L)
                                                    .lensModel("LensModel")
                                                    .lightSource(0L)
                                                    .maxApertureValue(0.0)
                                                    .meteringMode(0L)
                                                    .sceneCaptureType(0L)
                                                    .sceneType("SceneType")
                                                    .sensingMethod(0L)
                                                    .shutterSpeedValue(0.0)
                                                    .subSecTime("SubSecTime")
                                                    .userComment("UserComment")
                                                    .whiteBalance(0L)
                                                    .build()
                                            )
                                            .gps(
                                                Metadata.Exif.Gps.builder()
                                                    .gpsAltitude(0.0)
                                                    .gpsAltitudeRef(0L)
                                                    .gpsDateStamp("GPSDateStamp")
                                                    .gpsImgDirection(0.0)
                                                    .gpsImgDirectionRef("GPSImgDirectionRef")
                                                    .addGpsLatitude(0.0)
                                                    .gpsLatitudeRef("GPSLatitudeRef")
                                                    .addGpsLongitude(0.0)
                                                    .gpsLongitudeRef("GPSLongitudeRef")
                                                    .addGpsTimeStamp(0.0)
                                                    .addGpsVersionId(0L)
                                                    .build()
                                            )
                                            .image(
                                                Metadata.Exif.Image.builder()
                                                    .artist("Artist")
                                                    .copyright("Copyright")
                                                    .exifOffset(0L)
                                                    .gpsInfo(0L)
                                                    .imageDescription("ImageDescription")
                                                    .make("Make")
                                                    .model("Model")
                                                    .modifyDate("ModifyDate")
                                                    .orientation(0L)
                                                    .resolutionUnit(0L)
                                                    .software("Software")
                                                    .xResolution(0.0)
                                                    .yCbCrPositioning(0L)
                                                    .yResolution(0.0)
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
                                                    .xResolution(0.0)
                                                    .yResolution(0.0)
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

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofUploadPreTransformError() {
        val uploadPreTransformError =
            UploadPreTransformErrorEvent.builder()
                .id("id")
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

        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofUploadPreTransformError(uploadPreTransformError)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError())
            .contains(uploadPreTransformError)
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofUploadPreTransformErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofUploadPreTransformError(
                UploadPreTransformErrorEvent.builder()
                    .id("id")
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

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofUploadPostTransformSuccess() {
        val uploadPostTransformSuccess =
            UploadPostTransformSuccessEvent.builder()
                .id("id")
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

        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofUploadPostTransformSuccess(uploadPostTransformSuccess)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess())
            .contains(uploadPostTransformSuccess)
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofUploadPostTransformSuccessRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofUploadPostTransformSuccess(
                UploadPostTransformSuccessEvent.builder()
                    .id("id")
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

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofUploadPostTransformError() {
        val uploadPostTransformError =
            UploadPostTransformErrorEvent.builder()
                .id("id")
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

        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofUploadPostTransformError(uploadPostTransformError)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError())
            .contains(uploadPostTransformError)
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofUploadPostTransformErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofUploadPostTransformError(
                UploadPostTransformErrorEvent.builder()
                    .id("id")
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

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofFileCreated() {
        val fileCreated =
            FileCreateEvent.builder()
                .id("id")
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

        val unsafeUnwrapWebhookEvent = UnsafeUnwrapWebhookEvent.ofFileCreated(fileCreated)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).contains(fileCreated)
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofFileCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofFileCreated(
                FileCreateEvent.builder()
                    .id("id")
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

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofFileUpdated() {
        val fileUpdated =
            FileUpdateEvent.builder()
                .id("id")
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

        val unsafeUnwrapWebhookEvent = UnsafeUnwrapWebhookEvent.ofFileUpdated(fileUpdated)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).contains(fileUpdated)
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofFileUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofFileUpdated(
                FileUpdateEvent.builder()
                    .id("id")
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

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofFileDeleted() {
        val fileDeleted =
            FileDeleteEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(FileDeleteEvent.Data.builder().fileId("fileId").build())
                .build()

        val unsafeUnwrapWebhookEvent = UnsafeUnwrapWebhookEvent.ofFileDeleted(fileDeleted)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).contains(fileDeleted)
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofFileDeletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofFileDeleted(
                FileDeleteEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(FileDeleteEvent.Data.builder().fileId("fileId").build())
                    .build()
            )

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofFileVersionCreated() {
        val fileVersionCreated =
            FileVersionCreateEvent.builder()
                .id("id")
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

        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofFileVersionCreated(fileVersionCreated)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).contains(fileVersionCreated)
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofFileVersionCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofFileVersionCreated(
                FileVersionCreateEvent.builder()
                    .id("id")
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

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofFileVersionDeleted() {
        val fileVersionDeleted =
            FileVersionDeleteEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    FileVersionDeleteEvent.Data.builder()
                        .fileId("fileId")
                        .versionId("versionId")
                        .build()
                )
                .build()

        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofFileVersionDeleted(fileVersionDeleted)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).contains(fileVersionDeleted)
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofFileVersionDeletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofFileVersionDeleted(
                FileVersionDeleteEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        FileVersionDeleteEvent.Data.builder()
                            .fileId("fileId")
                            .versionId("versionId")
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofFolderCreated() {
        val folderCreated =
            FolderCreateEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    Folder.builder()
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .createdBy(Folder.CreatedBy.builder().email("email").name("name").build())
                        .customMetadata(
                            CustomMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .folderId("folderId")
                        .folderPath("folderPath")
                        .name("name")
                        .type(Folder.Type.FOLDER)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        val unsafeUnwrapWebhookEvent = UnsafeUnwrapWebhookEvent.ofFolderCreated(folderCreated)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).contains(folderCreated)
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofFolderCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofFolderCreated(
                FolderCreateEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        Folder.builder()
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .createdBy(
                                Folder.CreatedBy.builder().email("email").name("name").build()
                            )
                            .customMetadata(
                                CustomMetadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .folderId("folderId")
                            .folderPath("folderPath")
                            .name("name")
                            .type(Folder.Type.FOLDER)
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofFolderUpdated() {
        val folderUpdated =
            FolderUpdateEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    Folder.builder()
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .createdBy(Folder.CreatedBy.builder().email("email").name("name").build())
                        .customMetadata(
                            CustomMetadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .folderId("folderId")
                        .folderPath("folderPath")
                        .name("name")
                        .type(Folder.Type.FOLDER)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        val unsafeUnwrapWebhookEvent = UnsafeUnwrapWebhookEvent.ofFolderUpdated(folderUpdated)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).contains(folderUpdated)
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).isEmpty
    }

    @Test
    fun ofFolderUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofFolderUpdated(
                FolderUpdateEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        Folder.builder()
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .createdBy(
                                Folder.CreatedBy.builder().email("email").name("name").build()
                            )
                            .customMetadata(
                                CustomMetadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .folderId("folderId")
                            .folderPath("folderPath")
                            .name("name")
                            .type(Folder.Type.FOLDER)
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
    }

    @Test
    fun ofFolderDeleted() {
        val folderDeleted =
            FolderDeleteEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(FolderDeleteEvent.Data.builder().folderId("folderId").build())
                .build()

        val unsafeUnwrapWebhookEvent = UnsafeUnwrapWebhookEvent.ofFolderDeleted(folderDeleted)

        assertThat(unsafeUnwrapWebhookEvent.videoTransformationAccepted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationReady()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.videoTransformationError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPreTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformSuccess()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.uploadPostTransformError()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.fileVersionDeleted()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderCreated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderUpdated()).isEmpty
        assertThat(unsafeUnwrapWebhookEvent.folderDeleted()).contains(folderDeleted)
    }

    @Test
    fun ofFolderDeletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unsafeUnwrapWebhookEvent =
            UnsafeUnwrapWebhookEvent.ofFolderDeleted(
                FolderDeleteEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(FolderDeleteEvent.Data.builder().folderId("folderId").build())
                    .build()
            )

        val roundtrippedUnsafeUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unsafeUnwrapWebhookEvent),
                jacksonTypeRef<UnsafeUnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnsafeUnwrapWebhookEvent).isEqualTo(unsafeUnwrapWebhookEvent)
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
        val unsafeUnwrapWebhookEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<UnsafeUnwrapWebhookEvent>())

        val e = assertThrows<ImageKitInvalidDataException> { unsafeUnwrapWebhookEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
