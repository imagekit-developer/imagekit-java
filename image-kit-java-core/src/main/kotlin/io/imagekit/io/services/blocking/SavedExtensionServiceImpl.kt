// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.blocking

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
import io.imagekit.io.core.prepare
import io.imagekit.io.models.SavedExtension
import io.imagekit.io.models.savedextensions.SavedExtensionCreateParams
import io.imagekit.io.models.savedextensions.SavedExtensionDeleteParams
import io.imagekit.io.models.savedextensions.SavedExtensionGetParams
import io.imagekit.io.models.savedextensions.SavedExtensionListParams
import io.imagekit.io.models.savedextensions.SavedExtensionUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SavedExtensionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SavedExtensionService {

    private val withRawResponse: SavedExtensionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SavedExtensionService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SavedExtensionService =
        SavedExtensionServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: SavedExtensionCreateParams,
        requestOptions: RequestOptions,
    ): SavedExtension =
        // post /v1/saved-extensions
        withRawResponse().create(params, requestOptions).parse()

    override fun update(
        params: SavedExtensionUpdateParams,
        requestOptions: RequestOptions,
    ): SavedExtension =
        // patch /v1/saved-extensions/{id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: SavedExtensionListParams,
        requestOptions: RequestOptions,
    ): List<SavedExtension> =
        // get /v1/saved-extensions
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: SavedExtensionDeleteParams, requestOptions: RequestOptions) {
        // delete /v1/saved-extensions/{id}
        withRawResponse().delete(params, requestOptions)
    }

    override fun get(
        params: SavedExtensionGetParams,
        requestOptions: RequestOptions,
    ): SavedExtension =
        // get /v1/saved-extensions/{id}
        withRawResponse().get(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SavedExtensionService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SavedExtensionService.WithRawResponse =
            SavedExtensionServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<SavedExtension> =
            jsonHandler<SavedExtension>(clientOptions.jsonMapper)

        override fun create(
            params: SavedExtensionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SavedExtension> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "saved-extensions")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<SavedExtension> =
            jsonHandler<SavedExtension>(clientOptions.jsonMapper)

        override fun update(
            params: SavedExtensionUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SavedExtension> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<List<SavedExtension>> =
            jsonHandler<List<SavedExtension>>(clientOptions.jsonMapper)

        override fun list(
            params: SavedExtensionListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<SavedExtension>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "saved-extensions")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: SavedExtensionDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val getHandler: Handler<SavedExtension> =
            jsonHandler<SavedExtension>(clientOptions.jsonMapper)

        override fun get(
            params: SavedExtensionGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SavedExtension> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "saved-extensions", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
