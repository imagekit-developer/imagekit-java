// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.blocking

import io.imagekit.io.client.okhttp.ImageKitOkHttpClient
import io.imagekit.io.models.assets.AssetListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AssetServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val assetService = client.assets()

        val assets =
            assetService.list(
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

        assets.forEach { it.validate() }
    }
}
