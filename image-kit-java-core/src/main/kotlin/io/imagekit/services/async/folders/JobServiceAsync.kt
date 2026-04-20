// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async.folders

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.folders.job.JobGetParams
import io.imagekit.models.folders.job.JobGetResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface JobServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): JobServiceAsync

    /** This API returns the status of a bulk job like copy and move folder operations. */
    fun get(jobId: String): CompletableFuture<JobGetResponse> = get(jobId, JobGetParams.none())

    /** @see get */
    fun get(
        jobId: String,
        params: JobGetParams = JobGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<JobGetResponse> =
        get(params.toBuilder().jobId(jobId).build(), requestOptions)

    /** @see get */
    fun get(
        jobId: String,
        params: JobGetParams = JobGetParams.none(),
    ): CompletableFuture<JobGetResponse> = get(jobId, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: JobGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<JobGetResponse>

    /** @see get */
    fun get(params: JobGetParams): CompletableFuture<JobGetResponse> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(jobId: String, requestOptions: RequestOptions): CompletableFuture<JobGetResponse> =
        get(jobId, JobGetParams.none(), requestOptions)

    /** A view of [JobServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): JobServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/bulkJobs/{jobId}`, but is otherwise the same as
         * [JobServiceAsync.get].
         */
        fun get(jobId: String): CompletableFuture<HttpResponseFor<JobGetResponse>> =
            get(jobId, JobGetParams.none())

        /** @see get */
        fun get(
            jobId: String,
            params: JobGetParams = JobGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<JobGetResponse>> =
            get(params.toBuilder().jobId(jobId).build(), requestOptions)

        /** @see get */
        fun get(
            jobId: String,
            params: JobGetParams = JobGetParams.none(),
        ): CompletableFuture<HttpResponseFor<JobGetResponse>> =
            get(jobId, params, RequestOptions.none())

        /** @see get */
        fun get(
            params: JobGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<JobGetResponse>>

        /** @see get */
        fun get(params: JobGetParams): CompletableFuture<HttpResponseFor<JobGetResponse>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            jobId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<JobGetResponse>> =
            get(jobId, JobGetParams.none(), requestOptions)
    }
}
