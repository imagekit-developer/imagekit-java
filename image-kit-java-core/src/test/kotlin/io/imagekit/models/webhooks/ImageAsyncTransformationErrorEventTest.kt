// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageAsyncTransformationErrorEventTest {

    @Test
    fun create() {
        val imageAsyncTransformationErrorEvent =
            ImageAsyncTransformationErrorEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    ImageAsyncTransformationErrorEvent.Data.builder()
                        .asset(
                            ImageAsyncTransformationErrorEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            ImageAsyncTransformationErrorEvent.Data.Transformation.builder()
                                .type(
                                    ImageAsyncTransformationErrorEvent.Data.Transformation.Type
                                        .IMAGE_TRANSFORMATION
                                )
                                .error(
                                    ImageAsyncTransformationErrorEvent.Data.Transformation.Error
                                        .builder()
                                        .reason(
                                            ImageAsyncTransformationErrorEvent.Data.Transformation
                                                .Error
                                                .Reason
                                                .DOWNLOAD_FAILED
                                        )
                                        .message("message")
                                        .build()
                                )
                                .options(
                                    ImageAsyncTransformationErrorEvent.Data.Transformation.Options
                                        .builder()
                                        .transformation("transformation")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .request(
                    ImageAsyncTransformationErrorEvent.Request.builder()
                        .url("https://example.com")
                        .xRequestId("x_request_id")
                        .userAgent("user_agent")
                        .build()
                )
                .build()

        assertThat(imageAsyncTransformationErrorEvent.id()).isEqualTo("id")
        assertThat(imageAsyncTransformationErrorEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(imageAsyncTransformationErrorEvent.data())
            .isEqualTo(
                ImageAsyncTransformationErrorEvent.Data.builder()
                    .asset(
                        ImageAsyncTransformationErrorEvent.Data.Asset.builder()
                            .url("https://example.com")
                            .build()
                    )
                    .transformation(
                        ImageAsyncTransformationErrorEvent.Data.Transformation.builder()
                            .type(
                                ImageAsyncTransformationErrorEvent.Data.Transformation.Type
                                    .IMAGE_TRANSFORMATION
                            )
                            .error(
                                ImageAsyncTransformationErrorEvent.Data.Transformation.Error
                                    .builder()
                                    .reason(
                                        ImageAsyncTransformationErrorEvent.Data.Transformation.Error
                                            .Reason
                                            .DOWNLOAD_FAILED
                                    )
                                    .message("message")
                                    .build()
                            )
                            .options(
                                ImageAsyncTransformationErrorEvent.Data.Transformation.Options
                                    .builder()
                                    .transformation("transformation")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(imageAsyncTransformationErrorEvent.request())
            .isEqualTo(
                ImageAsyncTransformationErrorEvent.Request.builder()
                    .url("https://example.com")
                    .xRequestId("x_request_id")
                    .userAgent("user_agent")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageAsyncTransformationErrorEvent =
            ImageAsyncTransformationErrorEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    ImageAsyncTransformationErrorEvent.Data.builder()
                        .asset(
                            ImageAsyncTransformationErrorEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            ImageAsyncTransformationErrorEvent.Data.Transformation.builder()
                                .type(
                                    ImageAsyncTransformationErrorEvent.Data.Transformation.Type
                                        .IMAGE_TRANSFORMATION
                                )
                                .error(
                                    ImageAsyncTransformationErrorEvent.Data.Transformation.Error
                                        .builder()
                                        .reason(
                                            ImageAsyncTransformationErrorEvent.Data.Transformation
                                                .Error
                                                .Reason
                                                .DOWNLOAD_FAILED
                                        )
                                        .message("message")
                                        .build()
                                )
                                .options(
                                    ImageAsyncTransformationErrorEvent.Data.Transformation.Options
                                        .builder()
                                        .transformation("transformation")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .request(
                    ImageAsyncTransformationErrorEvent.Request.builder()
                        .url("https://example.com")
                        .xRequestId("x_request_id")
                        .userAgent("user_agent")
                        .build()
                )
                .build()

        val roundtrippedImageAsyncTransformationErrorEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageAsyncTransformationErrorEvent),
                jacksonTypeRef<ImageAsyncTransformationErrorEvent>(),
            )

        assertThat(roundtrippedImageAsyncTransformationErrorEvent)
            .isEqualTo(imageAsyncTransformationErrorEvent)
    }
}
