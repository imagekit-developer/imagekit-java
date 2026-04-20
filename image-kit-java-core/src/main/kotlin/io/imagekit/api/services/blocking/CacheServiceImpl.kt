// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.blocking

import io.imagekit.api.core.ClientOptions
import io.imagekit.api.services.blocking.cache.InvalidationService
import io.imagekit.api.services.blocking.cache.InvalidationServiceImpl
import java.util.function.Consumer

class CacheServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CacheService {

    private val withRawResponse: CacheService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val invalidation: InvalidationService by lazy { InvalidationServiceImpl(clientOptions) }

    override fun withRawResponse(): CacheService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CacheService =
        CacheServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun invalidation(): InvalidationService = invalidation

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CacheService.WithRawResponse {

        private val invalidation: InvalidationService.WithRawResponse by lazy {
            InvalidationServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CacheService.WithRawResponse =
            CacheServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun invalidation(): InvalidationService.WithRawResponse = invalidation
    }
}
