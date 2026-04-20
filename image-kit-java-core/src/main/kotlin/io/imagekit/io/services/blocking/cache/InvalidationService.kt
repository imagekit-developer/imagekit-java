// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.blocking.cache

import com.google.errorprone.annotations.MustBeClosed
import io.imagekit.io.core.ClientOptions
import io.imagekit.io.core.RequestOptions
import io.imagekit.io.core.http.HttpResponseFor
import io.imagekit.io.models.cache.invalidation.InvalidationCreateParams
import io.imagekit.io.models.cache.invalidation.InvalidationCreateResponse
import io.imagekit.io.models.cache.invalidation.InvalidationGetParams
import io.imagekit.io.models.cache.invalidation.InvalidationGetResponse
import java.util.function.Consumer

interface InvalidationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvalidationService

    /**
     * This API will purge CDN cache and ImageKit.io's internal cache for a file. Note: Purge cache
     * is an asynchronous process and it may take some time to reflect the changes.
     */
    fun create(params: InvalidationCreateParams): InvalidationCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InvalidationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvalidationCreateResponse

    /** This API returns the status of a purge cache request. */
    fun get(requestId: String): InvalidationGetResponse =
        get(requestId, InvalidationGetParams.none())

    /** @see get */
    fun get(
        requestId: String,
        params: InvalidationGetParams = InvalidationGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvalidationGetResponse =
        get(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see get */
    fun get(
        requestId: String,
        params: InvalidationGetParams = InvalidationGetParams.none(),
    ): InvalidationGetResponse = get(requestId, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: InvalidationGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvalidationGetResponse

    /** @see get */
    fun get(params: InvalidationGetParams): InvalidationGetResponse =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(requestId: String, requestOptions: RequestOptions): InvalidationGetResponse =
        get(requestId, InvalidationGetParams.none(), requestOptions)

    /**
     * A view of [InvalidationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InvalidationService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/files/purge`, but is otherwise the same as
         * [InvalidationService.create].
         */
        @MustBeClosed
        fun create(params: InvalidationCreateParams): HttpResponseFor<InvalidationCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: InvalidationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvalidationCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/files/purge/{requestId}`, but is otherwise the
         * same as [InvalidationService.get].
         */
        @MustBeClosed
        fun get(requestId: String): HttpResponseFor<InvalidationGetResponse> =
            get(requestId, InvalidationGetParams.none())

        /** @see get */
        @MustBeClosed
        fun get(
            requestId: String,
            params: InvalidationGetParams = InvalidationGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvalidationGetResponse> =
            get(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(
            requestId: String,
            params: InvalidationGetParams = InvalidationGetParams.none(),
        ): HttpResponseFor<InvalidationGetResponse> = get(requestId, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: InvalidationGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvalidationGetResponse>

        /** @see get */
        @MustBeClosed
        fun get(params: InvalidationGetParams): HttpResponseFor<InvalidationGetResponse> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            requestId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvalidationGetResponse> =
            get(requestId, InvalidationGetParams.none(), requestOptions)
    }
}
