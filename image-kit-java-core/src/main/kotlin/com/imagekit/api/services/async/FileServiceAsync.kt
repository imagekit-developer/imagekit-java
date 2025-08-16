// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponse
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.files.FileAddTagsParams
import com.imagekit.api.models.files.FileAddTagsResponse
import com.imagekit.api.models.files.FileCopyParams
import com.imagekit.api.models.files.FileCopyResponse
import com.imagekit.api.models.files.FileDeleteParams
import com.imagekit.api.models.files.FileListParams
import com.imagekit.api.models.files.FileListResponse
import com.imagekit.api.models.files.FileMoveParams
import com.imagekit.api.models.files.FileMoveResponse
import com.imagekit.api.models.files.FileRemoveAiTagsParams
import com.imagekit.api.models.files.FileRemoveAiTagsResponse
import com.imagekit.api.models.files.FileRemoveTagsParams
import com.imagekit.api.models.files.FileRemoveTagsResponse
import com.imagekit.api.models.files.FileRenameParams
import com.imagekit.api.models.files.FileRenameResponse
import com.imagekit.api.models.files.FileUploadV1Params
import com.imagekit.api.models.files.FileUploadV1Response
import com.imagekit.api.models.files.FileUploadV2Params
import com.imagekit.api.models.files.FileUploadV2Response
import com.imagekit.api.services.async.files.BatchServiceAsync
import com.imagekit.api.services.async.files.DetailServiceAsync
import com.imagekit.api.services.async.files.MetadataServiceAsync
import com.imagekit.api.services.async.files.PurgeServiceAsync
import com.imagekit.api.services.async.files.VersionServiceAsync
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

    fun details(): DetailServiceAsync

    fun batch(): BatchServiceAsync

    fun versions(): VersionServiceAsync

    fun purge(): PurgeServiceAsync

    fun metadata(): MetadataServiceAsync

    /**
     * This API can list all the uploaded files and folders in your ImageKit.io media library. In
     * addition, you can fine-tune your query by specifying various filters by generating a query
     * string in a Lucene-like syntax and provide this generated string as the value of the
     * `searchQuery`.
     */
    fun list(): CompletableFuture<List<FileListResponse>> = list(FileListParams.none())

    /** @see list */
    fun list(
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<FileListResponse>>

    /** @see list */
    fun list(
        params: FileListParams = FileListParams.none()
    ): CompletableFuture<List<FileListResponse>> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<FileListResponse>> =
        list(FileListParams.none(), requestOptions)

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
     * This API adds tags to multiple files in bulk. A maximum of 50 files can be specified at a
     * time.
     */
    fun addTags(params: FileAddTagsParams): CompletableFuture<FileAddTagsResponse> =
        addTags(params, RequestOptions.none())

    /** @see addTags */
    fun addTags(
        params: FileAddTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileAddTagsResponse>

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
     * This API removes AITags from multiple files in bulk. A maximum of 50 files can be specified
     * at a time.
     */
    fun removeAiTags(params: FileRemoveAiTagsParams): CompletableFuture<FileRemoveAiTagsResponse> =
        removeAiTags(params, RequestOptions.none())

    /** @see removeAiTags */
    fun removeAiTags(
        params: FileRemoveAiTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileRemoveAiTagsResponse>

    /**
     * This API removes tags from multiple files in bulk. A maximum of 50 files can be specified at
     * a time.
     */
    fun removeTags(params: FileRemoveTagsParams): CompletableFuture<FileRemoveTagsResponse> =
        removeTags(params, RequestOptions.none())

    /** @see removeTags */
    fun removeTags(
        params: FileRemoveTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileRemoveTagsResponse>

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
     * generate a one-time `token`, `signature`, and `expiration` from your secure backend using
     * private API.
     * [Learn more](/docs/api-reference/upload-file/upload-file#how-to-implement-client-side-file-upload)
     * about how to implement client-side file upload.
     *
     * The [V2 API](/docs/api-reference/upload-file/upload-file-v2) enhances security by verifying
     * the entire payload using JWT.
     *
     * **File size limit** \ On the free plan, the maximum upload file sizes are 20MB for images,
     * audio, and raw files and 100MB for videos. On the paid plan, these limits increase to 40MB
     * for images, audio, and raw files and 2GB for videos. These limits can be further increased
     * with higher-tier plans.
     *
     * **Version limit** \ A file can have a maximum of 100 versions.
     *
     * **Demo applications**
     * - A full-fledged
     *   [upload widget using Uppy](https://github.com/imagekit-samples/uppy-uploader), supporting
     *   file selections from local storage, URL, Dropbox, Google Drive, Instagram, and more.
     * - [Quick start guides](/docs/quick-start-guides) for various frameworks and technologies.
     */
    fun uploadV1(params: FileUploadV1Params): CompletableFuture<FileUploadV1Response> =
        uploadV1(params, RequestOptions.none())

    /** @see uploadV1 */
    fun uploadV1(
        params: FileUploadV1Params,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileUploadV1Response>

    /**
     * The V2 API enhances security by verifying the entire payload using JWT. This API is in beta.
     *
     * ImageKit.io allows you to upload files directly from both the server and client sides. For
     * server-side uploads, private API key authentication is used. For client-side uploads,
     * generate a one-time `token` from your secure backend using private API.
     * [Learn more](/docs/api-reference/upload-file/upload-file-v2#how-to-implement-secure-client-side-file-upload)
     * about how to implement secure client-side file upload.
     *
     * **File size limit** \ On the free plan, the maximum upload file sizes are 20MB for images,
     * audio, and raw files, and 100MB for videos. On the paid plan, these limits increase to 40MB
     * for images, audio, and raw files, and 2GB for videos. These limits can be further increased
     * with higher-tier plans.
     *
     * **Version limit** \ A file can have a maximum of 100 versions.
     *
     * **Demo applications**
     * - A full-fledged
     *   [upload widget using Uppy](https://github.com/imagekit-samples/uppy-uploader), supporting
     *   file selections from local storage, URL, Dropbox, Google Drive, Instagram, and more.
     * - [Quick start guides](/docs/quick-start-guides) for various frameworks and technologies.
     */
    fun uploadV2(params: FileUploadV2Params): CompletableFuture<FileUploadV2Response> =
        uploadV2(params, RequestOptions.none())

    /** @see uploadV2 */
    fun uploadV2(
        params: FileUploadV2Params,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileUploadV2Response>

    /** A view of [FileServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync.WithRawResponse

        fun details(): DetailServiceAsync.WithRawResponse

        fun batch(): BatchServiceAsync.WithRawResponse

        fun versions(): VersionServiceAsync.WithRawResponse

        fun purge(): PurgeServiceAsync.WithRawResponse

        fun metadata(): MetadataServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/files`, but is otherwise the same as
         * [FileServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<FileListResponse>>> =
            list(FileListParams.none())

        /** @see list */
        fun list(
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<FileListResponse>>>

        /** @see list */
        fun list(
            params: FileListParams = FileListParams.none()
        ): CompletableFuture<HttpResponseFor<List<FileListResponse>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<FileListResponse>>> =
            list(FileListParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `post /v1/files/addTags`, but is otherwise the same as
         * [FileServiceAsync.addTags].
         */
        fun addTags(
            params: FileAddTagsParams
        ): CompletableFuture<HttpResponseFor<FileAddTagsResponse>> =
            addTags(params, RequestOptions.none())

        /** @see addTags */
        fun addTags(
            params: FileAddTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileAddTagsResponse>>

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
         * Returns a raw HTTP response for `post /v1/files/removeAITags`, but is otherwise the same
         * as [FileServiceAsync.removeAiTags].
         */
        fun removeAiTags(
            params: FileRemoveAiTagsParams
        ): CompletableFuture<HttpResponseFor<FileRemoveAiTagsResponse>> =
            removeAiTags(params, RequestOptions.none())

        /** @see removeAiTags */
        fun removeAiTags(
            params: FileRemoveAiTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileRemoveAiTagsResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/files/removeTags`, but is otherwise the same as
         * [FileServiceAsync.removeTags].
         */
        fun removeTags(
            params: FileRemoveTagsParams
        ): CompletableFuture<HttpResponseFor<FileRemoveTagsResponse>> =
            removeTags(params, RequestOptions.none())

        /** @see removeTags */
        fun removeTags(
            params: FileRemoveTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileRemoveTagsResponse>>

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
         * [FileServiceAsync.uploadV1].
         */
        fun uploadV1(
            params: FileUploadV1Params
        ): CompletableFuture<HttpResponseFor<FileUploadV1Response>> =
            uploadV1(params, RequestOptions.none())

        /** @see uploadV1 */
        fun uploadV1(
            params: FileUploadV1Params,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileUploadV1Response>>

        /**
         * Returns a raw HTTP response for `post /api/v2/files/upload`, but is otherwise the same as
         * [FileServiceAsync.uploadV2].
         */
        fun uploadV2(
            params: FileUploadV2Params
        ): CompletableFuture<HttpResponseFor<FileUploadV2Response>> =
            uploadV2(params, RequestOptions.none())

        /** @see uploadV2 */
        fun uploadV2(
            params: FileUploadV2Params,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileUploadV2Response>>
    }
}
