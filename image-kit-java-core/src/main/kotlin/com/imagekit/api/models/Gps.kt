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
import com.imagekit.api.core.checkKnown
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Object containing GPS information. */
class Gps
private constructor(
    private val gpsVersionId: JsonField<List<Long>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("GPSVersionID")
        @ExcludeMissing
        gpsVersionId: JsonField<List<Long>> = JsonMissing.of()
    ) : this(gpsVersionId, mutableMapOf())

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun gpsVersionId(): Optional<List<Long>> = gpsVersionId.getOptional("GPSVersionID")

    /**
     * Returns the raw JSON value of [gpsVersionId].
     *
     * Unlike [gpsVersionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("GPSVersionID")
    @ExcludeMissing
    fun _gpsVersionId(): JsonField<List<Long>> = gpsVersionId

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

        /** Returns a mutable builder for constructing an instance of [Gps]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Gps]. */
    class Builder internal constructor() {

        private var gpsVersionId: JsonField<MutableList<Long>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(gps: Gps) = apply {
            gpsVersionId = gps.gpsVersionId.map { it.toMutableList() }
            additionalProperties = gps.additionalProperties.toMutableMap()
        }

        fun gpsVersionId(gpsVersionId: List<Long>) = gpsVersionId(JsonField.of(gpsVersionId))

        /**
         * Sets [Builder.gpsVersionId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.gpsVersionId] with a well-typed `List<Long>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun gpsVersionId(gpsVersionId: JsonField<List<Long>>) = apply {
            this.gpsVersionId = gpsVersionId.map { it.toMutableList() }
        }

        /**
         * Adds a single [Long] to [Builder.gpsVersionId].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addGpsVersionId(gpsVersionId: Long) = apply {
            this.gpsVersionId =
                (this.gpsVersionId ?: JsonField.of(mutableListOf())).also {
                    checkKnown("gpsVersionId", it).add(gpsVersionId)
                }
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
         * Returns an immutable instance of [Gps].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Gps =
            Gps(
                (gpsVersionId ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Gps = apply {
        if (validated) {
            return@apply
        }

        gpsVersionId()
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
    @JvmSynthetic internal fun validity(): Int = (gpsVersionId.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Gps &&
            gpsVersionId == other.gpsVersionId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(gpsVersionId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Gps{gpsVersionId=$gpsVersionId, additionalProperties=$additionalProperties}"
}
