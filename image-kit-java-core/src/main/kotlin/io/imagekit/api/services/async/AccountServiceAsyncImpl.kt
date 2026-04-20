// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.async

import io.imagekit.api.core.ClientOptions
import io.imagekit.api.services.async.accounts.OriginServiceAsync
import io.imagekit.api.services.async.accounts.OriginServiceAsyncImpl
import io.imagekit.api.services.async.accounts.UrlEndpointServiceAsync
import io.imagekit.api.services.async.accounts.UrlEndpointServiceAsyncImpl
import io.imagekit.api.services.async.accounts.UsageServiceAsync
import io.imagekit.api.services.async.accounts.UsageServiceAsyncImpl
import java.util.function.Consumer

class AccountServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AccountServiceAsync {

    private val withRawResponse: AccountServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val usage: UsageServiceAsync by lazy { UsageServiceAsyncImpl(clientOptions) }

    private val origins: OriginServiceAsync by lazy { OriginServiceAsyncImpl(clientOptions) }

    private val urlEndpoints: UrlEndpointServiceAsync by lazy {
        UrlEndpointServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): AccountServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountServiceAsync =
        AccountServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun usage(): UsageServiceAsync = usage

    override fun origins(): OriginServiceAsync = origins

    override fun urlEndpoints(): UrlEndpointServiceAsync = urlEndpoints

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AccountServiceAsync.WithRawResponse {

        private val usage: UsageServiceAsync.WithRawResponse by lazy {
            UsageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val origins: OriginServiceAsync.WithRawResponse by lazy {
            OriginServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val urlEndpoints: UrlEndpointServiceAsync.WithRawResponse by lazy {
            UrlEndpointServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccountServiceAsync.WithRawResponse =
            AccountServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun usage(): UsageServiceAsync.WithRawResponse = usage

        override fun origins(): OriginServiceAsync.WithRawResponse = origins

        override fun urlEndpoints(): UrlEndpointServiceAsync.WithRawResponse = urlEndpoints
    }
}
