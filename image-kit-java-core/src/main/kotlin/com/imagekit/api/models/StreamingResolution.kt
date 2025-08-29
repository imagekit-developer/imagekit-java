// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.imagekit.api.core.Enum
import com.imagekit.api.core.JsonField
import com.imagekit.api.errors.ImageKitInvalidDataException

/** Available streaming resolutions for adaptive bitrate streaming */
class StreamingResolution @JsonCreator private constructor(private val value: JsonField<String>) :
    Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val _240 = of("240")

        @JvmField val _360 = of("360")

        @JvmField val _480 = of("480")

        @JvmField val _720 = of("720")

        @JvmField val _1080 = of("1080")

        @JvmField val _1440 = of("1440")

        @JvmField val _2160 = of("2160")

        @JvmStatic fun of(value: String) = StreamingResolution(JsonField.of(value))
    }

    /** An enum containing [StreamingResolution]'s known values. */
    enum class Known {
        _240,
        _360,
        _480,
        _720,
        _1080,
        _1440,
        _2160,
    }

    /**
     * An enum containing [StreamingResolution]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [StreamingResolution] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        _240,
        _360,
        _480,
        _720,
        _1080,
        _1440,
        _2160,
        /**
         * An enum member indicating that [StreamingResolution] was instantiated with an unknown
         * value.
         */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            _240 -> Value._240
            _360 -> Value._360
            _480 -> Value._480
            _720 -> Value._720
            _1080 -> Value._1080
            _1440 -> Value._1440
            _2160 -> Value._2160
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws ImageKitInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            _240 -> Known._240
            _360 -> Known._360
            _480 -> Known._480
            _720 -> Known._720
            _1080 -> Known._1080
            _1440 -> Known._1440
            _2160 -> Known._2160
            else -> throw ImageKitInvalidDataException("Unknown StreamingResolution: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws ImageKitInvalidDataException if this class instance's value does not have the
     *   expected primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { ImageKitInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    fun validate(): StreamingResolution = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StreamingResolution && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
