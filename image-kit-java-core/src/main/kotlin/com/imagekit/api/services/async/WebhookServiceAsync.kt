// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.UnwrapWebhookParams
import com.imagekit.api.errors.ImageKitInvalidDataException
import com.imagekit.api.errors.ImageKitWebhookException
import com.imagekit.api.models.webhooks.UnsafeUnwrapWebhookEvent
import com.imagekit.api.models.webhooks.UnwrapWebhookEvent
import java.util.function.Consumer

interface WebhookServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookServiceAsync

    /**
     * Unwraps a webhook event from its JSON representation.
     *
     * @throws ImageKitInvalidDataException if the body could not be parsed.
     */
    fun unsafeUnwrap(body: String): UnsafeUnwrapWebhookEvent

    /**
     * Unwraps a webhook event from its JSON representation.
     *
     * @throws ImageKitInvalidDataException if the body could not be parsed.
     */
    fun unwrap(body: String): UnwrapWebhookEvent

    /**
     * Unwraps a webhook event from its JSON representation.
     *
     * @throws ImageKitInvalidDataException if the body could not be parsed.
     * @throws ImageKitWebhookException if the webhook signature could not be verified
     */
    fun unwrap(unwrapParams: UnwrapWebhookParams): UnwrapWebhookEvent

    /**
     * A view of [WebhookServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WebhookServiceAsync.WithRawResponse
    }
}
