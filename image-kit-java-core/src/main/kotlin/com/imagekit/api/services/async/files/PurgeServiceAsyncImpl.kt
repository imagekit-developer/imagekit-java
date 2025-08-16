// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.files

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
import com.imagekit.api.models.files.purge.PurgeExecuteParams
import com.imagekit.api.models.files.purge.PurgeExecuteResponse
import com.imagekit.api.models.files.purge.PurgeStatusParams
import com.imagekit.api.models.files.purge.PurgeStatusResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class PurgeServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PurgeServiceAsync {

    private val withRawResponse: PurgeServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PurgeServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PurgeServiceAsync =
        PurgeServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun execute(
        params: PurgeExecuteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PurgeExecuteResponse> =
        // post /v1/files/purge
        withRawResponse().execute(params, requestOptions).thenApply { it.parse() }

    override fun status(
        params: PurgeStatusParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PurgeStatusResponse> =
        // get /v1/files/purge/{requestId}
        withRawResponse().status(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PurgeServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PurgeServiceAsync.WithRawResponse =
            PurgeServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val executeHandler: Handler<PurgeExecuteResponse> =
            jsonHandler<PurgeExecuteResponse>(clientOptions.jsonMapper)

        override fun execute(
            params: PurgeExecuteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PurgeExecuteResponse>> {
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
                            .use { executeHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val statusHandler: Handler<PurgeStatusResponse> =
            jsonHandler<PurgeStatusResponse>(clientOptions.jsonMapper)

        override fun status(
            params: PurgeStatusParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PurgeStatusResponse>> {
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
                            .use { statusHandler.handle(it) }
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
