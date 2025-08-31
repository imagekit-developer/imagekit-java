// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadPostTransformSuccessWebhookEventTest {

    @Test
    fun create() {
        val uploadPostTransformSuccessWebhookEvent =
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

        assertThat(uploadPostTransformSuccessWebhookEvent.id()).isEqualTo("id")
        assertThat(uploadPostTransformSuccessWebhookEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(uploadPostTransformSuccessWebhookEvent.data())
            .isEqualTo(
                UploadPostTransformSuccessWebhookEvent.Data.builder()
                    .fileId("fileId")
                    .name("name")
                    .url("https://example.com")
                    .build()
            )
        assertThat(uploadPostTransformSuccessWebhookEvent.request())
            .isEqualTo(
                UploadPostTransformSuccessWebhookEvent.Request.builder()
                    .transformation(
                        UploadPostTransformSuccessWebhookEvent.Request.Transformation.builder()
                            .type(
                                UploadPostTransformSuccessWebhookEvent.Request.Transformation.Type
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val uploadPostTransformSuccessWebhookEvent =
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

        val roundtrippedUploadPostTransformSuccessWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(uploadPostTransformSuccessWebhookEvent),
                jacksonTypeRef<UploadPostTransformSuccessWebhookEvent>(),
            )

        assertThat(roundtrippedUploadPostTransformSuccessWebhookEvent)
            .isEqualTo(uploadPostTransformSuccessWebhookEvent)
    }
}
