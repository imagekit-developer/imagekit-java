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

/** Object containing EXIF image information. */
class ExifImage
private constructor(
    private val exifOffset: JsonField<Long>,
    private val gpsInfo: JsonField<Long>,
    private val make: JsonField<String>,
    private val model: JsonField<String>,
    private val modifyDate: JsonField<String>,
    private val orientation: JsonField<Long>,
    private val resolutionUnit: JsonField<Long>,
    private val software: JsonField<String>,
    private val xResolution: JsonField<Long>,
    private val yCbCrPositioning: JsonField<Long>,
    private val yResolution: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("ExifOffset") @ExcludeMissing exifOffset: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("GPSInfo") @ExcludeMissing gpsInfo: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("Make") @ExcludeMissing make: JsonField<String> = JsonMissing.of(),
        @JsonProperty("Model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("ModifyDate")
        @ExcludeMissing
        modifyDate: JsonField<String> = JsonMissing.of(),
        @JsonProperty("Orientation")
        @ExcludeMissing
        orientation: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ResolutionUnit")
        @ExcludeMissing
        resolutionUnit: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("Software") @ExcludeMissing software: JsonField<String> = JsonMissing.of(),
        @JsonProperty("XResolution")
        @ExcludeMissing
        xResolution: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("YCbCrPositioning")
        @ExcludeMissing
        yCbCrPositioning: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("YResolution") @ExcludeMissing yResolution: JsonField<Long> = JsonMissing.of(),
    ) : this(
        exifOffset,
        gpsInfo,
        make,
        model,
        modifyDate,
        orientation,
        resolutionUnit,
        software,
        xResolution,
        yCbCrPositioning,
        yResolution,
        mutableMapOf(),
    )

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exifOffset(): Optional<Long> = exifOffset.getOptional("ExifOffset")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun gpsInfo(): Optional<Long> = gpsInfo.getOptional("GPSInfo")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun make(): Optional<String> = make.getOptional("Make")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<String> = model.getOptional("Model")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun modifyDate(): Optional<String> = modifyDate.getOptional("ModifyDate")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun orientation(): Optional<Long> = orientation.getOptional("Orientation")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun resolutionUnit(): Optional<Long> = resolutionUnit.getOptional("ResolutionUnit")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun software(): Optional<String> = software.getOptional("Software")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun xResolution(): Optional<Long> = xResolution.getOptional("XResolution")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun yCbCrPositioning(): Optional<Long> = yCbCrPositioning.getOptional("YCbCrPositioning")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun yResolution(): Optional<Long> = yResolution.getOptional("YResolution")

    /**
     * Returns the raw JSON value of [exifOffset].
     *
     * Unlike [exifOffset], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ExifOffset") @ExcludeMissing fun _exifOffset(): JsonField<Long> = exifOffset

    /**
     * Returns the raw JSON value of [gpsInfo].
     *
     * Unlike [gpsInfo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("GPSInfo") @ExcludeMissing fun _gpsInfo(): JsonField<Long> = gpsInfo

    /**
     * Returns the raw JSON value of [make].
     *
     * Unlike [make], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("Make") @ExcludeMissing fun _make(): JsonField<String> = make

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("Model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [modifyDate].
     *
     * Unlike [modifyDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ModifyDate") @ExcludeMissing fun _modifyDate(): JsonField<String> = modifyDate

    /**
     * Returns the raw JSON value of [orientation].
     *
     * Unlike [orientation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("Orientation") @ExcludeMissing fun _orientation(): JsonField<Long> = orientation

    /**
     * Returns the raw JSON value of [resolutionUnit].
     *
     * Unlike [resolutionUnit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ResolutionUnit")
    @ExcludeMissing
    fun _resolutionUnit(): JsonField<Long> = resolutionUnit

    /**
     * Returns the raw JSON value of [software].
     *
     * Unlike [software], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("Software") @ExcludeMissing fun _software(): JsonField<String> = software

    /**
     * Returns the raw JSON value of [xResolution].
     *
     * Unlike [xResolution], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("XResolution") @ExcludeMissing fun _xResolution(): JsonField<Long> = xResolution

    /**
     * Returns the raw JSON value of [yCbCrPositioning].
     *
     * Unlike [yCbCrPositioning], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("YCbCrPositioning")
    @ExcludeMissing
    fun _yCbCrPositioning(): JsonField<Long> = yCbCrPositioning

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

        /** Returns a mutable builder for constructing an instance of [ExifImage]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExifImage]. */
    class Builder internal constructor() {

        private var exifOffset: JsonField<Long> = JsonMissing.of()
        private var gpsInfo: JsonField<Long> = JsonMissing.of()
        private var make: JsonField<String> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var modifyDate: JsonField<String> = JsonMissing.of()
        private var orientation: JsonField<Long> = JsonMissing.of()
        private var resolutionUnit: JsonField<Long> = JsonMissing.of()
        private var software: JsonField<String> = JsonMissing.of()
        private var xResolution: JsonField<Long> = JsonMissing.of()
        private var yCbCrPositioning: JsonField<Long> = JsonMissing.of()
        private var yResolution: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(exifImage: ExifImage) = apply {
            exifOffset = exifImage.exifOffset
            gpsInfo = exifImage.gpsInfo
            make = exifImage.make
            model = exifImage.model
            modifyDate = exifImage.modifyDate
            orientation = exifImage.orientation
            resolutionUnit = exifImage.resolutionUnit
            software = exifImage.software
            xResolution = exifImage.xResolution
            yCbCrPositioning = exifImage.yCbCrPositioning
            yResolution = exifImage.yResolution
            additionalProperties = exifImage.additionalProperties.toMutableMap()
        }

        fun exifOffset(exifOffset: Long) = exifOffset(JsonField.of(exifOffset))

        /**
         * Sets [Builder.exifOffset] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exifOffset] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun exifOffset(exifOffset: JsonField<Long>) = apply { this.exifOffset = exifOffset }

        fun gpsInfo(gpsInfo: Long) = gpsInfo(JsonField.of(gpsInfo))

        /**
         * Sets [Builder.gpsInfo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.gpsInfo] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun gpsInfo(gpsInfo: JsonField<Long>) = apply { this.gpsInfo = gpsInfo }

        fun make(make: String) = make(JsonField.of(make))

        /**
         * Sets [Builder.make] to an arbitrary JSON value.
         *
         * You should usually call [Builder.make] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun make(make: JsonField<String>) = apply { this.make = make }

        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        fun modifyDate(modifyDate: String) = modifyDate(JsonField.of(modifyDate))

        /**
         * Sets [Builder.modifyDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.modifyDate] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun modifyDate(modifyDate: JsonField<String>) = apply { this.modifyDate = modifyDate }

        fun orientation(orientation: Long) = orientation(JsonField.of(orientation))

        /**
         * Sets [Builder.orientation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orientation] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orientation(orientation: JsonField<Long>) = apply { this.orientation = orientation }

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

        fun software(software: String) = software(JsonField.of(software))

        /**
         * Sets [Builder.software] to an arbitrary JSON value.
         *
         * You should usually call [Builder.software] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun software(software: JsonField<String>) = apply { this.software = software }

        fun xResolution(xResolution: Long) = xResolution(JsonField.of(xResolution))

        /**
         * Sets [Builder.xResolution] to an arbitrary JSON value.
         *
         * You should usually call [Builder.xResolution] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun xResolution(xResolution: JsonField<Long>) = apply { this.xResolution = xResolution }

        fun yCbCrPositioning(yCbCrPositioning: Long) =
            yCbCrPositioning(JsonField.of(yCbCrPositioning))

        /**
         * Sets [Builder.yCbCrPositioning] to an arbitrary JSON value.
         *
         * You should usually call [Builder.yCbCrPositioning] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun yCbCrPositioning(yCbCrPositioning: JsonField<Long>) = apply {
            this.yCbCrPositioning = yCbCrPositioning
        }

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
         * Returns an immutable instance of [ExifImage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ExifImage =
            ExifImage(
                exifOffset,
                gpsInfo,
                make,
                model,
                modifyDate,
                orientation,
                resolutionUnit,
                software,
                xResolution,
                yCbCrPositioning,
                yResolution,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ExifImage = apply {
        if (validated) {
            return@apply
        }

        exifOffset()
        gpsInfo()
        make()
        model()
        modifyDate()
        orientation()
        resolutionUnit()
        software()
        xResolution()
        yCbCrPositioning()
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
        (if (exifOffset.asKnown().isPresent) 1 else 0) +
            (if (gpsInfo.asKnown().isPresent) 1 else 0) +
            (if (make.asKnown().isPresent) 1 else 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (if (modifyDate.asKnown().isPresent) 1 else 0) +
            (if (orientation.asKnown().isPresent) 1 else 0) +
            (if (resolutionUnit.asKnown().isPresent) 1 else 0) +
            (if (software.asKnown().isPresent) 1 else 0) +
            (if (xResolution.asKnown().isPresent) 1 else 0) +
            (if (yCbCrPositioning.asKnown().isPresent) 1 else 0) +
            (if (yResolution.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExifImage &&
            exifOffset == other.exifOffset &&
            gpsInfo == other.gpsInfo &&
            make == other.make &&
            model == other.model &&
            modifyDate == other.modifyDate &&
            orientation == other.orientation &&
            resolutionUnit == other.resolutionUnit &&
            software == other.software &&
            xResolution == other.xResolution &&
            yCbCrPositioning == other.yCbCrPositioning &&
            yResolution == other.yResolution &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            exifOffset,
            gpsInfo,
            make,
            model,
            modifyDate,
            orientation,
            resolutionUnit,
            software,
            xResolution,
            yCbCrPositioning,
            yResolution,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ExifImage{exifOffset=$exifOffset, gpsInfo=$gpsInfo, make=$make, model=$model, modifyDate=$modifyDate, orientation=$orientation, resolutionUnit=$resolutionUnit, software=$software, xResolution=$xResolution, yCbCrPositioning=$yCbCrPositioning, yResolution=$yResolution, additionalProperties=$additionalProperties}"
}
