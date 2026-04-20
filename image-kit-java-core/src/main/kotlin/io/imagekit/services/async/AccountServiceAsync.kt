// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.core.ClientOptions
import io.imagekit.services.async.accounts.OriginServiceAsync
import io.imagekit.services.async.accounts.UrlEndpointServiceAsync
import io.imagekit.services.async.accounts.UsageServiceAsync
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

    fun usage(): UsageServiceAsync

    fun origins(): OriginServiceAsync

    fun urlEndpoints(): UrlEndpointServiceAsync

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

        fun usage(): UsageServiceAsync.WithRawResponse

        fun origins(): OriginServiceAsync.WithRawResponse

        fun urlEndpoints(): UrlEndpointServiceAsync.WithRawResponse
    }
}
