// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.accounts

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.handlers.emptyHandler
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
import com.imagekit.api.core.prepare
import com.imagekit.api.models.accounts.origins.OriginCreateParams
import com.imagekit.api.models.accounts.origins.OriginDeleteParams
import com.imagekit.api.models.accounts.origins.OriginGetParams
import com.imagekit.api.models.accounts.origins.OriginListParams
import com.imagekit.api.models.accounts.origins.OriginResponse
import com.imagekit.api.models.accounts.origins.OriginUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OriginServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OriginService {

    private val withRawResponse: OriginService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OriginService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OriginService =
        OriginServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: OriginCreateParams,
        requestOptions: RequestOptions,
    ): OriginResponse =
        // post /v1/accounts/origins
        withRawResponse().create(params, requestOptions).parse()

    override fun update(
        params: OriginUpdateParams,
        requestOptions: RequestOptions,
    ): OriginResponse =
        // put /v1/accounts/origins/{id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: OriginListParams,
        requestOptions: RequestOptions,
    ): List<OriginResponse> =
        // get /v1/accounts/origins
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: OriginDeleteParams, requestOptions: RequestOptions) {
        // delete /v1/accounts/origins/{id}
        withRawResponse().delete(params, requestOptions)
    }

    override fun get(params: OriginGetParams, requestOptions: RequestOptions): OriginResponse =
        // get /v1/accounts/origins/{id}
        withRawResponse().get(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OriginService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OriginService.WithRawResponse =
            OriginServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<OriginResponse> =
            jsonHandler<OriginResponse>(clientOptions.jsonMapper)

        override fun create(
            params: OriginCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OriginResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "origins")
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

        private val updateHandler: Handler<OriginResponse> =
            jsonHandler<OriginResponse>(clientOptions.jsonMapper)

        override fun update(
            params: OriginUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OriginResponse> {
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

        private val listHandler: Handler<List<OriginResponse>> =
            jsonHandler<List<OriginResponse>>(clientOptions.jsonMapper)

        override fun list(
            params: OriginListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<OriginResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "origins")
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
            params: OriginDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val getHandler: Handler<OriginResponse> =
            jsonHandler<OriginResponse>(clientOptions.jsonMapper)

        override fun get(
            params: OriginGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OriginResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "accounts", "origins", params._pathParam(0))
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
