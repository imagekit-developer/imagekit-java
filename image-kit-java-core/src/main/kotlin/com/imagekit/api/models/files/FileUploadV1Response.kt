// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Object containing details of a successful upload. */
class FileUploadV1Response
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

        /** Returns a mutable builder for constructing an instance of [FileUploadV1Response]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileUploadV1Response]. */
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
        internal fun from(fileUploadV1Response: FileUploadV1Response) = apply {
            aiTags = fileUploadV1Response.aiTags.map { it.toMutableList() }
            audioCodec = fileUploadV1Response.audioCodec
            bitRate = fileUploadV1Response.bitRate
            customCoordinates = fileUploadV1Response.customCoordinates
            customMetadata = fileUploadV1Response.customMetadata
            duration = fileUploadV1Response.duration
            embeddedMetadata = fileUploadV1Response.embeddedMetadata
            extensionStatus = fileUploadV1Response.extensionStatus
            fileId = fileUploadV1Response.fileId
            filePath = fileUploadV1Response.filePath
            fileType = fileUploadV1Response.fileType
            height = fileUploadV1Response.height
            isPrivateFile = fileUploadV1Response.isPrivateFile
            isPublished = fileUploadV1Response.isPublished
            metadata = fileUploadV1Response.metadata
            name = fileUploadV1Response.name
            size = fileUploadV1Response.size
            tags = fileUploadV1Response.tags.map { it.toMutableList() }
            thumbnailUrl = fileUploadV1Response.thumbnailUrl
            url = fileUploadV1Response.url
            versionInfo = fileUploadV1Response.versionInfo
            videoCodec = fileUploadV1Response.videoCodec
            width = fileUploadV1Response.width
            additionalProperties = fileUploadV1Response.additionalProperties.toMutableMap()
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
         * Returns an immutable instance of [FileUploadV1Response].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FileUploadV1Response =
            FileUploadV1Response(
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

    fun validate(): FileUploadV1Response = apply {
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
    private constructor(
        private val aboutCvTermCvId: JsonField<String>,
        private val aboutCvTermId: JsonField<String>,
        private val aboutCvTermName: JsonField<String>,
        private val aboutCvTermRefinedAbout: JsonField<String>,
        private val additionalModelInformation: JsonField<String>,
        private val applicationRecordVersion: JsonField<Long>,
        private val artist: JsonField<String>,
        private val artworkCircaDateCreated: JsonField<String>,
        private val artworkContentDescription: JsonField<String>,
        private val artworkContributionDescription: JsonField<String>,
        private val artworkCopyrightNotice: JsonField<String>,
        private val artworkCopyrightOwnerId: JsonField<String>,
        private val artworkCopyrightOwnerName: JsonField<String>,
        private val artworkCreator: JsonField<List<String>>,
        private val artworkCreatorId: JsonField<List<String>>,
        private val artworkDateCreated: JsonField<OffsetDateTime>,
        private val artworkLicensorId: JsonField<String>,
        private val artworkLicensorName: JsonField<String>,
        private val artworkPhysicalDescription: JsonField<String>,
        private val artworkSource: JsonField<String>,
        private val artworkSourceInventoryNo: JsonField<String>,
        private val artworkSourceInvUrl: JsonField<String>,
        private val artworkStylePeriod: JsonField<List<String>>,
        private val artworkTitle: JsonField<String>,
        private val authorsPosition: JsonField<String>,
        private val byline: JsonField<String>,
        private val bylineTitle: JsonField<String>,
        private val caption: JsonField<String>,
        private val captionAbstract: JsonField<String>,
        private val captionWriter: JsonField<String>,
        private val city: JsonField<String>,
        private val colorSpace: JsonField<String>,
        private val componentsConfiguration: JsonField<String>,
        private val copyright: JsonField<String>,
        private val copyrightNotice: JsonField<String>,
        private val copyrightOwnerId: JsonField<List<String>>,
        private val copyrightOwnerName: JsonField<List<String>>,
        private val country: JsonField<String>,
        private val countryCode: JsonField<String>,
        private val countryPrimaryLocationCode: JsonField<String>,
        private val countryPrimaryLocationName: JsonField<String>,
        private val creator: JsonField<String>,
        private val creatorAddress: JsonField<String>,
        private val creatorCity: JsonField<String>,
        private val creatorCountry: JsonField<String>,
        private val creatorPostalCode: JsonField<String>,
        private val creatorRegion: JsonField<String>,
        private val creatorWorkEmail: JsonField<String>,
        private val creatorWorkTelephone: JsonField<String>,
        private val creatorWorkUrl: JsonField<String>,
        private val credit: JsonField<String>,
        private val dateCreated: JsonField<OffsetDateTime>,
        private val dateTimeCreated: JsonField<OffsetDateTime>,
        private val dateTimeOriginal: JsonField<OffsetDateTime>,
        private val description: JsonField<String>,
        private val digitalImageGuid: JsonField<String>,
        private val digitalSourceType: JsonField<String>,
        private val embeddedEncodedRightsExpr: JsonField<String>,
        private val embeddedEncodedRightsExprLangId: JsonField<String>,
        private val embeddedEncodedRightsExprType: JsonField<String>,
        private val event: JsonField<String>,
        private val exifVersion: JsonField<String>,
        private val flashpixVersion: JsonField<String>,
        private val genreCvId: JsonField<String>,
        private val genreCvTermId: JsonField<String>,
        private val genreCvTermName: JsonField<String>,
        private val genreCvTermRefinedAbout: JsonField<String>,
        private val headline: JsonField<String>,
        private val imageCreatorId: JsonField<String>,
        private val imageCreatorImageId: JsonField<String>,
        private val imageCreatorName: JsonField<String>,
        private val imageDescription: JsonField<String>,
        private val imageRegionBoundaryH: JsonField<List<Double>>,
        private val imageRegionBoundaryRx: JsonField<List<Double>>,
        private val imageRegionBoundaryShape: JsonField<List<String>>,
        private val imageRegionBoundaryUnit: JsonField<List<String>>,
        private val imageRegionBoundaryVerticesX: JsonField<List<Double>>,
        private val imageRegionBoundaryVerticesY: JsonField<List<Double>>,
        private val imageRegionBoundaryW: JsonField<List<Double>>,
        private val imageRegionBoundaryX: JsonField<List<Double>>,
        private val imageRegionBoundaryY: JsonField<List<Double>>,
        private val imageRegionCtypeIdentifier: JsonField<List<String>>,
        private val imageRegionCtypeName: JsonField<List<String>>,
        private val imageRegionId: JsonField<List<String>>,
        private val imageRegionName: JsonField<List<String>>,
        private val imageRegionOrganisationInImageName: JsonField<List<String>>,
        private val imageRegionPersonInImage: JsonField<List<String>>,
        private val imageRegionRoleIdentifier: JsonField<List<String>>,
        private val imageRegionRoleName: JsonField<List<String>>,
        private val imageSupplierId: JsonField<String>,
        private val imageSupplierImageId: JsonField<String>,
        private val imageSupplierName: JsonField<String>,
        private val instructions: JsonField<String>,
        private val intellectualGenre: JsonField<String>,
        private val keywords: JsonField<List<String>>,
        private val licensorCity: JsonField<List<String>>,
        private val licensorCountry: JsonField<List<String>>,
        private val licensorEmail: JsonField<List<String>>,
        private val licensorExtendedAddress: JsonField<List<String>>,
        private val licensorId: JsonField<List<String>>,
        private val licensorName: JsonField<List<String>>,
        private val licensorPostalCode: JsonField<List<String>>,
        private val licensorRegion: JsonField<List<String>>,
        private val licensorStreetAddress: JsonField<List<String>>,
        private val licensorTelephone1: JsonField<List<String>>,
        private val licensorTelephone2: JsonField<List<String>>,
        private val licensorUrl: JsonField<List<String>>,
        private val linkedEncodedRightsExpr: JsonField<String>,
        private val linkedEncodedRightsExprLangId: JsonField<String>,
        private val linkedEncodedRightsExprType: JsonField<String>,
        private val location: JsonField<String>,
        private val locationCreatedCity: JsonField<String>,
        private val locationCreatedCountryCode: JsonField<String>,
        private val locationCreatedCountryName: JsonField<String>,
        private val locationCreatedGpsAltitude: JsonField<String>,
        private val locationCreatedGpsLatitude: JsonField<String>,
        private val locationCreatedGpsLongitude: JsonField<String>,
        private val locationCreatedLocationId: JsonField<String>,
        private val locationCreatedLocationName: JsonField<String>,
        private val locationCreatedProvinceState: JsonField<String>,
        private val locationCreatedSublocation: JsonField<String>,
        private val locationCreatedWorldRegion: JsonField<String>,
        private val locationShownCity: JsonField<List<String>>,
        private val locationShownCountryCode: JsonField<List<String>>,
        private val locationShownCountryName: JsonField<List<String>>,
        private val locationShownGpsAltitude: JsonField<List<String>>,
        private val locationShownGpsLatitude: JsonField<List<String>>,
        private val locationShownGpsLongitude: JsonField<List<String>>,
        private val locationShownLocationId: JsonField<List<String>>,
        private val locationShownLocationName: JsonField<List<String>>,
        private val locationShownProvinceState: JsonField<List<String>>,
        private val locationShownSublocation: JsonField<List<String>>,
        private val locationShownWorldRegion: JsonField<List<String>>,
        private val maxAvailHeight: JsonField<Double>,
        private val maxAvailWidth: JsonField<Double>,
        private val modelAge: JsonField<List<Double>>,
        private val modelReleaseId: JsonField<List<String>>,
        private val objectAttributeReference: JsonField<String>,
        private val objectName: JsonField<String>,
        private val offsetTimeOriginal: JsonField<String>,
        private val organisationInImageCode: JsonField<List<String>>,
        private val organisationInImageName: JsonField<List<String>>,
        private val orientation: JsonField<String>,
        private val originalTransmissionReference: JsonField<String>,
        private val personInImage: JsonField<List<String>>,
        private val personInImageCvTermCvId: JsonField<List<String>>,
        private val personInImageCvTermId: JsonField<List<String>>,
        private val personInImageCvTermName: JsonField<List<String>>,
        private val personInImageCvTermRefinedAbout: JsonField<List<String>>,
        private val personInImageDescription: JsonField<List<String>>,
        private val personInImageId: JsonField<List<String>>,
        private val personInImageName: JsonField<List<String>>,
        private val productInImageDescription: JsonField<List<String>>,
        private val productInImageGtin: JsonField<List<Double>>,
        private val productInImageName: JsonField<List<String>>,
        private val propertyReleaseId: JsonField<List<String>>,
        private val provinceState: JsonField<String>,
        private val rating: JsonField<Long>,
        private val registryEntryRole: JsonField<List<String>>,
        private val registryItemId: JsonField<List<String>>,
        private val registryOrganisationId: JsonField<List<String>>,
        private val resolutionUnit: JsonField<String>,
        private val rights: JsonField<String>,
        private val scene: JsonField<List<String>>,
        private val source: JsonField<String>,
        private val specialInstructions: JsonField<String>,
        private val state: JsonField<String>,
        private val subject: JsonField<List<String>>,
        private val subjectCode: JsonField<List<String>>,
        private val subjectReference: JsonField<List<String>>,
        private val sublocation: JsonField<String>,
        private val timeCreated: JsonField<String>,
        private val title: JsonField<String>,
        private val transmissionReference: JsonField<String>,
        private val usageTerms: JsonField<String>,
        private val webStatement: JsonField<String>,
        private val writer: JsonField<String>,
        private val writerEditor: JsonField<String>,
        private val xResolution: JsonField<Double>,
        private val yResolution: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("AboutCvTermCvId")
            @ExcludeMissing
            aboutCvTermCvId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("AboutCvTermId")
            @ExcludeMissing
            aboutCvTermId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("AboutCvTermName")
            @ExcludeMissing
            aboutCvTermName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("AboutCvTermRefinedAbout")
            @ExcludeMissing
            aboutCvTermRefinedAbout: JsonField<String> = JsonMissing.of(),
            @JsonProperty("AdditionalModelInformation")
            @ExcludeMissing
            additionalModelInformation: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ApplicationRecordVersion")
            @ExcludeMissing
            applicationRecordVersion: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("Artist") @ExcludeMissing artist: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkCircaDateCreated")
            @ExcludeMissing
            artworkCircaDateCreated: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkContentDescription")
            @ExcludeMissing
            artworkContentDescription: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkContributionDescription")
            @ExcludeMissing
            artworkContributionDescription: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkCopyrightNotice")
            @ExcludeMissing
            artworkCopyrightNotice: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkCopyrightOwnerID")
            @ExcludeMissing
            artworkCopyrightOwnerId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkCopyrightOwnerName")
            @ExcludeMissing
            artworkCopyrightOwnerName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkCreator")
            @ExcludeMissing
            artworkCreator: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ArtworkCreatorID")
            @ExcludeMissing
            artworkCreatorId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ArtworkDateCreated")
            @ExcludeMissing
            artworkDateCreated: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("ArtworkLicensorID")
            @ExcludeMissing
            artworkLicensorId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkLicensorName")
            @ExcludeMissing
            artworkLicensorName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkPhysicalDescription")
            @ExcludeMissing
            artworkPhysicalDescription: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkSource")
            @ExcludeMissing
            artworkSource: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkSourceInventoryNo")
            @ExcludeMissing
            artworkSourceInventoryNo: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkSourceInvURL")
            @ExcludeMissing
            artworkSourceInvUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ArtworkStylePeriod")
            @ExcludeMissing
            artworkStylePeriod: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ArtworkTitle")
            @ExcludeMissing
            artworkTitle: JsonField<String> = JsonMissing.of(),
            @JsonProperty("AuthorsPosition")
            @ExcludeMissing
            authorsPosition: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Byline") @ExcludeMissing byline: JsonField<String> = JsonMissing.of(),
            @JsonProperty("BylineTitle")
            @ExcludeMissing
            bylineTitle: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Caption") @ExcludeMissing caption: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CaptionAbstract")
            @ExcludeMissing
            captionAbstract: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CaptionWriter")
            @ExcludeMissing
            captionWriter: JsonField<String> = JsonMissing.of(),
            @JsonProperty("City") @ExcludeMissing city: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ColorSpace")
            @ExcludeMissing
            colorSpace: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ComponentsConfiguration")
            @ExcludeMissing
            componentsConfiguration: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Copyright")
            @ExcludeMissing
            copyright: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CopyrightNotice")
            @ExcludeMissing
            copyrightNotice: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CopyrightOwnerID")
            @ExcludeMissing
            copyrightOwnerId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("CopyrightOwnerName")
            @ExcludeMissing
            copyrightOwnerName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("Country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CountryCode")
            @ExcludeMissing
            countryCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CountryPrimaryLocationCode")
            @ExcludeMissing
            countryPrimaryLocationCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CountryPrimaryLocationName")
            @ExcludeMissing
            countryPrimaryLocationName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Creator") @ExcludeMissing creator: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CreatorAddress")
            @ExcludeMissing
            creatorAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CreatorCity")
            @ExcludeMissing
            creatorCity: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CreatorCountry")
            @ExcludeMissing
            creatorCountry: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CreatorPostalCode")
            @ExcludeMissing
            creatorPostalCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CreatorRegion")
            @ExcludeMissing
            creatorRegion: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CreatorWorkEmail")
            @ExcludeMissing
            creatorWorkEmail: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CreatorWorkTelephone")
            @ExcludeMissing
            creatorWorkTelephone: JsonField<String> = JsonMissing.of(),
            @JsonProperty("CreatorWorkURL")
            @ExcludeMissing
            creatorWorkUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Credit") @ExcludeMissing credit: JsonField<String> = JsonMissing.of(),
            @JsonProperty("DateCreated")
            @ExcludeMissing
            dateCreated: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("DateTimeCreated")
            @ExcludeMissing
            dateTimeCreated: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("DateTimeOriginal")
            @ExcludeMissing
            dateTimeOriginal: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("Description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("DigitalImageGUID")
            @ExcludeMissing
            digitalImageGuid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("DigitalSourceType")
            @ExcludeMissing
            digitalSourceType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("EmbeddedEncodedRightsExpr")
            @ExcludeMissing
            embeddedEncodedRightsExpr: JsonField<String> = JsonMissing.of(),
            @JsonProperty("EmbeddedEncodedRightsExprLangID")
            @ExcludeMissing
            embeddedEncodedRightsExprLangId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("EmbeddedEncodedRightsExprType")
            @ExcludeMissing
            embeddedEncodedRightsExprType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Event") @ExcludeMissing event: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ExifVersion")
            @ExcludeMissing
            exifVersion: JsonField<String> = JsonMissing.of(),
            @JsonProperty("FlashpixVersion")
            @ExcludeMissing
            flashpixVersion: JsonField<String> = JsonMissing.of(),
            @JsonProperty("GenreCvId")
            @ExcludeMissing
            genreCvId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("GenreCvTermId")
            @ExcludeMissing
            genreCvTermId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("GenreCvTermName")
            @ExcludeMissing
            genreCvTermName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("GenreCvTermRefinedAbout")
            @ExcludeMissing
            genreCvTermRefinedAbout: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Headline")
            @ExcludeMissing
            headline: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ImageCreatorID")
            @ExcludeMissing
            imageCreatorId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ImageCreatorImageID")
            @ExcludeMissing
            imageCreatorImageId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ImageCreatorName")
            @ExcludeMissing
            imageCreatorName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ImageDescription")
            @ExcludeMissing
            imageDescription: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ImageRegionBoundaryH")
            @ExcludeMissing
            imageRegionBoundaryH: JsonField<List<Double>> = JsonMissing.of(),
            @JsonProperty("ImageRegionBoundaryRx")
            @ExcludeMissing
            imageRegionBoundaryRx: JsonField<List<Double>> = JsonMissing.of(),
            @JsonProperty("ImageRegionBoundaryShape")
            @ExcludeMissing
            imageRegionBoundaryShape: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ImageRegionBoundaryUnit")
            @ExcludeMissing
            imageRegionBoundaryUnit: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ImageRegionBoundaryVerticesX")
            @ExcludeMissing
            imageRegionBoundaryVerticesX: JsonField<List<Double>> = JsonMissing.of(),
            @JsonProperty("ImageRegionBoundaryVerticesY")
            @ExcludeMissing
            imageRegionBoundaryVerticesY: JsonField<List<Double>> = JsonMissing.of(),
            @JsonProperty("ImageRegionBoundaryW")
            @ExcludeMissing
            imageRegionBoundaryW: JsonField<List<Double>> = JsonMissing.of(),
            @JsonProperty("ImageRegionBoundaryX")
            @ExcludeMissing
            imageRegionBoundaryX: JsonField<List<Double>> = JsonMissing.of(),
            @JsonProperty("ImageRegionBoundaryY")
            @ExcludeMissing
            imageRegionBoundaryY: JsonField<List<Double>> = JsonMissing.of(),
            @JsonProperty("ImageRegionCtypeIdentifier")
            @ExcludeMissing
            imageRegionCtypeIdentifier: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ImageRegionCtypeName")
            @ExcludeMissing
            imageRegionCtypeName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ImageRegionID")
            @ExcludeMissing
            imageRegionId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ImageRegionName")
            @ExcludeMissing
            imageRegionName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ImageRegionOrganisationInImageName")
            @ExcludeMissing
            imageRegionOrganisationInImageName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ImageRegionPersonInImage")
            @ExcludeMissing
            imageRegionPersonInImage: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ImageRegionRoleIdentifier")
            @ExcludeMissing
            imageRegionRoleIdentifier: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ImageRegionRoleName")
            @ExcludeMissing
            imageRegionRoleName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ImageSupplierID")
            @ExcludeMissing
            imageSupplierId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ImageSupplierImageID")
            @ExcludeMissing
            imageSupplierImageId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ImageSupplierName")
            @ExcludeMissing
            imageSupplierName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Instructions")
            @ExcludeMissing
            instructions: JsonField<String> = JsonMissing.of(),
            @JsonProperty("IntellectualGenre")
            @ExcludeMissing
            intellectualGenre: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Keywords")
            @ExcludeMissing
            keywords: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorCity")
            @ExcludeMissing
            licensorCity: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorCountry")
            @ExcludeMissing
            licensorCountry: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorEmail")
            @ExcludeMissing
            licensorEmail: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorExtendedAddress")
            @ExcludeMissing
            licensorExtendedAddress: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorID")
            @ExcludeMissing
            licensorId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorName")
            @ExcludeMissing
            licensorName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorPostalCode")
            @ExcludeMissing
            licensorPostalCode: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorRegion")
            @ExcludeMissing
            licensorRegion: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorStreetAddress")
            @ExcludeMissing
            licensorStreetAddress: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorTelephone1")
            @ExcludeMissing
            licensorTelephone1: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorTelephone2")
            @ExcludeMissing
            licensorTelephone2: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LicensorURL")
            @ExcludeMissing
            licensorUrl: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LinkedEncodedRightsExpr")
            @ExcludeMissing
            linkedEncodedRightsExpr: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LinkedEncodedRightsExprLangID")
            @ExcludeMissing
            linkedEncodedRightsExprLangId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LinkedEncodedRightsExprType")
            @ExcludeMissing
            linkedEncodedRightsExprType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Location")
            @ExcludeMissing
            location: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationCreatedCity")
            @ExcludeMissing
            locationCreatedCity: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationCreatedCountryCode")
            @ExcludeMissing
            locationCreatedCountryCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationCreatedCountryName")
            @ExcludeMissing
            locationCreatedCountryName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationCreatedGPSAltitude")
            @ExcludeMissing
            locationCreatedGpsAltitude: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationCreatedGPSLatitude")
            @ExcludeMissing
            locationCreatedGpsLatitude: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationCreatedGPSLongitude")
            @ExcludeMissing
            locationCreatedGpsLongitude: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationCreatedLocationId")
            @ExcludeMissing
            locationCreatedLocationId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationCreatedLocationName")
            @ExcludeMissing
            locationCreatedLocationName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationCreatedProvinceState")
            @ExcludeMissing
            locationCreatedProvinceState: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationCreatedSublocation")
            @ExcludeMissing
            locationCreatedSublocation: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationCreatedWorldRegion")
            @ExcludeMissing
            locationCreatedWorldRegion: JsonField<String> = JsonMissing.of(),
            @JsonProperty("LocationShownCity")
            @ExcludeMissing
            locationShownCity: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LocationShownCountryCode")
            @ExcludeMissing
            locationShownCountryCode: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LocationShownCountryName")
            @ExcludeMissing
            locationShownCountryName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LocationShownGPSAltitude")
            @ExcludeMissing
            locationShownGpsAltitude: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LocationShownGPSLatitude")
            @ExcludeMissing
            locationShownGpsLatitude: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LocationShownGPSLongitude")
            @ExcludeMissing
            locationShownGpsLongitude: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LocationShownLocationId")
            @ExcludeMissing
            locationShownLocationId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LocationShownLocationName")
            @ExcludeMissing
            locationShownLocationName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LocationShownProvinceState")
            @ExcludeMissing
            locationShownProvinceState: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LocationShownSublocation")
            @ExcludeMissing
            locationShownSublocation: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("LocationShownWorldRegion")
            @ExcludeMissing
            locationShownWorldRegion: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("MaxAvailHeight")
            @ExcludeMissing
            maxAvailHeight: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("MaxAvailWidth")
            @ExcludeMissing
            maxAvailWidth: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("ModelAge")
            @ExcludeMissing
            modelAge: JsonField<List<Double>> = JsonMissing.of(),
            @JsonProperty("ModelReleaseID")
            @ExcludeMissing
            modelReleaseId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ObjectAttributeReference")
            @ExcludeMissing
            objectAttributeReference: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ObjectName")
            @ExcludeMissing
            objectName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("OffsetTimeOriginal")
            @ExcludeMissing
            offsetTimeOriginal: JsonField<String> = JsonMissing.of(),
            @JsonProperty("OrganisationInImageCode")
            @ExcludeMissing
            organisationInImageCode: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("OrganisationInImageName")
            @ExcludeMissing
            organisationInImageName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("Orientation")
            @ExcludeMissing
            orientation: JsonField<String> = JsonMissing.of(),
            @JsonProperty("OriginalTransmissionReference")
            @ExcludeMissing
            originalTransmissionReference: JsonField<String> = JsonMissing.of(),
            @JsonProperty("PersonInImage")
            @ExcludeMissing
            personInImage: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("PersonInImageCvTermCvId")
            @ExcludeMissing
            personInImageCvTermCvId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("PersonInImageCvTermId")
            @ExcludeMissing
            personInImageCvTermId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("PersonInImageCvTermName")
            @ExcludeMissing
            personInImageCvTermName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("PersonInImageCvTermRefinedAbout")
            @ExcludeMissing
            personInImageCvTermRefinedAbout: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("PersonInImageDescription")
            @ExcludeMissing
            personInImageDescription: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("PersonInImageId")
            @ExcludeMissing
            personInImageId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("PersonInImageName")
            @ExcludeMissing
            personInImageName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ProductInImageDescription")
            @ExcludeMissing
            productInImageDescription: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ProductInImageGTIN")
            @ExcludeMissing
            productInImageGtin: JsonField<List<Double>> = JsonMissing.of(),
            @JsonProperty("ProductInImageName")
            @ExcludeMissing
            productInImageName: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("PropertyReleaseID")
            @ExcludeMissing
            propertyReleaseId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ProvinceState")
            @ExcludeMissing
            provinceState: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Rating") @ExcludeMissing rating: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("RegistryEntryRole")
            @ExcludeMissing
            registryEntryRole: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("RegistryItemID")
            @ExcludeMissing
            registryItemId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("RegistryOrganisationID")
            @ExcludeMissing
            registryOrganisationId: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ResolutionUnit")
            @ExcludeMissing
            resolutionUnit: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Rights") @ExcludeMissing rights: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Scene")
            @ExcludeMissing
            scene: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("Source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
            @JsonProperty("SpecialInstructions")
            @ExcludeMissing
            specialInstructions: JsonField<String> = JsonMissing.of(),
            @JsonProperty("State") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Subject")
            @ExcludeMissing
            subject: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("SubjectCode")
            @ExcludeMissing
            subjectCode: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("SubjectReference")
            @ExcludeMissing
            subjectReference: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("Sublocation")
            @ExcludeMissing
            sublocation: JsonField<String> = JsonMissing.of(),
            @JsonProperty("TimeCreated")
            @ExcludeMissing
            timeCreated: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("TransmissionReference")
            @ExcludeMissing
            transmissionReference: JsonField<String> = JsonMissing.of(),
            @JsonProperty("UsageTerms")
            @ExcludeMissing
            usageTerms: JsonField<String> = JsonMissing.of(),
            @JsonProperty("WebStatement")
            @ExcludeMissing
            webStatement: JsonField<String> = JsonMissing.of(),
            @JsonProperty("Writer") @ExcludeMissing writer: JsonField<String> = JsonMissing.of(),
            @JsonProperty("WriterEditor")
            @ExcludeMissing
            writerEditor: JsonField<String> = JsonMissing.of(),
            @JsonProperty("XResolution")
            @ExcludeMissing
            xResolution: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("YResolution")
            @ExcludeMissing
            yResolution: JsonField<Double> = JsonMissing.of(),
        ) : this(
            aboutCvTermCvId,
            aboutCvTermId,
            aboutCvTermName,
            aboutCvTermRefinedAbout,
            additionalModelInformation,
            applicationRecordVersion,
            artist,
            artworkCircaDateCreated,
            artworkContentDescription,
            artworkContributionDescription,
            artworkCopyrightNotice,
            artworkCopyrightOwnerId,
            artworkCopyrightOwnerName,
            artworkCreator,
            artworkCreatorId,
            artworkDateCreated,
            artworkLicensorId,
            artworkLicensorName,
            artworkPhysicalDescription,
            artworkSource,
            artworkSourceInventoryNo,
            artworkSourceInvUrl,
            artworkStylePeriod,
            artworkTitle,
            authorsPosition,
            byline,
            bylineTitle,
            caption,
            captionAbstract,
            captionWriter,
            city,
            colorSpace,
            componentsConfiguration,
            copyright,
            copyrightNotice,
            copyrightOwnerId,
            copyrightOwnerName,
            country,
            countryCode,
            countryPrimaryLocationCode,
            countryPrimaryLocationName,
            creator,
            creatorAddress,
            creatorCity,
            creatorCountry,
            creatorPostalCode,
            creatorRegion,
            creatorWorkEmail,
            creatorWorkTelephone,
            creatorWorkUrl,
            credit,
            dateCreated,
            dateTimeCreated,
            dateTimeOriginal,
            description,
            digitalImageGuid,
            digitalSourceType,
            embeddedEncodedRightsExpr,
            embeddedEncodedRightsExprLangId,
            embeddedEncodedRightsExprType,
            event,
            exifVersion,
            flashpixVersion,
            genreCvId,
            genreCvTermId,
            genreCvTermName,
            genreCvTermRefinedAbout,
            headline,
            imageCreatorId,
            imageCreatorImageId,
            imageCreatorName,
            imageDescription,
            imageRegionBoundaryH,
            imageRegionBoundaryRx,
            imageRegionBoundaryShape,
            imageRegionBoundaryUnit,
            imageRegionBoundaryVerticesX,
            imageRegionBoundaryVerticesY,
            imageRegionBoundaryW,
            imageRegionBoundaryX,
            imageRegionBoundaryY,
            imageRegionCtypeIdentifier,
            imageRegionCtypeName,
            imageRegionId,
            imageRegionName,
            imageRegionOrganisationInImageName,
            imageRegionPersonInImage,
            imageRegionRoleIdentifier,
            imageRegionRoleName,
            imageSupplierId,
            imageSupplierImageId,
            imageSupplierName,
            instructions,
            intellectualGenre,
            keywords,
            licensorCity,
            licensorCountry,
            licensorEmail,
            licensorExtendedAddress,
            licensorId,
            licensorName,
            licensorPostalCode,
            licensorRegion,
            licensorStreetAddress,
            licensorTelephone1,
            licensorTelephone2,
            licensorUrl,
            linkedEncodedRightsExpr,
            linkedEncodedRightsExprLangId,
            linkedEncodedRightsExprType,
            location,
            locationCreatedCity,
            locationCreatedCountryCode,
            locationCreatedCountryName,
            locationCreatedGpsAltitude,
            locationCreatedGpsLatitude,
            locationCreatedGpsLongitude,
            locationCreatedLocationId,
            locationCreatedLocationName,
            locationCreatedProvinceState,
            locationCreatedSublocation,
            locationCreatedWorldRegion,
            locationShownCity,
            locationShownCountryCode,
            locationShownCountryName,
            locationShownGpsAltitude,
            locationShownGpsLatitude,
            locationShownGpsLongitude,
            locationShownLocationId,
            locationShownLocationName,
            locationShownProvinceState,
            locationShownSublocation,
            locationShownWorldRegion,
            maxAvailHeight,
            maxAvailWidth,
            modelAge,
            modelReleaseId,
            objectAttributeReference,
            objectName,
            offsetTimeOriginal,
            organisationInImageCode,
            organisationInImageName,
            orientation,
            originalTransmissionReference,
            personInImage,
            personInImageCvTermCvId,
            personInImageCvTermId,
            personInImageCvTermName,
            personInImageCvTermRefinedAbout,
            personInImageDescription,
            personInImageId,
            personInImageName,
            productInImageDescription,
            productInImageGtin,
            productInImageName,
            propertyReleaseId,
            provinceState,
            rating,
            registryEntryRole,
            registryItemId,
            registryOrganisationId,
            resolutionUnit,
            rights,
            scene,
            source,
            specialInstructions,
            state,
            subject,
            subjectCode,
            subjectReference,
            sublocation,
            timeCreated,
            title,
            transmissionReference,
            usageTerms,
            webStatement,
            writer,
            writerEditor,
            xResolution,
            yResolution,
            mutableMapOf(),
        )

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun aboutCvTermCvId(): Optional<String> = aboutCvTermCvId.getOptional("AboutCvTermCvId")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun aboutCvTermId(): Optional<String> = aboutCvTermId.getOptional("AboutCvTermId")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun aboutCvTermName(): Optional<String> = aboutCvTermName.getOptional("AboutCvTermName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun aboutCvTermRefinedAbout(): Optional<String> =
            aboutCvTermRefinedAbout.getOptional("AboutCvTermRefinedAbout")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun additionalModelInformation(): Optional<String> =
            additionalModelInformation.getOptional("AdditionalModelInformation")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun applicationRecordVersion(): Optional<Long> =
            applicationRecordVersion.getOptional("ApplicationRecordVersion")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artist(): Optional<String> = artist.getOptional("Artist")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkCircaDateCreated(): Optional<String> =
            artworkCircaDateCreated.getOptional("ArtworkCircaDateCreated")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkContentDescription(): Optional<String> =
            artworkContentDescription.getOptional("ArtworkContentDescription")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkContributionDescription(): Optional<String> =
            artworkContributionDescription.getOptional("ArtworkContributionDescription")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkCopyrightNotice(): Optional<String> =
            artworkCopyrightNotice.getOptional("ArtworkCopyrightNotice")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkCopyrightOwnerId(): Optional<String> =
            artworkCopyrightOwnerId.getOptional("ArtworkCopyrightOwnerID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkCopyrightOwnerName(): Optional<String> =
            artworkCopyrightOwnerName.getOptional("ArtworkCopyrightOwnerName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkCreator(): Optional<List<String>> = artworkCreator.getOptional("ArtworkCreator")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkCreatorId(): Optional<List<String>> =
            artworkCreatorId.getOptional("ArtworkCreatorID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkDateCreated(): Optional<OffsetDateTime> =
            artworkDateCreated.getOptional("ArtworkDateCreated")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkLicensorId(): Optional<String> =
            artworkLicensorId.getOptional("ArtworkLicensorID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkLicensorName(): Optional<String> =
            artworkLicensorName.getOptional("ArtworkLicensorName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkPhysicalDescription(): Optional<String> =
            artworkPhysicalDescription.getOptional("ArtworkPhysicalDescription")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkSource(): Optional<String> = artworkSource.getOptional("ArtworkSource")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkSourceInventoryNo(): Optional<String> =
            artworkSourceInventoryNo.getOptional("ArtworkSourceInventoryNo")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkSourceInvUrl(): Optional<String> =
            artworkSourceInvUrl.getOptional("ArtworkSourceInvURL")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkStylePeriod(): Optional<List<String>> =
            artworkStylePeriod.getOptional("ArtworkStylePeriod")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun artworkTitle(): Optional<String> = artworkTitle.getOptional("ArtworkTitle")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun authorsPosition(): Optional<String> = authorsPosition.getOptional("AuthorsPosition")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun byline(): Optional<String> = byline.getOptional("Byline")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun bylineTitle(): Optional<String> = bylineTitle.getOptional("BylineTitle")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun caption(): Optional<String> = caption.getOptional("Caption")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun captionAbstract(): Optional<String> = captionAbstract.getOptional("CaptionAbstract")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun captionWriter(): Optional<String> = captionWriter.getOptional("CaptionWriter")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun city(): Optional<String> = city.getOptional("City")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun colorSpace(): Optional<String> = colorSpace.getOptional("ColorSpace")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun componentsConfiguration(): Optional<String> =
            componentsConfiguration.getOptional("ComponentsConfiguration")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun copyright(): Optional<String> = copyright.getOptional("Copyright")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun copyrightNotice(): Optional<String> = copyrightNotice.getOptional("CopyrightNotice")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun copyrightOwnerId(): Optional<List<String>> =
            copyrightOwnerId.getOptional("CopyrightOwnerID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun copyrightOwnerName(): Optional<List<String>> =
            copyrightOwnerName.getOptional("CopyrightOwnerName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun country(): Optional<String> = country.getOptional("Country")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun countryCode(): Optional<String> = countryCode.getOptional("CountryCode")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun countryPrimaryLocationCode(): Optional<String> =
            countryPrimaryLocationCode.getOptional("CountryPrimaryLocationCode")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun countryPrimaryLocationName(): Optional<String> =
            countryPrimaryLocationName.getOptional("CountryPrimaryLocationName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun creator(): Optional<String> = creator.getOptional("Creator")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun creatorAddress(): Optional<String> = creatorAddress.getOptional("CreatorAddress")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun creatorCity(): Optional<String> = creatorCity.getOptional("CreatorCity")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun creatorCountry(): Optional<String> = creatorCountry.getOptional("CreatorCountry")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun creatorPostalCode(): Optional<String> =
            creatorPostalCode.getOptional("CreatorPostalCode")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun creatorRegion(): Optional<String> = creatorRegion.getOptional("CreatorRegion")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun creatorWorkEmail(): Optional<String> = creatorWorkEmail.getOptional("CreatorWorkEmail")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun creatorWorkTelephone(): Optional<String> =
            creatorWorkTelephone.getOptional("CreatorWorkTelephone")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun creatorWorkUrl(): Optional<String> = creatorWorkUrl.getOptional("CreatorWorkURL")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun credit(): Optional<String> = credit.getOptional("Credit")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun dateCreated(): Optional<OffsetDateTime> = dateCreated.getOptional("DateCreated")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun dateTimeCreated(): Optional<OffsetDateTime> =
            dateTimeCreated.getOptional("DateTimeCreated")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun dateTimeOriginal(): Optional<OffsetDateTime> =
            dateTimeOriginal.getOptional("DateTimeOriginal")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("Description")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun digitalImageGuid(): Optional<String> = digitalImageGuid.getOptional("DigitalImageGUID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun digitalSourceType(): Optional<String> =
            digitalSourceType.getOptional("DigitalSourceType")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun embeddedEncodedRightsExpr(): Optional<String> =
            embeddedEncodedRightsExpr.getOptional("EmbeddedEncodedRightsExpr")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun embeddedEncodedRightsExprLangId(): Optional<String> =
            embeddedEncodedRightsExprLangId.getOptional("EmbeddedEncodedRightsExprLangID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun embeddedEncodedRightsExprType(): Optional<String> =
            embeddedEncodedRightsExprType.getOptional("EmbeddedEncodedRightsExprType")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun event(): Optional<String> = event.getOptional("Event")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun exifVersion(): Optional<String> = exifVersion.getOptional("ExifVersion")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun flashpixVersion(): Optional<String> = flashpixVersion.getOptional("FlashpixVersion")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun genreCvId(): Optional<String> = genreCvId.getOptional("GenreCvId")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun genreCvTermId(): Optional<String> = genreCvTermId.getOptional("GenreCvTermId")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun genreCvTermName(): Optional<String> = genreCvTermName.getOptional("GenreCvTermName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun genreCvTermRefinedAbout(): Optional<String> =
            genreCvTermRefinedAbout.getOptional("GenreCvTermRefinedAbout")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun headline(): Optional<String> = headline.getOptional("Headline")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageCreatorId(): Optional<String> = imageCreatorId.getOptional("ImageCreatorID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageCreatorImageId(): Optional<String> =
            imageCreatorImageId.getOptional("ImageCreatorImageID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageCreatorName(): Optional<String> = imageCreatorName.getOptional("ImageCreatorName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageDescription(): Optional<String> = imageDescription.getOptional("ImageDescription")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionBoundaryH(): Optional<List<Double>> =
            imageRegionBoundaryH.getOptional("ImageRegionBoundaryH")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionBoundaryRx(): Optional<List<Double>> =
            imageRegionBoundaryRx.getOptional("ImageRegionBoundaryRx")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionBoundaryShape(): Optional<List<String>> =
            imageRegionBoundaryShape.getOptional("ImageRegionBoundaryShape")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionBoundaryUnit(): Optional<List<String>> =
            imageRegionBoundaryUnit.getOptional("ImageRegionBoundaryUnit")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionBoundaryVerticesX(): Optional<List<Double>> =
            imageRegionBoundaryVerticesX.getOptional("ImageRegionBoundaryVerticesX")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionBoundaryVerticesY(): Optional<List<Double>> =
            imageRegionBoundaryVerticesY.getOptional("ImageRegionBoundaryVerticesY")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionBoundaryW(): Optional<List<Double>> =
            imageRegionBoundaryW.getOptional("ImageRegionBoundaryW")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionBoundaryX(): Optional<List<Double>> =
            imageRegionBoundaryX.getOptional("ImageRegionBoundaryX")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionBoundaryY(): Optional<List<Double>> =
            imageRegionBoundaryY.getOptional("ImageRegionBoundaryY")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionCtypeIdentifier(): Optional<List<String>> =
            imageRegionCtypeIdentifier.getOptional("ImageRegionCtypeIdentifier")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionCtypeName(): Optional<List<String>> =
            imageRegionCtypeName.getOptional("ImageRegionCtypeName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionId(): Optional<List<String>> = imageRegionId.getOptional("ImageRegionID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionName(): Optional<List<String>> =
            imageRegionName.getOptional("ImageRegionName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionOrganisationInImageName(): Optional<List<String>> =
            imageRegionOrganisationInImageName.getOptional("ImageRegionOrganisationInImageName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionPersonInImage(): Optional<List<String>> =
            imageRegionPersonInImage.getOptional("ImageRegionPersonInImage")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionRoleIdentifier(): Optional<List<String>> =
            imageRegionRoleIdentifier.getOptional("ImageRegionRoleIdentifier")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageRegionRoleName(): Optional<List<String>> =
            imageRegionRoleName.getOptional("ImageRegionRoleName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageSupplierId(): Optional<String> = imageSupplierId.getOptional("ImageSupplierID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageSupplierImageId(): Optional<String> =
            imageSupplierImageId.getOptional("ImageSupplierImageID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun imageSupplierName(): Optional<String> =
            imageSupplierName.getOptional("ImageSupplierName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun instructions(): Optional<String> = instructions.getOptional("Instructions")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun intellectualGenre(): Optional<String> =
            intellectualGenre.getOptional("IntellectualGenre")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun keywords(): Optional<List<String>> = keywords.getOptional("Keywords")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorCity(): Optional<List<String>> = licensorCity.getOptional("LicensorCity")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorCountry(): Optional<List<String>> =
            licensorCountry.getOptional("LicensorCountry")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorEmail(): Optional<List<String>> = licensorEmail.getOptional("LicensorEmail")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorExtendedAddress(): Optional<List<String>> =
            licensorExtendedAddress.getOptional("LicensorExtendedAddress")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorId(): Optional<List<String>> = licensorId.getOptional("LicensorID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorName(): Optional<List<String>> = licensorName.getOptional("LicensorName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorPostalCode(): Optional<List<String>> =
            licensorPostalCode.getOptional("LicensorPostalCode")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorRegion(): Optional<List<String>> = licensorRegion.getOptional("LicensorRegion")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorStreetAddress(): Optional<List<String>> =
            licensorStreetAddress.getOptional("LicensorStreetAddress")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorTelephone1(): Optional<List<String>> =
            licensorTelephone1.getOptional("LicensorTelephone1")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorTelephone2(): Optional<List<String>> =
            licensorTelephone2.getOptional("LicensorTelephone2")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun licensorUrl(): Optional<List<String>> = licensorUrl.getOptional("LicensorURL")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun linkedEncodedRightsExpr(): Optional<String> =
            linkedEncodedRightsExpr.getOptional("LinkedEncodedRightsExpr")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun linkedEncodedRightsExprLangId(): Optional<String> =
            linkedEncodedRightsExprLangId.getOptional("LinkedEncodedRightsExprLangID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun linkedEncodedRightsExprType(): Optional<String> =
            linkedEncodedRightsExprType.getOptional("LinkedEncodedRightsExprType")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun location(): Optional<String> = location.getOptional("Location")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationCreatedCity(): Optional<String> =
            locationCreatedCity.getOptional("LocationCreatedCity")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationCreatedCountryCode(): Optional<String> =
            locationCreatedCountryCode.getOptional("LocationCreatedCountryCode")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationCreatedCountryName(): Optional<String> =
            locationCreatedCountryName.getOptional("LocationCreatedCountryName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationCreatedGpsAltitude(): Optional<String> =
            locationCreatedGpsAltitude.getOptional("LocationCreatedGPSAltitude")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationCreatedGpsLatitude(): Optional<String> =
            locationCreatedGpsLatitude.getOptional("LocationCreatedGPSLatitude")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationCreatedGpsLongitude(): Optional<String> =
            locationCreatedGpsLongitude.getOptional("LocationCreatedGPSLongitude")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationCreatedLocationId(): Optional<String> =
            locationCreatedLocationId.getOptional("LocationCreatedLocationId")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationCreatedLocationName(): Optional<String> =
            locationCreatedLocationName.getOptional("LocationCreatedLocationName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationCreatedProvinceState(): Optional<String> =
            locationCreatedProvinceState.getOptional("LocationCreatedProvinceState")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationCreatedSublocation(): Optional<String> =
            locationCreatedSublocation.getOptional("LocationCreatedSublocation")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationCreatedWorldRegion(): Optional<String> =
            locationCreatedWorldRegion.getOptional("LocationCreatedWorldRegion")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationShownCity(): Optional<List<String>> =
            locationShownCity.getOptional("LocationShownCity")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationShownCountryCode(): Optional<List<String>> =
            locationShownCountryCode.getOptional("LocationShownCountryCode")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationShownCountryName(): Optional<List<String>> =
            locationShownCountryName.getOptional("LocationShownCountryName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationShownGpsAltitude(): Optional<List<String>> =
            locationShownGpsAltitude.getOptional("LocationShownGPSAltitude")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationShownGpsLatitude(): Optional<List<String>> =
            locationShownGpsLatitude.getOptional("LocationShownGPSLatitude")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationShownGpsLongitude(): Optional<List<String>> =
            locationShownGpsLongitude.getOptional("LocationShownGPSLongitude")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationShownLocationId(): Optional<List<String>> =
            locationShownLocationId.getOptional("LocationShownLocationId")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationShownLocationName(): Optional<List<String>> =
            locationShownLocationName.getOptional("LocationShownLocationName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationShownProvinceState(): Optional<List<String>> =
            locationShownProvinceState.getOptional("LocationShownProvinceState")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationShownSublocation(): Optional<List<String>> =
            locationShownSublocation.getOptional("LocationShownSublocation")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun locationShownWorldRegion(): Optional<List<String>> =
            locationShownWorldRegion.getOptional("LocationShownWorldRegion")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun maxAvailHeight(): Optional<Double> = maxAvailHeight.getOptional("MaxAvailHeight")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun maxAvailWidth(): Optional<Double> = maxAvailWidth.getOptional("MaxAvailWidth")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun modelAge(): Optional<List<Double>> = modelAge.getOptional("ModelAge")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun modelReleaseId(): Optional<List<String>> = modelReleaseId.getOptional("ModelReleaseID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun objectAttributeReference(): Optional<String> =
            objectAttributeReference.getOptional("ObjectAttributeReference")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun objectName(): Optional<String> = objectName.getOptional("ObjectName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun offsetTimeOriginal(): Optional<String> =
            offsetTimeOriginal.getOptional("OffsetTimeOriginal")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun organisationInImageCode(): Optional<List<String>> =
            organisationInImageCode.getOptional("OrganisationInImageCode")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun organisationInImageName(): Optional<List<String>> =
            organisationInImageName.getOptional("OrganisationInImageName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun orientation(): Optional<String> = orientation.getOptional("Orientation")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun originalTransmissionReference(): Optional<String> =
            originalTransmissionReference.getOptional("OriginalTransmissionReference")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun personInImage(): Optional<List<String>> = personInImage.getOptional("PersonInImage")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun personInImageCvTermCvId(): Optional<List<String>> =
            personInImageCvTermCvId.getOptional("PersonInImageCvTermCvId")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun personInImageCvTermId(): Optional<List<String>> =
            personInImageCvTermId.getOptional("PersonInImageCvTermId")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun personInImageCvTermName(): Optional<List<String>> =
            personInImageCvTermName.getOptional("PersonInImageCvTermName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun personInImageCvTermRefinedAbout(): Optional<List<String>> =
            personInImageCvTermRefinedAbout.getOptional("PersonInImageCvTermRefinedAbout")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun personInImageDescription(): Optional<List<String>> =
            personInImageDescription.getOptional("PersonInImageDescription")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun personInImageId(): Optional<List<String>> =
            personInImageId.getOptional("PersonInImageId")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun personInImageName(): Optional<List<String>> =
            personInImageName.getOptional("PersonInImageName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun productInImageDescription(): Optional<List<String>> =
            productInImageDescription.getOptional("ProductInImageDescription")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun productInImageGtin(): Optional<List<Double>> =
            productInImageGtin.getOptional("ProductInImageGTIN")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun productInImageName(): Optional<List<String>> =
            productInImageName.getOptional("ProductInImageName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun propertyReleaseId(): Optional<List<String>> =
            propertyReleaseId.getOptional("PropertyReleaseID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun provinceState(): Optional<String> = provinceState.getOptional("ProvinceState")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun rating(): Optional<Long> = rating.getOptional("Rating")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun registryEntryRole(): Optional<List<String>> =
            registryEntryRole.getOptional("RegistryEntryRole")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun registryItemId(): Optional<List<String>> = registryItemId.getOptional("RegistryItemID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun registryOrganisationId(): Optional<List<String>> =
            registryOrganisationId.getOptional("RegistryOrganisationID")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun resolutionUnit(): Optional<String> = resolutionUnit.getOptional("ResolutionUnit")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun rights(): Optional<String> = rights.getOptional("Rights")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun scene(): Optional<List<String>> = scene.getOptional("Scene")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun source(): Optional<String> = source.getOptional("Source")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun specialInstructions(): Optional<String> =
            specialInstructions.getOptional("SpecialInstructions")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun state(): Optional<String> = state.getOptional("State")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun subject(): Optional<List<String>> = subject.getOptional("Subject")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun subjectCode(): Optional<List<String>> = subjectCode.getOptional("SubjectCode")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun subjectReference(): Optional<List<String>> =
            subjectReference.getOptional("SubjectReference")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sublocation(): Optional<String> = sublocation.getOptional("Sublocation")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun timeCreated(): Optional<String> = timeCreated.getOptional("TimeCreated")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun title(): Optional<String> = title.getOptional("Title")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun transmissionReference(): Optional<String> =
            transmissionReference.getOptional("TransmissionReference")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun usageTerms(): Optional<String> = usageTerms.getOptional("UsageTerms")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun webStatement(): Optional<String> = webStatement.getOptional("WebStatement")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun writer(): Optional<String> = writer.getOptional("Writer")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun writerEditor(): Optional<String> = writerEditor.getOptional("WriterEditor")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun xResolution(): Optional<Double> = xResolution.getOptional("XResolution")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun yResolution(): Optional<Double> = yResolution.getOptional("YResolution")

        /**
         * Returns the raw JSON value of [aboutCvTermCvId].
         *
         * Unlike [aboutCvTermCvId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("AboutCvTermCvId")
        @ExcludeMissing
        fun _aboutCvTermCvId(): JsonField<String> = aboutCvTermCvId

        /**
         * Returns the raw JSON value of [aboutCvTermId].
         *
         * Unlike [aboutCvTermId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("AboutCvTermId")
        @ExcludeMissing
        fun _aboutCvTermId(): JsonField<String> = aboutCvTermId

        /**
         * Returns the raw JSON value of [aboutCvTermName].
         *
         * Unlike [aboutCvTermName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("AboutCvTermName")
        @ExcludeMissing
        fun _aboutCvTermName(): JsonField<String> = aboutCvTermName

        /**
         * Returns the raw JSON value of [aboutCvTermRefinedAbout].
         *
         * Unlike [aboutCvTermRefinedAbout], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("AboutCvTermRefinedAbout")
        @ExcludeMissing
        fun _aboutCvTermRefinedAbout(): JsonField<String> = aboutCvTermRefinedAbout

        /**
         * Returns the raw JSON value of [additionalModelInformation].
         *
         * Unlike [additionalModelInformation], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("AdditionalModelInformation")
        @ExcludeMissing
        fun _additionalModelInformation(): JsonField<String> = additionalModelInformation

        /**
         * Returns the raw JSON value of [applicationRecordVersion].
         *
         * Unlike [applicationRecordVersion], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ApplicationRecordVersion")
        @ExcludeMissing
        fun _applicationRecordVersion(): JsonField<Long> = applicationRecordVersion

        /**
         * Returns the raw JSON value of [artist].
         *
         * Unlike [artist], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Artist") @ExcludeMissing fun _artist(): JsonField<String> = artist

        /**
         * Returns the raw JSON value of [artworkCircaDateCreated].
         *
         * Unlike [artworkCircaDateCreated], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ArtworkCircaDateCreated")
        @ExcludeMissing
        fun _artworkCircaDateCreated(): JsonField<String> = artworkCircaDateCreated

        /**
         * Returns the raw JSON value of [artworkContentDescription].
         *
         * Unlike [artworkContentDescription], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ArtworkContentDescription")
        @ExcludeMissing
        fun _artworkContentDescription(): JsonField<String> = artworkContentDescription

        /**
         * Returns the raw JSON value of [artworkContributionDescription].
         *
         * Unlike [artworkContributionDescription], this method doesn't throw if the JSON field has
         * an unexpected type.
         */
        @JsonProperty("ArtworkContributionDescription")
        @ExcludeMissing
        fun _artworkContributionDescription(): JsonField<String> = artworkContributionDescription

        /**
         * Returns the raw JSON value of [artworkCopyrightNotice].
         *
         * Unlike [artworkCopyrightNotice], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ArtworkCopyrightNotice")
        @ExcludeMissing
        fun _artworkCopyrightNotice(): JsonField<String> = artworkCopyrightNotice

        /**
         * Returns the raw JSON value of [artworkCopyrightOwnerId].
         *
         * Unlike [artworkCopyrightOwnerId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ArtworkCopyrightOwnerID")
        @ExcludeMissing
        fun _artworkCopyrightOwnerId(): JsonField<String> = artworkCopyrightOwnerId

        /**
         * Returns the raw JSON value of [artworkCopyrightOwnerName].
         *
         * Unlike [artworkCopyrightOwnerName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ArtworkCopyrightOwnerName")
        @ExcludeMissing
        fun _artworkCopyrightOwnerName(): JsonField<String> = artworkCopyrightOwnerName

        /**
         * Returns the raw JSON value of [artworkCreator].
         *
         * Unlike [artworkCreator], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ArtworkCreator")
        @ExcludeMissing
        fun _artworkCreator(): JsonField<List<String>> = artworkCreator

        /**
         * Returns the raw JSON value of [artworkCreatorId].
         *
         * Unlike [artworkCreatorId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ArtworkCreatorID")
        @ExcludeMissing
        fun _artworkCreatorId(): JsonField<List<String>> = artworkCreatorId

        /**
         * Returns the raw JSON value of [artworkDateCreated].
         *
         * Unlike [artworkDateCreated], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ArtworkDateCreated")
        @ExcludeMissing
        fun _artworkDateCreated(): JsonField<OffsetDateTime> = artworkDateCreated

        /**
         * Returns the raw JSON value of [artworkLicensorId].
         *
         * Unlike [artworkLicensorId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ArtworkLicensorID")
        @ExcludeMissing
        fun _artworkLicensorId(): JsonField<String> = artworkLicensorId

        /**
         * Returns the raw JSON value of [artworkLicensorName].
         *
         * Unlike [artworkLicensorName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ArtworkLicensorName")
        @ExcludeMissing
        fun _artworkLicensorName(): JsonField<String> = artworkLicensorName

        /**
         * Returns the raw JSON value of [artworkPhysicalDescription].
         *
         * Unlike [artworkPhysicalDescription], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ArtworkPhysicalDescription")
        @ExcludeMissing
        fun _artworkPhysicalDescription(): JsonField<String> = artworkPhysicalDescription

        /**
         * Returns the raw JSON value of [artworkSource].
         *
         * Unlike [artworkSource], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ArtworkSource")
        @ExcludeMissing
        fun _artworkSource(): JsonField<String> = artworkSource

        /**
         * Returns the raw JSON value of [artworkSourceInventoryNo].
         *
         * Unlike [artworkSourceInventoryNo], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ArtworkSourceInventoryNo")
        @ExcludeMissing
        fun _artworkSourceInventoryNo(): JsonField<String> = artworkSourceInventoryNo

        /**
         * Returns the raw JSON value of [artworkSourceInvUrl].
         *
         * Unlike [artworkSourceInvUrl], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ArtworkSourceInvURL")
        @ExcludeMissing
        fun _artworkSourceInvUrl(): JsonField<String> = artworkSourceInvUrl

        /**
         * Returns the raw JSON value of [artworkStylePeriod].
         *
         * Unlike [artworkStylePeriod], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ArtworkStylePeriod")
        @ExcludeMissing
        fun _artworkStylePeriod(): JsonField<List<String>> = artworkStylePeriod

        /**
         * Returns the raw JSON value of [artworkTitle].
         *
         * Unlike [artworkTitle], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ArtworkTitle")
        @ExcludeMissing
        fun _artworkTitle(): JsonField<String> = artworkTitle

        /**
         * Returns the raw JSON value of [authorsPosition].
         *
         * Unlike [authorsPosition], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("AuthorsPosition")
        @ExcludeMissing
        fun _authorsPosition(): JsonField<String> = authorsPosition

        /**
         * Returns the raw JSON value of [byline].
         *
         * Unlike [byline], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Byline") @ExcludeMissing fun _byline(): JsonField<String> = byline

        /**
         * Returns the raw JSON value of [bylineTitle].
         *
         * Unlike [bylineTitle], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("BylineTitle")
        @ExcludeMissing
        fun _bylineTitle(): JsonField<String> = bylineTitle

        /**
         * Returns the raw JSON value of [caption].
         *
         * Unlike [caption], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Caption") @ExcludeMissing fun _caption(): JsonField<String> = caption

        /**
         * Returns the raw JSON value of [captionAbstract].
         *
         * Unlike [captionAbstract], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("CaptionAbstract")
        @ExcludeMissing
        fun _captionAbstract(): JsonField<String> = captionAbstract

        /**
         * Returns the raw JSON value of [captionWriter].
         *
         * Unlike [captionWriter], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("CaptionWriter")
        @ExcludeMissing
        fun _captionWriter(): JsonField<String> = captionWriter

        /**
         * Returns the raw JSON value of [city].
         *
         * Unlike [city], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("City") @ExcludeMissing fun _city(): JsonField<String> = city

        /**
         * Returns the raw JSON value of [colorSpace].
         *
         * Unlike [colorSpace], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ColorSpace")
        @ExcludeMissing
        fun _colorSpace(): JsonField<String> = colorSpace

        /**
         * Returns the raw JSON value of [componentsConfiguration].
         *
         * Unlike [componentsConfiguration], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ComponentsConfiguration")
        @ExcludeMissing
        fun _componentsConfiguration(): JsonField<String> = componentsConfiguration

        /**
         * Returns the raw JSON value of [copyright].
         *
         * Unlike [copyright], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Copyright") @ExcludeMissing fun _copyright(): JsonField<String> = copyright

        /**
         * Returns the raw JSON value of [copyrightNotice].
         *
         * Unlike [copyrightNotice], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("CopyrightNotice")
        @ExcludeMissing
        fun _copyrightNotice(): JsonField<String> = copyrightNotice

        /**
         * Returns the raw JSON value of [copyrightOwnerId].
         *
         * Unlike [copyrightOwnerId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("CopyrightOwnerID")
        @ExcludeMissing
        fun _copyrightOwnerId(): JsonField<List<String>> = copyrightOwnerId

        /**
         * Returns the raw JSON value of [copyrightOwnerName].
         *
         * Unlike [copyrightOwnerName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("CopyrightOwnerName")
        @ExcludeMissing
        fun _copyrightOwnerName(): JsonField<List<String>> = copyrightOwnerName

        /**
         * Returns the raw JSON value of [country].
         *
         * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Country") @ExcludeMissing fun _country(): JsonField<String> = country

        /**
         * Returns the raw JSON value of [countryCode].
         *
         * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("CountryCode")
        @ExcludeMissing
        fun _countryCode(): JsonField<String> = countryCode

        /**
         * Returns the raw JSON value of [countryPrimaryLocationCode].
         *
         * Unlike [countryPrimaryLocationCode], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("CountryPrimaryLocationCode")
        @ExcludeMissing
        fun _countryPrimaryLocationCode(): JsonField<String> = countryPrimaryLocationCode

        /**
         * Returns the raw JSON value of [countryPrimaryLocationName].
         *
         * Unlike [countryPrimaryLocationName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("CountryPrimaryLocationName")
        @ExcludeMissing
        fun _countryPrimaryLocationName(): JsonField<String> = countryPrimaryLocationName

        /**
         * Returns the raw JSON value of [creator].
         *
         * Unlike [creator], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Creator") @ExcludeMissing fun _creator(): JsonField<String> = creator

        /**
         * Returns the raw JSON value of [creatorAddress].
         *
         * Unlike [creatorAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("CreatorAddress")
        @ExcludeMissing
        fun _creatorAddress(): JsonField<String> = creatorAddress

        /**
         * Returns the raw JSON value of [creatorCity].
         *
         * Unlike [creatorCity], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("CreatorCity")
        @ExcludeMissing
        fun _creatorCity(): JsonField<String> = creatorCity

        /**
         * Returns the raw JSON value of [creatorCountry].
         *
         * Unlike [creatorCountry], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("CreatorCountry")
        @ExcludeMissing
        fun _creatorCountry(): JsonField<String> = creatorCountry

        /**
         * Returns the raw JSON value of [creatorPostalCode].
         *
         * Unlike [creatorPostalCode], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("CreatorPostalCode")
        @ExcludeMissing
        fun _creatorPostalCode(): JsonField<String> = creatorPostalCode

        /**
         * Returns the raw JSON value of [creatorRegion].
         *
         * Unlike [creatorRegion], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("CreatorRegion")
        @ExcludeMissing
        fun _creatorRegion(): JsonField<String> = creatorRegion

        /**
         * Returns the raw JSON value of [creatorWorkEmail].
         *
         * Unlike [creatorWorkEmail], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("CreatorWorkEmail")
        @ExcludeMissing
        fun _creatorWorkEmail(): JsonField<String> = creatorWorkEmail

        /**
         * Returns the raw JSON value of [creatorWorkTelephone].
         *
         * Unlike [creatorWorkTelephone], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("CreatorWorkTelephone")
        @ExcludeMissing
        fun _creatorWorkTelephone(): JsonField<String> = creatorWorkTelephone

        /**
         * Returns the raw JSON value of [creatorWorkUrl].
         *
         * Unlike [creatorWorkUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("CreatorWorkURL")
        @ExcludeMissing
        fun _creatorWorkUrl(): JsonField<String> = creatorWorkUrl

        /**
         * Returns the raw JSON value of [credit].
         *
         * Unlike [credit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Credit") @ExcludeMissing fun _credit(): JsonField<String> = credit

        /**
         * Returns the raw JSON value of [dateCreated].
         *
         * Unlike [dateCreated], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("DateCreated")
        @ExcludeMissing
        fun _dateCreated(): JsonField<OffsetDateTime> = dateCreated

        /**
         * Returns the raw JSON value of [dateTimeCreated].
         *
         * Unlike [dateTimeCreated], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("DateTimeCreated")
        @ExcludeMissing
        fun _dateTimeCreated(): JsonField<OffsetDateTime> = dateTimeCreated

        /**
         * Returns the raw JSON value of [dateTimeOriginal].
         *
         * Unlike [dateTimeOriginal], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("DateTimeOriginal")
        @ExcludeMissing
        fun _dateTimeOriginal(): JsonField<OffsetDateTime> = dateTimeOriginal

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [digitalImageGuid].
         *
         * Unlike [digitalImageGuid], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("DigitalImageGUID")
        @ExcludeMissing
        fun _digitalImageGuid(): JsonField<String> = digitalImageGuid

        /**
         * Returns the raw JSON value of [digitalSourceType].
         *
         * Unlike [digitalSourceType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("DigitalSourceType")
        @ExcludeMissing
        fun _digitalSourceType(): JsonField<String> = digitalSourceType

        /**
         * Returns the raw JSON value of [embeddedEncodedRightsExpr].
         *
         * Unlike [embeddedEncodedRightsExpr], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("EmbeddedEncodedRightsExpr")
        @ExcludeMissing
        fun _embeddedEncodedRightsExpr(): JsonField<String> = embeddedEncodedRightsExpr

        /**
         * Returns the raw JSON value of [embeddedEncodedRightsExprLangId].
         *
         * Unlike [embeddedEncodedRightsExprLangId], this method doesn't throw if the JSON field has
         * an unexpected type.
         */
        @JsonProperty("EmbeddedEncodedRightsExprLangID")
        @ExcludeMissing
        fun _embeddedEncodedRightsExprLangId(): JsonField<String> = embeddedEncodedRightsExprLangId

        /**
         * Returns the raw JSON value of [embeddedEncodedRightsExprType].
         *
         * Unlike [embeddedEncodedRightsExprType], this method doesn't throw if the JSON field has
         * an unexpected type.
         */
        @JsonProperty("EmbeddedEncodedRightsExprType")
        @ExcludeMissing
        fun _embeddedEncodedRightsExprType(): JsonField<String> = embeddedEncodedRightsExprType

        /**
         * Returns the raw JSON value of [event].
         *
         * Unlike [event], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Event") @ExcludeMissing fun _event(): JsonField<String> = event

        /**
         * Returns the raw JSON value of [exifVersion].
         *
         * Unlike [exifVersion], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ExifVersion")
        @ExcludeMissing
        fun _exifVersion(): JsonField<String> = exifVersion

        /**
         * Returns the raw JSON value of [flashpixVersion].
         *
         * Unlike [flashpixVersion], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("FlashpixVersion")
        @ExcludeMissing
        fun _flashpixVersion(): JsonField<String> = flashpixVersion

        /**
         * Returns the raw JSON value of [genreCvId].
         *
         * Unlike [genreCvId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("GenreCvId") @ExcludeMissing fun _genreCvId(): JsonField<String> = genreCvId

        /**
         * Returns the raw JSON value of [genreCvTermId].
         *
         * Unlike [genreCvTermId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("GenreCvTermId")
        @ExcludeMissing
        fun _genreCvTermId(): JsonField<String> = genreCvTermId

        /**
         * Returns the raw JSON value of [genreCvTermName].
         *
         * Unlike [genreCvTermName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("GenreCvTermName")
        @ExcludeMissing
        fun _genreCvTermName(): JsonField<String> = genreCvTermName

        /**
         * Returns the raw JSON value of [genreCvTermRefinedAbout].
         *
         * Unlike [genreCvTermRefinedAbout], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("GenreCvTermRefinedAbout")
        @ExcludeMissing
        fun _genreCvTermRefinedAbout(): JsonField<String> = genreCvTermRefinedAbout

        /**
         * Returns the raw JSON value of [headline].
         *
         * Unlike [headline], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Headline") @ExcludeMissing fun _headline(): JsonField<String> = headline

        /**
         * Returns the raw JSON value of [imageCreatorId].
         *
         * Unlike [imageCreatorId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ImageCreatorID")
        @ExcludeMissing
        fun _imageCreatorId(): JsonField<String> = imageCreatorId

        /**
         * Returns the raw JSON value of [imageCreatorImageId].
         *
         * Unlike [imageCreatorImageId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageCreatorImageID")
        @ExcludeMissing
        fun _imageCreatorImageId(): JsonField<String> = imageCreatorImageId

        /**
         * Returns the raw JSON value of [imageCreatorName].
         *
         * Unlike [imageCreatorName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ImageCreatorName")
        @ExcludeMissing
        fun _imageCreatorName(): JsonField<String> = imageCreatorName

        /**
         * Returns the raw JSON value of [imageDescription].
         *
         * Unlike [imageDescription], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ImageDescription")
        @ExcludeMissing
        fun _imageDescription(): JsonField<String> = imageDescription

        /**
         * Returns the raw JSON value of [imageRegionBoundaryH].
         *
         * Unlike [imageRegionBoundaryH], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionBoundaryH")
        @ExcludeMissing
        fun _imageRegionBoundaryH(): JsonField<List<Double>> = imageRegionBoundaryH

        /**
         * Returns the raw JSON value of [imageRegionBoundaryRx].
         *
         * Unlike [imageRegionBoundaryRx], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionBoundaryRx")
        @ExcludeMissing
        fun _imageRegionBoundaryRx(): JsonField<List<Double>> = imageRegionBoundaryRx

        /**
         * Returns the raw JSON value of [imageRegionBoundaryShape].
         *
         * Unlike [imageRegionBoundaryShape], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionBoundaryShape")
        @ExcludeMissing
        fun _imageRegionBoundaryShape(): JsonField<List<String>> = imageRegionBoundaryShape

        /**
         * Returns the raw JSON value of [imageRegionBoundaryUnit].
         *
         * Unlike [imageRegionBoundaryUnit], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionBoundaryUnit")
        @ExcludeMissing
        fun _imageRegionBoundaryUnit(): JsonField<List<String>> = imageRegionBoundaryUnit

        /**
         * Returns the raw JSON value of [imageRegionBoundaryVerticesX].
         *
         * Unlike [imageRegionBoundaryVerticesX], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionBoundaryVerticesX")
        @ExcludeMissing
        fun _imageRegionBoundaryVerticesX(): JsonField<List<Double>> = imageRegionBoundaryVerticesX

        /**
         * Returns the raw JSON value of [imageRegionBoundaryVerticesY].
         *
         * Unlike [imageRegionBoundaryVerticesY], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionBoundaryVerticesY")
        @ExcludeMissing
        fun _imageRegionBoundaryVerticesY(): JsonField<List<Double>> = imageRegionBoundaryVerticesY

        /**
         * Returns the raw JSON value of [imageRegionBoundaryW].
         *
         * Unlike [imageRegionBoundaryW], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionBoundaryW")
        @ExcludeMissing
        fun _imageRegionBoundaryW(): JsonField<List<Double>> = imageRegionBoundaryW

        /**
         * Returns the raw JSON value of [imageRegionBoundaryX].
         *
         * Unlike [imageRegionBoundaryX], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionBoundaryX")
        @ExcludeMissing
        fun _imageRegionBoundaryX(): JsonField<List<Double>> = imageRegionBoundaryX

        /**
         * Returns the raw JSON value of [imageRegionBoundaryY].
         *
         * Unlike [imageRegionBoundaryY], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionBoundaryY")
        @ExcludeMissing
        fun _imageRegionBoundaryY(): JsonField<List<Double>> = imageRegionBoundaryY

        /**
         * Returns the raw JSON value of [imageRegionCtypeIdentifier].
         *
         * Unlike [imageRegionCtypeIdentifier], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionCtypeIdentifier")
        @ExcludeMissing
        fun _imageRegionCtypeIdentifier(): JsonField<List<String>> = imageRegionCtypeIdentifier

        /**
         * Returns the raw JSON value of [imageRegionCtypeName].
         *
         * Unlike [imageRegionCtypeName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionCtypeName")
        @ExcludeMissing
        fun _imageRegionCtypeName(): JsonField<List<String>> = imageRegionCtypeName

        /**
         * Returns the raw JSON value of [imageRegionId].
         *
         * Unlike [imageRegionId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ImageRegionID")
        @ExcludeMissing
        fun _imageRegionId(): JsonField<List<String>> = imageRegionId

        /**
         * Returns the raw JSON value of [imageRegionName].
         *
         * Unlike [imageRegionName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ImageRegionName")
        @ExcludeMissing
        fun _imageRegionName(): JsonField<List<String>> = imageRegionName

        /**
         * Returns the raw JSON value of [imageRegionOrganisationInImageName].
         *
         * Unlike [imageRegionOrganisationInImageName], this method doesn't throw if the JSON field
         * has an unexpected type.
         */
        @JsonProperty("ImageRegionOrganisationInImageName")
        @ExcludeMissing
        fun _imageRegionOrganisationInImageName(): JsonField<List<String>> =
            imageRegionOrganisationInImageName

        /**
         * Returns the raw JSON value of [imageRegionPersonInImage].
         *
         * Unlike [imageRegionPersonInImage], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionPersonInImage")
        @ExcludeMissing
        fun _imageRegionPersonInImage(): JsonField<List<String>> = imageRegionPersonInImage

        /**
         * Returns the raw JSON value of [imageRegionRoleIdentifier].
         *
         * Unlike [imageRegionRoleIdentifier], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionRoleIdentifier")
        @ExcludeMissing
        fun _imageRegionRoleIdentifier(): JsonField<List<String>> = imageRegionRoleIdentifier

        /**
         * Returns the raw JSON value of [imageRegionRoleName].
         *
         * Unlike [imageRegionRoleName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageRegionRoleName")
        @ExcludeMissing
        fun _imageRegionRoleName(): JsonField<List<String>> = imageRegionRoleName

        /**
         * Returns the raw JSON value of [imageSupplierId].
         *
         * Unlike [imageSupplierId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ImageSupplierID")
        @ExcludeMissing
        fun _imageSupplierId(): JsonField<String> = imageSupplierId

        /**
         * Returns the raw JSON value of [imageSupplierImageId].
         *
         * Unlike [imageSupplierImageId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ImageSupplierImageID")
        @ExcludeMissing
        fun _imageSupplierImageId(): JsonField<String> = imageSupplierImageId

        /**
         * Returns the raw JSON value of [imageSupplierName].
         *
         * Unlike [imageSupplierName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ImageSupplierName")
        @ExcludeMissing
        fun _imageSupplierName(): JsonField<String> = imageSupplierName

        /**
         * Returns the raw JSON value of [instructions].
         *
         * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("Instructions")
        @ExcludeMissing
        fun _instructions(): JsonField<String> = instructions

        /**
         * Returns the raw JSON value of [intellectualGenre].
         *
         * Unlike [intellectualGenre], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("IntellectualGenre")
        @ExcludeMissing
        fun _intellectualGenre(): JsonField<String> = intellectualGenre

        /**
         * Returns the raw JSON value of [keywords].
         *
         * Unlike [keywords], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Keywords")
        @ExcludeMissing
        fun _keywords(): JsonField<List<String>> = keywords

        /**
         * Returns the raw JSON value of [licensorCity].
         *
         * Unlike [licensorCity], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("LicensorCity")
        @ExcludeMissing
        fun _licensorCity(): JsonField<List<String>> = licensorCity

        /**
         * Returns the raw JSON value of [licensorCountry].
         *
         * Unlike [licensorCountry], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("LicensorCountry")
        @ExcludeMissing
        fun _licensorCountry(): JsonField<List<String>> = licensorCountry

        /**
         * Returns the raw JSON value of [licensorEmail].
         *
         * Unlike [licensorEmail], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("LicensorEmail")
        @ExcludeMissing
        fun _licensorEmail(): JsonField<List<String>> = licensorEmail

        /**
         * Returns the raw JSON value of [licensorExtendedAddress].
         *
         * Unlike [licensorExtendedAddress], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LicensorExtendedAddress")
        @ExcludeMissing
        fun _licensorExtendedAddress(): JsonField<List<String>> = licensorExtendedAddress

        /**
         * Returns the raw JSON value of [licensorId].
         *
         * Unlike [licensorId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("LicensorID")
        @ExcludeMissing
        fun _licensorId(): JsonField<List<String>> = licensorId

        /**
         * Returns the raw JSON value of [licensorName].
         *
         * Unlike [licensorName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("LicensorName")
        @ExcludeMissing
        fun _licensorName(): JsonField<List<String>> = licensorName

        /**
         * Returns the raw JSON value of [licensorPostalCode].
         *
         * Unlike [licensorPostalCode], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LicensorPostalCode")
        @ExcludeMissing
        fun _licensorPostalCode(): JsonField<List<String>> = licensorPostalCode

        /**
         * Returns the raw JSON value of [licensorRegion].
         *
         * Unlike [licensorRegion], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("LicensorRegion")
        @ExcludeMissing
        fun _licensorRegion(): JsonField<List<String>> = licensorRegion

        /**
         * Returns the raw JSON value of [licensorStreetAddress].
         *
         * Unlike [licensorStreetAddress], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LicensorStreetAddress")
        @ExcludeMissing
        fun _licensorStreetAddress(): JsonField<List<String>> = licensorStreetAddress

        /**
         * Returns the raw JSON value of [licensorTelephone1].
         *
         * Unlike [licensorTelephone1], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LicensorTelephone1")
        @ExcludeMissing
        fun _licensorTelephone1(): JsonField<List<String>> = licensorTelephone1

        /**
         * Returns the raw JSON value of [licensorTelephone2].
         *
         * Unlike [licensorTelephone2], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LicensorTelephone2")
        @ExcludeMissing
        fun _licensorTelephone2(): JsonField<List<String>> = licensorTelephone2

        /**
         * Returns the raw JSON value of [licensorUrl].
         *
         * Unlike [licensorUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("LicensorURL")
        @ExcludeMissing
        fun _licensorUrl(): JsonField<List<String>> = licensorUrl

        /**
         * Returns the raw JSON value of [linkedEncodedRightsExpr].
         *
         * Unlike [linkedEncodedRightsExpr], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LinkedEncodedRightsExpr")
        @ExcludeMissing
        fun _linkedEncodedRightsExpr(): JsonField<String> = linkedEncodedRightsExpr

        /**
         * Returns the raw JSON value of [linkedEncodedRightsExprLangId].
         *
         * Unlike [linkedEncodedRightsExprLangId], this method doesn't throw if the JSON field has
         * an unexpected type.
         */
        @JsonProperty("LinkedEncodedRightsExprLangID")
        @ExcludeMissing
        fun _linkedEncodedRightsExprLangId(): JsonField<String> = linkedEncodedRightsExprLangId

        /**
         * Returns the raw JSON value of [linkedEncodedRightsExprType].
         *
         * Unlike [linkedEncodedRightsExprType], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LinkedEncodedRightsExprType")
        @ExcludeMissing
        fun _linkedEncodedRightsExprType(): JsonField<String> = linkedEncodedRightsExprType

        /**
         * Returns the raw JSON value of [location].
         *
         * Unlike [location], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Location") @ExcludeMissing fun _location(): JsonField<String> = location

        /**
         * Returns the raw JSON value of [locationCreatedCity].
         *
         * Unlike [locationCreatedCity], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationCreatedCity")
        @ExcludeMissing
        fun _locationCreatedCity(): JsonField<String> = locationCreatedCity

        /**
         * Returns the raw JSON value of [locationCreatedCountryCode].
         *
         * Unlike [locationCreatedCountryCode], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationCreatedCountryCode")
        @ExcludeMissing
        fun _locationCreatedCountryCode(): JsonField<String> = locationCreatedCountryCode

        /**
         * Returns the raw JSON value of [locationCreatedCountryName].
         *
         * Unlike [locationCreatedCountryName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationCreatedCountryName")
        @ExcludeMissing
        fun _locationCreatedCountryName(): JsonField<String> = locationCreatedCountryName

        /**
         * Returns the raw JSON value of [locationCreatedGpsAltitude].
         *
         * Unlike [locationCreatedGpsAltitude], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationCreatedGPSAltitude")
        @ExcludeMissing
        fun _locationCreatedGpsAltitude(): JsonField<String> = locationCreatedGpsAltitude

        /**
         * Returns the raw JSON value of [locationCreatedGpsLatitude].
         *
         * Unlike [locationCreatedGpsLatitude], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationCreatedGPSLatitude")
        @ExcludeMissing
        fun _locationCreatedGpsLatitude(): JsonField<String> = locationCreatedGpsLatitude

        /**
         * Returns the raw JSON value of [locationCreatedGpsLongitude].
         *
         * Unlike [locationCreatedGpsLongitude], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationCreatedGPSLongitude")
        @ExcludeMissing
        fun _locationCreatedGpsLongitude(): JsonField<String> = locationCreatedGpsLongitude

        /**
         * Returns the raw JSON value of [locationCreatedLocationId].
         *
         * Unlike [locationCreatedLocationId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationCreatedLocationId")
        @ExcludeMissing
        fun _locationCreatedLocationId(): JsonField<String> = locationCreatedLocationId

        /**
         * Returns the raw JSON value of [locationCreatedLocationName].
         *
         * Unlike [locationCreatedLocationName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationCreatedLocationName")
        @ExcludeMissing
        fun _locationCreatedLocationName(): JsonField<String> = locationCreatedLocationName

        /**
         * Returns the raw JSON value of [locationCreatedProvinceState].
         *
         * Unlike [locationCreatedProvinceState], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationCreatedProvinceState")
        @ExcludeMissing
        fun _locationCreatedProvinceState(): JsonField<String> = locationCreatedProvinceState

        /**
         * Returns the raw JSON value of [locationCreatedSublocation].
         *
         * Unlike [locationCreatedSublocation], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationCreatedSublocation")
        @ExcludeMissing
        fun _locationCreatedSublocation(): JsonField<String> = locationCreatedSublocation

        /**
         * Returns the raw JSON value of [locationCreatedWorldRegion].
         *
         * Unlike [locationCreatedWorldRegion], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationCreatedWorldRegion")
        @ExcludeMissing
        fun _locationCreatedWorldRegion(): JsonField<String> = locationCreatedWorldRegion

        /**
         * Returns the raw JSON value of [locationShownCity].
         *
         * Unlike [locationShownCity], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("LocationShownCity")
        @ExcludeMissing
        fun _locationShownCity(): JsonField<List<String>> = locationShownCity

        /**
         * Returns the raw JSON value of [locationShownCountryCode].
         *
         * Unlike [locationShownCountryCode], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationShownCountryCode")
        @ExcludeMissing
        fun _locationShownCountryCode(): JsonField<List<String>> = locationShownCountryCode

        /**
         * Returns the raw JSON value of [locationShownCountryName].
         *
         * Unlike [locationShownCountryName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationShownCountryName")
        @ExcludeMissing
        fun _locationShownCountryName(): JsonField<List<String>> = locationShownCountryName

        /**
         * Returns the raw JSON value of [locationShownGpsAltitude].
         *
         * Unlike [locationShownGpsAltitude], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationShownGPSAltitude")
        @ExcludeMissing
        fun _locationShownGpsAltitude(): JsonField<List<String>> = locationShownGpsAltitude

        /**
         * Returns the raw JSON value of [locationShownGpsLatitude].
         *
         * Unlike [locationShownGpsLatitude], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationShownGPSLatitude")
        @ExcludeMissing
        fun _locationShownGpsLatitude(): JsonField<List<String>> = locationShownGpsLatitude

        /**
         * Returns the raw JSON value of [locationShownGpsLongitude].
         *
         * Unlike [locationShownGpsLongitude], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationShownGPSLongitude")
        @ExcludeMissing
        fun _locationShownGpsLongitude(): JsonField<List<String>> = locationShownGpsLongitude

        /**
         * Returns the raw JSON value of [locationShownLocationId].
         *
         * Unlike [locationShownLocationId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationShownLocationId")
        @ExcludeMissing
        fun _locationShownLocationId(): JsonField<List<String>> = locationShownLocationId

        /**
         * Returns the raw JSON value of [locationShownLocationName].
         *
         * Unlike [locationShownLocationName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationShownLocationName")
        @ExcludeMissing
        fun _locationShownLocationName(): JsonField<List<String>> = locationShownLocationName

        /**
         * Returns the raw JSON value of [locationShownProvinceState].
         *
         * Unlike [locationShownProvinceState], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationShownProvinceState")
        @ExcludeMissing
        fun _locationShownProvinceState(): JsonField<List<String>> = locationShownProvinceState

        /**
         * Returns the raw JSON value of [locationShownSublocation].
         *
         * Unlike [locationShownSublocation], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationShownSublocation")
        @ExcludeMissing
        fun _locationShownSublocation(): JsonField<List<String>> = locationShownSublocation

        /**
         * Returns the raw JSON value of [locationShownWorldRegion].
         *
         * Unlike [locationShownWorldRegion], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("LocationShownWorldRegion")
        @ExcludeMissing
        fun _locationShownWorldRegion(): JsonField<List<String>> = locationShownWorldRegion

        /**
         * Returns the raw JSON value of [maxAvailHeight].
         *
         * Unlike [maxAvailHeight], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("MaxAvailHeight")
        @ExcludeMissing
        fun _maxAvailHeight(): JsonField<Double> = maxAvailHeight

        /**
         * Returns the raw JSON value of [maxAvailWidth].
         *
         * Unlike [maxAvailWidth], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("MaxAvailWidth")
        @ExcludeMissing
        fun _maxAvailWidth(): JsonField<Double> = maxAvailWidth

        /**
         * Returns the raw JSON value of [modelAge].
         *
         * Unlike [modelAge], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ModelAge")
        @ExcludeMissing
        fun _modelAge(): JsonField<List<Double>> = modelAge

        /**
         * Returns the raw JSON value of [modelReleaseId].
         *
         * Unlike [modelReleaseId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ModelReleaseID")
        @ExcludeMissing
        fun _modelReleaseId(): JsonField<List<String>> = modelReleaseId

        /**
         * Returns the raw JSON value of [objectAttributeReference].
         *
         * Unlike [objectAttributeReference], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ObjectAttributeReference")
        @ExcludeMissing
        fun _objectAttributeReference(): JsonField<String> = objectAttributeReference

        /**
         * Returns the raw JSON value of [objectName].
         *
         * Unlike [objectName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ObjectName")
        @ExcludeMissing
        fun _objectName(): JsonField<String> = objectName

        /**
         * Returns the raw JSON value of [offsetTimeOriginal].
         *
         * Unlike [offsetTimeOriginal], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("OffsetTimeOriginal")
        @ExcludeMissing
        fun _offsetTimeOriginal(): JsonField<String> = offsetTimeOriginal

        /**
         * Returns the raw JSON value of [organisationInImageCode].
         *
         * Unlike [organisationInImageCode], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("OrganisationInImageCode")
        @ExcludeMissing
        fun _organisationInImageCode(): JsonField<List<String>> = organisationInImageCode

        /**
         * Returns the raw JSON value of [organisationInImageName].
         *
         * Unlike [organisationInImageName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("OrganisationInImageName")
        @ExcludeMissing
        fun _organisationInImageName(): JsonField<List<String>> = organisationInImageName

        /**
         * Returns the raw JSON value of [orientation].
         *
         * Unlike [orientation], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Orientation")
        @ExcludeMissing
        fun _orientation(): JsonField<String> = orientation

        /**
         * Returns the raw JSON value of [originalTransmissionReference].
         *
         * Unlike [originalTransmissionReference], this method doesn't throw if the JSON field has
         * an unexpected type.
         */
        @JsonProperty("OriginalTransmissionReference")
        @ExcludeMissing
        fun _originalTransmissionReference(): JsonField<String> = originalTransmissionReference

        /**
         * Returns the raw JSON value of [personInImage].
         *
         * Unlike [personInImage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("PersonInImage")
        @ExcludeMissing
        fun _personInImage(): JsonField<List<String>> = personInImage

        /**
         * Returns the raw JSON value of [personInImageCvTermCvId].
         *
         * Unlike [personInImageCvTermCvId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("PersonInImageCvTermCvId")
        @ExcludeMissing
        fun _personInImageCvTermCvId(): JsonField<List<String>> = personInImageCvTermCvId

        /**
         * Returns the raw JSON value of [personInImageCvTermId].
         *
         * Unlike [personInImageCvTermId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("PersonInImageCvTermId")
        @ExcludeMissing
        fun _personInImageCvTermId(): JsonField<List<String>> = personInImageCvTermId

        /**
         * Returns the raw JSON value of [personInImageCvTermName].
         *
         * Unlike [personInImageCvTermName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("PersonInImageCvTermName")
        @ExcludeMissing
        fun _personInImageCvTermName(): JsonField<List<String>> = personInImageCvTermName

        /**
         * Returns the raw JSON value of [personInImageCvTermRefinedAbout].
         *
         * Unlike [personInImageCvTermRefinedAbout], this method doesn't throw if the JSON field has
         * an unexpected type.
         */
        @JsonProperty("PersonInImageCvTermRefinedAbout")
        @ExcludeMissing
        fun _personInImageCvTermRefinedAbout(): JsonField<List<String>> =
            personInImageCvTermRefinedAbout

        /**
         * Returns the raw JSON value of [personInImageDescription].
         *
         * Unlike [personInImageDescription], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("PersonInImageDescription")
        @ExcludeMissing
        fun _personInImageDescription(): JsonField<List<String>> = personInImageDescription

        /**
         * Returns the raw JSON value of [personInImageId].
         *
         * Unlike [personInImageId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("PersonInImageId")
        @ExcludeMissing
        fun _personInImageId(): JsonField<List<String>> = personInImageId

        /**
         * Returns the raw JSON value of [personInImageName].
         *
         * Unlike [personInImageName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("PersonInImageName")
        @ExcludeMissing
        fun _personInImageName(): JsonField<List<String>> = personInImageName

        /**
         * Returns the raw JSON value of [productInImageDescription].
         *
         * Unlike [productInImageDescription], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ProductInImageDescription")
        @ExcludeMissing
        fun _productInImageDescription(): JsonField<List<String>> = productInImageDescription

        /**
         * Returns the raw JSON value of [productInImageGtin].
         *
         * Unlike [productInImageGtin], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ProductInImageGTIN")
        @ExcludeMissing
        fun _productInImageGtin(): JsonField<List<Double>> = productInImageGtin

        /**
         * Returns the raw JSON value of [productInImageName].
         *
         * Unlike [productInImageName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("ProductInImageName")
        @ExcludeMissing
        fun _productInImageName(): JsonField<List<String>> = productInImageName

        /**
         * Returns the raw JSON value of [propertyReleaseId].
         *
         * Unlike [propertyReleaseId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("PropertyReleaseID")
        @ExcludeMissing
        fun _propertyReleaseId(): JsonField<List<String>> = propertyReleaseId

        /**
         * Returns the raw JSON value of [provinceState].
         *
         * Unlike [provinceState], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ProvinceState")
        @ExcludeMissing
        fun _provinceState(): JsonField<String> = provinceState

        /**
         * Returns the raw JSON value of [rating].
         *
         * Unlike [rating], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Rating") @ExcludeMissing fun _rating(): JsonField<Long> = rating

        /**
         * Returns the raw JSON value of [registryEntryRole].
         *
         * Unlike [registryEntryRole], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("RegistryEntryRole")
        @ExcludeMissing
        fun _registryEntryRole(): JsonField<List<String>> = registryEntryRole

        /**
         * Returns the raw JSON value of [registryItemId].
         *
         * Unlike [registryItemId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("RegistryItemID")
        @ExcludeMissing
        fun _registryItemId(): JsonField<List<String>> = registryItemId

        /**
         * Returns the raw JSON value of [registryOrganisationId].
         *
         * Unlike [registryOrganisationId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("RegistryOrganisationID")
        @ExcludeMissing
        fun _registryOrganisationId(): JsonField<List<String>> = registryOrganisationId

        /**
         * Returns the raw JSON value of [resolutionUnit].
         *
         * Unlike [resolutionUnit], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ResolutionUnit")
        @ExcludeMissing
        fun _resolutionUnit(): JsonField<String> = resolutionUnit

        /**
         * Returns the raw JSON value of [rights].
         *
         * Unlike [rights], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Rights") @ExcludeMissing fun _rights(): JsonField<String> = rights

        /**
         * Returns the raw JSON value of [scene].
         *
         * Unlike [scene], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Scene") @ExcludeMissing fun _scene(): JsonField<List<String>> = scene

        /**
         * Returns the raw JSON value of [source].
         *
         * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Source") @ExcludeMissing fun _source(): JsonField<String> = source

        /**
         * Returns the raw JSON value of [specialInstructions].
         *
         * Unlike [specialInstructions], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("SpecialInstructions")
        @ExcludeMissing
        fun _specialInstructions(): JsonField<String> = specialInstructions

        /**
         * Returns the raw JSON value of [state].
         *
         * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("State") @ExcludeMissing fun _state(): JsonField<String> = state

        /**
         * Returns the raw JSON value of [subject].
         *
         * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Subject") @ExcludeMissing fun _subject(): JsonField<List<String>> = subject

        /**
         * Returns the raw JSON value of [subjectCode].
         *
         * Unlike [subjectCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("SubjectCode")
        @ExcludeMissing
        fun _subjectCode(): JsonField<List<String>> = subjectCode

        /**
         * Returns the raw JSON value of [subjectReference].
         *
         * Unlike [subjectReference], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("SubjectReference")
        @ExcludeMissing
        fun _subjectReference(): JsonField<List<String>> = subjectReference

        /**
         * Returns the raw JSON value of [sublocation].
         *
         * Unlike [sublocation], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Sublocation")
        @ExcludeMissing
        fun _sublocation(): JsonField<String> = sublocation

        /**
         * Returns the raw JSON value of [timeCreated].
         *
         * Unlike [timeCreated], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("TimeCreated")
        @ExcludeMissing
        fun _timeCreated(): JsonField<String> = timeCreated

        /**
         * Returns the raw JSON value of [title].
         *
         * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Title") @ExcludeMissing fun _title(): JsonField<String> = title

        /**
         * Returns the raw JSON value of [transmissionReference].
         *
         * Unlike [transmissionReference], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("TransmissionReference")
        @ExcludeMissing
        fun _transmissionReference(): JsonField<String> = transmissionReference

        /**
         * Returns the raw JSON value of [usageTerms].
         *
         * Unlike [usageTerms], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("UsageTerms")
        @ExcludeMissing
        fun _usageTerms(): JsonField<String> = usageTerms

        /**
         * Returns the raw JSON value of [webStatement].
         *
         * Unlike [webStatement], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("WebStatement")
        @ExcludeMissing
        fun _webStatement(): JsonField<String> = webStatement

        /**
         * Returns the raw JSON value of [writer].
         *
         * Unlike [writer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("Writer") @ExcludeMissing fun _writer(): JsonField<String> = writer

        /**
         * Returns the raw JSON value of [writerEditor].
         *
         * Unlike [writerEditor], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("WriterEditor")
        @ExcludeMissing
        fun _writerEditor(): JsonField<String> = writerEditor

        /**
         * Returns the raw JSON value of [xResolution].
         *
         * Unlike [xResolution], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("XResolution")
        @ExcludeMissing
        fun _xResolution(): JsonField<Double> = xResolution

        /**
         * Returns the raw JSON value of [yResolution].
         *
         * Unlike [yResolution], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("YResolution")
        @ExcludeMissing
        fun _yResolution(): JsonField<Double> = yResolution

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

            /** Returns a mutable builder for constructing an instance of [EmbeddedMetadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [EmbeddedMetadata]. */
        class Builder internal constructor() {

            private var aboutCvTermCvId: JsonField<String> = JsonMissing.of()
            private var aboutCvTermId: JsonField<String> = JsonMissing.of()
            private var aboutCvTermName: JsonField<String> = JsonMissing.of()
            private var aboutCvTermRefinedAbout: JsonField<String> = JsonMissing.of()
            private var additionalModelInformation: JsonField<String> = JsonMissing.of()
            private var applicationRecordVersion: JsonField<Long> = JsonMissing.of()
            private var artist: JsonField<String> = JsonMissing.of()
            private var artworkCircaDateCreated: JsonField<String> = JsonMissing.of()
            private var artworkContentDescription: JsonField<String> = JsonMissing.of()
            private var artworkContributionDescription: JsonField<String> = JsonMissing.of()
            private var artworkCopyrightNotice: JsonField<String> = JsonMissing.of()
            private var artworkCopyrightOwnerId: JsonField<String> = JsonMissing.of()
            private var artworkCopyrightOwnerName: JsonField<String> = JsonMissing.of()
            private var artworkCreator: JsonField<MutableList<String>>? = null
            private var artworkCreatorId: JsonField<MutableList<String>>? = null
            private var artworkDateCreated: JsonField<OffsetDateTime> = JsonMissing.of()
            private var artworkLicensorId: JsonField<String> = JsonMissing.of()
            private var artworkLicensorName: JsonField<String> = JsonMissing.of()
            private var artworkPhysicalDescription: JsonField<String> = JsonMissing.of()
            private var artworkSource: JsonField<String> = JsonMissing.of()
            private var artworkSourceInventoryNo: JsonField<String> = JsonMissing.of()
            private var artworkSourceInvUrl: JsonField<String> = JsonMissing.of()
            private var artworkStylePeriod: JsonField<MutableList<String>>? = null
            private var artworkTitle: JsonField<String> = JsonMissing.of()
            private var authorsPosition: JsonField<String> = JsonMissing.of()
            private var byline: JsonField<String> = JsonMissing.of()
            private var bylineTitle: JsonField<String> = JsonMissing.of()
            private var caption: JsonField<String> = JsonMissing.of()
            private var captionAbstract: JsonField<String> = JsonMissing.of()
            private var captionWriter: JsonField<String> = JsonMissing.of()
            private var city: JsonField<String> = JsonMissing.of()
            private var colorSpace: JsonField<String> = JsonMissing.of()
            private var componentsConfiguration: JsonField<String> = JsonMissing.of()
            private var copyright: JsonField<String> = JsonMissing.of()
            private var copyrightNotice: JsonField<String> = JsonMissing.of()
            private var copyrightOwnerId: JsonField<MutableList<String>>? = null
            private var copyrightOwnerName: JsonField<MutableList<String>>? = null
            private var country: JsonField<String> = JsonMissing.of()
            private var countryCode: JsonField<String> = JsonMissing.of()
            private var countryPrimaryLocationCode: JsonField<String> = JsonMissing.of()
            private var countryPrimaryLocationName: JsonField<String> = JsonMissing.of()
            private var creator: JsonField<String> = JsonMissing.of()
            private var creatorAddress: JsonField<String> = JsonMissing.of()
            private var creatorCity: JsonField<String> = JsonMissing.of()
            private var creatorCountry: JsonField<String> = JsonMissing.of()
            private var creatorPostalCode: JsonField<String> = JsonMissing.of()
            private var creatorRegion: JsonField<String> = JsonMissing.of()
            private var creatorWorkEmail: JsonField<String> = JsonMissing.of()
            private var creatorWorkTelephone: JsonField<String> = JsonMissing.of()
            private var creatorWorkUrl: JsonField<String> = JsonMissing.of()
            private var credit: JsonField<String> = JsonMissing.of()
            private var dateCreated: JsonField<OffsetDateTime> = JsonMissing.of()
            private var dateTimeCreated: JsonField<OffsetDateTime> = JsonMissing.of()
            private var dateTimeOriginal: JsonField<OffsetDateTime> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var digitalImageGuid: JsonField<String> = JsonMissing.of()
            private var digitalSourceType: JsonField<String> = JsonMissing.of()
            private var embeddedEncodedRightsExpr: JsonField<String> = JsonMissing.of()
            private var embeddedEncodedRightsExprLangId: JsonField<String> = JsonMissing.of()
            private var embeddedEncodedRightsExprType: JsonField<String> = JsonMissing.of()
            private var event: JsonField<String> = JsonMissing.of()
            private var exifVersion: JsonField<String> = JsonMissing.of()
            private var flashpixVersion: JsonField<String> = JsonMissing.of()
            private var genreCvId: JsonField<String> = JsonMissing.of()
            private var genreCvTermId: JsonField<String> = JsonMissing.of()
            private var genreCvTermName: JsonField<String> = JsonMissing.of()
            private var genreCvTermRefinedAbout: JsonField<String> = JsonMissing.of()
            private var headline: JsonField<String> = JsonMissing.of()
            private var imageCreatorId: JsonField<String> = JsonMissing.of()
            private var imageCreatorImageId: JsonField<String> = JsonMissing.of()
            private var imageCreatorName: JsonField<String> = JsonMissing.of()
            private var imageDescription: JsonField<String> = JsonMissing.of()
            private var imageRegionBoundaryH: JsonField<MutableList<Double>>? = null
            private var imageRegionBoundaryRx: JsonField<MutableList<Double>>? = null
            private var imageRegionBoundaryShape: JsonField<MutableList<String>>? = null
            private var imageRegionBoundaryUnit: JsonField<MutableList<String>>? = null
            private var imageRegionBoundaryVerticesX: JsonField<MutableList<Double>>? = null
            private var imageRegionBoundaryVerticesY: JsonField<MutableList<Double>>? = null
            private var imageRegionBoundaryW: JsonField<MutableList<Double>>? = null
            private var imageRegionBoundaryX: JsonField<MutableList<Double>>? = null
            private var imageRegionBoundaryY: JsonField<MutableList<Double>>? = null
            private var imageRegionCtypeIdentifier: JsonField<MutableList<String>>? = null
            private var imageRegionCtypeName: JsonField<MutableList<String>>? = null
            private var imageRegionId: JsonField<MutableList<String>>? = null
            private var imageRegionName: JsonField<MutableList<String>>? = null
            private var imageRegionOrganisationInImageName: JsonField<MutableList<String>>? = null
            private var imageRegionPersonInImage: JsonField<MutableList<String>>? = null
            private var imageRegionRoleIdentifier: JsonField<MutableList<String>>? = null
            private var imageRegionRoleName: JsonField<MutableList<String>>? = null
            private var imageSupplierId: JsonField<String> = JsonMissing.of()
            private var imageSupplierImageId: JsonField<String> = JsonMissing.of()
            private var imageSupplierName: JsonField<String> = JsonMissing.of()
            private var instructions: JsonField<String> = JsonMissing.of()
            private var intellectualGenre: JsonField<String> = JsonMissing.of()
            private var keywords: JsonField<MutableList<String>>? = null
            private var licensorCity: JsonField<MutableList<String>>? = null
            private var licensorCountry: JsonField<MutableList<String>>? = null
            private var licensorEmail: JsonField<MutableList<String>>? = null
            private var licensorExtendedAddress: JsonField<MutableList<String>>? = null
            private var licensorId: JsonField<MutableList<String>>? = null
            private var licensorName: JsonField<MutableList<String>>? = null
            private var licensorPostalCode: JsonField<MutableList<String>>? = null
            private var licensorRegion: JsonField<MutableList<String>>? = null
            private var licensorStreetAddress: JsonField<MutableList<String>>? = null
            private var licensorTelephone1: JsonField<MutableList<String>>? = null
            private var licensorTelephone2: JsonField<MutableList<String>>? = null
            private var licensorUrl: JsonField<MutableList<String>>? = null
            private var linkedEncodedRightsExpr: JsonField<String> = JsonMissing.of()
            private var linkedEncodedRightsExprLangId: JsonField<String> = JsonMissing.of()
            private var linkedEncodedRightsExprType: JsonField<String> = JsonMissing.of()
            private var location: JsonField<String> = JsonMissing.of()
            private var locationCreatedCity: JsonField<String> = JsonMissing.of()
            private var locationCreatedCountryCode: JsonField<String> = JsonMissing.of()
            private var locationCreatedCountryName: JsonField<String> = JsonMissing.of()
            private var locationCreatedGpsAltitude: JsonField<String> = JsonMissing.of()
            private var locationCreatedGpsLatitude: JsonField<String> = JsonMissing.of()
            private var locationCreatedGpsLongitude: JsonField<String> = JsonMissing.of()
            private var locationCreatedLocationId: JsonField<String> = JsonMissing.of()
            private var locationCreatedLocationName: JsonField<String> = JsonMissing.of()
            private var locationCreatedProvinceState: JsonField<String> = JsonMissing.of()
            private var locationCreatedSublocation: JsonField<String> = JsonMissing.of()
            private var locationCreatedWorldRegion: JsonField<String> = JsonMissing.of()
            private var locationShownCity: JsonField<MutableList<String>>? = null
            private var locationShownCountryCode: JsonField<MutableList<String>>? = null
            private var locationShownCountryName: JsonField<MutableList<String>>? = null
            private var locationShownGpsAltitude: JsonField<MutableList<String>>? = null
            private var locationShownGpsLatitude: JsonField<MutableList<String>>? = null
            private var locationShownGpsLongitude: JsonField<MutableList<String>>? = null
            private var locationShownLocationId: JsonField<MutableList<String>>? = null
            private var locationShownLocationName: JsonField<MutableList<String>>? = null
            private var locationShownProvinceState: JsonField<MutableList<String>>? = null
            private var locationShownSublocation: JsonField<MutableList<String>>? = null
            private var locationShownWorldRegion: JsonField<MutableList<String>>? = null
            private var maxAvailHeight: JsonField<Double> = JsonMissing.of()
            private var maxAvailWidth: JsonField<Double> = JsonMissing.of()
            private var modelAge: JsonField<MutableList<Double>>? = null
            private var modelReleaseId: JsonField<MutableList<String>>? = null
            private var objectAttributeReference: JsonField<String> = JsonMissing.of()
            private var objectName: JsonField<String> = JsonMissing.of()
            private var offsetTimeOriginal: JsonField<String> = JsonMissing.of()
            private var organisationInImageCode: JsonField<MutableList<String>>? = null
            private var organisationInImageName: JsonField<MutableList<String>>? = null
            private var orientation: JsonField<String> = JsonMissing.of()
            private var originalTransmissionReference: JsonField<String> = JsonMissing.of()
            private var personInImage: JsonField<MutableList<String>>? = null
            private var personInImageCvTermCvId: JsonField<MutableList<String>>? = null
            private var personInImageCvTermId: JsonField<MutableList<String>>? = null
            private var personInImageCvTermName: JsonField<MutableList<String>>? = null
            private var personInImageCvTermRefinedAbout: JsonField<MutableList<String>>? = null
            private var personInImageDescription: JsonField<MutableList<String>>? = null
            private var personInImageId: JsonField<MutableList<String>>? = null
            private var personInImageName: JsonField<MutableList<String>>? = null
            private var productInImageDescription: JsonField<MutableList<String>>? = null
            private var productInImageGtin: JsonField<MutableList<Double>>? = null
            private var productInImageName: JsonField<MutableList<String>>? = null
            private var propertyReleaseId: JsonField<MutableList<String>>? = null
            private var provinceState: JsonField<String> = JsonMissing.of()
            private var rating: JsonField<Long> = JsonMissing.of()
            private var registryEntryRole: JsonField<MutableList<String>>? = null
            private var registryItemId: JsonField<MutableList<String>>? = null
            private var registryOrganisationId: JsonField<MutableList<String>>? = null
            private var resolutionUnit: JsonField<String> = JsonMissing.of()
            private var rights: JsonField<String> = JsonMissing.of()
            private var scene: JsonField<MutableList<String>>? = null
            private var source: JsonField<String> = JsonMissing.of()
            private var specialInstructions: JsonField<String> = JsonMissing.of()
            private var state: JsonField<String> = JsonMissing.of()
            private var subject: JsonField<MutableList<String>>? = null
            private var subjectCode: JsonField<MutableList<String>>? = null
            private var subjectReference: JsonField<MutableList<String>>? = null
            private var sublocation: JsonField<String> = JsonMissing.of()
            private var timeCreated: JsonField<String> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var transmissionReference: JsonField<String> = JsonMissing.of()
            private var usageTerms: JsonField<String> = JsonMissing.of()
            private var webStatement: JsonField<String> = JsonMissing.of()
            private var writer: JsonField<String> = JsonMissing.of()
            private var writerEditor: JsonField<String> = JsonMissing.of()
            private var xResolution: JsonField<Double> = JsonMissing.of()
            private var yResolution: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(embeddedMetadata: EmbeddedMetadata) = apply {
                aboutCvTermCvId = embeddedMetadata.aboutCvTermCvId
                aboutCvTermId = embeddedMetadata.aboutCvTermId
                aboutCvTermName = embeddedMetadata.aboutCvTermName
                aboutCvTermRefinedAbout = embeddedMetadata.aboutCvTermRefinedAbout
                additionalModelInformation = embeddedMetadata.additionalModelInformation
                applicationRecordVersion = embeddedMetadata.applicationRecordVersion
                artist = embeddedMetadata.artist
                artworkCircaDateCreated = embeddedMetadata.artworkCircaDateCreated
                artworkContentDescription = embeddedMetadata.artworkContentDescription
                artworkContributionDescription = embeddedMetadata.artworkContributionDescription
                artworkCopyrightNotice = embeddedMetadata.artworkCopyrightNotice
                artworkCopyrightOwnerId = embeddedMetadata.artworkCopyrightOwnerId
                artworkCopyrightOwnerName = embeddedMetadata.artworkCopyrightOwnerName
                artworkCreator = embeddedMetadata.artworkCreator.map { it.toMutableList() }
                artworkCreatorId = embeddedMetadata.artworkCreatorId.map { it.toMutableList() }
                artworkDateCreated = embeddedMetadata.artworkDateCreated
                artworkLicensorId = embeddedMetadata.artworkLicensorId
                artworkLicensorName = embeddedMetadata.artworkLicensorName
                artworkPhysicalDescription = embeddedMetadata.artworkPhysicalDescription
                artworkSource = embeddedMetadata.artworkSource
                artworkSourceInventoryNo = embeddedMetadata.artworkSourceInventoryNo
                artworkSourceInvUrl = embeddedMetadata.artworkSourceInvUrl
                artworkStylePeriod = embeddedMetadata.artworkStylePeriod.map { it.toMutableList() }
                artworkTitle = embeddedMetadata.artworkTitle
                authorsPosition = embeddedMetadata.authorsPosition
                byline = embeddedMetadata.byline
                bylineTitle = embeddedMetadata.bylineTitle
                caption = embeddedMetadata.caption
                captionAbstract = embeddedMetadata.captionAbstract
                captionWriter = embeddedMetadata.captionWriter
                city = embeddedMetadata.city
                colorSpace = embeddedMetadata.colorSpace
                componentsConfiguration = embeddedMetadata.componentsConfiguration
                copyright = embeddedMetadata.copyright
                copyrightNotice = embeddedMetadata.copyrightNotice
                copyrightOwnerId = embeddedMetadata.copyrightOwnerId.map { it.toMutableList() }
                copyrightOwnerName = embeddedMetadata.copyrightOwnerName.map { it.toMutableList() }
                country = embeddedMetadata.country
                countryCode = embeddedMetadata.countryCode
                countryPrimaryLocationCode = embeddedMetadata.countryPrimaryLocationCode
                countryPrimaryLocationName = embeddedMetadata.countryPrimaryLocationName
                creator = embeddedMetadata.creator
                creatorAddress = embeddedMetadata.creatorAddress
                creatorCity = embeddedMetadata.creatorCity
                creatorCountry = embeddedMetadata.creatorCountry
                creatorPostalCode = embeddedMetadata.creatorPostalCode
                creatorRegion = embeddedMetadata.creatorRegion
                creatorWorkEmail = embeddedMetadata.creatorWorkEmail
                creatorWorkTelephone = embeddedMetadata.creatorWorkTelephone
                creatorWorkUrl = embeddedMetadata.creatorWorkUrl
                credit = embeddedMetadata.credit
                dateCreated = embeddedMetadata.dateCreated
                dateTimeCreated = embeddedMetadata.dateTimeCreated
                dateTimeOriginal = embeddedMetadata.dateTimeOriginal
                description = embeddedMetadata.description
                digitalImageGuid = embeddedMetadata.digitalImageGuid
                digitalSourceType = embeddedMetadata.digitalSourceType
                embeddedEncodedRightsExpr = embeddedMetadata.embeddedEncodedRightsExpr
                embeddedEncodedRightsExprLangId = embeddedMetadata.embeddedEncodedRightsExprLangId
                embeddedEncodedRightsExprType = embeddedMetadata.embeddedEncodedRightsExprType
                event = embeddedMetadata.event
                exifVersion = embeddedMetadata.exifVersion
                flashpixVersion = embeddedMetadata.flashpixVersion
                genreCvId = embeddedMetadata.genreCvId
                genreCvTermId = embeddedMetadata.genreCvTermId
                genreCvTermName = embeddedMetadata.genreCvTermName
                genreCvTermRefinedAbout = embeddedMetadata.genreCvTermRefinedAbout
                headline = embeddedMetadata.headline
                imageCreatorId = embeddedMetadata.imageCreatorId
                imageCreatorImageId = embeddedMetadata.imageCreatorImageId
                imageCreatorName = embeddedMetadata.imageCreatorName
                imageDescription = embeddedMetadata.imageDescription
                imageRegionBoundaryH =
                    embeddedMetadata.imageRegionBoundaryH.map { it.toMutableList() }
                imageRegionBoundaryRx =
                    embeddedMetadata.imageRegionBoundaryRx.map { it.toMutableList() }
                imageRegionBoundaryShape =
                    embeddedMetadata.imageRegionBoundaryShape.map { it.toMutableList() }
                imageRegionBoundaryUnit =
                    embeddedMetadata.imageRegionBoundaryUnit.map { it.toMutableList() }
                imageRegionBoundaryVerticesX =
                    embeddedMetadata.imageRegionBoundaryVerticesX.map { it.toMutableList() }
                imageRegionBoundaryVerticesY =
                    embeddedMetadata.imageRegionBoundaryVerticesY.map { it.toMutableList() }
                imageRegionBoundaryW =
                    embeddedMetadata.imageRegionBoundaryW.map { it.toMutableList() }
                imageRegionBoundaryX =
                    embeddedMetadata.imageRegionBoundaryX.map { it.toMutableList() }
                imageRegionBoundaryY =
                    embeddedMetadata.imageRegionBoundaryY.map { it.toMutableList() }
                imageRegionCtypeIdentifier =
                    embeddedMetadata.imageRegionCtypeIdentifier.map { it.toMutableList() }
                imageRegionCtypeName =
                    embeddedMetadata.imageRegionCtypeName.map { it.toMutableList() }
                imageRegionId = embeddedMetadata.imageRegionId.map { it.toMutableList() }
                imageRegionName = embeddedMetadata.imageRegionName.map { it.toMutableList() }
                imageRegionOrganisationInImageName =
                    embeddedMetadata.imageRegionOrganisationInImageName.map { it.toMutableList() }
                imageRegionPersonInImage =
                    embeddedMetadata.imageRegionPersonInImage.map { it.toMutableList() }
                imageRegionRoleIdentifier =
                    embeddedMetadata.imageRegionRoleIdentifier.map { it.toMutableList() }
                imageRegionRoleName =
                    embeddedMetadata.imageRegionRoleName.map { it.toMutableList() }
                imageSupplierId = embeddedMetadata.imageSupplierId
                imageSupplierImageId = embeddedMetadata.imageSupplierImageId
                imageSupplierName = embeddedMetadata.imageSupplierName
                instructions = embeddedMetadata.instructions
                intellectualGenre = embeddedMetadata.intellectualGenre
                keywords = embeddedMetadata.keywords.map { it.toMutableList() }
                licensorCity = embeddedMetadata.licensorCity.map { it.toMutableList() }
                licensorCountry = embeddedMetadata.licensorCountry.map { it.toMutableList() }
                licensorEmail = embeddedMetadata.licensorEmail.map { it.toMutableList() }
                licensorExtendedAddress =
                    embeddedMetadata.licensorExtendedAddress.map { it.toMutableList() }
                licensorId = embeddedMetadata.licensorId.map { it.toMutableList() }
                licensorName = embeddedMetadata.licensorName.map { it.toMutableList() }
                licensorPostalCode = embeddedMetadata.licensorPostalCode.map { it.toMutableList() }
                licensorRegion = embeddedMetadata.licensorRegion.map { it.toMutableList() }
                licensorStreetAddress =
                    embeddedMetadata.licensorStreetAddress.map { it.toMutableList() }
                licensorTelephone1 = embeddedMetadata.licensorTelephone1.map { it.toMutableList() }
                licensorTelephone2 = embeddedMetadata.licensorTelephone2.map { it.toMutableList() }
                licensorUrl = embeddedMetadata.licensorUrl.map { it.toMutableList() }
                linkedEncodedRightsExpr = embeddedMetadata.linkedEncodedRightsExpr
                linkedEncodedRightsExprLangId = embeddedMetadata.linkedEncodedRightsExprLangId
                linkedEncodedRightsExprType = embeddedMetadata.linkedEncodedRightsExprType
                location = embeddedMetadata.location
                locationCreatedCity = embeddedMetadata.locationCreatedCity
                locationCreatedCountryCode = embeddedMetadata.locationCreatedCountryCode
                locationCreatedCountryName = embeddedMetadata.locationCreatedCountryName
                locationCreatedGpsAltitude = embeddedMetadata.locationCreatedGpsAltitude
                locationCreatedGpsLatitude = embeddedMetadata.locationCreatedGpsLatitude
                locationCreatedGpsLongitude = embeddedMetadata.locationCreatedGpsLongitude
                locationCreatedLocationId = embeddedMetadata.locationCreatedLocationId
                locationCreatedLocationName = embeddedMetadata.locationCreatedLocationName
                locationCreatedProvinceState = embeddedMetadata.locationCreatedProvinceState
                locationCreatedSublocation = embeddedMetadata.locationCreatedSublocation
                locationCreatedWorldRegion = embeddedMetadata.locationCreatedWorldRegion
                locationShownCity = embeddedMetadata.locationShownCity.map { it.toMutableList() }
                locationShownCountryCode =
                    embeddedMetadata.locationShownCountryCode.map { it.toMutableList() }
                locationShownCountryName =
                    embeddedMetadata.locationShownCountryName.map { it.toMutableList() }
                locationShownGpsAltitude =
                    embeddedMetadata.locationShownGpsAltitude.map { it.toMutableList() }
                locationShownGpsLatitude =
                    embeddedMetadata.locationShownGpsLatitude.map { it.toMutableList() }
                locationShownGpsLongitude =
                    embeddedMetadata.locationShownGpsLongitude.map { it.toMutableList() }
                locationShownLocationId =
                    embeddedMetadata.locationShownLocationId.map { it.toMutableList() }
                locationShownLocationName =
                    embeddedMetadata.locationShownLocationName.map { it.toMutableList() }
                locationShownProvinceState =
                    embeddedMetadata.locationShownProvinceState.map { it.toMutableList() }
                locationShownSublocation =
                    embeddedMetadata.locationShownSublocation.map { it.toMutableList() }
                locationShownWorldRegion =
                    embeddedMetadata.locationShownWorldRegion.map { it.toMutableList() }
                maxAvailHeight = embeddedMetadata.maxAvailHeight
                maxAvailWidth = embeddedMetadata.maxAvailWidth
                modelAge = embeddedMetadata.modelAge.map { it.toMutableList() }
                modelReleaseId = embeddedMetadata.modelReleaseId.map { it.toMutableList() }
                objectAttributeReference = embeddedMetadata.objectAttributeReference
                objectName = embeddedMetadata.objectName
                offsetTimeOriginal = embeddedMetadata.offsetTimeOriginal
                organisationInImageCode =
                    embeddedMetadata.organisationInImageCode.map { it.toMutableList() }
                organisationInImageName =
                    embeddedMetadata.organisationInImageName.map { it.toMutableList() }
                orientation = embeddedMetadata.orientation
                originalTransmissionReference = embeddedMetadata.originalTransmissionReference
                personInImage = embeddedMetadata.personInImage.map { it.toMutableList() }
                personInImageCvTermCvId =
                    embeddedMetadata.personInImageCvTermCvId.map { it.toMutableList() }
                personInImageCvTermId =
                    embeddedMetadata.personInImageCvTermId.map { it.toMutableList() }
                personInImageCvTermName =
                    embeddedMetadata.personInImageCvTermName.map { it.toMutableList() }
                personInImageCvTermRefinedAbout =
                    embeddedMetadata.personInImageCvTermRefinedAbout.map { it.toMutableList() }
                personInImageDescription =
                    embeddedMetadata.personInImageDescription.map { it.toMutableList() }
                personInImageId = embeddedMetadata.personInImageId.map { it.toMutableList() }
                personInImageName = embeddedMetadata.personInImageName.map { it.toMutableList() }
                productInImageDescription =
                    embeddedMetadata.productInImageDescription.map { it.toMutableList() }
                productInImageGtin = embeddedMetadata.productInImageGtin.map { it.toMutableList() }
                productInImageName = embeddedMetadata.productInImageName.map { it.toMutableList() }
                propertyReleaseId = embeddedMetadata.propertyReleaseId.map { it.toMutableList() }
                provinceState = embeddedMetadata.provinceState
                rating = embeddedMetadata.rating
                registryEntryRole = embeddedMetadata.registryEntryRole.map { it.toMutableList() }
                registryItemId = embeddedMetadata.registryItemId.map { it.toMutableList() }
                registryOrganisationId =
                    embeddedMetadata.registryOrganisationId.map { it.toMutableList() }
                resolutionUnit = embeddedMetadata.resolutionUnit
                rights = embeddedMetadata.rights
                scene = embeddedMetadata.scene.map { it.toMutableList() }
                source = embeddedMetadata.source
                specialInstructions = embeddedMetadata.specialInstructions
                state = embeddedMetadata.state
                subject = embeddedMetadata.subject.map { it.toMutableList() }
                subjectCode = embeddedMetadata.subjectCode.map { it.toMutableList() }
                subjectReference = embeddedMetadata.subjectReference.map { it.toMutableList() }
                sublocation = embeddedMetadata.sublocation
                timeCreated = embeddedMetadata.timeCreated
                title = embeddedMetadata.title
                transmissionReference = embeddedMetadata.transmissionReference
                usageTerms = embeddedMetadata.usageTerms
                webStatement = embeddedMetadata.webStatement
                writer = embeddedMetadata.writer
                writerEditor = embeddedMetadata.writerEditor
                xResolution = embeddedMetadata.xResolution
                yResolution = embeddedMetadata.yResolution
                additionalProperties = embeddedMetadata.additionalProperties.toMutableMap()
            }

            fun aboutCvTermCvId(aboutCvTermCvId: String) =
                aboutCvTermCvId(JsonField.of(aboutCvTermCvId))

            /**
             * Sets [Builder.aboutCvTermCvId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.aboutCvTermCvId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun aboutCvTermCvId(aboutCvTermCvId: JsonField<String>) = apply {
                this.aboutCvTermCvId = aboutCvTermCvId
            }

            fun aboutCvTermId(aboutCvTermId: String) = aboutCvTermId(JsonField.of(aboutCvTermId))

            /**
             * Sets [Builder.aboutCvTermId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.aboutCvTermId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun aboutCvTermId(aboutCvTermId: JsonField<String>) = apply {
                this.aboutCvTermId = aboutCvTermId
            }

            fun aboutCvTermName(aboutCvTermName: String) =
                aboutCvTermName(JsonField.of(aboutCvTermName))

            /**
             * Sets [Builder.aboutCvTermName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.aboutCvTermName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun aboutCvTermName(aboutCvTermName: JsonField<String>) = apply {
                this.aboutCvTermName = aboutCvTermName
            }

            fun aboutCvTermRefinedAbout(aboutCvTermRefinedAbout: String) =
                aboutCvTermRefinedAbout(JsonField.of(aboutCvTermRefinedAbout))

            /**
             * Sets [Builder.aboutCvTermRefinedAbout] to an arbitrary JSON value.
             *
             * You should usually call [Builder.aboutCvTermRefinedAbout] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun aboutCvTermRefinedAbout(aboutCvTermRefinedAbout: JsonField<String>) = apply {
                this.aboutCvTermRefinedAbout = aboutCvTermRefinedAbout
            }

            fun additionalModelInformation(additionalModelInformation: String) =
                additionalModelInformation(JsonField.of(additionalModelInformation))

            /**
             * Sets [Builder.additionalModelInformation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.additionalModelInformation] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun additionalModelInformation(additionalModelInformation: JsonField<String>) = apply {
                this.additionalModelInformation = additionalModelInformation
            }

            fun applicationRecordVersion(applicationRecordVersion: Long) =
                applicationRecordVersion(JsonField.of(applicationRecordVersion))

            /**
             * Sets [Builder.applicationRecordVersion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.applicationRecordVersion] with a well-typed [Long]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun applicationRecordVersion(applicationRecordVersion: JsonField<Long>) = apply {
                this.applicationRecordVersion = applicationRecordVersion
            }

            fun artist(artist: String) = artist(JsonField.of(artist))

            /**
             * Sets [Builder.artist] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artist] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun artist(artist: JsonField<String>) = apply { this.artist = artist }

            fun artworkCircaDateCreated(artworkCircaDateCreated: String) =
                artworkCircaDateCreated(JsonField.of(artworkCircaDateCreated))

            /**
             * Sets [Builder.artworkCircaDateCreated] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkCircaDateCreated] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun artworkCircaDateCreated(artworkCircaDateCreated: JsonField<String>) = apply {
                this.artworkCircaDateCreated = artworkCircaDateCreated
            }

            fun artworkContentDescription(artworkContentDescription: String) =
                artworkContentDescription(JsonField.of(artworkContentDescription))

            /**
             * Sets [Builder.artworkContentDescription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkContentDescription] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun artworkContentDescription(artworkContentDescription: JsonField<String>) = apply {
                this.artworkContentDescription = artworkContentDescription
            }

            fun artworkContributionDescription(artworkContributionDescription: String) =
                artworkContributionDescription(JsonField.of(artworkContributionDescription))

            /**
             * Sets [Builder.artworkContributionDescription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkContributionDescription] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun artworkContributionDescription(artworkContributionDescription: JsonField<String>) =
                apply {
                    this.artworkContributionDescription = artworkContributionDescription
                }

            fun artworkCopyrightNotice(artworkCopyrightNotice: String) =
                artworkCopyrightNotice(JsonField.of(artworkCopyrightNotice))

            /**
             * Sets [Builder.artworkCopyrightNotice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkCopyrightNotice] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun artworkCopyrightNotice(artworkCopyrightNotice: JsonField<String>) = apply {
                this.artworkCopyrightNotice = artworkCopyrightNotice
            }

            fun artworkCopyrightOwnerId(artworkCopyrightOwnerId: String) =
                artworkCopyrightOwnerId(JsonField.of(artworkCopyrightOwnerId))

            /**
             * Sets [Builder.artworkCopyrightOwnerId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkCopyrightOwnerId] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun artworkCopyrightOwnerId(artworkCopyrightOwnerId: JsonField<String>) = apply {
                this.artworkCopyrightOwnerId = artworkCopyrightOwnerId
            }

            fun artworkCopyrightOwnerName(artworkCopyrightOwnerName: String) =
                artworkCopyrightOwnerName(JsonField.of(artworkCopyrightOwnerName))

            /**
             * Sets [Builder.artworkCopyrightOwnerName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkCopyrightOwnerName] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun artworkCopyrightOwnerName(artworkCopyrightOwnerName: JsonField<String>) = apply {
                this.artworkCopyrightOwnerName = artworkCopyrightOwnerName
            }

            fun artworkCreator(artworkCreator: List<String>) =
                artworkCreator(JsonField.of(artworkCreator))

            /**
             * Sets [Builder.artworkCreator] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkCreator] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun artworkCreator(artworkCreator: JsonField<List<String>>) = apply {
                this.artworkCreator = artworkCreator.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.artworkCreator].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addArtworkCreator(artworkCreator: String) = apply {
                this.artworkCreator =
                    (this.artworkCreator ?: JsonField.of(mutableListOf())).also {
                        checkKnown("artworkCreator", it).add(artworkCreator)
                    }
            }

            fun artworkCreatorId(artworkCreatorId: List<String>) =
                artworkCreatorId(JsonField.of(artworkCreatorId))

            /**
             * Sets [Builder.artworkCreatorId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkCreatorId] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun artworkCreatorId(artworkCreatorId: JsonField<List<String>>) = apply {
                this.artworkCreatorId = artworkCreatorId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.artworkCreatorId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addArtworkCreatorId(artworkCreatorId: String) = apply {
                this.artworkCreatorId =
                    (this.artworkCreatorId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("artworkCreatorId", it).add(artworkCreatorId)
                    }
            }

            fun artworkDateCreated(artworkDateCreated: OffsetDateTime) =
                artworkDateCreated(JsonField.of(artworkDateCreated))

            /**
             * Sets [Builder.artworkDateCreated] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkDateCreated] with a well-typed
             * [OffsetDateTime] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun artworkDateCreated(artworkDateCreated: JsonField<OffsetDateTime>) = apply {
                this.artworkDateCreated = artworkDateCreated
            }

            fun artworkLicensorId(artworkLicensorId: String) =
                artworkLicensorId(JsonField.of(artworkLicensorId))

            /**
             * Sets [Builder.artworkLicensorId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkLicensorId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun artworkLicensorId(artworkLicensorId: JsonField<String>) = apply {
                this.artworkLicensorId = artworkLicensorId
            }

            fun artworkLicensorName(artworkLicensorName: String) =
                artworkLicensorName(JsonField.of(artworkLicensorName))

            /**
             * Sets [Builder.artworkLicensorName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkLicensorName] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun artworkLicensorName(artworkLicensorName: JsonField<String>) = apply {
                this.artworkLicensorName = artworkLicensorName
            }

            fun artworkPhysicalDescription(artworkPhysicalDescription: String) =
                artworkPhysicalDescription(JsonField.of(artworkPhysicalDescription))

            /**
             * Sets [Builder.artworkPhysicalDescription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkPhysicalDescription] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun artworkPhysicalDescription(artworkPhysicalDescription: JsonField<String>) = apply {
                this.artworkPhysicalDescription = artworkPhysicalDescription
            }

            fun artworkSource(artworkSource: String) = artworkSource(JsonField.of(artworkSource))

            /**
             * Sets [Builder.artworkSource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkSource] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun artworkSource(artworkSource: JsonField<String>) = apply {
                this.artworkSource = artworkSource
            }

            fun artworkSourceInventoryNo(artworkSourceInventoryNo: String) =
                artworkSourceInventoryNo(JsonField.of(artworkSourceInventoryNo))

            /**
             * Sets [Builder.artworkSourceInventoryNo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkSourceInventoryNo] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun artworkSourceInventoryNo(artworkSourceInventoryNo: JsonField<String>) = apply {
                this.artworkSourceInventoryNo = artworkSourceInventoryNo
            }

            fun artworkSourceInvUrl(artworkSourceInvUrl: String) =
                artworkSourceInvUrl(JsonField.of(artworkSourceInvUrl))

            /**
             * Sets [Builder.artworkSourceInvUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkSourceInvUrl] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun artworkSourceInvUrl(artworkSourceInvUrl: JsonField<String>) = apply {
                this.artworkSourceInvUrl = artworkSourceInvUrl
            }

            fun artworkStylePeriod(artworkStylePeriod: List<String>) =
                artworkStylePeriod(JsonField.of(artworkStylePeriod))

            /**
             * Sets [Builder.artworkStylePeriod] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkStylePeriod] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun artworkStylePeriod(artworkStylePeriod: JsonField<List<String>>) = apply {
                this.artworkStylePeriod = artworkStylePeriod.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.artworkStylePeriod].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addArtworkStylePeriod(artworkStylePeriod: String) = apply {
                this.artworkStylePeriod =
                    (this.artworkStylePeriod ?: JsonField.of(mutableListOf())).also {
                        checkKnown("artworkStylePeriod", it).add(artworkStylePeriod)
                    }
            }

            fun artworkTitle(artworkTitle: String) = artworkTitle(JsonField.of(artworkTitle))

            /**
             * Sets [Builder.artworkTitle] to an arbitrary JSON value.
             *
             * You should usually call [Builder.artworkTitle] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun artworkTitle(artworkTitle: JsonField<String>) = apply {
                this.artworkTitle = artworkTitle
            }

            fun authorsPosition(authorsPosition: String) =
                authorsPosition(JsonField.of(authorsPosition))

            /**
             * Sets [Builder.authorsPosition] to an arbitrary JSON value.
             *
             * You should usually call [Builder.authorsPosition] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun authorsPosition(authorsPosition: JsonField<String>) = apply {
                this.authorsPosition = authorsPosition
            }

            fun byline(byline: String) = byline(JsonField.of(byline))

            /**
             * Sets [Builder.byline] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byline] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun byline(byline: JsonField<String>) = apply { this.byline = byline }

            fun bylineTitle(bylineTitle: String) = bylineTitle(JsonField.of(bylineTitle))

            /**
             * Sets [Builder.bylineTitle] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bylineTitle] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bylineTitle(bylineTitle: JsonField<String>) = apply {
                this.bylineTitle = bylineTitle
            }

            fun caption(caption: String) = caption(JsonField.of(caption))

            /**
             * Sets [Builder.caption] to an arbitrary JSON value.
             *
             * You should usually call [Builder.caption] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun caption(caption: JsonField<String>) = apply { this.caption = caption }

            fun captionAbstract(captionAbstract: String) =
                captionAbstract(JsonField.of(captionAbstract))

            /**
             * Sets [Builder.captionAbstract] to an arbitrary JSON value.
             *
             * You should usually call [Builder.captionAbstract] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun captionAbstract(captionAbstract: JsonField<String>) = apply {
                this.captionAbstract = captionAbstract
            }

            fun captionWriter(captionWriter: String) = captionWriter(JsonField.of(captionWriter))

            /**
             * Sets [Builder.captionWriter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.captionWriter] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun captionWriter(captionWriter: JsonField<String>) = apply {
                this.captionWriter = captionWriter
            }

            fun city(city: String) = city(JsonField.of(city))

            /**
             * Sets [Builder.city] to an arbitrary JSON value.
             *
             * You should usually call [Builder.city] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun city(city: JsonField<String>) = apply { this.city = city }

            fun colorSpace(colorSpace: String) = colorSpace(JsonField.of(colorSpace))

            /**
             * Sets [Builder.colorSpace] to an arbitrary JSON value.
             *
             * You should usually call [Builder.colorSpace] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun colorSpace(colorSpace: JsonField<String>) = apply { this.colorSpace = colorSpace }

            fun componentsConfiguration(componentsConfiguration: String) =
                componentsConfiguration(JsonField.of(componentsConfiguration))

            /**
             * Sets [Builder.componentsConfiguration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.componentsConfiguration] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun componentsConfiguration(componentsConfiguration: JsonField<String>) = apply {
                this.componentsConfiguration = componentsConfiguration
            }

            fun copyright(copyright: String) = copyright(JsonField.of(copyright))

            /**
             * Sets [Builder.copyright] to an arbitrary JSON value.
             *
             * You should usually call [Builder.copyright] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun copyright(copyright: JsonField<String>) = apply { this.copyright = copyright }

            fun copyrightNotice(copyrightNotice: String) =
                copyrightNotice(JsonField.of(copyrightNotice))

            /**
             * Sets [Builder.copyrightNotice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.copyrightNotice] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun copyrightNotice(copyrightNotice: JsonField<String>) = apply {
                this.copyrightNotice = copyrightNotice
            }

            fun copyrightOwnerId(copyrightOwnerId: List<String>) =
                copyrightOwnerId(JsonField.of(copyrightOwnerId))

            /**
             * Sets [Builder.copyrightOwnerId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.copyrightOwnerId] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun copyrightOwnerId(copyrightOwnerId: JsonField<List<String>>) = apply {
                this.copyrightOwnerId = copyrightOwnerId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.copyrightOwnerId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCopyrightOwnerId(copyrightOwnerId: String) = apply {
                this.copyrightOwnerId =
                    (this.copyrightOwnerId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("copyrightOwnerId", it).add(copyrightOwnerId)
                    }
            }

            fun copyrightOwnerName(copyrightOwnerName: List<String>) =
                copyrightOwnerName(JsonField.of(copyrightOwnerName))

            /**
             * Sets [Builder.copyrightOwnerName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.copyrightOwnerName] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun copyrightOwnerName(copyrightOwnerName: JsonField<List<String>>) = apply {
                this.copyrightOwnerName = copyrightOwnerName.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.copyrightOwnerName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCopyrightOwnerName(copyrightOwnerName: String) = apply {
                this.copyrightOwnerName =
                    (this.copyrightOwnerName ?: JsonField.of(mutableListOf())).also {
                        checkKnown("copyrightOwnerName", it).add(copyrightOwnerName)
                    }
            }

            fun country(country: String) = country(JsonField.of(country))

            /**
             * Sets [Builder.country] to an arbitrary JSON value.
             *
             * You should usually call [Builder.country] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun country(country: JsonField<String>) = apply { this.country = country }

            fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

            /**
             * Sets [Builder.countryCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.countryCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun countryCode(countryCode: JsonField<String>) = apply {
                this.countryCode = countryCode
            }

            fun countryPrimaryLocationCode(countryPrimaryLocationCode: String) =
                countryPrimaryLocationCode(JsonField.of(countryPrimaryLocationCode))

            /**
             * Sets [Builder.countryPrimaryLocationCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.countryPrimaryLocationCode] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun countryPrimaryLocationCode(countryPrimaryLocationCode: JsonField<String>) = apply {
                this.countryPrimaryLocationCode = countryPrimaryLocationCode
            }

            fun countryPrimaryLocationName(countryPrimaryLocationName: String) =
                countryPrimaryLocationName(JsonField.of(countryPrimaryLocationName))

            /**
             * Sets [Builder.countryPrimaryLocationName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.countryPrimaryLocationName] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun countryPrimaryLocationName(countryPrimaryLocationName: JsonField<String>) = apply {
                this.countryPrimaryLocationName = countryPrimaryLocationName
            }

            fun creator(creator: String) = creator(JsonField.of(creator))

            /**
             * Sets [Builder.creator] to an arbitrary JSON value.
             *
             * You should usually call [Builder.creator] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun creator(creator: JsonField<String>) = apply { this.creator = creator }

            fun creatorAddress(creatorAddress: String) =
                creatorAddress(JsonField.of(creatorAddress))

            /**
             * Sets [Builder.creatorAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.creatorAddress] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun creatorAddress(creatorAddress: JsonField<String>) = apply {
                this.creatorAddress = creatorAddress
            }

            fun creatorCity(creatorCity: String) = creatorCity(JsonField.of(creatorCity))

            /**
             * Sets [Builder.creatorCity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.creatorCity] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun creatorCity(creatorCity: JsonField<String>) = apply {
                this.creatorCity = creatorCity
            }

            fun creatorCountry(creatorCountry: String) =
                creatorCountry(JsonField.of(creatorCountry))

            /**
             * Sets [Builder.creatorCountry] to an arbitrary JSON value.
             *
             * You should usually call [Builder.creatorCountry] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun creatorCountry(creatorCountry: JsonField<String>) = apply {
                this.creatorCountry = creatorCountry
            }

            fun creatorPostalCode(creatorPostalCode: String) =
                creatorPostalCode(JsonField.of(creatorPostalCode))

            /**
             * Sets [Builder.creatorPostalCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.creatorPostalCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun creatorPostalCode(creatorPostalCode: JsonField<String>) = apply {
                this.creatorPostalCode = creatorPostalCode
            }

            fun creatorRegion(creatorRegion: String) = creatorRegion(JsonField.of(creatorRegion))

            /**
             * Sets [Builder.creatorRegion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.creatorRegion] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun creatorRegion(creatorRegion: JsonField<String>) = apply {
                this.creatorRegion = creatorRegion
            }

            fun creatorWorkEmail(creatorWorkEmail: String) =
                creatorWorkEmail(JsonField.of(creatorWorkEmail))

            /**
             * Sets [Builder.creatorWorkEmail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.creatorWorkEmail] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun creatorWorkEmail(creatorWorkEmail: JsonField<String>) = apply {
                this.creatorWorkEmail = creatorWorkEmail
            }

            fun creatorWorkTelephone(creatorWorkTelephone: String) =
                creatorWorkTelephone(JsonField.of(creatorWorkTelephone))

            /**
             * Sets [Builder.creatorWorkTelephone] to an arbitrary JSON value.
             *
             * You should usually call [Builder.creatorWorkTelephone] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun creatorWorkTelephone(creatorWorkTelephone: JsonField<String>) = apply {
                this.creatorWorkTelephone = creatorWorkTelephone
            }

            fun creatorWorkUrl(creatorWorkUrl: String) =
                creatorWorkUrl(JsonField.of(creatorWorkUrl))

            /**
             * Sets [Builder.creatorWorkUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.creatorWorkUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun creatorWorkUrl(creatorWorkUrl: JsonField<String>) = apply {
                this.creatorWorkUrl = creatorWorkUrl
            }

            fun credit(credit: String) = credit(JsonField.of(credit))

            /**
             * Sets [Builder.credit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.credit] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun credit(credit: JsonField<String>) = apply { this.credit = credit }

            fun dateCreated(dateCreated: OffsetDateTime) = dateCreated(JsonField.of(dateCreated))

            /**
             * Sets [Builder.dateCreated] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dateCreated] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun dateCreated(dateCreated: JsonField<OffsetDateTime>) = apply {
                this.dateCreated = dateCreated
            }

            fun dateTimeCreated(dateTimeCreated: OffsetDateTime) =
                dateTimeCreated(JsonField.of(dateTimeCreated))

            /**
             * Sets [Builder.dateTimeCreated] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dateTimeCreated] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun dateTimeCreated(dateTimeCreated: JsonField<OffsetDateTime>) = apply {
                this.dateTimeCreated = dateTimeCreated
            }

            fun dateTimeOriginal(dateTimeOriginal: OffsetDateTime) =
                dateTimeOriginal(JsonField.of(dateTimeOriginal))

            /**
             * Sets [Builder.dateTimeOriginal] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dateTimeOriginal] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun dateTimeOriginal(dateTimeOriginal: JsonField<OffsetDateTime>) = apply {
                this.dateTimeOriginal = dateTimeOriginal
            }

            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            fun digitalImageGuid(digitalImageGuid: String) =
                digitalImageGuid(JsonField.of(digitalImageGuid))

            /**
             * Sets [Builder.digitalImageGuid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.digitalImageGuid] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun digitalImageGuid(digitalImageGuid: JsonField<String>) = apply {
                this.digitalImageGuid = digitalImageGuid
            }

            fun digitalSourceType(digitalSourceType: String) =
                digitalSourceType(JsonField.of(digitalSourceType))

            /**
             * Sets [Builder.digitalSourceType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.digitalSourceType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun digitalSourceType(digitalSourceType: JsonField<String>) = apply {
                this.digitalSourceType = digitalSourceType
            }

            fun embeddedEncodedRightsExpr(embeddedEncodedRightsExpr: String) =
                embeddedEncodedRightsExpr(JsonField.of(embeddedEncodedRightsExpr))

            /**
             * Sets [Builder.embeddedEncodedRightsExpr] to an arbitrary JSON value.
             *
             * You should usually call [Builder.embeddedEncodedRightsExpr] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun embeddedEncodedRightsExpr(embeddedEncodedRightsExpr: JsonField<String>) = apply {
                this.embeddedEncodedRightsExpr = embeddedEncodedRightsExpr
            }

            fun embeddedEncodedRightsExprLangId(embeddedEncodedRightsExprLangId: String) =
                embeddedEncodedRightsExprLangId(JsonField.of(embeddedEncodedRightsExprLangId))

            /**
             * Sets [Builder.embeddedEncodedRightsExprLangId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.embeddedEncodedRightsExprLangId] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun embeddedEncodedRightsExprLangId(
                embeddedEncodedRightsExprLangId: JsonField<String>
            ) = apply { this.embeddedEncodedRightsExprLangId = embeddedEncodedRightsExprLangId }

            fun embeddedEncodedRightsExprType(embeddedEncodedRightsExprType: String) =
                embeddedEncodedRightsExprType(JsonField.of(embeddedEncodedRightsExprType))

            /**
             * Sets [Builder.embeddedEncodedRightsExprType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.embeddedEncodedRightsExprType] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun embeddedEncodedRightsExprType(embeddedEncodedRightsExprType: JsonField<String>) =
                apply {
                    this.embeddedEncodedRightsExprType = embeddedEncodedRightsExprType
                }

            fun event(event: String) = event(JsonField.of(event))

            /**
             * Sets [Builder.event] to an arbitrary JSON value.
             *
             * You should usually call [Builder.event] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun event(event: JsonField<String>) = apply { this.event = event }

            fun exifVersion(exifVersion: String) = exifVersion(JsonField.of(exifVersion))

            /**
             * Sets [Builder.exifVersion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.exifVersion] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun exifVersion(exifVersion: JsonField<String>) = apply {
                this.exifVersion = exifVersion
            }

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

            fun genreCvId(genreCvId: String) = genreCvId(JsonField.of(genreCvId))

            /**
             * Sets [Builder.genreCvId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.genreCvId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun genreCvId(genreCvId: JsonField<String>) = apply { this.genreCvId = genreCvId }

            fun genreCvTermId(genreCvTermId: String) = genreCvTermId(JsonField.of(genreCvTermId))

            /**
             * Sets [Builder.genreCvTermId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.genreCvTermId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun genreCvTermId(genreCvTermId: JsonField<String>) = apply {
                this.genreCvTermId = genreCvTermId
            }

            fun genreCvTermName(genreCvTermName: String) =
                genreCvTermName(JsonField.of(genreCvTermName))

            /**
             * Sets [Builder.genreCvTermName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.genreCvTermName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun genreCvTermName(genreCvTermName: JsonField<String>) = apply {
                this.genreCvTermName = genreCvTermName
            }

            fun genreCvTermRefinedAbout(genreCvTermRefinedAbout: String) =
                genreCvTermRefinedAbout(JsonField.of(genreCvTermRefinedAbout))

            /**
             * Sets [Builder.genreCvTermRefinedAbout] to an arbitrary JSON value.
             *
             * You should usually call [Builder.genreCvTermRefinedAbout] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun genreCvTermRefinedAbout(genreCvTermRefinedAbout: JsonField<String>) = apply {
                this.genreCvTermRefinedAbout = genreCvTermRefinedAbout
            }

            fun headline(headline: String) = headline(JsonField.of(headline))

            /**
             * Sets [Builder.headline] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headline] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headline(headline: JsonField<String>) = apply { this.headline = headline }

            fun imageCreatorId(imageCreatorId: String) =
                imageCreatorId(JsonField.of(imageCreatorId))

            /**
             * Sets [Builder.imageCreatorId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageCreatorId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun imageCreatorId(imageCreatorId: JsonField<String>) = apply {
                this.imageCreatorId = imageCreatorId
            }

            fun imageCreatorImageId(imageCreatorImageId: String) =
                imageCreatorImageId(JsonField.of(imageCreatorImageId))

            /**
             * Sets [Builder.imageCreatorImageId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageCreatorImageId] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun imageCreatorImageId(imageCreatorImageId: JsonField<String>) = apply {
                this.imageCreatorImageId = imageCreatorImageId
            }

            fun imageCreatorName(imageCreatorName: String) =
                imageCreatorName(JsonField.of(imageCreatorName))

            /**
             * Sets [Builder.imageCreatorName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageCreatorName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun imageCreatorName(imageCreatorName: JsonField<String>) = apply {
                this.imageCreatorName = imageCreatorName
            }

            fun imageDescription(imageDescription: String) =
                imageDescription(JsonField.of(imageDescription))

            /**
             * Sets [Builder.imageDescription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageDescription] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun imageDescription(imageDescription: JsonField<String>) = apply {
                this.imageDescription = imageDescription
            }

            fun imageRegionBoundaryH(imageRegionBoundaryH: List<Double>) =
                imageRegionBoundaryH(JsonField.of(imageRegionBoundaryH))

            /**
             * Sets [Builder.imageRegionBoundaryH] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionBoundaryH] with a well-typed
             * `List<Double>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionBoundaryH(imageRegionBoundaryH: JsonField<List<Double>>) = apply {
                this.imageRegionBoundaryH = imageRegionBoundaryH.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [Builder.imageRegionBoundaryH].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionBoundaryH(imageRegionBoundaryH: Double) = apply {
                this.imageRegionBoundaryH =
                    (this.imageRegionBoundaryH ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionBoundaryH", it).add(imageRegionBoundaryH)
                    }
            }

            fun imageRegionBoundaryRx(imageRegionBoundaryRx: List<Double>) =
                imageRegionBoundaryRx(JsonField.of(imageRegionBoundaryRx))

            /**
             * Sets [Builder.imageRegionBoundaryRx] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionBoundaryRx] with a well-typed
             * `List<Double>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionBoundaryRx(imageRegionBoundaryRx: JsonField<List<Double>>) = apply {
                this.imageRegionBoundaryRx = imageRegionBoundaryRx.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [Builder.imageRegionBoundaryRx].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionBoundaryRx(imageRegionBoundaryRx: Double) = apply {
                this.imageRegionBoundaryRx =
                    (this.imageRegionBoundaryRx ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionBoundaryRx", it).add(imageRegionBoundaryRx)
                    }
            }

            fun imageRegionBoundaryShape(imageRegionBoundaryShape: List<String>) =
                imageRegionBoundaryShape(JsonField.of(imageRegionBoundaryShape))

            /**
             * Sets [Builder.imageRegionBoundaryShape] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionBoundaryShape] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionBoundaryShape(imageRegionBoundaryShape: JsonField<List<String>>) =
                apply {
                    this.imageRegionBoundaryShape =
                        imageRegionBoundaryShape.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.imageRegionBoundaryShape].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionBoundaryShape(imageRegionBoundaryShape: String) = apply {
                this.imageRegionBoundaryShape =
                    (this.imageRegionBoundaryShape ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionBoundaryShape", it).add(imageRegionBoundaryShape)
                    }
            }

            fun imageRegionBoundaryUnit(imageRegionBoundaryUnit: List<String>) =
                imageRegionBoundaryUnit(JsonField.of(imageRegionBoundaryUnit))

            /**
             * Sets [Builder.imageRegionBoundaryUnit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionBoundaryUnit] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionBoundaryUnit(imageRegionBoundaryUnit: JsonField<List<String>>) = apply {
                this.imageRegionBoundaryUnit = imageRegionBoundaryUnit.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.imageRegionBoundaryUnit].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionBoundaryUnit(imageRegionBoundaryUnit: String) = apply {
                this.imageRegionBoundaryUnit =
                    (this.imageRegionBoundaryUnit ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionBoundaryUnit", it).add(imageRegionBoundaryUnit)
                    }
            }

            fun imageRegionBoundaryVerticesX(imageRegionBoundaryVerticesX: List<Double>) =
                imageRegionBoundaryVerticesX(JsonField.of(imageRegionBoundaryVerticesX))

            /**
             * Sets [Builder.imageRegionBoundaryVerticesX] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionBoundaryVerticesX] with a well-typed
             * `List<Double>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionBoundaryVerticesX(
                imageRegionBoundaryVerticesX: JsonField<List<Double>>
            ) = apply {
                this.imageRegionBoundaryVerticesX =
                    imageRegionBoundaryVerticesX.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [Builder.imageRegionBoundaryVerticesX].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionBoundaryVerticesX(imageRegionBoundaryVerticesX: Double) = apply {
                this.imageRegionBoundaryVerticesX =
                    (this.imageRegionBoundaryVerticesX ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionBoundaryVerticesX", it)
                            .add(imageRegionBoundaryVerticesX)
                    }
            }

            fun imageRegionBoundaryVerticesY(imageRegionBoundaryVerticesY: List<Double>) =
                imageRegionBoundaryVerticesY(JsonField.of(imageRegionBoundaryVerticesY))

            /**
             * Sets [Builder.imageRegionBoundaryVerticesY] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionBoundaryVerticesY] with a well-typed
             * `List<Double>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionBoundaryVerticesY(
                imageRegionBoundaryVerticesY: JsonField<List<Double>>
            ) = apply {
                this.imageRegionBoundaryVerticesY =
                    imageRegionBoundaryVerticesY.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [Builder.imageRegionBoundaryVerticesY].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionBoundaryVerticesY(imageRegionBoundaryVerticesY: Double) = apply {
                this.imageRegionBoundaryVerticesY =
                    (this.imageRegionBoundaryVerticesY ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionBoundaryVerticesY", it)
                            .add(imageRegionBoundaryVerticesY)
                    }
            }

            fun imageRegionBoundaryW(imageRegionBoundaryW: List<Double>) =
                imageRegionBoundaryW(JsonField.of(imageRegionBoundaryW))

            /**
             * Sets [Builder.imageRegionBoundaryW] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionBoundaryW] with a well-typed
             * `List<Double>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionBoundaryW(imageRegionBoundaryW: JsonField<List<Double>>) = apply {
                this.imageRegionBoundaryW = imageRegionBoundaryW.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [Builder.imageRegionBoundaryW].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionBoundaryW(imageRegionBoundaryW: Double) = apply {
                this.imageRegionBoundaryW =
                    (this.imageRegionBoundaryW ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionBoundaryW", it).add(imageRegionBoundaryW)
                    }
            }

            fun imageRegionBoundaryX(imageRegionBoundaryX: List<Double>) =
                imageRegionBoundaryX(JsonField.of(imageRegionBoundaryX))

            /**
             * Sets [Builder.imageRegionBoundaryX] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionBoundaryX] with a well-typed
             * `List<Double>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionBoundaryX(imageRegionBoundaryX: JsonField<List<Double>>) = apply {
                this.imageRegionBoundaryX = imageRegionBoundaryX.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [Builder.imageRegionBoundaryX].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionBoundaryX(imageRegionBoundaryX: Double) = apply {
                this.imageRegionBoundaryX =
                    (this.imageRegionBoundaryX ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionBoundaryX", it).add(imageRegionBoundaryX)
                    }
            }

            fun imageRegionBoundaryY(imageRegionBoundaryY: List<Double>) =
                imageRegionBoundaryY(JsonField.of(imageRegionBoundaryY))

            /**
             * Sets [Builder.imageRegionBoundaryY] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionBoundaryY] with a well-typed
             * `List<Double>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionBoundaryY(imageRegionBoundaryY: JsonField<List<Double>>) = apply {
                this.imageRegionBoundaryY = imageRegionBoundaryY.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [Builder.imageRegionBoundaryY].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionBoundaryY(imageRegionBoundaryY: Double) = apply {
                this.imageRegionBoundaryY =
                    (this.imageRegionBoundaryY ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionBoundaryY", it).add(imageRegionBoundaryY)
                    }
            }

            fun imageRegionCtypeIdentifier(imageRegionCtypeIdentifier: List<String>) =
                imageRegionCtypeIdentifier(JsonField.of(imageRegionCtypeIdentifier))

            /**
             * Sets [Builder.imageRegionCtypeIdentifier] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionCtypeIdentifier] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionCtypeIdentifier(imageRegionCtypeIdentifier: JsonField<List<String>>) =
                apply {
                    this.imageRegionCtypeIdentifier =
                        imageRegionCtypeIdentifier.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.imageRegionCtypeIdentifier].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionCtypeIdentifier(imageRegionCtypeIdentifier: String) = apply {
                this.imageRegionCtypeIdentifier =
                    (this.imageRegionCtypeIdentifier ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionCtypeIdentifier", it).add(imageRegionCtypeIdentifier)
                    }
            }

            fun imageRegionCtypeName(imageRegionCtypeName: List<String>) =
                imageRegionCtypeName(JsonField.of(imageRegionCtypeName))

            /**
             * Sets [Builder.imageRegionCtypeName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionCtypeName] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionCtypeName(imageRegionCtypeName: JsonField<List<String>>) = apply {
                this.imageRegionCtypeName = imageRegionCtypeName.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.imageRegionCtypeName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionCtypeName(imageRegionCtypeName: String) = apply {
                this.imageRegionCtypeName =
                    (this.imageRegionCtypeName ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionCtypeName", it).add(imageRegionCtypeName)
                    }
            }

            fun imageRegionId(imageRegionId: List<String>) =
                imageRegionId(JsonField.of(imageRegionId))

            /**
             * Sets [Builder.imageRegionId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionId] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun imageRegionId(imageRegionId: JsonField<List<String>>) = apply {
                this.imageRegionId = imageRegionId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.imageRegionId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionId(imageRegionId: String) = apply {
                this.imageRegionId =
                    (this.imageRegionId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionId", it).add(imageRegionId)
                    }
            }

            fun imageRegionName(imageRegionName: List<String>) =
                imageRegionName(JsonField.of(imageRegionName))

            /**
             * Sets [Builder.imageRegionName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionName] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun imageRegionName(imageRegionName: JsonField<List<String>>) = apply {
                this.imageRegionName = imageRegionName.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.imageRegionName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionName(imageRegionName: String) = apply {
                this.imageRegionName =
                    (this.imageRegionName ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionName", it).add(imageRegionName)
                    }
            }

            fun imageRegionOrganisationInImageName(
                imageRegionOrganisationInImageName: List<String>
            ) = imageRegionOrganisationInImageName(JsonField.of(imageRegionOrganisationInImageName))

            /**
             * Sets [Builder.imageRegionOrganisationInImageName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionOrganisationInImageName] with a
             * well-typed `List<String>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun imageRegionOrganisationInImageName(
                imageRegionOrganisationInImageName: JsonField<List<String>>
            ) = apply {
                this.imageRegionOrganisationInImageName =
                    imageRegionOrganisationInImageName.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.imageRegionOrganisationInImageName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionOrganisationInImageName(imageRegionOrganisationInImageName: String) =
                apply {
                    this.imageRegionOrganisationInImageName =
                        (this.imageRegionOrganisationInImageName ?: JsonField.of(mutableListOf()))
                            .also {
                                checkKnown("imageRegionOrganisationInImageName", it)
                                    .add(imageRegionOrganisationInImageName)
                            }
                }

            fun imageRegionPersonInImage(imageRegionPersonInImage: List<String>) =
                imageRegionPersonInImage(JsonField.of(imageRegionPersonInImage))

            /**
             * Sets [Builder.imageRegionPersonInImage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionPersonInImage] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionPersonInImage(imageRegionPersonInImage: JsonField<List<String>>) =
                apply {
                    this.imageRegionPersonInImage =
                        imageRegionPersonInImage.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.imageRegionPersonInImage].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionPersonInImage(imageRegionPersonInImage: String) = apply {
                this.imageRegionPersonInImage =
                    (this.imageRegionPersonInImage ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionPersonInImage", it).add(imageRegionPersonInImage)
                    }
            }

            fun imageRegionRoleIdentifier(imageRegionRoleIdentifier: List<String>) =
                imageRegionRoleIdentifier(JsonField.of(imageRegionRoleIdentifier))

            /**
             * Sets [Builder.imageRegionRoleIdentifier] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionRoleIdentifier] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionRoleIdentifier(imageRegionRoleIdentifier: JsonField<List<String>>) =
                apply {
                    this.imageRegionRoleIdentifier =
                        imageRegionRoleIdentifier.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.imageRegionRoleIdentifier].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionRoleIdentifier(imageRegionRoleIdentifier: String) = apply {
                this.imageRegionRoleIdentifier =
                    (this.imageRegionRoleIdentifier ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionRoleIdentifier", it).add(imageRegionRoleIdentifier)
                    }
            }

            fun imageRegionRoleName(imageRegionRoleName: List<String>) =
                imageRegionRoleName(JsonField.of(imageRegionRoleName))

            /**
             * Sets [Builder.imageRegionRoleName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageRegionRoleName] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun imageRegionRoleName(imageRegionRoleName: JsonField<List<String>>) = apply {
                this.imageRegionRoleName = imageRegionRoleName.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.imageRegionRoleName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addImageRegionRoleName(imageRegionRoleName: String) = apply {
                this.imageRegionRoleName =
                    (this.imageRegionRoleName ?: JsonField.of(mutableListOf())).also {
                        checkKnown("imageRegionRoleName", it).add(imageRegionRoleName)
                    }
            }

            fun imageSupplierId(imageSupplierId: String) =
                imageSupplierId(JsonField.of(imageSupplierId))

            /**
             * Sets [Builder.imageSupplierId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageSupplierId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun imageSupplierId(imageSupplierId: JsonField<String>) = apply {
                this.imageSupplierId = imageSupplierId
            }

            fun imageSupplierImageId(imageSupplierImageId: String) =
                imageSupplierImageId(JsonField.of(imageSupplierImageId))

            /**
             * Sets [Builder.imageSupplierImageId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageSupplierImageId] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun imageSupplierImageId(imageSupplierImageId: JsonField<String>) = apply {
                this.imageSupplierImageId = imageSupplierImageId
            }

            fun imageSupplierName(imageSupplierName: String) =
                imageSupplierName(JsonField.of(imageSupplierName))

            /**
             * Sets [Builder.imageSupplierName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageSupplierName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun imageSupplierName(imageSupplierName: JsonField<String>) = apply {
                this.imageSupplierName = imageSupplierName
            }

            fun instructions(instructions: String) = instructions(JsonField.of(instructions))

            /**
             * Sets [Builder.instructions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.instructions] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun instructions(instructions: JsonField<String>) = apply {
                this.instructions = instructions
            }

            fun intellectualGenre(intellectualGenre: String) =
                intellectualGenre(JsonField.of(intellectualGenre))

            /**
             * Sets [Builder.intellectualGenre] to an arbitrary JSON value.
             *
             * You should usually call [Builder.intellectualGenre] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun intellectualGenre(intellectualGenre: JsonField<String>) = apply {
                this.intellectualGenre = intellectualGenre
            }

            fun keywords(keywords: List<String>) = keywords(JsonField.of(keywords))

            /**
             * Sets [Builder.keywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.keywords] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun keywords(keywords: JsonField<List<String>>) = apply {
                this.keywords = keywords.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [keywords].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addKeyword(keyword: String) = apply {
                keywords =
                    (keywords ?: JsonField.of(mutableListOf())).also {
                        checkKnown("keywords", it).add(keyword)
                    }
            }

            fun licensorCity(licensorCity: List<String>) = licensorCity(JsonField.of(licensorCity))

            /**
             * Sets [Builder.licensorCity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorCity] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun licensorCity(licensorCity: JsonField<List<String>>) = apply {
                this.licensorCity = licensorCity.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorCity].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorCity(licensorCity: String) = apply {
                this.licensorCity =
                    (this.licensorCity ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorCity", it).add(licensorCity)
                    }
            }

            fun licensorCountry(licensorCountry: List<String>) =
                licensorCountry(JsonField.of(licensorCountry))

            /**
             * Sets [Builder.licensorCountry] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorCountry] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun licensorCountry(licensorCountry: JsonField<List<String>>) = apply {
                this.licensorCountry = licensorCountry.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorCountry].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorCountry(licensorCountry: String) = apply {
                this.licensorCountry =
                    (this.licensorCountry ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorCountry", it).add(licensorCountry)
                    }
            }

            fun licensorEmail(licensorEmail: List<String>) =
                licensorEmail(JsonField.of(licensorEmail))

            /**
             * Sets [Builder.licensorEmail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorEmail] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun licensorEmail(licensorEmail: JsonField<List<String>>) = apply {
                this.licensorEmail = licensorEmail.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorEmail].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorEmail(licensorEmail: String) = apply {
                this.licensorEmail =
                    (this.licensorEmail ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorEmail", it).add(licensorEmail)
                    }
            }

            fun licensorExtendedAddress(licensorExtendedAddress: List<String>) =
                licensorExtendedAddress(JsonField.of(licensorExtendedAddress))

            /**
             * Sets [Builder.licensorExtendedAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorExtendedAddress] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun licensorExtendedAddress(licensorExtendedAddress: JsonField<List<String>>) = apply {
                this.licensorExtendedAddress = licensorExtendedAddress.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorExtendedAddress].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorExtendedAddress(licensorExtendedAddress: String) = apply {
                this.licensorExtendedAddress =
                    (this.licensorExtendedAddress ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorExtendedAddress", it).add(licensorExtendedAddress)
                    }
            }

            fun licensorId(licensorId: List<String>) = licensorId(JsonField.of(licensorId))

            /**
             * Sets [Builder.licensorId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorId] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun licensorId(licensorId: JsonField<List<String>>) = apply {
                this.licensorId = licensorId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorId(licensorId: String) = apply {
                this.licensorId =
                    (this.licensorId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorId", it).add(licensorId)
                    }
            }

            fun licensorName(licensorName: List<String>) = licensorName(JsonField.of(licensorName))

            /**
             * Sets [Builder.licensorName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorName] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun licensorName(licensorName: JsonField<List<String>>) = apply {
                this.licensorName = licensorName.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorName(licensorName: String) = apply {
                this.licensorName =
                    (this.licensorName ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorName", it).add(licensorName)
                    }
            }

            fun licensorPostalCode(licensorPostalCode: List<String>) =
                licensorPostalCode(JsonField.of(licensorPostalCode))

            /**
             * Sets [Builder.licensorPostalCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorPostalCode] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun licensorPostalCode(licensorPostalCode: JsonField<List<String>>) = apply {
                this.licensorPostalCode = licensorPostalCode.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorPostalCode].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorPostalCode(licensorPostalCode: String) = apply {
                this.licensorPostalCode =
                    (this.licensorPostalCode ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorPostalCode", it).add(licensorPostalCode)
                    }
            }

            fun licensorRegion(licensorRegion: List<String>) =
                licensorRegion(JsonField.of(licensorRegion))

            /**
             * Sets [Builder.licensorRegion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorRegion] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun licensorRegion(licensorRegion: JsonField<List<String>>) = apply {
                this.licensorRegion = licensorRegion.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorRegion].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorRegion(licensorRegion: String) = apply {
                this.licensorRegion =
                    (this.licensorRegion ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorRegion", it).add(licensorRegion)
                    }
            }

            fun licensorStreetAddress(licensorStreetAddress: List<String>) =
                licensorStreetAddress(JsonField.of(licensorStreetAddress))

            /**
             * Sets [Builder.licensorStreetAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorStreetAddress] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun licensorStreetAddress(licensorStreetAddress: JsonField<List<String>>) = apply {
                this.licensorStreetAddress = licensorStreetAddress.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorStreetAddress].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorStreetAddress(licensorStreetAddress: String) = apply {
                this.licensorStreetAddress =
                    (this.licensorStreetAddress ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorStreetAddress", it).add(licensorStreetAddress)
                    }
            }

            fun licensorTelephone1(licensorTelephone1: List<String>) =
                licensorTelephone1(JsonField.of(licensorTelephone1))

            /**
             * Sets [Builder.licensorTelephone1] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorTelephone1] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun licensorTelephone1(licensorTelephone1: JsonField<List<String>>) = apply {
                this.licensorTelephone1 = licensorTelephone1.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorTelephone1].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorTelephone1(licensorTelephone1: String) = apply {
                this.licensorTelephone1 =
                    (this.licensorTelephone1 ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorTelephone1", it).add(licensorTelephone1)
                    }
            }

            fun licensorTelephone2(licensorTelephone2: List<String>) =
                licensorTelephone2(JsonField.of(licensorTelephone2))

            /**
             * Sets [Builder.licensorTelephone2] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorTelephone2] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun licensorTelephone2(licensorTelephone2: JsonField<List<String>>) = apply {
                this.licensorTelephone2 = licensorTelephone2.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorTelephone2].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorTelephone2(licensorTelephone2: String) = apply {
                this.licensorTelephone2 =
                    (this.licensorTelephone2 ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorTelephone2", it).add(licensorTelephone2)
                    }
            }

            fun licensorUrl(licensorUrl: List<String>) = licensorUrl(JsonField.of(licensorUrl))

            /**
             * Sets [Builder.licensorUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.licensorUrl] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun licensorUrl(licensorUrl: JsonField<List<String>>) = apply {
                this.licensorUrl = licensorUrl.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.licensorUrl].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLicensorUrl(licensorUrl: String) = apply {
                this.licensorUrl =
                    (this.licensorUrl ?: JsonField.of(mutableListOf())).also {
                        checkKnown("licensorUrl", it).add(licensorUrl)
                    }
            }

            fun linkedEncodedRightsExpr(linkedEncodedRightsExpr: String) =
                linkedEncodedRightsExpr(JsonField.of(linkedEncodedRightsExpr))

            /**
             * Sets [Builder.linkedEncodedRightsExpr] to an arbitrary JSON value.
             *
             * You should usually call [Builder.linkedEncodedRightsExpr] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun linkedEncodedRightsExpr(linkedEncodedRightsExpr: JsonField<String>) = apply {
                this.linkedEncodedRightsExpr = linkedEncodedRightsExpr
            }

            fun linkedEncodedRightsExprLangId(linkedEncodedRightsExprLangId: String) =
                linkedEncodedRightsExprLangId(JsonField.of(linkedEncodedRightsExprLangId))

            /**
             * Sets [Builder.linkedEncodedRightsExprLangId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.linkedEncodedRightsExprLangId] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun linkedEncodedRightsExprLangId(linkedEncodedRightsExprLangId: JsonField<String>) =
                apply {
                    this.linkedEncodedRightsExprLangId = linkedEncodedRightsExprLangId
                }

            fun linkedEncodedRightsExprType(linkedEncodedRightsExprType: String) =
                linkedEncodedRightsExprType(JsonField.of(linkedEncodedRightsExprType))

            /**
             * Sets [Builder.linkedEncodedRightsExprType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.linkedEncodedRightsExprType] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun linkedEncodedRightsExprType(linkedEncodedRightsExprType: JsonField<String>) =
                apply {
                    this.linkedEncodedRightsExprType = linkedEncodedRightsExprType
                }

            fun location(location: String) = location(JsonField.of(location))

            /**
             * Sets [Builder.location] to an arbitrary JSON value.
             *
             * You should usually call [Builder.location] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun location(location: JsonField<String>) = apply { this.location = location }

            fun locationCreatedCity(locationCreatedCity: String) =
                locationCreatedCity(JsonField.of(locationCreatedCity))

            /**
             * Sets [Builder.locationCreatedCity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationCreatedCity] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun locationCreatedCity(locationCreatedCity: JsonField<String>) = apply {
                this.locationCreatedCity = locationCreatedCity
            }

            fun locationCreatedCountryCode(locationCreatedCountryCode: String) =
                locationCreatedCountryCode(JsonField.of(locationCreatedCountryCode))

            /**
             * Sets [Builder.locationCreatedCountryCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationCreatedCountryCode] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationCreatedCountryCode(locationCreatedCountryCode: JsonField<String>) = apply {
                this.locationCreatedCountryCode = locationCreatedCountryCode
            }

            fun locationCreatedCountryName(locationCreatedCountryName: String) =
                locationCreatedCountryName(JsonField.of(locationCreatedCountryName))

            /**
             * Sets [Builder.locationCreatedCountryName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationCreatedCountryName] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationCreatedCountryName(locationCreatedCountryName: JsonField<String>) = apply {
                this.locationCreatedCountryName = locationCreatedCountryName
            }

            fun locationCreatedGpsAltitude(locationCreatedGpsAltitude: String) =
                locationCreatedGpsAltitude(JsonField.of(locationCreatedGpsAltitude))

            /**
             * Sets [Builder.locationCreatedGpsAltitude] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationCreatedGpsAltitude] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationCreatedGpsAltitude(locationCreatedGpsAltitude: JsonField<String>) = apply {
                this.locationCreatedGpsAltitude = locationCreatedGpsAltitude
            }

            fun locationCreatedGpsLatitude(locationCreatedGpsLatitude: String) =
                locationCreatedGpsLatitude(JsonField.of(locationCreatedGpsLatitude))

            /**
             * Sets [Builder.locationCreatedGpsLatitude] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationCreatedGpsLatitude] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationCreatedGpsLatitude(locationCreatedGpsLatitude: JsonField<String>) = apply {
                this.locationCreatedGpsLatitude = locationCreatedGpsLatitude
            }

            fun locationCreatedGpsLongitude(locationCreatedGpsLongitude: String) =
                locationCreatedGpsLongitude(JsonField.of(locationCreatedGpsLongitude))

            /**
             * Sets [Builder.locationCreatedGpsLongitude] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationCreatedGpsLongitude] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationCreatedGpsLongitude(locationCreatedGpsLongitude: JsonField<String>) =
                apply {
                    this.locationCreatedGpsLongitude = locationCreatedGpsLongitude
                }

            fun locationCreatedLocationId(locationCreatedLocationId: String) =
                locationCreatedLocationId(JsonField.of(locationCreatedLocationId))

            /**
             * Sets [Builder.locationCreatedLocationId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationCreatedLocationId] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationCreatedLocationId(locationCreatedLocationId: JsonField<String>) = apply {
                this.locationCreatedLocationId = locationCreatedLocationId
            }

            fun locationCreatedLocationName(locationCreatedLocationName: String) =
                locationCreatedLocationName(JsonField.of(locationCreatedLocationName))

            /**
             * Sets [Builder.locationCreatedLocationName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationCreatedLocationName] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationCreatedLocationName(locationCreatedLocationName: JsonField<String>) =
                apply {
                    this.locationCreatedLocationName = locationCreatedLocationName
                }

            fun locationCreatedProvinceState(locationCreatedProvinceState: String) =
                locationCreatedProvinceState(JsonField.of(locationCreatedProvinceState))

            /**
             * Sets [Builder.locationCreatedProvinceState] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationCreatedProvinceState] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationCreatedProvinceState(locationCreatedProvinceState: JsonField<String>) =
                apply {
                    this.locationCreatedProvinceState = locationCreatedProvinceState
                }

            fun locationCreatedSublocation(locationCreatedSublocation: String) =
                locationCreatedSublocation(JsonField.of(locationCreatedSublocation))

            /**
             * Sets [Builder.locationCreatedSublocation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationCreatedSublocation] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationCreatedSublocation(locationCreatedSublocation: JsonField<String>) = apply {
                this.locationCreatedSublocation = locationCreatedSublocation
            }

            fun locationCreatedWorldRegion(locationCreatedWorldRegion: String) =
                locationCreatedWorldRegion(JsonField.of(locationCreatedWorldRegion))

            /**
             * Sets [Builder.locationCreatedWorldRegion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationCreatedWorldRegion] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationCreatedWorldRegion(locationCreatedWorldRegion: JsonField<String>) = apply {
                this.locationCreatedWorldRegion = locationCreatedWorldRegion
            }

            fun locationShownCity(locationShownCity: List<String>) =
                locationShownCity(JsonField.of(locationShownCity))

            /**
             * Sets [Builder.locationShownCity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationShownCity] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun locationShownCity(locationShownCity: JsonField<List<String>>) = apply {
                this.locationShownCity = locationShownCity.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.locationShownCity].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLocationShownCity(locationShownCity: String) = apply {
                this.locationShownCity =
                    (this.locationShownCity ?: JsonField.of(mutableListOf())).also {
                        checkKnown("locationShownCity", it).add(locationShownCity)
                    }
            }

            fun locationShownCountryCode(locationShownCountryCode: List<String>) =
                locationShownCountryCode(JsonField.of(locationShownCountryCode))

            /**
             * Sets [Builder.locationShownCountryCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationShownCountryCode] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationShownCountryCode(locationShownCountryCode: JsonField<List<String>>) =
                apply {
                    this.locationShownCountryCode =
                        locationShownCountryCode.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.locationShownCountryCode].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLocationShownCountryCode(locationShownCountryCode: String) = apply {
                this.locationShownCountryCode =
                    (this.locationShownCountryCode ?: JsonField.of(mutableListOf())).also {
                        checkKnown("locationShownCountryCode", it).add(locationShownCountryCode)
                    }
            }

            fun locationShownCountryName(locationShownCountryName: List<String>) =
                locationShownCountryName(JsonField.of(locationShownCountryName))

            /**
             * Sets [Builder.locationShownCountryName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationShownCountryName] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationShownCountryName(locationShownCountryName: JsonField<List<String>>) =
                apply {
                    this.locationShownCountryName =
                        locationShownCountryName.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.locationShownCountryName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLocationShownCountryName(locationShownCountryName: String) = apply {
                this.locationShownCountryName =
                    (this.locationShownCountryName ?: JsonField.of(mutableListOf())).also {
                        checkKnown("locationShownCountryName", it).add(locationShownCountryName)
                    }
            }

            fun locationShownGpsAltitude(locationShownGpsAltitude: List<String>) =
                locationShownGpsAltitude(JsonField.of(locationShownGpsAltitude))

            /**
             * Sets [Builder.locationShownGpsAltitude] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationShownGpsAltitude] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationShownGpsAltitude(locationShownGpsAltitude: JsonField<List<String>>) =
                apply {
                    this.locationShownGpsAltitude =
                        locationShownGpsAltitude.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.locationShownGpsAltitude].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLocationShownGpsAltitude(locationShownGpsAltitude: String) = apply {
                this.locationShownGpsAltitude =
                    (this.locationShownGpsAltitude ?: JsonField.of(mutableListOf())).also {
                        checkKnown("locationShownGpsAltitude", it).add(locationShownGpsAltitude)
                    }
            }

            fun locationShownGpsLatitude(locationShownGpsLatitude: List<String>) =
                locationShownGpsLatitude(JsonField.of(locationShownGpsLatitude))

            /**
             * Sets [Builder.locationShownGpsLatitude] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationShownGpsLatitude] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationShownGpsLatitude(locationShownGpsLatitude: JsonField<List<String>>) =
                apply {
                    this.locationShownGpsLatitude =
                        locationShownGpsLatitude.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.locationShownGpsLatitude].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLocationShownGpsLatitude(locationShownGpsLatitude: String) = apply {
                this.locationShownGpsLatitude =
                    (this.locationShownGpsLatitude ?: JsonField.of(mutableListOf())).also {
                        checkKnown("locationShownGpsLatitude", it).add(locationShownGpsLatitude)
                    }
            }

            fun locationShownGpsLongitude(locationShownGpsLongitude: List<String>) =
                locationShownGpsLongitude(JsonField.of(locationShownGpsLongitude))

            /**
             * Sets [Builder.locationShownGpsLongitude] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationShownGpsLongitude] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationShownGpsLongitude(locationShownGpsLongitude: JsonField<List<String>>) =
                apply {
                    this.locationShownGpsLongitude =
                        locationShownGpsLongitude.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.locationShownGpsLongitude].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLocationShownGpsLongitude(locationShownGpsLongitude: String) = apply {
                this.locationShownGpsLongitude =
                    (this.locationShownGpsLongitude ?: JsonField.of(mutableListOf())).also {
                        checkKnown("locationShownGpsLongitude", it).add(locationShownGpsLongitude)
                    }
            }

            fun locationShownLocationId(locationShownLocationId: List<String>) =
                locationShownLocationId(JsonField.of(locationShownLocationId))

            /**
             * Sets [Builder.locationShownLocationId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationShownLocationId] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationShownLocationId(locationShownLocationId: JsonField<List<String>>) = apply {
                this.locationShownLocationId = locationShownLocationId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.locationShownLocationId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLocationShownLocationId(locationShownLocationId: String) = apply {
                this.locationShownLocationId =
                    (this.locationShownLocationId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("locationShownLocationId", it).add(locationShownLocationId)
                    }
            }

            fun locationShownLocationName(locationShownLocationName: List<String>) =
                locationShownLocationName(JsonField.of(locationShownLocationName))

            /**
             * Sets [Builder.locationShownLocationName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationShownLocationName] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationShownLocationName(locationShownLocationName: JsonField<List<String>>) =
                apply {
                    this.locationShownLocationName =
                        locationShownLocationName.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.locationShownLocationName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLocationShownLocationName(locationShownLocationName: String) = apply {
                this.locationShownLocationName =
                    (this.locationShownLocationName ?: JsonField.of(mutableListOf())).also {
                        checkKnown("locationShownLocationName", it).add(locationShownLocationName)
                    }
            }

            fun locationShownProvinceState(locationShownProvinceState: List<String>) =
                locationShownProvinceState(JsonField.of(locationShownProvinceState))

            /**
             * Sets [Builder.locationShownProvinceState] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationShownProvinceState] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationShownProvinceState(locationShownProvinceState: JsonField<List<String>>) =
                apply {
                    this.locationShownProvinceState =
                        locationShownProvinceState.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.locationShownProvinceState].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLocationShownProvinceState(locationShownProvinceState: String) = apply {
                this.locationShownProvinceState =
                    (this.locationShownProvinceState ?: JsonField.of(mutableListOf())).also {
                        checkKnown("locationShownProvinceState", it).add(locationShownProvinceState)
                    }
            }

            fun locationShownSublocation(locationShownSublocation: List<String>) =
                locationShownSublocation(JsonField.of(locationShownSublocation))

            /**
             * Sets [Builder.locationShownSublocation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationShownSublocation] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationShownSublocation(locationShownSublocation: JsonField<List<String>>) =
                apply {
                    this.locationShownSublocation =
                        locationShownSublocation.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.locationShownSublocation].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLocationShownSublocation(locationShownSublocation: String) = apply {
                this.locationShownSublocation =
                    (this.locationShownSublocation ?: JsonField.of(mutableListOf())).also {
                        checkKnown("locationShownSublocation", it).add(locationShownSublocation)
                    }
            }

            fun locationShownWorldRegion(locationShownWorldRegion: List<String>) =
                locationShownWorldRegion(JsonField.of(locationShownWorldRegion))

            /**
             * Sets [Builder.locationShownWorldRegion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationShownWorldRegion] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun locationShownWorldRegion(locationShownWorldRegion: JsonField<List<String>>) =
                apply {
                    this.locationShownWorldRegion =
                        locationShownWorldRegion.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.locationShownWorldRegion].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLocationShownWorldRegion(locationShownWorldRegion: String) = apply {
                this.locationShownWorldRegion =
                    (this.locationShownWorldRegion ?: JsonField.of(mutableListOf())).also {
                        checkKnown("locationShownWorldRegion", it).add(locationShownWorldRegion)
                    }
            }

            fun maxAvailHeight(maxAvailHeight: Double) =
                maxAvailHeight(JsonField.of(maxAvailHeight))

            /**
             * Sets [Builder.maxAvailHeight] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxAvailHeight] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxAvailHeight(maxAvailHeight: JsonField<Double>) = apply {
                this.maxAvailHeight = maxAvailHeight
            }

            fun maxAvailWidth(maxAvailWidth: Double) = maxAvailWidth(JsonField.of(maxAvailWidth))

            /**
             * Sets [Builder.maxAvailWidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxAvailWidth] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxAvailWidth(maxAvailWidth: JsonField<Double>) = apply {
                this.maxAvailWidth = maxAvailWidth
            }

            fun modelAge(modelAge: List<Double>) = modelAge(JsonField.of(modelAge))

            /**
             * Sets [Builder.modelAge] to an arbitrary JSON value.
             *
             * You should usually call [Builder.modelAge] with a well-typed `List<Double>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun modelAge(modelAge: JsonField<List<Double>>) = apply {
                this.modelAge = modelAge.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [Builder.modelAge].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addModelAge(modelAge: Double) = apply {
                this.modelAge =
                    (this.modelAge ?: JsonField.of(mutableListOf())).also {
                        checkKnown("modelAge", it).add(modelAge)
                    }
            }

            fun modelReleaseId(modelReleaseId: List<String>) =
                modelReleaseId(JsonField.of(modelReleaseId))

            /**
             * Sets [Builder.modelReleaseId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.modelReleaseId] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun modelReleaseId(modelReleaseId: JsonField<List<String>>) = apply {
                this.modelReleaseId = modelReleaseId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.modelReleaseId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addModelReleaseId(modelReleaseId: String) = apply {
                this.modelReleaseId =
                    (this.modelReleaseId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("modelReleaseId", it).add(modelReleaseId)
                    }
            }

            fun objectAttributeReference(objectAttributeReference: String) =
                objectAttributeReference(JsonField.of(objectAttributeReference))

            /**
             * Sets [Builder.objectAttributeReference] to an arbitrary JSON value.
             *
             * You should usually call [Builder.objectAttributeReference] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun objectAttributeReference(objectAttributeReference: JsonField<String>) = apply {
                this.objectAttributeReference = objectAttributeReference
            }

            fun objectName(objectName: String) = objectName(JsonField.of(objectName))

            /**
             * Sets [Builder.objectName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.objectName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun objectName(objectName: JsonField<String>) = apply { this.objectName = objectName }

            fun offsetTimeOriginal(offsetTimeOriginal: String) =
                offsetTimeOriginal(JsonField.of(offsetTimeOriginal))

            /**
             * Sets [Builder.offsetTimeOriginal] to an arbitrary JSON value.
             *
             * You should usually call [Builder.offsetTimeOriginal] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun offsetTimeOriginal(offsetTimeOriginal: JsonField<String>) = apply {
                this.offsetTimeOriginal = offsetTimeOriginal
            }

            fun organisationInImageCode(organisationInImageCode: List<String>) =
                organisationInImageCode(JsonField.of(organisationInImageCode))

            /**
             * Sets [Builder.organisationInImageCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.organisationInImageCode] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun organisationInImageCode(organisationInImageCode: JsonField<List<String>>) = apply {
                this.organisationInImageCode = organisationInImageCode.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.organisationInImageCode].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addOrganisationInImageCode(organisationInImageCode: String) = apply {
                this.organisationInImageCode =
                    (this.organisationInImageCode ?: JsonField.of(mutableListOf())).also {
                        checkKnown("organisationInImageCode", it).add(organisationInImageCode)
                    }
            }

            fun organisationInImageName(organisationInImageName: List<String>) =
                organisationInImageName(JsonField.of(organisationInImageName))

            /**
             * Sets [Builder.organisationInImageName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.organisationInImageName] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun organisationInImageName(organisationInImageName: JsonField<List<String>>) = apply {
                this.organisationInImageName = organisationInImageName.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.organisationInImageName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addOrganisationInImageName(organisationInImageName: String) = apply {
                this.organisationInImageName =
                    (this.organisationInImageName ?: JsonField.of(mutableListOf())).also {
                        checkKnown("organisationInImageName", it).add(organisationInImageName)
                    }
            }

            fun orientation(orientation: String) = orientation(JsonField.of(orientation))

            /**
             * Sets [Builder.orientation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orientation] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orientation(orientation: JsonField<String>) = apply {
                this.orientation = orientation
            }

            fun originalTransmissionReference(originalTransmissionReference: String) =
                originalTransmissionReference(JsonField.of(originalTransmissionReference))

            /**
             * Sets [Builder.originalTransmissionReference] to an arbitrary JSON value.
             *
             * You should usually call [Builder.originalTransmissionReference] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun originalTransmissionReference(originalTransmissionReference: JsonField<String>) =
                apply {
                    this.originalTransmissionReference = originalTransmissionReference
                }

            fun personInImage(personInImage: List<String>) =
                personInImage(JsonField.of(personInImage))

            /**
             * Sets [Builder.personInImage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.personInImage] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun personInImage(personInImage: JsonField<List<String>>) = apply {
                this.personInImage = personInImage.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.personInImage].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPersonInImage(personInImage: String) = apply {
                this.personInImage =
                    (this.personInImage ?: JsonField.of(mutableListOf())).also {
                        checkKnown("personInImage", it).add(personInImage)
                    }
            }

            fun personInImageCvTermCvId(personInImageCvTermCvId: List<String>) =
                personInImageCvTermCvId(JsonField.of(personInImageCvTermCvId))

            /**
             * Sets [Builder.personInImageCvTermCvId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.personInImageCvTermCvId] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun personInImageCvTermCvId(personInImageCvTermCvId: JsonField<List<String>>) = apply {
                this.personInImageCvTermCvId = personInImageCvTermCvId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.personInImageCvTermCvId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPersonInImageCvTermCvId(personInImageCvTermCvId: String) = apply {
                this.personInImageCvTermCvId =
                    (this.personInImageCvTermCvId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("personInImageCvTermCvId", it).add(personInImageCvTermCvId)
                    }
            }

            fun personInImageCvTermId(personInImageCvTermId: List<String>) =
                personInImageCvTermId(JsonField.of(personInImageCvTermId))

            /**
             * Sets [Builder.personInImageCvTermId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.personInImageCvTermId] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun personInImageCvTermId(personInImageCvTermId: JsonField<List<String>>) = apply {
                this.personInImageCvTermId = personInImageCvTermId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.personInImageCvTermId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPersonInImageCvTermId(personInImageCvTermId: String) = apply {
                this.personInImageCvTermId =
                    (this.personInImageCvTermId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("personInImageCvTermId", it).add(personInImageCvTermId)
                    }
            }

            fun personInImageCvTermName(personInImageCvTermName: List<String>) =
                personInImageCvTermName(JsonField.of(personInImageCvTermName))

            /**
             * Sets [Builder.personInImageCvTermName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.personInImageCvTermName] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun personInImageCvTermName(personInImageCvTermName: JsonField<List<String>>) = apply {
                this.personInImageCvTermName = personInImageCvTermName.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.personInImageCvTermName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPersonInImageCvTermName(personInImageCvTermName: String) = apply {
                this.personInImageCvTermName =
                    (this.personInImageCvTermName ?: JsonField.of(mutableListOf())).also {
                        checkKnown("personInImageCvTermName", it).add(personInImageCvTermName)
                    }
            }

            fun personInImageCvTermRefinedAbout(personInImageCvTermRefinedAbout: List<String>) =
                personInImageCvTermRefinedAbout(JsonField.of(personInImageCvTermRefinedAbout))

            /**
             * Sets [Builder.personInImageCvTermRefinedAbout] to an arbitrary JSON value.
             *
             * You should usually call [Builder.personInImageCvTermRefinedAbout] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun personInImageCvTermRefinedAbout(
                personInImageCvTermRefinedAbout: JsonField<List<String>>
            ) = apply {
                this.personInImageCvTermRefinedAbout =
                    personInImageCvTermRefinedAbout.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.personInImageCvTermRefinedAbout].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPersonInImageCvTermRefinedAbout(personInImageCvTermRefinedAbout: String) =
                apply {
                    this.personInImageCvTermRefinedAbout =
                        (this.personInImageCvTermRefinedAbout ?: JsonField.of(mutableListOf()))
                            .also {
                                checkKnown("personInImageCvTermRefinedAbout", it)
                                    .add(personInImageCvTermRefinedAbout)
                            }
                }

            fun personInImageDescription(personInImageDescription: List<String>) =
                personInImageDescription(JsonField.of(personInImageDescription))

            /**
             * Sets [Builder.personInImageDescription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.personInImageDescription] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun personInImageDescription(personInImageDescription: JsonField<List<String>>) =
                apply {
                    this.personInImageDescription =
                        personInImageDescription.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.personInImageDescription].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPersonInImageDescription(personInImageDescription: String) = apply {
                this.personInImageDescription =
                    (this.personInImageDescription ?: JsonField.of(mutableListOf())).also {
                        checkKnown("personInImageDescription", it).add(personInImageDescription)
                    }
            }

            fun personInImageId(personInImageId: List<String>) =
                personInImageId(JsonField.of(personInImageId))

            /**
             * Sets [Builder.personInImageId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.personInImageId] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun personInImageId(personInImageId: JsonField<List<String>>) = apply {
                this.personInImageId = personInImageId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.personInImageId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPersonInImageId(personInImageId: String) = apply {
                this.personInImageId =
                    (this.personInImageId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("personInImageId", it).add(personInImageId)
                    }
            }

            fun personInImageName(personInImageName: List<String>) =
                personInImageName(JsonField.of(personInImageName))

            /**
             * Sets [Builder.personInImageName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.personInImageName] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun personInImageName(personInImageName: JsonField<List<String>>) = apply {
                this.personInImageName = personInImageName.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.personInImageName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPersonInImageName(personInImageName: String) = apply {
                this.personInImageName =
                    (this.personInImageName ?: JsonField.of(mutableListOf())).also {
                        checkKnown("personInImageName", it).add(personInImageName)
                    }
            }

            fun productInImageDescription(productInImageDescription: List<String>) =
                productInImageDescription(JsonField.of(productInImageDescription))

            /**
             * Sets [Builder.productInImageDescription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.productInImageDescription] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun productInImageDescription(productInImageDescription: JsonField<List<String>>) =
                apply {
                    this.productInImageDescription =
                        productInImageDescription.map { it.toMutableList() }
                }

            /**
             * Adds a single [String] to [Builder.productInImageDescription].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addProductInImageDescription(productInImageDescription: String) = apply {
                this.productInImageDescription =
                    (this.productInImageDescription ?: JsonField.of(mutableListOf())).also {
                        checkKnown("productInImageDescription", it).add(productInImageDescription)
                    }
            }

            fun productInImageGtin(productInImageGtin: List<Double>) =
                productInImageGtin(JsonField.of(productInImageGtin))

            /**
             * Sets [Builder.productInImageGtin] to an arbitrary JSON value.
             *
             * You should usually call [Builder.productInImageGtin] with a well-typed `List<Double>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun productInImageGtin(productInImageGtin: JsonField<List<Double>>) = apply {
                this.productInImageGtin = productInImageGtin.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [Builder.productInImageGtin].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addProductInImageGtin(productInImageGtin: Double) = apply {
                this.productInImageGtin =
                    (this.productInImageGtin ?: JsonField.of(mutableListOf())).also {
                        checkKnown("productInImageGtin", it).add(productInImageGtin)
                    }
            }

            fun productInImageName(productInImageName: List<String>) =
                productInImageName(JsonField.of(productInImageName))

            /**
             * Sets [Builder.productInImageName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.productInImageName] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun productInImageName(productInImageName: JsonField<List<String>>) = apply {
                this.productInImageName = productInImageName.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.productInImageName].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addProductInImageName(productInImageName: String) = apply {
                this.productInImageName =
                    (this.productInImageName ?: JsonField.of(mutableListOf())).also {
                        checkKnown("productInImageName", it).add(productInImageName)
                    }
            }

            fun propertyReleaseId(propertyReleaseId: List<String>) =
                propertyReleaseId(JsonField.of(propertyReleaseId))

            /**
             * Sets [Builder.propertyReleaseId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.propertyReleaseId] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun propertyReleaseId(propertyReleaseId: JsonField<List<String>>) = apply {
                this.propertyReleaseId = propertyReleaseId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.propertyReleaseId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPropertyReleaseId(propertyReleaseId: String) = apply {
                this.propertyReleaseId =
                    (this.propertyReleaseId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("propertyReleaseId", it).add(propertyReleaseId)
                    }
            }

            fun provinceState(provinceState: String) = provinceState(JsonField.of(provinceState))

            /**
             * Sets [Builder.provinceState] to an arbitrary JSON value.
             *
             * You should usually call [Builder.provinceState] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun provinceState(provinceState: JsonField<String>) = apply {
                this.provinceState = provinceState
            }

            fun rating(rating: Long) = rating(JsonField.of(rating))

            /**
             * Sets [Builder.rating] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rating] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun rating(rating: JsonField<Long>) = apply { this.rating = rating }

            fun registryEntryRole(registryEntryRole: List<String>) =
                registryEntryRole(JsonField.of(registryEntryRole))

            /**
             * Sets [Builder.registryEntryRole] to an arbitrary JSON value.
             *
             * You should usually call [Builder.registryEntryRole] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun registryEntryRole(registryEntryRole: JsonField<List<String>>) = apply {
                this.registryEntryRole = registryEntryRole.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.registryEntryRole].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRegistryEntryRole(registryEntryRole: String) = apply {
                this.registryEntryRole =
                    (this.registryEntryRole ?: JsonField.of(mutableListOf())).also {
                        checkKnown("registryEntryRole", it).add(registryEntryRole)
                    }
            }

            fun registryItemId(registryItemId: List<String>) =
                registryItemId(JsonField.of(registryItemId))

            /**
             * Sets [Builder.registryItemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.registryItemId] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun registryItemId(registryItemId: JsonField<List<String>>) = apply {
                this.registryItemId = registryItemId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.registryItemId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRegistryItemId(registryItemId: String) = apply {
                this.registryItemId =
                    (this.registryItemId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("registryItemId", it).add(registryItemId)
                    }
            }

            fun registryOrganisationId(registryOrganisationId: List<String>) =
                registryOrganisationId(JsonField.of(registryOrganisationId))

            /**
             * Sets [Builder.registryOrganisationId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.registryOrganisationId] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun registryOrganisationId(registryOrganisationId: JsonField<List<String>>) = apply {
                this.registryOrganisationId = registryOrganisationId.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.registryOrganisationId].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRegistryOrganisationId(registryOrganisationId: String) = apply {
                this.registryOrganisationId =
                    (this.registryOrganisationId ?: JsonField.of(mutableListOf())).also {
                        checkKnown("registryOrganisationId", it).add(registryOrganisationId)
                    }
            }

            fun resolutionUnit(resolutionUnit: String) =
                resolutionUnit(JsonField.of(resolutionUnit))

            /**
             * Sets [Builder.resolutionUnit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resolutionUnit] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resolutionUnit(resolutionUnit: JsonField<String>) = apply {
                this.resolutionUnit = resolutionUnit
            }

            fun rights(rights: String) = rights(JsonField.of(rights))

            /**
             * Sets [Builder.rights] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rights] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun rights(rights: JsonField<String>) = apply { this.rights = rights }

            fun scene(scene: List<String>) = scene(JsonField.of(scene))

            /**
             * Sets [Builder.scene] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scene] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun scene(scene: JsonField<List<String>>) = apply {
                this.scene = scene.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.scene].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addScene(scene: String) = apply {
                this.scene =
                    (this.scene ?: JsonField.of(mutableListOf())).also {
                        checkKnown("scene", it).add(scene)
                    }
            }

            fun source(source: String) = source(JsonField.of(source))

            /**
             * Sets [Builder.source] to an arbitrary JSON value.
             *
             * You should usually call [Builder.source] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun source(source: JsonField<String>) = apply { this.source = source }

            fun specialInstructions(specialInstructions: String) =
                specialInstructions(JsonField.of(specialInstructions))

            /**
             * Sets [Builder.specialInstructions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.specialInstructions] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun specialInstructions(specialInstructions: JsonField<String>) = apply {
                this.specialInstructions = specialInstructions
            }

            fun state(state: String) = state(JsonField.of(state))

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun state(state: JsonField<String>) = apply { this.state = state }

            fun subject(subject: List<String>) = subject(JsonField.of(subject))

            /**
             * Sets [Builder.subject] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subject] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subject(subject: JsonField<List<String>>) = apply {
                this.subject = subject.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.subject].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSubject(subject: String) = apply {
                this.subject =
                    (this.subject ?: JsonField.of(mutableListOf())).also {
                        checkKnown("subject", it).add(subject)
                    }
            }

            fun subjectCode(subjectCode: List<String>) = subjectCode(JsonField.of(subjectCode))

            /**
             * Sets [Builder.subjectCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subjectCode] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subjectCode(subjectCode: JsonField<List<String>>) = apply {
                this.subjectCode = subjectCode.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.subjectCode].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSubjectCode(subjectCode: String) = apply {
                this.subjectCode =
                    (this.subjectCode ?: JsonField.of(mutableListOf())).also {
                        checkKnown("subjectCode", it).add(subjectCode)
                    }
            }

            fun subjectReference(subjectReference: List<String>) =
                subjectReference(JsonField.of(subjectReference))

            /**
             * Sets [Builder.subjectReference] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subjectReference] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun subjectReference(subjectReference: JsonField<List<String>>) = apply {
                this.subjectReference = subjectReference.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.subjectReference].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSubjectReference(subjectReference: String) = apply {
                this.subjectReference =
                    (this.subjectReference ?: JsonField.of(mutableListOf())).also {
                        checkKnown("subjectReference", it).add(subjectReference)
                    }
            }

            fun sublocation(sublocation: String) = sublocation(JsonField.of(sublocation))

            /**
             * Sets [Builder.sublocation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sublocation] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sublocation(sublocation: JsonField<String>) = apply {
                this.sublocation = sublocation
            }

            fun timeCreated(timeCreated: String) = timeCreated(JsonField.of(timeCreated))

            /**
             * Sets [Builder.timeCreated] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timeCreated] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timeCreated(timeCreated: JsonField<String>) = apply {
                this.timeCreated = timeCreated
            }

            fun title(title: String) = title(JsonField.of(title))

            /**
             * Sets [Builder.title] to an arbitrary JSON value.
             *
             * You should usually call [Builder.title] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun title(title: JsonField<String>) = apply { this.title = title }

            fun transmissionReference(transmissionReference: String) =
                transmissionReference(JsonField.of(transmissionReference))

            /**
             * Sets [Builder.transmissionReference] to an arbitrary JSON value.
             *
             * You should usually call [Builder.transmissionReference] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun transmissionReference(transmissionReference: JsonField<String>) = apply {
                this.transmissionReference = transmissionReference
            }

            fun usageTerms(usageTerms: String) = usageTerms(JsonField.of(usageTerms))

            /**
             * Sets [Builder.usageTerms] to an arbitrary JSON value.
             *
             * You should usually call [Builder.usageTerms] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun usageTerms(usageTerms: JsonField<String>) = apply { this.usageTerms = usageTerms }

            fun webStatement(webStatement: String) = webStatement(JsonField.of(webStatement))

            /**
             * Sets [Builder.webStatement] to an arbitrary JSON value.
             *
             * You should usually call [Builder.webStatement] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun webStatement(webStatement: JsonField<String>) = apply {
                this.webStatement = webStatement
            }

            fun writer(writer: String) = writer(JsonField.of(writer))

            /**
             * Sets [Builder.writer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.writer] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun writer(writer: JsonField<String>) = apply { this.writer = writer }

            fun writerEditor(writerEditor: String) = writerEditor(JsonField.of(writerEditor))

            /**
             * Sets [Builder.writerEditor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.writerEditor] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun writerEditor(writerEditor: JsonField<String>) = apply {
                this.writerEditor = writerEditor
            }

            fun xResolution(xResolution: Double) = xResolution(JsonField.of(xResolution))

            /**
             * Sets [Builder.xResolution] to an arbitrary JSON value.
             *
             * You should usually call [Builder.xResolution] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun xResolution(xResolution: JsonField<Double>) = apply {
                this.xResolution = xResolution
            }

            fun yResolution(yResolution: Double) = yResolution(JsonField.of(yResolution))

            /**
             * Sets [Builder.yResolution] to an arbitrary JSON value.
             *
             * You should usually call [Builder.yResolution] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun yResolution(yResolution: JsonField<Double>) = apply {
                this.yResolution = yResolution
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
            fun build(): EmbeddedMetadata =
                EmbeddedMetadata(
                    aboutCvTermCvId,
                    aboutCvTermId,
                    aboutCvTermName,
                    aboutCvTermRefinedAbout,
                    additionalModelInformation,
                    applicationRecordVersion,
                    artist,
                    artworkCircaDateCreated,
                    artworkContentDescription,
                    artworkContributionDescription,
                    artworkCopyrightNotice,
                    artworkCopyrightOwnerId,
                    artworkCopyrightOwnerName,
                    (artworkCreator ?: JsonMissing.of()).map { it.toImmutable() },
                    (artworkCreatorId ?: JsonMissing.of()).map { it.toImmutable() },
                    artworkDateCreated,
                    artworkLicensorId,
                    artworkLicensorName,
                    artworkPhysicalDescription,
                    artworkSource,
                    artworkSourceInventoryNo,
                    artworkSourceInvUrl,
                    (artworkStylePeriod ?: JsonMissing.of()).map { it.toImmutable() },
                    artworkTitle,
                    authorsPosition,
                    byline,
                    bylineTitle,
                    caption,
                    captionAbstract,
                    captionWriter,
                    city,
                    colorSpace,
                    componentsConfiguration,
                    copyright,
                    copyrightNotice,
                    (copyrightOwnerId ?: JsonMissing.of()).map { it.toImmutable() },
                    (copyrightOwnerName ?: JsonMissing.of()).map { it.toImmutable() },
                    country,
                    countryCode,
                    countryPrimaryLocationCode,
                    countryPrimaryLocationName,
                    creator,
                    creatorAddress,
                    creatorCity,
                    creatorCountry,
                    creatorPostalCode,
                    creatorRegion,
                    creatorWorkEmail,
                    creatorWorkTelephone,
                    creatorWorkUrl,
                    credit,
                    dateCreated,
                    dateTimeCreated,
                    dateTimeOriginal,
                    description,
                    digitalImageGuid,
                    digitalSourceType,
                    embeddedEncodedRightsExpr,
                    embeddedEncodedRightsExprLangId,
                    embeddedEncodedRightsExprType,
                    event,
                    exifVersion,
                    flashpixVersion,
                    genreCvId,
                    genreCvTermId,
                    genreCvTermName,
                    genreCvTermRefinedAbout,
                    headline,
                    imageCreatorId,
                    imageCreatorImageId,
                    imageCreatorName,
                    imageDescription,
                    (imageRegionBoundaryH ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionBoundaryRx ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionBoundaryShape ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionBoundaryUnit ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionBoundaryVerticesX ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionBoundaryVerticesY ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionBoundaryW ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionBoundaryX ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionBoundaryY ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionCtypeIdentifier ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionCtypeName ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionId ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionName ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionOrganisationInImageName ?: JsonMissing.of()).map {
                        it.toImmutable()
                    },
                    (imageRegionPersonInImage ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionRoleIdentifier ?: JsonMissing.of()).map { it.toImmutable() },
                    (imageRegionRoleName ?: JsonMissing.of()).map { it.toImmutable() },
                    imageSupplierId,
                    imageSupplierImageId,
                    imageSupplierName,
                    instructions,
                    intellectualGenre,
                    (keywords ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorCity ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorCountry ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorEmail ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorExtendedAddress ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorId ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorName ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorPostalCode ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorRegion ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorStreetAddress ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorTelephone1 ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorTelephone2 ?: JsonMissing.of()).map { it.toImmutable() },
                    (licensorUrl ?: JsonMissing.of()).map { it.toImmutable() },
                    linkedEncodedRightsExpr,
                    linkedEncodedRightsExprLangId,
                    linkedEncodedRightsExprType,
                    location,
                    locationCreatedCity,
                    locationCreatedCountryCode,
                    locationCreatedCountryName,
                    locationCreatedGpsAltitude,
                    locationCreatedGpsLatitude,
                    locationCreatedGpsLongitude,
                    locationCreatedLocationId,
                    locationCreatedLocationName,
                    locationCreatedProvinceState,
                    locationCreatedSublocation,
                    locationCreatedWorldRegion,
                    (locationShownCity ?: JsonMissing.of()).map { it.toImmutable() },
                    (locationShownCountryCode ?: JsonMissing.of()).map { it.toImmutable() },
                    (locationShownCountryName ?: JsonMissing.of()).map { it.toImmutable() },
                    (locationShownGpsAltitude ?: JsonMissing.of()).map { it.toImmutable() },
                    (locationShownGpsLatitude ?: JsonMissing.of()).map { it.toImmutable() },
                    (locationShownGpsLongitude ?: JsonMissing.of()).map { it.toImmutable() },
                    (locationShownLocationId ?: JsonMissing.of()).map { it.toImmutable() },
                    (locationShownLocationName ?: JsonMissing.of()).map { it.toImmutable() },
                    (locationShownProvinceState ?: JsonMissing.of()).map { it.toImmutable() },
                    (locationShownSublocation ?: JsonMissing.of()).map { it.toImmutable() },
                    (locationShownWorldRegion ?: JsonMissing.of()).map { it.toImmutable() },
                    maxAvailHeight,
                    maxAvailWidth,
                    (modelAge ?: JsonMissing.of()).map { it.toImmutable() },
                    (modelReleaseId ?: JsonMissing.of()).map { it.toImmutable() },
                    objectAttributeReference,
                    objectName,
                    offsetTimeOriginal,
                    (organisationInImageCode ?: JsonMissing.of()).map { it.toImmutable() },
                    (organisationInImageName ?: JsonMissing.of()).map { it.toImmutable() },
                    orientation,
                    originalTransmissionReference,
                    (personInImage ?: JsonMissing.of()).map { it.toImmutable() },
                    (personInImageCvTermCvId ?: JsonMissing.of()).map { it.toImmutable() },
                    (personInImageCvTermId ?: JsonMissing.of()).map { it.toImmutable() },
                    (personInImageCvTermName ?: JsonMissing.of()).map { it.toImmutable() },
                    (personInImageCvTermRefinedAbout ?: JsonMissing.of()).map { it.toImmutable() },
                    (personInImageDescription ?: JsonMissing.of()).map { it.toImmutable() },
                    (personInImageId ?: JsonMissing.of()).map { it.toImmutable() },
                    (personInImageName ?: JsonMissing.of()).map { it.toImmutable() },
                    (productInImageDescription ?: JsonMissing.of()).map { it.toImmutable() },
                    (productInImageGtin ?: JsonMissing.of()).map { it.toImmutable() },
                    (productInImageName ?: JsonMissing.of()).map { it.toImmutable() },
                    (propertyReleaseId ?: JsonMissing.of()).map { it.toImmutable() },
                    provinceState,
                    rating,
                    (registryEntryRole ?: JsonMissing.of()).map { it.toImmutable() },
                    (registryItemId ?: JsonMissing.of()).map { it.toImmutable() },
                    (registryOrganisationId ?: JsonMissing.of()).map { it.toImmutable() },
                    resolutionUnit,
                    rights,
                    (scene ?: JsonMissing.of()).map { it.toImmutable() },
                    source,
                    specialInstructions,
                    state,
                    (subject ?: JsonMissing.of()).map { it.toImmutable() },
                    (subjectCode ?: JsonMissing.of()).map { it.toImmutable() },
                    (subjectReference ?: JsonMissing.of()).map { it.toImmutable() },
                    sublocation,
                    timeCreated,
                    title,
                    transmissionReference,
                    usageTerms,
                    webStatement,
                    writer,
                    writerEditor,
                    xResolution,
                    yResolution,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): EmbeddedMetadata = apply {
            if (validated) {
                return@apply
            }

            aboutCvTermCvId()
            aboutCvTermId()
            aboutCvTermName()
            aboutCvTermRefinedAbout()
            additionalModelInformation()
            applicationRecordVersion()
            artist()
            artworkCircaDateCreated()
            artworkContentDescription()
            artworkContributionDescription()
            artworkCopyrightNotice()
            artworkCopyrightOwnerId()
            artworkCopyrightOwnerName()
            artworkCreator()
            artworkCreatorId()
            artworkDateCreated()
            artworkLicensorId()
            artworkLicensorName()
            artworkPhysicalDescription()
            artworkSource()
            artworkSourceInventoryNo()
            artworkSourceInvUrl()
            artworkStylePeriod()
            artworkTitle()
            authorsPosition()
            byline()
            bylineTitle()
            caption()
            captionAbstract()
            captionWriter()
            city()
            colorSpace()
            componentsConfiguration()
            copyright()
            copyrightNotice()
            copyrightOwnerId()
            copyrightOwnerName()
            country()
            countryCode()
            countryPrimaryLocationCode()
            countryPrimaryLocationName()
            creator()
            creatorAddress()
            creatorCity()
            creatorCountry()
            creatorPostalCode()
            creatorRegion()
            creatorWorkEmail()
            creatorWorkTelephone()
            creatorWorkUrl()
            credit()
            dateCreated()
            dateTimeCreated()
            dateTimeOriginal()
            description()
            digitalImageGuid()
            digitalSourceType()
            embeddedEncodedRightsExpr()
            embeddedEncodedRightsExprLangId()
            embeddedEncodedRightsExprType()
            event()
            exifVersion()
            flashpixVersion()
            genreCvId()
            genreCvTermId()
            genreCvTermName()
            genreCvTermRefinedAbout()
            headline()
            imageCreatorId()
            imageCreatorImageId()
            imageCreatorName()
            imageDescription()
            imageRegionBoundaryH()
            imageRegionBoundaryRx()
            imageRegionBoundaryShape()
            imageRegionBoundaryUnit()
            imageRegionBoundaryVerticesX()
            imageRegionBoundaryVerticesY()
            imageRegionBoundaryW()
            imageRegionBoundaryX()
            imageRegionBoundaryY()
            imageRegionCtypeIdentifier()
            imageRegionCtypeName()
            imageRegionId()
            imageRegionName()
            imageRegionOrganisationInImageName()
            imageRegionPersonInImage()
            imageRegionRoleIdentifier()
            imageRegionRoleName()
            imageSupplierId()
            imageSupplierImageId()
            imageSupplierName()
            instructions()
            intellectualGenre()
            keywords()
            licensorCity()
            licensorCountry()
            licensorEmail()
            licensorExtendedAddress()
            licensorId()
            licensorName()
            licensorPostalCode()
            licensorRegion()
            licensorStreetAddress()
            licensorTelephone1()
            licensorTelephone2()
            licensorUrl()
            linkedEncodedRightsExpr()
            linkedEncodedRightsExprLangId()
            linkedEncodedRightsExprType()
            location()
            locationCreatedCity()
            locationCreatedCountryCode()
            locationCreatedCountryName()
            locationCreatedGpsAltitude()
            locationCreatedGpsLatitude()
            locationCreatedGpsLongitude()
            locationCreatedLocationId()
            locationCreatedLocationName()
            locationCreatedProvinceState()
            locationCreatedSublocation()
            locationCreatedWorldRegion()
            locationShownCity()
            locationShownCountryCode()
            locationShownCountryName()
            locationShownGpsAltitude()
            locationShownGpsLatitude()
            locationShownGpsLongitude()
            locationShownLocationId()
            locationShownLocationName()
            locationShownProvinceState()
            locationShownSublocation()
            locationShownWorldRegion()
            maxAvailHeight()
            maxAvailWidth()
            modelAge()
            modelReleaseId()
            objectAttributeReference()
            objectName()
            offsetTimeOriginal()
            organisationInImageCode()
            organisationInImageName()
            orientation()
            originalTransmissionReference()
            personInImage()
            personInImageCvTermCvId()
            personInImageCvTermId()
            personInImageCvTermName()
            personInImageCvTermRefinedAbout()
            personInImageDescription()
            personInImageId()
            personInImageName()
            productInImageDescription()
            productInImageGtin()
            productInImageName()
            propertyReleaseId()
            provinceState()
            rating()
            registryEntryRole()
            registryItemId()
            registryOrganisationId()
            resolutionUnit()
            rights()
            scene()
            source()
            specialInstructions()
            state()
            subject()
            subjectCode()
            subjectReference()
            sublocation()
            timeCreated()
            title()
            transmissionReference()
            usageTerms()
            webStatement()
            writer()
            writerEditor()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (aboutCvTermCvId.asKnown().isPresent) 1 else 0) +
                (if (aboutCvTermId.asKnown().isPresent) 1 else 0) +
                (if (aboutCvTermName.asKnown().isPresent) 1 else 0) +
                (if (aboutCvTermRefinedAbout.asKnown().isPresent) 1 else 0) +
                (if (additionalModelInformation.asKnown().isPresent) 1 else 0) +
                (if (applicationRecordVersion.asKnown().isPresent) 1 else 0) +
                (if (artist.asKnown().isPresent) 1 else 0) +
                (if (artworkCircaDateCreated.asKnown().isPresent) 1 else 0) +
                (if (artworkContentDescription.asKnown().isPresent) 1 else 0) +
                (if (artworkContributionDescription.asKnown().isPresent) 1 else 0) +
                (if (artworkCopyrightNotice.asKnown().isPresent) 1 else 0) +
                (if (artworkCopyrightOwnerId.asKnown().isPresent) 1 else 0) +
                (if (artworkCopyrightOwnerName.asKnown().isPresent) 1 else 0) +
                (artworkCreator.asKnown().getOrNull()?.size ?: 0) +
                (artworkCreatorId.asKnown().getOrNull()?.size ?: 0) +
                (if (artworkDateCreated.asKnown().isPresent) 1 else 0) +
                (if (artworkLicensorId.asKnown().isPresent) 1 else 0) +
                (if (artworkLicensorName.asKnown().isPresent) 1 else 0) +
                (if (artworkPhysicalDescription.asKnown().isPresent) 1 else 0) +
                (if (artworkSource.asKnown().isPresent) 1 else 0) +
                (if (artworkSourceInventoryNo.asKnown().isPresent) 1 else 0) +
                (if (artworkSourceInvUrl.asKnown().isPresent) 1 else 0) +
                (artworkStylePeriod.asKnown().getOrNull()?.size ?: 0) +
                (if (artworkTitle.asKnown().isPresent) 1 else 0) +
                (if (authorsPosition.asKnown().isPresent) 1 else 0) +
                (if (byline.asKnown().isPresent) 1 else 0) +
                (if (bylineTitle.asKnown().isPresent) 1 else 0) +
                (if (caption.asKnown().isPresent) 1 else 0) +
                (if (captionAbstract.asKnown().isPresent) 1 else 0) +
                (if (captionWriter.asKnown().isPresent) 1 else 0) +
                (if (city.asKnown().isPresent) 1 else 0) +
                (if (colorSpace.asKnown().isPresent) 1 else 0) +
                (if (componentsConfiguration.asKnown().isPresent) 1 else 0) +
                (if (copyright.asKnown().isPresent) 1 else 0) +
                (if (copyrightNotice.asKnown().isPresent) 1 else 0) +
                (copyrightOwnerId.asKnown().getOrNull()?.size ?: 0) +
                (copyrightOwnerName.asKnown().getOrNull()?.size ?: 0) +
                (if (country.asKnown().isPresent) 1 else 0) +
                (if (countryCode.asKnown().isPresent) 1 else 0) +
                (if (countryPrimaryLocationCode.asKnown().isPresent) 1 else 0) +
                (if (countryPrimaryLocationName.asKnown().isPresent) 1 else 0) +
                (if (creator.asKnown().isPresent) 1 else 0) +
                (if (creatorAddress.asKnown().isPresent) 1 else 0) +
                (if (creatorCity.asKnown().isPresent) 1 else 0) +
                (if (creatorCountry.asKnown().isPresent) 1 else 0) +
                (if (creatorPostalCode.asKnown().isPresent) 1 else 0) +
                (if (creatorRegion.asKnown().isPresent) 1 else 0) +
                (if (creatorWorkEmail.asKnown().isPresent) 1 else 0) +
                (if (creatorWorkTelephone.asKnown().isPresent) 1 else 0) +
                (if (creatorWorkUrl.asKnown().isPresent) 1 else 0) +
                (if (credit.asKnown().isPresent) 1 else 0) +
                (if (dateCreated.asKnown().isPresent) 1 else 0) +
                (if (dateTimeCreated.asKnown().isPresent) 1 else 0) +
                (if (dateTimeOriginal.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (digitalImageGuid.asKnown().isPresent) 1 else 0) +
                (if (digitalSourceType.asKnown().isPresent) 1 else 0) +
                (if (embeddedEncodedRightsExpr.asKnown().isPresent) 1 else 0) +
                (if (embeddedEncodedRightsExprLangId.asKnown().isPresent) 1 else 0) +
                (if (embeddedEncodedRightsExprType.asKnown().isPresent) 1 else 0) +
                (if (event.asKnown().isPresent) 1 else 0) +
                (if (exifVersion.asKnown().isPresent) 1 else 0) +
                (if (flashpixVersion.asKnown().isPresent) 1 else 0) +
                (if (genreCvId.asKnown().isPresent) 1 else 0) +
                (if (genreCvTermId.asKnown().isPresent) 1 else 0) +
                (if (genreCvTermName.asKnown().isPresent) 1 else 0) +
                (if (genreCvTermRefinedAbout.asKnown().isPresent) 1 else 0) +
                (if (headline.asKnown().isPresent) 1 else 0) +
                (if (imageCreatorId.asKnown().isPresent) 1 else 0) +
                (if (imageCreatorImageId.asKnown().isPresent) 1 else 0) +
                (if (imageCreatorName.asKnown().isPresent) 1 else 0) +
                (if (imageDescription.asKnown().isPresent) 1 else 0) +
                (imageRegionBoundaryH.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionBoundaryRx.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionBoundaryShape.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionBoundaryUnit.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionBoundaryVerticesX.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionBoundaryVerticesY.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionBoundaryW.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionBoundaryX.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionBoundaryY.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionCtypeIdentifier.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionCtypeName.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionId.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionName.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionOrganisationInImageName.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionPersonInImage.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionRoleIdentifier.asKnown().getOrNull()?.size ?: 0) +
                (imageRegionRoleName.asKnown().getOrNull()?.size ?: 0) +
                (if (imageSupplierId.asKnown().isPresent) 1 else 0) +
                (if (imageSupplierImageId.asKnown().isPresent) 1 else 0) +
                (if (imageSupplierName.asKnown().isPresent) 1 else 0) +
                (if (instructions.asKnown().isPresent) 1 else 0) +
                (if (intellectualGenre.asKnown().isPresent) 1 else 0) +
                (keywords.asKnown().getOrNull()?.size ?: 0) +
                (licensorCity.asKnown().getOrNull()?.size ?: 0) +
                (licensorCountry.asKnown().getOrNull()?.size ?: 0) +
                (licensorEmail.asKnown().getOrNull()?.size ?: 0) +
                (licensorExtendedAddress.asKnown().getOrNull()?.size ?: 0) +
                (licensorId.asKnown().getOrNull()?.size ?: 0) +
                (licensorName.asKnown().getOrNull()?.size ?: 0) +
                (licensorPostalCode.asKnown().getOrNull()?.size ?: 0) +
                (licensorRegion.asKnown().getOrNull()?.size ?: 0) +
                (licensorStreetAddress.asKnown().getOrNull()?.size ?: 0) +
                (licensorTelephone1.asKnown().getOrNull()?.size ?: 0) +
                (licensorTelephone2.asKnown().getOrNull()?.size ?: 0) +
                (licensorUrl.asKnown().getOrNull()?.size ?: 0) +
                (if (linkedEncodedRightsExpr.asKnown().isPresent) 1 else 0) +
                (if (linkedEncodedRightsExprLangId.asKnown().isPresent) 1 else 0) +
                (if (linkedEncodedRightsExprType.asKnown().isPresent) 1 else 0) +
                (if (location.asKnown().isPresent) 1 else 0) +
                (if (locationCreatedCity.asKnown().isPresent) 1 else 0) +
                (if (locationCreatedCountryCode.asKnown().isPresent) 1 else 0) +
                (if (locationCreatedCountryName.asKnown().isPresent) 1 else 0) +
                (if (locationCreatedGpsAltitude.asKnown().isPresent) 1 else 0) +
                (if (locationCreatedGpsLatitude.asKnown().isPresent) 1 else 0) +
                (if (locationCreatedGpsLongitude.asKnown().isPresent) 1 else 0) +
                (if (locationCreatedLocationId.asKnown().isPresent) 1 else 0) +
                (if (locationCreatedLocationName.asKnown().isPresent) 1 else 0) +
                (if (locationCreatedProvinceState.asKnown().isPresent) 1 else 0) +
                (if (locationCreatedSublocation.asKnown().isPresent) 1 else 0) +
                (if (locationCreatedWorldRegion.asKnown().isPresent) 1 else 0) +
                (locationShownCity.asKnown().getOrNull()?.size ?: 0) +
                (locationShownCountryCode.asKnown().getOrNull()?.size ?: 0) +
                (locationShownCountryName.asKnown().getOrNull()?.size ?: 0) +
                (locationShownGpsAltitude.asKnown().getOrNull()?.size ?: 0) +
                (locationShownGpsLatitude.asKnown().getOrNull()?.size ?: 0) +
                (locationShownGpsLongitude.asKnown().getOrNull()?.size ?: 0) +
                (locationShownLocationId.asKnown().getOrNull()?.size ?: 0) +
                (locationShownLocationName.asKnown().getOrNull()?.size ?: 0) +
                (locationShownProvinceState.asKnown().getOrNull()?.size ?: 0) +
                (locationShownSublocation.asKnown().getOrNull()?.size ?: 0) +
                (locationShownWorldRegion.asKnown().getOrNull()?.size ?: 0) +
                (if (maxAvailHeight.asKnown().isPresent) 1 else 0) +
                (if (maxAvailWidth.asKnown().isPresent) 1 else 0) +
                (modelAge.asKnown().getOrNull()?.size ?: 0) +
                (modelReleaseId.asKnown().getOrNull()?.size ?: 0) +
                (if (objectAttributeReference.asKnown().isPresent) 1 else 0) +
                (if (objectName.asKnown().isPresent) 1 else 0) +
                (if (offsetTimeOriginal.asKnown().isPresent) 1 else 0) +
                (organisationInImageCode.asKnown().getOrNull()?.size ?: 0) +
                (organisationInImageName.asKnown().getOrNull()?.size ?: 0) +
                (if (orientation.asKnown().isPresent) 1 else 0) +
                (if (originalTransmissionReference.asKnown().isPresent) 1 else 0) +
                (personInImage.asKnown().getOrNull()?.size ?: 0) +
                (personInImageCvTermCvId.asKnown().getOrNull()?.size ?: 0) +
                (personInImageCvTermId.asKnown().getOrNull()?.size ?: 0) +
                (personInImageCvTermName.asKnown().getOrNull()?.size ?: 0) +
                (personInImageCvTermRefinedAbout.asKnown().getOrNull()?.size ?: 0) +
                (personInImageDescription.asKnown().getOrNull()?.size ?: 0) +
                (personInImageId.asKnown().getOrNull()?.size ?: 0) +
                (personInImageName.asKnown().getOrNull()?.size ?: 0) +
                (productInImageDescription.asKnown().getOrNull()?.size ?: 0) +
                (productInImageGtin.asKnown().getOrNull()?.size ?: 0) +
                (productInImageName.asKnown().getOrNull()?.size ?: 0) +
                (propertyReleaseId.asKnown().getOrNull()?.size ?: 0) +
                (if (provinceState.asKnown().isPresent) 1 else 0) +
                (if (rating.asKnown().isPresent) 1 else 0) +
                (registryEntryRole.asKnown().getOrNull()?.size ?: 0) +
                (registryItemId.asKnown().getOrNull()?.size ?: 0) +
                (registryOrganisationId.asKnown().getOrNull()?.size ?: 0) +
                (if (resolutionUnit.asKnown().isPresent) 1 else 0) +
                (if (rights.asKnown().isPresent) 1 else 0) +
                (scene.asKnown().getOrNull()?.size ?: 0) +
                (if (source.asKnown().isPresent) 1 else 0) +
                (if (specialInstructions.asKnown().isPresent) 1 else 0) +
                (if (state.asKnown().isPresent) 1 else 0) +
                (subject.asKnown().getOrNull()?.size ?: 0) +
                (subjectCode.asKnown().getOrNull()?.size ?: 0) +
                (subjectReference.asKnown().getOrNull()?.size ?: 0) +
                (if (sublocation.asKnown().isPresent) 1 else 0) +
                (if (timeCreated.asKnown().isPresent) 1 else 0) +
                (if (title.asKnown().isPresent) 1 else 0) +
                (if (transmissionReference.asKnown().isPresent) 1 else 0) +
                (if (usageTerms.asKnown().isPresent) 1 else 0) +
                (if (webStatement.asKnown().isPresent) 1 else 0) +
                (if (writer.asKnown().isPresent) 1 else 0) +
                (if (writerEditor.asKnown().isPresent) 1 else 0) +
                (if (xResolution.asKnown().isPresent) 1 else 0) +
                (if (yResolution.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EmbeddedMetadata &&
                aboutCvTermCvId == other.aboutCvTermCvId &&
                aboutCvTermId == other.aboutCvTermId &&
                aboutCvTermName == other.aboutCvTermName &&
                aboutCvTermRefinedAbout == other.aboutCvTermRefinedAbout &&
                additionalModelInformation == other.additionalModelInformation &&
                applicationRecordVersion == other.applicationRecordVersion &&
                artist == other.artist &&
                artworkCircaDateCreated == other.artworkCircaDateCreated &&
                artworkContentDescription == other.artworkContentDescription &&
                artworkContributionDescription == other.artworkContributionDescription &&
                artworkCopyrightNotice == other.artworkCopyrightNotice &&
                artworkCopyrightOwnerId == other.artworkCopyrightOwnerId &&
                artworkCopyrightOwnerName == other.artworkCopyrightOwnerName &&
                artworkCreator == other.artworkCreator &&
                artworkCreatorId == other.artworkCreatorId &&
                artworkDateCreated == other.artworkDateCreated &&
                artworkLicensorId == other.artworkLicensorId &&
                artworkLicensorName == other.artworkLicensorName &&
                artworkPhysicalDescription == other.artworkPhysicalDescription &&
                artworkSource == other.artworkSource &&
                artworkSourceInventoryNo == other.artworkSourceInventoryNo &&
                artworkSourceInvUrl == other.artworkSourceInvUrl &&
                artworkStylePeriod == other.artworkStylePeriod &&
                artworkTitle == other.artworkTitle &&
                authorsPosition == other.authorsPosition &&
                byline == other.byline &&
                bylineTitle == other.bylineTitle &&
                caption == other.caption &&
                captionAbstract == other.captionAbstract &&
                captionWriter == other.captionWriter &&
                city == other.city &&
                colorSpace == other.colorSpace &&
                componentsConfiguration == other.componentsConfiguration &&
                copyright == other.copyright &&
                copyrightNotice == other.copyrightNotice &&
                copyrightOwnerId == other.copyrightOwnerId &&
                copyrightOwnerName == other.copyrightOwnerName &&
                country == other.country &&
                countryCode == other.countryCode &&
                countryPrimaryLocationCode == other.countryPrimaryLocationCode &&
                countryPrimaryLocationName == other.countryPrimaryLocationName &&
                creator == other.creator &&
                creatorAddress == other.creatorAddress &&
                creatorCity == other.creatorCity &&
                creatorCountry == other.creatorCountry &&
                creatorPostalCode == other.creatorPostalCode &&
                creatorRegion == other.creatorRegion &&
                creatorWorkEmail == other.creatorWorkEmail &&
                creatorWorkTelephone == other.creatorWorkTelephone &&
                creatorWorkUrl == other.creatorWorkUrl &&
                credit == other.credit &&
                dateCreated == other.dateCreated &&
                dateTimeCreated == other.dateTimeCreated &&
                dateTimeOriginal == other.dateTimeOriginal &&
                description == other.description &&
                digitalImageGuid == other.digitalImageGuid &&
                digitalSourceType == other.digitalSourceType &&
                embeddedEncodedRightsExpr == other.embeddedEncodedRightsExpr &&
                embeddedEncodedRightsExprLangId == other.embeddedEncodedRightsExprLangId &&
                embeddedEncodedRightsExprType == other.embeddedEncodedRightsExprType &&
                event == other.event &&
                exifVersion == other.exifVersion &&
                flashpixVersion == other.flashpixVersion &&
                genreCvId == other.genreCvId &&
                genreCvTermId == other.genreCvTermId &&
                genreCvTermName == other.genreCvTermName &&
                genreCvTermRefinedAbout == other.genreCvTermRefinedAbout &&
                headline == other.headline &&
                imageCreatorId == other.imageCreatorId &&
                imageCreatorImageId == other.imageCreatorImageId &&
                imageCreatorName == other.imageCreatorName &&
                imageDescription == other.imageDescription &&
                imageRegionBoundaryH == other.imageRegionBoundaryH &&
                imageRegionBoundaryRx == other.imageRegionBoundaryRx &&
                imageRegionBoundaryShape == other.imageRegionBoundaryShape &&
                imageRegionBoundaryUnit == other.imageRegionBoundaryUnit &&
                imageRegionBoundaryVerticesX == other.imageRegionBoundaryVerticesX &&
                imageRegionBoundaryVerticesY == other.imageRegionBoundaryVerticesY &&
                imageRegionBoundaryW == other.imageRegionBoundaryW &&
                imageRegionBoundaryX == other.imageRegionBoundaryX &&
                imageRegionBoundaryY == other.imageRegionBoundaryY &&
                imageRegionCtypeIdentifier == other.imageRegionCtypeIdentifier &&
                imageRegionCtypeName == other.imageRegionCtypeName &&
                imageRegionId == other.imageRegionId &&
                imageRegionName == other.imageRegionName &&
                imageRegionOrganisationInImageName == other.imageRegionOrganisationInImageName &&
                imageRegionPersonInImage == other.imageRegionPersonInImage &&
                imageRegionRoleIdentifier == other.imageRegionRoleIdentifier &&
                imageRegionRoleName == other.imageRegionRoleName &&
                imageSupplierId == other.imageSupplierId &&
                imageSupplierImageId == other.imageSupplierImageId &&
                imageSupplierName == other.imageSupplierName &&
                instructions == other.instructions &&
                intellectualGenre == other.intellectualGenre &&
                keywords == other.keywords &&
                licensorCity == other.licensorCity &&
                licensorCountry == other.licensorCountry &&
                licensorEmail == other.licensorEmail &&
                licensorExtendedAddress == other.licensorExtendedAddress &&
                licensorId == other.licensorId &&
                licensorName == other.licensorName &&
                licensorPostalCode == other.licensorPostalCode &&
                licensorRegion == other.licensorRegion &&
                licensorStreetAddress == other.licensorStreetAddress &&
                licensorTelephone1 == other.licensorTelephone1 &&
                licensorTelephone2 == other.licensorTelephone2 &&
                licensorUrl == other.licensorUrl &&
                linkedEncodedRightsExpr == other.linkedEncodedRightsExpr &&
                linkedEncodedRightsExprLangId == other.linkedEncodedRightsExprLangId &&
                linkedEncodedRightsExprType == other.linkedEncodedRightsExprType &&
                location == other.location &&
                locationCreatedCity == other.locationCreatedCity &&
                locationCreatedCountryCode == other.locationCreatedCountryCode &&
                locationCreatedCountryName == other.locationCreatedCountryName &&
                locationCreatedGpsAltitude == other.locationCreatedGpsAltitude &&
                locationCreatedGpsLatitude == other.locationCreatedGpsLatitude &&
                locationCreatedGpsLongitude == other.locationCreatedGpsLongitude &&
                locationCreatedLocationId == other.locationCreatedLocationId &&
                locationCreatedLocationName == other.locationCreatedLocationName &&
                locationCreatedProvinceState == other.locationCreatedProvinceState &&
                locationCreatedSublocation == other.locationCreatedSublocation &&
                locationCreatedWorldRegion == other.locationCreatedWorldRegion &&
                locationShownCity == other.locationShownCity &&
                locationShownCountryCode == other.locationShownCountryCode &&
                locationShownCountryName == other.locationShownCountryName &&
                locationShownGpsAltitude == other.locationShownGpsAltitude &&
                locationShownGpsLatitude == other.locationShownGpsLatitude &&
                locationShownGpsLongitude == other.locationShownGpsLongitude &&
                locationShownLocationId == other.locationShownLocationId &&
                locationShownLocationName == other.locationShownLocationName &&
                locationShownProvinceState == other.locationShownProvinceState &&
                locationShownSublocation == other.locationShownSublocation &&
                locationShownWorldRegion == other.locationShownWorldRegion &&
                maxAvailHeight == other.maxAvailHeight &&
                maxAvailWidth == other.maxAvailWidth &&
                modelAge == other.modelAge &&
                modelReleaseId == other.modelReleaseId &&
                objectAttributeReference == other.objectAttributeReference &&
                objectName == other.objectName &&
                offsetTimeOriginal == other.offsetTimeOriginal &&
                organisationInImageCode == other.organisationInImageCode &&
                organisationInImageName == other.organisationInImageName &&
                orientation == other.orientation &&
                originalTransmissionReference == other.originalTransmissionReference &&
                personInImage == other.personInImage &&
                personInImageCvTermCvId == other.personInImageCvTermCvId &&
                personInImageCvTermId == other.personInImageCvTermId &&
                personInImageCvTermName == other.personInImageCvTermName &&
                personInImageCvTermRefinedAbout == other.personInImageCvTermRefinedAbout &&
                personInImageDescription == other.personInImageDescription &&
                personInImageId == other.personInImageId &&
                personInImageName == other.personInImageName &&
                productInImageDescription == other.productInImageDescription &&
                productInImageGtin == other.productInImageGtin &&
                productInImageName == other.productInImageName &&
                propertyReleaseId == other.propertyReleaseId &&
                provinceState == other.provinceState &&
                rating == other.rating &&
                registryEntryRole == other.registryEntryRole &&
                registryItemId == other.registryItemId &&
                registryOrganisationId == other.registryOrganisationId &&
                resolutionUnit == other.resolutionUnit &&
                rights == other.rights &&
                scene == other.scene &&
                source == other.source &&
                specialInstructions == other.specialInstructions &&
                state == other.state &&
                subject == other.subject &&
                subjectCode == other.subjectCode &&
                subjectReference == other.subjectReference &&
                sublocation == other.sublocation &&
                timeCreated == other.timeCreated &&
                title == other.title &&
                transmissionReference == other.transmissionReference &&
                usageTerms == other.usageTerms &&
                webStatement == other.webStatement &&
                writer == other.writer &&
                writerEditor == other.writerEditor &&
                xResolution == other.xResolution &&
                yResolution == other.yResolution &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                aboutCvTermCvId,
                aboutCvTermId,
                aboutCvTermName,
                aboutCvTermRefinedAbout,
                additionalModelInformation,
                applicationRecordVersion,
                artist,
                artworkCircaDateCreated,
                artworkContentDescription,
                artworkContributionDescription,
                artworkCopyrightNotice,
                artworkCopyrightOwnerId,
                artworkCopyrightOwnerName,
                artworkCreator,
                artworkCreatorId,
                artworkDateCreated,
                artworkLicensorId,
                artworkLicensorName,
                artworkPhysicalDescription,
                artworkSource,
                artworkSourceInventoryNo,
                artworkSourceInvUrl,
                artworkStylePeriod,
                artworkTitle,
                authorsPosition,
                byline,
                bylineTitle,
                caption,
                captionAbstract,
                captionWriter,
                city,
                colorSpace,
                componentsConfiguration,
                copyright,
                copyrightNotice,
                copyrightOwnerId,
                copyrightOwnerName,
                country,
                countryCode,
                countryPrimaryLocationCode,
                countryPrimaryLocationName,
                creator,
                creatorAddress,
                creatorCity,
                creatorCountry,
                creatorPostalCode,
                creatorRegion,
                creatorWorkEmail,
                creatorWorkTelephone,
                creatorWorkUrl,
                credit,
                dateCreated,
                dateTimeCreated,
                dateTimeOriginal,
                description,
                digitalImageGuid,
                digitalSourceType,
                embeddedEncodedRightsExpr,
                embeddedEncodedRightsExprLangId,
                embeddedEncodedRightsExprType,
                event,
                exifVersion,
                flashpixVersion,
                genreCvId,
                genreCvTermId,
                genreCvTermName,
                genreCvTermRefinedAbout,
                headline,
                imageCreatorId,
                imageCreatorImageId,
                imageCreatorName,
                imageDescription,
                imageRegionBoundaryH,
                imageRegionBoundaryRx,
                imageRegionBoundaryShape,
                imageRegionBoundaryUnit,
                imageRegionBoundaryVerticesX,
                imageRegionBoundaryVerticesY,
                imageRegionBoundaryW,
                imageRegionBoundaryX,
                imageRegionBoundaryY,
                imageRegionCtypeIdentifier,
                imageRegionCtypeName,
                imageRegionId,
                imageRegionName,
                imageRegionOrganisationInImageName,
                imageRegionPersonInImage,
                imageRegionRoleIdentifier,
                imageRegionRoleName,
                imageSupplierId,
                imageSupplierImageId,
                imageSupplierName,
                instructions,
                intellectualGenre,
                keywords,
                licensorCity,
                licensorCountry,
                licensorEmail,
                licensorExtendedAddress,
                licensorId,
                licensorName,
                licensorPostalCode,
                licensorRegion,
                licensorStreetAddress,
                licensorTelephone1,
                licensorTelephone2,
                licensorUrl,
                linkedEncodedRightsExpr,
                linkedEncodedRightsExprLangId,
                linkedEncodedRightsExprType,
                location,
                locationCreatedCity,
                locationCreatedCountryCode,
                locationCreatedCountryName,
                locationCreatedGpsAltitude,
                locationCreatedGpsLatitude,
                locationCreatedGpsLongitude,
                locationCreatedLocationId,
                locationCreatedLocationName,
                locationCreatedProvinceState,
                locationCreatedSublocation,
                locationCreatedWorldRegion,
                locationShownCity,
                locationShownCountryCode,
                locationShownCountryName,
                locationShownGpsAltitude,
                locationShownGpsLatitude,
                locationShownGpsLongitude,
                locationShownLocationId,
                locationShownLocationName,
                locationShownProvinceState,
                locationShownSublocation,
                locationShownWorldRegion,
                maxAvailHeight,
                maxAvailWidth,
                modelAge,
                modelReleaseId,
                objectAttributeReference,
                objectName,
                offsetTimeOriginal,
                organisationInImageCode,
                organisationInImageName,
                orientation,
                originalTransmissionReference,
                personInImage,
                personInImageCvTermCvId,
                personInImageCvTermId,
                personInImageCvTermName,
                personInImageCvTermRefinedAbout,
                personInImageDescription,
                personInImageId,
                personInImageName,
                productInImageDescription,
                productInImageGtin,
                productInImageName,
                propertyReleaseId,
                provinceState,
                rating,
                registryEntryRole,
                registryItemId,
                registryOrganisationId,
                resolutionUnit,
                rights,
                scene,
                source,
                specialInstructions,
                state,
                subject,
                subjectCode,
                subjectReference,
                sublocation,
                timeCreated,
                title,
                transmissionReference,
                usageTerms,
                webStatement,
                writer,
                writerEditor,
                xResolution,
                yResolution,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "EmbeddedMetadata{aboutCvTermCvId=$aboutCvTermCvId, aboutCvTermId=$aboutCvTermId, aboutCvTermName=$aboutCvTermName, aboutCvTermRefinedAbout=$aboutCvTermRefinedAbout, additionalModelInformation=$additionalModelInformation, applicationRecordVersion=$applicationRecordVersion, artist=$artist, artworkCircaDateCreated=$artworkCircaDateCreated, artworkContentDescription=$artworkContentDescription, artworkContributionDescription=$artworkContributionDescription, artworkCopyrightNotice=$artworkCopyrightNotice, artworkCopyrightOwnerId=$artworkCopyrightOwnerId, artworkCopyrightOwnerName=$artworkCopyrightOwnerName, artworkCreator=$artworkCreator, artworkCreatorId=$artworkCreatorId, artworkDateCreated=$artworkDateCreated, artworkLicensorId=$artworkLicensorId, artworkLicensorName=$artworkLicensorName, artworkPhysicalDescription=$artworkPhysicalDescription, artworkSource=$artworkSource, artworkSourceInventoryNo=$artworkSourceInventoryNo, artworkSourceInvUrl=$artworkSourceInvUrl, artworkStylePeriod=$artworkStylePeriod, artworkTitle=$artworkTitle, authorsPosition=$authorsPosition, byline=$byline, bylineTitle=$bylineTitle, caption=$caption, captionAbstract=$captionAbstract, captionWriter=$captionWriter, city=$city, colorSpace=$colorSpace, componentsConfiguration=$componentsConfiguration, copyright=$copyright, copyrightNotice=$copyrightNotice, copyrightOwnerId=$copyrightOwnerId, copyrightOwnerName=$copyrightOwnerName, country=$country, countryCode=$countryCode, countryPrimaryLocationCode=$countryPrimaryLocationCode, countryPrimaryLocationName=$countryPrimaryLocationName, creator=$creator, creatorAddress=$creatorAddress, creatorCity=$creatorCity, creatorCountry=$creatorCountry, creatorPostalCode=$creatorPostalCode, creatorRegion=$creatorRegion, creatorWorkEmail=$creatorWorkEmail, creatorWorkTelephone=$creatorWorkTelephone, creatorWorkUrl=$creatorWorkUrl, credit=$credit, dateCreated=$dateCreated, dateTimeCreated=$dateTimeCreated, dateTimeOriginal=$dateTimeOriginal, description=$description, digitalImageGuid=$digitalImageGuid, digitalSourceType=$digitalSourceType, embeddedEncodedRightsExpr=$embeddedEncodedRightsExpr, embeddedEncodedRightsExprLangId=$embeddedEncodedRightsExprLangId, embeddedEncodedRightsExprType=$embeddedEncodedRightsExprType, event=$event, exifVersion=$exifVersion, flashpixVersion=$flashpixVersion, genreCvId=$genreCvId, genreCvTermId=$genreCvTermId, genreCvTermName=$genreCvTermName, genreCvTermRefinedAbout=$genreCvTermRefinedAbout, headline=$headline, imageCreatorId=$imageCreatorId, imageCreatorImageId=$imageCreatorImageId, imageCreatorName=$imageCreatorName, imageDescription=$imageDescription, imageRegionBoundaryH=$imageRegionBoundaryH, imageRegionBoundaryRx=$imageRegionBoundaryRx, imageRegionBoundaryShape=$imageRegionBoundaryShape, imageRegionBoundaryUnit=$imageRegionBoundaryUnit, imageRegionBoundaryVerticesX=$imageRegionBoundaryVerticesX, imageRegionBoundaryVerticesY=$imageRegionBoundaryVerticesY, imageRegionBoundaryW=$imageRegionBoundaryW, imageRegionBoundaryX=$imageRegionBoundaryX, imageRegionBoundaryY=$imageRegionBoundaryY, imageRegionCtypeIdentifier=$imageRegionCtypeIdentifier, imageRegionCtypeName=$imageRegionCtypeName, imageRegionId=$imageRegionId, imageRegionName=$imageRegionName, imageRegionOrganisationInImageName=$imageRegionOrganisationInImageName, imageRegionPersonInImage=$imageRegionPersonInImage, imageRegionRoleIdentifier=$imageRegionRoleIdentifier, imageRegionRoleName=$imageRegionRoleName, imageSupplierId=$imageSupplierId, imageSupplierImageId=$imageSupplierImageId, imageSupplierName=$imageSupplierName, instructions=$instructions, intellectualGenre=$intellectualGenre, keywords=$keywords, licensorCity=$licensorCity, licensorCountry=$licensorCountry, licensorEmail=$licensorEmail, licensorExtendedAddress=$licensorExtendedAddress, licensorId=$licensorId, licensorName=$licensorName, licensorPostalCode=$licensorPostalCode, licensorRegion=$licensorRegion, licensorStreetAddress=$licensorStreetAddress, licensorTelephone1=$licensorTelephone1, licensorTelephone2=$licensorTelephone2, licensorUrl=$licensorUrl, linkedEncodedRightsExpr=$linkedEncodedRightsExpr, linkedEncodedRightsExprLangId=$linkedEncodedRightsExprLangId, linkedEncodedRightsExprType=$linkedEncodedRightsExprType, location=$location, locationCreatedCity=$locationCreatedCity, locationCreatedCountryCode=$locationCreatedCountryCode, locationCreatedCountryName=$locationCreatedCountryName, locationCreatedGpsAltitude=$locationCreatedGpsAltitude, locationCreatedGpsLatitude=$locationCreatedGpsLatitude, locationCreatedGpsLongitude=$locationCreatedGpsLongitude, locationCreatedLocationId=$locationCreatedLocationId, locationCreatedLocationName=$locationCreatedLocationName, locationCreatedProvinceState=$locationCreatedProvinceState, locationCreatedSublocation=$locationCreatedSublocation, locationCreatedWorldRegion=$locationCreatedWorldRegion, locationShownCity=$locationShownCity, locationShownCountryCode=$locationShownCountryCode, locationShownCountryName=$locationShownCountryName, locationShownGpsAltitude=$locationShownGpsAltitude, locationShownGpsLatitude=$locationShownGpsLatitude, locationShownGpsLongitude=$locationShownGpsLongitude, locationShownLocationId=$locationShownLocationId, locationShownLocationName=$locationShownLocationName, locationShownProvinceState=$locationShownProvinceState, locationShownSublocation=$locationShownSublocation, locationShownWorldRegion=$locationShownWorldRegion, maxAvailHeight=$maxAvailHeight, maxAvailWidth=$maxAvailWidth, modelAge=$modelAge, modelReleaseId=$modelReleaseId, objectAttributeReference=$objectAttributeReference, objectName=$objectName, offsetTimeOriginal=$offsetTimeOriginal, organisationInImageCode=$organisationInImageCode, organisationInImageName=$organisationInImageName, orientation=$orientation, originalTransmissionReference=$originalTransmissionReference, personInImage=$personInImage, personInImageCvTermCvId=$personInImageCvTermCvId, personInImageCvTermId=$personInImageCvTermId, personInImageCvTermName=$personInImageCvTermName, personInImageCvTermRefinedAbout=$personInImageCvTermRefinedAbout, personInImageDescription=$personInImageDescription, personInImageId=$personInImageId, personInImageName=$personInImageName, productInImageDescription=$productInImageDescription, productInImageGtin=$productInImageGtin, productInImageName=$productInImageName, propertyReleaseId=$propertyReleaseId, provinceState=$provinceState, rating=$rating, registryEntryRole=$registryEntryRole, registryItemId=$registryItemId, registryOrganisationId=$registryOrganisationId, resolutionUnit=$resolutionUnit, rights=$rights, scene=$scene, source=$source, specialInstructions=$specialInstructions, state=$state, subject=$subject, subjectCode=$subjectCode, subjectReference=$subjectReference, sublocation=$sublocation, timeCreated=$timeCreated, title=$title, transmissionReference=$transmissionReference, usageTerms=$usageTerms, webStatement=$webStatement, writer=$writer, writerEditor=$writerEditor, xResolution=$xResolution, yResolution=$yResolution, additionalProperties=$additionalProperties}"
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

        return other is FileUploadV1Response &&
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
        "FileUploadV1Response{aiTags=$aiTags, audioCodec=$audioCodec, bitRate=$bitRate, customCoordinates=$customCoordinates, customMetadata=$customMetadata, duration=$duration, embeddedMetadata=$embeddedMetadata, extensionStatus=$extensionStatus, fileId=$fileId, filePath=$filePath, fileType=$fileType, height=$height, isPrivateFile=$isPrivateFile, isPublished=$isPublished, metadata=$metadata, name=$name, size=$size, tags=$tags, thumbnailUrl=$thumbnailUrl, url=$url, versionInfo=$versionInfo, videoCodec=$videoCodec, width=$width, additionalProperties=$additionalProperties}"
}
