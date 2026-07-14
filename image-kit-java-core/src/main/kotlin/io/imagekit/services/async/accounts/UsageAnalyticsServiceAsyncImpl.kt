// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.accounts

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
import io.imagekit.core.http.parseable
import io.imagekit.core.prepareAsync
import io.imagekit.models.accounts.usageanalytics.UsageAnalyticsGetParams
import io.imagekit.models.accounts.usageanalytics.UsageAnalyticsResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class UsageAnalyticsServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : UsageAnalyticsServiceAsync {

    private val withRawResponse: UsageAnalyticsServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): UsageAnalyticsServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): UsageAnalyticsServiceAsync =
        UsageAnalyticsServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun get(
        params: UsageAnalyticsGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageAnalyticsResponse> =
        // get /v1/accounts/usage-analytics
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UsageAnalyticsServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UsageAnalyticsServiceAsync.WithRawResponse =
            UsageAnalyticsServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val getHandler: Handler<UsageAnalyticsResponse> =
            jsonHandler<UsageAnalyticsResponse>(clientOptions.jsonMapper)

        override fun get(
            params: UsageAnalyticsGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageAnalyticsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "usage-analytics")
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
