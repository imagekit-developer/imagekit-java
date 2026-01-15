// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

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
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TextOverlay
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val layerMode: JsonField<BaseOverlay.LayerMode>,
    private val position: JsonField<OverlayPosition>,
    private val timing: JsonField<OverlayTiming>,
    private val text: JsonField<String>,
    private val type: JsonValue,
    private val encoding: JsonField<Encoding>,
    private val transformation: JsonField<List<TextOverlayTransformation>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("layerMode")
        @ExcludeMissing
        layerMode: JsonField<BaseOverlay.LayerMode> = JsonMissing.of(),
        @JsonProperty("position")
        @ExcludeMissing
        position: JsonField<OverlayPosition> = JsonMissing.of(),
        @JsonProperty("timing") @ExcludeMissing timing: JsonField<OverlayTiming> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("encoding") @ExcludeMissing encoding: JsonField<Encoding> = JsonMissing.of(),
        @JsonProperty("transformation")
        @ExcludeMissing
        transformation: JsonField<List<TextOverlayTransformation>> = JsonMissing.of(),
    ) : this(layerMode, position, timing, text, type, encoding, transformation, mutableMapOf())

    fun toBaseOverlay(): BaseOverlay =
        BaseOverlay.builder().layerMode(layerMode).position(position).timing(timing).build()

    /**
     * Controls how the layer blends with the base image or underlying content. Maps to `lm` in the
     * URL. By default, layers completely cover the base image beneath them. Layer modes change this
     * behavior:
     * - `multiply`: Multiplies the pixel values of the layer with the base image. The result is
     *   always darker than the original images. This is ideal for applying shadows or color tints.
     * - `displace`: Uses the layer as a displacement map to distort pixels in the base image. The
     *   red channel controls horizontal displacement, and the green channel controls vertical
     *   displacement. Requires `x` or `y` parameter to control displacement magnitude.
     * - `cutout`: Acts as an inverse mask where opaque areas of the layer turn the base image
     *   transparent, while transparent areas leave the base image unchanged. This mode functions
     *   like a hole-punch, effectively cutting the shape of the layer out of the underlying image.
     * - `cutter`: Acts as a shape mask where only the parts of the base image that fall inside the
     *   opaque area of the layer are preserved. This mode functions like a cookie-cutter, trimming
     *   the base image to match the specific dimensions and shape of the layer. See
     *   [Layer modes](https://imagekit.io/docs/add-overlays-on-images#layer-modes).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun layerMode(): Optional<BaseOverlay.LayerMode> = layerMode.getOptional("layerMode")

    /**
     * Specifies the overlay's position relative to the parent asset. See
     * [Position of Layer](https://imagekit.io/docs/transformations#position-of-layer).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun position(): Optional<OverlayPosition> = position.getOptional("position")

    /**
     * Specifies timing information for the overlay (only applicable if the base asset is a video).
     * See [Position of Layer](https://imagekit.io/docs/transformations#position-of-layer).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timing(): Optional<OverlayTiming> = timing.getOptional("timing")

    /**
     * Specifies the text to be displayed in the overlay. The SDK automatically handles special
     * characters and encoding.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("text")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Text can be included in the layer as either `i-{input}` (plain text) or
     * `ie-{base64_encoded_input}` (base64). By default, the SDK selects the appropriate format
     * based on the input text. To always use base64 (`ie-{base64}`), set this parameter to
     * `base64`. To always use plain text (`i-{input}`), set it to `plain`.
     *
     * Regardless of the encoding method, the input text is always percent-encoded to ensure it is
     * URL-safe.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun encoding(): Optional<Encoding> = encoding.getOptional("encoding")

    /**
     * Control styling of the text overlay. See
     * [Text overlays](https://imagekit.io/docs/add-overlays-on-images#text-overlay).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun transformation(): Optional<List<TextOverlayTransformation>> =
        transformation.getOptional("transformation")

    /**
     * Returns the raw JSON value of [layerMode].
     *
     * Unlike [layerMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("layerMode")
    @ExcludeMissing
    fun _layerMode(): JsonField<BaseOverlay.LayerMode> = layerMode

    /**
     * Returns the raw JSON value of [position].
     *
     * Unlike [position], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("position") @ExcludeMissing fun _position(): JsonField<OverlayPosition> = position

    /**
     * Returns the raw JSON value of [timing].
     *
     * Unlike [timing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("timing") @ExcludeMissing fun _timing(): JsonField<OverlayTiming> = timing

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /**
     * Returns the raw JSON value of [encoding].
     *
     * Unlike [encoding], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("encoding") @ExcludeMissing fun _encoding(): JsonField<Encoding> = encoding

    /**
     * Returns the raw JSON value of [transformation].
     *
     * Unlike [transformation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transformation")
    @ExcludeMissing
    fun _transformation(): JsonField<List<TextOverlayTransformation>> = transformation

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
         * Returns a mutable builder for constructing an instance of [TextOverlay].
         *
         * The following fields are required:
         * ```java
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TextOverlay]. */
    class Builder internal constructor() {

        private var layerMode: JsonField<BaseOverlay.LayerMode> = JsonMissing.of()
        private var position: JsonField<OverlayPosition> = JsonMissing.of()
        private var timing: JsonField<OverlayTiming> = JsonMissing.of()
        private var text: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("text")
        private var encoding: JsonField<Encoding> = JsonMissing.of()
        private var transformation: JsonField<MutableList<TextOverlayTransformation>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(textOverlay: TextOverlay) = apply {
            layerMode = textOverlay.layerMode
            position = textOverlay.position
            timing = textOverlay.timing
            text = textOverlay.text
            type = textOverlay.type
            encoding = textOverlay.encoding
            transformation = textOverlay.transformation.map { it.toMutableList() }
            additionalProperties = textOverlay.additionalProperties.toMutableMap()
        }

        /**
         * Controls how the layer blends with the base image or underlying content. Maps to `lm` in
         * the URL. By default, layers completely cover the base image beneath them. Layer modes
         * change this behavior:
         * - `multiply`: Multiplies the pixel values of the layer with the base image. The result is
         *   always darker than the original images. This is ideal for applying shadows or color
         *   tints.
         * - `displace`: Uses the layer as a displacement map to distort pixels in the base image.
         *   The red channel controls horizontal displacement, and the green channel controls
         *   vertical displacement. Requires `x` or `y` parameter to control displacement magnitude.
         * - `cutout`: Acts as an inverse mask where opaque areas of the layer turn the base image
         *   transparent, while transparent areas leave the base image unchanged. This mode
         *   functions like a hole-punch, effectively cutting the shape of the layer out of the
         *   underlying image.
         * - `cutter`: Acts as a shape mask where only the parts of the base image that fall inside
         *   the opaque area of the layer are preserved. This mode functions like a cookie-cutter,
         *   trimming the base image to match the specific dimensions and shape of the layer. See
         *   [Layer modes](https://imagekit.io/docs/add-overlays-on-images#layer-modes).
         */
        fun layerMode(layerMode: BaseOverlay.LayerMode) = layerMode(JsonField.of(layerMode))

        /**
         * Sets [Builder.layerMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.layerMode] with a well-typed [BaseOverlay.LayerMode]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun layerMode(layerMode: JsonField<BaseOverlay.LayerMode>) = apply {
            this.layerMode = layerMode
        }

        /**
         * Specifies the overlay's position relative to the parent asset. See
         * [Position of Layer](https://imagekit.io/docs/transformations#position-of-layer).
         */
        fun position(position: OverlayPosition) = position(JsonField.of(position))

        /**
         * Sets [Builder.position] to an arbitrary JSON value.
         *
         * You should usually call [Builder.position] with a well-typed [OverlayPosition] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun position(position: JsonField<OverlayPosition>) = apply { this.position = position }

        /**
         * Specifies timing information for the overlay (only applicable if the base asset is a
         * video). See
         * [Position of Layer](https://imagekit.io/docs/transformations#position-of-layer).
         */
        fun timing(timing: OverlayTiming) = timing(JsonField.of(timing))

        /**
         * Sets [Builder.timing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timing] with a well-typed [OverlayTiming] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun timing(timing: JsonField<OverlayTiming>) = apply { this.timing = timing }

        /**
         * Specifies the text to be displayed in the overlay. The SDK automatically handles special
         * characters and encoding.
         */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("text")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * Text can be included in the layer as either `i-{input}` (plain text) or
         * `ie-{base64_encoded_input}` (base64). By default, the SDK selects the appropriate format
         * based on the input text. To always use base64 (`ie-{base64}`), set this parameter to
         * `base64`. To always use plain text (`i-{input}`), set it to `plain`.
         *
         * Regardless of the encoding method, the input text is always percent-encoded to ensure it
         * is URL-safe.
         */
        fun encoding(encoding: Encoding) = encoding(JsonField.of(encoding))

        /**
         * Sets [Builder.encoding] to an arbitrary JSON value.
         *
         * You should usually call [Builder.encoding] with a well-typed [Encoding] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun encoding(encoding: JsonField<Encoding>) = apply { this.encoding = encoding }

        /**
         * Control styling of the text overlay. See
         * [Text overlays](https://imagekit.io/docs/add-overlays-on-images#text-overlay).
         */
        fun transformation(transformation: List<TextOverlayTransformation>) =
            transformation(JsonField.of(transformation))

        /**
         * Sets [Builder.transformation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transformation] with a well-typed
         * `List<TextOverlayTransformation>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun transformation(transformation: JsonField<List<TextOverlayTransformation>>) = apply {
            this.transformation = transformation.map { it.toMutableList() }
        }

        /**
         * Adds a single [TextOverlayTransformation] to [Builder.transformation].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTransformation(transformation: TextOverlayTransformation) = apply {
            this.transformation =
                (this.transformation ?: JsonField.of(mutableListOf())).also {
                    checkKnown("transformation", it).add(transformation)
                }
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
         * Returns an immutable instance of [TextOverlay].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TextOverlay =
            TextOverlay(
                layerMode,
                position,
                timing,
                checkRequired("text", text),
                type,
                encoding,
                (transformation ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TextOverlay = apply {
        if (validated) {
            return@apply
        }

        layerMode().ifPresent { it.validate() }
        position().ifPresent { it.validate() }
        timing().ifPresent { it.validate() }
        text()
        _type().let {
            if (it != JsonValue.from("text")) {
                throw ImageKitInvalidDataException("'type' is invalid, received $it")
            }
        }
        encoding().ifPresent { it.validate() }
        transformation().ifPresent { it.forEach { it.validate() } }
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
        (layerMode.asKnown().getOrNull()?.validity() ?: 0) +
            (position.asKnown().getOrNull()?.validity() ?: 0) +
            (timing.asKnown().getOrNull()?.validity() ?: 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("text")) 1 else 0 } +
            (encoding.asKnown().getOrNull()?.validity() ?: 0) +
            (transformation.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /**
     * Text can be included in the layer as either `i-{input}` (plain text) or
     * `ie-{base64_encoded_input}` (base64). By default, the SDK selects the appropriate format
     * based on the input text. To always use base64 (`ie-{base64}`), set this parameter to
     * `base64`. To always use plain text (`i-{input}`), set it to `plain`.
     *
     * Regardless of the encoding method, the input text is always percent-encoded to ensure it is
     * URL-safe.
     */
    class Encoding @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val AUTO = of("auto")

            @JvmField val PLAIN = of("plain")

            @JvmField val BASE64 = of("base64")

            @JvmStatic fun of(value: String) = Encoding(JsonField.of(value))
        }

        /** An enum containing [Encoding]'s known values. */
        enum class Known {
            AUTO,
            PLAIN,
            BASE64,
        }

        /**
         * An enum containing [Encoding]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Encoding] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AUTO,
            PLAIN,
            BASE64,
            /** An enum member indicating that [Encoding] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                AUTO -> Value.AUTO
                PLAIN -> Value.PLAIN
                BASE64 -> Value.BASE64
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                AUTO -> Known.AUTO
                PLAIN -> Known.PLAIN
                BASE64 -> Known.BASE64
                else -> throw ImageKitInvalidDataException("Unknown Encoding: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                ImageKitInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Encoding = apply {
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

            return other is Encoding && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TextOverlay &&
            layerMode == other.layerMode &&
            position == other.position &&
            timing == other.timing &&
            text == other.text &&
            type == other.type &&
            encoding == other.encoding &&
            transformation == other.transformation &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            layerMode,
            position,
            timing,
            text,
            type,
            encoding,
            transformation,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TextOverlay{layerMode=$layerMode, position=$position, timing=$timing, text=$text, type=$type, encoding=$encoding, transformation=$transformation, additionalProperties=$additionalProperties}"
}
