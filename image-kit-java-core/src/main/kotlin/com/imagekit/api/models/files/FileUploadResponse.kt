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
            private val exif: JsonField<InnerExif>,
            private val gps: JsonField<Gps>,
            private val image: JsonField<Image>,
            private val interoperability: JsonField<Interoperability>,
            private val makernote: JsonField<Makernote>,
            private val thumbnail: JsonField<Thumbnail>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("exif") @ExcludeMissing exif: JsonField<InnerExif> = JsonMissing.of(),
                @JsonProperty("gps") @ExcludeMissing gps: JsonField<Gps> = JsonMissing.of(),
                @JsonProperty("image") @ExcludeMissing image: JsonField<Image> = JsonMissing.of(),
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
            fun exif(): Optional<InnerExif> = exif.getOptional("exif")

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
            fun image(): Optional<Image> = image.getOptional("image")

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
            @JsonProperty("exif") @ExcludeMissing fun _exif(): JsonField<InnerExif> = exif

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
            @JsonProperty("image") @ExcludeMissing fun _image(): JsonField<Image> = image

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

                private var exif: JsonField<InnerExif> = JsonMissing.of()
                private var gps: JsonField<Gps> = JsonMissing.of()
                private var image: JsonField<Image> = JsonMissing.of()
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
                fun exif(exif: InnerExif) = exif(JsonField.of(exif))

                /**
                 * Sets [Builder.exif] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.exif] with a well-typed [InnerExif] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun exif(exif: JsonField<InnerExif>) = apply { this.exif = exif }

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
                fun image(image: Image) = image(JsonField.of(image))

                /**
                 * Sets [Builder.image] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.image] with a well-typed [Image] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun image(image: JsonField<Image>) = apply { this.image = image }

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

            /** Object containing Exif details. */
            class InnerExif
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
                    @JsonProperty("ColorSpace")
                    @ExcludeMissing
                    colorSpace: JsonField<Long> = JsonMissing.of(),
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
                    @JsonProperty("Flash")
                    @ExcludeMissing
                    flash: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("FlashpixVersion")
                    @ExcludeMissing
                    flashpixVersion: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("FNumber")
                    @ExcludeMissing
                    fNumber: JsonField<Double> = JsonMissing.of(),
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
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun apertureValue(): Optional<Double> = apertureValue.getOptional("ApertureValue")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun colorSpace(): Optional<Long> = colorSpace.getOptional("ColorSpace")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun createDate(): Optional<String> = createDate.getOptional("CreateDate")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun customRendered(): Optional<Long> = customRendered.getOptional("CustomRendered")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun dateTimeOriginal(): Optional<String> =
                    dateTimeOriginal.getOptional("DateTimeOriginal")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun exifImageHeight(): Optional<Long> =
                    exifImageHeight.getOptional("ExifImageHeight")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun exifImageWidth(): Optional<Long> = exifImageWidth.getOptional("ExifImageWidth")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun exifVersion(): Optional<String> = exifVersion.getOptional("ExifVersion")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun exposureCompensation(): Optional<Double> =
                    exposureCompensation.getOptional("ExposureCompensation")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun exposureMode(): Optional<Long> = exposureMode.getOptional("ExposureMode")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun exposureProgram(): Optional<Long> =
                    exposureProgram.getOptional("ExposureProgram")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun exposureTime(): Optional<Double> = exposureTime.getOptional("ExposureTime")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun flash(): Optional<Long> = flash.getOptional("Flash")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun flashpixVersion(): Optional<String> =
                    flashpixVersion.getOptional("FlashpixVersion")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun fNumber(): Optional<Double> = fNumber.getOptional("FNumber")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun focalLength(): Optional<Long> = focalLength.getOptional("FocalLength")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun focalPlaneResolutionUnit(): Optional<Long> =
                    focalPlaneResolutionUnit.getOptional("FocalPlaneResolutionUnit")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun focalPlaneXResolution(): Optional<Double> =
                    focalPlaneXResolution.getOptional("FocalPlaneXResolution")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun focalPlaneYResolution(): Optional<Double> =
                    focalPlaneYResolution.getOptional("FocalPlaneYResolution")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun interopOffset(): Optional<Long> = interopOffset.getOptional("InteropOffset")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun iso(): Optional<Long> = iso.getOptional("ISO")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun meteringMode(): Optional<Long> = meteringMode.getOptional("MeteringMode")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun sceneCaptureType(): Optional<Long> =
                    sceneCaptureType.getOptional("SceneCaptureType")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun shutterSpeedValue(): Optional<Double> =
                    shutterSpeedValue.getOptional("ShutterSpeedValue")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun subSecTime(): Optional<String> = subSecTime.getOptional("SubSecTime")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun whiteBalance(): Optional<Long> = whiteBalance.getOptional("WhiteBalance")

                /**
                 * Returns the raw JSON value of [apertureValue].
                 *
                 * Unlike [apertureValue], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ApertureValue")
                @ExcludeMissing
                fun _apertureValue(): JsonField<Double> = apertureValue

                /**
                 * Returns the raw JSON value of [colorSpace].
                 *
                 * Unlike [colorSpace], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ColorSpace")
                @ExcludeMissing
                fun _colorSpace(): JsonField<Long> = colorSpace

                /**
                 * Returns the raw JSON value of [createDate].
                 *
                 * Unlike [createDate], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("CreateDate")
                @ExcludeMissing
                fun _createDate(): JsonField<String> = createDate

                /**
                 * Returns the raw JSON value of [customRendered].
                 *
                 * Unlike [customRendered], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("CustomRendered")
                @ExcludeMissing
                fun _customRendered(): JsonField<Long> = customRendered

                /**
                 * Returns the raw JSON value of [dateTimeOriginal].
                 *
                 * Unlike [dateTimeOriginal], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("DateTimeOriginal")
                @ExcludeMissing
                fun _dateTimeOriginal(): JsonField<String> = dateTimeOriginal

                /**
                 * Returns the raw JSON value of [exifImageHeight].
                 *
                 * Unlike [exifImageHeight], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ExifImageHeight")
                @ExcludeMissing
                fun _exifImageHeight(): JsonField<Long> = exifImageHeight

                /**
                 * Returns the raw JSON value of [exifImageWidth].
                 *
                 * Unlike [exifImageWidth], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ExifImageWidth")
                @ExcludeMissing
                fun _exifImageWidth(): JsonField<Long> = exifImageWidth

                /**
                 * Returns the raw JSON value of [exifVersion].
                 *
                 * Unlike [exifVersion], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ExifVersion")
                @ExcludeMissing
                fun _exifVersion(): JsonField<String> = exifVersion

                /**
                 * Returns the raw JSON value of [exposureCompensation].
                 *
                 * Unlike [exposureCompensation], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ExposureCompensation")
                @ExcludeMissing
                fun _exposureCompensation(): JsonField<Double> = exposureCompensation

                /**
                 * Returns the raw JSON value of [exposureMode].
                 *
                 * Unlike [exposureMode], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ExposureMode")
                @ExcludeMissing
                fun _exposureMode(): JsonField<Long> = exposureMode

                /**
                 * Returns the raw JSON value of [exposureProgram].
                 *
                 * Unlike [exposureProgram], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ExposureProgram")
                @ExcludeMissing
                fun _exposureProgram(): JsonField<Long> = exposureProgram

                /**
                 * Returns the raw JSON value of [exposureTime].
                 *
                 * Unlike [exposureTime], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ExposureTime")
                @ExcludeMissing
                fun _exposureTime(): JsonField<Double> = exposureTime

                /**
                 * Returns the raw JSON value of [flash].
                 *
                 * Unlike [flash], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("Flash") @ExcludeMissing fun _flash(): JsonField<Long> = flash

                /**
                 * Returns the raw JSON value of [flashpixVersion].
                 *
                 * Unlike [flashpixVersion], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("FlashpixVersion")
                @ExcludeMissing
                fun _flashpixVersion(): JsonField<String> = flashpixVersion

                /**
                 * Returns the raw JSON value of [fNumber].
                 *
                 * Unlike [fNumber], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("FNumber") @ExcludeMissing fun _fNumber(): JsonField<Double> = fNumber

                /**
                 * Returns the raw JSON value of [focalLength].
                 *
                 * Unlike [focalLength], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("FocalLength")
                @ExcludeMissing
                fun _focalLength(): JsonField<Long> = focalLength

                /**
                 * Returns the raw JSON value of [focalPlaneResolutionUnit].
                 *
                 * Unlike [focalPlaneResolutionUnit], this method doesn't throw if the JSON field
                 * has an unexpected type.
                 */
                @JsonProperty("FocalPlaneResolutionUnit")
                @ExcludeMissing
                fun _focalPlaneResolutionUnit(): JsonField<Long> = focalPlaneResolutionUnit

                /**
                 * Returns the raw JSON value of [focalPlaneXResolution].
                 *
                 * Unlike [focalPlaneXResolution], this method doesn't throw if the JSON field has
                 * an unexpected type.
                 */
                @JsonProperty("FocalPlaneXResolution")
                @ExcludeMissing
                fun _focalPlaneXResolution(): JsonField<Double> = focalPlaneXResolution

                /**
                 * Returns the raw JSON value of [focalPlaneYResolution].
                 *
                 * Unlike [focalPlaneYResolution], this method doesn't throw if the JSON field has
                 * an unexpected type.
                 */
                @JsonProperty("FocalPlaneYResolution")
                @ExcludeMissing
                fun _focalPlaneYResolution(): JsonField<Double> = focalPlaneYResolution

                /**
                 * Returns the raw JSON value of [interopOffset].
                 *
                 * Unlike [interopOffset], this method doesn't throw if the JSON field has an
                 * unexpected type.
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
                 * Unlike [meteringMode], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("MeteringMode")
                @ExcludeMissing
                fun _meteringMode(): JsonField<Long> = meteringMode

                /**
                 * Returns the raw JSON value of [sceneCaptureType].
                 *
                 * Unlike [sceneCaptureType], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("SceneCaptureType")
                @ExcludeMissing
                fun _sceneCaptureType(): JsonField<Long> = sceneCaptureType

                /**
                 * Returns the raw JSON value of [shutterSpeedValue].
                 *
                 * Unlike [shutterSpeedValue], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ShutterSpeedValue")
                @ExcludeMissing
                fun _shutterSpeedValue(): JsonField<Double> = shutterSpeedValue

                /**
                 * Returns the raw JSON value of [subSecTime].
                 *
                 * Unlike [subSecTime], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("SubSecTime")
                @ExcludeMissing
                fun _subSecTime(): JsonField<String> = subSecTime

                /**
                 * Returns the raw JSON value of [whiteBalance].
                 *
                 * Unlike [whiteBalance], this method doesn't throw if the JSON field has an
                 * unexpected type.
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

                    /** Returns a mutable builder for constructing an instance of [InnerExif]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [InnerExif]. */
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
                    internal fun from(innerExif: InnerExif) = apply {
                        apertureValue = innerExif.apertureValue
                        colorSpace = innerExif.colorSpace
                        createDate = innerExif.createDate
                        customRendered = innerExif.customRendered
                        dateTimeOriginal = innerExif.dateTimeOriginal
                        exifImageHeight = innerExif.exifImageHeight
                        exifImageWidth = innerExif.exifImageWidth
                        exifVersion = innerExif.exifVersion
                        exposureCompensation = innerExif.exposureCompensation
                        exposureMode = innerExif.exposureMode
                        exposureProgram = innerExif.exposureProgram
                        exposureTime = innerExif.exposureTime
                        flash = innerExif.flash
                        flashpixVersion = innerExif.flashpixVersion
                        fNumber = innerExif.fNumber
                        focalLength = innerExif.focalLength
                        focalPlaneResolutionUnit = innerExif.focalPlaneResolutionUnit
                        focalPlaneXResolution = innerExif.focalPlaneXResolution
                        focalPlaneYResolution = innerExif.focalPlaneYResolution
                        interopOffset = innerExif.interopOffset
                        iso = innerExif.iso
                        meteringMode = innerExif.meteringMode
                        sceneCaptureType = innerExif.sceneCaptureType
                        shutterSpeedValue = innerExif.shutterSpeedValue
                        subSecTime = innerExif.subSecTime
                        whiteBalance = innerExif.whiteBalance
                        additionalProperties = innerExif.additionalProperties.toMutableMap()
                    }

                    fun apertureValue(apertureValue: Double) =
                        apertureValue(JsonField.of(apertureValue))

                    /**
                     * Sets [Builder.apertureValue] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.apertureValue] with a well-typed [Double]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun apertureValue(apertureValue: JsonField<Double>) = apply {
                        this.apertureValue = apertureValue
                    }

                    fun colorSpace(colorSpace: Long) = colorSpace(JsonField.of(colorSpace))

                    /**
                     * Sets [Builder.colorSpace] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.colorSpace] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun colorSpace(colorSpace: JsonField<Long>) = apply {
                        this.colorSpace = colorSpace
                    }

                    fun createDate(createDate: String) = createDate(JsonField.of(createDate))

                    /**
                     * Sets [Builder.createDate] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.createDate] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun createDate(createDate: JsonField<String>) = apply {
                        this.createDate = createDate
                    }

                    fun customRendered(customRendered: Long) =
                        customRendered(JsonField.of(customRendered))

                    /**
                     * Sets [Builder.customRendered] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.customRendered] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun customRendered(customRendered: JsonField<Long>) = apply {
                        this.customRendered = customRendered
                    }

                    fun dateTimeOriginal(dateTimeOriginal: String) =
                        dateTimeOriginal(JsonField.of(dateTimeOriginal))

                    /**
                     * Sets [Builder.dateTimeOriginal] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.dateTimeOriginal] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun dateTimeOriginal(dateTimeOriginal: JsonField<String>) = apply {
                        this.dateTimeOriginal = dateTimeOriginal
                    }

                    fun exifImageHeight(exifImageHeight: Long) =
                        exifImageHeight(JsonField.of(exifImageHeight))

                    /**
                     * Sets [Builder.exifImageHeight] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.exifImageHeight] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun exifImageHeight(exifImageHeight: JsonField<Long>) = apply {
                        this.exifImageHeight = exifImageHeight
                    }

                    fun exifImageWidth(exifImageWidth: Long) =
                        exifImageWidth(JsonField.of(exifImageWidth))

                    /**
                     * Sets [Builder.exifImageWidth] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.exifImageWidth] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun exifImageWidth(exifImageWidth: JsonField<Long>) = apply {
                        this.exifImageWidth = exifImageWidth
                    }

                    fun exifVersion(exifVersion: String) = exifVersion(JsonField.of(exifVersion))

                    /**
                     * Sets [Builder.exifVersion] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.exifVersion] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun exifVersion(exifVersion: JsonField<String>) = apply {
                        this.exifVersion = exifVersion
                    }

                    fun exposureCompensation(exposureCompensation: Double) =
                        exposureCompensation(JsonField.of(exposureCompensation))

                    /**
                     * Sets [Builder.exposureCompensation] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.exposureCompensation] with a well-typed
                     * [Double] value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun exposureCompensation(exposureCompensation: JsonField<Double>) = apply {
                        this.exposureCompensation = exposureCompensation
                    }

                    fun exposureMode(exposureMode: Long) = exposureMode(JsonField.of(exposureMode))

                    /**
                     * Sets [Builder.exposureMode] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.exposureMode] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun exposureMode(exposureMode: JsonField<Long>) = apply {
                        this.exposureMode = exposureMode
                    }

                    fun exposureProgram(exposureProgram: Long) =
                        exposureProgram(JsonField.of(exposureProgram))

                    /**
                     * Sets [Builder.exposureProgram] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.exposureProgram] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun exposureProgram(exposureProgram: JsonField<Long>) = apply {
                        this.exposureProgram = exposureProgram
                    }

                    fun exposureTime(exposureTime: Double) =
                        exposureTime(JsonField.of(exposureTime))

                    /**
                     * Sets [Builder.exposureTime] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.exposureTime] with a well-typed [Double]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun exposureTime(exposureTime: JsonField<Double>) = apply {
                        this.exposureTime = exposureTime
                    }

                    fun flash(flash: Long) = flash(JsonField.of(flash))

                    /**
                     * Sets [Builder.flash] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.flash] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun flash(flash: JsonField<Long>) = apply { this.flash = flash }

                    fun flashpixVersion(flashpixVersion: String) =
                        flashpixVersion(JsonField.of(flashpixVersion))

                    /**
                     * Sets [Builder.flashpixVersion] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.flashpixVersion] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun flashpixVersion(flashpixVersion: JsonField<String>) = apply {
                        this.flashpixVersion = flashpixVersion
                    }

                    fun fNumber(fNumber: Double) = fNumber(JsonField.of(fNumber))

                    /**
                     * Sets [Builder.fNumber] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.fNumber] with a well-typed [Double] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun fNumber(fNumber: JsonField<Double>) = apply { this.fNumber = fNumber }

                    fun focalLength(focalLength: Long) = focalLength(JsonField.of(focalLength))

                    /**
                     * Sets [Builder.focalLength] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.focalLength] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun focalLength(focalLength: JsonField<Long>) = apply {
                        this.focalLength = focalLength
                    }

                    fun focalPlaneResolutionUnit(focalPlaneResolutionUnit: Long) =
                        focalPlaneResolutionUnit(JsonField.of(focalPlaneResolutionUnit))

                    /**
                     * Sets [Builder.focalPlaneResolutionUnit] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.focalPlaneResolutionUnit] with a well-typed
                     * [Long] value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun focalPlaneResolutionUnit(focalPlaneResolutionUnit: JsonField<Long>) =
                        apply {
                            this.focalPlaneResolutionUnit = focalPlaneResolutionUnit
                        }

                    fun focalPlaneXResolution(focalPlaneXResolution: Double) =
                        focalPlaneXResolution(JsonField.of(focalPlaneXResolution))

                    /**
                     * Sets [Builder.focalPlaneXResolution] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.focalPlaneXResolution] with a well-typed
                     * [Double] value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun focalPlaneXResolution(focalPlaneXResolution: JsonField<Double>) = apply {
                        this.focalPlaneXResolution = focalPlaneXResolution
                    }

                    fun focalPlaneYResolution(focalPlaneYResolution: Double) =
                        focalPlaneYResolution(JsonField.of(focalPlaneYResolution))

                    /**
                     * Sets [Builder.focalPlaneYResolution] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.focalPlaneYResolution] with a well-typed
                     * [Double] value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun focalPlaneYResolution(focalPlaneYResolution: JsonField<Double>) = apply {
                        this.focalPlaneYResolution = focalPlaneYResolution
                    }

                    fun interopOffset(interopOffset: Long) =
                        interopOffset(JsonField.of(interopOffset))

                    /**
                     * Sets [Builder.interopOffset] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.interopOffset] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun interopOffset(interopOffset: JsonField<Long>) = apply {
                        this.interopOffset = interopOffset
                    }

                    fun iso(iso: Long) = iso(JsonField.of(iso))

                    /**
                     * Sets [Builder.iso] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.iso] with a well-typed [Long] value instead.
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun iso(iso: JsonField<Long>) = apply { this.iso = iso }

                    fun meteringMode(meteringMode: Long) = meteringMode(JsonField.of(meteringMode))

                    /**
                     * Sets [Builder.meteringMode] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.meteringMode] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun meteringMode(meteringMode: JsonField<Long>) = apply {
                        this.meteringMode = meteringMode
                    }

                    fun sceneCaptureType(sceneCaptureType: Long) =
                        sceneCaptureType(JsonField.of(sceneCaptureType))

                    /**
                     * Sets [Builder.sceneCaptureType] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.sceneCaptureType] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun sceneCaptureType(sceneCaptureType: JsonField<Long>) = apply {
                        this.sceneCaptureType = sceneCaptureType
                    }

                    fun shutterSpeedValue(shutterSpeedValue: Double) =
                        shutterSpeedValue(JsonField.of(shutterSpeedValue))

                    /**
                     * Sets [Builder.shutterSpeedValue] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.shutterSpeedValue] with a well-typed
                     * [Double] value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun shutterSpeedValue(shutterSpeedValue: JsonField<Double>) = apply {
                        this.shutterSpeedValue = shutterSpeedValue
                    }

                    fun subSecTime(subSecTime: String) = subSecTime(JsonField.of(subSecTime))

                    /**
                     * Sets [Builder.subSecTime] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.subSecTime] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun subSecTime(subSecTime: JsonField<String>) = apply {
                        this.subSecTime = subSecTime
                    }

                    fun whiteBalance(whiteBalance: Long) = whiteBalance(JsonField.of(whiteBalance))

                    /**
                     * Sets [Builder.whiteBalance] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.whiteBalance] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun whiteBalance(whiteBalance: JsonField<Long>) = apply {
                        this.whiteBalance = whiteBalance
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
                     * Returns an immutable instance of [InnerExif].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): InnerExif =
                        InnerExif(
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

                fun validate(): InnerExif = apply {
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
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

                    return other is InnerExif &&
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
                    "InnerExif{apertureValue=$apertureValue, colorSpace=$colorSpace, createDate=$createDate, customRendered=$customRendered, dateTimeOriginal=$dateTimeOriginal, exifImageHeight=$exifImageHeight, exifImageWidth=$exifImageWidth, exifVersion=$exifVersion, exposureCompensation=$exposureCompensation, exposureMode=$exposureMode, exposureProgram=$exposureProgram, exposureTime=$exposureTime, flash=$flash, flashpixVersion=$flashpixVersion, fNumber=$fNumber, focalLength=$focalLength, focalPlaneResolutionUnit=$focalPlaneResolutionUnit, focalPlaneXResolution=$focalPlaneXResolution, focalPlaneYResolution=$focalPlaneYResolution, interopOffset=$interopOffset, iso=$iso, meteringMode=$meteringMode, sceneCaptureType=$sceneCaptureType, shutterSpeedValue=$shutterSpeedValue, subSecTime=$subSecTime, whiteBalance=$whiteBalance, additionalProperties=$additionalProperties}"
            }

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
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun gpsVersionId(): Optional<List<Long>> = gpsVersionId.getOptional("GPSVersionID")

                /**
                 * Returns the raw JSON value of [gpsVersionId].
                 *
                 * Unlike [gpsVersionId], this method doesn't throw if the JSON field has an
                 * unexpected type.
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

                    fun gpsVersionId(gpsVersionId: List<Long>) =
                        gpsVersionId(JsonField.of(gpsVersionId))

                    /**
                     * Sets [Builder.gpsVersionId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.gpsVersionId] with a well-typed `List<Long>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int = (gpsVersionId.asKnown().getOrNull()?.size ?: 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Gps &&
                        gpsVersionId == other.gpsVersionId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(gpsVersionId, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Gps{gpsVersionId=$gpsVersionId, additionalProperties=$additionalProperties}"
            }

            /** Object containing EXIF image information. */
            class Image
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
                    @JsonProperty("ExifOffset")
                    @ExcludeMissing
                    exifOffset: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("GPSInfo")
                    @ExcludeMissing
                    gpsInfo: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("Make")
                    @ExcludeMissing
                    make: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("Model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("ModifyDate")
                    @ExcludeMissing
                    modifyDate: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("Orientation")
                    @ExcludeMissing
                    orientation: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("ResolutionUnit")
                    @ExcludeMissing
                    resolutionUnit: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("Software")
                    @ExcludeMissing
                    software: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("XResolution")
                    @ExcludeMissing
                    xResolution: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("YCbCrPositioning")
                    @ExcludeMissing
                    yCbCrPositioning: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("YResolution")
                    @ExcludeMissing
                    yResolution: JsonField<Long> = JsonMissing.of(),
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
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun exifOffset(): Optional<Long> = exifOffset.getOptional("ExifOffset")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun gpsInfo(): Optional<Long> = gpsInfo.getOptional("GPSInfo")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun make(): Optional<String> = make.getOptional("Make")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun model(): Optional<String> = model.getOptional("Model")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun modifyDate(): Optional<String> = modifyDate.getOptional("ModifyDate")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun orientation(): Optional<Long> = orientation.getOptional("Orientation")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun resolutionUnit(): Optional<Long> = resolutionUnit.getOptional("ResolutionUnit")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun software(): Optional<String> = software.getOptional("Software")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun xResolution(): Optional<Long> = xResolution.getOptional("XResolution")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun yCbCrPositioning(): Optional<Long> =
                    yCbCrPositioning.getOptional("YCbCrPositioning")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun yResolution(): Optional<Long> = yResolution.getOptional("YResolution")

                /**
                 * Returns the raw JSON value of [exifOffset].
                 *
                 * Unlike [exifOffset], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ExifOffset")
                @ExcludeMissing
                fun _exifOffset(): JsonField<Long> = exifOffset

                /**
                 * Returns the raw JSON value of [gpsInfo].
                 *
                 * Unlike [gpsInfo], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("GPSInfo") @ExcludeMissing fun _gpsInfo(): JsonField<Long> = gpsInfo

                /**
                 * Returns the raw JSON value of [make].
                 *
                 * Unlike [make], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("Make") @ExcludeMissing fun _make(): JsonField<String> = make

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("Model") @ExcludeMissing fun _model(): JsonField<String> = model

                /**
                 * Returns the raw JSON value of [modifyDate].
                 *
                 * Unlike [modifyDate], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ModifyDate")
                @ExcludeMissing
                fun _modifyDate(): JsonField<String> = modifyDate

                /**
                 * Returns the raw JSON value of [orientation].
                 *
                 * Unlike [orientation], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("Orientation")
                @ExcludeMissing
                fun _orientation(): JsonField<Long> = orientation

                /**
                 * Returns the raw JSON value of [resolutionUnit].
                 *
                 * Unlike [resolutionUnit], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ResolutionUnit")
                @ExcludeMissing
                fun _resolutionUnit(): JsonField<Long> = resolutionUnit

                /**
                 * Returns the raw JSON value of [software].
                 *
                 * Unlike [software], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("Software")
                @ExcludeMissing
                fun _software(): JsonField<String> = software

                /**
                 * Returns the raw JSON value of [xResolution].
                 *
                 * Unlike [xResolution], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("XResolution")
                @ExcludeMissing
                fun _xResolution(): JsonField<Long> = xResolution

                /**
                 * Returns the raw JSON value of [yCbCrPositioning].
                 *
                 * Unlike [yCbCrPositioning], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("YCbCrPositioning")
                @ExcludeMissing
                fun _yCbCrPositioning(): JsonField<Long> = yCbCrPositioning

                /**
                 * Returns the raw JSON value of [yResolution].
                 *
                 * Unlike [yResolution], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("YResolution")
                @ExcludeMissing
                fun _yResolution(): JsonField<Long> = yResolution

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

                    /** Returns a mutable builder for constructing an instance of [Image]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Image]. */
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
                    internal fun from(image: Image) = apply {
                        exifOffset = image.exifOffset
                        gpsInfo = image.gpsInfo
                        make = image.make
                        model = image.model
                        modifyDate = image.modifyDate
                        orientation = image.orientation
                        resolutionUnit = image.resolutionUnit
                        software = image.software
                        xResolution = image.xResolution
                        yCbCrPositioning = image.yCbCrPositioning
                        yResolution = image.yResolution
                        additionalProperties = image.additionalProperties.toMutableMap()
                    }

                    fun exifOffset(exifOffset: Long) = exifOffset(JsonField.of(exifOffset))

                    /**
                     * Sets [Builder.exifOffset] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.exifOffset] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun exifOffset(exifOffset: JsonField<Long>) = apply {
                        this.exifOffset = exifOffset
                    }

                    fun gpsInfo(gpsInfo: Long) = gpsInfo(JsonField.of(gpsInfo))

                    /**
                     * Sets [Builder.gpsInfo] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.gpsInfo] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun gpsInfo(gpsInfo: JsonField<Long>) = apply { this.gpsInfo = gpsInfo }

                    fun make(make: String) = make(JsonField.of(make))

                    /**
                     * Sets [Builder.make] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.make] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun make(make: JsonField<String>) = apply { this.make = make }

                    fun model(model: String) = model(JsonField.of(model))

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

                    fun modifyDate(modifyDate: String) = modifyDate(JsonField.of(modifyDate))

                    /**
                     * Sets [Builder.modifyDate] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.modifyDate] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun modifyDate(modifyDate: JsonField<String>) = apply {
                        this.modifyDate = modifyDate
                    }

                    fun orientation(orientation: Long) = orientation(JsonField.of(orientation))

                    /**
                     * Sets [Builder.orientation] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.orientation] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun orientation(orientation: JsonField<Long>) = apply {
                        this.orientation = orientation
                    }

                    fun resolutionUnit(resolutionUnit: Long) =
                        resolutionUnit(JsonField.of(resolutionUnit))

                    /**
                     * Sets [Builder.resolutionUnit] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.resolutionUnit] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun resolutionUnit(resolutionUnit: JsonField<Long>) = apply {
                        this.resolutionUnit = resolutionUnit
                    }

                    fun software(software: String) = software(JsonField.of(software))

                    /**
                     * Sets [Builder.software] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.software] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun software(software: JsonField<String>) = apply { this.software = software }

                    fun xResolution(xResolution: Long) = xResolution(JsonField.of(xResolution))

                    /**
                     * Sets [Builder.xResolution] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.xResolution] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun xResolution(xResolution: JsonField<Long>) = apply {
                        this.xResolution = xResolution
                    }

                    fun yCbCrPositioning(yCbCrPositioning: Long) =
                        yCbCrPositioning(JsonField.of(yCbCrPositioning))

                    /**
                     * Sets [Builder.yCbCrPositioning] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.yCbCrPositioning] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun yCbCrPositioning(yCbCrPositioning: JsonField<Long>) = apply {
                        this.yCbCrPositioning = yCbCrPositioning
                    }

                    fun yResolution(yResolution: Long) = yResolution(JsonField.of(yResolution))

                    /**
                     * Sets [Builder.yResolution] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.yResolution] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun yResolution(yResolution: JsonField<Long>) = apply {
                        this.yResolution = yResolution
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
                     * Returns an immutable instance of [Image].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Image =
                        Image(
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

                fun validate(): Image = apply {
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
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

                    return other is Image &&
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
                    "Image{exifOffset=$exifOffset, gpsInfo=$gpsInfo, make=$make, model=$model, modifyDate=$modifyDate, orientation=$orientation, resolutionUnit=$resolutionUnit, software=$software, xResolution=$xResolution, yCbCrPositioning=$yCbCrPositioning, yResolution=$yResolution, additionalProperties=$additionalProperties}"
            }

            /** JSON object. */
            class Interoperability
            private constructor(
                private val interopIndex: JsonField<String>,
                private val interopVersion: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("InteropIndex")
                    @ExcludeMissing
                    interopIndex: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("InteropVersion")
                    @ExcludeMissing
                    interopVersion: JsonField<String> = JsonMissing.of(),
                ) : this(interopIndex, interopVersion, mutableMapOf())

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun interopIndex(): Optional<String> = interopIndex.getOptional("InteropIndex")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun interopVersion(): Optional<String> =
                    interopVersion.getOptional("InteropVersion")

                /**
                 * Returns the raw JSON value of [interopIndex].
                 *
                 * Unlike [interopIndex], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("InteropIndex")
                @ExcludeMissing
                fun _interopIndex(): JsonField<String> = interopIndex

                /**
                 * Returns the raw JSON value of [interopVersion].
                 *
                 * Unlike [interopVersion], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("InteropVersion")
                @ExcludeMissing
                fun _interopVersion(): JsonField<String> = interopVersion

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
                     * Returns a mutable builder for constructing an instance of [Interoperability].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Interoperability]. */
                class Builder internal constructor() {

                    private var interopIndex: JsonField<String> = JsonMissing.of()
                    private var interopVersion: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(interoperability: Interoperability) = apply {
                        interopIndex = interoperability.interopIndex
                        interopVersion = interoperability.interopVersion
                        additionalProperties = interoperability.additionalProperties.toMutableMap()
                    }

                    fun interopIndex(interopIndex: String) =
                        interopIndex(JsonField.of(interopIndex))

                    /**
                     * Sets [Builder.interopIndex] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.interopIndex] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun interopIndex(interopIndex: JsonField<String>) = apply {
                        this.interopIndex = interopIndex
                    }

                    fun interopVersion(interopVersion: String) =
                        interopVersion(JsonField.of(interopVersion))

                    /**
                     * Sets [Builder.interopVersion] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.interopVersion] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun interopVersion(interopVersion: JsonField<String>) = apply {
                        this.interopVersion = interopVersion
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
                     * Returns an immutable instance of [Interoperability].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Interoperability =
                        Interoperability(
                            interopIndex,
                            interopVersion,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Interoperability = apply {
                    if (validated) {
                        return@apply
                    }

                    interopIndex()
                    interopVersion()
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
                    (if (interopIndex.asKnown().isPresent) 1 else 0) +
                        (if (interopVersion.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Interoperability &&
                        interopIndex == other.interopIndex &&
                        interopVersion == other.interopVersion &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(interopIndex, interopVersion, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Interoperability{interopIndex=$interopIndex, interopVersion=$interopVersion, additionalProperties=$additionalProperties}"
            }

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
                    @JsonProperty("YResolution")
                    @ExcludeMissing
                    yResolution: JsonField<Long> = JsonMissing.of(),
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
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun compression(): Optional<Long> = compression.getOptional("Compression")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun resolutionUnit(): Optional<Long> = resolutionUnit.getOptional("ResolutionUnit")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun thumbnailLength(): Optional<Long> =
                    thumbnailLength.getOptional("ThumbnailLength")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun thumbnailOffset(): Optional<Long> =
                    thumbnailOffset.getOptional("ThumbnailOffset")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun xResolution(): Optional<Long> = xResolution.getOptional("XResolution")

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun yResolution(): Optional<Long> = yResolution.getOptional("YResolution")

                /**
                 * Returns the raw JSON value of [compression].
                 *
                 * Unlike [compression], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("Compression")
                @ExcludeMissing
                fun _compression(): JsonField<Long> = compression

                /**
                 * Returns the raw JSON value of [resolutionUnit].
                 *
                 * Unlike [resolutionUnit], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ResolutionUnit")
                @ExcludeMissing
                fun _resolutionUnit(): JsonField<Long> = resolutionUnit

                /**
                 * Returns the raw JSON value of [thumbnailLength].
                 *
                 * Unlike [thumbnailLength], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ThumbnailLength")
                @ExcludeMissing
                fun _thumbnailLength(): JsonField<Long> = thumbnailLength

                /**
                 * Returns the raw JSON value of [thumbnailOffset].
                 *
                 * Unlike [thumbnailOffset], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("ThumbnailOffset")
                @ExcludeMissing
                fun _thumbnailOffset(): JsonField<Long> = thumbnailOffset

                /**
                 * Returns the raw JSON value of [xResolution].
                 *
                 * Unlike [xResolution], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("XResolution")
                @ExcludeMissing
                fun _xResolution(): JsonField<Long> = xResolution

                /**
                 * Returns the raw JSON value of [yResolution].
                 *
                 * Unlike [yResolution], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("YResolution")
                @ExcludeMissing
                fun _yResolution(): JsonField<Long> = yResolution

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
                     * You should usually call [Builder.compression] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun compression(compression: JsonField<Long>) = apply {
                        this.compression = compression
                    }

                    fun resolutionUnit(resolutionUnit: Long) =
                        resolutionUnit(JsonField.of(resolutionUnit))

                    /**
                     * Sets [Builder.resolutionUnit] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.resolutionUnit] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun resolutionUnit(resolutionUnit: JsonField<Long>) = apply {
                        this.resolutionUnit = resolutionUnit
                    }

                    fun thumbnailLength(thumbnailLength: Long) =
                        thumbnailLength(JsonField.of(thumbnailLength))

                    /**
                     * Sets [Builder.thumbnailLength] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.thumbnailLength] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun thumbnailLength(thumbnailLength: JsonField<Long>) = apply {
                        this.thumbnailLength = thumbnailLength
                    }

                    fun thumbnailOffset(thumbnailOffset: Long) =
                        thumbnailOffset(JsonField.of(thumbnailOffset))

                    /**
                     * Sets [Builder.thumbnailOffset] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.thumbnailOffset] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun thumbnailOffset(thumbnailOffset: JsonField<Long>) = apply {
                        this.thumbnailOffset = thumbnailOffset
                    }

                    fun xResolution(xResolution: Long) = xResolution(JsonField.of(xResolution))

                    /**
                     * Sets [Builder.xResolution] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.xResolution] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun xResolution(xResolution: JsonField<Long>) = apply {
                        this.xResolution = xResolution
                    }

                    fun yResolution(yResolution: Long) = yResolution(JsonField.of(yResolution))

                    /**
                     * Sets [Builder.yResolution] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.yResolution] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun yResolution(yResolution: JsonField<Long>) = apply {
                        this.yResolution = yResolution
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
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
