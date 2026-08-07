// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.models.namedtransformations.NamedTransformationCreateParams
import io.imagekit.models.namedtransformations.NamedTransformationUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamedTransformationServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val namedTransformationServiceAsync = client.namedTransformations()

        val namedTransformationFuture =
            namedTransformationServiceAsync.create(
                NamedTransformationCreateParams.builder()
                    .name("small_thumbnail")
                    .transformation("w-150,h-150,fo-center,cm-resize")
                    .enabled(true)
                    .build()
            )

        val namedTransformation = namedTransformationFuture.get()
        namedTransformation.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val namedTransformationServiceAsync = client.namedTransformations()

        val namedTransformationFuture =
            namedTransformationServiceAsync.update(
                NamedTransformationUpdateParams.builder()
                    .id("id")
                    .enabled(true)
                    .name("small_thumbnail_v2")
                    .transformation("w-200,h-200,fo-center,cm-resize")
                    .build()
            )

        val namedTransformation = namedTransformationFuture.get()
        namedTransformation.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val namedTransformationServiceAsync = client.namedTransformations()

        val namedTransformationsFuture = namedTransformationServiceAsync.list()

        val namedTransformations = namedTransformationsFuture.get()
        namedTransformations.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val namedTransformationServiceAsync = client.namedTransformations()

        val namedTransformationFuture = namedTransformationServiceAsync.delete("id")

        val namedTransformation = namedTransformationFuture.get()
        namedTransformation.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val namedTransformationServiceAsync = client.namedTransformations()

        val namedTransformationFuture = namedTransformationServiceAsync.get("id")

        val namedTransformation = namedTransformationFuture.get()
        namedTransformation.validate()
    }
}
