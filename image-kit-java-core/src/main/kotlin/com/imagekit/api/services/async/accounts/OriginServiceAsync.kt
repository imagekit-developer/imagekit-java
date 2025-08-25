// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.accounts

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponse
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.accounts.origins.Origin
import com.imagekit.api.models.accounts.origins.OriginCreateParams
import com.imagekit.api.models.accounts.origins.OriginDeleteParams
import com.imagekit.api.models.accounts.origins.OriginGetParams
import com.imagekit.api.models.accounts.origins.OriginListParams
import com.imagekit.api.models.accounts.origins.OriginUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface OriginServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OriginServiceAsync

    /**
     * **Note:** This API is currently in beta. Creates a new origin and returns the origin object.
     */
    fun create(params: OriginCreateParams): CompletableFuture<Origin> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: OriginCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Origin>

    /**
     * **Note:** This API is currently in beta. Updates the origin identified by `id` and returns
     * the updated origin object.
     */
    fun update(id: String, params: OriginUpdateParams): CompletableFuture<Origin> =
        update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        params: OriginUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Origin> = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(params: OriginUpdateParams): CompletableFuture<Origin> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: OriginUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Origin>

    /**
     * **Note:** This API is currently in beta. Returns an array of all configured origins for the
     * current account.
     */
    fun list(): CompletableFuture<List<Origin>> = list(OriginListParams.none())

    /** @see list */
    fun list(
        params: OriginListParams = OriginListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Origin>>

    /** @see list */
    fun list(params: OriginListParams = OriginListParams.none()): CompletableFuture<List<Origin>> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<Origin>> =
        list(OriginListParams.none(), requestOptions)

    /**
     * **Note:** This API is currently in beta. Permanently removes the origin identified by `id`.
     * If the origin is in use by any URL‑endpoints, the API will return an error.
     */
    fun delete(id: String): CompletableFuture<Void?> = delete(id, OriginDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: OriginDeleteParams = OriginDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: OriginDeleteParams = OriginDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: OriginDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: OriginDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(id, OriginDeleteParams.none(), requestOptions)

    /** **Note:** This API is currently in beta. Retrieves the origin identified by `id`. */
    fun get(id: String): CompletableFuture<Origin> = get(id, OriginGetParams.none())

    /** @see get */
    fun get(
        id: String,
        params: OriginGetParams = OriginGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Origin> = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see get */
    fun get(
        id: String,
        params: OriginGetParams = OriginGetParams.none(),
    ): CompletableFuture<Origin> = get(id, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: OriginGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Origin>

    /** @see get */
    fun get(params: OriginGetParams): CompletableFuture<Origin> = get(params, RequestOptions.none())

    /** @see get */
    fun get(id: String, requestOptions: RequestOptions): CompletableFuture<Origin> =
        get(id, OriginGetParams.none(), requestOptions)

    /**
     * A view of [OriginServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OriginServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/accounts/origins`, but is otherwise the same as
         * [OriginServiceAsync.create].
         */
        fun create(params: OriginCreateParams): CompletableFuture<HttpResponseFor<Origin>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: OriginCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Origin>>

        /**
         * Returns a raw HTTP response for `put /v1/accounts/origins/{id}`, but is otherwise the
         * same as [OriginServiceAsync.update].
         */
        fun update(
            id: String,
            params: OriginUpdateParams,
        ): CompletableFuture<HttpResponseFor<Origin>> = update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            params: OriginUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Origin>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(params: OriginUpdateParams): CompletableFuture<HttpResponseFor<Origin>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: OriginUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Origin>>

        /**
         * Returns a raw HTTP response for `get /v1/accounts/origins`, but is otherwise the same as
         * [OriginServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<Origin>>> = list(OriginListParams.none())

        /** @see list */
        fun list(
            params: OriginListParams = OriginListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Origin>>>

        /** @see list */
        fun list(
            params: OriginListParams = OriginListParams.none()
        ): CompletableFuture<HttpResponseFor<List<Origin>>> = list(params, RequestOptions.none())

        /** @see list */
        fun list(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Origin>>> =
            list(OriginListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/accounts/origins/{id}`, but is otherwise the
         * same as [OriginServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponse> =
            delete(id, OriginDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: OriginDeleteParams = OriginDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: OriginDeleteParams = OriginDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: OriginDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: OriginDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(id, OriginDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/accounts/origins/{id}`, but is otherwise the
         * same as [OriginServiceAsync.get].
         */
        fun get(id: String): CompletableFuture<HttpResponseFor<Origin>> =
            get(id, OriginGetParams.none())

        /** @see get */
        fun get(
            id: String,
            params: OriginGetParams = OriginGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Origin>> =
            get(params.toBuilder().id(id).build(), requestOptions)

        /** @see get */
        fun get(
            id: String,
            params: OriginGetParams = OriginGetParams.none(),
        ): CompletableFuture<HttpResponseFor<Origin>> = get(id, params, RequestOptions.none())

        /** @see get */
        fun get(
            params: OriginGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Origin>>

        /** @see get */
        fun get(params: OriginGetParams): CompletableFuture<HttpResponseFor<Origin>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Origin>> =
            get(id, OriginGetParams.none(), requestOptions)
    }
}
