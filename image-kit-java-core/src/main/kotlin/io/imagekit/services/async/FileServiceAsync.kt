// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponse
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.files.File
import io.imagekit.models.files.FileCopyParams
import io.imagekit.models.files.FileCopyResponse
import io.imagekit.models.files.FileDeleteParams
import io.imagekit.models.files.FileGetParams
import io.imagekit.models.files.FileMoveParams
import io.imagekit.models.files.FileMoveResponse
import io.imagekit.models.files.FileRenameParams
import io.imagekit.models.files.FileRenameResponse
import io.imagekit.models.files.FileUpdateParams
import io.imagekit.models.files.FileUpdateResponse
import io.imagekit.models.files.FileUploadParams
import io.imagekit.models.files.FileUploadResponse
import io.imagekit.services.async.files.BulkServiceAsync
import io.imagekit.services.async.files.MetadataServiceAsync
import io.imagekit.services.async.files.VersionServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface FileServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync

    fun bulk(): BulkServiceAsync

    fun versions(): VersionServiceAsync

    fun metadata(): MetadataServiceAsync

    /**
     * This API updates the details or attributes of the current version of the file. You can update
     * `tags`, `customCoordinates`, `customMetadata`, publication status, remove existing `AITags`
     * and apply extensions using this API.
     */
    fun update(fileId: String, params: FileUpdateParams): CompletableFuture<FileUpdateResponse> =
        update(fileId, params, RequestOptions.none())

    /** @see update */
    fun update(
        fileId: String,
        params: FileUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileUpdateResponse> =
        update(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see update */
    fun update(params: FileUpdateParams): CompletableFuture<FileUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: FileUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileUpdateResponse>

    /**
     * This API deletes the file and all its file versions permanently.
     *
     * Note: If a file or specific transformation has been requested in the past, then the response
     * is cached. Deleting a file does not purge the cache. You can purge the cache using purge
     * cache API.
     */
    fun delete(fileId: String): CompletableFuture<Void?> = delete(fileId, FileDeleteParams.none())

    /** @see delete */
    fun delete(
        fileId: String,
        params: FileDeleteParams = FileDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see delete */
    fun delete(
        fileId: String,
        params: FileDeleteParams = FileDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(fileId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: FileDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(fileId: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(fileId, FileDeleteParams.none(), requestOptions)

    /**
     * This will copy a file from one folder to another.
     *
     * Note: If any file at the destination has the same name as the source file, then the source
     * file and its versions (if `includeFileVersions` is set to true) will be appended to the
     * destination file version history.
     */
    fun copy(params: FileCopyParams): CompletableFuture<FileCopyResponse> =
        copy(params, RequestOptions.none())

    /** @see copy */
    fun copy(
        params: FileCopyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileCopyResponse>

    /**
     * This API returns an object with details or attributes about the current version of the file.
     */
    fun get(fileId: String): CompletableFuture<File> = get(fileId, FileGetParams.none())

    /** @see get */
    fun get(
        fileId: String,
        params: FileGetParams = FileGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<File> = get(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see get */
    fun get(fileId: String, params: FileGetParams = FileGetParams.none()): CompletableFuture<File> =
        get(fileId, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: FileGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<File>

    /** @see get */
    fun get(params: FileGetParams): CompletableFuture<File> = get(params, RequestOptions.none())

    /** @see get */
    fun get(fileId: String, requestOptions: RequestOptions): CompletableFuture<File> =
        get(fileId, FileGetParams.none(), requestOptions)

    /**
     * This will move a file and all its versions from one folder to another.
     *
     * Note: If any file at the destination has the same name as the source file, then the source
     * file and its versions will be appended to the destination file.
     */
    fun move(params: FileMoveParams): CompletableFuture<FileMoveResponse> =
        move(params, RequestOptions.none())

    /** @see move */
    fun move(
        params: FileMoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileMoveResponse>

    /**
     * You can rename an already existing file in the media library using rename file API. This
     * operation would rename all file versions of the file.
     *
     * Note: The old URLs will stop working. The file/file version URLs cached on CDN will continue
     * to work unless a purge is requested.
     */
    fun rename(params: FileRenameParams): CompletableFuture<FileRenameResponse> =
        rename(params, RequestOptions.none())

    /** @see rename */
    fun rename(
        params: FileRenameParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileRenameResponse>

    /**
     * ImageKit.io allows you to upload files directly from both the server and client sides. For
     * server-side uploads, private API key authentication is used. For client-side uploads,
     * generate a one-time `token`, `signature`, and `expire` from your secure backend using private
     * API.
     * [Learn more](/docs/api-reference/upload-file/upload-file#how-to-implement-client-side-file-upload)
     * about how to implement client-side file upload.
     *
     * The [V2 API](/docs/api-reference/upload-file/upload-file-v2) enhances security by verifying
     * the entire payload using JWT.
     *
     * **File size limit** \ On the free plan, the maximum upload file sizes are 25MB for images,
     * audio, and raw files and 100MB for videos. On the Lite paid plan, these limits increase to
     * 40MB for images, audio, and raw files and 300MB for videos, whereas on the Pro paid plan,
     * these limits increase to 50MB for images, audio, and raw files and 2GB for videos. These
     * limits can be further increased with enterprise plans.
     *
     * **Version limit** \ A file can have a maximum of 100 versions.
     *
     * **Demo applications**
     *
     * - A full-fledged
     *   [upload widget using Uppy](https://github.com/imagekit-samples/uppy-uploader), supporting
     *   file selections from local storage, URL, Dropbox, Google Drive, Instagram, and more.
     * - [Quick start guides](/docs/quick-start-guides) for various frameworks and technologies.
     */
    fun upload(params: FileUploadParams): CompletableFuture<FileUploadResponse> =
        upload(params, RequestOptions.none())

    /** @see upload */
    fun upload(
        params: FileUploadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileUploadResponse>

    /** A view of [FileServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync.WithRawResponse

        fun bulk(): BulkServiceAsync.WithRawResponse

        fun versions(): VersionServiceAsync.WithRawResponse

        fun metadata(): MetadataServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `patch /v1/files/{fileId}/details`, but is otherwise the
         * same as [FileServiceAsync.update].
         */
        fun update(
            fileId: String,
            params: FileUpdateParams,
        ): CompletableFuture<HttpResponseFor<FileUpdateResponse>> =
            update(fileId, params, RequestOptions.none())

        /** @see update */
        fun update(
            fileId: String,
            params: FileUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileUpdateResponse>> =
            update(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see update */
        fun update(
            params: FileUpdateParams
        ): CompletableFuture<HttpResponseFor<FileUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: FileUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileUpdateResponse>>

        /**
         * Returns a raw HTTP response for `delete /v1/files/{fileId}`, but is otherwise the same as
         * [FileServiceAsync.delete].
         */
        fun delete(fileId: String): CompletableFuture<HttpResponse> =
            delete(fileId, FileDeleteParams.none())

        /** @see delete */
        fun delete(
            fileId: String,
            params: FileDeleteParams = FileDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see delete */
        fun delete(
            fileId: String,
            params: FileDeleteParams = FileDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(fileId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: FileDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            fileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = delete(fileId, FileDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/files/copy`, but is otherwise the same as
         * [FileServiceAsync.copy].
         */
        fun copy(params: FileCopyParams): CompletableFuture<HttpResponseFor<FileCopyResponse>> =
            copy(params, RequestOptions.none())

        /** @see copy */
        fun copy(
            params: FileCopyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileCopyResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/files/{fileId}/details`, but is otherwise the
         * same as [FileServiceAsync.get].
         */
        fun get(fileId: String): CompletableFuture<HttpResponseFor<File>> =
            get(fileId, FileGetParams.none())

        /** @see get */
        fun get(
            fileId: String,
            params: FileGetParams = FileGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<File>> =
            get(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see get */
        fun get(
            fileId: String,
            params: FileGetParams = FileGetParams.none(),
        ): CompletableFuture<HttpResponseFor<File>> = get(fileId, params, RequestOptions.none())

        /** @see get */
        fun get(
            params: FileGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<File>>

        /** @see get */
        fun get(params: FileGetParams): CompletableFuture<HttpResponseFor<File>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            fileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<File>> =
            get(fileId, FileGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/files/move`, but is otherwise the same as
         * [FileServiceAsync.move].
         */
        fun move(params: FileMoveParams): CompletableFuture<HttpResponseFor<FileMoveResponse>> =
            move(params, RequestOptions.none())

        /** @see move */
        fun move(
            params: FileMoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileMoveResponse>>

        /**
         * Returns a raw HTTP response for `put /v1/files/rename`, but is otherwise the same as
         * [FileServiceAsync.rename].
         */
        fun rename(
            params: FileRenameParams
        ): CompletableFuture<HttpResponseFor<FileRenameResponse>> =
            rename(params, RequestOptions.none())

        /** @see rename */
        fun rename(
            params: FileRenameParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileRenameResponse>>

        /**
         * Returns a raw HTTP response for `post /api/v1/files/upload`, but is otherwise the same as
         * [FileServiceAsync.upload].
         */
        fun upload(
            params: FileUploadParams
        ): CompletableFuture<HttpResponseFor<FileUploadResponse>> =
            upload(params, RequestOptions.none())

        /** @see upload */
        fun upload(
            params: FileUploadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileUploadResponse>>
    }
}
