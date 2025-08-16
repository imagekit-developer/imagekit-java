// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

import com.google.errorprone.annotations.MustBeClosed
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.files.purge.PurgeExecuteParams
import com.imagekit.api.models.files.purge.PurgeExecuteResponse
import com.imagekit.api.models.files.purge.PurgeStatusParams
import com.imagekit.api.models.files.purge.PurgeStatusResponse
import java.util.function.Consumer

interface PurgeService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): PurgeService

    /**
     * This API will purge CDN cache and ImageKit.io's internal cache for a file. Note: Purge cache
     * is an asynchronous process and it may take some time to reflect the changes.
     */
    fun execute(params: PurgeExecuteParams): PurgeExecuteResponse =
        execute(params, RequestOptions.none())

    /** @see execute */
    fun execute(
        params: PurgeExecuteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PurgeExecuteResponse

    /** This API returns the status of a purge cache request. */
    fun status(requestId: String): PurgeStatusResponse = status(requestId, PurgeStatusParams.none())

    /** @see status */
    fun status(
        requestId: String,
        params: PurgeStatusParams = PurgeStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PurgeStatusResponse = status(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see status */
    fun status(
        requestId: String,
        params: PurgeStatusParams = PurgeStatusParams.none(),
    ): PurgeStatusResponse = status(requestId, params, RequestOptions.none())

    /** @see status */
    fun status(
        params: PurgeStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PurgeStatusResponse

    /** @see status */
    fun status(params: PurgeStatusParams): PurgeStatusResponse =
        status(params, RequestOptions.none())

    /** @see status */
    fun status(requestId: String, requestOptions: RequestOptions): PurgeStatusResponse =
        status(requestId, PurgeStatusParams.none(), requestOptions)

    /** A view of [PurgeService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): PurgeService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/files/purge`, but is otherwise the same as
         * [PurgeService.execute].
         */
        @MustBeClosed
        fun execute(params: PurgeExecuteParams): HttpResponseFor<PurgeExecuteResponse> =
            execute(params, RequestOptions.none())

        /** @see execute */
        @MustBeClosed
        fun execute(
            params: PurgeExecuteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PurgeExecuteResponse>

        /**
         * Returns a raw HTTP response for `get /v1/files/purge/{requestId}`, but is otherwise the
         * same as [PurgeService.status].
         */
        @MustBeClosed
        fun status(requestId: String): HttpResponseFor<PurgeStatusResponse> =
            status(requestId, PurgeStatusParams.none())

        /** @see status */
        @MustBeClosed
        fun status(
            requestId: String,
            params: PurgeStatusParams = PurgeStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PurgeStatusResponse> =
            status(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see status */
        @MustBeClosed
        fun status(
            requestId: String,
            params: PurgeStatusParams = PurgeStatusParams.none(),
        ): HttpResponseFor<PurgeStatusResponse> = status(requestId, params, RequestOptions.none())

        /** @see status */
        @MustBeClosed
        fun status(
            params: PurgeStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PurgeStatusResponse>

        /** @see status */
        @MustBeClosed
        fun status(params: PurgeStatusParams): HttpResponseFor<PurgeStatusResponse> =
            status(params, RequestOptions.none())

        /** @see status */
        @MustBeClosed
        fun status(
            requestId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PurgeStatusResponse> =
            status(requestId, PurgeStatusParams.none(), requestOptions)
    }
}
