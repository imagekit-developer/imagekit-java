// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking.accounts

import com.google.errorprone.annotations.MustBeClosed
import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.accounts.usageanalytics.UsageAnalyticsGetParams
import io.imagekit.models.accounts.usageanalytics.UsageAnalyticsResponse
import java.util.function.Consumer

interface UsageAnalyticsService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageAnalyticsService

    /**
     * **Note:** This API is currently in beta.
     *
     * Get the account analytics data between two dates. The response covers the period from the
     * start date to the end date, both dates inclusive. Both dates are interpreted as UTC calendar
     * days.
     *
     * The returned data is scoped to the requesting account only. Unlike `/v1/accounts/usage`, an
     * agency account's analytics are not aggregated across its child accounts.
     *
     * The response is cached for 5 minutes per account and date range. Use `generatedAt` to check
     * how fresh the returned data is.
     */
    fun get(params: UsageAnalyticsGetParams): UsageAnalyticsResponse =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(
        params: UsageAnalyticsGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageAnalyticsResponse

    /**
     * A view of [UsageAnalyticsService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UsageAnalyticsService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/accounts/usage-analytics`, but is otherwise the
         * same as [UsageAnalyticsService.get].
         */
        @MustBeClosed
        fun get(params: UsageAnalyticsGetParams): HttpResponseFor<UsageAnalyticsResponse> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: UsageAnalyticsGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageAnalyticsResponse>
    }
}
