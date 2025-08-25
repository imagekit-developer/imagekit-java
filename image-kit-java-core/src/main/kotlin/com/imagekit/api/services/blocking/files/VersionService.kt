// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

import com.google.errorprone.annotations.MustBeClosed
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.assets.File
import com.imagekit.api.models.files.versions.VersionDeleteParams
import com.imagekit.api.models.files.versions.VersionDeleteResponse
import com.imagekit.api.models.files.versions.VersionGetParams
import com.imagekit.api.models.files.versions.VersionListParams
import com.imagekit.api.models.files.versions.VersionRestoreParams
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
    fun list(fileId: String): List<File> = list(fileId, VersionListParams.none())

    /** @see list */
    fun list(
        fileId: String,
        params: VersionListParams = VersionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<File> = list(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see list */
    fun list(fileId: String, params: VersionListParams = VersionListParams.none()): List<File> =
        list(fileId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: VersionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<File>

    /** @see list */
    fun list(params: VersionListParams): List<File> = list(params, RequestOptions.none())

    /** @see list */
    fun list(fileId: String, requestOptions: RequestOptions): List<File> =
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
    fun get(versionId: String, params: VersionGetParams): File =
        get(versionId, params, RequestOptions.none())

    /** @see get */
    fun get(
        versionId: String,
        params: VersionGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): File = get(params.toBuilder().versionId(versionId).build(), requestOptions)

    /** @see get */
    fun get(params: VersionGetParams): File = get(params, RequestOptions.none())

    /** @see get */
    fun get(params: VersionGetParams, requestOptions: RequestOptions = RequestOptions.none()): File

    /** This API restores a file version as the current file version. */
    fun restore(versionId: String, params: VersionRestoreParams): File =
        restore(versionId, params, RequestOptions.none())

    /** @see restore */
    fun restore(
        versionId: String,
        params: VersionRestoreParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): File = restore(params.toBuilder().versionId(versionId).build(), requestOptions)

    /** @see restore */
    fun restore(params: VersionRestoreParams): File = restore(params, RequestOptions.none())

    /** @see restore */
    fun restore(
        params: VersionRestoreParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): File

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
        fun list(fileId: String): HttpResponseFor<List<File>> =
            list(fileId, VersionListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            fileId: String,
            params: VersionListParams = VersionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<File>> =
            list(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            fileId: String,
            params: VersionListParams = VersionListParams.none(),
        ): HttpResponseFor<List<File>> = list(fileId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: VersionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<File>>

        /** @see list */
        @MustBeClosed
        fun list(params: VersionListParams): HttpResponseFor<List<File>> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(fileId: String, requestOptions: RequestOptions): HttpResponseFor<List<File>> =
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
        fun get(versionId: String, params: VersionGetParams): HttpResponseFor<File> =
            get(versionId, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            versionId: String,
            params: VersionGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<File> =
            get(params.toBuilder().versionId(versionId).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(params: VersionGetParams): HttpResponseFor<File> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: VersionGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<File>

        /**
         * Returns a raw HTTP response for `put /v1/files/{fileId}/versions/{versionId}/restore`,
         * but is otherwise the same as [VersionService.restore].
         */
        @MustBeClosed
        fun restore(versionId: String, params: VersionRestoreParams): HttpResponseFor<File> =
            restore(versionId, params, RequestOptions.none())

        /** @see restore */
        @MustBeClosed
        fun restore(
            versionId: String,
            params: VersionRestoreParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<File> =
            restore(params.toBuilder().versionId(versionId).build(), requestOptions)

        /** @see restore */
        @MustBeClosed
        fun restore(params: VersionRestoreParams): HttpResponseFor<File> =
            restore(params, RequestOptions.none())

        /** @see restore */
        @MustBeClosed
        fun restore(
            params: VersionRestoreParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<File>
    }
}
