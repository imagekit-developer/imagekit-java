// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.files

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
import com.imagekit.api.core.http.parseable
import com.imagekit.api.core.prepareAsync
import com.imagekit.api.models.files.metadata.MetadataFromUrlParams
import com.imagekit.api.models.files.metadata.MetadataFromUrlResponse
import com.imagekit.api.models.files.metadata.MetadataRetrieveParams
import com.imagekit.api.models.files.metadata.MetadataRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class MetadataServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    MetadataServiceAsync {

    private val withRawResponse: MetadataServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MetadataServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MetadataServiceAsync =
        MetadataServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: MetadataRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MetadataRetrieveResponse> =
        // get /v1/files/{fileId}/metadata
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun fromUrl(
        params: MetadataFromUrlParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MetadataFromUrlResponse> =
        // get /v1/files/metadata
        withRawResponse().fromUrl(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MetadataServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MetadataServiceAsync.WithRawResponse =
            MetadataServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<MetadataRetrieveResponse> =
            jsonHandler<MetadataRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: MetadataRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MetadataRetrieveResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", params._pathParam(0), "metadata")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val fromUrlHandler: Handler<MetadataFromUrlResponse> =
            jsonHandler<MetadataFromUrlResponse>(clientOptions.jsonMapper)

        override fun fromUrl(
            params: MetadataFromUrlParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MetadataFromUrlResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "metadata")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { fromUrlHandler.handle(it) }
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
