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

internal class UnwrapWebhookEventTest {

    @Test
    fun ofVideoTransformationAccepted() {
        val videoTransformationAccepted =
            VideoTransformationAcceptedWebhookEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    VideoTransformationAcceptedWebhookEvent.Data.builder()
                        .asset(
                            VideoTransformationAcceptedWebhookEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            VideoTransformationAcceptedWebhookEvent.Data.Transformation.builder()
                                .type(
                                    VideoTransformationAcceptedWebhookEvent.Data.Transformation.Type
                                        .VIDEO_TRANSFORMATION
                                )
                                .options(
                                    VideoTransformationAcceptedWebhookEvent.Data.Transformation
                                        .Options
                                        .builder()
                                        .audioCodec(
                                            VideoTransformationAcceptedWebhookEvent.Data
                                                .Transformation
                                                .Options
                                                .AudioCodec
                                                .AAC
                                        )
                                        .autoRotate(true)
                                        .format(
                                            VideoTransformationAcceptedWebhookEvent.Data
                                                .Transformation
                                                .Options
                                                .Format
                                                .MP4
                                        )
                                        .quality(0L)
                                        .streamProtocol(
                                            VideoTransformationAcceptedWebhookEvent.Data
                                                .Transformation
                                                .Options
                                                .StreamProtocol
                                                .HLS
                                        )
                                        .addVariant("string")
                                        .videoCodec(
                                            VideoTransformationAcceptedWebhookEvent.Data
                                                .Transformation
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
                    VideoTransformationAcceptedWebhookEvent.Request.builder()
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
    }

    @Test
    fun ofVideoTransformationAcceptedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationAccepted(
                VideoTransformationAcceptedWebhookEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        VideoTransformationAcceptedWebhookEvent.Data.builder()
                            .asset(
                                VideoTransformationAcceptedWebhookEvent.Data.Asset.builder()
                                    .url("https://example.com")
                                    .build()
                            )
                            .transformation(
                                VideoTransformationAcceptedWebhookEvent.Data.Transformation
                                    .builder()
                                    .type(
                                        VideoTransformationAcceptedWebhookEvent.Data.Transformation
                                            .Type
                                            .VIDEO_TRANSFORMATION
                                    )
                                    .options(
                                        VideoTransformationAcceptedWebhookEvent.Data.Transformation
                                            .Options
                                            .builder()
                                            .audioCodec(
                                                VideoTransformationAcceptedWebhookEvent.Data
                                                    .Transformation
                                                    .Options
                                                    .AudioCodec
                                                    .AAC
                                            )
                                            .autoRotate(true)
                                            .format(
                                                VideoTransformationAcceptedWebhookEvent.Data
                                                    .Transformation
                                                    .Options
                                                    .Format
                                                    .MP4
                                            )
                                            .quality(0L)
                                            .streamProtocol(
                                                VideoTransformationAcceptedWebhookEvent.Data
                                                    .Transformation
                                                    .Options
                                                    .StreamProtocol
                                                    .HLS
                                            )
                                            .addVariant("string")
                                            .videoCodec(
                                                VideoTransformationAcceptedWebhookEvent.Data
                                                    .Transformation
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
                        VideoTransformationAcceptedWebhookEvent.Request.builder()
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
            VideoTransformationReadyWebhookEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    VideoTransformationReadyWebhookEvent.Data.builder()
                        .asset(
                            VideoTransformationReadyWebhookEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            VideoTransformationReadyWebhookEvent.Data.Transformation.builder()
                                .type(
                                    VideoTransformationReadyWebhookEvent.Data.Transformation.Type
                                        .VIDEO_TRANSFORMATION
                                )
                                .options(
                                    VideoTransformationReadyWebhookEvent.Data.Transformation.Options
                                        .builder()
                                        .audioCodec(
                                            VideoTransformationReadyWebhookEvent.Data.Transformation
                                                .Options
                                                .AudioCodec
                                                .AAC
                                        )
                                        .autoRotate(true)
                                        .format(
                                            VideoTransformationReadyWebhookEvent.Data.Transformation
                                                .Options
                                                .Format
                                                .MP4
                                        )
                                        .quality(0L)
                                        .streamProtocol(
                                            VideoTransformationReadyWebhookEvent.Data.Transformation
                                                .Options
                                                .StreamProtocol
                                                .HLS
                                        )
                                        .addVariant("string")
                                        .videoCodec(
                                            VideoTransformationReadyWebhookEvent.Data.Transformation
                                                .Options
                                                .VideoCodec
                                                .H264
                                        )
                                        .build()
                                )
                                .output(
                                    VideoTransformationReadyWebhookEvent.Data.Transformation.Output
                                        .builder()
                                        .url("https://example.com")
                                        .videoMetadata(
                                            VideoTransformationReadyWebhookEvent.Data.Transformation
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
                    VideoTransformationReadyWebhookEvent.Request.builder()
                        .url("https://example.com")
                        .xRequestId("x_request_id")
                        .userAgent("user_agent")
                        .build()
                )
                .timings(
                    VideoTransformationReadyWebhookEvent.Timings.builder()
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
    }

    @Test
    fun ofVideoTransformationReadyRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationReady(
                VideoTransformationReadyWebhookEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        VideoTransformationReadyWebhookEvent.Data.builder()
                            .asset(
                                VideoTransformationReadyWebhookEvent.Data.Asset.builder()
                                    .url("https://example.com")
                                    .build()
                            )
                            .transformation(
                                VideoTransformationReadyWebhookEvent.Data.Transformation.builder()
                                    .type(
                                        VideoTransformationReadyWebhookEvent.Data.Transformation
                                            .Type
                                            .VIDEO_TRANSFORMATION
                                    )
                                    .options(
                                        VideoTransformationReadyWebhookEvent.Data.Transformation
                                            .Options
                                            .builder()
                                            .audioCodec(
                                                VideoTransformationReadyWebhookEvent.Data
                                                    .Transformation
                                                    .Options
                                                    .AudioCodec
                                                    .AAC
                                            )
                                            .autoRotate(true)
                                            .format(
                                                VideoTransformationReadyWebhookEvent.Data
                                                    .Transformation
                                                    .Options
                                                    .Format
                                                    .MP4
                                            )
                                            .quality(0L)
                                            .streamProtocol(
                                                VideoTransformationReadyWebhookEvent.Data
                                                    .Transformation
                                                    .Options
                                                    .StreamProtocol
                                                    .HLS
                                            )
                                            .addVariant("string")
                                            .videoCodec(
                                                VideoTransformationReadyWebhookEvent.Data
                                                    .Transformation
                                                    .Options
                                                    .VideoCodec
                                                    .H264
                                            )
                                            .build()
                                    )
                                    .output(
                                        VideoTransformationReadyWebhookEvent.Data.Transformation
                                            .Output
                                            .builder()
                                            .url("https://example.com")
                                            .videoMetadata(
                                                VideoTransformationReadyWebhookEvent.Data
                                                    .Transformation
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
                        VideoTransformationReadyWebhookEvent.Request.builder()
                            .url("https://example.com")
                            .xRequestId("x_request_id")
                            .userAgent("user_agent")
                            .build()
                    )
                    .timings(
                        VideoTransformationReadyWebhookEvent.Timings.builder()
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
            VideoTransformationErrorWebhookEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    VideoTransformationErrorWebhookEvent.Data.builder()
                        .asset(
                            VideoTransformationErrorWebhookEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            VideoTransformationErrorWebhookEvent.Data.Transformation.builder()
                                .type(
                                    VideoTransformationErrorWebhookEvent.Data.Transformation.Type
                                        .VIDEO_TRANSFORMATION
                                )
                                .error(
                                    VideoTransformationErrorWebhookEvent.Data.Transformation.Error
                                        .builder()
                                        .reason(
                                            VideoTransformationErrorWebhookEvent.Data.Transformation
                                                .Error
                                                .Reason
                                                .ENCODING_FAILED
                                        )
                                        .build()
                                )
                                .options(
                                    VideoTransformationErrorWebhookEvent.Data.Transformation.Options
                                        .builder()
                                        .audioCodec(
                                            VideoTransformationErrorWebhookEvent.Data.Transformation
                                                .Options
                                                .AudioCodec
                                                .AAC
                                        )
                                        .autoRotate(true)
                                        .format(
                                            VideoTransformationErrorWebhookEvent.Data.Transformation
                                                .Options
                                                .Format
                                                .MP4
                                        )
                                        .quality(0L)
                                        .streamProtocol(
                                            VideoTransformationErrorWebhookEvent.Data.Transformation
                                                .Options
                                                .StreamProtocol
                                                .HLS
                                        )
                                        .addVariant("string")
                                        .videoCodec(
                                            VideoTransformationErrorWebhookEvent.Data.Transformation
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
                    VideoTransformationErrorWebhookEvent.Request.builder()
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
    }

    @Test
    fun ofVideoTransformationErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofVideoTransformationError(
                VideoTransformationErrorWebhookEvent.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        VideoTransformationErrorWebhookEvent.Data.builder()
                            .asset(
                                VideoTransformationErrorWebhookEvent.Data.Asset.builder()
                                    .url("https://example.com")
                                    .build()
                            )
                            .transformation(
                                VideoTransformationErrorWebhookEvent.Data.Transformation.builder()
                                    .type(
                                        VideoTransformationErrorWebhookEvent.Data.Transformation
                                            .Type
                                            .VIDEO_TRANSFORMATION
                                    )
                                    .error(
                                        VideoTransformationErrorWebhookEvent.Data.Transformation
                                            .Error
                                            .builder()
                                            .reason(
                                                VideoTransformationErrorWebhookEvent.Data
                                                    .Transformation
                                                    .Error
                                                    .Reason
                                                    .ENCODING_FAILED
                                            )
                                            .build()
                                    )
                                    .options(
                                        VideoTransformationErrorWebhookEvent.Data.Transformation
                                            .Options
                                            .builder()
                                            .audioCodec(
                                                VideoTransformationErrorWebhookEvent.Data
                                                    .Transformation
                                                    .Options
                                                    .AudioCodec
                                                    .AAC
                                            )
                                            .autoRotate(true)
                                            .format(
                                                VideoTransformationErrorWebhookEvent.Data
                                                    .Transformation
                                                    .Options
                                                    .Format
                                                    .MP4
                                            )
                                            .quality(0L)
                                            .streamProtocol(
                                                VideoTransformationErrorWebhookEvent.Data
                                                    .Transformation
                                                    .Options
                                                    .StreamProtocol
                                                    .HLS
                                            )
                                            .addVariant("string")
                                            .videoCodec(
                                                VideoTransformationErrorWebhookEvent.Data
                                                    .Transformation
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
                        VideoTransformationErrorWebhookEvent.Request.builder()
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
