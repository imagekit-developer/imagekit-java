// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking.accounts

import com.google.errorprone.annotations.MustBeClosed
import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponse
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.accounts.origins.OriginCreateParams
import com.imagekit.api.models.accounts.origins.OriginDeleteParams
import com.imagekit.api.models.accounts.origins.OriginGetParams
import com.imagekit.api.models.accounts.origins.OriginListParams
import com.imagekit.api.models.accounts.origins.OriginResponse
import com.imagekit.api.models.accounts.origins.OriginUpdateParams
import java.util.function.Consumer

interface OriginService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OriginService

    /**
     * **Note:** This API is currently in beta. Creates a new origin and returns the origin object.
     */
    fun create(params: OriginCreateParams): OriginResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: OriginCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OriginResponse

    /**
     * **Note:** This API is currently in beta. Updates the origin identified by `id` and returns
     * the updated origin object.
     */
    fun update(id: String, params: OriginUpdateParams): OriginResponse =
        update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        params: OriginUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OriginResponse = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(params: OriginUpdateParams): OriginResponse = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: OriginUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OriginResponse

    /**
     * **Note:** This API is currently in beta. Returns an array of all configured origins for the
     * current account.
     */
    fun list(): List<OriginResponse> = list(OriginListParams.none())

    /** @see list */
    fun list(
        params: OriginListParams = OriginListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<OriginResponse>

    /** @see list */
    fun list(params: OriginListParams = OriginListParams.none()): List<OriginResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): List<OriginResponse> =
        list(OriginListParams.none(), requestOptions)

    /**
     * **Note:** This API is currently in beta. Permanently removes the origin identified by `id`.
     * If the origin is in use by any URL‑endpoints, the API will return an error.
     */
    fun delete(id: String) = delete(id, OriginDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: OriginDeleteParams = OriginDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(id: String, params: OriginDeleteParams = OriginDeleteParams.none()) =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: OriginDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: OriginDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions) =
        delete(id, OriginDeleteParams.none(), requestOptions)

    /** **Note:** This API is currently in beta. Retrieves the origin identified by `id`. */
    fun get(id: String): OriginResponse = get(id, OriginGetParams.none())

    /** @see get */
    fun get(
        id: String,
        params: OriginGetParams = OriginGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OriginResponse = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see get */
    fun get(id: String, params: OriginGetParams = OriginGetParams.none()): OriginResponse =
        get(id, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: OriginGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OriginResponse

    /** @see get */
    fun get(params: OriginGetParams): OriginResponse = get(params, RequestOptions.none())

    /** @see get */
    fun get(id: String, requestOptions: RequestOptions): OriginResponse =
        get(id, OriginGetParams.none(), requestOptions)

    /** A view of [OriginService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): OriginService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/accounts/origins`, but is otherwise the same as
         * [OriginService.create].
         */
        @MustBeClosed
        fun create(params: OriginCreateParams): HttpResponseFor<OriginResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: OriginCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OriginResponse>

        /**
         * Returns a raw HTTP response for `put /v1/accounts/origins/{id}`, but is otherwise the
         * same as [OriginService.update].
         */
        @MustBeClosed
        fun update(id: String, params: OriginUpdateParams): HttpResponseFor<OriginResponse> =
            update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: OriginUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OriginResponse> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: OriginUpdateParams): HttpResponseFor<OriginResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: OriginUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OriginResponse>

        /**
         * Returns a raw HTTP response for `get /v1/accounts/origins`, but is otherwise the same as
         * [OriginService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<List<OriginResponse>> = list(OriginListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: OriginListParams = OriginListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<OriginResponse>>

        /** @see list */
        @MustBeClosed
        fun list(
            params: OriginListParams = OriginListParams.none()
        ): HttpResponseFor<List<OriginResponse>> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<List<OriginResponse>> =
            list(OriginListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/accounts/origins/{id}`, but is otherwise the
         * same as [OriginService.delete].
         */
        @MustBeClosed fun delete(id: String): HttpResponse = delete(id, OriginDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: OriginDeleteParams = OriginDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: OriginDeleteParams = OriginDeleteParams.none(),
        ): HttpResponse = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: OriginDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: OriginDeleteParams): HttpResponse = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(id: String, requestOptions: RequestOptions): HttpResponse =
            delete(id, OriginDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/accounts/origins/{id}`, but is otherwise the
         * same as [OriginService.get].
         */
        @MustBeClosed
        fun get(id: String): HttpResponseFor<OriginResponse> = get(id, OriginGetParams.none())

        /** @see get */
        @MustBeClosed
        fun get(
            id: String,
            params: OriginGetParams = OriginGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OriginResponse> = get(params.toBuilder().id(id).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(
            id: String,
            params: OriginGetParams = OriginGetParams.none(),
        ): HttpResponseFor<OriginResponse> = get(id, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: OriginGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OriginResponse>

        /** @see get */
        @MustBeClosed
        fun get(params: OriginGetParams): HttpResponseFor<OriginResponse> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(id: String, requestOptions: RequestOptions): HttpResponseFor<OriginResponse> =
            get(id, OriginGetParams.none(), requestOptions)
    }
}
