// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.files

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.files.Metadata
import io.imagekit.models.files.metadata.MetadataGetFromUrlParams
import io.imagekit.models.files.metadata.MetadataGetParams
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
    fun get(fileId: String): CompletableFuture<Metadata> = get(fileId, MetadataGetParams.none())

    /** @see get */
    fun get(
        fileId: String,
        params: MetadataGetParams = MetadataGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Metadata> = get(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see get */
    fun get(
        fileId: String,
        params: MetadataGetParams = MetadataGetParams.none(),
    ): CompletableFuture<Metadata> = get(fileId, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: MetadataGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Metadata>

    /** @see get */
    fun get(params: MetadataGetParams): CompletableFuture<Metadata> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(fileId: String, requestOptions: RequestOptions): CompletableFuture<Metadata> =
        get(fileId, MetadataGetParams.none(), requestOptions)

    /**
     * Get image EXIF, pHash, and other metadata from ImageKit.io powered remote URL using this API.
     */
    fun getFromUrl(params: MetadataGetFromUrlParams): CompletableFuture<Metadata> =
        getFromUrl(params, RequestOptions.none())

    /** @see getFromUrl */
    fun getFromUrl(
        params: MetadataGetFromUrlParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Metadata>

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
        fun get(fileId: String): CompletableFuture<HttpResponseFor<Metadata>> =
            get(fileId, MetadataGetParams.none())

        /** @see get */
        fun get(
            fileId: String,
            params: MetadataGetParams = MetadataGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Metadata>> =
            get(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see get */
        fun get(
            fileId: String,
            params: MetadataGetParams = MetadataGetParams.none(),
        ): CompletableFuture<HttpResponseFor<Metadata>> = get(fileId, params, RequestOptions.none())

        /** @see get */
        fun get(
            params: MetadataGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Metadata>>

        /** @see get */
        fun get(params: MetadataGetParams): CompletableFuture<HttpResponseFor<Metadata>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            fileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Metadata>> =
            get(fileId, MetadataGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/metadata`, but is otherwise the same as
         * [MetadataServiceAsync.getFromUrl].
         */
        fun getFromUrl(
            params: MetadataGetFromUrlParams
        ): CompletableFuture<HttpResponseFor<Metadata>> = getFromUrl(params, RequestOptions.none())

        /** @see getFromUrl */
        fun getFromUrl(
            params: MetadataGetFromUrlParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Metadata>>
    }
}
