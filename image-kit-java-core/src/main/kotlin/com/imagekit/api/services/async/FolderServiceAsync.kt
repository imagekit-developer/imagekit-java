// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.folders.FolderCopyParams
import com.imagekit.api.models.folders.FolderCopyResponse
import com.imagekit.api.models.folders.FolderCreateParams
import com.imagekit.api.models.folders.FolderCreateResponse
import com.imagekit.api.models.folders.FolderDeleteParams
import com.imagekit.api.models.folders.FolderDeleteResponse
import com.imagekit.api.models.folders.FolderMoveParams
import com.imagekit.api.models.folders.FolderMoveResponse
import com.imagekit.api.models.folders.FolderRenameParams
import com.imagekit.api.models.folders.FolderRenameResponse
import com.imagekit.api.services.async.folders.JobServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface FolderServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FolderServiceAsync

    fun job(): JobServiceAsync

    /**
     * This will create a new folder. You can specify the folder name and location of the parent
     * folder where this new folder should be created.
     */
    fun create(params: FolderCreateParams): CompletableFuture<FolderCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FolderCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FolderCreateResponse>

    /**
     * This will delete a folder and all its contents permanently. The API returns an empty
     * response.
     */
    fun delete(params: FolderDeleteParams): CompletableFuture<FolderDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: FolderDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FolderDeleteResponse>

    /**
     * This will copy one folder into another. The selected folder, its nested folders, files, and
     * their versions (in `includeVersions` is set to true) are copied in this operation. Note: If
     * any file at the destination has the same name as the source file, then the source file and
     * its versions will be appended to the destination file version history.
     */
    fun copy(params: FolderCopyParams): CompletableFuture<FolderCopyResponse> =
        copy(params, RequestOptions.none())

    /** @see copy */
    fun copy(
        params: FolderCopyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FolderCopyResponse>

    /**
     * This will move one folder into another. The selected folder, its nested folders, files, and
     * their versions are moved in this operation. Note: If any file at the destination has the same
     * name as the source file, then the source file and its versions will be appended to the
     * destination file version history.
     */
    fun move(params: FolderMoveParams): CompletableFuture<FolderMoveResponse> =
        move(params, RequestOptions.none())

    /** @see move */
    fun move(
        params: FolderMoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FolderMoveResponse>

    /**
     * This API allows you to rename an existing folder. The folder and all its nested assets and
     * sub-folders will remain unchanged, but their paths will be updated to reflect the new folder
     * name.
     */
    fun rename(params: FolderRenameParams): CompletableFuture<FolderRenameResponse> =
        rename(params, RequestOptions.none())

    /** @see rename */
    fun rename(
        params: FolderRenameParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FolderRenameResponse>

    /**
     * A view of [FolderServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FolderServiceAsync.WithRawResponse

        fun job(): JobServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/folder`, but is otherwise the same as
         * [FolderServiceAsync.create].
         */
        fun create(
            params: FolderCreateParams
        ): CompletableFuture<HttpResponseFor<FolderCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: FolderCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FolderCreateResponse>>

        /**
         * Returns a raw HTTP response for `delete /v1/folder`, but is otherwise the same as
         * [FolderServiceAsync.delete].
         */
        fun delete(
            params: FolderDeleteParams
        ): CompletableFuture<HttpResponseFor<FolderDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: FolderDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FolderDeleteResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/bulkJobs/copyFolder`, but is otherwise the same
         * as [FolderServiceAsync.copy].
         */
        fun copy(params: FolderCopyParams): CompletableFuture<HttpResponseFor<FolderCopyResponse>> =
            copy(params, RequestOptions.none())

        /** @see copy */
        fun copy(
            params: FolderCopyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FolderCopyResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/bulkJobs/moveFolder`, but is otherwise the same
         * as [FolderServiceAsync.move].
         */
        fun move(params: FolderMoveParams): CompletableFuture<HttpResponseFor<FolderMoveResponse>> =
            move(params, RequestOptions.none())

        /** @see move */
        fun move(
            params: FolderMoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FolderMoveResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/bulkJobs/renameFolder`, but is otherwise the
         * same as [FolderServiceAsync.rename].
         */
        fun rename(
            params: FolderRenameParams
        ): CompletableFuture<HttpResponseFor<FolderRenameResponse>> =
            rename(params, RequestOptions.none())

        /** @see rename */
        fun rename(
            params: FolderRenameParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FolderRenameResponse>>
    }
}
