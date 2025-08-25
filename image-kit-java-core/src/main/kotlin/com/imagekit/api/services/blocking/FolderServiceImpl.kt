// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

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
import com.imagekit.api.core.prepare
import com.imagekit.api.models.folders.AsyncBulkJobResponse
import com.imagekit.api.models.folders.FolderCopyParams
import com.imagekit.api.models.folders.FolderCreateParams
import com.imagekit.api.models.folders.FolderCreateResponse
import com.imagekit.api.models.folders.FolderDeleteParams
import com.imagekit.api.models.folders.FolderDeleteResponse
import com.imagekit.api.models.folders.FolderMoveParams
import com.imagekit.api.models.folders.FolderRenameParams
import com.imagekit.api.services.blocking.folders.JobService
import com.imagekit.api.services.blocking.folders.JobServiceImpl
import java.util.function.Consumer

class FolderServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    FolderService {

    private val withRawResponse: FolderService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val job: JobService by lazy { JobServiceImpl(clientOptions) }

    override fun withRawResponse(): FolderService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FolderService =
        FolderServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun job(): JobService = job

    override fun create(
        params: FolderCreateParams,
        requestOptions: RequestOptions,
    ): FolderCreateResponse =
        // post /v1/folder
        withRawResponse().create(params, requestOptions).parse()

    override fun delete(
        params: FolderDeleteParams,
        requestOptions: RequestOptions,
    ): FolderDeleteResponse =
        // delete /v1/folder
        withRawResponse().delete(params, requestOptions).parse()

    override fun copy(
        params: FolderCopyParams,
        requestOptions: RequestOptions,
    ): AsyncBulkJobResponse =
        // post /v1/bulkJobs/copyFolder
        withRawResponse().copy(params, requestOptions).parse()

    override fun move(
        params: FolderMoveParams,
        requestOptions: RequestOptions,
    ): AsyncBulkJobResponse =
        // post /v1/bulkJobs/moveFolder
        withRawResponse().move(params, requestOptions).parse()

    override fun rename(
        params: FolderRenameParams,
        requestOptions: RequestOptions,
    ): AsyncBulkJobResponse =
        // post /v1/bulkJobs/renameFolder
        withRawResponse().rename(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FolderService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val job: JobService.WithRawResponse by lazy {
            JobServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FolderService.WithRawResponse =
            FolderServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun job(): JobService.WithRawResponse = job

        private val createHandler: Handler<FolderCreateResponse> =
            jsonHandler<FolderCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: FolderCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FolderCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "folder")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val deleteHandler: Handler<FolderDeleteResponse> =
            jsonHandler<FolderDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: FolderDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FolderDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "folder")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val copyHandler: Handler<AsyncBulkJobResponse> =
            jsonHandler<AsyncBulkJobResponse>(clientOptions.jsonMapper)

        override fun copy(
            params: FolderCopyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AsyncBulkJobResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "bulkJobs", "copyFolder")
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

        private val moveHandler: Handler<AsyncBulkJobResponse> =
            jsonHandler<AsyncBulkJobResponse>(clientOptions.jsonMapper)

        override fun move(
            params: FolderMoveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AsyncBulkJobResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "bulkJobs", "moveFolder")
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

        private val renameHandler: Handler<AsyncBulkJobResponse> =
            jsonHandler<AsyncBulkJobResponse>(clientOptions.jsonMapper)

        override fun rename(
            params: FolderRenameParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AsyncBulkJobResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "bulkJobs", "renameFolder")
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
    }
}
