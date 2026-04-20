// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.async.accounts

import io.imagekit.api.core.ClientOptions
import io.imagekit.api.core.RequestOptions
import io.imagekit.api.core.checkRequired
import io.imagekit.api.core.handlers.emptyHandler
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
import io.imagekit.api.models.accounts.urlendpoints.UrlEndpointCreateParams
import io.imagekit.api.models.accounts.urlendpoints.UrlEndpointDeleteParams
import io.imagekit.api.models.accounts.urlendpoints.UrlEndpointGetParams
import io.imagekit.api.models.accounts.urlendpoints.UrlEndpointListParams
import io.imagekit.api.models.accounts.urlendpoints.UrlEndpointResponse
import io.imagekit.api.models.accounts.urlendpoints.UrlEndpointUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class UrlEndpointServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    UrlEndpointServiceAsync {

    private val withRawResponse: UrlEndpointServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): UrlEndpointServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): UrlEndpointServiceAsync =
        UrlEndpointServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: UrlEndpointCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UrlEndpointResponse> =
        // post /v1/accounts/url-endpoints
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: UrlEndpointUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UrlEndpointResponse> =
        // put /v1/accounts/url-endpoints/{id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: UrlEndpointListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<UrlEndpointResponse>> =
        // get /v1/accounts/url-endpoints
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: UrlEndpointDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // delete /v1/accounts/url-endpoints/{id}
        withRawResponse().delete(params, requestOptions).thenAccept {}

    override fun get(
        params: UrlEndpointGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UrlEndpointResponse> =
        // get /v1/accounts/url-endpoints/{id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UrlEndpointServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UrlEndpointServiceAsync.WithRawResponse =
            UrlEndpointServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<UrlEndpointResponse> =
            jsonHandler<UrlEndpointResponse>(clientOptions.jsonMapper)

        override fun create(
            params: UrlEndpointCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UrlEndpointResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "url-endpoints")
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

        private val updateHandler: Handler<UrlEndpointResponse> =
            jsonHandler<UrlEndpointResponse>(clientOptions.jsonMapper)

        override fun update(
            params: UrlEndpointUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UrlEndpointResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "url-endpoints", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<List<UrlEndpointResponse>> =
            jsonHandler<List<UrlEndpointResponse>>(clientOptions.jsonMapper)

        override fun list(
            params: UrlEndpointListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<UrlEndpointResponse>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "url-endpoints")
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

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: UrlEndpointDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "url-endpoints", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { deleteHandler.handle(it) }
                    }
                }
        }

        private val getHandler: Handler<UrlEndpointResponse> =
            jsonHandler<UrlEndpointResponse>(clientOptions.jsonMapper)

        override fun get(
            params: UrlEndpointGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UrlEndpointResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "url-endpoints", params._pathParam(0))
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
