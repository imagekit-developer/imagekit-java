// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking

import io.imagekit.core.ClientOptions
import io.imagekit.services.blocking.accounts.ContractService
import io.imagekit.services.blocking.accounts.ContractServiceImpl
import io.imagekit.services.blocking.accounts.OriginService
import io.imagekit.services.blocking.accounts.OriginServiceImpl
import io.imagekit.services.blocking.accounts.UrlEndpointService
import io.imagekit.services.blocking.accounts.UrlEndpointServiceImpl
import io.imagekit.services.blocking.accounts.UsageAnalyticsService
import io.imagekit.services.blocking.accounts.UsageAnalyticsServiceImpl
import io.imagekit.services.blocking.accounts.UsageService
import io.imagekit.services.blocking.accounts.UsageServiceImpl
import io.imagekit.services.blocking.accounts.WebhookService
import io.imagekit.services.blocking.accounts.WebhookServiceImpl
import java.util.function.Consumer

class AccountServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AccountService {

    private val withRawResponse: AccountService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val usage: UsageService by lazy { UsageServiceImpl(clientOptions) }

    private val usageAnalytics: UsageAnalyticsService by lazy {
        UsageAnalyticsServiceImpl(clientOptions)
    }

    private val contract: ContractService by lazy { ContractServiceImpl(clientOptions) }

    private val origins: OriginService by lazy { OriginServiceImpl(clientOptions) }

    private val urlEndpoints: UrlEndpointService by lazy { UrlEndpointServiceImpl(clientOptions) }

    private val webhooks: WebhookService by lazy { WebhookServiceImpl(clientOptions) }

    override fun withRawResponse(): AccountService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService =
        AccountServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun usage(): UsageService = usage

    override fun usageAnalytics(): UsageAnalyticsService = usageAnalytics

    override fun contract(): ContractService = contract

    override fun origins(): OriginService = origins

    override fun urlEndpoints(): UrlEndpointService = urlEndpoints

    override fun webhooks(): WebhookService = webhooks

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AccountService.WithRawResponse {

        private val usage: UsageService.WithRawResponse by lazy {
            UsageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val usageAnalytics: UsageAnalyticsService.WithRawResponse by lazy {
            UsageAnalyticsServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val contract: ContractService.WithRawResponse by lazy {
            ContractServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val origins: OriginService.WithRawResponse by lazy {
            OriginServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val urlEndpoints: UrlEndpointService.WithRawResponse by lazy {
            UrlEndpointServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val webhooks: WebhookService.WithRawResponse by lazy {
            WebhookServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccountService.WithRawResponse =
            AccountServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun usage(): UsageService.WithRawResponse = usage

        override fun usageAnalytics(): UsageAnalyticsService.WithRawResponse = usageAnalytics

        override fun contract(): ContractService.WithRawResponse = contract

        override fun origins(): OriginService.WithRawResponse = origins

        override fun urlEndpoints(): UrlEndpointService.WithRawResponse = urlEndpoints

        override fun webhooks(): WebhookService.WithRawResponse = webhooks
    }
}
