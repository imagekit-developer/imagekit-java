// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.blocking

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
import io.imagekit.io.models.custommetadatafields.CustomMetadataField
import io.imagekit.io.models.custommetadatafields.CustomMetadataFieldCreateParams
import io.imagekit.io.models.custommetadatafields.CustomMetadataFieldDeleteParams
import io.imagekit.io.models.custommetadatafields.CustomMetadataFieldDeleteResponse
import io.imagekit.io.models.custommetadatafields.CustomMetadataFieldListParams
import io.imagekit.io.models.custommetadatafields.CustomMetadataFieldUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CustomMetadataFieldServiceImpl
internal constructor(private val clientOptions: ClientOptions) : CustomMetadataFieldService {

    private val withRawResponse: CustomMetadataFieldService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CustomMetadataFieldService.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): CustomMetadataFieldService =
        CustomMetadataFieldServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: CustomMetadataFieldCreateParams,
        requestOptions: RequestOptions,
    ): CustomMetadataField =
        // post /v1/customMetadataFields
        withRawResponse().create(params, requestOptions).parse()

    override fun update(
        params: CustomMetadataFieldUpdateParams,
        requestOptions: RequestOptions,
    ): CustomMetadataField =
        // patch /v1/customMetadataFields/{id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: CustomMetadataFieldListParams,
        requestOptions: RequestOptions,
    ): List<CustomMetadataField> =
        // get /v1/customMetadataFields
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: CustomMetadataFieldDeleteParams,
        requestOptions: RequestOptions,
    ): CustomMetadataFieldDeleteResponse =
        // delete /v1/customMetadataFields/{id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CustomMetadataFieldService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CustomMetadataFieldService.WithRawResponse =
            CustomMetadataFieldServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<CustomMetadataField> =
            jsonHandler<CustomMetadataField>(clientOptions.jsonMapper)

        override fun create(
            params: CustomMetadataFieldCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CustomMetadataField> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "customMetadataFields")
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

        private val updateHandler: Handler<CustomMetadataField> =
            jsonHandler<CustomMetadataField>(clientOptions.jsonMapper)

        override fun update(
            params: CustomMetadataFieldUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CustomMetadataField> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "customMetadataFields", params._pathParam(0))
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

        private val listHandler: Handler<List<CustomMetadataField>> =
            jsonHandler<List<CustomMetadataField>>(clientOptions.jsonMapper)

        override fun list(
            params: CustomMetadataFieldListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<CustomMetadataField>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "customMetadataFields")
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

        private val deleteHandler: Handler<CustomMetadataFieldDeleteResponse> =
            jsonHandler<CustomMetadataFieldDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: CustomMetadataFieldDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CustomMetadataFieldDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "customMetadataFields", params._pathParam(0))
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
    }
}
