// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.imagekit.api.core.Enum
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.checkRequired
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class AutoTaggingExtension
private constructor(
    private val maxTags: JsonField<Long>,
    private val minConfidence: JsonField<Long>,
    private val name: JsonField<Name>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("maxTags") @ExcludeMissing maxTags: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("minConfidence")
        @ExcludeMissing
        minConfidence: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<Name> = JsonMissing.of(),
    ) : this(maxTags, minConfidence, name, mutableMapOf())

    /**
     * Maximum number of tags to attach to the asset.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun maxTags(): Long = maxTags.getRequired("maxTags")

    /**
     * Minimum confidence level for tags to be considered valid.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun minConfidence(): Long = minConfidence.getRequired("minConfidence")

    /**
     * Specifies the auto-tagging extension used.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): Name = name.getRequired("name")

    /**
     * Returns the raw JSON value of [maxTags].
     *
     * Unlike [maxTags], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("maxTags") @ExcludeMissing fun _maxTags(): JsonField<Long> = maxTags

    /**
     * Returns the raw JSON value of [minConfidence].
     *
     * Unlike [minConfidence], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("minConfidence")
    @ExcludeMissing
    fun _minConfidence(): JsonField<Long> = minConfidence

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<Name> = name

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
         * Returns a mutable builder for constructing an instance of [AutoTaggingExtension].
         *
         * The following fields are required:
         * ```java
         * .maxTags()
         * .minConfidence()
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AutoTaggingExtension]. */
    class Builder internal constructor() {

        private var maxTags: JsonField<Long>? = null
        private var minConfidence: JsonField<Long>? = null
        private var name: JsonField<Name>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(autoTaggingExtension: AutoTaggingExtension) = apply {
            maxTags = autoTaggingExtension.maxTags
            minConfidence = autoTaggingExtension.minConfidence
            name = autoTaggingExtension.name
            additionalProperties = autoTaggingExtension.additionalProperties.toMutableMap()
        }

        /** Maximum number of tags to attach to the asset. */
        fun maxTags(maxTags: Long) = maxTags(JsonField.of(maxTags))

        /**
         * Sets [Builder.maxTags] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxTags] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun maxTags(maxTags: JsonField<Long>) = apply { this.maxTags = maxTags }

        /** Minimum confidence level for tags to be considered valid. */
        fun minConfidence(minConfidence: Long) = minConfidence(JsonField.of(minConfidence))

        /**
         * Sets [Builder.minConfidence] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minConfidence] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun minConfidence(minConfidence: JsonField<Long>) = apply {
            this.minConfidence = minConfidence
        }

        /** Specifies the auto-tagging extension used. */
        fun name(name: Name) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [Name] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<Name>) = apply { this.name = name }

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
         * Returns an immutable instance of [AutoTaggingExtension].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .maxTags()
         * .minConfidence()
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AutoTaggingExtension =
            AutoTaggingExtension(
                checkRequired("maxTags", maxTags),
                checkRequired("minConfidence", minConfidence),
                checkRequired("name", name),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AutoTaggingExtension = apply {
        if (validated) {
            return@apply
        }

        maxTags()
        minConfidence()
        name().validate()
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
        (if (maxTags.asKnown().isPresent) 1 else 0) +
            (if (minConfidence.asKnown().isPresent) 1 else 0) +
            (name.asKnown().getOrNull()?.validity() ?: 0)

    /** Specifies the auto-tagging extension used. */
    class Name @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val GOOGLE_AUTO_TAGGING = of("google-auto-tagging")

            @JvmField val AWS_AUTO_TAGGING = of("aws-auto-tagging")

            @JvmStatic fun of(value: String) = Name(JsonField.of(value))
        }

        /** An enum containing [Name]'s known values. */
        enum class Known {
            GOOGLE_AUTO_TAGGING,
            AWS_AUTO_TAGGING,
        }

        /**
         * An enum containing [Name]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Name] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            GOOGLE_AUTO_TAGGING,
            AWS_AUTO_TAGGING,
            /** An enum member indicating that [Name] was instantiated with an unknown value. */
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
                GOOGLE_AUTO_TAGGING -> Value.GOOGLE_AUTO_TAGGING
                AWS_AUTO_TAGGING -> Value.AWS_AUTO_TAGGING
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
                GOOGLE_AUTO_TAGGING -> Known.GOOGLE_AUTO_TAGGING
                AWS_AUTO_TAGGING -> Known.AWS_AUTO_TAGGING
                else -> throw ImageKitInvalidDataException("Unknown Name: $value")
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

        fun validate(): Name = apply {
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

            return other is Name && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AutoTaggingExtension &&
            maxTags == other.maxTags &&
            minConfidence == other.minConfidence &&
            name == other.name &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(maxTags, minConfidence, name, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AutoTaggingExtension{maxTags=$maxTags, minConfidence=$minConfidence, name=$name, additionalProperties=$additionalProperties}"
}
