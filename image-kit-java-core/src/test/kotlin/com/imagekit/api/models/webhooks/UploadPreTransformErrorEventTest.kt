// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadPreTransformErrorEventTest {

    @Test
    fun create() {
        val uploadPreTransformErrorEvent =
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

        assertThat(uploadPreTransformErrorEvent.id()).isEqualTo("id")
        assertThat(uploadPreTransformErrorEvent.type()).isEqualTo("upload.pre-transform.error")
        assertThat(uploadPreTransformErrorEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(uploadPreTransformErrorEvent.data())
            .isEqualTo(
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
        assertThat(uploadPreTransformErrorEvent.request())
            .isEqualTo(
                UploadPreTransformErrorEvent.Request.builder()
                    .transformation("transformation")
                    .xRequestId("x_request_id")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val uploadPreTransformErrorEvent =
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

        val roundtrippedUploadPreTransformErrorEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(uploadPreTransformErrorEvent),
                jacksonTypeRef<UploadPreTransformErrorEvent>(),
            )

        assertThat(roundtrippedUploadPreTransformErrorEvent).isEqualTo(uploadPreTransformErrorEvent)
    }
}
