// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.blocking.files

import io.imagekit.api.core.ClientOptions
import io.imagekit.api.core.RequestOptions
import io.imagekit.api.core.handlers.errorBodyHandler
import io.imagekit.api.core.handlers.errorHandler
import io.imagekit.api.core.handlers.jsonHandler
import io.imagekit.api.core.http.HttpMethod
import io.imagekit.api.core.http.HttpRequest
import io.imagekit.api.core.http.HttpResponse
import io.imagekit.api.core.http.HttpResponse.Handler
import io.imagekit.api.core.http.HttpResponseFor
import io.imagekit.api.core.http.json
import io.imagekit.api.core.http.parseable
import io.imagekit.api.core.prepare
import io.imagekit.api.models.files.bulk.BulkAddTagsParams
import io.imagekit.api.models.files.bulk.BulkAddTagsResponse
import io.imagekit.api.models.files.bulk.BulkDeleteParams
import io.imagekit.api.models.files.bulk.BulkDeleteResponse
import io.imagekit.api.models.files.bulk.BulkRemoveAiTagsParams
import io.imagekit.api.models.files.bulk.BulkRemoveAiTagsResponse
import io.imagekit.api.models.files.bulk.BulkRemoveTagsParams
import io.imagekit.api.models.files.bulk.BulkRemoveTagsResponse
import java.util.function.Consumer

class BulkServiceImpl internal constructor(private val clientOptions: ClientOptions) : BulkService {

    private val withRawResponse: BulkService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkService =
        BulkServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions,
    ): BulkDeleteResponse =
        // post /v1/files/batch/deleteByFileIds
        withRawResponse().delete(params, requestOptions).parse()

    override fun addTags(
        params: BulkAddTagsParams,
        requestOptions: RequestOptions,
    ): BulkAddTagsResponse =
        // post /v1/files/addTags
        withRawResponse().addTags(params, requestOptions).parse()

    override fun removeAiTags(
        params: BulkRemoveAiTagsParams,
        requestOptions: RequestOptions,
    ): BulkRemoveAiTagsResponse =
        // post /v1/files/removeAITags
        withRawResponse().removeAiTags(params, requestOptions).parse()

    override fun removeTags(
        params: BulkRemoveTagsParams,
        requestOptions: RequestOptions,
    ): BulkRemoveTagsResponse =
        // post /v1/files/removeTags
        withRawResponse().removeTags(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BulkService.WithRawResponse =
            BulkServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val deleteHandler: Handler<BulkDeleteResponse> =
            jsonHandler<BulkDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: BulkDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "batch", "deleteByFileIds")
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

        private val addTagsHandler: Handler<BulkAddTagsResponse> =
            jsonHandler<BulkAddTagsResponse>(clientOptions.jsonMapper)

        override fun addTags(
            params: BulkAddTagsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkAddTagsResponse> {
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

        private val removeAiTagsHandler: Handler<BulkRemoveAiTagsResponse> =
            jsonHandler<BulkRemoveAiTagsResponse>(clientOptions.jsonMapper)

        override fun removeAiTags(
            params: BulkRemoveAiTagsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkRemoveAiTagsResponse> {
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

        private val removeTagsHandler: Handler<BulkRemoveTagsResponse> =
            jsonHandler<BulkRemoveTagsResponse>(clientOptions.jsonMapper)

        override fun removeTags(
            params: BulkRemoveTagsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkRemoveTagsResponse> {
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
    }
}
