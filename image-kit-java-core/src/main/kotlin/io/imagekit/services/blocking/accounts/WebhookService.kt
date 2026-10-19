// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking.accounts

import com.google.errorprone.annotations.MustBeClosed
import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponse
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.accounts.webhooks.Webhook
import io.imagekit.models.accounts.webhooks.WebhookCreateParams
import io.imagekit.models.accounts.webhooks.WebhookDeleteParams
import io.imagekit.models.accounts.webhooks.WebhookGetParams
import io.imagekit.models.accounts.webhooks.WebhookListParams
import io.imagekit.models.accounts.webhooks.WebhookUpdateParams
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
     * Creates a new webhook and returns the created object, including the generated signing
     * `secret`.
     *
     * ImageKit sends a `POST` request to the webhook `endpoint` whenever one of the subscribed
     * `events` occurs. Use the `secret` to verify the signature of each request. Learn more about
     * [webhooks](https://imagekit.io/docs/webhooks).
     *
     * You can create up to 3 webhooks per account.
     */
    fun create(params: WebhookCreateParams): Webhook = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: WebhookCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Webhook

    /**
     * Updates the webhook identified by `id` and returns the updated object. Only the fields
     * included in the request body are changed.
     *
     * When `events` is provided, it replaces the existing list of subscribed events. The signing
     * `secret` can't be changed.
     */
    fun update(id: String): Webhook = update(id, WebhookUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Webhook = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(id: String, params: WebhookUpdateParams = WebhookUpdateParams.none()): Webhook =
        update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: WebhookUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Webhook

    /** @see update */
    fun update(params: WebhookUpdateParams): Webhook = update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): Webhook =
        update(id, WebhookUpdateParams.none(), requestOptions)

    /** Returns an array of all webhooks configured for your account. */
    fun list(): List<Webhook> = list(WebhookListParams.none())

    /** @see list */
    fun list(
        params: WebhookListParams = WebhookListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Webhook>

    /** @see list */
    fun list(params: WebhookListParams = WebhookListParams.none()): List<Webhook> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): List<Webhook> =
        list(WebhookListParams.none(), requestOptions)

    /**
     * Permanently deletes the webhook identified by `id`. ImageKit stops sending events to its
     * endpoint.
     */
    fun delete(id: String) = delete(id, WebhookDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: WebhookDeleteParams = WebhookDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(id: String, params: WebhookDeleteParams = WebhookDeleteParams.none()) =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: WebhookDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: WebhookDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions) =
        delete(id, WebhookDeleteParams.none(), requestOptions)

    /** Retrieves the webhook identified by `id`. */
    fun get(id: String): Webhook = get(id, WebhookGetParams.none())

    /** @see get */
    fun get(
        id: String,
        params: WebhookGetParams = WebhookGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Webhook = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see get */
    fun get(id: String, params: WebhookGetParams = WebhookGetParams.none()): Webhook =
        get(id, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: WebhookGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Webhook

    /** @see get */
    fun get(params: WebhookGetParams): Webhook = get(params, RequestOptions.none())

    /** @see get */
    fun get(id: String, requestOptions: RequestOptions): Webhook =
        get(id, WebhookGetParams.none(), requestOptions)

    /** A view of [WebhookService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/accounts/webhooks`, but is otherwise the same
         * as [WebhookService.create].
         */
        @MustBeClosed
        fun create(params: WebhookCreateParams): HttpResponseFor<Webhook> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: WebhookCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Webhook>

        /**
         * Returns a raw HTTP response for `patch /v1/accounts/webhooks/{id}`, but is otherwise the
         * same as [WebhookService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<Webhook> = update(id, WebhookUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Webhook> = update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
        ): HttpResponseFor<Webhook> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: WebhookUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Webhook>

        /** @see update */
        @MustBeClosed
        fun update(params: WebhookUpdateParams): HttpResponseFor<Webhook> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(id: String, requestOptions: RequestOptions): HttpResponseFor<Webhook> =
            update(id, WebhookUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/accounts/webhooks`, but is otherwise the same as
         * [WebhookService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<List<Webhook>> = list(WebhookListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: WebhookListParams = WebhookListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Webhook>>

        /** @see list */
        @MustBeClosed
        fun list(
            params: WebhookListParams = WebhookListParams.none()
        ): HttpResponseFor<List<Webhook>> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<List<Webhook>> =
            list(WebhookListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/accounts/webhooks/{id}`, but is otherwise the
         * same as [WebhookService.delete].
         */
        @MustBeClosed fun delete(id: String): HttpResponse = delete(id, WebhookDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
        ): HttpResponse = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: WebhookDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: WebhookDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(id: String, requestOptions: RequestOptions): HttpResponse =
            delete(id, WebhookDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/accounts/webhooks/{id}`, but is otherwise the
         * same as [WebhookService.get].
         */
        @MustBeClosed
        fun get(id: String): HttpResponseFor<Webhook> = get(id, WebhookGetParams.none())

        /** @see get */
        @MustBeClosed
        fun get(
            id: String,
            params: WebhookGetParams = WebhookGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Webhook> = get(params.toBuilder().id(id).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(
            id: String,
            params: WebhookGetParams = WebhookGetParams.none(),
        ): HttpResponseFor<Webhook> = get(id, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: WebhookGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Webhook>

        /** @see get */
        @MustBeClosed
        fun get(params: WebhookGetParams): HttpResponseFor<Webhook> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(id: String, requestOptions: RequestOptions): HttpResponseFor<Webhook> =
            get(id, WebhookGetParams.none(), requestOptions)
    }
}
