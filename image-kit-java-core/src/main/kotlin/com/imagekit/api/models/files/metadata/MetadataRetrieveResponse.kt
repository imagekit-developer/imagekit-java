// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.metadata

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import com.imagekit.api.models.files.ExifDetails
import com.imagekit.api.models.files.ExifImage
import com.imagekit.api.models.files.Gps
import com.imagekit.api.models.files.Interoperability
import com.imagekit.api.models.files.Thumbnail
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** JSON object containing metadata. */
class MetadataRetrieveResponse
private constructor(
    private val audioCodec: JsonField<String>,
    private val bitRate: JsonField<Long>,
    private val density: JsonField<Long>,
    private val duration: JsonField<Long>,
    private val exif: JsonField<Exif>,
    private val format: JsonField<String>,
    private val hasColorProfile: JsonField<Boolean>,
    private val hasTransparency: JsonField<Boolean>,
    private val height: JsonField<Long>,
    private val pHash: JsonField<String>,
    private val quality: JsonField<Long>,
    private val size: JsonField<Long>,
    private val videoCodec: JsonField<String>,
    private val width: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("audioCodec")
        @ExcludeMissing
        audioCodec: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bitRate") @ExcludeMissing bitRate: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("density") @ExcludeMissing density: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("duration") @ExcludeMissing duration: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("exif") @ExcludeMissing exif: JsonField<Exif> = JsonMissing.of(),
        @JsonProperty("format") @ExcludeMissing format: JsonField<String> = JsonMissing.of(),
        @JsonProperty("hasColorProfile")
        @ExcludeMissing
        hasColorProfile: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("hasTransparency")
        @ExcludeMissing
        hasTransparency: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("height") @ExcludeMissing height: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("pHash") @ExcludeMissing pHash: JsonField<String> = JsonMissing.of(),
        @JsonProperty("quality") @ExcludeMissing quality: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("size") @ExcludeMissing size: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("videoCodec")
        @ExcludeMissing
        videoCodec: JsonField<String> = JsonMissing.of(),
        @JsonProperty("width") @ExcludeMissing width: JsonField<Long> = JsonMissing.of(),
    ) : this(
        audioCodec,
        bitRate,
        density,
        duration,
        exif,
        format,
        hasColorProfile,
        hasTransparency,
        height,
        pHash,
        quality,
        size,
        videoCodec,
        width,
        mutableMapOf(),
    )

    /**
     * The audio codec used in the video (only for video).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audioCodec(): Optional<String> = audioCodec.getOptional("audioCodec")

    /**
     * The bit rate of the video in kbps (only for video).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bitRate(): Optional<Long> = bitRate.getOptional("bitRate")

    /**
     * The density of the image in DPI.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun density(): Optional<Long> = density.getOptional("density")

    /**
     * The duration of the video in seconds (only for video).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun duration(): Optional<Long> = duration.getOptional("duration")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exif(): Optional<Exif> = exif.getOptional("exif")

    /**
     * The format of the file (e.g., 'jpg', 'mp4').
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun format(): Optional<String> = format.getOptional("format")

    /**
     * Indicates if the image has a color profile.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun hasColorProfile(): Optional<Boolean> = hasColorProfile.getOptional("hasColorProfile")

    /**
     * Indicates if the image contains transparent areas.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun hasTransparency(): Optional<Boolean> = hasTransparency.getOptional("hasTransparency")

    /**
     * The height of the image or video in pixels.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun height(): Optional<Long> = height.getOptional("height")

    /**
     * Perceptual hash of the image.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun pHash(): Optional<String> = pHash.getOptional("pHash")

    /**
     * The quality indicator of the image.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun quality(): Optional<Long> = quality.getOptional("quality")

    /**
     * The file size in bytes.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun size(): Optional<Long> = size.getOptional("size")

    /**
     * The video codec used in the video (only for video).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun videoCodec(): Optional<String> = videoCodec.getOptional("videoCodec")

    /**
     * The width of the image or video in pixels.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun width(): Optional<Long> = width.getOptional("width")

    /**
     * Returns the raw JSON value of [audioCodec].
     *
     * Unlike [audioCodec], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audioCodec") @ExcludeMissing fun _audioCodec(): JsonField<String> = audioCodec

    /**
     * Returns the raw JSON value of [bitRate].
     *
     * Unlike [bitRate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bitRate") @ExcludeMissing fun _bitRate(): JsonField<Long> = bitRate

    /**
     * Returns the raw JSON value of [density].
     *
     * Unlike [density], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("density") @ExcludeMissing fun _density(): JsonField<Long> = density

    /**
     * Returns the raw JSON value of [duration].
     *
     * Unlike [duration], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("duration") @ExcludeMissing fun _duration(): JsonField<Long> = duration

    /**
     * Returns the raw JSON value of [exif].
     *
     * Unlike [exif], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("exif") @ExcludeMissing fun _exif(): JsonField<Exif> = exif

    /**
     * Returns the raw JSON value of [format].
     *
     * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<String> = format

    /**
     * Returns the raw JSON value of [hasColorProfile].
     *
     * Unlike [hasColorProfile], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hasColorProfile")
    @ExcludeMissing
    fun _hasColorProfile(): JsonField<Boolean> = hasColorProfile

    /**
     * Returns the raw JSON value of [hasTransparency].
     *
     * Unlike [hasTransparency], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hasTransparency")
    @ExcludeMissing
    fun _hasTransparency(): JsonField<Boolean> = hasTransparency

    /**
     * Returns the raw JSON value of [height].
     *
     * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

    /**
     * Returns the raw JSON value of [pHash].
     *
     * Unlike [pHash], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pHash") @ExcludeMissing fun _pHash(): JsonField<String> = pHash

    /**
     * Returns the raw JSON value of [quality].
     *
     * Unlike [quality], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quality") @ExcludeMissing fun _quality(): JsonField<Long> = quality

    /**
     * Returns the raw JSON value of [size].
     *
     * Unlike [size], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<Long> = size

    /**
     * Returns the raw JSON value of [videoCodec].
     *
     * Unlike [videoCodec], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("videoCodec") @ExcludeMissing fun _videoCodec(): JsonField<String> = videoCodec

    /**
     * Returns the raw JSON value of [width].
     *
     * Unlike [width], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("width") @ExcludeMissing fun _width(): JsonField<Long> = width

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

        /** Returns a mutable builder for constructing an instance of [MetadataRetrieveResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MetadataRetrieveResponse]. */
    class Builder internal constructor() {

        private var audioCodec: JsonField<String> = JsonMissing.of()
        private var bitRate: JsonField<Long> = JsonMissing.of()
        private var density: JsonField<Long> = JsonMissing.of()
        private var duration: JsonField<Long> = JsonMissing.of()
        private var exif: JsonField<Exif> = JsonMissing.of()
        private var format: JsonField<String> = JsonMissing.of()
        private var hasColorProfile: JsonField<Boolean> = JsonMissing.of()
        private var hasTransparency: JsonField<Boolean> = JsonMissing.of()
        private var height: JsonField<Long> = JsonMissing.of()
        private var pHash: JsonField<String> = JsonMissing.of()
        private var quality: JsonField<Long> = JsonMissing.of()
        private var size: JsonField<Long> = JsonMissing.of()
        private var videoCodec: JsonField<String> = JsonMissing.of()
        private var width: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(metadataRetrieveResponse: MetadataRetrieveResponse) = apply {
            audioCodec = metadataRetrieveResponse.audioCodec
            bitRate = metadataRetrieveResponse.bitRate
            density = metadataRetrieveResponse.density
            duration = metadataRetrieveResponse.duration
            exif = metadataRetrieveResponse.exif
            format = metadataRetrieveResponse.format
            hasColorProfile = metadataRetrieveResponse.hasColorProfile
            hasTransparency = metadataRetrieveResponse.hasTransparency
            height = metadataRetrieveResponse.height
            pHash = metadataRetrieveResponse.pHash
            quality = metadataRetrieveResponse.quality
            size = metadataRetrieveResponse.size
            videoCodec = metadataRetrieveResponse.videoCodec
            width = metadataRetrieveResponse.width
            additionalProperties = metadataRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** The audio codec used in the video (only for video). */
        fun audioCodec(audioCodec: String) = audioCodec(JsonField.of(audioCodec))

        /**
         * Sets [Builder.audioCodec] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audioCodec] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun audioCodec(audioCodec: JsonField<String>) = apply { this.audioCodec = audioCodec }

        /** The bit rate of the video in kbps (only for video). */
        fun bitRate(bitRate: Long) = bitRate(JsonField.of(bitRate))

        /**
         * Sets [Builder.bitRate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bitRate] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bitRate(bitRate: JsonField<Long>) = apply { this.bitRate = bitRate }

        /** The density of the image in DPI. */
        fun density(density: Long) = density(JsonField.of(density))

        /**
         * Sets [Builder.density] to an arbitrary JSON value.
         *
         * You should usually call [Builder.density] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun density(density: JsonField<Long>) = apply { this.density = density }

        /** The duration of the video in seconds (only for video). */
        fun duration(duration: Long) = duration(JsonField.of(duration))

        /**
         * Sets [Builder.duration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.duration] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun duration(duration: JsonField<Long>) = apply { this.duration = duration }

        fun exif(exif: Exif) = exif(JsonField.of(exif))

        /**
         * Sets [Builder.exif] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exif] with a well-typed [Exif] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun exif(exif: JsonField<Exif>) = apply { this.exif = exif }

        /** The format of the file (e.g., 'jpg', 'mp4'). */
        fun format(format: String) = format(JsonField.of(format))

        /**
         * Sets [Builder.format] to an arbitrary JSON value.
         *
         * You should usually call [Builder.format] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun format(format: JsonField<String>) = apply { this.format = format }

        /** Indicates if the image has a color profile. */
        fun hasColorProfile(hasColorProfile: Boolean) =
            hasColorProfile(JsonField.of(hasColorProfile))

        /**
         * Sets [Builder.hasColorProfile] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasColorProfile] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun hasColorProfile(hasColorProfile: JsonField<Boolean>) = apply {
            this.hasColorProfile = hasColorProfile
        }

        /** Indicates if the image contains transparent areas. */
        fun hasTransparency(hasTransparency: Boolean) =
            hasTransparency(JsonField.of(hasTransparency))

        /**
         * Sets [Builder.hasTransparency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasTransparency] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun hasTransparency(hasTransparency: JsonField<Boolean>) = apply {
            this.hasTransparency = hasTransparency
        }

        /** The height of the image or video in pixels. */
        fun height(height: Long) = height(JsonField.of(height))

        /**
         * Sets [Builder.height] to an arbitrary JSON value.
         *
         * You should usually call [Builder.height] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun height(height: JsonField<Long>) = apply { this.height = height }

        /** Perceptual hash of the image. */
        fun pHash(pHash: String) = pHash(JsonField.of(pHash))

        /**
         * Sets [Builder.pHash] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pHash] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun pHash(pHash: JsonField<String>) = apply { this.pHash = pHash }

        /** The quality indicator of the image. */
        fun quality(quality: Long) = quality(JsonField.of(quality))

        /**
         * Sets [Builder.quality] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quality] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quality(quality: JsonField<Long>) = apply { this.quality = quality }

        /** The file size in bytes. */
        fun size(size: Long) = size(JsonField.of(size))

        /**
         * Sets [Builder.size] to an arbitrary JSON value.
         *
         * You should usually call [Builder.size] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun size(size: JsonField<Long>) = apply { this.size = size }

        /** The video codec used in the video (only for video). */
        fun videoCodec(videoCodec: String) = videoCodec(JsonField.of(videoCodec))

        /**
         * Sets [Builder.videoCodec] to an arbitrary JSON value.
         *
         * You should usually call [Builder.videoCodec] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun videoCodec(videoCodec: JsonField<String>) = apply { this.videoCodec = videoCodec }

        /** The width of the image or video in pixels. */
        fun width(width: Long) = width(JsonField.of(width))

        /**
         * Sets [Builder.width] to an arbitrary JSON value.
         *
         * You should usually call [Builder.width] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun width(width: JsonField<Long>) = apply { this.width = width }

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
         * Returns an immutable instance of [MetadataRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MetadataRetrieveResponse =
            MetadataRetrieveResponse(
                audioCodec,
                bitRate,
                density,
                duration,
                exif,
                format,
                hasColorProfile,
                hasTransparency,
                height,
                pHash,
                quality,
                size,
                videoCodec,
                width,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MetadataRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        audioCodec()
        bitRate()
        density()
        duration()
        exif().ifPresent { it.validate() }
        format()
        hasColorProfile()
        hasTransparency()
        height()
        pHash()
        quality()
        size()
        videoCodec()
        width()
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
        (if (audioCodec.asKnown().isPresent) 1 else 0) +
            (if (bitRate.asKnown().isPresent) 1 else 0) +
            (if (density.asKnown().isPresent) 1 else 0) +
            (if (duration.asKnown().isPresent) 1 else 0) +
            (exif.asKnown().getOrNull()?.validity() ?: 0) +
            (if (format.asKnown().isPresent) 1 else 0) +
            (if (hasColorProfile.asKnown().isPresent) 1 else 0) +
            (if (hasTransparency.asKnown().isPresent) 1 else 0) +
            (if (height.asKnown().isPresent) 1 else 0) +
            (if (pHash.asKnown().isPresent) 1 else 0) +
            (if (quality.asKnown().isPresent) 1 else 0) +
            (if (size.asKnown().isPresent) 1 else 0) +
            (if (videoCodec.asKnown().isPresent) 1 else 0) +
            (if (width.asKnown().isPresent) 1 else 0)

    class Exif
    private constructor(
        private val exif: JsonField<ExifDetails>,
        private val gps: JsonField<Gps>,
        private val image: JsonField<ExifImage>,
        private val interoperability: JsonField<Interoperability>,
        private val makernote: JsonField<Makernote>,
        private val thumbnail: JsonField<Thumbnail>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("exif") @ExcludeMissing exif: JsonField<ExifDetails> = JsonMissing.of(),
            @JsonProperty("gps") @ExcludeMissing gps: JsonField<Gps> = JsonMissing.of(),
            @JsonProperty("image") @ExcludeMissing image: JsonField<ExifImage> = JsonMissing.of(),
            @JsonProperty("interoperability")
            @ExcludeMissing
            interoperability: JsonField<Interoperability> = JsonMissing.of(),
            @JsonProperty("makernote")
            @ExcludeMissing
            makernote: JsonField<Makernote> = JsonMissing.of(),
            @JsonProperty("thumbnail")
            @ExcludeMissing
            thumbnail: JsonField<Thumbnail> = JsonMissing.of(),
        ) : this(exif, gps, image, interoperability, makernote, thumbnail, mutableMapOf())

        /**
         * Object containing Exif details.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun exif(): Optional<ExifDetails> = exif.getOptional("exif")

        /**
         * Object containing GPS information.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun gps(): Optional<Gps> = gps.getOptional("gps")

        /**
         * Object containing EXIF image information.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun image(): Optional<ExifImage> = image.getOptional("image")

        /**
         * JSON object.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun interoperability(): Optional<Interoperability> =
            interoperability.getOptional("interoperability")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun makernote(): Optional<Makernote> = makernote.getOptional("makernote")

        /**
         * Object containing Thumbnail information.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun thumbnail(): Optional<Thumbnail> = thumbnail.getOptional("thumbnail")

        /**
         * Returns the raw JSON value of [exif].
         *
         * Unlike [exif], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("exif") @ExcludeMissing fun _exif(): JsonField<ExifDetails> = exif

        /**
         * Returns the raw JSON value of [gps].
         *
         * Unlike [gps], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("gps") @ExcludeMissing fun _gps(): JsonField<Gps> = gps

        /**
         * Returns the raw JSON value of [image].
         *
         * Unlike [image], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("image") @ExcludeMissing fun _image(): JsonField<ExifImage> = image

        /**
         * Returns the raw JSON value of [interoperability].
         *
         * Unlike [interoperability], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("interoperability")
        @ExcludeMissing
        fun _interoperability(): JsonField<Interoperability> = interoperability

        /**
         * Returns the raw JSON value of [makernote].
         *
         * Unlike [makernote], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("makernote")
        @ExcludeMissing
        fun _makernote(): JsonField<Makernote> = makernote

        /**
         * Returns the raw JSON value of [thumbnail].
         *
         * Unlike [thumbnail], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("thumbnail")
        @ExcludeMissing
        fun _thumbnail(): JsonField<Thumbnail> = thumbnail

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

            /** Returns a mutable builder for constructing an instance of [Exif]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Exif]. */
        class Builder internal constructor() {

            private var exif: JsonField<ExifDetails> = JsonMissing.of()
            private var gps: JsonField<Gps> = JsonMissing.of()
            private var image: JsonField<ExifImage> = JsonMissing.of()
            private var interoperability: JsonField<Interoperability> = JsonMissing.of()
            private var makernote: JsonField<Makernote> = JsonMissing.of()
            private var thumbnail: JsonField<Thumbnail> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(exif: Exif) = apply {
                this.exif = exif.exif
                gps = exif.gps
                image = exif.image
                interoperability = exif.interoperability
                makernote = exif.makernote
                thumbnail = exif.thumbnail
                additionalProperties = exif.additionalProperties.toMutableMap()
            }

            /** Object containing Exif details. */
            fun exif(exif: ExifDetails) = exif(JsonField.of(exif))

            /**
             * Sets [Builder.exif] to an arbitrary JSON value.
             *
             * You should usually call [Builder.exif] with a well-typed [ExifDetails] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun exif(exif: JsonField<ExifDetails>) = apply { this.exif = exif }

            /** Object containing GPS information. */
            fun gps(gps: Gps) = gps(JsonField.of(gps))

            /**
             * Sets [Builder.gps] to an arbitrary JSON value.
             *
             * You should usually call [Builder.gps] with a well-typed [Gps] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun gps(gps: JsonField<Gps>) = apply { this.gps = gps }

            /** Object containing EXIF image information. */
            fun image(image: ExifImage) = image(JsonField.of(image))

            /**
             * Sets [Builder.image] to an arbitrary JSON value.
             *
             * You should usually call [Builder.image] with a well-typed [ExifImage] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun image(image: JsonField<ExifImage>) = apply { this.image = image }

            /** JSON object. */
            fun interoperability(interoperability: Interoperability) =
                interoperability(JsonField.of(interoperability))

            /**
             * Sets [Builder.interoperability] to an arbitrary JSON value.
             *
             * You should usually call [Builder.interoperability] with a well-typed
             * [Interoperability] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun interoperability(interoperability: JsonField<Interoperability>) = apply {
                this.interoperability = interoperability
            }

            fun makernote(makernote: Makernote) = makernote(JsonField.of(makernote))

            /**
             * Sets [Builder.makernote] to an arbitrary JSON value.
             *
             * You should usually call [Builder.makernote] with a well-typed [Makernote] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun makernote(makernote: JsonField<Makernote>) = apply { this.makernote = makernote }

            /** Object containing Thumbnail information. */
            fun thumbnail(thumbnail: Thumbnail) = thumbnail(JsonField.of(thumbnail))

            /**
             * Sets [Builder.thumbnail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.thumbnail] with a well-typed [Thumbnail] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun thumbnail(thumbnail: JsonField<Thumbnail>) = apply { this.thumbnail = thumbnail }

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
             * Returns an immutable instance of [Exif].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Exif =
                Exif(
                    exif,
                    gps,
                    image,
                    interoperability,
                    makernote,
                    thumbnail,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Exif = apply {
            if (validated) {
                return@apply
            }

            exif().ifPresent { it.validate() }
            gps().ifPresent { it.validate() }
            image().ifPresent { it.validate() }
            interoperability().ifPresent { it.validate() }
            makernote().ifPresent { it.validate() }
            thumbnail().ifPresent { it.validate() }
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
        @JvmSynthetic
        internal fun validity(): Int =
            (exif.asKnown().getOrNull()?.validity() ?: 0) +
                (gps.asKnown().getOrNull()?.validity() ?: 0) +
                (image.asKnown().getOrNull()?.validity() ?: 0) +
                (interoperability.asKnown().getOrNull()?.validity() ?: 0) +
                (makernote.asKnown().getOrNull()?.validity() ?: 0) +
                (thumbnail.asKnown().getOrNull()?.validity() ?: 0)

        class Makernote
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Makernote]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Makernote]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(makernote: Makernote) = apply {
                    additionalProperties = makernote.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Makernote].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Makernote = Makernote(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Makernote = apply {
                if (validated) {
                    return@apply
                }

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
            @JvmSynthetic
            internal fun validity(): Int =
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Makernote && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Makernote{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Exif &&
                exif == other.exif &&
                gps == other.gps &&
                image == other.image &&
                interoperability == other.interoperability &&
                makernote == other.makernote &&
                thumbnail == other.thumbnail &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                exif,
                gps,
                image,
                interoperability,
                makernote,
                thumbnail,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Exif{exif=$exif, gps=$gps, image=$image, interoperability=$interoperability, makernote=$makernote, thumbnail=$thumbnail, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MetadataRetrieveResponse &&
            audioCodec == other.audioCodec &&
            bitRate == other.bitRate &&
            density == other.density &&
            duration == other.duration &&
            exif == other.exif &&
            format == other.format &&
            hasColorProfile == other.hasColorProfile &&
            hasTransparency == other.hasTransparency &&
            height == other.height &&
            pHash == other.pHash &&
            quality == other.quality &&
            size == other.size &&
            videoCodec == other.videoCodec &&
            width == other.width &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            audioCodec,
            bitRate,
            density,
            duration,
            exif,
            format,
            hasColorProfile,
            hasTransparency,
            height,
            pHash,
            quality,
            size,
            videoCodec,
            width,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MetadataRetrieveResponse{audioCodec=$audioCodec, bitRate=$bitRate, density=$density, duration=$duration, exif=$exif, format=$format, hasColorProfile=$hasColorProfile, hasTransparency=$hasTransparency, height=$height, pHash=$pHash, quality=$quality, size=$size, videoCodec=$videoCodec, width=$width, additionalProperties=$additionalProperties}"
}
