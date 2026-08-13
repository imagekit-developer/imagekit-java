// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponse
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.NamedTransformation
import io.imagekit.models.namedtransformations.NamedTransformationCreateParams
import io.imagekit.models.namedtransformations.NamedTransformationDeleteParams
import io.imagekit.models.namedtransformations.NamedTransformationGetParams
import io.imagekit.models.namedtransformations.NamedTransformationListParams
import io.imagekit.models.namedtransformations.NamedTransformationUpdateParams
import java.util.function.Consumer

interface NamedTransformationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NamedTransformationService

    /**
     * Creates a new named transformation and returns the created object.
     *
     * A named transformation is a short, reusable name for a transformation string. Use it in image
     * and video URLs as `tr:n-<name>`, and update the underlying transformation later without
     * changing existing URLs. Learn more about
     * [named transformations](https://imagekit.io/docs/transformations#named-transformations).
     *
     * You can create up to 250 named transformations per account.
     */
    fun create(params: NamedTransformationCreateParams): NamedTransformation =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: NamedTransformationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamedTransformation

    /**
     * Updates the named transformation identified by `id` and returns the updated object. Only the
     * fields present in the request body are updated; other fields stay unchanged.
     *
     * Renaming or disabling a named transformation fails with a `409` error if it is still
     * referenced (via the `n-<name>` token) by an upload pre-transformation or post-transformation
     * setting. This check is best-effort and can't detect references in your own application code
     * or in previously generated URLs.
     */
    fun update(id: String): NamedTransformation = update(id, NamedTransformationUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: NamedTransformationUpdateParams = NamedTransformationUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamedTransformation = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: NamedTransformationUpdateParams = NamedTransformationUpdateParams.none(),
    ): NamedTransformation = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: NamedTransformationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamedTransformation

    /** @see update */
    fun update(params: NamedTransformationUpdateParams): NamedTransformation =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): NamedTransformation =
        update(id, NamedTransformationUpdateParams.none(), requestOptions)

    /** Returns an array of all named transformations configured for your account. */
    fun list(): List<NamedTransformation> = list(NamedTransformationListParams.none())

    /** @see list */
    fun list(
        params: NamedTransformationListParams = NamedTransformationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<NamedTransformation>

    /** @see list */
    fun list(
        params: NamedTransformationListParams = NamedTransformationListParams.none()
    ): List<NamedTransformation> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): List<NamedTransformation> =
        list(NamedTransformationListParams.none(), requestOptions)

    /**
     * Permanently deletes the named transformation identified by `id`.
     *
     * Deletion fails with a `409` error if the named transformation is still referenced (via the
     * `n-<name>` token) by an upload pre-transformation or post-transformation setting. This check
     * is best-effort and can't detect references in your own application code or in previously
     * generated URLs.
     */
    fun delete(id: String) = delete(id, NamedTransformationDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: NamedTransformationDeleteParams = NamedTransformationDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: NamedTransformationDeleteParams = NamedTransformationDeleteParams.none(),
    ) = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: NamedTransformationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    fun delete(params: NamedTransformationDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions) =
        delete(id, NamedTransformationDeleteParams.none(), requestOptions)

    /** Retrieves the named transformation identified by `id`. */
    fun get(id: String): NamedTransformation = get(id, NamedTransformationGetParams.none())

    /** @see get */
    fun get(
        id: String,
        params: NamedTransformationGetParams = NamedTransformationGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamedTransformation = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see get */
    fun get(
        id: String,
        params: NamedTransformationGetParams = NamedTransformationGetParams.none(),
    ): NamedTransformation = get(id, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: NamedTransformationGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamedTransformation

    /** @see get */
    fun get(params: NamedTransformationGetParams): NamedTransformation =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(id: String, requestOptions: RequestOptions): NamedTransformation =
        get(id, NamedTransformationGetParams.none(), requestOptions)

    /**
     * A view of [NamedTransformationService] that provides access to raw HTTP responses for each
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
        ): NamedTransformationService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/named-transformations`, but is otherwise the
         * same as [NamedTransformationService.create].
         */
        @MustBeClosed
        fun create(params: NamedTransformationCreateParams): HttpResponseFor<NamedTransformation> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: NamedTransformationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamedTransformation>

        /**
         * Returns a raw HTTP response for `patch /v1/named-transformations/{id}`, but is otherwise
         * the same as [NamedTransformationService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<NamedTransformation> =
            update(id, NamedTransformationUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: NamedTransformationUpdateParams = NamedTransformationUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamedTransformation> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: NamedTransformationUpdateParams = NamedTransformationUpdateParams.none(),
        ): HttpResponseFor<NamedTransformation> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: NamedTransformationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamedTransformation>

        /** @see update */
        @MustBeClosed
        fun update(params: NamedTransformationUpdateParams): HttpResponseFor<NamedTransformation> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamedTransformation> =
            update(id, NamedTransformationUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/named-transformations`, but is otherwise the
         * same as [NamedTransformationService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<List<NamedTransformation>> =
            list(NamedTransformationListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: NamedTransformationListParams = NamedTransformationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<NamedTransformation>>

        /** @see list */
        @MustBeClosed
        fun list(
            params: NamedTransformationListParams = NamedTransformationListParams.none()
        ): HttpResponseFor<List<NamedTransformation>> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<List<NamedTransformation>> =
            list(NamedTransformationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/named-transformations/{id}`, but is otherwise
         * the same as [NamedTransformationService.delete].
         */
        @MustBeClosed
        fun delete(id: String): HttpResponse = delete(id, NamedTransformationDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: NamedTransformationDeleteParams = NamedTransformationDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: NamedTransformationDeleteParams = NamedTransformationDeleteParams.none(),
        ): HttpResponse = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: NamedTransformationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: NamedTransformationDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(id: String, requestOptions: RequestOptions): HttpResponse =
            delete(id, NamedTransformationDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/named-transformations/{id}`, but is otherwise
         * the same as [NamedTransformationService.get].
         */
        @MustBeClosed
        fun get(id: String): HttpResponseFor<NamedTransformation> =
            get(id, NamedTransformationGetParams.none())

        /** @see get */
        @MustBeClosed
        fun get(
            id: String,
            params: NamedTransformationGetParams = NamedTransformationGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamedTransformation> =
            get(params.toBuilder().id(id).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(
            id: String,
            params: NamedTransformationGetParams = NamedTransformationGetParams.none(),
        ): HttpResponseFor<NamedTransformation> = get(id, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: NamedTransformationGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamedTransformation>

        /** @see get */
        @MustBeClosed
        fun get(params: NamedTransformationGetParams): HttpResponseFor<NamedTransformation> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(id: String, requestOptions: RequestOptions): HttpResponseFor<NamedTransformation> =
            get(id, NamedTransformationGetParams.none(), requestOptions)
    }
}
