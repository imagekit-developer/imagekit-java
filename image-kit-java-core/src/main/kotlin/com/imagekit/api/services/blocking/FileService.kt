// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import com.imagekit.api.services.blocking.files.BatchService
import com.imagekit.api.services.blocking.files.DetailService
import com.imagekit.api.services.blocking.files.MetadataService
import com.imagekit.api.services.blocking.files.PurgeService
import com.imagekit.api.services.blocking.files.VersionService
import java.util.function.Consumer

interface FileService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService

    fun details(): DetailService

    fun batch(): BatchService

    fun versions(): VersionService

    fun purge(): PurgeService

    fun metadata(): MetadataService

    /**
     * This API can list all the uploaded files and folders in your ImageKit.io media library. In
     * addition, you can fine-tune your query by specifying various filters by generating a query
     * string in a Lucene-like syntax and provide this generated string as the value of the
     * `searchQuery`.
     */
    fun list(): List<FileListResponse> = list(FileListParams.none())

    /** @see list */
    fun list(
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<FileListResponse>

    /** @see list */
    fun list(params: FileListParams = FileListParams.none()): List<FileListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): List<FileListResponse> =
        list(FileListParams.none(), requestOptions)

    /**
     * This API deletes the file and all its file versions permanently.
     *
     * Note: If a file or specific transformation has been requested in the past, then the response
     * is cached. Deleting a file does not purge the cache. You can purge the cache using purge
     * cache API.
     */
    fun delete(fileId: String) = delete(fileId, FileDeleteParams.none())

    /** @see delete */
    fun delete(
        fileId: String,
        params: FileDeleteParams = FileDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see delete */
    fun delete(fileId: String, params: FileDeleteParams = FileDeleteParams.none()) =
        delete(fileId, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: FileDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: FileDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(fileId: String, requestOptions: RequestOptions) =
        delete(fileId, FileDeleteParams.none(), requestOptions)

    /**
     * This API adds tags to multiple files in bulk. A maximum of 50 files can be specified at a
     * time.
     */
    fun addTags(params: FileAddTagsParams): FileAddTagsResponse =
        addTags(params, RequestOptions.none())

    /** @see addTags */
    fun addTags(
        params: FileAddTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileAddTagsResponse

    /**
     * This will copy a file from one folder to another.
     *
     * Note: If any file at the destination has the same name as the source file, then the source
     * file and its versions (if `includeFileVersions` is set to true) will be appended to the
     * destination file version history.
     */
    fun copy(params: FileCopyParams): FileCopyResponse = copy(params, RequestOptions.none())

    /** @see copy */
    fun copy(
        params: FileCopyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileCopyResponse

    /**
     * This will move a file and all its versions from one folder to another.
     *
     * Note: If any file at the destination has the same name as the source file, then the source
     * file and its versions will be appended to the destination file.
     */
    fun move(params: FileMoveParams): FileMoveResponse = move(params, RequestOptions.none())

    /** @see move */
    fun move(
        params: FileMoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileMoveResponse

    /**
     * This API removes AITags from multiple files in bulk. A maximum of 50 files can be specified
     * at a time.
     */
    fun removeAiTags(params: FileRemoveAiTagsParams): FileRemoveAiTagsResponse =
        removeAiTags(params, RequestOptions.none())

    /** @see removeAiTags */
    fun removeAiTags(
        params: FileRemoveAiTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileRemoveAiTagsResponse

    /**
     * This API removes tags from multiple files in bulk. A maximum of 50 files can be specified at
     * a time.
     */
    fun removeTags(params: FileRemoveTagsParams): FileRemoveTagsResponse =
        removeTags(params, RequestOptions.none())

    /** @see removeTags */
    fun removeTags(
        params: FileRemoveTagsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileRemoveTagsResponse

    /**
     * You can rename an already existing file in the media library using rename file API. This
     * operation would rename all file versions of the file.
     *
     * Note: The old URLs will stop working. The file/file version URLs cached on CDN will continue
     * to work unless a purge is requested.
     */
    fun rename(params: FileRenameParams): FileRenameResponse = rename(params, RequestOptions.none())

    /** @see rename */
    fun rename(
        params: FileRenameParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileRenameResponse

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
    fun uploadV1(params: FileUploadV1Params): FileUploadV1Response =
        uploadV1(params, RequestOptions.none())

    /** @see uploadV1 */
    fun uploadV1(
        params: FileUploadV1Params,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileUploadV1Response

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
    fun uploadV2(params: FileUploadV2Params): FileUploadV2Response =
        uploadV2(params, RequestOptions.none())

    /** @see uploadV2 */
    fun uploadV2(
        params: FileUploadV2Params,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileUploadV2Response

    /** A view of [FileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService.WithRawResponse

        fun details(): DetailService.WithRawResponse

        fun batch(): BatchService.WithRawResponse

        fun versions(): VersionService.WithRawResponse

        fun purge(): PurgeService.WithRawResponse

        fun metadata(): MetadataService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/files`, but is otherwise the same as
         * [FileService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<List<FileListResponse>> = list(FileListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<FileListResponse>>

        /** @see list */
        @MustBeClosed
        fun list(
            params: FileListParams = FileListParams.none()
        ): HttpResponseFor<List<FileListResponse>> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<List<FileListResponse>> =
            list(FileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/files/{fileId}`, but is otherwise the same as
         * [FileService.delete].
         */
        @MustBeClosed
        fun delete(fileId: String): HttpResponse = delete(fileId, FileDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            fileId: String,
            params: FileDeleteParams = FileDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            fileId: String,
            params: FileDeleteParams = FileDeleteParams.none(),
        ): HttpResponse = delete(fileId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: FileDeleteParams): HttpResponse = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(fileId: String, requestOptions: RequestOptions): HttpResponse =
            delete(fileId, FileDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/files/addTags`, but is otherwise the same as
         * [FileService.addTags].
         */
        @MustBeClosed
        fun addTags(params: FileAddTagsParams): HttpResponseFor<FileAddTagsResponse> =
            addTags(params, RequestOptions.none())

        /** @see addTags */
        @MustBeClosed
        fun addTags(
            params: FileAddTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileAddTagsResponse>

        /**
         * Returns a raw HTTP response for `post /v1/files/copy`, but is otherwise the same as
         * [FileService.copy].
         */
        @MustBeClosed
        fun copy(params: FileCopyParams): HttpResponseFor<FileCopyResponse> =
            copy(params, RequestOptions.none())

        /** @see copy */
        @MustBeClosed
        fun copy(
            params: FileCopyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileCopyResponse>

        /**
         * Returns a raw HTTP response for `post /v1/files/move`, but is otherwise the same as
         * [FileService.move].
         */
        @MustBeClosed
        fun move(params: FileMoveParams): HttpResponseFor<FileMoveResponse> =
            move(params, RequestOptions.none())

        /** @see move */
        @MustBeClosed
        fun move(
            params: FileMoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileMoveResponse>

        /**
         * Returns a raw HTTP response for `post /v1/files/removeAITags`, but is otherwise the same
         * as [FileService.removeAiTags].
         */
        @MustBeClosed
        fun removeAiTags(
            params: FileRemoveAiTagsParams
        ): HttpResponseFor<FileRemoveAiTagsResponse> = removeAiTags(params, RequestOptions.none())

        /** @see removeAiTags */
        @MustBeClosed
        fun removeAiTags(
            params: FileRemoveAiTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileRemoveAiTagsResponse>

        /**
         * Returns a raw HTTP response for `post /v1/files/removeTags`, but is otherwise the same as
         * [FileService.removeTags].
         */
        @MustBeClosed
        fun removeTags(params: FileRemoveTagsParams): HttpResponseFor<FileRemoveTagsResponse> =
            removeTags(params, RequestOptions.none())

        /** @see removeTags */
        @MustBeClosed
        fun removeTags(
            params: FileRemoveTagsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileRemoveTagsResponse>

        /**
         * Returns a raw HTTP response for `put /v1/files/rename`, but is otherwise the same as
         * [FileService.rename].
         */
        @MustBeClosed
        fun rename(params: FileRenameParams): HttpResponseFor<FileRenameResponse> =
            rename(params, RequestOptions.none())

        /** @see rename */
        @MustBeClosed
        fun rename(
            params: FileRenameParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileRenameResponse>

        /**
         * Returns a raw HTTP response for `post /api/v1/files/upload`, but is otherwise the same as
         * [FileService.uploadV1].
         */
        @MustBeClosed
        fun uploadV1(params: FileUploadV1Params): HttpResponseFor<FileUploadV1Response> =
            uploadV1(params, RequestOptions.none())

        /** @see uploadV1 */
        @MustBeClosed
        fun uploadV1(
            params: FileUploadV1Params,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileUploadV1Response>

        /**
         * Returns a raw HTTP response for `post /api/v2/files/upload`, but is otherwise the same as
         * [FileService.uploadV2].
         */
        @MustBeClosed
        fun uploadV2(params: FileUploadV2Params): HttpResponseFor<FileUploadV2Response> =
            uploadV2(params, RequestOptions.none())

        /** @see uploadV2 */
        @MustBeClosed
        fun uploadV2(
            params: FileUploadV2Params,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileUploadV2Response>
    }
}
