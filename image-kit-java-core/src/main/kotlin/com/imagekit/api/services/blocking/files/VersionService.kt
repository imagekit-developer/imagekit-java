// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

interface VersionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VersionService

    /** This API returns details of all versions of a file. */
    fun list(fileId: String): List<VersionListResponse> = list(fileId, VersionListParams.none())

    /** @see list */
    fun list(
        fileId: String,
        params: VersionListParams = VersionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<VersionListResponse> = list(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see list */
    fun list(
        fileId: String,
        params: VersionListParams = VersionListParams.none(),
    ): List<VersionListResponse> = list(fileId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: VersionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<VersionListResponse>

    /** @see list */
    fun list(params: VersionListParams): List<VersionListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(fileId: String, requestOptions: RequestOptions): List<VersionListResponse> =
        list(fileId, VersionListParams.none(), requestOptions)

    /**
     * This API deletes a non-current file version permanently. The API returns an empty response.
     *
     * Note: If you want to delete all versions of a file, use the delete file API.
     */
    fun delete(versionId: String, params: VersionDeleteParams): VersionDeleteResponse =
        delete(versionId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        versionId: String,
        params: VersionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VersionDeleteResponse =
        delete(params.toBuilder().versionId(versionId).build(), requestOptions)

    /** @see delete */
    fun delete(params: VersionDeleteParams): VersionDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: VersionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VersionDeleteResponse

    /** This API returns an object with details or attributes of a file version. */
    fun get(versionId: String, params: VersionGetParams): VersionGetResponse =
        get(versionId, params, RequestOptions.none())

    /** @see get */
    fun get(
        versionId: String,
        params: VersionGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VersionGetResponse = get(params.toBuilder().versionId(versionId).build(), requestOptions)

    /** @see get */
    fun get(params: VersionGetParams): VersionGetResponse = get(params, RequestOptions.none())

    /** @see get */
    fun get(
        params: VersionGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VersionGetResponse

    /** This API restores a file version as the current file version. */
    fun restore(versionId: String, params: VersionRestoreParams): VersionRestoreResponse =
        restore(versionId, params, RequestOptions.none())

    /** @see restore */
    fun restore(
        versionId: String,
        params: VersionRestoreParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VersionRestoreResponse =
        restore(params.toBuilder().versionId(versionId).build(), requestOptions)

    /** @see restore */
    fun restore(params: VersionRestoreParams): VersionRestoreResponse =
        restore(params, RequestOptions.none())

    /** @see restore */
    fun restore(
        params: VersionRestoreParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VersionRestoreResponse

    /** A view of [VersionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): VersionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/files/{fileId}/versions`, but is otherwise the
         * same as [VersionService.list].
         */
        @MustBeClosed
        fun list(fileId: String): HttpResponseFor<List<VersionListResponse>> =
            list(fileId, VersionListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            fileId: String,
            params: VersionListParams = VersionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<VersionListResponse>> =
            list(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            fileId: String,
            params: VersionListParams = VersionListParams.none(),
        ): HttpResponseFor<List<VersionListResponse>> = list(fileId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: VersionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<VersionListResponse>>

        /** @see list */
        @MustBeClosed
        fun list(params: VersionListParams): HttpResponseFor<List<VersionListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            fileId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<VersionListResponse>> =
            list(fileId, VersionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/files/{fileId}/versions/{versionId}`, but is
         * otherwise the same as [VersionService.delete].
         */
        @MustBeClosed
        fun delete(
            versionId: String,
            params: VersionDeleteParams,
        ): HttpResponseFor<VersionDeleteResponse> = delete(versionId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            versionId: String,
            params: VersionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VersionDeleteResponse> =
            delete(params.toBuilder().versionId(versionId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: VersionDeleteParams): HttpResponseFor<VersionDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: VersionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VersionDeleteResponse>

        /**
         * Returns a raw HTTP response for `get /v1/files/{fileId}/versions/{versionId}`, but is
         * otherwise the same as [VersionService.get].
         */
        @MustBeClosed
        fun get(versionId: String, params: VersionGetParams): HttpResponseFor<VersionGetResponse> =
            get(versionId, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            versionId: String,
            params: VersionGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VersionGetResponse> =
            get(params.toBuilder().versionId(versionId).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(params: VersionGetParams): HttpResponseFor<VersionGetResponse> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: VersionGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VersionGetResponse>

        /**
         * Returns a raw HTTP response for `put /v1/files/{fileId}/versions/{versionId}/restore`,
         * but is otherwise the same as [VersionService.restore].
         */
        @MustBeClosed
        fun restore(
            versionId: String,
            params: VersionRestoreParams,
        ): HttpResponseFor<VersionRestoreResponse> =
            restore(versionId, params, RequestOptions.none())

        /** @see restore */
        @MustBeClosed
        fun restore(
            versionId: String,
            params: VersionRestoreParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VersionRestoreResponse> =
            restore(params.toBuilder().versionId(versionId).build(), requestOptions)

        /** @see restore */
        @MustBeClosed
        fun restore(params: VersionRestoreParams): HttpResponseFor<VersionRestoreResponse> =
            restore(params, RequestOptions.none())

        /** @see restore */
        @MustBeClosed
        fun restore(
            params: VersionRestoreParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VersionRestoreResponse>
    }
}
