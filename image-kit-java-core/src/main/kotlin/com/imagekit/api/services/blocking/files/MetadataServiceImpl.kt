// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.files

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
import com.imagekit.api.core.prepare
import com.imagekit.api.models.files.metadata.MetadataFromUrlParams
import com.imagekit.api.models.files.metadata.MetadataFromUrlResponse
import com.imagekit.api.models.files.metadata.MetadataRetrieveParams
import com.imagekit.api.models.files.metadata.MetadataRetrieveResponse
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

    override fun retrieve(
        params: MetadataRetrieveParams,
        requestOptions: RequestOptions,
    ): MetadataRetrieveResponse =
        // get /v1/files/{fileId}/metadata
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun fromUrl(
        params: MetadataFromUrlParams,
        requestOptions: RequestOptions,
    ): MetadataFromUrlResponse =
        // get /v1/files/metadata
        withRawResponse().fromUrl(params, requestOptions).parse()

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

        private val retrieveHandler: Handler<MetadataRetrieveResponse> =
            jsonHandler<MetadataRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: MetadataRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MetadataRetrieveResponse> {
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
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val fromUrlHandler: Handler<MetadataFromUrlResponse> =
            jsonHandler<MetadataFromUrlResponse>(clientOptions.jsonMapper)

        override fun fromUrl(
            params: MetadataFromUrlParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MetadataFromUrlResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", "metadata")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
