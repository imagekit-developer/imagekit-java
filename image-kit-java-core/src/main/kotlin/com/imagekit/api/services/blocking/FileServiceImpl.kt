// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.handlers.emptyHandler
import com.imagekit.api.core.handlers.errorBodyHandler
import com.imagekit.api.core.handlers.errorHandler
import com.imagekit.api.core.handlers.jsonHandler
import com.imagekit.api.core.http.HttpMethod
import com.imagekit.api.core.http.HttpRequest
import com.imagekit.api.core.http.HttpResponse
import com.imagekit.api.core.http.HttpResponse.Handler
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.core.http.json
import com.imagekit.api.core.http.multipartFormData
import com.imagekit.api.core.http.parseable
import com.imagekit.api.core.prepare
import com.imagekit.api.models.files.FileCopyParams
import com.imagekit.api.models.files.FileCopyResponse
import com.imagekit.api.models.files.FileDeleteParams
import com.imagekit.api.models.files.FileGetParams
import com.imagekit.api.models.files.FileGetResponse
import com.imagekit.api.models.files.FileMoveParams
import com.imagekit.api.models.files.FileMoveResponse
import com.imagekit.api.models.files.FileRenameParams
import com.imagekit.api.models.files.FileRenameResponse
import com.imagekit.api.models.files.FileUpdateParams
import com.imagekit.api.models.files.FileUpdateResponse
import com.imagekit.api.models.files.FileUploadParams
import com.imagekit.api.models.files.FileUploadResponse
import com.imagekit.api.services.blocking.files.BulkService
import com.imagekit.api.services.blocking.files.BulkServiceImpl
import com.imagekit.api.services.blocking.files.MetadataService
import com.imagekit.api.services.blocking.files.MetadataServiceImpl
import com.imagekit.api.services.blocking.files.VersionService
import com.imagekit.api.services.blocking.files.VersionServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class FileServiceImpl internal constructor(private val clientOptions: ClientOptions) : FileService {

    private val withRawResponse: FileService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val bulk: BulkService by lazy { BulkServiceImpl(clientOptions) }

    private val versions: VersionService by lazy { VersionServiceImpl(clientOptions) }

    private val metadata: MetadataService by lazy { MetadataServiceImpl(clientOptions) }

    override fun withRawResponse(): FileService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService =
        FileServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun bulk(): BulkService = bulk

    override fun versions(): VersionService = versions

    override fun metadata(): MetadataService = metadata

    override fun update(
        params: FileUpdateParams,
        requestOptions: RequestOptions,
    ): FileUpdateResponse =
        // patch /v1/files/{fileId}/details
        withRawResponse().update(params, requestOptions).parse()

    override fun delete(params: FileDeleteParams, requestOptions: RequestOptions) {
        // delete /v1/files/{fileId}
        withRawResponse().delete(params, requestOptions)
    }

    override fun copy(params: FileCopyParams, requestOptions: RequestOptions): FileCopyResponse =
        // post /v1/files/copy
        withRawResponse().copy(params, requestOptions).parse()

    override fun get(params: FileGetParams, requestOptions: RequestOptions): FileGetResponse =
        // get /v1/files/{fileId}/details
        withRawResponse().get(params, requestOptions).parse()

    override fun move(params: FileMoveParams, requestOptions: RequestOptions): FileMoveResponse =
        // post /v1/files/move
        withRawResponse().move(params, requestOptions).parse()

    override fun rename(
        params: FileRenameParams,
        requestOptions: RequestOptions,
    ): FileRenameResponse =
        // put /v1/files/rename
        withRawResponse().rename(params, requestOptions).parse()

    override fun upload(
        params: FileUploadParams,
        requestOptions: RequestOptions,
    ): FileUploadResponse =
        // post /api/v1/files/upload
        withRawResponse().upload(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val bulk: BulkService.WithRawResponse by lazy {
            BulkServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val versions: VersionService.WithRawResponse by lazy {
            VersionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val metadata: MetadataService.WithRawResponse by lazy {
            MetadataServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FileService.WithRawResponse =
            FileServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun bulk(): BulkService.WithRawResponse = bulk

        override fun versions(): VersionService.WithRawResponse = versions

        override fun metadata(): MetadataService.WithRawResponse = metadata

        private val updateHandler: Handler<FileUpdateResponse> =
            jsonHandler<FileUpdateResponse>(clientOptions.jsonMapper)

        override fun update(
            params: FileUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", params._pathParam(0), "details")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val copyHandler: Handler<FileCopyResponse> =
            jsonHandler<FileCopyResponse>(clientOptions.jsonMapper)

        override fun copy(
            params: FileCopyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileCopyResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "copy")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { copyHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getHandler: Handler<FileGetResponse> =
            jsonHandler<FileGetResponse>(clientOptions.jsonMapper)

        override fun get(
            params: FileGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileGetResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", params._pathParam(0), "details")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val moveHandler: Handler<FileMoveResponse> =
            jsonHandler<FileMoveResponse>(clientOptions.jsonMapper)

        override fun move(
            params: FileMoveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileMoveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "move")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { moveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val renameHandler: Handler<FileRenameResponse> =
            jsonHandler<FileRenameResponse>(clientOptions.jsonMapper)

        override fun rename(
            params: FileRenameParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileRenameResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "rename")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { renameHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val uploadHandler: Handler<FileUploadResponse> =
            jsonHandler<FileUploadResponse>(clientOptions.jsonMapper)

        override fun upload(
            params: FileUploadParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileUploadResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(
                        if (clientOptions.baseUrlOverridden()) clientOptions.baseUrl()
                        else "https://upload.imagekit.io"
                    )
                    .addPathSegments("api", "v1", "files", "upload")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { uploadHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
