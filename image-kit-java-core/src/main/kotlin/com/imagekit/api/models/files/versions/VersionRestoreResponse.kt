// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.versions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

/** Object containing details of a file or file version. */
class VersionRestoreResponse
private constructor(
    private val aiTags: JsonField<List<AiTag>>,
    private val createdAt: JsonField<String>,
    private val customCoordinates: JsonField<String>,
    private val customMetadata: JsonValue,
    private val fileId: JsonField<String>,
    private val filePath: JsonField<String>,
    private val fileType: JsonField<String>,
    private val hasAlpha: JsonField<Boolean>,
    private val height: JsonField<Double>,
    private val isPrivateFile: JsonField<Boolean>,
    private val isPublished: JsonField<Boolean>,
    private val mime: JsonField<String>,
    private val name: JsonField<String>,
    private val size: JsonField<Double>,
    private val tags: JsonField<List<String>>,
    private val thumbnail: JsonField<String>,
    private val type: JsonField<String>,
    private val updatedAt: JsonField<String>,
    private val url: JsonField<String>,
    private val versionInfo: JsonField<VersionInfo>,
    private val width: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("AITags") @ExcludeMissing aiTags: JsonField<List<AiTag>> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("customCoordinates")
        @ExcludeMissing
        customCoordinates: JsonField<String> = JsonMissing.of(),
        @JsonProperty("customMetadata")
        @ExcludeMissing
        customMetadata: JsonValue = JsonMissing.of(),
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
        @JsonProperty("size") @ExcludeMissing size: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tags") @ExcludeMissing tags: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("thumbnail") @ExcludeMissing thumbnail: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updatedAt") @ExcludeMissing updatedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("versionInfo")
        @ExcludeMissing
        versionInfo: JsonField<VersionInfo> = JsonMissing.of(),
        @JsonProperty("width") @ExcludeMissing width: JsonField<Double> = JsonMissing.of(),
    ) : this(
        aiTags,
        createdAt,
        customCoordinates,
        customMetadata,
        fileId,
        filePath,
        fileType,
        hasAlpha,
        height,
        isPrivateFile,
        isPublished,
        mime,
        name,
        size,
        tags,
        thumbnail,
        type,
        updatedAt,
        url,
        versionInfo,
        width,
        mutableMapOf(),
    )

    /**
     * An array of tags assigned to the file by auto tagging.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aiTags(): Optional<List<AiTag>> = aiTags.getOptional("AITags")

    /**
     * Date and time when the file was uploaded. The date and time is in ISO8601 format.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

    /**
     * An string with custom coordinates of the file.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customCoordinates(): Optional<String> = customCoordinates.getOptional("customCoordinates")

    /** An object with custom metadata for the file. */
    @JsonProperty("customMetadata")
    @ExcludeMissing
    fun _customMetadata(): JsonValue = customMetadata

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
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * Date and time when the file was last updated. The date and time is in ISO8601 format.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun updatedAt(): Optional<String> = updatedAt.getOptional("updatedAt")

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
     * Width of the file.
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
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

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
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt") @ExcludeMissing fun _updatedAt(): JsonField<String> = updatedAt

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

        /** Returns a mutable builder for constructing an instance of [VersionRestoreResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VersionRestoreResponse]. */
    class Builder internal constructor() {

        private var aiTags: JsonField<MutableList<AiTag>>? = null
        private var createdAt: JsonField<String> = JsonMissing.of()
        private var customCoordinates: JsonField<String> = JsonMissing.of()
        private var customMetadata: JsonValue = JsonMissing.of()
        private var fileId: JsonField<String> = JsonMissing.of()
        private var filePath: JsonField<String> = JsonMissing.of()
        private var fileType: JsonField<String> = JsonMissing.of()
        private var hasAlpha: JsonField<Boolean> = JsonMissing.of()
        private var height: JsonField<Double> = JsonMissing.of()
        private var isPrivateFile: JsonField<Boolean> = JsonMissing.of()
        private var isPublished: JsonField<Boolean> = JsonMissing.of()
        private var mime: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var size: JsonField<Double> = JsonMissing.of()
        private var tags: JsonField<MutableList<String>>? = null
        private var thumbnail: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var versionInfo: JsonField<VersionInfo> = JsonMissing.of()
        private var width: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(versionRestoreResponse: VersionRestoreResponse) = apply {
            aiTags = versionRestoreResponse.aiTags.map { it.toMutableList() }
            createdAt = versionRestoreResponse.createdAt
            customCoordinates = versionRestoreResponse.customCoordinates
            customMetadata = versionRestoreResponse.customMetadata
            fileId = versionRestoreResponse.fileId
            filePath = versionRestoreResponse.filePath
            fileType = versionRestoreResponse.fileType
            hasAlpha = versionRestoreResponse.hasAlpha
            height = versionRestoreResponse.height
            isPrivateFile = versionRestoreResponse.isPrivateFile
            isPublished = versionRestoreResponse.isPublished
            mime = versionRestoreResponse.mime
            name = versionRestoreResponse.name
            size = versionRestoreResponse.size
            tags = versionRestoreResponse.tags.map { it.toMutableList() }
            thumbnail = versionRestoreResponse.thumbnail
            type = versionRestoreResponse.type
            updatedAt = versionRestoreResponse.updatedAt
            url = versionRestoreResponse.url
            versionInfo = versionRestoreResponse.versionInfo
            width = versionRestoreResponse.width
            additionalProperties = versionRestoreResponse.additionalProperties.toMutableMap()
        }

        /** An array of tags assigned to the file by auto tagging. */
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

        /** Date and time when the file was uploaded. The date and time is in ISO8601 format. */
        fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

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
        fun customMetadata(customMetadata: JsonValue) = apply {
            this.customMetadata = customMetadata
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
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        /** Date and time when the file was last updated. The date and time is in ISO8601 format. */
        fun updatedAt(updatedAt: String) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun updatedAt(updatedAt: JsonField<String>) = apply { this.updatedAt = updatedAt }

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

        /** Width of the file. */
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
         * Returns an immutable instance of [VersionRestoreResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VersionRestoreResponse =
            VersionRestoreResponse(
                (aiTags ?: JsonMissing.of()).map { it.toImmutable() },
                createdAt,
                customCoordinates,
                customMetadata,
                fileId,
                filePath,
                fileType,
                hasAlpha,
                height,
                isPrivateFile,
                isPublished,
                mime,
                name,
                size,
                (tags ?: JsonMissing.of()).map { it.toImmutable() },
                thumbnail,
                type,
                updatedAt,
                url,
                versionInfo,
                width,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): VersionRestoreResponse = apply {
        if (validated) {
            return@apply
        }

        aiTags().ifPresent { it.forEach { it.validate() } }
        createdAt()
        customCoordinates()
        fileId()
        filePath()
        fileType()
        hasAlpha()
        height()
        isPrivateFile()
        isPublished()
        mime()
        name()
        size()
        tags()
        thumbnail()
        type()
        updatedAt()
        url()
        versionInfo().ifPresent { it.validate() }
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (customCoordinates.asKnown().isPresent) 1 else 0) +
            (if (fileId.asKnown().isPresent) 1 else 0) +
            (if (filePath.asKnown().isPresent) 1 else 0) +
            (if (fileType.asKnown().isPresent) 1 else 0) +
            (if (hasAlpha.asKnown().isPresent) 1 else 0) +
            (if (height.asKnown().isPresent) 1 else 0) +
            (if (isPrivateFile.asKnown().isPresent) 1 else 0) +
            (if (isPublished.asKnown().isPresent) 1 else 0) +
            (if (mime.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (size.asKnown().isPresent) 1 else 0) +
            (tags.asKnown().getOrNull()?.size ?: 0) +
            (if (thumbnail.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (versionInfo.asKnown().getOrNull()?.validity() ?: 0) +
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
         * Source of the tag. Possible values are `google-auto-tagging` and `aws-auto-tagging`.
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
             * Source of the tag. Possible values are `google-auto-tagging` and `aws-auto-tagging`.
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

    /** An object with details of the file version. */
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

        return other is VersionRestoreResponse &&
            aiTags == other.aiTags &&
            createdAt == other.createdAt &&
            customCoordinates == other.customCoordinates &&
            customMetadata == other.customMetadata &&
            fileId == other.fileId &&
            filePath == other.filePath &&
            fileType == other.fileType &&
            hasAlpha == other.hasAlpha &&
            height == other.height &&
            isPrivateFile == other.isPrivateFile &&
            isPublished == other.isPublished &&
            mime == other.mime &&
            name == other.name &&
            size == other.size &&
            tags == other.tags &&
            thumbnail == other.thumbnail &&
            type == other.type &&
            updatedAt == other.updatedAt &&
            url == other.url &&
            versionInfo == other.versionInfo &&
            width == other.width &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            aiTags,
            createdAt,
            customCoordinates,
            customMetadata,
            fileId,
            filePath,
            fileType,
            hasAlpha,
            height,
            isPrivateFile,
            isPublished,
            mime,
            name,
            size,
            tags,
            thumbnail,
            type,
            updatedAt,
            url,
            versionInfo,
            width,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VersionRestoreResponse{aiTags=$aiTags, createdAt=$createdAt, customCoordinates=$customCoordinates, customMetadata=$customMetadata, fileId=$fileId, filePath=$filePath, fileType=$fileType, hasAlpha=$hasAlpha, height=$height, isPrivateFile=$isPrivateFile, isPublished=$isPublished, mime=$mime, name=$name, size=$size, tags=$tags, thumbnail=$thumbnail, type=$type, updatedAt=$updatedAt, url=$url, versionInfo=$versionInfo, width=$width, additionalProperties=$additionalProperties}"
}
