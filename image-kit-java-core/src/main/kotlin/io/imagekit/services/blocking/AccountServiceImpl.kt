// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking

import io.imagekit.core.ClientOptions
import io.imagekit.services.blocking.accounts.OriginService
import io.imagekit.services.blocking.accounts.OriginServiceImpl
import io.imagekit.services.blocking.accounts.UrlEndpointService
import io.imagekit.services.blocking.accounts.UrlEndpointServiceImpl
import io.imagekit.services.blocking.accounts.UsageService
import io.imagekit.services.blocking.accounts.UsageServiceImpl
import java.util.function.Consumer

class AccountServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AccountService {

    private val withRawResponse: AccountService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val usage: UsageService by lazy { UsageServiceImpl(clientOptions) }

    private val origins: OriginService by lazy { OriginServiceImpl(clientOptions) }

    private val urlEndpoints: UrlEndpointService by lazy { UrlEndpointServiceImpl(clientOptions) }

    override fun withRawResponse(): AccountService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService =
        AccountServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun usage(): UsageService = usage

    override fun origins(): OriginService = origins

    override fun urlEndpoints(): UrlEndpointService = urlEndpoints

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AccountService.WithRawResponse {

        private val usage: UsageService.WithRawResponse by lazy {
            UsageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val origins: OriginService.WithRawResponse by lazy {
            OriginServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val urlEndpoints: UrlEndpointService.WithRawResponse by lazy {
            UrlEndpointServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccountService.WithRawResponse =
            AccountServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun usage(): UsageService.WithRawResponse = usage

        override fun origins(): OriginService.WithRawResponse = origins

        override fun urlEndpoints(): UrlEndpointService.WithRawResponse = urlEndpoints
    }
}
