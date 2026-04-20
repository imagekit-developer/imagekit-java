// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.assets

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.io.core.BaseDeserializer
import io.imagekit.io.core.BaseSerializer
import io.imagekit.io.core.JsonValue
import io.imagekit.io.core.getOrThrow
import io.imagekit.io.errors.ImageKitInvalidDataException
import io.imagekit.io.models.files.File
import io.imagekit.io.models.files.Folder
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Object containing details of a file or file version. */
@JsonDeserialize(using = AssetListResponse.Deserializer::class)
@JsonSerialize(using = AssetListResponse.Serializer::class)
class AssetListResponse
private constructor(
    private val file: File? = null,
    private val folder: Folder? = null,
    private val _json: JsonValue? = null,
) {

    /** Object containing details of a file or file version. */
    fun file(): Optional<File> = Optional.ofNullable(file)

    fun folder(): Optional<Folder> = Optional.ofNullable(folder)

    fun isFile(): Boolean = file != null

    fun isFolder(): Boolean = folder != null

    /** Object containing details of a file or file version. */
    fun asFile(): File = file.getOrThrow("file")

    fun asFolder(): Folder = folder.getOrThrow("folder")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            file != null -> visitor.visitFile(file)
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
                override fun visitFile(file: File) {
                    file.validate()
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
                override fun visitFile(file: File) = file.validity()

                override fun visitFolder(folder: Folder) = folder.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AssetListResponse && file == other.file && folder == other.folder
    }

    override fun hashCode(): Int = Objects.hash(file, folder)

    override fun toString(): String =
        when {
            file != null -> "AssetListResponse{file=$file}"
            folder != null -> "AssetListResponse{folder=$folder}"
            _json != null -> "AssetListResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AssetListResponse")
        }

    companion object {

        /** Object containing details of a file or file version. */
        @JvmStatic fun ofFile(file: File) = AssetListResponse(file = file)

        @JvmStatic fun ofFolder(folder: Folder) = AssetListResponse(folder = folder)
    }

    /**
     * An interface that defines how to map each variant of [AssetListResponse] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** Object containing details of a file or file version. */
        fun visitFile(file: File): T

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

            return tryDeserialize(node, jacksonTypeRef<File>())?.let {
                AssetListResponse(file = it, _json = json)
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
                value.file != null -> generator.writeObject(value.file)
                value.folder != null -> generator.writeObject(value.folder)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AssetListResponse")
            }
        }
    }
}
