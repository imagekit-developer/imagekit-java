// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.models.assets.AssetListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AssetServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = ImageKitOkHttpClient.builder().privateKey("My Private Key").build()
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
