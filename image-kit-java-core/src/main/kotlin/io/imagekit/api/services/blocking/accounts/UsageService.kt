// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.blocking.accounts

import com.google.errorprone.annotations.MustBeClosed
import io.imagekit.api.core.ClientOptions
import io.imagekit.api.core.RequestOptions
import io.imagekit.api.core.http.HttpResponseFor
import io.imagekit.api.models.accounts.usage.UsageGetParams
import io.imagekit.api.models.accounts.usage.UsageGetResponse
import java.util.function.Consumer

interface UsageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageService

    /**
     * Get the account usage information between two dates. Note that the API response includes data
     * from the start date while excluding data from the end date. In other words, the data covers
     * the period starting from the specified start date up to, but not including, the end date.
     */
    fun get(params: UsageGetParams): UsageGetResponse = get(params, RequestOptions.none())

    /** @see get */
    fun get(
        params: UsageGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageGetResponse

    /** A view of [UsageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/accounts/usage`, but is otherwise the same as
         * [UsageService.get].
         */
        @MustBeClosed
        fun get(params: UsageGetParams): HttpResponseFor<UsageGetResponse> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: UsageGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageGetResponse>
    }
}
