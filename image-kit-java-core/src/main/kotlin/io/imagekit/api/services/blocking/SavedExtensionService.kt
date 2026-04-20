// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import io.imagekit.api.core.ClientOptions
import io.imagekit.api.core.RequestOptions
import io.imagekit.api.core.http.HttpResponse
import io.imagekit.api.core.http.HttpResponseFor
import io.imagekit.api.models.SavedExtension
import io.imagekit.api.models.savedextensions.SavedExtensionCreateParams
import io.imagekit.api.models.savedextensions.SavedExtensionDeleteParams
import io.imagekit.api.models.savedextensions.SavedExtensionGetParams
import io.imagekit.api.models.savedextensions.SavedExtensionListParams
import io.imagekit.api.models.savedextensions.SavedExtensionUpdateParams
import java.util.function.Consumer

interface SavedExtensionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SavedExtensionService

    /**
     * This API creates a new saved extension. Saved extensions allow you to save complex extension
     * configurations (like AI tasks) and reuse them by referencing the ID in upload or update file
     * APIs.
     *
     * **Saved extension limit** \ You can create a maximum of 100 saved extensions per account.
     */
    fun create(params: SavedExtensionCreateParams): SavedExtension =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SavedExtensionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SavedExtension

    /**
     * This API updates an existing saved extension. You can update the name, description, or
     * config.
     */
    fun update(id: String): SavedExtension = update(id, SavedExtensionUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: SavedExtensionUpdateParams = SavedExtensionUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SavedExtension = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: SavedExtensionUpdateParams = SavedExtensionUpdateParams.none(),
    ): SavedExtension = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SavedExtensionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SavedExtension

    /** @see update */
    fun update(params: SavedExtensionUpdateParams): SavedExtension =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): SavedExtension =
        update(id, SavedExtensionUpdateParams.none(), requestOptions)

    /**
     * This API returns an array of all saved extensions for your account. Saved extensions allow
     * you to save complex extension configurations and reuse them by referencing them by ID in
     * upload or update file APIs.
     */
    fun list(): List<SavedExtension> = list(SavedExtensionListParams.none())

    /** @see list */
    fun list(
        params: SavedExtensionListParams = SavedExtensionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<SavedExtension>

    /** @see list */
    fun list(
        params: SavedExtensionListParams = SavedExtensionListParams.none()
    ): List<SavedExtension> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): List<SavedExtension> =
        list(SavedExtensionListParams.none(), requestOptions)

    /** This API deletes a saved extension permanently. */
    fun delete(id: String) = delete(id, SavedExtensionDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: SavedExtensionDeleteParams = SavedExtensionDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(id: String, params: SavedExtensionDeleteParams = SavedExtensionDeleteParams.none()) =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: SavedExtensionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    fun delete(params: SavedExtensionDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions) =
        delete(id, SavedExtensionDeleteParams.none(), requestOptions)

    /** This API returns details of a specific saved extension by ID. */
    fun get(id: String): SavedExtension = get(id, SavedExtensionGetParams.none())

    /** @see get */
    fun get(
        id: String,
        params: SavedExtensionGetParams = SavedExtensionGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SavedExtension = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see get */
    fun get(
        id: String,
        params: SavedExtensionGetParams = SavedExtensionGetParams.none(),
    ): SavedExtension = get(id, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: SavedExtensionGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SavedExtension

    /** @see get */
    fun get(params: SavedExtensionGetParams): SavedExtension = get(params, RequestOptions.none())

    /** @see get */
    fun get(id: String, requestOptions: RequestOptions): SavedExtension =
        get(id, SavedExtensionGetParams.none(), requestOptions)

    /**
     * A view of [SavedExtensionService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SavedExtensionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/saved-extensions`, but is otherwise the same as
         * [SavedExtensionService.create].
         */
        @MustBeClosed
        fun create(params: SavedExtensionCreateParams): HttpResponseFor<SavedExtension> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: SavedExtensionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SavedExtension>

        /**
         * Returns a raw HTTP response for `patch /v1/saved-extensions/{id}`, but is otherwise the
         * same as [SavedExtensionService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<SavedExtension> =
            update(id, SavedExtensionUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: SavedExtensionUpdateParams = SavedExtensionUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SavedExtension> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: SavedExtensionUpdateParams = SavedExtensionUpdateParams.none(),
        ): HttpResponseFor<SavedExtension> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: SavedExtensionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SavedExtension>

        /** @see update */
        @MustBeClosed
        fun update(params: SavedExtensionUpdateParams): HttpResponseFor<SavedExtension> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(id: String, requestOptions: RequestOptions): HttpResponseFor<SavedExtension> =
            update(id, SavedExtensionUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/saved-extensions`, but is otherwise the same as
         * [SavedExtensionService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<List<SavedExtension>> = list(SavedExtensionListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: SavedExtensionListParams = SavedExtensionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<SavedExtension>>

        /** @see list */
        @MustBeClosed
        fun list(
            params: SavedExtensionListParams = SavedExtensionListParams.none()
        ): HttpResponseFor<List<SavedExtension>> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<List<SavedExtension>> =
            list(SavedExtensionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/saved-extensions/{id}`, but is otherwise the
         * same as [SavedExtensionService.delete].
         */
        @MustBeClosed
        fun delete(id: String): HttpResponse = delete(id, SavedExtensionDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: SavedExtensionDeleteParams = SavedExtensionDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: SavedExtensionDeleteParams = SavedExtensionDeleteParams.none(),
        ): HttpResponse = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: SavedExtensionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: SavedExtensionDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(id: String, requestOptions: RequestOptions): HttpResponse =
            delete(id, SavedExtensionDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/saved-extensions/{id}`, but is otherwise the
         * same as [SavedExtensionService.get].
         */
        @MustBeClosed
        fun get(id: String): HttpResponseFor<SavedExtension> =
            get(id, SavedExtensionGetParams.none())

        /** @see get */
        @MustBeClosed
        fun get(
            id: String,
            params: SavedExtensionGetParams = SavedExtensionGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SavedExtension> = get(params.toBuilder().id(id).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(
            id: String,
            params: SavedExtensionGetParams = SavedExtensionGetParams.none(),
        ): HttpResponseFor<SavedExtension> = get(id, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: SavedExtensionGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SavedExtension>

        /** @see get */
        @MustBeClosed
        fun get(params: SavedExtensionGetParams): HttpResponseFor<SavedExtension> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(id: String, requestOptions: RequestOptions): HttpResponseFor<SavedExtension> =
            get(id, SavedExtensionGetParams.none(), requestOptions)
    }
}
