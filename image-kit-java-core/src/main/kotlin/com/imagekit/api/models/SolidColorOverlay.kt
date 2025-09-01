// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

class SolidColorOverlay
private constructor(
    private val position: JsonField<OverlayPosition>,
    private val timing: JsonField<OverlayTiming>,
    private val color: JsonField<String>,
    private val type: JsonValue,
    private val transformation: JsonField<List<SolidColorOverlayTransformation>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("position")
        @ExcludeMissing
        position: JsonField<OverlayPosition> = JsonMissing.of(),
        @JsonProperty("timing") @ExcludeMissing timing: JsonField<OverlayTiming> = JsonMissing.of(),
        @JsonProperty("color") @ExcludeMissing color: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("transformation")
        @ExcludeMissing
        transformation: JsonField<List<SolidColorOverlayTransformation>> = JsonMissing.of(),
    ) : this(position, timing, color, type, transformation, mutableMapOf())

    fun toBaseOverlay(): BaseOverlay =
        BaseOverlay.builder().position(position).timing(timing).build()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun position(): Optional<OverlayPosition> = position.getOptional("position")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timing(): Optional<OverlayTiming> = timing.getOptional("timing")

    /**
     * Specifies the color of the block using an RGB hex code (e.g., `FF0000`), an RGBA code (e.g.,
     * `FFAABB50`), or a color name (e.g., `red`). If an 8-character value is provided, the last two
     * characters represent the opacity level (from `00` for 0.00 to `99` for 0.99).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun color(): String = color.getRequired("color")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("solidColor")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Control width and height of the solid color overlay. Supported transformations depend on the
     * base/parent asset. See overlays on
     * [Images](https://imagekit.io/docs/add-overlays-on-images#apply-transformation-on-solid-color-overlay)
     * and
     * [Videos](https://imagekit.io/docs/add-overlays-on-videos#apply-transformations-on-solid-color-block-overlay).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun transformation(): Optional<List<SolidColorOverlayTransformation>> =
        transformation.getOptional("transformation")

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
     * Returns the raw JSON value of [color].
     *
     * Unlike [color], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("color") @ExcludeMissing fun _color(): JsonField<String> = color

    /**
     * Returns the raw JSON value of [transformation].
     *
     * Unlike [transformation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transformation")
    @ExcludeMissing
    fun _transformation(): JsonField<List<SolidColorOverlayTransformation>> = transformation

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
         * Returns a mutable builder for constructing an instance of [SolidColorOverlay].
         *
         * The following fields are required:
         * ```java
         * .color()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SolidColorOverlay]. */
    class Builder internal constructor() {

        private var position: JsonField<OverlayPosition> = JsonMissing.of()
        private var timing: JsonField<OverlayTiming> = JsonMissing.of()
        private var color: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("solidColor")
        private var transformation: JsonField<MutableList<SolidColorOverlayTransformation>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(solidColorOverlay: SolidColorOverlay) = apply {
            position = solidColorOverlay.position
            timing = solidColorOverlay.timing
            color = solidColorOverlay.color
            type = solidColorOverlay.type
            transformation = solidColorOverlay.transformation.map { it.toMutableList() }
            additionalProperties = solidColorOverlay.additionalProperties.toMutableMap()
        }

        fun position(position: OverlayPosition) = position(JsonField.of(position))

        /**
         * Sets [Builder.position] to an arbitrary JSON value.
         *
         * You should usually call [Builder.position] with a well-typed [OverlayPosition] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun position(position: JsonField<OverlayPosition>) = apply { this.position = position }

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
         * Specifies the color of the block using an RGB hex code (e.g., `FF0000`), an RGBA code
         * (e.g., `FFAABB50`), or a color name (e.g., `red`). If an 8-character value is provided,
         * the last two characters represent the opacity level (from `00` for 0.00 to `99` for
         * 0.99).
         */
        fun color(color: String) = color(JsonField.of(color))

        /**
         * Sets [Builder.color] to an arbitrary JSON value.
         *
         * You should usually call [Builder.color] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun color(color: JsonField<String>) = apply { this.color = color }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("solidColor")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * Control width and height of the solid color overlay. Supported transformations depend on
         * the base/parent asset. See overlays on
         * [Images](https://imagekit.io/docs/add-overlays-on-images#apply-transformation-on-solid-color-overlay)
         * and
         * [Videos](https://imagekit.io/docs/add-overlays-on-videos#apply-transformations-on-solid-color-block-overlay).
         */
        fun transformation(transformation: List<SolidColorOverlayTransformation>) =
            transformation(JsonField.of(transformation))

        /**
         * Sets [Builder.transformation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transformation] with a well-typed
         * `List<SolidColorOverlayTransformation>` value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun transformation(transformation: JsonField<List<SolidColorOverlayTransformation>>) =
            apply {
                this.transformation = transformation.map { it.toMutableList() }
            }

        /**
         * Adds a single [SolidColorOverlayTransformation] to [Builder.transformation].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTransformation(transformation: SolidColorOverlayTransformation) = apply {
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
         * Returns an immutable instance of [SolidColorOverlay].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .color()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SolidColorOverlay =
            SolidColorOverlay(
                position,
                timing,
                checkRequired("color", color),
                type,
                (transformation ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SolidColorOverlay = apply {
        if (validated) {
            return@apply
        }

        position().ifPresent { it.validate() }
        timing().ifPresent { it.validate() }
        color()
        _type().let {
            if (it != JsonValue.from("solidColor")) {
                throw ImageKitInvalidDataException("'type' is invalid, received $it")
            }
        }
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
        (position.asKnown().getOrNull()?.validity() ?: 0) +
            (timing.asKnown().getOrNull()?.validity() ?: 0) +
            (if (color.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("solidColor")) 1 else 0 } +
            (transformation.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SolidColorOverlay &&
            position == other.position &&
            timing == other.timing &&
            color == other.color &&
            type == other.type &&
            transformation == other.transformation &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(position, timing, color, type, transformation, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SolidColorOverlay{position=$position, timing=$timing, color=$color, type=$type, transformation=$transformation, additionalProperties=$additionalProperties}"
}
