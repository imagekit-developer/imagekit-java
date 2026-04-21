// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.folders.FolderCopyParams
import io.imagekit.models.folders.FolderCopyResponse
import io.imagekit.models.folders.FolderCreateParams
import io.imagekit.models.folders.FolderCreateResponse
import io.imagekit.models.folders.FolderDeleteParams
import io.imagekit.models.folders.FolderDeleteResponse
import io.imagekit.models.folders.FolderMoveParams
import io.imagekit.models.folders.FolderMoveResponse
import io.imagekit.models.folders.FolderRenameParams
import io.imagekit.models.folders.FolderRenameResponse
import io.imagekit.services.blocking.folders.JobService
import java.util.function.Consumer

interface FolderService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FolderService

    fun job(): JobService

    /**
     * This will create a new folder. You can specify the folder name and location of the parent
     * folder where this new folder should be created.
     */
    fun create(params: FolderCreateParams): FolderCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FolderCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FolderCreateResponse

    /**
     * This will delete a folder and all its contents permanently. The API returns an empty
     * response.
     */
    fun delete(params: FolderDeleteParams): FolderDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: FolderDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FolderDeleteResponse

    /**
     * This will copy one folder into another. The selected folder, its nested folders, files, and
     * their versions (in `includeVersions` is set to true) are copied in this operation. Note: If
     * any file at the destination has the same name as the source file, then the source file and
     * its versions will be appended to the destination file version history.
     */
    fun copy(params: FolderCopyParams): FolderCopyResponse = copy(params, RequestOptions.none())

    /** @see copy */
    fun copy(
        params: FolderCopyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FolderCopyResponse

    /**
     * This will move one folder into another. The selected folder, its nested folders, files, and
     * their versions are moved in this operation. Note: If any file at the destination has the same
     * name as the source file, then the source file and its versions will be appended to the
     * destination file version history.
     */
    fun move(params: FolderMoveParams): FolderMoveResponse = move(params, RequestOptions.none())

    /** @see move */
    fun move(
        params: FolderMoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FolderMoveResponse

    /**
     * This API allows you to rename an existing folder. The folder and all its nested assets and
     * sub-folders will remain unchanged, but their paths will be updated to reflect the new folder
     * name.
     */
    fun rename(params: FolderRenameParams): FolderRenameResponse =
        rename(params, RequestOptions.none())

    /** @see rename */
    fun rename(
        params: FolderRenameParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FolderRenameResponse

    /** A view of [FolderService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FolderService.WithRawResponse

        fun job(): JobService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/folder`, but is otherwise the same as
         * [FolderService.create].
         */
        @MustBeClosed
        fun create(params: FolderCreateParams): HttpResponseFor<FolderCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: FolderCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FolderCreateResponse>

        /**
         * Returns a raw HTTP response for `delete /v1/folder`, but is otherwise the same as
         * [FolderService.delete].
         */
        @MustBeClosed
        fun delete(params: FolderDeleteParams): HttpResponseFor<FolderDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: FolderDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FolderDeleteResponse>

        /**
         * Returns a raw HTTP response for `post /v1/bulkJobs/copyFolder`, but is otherwise the same
         * as [FolderService.copy].
         */
        @MustBeClosed
        fun copy(params: FolderCopyParams): HttpResponseFor<FolderCopyResponse> =
            copy(params, RequestOptions.none())

        /** @see copy */
        @MustBeClosed
        fun copy(
            params: FolderCopyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FolderCopyResponse>

        /**
         * Returns a raw HTTP response for `post /v1/bulkJobs/moveFolder`, but is otherwise the same
         * as [FolderService.move].
         */
        @MustBeClosed
        fun move(params: FolderMoveParams): HttpResponseFor<FolderMoveResponse> =
            move(params, RequestOptions.none())

        /** @see move */
        @MustBeClosed
        fun move(
            params: FolderMoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FolderMoveResponse>

        /**
         * Returns a raw HTTP response for `post /v1/bulkJobs/renameFolder`, but is otherwise the
         * same as [FolderService.rename].
         */
        @MustBeClosed
        fun rename(params: FolderRenameParams): HttpResponseFor<FolderRenameResponse> =
            rename(params, RequestOptions.none())

        /** @see rename */
        @MustBeClosed
        fun rename(
            params: FolderRenameParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FolderRenameResponse>
    }
}
