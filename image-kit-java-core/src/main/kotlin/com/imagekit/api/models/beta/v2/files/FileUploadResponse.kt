// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.beta.v2.files

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.imagekit.api.core.Enum
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.checkKnown
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import com.imagekit.api.models.ExifDetails
import com.imagekit.api.models.ExifImage
import com.imagekit.api.models.Gps
import com.imagekit.api.models.Interoperability
import com.imagekit.api.models.Thumbnail
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Object containing details of a successful upload. */
class FileUploadResponse
private constructor(
    private val aiTags: JsonField<List<AiTag>>,
    private val audioCodec: JsonField<String>,
    private val bitRate: JsonField<Long>,
    private val customCoordinates: JsonField<String>,
    private val customMetadata: JsonValue,
    private val duration: JsonField<Long>,
    private val embeddedMetadata: JsonField<EmbeddedMetadata>,
    private val extensionStatus: JsonField<ExtensionStatus>,
    private val fileId: JsonField<String>,
    private val filePath: JsonField<String>,
    private val fileType: JsonField<String>,
    private val height: JsonField<Double>,
    private val isPrivateFile: JsonField<Boolean>,
    private val isPublished: JsonField<Boolean>,
    private val metadata: JsonField<Metadata>,
    private val name: JsonField<String>,
    private val size: JsonField<Double>,
    private val tags: JsonField<List<String>>,
    private val thumbnailUrl: JsonField<String>,
    private val url: JsonField<String>,
    private val versionInfo: JsonField<VersionInfo>,
    private val videoCodec: JsonField<String>,
    private val width: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("AITags") @ExcludeMissing aiTags: JsonField<List<AiTag>> = JsonMissing.of(),
        @JsonProperty("audioCodec")
        @ExcludeMissing
        audioCodec: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bitRate") @ExcludeMissing bitRate: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("customCoordinates")
        @ExcludeMissing
        customCoordinates: JsonField<String> = JsonMissing.of(),
        @JsonProperty("customMetadata")
        @ExcludeMissing
        customMetadata: JsonValue = JsonMissing.of(),
        @JsonProperty("duration") @ExcludeMissing duration: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("embeddedMetadata")
        @ExcludeMissing
        embeddedMetadata: JsonField<EmbeddedMetadata> = JsonMissing.of(),
        @JsonProperty("extensionStatus")
        @ExcludeMissing
        extensionStatus: JsonField<ExtensionStatus> = JsonMissing.of(),
        @JsonProperty("fileId") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("filePath") @ExcludeMissing filePath: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fileType") @ExcludeMissing fileType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("height") @ExcludeMissing height: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("isPrivateFile")
        @ExcludeMissing
        isPrivateFile: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isPublished")
        @ExcludeMissing
        isPublished: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("size") @ExcludeMissing size: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tags") @ExcludeMissing tags: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("thumbnailUrl")
        @ExcludeMissing
        thumbnailUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("versionInfo")
        @ExcludeMissing
        versionInfo: JsonField<VersionInfo> = JsonMissing.of(),
        @JsonProperty("videoCodec")
        @ExcludeMissing
        videoCodec: JsonField<String> = JsonMissing.of(),
        @JsonProperty("width") @ExcludeMissing width: JsonField<Double> = JsonMissing.of(),
    ) : this(
        aiTags,
        audioCodec,
        bitRate,
        customCoordinates,
        customMetadata,
        duration,
        embeddedMetadata,
        extensionStatus,
        fileId,
        filePath,
        fileType,
        height,
        isPrivateFile,
        isPublished,
        metadata,
        name,
        size,
        tags,
        thumbnailUrl,
        url,
        versionInfo,
        videoCodec,
        width,
        mutableMapOf(),
    )

    /**
     * An array of tags assigned to the uploaded file by auto tagging.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aiTags(): Optional<List<AiTag>> = aiTags.getOptional("AITags")

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
     * Value of custom coordinates associated with the image in the format `x,y,width,height`. If
     * `customCoordinates` are not defined, then it is `null`. Send `customCoordinates` in
     * `responseFields` in API request to get the value of this field.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customCoordinates(): Optional<String> = customCoordinates.getOptional("customCoordinates")

    /**
     * A key-value data associated with the asset. Use `responseField` in API request to get
     * `customMetadata` in the upload API response. Before setting any custom metadata on an asset,
     * you have to create the field using custom metadata fields API. Send `customMetadata` in
     * `responseFields` in API request to get the value of this field.
     */
    @JsonProperty("customMetadata")
    @ExcludeMissing
    fun _customMetadata(): JsonValue = customMetadata

    /**
     * The duration of the video in seconds (only for video).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun duration(): Optional<Long> = duration.getOptional("duration")

    /**
     * Consolidated embedded metadata associated with the file. It includes exif, iptc, and xmp
     * data. Send `embeddedMetadata` in `responseFields` in API request to get embeddedMetadata in
     * the upload API response.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun embeddedMetadata(): Optional<EmbeddedMetadata> =
        embeddedMetadata.getOptional("embeddedMetadata")

    /**
     * Extension names with their processing status at the time of completion of the request. It
     * could have one of the following status values:
     *
     * `success`: The extension has been successfully applied. `failed`: The extension has failed
     * and will not be retried. `pending`: The extension will finish processing in some time. On
     * completion, the final status (success / failed) will be sent to the `webhookUrl` provided.
     *
     * If no extension was requested, then this parameter is not returned.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun extensionStatus(): Optional<ExtensionStatus> =
        extensionStatus.getOptional("extensionStatus")

    /**
     * Unique fileId. Store this fileld in your database, as this will be used to perform update
     * action on this file.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileId(): Optional<String> = fileId.getOptional("fileId")

    /**
     * The relative path of the file in the media library e.g. `/marketing-assets/new-banner.jpg`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun filePath(): Optional<String> = filePath.getOptional("filePath")

    /**
     * Type of the uploaded file. Possible values are `image`, `non-image`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileType(): Optional<String> = fileType.getOptional("fileType")

    /**
     * Height of the image in pixels (Only for images)
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun height(): Optional<Double> = height.getOptional("height")

    /**
     * Is the file marked as private. It can be either `true` or `false`. Send `isPrivateFile` in
     * `responseFields` in API request to get the value of this field.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isPrivateFile(): Optional<Boolean> = isPrivateFile.getOptional("isPrivateFile")

    /**
     * Is the file published or in draft state. It can be either `true` or `false`. Send
     * `isPublished` in `responseFields` in API request to get the value of this field.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isPublished(): Optional<Boolean> = isPublished.getOptional("isPublished")

    /**
     * Legacy metadata. Send `metadata` in `responseFields` in API request to get metadata in the
     * upload API response.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

    /**
     * Name of the asset.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Size of the image file in Bytes.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun size(): Optional<Double> = size.getOptional("size")

    /**
     * The array of tags associated with the asset. If no tags are set, it will be `null`. Send
     * `tags` in `responseFields` in API request to get the value of this field.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tags(): Optional<List<String>> = tags.getOptional("tags")

    /**
     * In the case of an image, a small thumbnail URL.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun thumbnailUrl(): Optional<String> = thumbnailUrl.getOptional("thumbnailUrl")

    /**
     * A publicly accessible URL of the file.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun url(): Optional<String> = url.getOptional("url")

    /**
     * An object containing the file or file version's `id` (versionId) and `name`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun versionInfo(): Optional<VersionInfo> = versionInfo.getOptional("versionInfo")

    /**
     * The video codec used in the video (only for video).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun videoCodec(): Optional<String> = videoCodec.getOptional("videoCodec")

    /**
     * Width of the image in pixels (Only for Images)
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun width(): Optional<Double> = width.getOptional("width")

    /**
     * Returns the raw JSON value of [aiTags].
     *
     * Unlike [aiTags], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("AITags") @ExcludeMissing fun _aiTags(): JsonField<List<AiTag>> = aiTags

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
     * Returns the raw JSON value of [customCoordinates].
     *
     * Unlike [customCoordinates], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("customCoordinates")
    @ExcludeMissing
    fun _customCoordinates(): JsonField<String> = customCoordinates

    /**
     * Returns the raw JSON value of [duration].
     *
     * Unlike [duration], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("duration") @ExcludeMissing fun _duration(): JsonField<Long> = duration

    /**
     * Returns the raw JSON value of [embeddedMetadata].
     *
     * Unlike [embeddedMetadata], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("embeddedMetadata")
    @ExcludeMissing
    fun _embeddedMetadata(): JsonField<EmbeddedMetadata> = embeddedMetadata

    /**
     * Returns the raw JSON value of [extensionStatus].
     *
     * Unlike [extensionStatus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("extensionStatus")
    @ExcludeMissing
    fun _extensionStatus(): JsonField<ExtensionStatus> = extensionStatus

    /**
     * Returns the raw JSON value of [fileId].
     *
     * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fileId") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

    /**
     * Returns the raw JSON value of [filePath].
     *
     * Unlike [filePath], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filePath") @ExcludeMissing fun _filePath(): JsonField<String> = filePath

    /**
     * Returns the raw JSON value of [fileType].
     *
     * Unlike [fileType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fileType") @ExcludeMissing fun _fileType(): JsonField<String> = fileType

    /**
     * Returns the raw JSON value of [height].
     *
     * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Double> = height

    /**
     * Returns the raw JSON value of [isPrivateFile].
     *
     * Unlike [isPrivateFile], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isPrivateFile")
    @ExcludeMissing
    fun _isPrivateFile(): JsonField<Boolean> = isPrivateFile

    /**
     * Returns the raw JSON value of [isPublished].
     *
     * Unlike [isPublished], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isPublished")
    @ExcludeMissing
    fun _isPublished(): JsonField<Boolean> = isPublished

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [size].
     *
     * Unlike [size], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<Double> = size

    /**
     * Returns the raw JSON value of [tags].
     *
     * Unlike [tags], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tags") @ExcludeMissing fun _tags(): JsonField<List<String>> = tags

    /**
     * Returns the raw JSON value of [thumbnailUrl].
     *
     * Unlike [thumbnailUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("thumbnailUrl")
    @ExcludeMissing
    fun _thumbnailUrl(): JsonField<String> = thumbnailUrl

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

    /**
     * Returns the raw JSON value of [versionInfo].
     *
     * Unlike [versionInfo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("versionInfo")
    @ExcludeMissing
    fun _versionInfo(): JsonField<VersionInfo> = versionInfo

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
    @JsonProperty("width") @ExcludeMissing fun _width(): JsonField<Double> = width

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

        /** Returns a mutable builder for constructing an instance of [FileUploadResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileUploadResponse]. */
    class Builder internal constructor() {

        private var aiTags: JsonField<MutableList<AiTag>>? = null
        private var audioCodec: JsonField<String> = JsonMissing.of()
        private var bitRate: JsonField<Long> = JsonMissing.of()
        private var customCoordinates: JsonField<String> = JsonMissing.of()
        private var customMetadata: JsonValue = JsonMissing.of()
        private var duration: JsonField<Long> = JsonMissing.of()
        private var embeddedMetadata: JsonField<EmbeddedMetadata> = JsonMissing.of()
        private var extensionStatus: JsonField<ExtensionStatus> = JsonMissing.of()
        private var fileId: JsonField<String> = JsonMissing.of()
        private var filePath: JsonField<String> = JsonMissing.of()
        private var fileType: JsonField<String> = JsonMissing.of()
        private var height: JsonField<Double> = JsonMissing.of()
        private var isPrivateFile: JsonField<Boolean> = JsonMissing.of()
        private var isPublished: JsonField<Boolean> = JsonMissing.of()
        private var metadata: JsonField<Metadata> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var size: JsonField<Double> = JsonMissing.of()
        private var tags: JsonField<MutableList<String>>? = null
        private var thumbnailUrl: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var versionInfo: JsonField<VersionInfo> = JsonMissing.of()
        private var videoCodec: JsonField<String> = JsonMissing.of()
        private var width: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileUploadResponse: FileUploadResponse) = apply {
            aiTags = fileUploadResponse.aiTags.map { it.toMutableList() }
            audioCodec = fileUploadResponse.audioCodec
            bitRate = fileUploadResponse.bitRate
            customCoordinates = fileUploadResponse.customCoordinates
            customMetadata = fileUploadResponse.customMetadata
            duration = fileUploadResponse.duration
            embeddedMetadata = fileUploadResponse.embeddedMetadata
            extensionStatus = fileUploadResponse.extensionStatus
            fileId = fileUploadResponse.fileId
            filePath = fileUploadResponse.filePath
            fileType = fileUploadResponse.fileType
            height = fileUploadResponse.height
            isPrivateFile = fileUploadResponse.isPrivateFile
            isPublished = fileUploadResponse.isPublished
            metadata = fileUploadResponse.metadata
            name = fileUploadResponse.name
            size = fileUploadResponse.size
            tags = fileUploadResponse.tags.map { it.toMutableList() }
            thumbnailUrl = fileUploadResponse.thumbnailUrl
            url = fileUploadResponse.url
            versionInfo = fileUploadResponse.versionInfo
            videoCodec = fileUploadResponse.videoCodec
            width = fileUploadResponse.width
            additionalProperties = fileUploadResponse.additionalProperties.toMutableMap()
        }

        /** An array of tags assigned to the uploaded file by auto tagging. */
        fun aiTags(aiTags: List<AiTag>?) = aiTags(JsonField.ofNullable(aiTags))

        /** Alias for calling [Builder.aiTags] with `aiTags.orElse(null)`. */
        fun aiTags(aiTags: Optional<List<AiTag>>) = aiTags(aiTags.getOrNull())

        /**
         * Sets [Builder.aiTags] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aiTags] with a well-typed `List<AiTag>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun aiTags(aiTags: JsonField<List<AiTag>>) = apply {
            this.aiTags = aiTags.map { it.toMutableList() }
        }

        /**
         * Adds a single [AiTag] to [aiTags].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAiTag(aiTag: AiTag) = apply {
            aiTags =
                (aiTags ?: JsonField.of(mutableListOf())).also {
                    checkKnown("aiTags", it).add(aiTag)
                }
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

        /**
         * Value of custom coordinates associated with the image in the format `x,y,width,height`.
         * If `customCoordinates` are not defined, then it is `null`. Send `customCoordinates` in
         * `responseFields` in API request to get the value of this field.
         */
        fun customCoordinates(customCoordinates: String?) =
            customCoordinates(JsonField.ofNullable(customCoordinates))

        /** Alias for calling [Builder.customCoordinates] with `customCoordinates.orElse(null)`. */
        fun customCoordinates(customCoordinates: Optional<String>) =
            customCoordinates(customCoordinates.getOrNull())

        /**
         * Sets [Builder.customCoordinates] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customCoordinates] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun customCoordinates(customCoordinates: JsonField<String>) = apply {
            this.customCoordinates = customCoordinates
        }

        /**
         * A key-value data associated with the asset. Use `responseField` in API request to get
         * `customMetadata` in the upload API response. Before setting any custom metadata on an
         * asset, you have to create the field using custom metadata fields API. Send
         * `customMetadata` in `responseFields` in API request to get the value of this field.
         */
        fun customMetadata(customMetadata: JsonValue) = apply {
            this.customMetadata = customMetadata
        }

        /** The duration of the video in seconds (only for video). */
        fun duration(duration: Long) = duration(JsonField.of(duration))

        /**
         * Sets [Builder.duration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.duration] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun duration(duration: JsonField<Long>) = apply { this.duration = duration }

        /**
         * Consolidated embedded metadata associated with the file. It includes exif, iptc, and xmp
         * data. Send `embeddedMetadata` in `responseFields` in API request to get embeddedMetadata
         * in the upload API response.
         */
        fun embeddedMetadata(embeddedMetadata: EmbeddedMetadata) =
            embeddedMetadata(JsonField.of(embeddedMetadata))

        /**
         * Sets [Builder.embeddedMetadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.embeddedMetadata] with a well-typed [EmbeddedMetadata]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun embeddedMetadata(embeddedMetadata: JsonField<EmbeddedMetadata>) = apply {
            this.embeddedMetadata = embeddedMetadata
        }

        /**
         * Extension names with their processing status at the time of completion of the request. It
         * could have one of the following status values:
         *
         * `success`: The extension has been successfully applied. `failed`: The extension has
         * failed and will not be retried. `pending`: The extension will finish processing in some
         * time. On completion, the final status (success / failed) will be sent to the `webhookUrl`
         * provided.
         *
         * If no extension was requested, then this parameter is not returned.
         */
        fun extensionStatus(extensionStatus: ExtensionStatus) =
            extensionStatus(JsonField.of(extensionStatus))

        /**
         * Sets [Builder.extensionStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.extensionStatus] with a well-typed [ExtensionStatus]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun extensionStatus(extensionStatus: JsonField<ExtensionStatus>) = apply {
            this.extensionStatus = extensionStatus
        }

        /**
         * Unique fileId. Store this fileld in your database, as this will be used to perform update
         * action on this file.
         */
        fun fileId(fileId: String) = fileId(JsonField.of(fileId))

        /**
         * Sets [Builder.fileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

        /**
         * The relative path of the file in the media library e.g.
         * `/marketing-assets/new-banner.jpg`.
         */
        fun filePath(filePath: String) = filePath(JsonField.of(filePath))

        /**
         * Sets [Builder.filePath] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filePath] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filePath(filePath: JsonField<String>) = apply { this.filePath = filePath }

        /** Type of the uploaded file. Possible values are `image`, `non-image`. */
        fun fileType(fileType: String) = fileType(JsonField.of(fileType))

        /**
         * Sets [Builder.fileType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileType] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileType(fileType: JsonField<String>) = apply { this.fileType = fileType }

        /** Height of the image in pixels (Only for images) */
        fun height(height: Double) = height(JsonField.of(height))

        /**
         * Sets [Builder.height] to an arbitrary JSON value.
         *
         * You should usually call [Builder.height] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun height(height: JsonField<Double>) = apply { this.height = height }

        /**
         * Is the file marked as private. It can be either `true` or `false`. Send `isPrivateFile`
         * in `responseFields` in API request to get the value of this field.
         */
        fun isPrivateFile(isPrivateFile: Boolean) = isPrivateFile(JsonField.of(isPrivateFile))

        /**
         * Sets [Builder.isPrivateFile] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isPrivateFile] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isPrivateFile(isPrivateFile: JsonField<Boolean>) = apply {
            this.isPrivateFile = isPrivateFile
        }

        /**
         * Is the file published or in draft state. It can be either `true` or `false`. Send
         * `isPublished` in `responseFields` in API request to get the value of this field.
         */
        fun isPublished(isPublished: Boolean) = isPublished(JsonField.of(isPublished))

        /**
         * Sets [Builder.isPublished] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isPublished] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isPublished(isPublished: JsonField<Boolean>) = apply { this.isPublished = isPublished }

        /**
         * Legacy metadata. Send `metadata` in `responseFields` in API request to get metadata in
         * the upload API response.
         */
        fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /** Name of the asset. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Size of the image file in Bytes. */
        fun size(size: Double) = size(JsonField.of(size))

        /**
         * Sets [Builder.size] to an arbitrary JSON value.
         *
         * You should usually call [Builder.size] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun size(size: JsonField<Double>) = apply { this.size = size }

        /**
         * The array of tags associated with the asset. If no tags are set, it will be `null`. Send
         * `tags` in `responseFields` in API request to get the value of this field.
         */
        fun tags(tags: List<String>?) = tags(JsonField.ofNullable(tags))

        /** Alias for calling [Builder.tags] with `tags.orElse(null)`. */
        fun tags(tags: Optional<List<String>>) = tags(tags.getOrNull())

        /**
         * Sets [Builder.tags] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tags] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tags(tags: JsonField<List<String>>) = apply {
            this.tags = tags.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [tags].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTag(tag: String) = apply {
            tags = (tags ?: JsonField.of(mutableListOf())).also { checkKnown("tags", it).add(tag) }
        }

        /** In the case of an image, a small thumbnail URL. */
        fun thumbnailUrl(thumbnailUrl: String) = thumbnailUrl(JsonField.of(thumbnailUrl))

        /**
         * Sets [Builder.thumbnailUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.thumbnailUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun thumbnailUrl(thumbnailUrl: JsonField<String>) = apply {
            this.thumbnailUrl = thumbnailUrl
        }

        /** A publicly accessible URL of the file. */
        fun url(url: String) = url(JsonField.of(url))

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

        /** An object containing the file or file version's `id` (versionId) and `name`. */
        fun versionInfo(versionInfo: VersionInfo) = versionInfo(JsonField.of(versionInfo))

        /**
         * Sets [Builder.versionInfo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.versionInfo] with a well-typed [VersionInfo] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun versionInfo(versionInfo: JsonField<VersionInfo>) = apply {
            this.versionInfo = versionInfo
        }

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

        /** Width of the image in pixels (Only for Images) */
        fun width(width: Double) = width(JsonField.of(width))

        /**
         * Sets [Builder.width] to an arbitrary JSON value.
         *
         * You should usually call [Builder.width] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun width(width: JsonField<Double>) = apply { this.width = width }

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
         * Returns an immutable instance of [FileUploadResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FileUploadResponse =
            FileUploadResponse(
                (aiTags ?: JsonMissing.of()).map { it.toImmutable() },
                audioCodec,
                bitRate,
                customCoordinates,
                customMetadata,
                duration,
                embeddedMetadata,
                extensionStatus,
                fileId,
                filePath,
                fileType,
                height,
                isPrivateFile,
                isPublished,
                metadata,
                name,
                size,
                (tags ?: JsonMissing.of()).map { it.toImmutable() },
                thumbnailUrl,
                url,
                versionInfo,
                videoCodec,
                width,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FileUploadResponse = apply {
        if (validated) {
            return@apply
        }

        aiTags().ifPresent { it.forEach { it.validate() } }
        audioCodec()
        bitRate()
        customCoordinates()
        duration()
        embeddedMetadata().ifPresent { it.validate() }
        extensionStatus().ifPresent { it.validate() }
        fileId()
        filePath()
        fileType()
        height()
        isPrivateFile()
        isPublished()
        metadata().ifPresent { it.validate() }
        name()
        size()
        tags()
        thumbnailUrl()
        url()
        versionInfo().ifPresent { it.validate() }
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
        (aiTags.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (audioCodec.asKnown().isPresent) 1 else 0) +
            (if (bitRate.asKnown().isPresent) 1 else 0) +
            (if (customCoordinates.asKnown().isPresent) 1 else 0) +
            (if (duration.asKnown().isPresent) 1 else 0) +
            (embeddedMetadata.asKnown().getOrNull()?.validity() ?: 0) +
            (extensionStatus.asKnown().getOrNull()?.validity() ?: 0) +
            (if (fileId.asKnown().isPresent) 1 else 0) +
            (if (filePath.asKnown().isPresent) 1 else 0) +
            (if (fileType.asKnown().isPresent) 1 else 0) +
            (if (height.asKnown().isPresent) 1 else 0) +
            (if (isPrivateFile.asKnown().isPresent) 1 else 0) +
            (if (isPublished.asKnown().isPresent) 1 else 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (size.asKnown().isPresent) 1 else 0) +
            (tags.asKnown().getOrNull()?.size ?: 0) +
            (if (thumbnailUrl.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (versionInfo.asKnown().getOrNull()?.validity() ?: 0) +
            (if (videoCodec.asKnown().isPresent) 1 else 0) +
            (if (width.asKnown().isPresent) 1 else 0)

    class AiTag
    private constructor(
        private val confidence: JsonField<Double>,
        private val name: JsonField<String>,
        private val source: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("confidence")
            @ExcludeMissing
            confidence: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
        ) : this(confidence, name, source, mutableMapOf())

        /**
         * Confidence score of the tag.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun confidence(): Optional<Double> = confidence.getOptional("confidence")

        /**
         * Name of the tag.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Array of `AITags` associated with the image. If no `AITags` are set, it will be null.
         * These tags can be added using the `google-auto-tagging` or `aws-auto-tagging` extensions.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun source(): Optional<String> = source.getOptional("source")

        /**
         * Returns the raw JSON value of [confidence].
         *
         * Unlike [confidence], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("confidence")
        @ExcludeMissing
        fun _confidence(): JsonField<Double> = confidence

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [source].
         *
         * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

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

            /** Returns a mutable builder for constructing an instance of [AiTag]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AiTag]. */
        class Builder internal constructor() {

            private var confidence: JsonField<Double> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var source: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(aiTag: AiTag) = apply {
                confidence = aiTag.confidence
                name = aiTag.name
                source = aiTag.source
                additionalProperties = aiTag.additionalProperties.toMutableMap()
            }

            /** Confidence score of the tag. */
            fun confidence(confidence: Double) = confidence(JsonField.of(confidence))

            /**
             * Sets [Builder.confidence] to an arbitrary JSON value.
             *
             * You should usually call [Builder.confidence] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun confidence(confidence: JsonField<Double>) = apply { this.confidence = confidence }

            /** Name of the tag. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * Array of `AITags` associated with the image. If no `AITags` are set, it will be null.
             * These tags can be added using the `google-auto-tagging` or `aws-auto-tagging`
             * extensions.
             */
            fun source(source: String) = source(JsonField.of(source))

            /**
             * Sets [Builder.source] to an arbitrary JSON value.
             *
             * You should usually call [Builder.source] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun source(source: JsonField<String>) = apply { this.source = source }

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
             * Returns an immutable instance of [AiTag].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): AiTag =
                AiTag(confidence, name, source, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): AiTag = apply {
            if (validated) {
                return@apply
            }

            confidence()
            name()
            source()
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
            (if (confidence.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (source.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AiTag &&
                confidence == other.confidence &&
                name == other.name &&
                source == other.source &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(confidence, name, source, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AiTag{confidence=$confidence, name=$name, source=$source, additionalProperties=$additionalProperties}"
    }

    /**
     * Consolidated embedded metadata associated with the file. It includes exif, iptc, and xmp
     * data. Send `embeddedMetadata` in `responseFields` in API request to get embeddedMetadata in
     * the upload API response.
     */
    class EmbeddedMetadata
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

            /** Returns a mutable builder for constructing an instance of [EmbeddedMetadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [EmbeddedMetadata]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(embeddedMetadata: EmbeddedMetadata) = apply {
                additionalProperties = embeddedMetadata.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [EmbeddedMetadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): EmbeddedMetadata = EmbeddedMetadata(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): EmbeddedMetadata = apply {
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

            return other is EmbeddedMetadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "EmbeddedMetadata{additionalProperties=$additionalProperties}"
    }

    /**
     * Extension names with their processing status at the time of completion of the request. It
     * could have one of the following status values:
     *
     * `success`: The extension has been successfully applied. `failed`: The extension has failed
     * and will not be retried. `pending`: The extension will finish processing in some time. On
     * completion, the final status (success / failed) will be sent to the `webhookUrl` provided.
     *
     * If no extension was requested, then this parameter is not returned.
     */
    class ExtensionStatus
    private constructor(
        private val awsAutoTagging: JsonField<AwsAutoTagging>,
        private val googleAutoTagging: JsonField<GoogleAutoTagging>,
        private val removeBg: JsonField<RemoveBg>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("aws-auto-tagging")
            @ExcludeMissing
            awsAutoTagging: JsonField<AwsAutoTagging> = JsonMissing.of(),
            @JsonProperty("google-auto-tagging")
            @ExcludeMissing
            googleAutoTagging: JsonField<GoogleAutoTagging> = JsonMissing.of(),
            @JsonProperty("remove-bg")
            @ExcludeMissing
            removeBg: JsonField<RemoveBg> = JsonMissing.of(),
        ) : this(awsAutoTagging, googleAutoTagging, removeBg, mutableMapOf())

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun awsAutoTagging(): Optional<AwsAutoTagging> =
            awsAutoTagging.getOptional("aws-auto-tagging")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun googleAutoTagging(): Optional<GoogleAutoTagging> =
            googleAutoTagging.getOptional("google-auto-tagging")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun removeBg(): Optional<RemoveBg> = removeBg.getOptional("remove-bg")

        /**
         * Returns the raw JSON value of [awsAutoTagging].
         *
         * Unlike [awsAutoTagging], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("aws-auto-tagging")
        @ExcludeMissing
        fun _awsAutoTagging(): JsonField<AwsAutoTagging> = awsAutoTagging

        /**
         * Returns the raw JSON value of [googleAutoTagging].
         *
         * Unlike [googleAutoTagging], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("google-auto-tagging")
        @ExcludeMissing
        fun _googleAutoTagging(): JsonField<GoogleAutoTagging> = googleAutoTagging

        /**
         * Returns the raw JSON value of [removeBg].
         *
         * Unlike [removeBg], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("remove-bg") @ExcludeMissing fun _removeBg(): JsonField<RemoveBg> = removeBg

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

            /** Returns a mutable builder for constructing an instance of [ExtensionStatus]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ExtensionStatus]. */
        class Builder internal constructor() {

            private var awsAutoTagging: JsonField<AwsAutoTagging> = JsonMissing.of()
            private var googleAutoTagging: JsonField<GoogleAutoTagging> = JsonMissing.of()
            private var removeBg: JsonField<RemoveBg> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(extensionStatus: ExtensionStatus) = apply {
                awsAutoTagging = extensionStatus.awsAutoTagging
                googleAutoTagging = extensionStatus.googleAutoTagging
                removeBg = extensionStatus.removeBg
                additionalProperties = extensionStatus.additionalProperties.toMutableMap()
            }

            fun awsAutoTagging(awsAutoTagging: AwsAutoTagging) =
                awsAutoTagging(JsonField.of(awsAutoTagging))

            /**
             * Sets [Builder.awsAutoTagging] to an arbitrary JSON value.
             *
             * You should usually call [Builder.awsAutoTagging] with a well-typed [AwsAutoTagging]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun awsAutoTagging(awsAutoTagging: JsonField<AwsAutoTagging>) = apply {
                this.awsAutoTagging = awsAutoTagging
            }

            fun googleAutoTagging(googleAutoTagging: GoogleAutoTagging) =
                googleAutoTagging(JsonField.of(googleAutoTagging))

            /**
             * Sets [Builder.googleAutoTagging] to an arbitrary JSON value.
             *
             * You should usually call [Builder.googleAutoTagging] with a well-typed
             * [GoogleAutoTagging] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun googleAutoTagging(googleAutoTagging: JsonField<GoogleAutoTagging>) = apply {
                this.googleAutoTagging = googleAutoTagging
            }

            fun removeBg(removeBg: RemoveBg) = removeBg(JsonField.of(removeBg))

            /**
             * Sets [Builder.removeBg] to an arbitrary JSON value.
             *
             * You should usually call [Builder.removeBg] with a well-typed [RemoveBg] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun removeBg(removeBg: JsonField<RemoveBg>) = apply { this.removeBg = removeBg }

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
             * Returns an immutable instance of [ExtensionStatus].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ExtensionStatus =
                ExtensionStatus(
                    awsAutoTagging,
                    googleAutoTagging,
                    removeBg,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): ExtensionStatus = apply {
            if (validated) {
                return@apply
            }

            awsAutoTagging().ifPresent { it.validate() }
            googleAutoTagging().ifPresent { it.validate() }
            removeBg().ifPresent { it.validate() }
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
            (awsAutoTagging.asKnown().getOrNull()?.validity() ?: 0) +
                (googleAutoTagging.asKnown().getOrNull()?.validity() ?: 0) +
                (removeBg.asKnown().getOrNull()?.validity() ?: 0)

        class AwsAutoTagging
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SUCCESS = of("success")

                @JvmField val PENDING = of("pending")

                @JvmField val FAILED = of("failed")

                @JvmStatic fun of(value: String) = AwsAutoTagging(JsonField.of(value))
            }

            /** An enum containing [AwsAutoTagging]'s known values. */
            enum class Known {
                SUCCESS,
                PENDING,
                FAILED,
            }

            /**
             * An enum containing [AwsAutoTagging]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [AwsAutoTagging] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SUCCESS,
                PENDING,
                FAILED,
                /**
                 * An enum member indicating that [AwsAutoTagging] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    SUCCESS -> Value.SUCCESS
                    PENDING -> Value.PENDING
                    FAILED -> Value.FAILED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws ImageKitInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    SUCCESS -> Known.SUCCESS
                    PENDING -> Known.PENDING
                    FAILED -> Known.FAILED
                    else -> throw ImageKitInvalidDataException("Unknown AwsAutoTagging: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws ImageKitInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    ImageKitInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): AwsAutoTagging = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is AwsAutoTagging && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class GoogleAutoTagging
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SUCCESS = of("success")

                @JvmField val PENDING = of("pending")

                @JvmField val FAILED = of("failed")

                @JvmStatic fun of(value: String) = GoogleAutoTagging(JsonField.of(value))
            }

            /** An enum containing [GoogleAutoTagging]'s known values. */
            enum class Known {
                SUCCESS,
                PENDING,
                FAILED,
            }

            /**
             * An enum containing [GoogleAutoTagging]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [GoogleAutoTagging] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SUCCESS,
                PENDING,
                FAILED,
                /**
                 * An enum member indicating that [GoogleAutoTagging] was instantiated with an
                 * unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    SUCCESS -> Value.SUCCESS
                    PENDING -> Value.PENDING
                    FAILED -> Value.FAILED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws ImageKitInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    SUCCESS -> Known.SUCCESS
                    PENDING -> Known.PENDING
                    FAILED -> Known.FAILED
                    else -> throw ImageKitInvalidDataException("Unknown GoogleAutoTagging: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws ImageKitInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    ImageKitInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): GoogleAutoTagging = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is GoogleAutoTagging && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class RemoveBg @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SUCCESS = of("success")

                @JvmField val PENDING = of("pending")

                @JvmField val FAILED = of("failed")

                @JvmStatic fun of(value: String) = RemoveBg(JsonField.of(value))
            }

            /** An enum containing [RemoveBg]'s known values. */
            enum class Known {
                SUCCESS,
                PENDING,
                FAILED,
            }

            /**
             * An enum containing [RemoveBg]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [RemoveBg] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SUCCESS,
                PENDING,
                FAILED,
                /**
                 * An enum member indicating that [RemoveBg] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    SUCCESS -> Value.SUCCESS
                    PENDING -> Value.PENDING
                    FAILED -> Value.FAILED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws ImageKitInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    SUCCESS -> Known.SUCCESS
                    PENDING -> Known.PENDING
                    FAILED -> Known.FAILED
                    else -> throw ImageKitInvalidDataException("Unknown RemoveBg: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws ImageKitInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    ImageKitInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): RemoveBg = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RemoveBg && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ExtensionStatus &&
                awsAutoTagging == other.awsAutoTagging &&
                googleAutoTagging == other.googleAutoTagging &&
                removeBg == other.removeBg &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(awsAutoTagging, googleAutoTagging, removeBg, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExtensionStatus{awsAutoTagging=$awsAutoTagging, googleAutoTagging=$googleAutoTagging, removeBg=$removeBg, additionalProperties=$additionalProperties}"
    }

    /**
     * Legacy metadata. Send `metadata` in `responseFields` in API request to get metadata in the
     * upload API response.
     */
    class Metadata
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
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun audioCodec(): Optional<String> = audioCodec.getOptional("audioCodec")

        /**
         * The bit rate of the video in kbps (only for video).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun bitRate(): Optional<Long> = bitRate.getOptional("bitRate")

        /**
         * The density of the image in DPI.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun density(): Optional<Long> = density.getOptional("density")

        /**
         * The duration of the video in seconds (only for video).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun duration(): Optional<Long> = duration.getOptional("duration")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun exif(): Optional<Exif> = exif.getOptional("exif")

        /**
         * The format of the file (e.g., 'jpg', 'mp4').
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun format(): Optional<String> = format.getOptional("format")

        /**
         * Indicates if the image has a color profile.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun hasColorProfile(): Optional<Boolean> = hasColorProfile.getOptional("hasColorProfile")

        /**
         * Indicates if the image contains transparent areas.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun hasTransparency(): Optional<Boolean> = hasTransparency.getOptional("hasTransparency")

        /**
         * The height of the image or video in pixels.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun height(): Optional<Long> = height.getOptional("height")

        /**
         * Perceptual hash of the image.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun pHash(): Optional<String> = pHash.getOptional("pHash")

        /**
         * The quality indicator of the image.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun quality(): Optional<Long> = quality.getOptional("quality")

        /**
         * The file size in bytes.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun size(): Optional<Long> = size.getOptional("size")

        /**
         * The video codec used in the video (only for video).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun videoCodec(): Optional<String> = videoCodec.getOptional("videoCodec")

        /**
         * The width of the image or video in pixels.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun width(): Optional<Long> = width.getOptional("width")

        /**
         * Returns the raw JSON value of [audioCodec].
         *
         * Unlike [audioCodec], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("audioCodec")
        @ExcludeMissing
        fun _audioCodec(): JsonField<String> = audioCodec

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
         * Unlike [hasColorProfile], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("hasColorProfile")
        @ExcludeMissing
        fun _hasColorProfile(): JsonField<Boolean> = hasColorProfile

        /**
         * Returns the raw JSON value of [hasTransparency].
         *
         * Unlike [hasTransparency], this method doesn't throw if the JSON field has an unexpected
         * type.
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
        @JsonProperty("videoCodec")
        @ExcludeMissing
        fun _videoCodec(): JsonField<String> = videoCodec

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

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
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
            internal fun from(metadata: Metadata) = apply {
                audioCodec = metadata.audioCodec
                bitRate = metadata.bitRate
                density = metadata.density
                duration = metadata.duration
                exif = metadata.exif
                format = metadata.format
                hasColorProfile = metadata.hasColorProfile
                hasTransparency = metadata.hasTransparency
                height = metadata.height
                pHash = metadata.pHash
                quality = metadata.quality
                size = metadata.size
                videoCodec = metadata.videoCodec
                width = metadata.width
                additionalProperties = metadata.additionalProperties.toMutableMap()
            }

            /** The audio codec used in the video (only for video). */
            fun audioCodec(audioCodec: String) = audioCodec(JsonField.of(audioCodec))

            /**
             * Sets [Builder.audioCodec] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audioCodec] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audioCodec(audioCodec: JsonField<String>) = apply { this.audioCodec = audioCodec }

            /** The bit rate of the video in kbps (only for video). */
            fun bitRate(bitRate: Long) = bitRate(JsonField.of(bitRate))

            /**
             * Sets [Builder.bitRate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bitRate] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bitRate(bitRate: JsonField<Long>) = apply { this.bitRate = bitRate }

            /** The density of the image in DPI. */
            fun density(density: Long) = density(JsonField.of(density))

            /**
             * Sets [Builder.density] to an arbitrary JSON value.
             *
             * You should usually call [Builder.density] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun density(density: JsonField<Long>) = apply { this.density = density }

            /** The duration of the video in seconds (only for video). */
            fun duration(duration: Long) = duration(JsonField.of(duration))

            /**
             * Sets [Builder.duration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.duration] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun duration(duration: JsonField<Long>) = apply { this.duration = duration }

            fun exif(exif: Exif) = exif(JsonField.of(exif))

            /**
             * Sets [Builder.exif] to an arbitrary JSON value.
             *
             * You should usually call [Builder.exif] with a well-typed [Exif] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun exif(exif: JsonField<Exif>) = apply { this.exif = exif }

            /** The format of the file (e.g., 'jpg', 'mp4'). */
            fun format(format: String) = format(JsonField.of(format))

            /**
             * Sets [Builder.format] to an arbitrary JSON value.
             *
             * You should usually call [Builder.format] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun height(height: JsonField<Long>) = apply { this.height = height }

            /** Perceptual hash of the image. */
            fun pHash(pHash: String) = pHash(JsonField.of(pHash))

            /**
             * Sets [Builder.pHash] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pHash] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pHash(pHash: JsonField<String>) = apply { this.pHash = pHash }

            /** The quality indicator of the image. */
            fun quality(quality: Long) = quality(JsonField.of(quality))

            /**
             * Sets [Builder.quality] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quality] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quality(quality: JsonField<Long>) = apply { this.quality = quality }

            /** The file size in bytes. */
            fun size(size: Long) = size(JsonField.of(size))

            /**
             * Sets [Builder.size] to an arbitrary JSON value.
             *
             * You should usually call [Builder.size] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun size(size: JsonField<Long>) = apply { this.size = size }

            /** The video codec used in the video (only for video). */
            fun videoCodec(videoCodec: String) = videoCodec(JsonField.of(videoCodec))

            /**
             * Sets [Builder.videoCodec] to an arbitrary JSON value.
             *
             * You should usually call [Builder.videoCodec] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun videoCodec(videoCodec: JsonField<String>) = apply { this.videoCodec = videoCodec }

            /** The width of the image or video in pixels. */
            fun width(width: Long) = width(JsonField.of(width))

            /**
             * Sets [Builder.width] to an arbitrary JSON value.
             *
             * You should usually call [Builder.width] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata =
                Metadata(
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

        fun validate(): Metadata = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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
                @JsonProperty("exif")
                @ExcludeMissing
                exif: JsonField<ExifDetails> = JsonMissing.of(),
                @JsonProperty("gps") @ExcludeMissing gps: JsonField<Gps> = JsonMissing.of(),
                @JsonProperty("image")
                @ExcludeMissing
                image: JsonField<ExifImage> = JsonMissing.of(),
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
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun exif(): Optional<ExifDetails> = exif.getOptional("exif")

            /**
             * Object containing GPS information.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun gps(): Optional<Gps> = gps.getOptional("gps")

            /**
             * Object containing EXIF image information.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun image(): Optional<ExifImage> = image.getOptional("image")

            /**
             * JSON object.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun interoperability(): Optional<Interoperability> =
                interoperability.getOptional("interoperability")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun makernote(): Optional<Makernote> = makernote.getOptional("makernote")

            /**
             * Object containing Thumbnail information.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
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
             * Unlike [interoperability], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("interoperability")
            @ExcludeMissing
            fun _interoperability(): JsonField<Interoperability> = interoperability

            /**
             * Returns the raw JSON value of [makernote].
             *
             * Unlike [makernote], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("makernote")
            @ExcludeMissing
            fun _makernote(): JsonField<Makernote> = makernote

            /**
             * Returns the raw JSON value of [thumbnail].
             *
             * Unlike [thumbnail], this method doesn't throw if the JSON field has an unexpected
             * type.
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
                 * You should usually call [Builder.exif] with a well-typed [ExifDetails] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
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
                 * You should usually call [Builder.image] with a well-typed [ExifImage] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun image(image: JsonField<ExifImage>) = apply { this.image = image }

                /** JSON object. */
                fun interoperability(interoperability: Interoperability) =
                    interoperability(JsonField.of(interoperability))

                /**
                 * Sets [Builder.interoperability] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.interoperability] with a well-typed
                 * [Interoperability] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun interoperability(interoperability: JsonField<Interoperability>) = apply {
                    this.interoperability = interoperability
                }

                fun makernote(makernote: Makernote) = makernote(JsonField.of(makernote))

                /**
                 * Sets [Builder.makernote] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.makernote] with a well-typed [Makernote] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun makernote(makernote: JsonField<Makernote>) = apply {
                    this.makernote = makernote
                }

                /** Object containing Thumbnail information. */
                fun thumbnail(thumbnail: Thumbnail) = thumbnail(JsonField.of(thumbnail))

                /**
                 * Sets [Builder.thumbnail] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.thumbnail] with a well-typed [Thumbnail] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun thumbnail(thumbnail: JsonField<Thumbnail>) = apply {
                    this.thumbnail = thumbnail
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
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

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

            return other is Metadata &&
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
            "Metadata{audioCodec=$audioCodec, bitRate=$bitRate, density=$density, duration=$duration, exif=$exif, format=$format, hasColorProfile=$hasColorProfile, hasTransparency=$hasTransparency, height=$height, pHash=$pHash, quality=$quality, size=$size, videoCodec=$videoCodec, width=$width, additionalProperties=$additionalProperties}"
    }

    /** An object containing the file or file version's `id` (versionId) and `name`. */
    class VersionInfo
    private constructor(
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(id, name, mutableMapOf())

        /**
         * Unique identifier of the file version.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * Name of the file version.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

            /** Returns a mutable builder for constructing an instance of [VersionInfo]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [VersionInfo]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(versionInfo: VersionInfo) = apply {
                id = versionInfo.id
                name = versionInfo.name
                additionalProperties = versionInfo.additionalProperties.toMutableMap()
            }

            /** Unique identifier of the file version. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Name of the file version. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * Returns an immutable instance of [VersionInfo].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): VersionInfo = VersionInfo(id, name, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): VersionInfo = apply {
            if (validated) {
                return@apply
            }

            id()
            name()
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
            (if (id.asKnown().isPresent) 1 else 0) + (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is VersionInfo &&
                id == other.id &&
                name == other.name &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "VersionInfo{id=$id, name=$name, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileUploadResponse &&
            aiTags == other.aiTags &&
            audioCodec == other.audioCodec &&
            bitRate == other.bitRate &&
            customCoordinates == other.customCoordinates &&
            customMetadata == other.customMetadata &&
            duration == other.duration &&
            embeddedMetadata == other.embeddedMetadata &&
            extensionStatus == other.extensionStatus &&
            fileId == other.fileId &&
            filePath == other.filePath &&
            fileType == other.fileType &&
            height == other.height &&
            isPrivateFile == other.isPrivateFile &&
            isPublished == other.isPublished &&
            metadata == other.metadata &&
            name == other.name &&
            size == other.size &&
            tags == other.tags &&
            thumbnailUrl == other.thumbnailUrl &&
            url == other.url &&
            versionInfo == other.versionInfo &&
            videoCodec == other.videoCodec &&
            width == other.width &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            aiTags,
            audioCodec,
            bitRate,
            customCoordinates,
            customMetadata,
            duration,
            embeddedMetadata,
            extensionStatus,
            fileId,
            filePath,
            fileType,
            height,
            isPrivateFile,
            isPublished,
            metadata,
            name,
            size,
            tags,
            thumbnailUrl,
            url,
            versionInfo,
            videoCodec,
            width,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileUploadResponse{aiTags=$aiTags, audioCodec=$audioCodec, bitRate=$bitRate, customCoordinates=$customCoordinates, customMetadata=$customMetadata, duration=$duration, embeddedMetadata=$embeddedMetadata, extensionStatus=$extensionStatus, fileId=$fileId, filePath=$filePath, fileType=$fileType, height=$height, isPrivateFile=$isPrivateFile, isPublished=$isPublished, metadata=$metadata, name=$name, size=$size, tags=$tags, thumbnailUrl=$thumbnailUrl, url=$url, versionInfo=$versionInfo, videoCodec=$videoCodec, width=$width, additionalProperties=$additionalProperties}"
}
