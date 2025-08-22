// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoTransformationAcceptedWebhookEventTest {

    @Test
    fun create() {
        val videoTransformationAcceptedWebhookEvent =
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
                .type(VideoTransformationAcceptedWebhookEvent.Type.VIDEO_TRANSFORMATION_ACCEPTED)
                .build()

        assertThat(videoTransformationAcceptedWebhookEvent.id()).isEqualTo("id")
        assertThat(videoTransformationAcceptedWebhookEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(videoTransformationAcceptedWebhookEvent.data())
            .isEqualTo(
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
                                VideoTransformationAcceptedWebhookEvent.Data.Transformation.Options
                                    .builder()
                                    .audioCodec(
                                        VideoTransformationAcceptedWebhookEvent.Data.Transformation
                                            .Options
                                            .AudioCodec
                                            .AAC
                                    )
                                    .autoRotate(true)
                                    .format(
                                        VideoTransformationAcceptedWebhookEvent.Data.Transformation
                                            .Options
                                            .Format
                                            .MP4
                                    )
                                    .quality(0L)
                                    .streamProtocol(
                                        VideoTransformationAcceptedWebhookEvent.Data.Transformation
                                            .Options
                                            .StreamProtocol
                                            .HLS
                                    )
                                    .addVariant("string")
                                    .videoCodec(
                                        VideoTransformationAcceptedWebhookEvent.Data.Transformation
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
        assertThat(videoTransformationAcceptedWebhookEvent.request())
            .isEqualTo(
                VideoTransformationAcceptedWebhookEvent.Request.builder()
                    .url("https://example.com")
                    .xRequestId("x_request_id")
                    .userAgent("user_agent")
                    .build()
            )
        assertThat(videoTransformationAcceptedWebhookEvent.type())
            .isEqualTo(VideoTransformationAcceptedWebhookEvent.Type.VIDEO_TRANSFORMATION_ACCEPTED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val videoTransformationAcceptedWebhookEvent =
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
                .type(VideoTransformationAcceptedWebhookEvent.Type.VIDEO_TRANSFORMATION_ACCEPTED)
                .build()

        val roundtrippedVideoTransformationAcceptedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(videoTransformationAcceptedWebhookEvent),
                jacksonTypeRef<VideoTransformationAcceptedWebhookEvent>(),
            )

        assertThat(roundtrippedVideoTransformationAcceptedWebhookEvent)
            .isEqualTo(videoTransformationAcceptedWebhookEvent)
    }
}
