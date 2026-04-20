// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.async.files

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
import io.imagekit.api.core.prepareAsync
import io.imagekit.api.models.files.bulk.BulkAddTagsParams
import io.imagekit.api.models.files.bulk.BulkAddTagsResponse
import io.imagekit.api.models.files.bulk.BulkDeleteParams
import io.imagekit.api.models.files.bulk.BulkDeleteResponse
import io.imagekit.api.models.files.bulk.BulkRemoveAiTagsParams
import io.imagekit.api.models.files.bulk.BulkRemoveAiTagsResponse
import io.imagekit.api.models.files.bulk.BulkRemoveTagsParams
import io.imagekit.api.models.files.bulk.BulkRemoveTagsResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class BulkServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BulkServiceAsync {

    private val withRawResponse: BulkServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkServiceAsync =
        BulkServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BulkDeleteResponse> =
        // post /v1/files/batch/deleteByFileIds
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun addTags(
        params: BulkAddTagsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BulkAddTagsResponse> =
        // post /v1/files/addTags
        withRawResponse().addTags(params, requestOptions).thenApply { it.parse() }

    override fun removeAiTags(
        params: BulkRemoveAiTagsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BulkRemoveAiTagsResponse> =
        // post /v1/files/removeAITags
        withRawResponse().removeAiTags(params, requestOptions).thenApply { it.parse() }

    override fun removeTags(
        params: BulkRemoveTagsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BulkRemoveTagsResponse> =
        // post /v1/files/removeTags
        withRawResponse().removeTags(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BulkServiceAsync.WithRawResponse =
            BulkServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val deleteHandler: Handler<BulkDeleteResponse> =
            jsonHandler<BulkDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: BulkDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BulkDeleteResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "batch", "deleteByFileIds")
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

        private val addTagsHandler: Handler<BulkAddTagsResponse> =
            jsonHandler<BulkAddTagsResponse>(clientOptions.jsonMapper)

        override fun addTags(
            params: BulkAddTagsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BulkAddTagsResponse>> {
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

        private val removeAiTagsHandler: Handler<BulkRemoveAiTagsResponse> =
            jsonHandler<BulkRemoveAiTagsResponse>(clientOptions.jsonMapper)

        override fun removeAiTags(
            params: BulkRemoveAiTagsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BulkRemoveAiTagsResponse>> {
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

        private val removeTagsHandler: Handler<BulkRemoveTagsResponse> =
            jsonHandler<BulkRemoveTagsResponse>(clientOptions.jsonMapper)

        override fun removeTags(
            params: BulkRemoveTagsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BulkRemoveTagsResponse>> {
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
    }
}
