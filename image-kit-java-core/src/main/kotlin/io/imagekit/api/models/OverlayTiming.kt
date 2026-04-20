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

class OverlayTiming
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val duration: JsonField<Duration>,
    private val end: JsonField<End>,
    private val start: JsonField<Start>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("duration") @ExcludeMissing duration: JsonField<Duration> = JsonMissing.of(),
        @JsonProperty("end") @ExcludeMissing end: JsonField<End> = JsonMissing.of(),
        @JsonProperty("start") @ExcludeMissing start: JsonField<Start> = JsonMissing.of(),
    ) : this(duration, end, start, mutableMapOf())

    /**
     * Specifies the duration (in seconds) during which the overlay should appear on the base video.
     * Accepts a positive number up to two decimal places (e.g., `20` or `20.50`) and arithmetic
     * expressions such as `bdu_mul_0.4` or `bdu_sub_idu`. Applies only if the base asset is a
     * video. Maps to `ldu` in the URL.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun duration(): Optional<Duration> = duration.getOptional("duration")

    /**
     * Specifies the end time (in seconds) for when the overlay should disappear from the base
     * video. If both end and duration are provided, duration is ignored. Accepts a positive number
     * up to two decimal places (e.g., `20` or `20.50`) and arithmetic expressions such as
     * `bdu_mul_0.4` or `bdu_sub_idu`. Applies only if the base asset is a video. Maps to `leo` in
     * the URL.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun end(): Optional<End> = end.getOptional("end")

    /**
     * Specifies the start time (in seconds) for when the overlay should appear on the base video.
     * Accepts a positive number up to two decimal places (e.g., `20` or `20.50`) and arithmetic
     * expressions such as `bdu_mul_0.4` or `bdu_sub_idu`. Applies only if the base asset is a
     * video. Maps to `lso` in the URL.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun start(): Optional<Start> = start.getOptional("start")

    /**
     * Returns the raw JSON value of [duration].
     *
     * Unlike [duration], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("duration") @ExcludeMissing fun _duration(): JsonField<Duration> = duration

    /**
     * Returns the raw JSON value of [end].
     *
     * Unlike [end], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("end") @ExcludeMissing fun _end(): JsonField<End> = end

    /**
     * Returns the raw JSON value of [start].
     *
     * Unlike [start], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("start") @ExcludeMissing fun _start(): JsonField<Start> = start

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

        /** Returns a mutable builder for constructing an instance of [OverlayTiming]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OverlayTiming]. */
    class Builder internal constructor() {

        private var duration: JsonField<Duration> = JsonMissing.of()
        private var end: JsonField<End> = JsonMissing.of()
        private var start: JsonField<Start> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(overlayTiming: OverlayTiming) = apply {
            duration = overlayTiming.duration
            end = overlayTiming.end
            start = overlayTiming.start
            additionalProperties = overlayTiming.additionalProperties.toMutableMap()
        }

        /**
         * Specifies the duration (in seconds) during which the overlay should appear on the base
         * video. Accepts a positive number up to two decimal places (e.g., `20` or `20.50`) and
         * arithmetic expressions such as `bdu_mul_0.4` or `bdu_sub_idu`. Applies only if the base
         * asset is a video. Maps to `ldu` in the URL.
         */
        fun duration(duration: Duration) = duration(JsonField.of(duration))

        /**
         * Sets [Builder.duration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.duration] with a well-typed [Duration] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun duration(duration: JsonField<Duration>) = apply { this.duration = duration }

        /** Alias for calling [duration] with `Duration.ofNumber(number)`. */
        fun duration(number: Double) = duration(Duration.ofNumber(number))

        /** Alias for calling [duration] with `Duration.ofString(string)`. */
        fun duration(string: String) = duration(Duration.ofString(string))

        /**
         * Specifies the end time (in seconds) for when the overlay should disappear from the base
         * video. If both end and duration are provided, duration is ignored. Accepts a positive
         * number up to two decimal places (e.g., `20` or `20.50`) and arithmetic expressions such
         * as `bdu_mul_0.4` or `bdu_sub_idu`. Applies only if the base asset is a video. Maps to
         * `leo` in the URL.
         */
        fun end(end: End) = end(JsonField.of(end))

        /**
         * Sets [Builder.end] to an arbitrary JSON value.
         *
         * You should usually call [Builder.end] with a well-typed [End] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun end(end: JsonField<End>) = apply { this.end = end }

        /** Alias for calling [end] with `End.ofNumber(number)`. */
        fun end(number: Double) = end(End.ofNumber(number))

        /** Alias for calling [end] with `End.ofString(string)`. */
        fun end(string: String) = end(End.ofString(string))

        /**
         * Specifies the start time (in seconds) for when the overlay should appear on the base
         * video. Accepts a positive number up to two decimal places (e.g., `20` or `20.50`) and
         * arithmetic expressions such as `bdu_mul_0.4` or `bdu_sub_idu`. Applies only if the base
         * asset is a video. Maps to `lso` in the URL.
         */
        fun start(start: Start) = start(JsonField.of(start))

        /**
         * Sets [Builder.start] to an arbitrary JSON value.
         *
         * You should usually call [Builder.start] with a well-typed [Start] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun start(start: JsonField<Start>) = apply { this.start = start }

        /** Alias for calling [start] with `Start.ofNumber(number)`. */
        fun start(number: Double) = start(Start.ofNumber(number))

        /** Alias for calling [start] with `Start.ofString(string)`. */
        fun start(string: String) = start(Start.ofString(string))

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
         * Returns an immutable instance of [OverlayTiming].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): OverlayTiming =
            OverlayTiming(duration, end, start, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): OverlayTiming = apply {
        if (validated) {
            return@apply
        }

        duration().ifPresent { it.validate() }
        end().ifPresent { it.validate() }
        start().ifPresent { it.validate() }
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
        (duration.asKnown().getOrNull()?.validity() ?: 0) +
            (end.asKnown().getOrNull()?.validity() ?: 0) +
            (start.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Specifies the duration (in seconds) during which the overlay should appear on the base video.
     * Accepts a positive number up to two decimal places (e.g., `20` or `20.50`) and arithmetic
     * expressions such as `bdu_mul_0.4` or `bdu_sub_idu`. Applies only if the base asset is a
     * video. Maps to `ldu` in the URL.
     */
    @JsonDeserialize(using = Duration.Deserializer::class)
    @JsonSerialize(using = Duration.Serializer::class)
    class Duration
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

        fun validate(): Duration = apply {
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

            return other is Duration && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Duration{number=$number}"
                string != null -> "Duration{string=$string}"
                _json != null -> "Duration{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Duration")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Duration(number = number)

            @JvmStatic fun ofString(string: String) = Duration(string = string)
        }

        /**
         * An interface that defines how to map each variant of [Duration] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Duration] to a value of type [T].
             *
             * An instance of [Duration] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Duration: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Duration>(Duration::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Duration {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Duration(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Duration(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Duration(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Duration>(Duration::class) {

            override fun serialize(
                value: Duration,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Duration")
                }
            }
        }
    }

    /**
     * Specifies the end time (in seconds) for when the overlay should disappear from the base
     * video. If both end and duration are provided, duration is ignored. Accepts a positive number
     * up to two decimal places (e.g., `20` or `20.50`) and arithmetic expressions such as
     * `bdu_mul_0.4` or `bdu_sub_idu`. Applies only if the base asset is a video. Maps to `leo` in
     * the URL.
     */
    @JsonDeserialize(using = End.Deserializer::class)
    @JsonSerialize(using = End.Serializer::class)
    class End
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

        fun validate(): End = apply {
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

            return other is End && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "End{number=$number}"
                string != null -> "End{string=$string}"
                _json != null -> "End{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid End")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = End(number = number)

            @JvmStatic fun ofString(string: String) = End(string = string)
        }

        /** An interface that defines how to map each variant of [End] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [End] to a value of type [T].
             *
             * An instance of [End] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown End: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<End>(End::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): End {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                End(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                End(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> End(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<End>(End::class) {

            override fun serialize(
                value: End,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid End")
                }
            }
        }
    }

    /**
     * Specifies the start time (in seconds) for when the overlay should appear on the base video.
     * Accepts a positive number up to two decimal places (e.g., `20` or `20.50`) and arithmetic
     * expressions such as `bdu_mul_0.4` or `bdu_sub_idu`. Applies only if the base asset is a
     * video. Maps to `lso` in the URL.
     */
    @JsonDeserialize(using = Start.Deserializer::class)
    @JsonSerialize(using = Start.Serializer::class)
    class Start
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

        fun validate(): Start = apply {
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

            return other is Start && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Start{number=$number}"
                string != null -> "Start{string=$string}"
                _json != null -> "Start{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Start")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Start(number = number)

            @JvmStatic fun ofString(string: String) = Start(string = string)
        }

        /** An interface that defines how to map each variant of [Start] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Start] to a value of type [T].
             *
             * An instance of [Start] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Start: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Start>(Start::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Start {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Start(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Start(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Start(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Start>(Start::class) {

            override fun serialize(
                value: Start,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Start")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OverlayTiming &&
            duration == other.duration &&
            end == other.end &&
            start == other.start &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(duration, end, start, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OverlayTiming{duration=$duration, end=$end, start=$start, additionalProperties=$additionalProperties}"
}
