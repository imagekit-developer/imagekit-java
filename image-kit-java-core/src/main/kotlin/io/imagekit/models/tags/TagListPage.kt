// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.tags

import io.imagekit.core.AutoPager
import io.imagekit.core.Page
import io.imagekit.core.checkRequired
import io.imagekit.services.blocking.TagService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see TagService.list */
class TagListPage
private constructor(
    private val service: TagService,
    private val params: TagListParams,
    private val response: TagListPageResponse,
) : Page<Tag> {

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

    override fun nextPage(): TagListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Tag> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): TagListParams = params

    /** The response that this page was parsed from. */
    fun response(): TagListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TagListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TagListPage]. */
    class Builder internal constructor() {

        private var service: TagService? = null
        private var params: TagListParams? = null
        private var response: TagListPageResponse? = null

        @JvmSynthetic
        internal fun from(tagListPage: TagListPage) = apply {
            service = tagListPage.service
            params = tagListPage.params
            response = tagListPage.response
        }

        fun service(service: TagService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: TagListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TagListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TagListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TagListPage =
            TagListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TagListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "TagListPage{service=$service, params=$params, response=$response}"
}
