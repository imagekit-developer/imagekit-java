// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.blocking

import io.imagekit.io.core.ClientOptions
import io.imagekit.io.core.RequestOptions
import io.imagekit.io.core.handlers.errorBodyHandler
import io.imagekit.io.core.handlers.errorHandler
import io.imagekit.io.core.handlers.jsonHandler
import io.imagekit.io.core.http.HttpMethod
import io.imagekit.io.core.http.HttpRequest
import io.imagekit.io.core.http.HttpResponse
import io.imagekit.io.core.http.HttpResponse.Handler
import io.imagekit.io.core.http.HttpResponseFor
import io.imagekit.io.core.http.json
import io.imagekit.io.core.http.parseable
import io.imagekit.io.core.prepare
import io.imagekit.io.models.folders.FolderCopyParams
import io.imagekit.io.models.folders.FolderCopyResponse
import io.imagekit.io.models.folders.FolderCreateParams
import io.imagekit.io.models.folders.FolderCreateResponse
import io.imagekit.io.models.folders.FolderDeleteParams
import io.imagekit.io.models.folders.FolderDeleteResponse
import io.imagekit.io.models.folders.FolderMoveParams
import io.imagekit.io.models.folders.FolderMoveResponse
import io.imagekit.io.models.folders.FolderRenameParams
import io.imagekit.io.models.folders.FolderRenameResponse
import io.imagekit.io.services.blocking.folders.JobService
import io.imagekit.io.services.blocking.folders.JobServiceImpl
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
    ): FolderCopyResponse =
        // post /v1/bulkJobs/copyFolder
        withRawResponse().copy(params, requestOptions).parse()

    override fun move(
        params: FolderMoveParams,
        requestOptions: RequestOptions,
    ): FolderMoveResponse =
        // post /v1/bulkJobs/moveFolder
        withRawResponse().move(params, requestOptions).parse()

    override fun rename(
        params: FolderRenameParams,
        requestOptions: RequestOptions,
    ): FolderRenameResponse =
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

        private val copyHandler: Handler<FolderCopyResponse> =
            jsonHandler<FolderCopyResponse>(clientOptions.jsonMapper)

        override fun copy(
            params: FolderCopyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FolderCopyResponse> {
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

        private val moveHandler: Handler<FolderMoveResponse> =
            jsonHandler<FolderMoveResponse>(clientOptions.jsonMapper)

        override fun move(
            params: FolderMoveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FolderMoveResponse> {
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

        private val renameHandler: Handler<FolderRenameResponse> =
            jsonHandler<FolderRenameResponse>(clientOptions.jsonMapper)

        override fun rename(
            params: FolderRenameParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FolderRenameResponse> {
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
