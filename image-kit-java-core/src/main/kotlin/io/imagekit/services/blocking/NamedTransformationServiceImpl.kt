// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.checkRequired
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
import io.imagekit.core.prepare
import io.imagekit.models.NamedTransformation
import io.imagekit.models.namedtransformations.NamedTransformationCreateParams
import io.imagekit.models.namedtransformations.NamedTransformationDeleteParams
import io.imagekit.models.namedtransformations.NamedTransformationDeleteResponse
import io.imagekit.models.namedtransformations.NamedTransformationGetParams
import io.imagekit.models.namedtransformations.NamedTransformationListParams
import io.imagekit.models.namedtransformations.NamedTransformationUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class NamedTransformationServiceImpl
internal constructor(private val clientOptions: ClientOptions) : NamedTransformationService {

    private val withRawResponse: NamedTransformationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): NamedTransformationService.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): NamedTransformationService =
        NamedTransformationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: NamedTransformationCreateParams,
        requestOptions: RequestOptions,
    ): NamedTransformation =
        // post /v1/named-transformations
        withRawResponse().create(params, requestOptions).parse()

    override fun update(
        params: NamedTransformationUpdateParams,
        requestOptions: RequestOptions,
    ): NamedTransformation =
        // patch /v1/named-transformations/{id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: NamedTransformationListParams,
        requestOptions: RequestOptions,
    ): List<NamedTransformation> =
        // get /v1/named-transformations
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: NamedTransformationDeleteParams,
        requestOptions: RequestOptions,
    ): NamedTransformationDeleteResponse =
        // delete /v1/named-transformations/{id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun get(
        params: NamedTransformationGetParams,
        requestOptions: RequestOptions,
    ): NamedTransformation =
        // get /v1/named-transformations/{id}
        withRawResponse().get(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NamedTransformationService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NamedTransformationService.WithRawResponse =
            NamedTransformationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<NamedTransformation> =
            jsonHandler<NamedTransformation>(clientOptions.jsonMapper)

        override fun create(
            params: NamedTransformationCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamedTransformation> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "named-transformations")
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

        private val updateHandler: Handler<NamedTransformation> =
            jsonHandler<NamedTransformation>(clientOptions.jsonMapper)

        override fun update(
            params: NamedTransformationUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamedTransformation> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "named-transformations", params._pathParam(0))
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

        private val listHandler: Handler<List<NamedTransformation>> =
            jsonHandler<List<NamedTransformation>>(clientOptions.jsonMapper)

        override fun list(
            params: NamedTransformationListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<NamedTransformation>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "named-transformations")
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

        private val deleteHandler: Handler<NamedTransformationDeleteResponse> =
            jsonHandler<NamedTransformationDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: NamedTransformationDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamedTransformationDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "named-transformations", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getHandler: Handler<NamedTransformation> =
            jsonHandler<NamedTransformation>(clientOptions.jsonMapper)

        override fun get(
            params: NamedTransformationGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamedTransformation> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "named-transformations", params._pathParam(0))
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
