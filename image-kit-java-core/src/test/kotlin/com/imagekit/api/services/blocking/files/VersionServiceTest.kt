// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.files.versions.VersionDeleteParams
import com.imagekit.api.models.files.versions.VersionGetParams
import com.imagekit.api.models.files.versions.VersionRestoreParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class VersionServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val versionService = client.files().versions()

        val files = versionService.list("fileId")

        files.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val versionService = client.files().versions()

        val version =
            versionService.delete(
                VersionDeleteParams.builder().fileId("fileId").versionId("versionId").build()
            )

        version.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val versionService = client.files().versions()

        val file =
            versionService.get(
                VersionGetParams.builder().fileId("fileId").versionId("versionId").build()
            )

        file.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun restore() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val versionService = client.files().versions()

        val file =
            versionService.restore(
                VersionRestoreParams.builder().fileId("fileId").versionId("versionId").build()
            )

        file.validate()
    }
}
