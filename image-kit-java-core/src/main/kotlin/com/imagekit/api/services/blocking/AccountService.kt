// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.services.blocking.accounts.OriginService
import com.imagekit.api.services.blocking.accounts.UrlEndpointService
import com.imagekit.api.services.blocking.accounts.UsageService
import java.util.function.Consumer

interface AccountService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService

    fun usage(): UsageService

    fun origins(): OriginService

    fun urlEndpoints(): UrlEndpointService

    /** A view of [AccountService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService.WithRawResponse

        fun usage(): UsageService.WithRawResponse

        fun origins(): OriginService.WithRawResponse

        fun urlEndpoints(): UrlEndpointService.WithRawResponse
    }
}
