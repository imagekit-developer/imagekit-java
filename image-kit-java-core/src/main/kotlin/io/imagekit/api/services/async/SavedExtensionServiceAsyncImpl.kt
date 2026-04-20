// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.async

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
import io.imagekit.api.models.SavedExtension
import io.imagekit.api.models.savedextensions.SavedExtensionCreateParams
import io.imagekit.api.models.savedextensions.SavedExtensionDeleteParams
import io.imagekit.api.models.savedextensions.SavedExtensionGetParams
import io.imagekit.api.models.savedextensions.SavedExtensionListParams
import io.imagekit.api.models.savedextensions.SavedExtensionUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SavedExtensionServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : SavedExtensionServiceAsync {

    private val withRawResponse: SavedExtensionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SavedExtensionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): SavedExtensionServiceAsync =
        SavedExtensionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: SavedExtensionCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SavedExtension> =
        // post /v1/saved-extensions
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: SavedExtensionUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SavedExtension> =
        // patch /v1/saved-extensions/{id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: SavedExtensionListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<SavedExtension>> =
        // get /v1/saved-extensions
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: SavedExtensionDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // delete /v1/saved-extensions/{id}
        withRawResponse().delete(params, requestOptions).thenAccept {}

    override fun get(
        params: SavedExtensionGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SavedExtension> =
        // get /v1/saved-extensions/{id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SavedExtensionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SavedExtensionServiceAsync.WithRawResponse =
            SavedExtensionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<SavedExtension> =
            jsonHandler<SavedExtension>(clientOptions.jsonMapper)

        override fun create(
            params: SavedExtensionCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SavedExtension>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "saved-extensions")
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

        private val updateHandler: Handler<SavedExtension> =
            jsonHandler<SavedExtension>(clientOptions.jsonMapper)

        override fun update(
            params: SavedExtensionUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SavedExtension>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "saved-extensions", params._pathParam(0))
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

        private val listHandler: Handler<List<SavedExtension>> =
            jsonHandler<List<SavedExtension>>(clientOptions.jsonMapper)

        override fun list(
            params: SavedExtensionListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<SavedExtension>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "saved-extensions")
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
            params: SavedExtensionDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "saved-extensions", params._pathParam(0))
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

        private val getHandler: Handler<SavedExtension> =
            jsonHandler<SavedExtension>(clientOptions.jsonMapper)

        override fun get(
            params: SavedExtensionGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SavedExtension>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "saved-extensions", params._pathParam(0))
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
