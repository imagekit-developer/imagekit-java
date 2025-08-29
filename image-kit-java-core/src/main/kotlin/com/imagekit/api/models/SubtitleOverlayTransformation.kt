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

class SubtitleOverlayTransformation
private constructor(
    private val background: JsonField<String>,
    private val color: JsonField<String>,
    private val fontFamily: JsonField<String>,
    private val fontOutline: JsonField<String>,
    private val fontShadow: JsonField<String>,
    private val fontSize: JsonField<FontSize>,
    private val typography: JsonField<Typography>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("background")
        @ExcludeMissing
        background: JsonField<String> = JsonMissing.of(),
        @JsonProperty("color") @ExcludeMissing color: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fontFamily")
        @ExcludeMissing
        fontFamily: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fontOutline")
        @ExcludeMissing
        fontOutline: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fontShadow")
        @ExcludeMissing
        fontShadow: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fontSize") @ExcludeMissing fontSize: JsonField<FontSize> = JsonMissing.of(),
        @JsonProperty("typography")
        @ExcludeMissing
        typography: JsonField<Typography> = JsonMissing.of(),
    ) : this(
        background,
        color,
        fontFamily,
        fontOutline,
        fontShadow,
        fontSize,
        typography,
        mutableMapOf(),
    )

    /**
     * Background color for subtitles
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun background(): Optional<String> = background.getOptional("background")

    /**
     * Text color for subtitles
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun color(): Optional<String> = color.getOptional("color")

    /**
     * Font family for subtitles
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fontFamily(): Optional<String> = fontFamily.getOptional("fontFamily")

    /**
     * Font outline for subtitles
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fontOutline(): Optional<String> = fontOutline.getOptional("fontOutline")

    /**
     * Font shadow for subtitles
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fontShadow(): Optional<String> = fontShadow.getOptional("fontShadow")

    /**
     * Font size for subtitles
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fontSize(): Optional<FontSize> = fontSize.getOptional("fontSize")

    /**
     * Typography style for subtitles
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun typography(): Optional<Typography> = typography.getOptional("typography")

    /**
     * Returns the raw JSON value of [background].
     *
     * Unlike [background], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("background") @ExcludeMissing fun _background(): JsonField<String> = background

    /**
     * Returns the raw JSON value of [color].
     *
     * Unlike [color], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("color") @ExcludeMissing fun _color(): JsonField<String> = color

    /**
     * Returns the raw JSON value of [fontFamily].
     *
     * Unlike [fontFamily], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fontFamily") @ExcludeMissing fun _fontFamily(): JsonField<String> = fontFamily

    /**
     * Returns the raw JSON value of [fontOutline].
     *
     * Unlike [fontOutline], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fontOutline") @ExcludeMissing fun _fontOutline(): JsonField<String> = fontOutline

    /**
     * Returns the raw JSON value of [fontShadow].
     *
     * Unlike [fontShadow], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fontShadow") @ExcludeMissing fun _fontShadow(): JsonField<String> = fontShadow

    /**
     * Returns the raw JSON value of [fontSize].
     *
     * Unlike [fontSize], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fontSize") @ExcludeMissing fun _fontSize(): JsonField<FontSize> = fontSize

    /**
     * Returns the raw JSON value of [typography].
     *
     * Unlike [typography], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("typography")
    @ExcludeMissing
    fun _typography(): JsonField<Typography> = typography

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
         * [SubtitleOverlayTransformation].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SubtitleOverlayTransformation]. */
    class Builder internal constructor() {

        private var background: JsonField<String> = JsonMissing.of()
        private var color: JsonField<String> = JsonMissing.of()
        private var fontFamily: JsonField<String> = JsonMissing.of()
        private var fontOutline: JsonField<String> = JsonMissing.of()
        private var fontShadow: JsonField<String> = JsonMissing.of()
        private var fontSize: JsonField<FontSize> = JsonMissing.of()
        private var typography: JsonField<Typography> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(subtitleOverlayTransformation: SubtitleOverlayTransformation) = apply {
            background = subtitleOverlayTransformation.background
            color = subtitleOverlayTransformation.color
            fontFamily = subtitleOverlayTransformation.fontFamily
            fontOutline = subtitleOverlayTransformation.fontOutline
            fontShadow = subtitleOverlayTransformation.fontShadow
            fontSize = subtitleOverlayTransformation.fontSize
            typography = subtitleOverlayTransformation.typography
            additionalProperties = subtitleOverlayTransformation.additionalProperties.toMutableMap()
        }

        /** Background color for subtitles */
        fun background(background: String) = background(JsonField.of(background))

        /**
         * Sets [Builder.background] to an arbitrary JSON value.
         *
         * You should usually call [Builder.background] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun background(background: JsonField<String>) = apply { this.background = background }

        /** Text color for subtitles */
        fun color(color: String) = color(JsonField.of(color))

        /**
         * Sets [Builder.color] to an arbitrary JSON value.
         *
         * You should usually call [Builder.color] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun color(color: JsonField<String>) = apply { this.color = color }

        /** Font family for subtitles */
        fun fontFamily(fontFamily: String) = fontFamily(JsonField.of(fontFamily))

        /**
         * Sets [Builder.fontFamily] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fontFamily] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fontFamily(fontFamily: JsonField<String>) = apply { this.fontFamily = fontFamily }

        /** Font outline for subtitles */
        fun fontOutline(fontOutline: String) = fontOutline(JsonField.of(fontOutline))

        /**
         * Sets [Builder.fontOutline] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fontOutline] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fontOutline(fontOutline: JsonField<String>) = apply { this.fontOutline = fontOutline }

        /** Font shadow for subtitles */
        fun fontShadow(fontShadow: String) = fontShadow(JsonField.of(fontShadow))

        /**
         * Sets [Builder.fontShadow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fontShadow] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fontShadow(fontShadow: JsonField<String>) = apply { this.fontShadow = fontShadow }

        /** Font size for subtitles */
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

        /** Typography style for subtitles */
        fun typography(typography: Typography) = typography(JsonField.of(typography))

        /**
         * Sets [Builder.typography] to an arbitrary JSON value.
         *
         * You should usually call [Builder.typography] with a well-typed [Typography] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun typography(typography: JsonField<Typography>) = apply { this.typography = typography }

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
         * Returns an immutable instance of [SubtitleOverlayTransformation].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SubtitleOverlayTransformation =
            SubtitleOverlayTransformation(
                background,
                color,
                fontFamily,
                fontOutline,
                fontShadow,
                fontSize,
                typography,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SubtitleOverlayTransformation = apply {
        if (validated) {
            return@apply
        }

        background()
        color()
        fontFamily()
        fontOutline()
        fontShadow()
        fontSize().ifPresent { it.validate() }
        typography().ifPresent { it.validate() }
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
        (if (background.asKnown().isPresent) 1 else 0) +
            (if (color.asKnown().isPresent) 1 else 0) +
            (if (fontFamily.asKnown().isPresent) 1 else 0) +
            (if (fontOutline.asKnown().isPresent) 1 else 0) +
            (if (fontShadow.asKnown().isPresent) 1 else 0) +
            (fontSize.asKnown().getOrNull()?.validity() ?: 0) +
            (typography.asKnown().getOrNull()?.validity() ?: 0)

    /** Font size for subtitles */
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
                    // all the possible variants (e.g. deserializing from object).
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

    /** Typography style for subtitles */
    class Typography @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val B = of("b")

            @JvmField val I = of("i")

            @JvmField val B_I = of("b_i")

            @JvmStatic fun of(value: String) = Typography(JsonField.of(value))
        }

        /** An enum containing [Typography]'s known values. */
        enum class Known {
            B,
            I,
            B_I,
        }

        /**
         * An enum containing [Typography]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Typography] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            B,
            I,
            B_I,
            /**
             * An enum member indicating that [Typography] was instantiated with an unknown value.
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
                B -> Value.B
                I -> Value.I
                B_I -> Value.B_I
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
                B -> Known.B
                I -> Known.I
                B_I -> Known.B_I
                else -> throw ImageKitInvalidDataException("Unknown Typography: $value")
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

        fun validate(): Typography = apply {
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

            return other is Typography && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SubtitleOverlayTransformation &&
            background == other.background &&
            color == other.color &&
            fontFamily == other.fontFamily &&
            fontOutline == other.fontOutline &&
            fontShadow == other.fontShadow &&
            fontSize == other.fontSize &&
            typography == other.typography &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            background,
            color,
            fontFamily,
            fontOutline,
            fontShadow,
            fontSize,
            typography,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SubtitleOverlayTransformation{background=$background, color=$color, fontFamily=$fontFamily, fontOutline=$fontOutline, fontShadow=$fontShadow, fontSize=$fontSize, typography=$typography, additionalProperties=$additionalProperties}"
}
