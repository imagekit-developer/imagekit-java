// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.files

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.files.bulk.BulkAddTagsParams
import io.imagekit.models.files.bulk.BulkAddTagsResponse
import io.imagekit.models.files.bulk.BulkDeleteParams
import io.imagekit.models.files.bulk.BulkDeleteResponse
import io.imagekit.models.files.bulk.BulkRemoveAiTagsParams
import io.imagekit.models.files.bulk.BulkRemoveAiTagsResponse
import io.imagekit.models.files.bulk.BulkRemoveTagsParams
import io.imagekit.models.files.bulk.BulkRemoveTagsResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkServiceAsync

    /**
     * This API deletes multiple files and all their file versions permanently.
     *
     * Note: If a file or specific transformation has been requested in the past, then the response
     * is cached. Deleting a file does not purge the cache. You can purge the cache using purge
     * cache API.
     *
     * A maximum of 100 files can be deleted at a time.
     */
    fun delete(params: BulkDeleteParams): CompletableFuture<BulkDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkDeleteResponse>

    /**
     * This API adds tags to multiple files in bulk. A maximum of 50 files can be specified at a
     * time.
     */
    fun addTags(params: BulkAddTagsParams): CompletableFuture<BulkAddTagsResponse> =
        addTags(params, RequestOptions.none())

    /** @see addTags */
    fun addTags(
        params: BulkAddTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkAddTagsResponse>

    /**
     * This API removes AITags from multiple files in bulk. A maximum of 50 files can be specified
     * at a time.
     */
    fun removeAiTags(params: BulkRemoveAiTagsParams): CompletableFuture<BulkRemoveAiTagsResponse> =
        removeAiTags(params, RequestOptions.none())

    /** @see removeAiTags */
    fun removeAiTags(
        params: BulkRemoveAiTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkRemoveAiTagsResponse>

    /**
     * This API removes tags from multiple files in bulk. A maximum of 50 files can be specified at
     * a time.
     */
    fun removeTags(params: BulkRemoveTagsParams): CompletableFuture<BulkRemoveTagsResponse> =
        removeTags(params, RequestOptions.none())

    /** @see removeTags */
    fun removeTags(
        params: BulkRemoveTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkRemoveTagsResponse>

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/files/batch/deleteByFileIds`, but is otherwise
         * the same as [BulkServiceAsync.delete].
         */
        fun delete(
            params: BulkDeleteParams
        ): CompletableFuture<HttpResponseFor<BulkDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: BulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkDeleteResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/files/addTags`, but is otherwise the same as
         * [BulkServiceAsync.addTags].
         */
        fun addTags(
            params: BulkAddTagsParams
        ): CompletableFuture<HttpResponseFor<BulkAddTagsResponse>> =
            addTags(params, RequestOptions.none())

        /** @see addTags */
        fun addTags(
            params: BulkAddTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkAddTagsResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/files/removeAITags`, but is otherwise the same
         * as [BulkServiceAsync.removeAiTags].
         */
        fun removeAiTags(
            params: BulkRemoveAiTagsParams
        ): CompletableFuture<HttpResponseFor<BulkRemoveAiTagsResponse>> =
            removeAiTags(params, RequestOptions.none())

        /** @see removeAiTags */
        fun removeAiTags(
            params: BulkRemoveAiTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkRemoveAiTagsResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/files/removeTags`, but is otherwise the same as
         * [BulkServiceAsync.removeTags].
         */
        fun removeTags(
            params: BulkRemoveTagsParams
        ): CompletableFuture<HttpResponseFor<BulkRemoveTagsResponse>> =
            removeTags(params, RequestOptions.none())

        /** @see removeTags */
        fun removeTags(
            params: BulkRemoveTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkRemoveTagsResponse>>
    }
}
