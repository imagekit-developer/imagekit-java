// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import io.imagekit.io.core.ClientOptions
import io.imagekit.io.core.RequestOptions
import io.imagekit.io.core.http.HttpResponseFor
import io.imagekit.io.models.assets.AssetListParams
import io.imagekit.io.models.assets.AssetListResponse
import java.util.function.Consumer

interface AssetService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AssetService

    /**
     * This API can list all the uploaded files and folders in your ImageKit.io media library. In
     * addition, you can fine-tune your query by specifying various filters by generating a query
     * string in a Lucene-like syntax and provide this generated string as the value of the
     * `searchQuery`.
     */
    fun list(): List<AssetListResponse> = list(AssetListParams.none())

    /** @see list */
    fun list(
        params: AssetListParams = AssetListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AssetListResponse>

    /** @see list */
    fun list(params: AssetListParams = AssetListParams.none()): List<AssetListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): List<AssetListResponse> =
        list(AssetListParams.none(), requestOptions)

    /** A view of [AssetService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AssetService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/files`, but is otherwise the same as
         * [AssetService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<List<AssetListResponse>> = list(AssetListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: AssetListParams = AssetListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AssetListResponse>>

        /** @see list */
        @MustBeClosed
        fun list(
            params: AssetListParams = AssetListParams.none()
        ): HttpResponseFor<List<AssetListResponse>> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<List<AssetListResponse>> =
            list(AssetListParams.none(), requestOptions)
    }
}
