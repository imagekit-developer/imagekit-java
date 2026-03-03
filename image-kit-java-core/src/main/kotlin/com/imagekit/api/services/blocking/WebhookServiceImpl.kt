// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.UnwrapWebhookParams
import com.imagekit.api.core.checkRequired
import com.imagekit.api.errors.ImageKitInvalidDataException
import com.imagekit.api.errors.ImageKitWebhookException
import com.imagekit.api.models.webhooks.UnsafeUnwrapWebhookEvent
import com.imagekit.api.models.webhooks.UnwrapWebhookEvent
import com.standardwebhooks.Webhook
import com.standardwebhooks.exceptions.WebhookVerificationException
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class WebhookServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    WebhookService {

    private val withRawResponse: WebhookService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WebhookService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService =
        WebhookServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun unsafeUnwrap(body: String): UnsafeUnwrapWebhookEvent =
        try {
            clientOptions.jsonMapper.readValue(body, jacksonTypeRef<UnsafeUnwrapWebhookEvent>())
        } catch (e: Exception) {
            throw ImageKitInvalidDataException("Error parsing body", e)
        }

    override fun unwrap(body: String): UnwrapWebhookEvent =
        try {
            clientOptions.jsonMapper.readValue(body, jacksonTypeRef<UnwrapWebhookEvent>())
        } catch (e: Exception) {
            throw ImageKitInvalidDataException("Error parsing body", e)
        }

    override fun unwrap(unwrapParams: UnwrapWebhookParams): UnwrapWebhookEvent {
        val headers = unwrapParams.headers().getOrNull()
        if (headers != null) {
            try {
                val webhookSecret =
                    checkRequired(
                        "webhookSecret",
                        unwrapParams.secret().getOrNull()
                            ?: clientOptions.webhookSecret().getOrNull(),
                    )

                val headersMap =
                    headers.names().associateWith { name -> headers.values(name) }.toMap()

                val webhook = Webhook(webhookSecret)
                webhook.verify(unwrapParams.body(), headersMap)
            } catch (e: WebhookVerificationException) {
                throw ImageKitWebhookException("Could not verify webhook event signature", e)
            }
        }
        return unwrap(unwrapParams.body())
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
