// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.files.versions.VersionDeleteParams
import com.imagekit.api.models.files.versions.VersionRestoreParams
import com.imagekit.api.models.files.versions.VersionRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class VersionServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val versionService = client.files().versions()

        val version =
            versionService.retrieve(
                VersionRetrieveParams.builder().fileId("fileId").versionId("versionId").build()
            )

        version.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val versionService = client.files().versions()

        val versions = versionService.list("fileId")

        versions.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val versionService = client.files().versions()

        val version =
            versionService.delete(
                VersionDeleteParams.builder().fileId("fileId").versionId("versionId").build()
            )

        version.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun restore() {
        val client =
            ImageKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val versionService = client.files().versions()

        val response =
            versionService.restore(
                VersionRestoreParams.builder().fileId("fileId").versionId("versionId").build()
            )

        response.validate()
    }
}
