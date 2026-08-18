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
import io.imagekit.models.aifiltersearch.AiFilterSearchCreateParams
import io.imagekit.models.aifiltersearch.AiFilterSearchCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class AiFilterSearchServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : AiFilterSearchServiceAsync {

    private val withRawResponse: AiFilterSearchServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AiFilterSearchServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): AiFilterSearchServiceAsync =
        AiFilterSearchServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: AiFilterSearchCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AiFilterSearchCreateResponse> =
        // post /v1/ai-filter-search
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AiFilterSearchServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AiFilterSearchServiceAsync.WithRawResponse =
            AiFilterSearchServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<AiFilterSearchCreateResponse> =
            jsonHandler<AiFilterSearchCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: AiFilterSearchCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AiFilterSearchCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "ai-filter-search")
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
    }
}
