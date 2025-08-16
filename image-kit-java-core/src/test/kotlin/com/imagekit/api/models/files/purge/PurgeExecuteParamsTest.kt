// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.purge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PurgeExecuteParamsTest {

    @Test
    fun create() {
        PurgeExecuteParams.builder()
            .url("https://ik.imagekit.io/your_imagekit_id/default-image.jpg")
            .build()
    }

    @Test
    fun body() {
        val params =
            PurgeExecuteParams.builder()
                .url("https://ik.imagekit.io/your_imagekit_id/default-image.jpg")
                .build()

        val body = params._body()

        assertThat(body.url())
            .isEqualTo("https://ik.imagekit.io/your_imagekit_id/default-image.jpg")
    }
}
