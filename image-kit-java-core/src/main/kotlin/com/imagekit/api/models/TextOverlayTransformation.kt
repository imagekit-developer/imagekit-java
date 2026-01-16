// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

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
import com.imagekit.api.core.allMaxBy
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TextOverlayTransformation
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val alpha: JsonField<Double>,
    private val background: JsonField<String>,
    private val flip: JsonField<Flip>,
    private val fontColor: JsonField<String>,
    private val fontFamily: JsonField<String>,
    private val fontSize: JsonField<FontSize>,
    private val innerAlignment: JsonField<InnerAlignment>,
    private val lineHeight: JsonField<LineHeight>,
    private val padding: JsonField<Padding>,
    private val radius: JsonField<Radius>,
    private val rotation: JsonField<Rotation>,
    private val typography: JsonField<String>,
    private val width: JsonField<Width>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("alpha") @ExcludeMissing alpha: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("background")
        @ExcludeMissing
        background: JsonField<String> = JsonMissing.of(),
        @JsonProperty("flip") @ExcludeMissing flip: JsonField<Flip> = JsonMissing.of(),
        @JsonProperty("fontColor") @ExcludeMissing fontColor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fontFamily")
        @ExcludeMissing
        fontFamily: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fontSize") @ExcludeMissing fontSize: JsonField<FontSize> = JsonMissing.of(),
        @JsonProperty("innerAlignment")
        @ExcludeMissing
        innerAlignment: JsonField<InnerAlignment> = JsonMissing.of(),
        @JsonProperty("lineHeight")
        @ExcludeMissing
        lineHeight: JsonField<LineHeight> = JsonMissing.of(),
        @JsonProperty("padding") @ExcludeMissing padding: JsonField<Padding> = JsonMissing.of(),
        @JsonProperty("radius") @ExcludeMissing radius: JsonField<Radius> = JsonMissing.of(),
        @JsonProperty("rotation") @ExcludeMissing rotation: JsonField<Rotation> = JsonMissing.of(),
        @JsonProperty("typography")
        @ExcludeMissing
        typography: JsonField<String> = JsonMissing.of(),
        @JsonProperty("width") @ExcludeMissing width: JsonField<Width> = JsonMissing.of(),
    ) : this(
        alpha,
        background,
        flip,
        fontColor,
        fontFamily,
        fontSize,
        innerAlignment,
        lineHeight,
        padding,
        radius,
        rotation,
        typography,
        width,
        mutableMapOf(),
    )

    /**
     * Specifies the transparency level of the text overlay. Accepts integers from `1` to `9`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun alpha(): Optional<Double> = alpha.getOptional("alpha")

    /**
     * Specifies the background color of the text overlay. Accepts an RGB hex code, an RGBA code, or
     * a color name.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun background(): Optional<String> = background.getOptional("background")

    /**
     * Flip/mirror the text horizontally, vertically, or in both directions. Acceptable values: `h`
     * (horizontal), `v` (vertical), `h_v` (horizontal and vertical), or `v_h`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun flip(): Optional<Flip> = flip.getOptional("flip")

    /**
     * Specifies the font color of the overlaid text. Accepts an RGB hex code (e.g., `FF0000`), an
     * RGBA code (e.g., `FFAABB50`), or a color name.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fontColor(): Optional<String> = fontColor.getOptional("fontColor")

    /**
     * Specifies the font family of the overlaid text. Choose from the supported fonts list or use a
     * custom font. See
     * [Supported fonts](https://imagekit.io/docs/add-overlays-on-images#supported-text-font-list)
     * and
     * [Custom font](https://imagekit.io/docs/add-overlays-on-images#change-font-family-in-text-overlay).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fontFamily(): Optional<String> = fontFamily.getOptional("fontFamily")

    /**
     * Specifies the font size of the overlaid text. Accepts a numeric value or an arithmetic
     * expression.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fontSize(): Optional<FontSize> = fontSize.getOptional("fontSize")

    /**
     * Specifies the inner alignment of the text when width is more than the text length.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun innerAlignment(): Optional<InnerAlignment> = innerAlignment.getOptional("innerAlignment")

    /**
     * Specifies the line height for multi-line text overlays. It will come into effect only if the
     * text wraps over multiple lines. Accepts either an integer value or an arithmetic expression.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lineHeight(): Optional<LineHeight> = lineHeight.getOptional("lineHeight")

    /**
     * Specifies the padding around the overlaid text. Can be provided as a single positive integer
     * or multiple values separated by underscores (following CSS shorthand order). Arithmetic
     * expressions are also accepted.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun padding(): Optional<Padding> = padding.getOptional("padding")

    /**
     * Specifies the corner radius:
     * - Single value (positive integer): Applied to all corners (e.g., `20`).
     * - `max`: Creates a circular or oval shape.
     * - Per-corner array: Provide four underscore-separated values representing top-left,
     *   top-right, bottom-right, and bottom-left corners respectively (e.g., `10_20_30_40`). See
     *   [Radius](https://imagekit.io/docs/effects-and-enhancements#radius---r).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun radius(): Optional<Radius> = radius.getOptional("radius")

    /**
     * Specifies the rotation angle of the text overlay. Accepts a numeric value for clockwise
     * rotation or a string prefixed with "N" for counter-clockwise rotation.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rotation(): Optional<Rotation> = rotation.getOptional("rotation")

    /**
     * Specifies the typography style of the text. Supported values:
     * - Single styles: `b` (bold), `i` (italic), `strikethrough`.
     * - Combinations: Any combination separated by underscores, e.g., `b_i`, `b_i_strikethrough`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun typography(): Optional<String> = typography.getOptional("typography")

    /**
     * Specifies the maximum width (in pixels) of the overlaid text. The text wraps automatically,
     * and arithmetic expressions (e.g., `bw_mul_0.2` or `bh_div_2`) are supported. Useful when used
     * in conjunction with the `background`. Learn about
     * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun width(): Optional<Width> = width.getOptional("width")

    /**
     * Returns the raw JSON value of [alpha].
     *
     * Unlike [alpha], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("alpha") @ExcludeMissing fun _alpha(): JsonField<Double> = alpha

    /**
     * Returns the raw JSON value of [background].
     *
     * Unlike [background], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("background") @ExcludeMissing fun _background(): JsonField<String> = background

    /**
     * Returns the raw JSON value of [flip].
     *
     * Unlike [flip], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("flip") @ExcludeMissing fun _flip(): JsonField<Flip> = flip

    /**
     * Returns the raw JSON value of [fontColor].
     *
     * Unlike [fontColor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fontColor") @ExcludeMissing fun _fontColor(): JsonField<String> = fontColor

    /**
     * Returns the raw JSON value of [fontFamily].
     *
     * Unlike [fontFamily], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fontFamily") @ExcludeMissing fun _fontFamily(): JsonField<String> = fontFamily

    /**
     * Returns the raw JSON value of [fontSize].
     *
     * Unlike [fontSize], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fontSize") @ExcludeMissing fun _fontSize(): JsonField<FontSize> = fontSize

    /**
     * Returns the raw JSON value of [innerAlignment].
     *
     * Unlike [innerAlignment], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("innerAlignment")
    @ExcludeMissing
    fun _innerAlignment(): JsonField<InnerAlignment> = innerAlignment

    /**
     * Returns the raw JSON value of [lineHeight].
     *
     * Unlike [lineHeight], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lineHeight")
    @ExcludeMissing
    fun _lineHeight(): JsonField<LineHeight> = lineHeight

    /**
     * Returns the raw JSON value of [padding].
     *
     * Unlike [padding], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("padding") @ExcludeMissing fun _padding(): JsonField<Padding> = padding

    /**
     * Returns the raw JSON value of [radius].
     *
     * Unlike [radius], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("radius") @ExcludeMissing fun _radius(): JsonField<Radius> = radius

    /**
     * Returns the raw JSON value of [rotation].
     *
     * Unlike [rotation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rotation") @ExcludeMissing fun _rotation(): JsonField<Rotation> = rotation

    /**
     * Returns the raw JSON value of [typography].
     *
     * Unlike [typography], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("typography") @ExcludeMissing fun _typography(): JsonField<String> = typography

    /**
     * Returns the raw JSON value of [width].
     *
     * Unlike [width], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("width") @ExcludeMissing fun _width(): JsonField<Width> = width

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
         * Returns a mutable builder for constructing an instance of [TextOverlayTransformation].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TextOverlayTransformation]. */
    class Builder internal constructor() {

        private var alpha: JsonField<Double> = JsonMissing.of()
        private var background: JsonField<String> = JsonMissing.of()
        private var flip: JsonField<Flip> = JsonMissing.of()
        private var fontColor: JsonField<String> = JsonMissing.of()
        private var fontFamily: JsonField<String> = JsonMissing.of()
        private var fontSize: JsonField<FontSize> = JsonMissing.of()
        private var innerAlignment: JsonField<InnerAlignment> = JsonMissing.of()
        private var lineHeight: JsonField<LineHeight> = JsonMissing.of()
        private var padding: JsonField<Padding> = JsonMissing.of()
        private var radius: JsonField<Radius> = JsonMissing.of()
        private var rotation: JsonField<Rotation> = JsonMissing.of()
        private var typography: JsonField<String> = JsonMissing.of()
        private var width: JsonField<Width> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(textOverlayTransformation: TextOverlayTransformation) = apply {
            alpha = textOverlayTransformation.alpha
            background = textOverlayTransformation.background
            flip = textOverlayTransformation.flip
            fontColor = textOverlayTransformation.fontColor
            fontFamily = textOverlayTransformation.fontFamily
            fontSize = textOverlayTransformation.fontSize
            innerAlignment = textOverlayTransformation.innerAlignment
            lineHeight = textOverlayTransformation.lineHeight
            padding = textOverlayTransformation.padding
            radius = textOverlayTransformation.radius
            rotation = textOverlayTransformation.rotation
            typography = textOverlayTransformation.typography
            width = textOverlayTransformation.width
            additionalProperties = textOverlayTransformation.additionalProperties.toMutableMap()
        }

        /**
         * Specifies the transparency level of the text overlay. Accepts integers from `1` to `9`.
         */
        fun alpha(alpha: Double) = alpha(JsonField.of(alpha))

        /**
         * Sets [Builder.alpha] to an arbitrary JSON value.
         *
         * You should usually call [Builder.alpha] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun alpha(alpha: JsonField<Double>) = apply { this.alpha = alpha }

        /**
         * Specifies the background color of the text overlay. Accepts an RGB hex code, an RGBA
         * code, or a color name.
         */
        fun background(background: String) = background(JsonField.of(background))

        /**
         * Sets [Builder.background] to an arbitrary JSON value.
         *
         * You should usually call [Builder.background] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun background(background: JsonField<String>) = apply { this.background = background }

        /**
         * Flip/mirror the text horizontally, vertically, or in both directions. Acceptable values:
         * `h` (horizontal), `v` (vertical), `h_v` (horizontal and vertical), or `v_h`.
         */
        fun flip(flip: Flip) = flip(JsonField.of(flip))

        /**
         * Sets [Builder.flip] to an arbitrary JSON value.
         *
         * You should usually call [Builder.flip] with a well-typed [Flip] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun flip(flip: JsonField<Flip>) = apply { this.flip = flip }

        /**
         * Specifies the font color of the overlaid text. Accepts an RGB hex code (e.g., `FF0000`),
         * an RGBA code (e.g., `FFAABB50`), or a color name.
         */
        fun fontColor(fontColor: String) = fontColor(JsonField.of(fontColor))

        /**
         * Sets [Builder.fontColor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fontColor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fontColor(fontColor: JsonField<String>) = apply { this.fontColor = fontColor }

        /**
         * Specifies the font family of the overlaid text. Choose from the supported fonts list or
         * use a custom font. See
         * [Supported fonts](https://imagekit.io/docs/add-overlays-on-images#supported-text-font-list)
         * and
         * [Custom font](https://imagekit.io/docs/add-overlays-on-images#change-font-family-in-text-overlay).
         */
        fun fontFamily(fontFamily: String) = fontFamily(JsonField.of(fontFamily))

        /**
         * Sets [Builder.fontFamily] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fontFamily] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fontFamily(fontFamily: JsonField<String>) = apply { this.fontFamily = fontFamily }

        /**
         * Specifies the font size of the overlaid text. Accepts a numeric value or an arithmetic
         * expression.
         */
        fun fontSize(fontSize: FontSize) = fontSize(JsonField.of(fontSize))

        /**
         * Sets [Builder.fontSize] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fontSize] with a well-typed [FontSize] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fontSize(fontSize: JsonField<FontSize>) = apply { this.fontSize = fontSize }

        /** Alias for calling [fontSize] with `FontSize.ofNumber(number)`. */
        fun fontSize(number: Double) = fontSize(FontSize.ofNumber(number))

        /** Alias for calling [fontSize] with `FontSize.ofString(string)`. */
        fun fontSize(string: String) = fontSize(FontSize.ofString(string))

        /** Specifies the inner alignment of the text when width is more than the text length. */
        fun innerAlignment(innerAlignment: InnerAlignment) =
            innerAlignment(JsonField.of(innerAlignment))

        /**
         * Sets [Builder.innerAlignment] to an arbitrary JSON value.
         *
         * You should usually call [Builder.innerAlignment] with a well-typed [InnerAlignment] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun innerAlignment(innerAlignment: JsonField<InnerAlignment>) = apply {
            this.innerAlignment = innerAlignment
        }

        /**
         * Specifies the line height for multi-line text overlays. It will come into effect only if
         * the text wraps over multiple lines. Accepts either an integer value or an arithmetic
         * expression.
         */
        fun lineHeight(lineHeight: LineHeight) = lineHeight(JsonField.of(lineHeight))

        /**
         * Sets [Builder.lineHeight] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lineHeight] with a well-typed [LineHeight] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun lineHeight(lineHeight: JsonField<LineHeight>) = apply { this.lineHeight = lineHeight }

        /** Alias for calling [lineHeight] with `LineHeight.ofNumber(number)`. */
        fun lineHeight(number: Double) = lineHeight(LineHeight.ofNumber(number))

        /** Alias for calling [lineHeight] with `LineHeight.ofString(string)`. */
        fun lineHeight(string: String) = lineHeight(LineHeight.ofString(string))

        /**
         * Specifies the padding around the overlaid text. Can be provided as a single positive
         * integer or multiple values separated by underscores (following CSS shorthand order).
         * Arithmetic expressions are also accepted.
         */
        fun padding(padding: Padding) = padding(JsonField.of(padding))

        /**
         * Sets [Builder.padding] to an arbitrary JSON value.
         *
         * You should usually call [Builder.padding] with a well-typed [Padding] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun padding(padding: JsonField<Padding>) = apply { this.padding = padding }

        /** Alias for calling [padding] with `Padding.ofNumber(number)`. */
        fun padding(number: Double) = padding(Padding.ofNumber(number))

        /** Alias for calling [padding] with `Padding.ofString(string)`. */
        fun padding(string: String) = padding(Padding.ofString(string))

        /**
         * Specifies the corner radius:
         * - Single value (positive integer): Applied to all corners (e.g., `20`).
         * - `max`: Creates a circular or oval shape.
         * - Per-corner array: Provide four underscore-separated values representing top-left,
         *   top-right, bottom-right, and bottom-left corners respectively (e.g., `10_20_30_40`).
         *   See [Radius](https://imagekit.io/docs/effects-and-enhancements#radius---r).
         */
        fun radius(radius: Radius) = radius(JsonField.of(radius))

        /**
         * Sets [Builder.radius] to an arbitrary JSON value.
         *
         * You should usually call [Builder.radius] with a well-typed [Radius] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun radius(radius: JsonField<Radius>) = apply { this.radius = radius }

        /** Alias for calling [radius] with `Radius.ofNumber(number)`. */
        fun radius(number: Double) = radius(Radius.ofNumber(number))

        /** Alias for calling [radius] with `Radius.ofMax()`. */
        fun radiusMax() = radius(Radius.ofMax())

        /** Alias for calling [radius] with `Radius.ofString(string)`. */
        fun radius(string: String) = radius(Radius.ofString(string))

        /**
         * Specifies the rotation angle of the text overlay. Accepts a numeric value for clockwise
         * rotation or a string prefixed with "N" for counter-clockwise rotation.
         */
        fun rotation(rotation: Rotation) = rotation(JsonField.of(rotation))

        /**
         * Sets [Builder.rotation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rotation] with a well-typed [Rotation] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun rotation(rotation: JsonField<Rotation>) = apply { this.rotation = rotation }

        /** Alias for calling [rotation] with `Rotation.ofNumber(number)`. */
        fun rotation(number: Double) = rotation(Rotation.ofNumber(number))

        /** Alias for calling [rotation] with `Rotation.ofString(string)`. */
        fun rotation(string: String) = rotation(Rotation.ofString(string))

        /**
         * Specifies the typography style of the text. Supported values:
         * - Single styles: `b` (bold), `i` (italic), `strikethrough`.
         * - Combinations: Any combination separated by underscores, e.g., `b_i`,
         *   `b_i_strikethrough`.
         */
        fun typography(typography: String) = typography(JsonField.of(typography))

        /**
         * Sets [Builder.typography] to an arbitrary JSON value.
         *
         * You should usually call [Builder.typography] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun typography(typography: JsonField<String>) = apply { this.typography = typography }

        /**
         * Specifies the maximum width (in pixels) of the overlaid text. The text wraps
         * automatically, and arithmetic expressions (e.g., `bw_mul_0.2` or `bh_div_2`) are
         * supported. Useful when used in conjunction with the `background`. Learn about
         * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
         */
        fun width(width: Width) = width(JsonField.of(width))

        /**
         * Sets [Builder.width] to an arbitrary JSON value.
         *
         * You should usually call [Builder.width] with a well-typed [Width] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun width(width: JsonField<Width>) = apply { this.width = width }

        /** Alias for calling [width] with `Width.ofNumber(number)`. */
        fun width(number: Double) = width(Width.ofNumber(number))

        /** Alias for calling [width] with `Width.ofString(string)`. */
        fun width(string: String) = width(Width.ofString(string))

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
         * Returns an immutable instance of [TextOverlayTransformation].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TextOverlayTransformation =
            TextOverlayTransformation(
                alpha,
                background,
                flip,
                fontColor,
                fontFamily,
                fontSize,
                innerAlignment,
                lineHeight,
                padding,
                radius,
                rotation,
                typography,
                width,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TextOverlayTransformation = apply {
        if (validated) {
            return@apply
        }

        alpha()
        background()
        flip().ifPresent { it.validate() }
        fontColor()
        fontFamily()
        fontSize().ifPresent { it.validate() }
        innerAlignment().ifPresent { it.validate() }
        lineHeight().ifPresent { it.validate() }
        padding().ifPresent { it.validate() }
        radius().ifPresent { it.validate() }
        rotation().ifPresent { it.validate() }
        typography()
        width().ifPresent { it.validate() }
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
        (if (alpha.asKnown().isPresent) 1 else 0) +
            (if (background.asKnown().isPresent) 1 else 0) +
            (flip.asKnown().getOrNull()?.validity() ?: 0) +
            (if (fontColor.asKnown().isPresent) 1 else 0) +
            (if (fontFamily.asKnown().isPresent) 1 else 0) +
            (fontSize.asKnown().getOrNull()?.validity() ?: 0) +
            (innerAlignment.asKnown().getOrNull()?.validity() ?: 0) +
            (lineHeight.asKnown().getOrNull()?.validity() ?: 0) +
            (padding.asKnown().getOrNull()?.validity() ?: 0) +
            (radius.asKnown().getOrNull()?.validity() ?: 0) +
            (rotation.asKnown().getOrNull()?.validity() ?: 0) +
            (if (typography.asKnown().isPresent) 1 else 0) +
            (width.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Flip/mirror the text horizontally, vertically, or in both directions. Acceptable values: `h`
     * (horizontal), `v` (vertical), `h_v` (horizontal and vertical), or `v_h`.
     */
    class Flip @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val H = of("h")

            @JvmField val V = of("v")

            @JvmField val H_V = of("h_v")

            @JvmField val V_H = of("v_h")

            @JvmStatic fun of(value: String) = Flip(JsonField.of(value))
        }

        /** An enum containing [Flip]'s known values. */
        enum class Known {
            H,
            V,
            H_V,
            V_H,
        }

        /**
         * An enum containing [Flip]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Flip] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            H,
            V,
            H_V,
            V_H,
            /** An enum member indicating that [Flip] was instantiated with an unknown value. */
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
                H -> Value.H
                V -> Value.V
                H_V -> Value.H_V
                V_H -> Value.V_H
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
                H -> Known.H
                V -> Known.V
                H_V -> Known.H_V
                V_H -> Known.V_H
                else -> throw ImageKitInvalidDataException("Unknown Flip: $value")
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

        fun validate(): Flip = apply {
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

            return other is Flip && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Specifies the font size of the overlaid text. Accepts a numeric value or an arithmetic
     * expression.
     */
    @JsonDeserialize(using = FontSize.Deserializer::class)
    @JsonSerialize(using = FontSize.Serializer::class)
    class FontSize
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): FontSize = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FontSize && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "FontSize{number=$number}"
                string != null -> "FontSize{string=$string}"
                _json != null -> "FontSize{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid FontSize")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = FontSize(number = number)

            @JvmStatic fun ofString(string: String) = FontSize(string = string)
        }

        /**
         * An interface that defines how to map each variant of [FontSize] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [FontSize] to a value of type [T].
             *
             * An instance of [FontSize] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown FontSize: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<FontSize>(FontSize::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): FontSize {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                FontSize(number = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                FontSize(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> FontSize(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<FontSize>(FontSize::class) {

            override fun serialize(
                value: FontSize,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid FontSize")
                }
            }
        }
    }

    /** Specifies the inner alignment of the text when width is more than the text length. */
    class InnerAlignment @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val LEFT = of("left")

            @JvmField val RIGHT = of("right")

            @JvmField val CENTER = of("center")

            @JvmStatic fun of(value: String) = InnerAlignment(JsonField.of(value))
        }

        /** An enum containing [InnerAlignment]'s known values. */
        enum class Known {
            LEFT,
            RIGHT,
            CENTER,
        }

        /**
         * An enum containing [InnerAlignment]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [InnerAlignment] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            LEFT,
            RIGHT,
            CENTER,
            /**
             * An enum member indicating that [InnerAlignment] was instantiated with an unknown
             * value.
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
                LEFT -> Value.LEFT
                RIGHT -> Value.RIGHT
                CENTER -> Value.CENTER
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
                LEFT -> Known.LEFT
                RIGHT -> Known.RIGHT
                CENTER -> Known.CENTER
                else -> throw ImageKitInvalidDataException("Unknown InnerAlignment: $value")
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

        fun validate(): InnerAlignment = apply {
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

            return other is InnerAlignment && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Specifies the line height for multi-line text overlays. It will come into effect only if the
     * text wraps over multiple lines. Accepts either an integer value or an arithmetic expression.
     */
    @JsonDeserialize(using = LineHeight.Deserializer::class)
    @JsonSerialize(using = LineHeight.Serializer::class)
    class LineHeight
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): LineHeight = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LineHeight && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "LineHeight{number=$number}"
                string != null -> "LineHeight{string=$string}"
                _json != null -> "LineHeight{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid LineHeight")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = LineHeight(number = number)

            @JvmStatic fun ofString(string: String) = LineHeight(string = string)
        }

        /**
         * An interface that defines how to map each variant of [LineHeight] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [LineHeight] to a value of type [T].
             *
             * An instance of [LineHeight] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown LineHeight: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<LineHeight>(LineHeight::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): LineHeight {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                LineHeight(number = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                LineHeight(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> LineHeight(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<LineHeight>(LineHeight::class) {

            override fun serialize(
                value: LineHeight,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid LineHeight")
                }
            }
        }
    }

    /**
     * Specifies the padding around the overlaid text. Can be provided as a single positive integer
     * or multiple values separated by underscores (following CSS shorthand order). Arithmetic
     * expressions are also accepted.
     */
    @JsonDeserialize(using = Padding.Deserializer::class)
    @JsonSerialize(using = Padding.Serializer::class)
    class Padding
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Padding = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Padding && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Padding{number=$number}"
                string != null -> "Padding{string=$string}"
                _json != null -> "Padding{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Padding")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Padding(number = number)

            @JvmStatic fun ofString(string: String) = Padding(string = string)
        }

        /**
         * An interface that defines how to map each variant of [Padding] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Padding] to a value of type [T].
             *
             * An instance of [Padding] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Padding: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Padding>(Padding::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Padding {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Padding(number = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Padding(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Padding(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Padding>(Padding::class) {

            override fun serialize(
                value: Padding,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Padding")
                }
            }
        }
    }

    /**
     * Specifies the corner radius:
     * - Single value (positive integer): Applied to all corners (e.g., `20`).
     * - `max`: Creates a circular or oval shape.
     * - Per-corner array: Provide four underscore-separated values representing top-left,
     *   top-right, bottom-right, and bottom-left corners respectively (e.g., `10_20_30_40`). See
     *   [Radius](https://imagekit.io/docs/effects-and-enhancements#radius---r).
     */
    @JsonDeserialize(using = Radius.Deserializer::class)
    @JsonSerialize(using = Radius.Serializer::class)
    class Radius
    private constructor(
        private val number: Double? = null,
        private val max: JsonValue? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun max(): Optional<JsonValue> = Optional.ofNullable(max)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isMax(): Boolean = max != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asMax(): JsonValue = max.getOrThrow("max")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                max != null -> visitor.visitMax(max)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Radius = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitMax(max: JsonValue) {
                        max.let {
                            if (it != JsonValue.from("max")) {
                                throw ImageKitInvalidDataException("'max' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitString(string: String) {}
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitNumber(number: Double) = 1

                    override fun visitMax(max: JsonValue) =
                        max.let { if (it == JsonValue.from("max")) 1 else 0 }

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Radius &&
                number == other.number &&
                max == other.max &&
                string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, max, string)

        override fun toString(): String =
            when {
                number != null -> "Radius{number=$number}"
                max != null -> "Radius{max=$max}"
                string != null -> "Radius{string=$string}"
                _json != null -> "Radius{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Radius")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Radius(number = number)

            @JvmStatic fun ofMax() = Radius(max = JsonValue.from("max"))

            @JvmStatic fun ofString(string: String) = Radius(string = string)
        }

        /** An interface that defines how to map each variant of [Radius] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitMax(max: JsonValue): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Radius] to a value of type [T].
             *
             * An instance of [Radius] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Radius: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Radius>(Radius::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Radius {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Radius(max = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Radius(number = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Radius(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Radius(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Radius>(Radius::class) {

            override fun serialize(
                value: Radius,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.max != null -> generator.writeObject(value.max)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Radius")
                }
            }
        }
    }

    /**
     * Specifies the rotation angle of the text overlay. Accepts a numeric value for clockwise
     * rotation or a string prefixed with "N" for counter-clockwise rotation.
     */
    @JsonDeserialize(using = Rotation.Deserializer::class)
    @JsonSerialize(using = Rotation.Serializer::class)
    class Rotation
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Rotation = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Rotation && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Rotation{number=$number}"
                string != null -> "Rotation{string=$string}"
                _json != null -> "Rotation{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Rotation")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Rotation(number = number)

            @JvmStatic fun ofString(string: String) = Rotation(string = string)
        }

        /**
         * An interface that defines how to map each variant of [Rotation] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Rotation] to a value of type [T].
             *
             * An instance of [Rotation] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Rotation: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Rotation>(Rotation::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Rotation {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Rotation(number = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Rotation(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Rotation(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Rotation>(Rotation::class) {

            override fun serialize(
                value: Rotation,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Rotation")
                }
            }
        }
    }

    /**
     * Specifies the maximum width (in pixels) of the overlaid text. The text wraps automatically,
     * and arithmetic expressions (e.g., `bw_mul_0.2` or `bh_div_2`) are supported. Useful when used
     * in conjunction with the `background`. Learn about
     * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     */
    @JsonDeserialize(using = Width.Deserializer::class)
    @JsonSerialize(using = Width.Serializer::class)
    class Width
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Width = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Width && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Width{number=$number}"
                string != null -> "Width{string=$string}"
                _json != null -> "Width{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Width")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Width(number = number)

            @JvmStatic fun ofString(string: String) = Width(string = string)
        }

        /** An interface that defines how to map each variant of [Width] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Width] to a value of type [T].
             *
             * An instance of [Width] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Width: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Width>(Width::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Width {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Width(number = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Width(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Width(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Width>(Width::class) {

            override fun serialize(
                value: Width,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Width")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TextOverlayTransformation &&
            alpha == other.alpha &&
            background == other.background &&
            flip == other.flip &&
            fontColor == other.fontColor &&
            fontFamily == other.fontFamily &&
            fontSize == other.fontSize &&
            innerAlignment == other.innerAlignment &&
            lineHeight == other.lineHeight &&
            padding == other.padding &&
            radius == other.radius &&
            rotation == other.rotation &&
            typography == other.typography &&
            width == other.width &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            alpha,
            background,
            flip,
            fontColor,
            fontFamily,
            fontSize,
            innerAlignment,
            lineHeight,
            padding,
            radius,
            rotation,
            typography,
            width,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TextOverlayTransformation{alpha=$alpha, background=$background, flip=$flip, fontColor=$fontColor, fontFamily=$fontFamily, fontSize=$fontSize, innerAlignment=$innerAlignment, lineHeight=$lineHeight, padding=$padding, radius=$radius, rotation=$rotation, typography=$typography, width=$width, additionalProperties=$additionalProperties}"
}
