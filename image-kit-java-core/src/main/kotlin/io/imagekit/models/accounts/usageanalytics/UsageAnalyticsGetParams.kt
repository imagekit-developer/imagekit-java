// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.usageanalytics

import io.imagekit.core.Params
import io.imagekit.core.checkRequired
import io.imagekit.core.http.Headers
import io.imagekit.core.http.QueryParams
import java.time.LocalDate
import java.util.Objects

/**
 * **Note:** This API is currently in beta.
 *
 * Get the account analytics data between two dates. The response covers the period from the start
 * date to the end date, both dates inclusive. Both dates are interpreted as UTC calendar days.
 *
 * The returned data is scoped to the requesting account only. Unlike `/v1/accounts/usage`, an
 * agency account's analytics are not aggregated across its child accounts.
 *
 * The response is cached for 5 minutes per account and date range. Use `generatedAt` to check how
 * fresh the returned data is.
 */
class UsageAnalyticsGetParams
private constructor(
    private val endDate: LocalDate,
    private val startDate: LocalDate,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Specify an `endDate` in `YYYY-MM-DD` format, interpreted as a UTC calendar day. It should be
     * after the `startDate`. The difference between `startDate` and `endDate` should be less than
     * 90 days.
     */
    fun endDate(): LocalDate = endDate

    /**
     * Specify a `startDate` in `YYYY-MM-DD` format, interpreted as a UTC calendar day. It should be
     * before the `endDate`. The difference between `startDate` and `endDate` should be less than 90
     * days.
     */
    fun startDate(): LocalDate = startDate

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UsageAnalyticsGetParams].
         *
         * The following fields are required:
         * ```java
         * .endDate()
         * .startDate()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UsageAnalyticsGetParams]. */
    class Builder internal constructor() {

        private var endDate: LocalDate? = null
        private var startDate: LocalDate? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(usageAnalyticsGetParams: UsageAnalyticsGetParams) = apply {
            endDate = usageAnalyticsGetParams.endDate
            startDate = usageAnalyticsGetParams.startDate
            additionalHeaders = usageAnalyticsGetParams.additionalHeaders.toBuilder()
            additionalQueryParams = usageAnalyticsGetParams.additionalQueryParams.toBuilder()
        }

        /**
         * Specify an `endDate` in `YYYY-MM-DD` format, interpreted as a UTC calendar day. It should
         * be after the `startDate`. The difference between `startDate` and `endDate` should be less
         * than 90 days.
         */
        fun endDate(endDate: LocalDate) = apply { this.endDate = endDate }

        /**
         * Specify a `startDate` in `YYYY-MM-DD` format, interpreted as a UTC calendar day. It
         * should be before the `endDate`. The difference between `startDate` and `endDate` should
         * be less than 90 days.
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
         * Returns an immutable instance of [UsageAnalyticsGetParams].
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
        fun build(): UsageAnalyticsGetParams =
            UsageAnalyticsGetParams(
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

        return other is UsageAnalyticsGetParams &&
            endDate == other.endDate &&
            startDate == other.startDate &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(endDate, startDate, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "UsageAnalyticsGetParams{endDate=$endDate, startDate=$startDate, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
