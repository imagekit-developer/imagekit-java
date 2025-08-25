// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.assets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.BaseDeserializer
import com.imagekit.api.core.BaseSerializer
import com.imagekit.api.core.Enum
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.checkKnown
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Object containing details of a file or file version. */
@JsonDeserialize(using = AssetListResponse.Deserializer::class)
@JsonSerialize(using = AssetListResponse.Serializer::class)
class AssetListResponse
private constructor(
    private val fileDetails: FileDetails? = null,
    private val folder: Folder? = null,
    private val _json: JsonValue? = null,
) {

    /** Object containing details of a file or file version. */
    fun fileDetails(): Optional<FileDetails> = Optional.ofNullable(fileDetails)

    fun folder(): Optional<Folder> = Optional.ofNullable(folder)

    fun isFileDetails(): Boolean = fileDetails != null

    fun isFolder(): Boolean = folder != null

    /** Object containing details of a file or file version. */
    fun asFileDetails(): FileDetails = fileDetails.getOrThrow("fileDetails")

    fun asFolder(): Folder = folder.getOrThrow("folder")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            fileDetails != null -> visitor.visitFileDetails(fileDetails)
            folder != null -> visitor.visitFolder(folder)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): AssetListResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFileDetails(fileDetails: FileDetails) {
                    fileDetails.validate()
                }

                override fun visitFolder(folder: Folder) {
                    folder.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitFileDetails(fileDetails: FileDetails) = fileDetails.validity()

                override fun visitFolder(folder: Folder) = folder.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AssetListResponse &&
            fileDetails == other.fileDetails &&
            folder == other.folder
    }

    override fun hashCode(): Int = Objects.hash(fileDetails, folder)

    override fun toString(): String =
        when {
            fileDetails != null -> "AssetListResponse{fileDetails=$fileDetails}"
            folder != null -> "AssetListResponse{folder=$folder}"
            _json != null -> "AssetListResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AssetListResponse")
        }

    companion object {

        /** Object containing details of a file or file version. */
        @JvmStatic
        fun ofFileDetails(fileDetails: FileDetails) = AssetListResponse(fileDetails = fileDetails)

        @JvmStatic fun ofFolder(folder: Folder) = AssetListResponse(folder = folder)
    }

    /**
     * An interface that defines how to map each variant of [AssetListResponse] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** Object containing details of a file or file version. */
        fun visitFileDetails(fileDetails: FileDetails): T

        fun visitFolder(folder: Folder): T

        /**
         * Maps an unknown variant of [AssetListResponse] to a value of type [T].
         *
         * An instance of [AssetListResponse] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws ImageKitInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw ImageKitInvalidDataException("Unknown AssetListResponse: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<AssetListResponse>(AssetListResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AssetListResponse {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            if (type == "folder") {
                return tryDeserialize(node, jacksonTypeRef<Folder>())?.let {
                    AssetListResponse(folder = it, _json = json)
                } ?: AssetListResponse(_json = json)
            }

            return tryDeserialize(node, jacksonTypeRef<FileDetails>())?.let {
                AssetListResponse(fileDetails = it, _json = json)
            } ?: AssetListResponse(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AssetListResponse>(AssetListResponse::class) {

        override fun serialize(
            value: AssetListResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.fileDetails != null -> generator.writeObject(value.fileDetails)
                value.folder != null -> generator.writeObject(value.folder)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AssetListResponse")
            }
        }
    }

    /** Object containing details of a file or file version. */
    class FileDetails
    private constructor(
        private val aiTags: JsonField<List<AiTag>>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val customCoordinates: JsonField<String>,
        private val customMetadata: JsonField<CustomMetadata>,
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
        private val type: JsonField<Type>,
        private val updatedAt: JsonField<OffsetDateTime>,
        private val url: JsonField<String>,
        private val versionInfo: JsonField<VersionInfo>,
        private val width: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("AITags")
            @ExcludeMissing
            aiTags: JsonField<List<AiTag>> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("customCoordinates")
            @ExcludeMissing
            customCoordinates: JsonField<String> = JsonMissing.of(),
            @JsonProperty("customMetadata")
            @ExcludeMissing
            customMetadata: JsonField<CustomMetadata> = JsonMissing.of(),
            @JsonProperty("fileId") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("filePath")
            @ExcludeMissing
            filePath: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fileType")
            @ExcludeMissing
            fileType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("hasAlpha")
            @ExcludeMissing
            hasAlpha: JsonField<Boolean> = JsonMissing.of(),
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
            @JsonProperty("thumbnail")
            @ExcludeMissing
            thumbnail: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
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
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun aiTags(): Optional<List<AiTag>> = aiTags.getOptional("AITags")

        /**
         * Date and time when the file was uploaded. The date and time is in ISO8601 format.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

        /**
         * An string with custom coordinates of the file.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun customCoordinates(): Optional<String> =
            customCoordinates.getOptional("customCoordinates")

        /**
         * An object with custom metadata for the file.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun customMetadata(): Optional<CustomMetadata> =
            customMetadata.getOptional("customMetadata")

        /**
         * Unique identifier of the asset.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fileId(): Optional<String> = fileId.getOptional("fileId")

        /**
         * Path of the file. This is the path you would use in the URL to access the file. For
         * example, if the file is at the root of the media library, the path will be `/file.jpg`.
         * If the file is inside a folder named `images`, the path will be `/images/file.jpg`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun filePath(): Optional<String> = filePath.getOptional("filePath")

        /**
         * Type of the file. Possible values are `image`, `non-image`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fileType(): Optional<String> = fileType.getOptional("fileType")

        /**
         * Specifies if the image has an alpha channel.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun hasAlpha(): Optional<Boolean> = hasAlpha.getOptional("hasAlpha")

        /**
         * Height of the file.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun height(): Optional<Double> = height.getOptional("height")

        /**
         * Specifies if the file is private or not.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun isPrivateFile(): Optional<Boolean> = isPrivateFile.getOptional("isPrivateFile")

        /**
         * Specifies if the file is published or not.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun isPublished(): Optional<Boolean> = isPublished.getOptional("isPublished")

        /**
         * MIME type of the file.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun mime(): Optional<String> = mime.getOptional("mime")

        /**
         * Name of the asset.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Size of the file in bytes.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun size(): Optional<Double> = size.getOptional("size")

        /**
         * An array of tags assigned to the file. Tags are used to search files in the media
         * library.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun tags(): Optional<List<String>> = tags.getOptional("tags")

        /**
         * URL of the thumbnail image. This URL is used to access the thumbnail image of the file in
         * the media library.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun thumbnail(): Optional<String> = thumbnail.getOptional("thumbnail")

        /**
         * Type of the asset.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Date and time when the file was last updated. The date and time is in ISO8601 format.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

        /**
         * URL of the file.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * An object with details of the file version.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun versionInfo(): Optional<VersionInfo> = versionInfo.getOptional("versionInfo")

        /**
         * Width of the file.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
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
         * Unlike [customMetadata], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("customMetadata")
        @ExcludeMissing
        fun _customMetadata(): JsonField<CustomMetadata> = customMetadata

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
         * Unlike [isPrivateFile], this method doesn't throw if the JSON field has an unexpected
         * type.
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
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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

            /** Returns a mutable builder for constructing an instance of [FileDetails]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FileDetails]. */
        class Builder internal constructor() {

            private var aiTags: JsonField<MutableList<AiTag>>? = null
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var customCoordinates: JsonField<String> = JsonMissing.of()
            private var customMetadata: JsonField<CustomMetadata> = JsonMissing.of()
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
            private var type: JsonField<Type> = JsonMissing.of()
            private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var versionInfo: JsonField<VersionInfo> = JsonMissing.of()
            private var width: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileDetails: FileDetails) = apply {
                aiTags = fileDetails.aiTags.map { it.toMutableList() }
                createdAt = fileDetails.createdAt
                customCoordinates = fileDetails.customCoordinates
                customMetadata = fileDetails.customMetadata
                fileId = fileDetails.fileId
                filePath = fileDetails.filePath
                fileType = fileDetails.fileType
                hasAlpha = fileDetails.hasAlpha
                height = fileDetails.height
                isPrivateFile = fileDetails.isPrivateFile
                isPublished = fileDetails.isPublished
                mime = fileDetails.mime
                name = fileDetails.name
                size = fileDetails.size
                tags = fileDetails.tags.map { it.toMutableList() }
                thumbnail = fileDetails.thumbnail
                type = fileDetails.type
                updatedAt = fileDetails.updatedAt
                url = fileDetails.url
                versionInfo = fileDetails.versionInfo
                width = fileDetails.width
                additionalProperties = fileDetails.additionalProperties.toMutableMap()
            }

            /** An array of tags assigned to the file by auto tagging. */
            fun aiTags(aiTags: List<AiTag>?) = aiTags(JsonField.ofNullable(aiTags))

            /** Alias for calling [Builder.aiTags] with `aiTags.orElse(null)`. */
            fun aiTags(aiTags: Optional<List<AiTag>>) = aiTags(aiTags.getOrNull())

            /**
             * Sets [Builder.aiTags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.aiTags] with a well-typed `List<AiTag>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            /** An string with custom coordinates of the file. */
            fun customCoordinates(customCoordinates: String?) =
                customCoordinates(JsonField.ofNullable(customCoordinates))

            /**
             * Alias for calling [Builder.customCoordinates] with `customCoordinates.orElse(null)`.
             */
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
             * You should usually call [Builder.customMetadata] with a well-typed [CustomMetadata]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun customMetadata(customMetadata: JsonField<CustomMetadata>) = apply {
                this.customMetadata = customMetadata
            }

            /** Unique identifier of the asset. */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /**
             * Sets [Builder.fileId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

            /**
             * Path of the file. This is the path you would use in the URL to access the file. For
             * example, if the file is at the root of the media library, the path will be
             * `/file.jpg`. If the file is inside a folder named `images`, the path will be
             * `/images/file.jpg`.
             */
            fun filePath(filePath: String) = filePath(JsonField.of(filePath))

            /**
             * Sets [Builder.filePath] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filePath] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filePath(filePath: JsonField<String>) = apply { this.filePath = filePath }

            /** Type of the file. Possible values are `image`, `non-image`. */
            fun fileType(fileType: String) = fileType(JsonField.of(fileType))

            /**
             * Sets [Builder.fileType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileType(fileType: JsonField<String>) = apply { this.fileType = fileType }

            /** Specifies if the image has an alpha channel. */
            fun hasAlpha(hasAlpha: Boolean) = hasAlpha(JsonField.of(hasAlpha))

            /**
             * Sets [Builder.hasAlpha] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasAlpha] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasAlpha(hasAlpha: JsonField<Boolean>) = apply { this.hasAlpha = hasAlpha }

            /** Height of the file. */
            fun height(height: Double) = height(JsonField.of(height))

            /**
             * Sets [Builder.height] to an arbitrary JSON value.
             *
             * You should usually call [Builder.height] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * You should usually call [Builder.isPublished] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isPublished(isPublished: JsonField<Boolean>) = apply {
                this.isPublished = isPublished
            }

            /** MIME type of the file. */
            fun mime(mime: String) = mime(JsonField.of(mime))

            /**
             * Sets [Builder.mime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mime] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun mime(mime: JsonField<String>) = apply { this.mime = mime }

            /** Name of the asset. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Size of the file in bytes. */
            fun size(size: Double) = size(JsonField.of(size))

            /**
             * Sets [Builder.size] to an arbitrary JSON value.
             *
             * You should usually call [Builder.size] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * You should usually call [Builder.tags] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
                tags =
                    (tags ?: JsonField.of(mutableListOf())).also { checkKnown("tags", it).add(tag) }
            }

            /**
             * URL of the thumbnail image. This URL is used to access the thumbnail image of the
             * file in the media library.
             */
            fun thumbnail(thumbnail: String) = thumbnail(JsonField.of(thumbnail))

            /**
             * Sets [Builder.thumbnail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.thumbnail] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun thumbnail(thumbnail: JsonField<String>) = apply { this.thumbnail = thumbnail }

            /** Type of the asset. */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            /**
             * Date and time when the file was last updated. The date and time is in ISO8601 format.
             */
            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /**
             * Sets [Builder.updatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
            }

            /** URL of the file. */
            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * You should usually call [Builder.width] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [FileDetails].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): FileDetails =
                FileDetails(
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

        fun validate(): FileDetails = apply {
            if (validated) {
                return@apply
            }

            aiTags().ifPresent { it.forEach { it.validate() } }
            createdAt()
            customCoordinates()
            customMetadata().ifPresent { it.validate() }
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
            type().ifPresent { it.validate() }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (aiTags.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (customCoordinates.asKnown().isPresent) 1 else 0) +
                (customMetadata.asKnown().getOrNull()?.validity() ?: 0) +
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
                (type.asKnown().getOrNull()?.validity() ?: 0) +
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
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun confidence(): Optional<Double> = confidence.getOptional("confidence")

            /**
             * Name of the tag.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Source of the tag. Possible values are `google-auto-tagging` and `aws-auto-tagging`.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun source(): Optional<String> = source.getOptional("source")

            /**
             * Returns the raw JSON value of [confidence].
             *
             * Unlike [confidence], this method doesn't throw if the JSON field has an unexpected
             * type.
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
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun confidence(confidence: JsonField<Double>) = apply {
                    this.confidence = confidence
                }

                /** Name of the tag. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * Source of the tag. Possible values are `google-auto-tagging` and
                 * `aws-auto-tagging`.
                 */
                fun source(source: String) = source(JsonField.of(source))

                /**
                 * Sets [Builder.source] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.source] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun source(source: JsonField<String>) = apply { this.source = source }

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

        /** An object with custom metadata for the file. */
        class CustomMetadata
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

                /** Returns a mutable builder for constructing an instance of [CustomMetadata]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CustomMetadata]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(customMetadata: CustomMetadata) = apply {
                    additionalProperties = customMetadata.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [CustomMetadata].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): CustomMetadata = CustomMetadata(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): CustomMetadata = apply {
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

                return other is CustomMetadata && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "CustomMetadata{additionalProperties=$additionalProperties}"
        }

        /** Type of the asset. */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val FILE = of("file")

                @JvmField val FILE_VERSION = of("file-version")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                FILE,
                FILE_VERSION,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                FILE,
                FILE_VERSION,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    FILE -> Value.FILE
                    FILE_VERSION -> Value.FILE_VERSION
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
                    FILE -> Known.FILE
                    FILE_VERSION -> Known.FILE_VERSION
                    else -> throw ImageKitInvalidDataException("Unknown Type: $value")
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

            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
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
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * Name of the file version.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
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
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Name of the file version. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

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
                 * Returns an immutable instance of [VersionInfo].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): VersionInfo =
                    VersionInfo(id, name, additionalProperties.toMutableMap())
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

            return other is FileDetails &&
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
            "FileDetails{aiTags=$aiTags, createdAt=$createdAt, customCoordinates=$customCoordinates, customMetadata=$customMetadata, fileId=$fileId, filePath=$filePath, fileType=$fileType, hasAlpha=$hasAlpha, height=$height, isPrivateFile=$isPrivateFile, isPublished=$isPublished, mime=$mime, name=$name, size=$size, tags=$tags, thumbnail=$thumbnail, type=$type, updatedAt=$updatedAt, url=$url, versionInfo=$versionInfo, width=$width, additionalProperties=$additionalProperties}"
    }

    class Folder
    private constructor(
        private val createdAt: JsonField<OffsetDateTime>,
        private val folderId: JsonField<String>,
        private val folderPath: JsonField<String>,
        private val name: JsonField<String>,
        private val type: JsonField<Type>,
        private val updatedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("folderId")
            @ExcludeMissing
            folderId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("folderPath")
            @ExcludeMissing
            folderPath: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(createdAt, folderId, folderPath, name, type, updatedAt, mutableMapOf())

        /**
         * Date and time when the folder was created. The date and time is in ISO8601 format.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

        /**
         * Unique identifier of the asset.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun folderId(): Optional<String> = folderId.getOptional("folderId")

        /**
         * Path of the folder. This is the path you would use in the URL to access the folder. For
         * example, if the folder is at the root of the media library, the path will be /folder. If
         * the folder is inside another folder named images, the path will be /images/folder.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun folderPath(): Optional<String> = folderPath.getOptional("folderPath")

        /**
         * Name of the asset.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Type of the asset.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Date and time when the folder was last updated. The date and time is in ISO8601 format.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [folderId].
         *
         * Unlike [folderId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("folderId") @ExcludeMissing fun _folderId(): JsonField<String> = folderId

        /**
         * Returns the raw JSON value of [folderPath].
         *
         * Unlike [folderPath], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("folderPath")
        @ExcludeMissing
        fun _folderPath(): JsonField<String> = folderPath

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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

            /** Returns a mutable builder for constructing an instance of [Folder]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Folder]. */
        class Builder internal constructor() {

            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var folderId: JsonField<String> = JsonMissing.of()
            private var folderPath: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(folder: Folder) = apply {
                createdAt = folder.createdAt
                folderId = folder.folderId
                folderPath = folder.folderPath
                name = folder.name
                type = folder.type
                updatedAt = folder.updatedAt
                additionalProperties = folder.additionalProperties.toMutableMap()
            }

            /**
             * Date and time when the folder was created. The date and time is in ISO8601 format.
             */
            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            /** Unique identifier of the asset. */
            fun folderId(folderId: String) = folderId(JsonField.of(folderId))

            /**
             * Sets [Builder.folderId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.folderId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun folderId(folderId: JsonField<String>) = apply { this.folderId = folderId }

            /**
             * Path of the folder. This is the path you would use in the URL to access the folder.
             * For example, if the folder is at the root of the media library, the path will be
             * /folder. If the folder is inside another folder named images, the path will be
             * /images/folder.
             */
            fun folderPath(folderPath: String) = folderPath(JsonField.of(folderPath))

            /**
             * Sets [Builder.folderPath] to an arbitrary JSON value.
             *
             * You should usually call [Builder.folderPath] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun folderPath(folderPath: JsonField<String>) = apply { this.folderPath = folderPath }

            /** Name of the asset. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Type of the asset. */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            /**
             * Date and time when the folder was last updated. The date and time is in ISO8601
             * format.
             */
            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /**
             * Sets [Builder.updatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
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
             * Returns an immutable instance of [Folder].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Folder =
                Folder(
                    createdAt,
                    folderId,
                    folderPath,
                    name,
                    type,
                    updatedAt,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Folder = apply {
            if (validated) {
                return@apply
            }

            createdAt()
            folderId()
            folderPath()
            name()
            type().ifPresent { it.validate() }
            updatedAt()
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (folderId.asKnown().isPresent) 1 else 0) +
                (if (folderPath.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        /** Type of the asset. */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val FOLDER = of("folder")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                FOLDER
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                FOLDER,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    FOLDER -> Value.FOLDER
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
                    FOLDER -> Known.FOLDER
                    else -> throw ImageKitInvalidDataException("Unknown Type: $value")
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

            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Folder &&
                createdAt == other.createdAt &&
                folderId == other.folderId &&
                folderPath == other.folderPath &&
                name == other.name &&
                type == other.type &&
                updatedAt == other.updatedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                createdAt,
                folderId,
                folderPath,
                name,
                type,
                updatedAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Folder{createdAt=$createdAt, folderId=$folderId, folderPath=$folderPath, name=$name, type=$type, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
    }
}
