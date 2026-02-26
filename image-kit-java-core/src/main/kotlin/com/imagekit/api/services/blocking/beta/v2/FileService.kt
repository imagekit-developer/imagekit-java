// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.beta.v2

import com.google.errorprone.annotations.MustBeClosed
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.beta.v2.files.FileUploadParams
import com.imagekit.api.models.beta.v2.files.FileUploadResponse
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

    /**
     * The V2 API enhances security by verifying the entire payload using JWT. This API is in beta.
     *
     * ImageKit.io allows you to upload files directly from both the server and client sides. For
     * server-side uploads, private API key authentication is used. For client-side uploads,
     * generate a one-time `token` from your secure backend using private API.
     * [Learn more](/docs/api-reference/upload-file/upload-file-v2#how-to-implement-secure-client-side-file-upload)
     * about how to implement secure client-side file upload.
     *
     * **File size limit** \ On the free plan, the maximum upload file sizes are 25MB for images,
     * audio, and raw files, and 100MB for videos. On the Lite paid plan, these limits increase to
     * 40MB for images, audio, and raw files and 300MB for videos, whereas on the Pro paid plan,
     * these limits increase to 50MB for images, audio, and raw files and 2GB for videos. These
     * limits can be further increased with enterprise plans.
     *
     * **Version limit** \ A file can have a maximum of 100 versions.
     *
     * **Demo applications**
     * - A full-fledged
     *   [upload widget using Uppy](https://github.com/imagekit-samples/uppy-uploader), supporting
     *   file selections from local storage, URL, Dropbox, Google Drive, Instagram, and more.
     * - [Quick start guides](/docs/quick-start-guides) for various frameworks and technologies.
     */
    fun upload(params: FileUploadParams): FileUploadResponse = upload(params, RequestOptions.none())

    /** @see upload */
    fun upload(
        params: FileUploadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileUploadResponse

    /** A view of [FileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v2/files/upload`, but is otherwise the same as
         * [FileService.upload].
         */
        @MustBeClosed
        fun upload(params: FileUploadParams): HttpResponseFor<FileUploadResponse> =
            upload(params, RequestOptions.none())

        /** @see upload */
        @MustBeClosed
        fun upload(
            params: FileUploadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileUploadResponse>
    }
}
