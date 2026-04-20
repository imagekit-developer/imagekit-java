// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.async.files

import io.imagekit.api.core.ClientOptions
import io.imagekit.api.core.RequestOptions
import io.imagekit.api.core.checkRequired
import io.imagekit.api.core.handlers.errorBodyHandler
import io.imagekit.api.core.handlers.errorHandler
import io.imagekit.api.core.handlers.jsonHandler
import io.imagekit.api.core.http.HttpMethod
import io.imagekit.api.core.http.HttpRequest
import io.imagekit.api.core.http.HttpResponse
import io.imagekit.api.core.http.HttpResponse.Handler
import io.imagekit.api.core.http.HttpResponseFor
import io.imagekit.api.core.http.parseable
import io.imagekit.api.core.prepareAsync
import io.imagekit.api.models.files.Metadata
import io.imagekit.api.models.files.metadata.MetadataGetFromUrlParams
import io.imagekit.api.models.files.metadata.MetadataGetParams
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

    override fun get(
        params: MetadataGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Metadata> =
        // get /v1/files/{fileId}/metadata
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    override fun getFromUrl(
        params: MetadataGetFromUrlParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Metadata> =
        // get /v1/metadata
        withRawResponse().getFromUrl(params, requestOptions).thenApply { it.parse() }

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

        private val getHandler: Handler<Metadata> = jsonHandler<Metadata>(clientOptions.jsonMapper)

        override fun get(
            params: MetadataGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Metadata>> {
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
                            .use { getHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getFromUrlHandler: Handler<Metadata> =
            jsonHandler<Metadata>(clientOptions.jsonMapper)

        override fun getFromUrl(
            params: MetadataGetFromUrlParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Metadata>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "metadata")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getFromUrlHandler.handle(it) }
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
