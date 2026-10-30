// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.tags

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.core.checkRequired
import io.imagekit.errors.ImageKitInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects

/**
 * A tag in use in your media library, aggregated case-insensitively across the assets that carry
 * it.
 */
class Tag
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val assetCount: JsonField<Long>,
    private val label: JsonField<String>,
    private val lastUsedAt: JsonField<OffsetDateTime>,
    private val name: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("assetCount") @ExcludeMissing assetCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("label") @ExcludeMissing label: JsonField<String> = JsonMissing.of(),
        @JsonProperty("lastUsedAt")
        @ExcludeMissing
        lastUsedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
    ) : this(assetCount, label, lastUsedAt, name, mutableMapOf())

    /**
     * The number of assets carrying the tag, counted across both tag sources (user-generated tags
     * and AI-generated tags) and all file types regardless of the request's filters.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assetCount(): Long = assetCount.getRequired("assetCount")

    /**
     * The tag as it was spelled when it was last applied to any asset. Use it for display.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun label(): String = label.getRequired("label")

    /**
     * When the tag was last applied to an asset matching the `tagSource` and `fileType` filters of
     * the request, in ISO 8601 format.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun lastUsedAt(): OffsetDateTime = lastUsedAt.getRequired("lastUsedAt")

    /**
     * The tag in lowercase. Tags are case-insensitive, so this is the unique key of the tag within
     * your account.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * Returns the raw JSON value of [assetCount].
     *
     * Unlike [assetCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("assetCount") @ExcludeMissing fun _assetCount(): JsonField<Long> = assetCount

    /**
     * Returns the raw JSON value of [label].
     *
     * Unlike [label], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

    /**
     * Returns the raw JSON value of [lastUsedAt].
     *
     * Unlike [lastUsedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lastUsedAt")
    @ExcludeMissing
    fun _lastUsedAt(): JsonField<OffsetDateTime> = lastUsedAt

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
         * Returns a mutable builder for constructing an instance of [Tag].
         *
         * The following fields are required:
         * ```java
         * .assetCount()
         * .label()
         * .lastUsedAt()
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Tag]. */
    class Builder internal constructor() {

        private var assetCount: JsonField<Long>? = null
        private var label: JsonField<String>? = null
        private var lastUsedAt: JsonField<OffsetDateTime>? = null
        private var name: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tag: Tag) = apply {
            assetCount = tag.assetCount
            label = tag.label
            lastUsedAt = tag.lastUsedAt
            name = tag.name
            additionalProperties = tag.additionalProperties.toMutableMap()
        }

        /**
         * The number of assets carrying the tag, counted across both tag sources (user-generated
         * tags and AI-generated tags) and all file types regardless of the request's filters.
         */
        fun assetCount(assetCount: Long) = assetCount(JsonField.of(assetCount))

        /**
         * Sets [Builder.assetCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.assetCount] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun assetCount(assetCount: JsonField<Long>) = apply { this.assetCount = assetCount }

        /** The tag as it was spelled when it was last applied to any asset. Use it for display. */
        fun label(label: String) = label(JsonField.of(label))

        /**
         * Sets [Builder.label] to an arbitrary JSON value.
         *
         * You should usually call [Builder.label] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun label(label: JsonField<String>) = apply { this.label = label }

        /**
         * When the tag was last applied to an asset matching the `tagSource` and `fileType` filters
         * of the request, in ISO 8601 format.
         */
        fun lastUsedAt(lastUsedAt: OffsetDateTime) = lastUsedAt(JsonField.of(lastUsedAt))

        /**
         * Sets [Builder.lastUsedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastUsedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun lastUsedAt(lastUsedAt: JsonField<OffsetDateTime>) = apply {
            this.lastUsedAt = lastUsedAt
        }

        /**
         * The tag in lowercase. Tags are case-insensitive, so this is the unique key of the tag
         * within your account.
         */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

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
         * Returns an immutable instance of [Tag].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .assetCount()
         * .label()
         * .lastUsedAt()
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Tag =
            Tag(
                checkRequired("assetCount", assetCount),
                checkRequired("label", label),
                checkRequired("lastUsedAt", lastUsedAt),
                checkRequired("name", name),
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
    fun validate(): Tag = apply {
        if (validated) {
            return@apply
        }

        assetCount()
        label()
        lastUsedAt()
        name()
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
        (if (assetCount.asKnown().isPresent) 1 else 0) +
            (if (label.asKnown().isPresent) 1 else 0) +
            (if (lastUsedAt.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Tag &&
            assetCount == other.assetCount &&
            label == other.label &&
            lastUsedAt == other.lastUsedAt &&
            name == other.name &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(assetCount, label, lastUsedAt, name, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Tag{assetCount=$assetCount, label=$label, lastUsedAt=$lastUsedAt, name=$name, additionalProperties=$additionalProperties}"
}
