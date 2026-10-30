// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking.accounts

import com.google.errorprone.annotations.MustBeClosed
import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.accounts.contract.ContractGetParams
import io.imagekit.models.accounts.contract.ContractGetResponse
import java.util.function.Consumer

interface ContractService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContractService

    /**
     * Get the account's contract terms and the usage consumed against them in the current contract
     * term. Bandwidth is in bytes; video processing units, extension units and purge cache requests
     * are counts.
     *
     * For an agency account, consumption includes the child accounts billed to it. A child account
     * billed to its parent cannot call this endpoint; call it with the parent account's credentials
     * instead.
     *
     * Contract terms are read live; consumption is refreshed periodically, not on every request.
     * Use `asOf` to check how fresh it is. Contracts of one month or less are reported as
     * `hasContract: false`. The response is cached for 5 minutes per account.
     *
     * Requires an API key with account management access.
     */
    fun get(): ContractGetResponse = get(ContractGetParams.none())

    /** @see get */
    fun get(
        params: ContractGetParams = ContractGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContractGetResponse

    /** @see get */
    fun get(params: ContractGetParams = ContractGetParams.none()): ContractGetResponse =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(requestOptions: RequestOptions): ContractGetResponse =
        get(ContractGetParams.none(), requestOptions)

    /** A view of [ContractService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContractService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/accounts/contract`, but is otherwise the same as
         * [ContractService.get].
         */
        @MustBeClosed
        fun get(): HttpResponseFor<ContractGetResponse> = get(ContractGetParams.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: ContractGetParams = ContractGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContractGetResponse>

        /** @see get */
        @MustBeClosed
        fun get(
            params: ContractGetParams = ContractGetParams.none()
        ): HttpResponseFor<ContractGetResponse> = get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(requestOptions: RequestOptions): HttpResponseFor<ContractGetResponse> =
            get(ContractGetParams.none(), requestOptions)
    }
}
