// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.blocking.cache

import io.imagekit.io.core.ClientOptions
import io.imagekit.io.core.RequestOptions
import io.imagekit.io.core.checkRequired
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
import io.imagekit.io.models.cache.invalidation.InvalidationCreateParams
import io.imagekit.io.models.cache.invalidation.InvalidationCreateResponse
import io.imagekit.io.models.cache.invalidation.InvalidationGetParams
import io.imagekit.io.models.cache.invalidation.InvalidationGetResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class InvalidationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    InvalidationService {

    private val withRawResponse: InvalidationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): InvalidationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvalidationService =
        InvalidationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: InvalidationCreateParams,
        requestOptions: RequestOptions,
    ): InvalidationCreateResponse =
        // post /v1/files/purge
        withRawResponse().create(params, requestOptions).parse()

    override fun get(
        params: InvalidationGetParams,
        requestOptions: RequestOptions,
    ): InvalidationGetResponse =
        // get /v1/files/purge/{requestId}
        withRawResponse().get(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InvalidationService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InvalidationService.WithRawResponse =
            InvalidationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<InvalidationCreateResponse> =
            jsonHandler<InvalidationCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: InvalidationCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvalidationCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "purge")
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

        private val getHandler: Handler<InvalidationGetResponse> =
            jsonHandler<InvalidationGetResponse>(clientOptions.jsonMapper)

        override fun get(
            params: InvalidationGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvalidationGetResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("requestId", params.requestId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "purge", params._pathParam(0))
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
