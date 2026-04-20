// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.async

import io.imagekit.api.core.ClientOptions
import io.imagekit.api.core.UnwrapWebhookParams
import io.imagekit.api.models.webhooks.UnsafeUnwrapWebhookEvent
import io.imagekit.api.models.webhooks.UnwrapWebhookEvent
import io.imagekit.api.services.blocking.WebhookServiceImpl
import java.util.function.Consumer

class WebhookServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    WebhookServiceAsync {

    private val withRawResponse: WebhookServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WebhookServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookServiceAsync =
        WebhookServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun unsafeUnwrap(body: String): UnsafeUnwrapWebhookEvent =
        WebhookServiceImpl(clientOptions).unsafeUnwrap(body)

    override fun unwrap(body: String): UnwrapWebhookEvent =
        WebhookServiceImpl(clientOptions).unwrap(body)

    override fun unwrap(unwrapParams: UnwrapWebhookParams): UnwrapWebhookEvent =
        WebhookServiceImpl(clientOptions).unwrap(unwrapParams)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WebhookServiceAsync.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WebhookServiceAsync.WithRawResponse =
            WebhookServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
