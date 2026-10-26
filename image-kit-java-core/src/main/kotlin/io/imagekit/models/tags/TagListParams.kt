// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.tags

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
 * This API lists the distinct tags in use across your media library, with the number of assets each
 * tag is applied to and when it was last used. Tags are matched case-insensitively, so `Summer` and
 * `summer` are one entry: `name` is the lowercased form and `label` is the spelling that was used
 * most recently.
 *
 * Use `tagSource` and `fileType` to list only the tags in use on matching assets. `lastUsedAt` and
 * the `ASC_LAST_USED` / `DESC_LAST_USED` sorts follow those filters, while `assetCount` always
 * counts every asset carrying the tag. Use `search` or `prefix` to narrow the listing and `cursor`
 * to page through it.
 */
class TagListParams
private constructor(
    private val cursor: String?,
    private val fileType: FileType?,
    private val limit: Long?,
    private val prefix: String?,
    private val search: String?,
    private val sort: Sort?,
    private val tagSource: TagSource?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The `nextCursor` value from the previous response, to fetch the next page. A cursor is bound
     * to the `tagSource`, `fileType`, `sort`, `search` and `prefix` it was issued with; sending it
     * with different values returns a 400.
     */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /**
     * Filter tags by the type of asset they are applied to.
     * - `image` — tags in use on images
     * - `video` — tags in use on videos
     * - `static` — tags in use on any other file, such as documents, scripts and stylesheets
     * - `all` — tags in use on any asset
     */
    fun fileType(): Optional<FileType> = Optional.ofNullable(fileType)

    /** The maximum number of tags to return in response. */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Only return tags that begin with this value. Matching is case-insensitive. */
    fun prefix(): Optional<String> = Optional.ofNullable(prefix)

    /**
     * Only return tags that contain this text. Every word in the value must appear in the tag and
     * the last word may be incomplete, which suits search-as-you-type. Matching is
     * case-insensitive.
     */
    fun search(): Optional<String> = Optional.ofNullable(search)

    /**
     * Sort the results.
     * - `ASC_NAME` / `DESC_NAME` — by `name`
     * - `ASC_LAST_USED` / `DESC_LAST_USED` — by `lastUsedAt` within the requested `tagSource` and
     *   `fileType`, ties broken by `name`
     */
    fun sort(): Optional<Sort> = Optional.ofNullable(sort)

    /**
     * Filter tags by who added them.
     * - `user` — tags added by users through the dashboard or the API
     * - `ai` — tags added by AI auto-tagging extensions
     * - `all` — both
     */
    fun tagSource(): Optional<TagSource> = Optional.ofNullable(tagSource)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): TagListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [TagListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TagListParams]. */
    class Builder internal constructor() {

        private var cursor: String? = null
        private var fileType: FileType? = null
        private var limit: Long? = null
        private var prefix: String? = null
        private var search: String? = null
        private var sort: Sort? = null
        private var tagSource: TagSource? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(tagListParams: TagListParams) = apply {
            cursor = tagListParams.cursor
            fileType = tagListParams.fileType
            limit = tagListParams.limit
            prefix = tagListParams.prefix
            search = tagListParams.search
            sort = tagListParams.sort
            tagSource = tagListParams.tagSource
            additionalHeaders = tagListParams.additionalHeaders.toBuilder()
            additionalQueryParams = tagListParams.additionalQueryParams.toBuilder()
        }

        /**
         * The `nextCursor` value from the previous response, to fetch the next page. A cursor is
         * bound to the `tagSource`, `fileType`, `sort`, `search` and `prefix` it was issued with;
         * sending it with different values returns a 400.
         */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /**
         * Filter tags by the type of asset they are applied to.
         * - `image` — tags in use on images
         * - `video` — tags in use on videos
         * - `static` — tags in use on any other file, such as documents, scripts and stylesheets
         * - `all` — tags in use on any asset
         */
        fun fileType(fileType: FileType?) = apply { this.fileType = fileType }

        /** Alias for calling [Builder.fileType] with `fileType.orElse(null)`. */
        fun fileType(fileType: Optional<FileType>) = fileType(fileType.getOrNull())

        /** The maximum number of tags to return in response. */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /** Only return tags that begin with this value. Matching is case-insensitive. */
        fun prefix(prefix: String?) = apply { this.prefix = prefix }

        /** Alias for calling [Builder.prefix] with `prefix.orElse(null)`. */
        fun prefix(prefix: Optional<String>) = prefix(prefix.getOrNull())

        /**
         * Only return tags that contain this text. Every word in the value must appear in the tag
         * and the last word may be incomplete, which suits search-as-you-type. Matching is
         * case-insensitive.
         */
        fun search(search: String?) = apply { this.search = search }

        /** Alias for calling [Builder.search] with `search.orElse(null)`. */
        fun search(search: Optional<String>) = search(search.getOrNull())

        /**
         * Sort the results.
         * - `ASC_NAME` / `DESC_NAME` — by `name`
         * - `ASC_LAST_USED` / `DESC_LAST_USED` — by `lastUsedAt` within the requested `tagSource`
         *   and `fileType`, ties broken by `name`
         */
        fun sort(sort: Sort?) = apply { this.sort = sort }

        /** Alias for calling [Builder.sort] with `sort.orElse(null)`. */
        fun sort(sort: Optional<Sort>) = sort(sort.getOrNull())

        /**
         * Filter tags by who added them.
         * - `user` — tags added by users through the dashboard or the API
         * - `ai` — tags added by AI auto-tagging extensions
         * - `all` — both
         */
        fun tagSource(tagSource: TagSource?) = apply { this.tagSource = tagSource }

        /** Alias for calling [Builder.tagSource] with `tagSource.orElse(null)`. */
        fun tagSource(tagSource: Optional<TagSource>) = tagSource(tagSource.getOrNull())

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
         * Returns an immutable instance of [TagListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TagListParams =
            TagListParams(
                cursor,
                fileType,
                limit,
                prefix,
                search,
                sort,
                tagSource,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                cursor?.let { put("cursor", it) }
                fileType?.let { put("fileType", it.toString()) }
                limit?.let { put("limit", it.toString()) }
                prefix?.let { put("prefix", it) }
                search?.let { put("search", it) }
                sort?.let { put("sort", it.toString()) }
                tagSource?.let { put("tagSource", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * Filter tags by the type of asset they are applied to.
     * - `image` — tags in use on images
     * - `video` — tags in use on videos
     * - `static` — tags in use on any other file, such as documents, scripts and stylesheets
     * - `all` — tags in use on any asset
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

            @JvmField val IMAGE = of("image")

            @JvmField val VIDEO = of("video")

            @JvmField val STATIC = of("static")

            @JvmField val ALL = of("all")

            @JvmStatic fun of(value: String) = FileType(JsonField.of(value))
        }

        /** An enum containing [FileType]'s known values. */
        enum class Known {
            IMAGE,
            VIDEO,
            STATIC,
            ALL,
        }

        /**
         * An enum containing [FileType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [FileType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            IMAGE,
            VIDEO,
            STATIC,
            ALL,
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
                IMAGE -> Value.IMAGE
                VIDEO -> Value.VIDEO
                STATIC -> Value.STATIC
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
                IMAGE -> Known.IMAGE
                VIDEO -> Known.VIDEO
                STATIC -> Known.STATIC
                ALL -> Known.ALL
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

    /**
     * Sort the results.
     * - `ASC_NAME` / `DESC_NAME` — by `name`
     * - `ASC_LAST_USED` / `DESC_LAST_USED` — by `lastUsedAt` within the requested `tagSource` and
     *   `fileType`, ties broken by `name`
     */
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

            @JvmField val ASC_LAST_USED = of("ASC_LAST_USED")

            @JvmField val DESC_LAST_USED = of("DESC_LAST_USED")

            @JvmStatic fun of(value: String) = Sort(JsonField.of(value))
        }

        /** An enum containing [Sort]'s known values. */
        enum class Known {
            ASC_NAME,
            DESC_NAME,
            ASC_LAST_USED,
            DESC_LAST_USED,
        }

        /**
         * An enum containing [Sort]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Sort] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ASC_NAME,
            DESC_NAME,
            ASC_LAST_USED,
            DESC_LAST_USED,
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
                ASC_LAST_USED -> Value.ASC_LAST_USED
                DESC_LAST_USED -> Value.DESC_LAST_USED
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
                ASC_LAST_USED -> Known.ASC_LAST_USED
                DESC_LAST_USED -> Known.DESC_LAST_USED
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
     * Filter tags by who added them.
     * - `user` — tags added by users through the dashboard or the API
     * - `ai` — tags added by AI auto-tagging extensions
     * - `all` — both
     */
    class TagSource @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val USER = of("user")

            @JvmField val AI = of("ai")

            @JvmField val ALL = of("all")

            @JvmStatic fun of(value: String) = TagSource(JsonField.of(value))
        }

        /** An enum containing [TagSource]'s known values. */
        enum class Known {
            USER,
            AI,
            ALL,
        }

        /**
         * An enum containing [TagSource]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [TagSource] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            USER,
            AI,
            ALL,
            /**
             * An enum member indicating that [TagSource] was instantiated with an unknown value.
             */
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
                USER -> Value.USER
                AI -> Value.AI
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
                USER -> Known.USER
                AI -> Known.AI
                ALL -> Known.ALL
                else -> throw ImageKitInvalidDataException("Unknown TagSource: $value")
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
        fun validate(): TagSource = apply {
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

            return other is TagSource && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TagListParams &&
            cursor == other.cursor &&
            fileType == other.fileType &&
            limit == other.limit &&
            prefix == other.prefix &&
            search == other.search &&
            sort == other.sort &&
            tagSource == other.tagSource &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            cursor,
            fileType,
            limit,
            prefix,
            search,
            sort,
            tagSource,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "TagListParams{cursor=$cursor, fileType=$fileType, limit=$limit, prefix=$prefix, search=$search, sort=$sort, tagSource=$tagSource, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
