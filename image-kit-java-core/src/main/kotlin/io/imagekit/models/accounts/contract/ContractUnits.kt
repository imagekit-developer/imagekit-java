// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.contract

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

class ContractUnits
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val bandwidthBytes: JsonField<Long>,
    private val extensionUnitsCount: JsonField<Long>,
    private val purgeCacheRequests: JsonField<Long>,
    private val videoProcessingUnitsCount: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("bandwidthBytes")
        @ExcludeMissing
        bandwidthBytes: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("extensionUnitsCount")
        @ExcludeMissing
        extensionUnitsCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("purgeCacheRequests")
        @ExcludeMissing
        purgeCacheRequests: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("videoProcessingUnitsCount")
        @ExcludeMissing
        videoProcessingUnitsCount: JsonField<Long> = JsonMissing.of(),
    ) : this(
        bandwidthBytes,
        extensionUnitsCount,
        purgeCacheRequests,
        videoProcessingUnitsCount,
        mutableMapOf(),
    )

    /**
     * Bandwidth in bytes.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bandwidthBytes(): Long = bandwidthBytes.getRequired("bandwidthBytes")

    /**
     * Number of extension units.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun extensionUnitsCount(): Long = extensionUnitsCount.getRequired("extensionUnitsCount")

    /**
     * Number of purge cache requests.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun purgeCacheRequests(): Long = purgeCacheRequests.getRequired("purgeCacheRequests")

    /**
     * Number of video processing units.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun videoProcessingUnitsCount(): Long =
        videoProcessingUnitsCount.getRequired("videoProcessingUnitsCount")

    /**
     * Returns the raw JSON value of [bandwidthBytes].
     *
     * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bandwidthBytes")
    @ExcludeMissing
    fun _bandwidthBytes(): JsonField<Long> = bandwidthBytes

    /**
     * Returns the raw JSON value of [extensionUnitsCount].
     *
     * Unlike [extensionUnitsCount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("extensionUnitsCount")
    @ExcludeMissing
    fun _extensionUnitsCount(): JsonField<Long> = extensionUnitsCount

    /**
     * Returns the raw JSON value of [purgeCacheRequests].
     *
     * Unlike [purgeCacheRequests], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("purgeCacheRequests")
    @ExcludeMissing
    fun _purgeCacheRequests(): JsonField<Long> = purgeCacheRequests

    /**
     * Returns the raw JSON value of [videoProcessingUnitsCount].
     *
     * Unlike [videoProcessingUnitsCount], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("videoProcessingUnitsCount")
    @ExcludeMissing
    fun _videoProcessingUnitsCount(): JsonField<Long> = videoProcessingUnitsCount

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
         * Returns a mutable builder for constructing an instance of [ContractUnits].
         *
         * The following fields are required:
         * ```java
         * .bandwidthBytes()
         * .extensionUnitsCount()
         * .purgeCacheRequests()
         * .videoProcessingUnitsCount()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContractUnits]. */
    class Builder internal constructor() {

        private var bandwidthBytes: JsonField<Long>? = null
        private var extensionUnitsCount: JsonField<Long>? = null
        private var purgeCacheRequests: JsonField<Long>? = null
        private var videoProcessingUnitsCount: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contractUnits: ContractUnits) = apply {
            bandwidthBytes = contractUnits.bandwidthBytes
            extensionUnitsCount = contractUnits.extensionUnitsCount
            purgeCacheRequests = contractUnits.purgeCacheRequests
            videoProcessingUnitsCount = contractUnits.videoProcessingUnitsCount
            additionalProperties = contractUnits.additionalProperties.toMutableMap()
        }

        /** Bandwidth in bytes. */
        fun bandwidthBytes(bandwidthBytes: Long) = bandwidthBytes(JsonField.of(bandwidthBytes))

        /**
         * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bandwidthBytes] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bandwidthBytes(bandwidthBytes: JsonField<Long>) = apply {
            this.bandwidthBytes = bandwidthBytes
        }

        /** Number of extension units. */
        fun extensionUnitsCount(extensionUnitsCount: Long) =
            extensionUnitsCount(JsonField.of(extensionUnitsCount))

        /**
         * Sets [Builder.extensionUnitsCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.extensionUnitsCount] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun extensionUnitsCount(extensionUnitsCount: JsonField<Long>) = apply {
            this.extensionUnitsCount = extensionUnitsCount
        }

        /** Number of purge cache requests. */
        fun purgeCacheRequests(purgeCacheRequests: Long) =
            purgeCacheRequests(JsonField.of(purgeCacheRequests))

        /**
         * Sets [Builder.purgeCacheRequests] to an arbitrary JSON value.
         *
         * You should usually call [Builder.purgeCacheRequests] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun purgeCacheRequests(purgeCacheRequests: JsonField<Long>) = apply {
            this.purgeCacheRequests = purgeCacheRequests
        }

        /** Number of video processing units. */
        fun videoProcessingUnitsCount(videoProcessingUnitsCount: Long) =
            videoProcessingUnitsCount(JsonField.of(videoProcessingUnitsCount))

        /**
         * Sets [Builder.videoProcessingUnitsCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.videoProcessingUnitsCount] with a well-typed [Long]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun videoProcessingUnitsCount(videoProcessingUnitsCount: JsonField<Long>) = apply {
            this.videoProcessingUnitsCount = videoProcessingUnitsCount
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
         * Returns an immutable instance of [ContractUnits].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .bandwidthBytes()
         * .extensionUnitsCount()
         * .purgeCacheRequests()
         * .videoProcessingUnitsCount()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ContractUnits =
            ContractUnits(
                checkRequired("bandwidthBytes", bandwidthBytes),
                checkRequired("extensionUnitsCount", extensionUnitsCount),
                checkRequired("purgeCacheRequests", purgeCacheRequests),
                checkRequired("videoProcessingUnitsCount", videoProcessingUnitsCount),
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
    fun validate(): ContractUnits = apply {
        if (validated) {
            return@apply
        }

        bandwidthBytes()
        extensionUnitsCount()
        purgeCacheRequests()
        videoProcessingUnitsCount()
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
            (if (extensionUnitsCount.asKnown().isPresent) 1 else 0) +
            (if (purgeCacheRequests.asKnown().isPresent) 1 else 0) +
            (if (videoProcessingUnitsCount.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContractUnits &&
            bandwidthBytes == other.bandwidthBytes &&
            extensionUnitsCount == other.extensionUnitsCount &&
            purgeCacheRequests == other.purgeCacheRequests &&
            videoProcessingUnitsCount == other.videoProcessingUnitsCount &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            bandwidthBytes,
            extensionUnitsCount,
            purgeCacheRequests,
            videoProcessingUnitsCount,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContractUnits{bandwidthBytes=$bandwidthBytes, extensionUnitsCount=$extensionUnitsCount, purgeCacheRequests=$purgeCacheRequests, videoProcessingUnitsCount=$videoProcessingUnitsCount, additionalProperties=$additionalProperties}"
}
