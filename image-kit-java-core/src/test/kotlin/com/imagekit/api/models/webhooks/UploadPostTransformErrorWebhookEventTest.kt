// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadPostTransformErrorWebhookEventTest {

    @Test
    fun create() {
        val uploadPostTransformErrorWebhookEvent =
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

        assertThat(uploadPostTransformErrorWebhookEvent.id()).isEqualTo("id")
        assertThat(uploadPostTransformErrorWebhookEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(uploadPostTransformErrorWebhookEvent.data())
            .isEqualTo(
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
        assertThat(uploadPostTransformErrorWebhookEvent.request())
            .isEqualTo(
                UploadPostTransformErrorWebhookEvent.Request.builder()
                    .transformation(
                        UploadPostTransformErrorWebhookEvent.Request.Transformation.builder()
                            .type(
                                UploadPostTransformErrorWebhookEvent.Request.Transformation.Type
                                    .TRANSFORMATION
                            )
                            .protocol(
                                UploadPostTransformErrorWebhookEvent.Request.Transformation.Protocol
                                    .HLS
                            )
                            .value("value")
                            .build()
                    )
                    .xRequestId("x_request_id")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val uploadPostTransformErrorWebhookEvent =
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

        val roundtrippedUploadPostTransformErrorWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(uploadPostTransformErrorWebhookEvent),
                jacksonTypeRef<UploadPostTransformErrorWebhookEvent>(),
            )

        assertThat(roundtrippedUploadPostTransformErrorWebhookEvent)
            .isEqualTo(uploadPostTransformErrorWebhookEvent)
    }
}
