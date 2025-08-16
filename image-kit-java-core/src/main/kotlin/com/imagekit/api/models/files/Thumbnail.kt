// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

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

/** Object containing Thumbnail information. */
class Thumbnail
private constructor(
    private val compression: JsonField<Long>,
    private val resolutionUnit: JsonField<Long>,
    private val thumbnailLength: JsonField<Long>,
    private val thumbnailOffset: JsonField<Long>,
    private val xResolution: JsonField<Long>,
    private val yResolution: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("Compression")
        @ExcludeMissing
        compression: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ResolutionUnit")
        @ExcludeMissing
        resolutionUnit: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ThumbnailLength")
        @ExcludeMissing
        thumbnailLength: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ThumbnailOffset")
        @ExcludeMissing
        thumbnailOffset: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("XResolution")
        @ExcludeMissing
        xResolution: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("YResolution") @ExcludeMissing yResolution: JsonField<Long> = JsonMissing.of(),
    ) : this(
        compression,
        resolutionUnit,
        thumbnailLength,
        thumbnailOffset,
        xResolution,
        yResolution,
        mutableMapOf(),
    )

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun compression(): Optional<Long> = compression.getOptional("Compression")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun resolutionUnit(): Optional<Long> = resolutionUnit.getOptional("ResolutionUnit")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun thumbnailLength(): Optional<Long> = thumbnailLength.getOptional("ThumbnailLength")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun thumbnailOffset(): Optional<Long> = thumbnailOffset.getOptional("ThumbnailOffset")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun xResolution(): Optional<Long> = xResolution.getOptional("XResolution")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun yResolution(): Optional<Long> = yResolution.getOptional("YResolution")

    /**
     * Returns the raw JSON value of [compression].
     *
     * Unlike [compression], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("Compression") @ExcludeMissing fun _compression(): JsonField<Long> = compression

    /**
     * Returns the raw JSON value of [resolutionUnit].
     *
     * Unlike [resolutionUnit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ResolutionUnit")
    @ExcludeMissing
    fun _resolutionUnit(): JsonField<Long> = resolutionUnit

    /**
     * Returns the raw JSON value of [thumbnailLength].
     *
     * Unlike [thumbnailLength], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ThumbnailLength")
    @ExcludeMissing
    fun _thumbnailLength(): JsonField<Long> = thumbnailLength

    /**
     * Returns the raw JSON value of [thumbnailOffset].
     *
     * Unlike [thumbnailOffset], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ThumbnailOffset")
    @ExcludeMissing
    fun _thumbnailOffset(): JsonField<Long> = thumbnailOffset

    /**
     * Returns the raw JSON value of [xResolution].
     *
     * Unlike [xResolution], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("XResolution") @ExcludeMissing fun _xResolution(): JsonField<Long> = xResolution

    /**
     * Returns the raw JSON value of [yResolution].
     *
     * Unlike [yResolution], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("YResolution") @ExcludeMissing fun _yResolution(): JsonField<Long> = yResolution

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

        /** Returns a mutable builder for constructing an instance of [Thumbnail]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Thumbnail]. */
    class Builder internal constructor() {

        private var compression: JsonField<Long> = JsonMissing.of()
        private var resolutionUnit: JsonField<Long> = JsonMissing.of()
        private var thumbnailLength: JsonField<Long> = JsonMissing.of()
        private var thumbnailOffset: JsonField<Long> = JsonMissing.of()
        private var xResolution: JsonField<Long> = JsonMissing.of()
        private var yResolution: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(thumbnail: Thumbnail) = apply {
            compression = thumbnail.compression
            resolutionUnit = thumbnail.resolutionUnit
            thumbnailLength = thumbnail.thumbnailLength
            thumbnailOffset = thumbnail.thumbnailOffset
            xResolution = thumbnail.xResolution
            yResolution = thumbnail.yResolution
            additionalProperties = thumbnail.additionalProperties.toMutableMap()
        }

        fun compression(compression: Long) = compression(JsonField.of(compression))

        /**
         * Sets [Builder.compression] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compression] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun compression(compression: JsonField<Long>) = apply { this.compression = compression }

        fun resolutionUnit(resolutionUnit: Long) = resolutionUnit(JsonField.of(resolutionUnit))

        /**
         * Sets [Builder.resolutionUnit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resolutionUnit] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun resolutionUnit(resolutionUnit: JsonField<Long>) = apply {
            this.resolutionUnit = resolutionUnit
        }

        fun thumbnailLength(thumbnailLength: Long) = thumbnailLength(JsonField.of(thumbnailLength))

        /**
         * Sets [Builder.thumbnailLength] to an arbitrary JSON value.
         *
         * You should usually call [Builder.thumbnailLength] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun thumbnailLength(thumbnailLength: JsonField<Long>) = apply {
            this.thumbnailLength = thumbnailLength
        }

        fun thumbnailOffset(thumbnailOffset: Long) = thumbnailOffset(JsonField.of(thumbnailOffset))

        /**
         * Sets [Builder.thumbnailOffset] to an arbitrary JSON value.
         *
         * You should usually call [Builder.thumbnailOffset] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun thumbnailOffset(thumbnailOffset: JsonField<Long>) = apply {
            this.thumbnailOffset = thumbnailOffset
        }

        fun xResolution(xResolution: Long) = xResolution(JsonField.of(xResolution))

        /**
         * Sets [Builder.xResolution] to an arbitrary JSON value.
         *
         * You should usually call [Builder.xResolution] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun xResolution(xResolution: JsonField<Long>) = apply { this.xResolution = xResolution }

        fun yResolution(yResolution: Long) = yResolution(JsonField.of(yResolution))

        /**
         * Sets [Builder.yResolution] to an arbitrary JSON value.
         *
         * You should usually call [Builder.yResolution] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun yResolution(yResolution: JsonField<Long>) = apply { this.yResolution = yResolution }

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
         * Returns an immutable instance of [Thumbnail].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Thumbnail =
            Thumbnail(
                compression,
                resolutionUnit,
                thumbnailLength,
                thumbnailOffset,
                xResolution,
                yResolution,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Thumbnail = apply {
        if (validated) {
            return@apply
        }

        compression()
        resolutionUnit()
        thumbnailLength()
        thumbnailOffset()
        xResolution()
        yResolution()
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
        (if (compression.asKnown().isPresent) 1 else 0) +
            (if (resolutionUnit.asKnown().isPresent) 1 else 0) +
            (if (thumbnailLength.asKnown().isPresent) 1 else 0) +
            (if (thumbnailOffset.asKnown().isPresent) 1 else 0) +
            (if (xResolution.asKnown().isPresent) 1 else 0) +
            (if (yResolution.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Thumbnail &&
            compression == other.compression &&
            resolutionUnit == other.resolutionUnit &&
            thumbnailLength == other.thumbnailLength &&
            thumbnailOffset == other.thumbnailOffset &&
            xResolution == other.xResolution &&
            yResolution == other.yResolution &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            compression,
            resolutionUnit,
            thumbnailLength,
            thumbnailOffset,
            xResolution,
            yResolution,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Thumbnail{compression=$compression, resolutionUnit=$resolutionUnit, thumbnailLength=$thumbnailLength, thumbnailOffset=$thumbnailOffset, xResolution=$xResolution, yResolution=$yResolution, additionalProperties=$additionalProperties}"
}
