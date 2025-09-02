// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadPostTransformSuccessEventTest {

    @Test
    fun create() {
        val uploadPostTransformSuccessEvent =
            UploadPostTransformSuccessEvent.builder()
                .id("id")
                .type("upload.post-transform.success")
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

        assertThat(uploadPostTransformSuccessEvent.id()).isEqualTo("id")
        assertThat(uploadPostTransformSuccessEvent.type())
            .isEqualTo("upload.post-transform.success")
        assertThat(uploadPostTransformSuccessEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(uploadPostTransformSuccessEvent.data())
            .isEqualTo(
                UploadPostTransformSuccessEvent.Data.builder()
                    .fileId("fileId")
                    .name("name")
                    .url("https://example.com")
                    .build()
            )
        assertThat(uploadPostTransformSuccessEvent.request())
            .isEqualTo(
                UploadPostTransformSuccessEvent.Request.builder()
                    .transformation(
                        UploadPostTransformSuccessEvent.Request.Transformation.builder()
                            .type(
                                UploadPostTransformSuccessEvent.Request.Transformation.Type
                                    .TRANSFORMATION
                            )
                            .protocol(
                                UploadPostTransformSuccessEvent.Request.Transformation.Protocol.HLS
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
        val uploadPostTransformSuccessEvent =
            UploadPostTransformSuccessEvent.builder()
                .id("id")
                .type("upload.post-transform.success")
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

        val roundtrippedUploadPostTransformSuccessEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(uploadPostTransformSuccessEvent),
                jacksonTypeRef<UploadPostTransformSuccessEvent>(),
            )

        assertThat(roundtrippedUploadPostTransformSuccessEvent)
            .isEqualTo(uploadPostTransformSuccessEvent)
    }
}
