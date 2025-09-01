// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.assets.AssetListParams
import com.imagekit.api.models.assets.AssetListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AssetServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AssetServiceAsync

    /**
     * This API can list all the uploaded files and folders in your ImageKit.io media library. In
     * addition, you can fine-tune your query by specifying various filters by generating a query
     * string in a Lucene-like syntax and provide this generated string as the value of the
     * `searchQuery`.
     */
    fun list(): CompletableFuture<List<AssetListResponse>> = list(AssetListParams.none())

    /** @see list */
    fun list(
        params: AssetListParams = AssetListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AssetListResponse>>

    /** @see list */
    fun list(
        params: AssetListParams = AssetListParams.none()
    ): CompletableFuture<List<AssetListResponse>> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<AssetListResponse>> =
        list(AssetListParams.none(), requestOptions)

    /** A view of [AssetServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AssetServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/files`, but is otherwise the same as
         * [AssetServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<AssetListResponse>>> =
            list(AssetListParams.none())

        /** @see list */
        fun list(
            params: AssetListParams = AssetListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AssetListResponse>>>

        /** @see list */
        fun list(
            params: AssetListParams = AssetListParams.none()
        ): CompletableFuture<HttpResponseFor<List<AssetListResponse>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<AssetListResponse>>> =
            list(AssetListParams.none(), requestOptions)
    }
}
