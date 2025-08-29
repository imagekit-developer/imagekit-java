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

class SolidColorOverlayTransformation
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
     * Alpha transparency level
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun alpha(): Optional<Double> = alpha.getOptional("alpha")

    /**
     * Background color
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun background(): Optional<String> = background.getOptional("background")

    /**
     * Gradient effect for the overlay
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun gradient(): Optional<Gradient> = gradient.getOptional("gradient")

    /**
     * Height of the solid color overlay
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun height(): Optional<Height> = height.getOptional("height")

    /**
     * Corner radius of the solid color overlay
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun radius(): Optional<Radius> = radius.getOptional("radius")

    /**
     * Width of the solid color overlay
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

        /** Alpha transparency level */
        fun alpha(alpha: Double) = alpha(JsonField.of(alpha))

        /**
         * Sets [Builder.alpha] to an arbitrary JSON value.
         *
         * You should usually call [Builder.alpha] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun alpha(alpha: JsonField<Double>) = apply { this.alpha = alpha }

        /** Background color */
        fun background(background: String) = background(JsonField.of(background))

        /**
         * Sets [Builder.background] to an arbitrary JSON value.
         *
         * You should usually call [Builder.background] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun background(background: JsonField<String>) = apply { this.background = background }

        /** Gradient effect for the overlay */
        fun gradient(gradient: Gradient) = gradient(JsonField.of(gradient))

        /**
         * Sets [Builder.gradient] to an arbitrary JSON value.
         *
         * You should usually call [Builder.gradient] with a well-typed [Gradient] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun gradient(gradient: JsonField<Gradient>) = apply { this.gradient = gradient }

        /** Alias for calling [gradient] with `Gradient.ofUnionMember0(unionMember0)`. */
        fun gradient(unionMember0: Gradient.UnionMember0) =
            gradient(Gradient.ofUnionMember0(unionMember0))

        /** Alias for calling [gradient] with `Gradient.ofString(string)`. */
        fun gradient(string: String) = gradient(Gradient.ofString(string))

        /** Height of the solid color overlay */
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

        /** Corner radius of the solid color overlay */
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

        /** Alias for calling [radius] with `Radius.ofUnionMember1(unionMember1)`. */
        fun radius(unionMember1: Radius.UnionMember1) = radius(Radius.ofUnionMember1(unionMember1))

        /** Width of the solid color overlay */
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

    /** Gradient effect for the overlay */
    @JsonDeserialize(using = Gradient.Deserializer::class)
    @JsonSerialize(using = Gradient.Serializer::class)
    class Gradient
    private constructor(
        private val unionMember0: UnionMember0? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun unionMember0(): Optional<UnionMember0> = Optional.ofNullable(unionMember0)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isUnionMember0(): Boolean = unionMember0 != null

        fun isString(): Boolean = string != null

        fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
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
                    override fun visitUnionMember0(unionMember0: UnionMember0) {
                        unionMember0.validate()
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
                    override fun visitUnionMember0(unionMember0: UnionMember0) =
                        unionMember0.validity()

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Gradient && unionMember0 == other.unionMember0 && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(unionMember0, string)

        override fun toString(): String =
            when {
                unionMember0 != null -> "Gradient{unionMember0=$unionMember0}"
                string != null -> "Gradient{string=$string}"
                _json != null -> "Gradient{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Gradient")
            }

        companion object {

            @JvmStatic
            fun ofUnionMember0(unionMember0: UnionMember0) = Gradient(unionMember0 = unionMember0)

            @JvmStatic fun ofString(string: String) = Gradient(string = string)
        }

        /**
         * An interface that defines how to map each variant of [Gradient] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitUnionMember0(unionMember0: UnionMember0): T

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
                            tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                                Gradient(unionMember0 = it, _json = json)
                            },
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
                    value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Gradient")
                }
            }
        }

        class UnionMember0 @JsonCreator private constructor(private val value: JsonField<Boolean>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

            companion object {

                @JvmField val TRUE = of(true)

                @JvmStatic fun of(value: Boolean) = UnionMember0(JsonField.of(value))
            }

            /** An enum containing [UnionMember0]'s known values. */
            enum class Known {
                TRUE
            }

            /**
             * An enum containing [UnionMember0]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [UnionMember0] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TRUE,
                /**
                 * An enum member indicating that [UnionMember0] was instantiated with an unknown
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
                    TRUE -> Value.TRUE
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
                    TRUE -> Known.TRUE
                    else -> throw ImageKitInvalidDataException("Unknown UnionMember0: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws ImageKitInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asBoolean(): Boolean =
                _value().asBoolean().orElseThrow {
                    ImageKitInvalidDataException("Value is not a Boolean")
                }

            private var validated: Boolean = false

            fun validate(): UnionMember0 = apply {
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

                return other is UnionMember0 && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }
    }

    /** Height of the solid color overlay */
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

    /** Corner radius of the solid color overlay */
    @JsonDeserialize(using = Radius.Deserializer::class)
    @JsonSerialize(using = Radius.Serializer::class)
    class Radius
    private constructor(
        private val number: Double? = null,
        private val unionMember1: UnionMember1? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun unionMember1(): Optional<UnionMember1> = Optional.ofNullable(unionMember1)

        fun isNumber(): Boolean = number != null

        fun isUnionMember1(): Boolean = unionMember1 != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
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

                    override fun visitUnionMember1(unionMember1: UnionMember1) {
                        unionMember1.validate()
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

                    override fun visitUnionMember1(unionMember1: UnionMember1) =
                        unionMember1.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Radius && number == other.number && unionMember1 == other.unionMember1
        }

        override fun hashCode(): Int = Objects.hash(number, unionMember1)

        override fun toString(): String =
            when {
                number != null -> "Radius{number=$number}"
                unionMember1 != null -> "Radius{unionMember1=$unionMember1}"
                _json != null -> "Radius{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Radius")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Radius(number = number)

            @JvmStatic
            fun ofUnionMember1(unionMember1: UnionMember1) = Radius(unionMember1 = unionMember1)
        }

        /** An interface that defines how to map each variant of [Radius] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitUnionMember1(unionMember1: UnionMember1): T

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
                            tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                                Radius(unionMember1 = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Radius(number = it, _json = json)
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
                    value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Radius")
                }
            }
        }

        class UnionMember1 @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val MAX = of("max")

                @JvmStatic fun of(value: String) = UnionMember1(JsonField.of(value))
            }

            /** An enum containing [UnionMember1]'s known values. */
            enum class Known {
                MAX
            }

            /**
             * An enum containing [UnionMember1]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [UnionMember1] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                MAX,
                /**
                 * An enum member indicating that [UnionMember1] was instantiated with an unknown
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
                    MAX -> Value.MAX
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
                    MAX -> Known.MAX
                    else -> throw ImageKitInvalidDataException("Unknown UnionMember1: $value")
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

            fun validate(): UnionMember1 = apply {
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

                return other is UnionMember1 && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }
    }

    /** Width of the solid color overlay */
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
