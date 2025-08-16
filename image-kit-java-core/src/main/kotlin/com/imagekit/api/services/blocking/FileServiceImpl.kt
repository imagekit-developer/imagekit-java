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
import com.imagekit.api.services.blocking.files.BatchServiceImpl
import com.imagekit.api.services.blocking.files.DetailService
import com.imagekit.api.services.blocking.files.DetailServiceImpl
import com.imagekit.api.services.blocking.files.MetadataService
import com.imagekit.api.services.blocking.files.MetadataServiceImpl
import com.imagekit.api.services.blocking.files.PurgeService
import com.imagekit.api.services.blocking.files.PurgeServiceImpl
import com.imagekit.api.services.blocking.files.VersionService
import com.imagekit.api.services.blocking.files.VersionServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class FileServiceImpl internal constructor(private val clientOptions: ClientOptions) : FileService {

    private val withRawResponse: FileService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val details: DetailService by lazy { DetailServiceImpl(clientOptions) }

    private val batch: BatchService by lazy { BatchServiceImpl(clientOptions) }

    private val versions: VersionService by lazy { VersionServiceImpl(clientOptions) }

    private val purge: PurgeService by lazy { PurgeServiceImpl(clientOptions) }

    private val metadata: MetadataService by lazy { MetadataServiceImpl(clientOptions) }

    override fun withRawResponse(): FileService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService =
        FileServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun details(): DetailService = details

    override fun batch(): BatchService = batch

    override fun versions(): VersionService = versions

    override fun purge(): PurgeService = purge

    override fun metadata(): MetadataService = metadata

    override fun list(
        params: FileListParams,
        requestOptions: RequestOptions,
    ): List<FileListResponse> =
        // get /v1/files
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: FileDeleteParams, requestOptions: RequestOptions) {
        // delete /v1/files/{fileId}
        withRawResponse().delete(params, requestOptions)
    }

    override fun addTags(
        params: FileAddTagsParams,
        requestOptions: RequestOptions,
    ): FileAddTagsResponse =
        // post /v1/files/addTags
        withRawResponse().addTags(params, requestOptions).parse()

    override fun copy(params: FileCopyParams, requestOptions: RequestOptions): FileCopyResponse =
        // post /v1/files/copy
        withRawResponse().copy(params, requestOptions).parse()

    override fun move(params: FileMoveParams, requestOptions: RequestOptions): FileMoveResponse =
        // post /v1/files/move
        withRawResponse().move(params, requestOptions).parse()

    override fun removeAiTags(
        params: FileRemoveAiTagsParams,
        requestOptions: RequestOptions,
    ): FileRemoveAiTagsResponse =
        // post /v1/files/removeAITags
        withRawResponse().removeAiTags(params, requestOptions).parse()

    override fun removeTags(
        params: FileRemoveTagsParams,
        requestOptions: RequestOptions,
    ): FileRemoveTagsResponse =
        // post /v1/files/removeTags
        withRawResponse().removeTags(params, requestOptions).parse()

    override fun rename(
        params: FileRenameParams,
        requestOptions: RequestOptions,
    ): FileRenameResponse =
        // put /v1/files/rename
        withRawResponse().rename(params, requestOptions).parse()

    override fun uploadV1(
        params: FileUploadV1Params,
        requestOptions: RequestOptions,
    ): FileUploadV1Response =
        // post /api/v1/files/upload
        withRawResponse().uploadV1(params, requestOptions).parse()

    override fun uploadV2(
        params: FileUploadV2Params,
        requestOptions: RequestOptions,
    ): FileUploadV2Response =
        // post /api/v2/files/upload
        withRawResponse().uploadV2(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val details: DetailService.WithRawResponse by lazy {
            DetailServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val batch: BatchService.WithRawResponse by lazy {
            BatchServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val versions: VersionService.WithRawResponse by lazy {
            VersionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val purge: PurgeService.WithRawResponse by lazy {
            PurgeServiceImpl.WithRawResponseImpl(clientOptions)
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

        override fun details(): DetailService.WithRawResponse = details

        override fun batch(): BatchService.WithRawResponse = batch

        override fun versions(): VersionService.WithRawResponse = versions

        override fun purge(): PurgeService.WithRawResponse = purge

        override fun metadata(): MetadataService.WithRawResponse = metadata

        private val listHandler: Handler<List<FileListResponse>> =
            jsonHandler<List<FileListResponse>>(clientOptions.jsonMapper)

        override fun list(
            params: FileListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<FileListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
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

        private val addTagsHandler: Handler<FileAddTagsResponse> =
            jsonHandler<FileAddTagsResponse>(clientOptions.jsonMapper)

        override fun addTags(
            params: FileAddTagsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileAddTagsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "addTags")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { addTagsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
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

        private val removeAiTagsHandler: Handler<FileRemoveAiTagsResponse> =
            jsonHandler<FileRemoveAiTagsResponse>(clientOptions.jsonMapper)

        override fun removeAiTags(
            params: FileRemoveAiTagsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileRemoveAiTagsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "removeAITags")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { removeAiTagsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val removeTagsHandler: Handler<FileRemoveTagsResponse> =
            jsonHandler<FileRemoveTagsResponse>(clientOptions.jsonMapper)

        override fun removeTags(
            params: FileRemoveTagsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileRemoveTagsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "removeTags")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { removeTagsHandler.handle(it) }
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

        private val uploadV1Handler: Handler<FileUploadV1Response> =
            jsonHandler<FileUploadV1Response>(clientOptions.jsonMapper)

        override fun uploadV1(
            params: FileUploadV1Params,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileUploadV1Response> {
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
                    .use { uploadV1Handler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val uploadV2Handler: Handler<FileUploadV2Response> =
            jsonHandler<FileUploadV2Response>(clientOptions.jsonMapper)

        override fun uploadV2(
            params: FileUploadV2Params,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileUploadV2Response> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(
                        if (clientOptions.baseUrlOverridden()) clientOptions.baseUrl()
                        else "https://upload.imagekit.io"
                    )
                    .addPathSegments("api", "v2", "files", "upload")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { uploadV2Handler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
