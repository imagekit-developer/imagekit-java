// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.BaseDeserializer
import com.imagekit.api.core.BaseSerializer
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.allMaxBy
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Specifies an overlay to be applied on the parent image or video. ImageKit supports overlays
 * including images, text, videos, subtitles, and solid colors. See
 * [Overlay using layers](https://imagekit.io/docs/transformations#overlay-using-layers).
 */
@JsonDeserialize(using = Overlay.Deserializer::class)
@JsonSerialize(using = Overlay.Serializer::class)
class Overlay
private constructor(
    private val text: TextOverlay? = null,
    private val image: ImageOverlay? = null,
    private val video: VideoOverlay? = null,
    private val subtitle: SubtitleOverlay? = null,
    private val solidColor: SolidColorOverlay? = null,
    private val _json: JsonValue? = null,
) {

    fun text(): Optional<TextOverlay> = Optional.ofNullable(text)

    fun image(): Optional<ImageOverlay> = Optional.ofNullable(image)

    fun video(): Optional<VideoOverlay> = Optional.ofNullable(video)

    fun subtitle(): Optional<SubtitleOverlay> = Optional.ofNullable(subtitle)

    fun solidColor(): Optional<SolidColorOverlay> = Optional.ofNullable(solidColor)

    fun isText(): Boolean = text != null

    fun isImage(): Boolean = image != null

    fun isVideo(): Boolean = video != null

    fun isSubtitle(): Boolean = subtitle != null

    fun isSolidColor(): Boolean = solidColor != null

    fun asText(): TextOverlay = text.getOrThrow("text")

    fun asImage(): ImageOverlay = image.getOrThrow("image")

    fun asVideo(): VideoOverlay = video.getOrThrow("video")

    fun asSubtitle(): SubtitleOverlay = subtitle.getOrThrow("subtitle")

    fun asSolidColor(): SolidColorOverlay = solidColor.getOrThrow("solidColor")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            text != null -> visitor.visitText(text)
            image != null -> visitor.visitImage(image)
            video != null -> visitor.visitVideo(video)
            subtitle != null -> visitor.visitSubtitle(subtitle)
            solidColor != null -> visitor.visitSolidColor(solidColor)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): Overlay = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitText(text: TextOverlay) {
                    text.validate()
                }

                override fun visitImage(image: ImageOverlay) {
                    image.validate()
                }

                override fun visitVideo(video: VideoOverlay) {
                    video.validate()
                }

                override fun visitSubtitle(subtitle: SubtitleOverlay) {
                    subtitle.validate()
                }

                override fun visitSolidColor(solidColor: SolidColorOverlay) {
                    solidColor.validate()
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
                override fun visitText(text: TextOverlay) = text.validity()

                override fun visitImage(image: ImageOverlay) = image.validity()

                override fun visitVideo(video: VideoOverlay) = video.validity()

                override fun visitSubtitle(subtitle: SubtitleOverlay) = subtitle.validity()

                override fun visitSolidColor(solidColor: SolidColorOverlay) = solidColor.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Overlay &&
            text == other.text &&
            image == other.image &&
            video == other.video &&
            subtitle == other.subtitle &&
            solidColor == other.solidColor
    }

    override fun hashCode(): Int = Objects.hash(text, image, video, subtitle, solidColor)

    override fun toString(): String =
        when {
            text != null -> "Overlay{text=$text}"
            image != null -> "Overlay{image=$image}"
            video != null -> "Overlay{video=$video}"
            subtitle != null -> "Overlay{subtitle=$subtitle}"
            solidColor != null -> "Overlay{solidColor=$solidColor}"
            _json != null -> "Overlay{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Overlay")
        }

    companion object {

        @JvmStatic fun ofText(text: TextOverlay) = Overlay(text = text)

        @JvmStatic fun ofImage(image: ImageOverlay) = Overlay(image = image)

        @JvmStatic fun ofVideo(video: VideoOverlay) = Overlay(video = video)

        @JvmStatic fun ofSubtitle(subtitle: SubtitleOverlay) = Overlay(subtitle = subtitle)

        @JvmStatic
        fun ofSolidColor(solidColor: SolidColorOverlay) = Overlay(solidColor = solidColor)
    }

    /** An interface that defines how to map each variant of [Overlay] to a value of type [T]. */
    interface Visitor<out T> {

        fun visitText(text: TextOverlay): T

        fun visitImage(image: ImageOverlay): T

        fun visitVideo(video: VideoOverlay): T

        fun visitSubtitle(subtitle: SubtitleOverlay): T

        fun visitSolidColor(solidColor: SolidColorOverlay): T

        /**
         * Maps an unknown variant of [Overlay] to a value of type [T].
         *
         * An instance of [Overlay] can contain an unknown variant if it was deserialized from data
         * that doesn't match any known variant. For example, if the SDK is on an older version than
         * the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws ImageKitInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw ImageKitInvalidDataException("Unknown Overlay: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<Overlay>(Overlay::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): Overlay {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<TextOverlay>())?.let {
                            Overlay(text = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<ImageOverlay>())?.let {
                            Overlay(image = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<VideoOverlay>())?.let {
                            Overlay(video = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<SubtitleOverlay>())?.let {
                            Overlay(subtitle = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<SolidColorOverlay>())?.let {
                            Overlay(solidColor = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> Overlay(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<Overlay>(Overlay::class) {

        override fun serialize(
            value: Overlay,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.text != null -> generator.writeObject(value.text)
                value.image != null -> generator.writeObject(value.image)
                value.video != null -> generator.writeObject(value.video)
                value.subtitle != null -> generator.writeObject(value.subtitle)
                value.solidColor != null -> generator.writeObject(value.solidColor)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Overlay")
            }
        }
    }
}
