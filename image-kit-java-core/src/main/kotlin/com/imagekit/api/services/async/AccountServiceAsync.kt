// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.accounts.AccountGetUsageParams
import com.imagekit.api.models.accounts.AccountGetUsageResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AccountServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountServiceAsync

    /**
     * Get the account usage information between two dates. Note that the API response includes data
     * from the start date while excluding data from the end date. In other words, the data covers
     * the period starting from the specified start date up to, but not including, the end date.
     */
    fun getUsage(params: AccountGetUsageParams): CompletableFuture<AccountGetUsageResponse> =
        getUsage(params, RequestOptions.none())

    /** @see getUsage */
    fun getUsage(
        params: AccountGetUsageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountGetUsageResponse>

    /**
     * A view of [AccountServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccountServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/accounts/usage`, but is otherwise the same as
         * [AccountServiceAsync.getUsage].
         */
        fun getUsage(
            params: AccountGetUsageParams
        ): CompletableFuture<HttpResponseFor<AccountGetUsageResponse>> =
            getUsage(params, RequestOptions.none())

        /** @see getUsage */
        fun getUsage(
            params: AccountGetUsageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountGetUsageResponse>>
    }
}
