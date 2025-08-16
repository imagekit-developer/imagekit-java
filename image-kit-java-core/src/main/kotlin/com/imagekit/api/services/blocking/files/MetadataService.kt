// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

import com.google.errorprone.annotations.MustBeClosed
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.files.metadata.MetadataFromUrlParams
import com.imagekit.api.models.files.metadata.MetadataFromUrlResponse
import com.imagekit.api.models.files.metadata.MetadataRetrieveParams
import com.imagekit.api.models.files.metadata.MetadataRetrieveResponse
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
    fun retrieve(fileId: String): MetadataRetrieveResponse =
        retrieve(fileId, MetadataRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        params: MetadataRetrieveParams = MetadataRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MetadataRetrieveResponse =
        retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        params: MetadataRetrieveParams = MetadataRetrieveParams.none(),
    ): MetadataRetrieveResponse = retrieve(fileId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: MetadataRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MetadataRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: MetadataRetrieveParams): MetadataRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(fileId: String, requestOptions: RequestOptions): MetadataRetrieveResponse =
        retrieve(fileId, MetadataRetrieveParams.none(), requestOptions)

    /**
     * Get image EXIF, pHash, and other metadata from ImageKit.io powered remote URL using this API.
     */
    fun fromUrl(params: MetadataFromUrlParams): MetadataFromUrlResponse =
        fromUrl(params, RequestOptions.none())

    /** @see fromUrl */
    fun fromUrl(
        params: MetadataFromUrlParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MetadataFromUrlResponse

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
         * same as [MetadataService.retrieve].
         */
        @MustBeClosed
        fun retrieve(fileId: String): HttpResponseFor<MetadataRetrieveResponse> =
            retrieve(fileId, MetadataRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: MetadataRetrieveParams = MetadataRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MetadataRetrieveResponse> =
            retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: MetadataRetrieveParams = MetadataRetrieveParams.none(),
        ): HttpResponseFor<MetadataRetrieveResponse> =
            retrieve(fileId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: MetadataRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MetadataRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: MetadataRetrieveParams): HttpResponseFor<MetadataRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MetadataRetrieveResponse> =
            retrieve(fileId, MetadataRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/files/metadata`, but is otherwise the same as
         * [MetadataService.fromUrl].
         */
        @MustBeClosed
        fun fromUrl(params: MetadataFromUrlParams): HttpResponseFor<MetadataFromUrlResponse> =
            fromUrl(params, RequestOptions.none())

        /** @see fromUrl */
        @MustBeClosed
        fun fromUrl(
            params: MetadataFromUrlParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MetadataFromUrlResponse>
    }
}
