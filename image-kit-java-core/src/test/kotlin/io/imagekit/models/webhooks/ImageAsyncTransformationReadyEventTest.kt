// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageAsyncTransformationReadyEventTest {

    @Test
    fun create() {
        val imageAsyncTransformationReadyEvent =
            ImageAsyncTransformationReadyEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    ImageAsyncTransformationReadyEvent.Data.builder()
                        .asset(
                            ImageAsyncTransformationReadyEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            ImageAsyncTransformationReadyEvent.Data.Transformation.builder()
                                .type(
                                    ImageAsyncTransformationReadyEvent.Data.Transformation.Type
                                        .IMAGE_TRANSFORMATION
                                )
                                .options(
                                    ImageAsyncTransformationReadyEvent.Data.Transformation.Options
                                        .builder()
                                        .transformation("transformation")
                                        .build()
                                )
                                .output(
                                    ImageAsyncTransformationReadyEvent.Data.Transformation.Output
                                        .builder()
                                        .url("https://example.com")
                                        .imageMetadata(
                                            ImageAsyncTransformationReadyEvent.Data.Transformation
                                                .Output
                                                .ImageMetadata
                                                .builder()
                                                .size(0L)
                                                .format("format")
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .request(
                    ImageAsyncTransformationReadyEvent.Request.builder()
                        .url("https://example.com")
                        .xRequestId("x_request_id")
                        .userAgent("user_agent")
                        .build()
                )
                .timings(
                    ImageAsyncTransformationReadyEvent.Timings.builder()
                        .processingDuration(0L)
                        .queueDuration(0L)
                        .build()
                )
                .build()

        assertThat(imageAsyncTransformationReadyEvent.id()).isEqualTo("id")
        assertThat(imageAsyncTransformationReadyEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(imageAsyncTransformationReadyEvent.data())
            .isEqualTo(
                ImageAsyncTransformationReadyEvent.Data.builder()
                    .asset(
                        ImageAsyncTransformationReadyEvent.Data.Asset.builder()
                            .url("https://example.com")
                            .build()
                    )
                    .transformation(
                        ImageAsyncTransformationReadyEvent.Data.Transformation.builder()
                            .type(
                                ImageAsyncTransformationReadyEvent.Data.Transformation.Type
                                    .IMAGE_TRANSFORMATION
                            )
                            .options(
                                ImageAsyncTransformationReadyEvent.Data.Transformation.Options
                                    .builder()
                                    .transformation("transformation")
                                    .build()
                            )
                            .output(
                                ImageAsyncTransformationReadyEvent.Data.Transformation.Output
                                    .builder()
                                    .url("https://example.com")
                                    .imageMetadata(
                                        ImageAsyncTransformationReadyEvent.Data.Transformation
                                            .Output
                                            .ImageMetadata
                                            .builder()
                                            .size(0L)
                                            .format("format")
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(imageAsyncTransformationReadyEvent.request())
            .isEqualTo(
                ImageAsyncTransformationReadyEvent.Request.builder()
                    .url("https://example.com")
                    .xRequestId("x_request_id")
                    .userAgent("user_agent")
                    .build()
            )
        assertThat(imageAsyncTransformationReadyEvent.timings())
            .contains(
                ImageAsyncTransformationReadyEvent.Timings.builder()
                    .processingDuration(0L)
                    .queueDuration(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageAsyncTransformationReadyEvent =
            ImageAsyncTransformationReadyEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    ImageAsyncTransformationReadyEvent.Data.builder()
                        .asset(
                            ImageAsyncTransformationReadyEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            ImageAsyncTransformationReadyEvent.Data.Transformation.builder()
                                .type(
                                    ImageAsyncTransformationReadyEvent.Data.Transformation.Type
                                        .IMAGE_TRANSFORMATION
                                )
                                .options(
                                    ImageAsyncTransformationReadyEvent.Data.Transformation.Options
                                        .builder()
                                        .transformation("transformation")
                                        .build()
                                )
                                .output(
                                    ImageAsyncTransformationReadyEvent.Data.Transformation.Output
                                        .builder()
                                        .url("https://example.com")
                                        .imageMetadata(
                                            ImageAsyncTransformationReadyEvent.Data.Transformation
                                                .Output
                                                .ImageMetadata
                                                .builder()
                                                .size(0L)
                                                .format("format")
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .request(
                    ImageAsyncTransformationReadyEvent.Request.builder()
                        .url("https://example.com")
                        .xRequestId("x_request_id")
                        .userAgent("user_agent")
                        .build()
                )
                .timings(
                    ImageAsyncTransformationReadyEvent.Timings.builder()
                        .processingDuration(0L)
                        .queueDuration(0L)
                        .build()
                )
                .build()

        val roundtrippedImageAsyncTransformationReadyEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageAsyncTransformationReadyEvent),
                jacksonTypeRef<ImageAsyncTransformationReadyEvent>(),
            )

        assertThat(roundtrippedImageAsyncTransformationReadyEvent)
            .isEqualTo(imageAsyncTransformationReadyEvent)
    }
}
