// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

interface CustomMetadataFieldService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CustomMetadataFieldService

    /**
     * This API creates a new custom metadata field. Once a custom metadata field is created either
     * through this API or using the dashboard UI, its value can be set on the assets. The value of
     * a field for an asset can be set using the media library UI or programmatically through upload
     * or update assets API.
     */
    fun create(params: CustomMetadataFieldCreateParams): CustomMetadataFieldCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CustomMetadataFieldCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CustomMetadataFieldCreateResponse

    /** This API updates the label or schema of an existing custom metadata field. */
    fun update(id: String): CustomMetadataFieldUpdateResponse =
        update(id, CustomMetadataFieldUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CustomMetadataFieldUpdateResponse = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
    ): CustomMetadataFieldUpdateResponse = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: CustomMetadataFieldUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CustomMetadataFieldUpdateResponse

    /** @see update */
    fun update(params: CustomMetadataFieldUpdateParams): CustomMetadataFieldUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): CustomMetadataFieldUpdateResponse =
        update(id, CustomMetadataFieldUpdateParams.none(), requestOptions)

    /**
     * This API returns the array of created custom metadata field objects. By default the API
     * returns only non deleted field objects, but you can include deleted fields in the API
     * response.
     */
    fun list(): List<CustomMetadataFieldListResponse> = list(CustomMetadataFieldListParams.none())

    /** @see list */
    fun list(
        params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<CustomMetadataFieldListResponse>

    /** @see list */
    fun list(
        params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none()
    ): List<CustomMetadataFieldListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): List<CustomMetadataFieldListResponse> =
        list(CustomMetadataFieldListParams.none(), requestOptions)

    /**
     * This API deletes a custom metadata field. Even after deleting a custom metadata field, you
     * cannot create any new custom metadata field with the same name.
     */
    fun delete(id: String): CustomMetadataFieldDeleteResponse =
        delete(id, CustomMetadataFieldDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: CustomMetadataFieldDeleteParams = CustomMetadataFieldDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CustomMetadataFieldDeleteResponse = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: CustomMetadataFieldDeleteParams = CustomMetadataFieldDeleteParams.none(),
    ): CustomMetadataFieldDeleteResponse = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: CustomMetadataFieldDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CustomMetadataFieldDeleteResponse

    /** @see delete */
    fun delete(params: CustomMetadataFieldDeleteParams): CustomMetadataFieldDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CustomMetadataFieldDeleteResponse =
        delete(id, CustomMetadataFieldDeleteParams.none(), requestOptions)

    /**
     * A view of [CustomMetadataFieldService] that provides access to raw HTTP responses for each
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
        ): CustomMetadataFieldService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/customMetadataFields`, but is otherwise the
         * same as [CustomMetadataFieldService.create].
         */
        @MustBeClosed
        fun create(
            params: CustomMetadataFieldCreateParams
        ): HttpResponseFor<CustomMetadataFieldCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: CustomMetadataFieldCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CustomMetadataFieldCreateResponse>

        /**
         * Returns a raw HTTP response for `patch /v1/customMetadataFields/{id}`, but is otherwise
         * the same as [CustomMetadataFieldService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<CustomMetadataFieldUpdateResponse> =
            update(id, CustomMetadataFieldUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CustomMetadataFieldUpdateResponse> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: CustomMetadataFieldUpdateParams = CustomMetadataFieldUpdateParams.none(),
        ): HttpResponseFor<CustomMetadataFieldUpdateResponse> =
            update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: CustomMetadataFieldUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CustomMetadataFieldUpdateResponse>

        /** @see update */
        @MustBeClosed
        fun update(
            params: CustomMetadataFieldUpdateParams
        ): HttpResponseFor<CustomMetadataFieldUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CustomMetadataFieldUpdateResponse> =
            update(id, CustomMetadataFieldUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/customMetadataFields`, but is otherwise the same
         * as [CustomMetadataFieldService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<List<CustomMetadataFieldListResponse>> =
            list(CustomMetadataFieldListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<CustomMetadataFieldListResponse>>

        /** @see list */
        @MustBeClosed
        fun list(
            params: CustomMetadataFieldListParams = CustomMetadataFieldListParams.none()
        ): HttpResponseFor<List<CustomMetadataFieldListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): HttpResponseFor<List<CustomMetadataFieldListResponse>> =
            list(CustomMetadataFieldListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/customMetadataFields/{id}`, but is otherwise
         * the same as [CustomMetadataFieldService.delete].
         */
        @MustBeClosed
        fun delete(id: String): HttpResponseFor<CustomMetadataFieldDeleteResponse> =
            delete(id, CustomMetadataFieldDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: CustomMetadataFieldDeleteParams = CustomMetadataFieldDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CustomMetadataFieldDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: CustomMetadataFieldDeleteParams = CustomMetadataFieldDeleteParams.none(),
        ): HttpResponseFor<CustomMetadataFieldDeleteResponse> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: CustomMetadataFieldDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CustomMetadataFieldDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: CustomMetadataFieldDeleteParams
        ): HttpResponseFor<CustomMetadataFieldDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CustomMetadataFieldDeleteResponse> =
            delete(id, CustomMetadataFieldDeleteParams.none(), requestOptions)
    }
}
