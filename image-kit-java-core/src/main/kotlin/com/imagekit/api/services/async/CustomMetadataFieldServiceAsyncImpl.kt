// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.checkRequired
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
import com.imagekit.api.core.prepareAsync
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldCreateParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldCreateResponse
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldDeleteParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldDeleteResponse
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldListParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldListResponse
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldUpdateParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldUpdateResponse
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
    ): CompletableFuture<CustomMetadataFieldCreateResponse> =
        // post /v1/customMetadataFields
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: CustomMetadataFieldUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CustomMetadataFieldUpdateResponse> =
        // patch /v1/customMetadataFields/{id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: CustomMetadataFieldListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<CustomMetadataFieldListResponse>> =
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

        private val createHandler: Handler<CustomMetadataFieldCreateResponse> =
            jsonHandler<CustomMetadataFieldCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: CustomMetadataFieldCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldCreateResponse>> {
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

        private val updateHandler: Handler<CustomMetadataFieldUpdateResponse> =
            jsonHandler<CustomMetadataFieldUpdateResponse>(clientOptions.jsonMapper)

        override fun update(
            params: CustomMetadataFieldUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldUpdateResponse>> {
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

        private val listHandler: Handler<List<CustomMetadataFieldListResponse>> =
            jsonHandler<List<CustomMetadataFieldListResponse>>(clientOptions.jsonMapper)

        override fun list(
            params: CustomMetadataFieldListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<CustomMetadataFieldListResponse>>> {
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
