// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.async.cache

import io.imagekit.io.core.ClientOptions
import io.imagekit.io.core.RequestOptions
import io.imagekit.io.core.http.HttpResponseFor
import io.imagekit.io.models.cache.invalidation.InvalidationCreateParams
import io.imagekit.io.models.cache.invalidation.InvalidationCreateResponse
import io.imagekit.io.models.cache.invalidation.InvalidationGetParams
import io.imagekit.io.models.cache.invalidation.InvalidationGetResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface InvalidationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvalidationServiceAsync

    /**
     * This API will purge CDN cache and ImageKit.io's internal cache for a file. Note: Purge cache
     * is an asynchronous process and it may take some time to reflect the changes.
     */
    fun create(params: InvalidationCreateParams): CompletableFuture<InvalidationCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InvalidationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvalidationCreateResponse>

    /** This API returns the status of a purge cache request. */
    fun get(requestId: String): CompletableFuture<InvalidationGetResponse> =
        get(requestId, InvalidationGetParams.none())

    /** @see get */
    fun get(
        requestId: String,
        params: InvalidationGetParams = InvalidationGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvalidationGetResponse> =
        get(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see get */
    fun get(
        requestId: String,
        params: InvalidationGetParams = InvalidationGetParams.none(),
    ): CompletableFuture<InvalidationGetResponse> = get(requestId, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: InvalidationGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvalidationGetResponse>

    /** @see get */
    fun get(params: InvalidationGetParams): CompletableFuture<InvalidationGetResponse> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(
        requestId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InvalidationGetResponse> =
        get(requestId, InvalidationGetParams.none(), requestOptions)

    /**
     * A view of [InvalidationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InvalidationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/files/purge`, but is otherwise the same as
         * [InvalidationServiceAsync.create].
         */
        fun create(
            params: InvalidationCreateParams
        ): CompletableFuture<HttpResponseFor<InvalidationCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: InvalidationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvalidationCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/files/purge/{requestId}`, but is otherwise the
         * same as [InvalidationServiceAsync.get].
         */
        fun get(requestId: String): CompletableFuture<HttpResponseFor<InvalidationGetResponse>> =
            get(requestId, InvalidationGetParams.none())

        /** @see get */
        fun get(
            requestId: String,
            params: InvalidationGetParams = InvalidationGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvalidationGetResponse>> =
            get(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see get */
        fun get(
            requestId: String,
            params: InvalidationGetParams = InvalidationGetParams.none(),
        ): CompletableFuture<HttpResponseFor<InvalidationGetResponse>> =
            get(requestId, params, RequestOptions.none())

        /** @see get */
        fun get(
            params: InvalidationGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvalidationGetResponse>>

        /** @see get */
        fun get(
            params: InvalidationGetParams
        ): CompletableFuture<HttpResponseFor<InvalidationGetResponse>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            requestId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InvalidationGetResponse>> =
            get(requestId, InvalidationGetParams.none(), requestOptions)
    }
}
