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

/** Object containing Exif details. */
class ExifDetails
private constructor(
    private val apertureValue: JsonField<Double>,
    private val colorSpace: JsonField<Long>,
    private val createDate: JsonField<String>,
    private val customRendered: JsonField<Long>,
    private val dateTimeOriginal: JsonField<String>,
    private val exifImageHeight: JsonField<Long>,
    private val exifImageWidth: JsonField<Long>,
    private val exifVersion: JsonField<String>,
    private val exposureCompensation: JsonField<Double>,
    private val exposureMode: JsonField<Long>,
    private val exposureProgram: JsonField<Long>,
    private val exposureTime: JsonField<Double>,
    private val flash: JsonField<Long>,
    private val flashpixVersion: JsonField<String>,
    private val fNumber: JsonField<Double>,
    private val focalLength: JsonField<Long>,
    private val focalPlaneResolutionUnit: JsonField<Long>,
    private val focalPlaneXResolution: JsonField<Double>,
    private val focalPlaneYResolution: JsonField<Double>,
    private val interopOffset: JsonField<Long>,
    private val iso: JsonField<Long>,
    private val meteringMode: JsonField<Long>,
    private val sceneCaptureType: JsonField<Long>,
    private val shutterSpeedValue: JsonField<Double>,
    private val subSecTime: JsonField<String>,
    private val whiteBalance: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("ApertureValue")
        @ExcludeMissing
        apertureValue: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("ColorSpace") @ExcludeMissing colorSpace: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("CreateDate")
        @ExcludeMissing
        createDate: JsonField<String> = JsonMissing.of(),
        @JsonProperty("CustomRendered")
        @ExcludeMissing
        customRendered: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("DateTimeOriginal")
        @ExcludeMissing
        dateTimeOriginal: JsonField<String> = JsonMissing.of(),
        @JsonProperty("ExifImageHeight")
        @ExcludeMissing
        exifImageHeight: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ExifImageWidth")
        @ExcludeMissing
        exifImageWidth: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ExifVersion")
        @ExcludeMissing
        exifVersion: JsonField<String> = JsonMissing.of(),
        @JsonProperty("ExposureCompensation")
        @ExcludeMissing
        exposureCompensation: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("ExposureMode")
        @ExcludeMissing
        exposureMode: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ExposureProgram")
        @ExcludeMissing
        exposureProgram: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ExposureTime")
        @ExcludeMissing
        exposureTime: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("Flash") @ExcludeMissing flash: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("FlashpixVersion")
        @ExcludeMissing
        flashpixVersion: JsonField<String> = JsonMissing.of(),
        @JsonProperty("FNumber") @ExcludeMissing fNumber: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("FocalLength")
        @ExcludeMissing
        focalLength: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("FocalPlaneResolutionUnit")
        @ExcludeMissing
        focalPlaneResolutionUnit: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("FocalPlaneXResolution")
        @ExcludeMissing
        focalPlaneXResolution: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("FocalPlaneYResolution")
        @ExcludeMissing
        focalPlaneYResolution: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("InteropOffset")
        @ExcludeMissing
        interopOffset: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ISO") @ExcludeMissing iso: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("MeteringMode")
        @ExcludeMissing
        meteringMode: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("SceneCaptureType")
        @ExcludeMissing
        sceneCaptureType: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ShutterSpeedValue")
        @ExcludeMissing
        shutterSpeedValue: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("SubSecTime")
        @ExcludeMissing
        subSecTime: JsonField<String> = JsonMissing.of(),
        @JsonProperty("WhiteBalance")
        @ExcludeMissing
        whiteBalance: JsonField<Long> = JsonMissing.of(),
    ) : this(
        apertureValue,
        colorSpace,
        createDate,
        customRendered,
        dateTimeOriginal,
        exifImageHeight,
        exifImageWidth,
        exifVersion,
        exposureCompensation,
        exposureMode,
        exposureProgram,
        exposureTime,
        flash,
        flashpixVersion,
        fNumber,
        focalLength,
        focalPlaneResolutionUnit,
        focalPlaneXResolution,
        focalPlaneYResolution,
        interopOffset,
        iso,
        meteringMode,
        sceneCaptureType,
        shutterSpeedValue,
        subSecTime,
        whiteBalance,
        mutableMapOf(),
    )

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun apertureValue(): Optional<Double> = apertureValue.getOptional("ApertureValue")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun colorSpace(): Optional<Long> = colorSpace.getOptional("ColorSpace")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createDate(): Optional<String> = createDate.getOptional("CreateDate")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customRendered(): Optional<Long> = customRendered.getOptional("CustomRendered")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun dateTimeOriginal(): Optional<String> = dateTimeOriginal.getOptional("DateTimeOriginal")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exifImageHeight(): Optional<Long> = exifImageHeight.getOptional("ExifImageHeight")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exifImageWidth(): Optional<Long> = exifImageWidth.getOptional("ExifImageWidth")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exifVersion(): Optional<String> = exifVersion.getOptional("ExifVersion")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exposureCompensation(): Optional<Double> =
        exposureCompensation.getOptional("ExposureCompensation")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exposureMode(): Optional<Long> = exposureMode.getOptional("ExposureMode")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exposureProgram(): Optional<Long> = exposureProgram.getOptional("ExposureProgram")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exposureTime(): Optional<Double> = exposureTime.getOptional("ExposureTime")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun flash(): Optional<Long> = flash.getOptional("Flash")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun flashpixVersion(): Optional<String> = flashpixVersion.getOptional("FlashpixVersion")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fNumber(): Optional<Double> = fNumber.getOptional("FNumber")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun focalLength(): Optional<Long> = focalLength.getOptional("FocalLength")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun focalPlaneResolutionUnit(): Optional<Long> =
        focalPlaneResolutionUnit.getOptional("FocalPlaneResolutionUnit")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun focalPlaneXResolution(): Optional<Double> =
        focalPlaneXResolution.getOptional("FocalPlaneXResolution")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun focalPlaneYResolution(): Optional<Double> =
        focalPlaneYResolution.getOptional("FocalPlaneYResolution")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun interopOffset(): Optional<Long> = interopOffset.getOptional("InteropOffset")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun iso(): Optional<Long> = iso.getOptional("ISO")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun meteringMode(): Optional<Long> = meteringMode.getOptional("MeteringMode")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sceneCaptureType(): Optional<Long> = sceneCaptureType.getOptional("SceneCaptureType")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun shutterSpeedValue(): Optional<Double> = shutterSpeedValue.getOptional("ShutterSpeedValue")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun subSecTime(): Optional<String> = subSecTime.getOptional("SubSecTime")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun whiteBalance(): Optional<Long> = whiteBalance.getOptional("WhiteBalance")

    /**
     * Returns the raw JSON value of [apertureValue].
     *
     * Unlike [apertureValue], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ApertureValue")
    @ExcludeMissing
    fun _apertureValue(): JsonField<Double> = apertureValue

    /**
     * Returns the raw JSON value of [colorSpace].
     *
     * Unlike [colorSpace], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ColorSpace") @ExcludeMissing fun _colorSpace(): JsonField<Long> = colorSpace

    /**
     * Returns the raw JSON value of [createDate].
     *
     * Unlike [createDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("CreateDate") @ExcludeMissing fun _createDate(): JsonField<String> = createDate

    /**
     * Returns the raw JSON value of [customRendered].
     *
     * Unlike [customRendered], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("CustomRendered")
    @ExcludeMissing
    fun _customRendered(): JsonField<Long> = customRendered

    /**
     * Returns the raw JSON value of [dateTimeOriginal].
     *
     * Unlike [dateTimeOriginal], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("DateTimeOriginal")
    @ExcludeMissing
    fun _dateTimeOriginal(): JsonField<String> = dateTimeOriginal

    /**
     * Returns the raw JSON value of [exifImageHeight].
     *
     * Unlike [exifImageHeight], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ExifImageHeight")
    @ExcludeMissing
    fun _exifImageHeight(): JsonField<Long> = exifImageHeight

    /**
     * Returns the raw JSON value of [exifImageWidth].
     *
     * Unlike [exifImageWidth], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ExifImageWidth")
    @ExcludeMissing
    fun _exifImageWidth(): JsonField<Long> = exifImageWidth

    /**
     * Returns the raw JSON value of [exifVersion].
     *
     * Unlike [exifVersion], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ExifVersion") @ExcludeMissing fun _exifVersion(): JsonField<String> = exifVersion

    /**
     * Returns the raw JSON value of [exposureCompensation].
     *
     * Unlike [exposureCompensation], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("ExposureCompensation")
    @ExcludeMissing
    fun _exposureCompensation(): JsonField<Double> = exposureCompensation

    /**
     * Returns the raw JSON value of [exposureMode].
     *
     * Unlike [exposureMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ExposureMode")
    @ExcludeMissing
    fun _exposureMode(): JsonField<Long> = exposureMode

    /**
     * Returns the raw JSON value of [exposureProgram].
     *
     * Unlike [exposureProgram], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ExposureProgram")
    @ExcludeMissing
    fun _exposureProgram(): JsonField<Long> = exposureProgram

    /**
     * Returns the raw JSON value of [exposureTime].
     *
     * Unlike [exposureTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ExposureTime")
    @ExcludeMissing
    fun _exposureTime(): JsonField<Double> = exposureTime

    /**
     * Returns the raw JSON value of [flash].
     *
     * Unlike [flash], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("Flash") @ExcludeMissing fun _flash(): JsonField<Long> = flash

    /**
     * Returns the raw JSON value of [flashpixVersion].
     *
     * Unlike [flashpixVersion], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("FlashpixVersion")
    @ExcludeMissing
    fun _flashpixVersion(): JsonField<String> = flashpixVersion

    /**
     * Returns the raw JSON value of [fNumber].
     *
     * Unlike [fNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("FNumber") @ExcludeMissing fun _fNumber(): JsonField<Double> = fNumber

    /**
     * Returns the raw JSON value of [focalLength].
     *
     * Unlike [focalLength], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("FocalLength") @ExcludeMissing fun _focalLength(): JsonField<Long> = focalLength

    /**
     * Returns the raw JSON value of [focalPlaneResolutionUnit].
     *
     * Unlike [focalPlaneResolutionUnit], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("FocalPlaneResolutionUnit")
    @ExcludeMissing
    fun _focalPlaneResolutionUnit(): JsonField<Long> = focalPlaneResolutionUnit

    /**
     * Returns the raw JSON value of [focalPlaneXResolution].
     *
     * Unlike [focalPlaneXResolution], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("FocalPlaneXResolution")
    @ExcludeMissing
    fun _focalPlaneXResolution(): JsonField<Double> = focalPlaneXResolution

    /**
     * Returns the raw JSON value of [focalPlaneYResolution].
     *
     * Unlike [focalPlaneYResolution], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("FocalPlaneYResolution")
    @ExcludeMissing
    fun _focalPlaneYResolution(): JsonField<Double> = focalPlaneYResolution

    /**
     * Returns the raw JSON value of [interopOffset].
     *
     * Unlike [interopOffset], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("InteropOffset")
    @ExcludeMissing
    fun _interopOffset(): JsonField<Long> = interopOffset

    /**
     * Returns the raw JSON value of [iso].
     *
     * Unlike [iso], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ISO") @ExcludeMissing fun _iso(): JsonField<Long> = iso

    /**
     * Returns the raw JSON value of [meteringMode].
     *
     * Unlike [meteringMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("MeteringMode")
    @ExcludeMissing
    fun _meteringMode(): JsonField<Long> = meteringMode

    /**
     * Returns the raw JSON value of [sceneCaptureType].
     *
     * Unlike [sceneCaptureType], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("SceneCaptureType")
    @ExcludeMissing
    fun _sceneCaptureType(): JsonField<Long> = sceneCaptureType

    /**
     * Returns the raw JSON value of [shutterSpeedValue].
     *
     * Unlike [shutterSpeedValue], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("ShutterSpeedValue")
    @ExcludeMissing
    fun _shutterSpeedValue(): JsonField<Double> = shutterSpeedValue

    /**
     * Returns the raw JSON value of [subSecTime].
     *
     * Unlike [subSecTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("SubSecTime") @ExcludeMissing fun _subSecTime(): JsonField<String> = subSecTime

    /**
     * Returns the raw JSON value of [whiteBalance].
     *
     * Unlike [whiteBalance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("WhiteBalance")
    @ExcludeMissing
    fun _whiteBalance(): JsonField<Long> = whiteBalance

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

        /** Returns a mutable builder for constructing an instance of [ExifDetails]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExifDetails]. */
    class Builder internal constructor() {

        private var apertureValue: JsonField<Double> = JsonMissing.of()
        private var colorSpace: JsonField<Long> = JsonMissing.of()
        private var createDate: JsonField<String> = JsonMissing.of()
        private var customRendered: JsonField<Long> = JsonMissing.of()
        private var dateTimeOriginal: JsonField<String> = JsonMissing.of()
        private var exifImageHeight: JsonField<Long> = JsonMissing.of()
        private var exifImageWidth: JsonField<Long> = JsonMissing.of()
        private var exifVersion: JsonField<String> = JsonMissing.of()
        private var exposureCompensation: JsonField<Double> = JsonMissing.of()
        private var exposureMode: JsonField<Long> = JsonMissing.of()
        private var exposureProgram: JsonField<Long> = JsonMissing.of()
        private var exposureTime: JsonField<Double> = JsonMissing.of()
        private var flash: JsonField<Long> = JsonMissing.of()
        private var flashpixVersion: JsonField<String> = JsonMissing.of()
        private var fNumber: JsonField<Double> = JsonMissing.of()
        private var focalLength: JsonField<Long> = JsonMissing.of()
        private var focalPlaneResolutionUnit: JsonField<Long> = JsonMissing.of()
        private var focalPlaneXResolution: JsonField<Double> = JsonMissing.of()
        private var focalPlaneYResolution: JsonField<Double> = JsonMissing.of()
        private var interopOffset: JsonField<Long> = JsonMissing.of()
        private var iso: JsonField<Long> = JsonMissing.of()
        private var meteringMode: JsonField<Long> = JsonMissing.of()
        private var sceneCaptureType: JsonField<Long> = JsonMissing.of()
        private var shutterSpeedValue: JsonField<Double> = JsonMissing.of()
        private var subSecTime: JsonField<String> = JsonMissing.of()
        private var whiteBalance: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(exifDetails: ExifDetails) = apply {
            apertureValue = exifDetails.apertureValue
            colorSpace = exifDetails.colorSpace
            createDate = exifDetails.createDate
            customRendered = exifDetails.customRendered
            dateTimeOriginal = exifDetails.dateTimeOriginal
            exifImageHeight = exifDetails.exifImageHeight
            exifImageWidth = exifDetails.exifImageWidth
            exifVersion = exifDetails.exifVersion
            exposureCompensation = exifDetails.exposureCompensation
            exposureMode = exifDetails.exposureMode
            exposureProgram = exifDetails.exposureProgram
            exposureTime = exifDetails.exposureTime
            flash = exifDetails.flash
            flashpixVersion = exifDetails.flashpixVersion
            fNumber = exifDetails.fNumber
            focalLength = exifDetails.focalLength
            focalPlaneResolutionUnit = exifDetails.focalPlaneResolutionUnit
            focalPlaneXResolution = exifDetails.focalPlaneXResolution
            focalPlaneYResolution = exifDetails.focalPlaneYResolution
            interopOffset = exifDetails.interopOffset
            iso = exifDetails.iso
            meteringMode = exifDetails.meteringMode
            sceneCaptureType = exifDetails.sceneCaptureType
            shutterSpeedValue = exifDetails.shutterSpeedValue
            subSecTime = exifDetails.subSecTime
            whiteBalance = exifDetails.whiteBalance
            additionalProperties = exifDetails.additionalProperties.toMutableMap()
        }

        fun apertureValue(apertureValue: Double) = apertureValue(JsonField.of(apertureValue))

        /**
         * Sets [Builder.apertureValue] to an arbitrary JSON value.
         *
         * You should usually call [Builder.apertureValue] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun apertureValue(apertureValue: JsonField<Double>) = apply {
            this.apertureValue = apertureValue
        }

        fun colorSpace(colorSpace: Long) = colorSpace(JsonField.of(colorSpace))

        /**
         * Sets [Builder.colorSpace] to an arbitrary JSON value.
         *
         * You should usually call [Builder.colorSpace] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun colorSpace(colorSpace: JsonField<Long>) = apply { this.colorSpace = colorSpace }

        fun createDate(createDate: String) = createDate(JsonField.of(createDate))

        /**
         * Sets [Builder.createDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createDate] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun createDate(createDate: JsonField<String>) = apply { this.createDate = createDate }

        fun customRendered(customRendered: Long) = customRendered(JsonField.of(customRendered))

        /**
         * Sets [Builder.customRendered] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customRendered] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun customRendered(customRendered: JsonField<Long>) = apply {
            this.customRendered = customRendered
        }

        fun dateTimeOriginal(dateTimeOriginal: String) =
            dateTimeOriginal(JsonField.of(dateTimeOriginal))

        /**
         * Sets [Builder.dateTimeOriginal] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dateTimeOriginal] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun dateTimeOriginal(dateTimeOriginal: JsonField<String>) = apply {
            this.dateTimeOriginal = dateTimeOriginal
        }

        fun exifImageHeight(exifImageHeight: Long) = exifImageHeight(JsonField.of(exifImageHeight))

        /**
         * Sets [Builder.exifImageHeight] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exifImageHeight] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun exifImageHeight(exifImageHeight: JsonField<Long>) = apply {
            this.exifImageHeight = exifImageHeight
        }

        fun exifImageWidth(exifImageWidth: Long) = exifImageWidth(JsonField.of(exifImageWidth))

        /**
         * Sets [Builder.exifImageWidth] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exifImageWidth] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun exifImageWidth(exifImageWidth: JsonField<Long>) = apply {
            this.exifImageWidth = exifImageWidth
        }

        fun exifVersion(exifVersion: String) = exifVersion(JsonField.of(exifVersion))

        /**
         * Sets [Builder.exifVersion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exifVersion] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun exifVersion(exifVersion: JsonField<String>) = apply { this.exifVersion = exifVersion }

        fun exposureCompensation(exposureCompensation: Double) =
            exposureCompensation(JsonField.of(exposureCompensation))

        /**
         * Sets [Builder.exposureCompensation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exposureCompensation] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun exposureCompensation(exposureCompensation: JsonField<Double>) = apply {
            this.exposureCompensation = exposureCompensation
        }

        fun exposureMode(exposureMode: Long) = exposureMode(JsonField.of(exposureMode))

        /**
         * Sets [Builder.exposureMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exposureMode] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun exposureMode(exposureMode: JsonField<Long>) = apply { this.exposureMode = exposureMode }

        fun exposureProgram(exposureProgram: Long) = exposureProgram(JsonField.of(exposureProgram))

        /**
         * Sets [Builder.exposureProgram] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exposureProgram] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun exposureProgram(exposureProgram: JsonField<Long>) = apply {
            this.exposureProgram = exposureProgram
        }

        fun exposureTime(exposureTime: Double) = exposureTime(JsonField.of(exposureTime))

        /**
         * Sets [Builder.exposureTime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exposureTime] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun exposureTime(exposureTime: JsonField<Double>) = apply {
            this.exposureTime = exposureTime
        }

        fun flash(flash: Long) = flash(JsonField.of(flash))

        /**
         * Sets [Builder.flash] to an arbitrary JSON value.
         *
         * You should usually call [Builder.flash] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun flash(flash: JsonField<Long>) = apply { this.flash = flash }

        fun flashpixVersion(flashpixVersion: String) =
            flashpixVersion(JsonField.of(flashpixVersion))

        /**
         * Sets [Builder.flashpixVersion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.flashpixVersion] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun flashpixVersion(flashpixVersion: JsonField<String>) = apply {
            this.flashpixVersion = flashpixVersion
        }

        fun fNumber(fNumber: Double) = fNumber(JsonField.of(fNumber))

        /**
         * Sets [Builder.fNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fNumber] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fNumber(fNumber: JsonField<Double>) = apply { this.fNumber = fNumber }

        fun focalLength(focalLength: Long) = focalLength(JsonField.of(focalLength))

        /**
         * Sets [Builder.focalLength] to an arbitrary JSON value.
         *
         * You should usually call [Builder.focalLength] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun focalLength(focalLength: JsonField<Long>) = apply { this.focalLength = focalLength }

        fun focalPlaneResolutionUnit(focalPlaneResolutionUnit: Long) =
            focalPlaneResolutionUnit(JsonField.of(focalPlaneResolutionUnit))

        /**
         * Sets [Builder.focalPlaneResolutionUnit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.focalPlaneResolutionUnit] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun focalPlaneResolutionUnit(focalPlaneResolutionUnit: JsonField<Long>) = apply {
            this.focalPlaneResolutionUnit = focalPlaneResolutionUnit
        }

        fun focalPlaneXResolution(focalPlaneXResolution: Double) =
            focalPlaneXResolution(JsonField.of(focalPlaneXResolution))

        /**
         * Sets [Builder.focalPlaneXResolution] to an arbitrary JSON value.
         *
         * You should usually call [Builder.focalPlaneXResolution] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun focalPlaneXResolution(focalPlaneXResolution: JsonField<Double>) = apply {
            this.focalPlaneXResolution = focalPlaneXResolution
        }

        fun focalPlaneYResolution(focalPlaneYResolution: Double) =
            focalPlaneYResolution(JsonField.of(focalPlaneYResolution))

        /**
         * Sets [Builder.focalPlaneYResolution] to an arbitrary JSON value.
         *
         * You should usually call [Builder.focalPlaneYResolution] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun focalPlaneYResolution(focalPlaneYResolution: JsonField<Double>) = apply {
            this.focalPlaneYResolution = focalPlaneYResolution
        }

        fun interopOffset(interopOffset: Long) = interopOffset(JsonField.of(interopOffset))

        /**
         * Sets [Builder.interopOffset] to an arbitrary JSON value.
         *
         * You should usually call [Builder.interopOffset] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun interopOffset(interopOffset: JsonField<Long>) = apply {
            this.interopOffset = interopOffset
        }

        fun iso(iso: Long) = iso(JsonField.of(iso))

        /**
         * Sets [Builder.iso] to an arbitrary JSON value.
         *
         * You should usually call [Builder.iso] with a well-typed [Long] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun iso(iso: JsonField<Long>) = apply { this.iso = iso }

        fun meteringMode(meteringMode: Long) = meteringMode(JsonField.of(meteringMode))

        /**
         * Sets [Builder.meteringMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.meteringMode] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun meteringMode(meteringMode: JsonField<Long>) = apply { this.meteringMode = meteringMode }

        fun sceneCaptureType(sceneCaptureType: Long) =
            sceneCaptureType(JsonField.of(sceneCaptureType))

        /**
         * Sets [Builder.sceneCaptureType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sceneCaptureType] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sceneCaptureType(sceneCaptureType: JsonField<Long>) = apply {
            this.sceneCaptureType = sceneCaptureType
        }

        fun shutterSpeedValue(shutterSpeedValue: Double) =
            shutterSpeedValue(JsonField.of(shutterSpeedValue))

        /**
         * Sets [Builder.shutterSpeedValue] to an arbitrary JSON value.
         *
         * You should usually call [Builder.shutterSpeedValue] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun shutterSpeedValue(shutterSpeedValue: JsonField<Double>) = apply {
            this.shutterSpeedValue = shutterSpeedValue
        }

        fun subSecTime(subSecTime: String) = subSecTime(JsonField.of(subSecTime))

        /**
         * Sets [Builder.subSecTime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subSecTime] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun subSecTime(subSecTime: JsonField<String>) = apply { this.subSecTime = subSecTime }

        fun whiteBalance(whiteBalance: Long) = whiteBalance(JsonField.of(whiteBalance))

        /**
         * Sets [Builder.whiteBalance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.whiteBalance] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun whiteBalance(whiteBalance: JsonField<Long>) = apply { this.whiteBalance = whiteBalance }

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
         * Returns an immutable instance of [ExifDetails].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ExifDetails =
            ExifDetails(
                apertureValue,
                colorSpace,
                createDate,
                customRendered,
                dateTimeOriginal,
                exifImageHeight,
                exifImageWidth,
                exifVersion,
                exposureCompensation,
                exposureMode,
                exposureProgram,
                exposureTime,
                flash,
                flashpixVersion,
                fNumber,
                focalLength,
                focalPlaneResolutionUnit,
                focalPlaneXResolution,
                focalPlaneYResolution,
                interopOffset,
                iso,
                meteringMode,
                sceneCaptureType,
                shutterSpeedValue,
                subSecTime,
                whiteBalance,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ExifDetails = apply {
        if (validated) {
            return@apply
        }

        apertureValue()
        colorSpace()
        createDate()
        customRendered()
        dateTimeOriginal()
        exifImageHeight()
        exifImageWidth()
        exifVersion()
        exposureCompensation()
        exposureMode()
        exposureProgram()
        exposureTime()
        flash()
        flashpixVersion()
        fNumber()
        focalLength()
        focalPlaneResolutionUnit()
        focalPlaneXResolution()
        focalPlaneYResolution()
        interopOffset()
        iso()
        meteringMode()
        sceneCaptureType()
        shutterSpeedValue()
        subSecTime()
        whiteBalance()
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
        (if (apertureValue.asKnown().isPresent) 1 else 0) +
            (if (colorSpace.asKnown().isPresent) 1 else 0) +
            (if (createDate.asKnown().isPresent) 1 else 0) +
            (if (customRendered.asKnown().isPresent) 1 else 0) +
            (if (dateTimeOriginal.asKnown().isPresent) 1 else 0) +
            (if (exifImageHeight.asKnown().isPresent) 1 else 0) +
            (if (exifImageWidth.asKnown().isPresent) 1 else 0) +
            (if (exifVersion.asKnown().isPresent) 1 else 0) +
            (if (exposureCompensation.asKnown().isPresent) 1 else 0) +
            (if (exposureMode.asKnown().isPresent) 1 else 0) +
            (if (exposureProgram.asKnown().isPresent) 1 else 0) +
            (if (exposureTime.asKnown().isPresent) 1 else 0) +
            (if (flash.asKnown().isPresent) 1 else 0) +
            (if (flashpixVersion.asKnown().isPresent) 1 else 0) +
            (if (fNumber.asKnown().isPresent) 1 else 0) +
            (if (focalLength.asKnown().isPresent) 1 else 0) +
            (if (focalPlaneResolutionUnit.asKnown().isPresent) 1 else 0) +
            (if (focalPlaneXResolution.asKnown().isPresent) 1 else 0) +
            (if (focalPlaneYResolution.asKnown().isPresent) 1 else 0) +
            (if (interopOffset.asKnown().isPresent) 1 else 0) +
            (if (iso.asKnown().isPresent) 1 else 0) +
            (if (meteringMode.asKnown().isPresent) 1 else 0) +
            (if (sceneCaptureType.asKnown().isPresent) 1 else 0) +
            (if (shutterSpeedValue.asKnown().isPresent) 1 else 0) +
            (if (subSecTime.asKnown().isPresent) 1 else 0) +
            (if (whiteBalance.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExifDetails &&
            apertureValue == other.apertureValue &&
            colorSpace == other.colorSpace &&
            createDate == other.createDate &&
            customRendered == other.customRendered &&
            dateTimeOriginal == other.dateTimeOriginal &&
            exifImageHeight == other.exifImageHeight &&
            exifImageWidth == other.exifImageWidth &&
            exifVersion == other.exifVersion &&
            exposureCompensation == other.exposureCompensation &&
            exposureMode == other.exposureMode &&
            exposureProgram == other.exposureProgram &&
            exposureTime == other.exposureTime &&
            flash == other.flash &&
            flashpixVersion == other.flashpixVersion &&
            fNumber == other.fNumber &&
            focalLength == other.focalLength &&
            focalPlaneResolutionUnit == other.focalPlaneResolutionUnit &&
            focalPlaneXResolution == other.focalPlaneXResolution &&
            focalPlaneYResolution == other.focalPlaneYResolution &&
            interopOffset == other.interopOffset &&
            iso == other.iso &&
            meteringMode == other.meteringMode &&
            sceneCaptureType == other.sceneCaptureType &&
            shutterSpeedValue == other.shutterSpeedValue &&
            subSecTime == other.subSecTime &&
            whiteBalance == other.whiteBalance &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            apertureValue,
            colorSpace,
            createDate,
            customRendered,
            dateTimeOriginal,
            exifImageHeight,
            exifImageWidth,
            exifVersion,
            exposureCompensation,
            exposureMode,
            exposureProgram,
            exposureTime,
            flash,
            flashpixVersion,
            fNumber,
            focalLength,
            focalPlaneResolutionUnit,
            focalPlaneXResolution,
            focalPlaneYResolution,
            interopOffset,
            iso,
            meteringMode,
            sceneCaptureType,
            shutterSpeedValue,
            subSecTime,
            whiteBalance,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ExifDetails{apertureValue=$apertureValue, colorSpace=$colorSpace, createDate=$createDate, customRendered=$customRendered, dateTimeOriginal=$dateTimeOriginal, exifImageHeight=$exifImageHeight, exifImageWidth=$exifImageWidth, exifVersion=$exifVersion, exposureCompensation=$exposureCompensation, exposureMode=$exposureMode, exposureProgram=$exposureProgram, exposureTime=$exposureTime, flash=$flash, flashpixVersion=$flashpixVersion, fNumber=$fNumber, focalLength=$focalLength, focalPlaneResolutionUnit=$focalPlaneResolutionUnit, focalPlaneXResolution=$focalPlaneXResolution, focalPlaneYResolution=$focalPlaneYResolution, interopOffset=$interopOffset, iso=$iso, meteringMode=$meteringMode, sceneCaptureType=$sceneCaptureType, shutterSpeedValue=$shutterSpeedValue, subSecTime=$subSecTime, whiteBalance=$whiteBalance, additionalProperties=$additionalProperties}"
}
