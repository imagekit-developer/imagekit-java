// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponse
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.SavedExtension
import io.imagekit.models.savedextensions.SavedExtensionCreateParams
import io.imagekit.models.savedextensions.SavedExtensionDeleteParams
import io.imagekit.models.savedextensions.SavedExtensionGetParams
import io.imagekit.models.savedextensions.SavedExtensionListParams
import io.imagekit.models.savedextensions.SavedExtensionUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SavedExtensionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SavedExtensionServiceAsync

    /**
     * This API creates a new saved extension. Saved extensions allow you to save complex extension
     * configurations (like AI tasks) and reuse them by referencing the ID in upload or update file
     * APIs.
     *
     * **Saved extension limit** \ You can create a maximum of 100 saved extensions per account.
     */
    fun create(params: SavedExtensionCreateParams): CompletableFuture<SavedExtension> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SavedExtensionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SavedExtension>

    /**
     * This API updates an existing saved extension. You can update the name, description, or
     * config.
     */
    fun update(id: String): CompletableFuture<SavedExtension> =
        update(id, SavedExtensionUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: SavedExtensionUpdateParams = SavedExtensionUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SavedExtension> = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: SavedExtensionUpdateParams = SavedExtensionUpdateParams.none(),
    ): CompletableFuture<SavedExtension> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SavedExtensionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SavedExtension>

    /** @see update */
    fun update(params: SavedExtensionUpdateParams): CompletableFuture<SavedExtension> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): CompletableFuture<SavedExtension> =
        update(id, SavedExtensionUpdateParams.none(), requestOptions)

    /**
     * This API returns an array of all saved extensions for your account. Saved extensions allow
     * you to save complex extension configurations and reuse them by referencing them by ID in
     * upload or update file APIs.
     */
    fun list(): CompletableFuture<List<SavedExtension>> = list(SavedExtensionListParams.none())

    /** @see list */
    fun list(
        params: SavedExtensionListParams = SavedExtensionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<SavedExtension>>

    /** @see list */
    fun list(
        params: SavedExtensionListParams = SavedExtensionListParams.none()
    ): CompletableFuture<List<SavedExtension>> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<SavedExtension>> =
        list(SavedExtensionListParams.none(), requestOptions)

    /** This API deletes a saved extension permanently. */
    fun delete(id: String): CompletableFuture<Void?> = delete(id, SavedExtensionDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: SavedExtensionDeleteParams = SavedExtensionDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: SavedExtensionDeleteParams = SavedExtensionDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: SavedExtensionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: SavedExtensionDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(id, SavedExtensionDeleteParams.none(), requestOptions)

    /** This API returns details of a specific saved extension by ID. */
    fun get(id: String): CompletableFuture<SavedExtension> = get(id, SavedExtensionGetParams.none())

    /** @see get */
    fun get(
        id: String,
        params: SavedExtensionGetParams = SavedExtensionGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SavedExtension> = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see get */
    fun get(
        id: String,
        params: SavedExtensionGetParams = SavedExtensionGetParams.none(),
    ): CompletableFuture<SavedExtension> = get(id, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: SavedExtensionGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SavedExtension>

    /** @see get */
    fun get(params: SavedExtensionGetParams): CompletableFuture<SavedExtension> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(id: String, requestOptions: RequestOptions): CompletableFuture<SavedExtension> =
        get(id, SavedExtensionGetParams.none(), requestOptions)

    /**
     * A view of [SavedExtensionServiceAsync] that provides access to raw HTTP responses for each
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
        ): SavedExtensionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/saved-extensions`, but is otherwise the same as
         * [SavedExtensionServiceAsync.create].
         */
        fun create(
            params: SavedExtensionCreateParams
        ): CompletableFuture<HttpResponseFor<SavedExtension>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: SavedExtensionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SavedExtension>>

        /**
         * Returns a raw HTTP response for `patch /v1/saved-extensions/{id}`, but is otherwise the
         * same as [SavedExtensionServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<SavedExtension>> =
            update(id, SavedExtensionUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: SavedExtensionUpdateParams = SavedExtensionUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SavedExtension>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: SavedExtensionUpdateParams = SavedExtensionUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<SavedExtension>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: SavedExtensionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SavedExtension>>

        /** @see update */
        fun update(
            params: SavedExtensionUpdateParams
        ): CompletableFuture<HttpResponseFor<SavedExtension>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SavedExtension>> =
            update(id, SavedExtensionUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/saved-extensions`, but is otherwise the same as
         * [SavedExtensionServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<SavedExtension>>> =
            list(SavedExtensionListParams.none())

        /** @see list */
        fun list(
            params: SavedExtensionListParams = SavedExtensionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<SavedExtension>>>

        /** @see list */
        fun list(
            params: SavedExtensionListParams = SavedExtensionListParams.none()
        ): CompletableFuture<HttpResponseFor<List<SavedExtension>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<SavedExtension>>> =
            list(SavedExtensionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/saved-extensions/{id}`, but is otherwise the
         * same as [SavedExtensionServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponse> =
            delete(id, SavedExtensionDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: SavedExtensionDeleteParams = SavedExtensionDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: SavedExtensionDeleteParams = SavedExtensionDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: SavedExtensionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: SavedExtensionDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(id, SavedExtensionDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/saved-extensions/{id}`, but is otherwise the
         * same as [SavedExtensionServiceAsync.get].
         */
        fun get(id: String): CompletableFuture<HttpResponseFor<SavedExtension>> =
            get(id, SavedExtensionGetParams.none())

        /** @see get */
        fun get(
            id: String,
            params: SavedExtensionGetParams = SavedExtensionGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SavedExtension>> =
            get(params.toBuilder().id(id).build(), requestOptions)

        /** @see get */
        fun get(
            id: String,
            params: SavedExtensionGetParams = SavedExtensionGetParams.none(),
        ): CompletableFuture<HttpResponseFor<SavedExtension>> =
            get(id, params, RequestOptions.none())

        /** @see get */
        fun get(
            params: SavedExtensionGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SavedExtension>>

        /** @see get */
        fun get(
            params: SavedExtensionGetParams
        ): CompletableFuture<HttpResponseFor<SavedExtension>> = get(params, RequestOptions.none())

        /** @see get */
        fun get(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SavedExtension>> =
            get(id, SavedExtensionGetParams.none(), requestOptions)
    }
}
