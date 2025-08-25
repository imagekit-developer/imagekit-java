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
import com.imagekit.api.core.http.json
import com.imagekit.api.core.http.parseable
import com.imagekit.api.core.prepareAsync
import com.imagekit.api.models.File
import com.imagekit.api.models.files.versions.VersionDeleteParams
import com.imagekit.api.models.files.versions.VersionDeleteResponse
import com.imagekit.api.models.files.versions.VersionGetParams
import com.imagekit.api.models.files.versions.VersionListParams
import com.imagekit.api.models.files.versions.VersionRestoreParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class VersionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    VersionServiceAsync {

    private val withRawResponse: VersionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): VersionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VersionServiceAsync =
        VersionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: VersionListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<File>> =
        // get /v1/files/{fileId}/versions
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: VersionDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VersionDeleteResponse> =
        // delete /v1/files/{fileId}/versions/{versionId}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun get(
        params: VersionGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<File> =
        // get /v1/files/{fileId}/versions/{versionId}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    override fun restore(
        params: VersionRestoreParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<File> =
        // put /v1/files/{fileId}/versions/{versionId}/restore
        withRawResponse().restore(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VersionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VersionServiceAsync.WithRawResponse =
            VersionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<List<File>> =
            jsonHandler<List<File>>(clientOptions.jsonMapper)

        override fun list(
            params: VersionListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<File>>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "files", params._pathParam(0), "versions")
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

        private val deleteHandler: Handler<VersionDeleteResponse> =
            jsonHandler<VersionDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: VersionDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VersionDeleteResponse>> {
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

        private val getHandler: Handler<File> = jsonHandler<File>(clientOptions.jsonMapper)

        override fun get(
            params: VersionGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<File>> {
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

        private val restoreHandler: Handler<File> = jsonHandler<File>(clientOptions.jsonMapper)

        override fun restore(
            params: VersionRestoreParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<File>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
