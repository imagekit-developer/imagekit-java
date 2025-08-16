// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

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
import com.imagekit.api.core.prepareAsync
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
import com.imagekit.api.services.async.files.BatchServiceAsyncImpl
import com.imagekit.api.services.async.files.DetailServiceAsync
import com.imagekit.api.services.async.files.DetailServiceAsyncImpl
import com.imagekit.api.services.async.files.MetadataServiceAsync
import com.imagekit.api.services.async.files.MetadataServiceAsyncImpl
import com.imagekit.api.services.async.files.PurgeServiceAsync
import com.imagekit.api.services.async.files.PurgeServiceAsyncImpl
import com.imagekit.api.services.async.files.VersionServiceAsync
import com.imagekit.api.services.async.files.VersionServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class FileServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FileServiceAsync {

    private val withRawResponse: FileServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val details: DetailServiceAsync by lazy { DetailServiceAsyncImpl(clientOptions) }

    private val batch: BatchServiceAsync by lazy { BatchServiceAsyncImpl(clientOptions) }

    private val versions: VersionServiceAsync by lazy { VersionServiceAsyncImpl(clientOptions) }

    private val purge: PurgeServiceAsync by lazy { PurgeServiceAsyncImpl(clientOptions) }

    private val metadata: MetadataServiceAsync by lazy { MetadataServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): FileServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync =
        FileServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun details(): DetailServiceAsync = details

    override fun batch(): BatchServiceAsync = batch

    override fun versions(): VersionServiceAsync = versions

    override fun purge(): PurgeServiceAsync = purge

    override fun metadata(): MetadataServiceAsync = metadata

    override fun list(
        params: FileListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<FileListResponse>> =
        // get /v1/files
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // delete /v1/files/{fileId}
        withRawResponse().delete(params, requestOptions).thenAccept {}

    override fun addTags(
        params: FileAddTagsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileAddTagsResponse> =
        // post /v1/files/addTags
        withRawResponse().addTags(params, requestOptions).thenApply { it.parse() }

    override fun copy(
        params: FileCopyParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileCopyResponse> =
        // post /v1/files/copy
        withRawResponse().copy(params, requestOptions).thenApply { it.parse() }

    override fun move(
        params: FileMoveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileMoveResponse> =
        // post /v1/files/move
        withRawResponse().move(params, requestOptions).thenApply { it.parse() }

    override fun removeAiTags(
        params: FileRemoveAiTagsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileRemoveAiTagsResponse> =
        // post /v1/files/removeAITags
        withRawResponse().removeAiTags(params, requestOptions).thenApply { it.parse() }

    override fun removeTags(
        params: FileRemoveTagsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileRemoveTagsResponse> =
        // post /v1/files/removeTags
        withRawResponse().removeTags(params, requestOptions).thenApply { it.parse() }

    override fun rename(
        params: FileRenameParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileRenameResponse> =
        // put /v1/files/rename
        withRawResponse().rename(params, requestOptions).thenApply { it.parse() }

    override fun uploadV1(
        params: FileUploadV1Params,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileUploadV1Response> =
        // post /api/v1/files/upload
        withRawResponse().uploadV1(params, requestOptions).thenApply { it.parse() }

    override fun uploadV2(
        params: FileUploadV2Params,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileUploadV2Response> =
        // post /api/v2/files/upload
        withRawResponse().uploadV2(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val details: DetailServiceAsync.WithRawResponse by lazy {
            DetailServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val batch: BatchServiceAsync.WithRawResponse by lazy {
            BatchServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val versions: VersionServiceAsync.WithRawResponse by lazy {
            VersionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val purge: PurgeServiceAsync.WithRawResponse by lazy {
            PurgeServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val metadata: MetadataServiceAsync.WithRawResponse by lazy {
            MetadataServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FileServiceAsync.WithRawResponse =
            FileServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun details(): DetailServiceAsync.WithRawResponse = details

        override fun batch(): BatchServiceAsync.WithRawResponse = batch

        override fun versions(): VersionServiceAsync.WithRawResponse = versions

        override fun purge(): PurgeServiceAsync.WithRawResponse = purge

        override fun metadata(): MetadataServiceAsync.WithRawResponse = metadata

        private val listHandler: Handler<List<FileListResponse>> =
            jsonHandler<List<FileListResponse>>(clientOptions.jsonMapper)

        override fun list(
            params: FileListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<FileListResponse>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { deleteHandler.handle(it) }
                    }
                }
        }

        private val addTagsHandler: Handler<FileAddTagsResponse> =
            jsonHandler<FileAddTagsResponse>(clientOptions.jsonMapper)

        override fun addTags(
            params: FileAddTagsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileAddTagsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "addTags")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { addTagsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val copyHandler: Handler<FileCopyResponse> =
            jsonHandler<FileCopyResponse>(clientOptions.jsonMapper)

        override fun copy(
            params: FileCopyParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileCopyResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "copy")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { copyHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val moveHandler: Handler<FileMoveResponse> =
            jsonHandler<FileMoveResponse>(clientOptions.jsonMapper)

        override fun move(
            params: FileMoveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileMoveResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "move")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { moveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val removeAiTagsHandler: Handler<FileRemoveAiTagsResponse> =
            jsonHandler<FileRemoveAiTagsResponse>(clientOptions.jsonMapper)

        override fun removeAiTags(
            params: FileRemoveAiTagsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileRemoveAiTagsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "removeAITags")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { removeAiTagsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val removeTagsHandler: Handler<FileRemoveTagsResponse> =
            jsonHandler<FileRemoveTagsResponse>(clientOptions.jsonMapper)

        override fun removeTags(
            params: FileRemoveTagsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileRemoveTagsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "removeTags")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { removeTagsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val renameHandler: Handler<FileRenameResponse> =
            jsonHandler<FileRenameResponse>(clientOptions.jsonMapper)

        override fun rename(
            params: FileRenameParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileRenameResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "rename")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { renameHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val uploadV1Handler: Handler<FileUploadV1Response> =
            jsonHandler<FileUploadV1Response>(clientOptions.jsonMapper)

        override fun uploadV1(
            params: FileUploadV1Params,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileUploadV1Response>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { uploadV1Handler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val uploadV2Handler: Handler<FileUploadV2Response> =
            jsonHandler<FileUploadV2Response>(clientOptions.jsonMapper)

        override fun uploadV2(
            params: FileUploadV2Params,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileUploadV2Response>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
