// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.ExtensionConfig
import com.imagekit.api.models.savedextensions.SavedExtensionCreateParams
import com.imagekit.api.models.savedextensions.SavedExtensionUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SavedExtensionServiceAsyncTest {

    @Disabled("Prism tests are disabled")
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

    @Disabled("Prism tests are disabled")
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

    @Disabled("Prism tests are disabled")
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

    @Disabled("Prism tests are disabled")
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

    @Disabled("Prism tests are disabled")
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
