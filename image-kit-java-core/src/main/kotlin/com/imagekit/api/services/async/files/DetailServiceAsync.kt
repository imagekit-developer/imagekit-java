// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.files

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.files.details.DetailRetrieveParams
import com.imagekit.api.models.files.details.DetailRetrieveResponse
import com.imagekit.api.models.files.details.DetailUpdateParams
import com.imagekit.api.models.files.details.DetailUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface DetailServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DetailServiceAsync

    /**
     * This API returns an object with details or attributes about the current version of the file.
     */
    fun retrieve(fileId: String): CompletableFuture<DetailRetrieveResponse> =
        retrieve(fileId, DetailRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        params: DetailRetrieveParams = DetailRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DetailRetrieveResponse> =
        retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        params: DetailRetrieveParams = DetailRetrieveParams.none(),
    ): CompletableFuture<DetailRetrieveResponse> = retrieve(fileId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: DetailRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DetailRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: DetailRetrieveParams): CompletableFuture<DetailRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<DetailRetrieveResponse> =
        retrieve(fileId, DetailRetrieveParams.none(), requestOptions)

    /**
     * This API updates the details or attributes of the current version of the file. You can update
     * `tags`, `customCoordinates`, `customMetadata`, publication status, remove existing `AITags`
     * and apply extensions using this API.
     */
    fun update(fileId: String): CompletableFuture<DetailUpdateResponse> =
        update(fileId, DetailUpdateParams.none())

    /** @see update */
    fun update(
        fileId: String,
        params: DetailUpdateParams = DetailUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DetailUpdateResponse> =
        update(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see update */
    fun update(
        fileId: String,
        params: DetailUpdateParams = DetailUpdateParams.none(),
    ): CompletableFuture<DetailUpdateResponse> = update(fileId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: DetailUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DetailUpdateResponse>

    /** @see update */
    fun update(params: DetailUpdateParams): CompletableFuture<DetailUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        fileId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<DetailUpdateResponse> =
        update(fileId, DetailUpdateParams.none(), requestOptions)

    /**
     * A view of [DetailServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DetailServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/files/{fileId}/details`, but is otherwise the
         * same as [DetailServiceAsync.retrieve].
         */
        fun retrieve(fileId: String): CompletableFuture<HttpResponseFor<DetailRetrieveResponse>> =
            retrieve(fileId, DetailRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            fileId: String,
            params: DetailRetrieveParams = DetailRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DetailRetrieveResponse>> =
            retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            fileId: String,
            params: DetailRetrieveParams = DetailRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<DetailRetrieveResponse>> =
            retrieve(fileId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: DetailRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DetailRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: DetailRetrieveParams
        ): CompletableFuture<HttpResponseFor<DetailRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            fileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DetailRetrieveResponse>> =
            retrieve(fileId, DetailRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/files/{fileId}/details`, but is otherwise the
         * same as [DetailServiceAsync.update].
         */
        fun update(fileId: String): CompletableFuture<HttpResponseFor<DetailUpdateResponse>> =
            update(fileId, DetailUpdateParams.none())

        /** @see update */
        fun update(
            fileId: String,
            params: DetailUpdateParams = DetailUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DetailUpdateResponse>> =
            update(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see update */
        fun update(
            fileId: String,
            params: DetailUpdateParams = DetailUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<DetailUpdateResponse>> =
            update(fileId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: DetailUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DetailUpdateResponse>>

        /** @see update */
        fun update(
            params: DetailUpdateParams
        ): CompletableFuture<HttpResponseFor<DetailUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            fileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DetailUpdateResponse>> =
            update(fileId, DetailUpdateParams.none(), requestOptions)
    }
}
