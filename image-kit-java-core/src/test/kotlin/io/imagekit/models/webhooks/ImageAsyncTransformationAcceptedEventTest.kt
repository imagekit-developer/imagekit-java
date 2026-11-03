// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageAsyncTransformationAcceptedEventTest {

    @Test
    fun create() {
        val imageAsyncTransformationAcceptedEvent =
            ImageAsyncTransformationAcceptedEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    ImageAsyncTransformationAcceptedEvent.Data.builder()
                        .asset(
                            ImageAsyncTransformationAcceptedEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            ImageAsyncTransformationAcceptedEvent.Data.Transformation.builder()
                                .type(
                                    ImageAsyncTransformationAcceptedEvent.Data.Transformation.Type
                                        .IMAGE_TRANSFORMATION
                                )
                                .options(
                                    ImageAsyncTransformationAcceptedEvent.Data.Transformation
                                        .Options
                                        .builder()
                                        .transformation("transformation")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .request(
                    ImageAsyncTransformationAcceptedEvent.Request.builder()
                        .url("https://example.com")
                        .xRequestId("x_request_id")
                        .userAgent("user_agent")
                        .build()
                )
                .build()

        assertThat(imageAsyncTransformationAcceptedEvent.id()).isEqualTo("id")
        assertThat(imageAsyncTransformationAcceptedEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(imageAsyncTransformationAcceptedEvent.data())
            .isEqualTo(
                ImageAsyncTransformationAcceptedEvent.Data.builder()
                    .asset(
                        ImageAsyncTransformationAcceptedEvent.Data.Asset.builder()
                            .url("https://example.com")
                            .build()
                    )
                    .transformation(
                        ImageAsyncTransformationAcceptedEvent.Data.Transformation.builder()
                            .type(
                                ImageAsyncTransformationAcceptedEvent.Data.Transformation.Type
                                    .IMAGE_TRANSFORMATION
                            )
                            .options(
                                ImageAsyncTransformationAcceptedEvent.Data.Transformation.Options
                                    .builder()
                                    .transformation("transformation")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(imageAsyncTransformationAcceptedEvent.request())
            .isEqualTo(
                ImageAsyncTransformationAcceptedEvent.Request.builder()
                    .url("https://example.com")
                    .xRequestId("x_request_id")
                    .userAgent("user_agent")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageAsyncTransformationAcceptedEvent =
            ImageAsyncTransformationAcceptedEvent.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    ImageAsyncTransformationAcceptedEvent.Data.builder()
                        .asset(
                            ImageAsyncTransformationAcceptedEvent.Data.Asset.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .transformation(
                            ImageAsyncTransformationAcceptedEvent.Data.Transformation.builder()
                                .type(
                                    ImageAsyncTransformationAcceptedEvent.Data.Transformation.Type
                                        .IMAGE_TRANSFORMATION
                                )
                                .options(
                                    ImageAsyncTransformationAcceptedEvent.Data.Transformation
                                        .Options
                                        .builder()
                                        .transformation("transformation")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .request(
                    ImageAsyncTransformationAcceptedEvent.Request.builder()
                        .url("https://example.com")
                        .xRequestId("x_request_id")
                        .userAgent("user_agent")
                        .build()
                )
                .build()

        val roundtrippedImageAsyncTransformationAcceptedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageAsyncTransformationAcceptedEvent),
                jacksonTypeRef<ImageAsyncTransformationAcceptedEvent>(),
            )

        assertThat(roundtrippedImageAsyncTransformationAcceptedEvent)
            .isEqualTo(imageAsyncTransformationAcceptedEvent)
    }
}
