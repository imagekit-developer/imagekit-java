// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.errors.ImageKitInvalidDataException
import com.imagekit.api.models.webhooks.UnsafeUnwrapWebhookEvent
import com.imagekit.api.models.webhooks.UnwrapWebhookEvent
import com.imagekit.api.services.blocking.WebhookServiceImpl
import java.util.function.Consumer

class WebhookServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    WebhookServiceAsync {

    private val withRawResponse: WebhookServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WebhookServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookServiceAsync =
        WebhookServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Unwraps a webhook event from its JSON representation.
     *
     * @throws ImageKitInvalidDataException if the body could not be parsed.
     */
    override fun unsafeUnwrap(body: String): UnsafeUnwrapWebhookEvent =
        WebhookServiceImpl(clientOptions).unsafeUnwrap(body)

    /**
     * Unwraps a webhook event from its JSON representation.
     *
     * @throws ImageKitInvalidDataException if the body could not be parsed.
     */
    override fun unwrap(body: String): UnwrapWebhookEvent =
        WebhookServiceImpl(clientOptions).unwrap(body)

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
