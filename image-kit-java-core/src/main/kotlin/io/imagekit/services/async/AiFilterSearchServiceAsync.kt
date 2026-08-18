// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.aifiltersearch.AiFilterSearchCreateParams
import io.imagekit.models.aifiltersearch.AiFilterSearchCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AiFilterSearchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AiFilterSearchServiceAsync

    /**
     * Convert a natural-language prompt into a structured ImageKit media-library search query. The
     * response returns a `searchQuery` string (the same Lucene-like syntax accepted by the list and
     * search assets API) plus suggested filter parameters. This endpoint only generates the query;
     * it does not execute the search.
     */
    fun create(
        params: AiFilterSearchCreateParams
    ): CompletableFuture<AiFilterSearchCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AiFilterSearchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AiFilterSearchCreateResponse>

    /**
     * A view of [AiFilterSearchServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AiFilterSearchServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/ai-filter-search`, but is otherwise the same as
         * [AiFilterSearchServiceAsync.create].
         */
        fun create(
            params: AiFilterSearchCreateParams
        ): CompletableFuture<HttpResponseFor<AiFilterSearchCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: AiFilterSearchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AiFilterSearchCreateResponse>>
    }
}
