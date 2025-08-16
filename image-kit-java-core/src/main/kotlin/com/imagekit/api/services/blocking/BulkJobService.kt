// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.bulkjobs.BulkJobCopyFolderParams
import com.imagekit.api.models.bulkjobs.BulkJobCopyFolderResponse
import com.imagekit.api.models.bulkjobs.BulkJobMoveFolderParams
import com.imagekit.api.models.bulkjobs.BulkJobMoveFolderResponse
import com.imagekit.api.models.bulkjobs.BulkJobRetrieveStatusParams
import com.imagekit.api.models.bulkjobs.BulkJobRetrieveStatusResponse
import java.util.function.Consumer

interface BulkJobService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkJobService

    /**
     * This will copy one folder into another. The selected folder, its nested folders, files, and
     * their versions (in `includeVersions` is set to true) are copied in this operation. Note: If
     * any file at the destination has the same name as the source file, then the source file and
     * its versions will be appended to the destination file version history.
     */
    fun copyFolder(params: BulkJobCopyFolderParams): BulkJobCopyFolderResponse =
        copyFolder(params, RequestOptions.none())

    /** @see copyFolder */
    fun copyFolder(
        params: BulkJobCopyFolderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkJobCopyFolderResponse

    /**
     * This will move one folder into another. The selected folder, its nested folders, files, and
     * their versions are moved in this operation. Note: If any file at the destination has the same
     * name as the source file, then the source file and its versions will be appended to the
     * destination file version history.
     */
    fun moveFolder(params: BulkJobMoveFolderParams): BulkJobMoveFolderResponse =
        moveFolder(params, RequestOptions.none())

    /** @see moveFolder */
    fun moveFolder(
        params: BulkJobMoveFolderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkJobMoveFolderResponse

    /** This API returns the status of a bulk job like copy and move folder operations. */
    fun retrieveStatus(jobId: String): BulkJobRetrieveStatusResponse =
        retrieveStatus(jobId, BulkJobRetrieveStatusParams.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        jobId: String,
        params: BulkJobRetrieveStatusParams = BulkJobRetrieveStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkJobRetrieveStatusResponse =
        retrieveStatus(params.toBuilder().jobId(jobId).build(), requestOptions)

    /** @see retrieveStatus */
    fun retrieveStatus(
        jobId: String,
        params: BulkJobRetrieveStatusParams = BulkJobRetrieveStatusParams.none(),
    ): BulkJobRetrieveStatusResponse = retrieveStatus(jobId, params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: BulkJobRetrieveStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkJobRetrieveStatusResponse

    /** @see retrieveStatus */
    fun retrieveStatus(params: BulkJobRetrieveStatusParams): BulkJobRetrieveStatusResponse =
        retrieveStatus(params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        jobId: String,
        requestOptions: RequestOptions,
    ): BulkJobRetrieveStatusResponse =
        retrieveStatus(jobId, BulkJobRetrieveStatusParams.none(), requestOptions)

    /** A view of [BulkJobService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkJobService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/bulkJobs/copyFolder`, but is otherwise the same
         * as [BulkJobService.copyFolder].
         */
        @MustBeClosed
        fun copyFolder(
            params: BulkJobCopyFolderParams
        ): HttpResponseFor<BulkJobCopyFolderResponse> = copyFolder(params, RequestOptions.none())

        /** @see copyFolder */
        @MustBeClosed
        fun copyFolder(
            params: BulkJobCopyFolderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkJobCopyFolderResponse>

        /**
         * Returns a raw HTTP response for `post /v1/bulkJobs/moveFolder`, but is otherwise the same
         * as [BulkJobService.moveFolder].
         */
        @MustBeClosed
        fun moveFolder(
            params: BulkJobMoveFolderParams
        ): HttpResponseFor<BulkJobMoveFolderResponse> = moveFolder(params, RequestOptions.none())

        /** @see moveFolder */
        @MustBeClosed
        fun moveFolder(
            params: BulkJobMoveFolderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkJobMoveFolderResponse>

        /**
         * Returns a raw HTTP response for `get /v1/bulkJobs/{jobId}`, but is otherwise the same as
         * [BulkJobService.retrieveStatus].
         */
        @MustBeClosed
        fun retrieveStatus(jobId: String): HttpResponseFor<BulkJobRetrieveStatusResponse> =
            retrieveStatus(jobId, BulkJobRetrieveStatusParams.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            jobId: String,
            params: BulkJobRetrieveStatusParams = BulkJobRetrieveStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkJobRetrieveStatusResponse> =
            retrieveStatus(params.toBuilder().jobId(jobId).build(), requestOptions)

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            jobId: String,
            params: BulkJobRetrieveStatusParams = BulkJobRetrieveStatusParams.none(),
        ): HttpResponseFor<BulkJobRetrieveStatusResponse> =
            retrieveStatus(jobId, params, RequestOptions.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: BulkJobRetrieveStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkJobRetrieveStatusResponse>

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: BulkJobRetrieveStatusParams
        ): HttpResponseFor<BulkJobRetrieveStatusResponse> =
            retrieveStatus(params, RequestOptions.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            jobId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkJobRetrieveStatusResponse> =
            retrieveStatus(jobId, BulkJobRetrieveStatusParams.none(), requestOptions)
    }
}
