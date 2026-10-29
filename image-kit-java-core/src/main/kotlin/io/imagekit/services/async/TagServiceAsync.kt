// File generated from our OpenAPI spec by Stainless.

package io.imagekit.services.async

import io.imagekit.core.ClientOptions
import io.imagekit.core.RequestOptions
import io.imagekit.core.http.HttpResponseFor
import io.imagekit.models.tags.TagListParams
import io.imagekit.models.tags.TagListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TagServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TagServiceAsync

    /**
     * This API lists the distinct tags in use across your media library, with the number of assets
     * each tag is applied to and when it was last used. Tags are matched case-insensitively, so
     * `Summer` and `summer` are one entry: `name` is the lowercased form and `label` is the
     * spelling that was used most recently.
     *
     * Use `tagSource` and `fileType` to list only the tags in use on matching assets. `lastUsedAt`
     * and the `ASC_LAST_USED` / `DESC_LAST_USED` sorts follow those filters, while `assetCount`
     * always counts every asset carrying the tag. Use `search` or `prefix` to narrow the listing
     * and `cursor` to page through it.
     *
     * Tag counts are updated asynchronously. Changes to a file's tags usually appear in this list
     * within about a minute, but can take longer during heavy tagging activity, so a tag you just
     * added or removed may not be reflected immediately.
     */
    fun list(): CompletableFuture<TagListResponse> = list(TagListParams.none())

    /** @see list */
    fun list(
        params: TagListParams = TagListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TagListResponse>

    /** @see list */
    fun list(params: TagListParams = TagListParams.none()): CompletableFuture<TagListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<TagListResponse> =
        list(TagListParams.none(), requestOptions)

    /** A view of [TagServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TagServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/tags`, but is otherwise the same as
         * [TagServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<TagListResponse>> = list(TagListParams.none())

        /** @see list */
        fun list(
            params: TagListParams = TagListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TagListResponse>>

        /** @see list */
        fun list(
            params: TagListParams = TagListParams.none()
        ): CompletableFuture<HttpResponseFor<TagListResponse>> = list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<TagListResponse>> =
            list(TagListParams.none(), requestOptions)
    }
}
