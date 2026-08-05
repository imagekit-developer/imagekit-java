// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.NamedTransformation
import io.imagekit.models.namedtransformations.NamedTransformationCreateParams
import io.imagekit.models.namedtransformations.NamedTransformationDeleteParams
import io.imagekit.models.namedtransformations.NamedTransformationGetParams
import io.imagekit.models.namedtransformations.NamedTransformationListParams
import io.imagekit.models.namedtransformations.NamedTransformationUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface NamedTransformationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NamedTransformationServiceAsync

    /**
     * Creates a new named transformation and returns the created object.
     *
     * Named transformations let you assign a short, reusable name to a complex transformation
     * string, so it can be applied in image and video URLs as `tr:n-<name>` and later updated
     * without changing any existing URLs.
     *
     * Learn more about
     * [named transformations](https://imagekit.io/docs/transformations#named-transformations).
     */
    fun create(params: NamedTransformationCreateParams): CompletableFuture<NamedTransformation> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: NamedTransformationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamedTransformation>

    /**
     * Updates the named transformation identified by `id` and returns the updated object. Only the
     * fields present in the request body are updated; omitted fields are left unchanged.
     */
    fun update(id: String): CompletableFuture<NamedTransformation> =
        update(id, NamedTransformationUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: NamedTransformationUpdateParams = NamedTransformationUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamedTransformation> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: NamedTransformationUpdateParams = NamedTransformationUpdateParams.none(),
    ): CompletableFuture<NamedTransformation> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: NamedTransformationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamedTransformation>

    /** @see update */
    fun update(params: NamedTransformationUpdateParams): CompletableFuture<NamedTransformation> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): CompletableFuture<NamedTransformation> =
        update(id, NamedTransformationUpdateParams.none(), requestOptions)

    /** Returns an array of all named transformations configured for your account. */
    fun list(): CompletableFuture<List<NamedTransformation>> =
        list(NamedTransformationListParams.none())

    /** @see list */
    fun list(
        params: NamedTransformationListParams = NamedTransformationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<NamedTransformation>>

    /** @see list */
    fun list(
        params: NamedTransformationListParams = NamedTransformationListParams.none()
    ): CompletableFuture<List<NamedTransformation>> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<NamedTransformation>> =
        list(NamedTransformationListParams.none(), requestOptions)

    /**
     * Permanently deletes the named transformation identified by `id` and returns the deleted
     * object.
     *
     * **Note:**
     * - If another named transformation, or your account's upload
     *   pre-transformation/post-transformation settings, reference this named transformation (via
     *   the `n-<name>` token), the request fails with a `409` error whose `message` describes what
     *   it is referenced by. Remove those references first, then retry the deletion. This is a
     *   best-effort check and cannot detect references baked into your own application code or
     *   previously generated URLs.
     */
    fun delete(id: String): CompletableFuture<NamedTransformation> =
        delete(id, NamedTransformationDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: NamedTransformationDeleteParams = NamedTransformationDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamedTransformation> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: NamedTransformationDeleteParams = NamedTransformationDeleteParams.none(),
    ): CompletableFuture<NamedTransformation> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: NamedTransformationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamedTransformation>

    /** @see delete */
    fun delete(params: NamedTransformationDeleteParams): CompletableFuture<NamedTransformation> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<NamedTransformation> =
        delete(id, NamedTransformationDeleteParams.none(), requestOptions)

    /** Retrieves the named transformation identified by `id`. */
    fun get(id: String): CompletableFuture<NamedTransformation> =
        get(id, NamedTransformationGetParams.none())

    /** @see get */
    fun get(
        id: String,
        params: NamedTransformationGetParams = NamedTransformationGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamedTransformation> =
        get(params.toBuilder().id(id).build(), requestOptions)

    /** @see get */
    fun get(
        id: String,
        params: NamedTransformationGetParams = NamedTransformationGetParams.none(),
    ): CompletableFuture<NamedTransformation> = get(id, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: NamedTransformationGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamedTransformation>

    /** @see get */
    fun get(params: NamedTransformationGetParams): CompletableFuture<NamedTransformation> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(id: String, requestOptions: RequestOptions): CompletableFuture<NamedTransformation> =
        get(id, NamedTransformationGetParams.none(), requestOptions)

    /**
     * A view of [NamedTransformationServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NamedTransformationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/named-transformations`, but is otherwise the
         * same as [NamedTransformationServiceAsync.create].
         */
        fun create(
            params: NamedTransformationCreateParams
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: NamedTransformationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamedTransformation>>

        /**
         * Returns a raw HTTP response for `patch /v1/named-transformations/{id}`, but is otherwise
         * the same as [NamedTransformationServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            update(id, NamedTransformationUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: NamedTransformationUpdateParams = NamedTransformationUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: NamedTransformationUpdateParams = NamedTransformationUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: NamedTransformationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamedTransformation>>

        /** @see update */
        fun update(
            params: NamedTransformationUpdateParams
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            update(id, NamedTransformationUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/named-transformations`, but is otherwise the
         * same as [NamedTransformationServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<NamedTransformation>>> =
            list(NamedTransformationListParams.none())

        /** @see list */
        fun list(
            params: NamedTransformationListParams = NamedTransformationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<NamedTransformation>>>

        /** @see list */
        fun list(
            params: NamedTransformationListParams = NamedTransformationListParams.none()
        ): CompletableFuture<HttpResponseFor<List<NamedTransformation>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<NamedTransformation>>> =
            list(NamedTransformationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/named-transformations/{id}`, but is otherwise
         * the same as [NamedTransformationServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            delete(id, NamedTransformationDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: NamedTransformationDeleteParams = NamedTransformationDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: NamedTransformationDeleteParams = NamedTransformationDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: NamedTransformationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamedTransformation>>

        /** @see delete */
        fun delete(
            params: NamedTransformationDeleteParams
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            delete(id, NamedTransformationDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/named-transformations/{id}`, but is otherwise
         * the same as [NamedTransformationServiceAsync.get].
         */
        fun get(id: String): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            get(id, NamedTransformationGetParams.none())

        /** @see get */
        fun get(
            id: String,
            params: NamedTransformationGetParams = NamedTransformationGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            get(params.toBuilder().id(id).build(), requestOptions)

        /** @see get */
        fun get(
            id: String,
            params: NamedTransformationGetParams = NamedTransformationGetParams.none(),
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            get(id, params, RequestOptions.none())

        /** @see get */
        fun get(
            params: NamedTransformationGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamedTransformation>>

        /** @see get */
        fun get(
            params: NamedTransformationGetParams
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamedTransformation>> =
            get(id, NamedTransformationGetParams.none(), requestOptions)
    }
}
