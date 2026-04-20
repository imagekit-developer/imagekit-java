// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models

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
import io.imagekit.api.core.BaseDeserializer
import io.imagekit.api.core.BaseSerializer
import io.imagekit.api.core.Enum
import io.imagekit.api.core.ExcludeMissing
import io.imagekit.api.core.JsonField
import io.imagekit.api.core.JsonMissing
import io.imagekit.api.core.JsonValue
import io.imagekit.api.core.allMaxBy
import io.imagekit.api.core.getOrThrow
import io.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class OverlayPosition
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val anchorPoint: JsonField<AnchorPoint>,
    private val focus: JsonField<Focus>,
    private val x: JsonField<X>,
    private val xCenter: JsonField<XCenter>,
    private val y: JsonField<Y>,
    private val yCenter: JsonField<YCenter>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("anchorPoint")
        @ExcludeMissing
        anchorPoint: JsonField<AnchorPoint> = JsonMissing.of(),
        @JsonProperty("focus") @ExcludeMissing focus: JsonField<Focus> = JsonMissing.of(),
        @JsonProperty("x") @ExcludeMissing x: JsonField<X> = JsonMissing.of(),
        @JsonProperty("xCenter") @ExcludeMissing xCenter: JsonField<XCenter> = JsonMissing.of(),
        @JsonProperty("y") @ExcludeMissing y: JsonField<Y> = JsonMissing.of(),
        @JsonProperty("yCenter") @ExcludeMissing yCenter: JsonField<YCenter> = JsonMissing.of(),
    ) : this(anchorPoint, focus, x, xCenter, y, yCenter, mutableMapOf())

    /**
     * Sets the anchor point on the base asset from which the overlay offset is calculated. The
     * default value is `top_left`. Maps to `lap` in the URL. Can only be used with one or more of
     * `x`, `y`, `xCenter`, or `yCenter`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun anchorPoint(): Optional<AnchorPoint> = anchorPoint.getOptional("anchorPoint")

    /**
     * Specifies the position of the overlay relative to the parent image or video. If one or more
     * of `x`, `y`, `xCenter`, or `yCenter` parameters are specified, this parameter is ignored.
     * Maps to `lfo` in the URL.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun focus(): Optional<Focus> = focus.getOptional("focus")

    /**
     * Specifies the x-coordinate of the top-left corner of the base asset where the overlay's
     * top-left corner will be positioned. It also accepts arithmetic expressions such as
     * `bw_mul_0.4` or `bw_sub_cw`. Maps to `lx` in the URL. Learn about
     * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun x(): Optional<X> = x.getOptional("x")

    /**
     * Specifies the x-coordinate on the base asset where the overlay's center will be positioned.
     * It also accepts arithmetic expressions such as `bw_mul_0.4` or `bw_sub_cw`. Maps to `lxc` in
     * the URL. Cannot be used together with `x`, but can be used with `y`. Learn about
     * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun xCenter(): Optional<XCenter> = xCenter.getOptional("xCenter")

    /**
     * Specifies the y-coordinate of the top-left corner of the base asset where the overlay's
     * top-left corner will be positioned. It also accepts arithmetic expressions such as
     * `bh_mul_0.4` or `bh_sub_ch`. Maps to `ly` in the URL. Learn about
     * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun y(): Optional<Y> = y.getOptional("y")

    /**
     * Specifies the y-coordinate on the base asset where the overlay's center will be positioned.
     * It also accepts arithmetic expressions such as `bh_mul_0.4` or `bh_sub_ch`. Maps to `lyc` in
     * the URL. Cannot be used together with `y`, but can be used with `x`. Learn about
     * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun yCenter(): Optional<YCenter> = yCenter.getOptional("yCenter")

    /**
     * Returns the raw JSON value of [anchorPoint].
     *
     * Unlike [anchorPoint], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("anchorPoint")
    @ExcludeMissing
    fun _anchorPoint(): JsonField<AnchorPoint> = anchorPoint

    /**
     * Returns the raw JSON value of [focus].
     *
     * Unlike [focus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("focus") @ExcludeMissing fun _focus(): JsonField<Focus> = focus

    /**
     * Returns the raw JSON value of [x].
     *
     * Unlike [x], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("x") @ExcludeMissing fun _x(): JsonField<X> = x

    /**
     * Returns the raw JSON value of [xCenter].
     *
     * Unlike [xCenter], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("xCenter") @ExcludeMissing fun _xCenter(): JsonField<XCenter> = xCenter

    /**
     * Returns the raw JSON value of [y].
     *
     * Unlike [y], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("y") @ExcludeMissing fun _y(): JsonField<Y> = y

    /**
     * Returns the raw JSON value of [yCenter].
     *
     * Unlike [yCenter], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("yCenter") @ExcludeMissing fun _yCenter(): JsonField<YCenter> = yCenter

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

        /** Returns a mutable builder for constructing an instance of [OverlayPosition]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OverlayPosition]. */
    class Builder internal constructor() {

        private var anchorPoint: JsonField<AnchorPoint> = JsonMissing.of()
        private var focus: JsonField<Focus> = JsonMissing.of()
        private var x: JsonField<X> = JsonMissing.of()
        private var xCenter: JsonField<XCenter> = JsonMissing.of()
        private var y: JsonField<Y> = JsonMissing.of()
        private var yCenter: JsonField<YCenter> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(overlayPosition: OverlayPosition) = apply {
            anchorPoint = overlayPosition.anchorPoint
            focus = overlayPosition.focus
            x = overlayPosition.x
            xCenter = overlayPosition.xCenter
            y = overlayPosition.y
            yCenter = overlayPosition.yCenter
            additionalProperties = overlayPosition.additionalProperties.toMutableMap()
        }

        /**
         * Sets the anchor point on the base asset from which the overlay offset is calculated. The
         * default value is `top_left`. Maps to `lap` in the URL. Can only be used with one or more
         * of `x`, `y`, `xCenter`, or `yCenter`.
         */
        fun anchorPoint(anchorPoint: AnchorPoint) = anchorPoint(JsonField.of(anchorPoint))

        /**
         * Sets [Builder.anchorPoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.anchorPoint] with a well-typed [AnchorPoint] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun anchorPoint(anchorPoint: JsonField<AnchorPoint>) = apply {
            this.anchorPoint = anchorPoint
        }

        /**
         * Specifies the position of the overlay relative to the parent image or video. If one or
         * more of `x`, `y`, `xCenter`, or `yCenter` parameters are specified, this parameter is
         * ignored. Maps to `lfo` in the URL.
         */
        fun focus(focus: Focus) = focus(JsonField.of(focus))

        /**
         * Sets [Builder.focus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.focus] with a well-typed [Focus] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun focus(focus: JsonField<Focus>) = apply { this.focus = focus }

        /**
         * Specifies the x-coordinate of the top-left corner of the base asset where the overlay's
         * top-left corner will be positioned. It also accepts arithmetic expressions such as
         * `bw_mul_0.4` or `bw_sub_cw`. Maps to `lx` in the URL. Learn about
         * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
         */
        fun x(x: X) = x(JsonField.of(x))

        /**
         * Sets [Builder.x] to an arbitrary JSON value.
         *
         * You should usually call [Builder.x] with a well-typed [X] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun x(x: JsonField<X>) = apply { this.x = x }

        /** Alias for calling [x] with `X.ofNumber(number)`. */
        fun x(number: Double) = x(X.ofNumber(number))

        /** Alias for calling [x] with `X.ofString(string)`. */
        fun x(string: String) = x(X.ofString(string))

        /**
         * Specifies the x-coordinate on the base asset where the overlay's center will be
         * positioned. It also accepts arithmetic expressions such as `bw_mul_0.4` or `bw_sub_cw`.
         * Maps to `lxc` in the URL. Cannot be used together with `x`, but can be used with `y`.
         * Learn about
         * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
         */
        fun xCenter(xCenter: XCenter) = xCenter(JsonField.of(xCenter))

        /**
         * Sets [Builder.xCenter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.xCenter] with a well-typed [XCenter] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun xCenter(xCenter: JsonField<XCenter>) = apply { this.xCenter = xCenter }

        /** Alias for calling [xCenter] with `XCenter.ofNumber(number)`. */
        fun xCenter(number: Double) = xCenter(XCenter.ofNumber(number))

        /** Alias for calling [xCenter] with `XCenter.ofString(string)`. */
        fun xCenter(string: String) = xCenter(XCenter.ofString(string))

        /**
         * Specifies the y-coordinate of the top-left corner of the base asset where the overlay's
         * top-left corner will be positioned. It also accepts arithmetic expressions such as
         * `bh_mul_0.4` or `bh_sub_ch`. Maps to `ly` in the URL. Learn about
         * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
         */
        fun y(y: Y) = y(JsonField.of(y))

        /**
         * Sets [Builder.y] to an arbitrary JSON value.
         *
         * You should usually call [Builder.y] with a well-typed [Y] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun y(y: JsonField<Y>) = apply { this.y = y }

        /** Alias for calling [y] with `Y.ofNumber(number)`. */
        fun y(number: Double) = y(Y.ofNumber(number))

        /** Alias for calling [y] with `Y.ofString(string)`. */
        fun y(string: String) = y(Y.ofString(string))

        /**
         * Specifies the y-coordinate on the base asset where the overlay's center will be
         * positioned. It also accepts arithmetic expressions such as `bh_mul_0.4` or `bh_sub_ch`.
         * Maps to `lyc` in the URL. Cannot be used together with `y`, but can be used with `x`.
         * Learn about
         * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
         */
        fun yCenter(yCenter: YCenter) = yCenter(JsonField.of(yCenter))

        /**
         * Sets [Builder.yCenter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.yCenter] with a well-typed [YCenter] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun yCenter(yCenter: JsonField<YCenter>) = apply { this.yCenter = yCenter }

        /** Alias for calling [yCenter] with `YCenter.ofNumber(number)`. */
        fun yCenter(number: Double) = yCenter(YCenter.ofNumber(number))

        /** Alias for calling [yCenter] with `YCenter.ofString(string)`. */
        fun yCenter(string: String) = yCenter(YCenter.ofString(string))

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
         * Returns an immutable instance of [OverlayPosition].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): OverlayPosition =
            OverlayPosition(
                anchorPoint,
                focus,
                x,
                xCenter,
                y,
                yCenter,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OverlayPosition = apply {
        if (validated) {
            return@apply
        }

        anchorPoint().ifPresent { it.validate() }
        focus().ifPresent { it.validate() }
        x().ifPresent { it.validate() }
        xCenter().ifPresent { it.validate() }
        y().ifPresent { it.validate() }
        yCenter().ifPresent { it.validate() }
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
        (anchorPoint.asKnown().getOrNull()?.validity() ?: 0) +
            (focus.asKnown().getOrNull()?.validity() ?: 0) +
            (x.asKnown().getOrNull()?.validity() ?: 0) +
            (xCenter.asKnown().getOrNull()?.validity() ?: 0) +
            (y.asKnown().getOrNull()?.validity() ?: 0) +
            (yCenter.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Sets the anchor point on the base asset from which the overlay offset is calculated. The
     * default value is `top_left`. Maps to `lap` in the URL. Can only be used with one or more of
     * `x`, `y`, `xCenter`, or `yCenter`.
     */
    class AnchorPoint @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val TOP = of("top")

            @JvmField val LEFT = of("left")

            @JvmField val RIGHT = of("right")

            @JvmField val BOTTOM = of("bottom")

            @JvmField val TOP_LEFT = of("top_left")

            @JvmField val TOP_RIGHT = of("top_right")

            @JvmField val BOTTOM_LEFT = of("bottom_left")

            @JvmField val BOTTOM_RIGHT = of("bottom_right")

            @JvmField val CENTER = of("center")

            @JvmStatic fun of(value: String) = AnchorPoint(JsonField.of(value))
        }

        /** An enum containing [AnchorPoint]'s known values. */
        enum class Known {
            TOP,
            LEFT,
            RIGHT,
            BOTTOM,
            TOP_LEFT,
            TOP_RIGHT,
            BOTTOM_LEFT,
            BOTTOM_RIGHT,
            CENTER,
        }

        /**
         * An enum containing [AnchorPoint]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [AnchorPoint] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TOP,
            LEFT,
            RIGHT,
            BOTTOM,
            TOP_LEFT,
            TOP_RIGHT,
            BOTTOM_LEFT,
            BOTTOM_RIGHT,
            CENTER,
            /**
             * An enum member indicating that [AnchorPoint] was instantiated with an unknown value.
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
                TOP -> Value.TOP
                LEFT -> Value.LEFT
                RIGHT -> Value.RIGHT
                BOTTOM -> Value.BOTTOM
                TOP_LEFT -> Value.TOP_LEFT
                TOP_RIGHT -> Value.TOP_RIGHT
                BOTTOM_LEFT -> Value.BOTTOM_LEFT
                BOTTOM_RIGHT -> Value.BOTTOM_RIGHT
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
                TOP -> Known.TOP
                LEFT -> Known.LEFT
                RIGHT -> Known.RIGHT
                BOTTOM -> Known.BOTTOM
                TOP_LEFT -> Known.TOP_LEFT
                TOP_RIGHT -> Known.TOP_RIGHT
                BOTTOM_LEFT -> Known.BOTTOM_LEFT
                BOTTOM_RIGHT -> Known.BOTTOM_RIGHT
                CENTER -> Known.CENTER
                else -> throw ImageKitInvalidDataException("Unknown AnchorPoint: $value")
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

        fun validate(): AnchorPoint = apply {
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

            return other is AnchorPoint && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Specifies the position of the overlay relative to the parent image or video. If one or more
     * of `x`, `y`, `xCenter`, or `yCenter` parameters are specified, this parameter is ignored.
     * Maps to `lfo` in the URL.
     */
    class Focus @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val CENTER = of("center")

            @JvmField val TOP = of("top")

            @JvmField val LEFT = of("left")

            @JvmField val BOTTOM = of("bottom")

            @JvmField val RIGHT = of("right")

            @JvmField val TOP_LEFT = of("top_left")

            @JvmField val TOP_RIGHT = of("top_right")

            @JvmField val BOTTOM_LEFT = of("bottom_left")

            @JvmField val BOTTOM_RIGHT = of("bottom_right")

            @JvmStatic fun of(value: String) = Focus(JsonField.of(value))
        }

        /** An enum containing [Focus]'s known values. */
        enum class Known {
            CENTER,
            TOP,
            LEFT,
            BOTTOM,
            RIGHT,
            TOP_LEFT,
            TOP_RIGHT,
            BOTTOM_LEFT,
            BOTTOM_RIGHT,
        }

        /**
         * An enum containing [Focus]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Focus] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CENTER,
            TOP,
            LEFT,
            BOTTOM,
            RIGHT,
            TOP_LEFT,
            TOP_RIGHT,
            BOTTOM_LEFT,
            BOTTOM_RIGHT,
            /** An enum member indicating that [Focus] was instantiated with an unknown value. */
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
                CENTER -> Value.CENTER
                TOP -> Value.TOP
                LEFT -> Value.LEFT
                BOTTOM -> Value.BOTTOM
                RIGHT -> Value.RIGHT
                TOP_LEFT -> Value.TOP_LEFT
                TOP_RIGHT -> Value.TOP_RIGHT
                BOTTOM_LEFT -> Value.BOTTOM_LEFT
                BOTTOM_RIGHT -> Value.BOTTOM_RIGHT
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
                CENTER -> Known.CENTER
                TOP -> Known.TOP
                LEFT -> Known.LEFT
                BOTTOM -> Known.BOTTOM
                RIGHT -> Known.RIGHT
                TOP_LEFT -> Known.TOP_LEFT
                TOP_RIGHT -> Known.TOP_RIGHT
                BOTTOM_LEFT -> Known.BOTTOM_LEFT
                BOTTOM_RIGHT -> Known.BOTTOM_RIGHT
                else -> throw ImageKitInvalidDataException("Unknown Focus: $value")
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

        fun validate(): Focus = apply {
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

            return other is Focus && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Specifies the x-coordinate of the top-left corner of the base asset where the overlay's
     * top-left corner will be positioned. It also accepts arithmetic expressions such as
     * `bw_mul_0.4` or `bw_sub_cw`. Maps to `lx` in the URL. Learn about
     * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     */
    @JsonDeserialize(using = X.Deserializer::class)
    @JsonSerialize(using = X.Serializer::class)
    class X
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

        fun validate(): X = apply {
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

            return other is X && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "X{number=$number}"
                string != null -> "X{string=$string}"
                _json != null -> "X{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid X")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = X(number = number)

            @JvmStatic fun ofString(string: String) = X(string = string)
        }

        /** An interface that defines how to map each variant of [X] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [X] to a value of type [T].
             *
             * An instance of [X] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown X: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<X>(X::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): X {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                X(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                X(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> X(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<X>(X::class) {

            override fun serialize(
                value: X,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid X")
                }
            }
        }
    }

    /**
     * Specifies the x-coordinate on the base asset where the overlay's center will be positioned.
     * It also accepts arithmetic expressions such as `bw_mul_0.4` or `bw_sub_cw`. Maps to `lxc` in
     * the URL. Cannot be used together with `x`, but can be used with `y`. Learn about
     * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     */
    @JsonDeserialize(using = XCenter.Deserializer::class)
    @JsonSerialize(using = XCenter.Serializer::class)
    class XCenter
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

        fun validate(): XCenter = apply {
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

            return other is XCenter && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "XCenter{number=$number}"
                string != null -> "XCenter{string=$string}"
                _json != null -> "XCenter{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid XCenter")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = XCenter(number = number)

            @JvmStatic fun ofString(string: String) = XCenter(string = string)
        }

        /**
         * An interface that defines how to map each variant of [XCenter] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [XCenter] to a value of type [T].
             *
             * An instance of [XCenter] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown XCenter: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<XCenter>(XCenter::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): XCenter {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                XCenter(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                XCenter(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> XCenter(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<XCenter>(XCenter::class) {

            override fun serialize(
                value: XCenter,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid XCenter")
                }
            }
        }
    }

    /**
     * Specifies the y-coordinate of the top-left corner of the base asset where the overlay's
     * top-left corner will be positioned. It also accepts arithmetic expressions such as
     * `bh_mul_0.4` or `bh_sub_ch`. Maps to `ly` in the URL. Learn about
     * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     */
    @JsonDeserialize(using = Y.Deserializer::class)
    @JsonSerialize(using = Y.Serializer::class)
    class Y
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

        fun validate(): Y = apply {
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

            return other is Y && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Y{number=$number}"
                string != null -> "Y{string=$string}"
                _json != null -> "Y{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Y")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Y(number = number)

            @JvmStatic fun ofString(string: String) = Y(string = string)
        }

        /** An interface that defines how to map each variant of [Y] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Y] to a value of type [T].
             *
             * An instance of [Y] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Y: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Y>(Y::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Y {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Y(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Y(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Y(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Y>(Y::class) {

            override fun serialize(
                value: Y,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Y")
                }
            }
        }
    }

    /**
     * Specifies the y-coordinate on the base asset where the overlay's center will be positioned.
     * It also accepts arithmetic expressions such as `bh_mul_0.4` or `bh_sub_ch`. Maps to `lyc` in
     * the URL. Cannot be used together with `y`, but can be used with `x`. Learn about
     * [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     */
    @JsonDeserialize(using = YCenter.Deserializer::class)
    @JsonSerialize(using = YCenter.Serializer::class)
    class YCenter
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

        fun validate(): YCenter = apply {
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

            return other is YCenter && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "YCenter{number=$number}"
                string != null -> "YCenter{string=$string}"
                _json != null -> "YCenter{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid YCenter")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = YCenter(number = number)

            @JvmStatic fun ofString(string: String) = YCenter(string = string)
        }

        /**
         * An interface that defines how to map each variant of [YCenter] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [YCenter] to a value of type [T].
             *
             * An instance of [YCenter] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown YCenter: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<YCenter>(YCenter::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): YCenter {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                YCenter(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                YCenter(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> YCenter(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<YCenter>(YCenter::class) {

            override fun serialize(
                value: YCenter,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid YCenter")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OverlayPosition &&
            anchorPoint == other.anchorPoint &&
            focus == other.focus &&
            x == other.x &&
            xCenter == other.xCenter &&
            y == other.y &&
            yCenter == other.yCenter &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(anchorPoint, focus, x, xCenter, y, yCenter, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OverlayPosition{anchorPoint=$anchorPoint, focus=$focus, x=$x, xCenter=$xCenter, y=$y, yCenter=$yCenter, additionalProperties=$additionalProperties}"
}
