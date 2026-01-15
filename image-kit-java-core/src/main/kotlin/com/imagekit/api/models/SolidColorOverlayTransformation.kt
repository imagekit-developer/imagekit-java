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

class SolidColorOverlayTransformation
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val alpha: JsonField<Double>,
    private val background: JsonField<String>,
    private val gradient: JsonField<Gradient>,
    private val height: JsonField<Height>,
    private val radius: JsonField<Radius>,
    private val width: JsonField<Width>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("alpha") @ExcludeMissing alpha: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("background")
        @ExcludeMissing
        background: JsonField<String> = JsonMissing.of(),
        @JsonProperty("gradient") @ExcludeMissing gradient: JsonField<Gradient> = JsonMissing.of(),
        @JsonProperty("height") @ExcludeMissing height: JsonField<Height> = JsonMissing.of(),
        @JsonProperty("radius") @ExcludeMissing radius: JsonField<Radius> = JsonMissing.of(),
        @JsonProperty("width") @ExcludeMissing width: JsonField<Width> = JsonMissing.of(),
    ) : this(alpha, background, gradient, height, radius, width, mutableMapOf())

    /**
     * Specifies the transparency level of the overlaid solid color layer. Supports integers from
     * `1` to `9`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun alpha(): Optional<Double> = alpha.getOptional("alpha")

    /**
     * Specifies the background color of the solid color overlay. Accepts an RGB hex code (e.g.,
     * `FF0000`), an RGBA code (e.g., `FFAABB50`), or a color name.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun background(): Optional<String> = background.getOptional("background")

    /**
     * Creates a linear gradient with two colors. Pass `true` for a default gradient, or provide a
     * string for a custom gradient. Only works if the base asset is an image. See
     * [gradient](https://imagekit.io/docs/effects-and-enhancements#gradient---e-gradient).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun gradient(): Optional<Gradient> = gradient.getOptional("gradient")

    /**
     * Controls the height of the solid color overlay. Accepts a numeric value or an arithmetic
     * expression. Learn about
     * [arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun height(): Optional<Height> = height.getOptional("height")

    /**
     * Specifies the corner radius of the solid color overlay.
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
     * Controls the width of the solid color overlay. Accepts a numeric value or an arithmetic
     * expression (e.g., `bw_mul_0.2` or `bh_div_2`). Learn about
     * [arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
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
     * Returns the raw JSON value of [gradient].
     *
     * Unlike [gradient], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("gradient") @ExcludeMissing fun _gradient(): JsonField<Gradient> = gradient

    /**
     * Returns the raw JSON value of [height].
     *
     * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Height> = height

    /**
     * Returns the raw JSON value of [radius].
     *
     * Unlike [radius], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("radius") @ExcludeMissing fun _radius(): JsonField<Radius> = radius

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
         * Returns a mutable builder for constructing an instance of
         * [SolidColorOverlayTransformation].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SolidColorOverlayTransformation]. */
    class Builder internal constructor() {

        private var alpha: JsonField<Double> = JsonMissing.of()
        private var background: JsonField<String> = JsonMissing.of()
        private var gradient: JsonField<Gradient> = JsonMissing.of()
        private var height: JsonField<Height> = JsonMissing.of()
        private var radius: JsonField<Radius> = JsonMissing.of()
        private var width: JsonField<Width> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(solidColorOverlayTransformation: SolidColorOverlayTransformation) =
            apply {
                alpha = solidColorOverlayTransformation.alpha
                background = solidColorOverlayTransformation.background
                gradient = solidColorOverlayTransformation.gradient
                height = solidColorOverlayTransformation.height
                radius = solidColorOverlayTransformation.radius
                width = solidColorOverlayTransformation.width
                additionalProperties =
                    solidColorOverlayTransformation.additionalProperties.toMutableMap()
            }

        /**
         * Specifies the transparency level of the overlaid solid color layer. Supports integers
         * from `1` to `9`.
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
         * Specifies the background color of the solid color overlay. Accepts an RGB hex code (e.g.,
         * `FF0000`), an RGBA code (e.g., `FFAABB50`), or a color name.
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
         * Creates a linear gradient with two colors. Pass `true` for a default gradient, or provide
         * a string for a custom gradient. Only works if the base asset is an image. See
         * [gradient](https://imagekit.io/docs/effects-and-enhancements#gradient---e-gradient).
         */
        fun gradient(gradient: Gradient) = gradient(JsonField.of(gradient))

        /**
         * Sets [Builder.gradient] to an arbitrary JSON value.
         *
         * You should usually call [Builder.gradient] with a well-typed [Gradient] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun gradient(gradient: JsonField<Gradient>) = apply { this.gradient = gradient }

        /** Alias for calling [gradient] with `Gradient.ofTrue()`. */
        fun gradientTrue() = gradient(Gradient.ofTrue())

        /** Alias for calling [gradient] with `Gradient.ofString(string)`. */
        fun gradient(string: String) = gradient(Gradient.ofString(string))

        /**
         * Controls the height of the solid color overlay. Accepts a numeric value or an arithmetic
         * expression. Learn about
         * [arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
         */
        fun height(height: Height) = height(JsonField.of(height))

        /**
         * Sets [Builder.height] to an arbitrary JSON value.
         *
         * You should usually call [Builder.height] with a well-typed [Height] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun height(height: JsonField<Height>) = apply { this.height = height }

        /** Alias for calling [height] with `Height.ofNumber(number)`. */
        fun height(number: Double) = height(Height.ofNumber(number))

        /** Alias for calling [height] with `Height.ofString(string)`. */
        fun height(string: String) = height(Height.ofString(string))

        /**
         * Specifies the corner radius of the solid color overlay.
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
         * Controls the width of the solid color overlay. Accepts a numeric value or an arithmetic
         * expression (e.g., `bw_mul_0.2` or `bh_div_2`). Learn about
         * [arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
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
         * Returns an immutable instance of [SolidColorOverlayTransformation].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SolidColorOverlayTransformation =
            SolidColorOverlayTransformation(
                alpha,
                background,
                gradient,
                height,
                radius,
                width,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SolidColorOverlayTransformation = apply {
        if (validated) {
            return@apply
        }

        alpha()
        background()
        gradient().ifPresent { it.validate() }
        height().ifPresent { it.validate() }
        radius().ifPresent { it.validate() }
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
            (gradient.asKnown().getOrNull()?.validity() ?: 0) +
            (height.asKnown().getOrNull()?.validity() ?: 0) +
            (radius.asKnown().getOrNull()?.validity() ?: 0) +
            (width.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Creates a linear gradient with two colors. Pass `true` for a default gradient, or provide a
     * string for a custom gradient. Only works if the base asset is an image. See
     * [gradient](https://imagekit.io/docs/effects-and-enhancements#gradient---e-gradient).
     */
    @JsonDeserialize(using = Gradient.Deserializer::class)
    @JsonSerialize(using = Gradient.Serializer::class)
    class Gradient
    private constructor(
        private val true_: JsonValue? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun true_(): Optional<JsonValue> = Optional.ofNullable(true_)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isTrue(): Boolean = true_ != null

        fun isString(): Boolean = string != null

        fun asTrue(): JsonValue = true_.getOrThrow("true_")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                true_ != null -> visitor.visitTrue(true_)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Gradient = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTrue(true_: JsonValue) {
                        true_.let {
                            if (it != JsonValue.from(true)) {
                                throw ImageKitInvalidDataException(
                                    "'true_' is invalid, received $it"
                                )
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
                    override fun visitTrue(true_: JsonValue) =
                        true_.let { if (it == JsonValue.from(true)) 1 else 0 }

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Gradient && true_ == other.true_ && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(true_, string)

        override fun toString(): String =
            when {
                true_ != null -> "Gradient{true_=$true_}"
                string != null -> "Gradient{string=$string}"
                _json != null -> "Gradient{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Gradient")
            }

        companion object {

            @JvmStatic fun ofTrue() = Gradient(true_ = JsonValue.from(true))

            @JvmStatic fun ofString(string: String) = Gradient(string = string)
        }

        /**
         * An interface that defines how to map each variant of [Gradient] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitTrue(true_: JsonValue): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Gradient] to a value of type [T].
             *
             * An instance of [Gradient] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Gradient: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Gradient>(Gradient::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Gradient {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Gradient(true_ = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Gradient(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> Gradient(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Gradient>(Gradient::class) {

            override fun serialize(
                value: Gradient,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.true_ != null -> generator.writeObject(value.true_)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Gradient")
                }
            }
        }
    }

    /**
     * Controls the height of the solid color overlay. Accepts a numeric value or an arithmetic
     * expression. Learn about
     * [arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     */
    @JsonDeserialize(using = Height.Deserializer::class)
    @JsonSerialize(using = Height.Serializer::class)
    class Height
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

        fun validate(): Height = apply {
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

            return other is Height && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Height{number=$number}"
                string != null -> "Height{string=$string}"
                _json != null -> "Height{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Height")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Height(number = number)

            @JvmStatic fun ofString(string: String) = Height(string = string)
        }

        /** An interface that defines how to map each variant of [Height] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Height] to a value of type [T].
             *
             * An instance of [Height] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Height: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Height>(Height::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Height {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Height(number = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Height(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> Height(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Height>(Height::class) {

            override fun serialize(
                value: Height,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Height")
                }
            }
        }
    }

    /**
     * Specifies the corner radius of the solid color overlay.
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
                    // all the possible variants (e.g. deserializing from object).
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
     * Controls the width of the solid color overlay. Accepts a numeric value or an arithmetic
     * expression (e.g., `bw_mul_0.2` or `bh_div_2`). Learn about
     * [arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
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
                    // all the possible variants (e.g. deserializing from object).
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

        return other is SolidColorOverlayTransformation &&
            alpha == other.alpha &&
            background == other.background &&
            gradient == other.gradient &&
            height == other.height &&
            radius == other.radius &&
            width == other.width &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(alpha, background, gradient, height, radius, width, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SolidColorOverlayTransformation{alpha=$alpha, background=$background, gradient=$gradient, height=$height, radius=$radius, width=$width, additionalProperties=$additionalProperties}"
}
