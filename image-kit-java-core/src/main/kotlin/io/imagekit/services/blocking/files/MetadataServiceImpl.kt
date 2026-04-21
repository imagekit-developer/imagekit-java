// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking.files

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
import io.imagekit.core.http.parseable
import io.imagekit.core.prepare
import io.imagekit.models.files.Metadata
import io.imagekit.models.files.metadata.MetadataGetFromUrlParams
import io.imagekit.models.files.metadata.MetadataGetParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class MetadataServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MetadataService {

    private val withRawResponse: MetadataService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MetadataService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MetadataService =
        MetadataServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun get(params: MetadataGetParams, requestOptions: RequestOptions): Metadata =
        // get /v1/files/{fileId}/metadata
        withRawResponse().get(params, requestOptions).parse()

    override fun getFromUrl(
        params: MetadataGetFromUrlParams,
        requestOptions: RequestOptions,
    ): Metadata =
        // get /v1/metadata
        withRawResponse().getFromUrl(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MetadataService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MetadataService.WithRawResponse =
            MetadataServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val getHandler: Handler<Metadata> = jsonHandler<Metadata>(clientOptions.jsonMapper)

        override fun get(
            params: MetadataGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Metadata> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", params._pathParam(0), "metadata")
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

        private val getFromUrlHandler: Handler<Metadata> =
            jsonHandler<Metadata>(clientOptions.jsonMapper)

        override fun getFromUrl(
            params: MetadataGetFromUrlParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Metadata> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "metadata")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
