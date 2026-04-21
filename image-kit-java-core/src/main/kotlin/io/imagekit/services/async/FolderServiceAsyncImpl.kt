// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.handlers.errorBodyHandler
import io.imagekit.core.handlers.errorHandler
import io.imagekit.core.handlers.jsonHandler
import io.imagekit.core.http.HttpMethod
import io.imagekit.core.http.HttpRequest
import io.imagekit.core.http.HttpResponse
import io.imagekit.core.http.HttpResponse.Handler
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.core.http.json
import io.imagekit.core.http.parseable
import io.imagekit.core.prepareAsync
import io.imagekit.models.folders.FolderCopyParams
import io.imagekit.models.folders.FolderCopyResponse
import io.imagekit.models.folders.FolderCreateParams
import io.imagekit.models.folders.FolderCreateResponse
import io.imagekit.models.folders.FolderDeleteParams
import io.imagekit.models.folders.FolderDeleteResponse
import io.imagekit.models.folders.FolderMoveParams
import io.imagekit.models.folders.FolderMoveResponse
import io.imagekit.models.folders.FolderRenameParams
import io.imagekit.models.folders.FolderRenameResponse
import io.imagekit.services.async.folders.JobServiceAsync
import io.imagekit.services.async.folders.JobServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class FolderServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FolderServiceAsync {

    private val withRawResponse: FolderServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val job: JobServiceAsync by lazy { JobServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): FolderServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FolderServiceAsync =
        FolderServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun job(): JobServiceAsync = job

    override fun create(
        params: FolderCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FolderCreateResponse> =
        // post /v1/folder
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: FolderDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FolderDeleteResponse> =
        // delete /v1/folder
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun copy(
        params: FolderCopyParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FolderCopyResponse> =
        // post /v1/bulkJobs/copyFolder
        withRawResponse().copy(params, requestOptions).thenApply { it.parse() }

    override fun move(
        params: FolderMoveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FolderMoveResponse> =
        // post /v1/bulkJobs/moveFolder
        withRawResponse().move(params, requestOptions).thenApply { it.parse() }

    override fun rename(
        params: FolderRenameParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FolderRenameResponse> =
        // post /v1/bulkJobs/renameFolder
        withRawResponse().rename(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FolderServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val job: JobServiceAsync.WithRawResponse by lazy {
            JobServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FolderServiceAsync.WithRawResponse =
            FolderServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun job(): JobServiceAsync.WithRawResponse = job

        private val createHandler: Handler<FolderCreateResponse> =
            jsonHandler<FolderCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: FolderCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FolderCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "folder")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val deleteHandler: Handler<FolderDeleteResponse> =
            jsonHandler<FolderDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: FolderDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FolderDeleteResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "folder")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { deleteHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val copyHandler: Handler<FolderCopyResponse> =
            jsonHandler<FolderCopyResponse>(clientOptions.jsonMapper)

        override fun copy(
            params: FolderCopyParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FolderCopyResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "bulkJobs", "copyFolder")
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

        private val moveHandler: Handler<FolderMoveResponse> =
            jsonHandler<FolderMoveResponse>(clientOptions.jsonMapper)

        override fun move(
            params: FolderMoveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FolderMoveResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "bulkJobs", "moveFolder")
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

        private val renameHandler: Handler<FolderRenameResponse> =
            jsonHandler<FolderRenameResponse>(clientOptions.jsonMapper)

        override fun rename(
            params: FolderRenameParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FolderRenameResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "bulkJobs", "renameFolder")
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
    }
}
