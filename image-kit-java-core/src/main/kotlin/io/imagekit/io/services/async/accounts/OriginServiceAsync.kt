// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.async.accounts

import io.imagekit.io.core.ClientOptions
import io.imagekit.io.core.RequestOptions
import io.imagekit.io.core.http.HttpResponse
import io.imagekit.io.core.http.HttpResponseFor
import io.imagekit.io.models.accounts.origins.OriginCreateParams
import io.imagekit.io.models.accounts.origins.OriginDeleteParams
import io.imagekit.io.models.accounts.origins.OriginGetParams
import io.imagekit.io.models.accounts.origins.OriginListParams
import io.imagekit.io.models.accounts.origins.OriginRequest
import io.imagekit.io.models.accounts.origins.OriginResponse
import io.imagekit.io.models.accounts.origins.OriginUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface OriginServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OriginServiceAsync

    /**
     * **Note:** This API is currently in beta. Creates a new origin and returns the origin object.
     */
    fun create(params: OriginCreateParams): CompletableFuture<OriginResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: OriginCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse>

    /** @see create */
    fun create(
        originRequest: OriginRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse> =
        create(OriginCreateParams.builder().originRequest(originRequest).build(), requestOptions)

    /** @see create */
    fun create(originRequest: OriginRequest): CompletableFuture<OriginResponse> =
        create(originRequest, RequestOptions.none())

    /** @see create */
    fun create(
        s3: OriginRequest.S3,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse> = create(OriginRequest.ofS3(s3), requestOptions)

    /** @see create */
    fun create(s3: OriginRequest.S3): CompletableFuture<OriginResponse> =
        create(s3, RequestOptions.none())

    /** @see create */
    fun create(
        s3Compatible: OriginRequest.S3Compatible,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse> =
        create(OriginRequest.ofS3Compatible(s3Compatible), requestOptions)

    /** @see create */
    fun create(s3Compatible: OriginRequest.S3Compatible): CompletableFuture<OriginResponse> =
        create(s3Compatible, RequestOptions.none())

    /** @see create */
    fun create(
        cloudinaryBackup: OriginRequest.CloudinaryBackup,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse> =
        create(OriginRequest.ofCloudinaryBackup(cloudinaryBackup), requestOptions)

    /** @see create */
    fun create(
        cloudinaryBackup: OriginRequest.CloudinaryBackup
    ): CompletableFuture<OriginResponse> = create(cloudinaryBackup, RequestOptions.none())

    /** @see create */
    fun create(
        webFolder: OriginRequest.WebFolder,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse> =
        create(OriginRequest.ofWebFolder(webFolder), requestOptions)

    /** @see create */
    fun create(webFolder: OriginRequest.WebFolder): CompletableFuture<OriginResponse> =
        create(webFolder, RequestOptions.none())

    /** @see create */
    fun create(
        webProxy: OriginRequest.WebProxy,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse> =
        create(OriginRequest.ofWebProxy(webProxy), requestOptions)

    /** @see create */
    fun create(webProxy: OriginRequest.WebProxy): CompletableFuture<OriginResponse> =
        create(webProxy, RequestOptions.none())

    /** @see create */
    fun create(
        gcs: OriginRequest.Gcs,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse> = create(OriginRequest.ofGcs(gcs), requestOptions)

    /** @see create */
    fun create(gcs: OriginRequest.Gcs): CompletableFuture<OriginResponse> =
        create(gcs, RequestOptions.none())

    /** @see create */
    fun create(
        azureBlob: OriginRequest.AzureBlob,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse> =
        create(OriginRequest.ofAzureBlob(azureBlob), requestOptions)

    /** @see create */
    fun create(azureBlob: OriginRequest.AzureBlob): CompletableFuture<OriginResponse> =
        create(azureBlob, RequestOptions.none())

    /** @see create */
    fun create(
        akeneoPim: OriginRequest.AkeneoPim,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse> =
        create(OriginRequest.ofAkeneoPim(akeneoPim), requestOptions)

    /** @see create */
    fun create(akeneoPim: OriginRequest.AkeneoPim): CompletableFuture<OriginResponse> =
        create(akeneoPim, RequestOptions.none())

    /**
     * **Note:** This API is currently in beta. Updates the origin identified by `id` and returns
     * the updated origin object.
     */
    fun update(id: String, params: OriginUpdateParams): CompletableFuture<OriginResponse> =
        update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        params: OriginUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse> = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(params: OriginUpdateParams): CompletableFuture<OriginResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: OriginUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse>

    /**
     * **Note:** This API is currently in beta. Returns an array of all configured origins for the
     * current account.
     */
    fun list(): CompletableFuture<List<OriginResponse>> = list(OriginListParams.none())

    /** @see list */
    fun list(
        params: OriginListParams = OriginListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<OriginResponse>>

    /** @see list */
    fun list(
        params: OriginListParams = OriginListParams.none()
    ): CompletableFuture<List<OriginResponse>> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<OriginResponse>> =
        list(OriginListParams.none(), requestOptions)

    /**
     * **Note:** This API is currently in beta. Permanently removes the origin identified by `id`.
     * If the origin is in use by any URL‑endpoints, the API will return an error.
     */
    fun delete(id: String): CompletableFuture<Void?> = delete(id, OriginDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: OriginDeleteParams = OriginDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: OriginDeleteParams = OriginDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: OriginDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: OriginDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(id, OriginDeleteParams.none(), requestOptions)

    /** **Note:** This API is currently in beta. Retrieves the origin identified by `id`. */
    fun get(id: String): CompletableFuture<OriginResponse> = get(id, OriginGetParams.none())

    /** @see get */
    fun get(
        id: String,
        params: OriginGetParams = OriginGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse> = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see get */
    fun get(
        id: String,
        params: OriginGetParams = OriginGetParams.none(),
    ): CompletableFuture<OriginResponse> = get(id, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: OriginGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OriginResponse>

    /** @see get */
    fun get(params: OriginGetParams): CompletableFuture<OriginResponse> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(id: String, requestOptions: RequestOptions): CompletableFuture<OriginResponse> =
        get(id, OriginGetParams.none(), requestOptions)

    /**
     * A view of [OriginServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OriginServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/accounts/origins`, but is otherwise the same as
         * [OriginServiceAsync.create].
         */
        fun create(params: OriginCreateParams): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: OriginCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>>

        /** @see create */
        fun create(
            originRequest: OriginRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(
                OriginCreateParams.builder().originRequest(originRequest).build(),
                requestOptions,
            )

        /** @see create */
        fun create(
            originRequest: OriginRequest
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(originRequest, RequestOptions.none())

        /** @see create */
        fun create(
            s3: OriginRequest.S3,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(OriginRequest.ofS3(s3), requestOptions)

        /** @see create */
        fun create(s3: OriginRequest.S3): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(s3, RequestOptions.none())

        /** @see create */
        fun create(
            s3Compatible: OriginRequest.S3Compatible,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(OriginRequest.ofS3Compatible(s3Compatible), requestOptions)

        /** @see create */
        fun create(
            s3Compatible: OriginRequest.S3Compatible
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(s3Compatible, RequestOptions.none())

        /** @see create */
        fun create(
            cloudinaryBackup: OriginRequest.CloudinaryBackup,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(OriginRequest.ofCloudinaryBackup(cloudinaryBackup), requestOptions)

        /** @see create */
        fun create(
            cloudinaryBackup: OriginRequest.CloudinaryBackup
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(cloudinaryBackup, RequestOptions.none())

        /** @see create */
        fun create(
            webFolder: OriginRequest.WebFolder,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(OriginRequest.ofWebFolder(webFolder), requestOptions)

        /** @see create */
        fun create(
            webFolder: OriginRequest.WebFolder
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(webFolder, RequestOptions.none())

        /** @see create */
        fun create(
            webProxy: OriginRequest.WebProxy,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(OriginRequest.ofWebProxy(webProxy), requestOptions)

        /** @see create */
        fun create(
            webProxy: OriginRequest.WebProxy
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(webProxy, RequestOptions.none())

        /** @see create */
        fun create(
            gcs: OriginRequest.Gcs,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(OriginRequest.ofGcs(gcs), requestOptions)

        /** @see create */
        fun create(gcs: OriginRequest.Gcs): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(gcs, RequestOptions.none())

        /** @see create */
        fun create(
            azureBlob: OriginRequest.AzureBlob,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(OriginRequest.ofAzureBlob(azureBlob), requestOptions)

        /** @see create */
        fun create(
            azureBlob: OriginRequest.AzureBlob
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(azureBlob, RequestOptions.none())

        /** @see create */
        fun create(
            akeneoPim: OriginRequest.AkeneoPim,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(OriginRequest.ofAkeneoPim(akeneoPim), requestOptions)

        /** @see create */
        fun create(
            akeneoPim: OriginRequest.AkeneoPim
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            create(akeneoPim, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `put /v1/accounts/origins/{id}`, but is otherwise the
         * same as [OriginServiceAsync.update].
         */
        fun update(
            id: String,
            params: OriginUpdateParams,
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            params: OriginUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(params: OriginUpdateParams): CompletableFuture<HttpResponseFor<OriginResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: OriginUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/accounts/origins`, but is otherwise the same as
         * [OriginServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<OriginResponse>>> =
            list(OriginListParams.none())

        /** @see list */
        fun list(
            params: OriginListParams = OriginListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<OriginResponse>>>

        /** @see list */
        fun list(
            params: OriginListParams = OriginListParams.none()
        ): CompletableFuture<HttpResponseFor<List<OriginResponse>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<OriginResponse>>> =
            list(OriginListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/accounts/origins/{id}`, but is otherwise the
         * same as [OriginServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponse> =
            delete(id, OriginDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: OriginDeleteParams = OriginDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: OriginDeleteParams = OriginDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: OriginDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: OriginDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(id, OriginDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/accounts/origins/{id}`, but is otherwise the
         * same as [OriginServiceAsync.get].
         */
        fun get(id: String): CompletableFuture<HttpResponseFor<OriginResponse>> =
            get(id, OriginGetParams.none())

        /** @see get */
        fun get(
            id: String,
            params: OriginGetParams = OriginGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            get(params.toBuilder().id(id).build(), requestOptions)

        /** @see get */
        fun get(
            id: String,
            params: OriginGetParams = OriginGetParams.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            get(id, params, RequestOptions.none())

        /** @see get */
        fun get(
            params: OriginGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OriginResponse>>

        /** @see get */
        fun get(params: OriginGetParams): CompletableFuture<HttpResponseFor<OriginResponse>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OriginResponse>> =
            get(id, OriginGetParams.none(), requestOptions)
    }
}
