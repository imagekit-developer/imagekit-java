// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.cache

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.checkRequired
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
import com.imagekit.api.models.cache.invalidation.InvalidationCreateParams
import com.imagekit.api.models.cache.invalidation.InvalidationCreateResponse
import com.imagekit.api.models.cache.invalidation.InvalidationGetParams
import com.imagekit.api.models.cache.invalidation.InvalidationGetResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class InvalidationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    InvalidationServiceAsync {

    private val withRawResponse: InvalidationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): InvalidationServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvalidationServiceAsync =
        InvalidationServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: InvalidationCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<InvalidationCreateResponse> =
        // post /v1/files/purge
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun get(
        params: InvalidationGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<InvalidationGetResponse> =
        // get /v1/files/purge/{requestId}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InvalidationServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InvalidationServiceAsync.WithRawResponse =
            InvalidationServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<InvalidationCreateResponse> =
            jsonHandler<InvalidationCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: InvalidationCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InvalidationCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "purge")
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

        private val getHandler: Handler<InvalidationGetResponse> =
            jsonHandler<InvalidationGetResponse>(clientOptions.jsonMapper)

        override fun get(
            params: InvalidationGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InvalidationGetResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("requestId", params.requestId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "purge", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getHandler.handle(it) }
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
