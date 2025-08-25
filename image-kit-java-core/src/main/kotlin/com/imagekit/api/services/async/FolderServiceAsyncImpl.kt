// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.handlers.errorBodyHandler
import com.imagekit.api.core.handlers.errorHandler
import com.imagekit.api.core.handlers.jsonHandler
import com.imagekit.api.core.http.HttpMethod
import com.imagekit.api.core.http.HttpRequest
import com.imagekit.api.core.http.HttpResponse
import com.imagekit.api.core.http.HttpResponse.Handler
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.core.http.json
import com.imagekit.api.core.http.parseable
import com.imagekit.api.core.prepareAsync
import com.imagekit.api.models.folders.FolderCopyParams
import com.imagekit.api.models.folders.FolderCreateParams
import com.imagekit.api.models.folders.FolderCreateResponse
import com.imagekit.api.models.folders.FolderDeleteParams
import com.imagekit.api.models.folders.FolderDeleteResponse
import com.imagekit.api.models.folders.FolderMoveParams
import com.imagekit.api.models.folders.FolderRenameParams
import com.imagekit.api.models.folders.JobResponse
import com.imagekit.api.services.async.folders.JobServiceAsync
import com.imagekit.api.services.async.folders.JobServiceAsyncImpl
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
    ): CompletableFuture<JobResponse> =
        // post /v1/bulkJobs/copyFolder
        withRawResponse().copy(params, requestOptions).thenApply { it.parse() }

    override fun move(
        params: FolderMoveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<JobResponse> =
        // post /v1/bulkJobs/moveFolder
        withRawResponse().move(params, requestOptions).thenApply { it.parse() }

    override fun rename(
        params: FolderRenameParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<JobResponse> =
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

        private val copyHandler: Handler<JobResponse> =
            jsonHandler<JobResponse>(clientOptions.jsonMapper)

        override fun copy(
            params: FolderCopyParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<JobResponse>> {
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

        private val moveHandler: Handler<JobResponse> =
            jsonHandler<JobResponse>(clientOptions.jsonMapper)

        override fun move(
            params: FolderMoveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<JobResponse>> {
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

        private val renameHandler: Handler<JobResponse> =
            jsonHandler<JobResponse>(clientOptions.jsonMapper)

        override fun rename(
            params: FolderRenameParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<JobResponse>> {
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
