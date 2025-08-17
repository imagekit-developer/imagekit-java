// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.files

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.files.metadata.MetadataGetFromUrlParams
import com.imagekit.api.models.files.metadata.MetadataGetFromUrlResponse
import com.imagekit.api.models.files.metadata.MetadataGetParams
import com.imagekit.api.models.files.metadata.MetadataGetResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface MetadataServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MetadataServiceAsync

    /**
     * You can programmatically get image EXIF, pHash, and other metadata for uploaded files in the
     * ImageKit.io media library using this API.
     *
     * You can also get the metadata in upload API response by passing `metadata` in
     * `responseFields` parameter.
     */
    fun get(fileId: String): CompletableFuture<MetadataGetResponse> =
        get(fileId, MetadataGetParams.none())

    /** @see get */
    fun get(
        fileId: String,
        params: MetadataGetParams = MetadataGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MetadataGetResponse> =
        get(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see get */
    fun get(
        fileId: String,
        params: MetadataGetParams = MetadataGetParams.none(),
    ): CompletableFuture<MetadataGetResponse> = get(fileId, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: MetadataGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MetadataGetResponse>

    /** @see get */
    fun get(params: MetadataGetParams): CompletableFuture<MetadataGetResponse> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(
        fileId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MetadataGetResponse> =
        get(fileId, MetadataGetParams.none(), requestOptions)

    /**
     * Get image EXIF, pHash, and other metadata from ImageKit.io powered remote URL using this API.
     */
    fun getFromUrl(
        params: MetadataGetFromUrlParams
    ): CompletableFuture<MetadataGetFromUrlResponse> = getFromUrl(params, RequestOptions.none())

    /** @see getFromUrl */
    fun getFromUrl(
        params: MetadataGetFromUrlParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MetadataGetFromUrlResponse>

    /**
     * A view of [MetadataServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MetadataServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/files/{fileId}/metadata`, but is otherwise the
         * same as [MetadataServiceAsync.get].
         */
        fun get(fileId: String): CompletableFuture<HttpResponseFor<MetadataGetResponse>> =
            get(fileId, MetadataGetParams.none())

        /** @see get */
        fun get(
            fileId: String,
            params: MetadataGetParams = MetadataGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MetadataGetResponse>> =
            get(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see get */
        fun get(
            fileId: String,
            params: MetadataGetParams = MetadataGetParams.none(),
        ): CompletableFuture<HttpResponseFor<MetadataGetResponse>> =
            get(fileId, params, RequestOptions.none())

        /** @see get */
        fun get(
            params: MetadataGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MetadataGetResponse>>

        /** @see get */
        fun get(
            params: MetadataGetParams
        ): CompletableFuture<HttpResponseFor<MetadataGetResponse>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            fileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MetadataGetResponse>> =
            get(fileId, MetadataGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/files/metadata`, but is otherwise the same as
         * [MetadataServiceAsync.getFromUrl].
         */
        fun getFromUrl(
            params: MetadataGetFromUrlParams
        ): CompletableFuture<HttpResponseFor<MetadataGetFromUrlResponse>> =
            getFromUrl(params, RequestOptions.none())

        /** @see getFromUrl */
        fun getFromUrl(
            params: MetadataGetFromUrlParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MetadataGetFromUrlResponse>>
    }
}
