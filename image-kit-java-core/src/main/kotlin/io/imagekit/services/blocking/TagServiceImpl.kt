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
import io.imagekit.core.http.parseable
import io.imagekit.core.prepare
import io.imagekit.models.tags.TagListPage
import io.imagekit.models.tags.TagListPageResponse
import io.imagekit.models.tags.TagListParams
import java.util.function.Consumer

class TagServiceImpl internal constructor(private val clientOptions: ClientOptions) : TagService {

    private val withRawResponse: TagService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TagService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TagService =
        TagServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(params: TagListParams, requestOptions: RequestOptions): TagListPage =
        // get /v1/tags
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TagService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TagService.WithRawResponse =
            TagServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<TagListPageResponse> =
            jsonHandler<TagListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: TagListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TagListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "tags")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        TagListPage.builder()
                            .service(TagServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
