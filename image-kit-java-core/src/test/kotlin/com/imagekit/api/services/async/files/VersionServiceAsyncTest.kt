// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.files

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.models.files.versions.VersionDeleteParams
import com.imagekit.api.models.files.versions.VersionGetParams
import com.imagekit.api.models.files.versions.VersionRestoreParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class VersionServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val versionServiceAsync = client.files().versions()

        val filesFuture = versionServiceAsync.list("fileId")

        val files = filesFuture.get()
        files.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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

    @Disabled("Prism tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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

    @Disabled("Prism tests are disabled")
    @Test
    fun restore() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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
