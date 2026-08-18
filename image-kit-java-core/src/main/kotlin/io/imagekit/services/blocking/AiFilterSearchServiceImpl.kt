// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
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
import io.imagekit.models.aifiltersearch.AiFilterSearchCreateParams
import io.imagekit.models.aifiltersearch.AiFilterSearchCreateResponse
import java.util.function.Consumer

class AiFilterSearchServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AiFilterSearchService {

    private val withRawResponse: AiFilterSearchService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AiFilterSearchService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AiFilterSearchService =
        AiFilterSearchServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: AiFilterSearchCreateParams,
        requestOptions: RequestOptions,
    ): AiFilterSearchCreateResponse =
        // post /v1/ai-filter-search
        withRawResponse().create(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AiFilterSearchService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AiFilterSearchService.WithRawResponse =
            AiFilterSearchServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<AiFilterSearchCreateResponse> =
            jsonHandler<AiFilterSearchCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: AiFilterSearchCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AiFilterSearchCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "ai-filter-search")
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
    }
}
