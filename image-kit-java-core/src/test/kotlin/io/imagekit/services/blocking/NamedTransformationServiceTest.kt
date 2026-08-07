// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import io.imagekit.models.namedtransformations.NamedTransformationCreateParams
import io.imagekit.models.namedtransformations.NamedTransformationUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamedTransformationServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val namedTransformationService = client.namedTransformations()

        val namedTransformation =
            namedTransformationService.create(
                NamedTransformationCreateParams.builder()
                    .name("small_thumbnail")
                    .transformation("w-150,h-150,fo-center,cm-resize")
                    .enabled(true)
                    .build()
            )

        namedTransformation.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val namedTransformationService = client.namedTransformations()

        val namedTransformation =
            namedTransformationService.update(
                NamedTransformationUpdateParams.builder()
                    .id("id")
                    .enabled(true)
                    .name("small_thumbnail_v2")
                    .transformation("w-200,h-200,fo-center,cm-resize")
                    .build()
            )

        namedTransformation.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val namedTransformationService = client.namedTransformations()

        val namedTransformations = namedTransformationService.list()

        namedTransformations.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val namedTransformationService = client.namedTransformations()

        val namedTransformation = namedTransformationService.delete("id")

        namedTransformation.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val namedTransformationService = client.namedTransformations()

        val namedTransformation = namedTransformationService.get("id")

        namedTransformation.validate()
    }
}
