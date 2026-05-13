// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.usage

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class UsageGetResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val bandwidthBytes: JsonField<Long>,
    private val extensionUnitsCount: JsonField<Long>,
    private val mediaLibraryStorageBytes: JsonField<Long>,
    private val originalCacheStorageBytes: JsonField<Long>,
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
        @JsonProperty("mediaLibraryStorageBytes")
        @ExcludeMissing
        mediaLibraryStorageBytes: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("originalCacheStorageBytes")
        @ExcludeMissing
        originalCacheStorageBytes: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("videoProcessingUnitsCount")
        @ExcludeMissing
        videoProcessingUnitsCount: JsonField<Long> = JsonMissing.of(),
    ) : this(
        bandwidthBytes,
        extensionUnitsCount,
        mediaLibraryStorageBytes,
        originalCacheStorageBytes,
        videoProcessingUnitsCount,
        mutableMapOf(),
    )

    /**
     * Amount of bandwidth used in bytes.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bandwidthBytes(): Optional<Long> = bandwidthBytes.getOptional("bandwidthBytes")

    /**
     * Number of extension units used.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun extensionUnitsCount(): Optional<Long> =
        extensionUnitsCount.getOptional("extensionUnitsCount")

    /**
     * Storage used by media library in bytes.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mediaLibraryStorageBytes(): Optional<Long> =
        mediaLibraryStorageBytes.getOptional("mediaLibraryStorageBytes")

    /**
     * Storage used by the original cache in bytes.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun originalCacheStorageBytes(): Optional<Long> =
        originalCacheStorageBytes.getOptional("originalCacheStorageBytes")

    /**
     * Number of video processing units used.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun videoProcessingUnitsCount(): Optional<Long> =
        videoProcessingUnitsCount.getOptional("videoProcessingUnitsCount")

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
     * Returns the raw JSON value of [mediaLibraryStorageBytes].
     *
     * Unlike [mediaLibraryStorageBytes], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("mediaLibraryStorageBytes")
    @ExcludeMissing
    fun _mediaLibraryStorageBytes(): JsonField<Long> = mediaLibraryStorageBytes

    /**
     * Returns the raw JSON value of [originalCacheStorageBytes].
     *
     * Unlike [originalCacheStorageBytes], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("originalCacheStorageBytes")
    @ExcludeMissing
    fun _originalCacheStorageBytes(): JsonField<Long> = originalCacheStorageBytes

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

        /** Returns a mutable builder for constructing an instance of [UsageGetResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UsageGetResponse]. */
    class Builder internal constructor() {

        private var bandwidthBytes: JsonField<Long> = JsonMissing.of()
        private var extensionUnitsCount: JsonField<Long> = JsonMissing.of()
        private var mediaLibraryStorageBytes: JsonField<Long> = JsonMissing.of()
        private var originalCacheStorageBytes: JsonField<Long> = JsonMissing.of()
        private var videoProcessingUnitsCount: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(usageGetResponse: UsageGetResponse) = apply {
            bandwidthBytes = usageGetResponse.bandwidthBytes
            extensionUnitsCount = usageGetResponse.extensionUnitsCount
            mediaLibraryStorageBytes = usageGetResponse.mediaLibraryStorageBytes
            originalCacheStorageBytes = usageGetResponse.originalCacheStorageBytes
            videoProcessingUnitsCount = usageGetResponse.videoProcessingUnitsCount
            additionalProperties = usageGetResponse.additionalProperties.toMutableMap()
        }

        /** Amount of bandwidth used in bytes. */
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

        /** Number of extension units used. */
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

        /** Storage used by media library in bytes. */
        fun mediaLibraryStorageBytes(mediaLibraryStorageBytes: Long) =
            mediaLibraryStorageBytes(JsonField.of(mediaLibraryStorageBytes))

        /**
         * Sets [Builder.mediaLibraryStorageBytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaLibraryStorageBytes] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun mediaLibraryStorageBytes(mediaLibraryStorageBytes: JsonField<Long>) = apply {
            this.mediaLibraryStorageBytes = mediaLibraryStorageBytes
        }

        /** Storage used by the original cache in bytes. */
        fun originalCacheStorageBytes(originalCacheStorageBytes: Long) =
            originalCacheStorageBytes(JsonField.of(originalCacheStorageBytes))

        /**
         * Sets [Builder.originalCacheStorageBytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.originalCacheStorageBytes] with a well-typed [Long]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun originalCacheStorageBytes(originalCacheStorageBytes: JsonField<Long>) = apply {
            this.originalCacheStorageBytes = originalCacheStorageBytes
        }

        /** Number of video processing units used. */
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
         * Returns an immutable instance of [UsageGetResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UsageGetResponse =
            UsageGetResponse(
                bandwidthBytes,
                extensionUnitsCount,
                mediaLibraryStorageBytes,
                originalCacheStorageBytes,
                videoProcessingUnitsCount,
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
    fun validate(): UsageGetResponse = apply {
        if (validated) {
            return@apply
        }

        bandwidthBytes()
        extensionUnitsCount()
        mediaLibraryStorageBytes()
        originalCacheStorageBytes()
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
            (if (mediaLibraryStorageBytes.asKnown().isPresent) 1 else 0) +
            (if (originalCacheStorageBytes.asKnown().isPresent) 1 else 0) +
            (if (videoProcessingUnitsCount.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UsageGetResponse &&
            bandwidthBytes == other.bandwidthBytes &&
            extensionUnitsCount == other.extensionUnitsCount &&
            mediaLibraryStorageBytes == other.mediaLibraryStorageBytes &&
            originalCacheStorageBytes == other.originalCacheStorageBytes &&
            videoProcessingUnitsCount == other.videoProcessingUnitsCount &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            bandwidthBytes,
            extensionUnitsCount,
            mediaLibraryStorageBytes,
            originalCacheStorageBytes,
            videoProcessingUnitsCount,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UsageGetResponse{bandwidthBytes=$bandwidthBytes, extensionUnitsCount=$extensionUnitsCount, mediaLibraryStorageBytes=$mediaLibraryStorageBytes, originalCacheStorageBytes=$originalCacheStorageBytes, videoProcessingUnitsCount=$videoProcessingUnitsCount, additionalProperties=$additionalProperties}"
}
