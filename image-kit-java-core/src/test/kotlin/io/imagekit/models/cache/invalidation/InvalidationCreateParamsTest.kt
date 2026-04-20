// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.cache.invalidation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvalidationCreateParamsTest {

    @Test
    fun create() {
        InvalidationCreateParams.builder()
            .url("https://ik.imagekit.io/your_imagekit_id/default-image.jpg")
            .build()
    }

    @Test
    fun body() {
        val params =
            InvalidationCreateParams.builder()
                .url("https://ik.imagekit.io/your_imagekit_id/default-image.jpg")
                .build()

        val body = params._body()

        assertThat(body.url())
            .isEqualTo("https://ik.imagekit.io/your_imagekit_id/default-image.jpg")
    }
}
