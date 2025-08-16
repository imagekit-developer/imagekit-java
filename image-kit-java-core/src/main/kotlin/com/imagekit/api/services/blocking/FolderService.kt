// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.folder.FolderCreateParams
import com.imagekit.api.models.folder.FolderCreateResponse
import com.imagekit.api.models.folder.FolderDeleteParams
import com.imagekit.api.models.folder.FolderDeleteResponse
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

    /** A view of [FolderService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FolderService.WithRawResponse

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
    }
}
