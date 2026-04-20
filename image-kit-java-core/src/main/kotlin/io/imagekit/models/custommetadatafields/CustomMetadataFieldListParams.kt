// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.custommetadatafields

import io.imagekit.core.Params
import io.imagekit.core.http.Headers
import io.imagekit.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * This API returns the array of created custom metadata field objects. By default the API returns
 * only non deleted field objects, but you can include deleted fields in the API response.
 *
 * You can also filter results by a specific folder path to retrieve custom metadata fields
 * applicable at that location. This path-specific filtering is useful when using the **Path
 * policy** feature to determine which custom metadata fields are selected for a given path.
 */
class CustomMetadataFieldListParams
private constructor(
    private val folderPath: String?,
    private val includeDeleted: Boolean?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The folder path (e.g., `/path/to/folder`) for which to retrieve applicable custom metadata
     * fields. Useful for determining path-specific field selections when the
     * [Path policy](https://imagekit.io/docs/dam/path-policy) feature is in use.
     */
    fun folderPath(): Optional<String> = Optional.ofNullable(folderPath)

    /** Set it to `true` to include deleted field objects in the API response. */
    fun includeDeleted(): Optional<Boolean> = Optional.ofNullable(includeDeleted)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): CustomMetadataFieldListParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [CustomMetadataFieldListParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CustomMetadataFieldListParams]. */
    class Builder internal constructor() {

        private var folderPath: String? = null
        private var includeDeleted: Boolean? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(customMetadataFieldListParams: CustomMetadataFieldListParams) = apply {
            folderPath = customMetadataFieldListParams.folderPath
            includeDeleted = customMetadataFieldListParams.includeDeleted
            additionalHeaders = customMetadataFieldListParams.additionalHeaders.toBuilder()
            additionalQueryParams = customMetadataFieldListParams.additionalQueryParams.toBuilder()
        }

        /**
         * The folder path (e.g., `/path/to/folder`) for which to retrieve applicable custom
         * metadata fields. Useful for determining path-specific field selections when the
         * [Path policy](https://imagekit.io/docs/dam/path-policy) feature is in use.
         */
        fun folderPath(folderPath: String?) = apply { this.folderPath = folderPath }

        /** Alias for calling [Builder.folderPath] with `folderPath.orElse(null)`. */
        fun folderPath(folderPath: Optional<String>) = folderPath(folderPath.getOrNull())

        /** Set it to `true` to include deleted field objects in the API response. */
        fun includeDeleted(includeDeleted: Boolean?) = apply {
            this.includeDeleted = includeDeleted
        }

        /**
         * Alias for [Builder.includeDeleted].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun includeDeleted(includeDeleted: Boolean) = includeDeleted(includeDeleted as Boolean?)

        /** Alias for calling [Builder.includeDeleted] with `includeDeleted.orElse(null)`. */
        fun includeDeleted(includeDeleted: Optional<Boolean>) =
            includeDeleted(includeDeleted.getOrNull())

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
         * Returns an immutable instance of [CustomMetadataFieldListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CustomMetadataFieldListParams =
            CustomMetadataFieldListParams(
                folderPath,
                includeDeleted,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                folderPath?.let { put("folderPath", it) }
                includeDeleted?.let { put("includeDeleted", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CustomMetadataFieldListParams &&
            folderPath == other.folderPath &&
            includeDeleted == other.includeDeleted &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(folderPath, includeDeleted, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "CustomMetadataFieldListParams{folderPath=$folderPath, includeDeleted=$includeDeleted, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
