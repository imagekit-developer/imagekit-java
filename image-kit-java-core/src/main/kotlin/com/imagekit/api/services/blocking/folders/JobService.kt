// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.folders

import com.google.errorprone.annotations.MustBeClosed
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.folders.job.JobGetParams
import com.imagekit.api.models.folders.job.JobGetResponse
import java.util.function.Consumer

interface JobService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): JobService

    /** This API returns the status of a bulk job like copy and move folder operations. */
    fun get(jobId: String): JobGetResponse = get(jobId, JobGetParams.none())

    /** @see get */
    fun get(
        jobId: String,
        params: JobGetParams = JobGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JobGetResponse = get(params.toBuilder().jobId(jobId).build(), requestOptions)

    /** @see get */
    fun get(jobId: String, params: JobGetParams = JobGetParams.none()): JobGetResponse =
        get(jobId, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: JobGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JobGetResponse

    /** @see get */
    fun get(params: JobGetParams): JobGetResponse = get(params, RequestOptions.none())

    /** @see get */
    fun get(jobId: String, requestOptions: RequestOptions): JobGetResponse =
        get(jobId, JobGetParams.none(), requestOptions)

    /** A view of [JobService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): JobService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/bulkJobs/{jobId}`, but is otherwise the same as
         * [JobService.get].
         */
        @MustBeClosed
        fun get(jobId: String): HttpResponseFor<JobGetResponse> = get(jobId, JobGetParams.none())

        /** @see get */
        @MustBeClosed
        fun get(
            jobId: String,
            params: JobGetParams = JobGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JobGetResponse> =
            get(params.toBuilder().jobId(jobId).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(
            jobId: String,
            params: JobGetParams = JobGetParams.none(),
        ): HttpResponseFor<JobGetResponse> = get(jobId, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: JobGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JobGetResponse>

        /** @see get */
        @MustBeClosed
        fun get(params: JobGetParams): HttpResponseFor<JobGetResponse> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(jobId: String, requestOptions: RequestOptions): HttpResponseFor<JobGetResponse> =
            get(jobId, JobGetParams.none(), requestOptions)
    }
}
