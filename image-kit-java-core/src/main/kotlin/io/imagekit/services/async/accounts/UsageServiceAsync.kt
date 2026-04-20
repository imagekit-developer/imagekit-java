// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.accounts

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.accounts.usage.UsageGetParams
import io.imagekit.models.accounts.usage.UsageGetResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface UsageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageServiceAsync

    /**
     * Get the account usage information between two dates. Note that the API response includes data
     * from the start date while excluding data from the end date. In other words, the data covers
     * the period starting from the specified start date up to, but not including, the end date.
     */
    fun get(params: UsageGetParams): CompletableFuture<UsageGetResponse> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(
        params: UsageGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageGetResponse>

    /** A view of [UsageServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UsageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/accounts/usage`, but is otherwise the same as
         * [UsageServiceAsync.get].
         */
        fun get(params: UsageGetParams): CompletableFuture<HttpResponseFor<UsageGetResponse>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            params: UsageGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageGetResponse>>
    }
}
