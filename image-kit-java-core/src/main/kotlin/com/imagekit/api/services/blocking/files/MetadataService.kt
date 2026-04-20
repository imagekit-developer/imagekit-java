// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

import com.google.errorprone.annotations.MustBeClosed
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.files.Metadata
import com.imagekit.api.models.files.metadata.MetadataGetFromUrlParams
import com.imagekit.api.models.files.metadata.MetadataGetParams
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
    fun get(fileId: String): Metadata = get(fileId, MetadataGetParams.none())

    /** @see get */
    fun get(
        fileId: String,
        params: MetadataGetParams = MetadataGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Metadata = get(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see get */
    fun get(fileId: String, params: MetadataGetParams = MetadataGetParams.none()): Metadata =
        get(fileId, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: MetadataGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Metadata

    /** @see get */
    fun get(params: MetadataGetParams): Metadata = get(params, RequestOptions.none())

    /** @see get */
    fun get(fileId: String, requestOptions: RequestOptions): Metadata =
        get(fileId, MetadataGetParams.none(), requestOptions)

    /**
     * Get image EXIF, pHash, and other metadata from ImageKit.io powered remote URL using this API.
     */
    fun getFromUrl(params: MetadataGetFromUrlParams): Metadata =
        getFromUrl(params, RequestOptions.none())

    /** @see getFromUrl */
    fun getFromUrl(
        params: MetadataGetFromUrlParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Metadata

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
        fun get(fileId: String): HttpResponseFor<Metadata> = get(fileId, MetadataGetParams.none())

        /** @see get */
        @MustBeClosed
        fun get(
            fileId: String,
            params: MetadataGetParams = MetadataGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Metadata> =
            get(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(
            fileId: String,
            params: MetadataGetParams = MetadataGetParams.none(),
        ): HttpResponseFor<Metadata> = get(fileId, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: MetadataGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Metadata>

        /** @see get */
        @MustBeClosed
        fun get(params: MetadataGetParams): HttpResponseFor<Metadata> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(fileId: String, requestOptions: RequestOptions): HttpResponseFor<Metadata> =
            get(fileId, MetadataGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/metadata`, but is otherwise the same as
         * [MetadataService.getFromUrl].
         */
        @MustBeClosed
        fun getFromUrl(params: MetadataGetFromUrlParams): HttpResponseFor<Metadata> =
            getFromUrl(params, RequestOptions.none())

        /** @see getFromUrl */
        @MustBeClosed
        fun getFromUrl(
            params: MetadataGetFromUrlParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Metadata>
    }
}
