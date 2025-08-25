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
import com.imagekit.api.models.files.File
import com.imagekit.api.models.files.versions.VersionDeleteParams
import com.imagekit.api.models.files.versions.VersionDeleteResponse
import com.imagekit.api.models.files.versions.VersionGetParams
import com.imagekit.api.models.files.versions.VersionListParams
import com.imagekit.api.models.files.versions.VersionRestoreParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class VersionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    VersionService {

    private val withRawResponse: VersionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): VersionService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VersionService =
        VersionServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(params: VersionListParams, requestOptions: RequestOptions): List<File> =
        // get /v1/files/{fileId}/versions
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: VersionDeleteParams,
        requestOptions: RequestOptions,
    ): VersionDeleteResponse =
        // delete /v1/files/{fileId}/versions/{versionId}
        withRawResponse().delete(params, requestOptions).parse()

    override fun get(params: VersionGetParams, requestOptions: RequestOptions): File =
        // get /v1/files/{fileId}/versions/{versionId}
        withRawResponse().get(params, requestOptions).parse()

    override fun restore(params: VersionRestoreParams, requestOptions: RequestOptions): File =
        // put /v1/files/{fileId}/versions/{versionId}/restore
        withRawResponse().restore(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VersionService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VersionService.WithRawResponse =
            VersionServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<List<File>> =
            jsonHandler<List<File>>(clientOptions.jsonMapper)

        override fun list(
            params: VersionListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<File>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", params._pathParam(0), "versions")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val deleteHandler: Handler<VersionDeleteResponse> =
            jsonHandler<VersionDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: VersionDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VersionDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("versionId", params.versionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "files",
                        params._pathParam(0),
                        "versions",
                        params._pathParam(1),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getHandler: Handler<File> = jsonHandler<File>(clientOptions.jsonMapper)

        override fun get(
            params: VersionGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<File> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("versionId", params.versionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "files",
                        params._pathParam(0),
                        "versions",
                        params._pathParam(1),
                    )
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

        private val restoreHandler: Handler<File> = jsonHandler<File>(clientOptions.jsonMapper)

        override fun restore(
            params: VersionRestoreParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<File> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("versionId", params.versionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "files",
                        params._pathParam(0),
                        "versions",
                        params._pathParam(1),
                        "restore",
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { restoreHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
