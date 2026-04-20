// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.async

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
import io.imagekit.api.core.http.parseable
import io.imagekit.api.core.prepareAsync
import io.imagekit.api.models.assets.AssetListParams
import io.imagekit.api.models.assets.AssetListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class AssetServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AssetServiceAsync {

    private val withRawResponse: AssetServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AssetServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AssetServiceAsync =
        AssetServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: AssetListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<AssetListResponse>> =
        // get /v1/files
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AssetServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AssetServiceAsync.WithRawResponse =
            AssetServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<List<AssetListResponse>> =
            jsonHandler<List<AssetListResponse>>(clientOptions.jsonMapper)

        override fun list(
            params: AssetListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<AssetListResponse>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }
    }
}
