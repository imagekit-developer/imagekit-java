// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.async.accounts

import io.imagekit.io.core.ClientOptions
import io.imagekit.io.core.RequestOptions
import io.imagekit.io.core.checkRequired
import io.imagekit.io.core.handlers.emptyHandler
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
import io.imagekit.io.core.prepareAsync
import io.imagekit.io.models.accounts.origins.OriginCreateParams
import io.imagekit.io.models.accounts.origins.OriginDeleteParams
import io.imagekit.io.models.accounts.origins.OriginGetParams
import io.imagekit.io.models.accounts.origins.OriginListParams
import io.imagekit.io.models.accounts.origins.OriginResponse
import io.imagekit.io.models.accounts.origins.OriginUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OriginServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    OriginServiceAsync {

    private val withRawResponse: OriginServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OriginServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OriginServiceAsync =
        OriginServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: OriginCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OriginResponse> =
        // post /v1/accounts/origins
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: OriginUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OriginResponse> =
        // put /v1/accounts/origins/{id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: OriginListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<OriginResponse>> =
        // get /v1/accounts/origins
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: OriginDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // delete /v1/accounts/origins/{id}
        withRawResponse().delete(params, requestOptions).thenAccept {}

    override fun get(
        params: OriginGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OriginResponse> =
        // get /v1/accounts/origins/{id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OriginServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OriginServiceAsync.WithRawResponse =
            OriginServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<OriginResponse> =
            jsonHandler<OriginResponse>(clientOptions.jsonMapper)

        override fun create(
            params: OriginCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OriginResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "origins")
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

        private val updateHandler: Handler<OriginResponse> =
            jsonHandler<OriginResponse>(clientOptions.jsonMapper)

        override fun update(
            params: OriginUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OriginResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "origins", params._pathParam(0))
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

        private val listHandler: Handler<List<OriginResponse>> =
            jsonHandler<List<OriginResponse>>(clientOptions.jsonMapper)

        override fun list(
            params: OriginListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<OriginResponse>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "origins")
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
            params: OriginDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "origins", params._pathParam(0))
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

        private val getHandler: Handler<OriginResponse> =
            jsonHandler<OriginResponse>(clientOptions.jsonMapper)

        override fun get(
            params: OriginGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OriginResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "origins", params._pathParam(0))
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
