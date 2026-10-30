// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking.accounts

import io.imagekit.client.okhttp.ImageKitOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ContractServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()
        val contractService = client.accounts().contract()

        val contract = contractService.get()

        contract.validate()
    }
}
