// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

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
import com.imagekit.api.models.bulkjobs.BulkJobCopyFolderParams
import com.imagekit.api.models.bulkjobs.BulkJobCopyFolderResponse
import com.imagekit.api.models.bulkjobs.BulkJobMoveFolderParams
import com.imagekit.api.models.bulkjobs.BulkJobMoveFolderResponse
import com.imagekit.api.models.bulkjobs.BulkJobRetrieveStatusParams
import com.imagekit.api.models.bulkjobs.BulkJobRetrieveStatusResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class BulkJobServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BulkJobService {

    private val withRawResponse: BulkJobService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkJobService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkJobService =
        BulkJobServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun copyFolder(
        params: BulkJobCopyFolderParams,
        requestOptions: RequestOptions,
    ): BulkJobCopyFolderResponse =
        // post /v1/bulkJobs/copyFolder
        withRawResponse().copyFolder(params, requestOptions).parse()

    override fun moveFolder(
        params: BulkJobMoveFolderParams,
        requestOptions: RequestOptions,
    ): BulkJobMoveFolderResponse =
        // post /v1/bulkJobs/moveFolder
        withRawResponse().moveFolder(params, requestOptions).parse()

    override fun retrieveStatus(
        params: BulkJobRetrieveStatusParams,
        requestOptions: RequestOptions,
    ): BulkJobRetrieveStatusResponse =
        // get /v1/bulkJobs/{jobId}
        withRawResponse().retrieveStatus(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkJobService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BulkJobService.WithRawResponse =
            BulkJobServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val copyFolderHandler: Handler<BulkJobCopyFolderResponse> =
            jsonHandler<BulkJobCopyFolderResponse>(clientOptions.jsonMapper)

        override fun copyFolder(
            params: BulkJobCopyFolderParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkJobCopyFolderResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "bulkJobs", "copyFolder")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { copyFolderHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val moveFolderHandler: Handler<BulkJobMoveFolderResponse> =
            jsonHandler<BulkJobMoveFolderResponse>(clientOptions.jsonMapper)

        override fun moveFolder(
            params: BulkJobMoveFolderParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkJobMoveFolderResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "bulkJobs", "moveFolder")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { moveFolderHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveStatusHandler: Handler<BulkJobRetrieveStatusResponse> =
            jsonHandler<BulkJobRetrieveStatusResponse>(clientOptions.jsonMapper)

        override fun retrieveStatus(
            params: BulkJobRetrieveStatusParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkJobRetrieveStatusResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("jobId", params.jobId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "bulkJobs", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveStatusHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
