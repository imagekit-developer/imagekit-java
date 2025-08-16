// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.bulkjobs.BulkJobCopyFolderParams
import com.imagekit.api.models.bulkjobs.BulkJobCopyFolderResponse
import com.imagekit.api.models.bulkjobs.BulkJobMoveFolderParams
import com.imagekit.api.models.bulkjobs.BulkJobMoveFolderResponse
import com.imagekit.api.models.bulkjobs.BulkJobRetrieveStatusParams
import com.imagekit.api.models.bulkjobs.BulkJobRetrieveStatusResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface BulkJobServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkJobServiceAsync

    /**
     * This will copy one folder into another. The selected folder, its nested folders, files, and
     * their versions (in `includeVersions` is set to true) are copied in this operation. Note: If
     * any file at the destination has the same name as the source file, then the source file and
     * its versions will be appended to the destination file version history.
     */
    fun copyFolder(params: BulkJobCopyFolderParams): CompletableFuture<BulkJobCopyFolderResponse> =
        copyFolder(params, RequestOptions.none())

    /** @see copyFolder */
    fun copyFolder(
        params: BulkJobCopyFolderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkJobCopyFolderResponse>

    /**
     * This will move one folder into another. The selected folder, its nested folders, files, and
     * their versions are moved in this operation. Note: If any file at the destination has the same
     * name as the source file, then the source file and its versions will be appended to the
     * destination file version history.
     */
    fun moveFolder(params: BulkJobMoveFolderParams): CompletableFuture<BulkJobMoveFolderResponse> =
        moveFolder(params, RequestOptions.none())

    /** @see moveFolder */
    fun moveFolder(
        params: BulkJobMoveFolderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkJobMoveFolderResponse>

    /** This API returns the status of a bulk job like copy and move folder operations. */
    fun retrieveStatus(jobId: String): CompletableFuture<BulkJobRetrieveStatusResponse> =
        retrieveStatus(jobId, BulkJobRetrieveStatusParams.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        jobId: String,
        params: BulkJobRetrieveStatusParams = BulkJobRetrieveStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkJobRetrieveStatusResponse> =
        retrieveStatus(params.toBuilder().jobId(jobId).build(), requestOptions)

    /** @see retrieveStatus */
    fun retrieveStatus(
        jobId: String,
        params: BulkJobRetrieveStatusParams = BulkJobRetrieveStatusParams.none(),
    ): CompletableFuture<BulkJobRetrieveStatusResponse> =
        retrieveStatus(jobId, params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: BulkJobRetrieveStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkJobRetrieveStatusResponse>

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: BulkJobRetrieveStatusParams
    ): CompletableFuture<BulkJobRetrieveStatusResponse> =
        retrieveStatus(params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        jobId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<BulkJobRetrieveStatusResponse> =
        retrieveStatus(jobId, BulkJobRetrieveStatusParams.none(), requestOptions)

    /**
     * A view of [BulkJobServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BulkJobServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/bulkJobs/copyFolder`, but is otherwise the same
         * as [BulkJobServiceAsync.copyFolder].
         */
        fun copyFolder(
            params: BulkJobCopyFolderParams
        ): CompletableFuture<HttpResponseFor<BulkJobCopyFolderResponse>> =
            copyFolder(params, RequestOptions.none())

        /** @see copyFolder */
        fun copyFolder(
            params: BulkJobCopyFolderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkJobCopyFolderResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/bulkJobs/moveFolder`, but is otherwise the same
         * as [BulkJobServiceAsync.moveFolder].
         */
        fun moveFolder(
            params: BulkJobMoveFolderParams
        ): CompletableFuture<HttpResponseFor<BulkJobMoveFolderResponse>> =
            moveFolder(params, RequestOptions.none())

        /** @see moveFolder */
        fun moveFolder(
            params: BulkJobMoveFolderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkJobMoveFolderResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/bulkJobs/{jobId}`, but is otherwise the same as
         * [BulkJobServiceAsync.retrieveStatus].
         */
        fun retrieveStatus(
            jobId: String
        ): CompletableFuture<HttpResponseFor<BulkJobRetrieveStatusResponse>> =
            retrieveStatus(jobId, BulkJobRetrieveStatusParams.none())

        /** @see retrieveStatus */
        fun retrieveStatus(
            jobId: String,
            params: BulkJobRetrieveStatusParams = BulkJobRetrieveStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkJobRetrieveStatusResponse>> =
            retrieveStatus(params.toBuilder().jobId(jobId).build(), requestOptions)

        /** @see retrieveStatus */
        fun retrieveStatus(
            jobId: String,
            params: BulkJobRetrieveStatusParams = BulkJobRetrieveStatusParams.none(),
        ): CompletableFuture<HttpResponseFor<BulkJobRetrieveStatusResponse>> =
            retrieveStatus(jobId, params, RequestOptions.none())

        /** @see retrieveStatus */
        fun retrieveStatus(
            params: BulkJobRetrieveStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkJobRetrieveStatusResponse>>

        /** @see retrieveStatus */
        fun retrieveStatus(
            params: BulkJobRetrieveStatusParams
        ): CompletableFuture<HttpResponseFor<BulkJobRetrieveStatusResponse>> =
            retrieveStatus(params, RequestOptions.none())

        /** @see retrieveStatus */
        fun retrieveStatus(
            jobId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BulkJobRetrieveStatusResponse>> =
            retrieveStatus(jobId, BulkJobRetrieveStatusParams.none(), requestOptions)
    }
}
