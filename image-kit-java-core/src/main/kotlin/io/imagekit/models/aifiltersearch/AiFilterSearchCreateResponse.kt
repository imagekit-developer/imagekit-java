// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.aifiltersearch

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.core.Enum
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class AiFilterSearchCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val fileType: JsonField<FileType>,
    private val isVersionIncludedInSearch: JsonField<Boolean>,
    private val searchQuery: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("fileType") @ExcludeMissing fileType: JsonField<FileType> = JsonMissing.of(),
        @JsonProperty("isVersionIncludedInSearch")
        @ExcludeMissing
        isVersionIncludedInSearch: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("searchQuery")
        @ExcludeMissing
        searchQuery: JsonField<String> = JsonMissing.of(),
    ) : this(fileType, isVersionIncludedInSearch, searchQuery, mutableMapOf())

    /**
     * Suggested asset-type filter derived from the prompt. Empty string means no file-type
     * restriction.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileType(): Optional<FileType> = fileType.getOptional("fileType")

    /**
     * Whether previous file versions should be included in the search results.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isVersionIncludedInSearch(): Optional<Boolean> =
        isVersionIncludedInSearch.getOptional("isVersionIncludedInSearch")

    /**
     * Generated query in ImageKit's Lucene-like syntax. Pass this as the `searchQuery` parameter to
     * the list and search assets API. Empty string when no filters could be derived from the
     * prompt.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun searchQuery(): Optional<String> = searchQuery.getOptional("searchQuery")

    /**
     * Returns the raw JSON value of [fileType].
     *
     * Unlike [fileType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fileType") @ExcludeMissing fun _fileType(): JsonField<FileType> = fileType

    /**
     * Returns the raw JSON value of [isVersionIncludedInSearch].
     *
     * Unlike [isVersionIncludedInSearch], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("isVersionIncludedInSearch")
    @ExcludeMissing
    fun _isVersionIncludedInSearch(): JsonField<Boolean> = isVersionIncludedInSearch

    /**
     * Returns the raw JSON value of [searchQuery].
     *
     * Unlike [searchQuery], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("searchQuery") @ExcludeMissing fun _searchQuery(): JsonField<String> = searchQuery

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AiFilterSearchCreateResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AiFilterSearchCreateResponse]. */
    class Builder internal constructor() {

        private var fileType: JsonField<FileType> = JsonMissing.of()
        private var isVersionIncludedInSearch: JsonField<Boolean> = JsonMissing.of()
        private var searchQuery: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(aiFilterSearchCreateResponse: AiFilterSearchCreateResponse) = apply {
            fileType = aiFilterSearchCreateResponse.fileType
            isVersionIncludedInSearch = aiFilterSearchCreateResponse.isVersionIncludedInSearch
            searchQuery = aiFilterSearchCreateResponse.searchQuery
            additionalProperties = aiFilterSearchCreateResponse.additionalProperties.toMutableMap()
        }

        /**
         * Suggested asset-type filter derived from the prompt. Empty string means no file-type
         * restriction.
         */
        fun fileType(fileType: FileType) = fileType(JsonField.of(fileType))

        /**
         * Sets [Builder.fileType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileType] with a well-typed [FileType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fileType(fileType: JsonField<FileType>) = apply { this.fileType = fileType }

        /** Whether previous file versions should be included in the search results. */
        fun isVersionIncludedInSearch(isVersionIncludedInSearch: Boolean) =
            isVersionIncludedInSearch(JsonField.of(isVersionIncludedInSearch))

        /**
         * Sets [Builder.isVersionIncludedInSearch] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isVersionIncludedInSearch] with a well-typed [Boolean]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun isVersionIncludedInSearch(isVersionIncludedInSearch: JsonField<Boolean>) = apply {
            this.isVersionIncludedInSearch = isVersionIncludedInSearch
        }

        /**
         * Generated query in ImageKit's Lucene-like syntax. Pass this as the `searchQuery`
         * parameter to the list and search assets API. Empty string when no filters could be
         * derived from the prompt.
         */
        fun searchQuery(searchQuery: String) = searchQuery(JsonField.of(searchQuery))

        /**
         * Sets [Builder.searchQuery] to an arbitrary JSON value.
         *
         * You should usually call [Builder.searchQuery] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun searchQuery(searchQuery: JsonField<String>) = apply { this.searchQuery = searchQuery }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [AiFilterSearchCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): AiFilterSearchCreateResponse =
            AiFilterSearchCreateResponse(
                fileType,
                isVersionIncludedInSearch,
                searchQuery,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): AiFilterSearchCreateResponse = apply {
        if (validated) {
            return@apply
        }

        fileType().ifPresent { it.validate() }
        isVersionIncludedInSearch()
        searchQuery()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (fileType.asKnown().getOrNull()?.validity() ?: 0) +
            (if (isVersionIncludedInSearch.asKnown().isPresent) 1 else 0) +
            (if (searchQuery.asKnown().isPresent) 1 else 0)

    /**
     * Suggested asset-type filter derived from the prompt. Empty string means no file-type
     * restriction.
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

            @JvmField val EMPTY = of("")

            @JvmField val IMAGES = of("images")

            @JvmField val VIDEOS = of("videos")

            @JvmField val CSS_JS = of("cssJs")

            @JvmField val OTHERS = of("others")

            @JvmStatic fun of(value: String) = FileType(JsonField.of(value))
        }

        /** An enum containing [FileType]'s known values. */
        enum class Known {
            EMPTY,
            IMAGES,
            VIDEOS,
            CSS_JS,
            OTHERS,
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
            EMPTY,
            IMAGES,
            VIDEOS,
            CSS_JS,
            OTHERS,
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
                EMPTY -> Value.EMPTY
                IMAGES -> Value.IMAGES
                VIDEOS -> Value.VIDEOS
                CSS_JS -> Value.CSS_JS
                OTHERS -> Value.OTHERS
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
                EMPTY -> Known.EMPTY
                IMAGES -> Known.IMAGES
                VIDEOS -> Known.VIDEOS
                CSS_JS -> Known.CSS_JS
                OTHERS -> Known.OTHERS
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AiFilterSearchCreateResponse &&
            fileType == other.fileType &&
            isVersionIncludedInSearch == other.isVersionIncludedInSearch &&
            searchQuery == other.searchQuery &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(fileType, isVersionIncludedInSearch, searchQuery, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AiFilterSearchCreateResponse{fileType=$fileType, isVersionIncludedInSearch=$isVersionIncludedInSearch, searchQuery=$searchQuery, additionalProperties=$additionalProperties}"
}
