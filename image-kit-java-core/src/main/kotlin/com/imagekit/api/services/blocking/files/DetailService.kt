// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

import com.google.errorprone.annotations.MustBeClosed
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.files.details.DetailRetrieveParams
import com.imagekit.api.models.files.details.DetailRetrieveResponse
import com.imagekit.api.models.files.details.DetailUpdateParams
import com.imagekit.api.models.files.details.DetailUpdateResponse
import java.util.function.Consumer

interface DetailService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DetailService

    /**
     * This API returns an object with details or attributes about the current version of the file.
     */
    fun retrieve(fileId: String): DetailRetrieveResponse =
        retrieve(fileId, DetailRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        params: DetailRetrieveParams = DetailRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DetailRetrieveResponse = retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        params: DetailRetrieveParams = DetailRetrieveParams.none(),
    ): DetailRetrieveResponse = retrieve(fileId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: DetailRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DetailRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: DetailRetrieveParams): DetailRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(fileId: String, requestOptions: RequestOptions): DetailRetrieveResponse =
        retrieve(fileId, DetailRetrieveParams.none(), requestOptions)

    /**
     * This API updates the details or attributes of the current version of the file. You can update
     * `tags`, `customCoordinates`, `customMetadata`, publication status, remove existing `AITags`
     * and apply extensions using this API.
     */
    fun update(fileId: String): DetailUpdateResponse = update(fileId, DetailUpdateParams.none())

    /** @see update */
    fun update(
        fileId: String,
        params: DetailUpdateParams = DetailUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DetailUpdateResponse = update(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see update */
    fun update(
        fileId: String,
        params: DetailUpdateParams = DetailUpdateParams.none(),
    ): DetailUpdateResponse = update(fileId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: DetailUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DetailUpdateResponse

    /** @see update */
    fun update(params: DetailUpdateParams): DetailUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(fileId: String, requestOptions: RequestOptions): DetailUpdateResponse =
        update(fileId, DetailUpdateParams.none(), requestOptions)

    /** A view of [DetailService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): DetailService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/files/{fileId}/details`, but is otherwise the
         * same as [DetailService.retrieve].
         */
        @MustBeClosed
        fun retrieve(fileId: String): HttpResponseFor<DetailRetrieveResponse> =
            retrieve(fileId, DetailRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: DetailRetrieveParams = DetailRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DetailRetrieveResponse> =
            retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: DetailRetrieveParams = DetailRetrieveParams.none(),
        ): HttpResponseFor<DetailRetrieveResponse> = retrieve(fileId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: DetailRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DetailRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: DetailRetrieveParams): HttpResponseFor<DetailRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DetailRetrieveResponse> =
            retrieve(fileId, DetailRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/files/{fileId}/details`, but is otherwise the
         * same as [DetailService.update].
         */
        @MustBeClosed
        fun update(fileId: String): HttpResponseFor<DetailUpdateResponse> =
            update(fileId, DetailUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            fileId: String,
            params: DetailUpdateParams = DetailUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DetailUpdateResponse> =
            update(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            fileId: String,
            params: DetailUpdateParams = DetailUpdateParams.none(),
        ): HttpResponseFor<DetailUpdateResponse> = update(fileId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: DetailUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DetailUpdateResponse>

        /** @see update */
        @MustBeClosed
        fun update(params: DetailUpdateParams): HttpResponseFor<DetailUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            fileId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DetailUpdateResponse> =
            update(fileId, DetailUpdateParams.none(), requestOptions)
    }
}
