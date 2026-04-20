// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.async

import io.imagekit.io.core.ClientOptions
import io.imagekit.io.services.async.cache.InvalidationServiceAsync
import io.imagekit.io.services.async.cache.InvalidationServiceAsyncImpl
import java.util.function.Consumer

class CacheServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CacheServiceAsync {

    private val withRawResponse: CacheServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val invalidation: InvalidationServiceAsync by lazy {
        InvalidationServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): CacheServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CacheServiceAsync =
        CacheServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun invalidation(): InvalidationServiceAsync = invalidation

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CacheServiceAsync.WithRawResponse {

        private val invalidation: InvalidationServiceAsync.WithRawResponse by lazy {
            InvalidationServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CacheServiceAsync.WithRawResponse =
            CacheServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun invalidation(): InvalidationServiceAsync.WithRawResponse = invalidation
    }
}
