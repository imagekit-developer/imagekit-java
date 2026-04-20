// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadPostTransformErrorEventTest {

    @Test
    fun create() {
        val uploadPostTransformErrorEvent =
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

        assertThat(uploadPostTransformErrorEvent.id()).isEqualTo("id")
        assertThat(uploadPostTransformErrorEvent.type()).isEqualTo("upload.post-transform.error")
        assertThat(uploadPostTransformErrorEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(uploadPostTransformErrorEvent.data())
            .isEqualTo(
                UploadPostTransformErrorEvent.Data.builder()
                    .fileId("fileId")
                    .name("name")
                    .path("path")
                    .transformation(
                        UploadPostTransformErrorEvent.Data.Transformation.builder()
                            .error(
                                UploadPostTransformErrorEvent.Data.Transformation.Error.builder()
                                    .reason("encoding_failed")
                                    .build()
                            )
                            .build()
                    )
                    .url("https://example.com")
                    .build()
            )
        assertThat(uploadPostTransformErrorEvent.request())
            .isEqualTo(
                UploadPostTransformErrorEvent.Request.builder()
                    .transformation(
                        UploadPostTransformErrorEvent.Request.Transformation.builder()
                            .type(
                                UploadPostTransformErrorEvent.Request.Transformation.Type
                                    .TRANSFORMATION
                            )
                            .protocol(
                                UploadPostTransformErrorEvent.Request.Transformation.Protocol.HLS
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
        val uploadPostTransformErrorEvent =
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

        val roundtrippedUploadPostTransformErrorEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(uploadPostTransformErrorEvent),
                jacksonTypeRef<UploadPostTransformErrorEvent>(),
            )

        assertThat(roundtrippedUploadPostTransformErrorEvent)
            .isEqualTo(uploadPostTransformErrorEvent)
    }
}
