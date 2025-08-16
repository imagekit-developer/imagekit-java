// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.annotation.JsonCreator
import com.imagekit.api.core.Enum
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.Params
import com.imagekit.api.core.http.Headers
import com.imagekit.api.core.http.QueryParams
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * This API can list all the uploaded files and folders in your ImageKit.io media library. In
 * addition, you can fine-tune your query by specifying various filters by generating a query string
 * in a Lucene-like syntax and provide this generated string as the value of the `searchQuery`.
 */
class FileListParams
private constructor(
    private val fileType: String?,
    private val limit: String?,
    private val path: String?,
    private val searchQuery: String?,
    private val skip: String?,
    private val sort: String?,
    private val type: Type?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Type of files to include in the result set. Accepts three values:
     *
     * `all` - include all types of files in the result set. `image` - only search in image type
     * files. `non-image` - only search in files that are not images, e.g., JS or CSS or video
     * files.
     *
     * Default value - `all`
     */
    fun fileType(): Optional<String> = Optional.ofNullable(fileType)

    /**
     * The maximum number of results to return in response:
     *
     * Minimum value - 1
     *
     * Maximum value - 1000
     *
     * Default value - 1000
     */
    fun limit(): Optional<String> = Optional.ofNullable(limit)

    /**
     * Folder path if you want to limit the search within a specific folder. For example,
     * `/sales-banner/` will only search in folder sales-banner.
     */
    fun path(): Optional<String> = Optional.ofNullable(path)

    /**
     * Query string in a Lucene-like query language e.g. `createdAt > "7d"`.
     *
     * Note : When the searchQuery parameter is present, the following query parameters will have no
     * effect on the result:
     * 1. `tags`
     * 2. `type`
     * 3. `name`
     *
     * [Learn
     * more](/docs/api-reference/digital-asset-management-dam/list-and-search-assets#advanced-search-queries)
     * from examples.
     */
    fun searchQuery(): Optional<String> = Optional.ofNullable(searchQuery)

    /**
     * The number of results to skip before returning results:
     *
     * Minimum value - 0
     *
     * Default value - 0
     */
    fun skip(): Optional<String> = Optional.ofNullable(skip)

    /**
     * You can sort based on the following fields:
     * 1. name - `ASC_NAME` or `DESC_NAME`
     * 2. createdAt - `ASC_CREATED` or `DESC_CREATED`
     * 3. updatedAt - `ASC_UPDATED` or `DESC_UPDATED`
     * 4. height - `ASC_HEIGHT` or `DESC_HEIGHT`
     * 5. width - `ASC_WIDTH` or `DESC_WIDTH`
     * 6. size - `ASC_SIZE` or `DESC_SIZE`
     *
     * Default value - `ASC_CREATED`
     */
    fun sort(): Optional<String> = Optional.ofNullable(sort)

    /**
     * Limit search to one of `file`, `file-version`, or `folder`. Pass `all` to include `files` and
     * `folders` in search results (`file-version` will not be included in this case).
     *
     * Default value - `file`
     */
    fun type(): Optional<Type> = Optional.ofNullable(type)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): FileListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [FileListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileListParams]. */
    class Builder internal constructor() {

        private var fileType: String? = null
        private var limit: String? = null
        private var path: String? = null
        private var searchQuery: String? = null
        private var skip: String? = null
        private var sort: String? = null
        private var type: Type? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fileListParams: FileListParams) = apply {
            fileType = fileListParams.fileType
            limit = fileListParams.limit
            path = fileListParams.path
            searchQuery = fileListParams.searchQuery
            skip = fileListParams.skip
            sort = fileListParams.sort
            type = fileListParams.type
            additionalHeaders = fileListParams.additionalHeaders.toBuilder()
            additionalQueryParams = fileListParams.additionalQueryParams.toBuilder()
        }

        /**
         * Type of files to include in the result set. Accepts three values:
         *
         * `all` - include all types of files in the result set. `image` - only search in image type
         * files. `non-image` - only search in files that are not images, e.g., JS or CSS or video
         * files.
         *
         * Default value - `all`
         */
        fun fileType(fileType: String?) = apply { this.fileType = fileType }

        /** Alias for calling [Builder.fileType] with `fileType.orElse(null)`. */
        fun fileType(fileType: Optional<String>) = fileType(fileType.getOrNull())

        /**
         * The maximum number of results to return in response:
         *
         * Minimum value - 1
         *
         * Maximum value - 1000
         *
         * Default value - 1000
         */
        fun limit(limit: String?) = apply { this.limit = limit }

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<String>) = limit(limit.getOrNull())

        /**
         * Folder path if you want to limit the search within a specific folder. For example,
         * `/sales-banner/` will only search in folder sales-banner.
         */
        fun path(path: String?) = apply { this.path = path }

        /** Alias for calling [Builder.path] with `path.orElse(null)`. */
        fun path(path: Optional<String>) = path(path.getOrNull())

        /**
         * Query string in a Lucene-like query language e.g. `createdAt > "7d"`.
         *
         * Note : When the searchQuery parameter is present, the following query parameters will
         * have no effect on the result:
         * 1. `tags`
         * 2. `type`
         * 3. `name`
         *
         * [Learn
         * more](/docs/api-reference/digital-asset-management-dam/list-and-search-assets#advanced-search-queries)
         * from examples.
         */
        fun searchQuery(searchQuery: String?) = apply { this.searchQuery = searchQuery }

        /** Alias for calling [Builder.searchQuery] with `searchQuery.orElse(null)`. */
        fun searchQuery(searchQuery: Optional<String>) = searchQuery(searchQuery.getOrNull())

        /**
         * The number of results to skip before returning results:
         *
         * Minimum value - 0
         *
         * Default value - 0
         */
        fun skip(skip: String?) = apply { this.skip = skip }

        /** Alias for calling [Builder.skip] with `skip.orElse(null)`. */
        fun skip(skip: Optional<String>) = skip(skip.getOrNull())

        /**
         * You can sort based on the following fields:
         * 1. name - `ASC_NAME` or `DESC_NAME`
         * 2. createdAt - `ASC_CREATED` or `DESC_CREATED`
         * 3. updatedAt - `ASC_UPDATED` or `DESC_UPDATED`
         * 4. height - `ASC_HEIGHT` or `DESC_HEIGHT`
         * 5. width - `ASC_WIDTH` or `DESC_WIDTH`
         * 6. size - `ASC_SIZE` or `DESC_SIZE`
         *
         * Default value - `ASC_CREATED`
         */
        fun sort(sort: String?) = apply { this.sort = sort }

        /** Alias for calling [Builder.sort] with `sort.orElse(null)`. */
        fun sort(sort: Optional<String>) = sort(sort.getOrNull())

        /**
         * Limit search to one of `file`, `file-version`, or `folder`. Pass `all` to include `files`
         * and `folders` in search results (`file-version` will not be included in this case).
         *
         * Default value - `file`
         */
        fun type(type: Type?) = apply { this.type = type }

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<Type>) = type(type.getOrNull())

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
         * Returns an immutable instance of [FileListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FileListParams =
            FileListParams(
                fileType,
                limit,
                path,
                searchQuery,
                skip,
                sort,
                type,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                fileType?.let { put("fileType", it) }
                limit?.let { put("limit", it) }
                path?.let { put("path", it) }
                searchQuery?.let { put("searchQuery", it) }
                skip?.let { put("skip", it) }
                sort?.let { put("sort", it) }
                type?.let { put("type", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * Limit search to one of `file`, `file-version`, or `folder`. Pass `all` to include `files` and
     * `folders` in search results (`file-version` will not be included in this case).
     *
     * Default value - `file`
     */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FILE = of("file")

            @JvmField val FILE_VERSION = of("file-version")

            @JvmField val FOLDER = of("folder")

            @JvmField val ALL = of("all")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            FILE,
            FILE_VERSION,
            FOLDER,
            ALL,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FILE,
            FILE_VERSION,
            FOLDER,
            ALL,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                FILE -> Value.FILE
                FILE_VERSION -> Value.FILE_VERSION
                FOLDER -> Value.FOLDER
                ALL -> Value.ALL
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                FILE -> Known.FILE
                FILE_VERSION -> Known.FILE_VERSION
                FOLDER -> Known.FOLDER
                ALL -> Known.ALL
                else -> throw ImageKitInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                ImageKitInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Type = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileListParams &&
            fileType == other.fileType &&
            limit == other.limit &&
            path == other.path &&
            searchQuery == other.searchQuery &&
            skip == other.skip &&
            sort == other.sort &&
            type == other.type &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            fileType,
            limit,
            path,
            searchQuery,
            skip,
            sort,
            type,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "FileListParams{fileType=$fileType, limit=$limit, path=$path, searchQuery=$searchQuery, skip=$skip, sort=$sort, type=$type, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
