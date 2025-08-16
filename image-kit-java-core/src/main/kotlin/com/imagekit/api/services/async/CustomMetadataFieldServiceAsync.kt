// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.RequestOptions
import com.imagekit.api.core.http.HttpResponseFor
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldCreateParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldCreateResponse
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldDeleteParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldDeleteResponse
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldListParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldListResponse
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldUpdateParams
import com.imagekit.api.models.custommetadatafields.CustomMetadataFieldUpdateResponse
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
    fun create(
        params: CustomMetadataFieldCreateParams
    ): CompletableFuture<CustomMetadataFieldCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CustomMetadataFieldCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomMetadataFieldCreateResponse>

    /** This API updates the label or schema of an existing custom metadata field. */
    fun update(id: String): CompletableFuture<CustomMetadataFieldUpdateResponse> =
        update(id, CustomMetadataFieldUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomMetadataFieldUpdateResponse> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
    ): CompletableFuture<CustomMetadataFieldUpdateResponse> =
        update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: CustomMetadataFieldUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomMetadataFieldUpdateResponse>

    /** @see update */
    fun update(
        params: CustomMetadataFieldUpdateParams
    ): CompletableFuture<CustomMetadataFieldUpdateResponse> = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CustomMetadataFieldUpdateResponse> =
        update(id, CustomMetadataFieldUpdateParams.none(), requestOptions)

    /**
     * This API returns the array of created custom metadata field objects. By default the API
     * returns only non deleted field objects, but you can include deleted fields in the API
     * response.
     */
    fun list(): CompletableFuture<List<CustomMetadataFieldListResponse>> =
        list(CustomMetadataFieldListParams.none())

    /** @see list */
    fun list(
        params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<CustomMetadataFieldListResponse>>

    /** @see list */
    fun list(
        params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none()
    ): CompletableFuture<List<CustomMetadataFieldListResponse>> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        requestOptions: RequestOptions
    ): CompletableFuture<List<CustomMetadataFieldListResponse>> =
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
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: CustomMetadataFieldCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldCreateResponse>>

        /**
         * Returns a raw HTTP response for `patch /v1/customMetadataFields/{id}`, but is otherwise
         * the same as [CustomMetadataFieldServiceAsync.update].
         */
        fun update(
            id: String
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldUpdateResponse>> =
            update(id, CustomMetadataFieldUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldUpdateResponse>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldUpdateResponse>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: CustomMetadataFieldUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldUpdateResponse>>

        /** @see update */
        fun update(
            params: CustomMetadataFieldUpdateParams
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomMetadataFieldUpdateResponse>> =
            update(id, CustomMetadataFieldUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/customMetadataFields`, but is otherwise the same
         * as [CustomMetadataFieldServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<CustomMetadataFieldListResponse>>> =
            list(CustomMetadataFieldListParams.none())

        /** @see list */
        fun list(
            params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<CustomMetadataFieldListResponse>>>

        /** @see list */
        fun list(
            params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none()
        ): CompletableFuture<HttpResponseFor<List<CustomMetadataFieldListResponse>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<CustomMetadataFieldListResponse>>> =
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
