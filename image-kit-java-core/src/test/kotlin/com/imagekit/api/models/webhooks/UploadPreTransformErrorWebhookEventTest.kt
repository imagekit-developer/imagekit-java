// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadPreTransformErrorWebhookEventTest {

    @Test
    fun create() {
        val uploadPreTransformErrorWebhookEvent =
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

        assertThat(uploadPreTransformErrorWebhookEvent.id()).isEqualTo("id")
        assertThat(uploadPreTransformErrorWebhookEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(uploadPreTransformErrorWebhookEvent.data())
            .isEqualTo(
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
        assertThat(uploadPreTransformErrorWebhookEvent.request())
            .isEqualTo(
                UploadPreTransformErrorWebhookEvent.Request.builder()
                    .transformation("transformation")
                    .xRequestId("x_request_id")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val uploadPreTransformErrorWebhookEvent =
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

        val roundtrippedUploadPreTransformErrorWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(uploadPreTransformErrorWebhookEvent),
                jacksonTypeRef<UploadPreTransformErrorWebhookEvent>(),
            )

        assertThat(roundtrippedUploadPreTransformErrorWebhookEvent)
            .isEqualTo(uploadPreTransformErrorWebhookEvent)
    }
}
