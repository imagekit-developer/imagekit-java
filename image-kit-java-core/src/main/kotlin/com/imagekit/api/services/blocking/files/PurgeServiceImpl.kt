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
import com.imagekit.api.core.http.json
import com.imagekit.api.core.http.parseable
import com.imagekit.api.core.prepare
import com.imagekit.api.models.files.purge.PurgeExecuteParams
import com.imagekit.api.models.files.purge.PurgeExecuteResponse
import com.imagekit.api.models.files.purge.PurgeStatusParams
import com.imagekit.api.models.files.purge.PurgeStatusResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class PurgeServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    PurgeService {

    private val withRawResponse: PurgeService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PurgeService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PurgeService =
        PurgeServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun execute(
        params: PurgeExecuteParams,
        requestOptions: RequestOptions,
    ): PurgeExecuteResponse =
        // post /v1/files/purge
        withRawResponse().execute(params, requestOptions).parse()

    override fun status(
        params: PurgeStatusParams,
        requestOptions: RequestOptions,
    ): PurgeStatusResponse =
        // get /v1/files/purge/{requestId}
        withRawResponse().status(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PurgeService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PurgeService.WithRawResponse =
            PurgeServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val executeHandler: Handler<PurgeExecuteResponse> =
            jsonHandler<PurgeExecuteResponse>(clientOptions.jsonMapper)

        override fun execute(
            params: PurgeExecuteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PurgeExecuteResponse> {
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
                    .use { executeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val statusHandler: Handler<PurgeStatusResponse> =
            jsonHandler<PurgeStatusResponse>(clientOptions.jsonMapper)

        override fun status(
            params: PurgeStatusParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PurgeStatusResponse> {
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
                    .use { statusHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
