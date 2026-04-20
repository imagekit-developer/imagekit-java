// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.blocking.files

import com.google.errorprone.annotations.MustBeClosed
import io.imagekit.io.core.ClientOptions
import io.imagekit.io.core.RequestOptions
import io.imagekit.io.core.http.HttpResponseFor
import io.imagekit.io.models.files.bulk.BulkAddTagsParams
import io.imagekit.io.models.files.bulk.BulkAddTagsResponse
import io.imagekit.io.models.files.bulk.BulkDeleteParams
import io.imagekit.io.models.files.bulk.BulkDeleteResponse
import io.imagekit.io.models.files.bulk.BulkRemoveAiTagsParams
import io.imagekit.io.models.files.bulk.BulkRemoveAiTagsResponse
import io.imagekit.io.models.files.bulk.BulkRemoveTagsParams
import io.imagekit.io.models.files.bulk.BulkRemoveTagsResponse
import java.util.function.Consumer

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkService

    /**
     * This API deletes multiple files and all their file versions permanently.
     *
     * Note: If a file or specific transformation has been requested in the past, then the response
     * is cached. Deleting a file does not purge the cache. You can purge the cache using purge
     * cache API.
     *
     * A maximum of 100 files can be deleted at a time.
     */
    fun delete(params: BulkDeleteParams): BulkDeleteResponse = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkDeleteResponse

    /**
     * This API adds tags to multiple files in bulk. A maximum of 50 files can be specified at a
     * time.
     */
    fun addTags(params: BulkAddTagsParams): BulkAddTagsResponse =
        addTags(params, RequestOptions.none())

    /** @see addTags */
    fun addTags(
        params: BulkAddTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkAddTagsResponse

    /**
     * This API removes AITags from multiple files in bulk. A maximum of 50 files can be specified
     * at a time.
     */
    fun removeAiTags(params: BulkRemoveAiTagsParams): BulkRemoveAiTagsResponse =
        removeAiTags(params, RequestOptions.none())

    /** @see removeAiTags */
    fun removeAiTags(
        params: BulkRemoveAiTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkRemoveAiTagsResponse

    /**
     * This API removes tags from multiple files in bulk. A maximum of 50 files can be specified at
     * a time.
     */
    fun removeTags(params: BulkRemoveTagsParams): BulkRemoveTagsResponse =
        removeTags(params, RequestOptions.none())

    /** @see removeTags */
    fun removeTags(
        params: BulkRemoveTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkRemoveTagsResponse

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/files/batch/deleteByFileIds`, but is otherwise
         * the same as [BulkService.delete].
         */
        @MustBeClosed
        fun delete(params: BulkDeleteParams): HttpResponseFor<BulkDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: BulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkDeleteResponse>

        /**
         * Returns a raw HTTP response for `post /v1/files/addTags`, but is otherwise the same as
         * [BulkService.addTags].
         */
        @MustBeClosed
        fun addTags(params: BulkAddTagsParams): HttpResponseFor<BulkAddTagsResponse> =
            addTags(params, RequestOptions.none())

        /** @see addTags */
        @MustBeClosed
        fun addTags(
            params: BulkAddTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkAddTagsResponse>

        /**
         * Returns a raw HTTP response for `post /v1/files/removeAITags`, but is otherwise the same
         * as [BulkService.removeAiTags].
         */
        @MustBeClosed
        fun removeAiTags(
            params: BulkRemoveAiTagsParams
        ): HttpResponseFor<BulkRemoveAiTagsResponse> = removeAiTags(params, RequestOptions.none())

        /** @see removeAiTags */
        @MustBeClosed
        fun removeAiTags(
            params: BulkRemoveAiTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkRemoveAiTagsResponse>

        /**
         * Returns a raw HTTP response for `post /v1/files/removeTags`, but is otherwise the same as
         * [BulkService.removeTags].
         */
        @MustBeClosed
        fun removeTags(params: BulkRemoveTagsParams): HttpResponseFor<BulkRemoveTagsResponse> =
            removeTags(params, RequestOptions.none())

        /** @see removeTags */
        @MustBeClosed
        fun removeTags(
            params: BulkRemoveTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkRemoveTagsResponse>
    }
}
