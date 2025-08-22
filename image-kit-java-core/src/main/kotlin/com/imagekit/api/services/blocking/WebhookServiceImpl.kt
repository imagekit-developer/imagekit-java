// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.errors.ImageKitInvalidDataException
import com.imagekit.api.models.webhooks.UnsafeUnwrapWebhookEvent
import com.imagekit.api.models.webhooks.UnwrapWebhookEvent
import java.util.function.Consumer

class WebhookServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    WebhookService {

    private val withRawResponse: WebhookService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WebhookService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService =
        WebhookServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Unwraps a webhook event from its JSON representation.
     *
     * @throws ImageKitInvalidDataException if the body could not be parsed.
     */
    override fun unsafeUnwrap(body: String): UnsafeUnwrapWebhookEvent =
        try {
            clientOptions.jsonMapper.readValue(body, jacksonTypeRef<UnsafeUnwrapWebhookEvent>())
        } catch (e: Exception) {
            throw ImageKitInvalidDataException("Error parsing body", e)
        }

    /**
     * Unwraps a webhook event from its JSON representation.
     *
     * @throws ImageKitInvalidDataException if the body could not be parsed.
     */
    override fun unwrap(body: String): UnwrapWebhookEvent =
        try {
            clientOptions.jsonMapper.readValue(body, jacksonTypeRef<UnwrapWebhookEvent>())
        } catch (e: Exception) {
            throw ImageKitInvalidDataException("Error parsing body", e)
        }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WebhookService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WebhookService.WithRawResponse =
            WebhookServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
