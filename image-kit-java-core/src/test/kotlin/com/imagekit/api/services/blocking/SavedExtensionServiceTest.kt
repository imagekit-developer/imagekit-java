// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.ExtensionConfig
import com.imagekit.api.models.savedextensions.SavedExtensionCreateParams
import com.imagekit.api.models.savedextensions.SavedExtensionUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SavedExtensionServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = ImageKitOkHttpClient.builder().privateKey("My Private Key").build()
        val savedExtensionService = client.savedExtensions()

        val savedExtension =
            savedExtensionService.create(
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

        savedExtension.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = ImageKitOkHttpClient.builder().privateKey("My Private Key").build()
        val savedExtensionService = client.savedExtensions()

        val savedExtension =
            savedExtensionService.update(
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

        savedExtension.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = ImageKitOkHttpClient.builder().privateKey("My Private Key").build()
        val savedExtensionService = client.savedExtensions()

        val savedExtensions = savedExtensionService.list()

        savedExtensions.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = ImageKitOkHttpClient.builder().privateKey("My Private Key").build()
        val savedExtensionService = client.savedExtensions()

        savedExtensionService.delete("id")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client = ImageKitOkHttpClient.builder().privateKey("My Private Key").build()
        val savedExtensionService = client.savedExtensions()

        val savedExtension = savedExtensionService.get("id")

        savedExtension.validate()
    }
}
