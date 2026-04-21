// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.usage

import io.imagekit.core.Params
import io.imagekit.core.checkRequired
import io.imagekit.core.http.Headers
import io.imagekit.core.http.QueryParams
import java.time.LocalDate
import java.util.Objects

/**
 * Get the account usage information between two dates. Note that the API response includes data
 * from the start date while excluding data from the end date. In other words, the data covers the
 * period starting from the specified start date up to, but not including, the end date.
 */
class UsageGetParams
private constructor(
    private val endDate: LocalDate,
    private val startDate: LocalDate,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Specify a `endDate` in `YYYY-MM-DD` format. It should be after the `startDate`. The
     * difference between `startDate` and `endDate` should be less than 90 days.
     */
    fun endDate(): LocalDate = endDate

    /**
     * Specify a `startDate` in `YYYY-MM-DD` format. It should be before the `endDate`. The
     * difference between `startDate` and `endDate` should be less than 90 days.
     */
    fun startDate(): LocalDate = startDate

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UsageGetParams].
         *
         * The following fields are required:
         * ```java
         * .endDate()
         * .startDate()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UsageGetParams]. */
    class Builder internal constructor() {

        private var endDate: LocalDate? = null
        private var startDate: LocalDate? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(usageGetParams: UsageGetParams) = apply {
            endDate = usageGetParams.endDate
            startDate = usageGetParams.startDate
            additionalHeaders = usageGetParams.additionalHeaders.toBuilder()
            additionalQueryParams = usageGetParams.additionalQueryParams.toBuilder()
        }

        /**
         * Specify a `endDate` in `YYYY-MM-DD` format. It should be after the `startDate`. The
         * difference between `startDate` and `endDate` should be less than 90 days.
         */
        fun endDate(endDate: LocalDate) = apply { this.endDate = endDate }

        /**
         * Specify a `startDate` in `YYYY-MM-DD` format. It should be before the `endDate`. The
         * difference between `startDate` and `endDate` should be less than 90 days.
         */
        fun startDate(startDate: LocalDate) = apply { this.startDate = startDate }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [UsageGetParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .endDate()
         * .startDate()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UsageGetParams =
            UsageGetParams(
                checkRequired("endDate", endDate),
                checkRequired("startDate", startDate),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("endDate", endDate.toString())
                put("startDate", startDate.toString())
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UsageGetParams &&
            endDate == other.endDate &&
            startDate == other.startDate &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(endDate, startDate, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "UsageGetParams{endDate=$endDate, startDate=$startDate, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
