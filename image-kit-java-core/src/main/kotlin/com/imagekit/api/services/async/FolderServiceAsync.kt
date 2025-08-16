// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.folder.FolderCreateParams
import com.imagekit.api.models.folder.FolderCreateResponse
import com.imagekit.api.models.folder.FolderDeleteParams
import com.imagekit.api.models.folder.FolderDeleteResponse
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
    }
}
