// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.accounts

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
import java.util.concurrent.CompletableFuture
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
     * Creates a new webhook and returns the created object, including the generated signing
     * `secret`.
     *
     * ImageKit sends a `POST` request to the webhook `endpoint` whenever one of the subscribed
     * `events` occurs. Use the `secret` to verify the signature of each request. Learn more about
     * [webhooks](https://imagekit.io/docs/webhooks).
     *
     * You can create up to 3 webhooks per account.
     */
    fun create(params: WebhookCreateParams): CompletableFuture<Webhook> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: WebhookCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Webhook>

    /**
     * Updates the webhook identified by `id` and returns the updated object. Only the fields
     * included in the request body are changed.
     *
     * When `events` is provided, it replaces the existing list of subscribed events. The signing
     * `secret` can't be changed.
     */
    fun update(id: String): CompletableFuture<Webhook> = update(id, WebhookUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Webhook> = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
    ): CompletableFuture<Webhook> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: WebhookUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Webhook>

    /** @see update */
    fun update(params: WebhookUpdateParams): CompletableFuture<Webhook> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): CompletableFuture<Webhook> =
        update(id, WebhookUpdateParams.none(), requestOptions)

    /** Returns an array of all webhooks configured for your account. */
    fun list(): CompletableFuture<List<Webhook>> = list(WebhookListParams.none())

    /** @see list */
    fun list(
        params: WebhookListParams = WebhookListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Webhook>>

    /** @see list */
    fun list(
        params: WebhookListParams = WebhookListParams.none()
    ): CompletableFuture<List<Webhook>> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<Webhook>> =
        list(WebhookListParams.none(), requestOptions)

    /**
     * Permanently deletes the webhook identified by `id`. ImageKit stops sending events to its
     * endpoint.
     */
    fun delete(id: String): CompletableFuture<Void?> = delete(id, WebhookDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: WebhookDeleteParams = WebhookDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: WebhookDeleteParams = WebhookDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: WebhookDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: WebhookDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(id, WebhookDeleteParams.none(), requestOptions)

    /** Retrieves the webhook identified by `id`. */
    fun get(id: String): CompletableFuture<Webhook> = get(id, WebhookGetParams.none())

    /** @see get */
    fun get(
        id: String,
        params: WebhookGetParams = WebhookGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Webhook> = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see get */
    fun get(
        id: String,
        params: WebhookGetParams = WebhookGetParams.none(),
    ): CompletableFuture<Webhook> = get(id, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: WebhookGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Webhook>

    /** @see get */
    fun get(params: WebhookGetParams): CompletableFuture<Webhook> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(id: String, requestOptions: RequestOptions): CompletableFuture<Webhook> =
        get(id, WebhookGetParams.none(), requestOptions)

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

        /**
         * Returns a raw HTTP response for `post /v1/accounts/webhooks`, but is otherwise the same
         * as [WebhookServiceAsync.create].
         */
        fun create(params: WebhookCreateParams): CompletableFuture<HttpResponseFor<Webhook>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: WebhookCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Webhook>>

        /**
         * Returns a raw HTTP response for `patch /v1/accounts/webhooks/{id}`, but is otherwise the
         * same as [WebhookServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<Webhook>> =
            update(id, WebhookUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Webhook>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<Webhook>> = update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: WebhookUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Webhook>>

        /** @see update */
        fun update(params: WebhookUpdateParams): CompletableFuture<HttpResponseFor<Webhook>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Webhook>> =
            update(id, WebhookUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/accounts/webhooks`, but is otherwise the same as
         * [WebhookServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<Webhook>>> =
            list(WebhookListParams.none())

        /** @see list */
        fun list(
            params: WebhookListParams = WebhookListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Webhook>>>

        /** @see list */
        fun list(
            params: WebhookListParams = WebhookListParams.none()
        ): CompletableFuture<HttpResponseFor<List<Webhook>>> = list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Webhook>>> =
            list(WebhookListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/accounts/webhooks/{id}`, but is otherwise the
         * same as [WebhookServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponse> =
            delete(id, WebhookDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: WebhookDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: WebhookDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(id, WebhookDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/accounts/webhooks/{id}`, but is otherwise the
         * same as [WebhookServiceAsync.get].
         */
        fun get(id: String): CompletableFuture<HttpResponseFor<Webhook>> =
            get(id, WebhookGetParams.none())

        /** @see get */
        fun get(
            id: String,
            params: WebhookGetParams = WebhookGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Webhook>> =
            get(params.toBuilder().id(id).build(), requestOptions)

        /** @see get */
        fun get(
            id: String,
            params: WebhookGetParams = WebhookGetParams.none(),
        ): CompletableFuture<HttpResponseFor<Webhook>> = get(id, params, RequestOptions.none())

        /** @see get */
        fun get(
            params: WebhookGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Webhook>>

        /** @see get */
        fun get(params: WebhookGetParams): CompletableFuture<HttpResponseFor<Webhook>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Webhook>> =
            get(id, WebhookGetParams.none(), requestOptions)
    }
}
