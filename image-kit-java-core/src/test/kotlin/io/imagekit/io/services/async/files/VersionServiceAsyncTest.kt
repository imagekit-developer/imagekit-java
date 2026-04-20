// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.async.files

import io.imagekit.io.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.io.models.files.versions.VersionDeleteParams
import io.imagekit.io.models.files.versions.VersionGetParams
import io.imagekit.io.models.files.versions.VersionRestoreParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class VersionServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val versionServiceAsync = client.files().versions()

        val filesFuture = versionServiceAsync.list("fileId")

        val files = filesFuture.get()
        files.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val versionServiceAsync = client.files().versions()

        val versionFuture =
            versionServiceAsync.delete(
                VersionDeleteParams.builder().fileId("fileId").versionId("versionId").build()
            )

        val version = versionFuture.get()
        version.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val versionServiceAsync = client.files().versions()

        val fileFuture =
            versionServiceAsync.get(
                VersionGetParams.builder().fileId("fileId").versionId("versionId").build()
            )

        val file = fileFuture.get()
        file.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun restore() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val versionServiceAsync = client.files().versions()

        val fileFuture =
            versionServiceAsync.restore(
                VersionRestoreParams.builder().fileId("fileId").versionId("versionId").build()
            )

        val file = fileFuture.get()
        file.validate()
    }
}
