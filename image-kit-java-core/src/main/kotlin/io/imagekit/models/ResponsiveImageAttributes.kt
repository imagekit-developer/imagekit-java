// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.core.checkRequired
import io.imagekit.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * Resulting set of attributes suitable for an HTML `<img>` element. Useful for enabling responsive
 * image loading with `srcSet` and `sizes`.
 */
class ResponsiveImageAttributes
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val src: JsonField<String>,
    private val sizes: JsonField<String>,
    private val srcSet: JsonField<String>,
    private val width: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("src") @ExcludeMissing src: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sizes") @ExcludeMissing sizes: JsonField<String> = JsonMissing.of(),
        @JsonProperty("srcSet") @ExcludeMissing srcSet: JsonField<String> = JsonMissing.of(),
        @JsonProperty("width") @ExcludeMissing width: JsonField<Double> = JsonMissing.of(),
    ) : this(src, sizes, srcSet, width, mutableMapOf())

    /**
     * URL for the *largest* candidate (assigned to plain `src`).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun src(): String = src.getRequired("src")

    /**
     * `sizes` returned (or synthesised as `100vw`). The value for the HTML `sizes` attribute.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sizes(): Optional<String> = sizes.getOptional("sizes")

    /**
     * Candidate set with `w` or `x` descriptors. Multiple image URLs separated by commas, each with
     * a descriptor.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun srcSet(): Optional<String> = srcSet.getOptional("srcSet")

    /**
     * Width as a number (if `width` was provided in the input options).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun width(): Optional<Double> = width.getOptional("width")

    /**
     * Returns the raw JSON value of [src].
     *
     * Unlike [src], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("src") @ExcludeMissing fun _src(): JsonField<String> = src

    /**
     * Returns the raw JSON value of [sizes].
     *
     * Unlike [sizes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sizes") @ExcludeMissing fun _sizes(): JsonField<String> = sizes

    /**
     * Returns the raw JSON value of [srcSet].
     *
     * Unlike [srcSet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("srcSet") @ExcludeMissing fun _srcSet(): JsonField<String> = srcSet

    /**
     * Returns the raw JSON value of [width].
     *
     * Unlike [width], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("width") @ExcludeMissing fun _width(): JsonField<Double> = width

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
         * Returns a mutable builder for constructing an instance of [ResponsiveImageAttributes].
         *
         * The following fields are required:
         * ```java
         * .src()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponsiveImageAttributes]. */
    class Builder internal constructor() {

        private var src: JsonField<String>? = null
        private var sizes: JsonField<String> = JsonMissing.of()
        private var srcSet: JsonField<String> = JsonMissing.of()
        private var width: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responsiveImageAttributes: ResponsiveImageAttributes) = apply {
            src = responsiveImageAttributes.src
            sizes = responsiveImageAttributes.sizes
            srcSet = responsiveImageAttributes.srcSet
            width = responsiveImageAttributes.width
            additionalProperties = responsiveImageAttributes.additionalProperties.toMutableMap()
        }

        /** URL for the *largest* candidate (assigned to plain `src`). */
        fun src(src: String) = src(JsonField.of(src))

        /**
         * Sets [Builder.src] to an arbitrary JSON value.
         *
         * You should usually call [Builder.src] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun src(src: JsonField<String>) = apply { this.src = src }

        /**
         * `sizes` returned (or synthesised as `100vw`). The value for the HTML `sizes` attribute.
         */
        fun sizes(sizes: String) = sizes(JsonField.of(sizes))

        /**
         * Sets [Builder.sizes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sizes] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sizes(sizes: JsonField<String>) = apply { this.sizes = sizes }

        /**
         * Candidate set with `w` or `x` descriptors. Multiple image URLs separated by commas, each
         * with a descriptor.
         */
        fun srcSet(srcSet: String) = srcSet(JsonField.of(srcSet))

        /**
         * Sets [Builder.srcSet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.srcSet] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun srcSet(srcSet: JsonField<String>) = apply { this.srcSet = srcSet }

        /** Width as a number (if `width` was provided in the input options). */
        fun width(width: Double) = width(JsonField.of(width))

        /**
         * Sets [Builder.width] to an arbitrary JSON value.
         *
         * You should usually call [Builder.width] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun width(width: JsonField<Double>) = apply { this.width = width }

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
         * Returns an immutable instance of [ResponsiveImageAttributes].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .src()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponsiveImageAttributes =
            ResponsiveImageAttributes(
                checkRequired("src", src),
                sizes,
                srcSet,
                width,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponsiveImageAttributes = apply {
        if (validated) {
            return@apply
        }

        src()
        sizes()
        srcSet()
        width()
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
        (if (src.asKnown().isPresent) 1 else 0) +
            (if (sizes.asKnown().isPresent) 1 else 0) +
            (if (srcSet.asKnown().isPresent) 1 else 0) +
            (if (width.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponsiveImageAttributes &&
            src == other.src &&
            sizes == other.sizes &&
            srcSet == other.srcSet &&
            width == other.width &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(src, sizes, srcSet, width, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponsiveImageAttributes{src=$src, sizes=$sizes, srcSet=$srcSet, width=$width, additionalProperties=$additionalProperties}"
}
