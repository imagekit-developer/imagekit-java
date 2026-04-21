// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.custommetadatafields.CustomMetadataField
import io.imagekit.models.custommetadatafields.CustomMetadataFieldCreateParams
import io.imagekit.models.custommetadatafields.CustomMetadataFieldDeleteParams
import io.imagekit.models.custommetadatafields.CustomMetadataFieldDeleteResponse
import io.imagekit.models.custommetadatafields.CustomMetadataFieldListParams
import io.imagekit.models.custommetadatafields.CustomMetadataFieldUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CustomMetadataFieldServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CustomMetadataFieldServiceAsync

    /**
     * This API creates a new custom metadata field. Once a custom metadata field is created either
     * through this API or using the dashboard UI, its value can be set on the assets. The value of
     * a field for an asset can be set using the media library UI or programmatically through upload
     * or update assets API.
     */
    fun create(params: CustomMetadataFieldCreateParams): CompletableFuture<CustomMetadataField> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CustomMetadataFieldCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomMetadataField>

    /** This API updates the label or schema of an existing custom metadata field. */
    fun update(id: String): CompletableFuture<CustomMetadataField> =
        update(id, CustomMetadataFieldUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomMetadataField> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
    ): CompletableFuture<CustomMetadataField> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: CustomMetadataFieldUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomMetadataField>

    /** @see update */
    fun update(params: CustomMetadataFieldUpdateParams): CompletableFuture<CustomMetadataField> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): CompletableFuture<CustomMetadataField> =
        update(id, CustomMetadataFieldUpdateParams.none(), requestOptions)

    /**
     * This API returns the array of created custom metadata field objects. By default the API
     * returns only non deleted field objects, but you can include deleted fields in the API
     * response.
     *
     * You can also filter results by a specific folder path to retrieve custom metadata fields
     * applicable at that location. This path-specific filtering is useful when using the **Path
     * policy** feature to determine which custom metadata fields are selected for a given path.
     */
    fun list(): CompletableFuture<List<CustomMetadataField>> =
        list(CustomMetadataFieldListParams.none())

    /** @see list */
    fun list(
        params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<CustomMetadataField>>

    /** @see list */
    fun list(
        params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none()
    ): CompletableFuture<List<CustomMetadataField>> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<CustomMetadataField>> =
        list(CustomMetadataFieldListParams.none(), requestOptions)

    /**
     * This API deletes a custom metadata field. Even after deleting a custom metadata field, you
     * cannot create any new custom metadata field with the same name.
     */
    fun delete(id: String): CompletableFuture<CustomMetadataFieldDeleteResponse> =
        delete(id, CustomMetadataFieldDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: CustomMetadataFieldDeleteParams = CustomMetadataFieldDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomMetadataFieldDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: CustomMetadataFieldDeleteParams = CustomMetadataFieldDeleteParams.none(),
    ): CompletableFuture<CustomMetadataFieldDeleteResponse> =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: CustomMetadataFieldDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomMetadataFieldDeleteResponse>

    /** @see delete */
    fun delete(
        params: CustomMetadataFieldDeleteParams
    ): CompletableFuture<CustomMetadataFieldDeleteResponse> = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CustomMetadataFieldDeleteResponse> =
        delete(id, CustomMetadataFieldDeleteParams.none(), requestOptions)

    /**
     * A view of [CustomMetadataFieldServiceAsync] that provides access to raw HTTP responses for
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
        ): CustomMetadataFieldServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/customMetadataFields`, but is otherwise the
         * same as [CustomMetadataFieldServiceAsync.create].
         */
        fun create(
            params: CustomMetadataFieldCreateParams
        ): CompletableFuture<HttpResponseFor<CustomMetadataField>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: CustomMetadataFieldCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomMetadataField>>

        /**
         * Returns a raw HTTP response for `patch /v1/customMetadataFields/{id}`, but is otherwise
         * the same as [CustomMetadataFieldServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<CustomMetadataField>> =
            update(id, CustomMetadataFieldUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomMetadataField>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<CustomMetadataField>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: CustomMetadataFieldUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomMetadataField>>

        /** @see update */
        fun update(
            params: CustomMetadataFieldUpdateParams
        ): CompletableFuture<HttpResponseFor<CustomMetadataField>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomMetadataField>> =
            update(id, CustomMetadataFieldUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/customMetadataFields`, but is otherwise the same
         * as [CustomMetadataFieldServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<CustomMetadataField>>> =
            list(CustomMetadataFieldListParams.none())

        /** @see list */
        fun list(
            params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<CustomMetadataField>>>

        /** @see list */
        fun list(
            params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none()
        ): CompletableFuture<HttpResponseFor<List<CustomMetadataField>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<CustomMetadataField>>> =
            list(CustomMetadataFieldListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/customMetadataFields/{id}`, but is otherwise
         * the same as [CustomMetadataFieldServiceAsync.delete].
         */
        fun delete(
            id: String
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldDeleteResponse>> =
            delete(id, CustomMetadataFieldDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: CustomMetadataFieldDeleteParams = CustomMetadataFieldDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: CustomMetadataFieldDeleteParams = CustomMetadataFieldDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: CustomMetadataFieldDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldDeleteResponse>>

        /** @see delete */
        fun delete(
            params: CustomMetadataFieldDeleteParams
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldDeleteResponse>> =
            delete(id, CustomMetadataFieldDeleteParams.none(), requestOptions)
    }
}
