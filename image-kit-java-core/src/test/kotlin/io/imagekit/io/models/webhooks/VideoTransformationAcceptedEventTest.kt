// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.io.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoTransformationAcceptedEventTest {

    @Test
    fun create() {
        val videoTransformationAcceptedEvent =
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

        assertThat(videoTransformationAcceptedEvent.id()).isEqualTo("id")
        assertThat(videoTransformationAcceptedEvent.type())
            .isEqualTo("video.transformation.accepted")
        assertThat(videoTransformationAcceptedEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(videoTransformationAcceptedEvent.data())
            .isEqualTo(
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
                                        VideoTransformationAcceptedEvent.Data.Transformation.Options
                                            .AudioCodec
                                            .AAC
                                    )
                                    .autoRotate(true)
                                    .format(
                                        VideoTransformationAcceptedEvent.Data.Transformation.Options
                                            .Format
                                            .MP4
                                    )
                                    .quality(0L)
                                    .streamProtocol(
                                        VideoTransformationAcceptedEvent.Data.Transformation.Options
                                            .StreamProtocol
                                            .HLS
                                    )
                                    .addVariant("string")
                                    .videoCodec(
                                        VideoTransformationAcceptedEvent.Data.Transformation.Options
                                            .VideoCodec
                                            .H264
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(videoTransformationAcceptedEvent.request())
            .isEqualTo(
                VideoTransformationAcceptedEvent.Request.builder()
                    .url("https://example.com")
                    .xRequestId("x_request_id")
                    .userAgent("user_agent")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val videoTransformationAcceptedEvent =
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

        val roundtrippedVideoTransformationAcceptedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(videoTransformationAcceptedEvent),
                jacksonTypeRef<VideoTransformationAcceptedEvent>(),
            )

        assertThat(roundtrippedVideoTransformationAcceptedEvent)
            .isEqualTo(videoTransformationAcceptedEvent)
    }
}
