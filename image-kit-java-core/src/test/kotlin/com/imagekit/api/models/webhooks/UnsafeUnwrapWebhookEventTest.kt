// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

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
