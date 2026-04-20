// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.async.accounts

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
import io.imagekit.io.core.http.parseable
import io.imagekit.io.core.prepareAsync
import io.imagekit.io.models.accounts.usage.UsageGetParams
import io.imagekit.io.models.accounts.usage.UsageGetResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class UsageServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    UsageServiceAsync {

    private val withRawResponse: UsageServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): UsageServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageServiceAsync =
        UsageServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun get(
        params: UsageGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageGetResponse> =
        // get /v1/accounts/usage
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UsageServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UsageServiceAsync.WithRawResponse =
            UsageServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val getHandler: Handler<UsageGetResponse> =
            jsonHandler<UsageGetResponse>(clientOptions.jsonMapper)

        override fun get(
            params: UsageGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageGetResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "usage")
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
