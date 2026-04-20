// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.async

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
import io.imagekit.io.core.prepareAsync
import io.imagekit.io.models.custommetadatafields.CustomMetadataField
import io.imagekit.io.models.custommetadatafields.CustomMetadataFieldCreateParams
import io.imagekit.io.models.custommetadatafields.CustomMetadataFieldDeleteParams
import io.imagekit.io.models.custommetadatafields.CustomMetadataFieldDeleteResponse
import io.imagekit.io.models.custommetadatafields.CustomMetadataFieldListParams
import io.imagekit.io.models.custommetadatafields.CustomMetadataFieldUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CustomMetadataFieldServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : CustomMetadataFieldServiceAsync {

    private val withRawResponse: CustomMetadataFieldServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CustomMetadataFieldServiceAsync.WithRawResponse =
        withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): CustomMetadataFieldServiceAsync =
        CustomMetadataFieldServiceAsyncImpl(
            clientOptions.toBuilder().apply(modifier::accept).build()
        )

    override fun create(
        params: CustomMetadataFieldCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CustomMetadataField> =
        // post /v1/customMetadataFields
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: CustomMetadataFieldUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CustomMetadataField> =
        // patch /v1/customMetadataFields/{id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: CustomMetadataFieldListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<CustomMetadataField>> =
        // get /v1/customMetadataFields
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: CustomMetadataFieldDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CustomMetadataFieldDeleteResponse> =
        // delete /v1/customMetadataFields/{id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CustomMetadataFieldServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CustomMetadataFieldServiceAsync.WithRawResponse =
            CustomMetadataFieldServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<CustomMetadataField> =
            jsonHandler<CustomMetadataField>(clientOptions.jsonMapper)

        override fun create(
            params: CustomMetadataFieldCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomMetadataField>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "customMetadataFields")
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

        private val updateHandler: Handler<CustomMetadataField> =
            jsonHandler<CustomMetadataField>(clientOptions.jsonMapper)

        override fun update(
            params: CustomMetadataFieldUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomMetadataField>> {
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

        private val listHandler: Handler<List<CustomMetadataField>> =
            jsonHandler<List<CustomMetadataField>>(clientOptions.jsonMapper)

        override fun list(
            params: CustomMetadataFieldListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<CustomMetadataField>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "customMetadataFields")
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

        private val deleteHandler: Handler<CustomMetadataFieldDeleteResponse> =
            jsonHandler<CustomMetadataFieldDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: CustomMetadataFieldDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldDeleteResponse>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
