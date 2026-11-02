// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.tags

import io.imagekit.core.AutoPagerAsync
import io.imagekit.core.PageAsync
import io.imagekit.core.checkRequired
import io.imagekit.services.async.TagServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see TagServiceAsync.list */
class TagListPageAsync
private constructor(
    private val service: TagServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: TagListParams,
    private val response: TagListPageResponse,
) : PageAsync<Tag> {

    /**
     * Delegates to [TagListPageResponse], but gracefully handles missing data.
     *
     * @see TagListPageResponse.tags
     */
    fun tags(): List<Tag> = response._tags().getOptional("tags").getOrNull() ?: emptyList()

    /**
     * Delegates to [TagListPageResponse], but gracefully handles missing data.
     *
     * @see TagListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("nextCursor")

    override fun items(): List<Tag> = tags()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): TagListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<TagListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Tag> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): TagListParams = params

    /** The response that this page was parsed from. */
    fun response(): TagListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TagListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TagListPageAsync]. */
    class Builder internal constructor() {

        private var service: TagServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: TagListParams? = null
        private var response: TagListPageResponse? = null

        @JvmSynthetic
        internal fun from(tagListPageAsync: TagListPageAsync) = apply {
            service = tagListPageAsync.service
            streamHandlerExecutor = tagListPageAsync.streamHandlerExecutor
            params = tagListPageAsync.params
            response = tagListPageAsync.response
        }

        fun service(service: TagServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: TagListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TagListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TagListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TagListPageAsync =
            TagListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TagListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "TagListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
