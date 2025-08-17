// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.files

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.files.versions.VersionDeleteParams
import com.imagekit.api.models.files.versions.VersionDeleteResponse
import com.imagekit.api.models.files.versions.VersionGetParams
import com.imagekit.api.models.files.versions.VersionGetResponse
import com.imagekit.api.models.files.versions.VersionListParams
import com.imagekit.api.models.files.versions.VersionListResponse
import com.imagekit.api.models.files.versions.VersionRestoreParams
import com.imagekit.api.models.files.versions.VersionRestoreResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface VersionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VersionServiceAsync

    /** This API returns details of all versions of a file. */
    fun list(fileId: String): CompletableFuture<List<VersionListResponse>> =
        list(fileId, VersionListParams.none())

    /** @see list */
    fun list(
        fileId: String,
        params: VersionListParams = VersionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<VersionListResponse>> =
        list(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see list */
    fun list(
        fileId: String,
        params: VersionListParams = VersionListParams.none(),
    ): CompletableFuture<List<VersionListResponse>> = list(fileId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: VersionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<VersionListResponse>>

    /** @see list */
    fun list(params: VersionListParams): CompletableFuture<List<VersionListResponse>> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        fileId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<VersionListResponse>> =
        list(fileId, VersionListParams.none(), requestOptions)

    /**
     * This API deletes a non-current file version permanently. The API returns an empty response.
     *
     * Note: If you want to delete all versions of a file, use the delete file API.
     */
    fun delete(
        versionId: String,
        params: VersionDeleteParams,
    ): CompletableFuture<VersionDeleteResponse> = delete(versionId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        versionId: String,
        params: VersionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VersionDeleteResponse> =
        delete(params.toBuilder().versionId(versionId).build(), requestOptions)

    /** @see delete */
    fun delete(params: VersionDeleteParams): CompletableFuture<VersionDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: VersionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VersionDeleteResponse>

    /** This API returns an object with details or attributes of a file version. */
    fun get(versionId: String, params: VersionGetParams): CompletableFuture<VersionGetResponse> =
        get(versionId, params, RequestOptions.none())

    /** @see get */
    fun get(
        versionId: String,
        params: VersionGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VersionGetResponse> =
        get(params.toBuilder().versionId(versionId).build(), requestOptions)

    /** @see get */
    fun get(params: VersionGetParams): CompletableFuture<VersionGetResponse> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(
        params: VersionGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VersionGetResponse>

    /** This API restores a file version as the current file version. */
    fun restore(
        versionId: String,
        params: VersionRestoreParams,
    ): CompletableFuture<VersionRestoreResponse> = restore(versionId, params, RequestOptions.none())

    /** @see restore */
    fun restore(
        versionId: String,
        params: VersionRestoreParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VersionRestoreResponse> =
        restore(params.toBuilder().versionId(versionId).build(), requestOptions)

    /** @see restore */
    fun restore(params: VersionRestoreParams): CompletableFuture<VersionRestoreResponse> =
        restore(params, RequestOptions.none())

    /** @see restore */
    fun restore(
        params: VersionRestoreParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VersionRestoreResponse>

    /**
     * A view of [VersionServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VersionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/files/{fileId}/versions`, but is otherwise the
         * same as [VersionServiceAsync.list].
         */
        fun list(fileId: String): CompletableFuture<HttpResponseFor<List<VersionListResponse>>> =
            list(fileId, VersionListParams.none())

        /** @see list */
        fun list(
            fileId: String,
            params: VersionListParams = VersionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<VersionListResponse>>> =
            list(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see list */
        fun list(
            fileId: String,
            params: VersionListParams = VersionListParams.none(),
        ): CompletableFuture<HttpResponseFor<List<VersionListResponse>>> =
            list(fileId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: VersionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<VersionListResponse>>>

        /** @see list */
        fun list(
            params: VersionListParams
        ): CompletableFuture<HttpResponseFor<List<VersionListResponse>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            fileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<VersionListResponse>>> =
            list(fileId, VersionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/files/{fileId}/versions/{versionId}`, but is
         * otherwise the same as [VersionServiceAsync.delete].
         */
        fun delete(
            versionId: String,
            params: VersionDeleteParams,
        ): CompletableFuture<HttpResponseFor<VersionDeleteResponse>> =
            delete(versionId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            versionId: String,
            params: VersionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VersionDeleteResponse>> =
            delete(params.toBuilder().versionId(versionId).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: VersionDeleteParams
        ): CompletableFuture<HttpResponseFor<VersionDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: VersionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VersionDeleteResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/files/{fileId}/versions/{versionId}`, but is
         * otherwise the same as [VersionServiceAsync.get].
         */
        fun get(
            versionId: String,
            params: VersionGetParams,
        ): CompletableFuture<HttpResponseFor<VersionGetResponse>> =
            get(versionId, params, RequestOptions.none())

        /** @see get */
        fun get(
            versionId: String,
            params: VersionGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VersionGetResponse>> =
            get(params.toBuilder().versionId(versionId).build(), requestOptions)

        /** @see get */
        fun get(params: VersionGetParams): CompletableFuture<HttpResponseFor<VersionGetResponse>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            params: VersionGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VersionGetResponse>>

        /**
         * Returns a raw HTTP response for `put /v1/files/{fileId}/versions/{versionId}/restore`,
         * but is otherwise the same as [VersionServiceAsync.restore].
         */
        fun restore(
            versionId: String,
            params: VersionRestoreParams,
        ): CompletableFuture<HttpResponseFor<VersionRestoreResponse>> =
            restore(versionId, params, RequestOptions.none())

        /** @see restore */
        fun restore(
            versionId: String,
            params: VersionRestoreParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VersionRestoreResponse>> =
            restore(params.toBuilder().versionId(versionId).build(), requestOptions)

        /** @see restore */
        fun restore(
            params: VersionRestoreParams
        ): CompletableFuture<HttpResponseFor<VersionRestoreResponse>> =
            restore(params, RequestOptions.none())

        /** @see restore */
        fun restore(
            params: VersionRestoreParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VersionRestoreResponse>>
    }
}
