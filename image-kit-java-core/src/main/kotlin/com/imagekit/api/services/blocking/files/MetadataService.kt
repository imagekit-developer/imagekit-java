// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

import com.google.errorprone.annotations.MustBeClosed
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.files.metadata.MetadataGetFromUrlParams
import com.imagekit.api.models.files.metadata.MetadataGetFromUrlResponse
import com.imagekit.api.models.files.metadata.MetadataGetParams
import com.imagekit.api.models.files.metadata.MetadataGetResponse
import java.util.function.Consumer

interface MetadataService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MetadataService

    /**
     * You can programmatically get image EXIF, pHash, and other metadata for uploaded files in the
     * ImageKit.io media library using this API.
     *
     * You can also get the metadata in upload API response by passing `metadata` in
     * `responseFields` parameter.
     */
    fun get(fileId: String): MetadataGetResponse = get(fileId, MetadataGetParams.none())

    /** @see get */
    fun get(
        fileId: String,
        params: MetadataGetParams = MetadataGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MetadataGetResponse = get(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see get */
    fun get(
        fileId: String,
        params: MetadataGetParams = MetadataGetParams.none(),
    ): MetadataGetResponse = get(fileId, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: MetadataGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MetadataGetResponse

    /** @see get */
    fun get(params: MetadataGetParams): MetadataGetResponse = get(params, RequestOptions.none())

    /** @see get */
    fun get(fileId: String, requestOptions: RequestOptions): MetadataGetResponse =
        get(fileId, MetadataGetParams.none(), requestOptions)

    /**
     * Get image EXIF, pHash, and other metadata from ImageKit.io powered remote URL using this API.
     */
    fun getFromUrl(params: MetadataGetFromUrlParams): MetadataGetFromUrlResponse =
        getFromUrl(params, RequestOptions.none())

    /** @see getFromUrl */
    fun getFromUrl(
        params: MetadataGetFromUrlParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MetadataGetFromUrlResponse

    /** A view of [MetadataService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MetadataService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/files/{fileId}/metadata`, but is otherwise the
         * same as [MetadataService.get].
         */
        @MustBeClosed
        fun get(fileId: String): HttpResponseFor<MetadataGetResponse> =
            get(fileId, MetadataGetParams.none())

        /** @see get */
        @MustBeClosed
        fun get(
            fileId: String,
            params: MetadataGetParams = MetadataGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MetadataGetResponse> =
            get(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(
            fileId: String,
            params: MetadataGetParams = MetadataGetParams.none(),
        ): HttpResponseFor<MetadataGetResponse> = get(fileId, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: MetadataGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MetadataGetResponse>

        /** @see get */
        @MustBeClosed
        fun get(params: MetadataGetParams): HttpResponseFor<MetadataGetResponse> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            fileId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MetadataGetResponse> =
            get(fileId, MetadataGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/files/metadata`, but is otherwise the same as
         * [MetadataService.getFromUrl].
         */
        @MustBeClosed
        fun getFromUrl(
            params: MetadataGetFromUrlParams
        ): HttpResponseFor<MetadataGetFromUrlResponse> = getFromUrl(params, RequestOptions.none())

        /** @see getFromUrl */
        @MustBeClosed
        fun getFromUrl(
            params: MetadataGetFromUrlParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MetadataGetFromUrlResponse>
    }
}
