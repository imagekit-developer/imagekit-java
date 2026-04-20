// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.io.core.Enum
import io.imagekit.io.core.ExcludeMissing
import io.imagekit.io.core.JsonField
import io.imagekit.io.core.JsonMissing
import io.imagekit.io.core.JsonValue
import io.imagekit.io.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BaseOverlay
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val layerMode: JsonField<LayerMode>,
    private val position: JsonField<OverlayPosition>,
    private val timing: JsonField<OverlayTiming>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("layerMode")
        @ExcludeMissing
        layerMode: JsonField<LayerMode> = JsonMissing.of(),
        @JsonProperty("position")
        @ExcludeMissing
        position: JsonField<OverlayPosition> = JsonMissing.of(),
        @JsonProperty("timing") @ExcludeMissing timing: JsonField<OverlayTiming> = JsonMissing.of(),
    ) : this(layerMode, position, timing, mutableMapOf())

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
    fun layerMode(): Optional<LayerMode> = layerMode.getOptional("layerMode")

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
     * Returns the raw JSON value of [layerMode].
     *
     * Unlike [layerMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("layerMode") @ExcludeMissing fun _layerMode(): JsonField<LayerMode> = layerMode

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

        /** Returns a mutable builder for constructing an instance of [BaseOverlay]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BaseOverlay]. */
    class Builder internal constructor() {

        private var layerMode: JsonField<LayerMode> = JsonMissing.of()
        private var position: JsonField<OverlayPosition> = JsonMissing.of()
        private var timing: JsonField<OverlayTiming> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(baseOverlay: BaseOverlay) = apply {
            layerMode = baseOverlay.layerMode
            position = baseOverlay.position
            timing = baseOverlay.timing
            additionalProperties = baseOverlay.additionalProperties.toMutableMap()
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
        fun layerMode(layerMode: LayerMode) = layerMode(JsonField.of(layerMode))

        /**
         * Sets [Builder.layerMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.layerMode] with a well-typed [LayerMode] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun layerMode(layerMode: JsonField<LayerMode>) = apply { this.layerMode = layerMode }

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
         * Returns an immutable instance of [BaseOverlay].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BaseOverlay =
            BaseOverlay(layerMode, position, timing, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): BaseOverlay = apply {
        if (validated) {
            return@apply
        }

        layerMode().ifPresent { it.validate() }
        position().ifPresent { it.validate() }
        timing().ifPresent { it.validate() }
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
            (timing.asKnown().getOrNull()?.validity() ?: 0)

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
     */
    class LayerMode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val MULTIPLY = of("multiply")

            @JvmField val CUTTER = of("cutter")

            @JvmField val CUTOUT = of("cutout")

            @JvmField val DISPLACE = of("displace")

            @JvmStatic fun of(value: String) = LayerMode(JsonField.of(value))
        }

        /** An enum containing [LayerMode]'s known values. */
        enum class Known {
            MULTIPLY,
            CUTTER,
            CUTOUT,
            DISPLACE,
        }

        /**
         * An enum containing [LayerMode]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [LayerMode] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            MULTIPLY,
            CUTTER,
            CUTOUT,
            DISPLACE,
            /**
             * An enum member indicating that [LayerMode] was instantiated with an unknown value.
             */
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
                MULTIPLY -> Value.MULTIPLY
                CUTTER -> Value.CUTTER
                CUTOUT -> Value.CUTOUT
                DISPLACE -> Value.DISPLACE
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
                MULTIPLY -> Known.MULTIPLY
                CUTTER -> Known.CUTTER
                CUTOUT -> Known.CUTOUT
                DISPLACE -> Known.DISPLACE
                else -> throw ImageKitInvalidDataException("Unknown LayerMode: $value")
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

        fun validate(): LayerMode = apply {
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

            return other is LayerMode && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BaseOverlay &&
            layerMode == other.layerMode &&
            position == other.position &&
            timing == other.timing &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(layerMode, position, timing, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BaseOverlay{layerMode=$layerMode, position=$position, timing=$timing, additionalProperties=$additionalProperties}"
}
