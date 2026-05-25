// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.core.Enum
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.core.checkKnown
import io.imagekit.core.toImmutable
import io.imagekit.errors.ImageKitInvalidDataException
import io.imagekit.models.AiTag
import io.imagekit.models.CustomMetadata
import io.imagekit.models.EmbeddedMetadata
import io.imagekit.models.SelectedFieldsSchema
import io.imagekit.models.VersionInfo
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Object containing details of a file or file version. */
class FileUpdateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val aiTags: JsonField<List<AiTag>>,
    private val audioCodec: JsonField<String>,
    private val bitRate: JsonField<Long>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val customCoordinates: JsonField<String>,
    private val customMetadata: JsonField<CustomMetadata>,
    private val description: JsonField<String>,
    private val duration: JsonField<Long>,
    private val embeddedMetadata: JsonField<EmbeddedMetadata>,
    private val fileId: JsonField<String>,
    private val filePath: JsonField<String>,
    private val fileType: JsonField<String>,
    private val hasAlpha: JsonField<Boolean>,
    private val height: JsonField<Double>,
    private val isPrivateFile: JsonField<Boolean>,
    private val isPublished: JsonField<Boolean>,
    private val mime: JsonField<String>,
    private val name: JsonField<String>,
    private val selectedFieldsSchema: JsonField<SelectedFieldsSchema>,
    private val size: JsonField<Double>,
    private val tags: JsonField<List<String>>,
    private val thumbnail: JsonField<String>,
    private val type: JsonField<File.Type>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val url: JsonField<String>,
    private val versionInfo: JsonField<VersionInfo>,
    private val videoCodec: JsonField<String>,
    private val width: JsonField<Double>,
    private val extensionStatus: JsonField<ExtensionStatus>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("AITags") @ExcludeMissing aiTags: JsonField<List<AiTag>> = JsonMissing.of(),
        @JsonProperty("audioCodec")
        @ExcludeMissing
        audioCodec: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bitRate") @ExcludeMissing bitRate: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("customCoordinates")
        @ExcludeMissing
        customCoordinates: JsonField<String> = JsonMissing.of(),
        @JsonProperty("customMetadata")
        @ExcludeMissing
        customMetadata: JsonField<CustomMetadata> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("duration") @ExcludeMissing duration: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("embeddedMetadata")
        @ExcludeMissing
        embeddedMetadata: JsonField<EmbeddedMetadata> = JsonMissing.of(),
        @JsonProperty("fileId") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("filePath") @ExcludeMissing filePath: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fileType") @ExcludeMissing fileType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("hasAlpha") @ExcludeMissing hasAlpha: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("height") @ExcludeMissing height: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("isPrivateFile")
        @ExcludeMissing
        isPrivateFile: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isPublished")
        @ExcludeMissing
        isPublished: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("mime") @ExcludeMissing mime: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("selectedFieldsSchema")
        @ExcludeMissing
        selectedFieldsSchema: JsonField<SelectedFieldsSchema> = JsonMissing.of(),
        @JsonProperty("size") @ExcludeMissing size: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tags") @ExcludeMissing tags: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("thumbnail") @ExcludeMissing thumbnail: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<File.Type> = JsonMissing.of(),
        @JsonProperty("updatedAt")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("versionInfo")
        @ExcludeMissing
        versionInfo: JsonField<VersionInfo> = JsonMissing.of(),
        @JsonProperty("videoCodec")
        @ExcludeMissing
        videoCodec: JsonField<String> = JsonMissing.of(),
        @JsonProperty("width") @ExcludeMissing width: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("extensionStatus")
        @ExcludeMissing
        extensionStatus: JsonField<ExtensionStatus> = JsonMissing.of(),
    ) : this(
        aiTags,
        audioCodec,
        bitRate,
        createdAt,
        customCoordinates,
        customMetadata,
        description,
        duration,
        embeddedMetadata,
        fileId,
        filePath,
        fileType,
        hasAlpha,
        height,
        isPrivateFile,
        isPublished,
        mime,
        name,
        selectedFieldsSchema,
        size,
        tags,
        thumbnail,
        type,
        updatedAt,
        url,
        versionInfo,
        videoCodec,
        width,
        extensionStatus,
        mutableMapOf(),
    )

    fun toFile(): File =
        File.builder()
            .aiTags(aiTags)
            .audioCodec(audioCodec)
            .bitRate(bitRate)
            .createdAt(createdAt)
            .customCoordinates(customCoordinates)
            .customMetadata(customMetadata)
            .description(description)
            .duration(duration)
            .embeddedMetadata(embeddedMetadata)
            .fileId(fileId)
            .filePath(filePath)
            .fileType(fileType)
            .hasAlpha(hasAlpha)
            .height(height)
            .isPrivateFile(isPrivateFile)
            .isPublished(isPublished)
            .mime(mime)
            .name(name)
            .selectedFieldsSchema(selectedFieldsSchema)
            .size(size)
            .tags(tags)
            .thumbnail(thumbnail)
            .type(type)
            .updatedAt(updatedAt)
            .url(url)
            .versionInfo(versionInfo)
            .videoCodec(videoCodec)
            .width(width)
            .build()

    /**
     * Array of AI-generated tags associated with the image. If no AITags are set, it will be null.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aiTags(): Optional<List<AiTag>> = aiTags.getOptional("AITags")

    /**
     * The audio codec used in the video (only for video/audio).
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
     * Date and time when the file was uploaded. The date and time is in ISO8601 format.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

    /**
     * An string with custom coordinates of the file.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customCoordinates(): Optional<String> = customCoordinates.getOptional("customCoordinates")

    /**
     * An object with custom metadata for the file.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customMetadata(): Optional<CustomMetadata> = customMetadata.getOptional("customMetadata")

    /**
     * Optional text to describe the contents of the file. Can be set by the user or the
     * ai-auto-description extension.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * The duration of the video in seconds (only for video).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun duration(): Optional<Long> = duration.getOptional("duration")

    /**
     * Consolidated embedded metadata associated with the file. It includes exif, iptc, and xmp
     * data.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun embeddedMetadata(): Optional<EmbeddedMetadata> =
        embeddedMetadata.getOptional("embeddedMetadata")

    /**
     * Unique identifier of the asset.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileId(): Optional<String> = fileId.getOptional("fileId")

    /**
     * Path of the file. This is the path you would use in the URL to access the file. For example,
     * if the file is at the root of the media library, the path will be `/file.jpg`. If the file is
     * inside a folder named `images`, the path will be `/images/file.jpg`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun filePath(): Optional<String> = filePath.getOptional("filePath")

    /**
     * Type of the file. Possible values are `image`, `non-image`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileType(): Optional<String> = fileType.getOptional("fileType")

    /**
     * Specifies if the image has an alpha channel.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun hasAlpha(): Optional<Boolean> = hasAlpha.getOptional("hasAlpha")

    /**
     * Height of the file.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun height(): Optional<Double> = height.getOptional("height")

    /**
     * Specifies if the file is private or not.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isPrivateFile(): Optional<Boolean> = isPrivateFile.getOptional("isPrivateFile")

    /**
     * Specifies if the file is published or not.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isPublished(): Optional<Boolean> = isPublished.getOptional("isPublished")

    /**
     * MIME type of the file.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mime(): Optional<String> = mime.getOptional("mime")

    /**
     * Name of the asset.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * This field is included in the response only if the Path policy feature is available in the
     * plan. It contains schema definitions for the custom metadata fields selected for the
     * specified file path. Field selection can only be done when the Path policy feature is
     * enabled.
     *
     * Keys are the names of the custom metadata fields; the value object has details about the
     * custom metadata schema.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun selectedFieldsSchema(): Optional<SelectedFieldsSchema> =
        selectedFieldsSchema.getOptional("selectedFieldsSchema")

    /**
     * Size of the file in bytes.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun size(): Optional<Double> = size.getOptional("size")

    /**
     * An array of tags assigned to the file. Tags are used to search files in the media library.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tags(): Optional<List<String>> = tags.getOptional("tags")

    /**
     * URL of the thumbnail image. This URL is used to access the thumbnail image of the file in the
     * media library.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun thumbnail(): Optional<String> = thumbnail.getOptional("thumbnail")

    /**
     * Type of the asset.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<File.Type> = type.getOptional("type")

    /**
     * Date and time when the file was last updated. The date and time is in ISO8601 format.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

    /**
     * URL of the file.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun url(): Optional<String> = url.getOptional("url")

    /**
     * An object with details of the file version.
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
     * Width of the file.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun width(): Optional<Double> = width.getOptional("width")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun extensionStatus(): Optional<ExtensionStatus> =
        extensionStatus.getOptional("extensionStatus")

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
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

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
     * Returns the raw JSON value of [customMetadata].
     *
     * Unlike [customMetadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("customMetadata")
    @ExcludeMissing
    fun _customMetadata(): JsonField<CustomMetadata> = customMetadata

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

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
     * Returns the raw JSON value of [hasAlpha].
     *
     * Unlike [hasAlpha], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hasAlpha") @ExcludeMissing fun _hasAlpha(): JsonField<Boolean> = hasAlpha

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
     * Returns the raw JSON value of [mime].
     *
     * Unlike [mime], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mime") @ExcludeMissing fun _mime(): JsonField<String> = mime

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [selectedFieldsSchema].
     *
     * Unlike [selectedFieldsSchema], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("selectedFieldsSchema")
    @ExcludeMissing
    fun _selectedFieldsSchema(): JsonField<SelectedFieldsSchema> = selectedFieldsSchema

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
     * Returns the raw JSON value of [thumbnail].
     *
     * Unlike [thumbnail], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("thumbnail") @ExcludeMissing fun _thumbnail(): JsonField<String> = thumbnail

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<File.Type> = type

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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

    /**
     * Returns the raw JSON value of [extensionStatus].
     *
     * Unlike [extensionStatus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("extensionStatus")
    @ExcludeMissing
    fun _extensionStatus(): JsonField<ExtensionStatus> = extensionStatus

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

        /** Returns a mutable builder for constructing an instance of [FileUpdateResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileUpdateResponse]. */
    class Builder internal constructor() {

        private var aiTags: JsonField<MutableList<AiTag>>? = null
        private var audioCodec: JsonField<String> = JsonMissing.of()
        private var bitRate: JsonField<Long> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var customCoordinates: JsonField<String> = JsonMissing.of()
        private var customMetadata: JsonField<CustomMetadata> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var duration: JsonField<Long> = JsonMissing.of()
        private var embeddedMetadata: JsonField<EmbeddedMetadata> = JsonMissing.of()
        private var fileId: JsonField<String> = JsonMissing.of()
        private var filePath: JsonField<String> = JsonMissing.of()
        private var fileType: JsonField<String> = JsonMissing.of()
        private var hasAlpha: JsonField<Boolean> = JsonMissing.of()
        private var height: JsonField<Double> = JsonMissing.of()
        private var isPrivateFile: JsonField<Boolean> = JsonMissing.of()
        private var isPublished: JsonField<Boolean> = JsonMissing.of()
        private var mime: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var selectedFieldsSchema: JsonField<SelectedFieldsSchema> = JsonMissing.of()
        private var size: JsonField<Double> = JsonMissing.of()
        private var tags: JsonField<MutableList<String>>? = null
        private var thumbnail: JsonField<String> = JsonMissing.of()
        private var type: JsonField<File.Type> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var versionInfo: JsonField<VersionInfo> = JsonMissing.of()
        private var videoCodec: JsonField<String> = JsonMissing.of()
        private var width: JsonField<Double> = JsonMissing.of()
        private var extensionStatus: JsonField<ExtensionStatus> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileUpdateResponse: FileUpdateResponse) = apply {
            aiTags = fileUpdateResponse.aiTags.map { it.toMutableList() }
            audioCodec = fileUpdateResponse.audioCodec
            bitRate = fileUpdateResponse.bitRate
            createdAt = fileUpdateResponse.createdAt
            customCoordinates = fileUpdateResponse.customCoordinates
            customMetadata = fileUpdateResponse.customMetadata
            description = fileUpdateResponse.description
            duration = fileUpdateResponse.duration
            embeddedMetadata = fileUpdateResponse.embeddedMetadata
            fileId = fileUpdateResponse.fileId
            filePath = fileUpdateResponse.filePath
            fileType = fileUpdateResponse.fileType
            hasAlpha = fileUpdateResponse.hasAlpha
            height = fileUpdateResponse.height
            isPrivateFile = fileUpdateResponse.isPrivateFile
            isPublished = fileUpdateResponse.isPublished
            mime = fileUpdateResponse.mime
            name = fileUpdateResponse.name
            selectedFieldsSchema = fileUpdateResponse.selectedFieldsSchema
            size = fileUpdateResponse.size
            tags = fileUpdateResponse.tags.map { it.toMutableList() }
            thumbnail = fileUpdateResponse.thumbnail
            type = fileUpdateResponse.type
            updatedAt = fileUpdateResponse.updatedAt
            url = fileUpdateResponse.url
            versionInfo = fileUpdateResponse.versionInfo
            videoCodec = fileUpdateResponse.videoCodec
            width = fileUpdateResponse.width
            extensionStatus = fileUpdateResponse.extensionStatus
            additionalProperties = fileUpdateResponse.additionalProperties.toMutableMap()
        }

        /**
         * Array of AI-generated tags associated with the image. If no AITags are set, it will be
         * null.
         */
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

        /** The audio codec used in the video (only for video/audio). */
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

        /** Date and time when the file was uploaded. The date and time is in ISO8601 format. */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** An string with custom coordinates of the file. */
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

        /** An object with custom metadata for the file. */
        fun customMetadata(customMetadata: CustomMetadata) =
            customMetadata(JsonField.of(customMetadata))

        /**
         * Sets [Builder.customMetadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customMetadata] with a well-typed [CustomMetadata] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun customMetadata(customMetadata: JsonField<CustomMetadata>) = apply {
            this.customMetadata = customMetadata
        }

        /**
         * Optional text to describe the contents of the file. Can be set by the user or the
         * ai-auto-description extension.
         */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

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
         * data.
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

        /** Unique identifier of the asset. */
        fun fileId(fileId: String) = fileId(JsonField.of(fileId))

        /**
         * Sets [Builder.fileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

        /**
         * Path of the file. This is the path you would use in the URL to access the file. For
         * example, if the file is at the root of the media library, the path will be `/file.jpg`.
         * If the file is inside a folder named `images`, the path will be `/images/file.jpg`.
         */
        fun filePath(filePath: String) = filePath(JsonField.of(filePath))

        /**
         * Sets [Builder.filePath] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filePath] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filePath(filePath: JsonField<String>) = apply { this.filePath = filePath }

        /** Type of the file. Possible values are `image`, `non-image`. */
        fun fileType(fileType: String) = fileType(JsonField.of(fileType))

        /**
         * Sets [Builder.fileType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileType] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileType(fileType: JsonField<String>) = apply { this.fileType = fileType }

        /** Specifies if the image has an alpha channel. */
        fun hasAlpha(hasAlpha: Boolean) = hasAlpha(JsonField.of(hasAlpha))

        /**
         * Sets [Builder.hasAlpha] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasAlpha] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hasAlpha(hasAlpha: JsonField<Boolean>) = apply { this.hasAlpha = hasAlpha }

        /** Height of the file. */
        fun height(height: Double) = height(JsonField.of(height))

        /**
         * Sets [Builder.height] to an arbitrary JSON value.
         *
         * You should usually call [Builder.height] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun height(height: JsonField<Double>) = apply { this.height = height }

        /** Specifies if the file is private or not. */
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

        /** Specifies if the file is published or not. */
        fun isPublished(isPublished: Boolean) = isPublished(JsonField.of(isPublished))

        /**
         * Sets [Builder.isPublished] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isPublished] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isPublished(isPublished: JsonField<Boolean>) = apply { this.isPublished = isPublished }

        /** MIME type of the file. */
        fun mime(mime: String) = mime(JsonField.of(mime))

        /**
         * Sets [Builder.mime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mime] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mime(mime: JsonField<String>) = apply { this.mime = mime }

        /** Name of the asset. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * This field is included in the response only if the Path policy feature is available in
         * the plan. It contains schema definitions for the custom metadata fields selected for the
         * specified file path. Field selection can only be done when the Path policy feature is
         * enabled.
         *
         * Keys are the names of the custom metadata fields; the value object has details about the
         * custom metadata schema.
         */
        fun selectedFieldsSchema(selectedFieldsSchema: SelectedFieldsSchema) =
            selectedFieldsSchema(JsonField.of(selectedFieldsSchema))

        /**
         * Sets [Builder.selectedFieldsSchema] to an arbitrary JSON value.
         *
         * You should usually call [Builder.selectedFieldsSchema] with a well-typed
         * [SelectedFieldsSchema] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun selectedFieldsSchema(selectedFieldsSchema: JsonField<SelectedFieldsSchema>) = apply {
            this.selectedFieldsSchema = selectedFieldsSchema
        }

        /** Size of the file in bytes. */
        fun size(size: Double) = size(JsonField.of(size))

        /**
         * Sets [Builder.size] to an arbitrary JSON value.
         *
         * You should usually call [Builder.size] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun size(size: JsonField<Double>) = apply { this.size = size }

        /**
         * An array of tags assigned to the file. Tags are used to search files in the media
         * library.
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

        /**
         * URL of the thumbnail image. This URL is used to access the thumbnail image of the file in
         * the media library.
         */
        fun thumbnail(thumbnail: String) = thumbnail(JsonField.of(thumbnail))

        /**
         * Sets [Builder.thumbnail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.thumbnail] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun thumbnail(thumbnail: JsonField<String>) = apply { this.thumbnail = thumbnail }

        /** Type of the asset. */
        fun type(type: File.Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [File.Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<File.Type>) = apply { this.type = type }

        /** Date and time when the file was last updated. The date and time is in ISO8601 format. */
        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /** URL of the file. */
        fun url(url: String) = url(JsonField.of(url))

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

        /** An object with details of the file version. */
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

        /** Width of the file. */
        fun width(width: Double) = width(JsonField.of(width))

        /**
         * Sets [Builder.width] to an arbitrary JSON value.
         *
         * You should usually call [Builder.width] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun width(width: JsonField<Double>) = apply { this.width = width }

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
         * Returns an immutable instance of [FileUpdateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FileUpdateResponse =
            FileUpdateResponse(
                (aiTags ?: JsonMissing.of()).map { it.toImmutable() },
                audioCodec,
                bitRate,
                createdAt,
                customCoordinates,
                customMetadata,
                description,
                duration,
                embeddedMetadata,
                fileId,
                filePath,
                fileType,
                hasAlpha,
                height,
                isPrivateFile,
                isPublished,
                mime,
                name,
                selectedFieldsSchema,
                size,
                (tags ?: JsonMissing.of()).map { it.toImmutable() },
                thumbnail,
                type,
                updatedAt,
                url,
                versionInfo,
                videoCodec,
                width,
                extensionStatus,
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
    fun validate(): FileUpdateResponse = apply {
        if (validated) {
            return@apply
        }

        aiTags().ifPresent { it.forEach { it.validate() } }
        audioCodec()
        bitRate()
        createdAt()
        customCoordinates()
        customMetadata().ifPresent { it.validate() }
        description()
        duration()
        embeddedMetadata().ifPresent { it.validate() }
        fileId()
        filePath()
        fileType()
        hasAlpha()
        height()
        isPrivateFile()
        isPublished()
        mime()
        name()
        selectedFieldsSchema().ifPresent { it.validate() }
        size()
        tags()
        thumbnail()
        type().ifPresent { it.validate() }
        updatedAt()
        url()
        versionInfo().ifPresent { it.validate() }
        videoCodec()
        width()
        extensionStatus().ifPresent { it.validate() }
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (customCoordinates.asKnown().isPresent) 1 else 0) +
            (customMetadata.asKnown().getOrNull()?.validity() ?: 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (duration.asKnown().isPresent) 1 else 0) +
            (embeddedMetadata.asKnown().getOrNull()?.validity() ?: 0) +
            (if (fileId.asKnown().isPresent) 1 else 0) +
            (if (filePath.asKnown().isPresent) 1 else 0) +
            (if (fileType.asKnown().isPresent) 1 else 0) +
            (if (hasAlpha.asKnown().isPresent) 1 else 0) +
            (if (height.asKnown().isPresent) 1 else 0) +
            (if (isPrivateFile.asKnown().isPresent) 1 else 0) +
            (if (isPublished.asKnown().isPresent) 1 else 0) +
            (if (mime.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (selectedFieldsSchema.asKnown().getOrNull()?.validity() ?: 0) +
            (if (size.asKnown().isPresent) 1 else 0) +
            (tags.asKnown().getOrNull()?.size ?: 0) +
            (if (thumbnail.asKnown().isPresent) 1 else 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (versionInfo.asKnown().getOrNull()?.validity() ?: 0) +
            (if (videoCodec.asKnown().isPresent) 1 else 0) +
            (if (width.asKnown().isPresent) 1 else 0) +
            (extensionStatus.asKnown().getOrNull()?.validity() ?: 0)

    class ExtensionStatus
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val aiAutoDescription: JsonField<AiAutoDescription>,
        private val aiTasks: JsonField<AiTasks>,
        private val awsAutoTagging: JsonField<AwsAutoTagging>,
        private val googleAutoTagging: JsonField<GoogleAutoTagging>,
        private val removeBg: JsonField<RemoveBg>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("ai-auto-description")
            @ExcludeMissing
            aiAutoDescription: JsonField<AiAutoDescription> = JsonMissing.of(),
            @JsonProperty("ai-tasks")
            @ExcludeMissing
            aiTasks: JsonField<AiTasks> = JsonMissing.of(),
            @JsonProperty("aws-auto-tagging")
            @ExcludeMissing
            awsAutoTagging: JsonField<AwsAutoTagging> = JsonMissing.of(),
            @JsonProperty("google-auto-tagging")
            @ExcludeMissing
            googleAutoTagging: JsonField<GoogleAutoTagging> = JsonMissing.of(),
            @JsonProperty("remove-bg")
            @ExcludeMissing
            removeBg: JsonField<RemoveBg> = JsonMissing.of(),
        ) : this(
            aiAutoDescription,
            aiTasks,
            awsAutoTagging,
            googleAutoTagging,
            removeBg,
            mutableMapOf(),
        )

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun aiAutoDescription(): Optional<AiAutoDescription> =
            aiAutoDescription.getOptional("ai-auto-description")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun aiTasks(): Optional<AiTasks> = aiTasks.getOptional("ai-tasks")

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
         * Returns the raw JSON value of [aiAutoDescription].
         *
         * Unlike [aiAutoDescription], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ai-auto-description")
        @ExcludeMissing
        fun _aiAutoDescription(): JsonField<AiAutoDescription> = aiAutoDescription

        /**
         * Returns the raw JSON value of [aiTasks].
         *
         * Unlike [aiTasks], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ai-tasks") @ExcludeMissing fun _aiTasks(): JsonField<AiTasks> = aiTasks

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

            private var aiAutoDescription: JsonField<AiAutoDescription> = JsonMissing.of()
            private var aiTasks: JsonField<AiTasks> = JsonMissing.of()
            private var awsAutoTagging: JsonField<AwsAutoTagging> = JsonMissing.of()
            private var googleAutoTagging: JsonField<GoogleAutoTagging> = JsonMissing.of()
            private var removeBg: JsonField<RemoveBg> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(extensionStatus: ExtensionStatus) = apply {
                aiAutoDescription = extensionStatus.aiAutoDescription
                aiTasks = extensionStatus.aiTasks
                awsAutoTagging = extensionStatus.awsAutoTagging
                googleAutoTagging = extensionStatus.googleAutoTagging
                removeBg = extensionStatus.removeBg
                additionalProperties = extensionStatus.additionalProperties.toMutableMap()
            }

            fun aiAutoDescription(aiAutoDescription: AiAutoDescription) =
                aiAutoDescription(JsonField.of(aiAutoDescription))

            /**
             * Sets [Builder.aiAutoDescription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.aiAutoDescription] with a well-typed
             * [AiAutoDescription] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun aiAutoDescription(aiAutoDescription: JsonField<AiAutoDescription>) = apply {
                this.aiAutoDescription = aiAutoDescription
            }

            fun aiTasks(aiTasks: AiTasks) = aiTasks(JsonField.of(aiTasks))

            /**
             * Sets [Builder.aiTasks] to an arbitrary JSON value.
             *
             * You should usually call [Builder.aiTasks] with a well-typed [AiTasks] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun aiTasks(aiTasks: JsonField<AiTasks>) = apply { this.aiTasks = aiTasks }

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
                    aiAutoDescription,
                    aiTasks,
                    awsAutoTagging,
                    googleAutoTagging,
                    removeBg,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): ExtensionStatus = apply {
            if (validated) {
                return@apply
            }

            aiAutoDescription().ifPresent { it.validate() }
            aiTasks().ifPresent { it.validate() }
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
            (aiAutoDescription.asKnown().getOrNull()?.validity() ?: 0) +
                (aiTasks.asKnown().getOrNull()?.validity() ?: 0) +
                (awsAutoTagging.asKnown().getOrNull()?.validity() ?: 0) +
                (googleAutoTagging.asKnown().getOrNull()?.validity() ?: 0) +
                (removeBg.asKnown().getOrNull()?.validity() ?: 0)

        class AiAutoDescription
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

                @JvmStatic fun of(value: String) = AiAutoDescription(JsonField.of(value))
            }

            /** An enum containing [AiAutoDescription]'s known values. */
            enum class Known {
                SUCCESS,
                PENDING,
                FAILED,
            }

            /**
             * An enum containing [AiAutoDescription]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [AiAutoDescription] can contain an unknown value in a couple of cases:
             *
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             *
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SUCCESS,
                PENDING,
                FAILED,
                /**
                 * An enum member indicating that [AiAutoDescription] was instantiated with an
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
                    else -> throw ImageKitInvalidDataException("Unknown AiAutoDescription: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): AiAutoDescription = apply {
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

                return other is AiAutoDescription && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class AiTasks @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmStatic fun of(value: String) = AiTasks(JsonField.of(value))
            }

            /** An enum containing [AiTasks]'s known values. */
            enum class Known {
                SUCCESS,
                PENDING,
                FAILED,
            }

            /**
             * An enum containing [AiTasks]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [AiTasks] can contain an unknown value in a couple of cases:
             *
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             *
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SUCCESS,
                PENDING,
                FAILED,
                /**
                 * An enum member indicating that [AiTasks] was instantiated with an unknown value.
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
                    else -> throw ImageKitInvalidDataException("Unknown AiTasks: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): AiTasks = apply {
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

                return other is AiTasks && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

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
             *
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             *
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
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
             *
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             *
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
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
             *
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             *
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
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
                aiAutoDescription == other.aiAutoDescription &&
                aiTasks == other.aiTasks &&
                awsAutoTagging == other.awsAutoTagging &&
                googleAutoTagging == other.googleAutoTagging &&
                removeBg == other.removeBg &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                aiAutoDescription,
                aiTasks,
                awsAutoTagging,
                googleAutoTagging,
                removeBg,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExtensionStatus{aiAutoDescription=$aiAutoDescription, aiTasks=$aiTasks, awsAutoTagging=$awsAutoTagging, googleAutoTagging=$googleAutoTagging, removeBg=$removeBg, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileUpdateResponse &&
            aiTags == other.aiTags &&
            audioCodec == other.audioCodec &&
            bitRate == other.bitRate &&
            createdAt == other.createdAt &&
            customCoordinates == other.customCoordinates &&
            customMetadata == other.customMetadata &&
            description == other.description &&
            duration == other.duration &&
            embeddedMetadata == other.embeddedMetadata &&
            fileId == other.fileId &&
            filePath == other.filePath &&
            fileType == other.fileType &&
            hasAlpha == other.hasAlpha &&
            height == other.height &&
            isPrivateFile == other.isPrivateFile &&
            isPublished == other.isPublished &&
            mime == other.mime &&
            name == other.name &&
            selectedFieldsSchema == other.selectedFieldsSchema &&
            size == other.size &&
            tags == other.tags &&
            thumbnail == other.thumbnail &&
            type == other.type &&
            updatedAt == other.updatedAt &&
            url == other.url &&
            versionInfo == other.versionInfo &&
            videoCodec == other.videoCodec &&
            width == other.width &&
            extensionStatus == other.extensionStatus &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            aiTags,
            audioCodec,
            bitRate,
            createdAt,
            customCoordinates,
            customMetadata,
            description,
            duration,
            embeddedMetadata,
            fileId,
            filePath,
            fileType,
            hasAlpha,
            height,
            isPrivateFile,
            isPublished,
            mime,
            name,
            selectedFieldsSchema,
            size,
            tags,
            thumbnail,
            type,
            updatedAt,
            url,
            versionInfo,
            videoCodec,
            width,
            extensionStatus,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileUpdateResponse{aiTags=$aiTags, audioCodec=$audioCodec, bitRate=$bitRate, createdAt=$createdAt, customCoordinates=$customCoordinates, customMetadata=$customMetadata, description=$description, duration=$duration, embeddedMetadata=$embeddedMetadata, fileId=$fileId, filePath=$filePath, fileType=$fileType, hasAlpha=$hasAlpha, height=$height, isPrivateFile=$isPrivateFile, isPublished=$isPublished, mime=$mime, name=$name, selectedFieldsSchema=$selectedFieldsSchema, size=$size, tags=$tags, thumbnail=$thumbnail, type=$type, updatedAt=$updatedAt, url=$url, versionInfo=$versionInfo, videoCodec=$videoCodec, width=$width, extensionStatus=$extensionStatus, additionalProperties=$additionalProperties}"
}
