// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** JSON object. */
class Interoperability
private constructor(
    private val interopIndex: JsonField<String>,
    private val interopVersion: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("InteropIndex")
        @ExcludeMissing
        interopIndex: JsonField<String> = JsonMissing.of(),
        @JsonProperty("InteropVersion")
        @ExcludeMissing
        interopVersion: JsonField<String> = JsonMissing.of(),
    ) : this(interopIndex, interopVersion, mutableMapOf())

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun interopIndex(): Optional<String> = interopIndex.getOptional("InteropIndex")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun interopVersion(): Optional<String> = interopVersion.getOptional("InteropVersion")

    /**
     * Returns the raw JSON value of [interopIndex].
     *
     * Unlike [interopIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("InteropIndex")
    @ExcludeMissing
    fun _interopIndex(): JsonField<String> = interopIndex

    /**
     * Returns the raw JSON value of [interopVersion].
     *
     * Unlike [interopVersion], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("InteropVersion")
    @ExcludeMissing
    fun _interopVersion(): JsonField<String> = interopVersion

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

        /** Returns a mutable builder for constructing an instance of [Interoperability]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Interoperability]. */
    class Builder internal constructor() {

        private var interopIndex: JsonField<String> = JsonMissing.of()
        private var interopVersion: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(interoperability: Interoperability) = apply {
            interopIndex = interoperability.interopIndex
            interopVersion = interoperability.interopVersion
            additionalProperties = interoperability.additionalProperties.toMutableMap()
        }

        fun interopIndex(interopIndex: String) = interopIndex(JsonField.of(interopIndex))

        /**
         * Sets [Builder.interopIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.interopIndex] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun interopIndex(interopIndex: JsonField<String>) = apply {
            this.interopIndex = interopIndex
        }

        fun interopVersion(interopVersion: String) = interopVersion(JsonField.of(interopVersion))

        /**
         * Sets [Builder.interopVersion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.interopVersion] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun interopVersion(interopVersion: JsonField<String>) = apply {
            this.interopVersion = interopVersion
        }

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
         * Returns an immutable instance of [Interoperability].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Interoperability =
            Interoperability(interopIndex, interopVersion, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): Interoperability = apply {
        if (validated) {
            return@apply
        }

        interopIndex()
        interopVersion()
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
        (if (interopIndex.asKnown().isPresent) 1 else 0) +
            (if (interopVersion.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Interoperability &&
            interopIndex == other.interopIndex &&
            interopVersion == other.interopVersion &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(interopIndex, interopVersion, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Interoperability{interopIndex=$interopIndex, interopVersion=$interopVersion, additionalProperties=$additionalProperties}"
}
