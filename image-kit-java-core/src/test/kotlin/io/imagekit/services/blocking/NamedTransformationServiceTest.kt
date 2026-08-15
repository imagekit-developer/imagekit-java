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
                    .transformation("w-150,h-150,fo-center,cm-pad_resize")
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
                    .id("6bZ9x2ZUx")
                    .enabled(false)
                    .name("small_thumbnail")
                    .transformation("w-200,h-200,fo-center,cm-pad_resize")
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

        namedTransformationService.delete("6bZ9x2ZUx")
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

        val namedTransformation = namedTransformationService.get("6bZ9x2ZUx")

        namedTransformation.validate()
    }
}
