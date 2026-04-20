// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.async

import io.imagekit.io.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.io.models.ExtensionConfig
import io.imagekit.io.models.savedextensions.SavedExtensionCreateParams
import io.imagekit.io.models.savedextensions.SavedExtensionUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SavedExtensionServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val savedExtensionServiceAsync = client.savedExtensions()

        val savedExtensionFuture =
            savedExtensionServiceAsync.create(
                SavedExtensionCreateParams.builder()
                    .config(
                        ExtensionConfig.RemoveBg.builder()
                            .options(
                                ExtensionConfig.RemoveBg.Options.builder()
                                    .addShadow(true)
                                    .bgColor("bg_color")
                                    .bgImageUrl("bg_image_url")
                                    .semitransparency(true)
                                    .build()
                            )
                            .build()
                    )
                    .description(
                        "Analyzes vehicle images for type, condition, and quality assessment"
                    )
                    .name("Car Quality Analysis")
                    .build()
            )

        val savedExtension = savedExtensionFuture.get()
        savedExtension.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val savedExtensionServiceAsync = client.savedExtensions()

        val savedExtensionFuture =
            savedExtensionServiceAsync.update(
                SavedExtensionUpdateParams.builder()
                    .id("id")
                    .config(
                        ExtensionConfig.RemoveBg.builder()
                            .options(
                                ExtensionConfig.RemoveBg.Options.builder()
                                    .addShadow(true)
                                    .bgColor("bg_color")
                                    .bgImageUrl("bg_image_url")
                                    .semitransparency(true)
                                    .build()
                            )
                            .build()
                    )
                    .description("x")
                    .name("x")
                    .build()
            )

        val savedExtension = savedExtensionFuture.get()
        savedExtension.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val savedExtensionServiceAsync = client.savedExtensions()

        val savedExtensionsFuture = savedExtensionServiceAsync.list()

        val savedExtensions = savedExtensionsFuture.get()
        savedExtensions.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val savedExtensionServiceAsync = client.savedExtensions()

        val future = savedExtensionServiceAsync.delete("id")

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val savedExtensionServiceAsync = client.savedExtensions()

        val savedExtensionFuture = savedExtensionServiceAsync.get("id")

        val savedExtension = savedExtensionFuture.get()
        savedExtension.validate()
    }
}
