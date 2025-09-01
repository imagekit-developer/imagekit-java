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
import kotlin.jvm.optionals.getOrNull

class BaseOverlay
private constructor(
    private val position: JsonField<OverlayPosition>,
    private val timing: JsonField<OverlayTiming>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("position")
        @ExcludeMissing
        position: JsonField<OverlayPosition> = JsonMissing.of(),
        @JsonProperty("timing") @ExcludeMissing timing: JsonField<OverlayTiming> = JsonMissing.of(),
    ) : this(position, timing, mutableMapOf())

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun position(): Optional<OverlayPosition> = position.getOptional("position")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timing(): Optional<OverlayTiming> = timing.getOptional("timing")

    /**
     * Returns the raw JSON value of [position].
     *
     * Unlike [position], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("position") @ExcludeMissing fun _position(): JsonField<OverlayPosition> = position

    /**
     * Returns the raw JSON value of [timing].
     *
     * Unlike [timing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("timing") @ExcludeMissing fun _timing(): JsonField<OverlayTiming> = timing

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

        /** Returns a mutable builder for constructing an instance of [BaseOverlay]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BaseOverlay]. */
    class Builder internal constructor() {

        private var position: JsonField<OverlayPosition> = JsonMissing.of()
        private var timing: JsonField<OverlayTiming> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(baseOverlay: BaseOverlay) = apply {
            position = baseOverlay.position
            timing = baseOverlay.timing
            additionalProperties = baseOverlay.additionalProperties.toMutableMap()
        }

        fun position(position: OverlayPosition) = position(JsonField.of(position))

        /**
         * Sets [Builder.position] to an arbitrary JSON value.
         *
         * You should usually call [Builder.position] with a well-typed [OverlayPosition] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun position(position: JsonField<OverlayPosition>) = apply { this.position = position }

        fun timing(timing: OverlayTiming) = timing(JsonField.of(timing))

        /**
         * Sets [Builder.timing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timing] with a well-typed [OverlayTiming] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun timing(timing: JsonField<OverlayTiming>) = apply { this.timing = timing }

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
         * Returns an immutable instance of [BaseOverlay].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BaseOverlay =
            BaseOverlay(position, timing, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): BaseOverlay = apply {
        if (validated) {
            return@apply
        }

        position().ifPresent { it.validate() }
        timing().ifPresent { it.validate() }
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
        (position.asKnown().getOrNull()?.validity() ?: 0) +
            (timing.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BaseOverlay &&
            position == other.position &&
            timing == other.timing &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(position, timing, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BaseOverlay{position=$position, timing=$timing, additionalProperties=$additionalProperties}"
}
