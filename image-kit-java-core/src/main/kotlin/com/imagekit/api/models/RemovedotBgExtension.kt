// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.imagekit.api.core.Enum
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.checkRequired
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class RemovedotBgExtension
private constructor(
    private val name: JsonField<Name>,
    private val options: JsonField<Options>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("name") @ExcludeMissing name: JsonField<Name> = JsonMissing.of(),
        @JsonProperty("options") @ExcludeMissing options: JsonField<Options> = JsonMissing.of(),
    ) : this(name, options, mutableMapOf())

    /**
     * Specifies the background removal extension.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): Name = name.getRequired("name")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun options(): Optional<Options> = options.getOptional("options")

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<Name> = name

    /**
     * Returns the raw JSON value of [options].
     *
     * Unlike [options], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("options") @ExcludeMissing fun _options(): JsonField<Options> = options

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
         * Returns a mutable builder for constructing an instance of [RemovedotBgExtension].
         *
         * The following fields are required:
         * ```java
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RemovedotBgExtension]. */
    class Builder internal constructor() {

        private var name: JsonField<Name>? = null
        private var options: JsonField<Options> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(removedotBgExtension: RemovedotBgExtension) = apply {
            name = removedotBgExtension.name
            options = removedotBgExtension.options
            additionalProperties = removedotBgExtension.additionalProperties.toMutableMap()
        }

        /** Specifies the background removal extension. */
        fun name(name: Name) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [Name] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<Name>) = apply { this.name = name }

        fun options(options: Options) = options(JsonField.of(options))

        /**
         * Sets [Builder.options] to an arbitrary JSON value.
         *
         * You should usually call [Builder.options] with a well-typed [Options] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun options(options: JsonField<Options>) = apply { this.options = options }

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
         * Returns an immutable instance of [RemovedotBgExtension].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RemovedotBgExtension =
            RemovedotBgExtension(
                checkRequired("name", name),
                options,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RemovedotBgExtension = apply {
        if (validated) {
            return@apply
        }

        name().validate()
        options().ifPresent { it.validate() }
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
        (name.asKnown().getOrNull()?.validity() ?: 0) +
            (options.asKnown().getOrNull()?.validity() ?: 0)

    /** Specifies the background removal extension. */
    class Name @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val REMOVE_BG = of("remove-bg")

            @JvmStatic fun of(value: String) = Name(JsonField.of(value))
        }

        /** An enum containing [Name]'s known values. */
        enum class Known {
            REMOVE_BG
        }

        /**
         * An enum containing [Name]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Name] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            REMOVE_BG,
            /** An enum member indicating that [Name] was instantiated with an unknown value. */
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
                REMOVE_BG -> Value.REMOVE_BG
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
                REMOVE_BG -> Known.REMOVE_BG
                else -> throw ImageKitInvalidDataException("Unknown Name: $value")
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

        fun validate(): Name = apply {
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

            return other is Name && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Options
    private constructor(
        private val addShadow: JsonField<Boolean>,
        private val bgColor: JsonField<String>,
        private val bgImageUrl: JsonField<String>,
        private val semitransparency: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("add_shadow")
            @ExcludeMissing
            addShadow: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("bg_color") @ExcludeMissing bgColor: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bg_image_url")
            @ExcludeMissing
            bgImageUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("semitransparency")
            @ExcludeMissing
            semitransparency: JsonField<Boolean> = JsonMissing.of(),
        ) : this(addShadow, bgColor, bgImageUrl, semitransparency, mutableMapOf())

        /**
         * Whether to add an artificial shadow to the result. Default is false. Note: Adding shadows
         * is currently only supported for car photos.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun addShadow(): Optional<Boolean> = addShadow.getOptional("add_shadow")

        /**
         * Specifies a solid color background using hex code (e.g., "81d4fa", "fff") or color name
         * (e.g., "green"). If this parameter is set, `bg_image_url` must be empty.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun bgColor(): Optional<String> = bgColor.getOptional("bg_color")

        /**
         * Sets a background image from a URL. If this parameter is set, `bg_color` must be empty.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun bgImageUrl(): Optional<String> = bgImageUrl.getOptional("bg_image_url")

        /**
         * Allows semi-transparent regions in the result. Default is true. Note: Semitransparency is
         * currently only supported for car windows.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun semitransparency(): Optional<Boolean> = semitransparency.getOptional("semitransparency")

        /**
         * Returns the raw JSON value of [addShadow].
         *
         * Unlike [addShadow], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("add_shadow") @ExcludeMissing fun _addShadow(): JsonField<Boolean> = addShadow

        /**
         * Returns the raw JSON value of [bgColor].
         *
         * Unlike [bgColor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bg_color") @ExcludeMissing fun _bgColor(): JsonField<String> = bgColor

        /**
         * Returns the raw JSON value of [bgImageUrl].
         *
         * Unlike [bgImageUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bg_image_url")
        @ExcludeMissing
        fun _bgImageUrl(): JsonField<String> = bgImageUrl

        /**
         * Returns the raw JSON value of [semitransparency].
         *
         * Unlike [semitransparency], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("semitransparency")
        @ExcludeMissing
        fun _semitransparency(): JsonField<Boolean> = semitransparency

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

            /** Returns a mutable builder for constructing an instance of [Options]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Options]. */
        class Builder internal constructor() {

            private var addShadow: JsonField<Boolean> = JsonMissing.of()
            private var bgColor: JsonField<String> = JsonMissing.of()
            private var bgImageUrl: JsonField<String> = JsonMissing.of()
            private var semitransparency: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(options: Options) = apply {
                addShadow = options.addShadow
                bgColor = options.bgColor
                bgImageUrl = options.bgImageUrl
                semitransparency = options.semitransparency
                additionalProperties = options.additionalProperties.toMutableMap()
            }

            /**
             * Whether to add an artificial shadow to the result. Default is false. Note: Adding
             * shadows is currently only supported for car photos.
             */
            fun addShadow(addShadow: Boolean) = addShadow(JsonField.of(addShadow))

            /**
             * Sets [Builder.addShadow] to an arbitrary JSON value.
             *
             * You should usually call [Builder.addShadow] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun addShadow(addShadow: JsonField<Boolean>) = apply { this.addShadow = addShadow }

            /**
             * Specifies a solid color background using hex code (e.g., "81d4fa", "fff") or color
             * name (e.g., "green"). If this parameter is set, `bg_image_url` must be empty.
             */
            fun bgColor(bgColor: String) = bgColor(JsonField.of(bgColor))

            /**
             * Sets [Builder.bgColor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bgColor] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bgColor(bgColor: JsonField<String>) = apply { this.bgColor = bgColor }

            /**
             * Sets a background image from a URL. If this parameter is set, `bg_color` must be
             * empty.
             */
            fun bgImageUrl(bgImageUrl: String) = bgImageUrl(JsonField.of(bgImageUrl))

            /**
             * Sets [Builder.bgImageUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bgImageUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bgImageUrl(bgImageUrl: JsonField<String>) = apply { this.bgImageUrl = bgImageUrl }

            /**
             * Allows semi-transparent regions in the result. Default is true. Note:
             * Semitransparency is currently only supported for car windows.
             */
            fun semitransparency(semitransparency: Boolean) =
                semitransparency(JsonField.of(semitransparency))

            /**
             * Sets [Builder.semitransparency] to an arbitrary JSON value.
             *
             * You should usually call [Builder.semitransparency] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun semitransparency(semitransparency: JsonField<Boolean>) = apply {
                this.semitransparency = semitransparency
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
             * Returns an immutable instance of [Options].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Options =
                Options(
                    addShadow,
                    bgColor,
                    bgImageUrl,
                    semitransparency,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Options = apply {
            if (validated) {
                return@apply
            }

            addShadow()
            bgColor()
            bgImageUrl()
            semitransparency()
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
            (if (addShadow.asKnown().isPresent) 1 else 0) +
                (if (bgColor.asKnown().isPresent) 1 else 0) +
                (if (bgImageUrl.asKnown().isPresent) 1 else 0) +
                (if (semitransparency.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Options &&
                addShadow == other.addShadow &&
                bgColor == other.bgColor &&
                bgImageUrl == other.bgImageUrl &&
                semitransparency == other.semitransparency &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(addShadow, bgColor, bgImageUrl, semitransparency, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Options{addShadow=$addShadow, bgColor=$bgColor, bgImageUrl=$bgImageUrl, semitransparency=$semitransparency, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RemovedotBgExtension &&
            name == other.name &&
            options == other.options &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(name, options, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RemovedotBgExtension{name=$name, options=$options, additionalProperties=$additionalProperties}"
}
