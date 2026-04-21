// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking

import io.imagekit.core.ClientOptions
import io.imagekit.services.blocking.beta.V2Service
import io.imagekit.services.blocking.beta.V2ServiceImpl
import java.util.function.Consumer

class BetaServiceImpl internal constructor(private val clientOptions: ClientOptions) : BetaService {

    private val withRawResponse: BetaService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val v2: V2Service by lazy { V2ServiceImpl(clientOptions) }

    override fun withRawResponse(): BetaService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaService =
        BetaServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun v2(): V2Service = v2

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BetaService.WithRawResponse {

        private val v2: V2Service.WithRawResponse by lazy {
            V2ServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BetaService.WithRawResponse =
            BetaServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun v2(): V2Service.WithRawResponse = v2
    }
}
