// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync
import io.imagekit.models.assets.AssetListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AssetServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val assetServiceAsync = client.assets()

        val assetsFuture =
            assetServiceAsync.list(
                AssetListParams.builder()
                    .fileType(AssetListParams.FileType.ALL)
                    .limit(1L)
                    .path("path")
                    .searchQuery("searchQuery")
                    .skip(0L)
                    .sort(AssetListParams.Sort.ASC_NAME)
                    .type(AssetListParams.Type.FILE)
                    .build()
            )

        val assets = assetsFuture.get()
        assets.forEach { it.validate() }
    }
}
