// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.assets

import com.fasterxml.jackson.annotation.JsonCreator
import io.imagekit.core.Enum
import io.imagekit.core.JsonField
import io.imagekit.core.Params
import io.imagekit.core.http.Headers
import io.imagekit.core.http.QueryParams
import io.imagekit.errors.ImageKitInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * This API can list all the uploaded files and folders in your ImageKit.io media library. In
 * addition, you can fine-tune your query by specifying various filters by generating a query string
 * in a Lucene-like syntax and provide this generated string as the value of the `searchQuery`.
 */
class AssetListParams
private constructor(
    private val fileType: FileType?,
    private val limit: Long?,
    private val path: String?,
    private val searchQuery: String?,
    private val skip: Long?,
    private val sort: Sort?,
    private val type: Type?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Filter results by file type.
     *
     * - `all` — include all file types
     * - `image` — include only image files
     * - `non-image` — include only non-image files (e.g., JS, CSS, video)
     */
    fun fileType(): Optional<FileType> = Optional.ofNullable(fileType)

    /** The maximum number of results to return in response. */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /**
     * Folder path if you want to limit the search within a specific folder. For example,
     * `/sales-banner/` will only search in folder sales-banner.
     *
     * Note : If your use case involves searching within a folder as well as its subfolders, you can
     * use `path` parameter in `searchQuery` with appropriate operator. Checkout
     * [Supported parameters](/docs/api-reference/digital-asset-management-dam/list-and-search-assets#supported-parameters)
     * for more information.
     */
    fun path(): Optional<String> = Optional.ofNullable(path)

    /**
     * Query string in a Lucene-like query language e.g. `createdAt > "7d"`.
     *
     * Note : When the searchQuery parameter is present, the following query parameters will have no
     * effect on the result:
     *
     * 1. `tags`
     * 2. `type`
     * 3. `name`
     *
     * [Learn
     * more](/docs/api-reference/digital-asset-management-dam/list-and-search-assets#advanced-search-queries)
     * from examples.
     */
    fun searchQuery(): Optional<String> = Optional.ofNullable(searchQuery)

    /** The number of results to skip before returning results. */
    fun skip(): Optional<Long> = Optional.ofNullable(skip)

    /** Sort the results by one of the supported fields in ascending or descending order. */
    fun sort(): Optional<Sort> = Optional.ofNullable(sort)

    /**
     * Filter results by asset type.
     *
     * - `file` — returns only files
     * - `file-version` — returns specific file versions
     * - `folder` — returns only folders
     * - `all` — returns both files and folders (excludes `file-version`)
     */
    fun type(): Optional<Type> = Optional.ofNullable(type)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): AssetListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [AssetListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AssetListParams]. */
    class Builder internal constructor() {

        private var fileType: FileType? = null
        private var limit: Long? = null
        private var path: String? = null
        private var searchQuery: String? = null
        private var skip: Long? = null
        private var sort: Sort? = null
        private var type: Type? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(assetListParams: AssetListParams) = apply {
            fileType = assetListParams.fileType
            limit = assetListParams.limit
            path = assetListParams.path
            searchQuery = assetListParams.searchQuery
            skip = assetListParams.skip
            sort = assetListParams.sort
            type = assetListParams.type
            additionalHeaders = assetListParams.additionalHeaders.toBuilder()
            additionalQueryParams = assetListParams.additionalQueryParams.toBuilder()
        }

        /**
         * Filter results by file type.
         *
         * - `all` — include all file types
         * - `image` — include only image files
         * - `non-image` — include only non-image files (e.g., JS, CSS, video)
         */
        fun fileType(fileType: FileType?) = apply { this.fileType = fileType }

        /** Alias for calling [Builder.fileType] with `fileType.orElse(null)`. */
        fun fileType(fileType: Optional<FileType>) = fileType(fileType.getOrNull())

        /** The maximum number of results to return in response. */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /**
         * Folder path if you want to limit the search within a specific folder. For example,
         * `/sales-banner/` will only search in folder sales-banner.
         *
         * Note : If your use case involves searching within a folder as well as its subfolders, you
         * can use `path` parameter in `searchQuery` with appropriate operator. Checkout
         * [Supported parameters](/docs/api-reference/digital-asset-management-dam/list-and-search-assets#supported-parameters)
         * for more information.
         */
        fun path(path: String?) = apply { this.path = path }

        /** Alias for calling [Builder.path] with `path.orElse(null)`. */
        fun path(path: Optional<String>) = path(path.getOrNull())

        /**
         * Query string in a Lucene-like query language e.g. `createdAt > "7d"`.
         *
         * Note : When the searchQuery parameter is present, the following query parameters will
         * have no effect on the result:
         *
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

        /** The number of results to skip before returning results. */
        fun skip(skip: Long?) = apply { this.skip = skip }

        /**
         * Alias for [Builder.skip].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun skip(skip: Long) = skip(skip as Long?)

        /** Alias for calling [Builder.skip] with `skip.orElse(null)`. */
        fun skip(skip: Optional<Long>) = skip(skip.getOrNull())

        /** Sort the results by one of the supported fields in ascending or descending order. */
        fun sort(sort: Sort?) = apply { this.sort = sort }

        /** Alias for calling [Builder.sort] with `sort.orElse(null)`. */
        fun sort(sort: Optional<Sort>) = sort(sort.getOrNull())

        /**
         * Filter results by asset type.
         *
         * - `file` — returns only files
         * - `file-version` — returns specific file versions
         * - `folder` — returns only folders
         * - `all` — returns both files and folders (excludes `file-version`)
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
         * Returns an immutable instance of [AssetListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): AssetListParams =
            AssetListParams(
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
                fileType?.let { put("fileType", it.toString()) }
                limit?.let { put("limit", it.toString()) }
                path?.let { put("path", it) }
                searchQuery?.let { put("searchQuery", it) }
                skip?.let { put("skip", it.toString()) }
                sort?.let { put("sort", it.toString()) }
                type?.let { put("type", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * Filter results by file type.
     *
     * - `all` — include all file types
     * - `image` — include only image files
     * - `non-image` — include only non-image files (e.g., JS, CSS, video)
     */
    class FileType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val ALL = of("all")

            @JvmField val IMAGE = of("image")

            @JvmField val NON_IMAGE = of("non-image")

            @JvmStatic fun of(value: String) = FileType(JsonField.of(value))
        }

        /** An enum containing [FileType]'s known values. */
        enum class Known {
            ALL,
            IMAGE,
            NON_IMAGE,
        }

        /**
         * An enum containing [FileType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [FileType] can contain an unknown value in a couple of cases:
         *
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         *
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ALL,
            IMAGE,
            NON_IMAGE,
            /** An enum member indicating that [FileType] was instantiated with an unknown value. */
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
                ALL -> Value.ALL
                IMAGE -> Value.IMAGE
                NON_IMAGE -> Value.NON_IMAGE
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
                ALL -> Known.ALL
                IMAGE -> Known.IMAGE
                NON_IMAGE -> Known.NON_IMAGE
                else -> throw ImageKitInvalidDataException("Unknown FileType: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): FileType = apply {
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

            return other is FileType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Sort the results by one of the supported fields in ascending or descending order. */
    class Sort @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val ASC_NAME = of("ASC_NAME")

            @JvmField val DESC_NAME = of("DESC_NAME")

            @JvmField val ASC_CREATED = of("ASC_CREATED")

            @JvmField val DESC_CREATED = of("DESC_CREATED")

            @JvmField val ASC_UPDATED = of("ASC_UPDATED")

            @JvmField val DESC_UPDATED = of("DESC_UPDATED")

            @JvmField val ASC_HEIGHT = of("ASC_HEIGHT")

            @JvmField val DESC_HEIGHT = of("DESC_HEIGHT")

            @JvmField val ASC_WIDTH = of("ASC_WIDTH")

            @JvmField val DESC_WIDTH = of("DESC_WIDTH")

            @JvmField val ASC_SIZE = of("ASC_SIZE")

            @JvmField val DESC_SIZE = of("DESC_SIZE")

            @JvmField val ASC_RELEVANCE = of("ASC_RELEVANCE")

            @JvmField val DESC_RELEVANCE = of("DESC_RELEVANCE")

            @JvmStatic fun of(value: String) = Sort(JsonField.of(value))
        }

        /** An enum containing [Sort]'s known values. */
        enum class Known {
            ASC_NAME,
            DESC_NAME,
            ASC_CREATED,
            DESC_CREATED,
            ASC_UPDATED,
            DESC_UPDATED,
            ASC_HEIGHT,
            DESC_HEIGHT,
            ASC_WIDTH,
            DESC_WIDTH,
            ASC_SIZE,
            DESC_SIZE,
            ASC_RELEVANCE,
            DESC_RELEVANCE,
        }

        /**
         * An enum containing [Sort]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Sort] can contain an unknown value in a couple of cases:
         *
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         *
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ASC_NAME,
            DESC_NAME,
            ASC_CREATED,
            DESC_CREATED,
            ASC_UPDATED,
            DESC_UPDATED,
            ASC_HEIGHT,
            DESC_HEIGHT,
            ASC_WIDTH,
            DESC_WIDTH,
            ASC_SIZE,
            DESC_SIZE,
            ASC_RELEVANCE,
            DESC_RELEVANCE,
            /** An enum member indicating that [Sort] was instantiated with an unknown value. */
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
                ASC_NAME -> Value.ASC_NAME
                DESC_NAME -> Value.DESC_NAME
                ASC_CREATED -> Value.ASC_CREATED
                DESC_CREATED -> Value.DESC_CREATED
                ASC_UPDATED -> Value.ASC_UPDATED
                DESC_UPDATED -> Value.DESC_UPDATED
                ASC_HEIGHT -> Value.ASC_HEIGHT
                DESC_HEIGHT -> Value.DESC_HEIGHT
                ASC_WIDTH -> Value.ASC_WIDTH
                DESC_WIDTH -> Value.DESC_WIDTH
                ASC_SIZE -> Value.ASC_SIZE
                DESC_SIZE -> Value.DESC_SIZE
                ASC_RELEVANCE -> Value.ASC_RELEVANCE
                DESC_RELEVANCE -> Value.DESC_RELEVANCE
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
                ASC_NAME -> Known.ASC_NAME
                DESC_NAME -> Known.DESC_NAME
                ASC_CREATED -> Known.ASC_CREATED
                DESC_CREATED -> Known.DESC_CREATED
                ASC_UPDATED -> Known.ASC_UPDATED
                DESC_UPDATED -> Known.DESC_UPDATED
                ASC_HEIGHT -> Known.ASC_HEIGHT
                DESC_HEIGHT -> Known.DESC_HEIGHT
                ASC_WIDTH -> Known.ASC_WIDTH
                DESC_WIDTH -> Known.DESC_WIDTH
                ASC_SIZE -> Known.ASC_SIZE
                DESC_SIZE -> Known.DESC_SIZE
                ASC_RELEVANCE -> Known.ASC_RELEVANCE
                DESC_RELEVANCE -> Known.DESC_RELEVANCE
                else -> throw ImageKitInvalidDataException("Unknown Sort: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Sort = apply {
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

            return other is Sort && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Filter results by asset type.
     *
     * - `file` — returns only files
     * - `file-version` — returns specific file versions
     * - `folder` — returns only folders
     * - `all` — returns both files and folders (excludes `file-version`)
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
         *
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         *
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

        return other is AssetListParams &&
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
        "AssetListParams{fileType=$fileType, limit=$limit, path=$path, searchQuery=$searchQuery, skip=$skip, sort=$sort, type=$type, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
