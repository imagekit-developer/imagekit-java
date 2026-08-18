// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.aifiltersearch

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AiFilterSearchCreateParamsTest {

    @Test
    fun create() {
        AiFilterSearchCreateParams.builder()
            .prompt("red dresses tagged summer uploaded last month")
            .currentFolder("/products")
            .timezone("Asia/Kolkata")
            .build()
    }

    @Test
    fun body() {
        val params =
            AiFilterSearchCreateParams.builder()
                .prompt("red dresses tagged summer uploaded last month")
                .currentFolder("/products")
                .timezone("Asia/Kolkata")
                .build()

        val body = params._body()

        assertThat(body.prompt()).isEqualTo("red dresses tagged summer uploaded last month")
        assertThat(body.currentFolder()).contains("/products")
        assertThat(body.timezone()).contains("Asia/Kolkata")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            AiFilterSearchCreateParams.builder()
                .prompt("red dresses tagged summer uploaded last month")
                .build()

        val body = params._body()

        assertThat(body.prompt()).isEqualTo("red dresses tagged summer uploaded last month")
    }
}
