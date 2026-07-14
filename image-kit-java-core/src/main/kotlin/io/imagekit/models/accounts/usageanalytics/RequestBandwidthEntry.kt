// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.usageanalytics

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
import java.util.Collections
import java.util.Objects

class RequestBandwidthEntry
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val bandwidthBytes: JsonField<Double>,
    private val requestCount: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("bandwidthBytes")
        @ExcludeMissing
        bandwidthBytes: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("requestCount")
        @ExcludeMissing
        requestCount: JsonField<Double> = JsonMissing.of(),
    ) : this(bandwidthBytes, requestCount, mutableMapOf())

    /**
     * Total bandwidth used in bytes.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

    /**
     * Number of requests.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun requestCount(): Double = requestCount.getRequired("requestCount")

    /**
     * Returns the raw JSON value of [bandwidthBytes].
     *
     * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bandwidthBytes")
    @ExcludeMissing
    fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

    /**
     * Returns the raw JSON value of [requestCount].
     *
     * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("requestCount")
    @ExcludeMissing
    fun _requestCount(): JsonField<Double> = requestCount

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
         * Returns a mutable builder for constructing an instance of [RequestBandwidthEntry].
         *
         * The following fields are required:
         * ```java
         * .bandwidthBytes()
         * .requestCount()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RequestBandwidthEntry]. */
    class Builder internal constructor() {

        private var bandwidthBytes: JsonField<Double>? = null
        private var requestCount: JsonField<Double>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(requestBandwidthEntry: RequestBandwidthEntry) = apply {
            bandwidthBytes = requestBandwidthEntry.bandwidthBytes
            requestCount = requestBandwidthEntry.requestCount
            additionalProperties = requestBandwidthEntry.additionalProperties.toMutableMap()
        }

        /** Total bandwidth used in bytes. */
        fun bandwidthBytes(bandwidthBytes: Double) = bandwidthBytes(JsonField.of(bandwidthBytes))

        /**
         * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
            this.bandwidthBytes = bandwidthBytes
        }

        /** Number of requests. */
        fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

        /**
         * Sets [Builder.requestCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestCount] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestCount(requestCount: JsonField<Double>) = apply {
            this.requestCount = requestCount
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
         * Returns an immutable instance of [RequestBandwidthEntry].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .bandwidthBytes()
         * .requestCount()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RequestBandwidthEntry =
            RequestBandwidthEntry(
                checkRequired("bandwidthBytes", bandwidthBytes),
                checkRequired("requestCount", requestCount),
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
    fun validate(): RequestBandwidthEntry = apply {
        if (validated) {
            return@apply
        }

        bandwidthBytes()
        requestCount()
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
        (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
            (if (requestCount.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RequestBandwidthEntry &&
            bandwidthBytes == other.bandwidthBytes &&
            requestCount == other.requestCount &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(bandwidthBytes, requestCount, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RequestBandwidthEntry{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, additionalProperties=$additionalProperties}"
}
