// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.blocking

import io.imagekit.api.core.ClientOptions
import io.imagekit.api.core.UnwrapWebhookParams
import io.imagekit.api.errors.ImageKitInvalidDataException
import io.imagekit.api.errors.ImageKitWebhookException
import io.imagekit.api.models.webhooks.UnsafeUnwrapWebhookEvent
import io.imagekit.api.models.webhooks.UnwrapWebhookEvent
import java.util.function.Consumer

interface WebhookService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService

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

    /** A view of [WebhookService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService.WithRawResponse
    }
}
