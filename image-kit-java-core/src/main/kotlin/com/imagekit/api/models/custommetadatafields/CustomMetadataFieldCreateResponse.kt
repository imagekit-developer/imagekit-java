// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.custommetadatafields

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
import com.imagekit.api.core.checkKnown
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Object containing details of a custom metadata field. */
class CustomMetadataFieldCreateResponse
private constructor(
    private val id: JsonField<String>,
    private val label: JsonField<String>,
    private val name: JsonField<String>,
    private val schema: JsonField<Schema>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("label") @ExcludeMissing label: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("schema") @ExcludeMissing schema: JsonField<Schema> = JsonMissing.of(),
    ) : this(id, label, name, schema, mutableMapOf())

    /**
     * Unique identifier for the custom metadata field. Use this to update the field.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Human readable name of the custom metadata field. This name is displayed as form field label
     * to the users while setting field value on the asset in the media library UI.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun label(): String = label.getRequired("label")

    /**
     * API name of the custom metadata field. This becomes the key while setting `customMetadata`
     * (key-value object) for an asset using upload or update API.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * An object that describes the rules for the custom metadata field value.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun schema(): Schema = schema.getRequired("schema")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [label].
     *
     * Unlike [label], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [schema].
     *
     * Unlike [schema], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonField<Schema> = schema

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
         * [CustomMetadataFieldCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .label()
         * .name()
         * .schema()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CustomMetadataFieldCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var label: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var schema: JsonField<Schema>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(customMetadataFieldCreateResponse: CustomMetadataFieldCreateResponse) =
            apply {
                id = customMetadataFieldCreateResponse.id
                label = customMetadataFieldCreateResponse.label
                name = customMetadataFieldCreateResponse.name
                schema = customMetadataFieldCreateResponse.schema
                additionalProperties =
                    customMetadataFieldCreateResponse.additionalProperties.toMutableMap()
            }

        /** Unique identifier for the custom metadata field. Use this to update the field. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * Human readable name of the custom metadata field. This name is displayed as form field
         * label to the users while setting field value on the asset in the media library UI.
         */
        fun label(label: String) = label(JsonField.of(label))

        /**
         * Sets [Builder.label] to an arbitrary JSON value.
         *
         * You should usually call [Builder.label] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun label(label: JsonField<String>) = apply { this.label = label }

        /**
         * API name of the custom metadata field. This becomes the key while setting
         * `customMetadata` (key-value object) for an asset using upload or update API.
         */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** An object that describes the rules for the custom metadata field value. */
        fun schema(schema: Schema) = schema(JsonField.of(schema))

        /**
         * Sets [Builder.schema] to an arbitrary JSON value.
         *
         * You should usually call [Builder.schema] with a well-typed [Schema] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun schema(schema: JsonField<Schema>) = apply { this.schema = schema }

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
         * Returns an immutable instance of [CustomMetadataFieldCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .label()
         * .name()
         * .schema()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CustomMetadataFieldCreateResponse =
            CustomMetadataFieldCreateResponse(
                checkRequired("id", id),
                checkRequired("label", label),
                checkRequired("name", name),
                checkRequired("schema", schema),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CustomMetadataFieldCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        label()
        name()
        schema().validate()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (label.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (schema.asKnown().getOrNull()?.validity() ?: 0)

    /** An object that describes the rules for the custom metadata field value. */
    class Schema
    private constructor(
        private val type: JsonField<Type>,
        private val defaultValue: JsonField<DefaultValue>,
        private val isValueRequired: JsonField<Boolean>,
        private val maxLength: JsonField<Double>,
        private val maxValue: JsonField<MaxValue>,
        private val minLength: JsonField<Double>,
        private val minValue: JsonField<MinValue>,
        private val selectOptions: JsonField<List<SelectOption>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("defaultValue")
            @ExcludeMissing
            defaultValue: JsonField<DefaultValue> = JsonMissing.of(),
            @JsonProperty("isValueRequired")
            @ExcludeMissing
            isValueRequired: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("maxLength")
            @ExcludeMissing
            maxLength: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("maxValue")
            @ExcludeMissing
            maxValue: JsonField<MaxValue> = JsonMissing.of(),
            @JsonProperty("minLength")
            @ExcludeMissing
            minLength: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("minValue")
            @ExcludeMissing
            minValue: JsonField<MinValue> = JsonMissing.of(),
            @JsonProperty("selectOptions")
            @ExcludeMissing
            selectOptions: JsonField<List<SelectOption>> = JsonMissing.of(),
        ) : this(
            type,
            defaultValue,
            isValueRequired,
            maxLength,
            maxValue,
            minLength,
            minValue,
            selectOptions,
            mutableMapOf(),
        )

        /**
         * Type of the custom metadata field.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * The default value for this custom metadata field. Date type of default value depends on
         * the field type.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun defaultValue(): Optional<DefaultValue> = defaultValue.getOptional("defaultValue")

        /**
         * Specifies if the this custom metadata field is required or not.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun isValueRequired(): Optional<Boolean> = isValueRequired.getOptional("isValueRequired")

        /**
         * Maximum length of string. Only set if `type` is set to `Text` or `Textarea`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun maxLength(): Optional<Double> = maxLength.getOptional("maxLength")

        /**
         * Maximum value of the field. Only set if field type is `Date` or `Number`. For `Date` type
         * field, the value will be in ISO8601 string format. For `Number` type field, it will be a
         * numeric value.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun maxValue(): Optional<MaxValue> = maxValue.getOptional("maxValue")

        /**
         * Minimum length of string. Only set if `type` is set to `Text` or `Textarea`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun minLength(): Optional<Double> = minLength.getOptional("minLength")

        /**
         * Minimum value of the field. Only set if field type is `Date` or `Number`. For `Date` type
         * field, the value will be in ISO8601 string format. For `Number` type field, it will be a
         * numeric value.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun minValue(): Optional<MinValue> = minValue.getOptional("minValue")

        /**
         * An array of allowed values when field type is `SingleSelect` or `MultiSelect`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun selectOptions(): Optional<List<SelectOption>> =
            selectOptions.getOptional("selectOptions")

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [defaultValue].
         *
         * Unlike [defaultValue], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("defaultValue")
        @ExcludeMissing
        fun _defaultValue(): JsonField<DefaultValue> = defaultValue

        /**
         * Returns the raw JSON value of [isValueRequired].
         *
         * Unlike [isValueRequired], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isValueRequired")
        @ExcludeMissing
        fun _isValueRequired(): JsonField<Boolean> = isValueRequired

        /**
         * Returns the raw JSON value of [maxLength].
         *
         * Unlike [maxLength], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("maxLength") @ExcludeMissing fun _maxLength(): JsonField<Double> = maxLength

        /**
         * Returns the raw JSON value of [maxValue].
         *
         * Unlike [maxValue], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("maxValue") @ExcludeMissing fun _maxValue(): JsonField<MaxValue> = maxValue

        /**
         * Returns the raw JSON value of [minLength].
         *
         * Unlike [minLength], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minLength") @ExcludeMissing fun _minLength(): JsonField<Double> = minLength

        /**
         * Returns the raw JSON value of [minValue].
         *
         * Unlike [minValue], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minValue") @ExcludeMissing fun _minValue(): JsonField<MinValue> = minValue

        /**
         * Returns the raw JSON value of [selectOptions].
         *
         * Unlike [selectOptions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("selectOptions")
        @ExcludeMissing
        fun _selectOptions(): JsonField<List<SelectOption>> = selectOptions

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
             * Returns a mutable builder for constructing an instance of [Schema].
             *
             * The following fields are required:
             * ```java
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Schema]. */
        class Builder internal constructor() {

            private var type: JsonField<Type>? = null
            private var defaultValue: JsonField<DefaultValue> = JsonMissing.of()
            private var isValueRequired: JsonField<Boolean> = JsonMissing.of()
            private var maxLength: JsonField<Double> = JsonMissing.of()
            private var maxValue: JsonField<MaxValue> = JsonMissing.of()
            private var minLength: JsonField<Double> = JsonMissing.of()
            private var minValue: JsonField<MinValue> = JsonMissing.of()
            private var selectOptions: JsonField<MutableList<SelectOption>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(schema: Schema) = apply {
                type = schema.type
                defaultValue = schema.defaultValue
                isValueRequired = schema.isValueRequired
                maxLength = schema.maxLength
                maxValue = schema.maxValue
                minLength = schema.minLength
                minValue = schema.minValue
                selectOptions = schema.selectOptions.map { it.toMutableList() }
                additionalProperties = schema.additionalProperties.toMutableMap()
            }

            /** Type of the custom metadata field. */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            /**
             * The default value for this custom metadata field. Date type of default value depends
             * on the field type.
             */
            fun defaultValue(defaultValue: DefaultValue) = defaultValue(JsonField.of(defaultValue))

            /**
             * Sets [Builder.defaultValue] to an arbitrary JSON value.
             *
             * You should usually call [Builder.defaultValue] with a well-typed [DefaultValue] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun defaultValue(defaultValue: JsonField<DefaultValue>) = apply {
                this.defaultValue = defaultValue
            }

            /**
             * Alias for calling [defaultValue] with `DefaultValue.ofUnionMember0(unionMember0)`.
             */
            fun defaultValue(unionMember0: DefaultValue.UnionMember0) =
                defaultValue(DefaultValue.ofUnionMember0(unionMember0))

            /**
             * Alias for calling [defaultValue] with
             * `DefaultValue.ofJsonScalarArray(jsonScalarArray)`.
             */
            fun defaultValueOfJsonScalarArray(
                jsonScalarArray: List<DefaultValue.UnnamedSchemaWithArrayParent0>
            ) = defaultValue(DefaultValue.ofJsonScalarArray(jsonScalarArray))

            /** Specifies if the this custom metadata field is required or not. */
            fun isValueRequired(isValueRequired: Boolean) =
                isValueRequired(JsonField.of(isValueRequired))

            /**
             * Sets [Builder.isValueRequired] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isValueRequired] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isValueRequired(isValueRequired: JsonField<Boolean>) = apply {
                this.isValueRequired = isValueRequired
            }

            /** Maximum length of string. Only set if `type` is set to `Text` or `Textarea`. */
            fun maxLength(maxLength: Double) = maxLength(JsonField.of(maxLength))

            /**
             * Sets [Builder.maxLength] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxLength] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxLength(maxLength: JsonField<Double>) = apply { this.maxLength = maxLength }

            /**
             * Maximum value of the field. Only set if field type is `Date` or `Number`. For `Date`
             * type field, the value will be in ISO8601 string format. For `Number` type field, it
             * will be a numeric value.
             */
            fun maxValue(maxValue: MaxValue) = maxValue(JsonField.of(maxValue))

            /**
             * Sets [Builder.maxValue] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxValue] with a well-typed [MaxValue] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxValue(maxValue: JsonField<MaxValue>) = apply { this.maxValue = maxValue }

            /** Alias for calling [maxValue] with `MaxValue.ofString(string)`. */
            fun maxValue(string: String) = maxValue(MaxValue.ofString(string))

            /** Alias for calling [maxValue] with `MaxValue.ofNumber(number)`. */
            fun maxValue(number: Double) = maxValue(MaxValue.ofNumber(number))

            /** Minimum length of string. Only set if `type` is set to `Text` or `Textarea`. */
            fun minLength(minLength: Double) = minLength(JsonField.of(minLength))

            /**
             * Sets [Builder.minLength] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minLength] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minLength(minLength: JsonField<Double>) = apply { this.minLength = minLength }

            /**
             * Minimum value of the field. Only set if field type is `Date` or `Number`. For `Date`
             * type field, the value will be in ISO8601 string format. For `Number` type field, it
             * will be a numeric value.
             */
            fun minValue(minValue: MinValue) = minValue(JsonField.of(minValue))

            /**
             * Sets [Builder.minValue] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minValue] with a well-typed [MinValue] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minValue(minValue: JsonField<MinValue>) = apply { this.minValue = minValue }

            /** Alias for calling [minValue] with `MinValue.ofString(string)`. */
            fun minValue(string: String) = minValue(MinValue.ofString(string))

            /** Alias for calling [minValue] with `MinValue.ofNumber(number)`. */
            fun minValue(number: Double) = minValue(MinValue.ofNumber(number))

            /** An array of allowed values when field type is `SingleSelect` or `MultiSelect`. */
            fun selectOptions(selectOptions: List<SelectOption>) =
                selectOptions(JsonField.of(selectOptions))

            /**
             * Sets [Builder.selectOptions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.selectOptions] with a well-typed
             * `List<SelectOption>` value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun selectOptions(selectOptions: JsonField<List<SelectOption>>) = apply {
                this.selectOptions = selectOptions.map { it.toMutableList() }
            }

            /**
             * Adds a single [SelectOption] to [selectOptions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSelectOption(selectOption: SelectOption) = apply {
                selectOptions =
                    (selectOptions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("selectOptions", it).add(selectOption)
                    }
            }

            /** Alias for calling [addSelectOption] with `SelectOption.ofString(string)`. */
            fun addSelectOption(string: String) = addSelectOption(SelectOption.ofString(string))

            /** Alias for calling [addSelectOption] with `SelectOption.ofNumber(number)`. */
            fun addSelectOption(number: Double) = addSelectOption(SelectOption.ofNumber(number))

            /** Alias for calling [addSelectOption] with `SelectOption.ofBool(bool)`. */
            fun addSelectOption(bool: Boolean) = addSelectOption(SelectOption.ofBool(bool))

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
             * Returns an immutable instance of [Schema].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Schema =
                Schema(
                    checkRequired("type", type),
                    defaultValue,
                    isValueRequired,
                    maxLength,
                    maxValue,
                    minLength,
                    minValue,
                    (selectOptions ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Schema = apply {
            if (validated) {
                return@apply
            }

            type().validate()
            defaultValue().ifPresent { it.validate() }
            isValueRequired()
            maxLength()
            maxValue().ifPresent { it.validate() }
            minLength()
            minValue().ifPresent { it.validate() }
            selectOptions().ifPresent { it.forEach { it.validate() } }
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
            (type.asKnown().getOrNull()?.validity() ?: 0) +
                (defaultValue.asKnown().getOrNull()?.validity() ?: 0) +
                (if (isValueRequired.asKnown().isPresent) 1 else 0) +
                (if (maxLength.asKnown().isPresent) 1 else 0) +
                (maxValue.asKnown().getOrNull()?.validity() ?: 0) +
                (if (minLength.asKnown().isPresent) 1 else 0) +
                (minValue.asKnown().getOrNull()?.validity() ?: 0) +
                (selectOptions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /** Type of the custom metadata field. */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val TEXT = of("Text")

                @JvmField val TEXTAREA = of("Textarea")

                @JvmField val NUMBER = of("Number")

                @JvmField val DATE = of("Date")

                @JvmField val BOOLEAN = of("Boolean")

                @JvmField val SINGLE_SELECT = of("SingleSelect")

                @JvmField val MULTI_SELECT = of("MultiSelect")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                TEXT,
                TEXTAREA,
                NUMBER,
                DATE,
                BOOLEAN,
                SINGLE_SELECT,
                MULTI_SELECT,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                TEXTAREA,
                NUMBER,
                DATE,
                BOOLEAN,
                SINGLE_SELECT,
                MULTI_SELECT,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    TEXT -> Value.TEXT
                    TEXTAREA -> Value.TEXTAREA
                    NUMBER -> Value.NUMBER
                    DATE -> Value.DATE
                    BOOLEAN -> Value.BOOLEAN
                    SINGLE_SELECT -> Value.SINGLE_SELECT
                    MULTI_SELECT -> Value.MULTI_SELECT
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
                    TEXT -> Known.TEXT
                    TEXTAREA -> Known.TEXTAREA
                    NUMBER -> Known.NUMBER
                    DATE -> Known.DATE
                    BOOLEAN -> Known.BOOLEAN
                    SINGLE_SELECT -> Known.SINGLE_SELECT
                    MULTI_SELECT -> Known.MULTI_SELECT
                    else -> throw ImageKitInvalidDataException("Unknown Type: $value")
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

            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * The default value for this custom metadata field. Date type of default value depends on
         * the field type.
         */
        @JsonDeserialize(using = DefaultValue.Deserializer::class)
        @JsonSerialize(using = DefaultValue.Serializer::class)
        class DefaultValue
        private constructor(
            private val unionMember0: UnionMember0? = null,
            private val jsonScalarArray: List<UnnamedSchemaWithArrayParent0>? = null,
            private val _json: JsonValue? = null,
        ) {

            /** Primitive JSON scalar. */
            fun unionMember0(): Optional<UnionMember0> = Optional.ofNullable(unionMember0)

            fun jsonScalarArray(): Optional<List<UnnamedSchemaWithArrayParent0>> =
                Optional.ofNullable(jsonScalarArray)

            fun isUnionMember0(): Boolean = unionMember0 != null

            fun isJsonScalarArray(): Boolean = jsonScalarArray != null

            /** Primitive JSON scalar. */
            fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

            fun asJsonScalarArray(): List<UnnamedSchemaWithArrayParent0> =
                jsonScalarArray.getOrThrow("jsonScalarArray")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                    jsonScalarArray != null -> visitor.visitJsonScalarArray(jsonScalarArray)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): DefaultValue = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitUnionMember0(unionMember0: UnionMember0) {
                            unionMember0.validate()
                        }

                        override fun visitJsonScalarArray(
                            jsonScalarArray: List<UnnamedSchemaWithArrayParent0>
                        ) {
                            jsonScalarArray.forEach { it.validate() }
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
                        override fun visitUnionMember0(unionMember0: UnionMember0) =
                            unionMember0.validity()

                        override fun visitJsonScalarArray(
                            jsonScalarArray: List<UnnamedSchemaWithArrayParent0>
                        ) = jsonScalarArray.sumOf { it.validity().toInt() }

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is DefaultValue &&
                    unionMember0 == other.unionMember0 &&
                    jsonScalarArray == other.jsonScalarArray
            }

            override fun hashCode(): Int = Objects.hash(unionMember0, jsonScalarArray)

            override fun toString(): String =
                when {
                    unionMember0 != null -> "DefaultValue{unionMember0=$unionMember0}"
                    jsonScalarArray != null -> "DefaultValue{jsonScalarArray=$jsonScalarArray}"
                    _json != null -> "DefaultValue{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid DefaultValue")
                }

            companion object {

                /** Primitive JSON scalar. */
                @JvmStatic
                fun ofUnionMember0(unionMember0: UnionMember0) =
                    DefaultValue(unionMember0 = unionMember0)

                @JvmStatic
                fun ofJsonScalarArray(jsonScalarArray: List<UnnamedSchemaWithArrayParent0>) =
                    DefaultValue(jsonScalarArray = jsonScalarArray.toImmutable())
            }

            /**
             * An interface that defines how to map each variant of [DefaultValue] to a value of
             * type [T].
             */
            interface Visitor<out T> {

                /** Primitive JSON scalar. */
                fun visitUnionMember0(unionMember0: UnionMember0): T

                fun visitJsonScalarArray(jsonScalarArray: List<UnnamedSchemaWithArrayParent0>): T

                /**
                 * Maps an unknown variant of [DefaultValue] to a value of type [T].
                 *
                 * An instance of [DefaultValue] can contain an unknown variant if it was
                 * deserialized from data that doesn't match any known variant. For example, if the
                 * SDK is on an older version than the API, then the API may respond with new
                 * variants that the SDK is unaware of.
                 *
                 * @throws ImageKitInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw ImageKitInvalidDataException("Unknown DefaultValue: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<DefaultValue>(DefaultValue::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): DefaultValue {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                                    DefaultValue(unionMember0 = it, _json = json)
                                },
                                tryDeserialize(
                                        node,
                                        jacksonTypeRef<List<UnnamedSchemaWithArrayParent0>>(),
                                    )
                                    ?.let { DefaultValue(jsonScalarArray = it, _json = json) },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
                        0 -> DefaultValue(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<DefaultValue>(DefaultValue::class) {

                override fun serialize(
                    value: DefaultValue,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                        value.jsonScalarArray != null ->
                            generator.writeObject(value.jsonScalarArray)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid DefaultValue")
                    }
                }
            }

            /** Primitive JSON scalar. */
            @JsonDeserialize(using = UnionMember0.Deserializer::class)
            @JsonSerialize(using = UnionMember0.Serializer::class)
            class UnionMember0
            private constructor(
                private val jsonScalar: String? = null,
                private val jsonScalar: Double? = null,
                private val jsonScalar: Boolean? = null,
                private val _json: JsonValue? = null,
            ) {

                /** Primitive JSON scalar. */
                fun jsonScalar(): Optional<String> = Optional.ofNullable(jsonScalar)

                /** Primitive JSON scalar. */
                fun jsonScalar(): Optional<Double> = Optional.ofNullable(jsonScalar)

                /** Primitive JSON scalar. */
                fun jsonScalar(): Optional<Boolean> = Optional.ofNullable(jsonScalar)

                fun isJsonScalar(): Boolean = jsonScalar != null

                fun isJsonScalar(): Boolean = jsonScalar != null

                fun isJsonScalar(): Boolean = jsonScalar != null

                /** Primitive JSON scalar. */
                fun asJsonScalar(): String = jsonScalar.getOrThrow("jsonScalar")

                /** Primitive JSON scalar. */
                fun asJsonScalar(): Double = jsonScalar.getOrThrow("jsonScalar")

                /** Primitive JSON scalar. */
                fun asJsonScalar(): Boolean = jsonScalar.getOrThrow("jsonScalar")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        jsonScalar != null -> visitor.visitJsonScalar(jsonScalar)
                        jsonScalar != null -> visitor.visitJsonScalar(jsonScalar)
                        jsonScalar != null -> visitor.visitJsonScalar(jsonScalar)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): UnionMember0 = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitJsonScalar(jsonScalar: String) {}

                            override fun visitJsonScalar(jsonScalar: Double) {}

                            override fun visitJsonScalar(jsonScalar: Boolean) {}
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
                            override fun visitJsonScalar(jsonScalar: String) = 1

                            override fun visitJsonScalar(jsonScalar: Double) = 1

                            override fun visitJsonScalar(jsonScalar: Boolean) = 1

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember0 &&
                        jsonScalar == other.jsonScalar &&
                        jsonScalar == other.jsonScalar &&
                        jsonScalar == other.jsonScalar
                }

                override fun hashCode(): Int = Objects.hash(jsonScalar, jsonScalar, jsonScalar)

                override fun toString(): String =
                    when {
                        jsonScalar != null -> "UnionMember0{jsonScalar=$jsonScalar}"
                        jsonScalar != null -> "UnionMember0{jsonScalar=$jsonScalar}"
                        jsonScalar != null -> "UnionMember0{jsonScalar=$jsonScalar}"
                        _json != null -> "UnionMember0{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid UnionMember0")
                    }

                companion object {

                    /** Primitive JSON scalar. */
                    @JvmStatic
                    fun ofJsonScalar(jsonScalar: String) = UnionMember0(jsonScalar = jsonScalar)

                    /** Primitive JSON scalar. */
                    @JvmStatic
                    fun ofJsonScalar(jsonScalar: Double) = UnionMember0(jsonScalar = jsonScalar)

                    /** Primitive JSON scalar. */
                    @JvmStatic
                    fun ofJsonScalar(jsonScalar: Boolean) = UnionMember0(jsonScalar = jsonScalar)
                }

                /**
                 * An interface that defines how to map each variant of [UnionMember0] to a value of
                 * type [T].
                 */
                interface Visitor<out T> {

                    /** Primitive JSON scalar. */
                    fun visitJsonScalar(jsonScalar: String): T

                    /** Primitive JSON scalar. */
                    fun visitJsonScalar(jsonScalar: Double): T

                    /** Primitive JSON scalar. */
                    fun visitJsonScalar(jsonScalar: Boolean): T

                    /**
                     * Maps an unknown variant of [UnionMember0] to a value of type [T].
                     *
                     * An instance of [UnionMember0] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws ImageKitInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw ImageKitInvalidDataException("Unknown UnionMember0: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<UnionMember0>(UnionMember0::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): UnionMember0 {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                        UnionMember0(jsonScalar = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                        UnionMember0(jsonScalar = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                        UnionMember0(jsonScalar = it, _json = json)
                                    },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // object).
                            0 -> UnionMember0(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer : BaseSerializer<UnionMember0>(UnionMember0::class) {

                    override fun serialize(
                        value: UnionMember0,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.jsonScalar != null -> generator.writeObject(value.jsonScalar)
                            value.jsonScalar != null -> generator.writeObject(value.jsonScalar)
                            value.jsonScalar != null -> generator.writeObject(value.jsonScalar)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid UnionMember0")
                        }
                    }
                }
            }

            /** Primitive JSON scalar. */
            @JsonDeserialize(using = UnnamedSchemaWithArrayParent0.Deserializer::class)
            @JsonSerialize(using = UnnamedSchemaWithArrayParent0.Serializer::class)
            class UnnamedSchemaWithArrayParent0
            private constructor(
                private val jsonScalar: String? = null,
                private val jsonScalar: Double? = null,
                private val jsonScalar: Boolean? = null,
                private val _json: JsonValue? = null,
            ) {

                /** Primitive JSON scalar. */
                fun jsonScalar(): Optional<String> = Optional.ofNullable(jsonScalar)

                /** Primitive JSON scalar. */
                fun jsonScalar(): Optional<Double> = Optional.ofNullable(jsonScalar)

                /** Primitive JSON scalar. */
                fun jsonScalar(): Optional<Boolean> = Optional.ofNullable(jsonScalar)

                fun isJsonScalar(): Boolean = jsonScalar != null

                fun isJsonScalar(): Boolean = jsonScalar != null

                fun isJsonScalar(): Boolean = jsonScalar != null

                /** Primitive JSON scalar. */
                fun asJsonScalar(): String = jsonScalar.getOrThrow("jsonScalar")

                /** Primitive JSON scalar. */
                fun asJsonScalar(): Double = jsonScalar.getOrThrow("jsonScalar")

                /** Primitive JSON scalar. */
                fun asJsonScalar(): Boolean = jsonScalar.getOrThrow("jsonScalar")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        jsonScalar != null -> visitor.visitJsonScalar(jsonScalar)
                        jsonScalar != null -> visitor.visitJsonScalar(jsonScalar)
                        jsonScalar != null -> visitor.visitJsonScalar(jsonScalar)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): UnnamedSchemaWithArrayParent0 = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitJsonScalar(jsonScalar: String) {}

                            override fun visitJsonScalar(jsonScalar: Double) {}

                            override fun visitJsonScalar(jsonScalar: Boolean) {}
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
                            override fun visitJsonScalar(jsonScalar: String) = 1

                            override fun visitJsonScalar(jsonScalar: Double) = 1

                            override fun visitJsonScalar(jsonScalar: Boolean) = 1

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnnamedSchemaWithArrayParent0 &&
                        jsonScalar == other.jsonScalar &&
                        jsonScalar == other.jsonScalar &&
                        jsonScalar == other.jsonScalar
                }

                override fun hashCode(): Int = Objects.hash(jsonScalar, jsonScalar, jsonScalar)

                override fun toString(): String =
                    when {
                        jsonScalar != null ->
                            "UnnamedSchemaWithArrayParent0{jsonScalar=$jsonScalar}"
                        jsonScalar != null ->
                            "UnnamedSchemaWithArrayParent0{jsonScalar=$jsonScalar}"
                        jsonScalar != null ->
                            "UnnamedSchemaWithArrayParent0{jsonScalar=$jsonScalar}"
                        _json != null -> "UnnamedSchemaWithArrayParent0{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent0")
                    }

                companion object {

                    /** Primitive JSON scalar. */
                    @JvmStatic
                    fun ofJsonScalar(jsonScalar: String) =
                        UnnamedSchemaWithArrayParent0(jsonScalar = jsonScalar)

                    /** Primitive JSON scalar. */
                    @JvmStatic
                    fun ofJsonScalar(jsonScalar: Double) =
                        UnnamedSchemaWithArrayParent0(jsonScalar = jsonScalar)

                    /** Primitive JSON scalar. */
                    @JvmStatic
                    fun ofJsonScalar(jsonScalar: Boolean) =
                        UnnamedSchemaWithArrayParent0(jsonScalar = jsonScalar)
                }

                /**
                 * An interface that defines how to map each variant of
                 * [UnnamedSchemaWithArrayParent0] to a value of type [T].
                 */
                interface Visitor<out T> {

                    /** Primitive JSON scalar. */
                    fun visitJsonScalar(jsonScalar: String): T

                    /** Primitive JSON scalar. */
                    fun visitJsonScalar(jsonScalar: Double): T

                    /** Primitive JSON scalar. */
                    fun visitJsonScalar(jsonScalar: Boolean): T

                    /**
                     * Maps an unknown variant of [UnnamedSchemaWithArrayParent0] to a value of type
                     * [T].
                     *
                     * An instance of [UnnamedSchemaWithArrayParent0] can contain an unknown variant
                     * if it was deserialized from data that doesn't match any known variant. For
                     * example, if the SDK is on an older version than the API, then the API may
                     * respond with new variants that the SDK is unaware of.
                     *
                     * @throws ImageKitInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw ImageKitInvalidDataException(
                            "Unknown UnnamedSchemaWithArrayParent0: $json"
                        )
                    }
                }

                internal class Deserializer :
                    BaseDeserializer<UnnamedSchemaWithArrayParent0>(
                        UnnamedSchemaWithArrayParent0::class
                    ) {

                    override fun ObjectCodec.deserialize(
                        node: JsonNode
                    ): UnnamedSchemaWithArrayParent0 {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                        UnnamedSchemaWithArrayParent0(jsonScalar = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                        UnnamedSchemaWithArrayParent0(jsonScalar = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                        UnnamedSchemaWithArrayParent0(jsonScalar = it, _json = json)
                                    },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // object).
                            0 -> UnnamedSchemaWithArrayParent0(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer :
                    BaseSerializer<UnnamedSchemaWithArrayParent0>(
                        UnnamedSchemaWithArrayParent0::class
                    ) {

                    override fun serialize(
                        value: UnnamedSchemaWithArrayParent0,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.jsonScalar != null -> generator.writeObject(value.jsonScalar)
                            value.jsonScalar != null -> generator.writeObject(value.jsonScalar)
                            value.jsonScalar != null -> generator.writeObject(value.jsonScalar)
                            value._json != null -> generator.writeObject(value._json)
                            else ->
                                throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent0")
                        }
                    }
                }
            }
        }

        /**
         * Maximum value of the field. Only set if field type is `Date` or `Number`. For `Date` type
         * field, the value will be in ISO8601 string format. For `Number` type field, it will be a
         * numeric value.
         */
        @JsonDeserialize(using = MaxValue.Deserializer::class)
        @JsonSerialize(using = MaxValue.Serializer::class)
        class MaxValue
        private constructor(
            private val string: String? = null,
            private val number: Double? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun number(): Optional<Double> = Optional.ofNullable(number)

            fun isString(): Boolean = string != null

            fun isNumber(): Boolean = number != null

            fun asString(): String = string.getOrThrow("string")

            fun asNumber(): Double = number.getOrThrow("number")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    number != null -> visitor.visitNumber(number)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): MaxValue = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitNumber(number: Double) {}
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
                        override fun visitString(string: String) = 1

                        override fun visitNumber(number: Double) = 1

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is MaxValue && string == other.string && number == other.number
            }

            override fun hashCode(): Int = Objects.hash(string, number)

            override fun toString(): String =
                when {
                    string != null -> "MaxValue{string=$string}"
                    number != null -> "MaxValue{number=$number}"
                    _json != null -> "MaxValue{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid MaxValue")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = MaxValue(string = string)

                @JvmStatic fun ofNumber(number: Double) = MaxValue(number = number)
            }

            /**
             * An interface that defines how to map each variant of [MaxValue] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitNumber(number: Double): T

                /**
                 * Maps an unknown variant of [MaxValue] to a value of type [T].
                 *
                 * An instance of [MaxValue] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws ImageKitInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw ImageKitInvalidDataException("Unknown MaxValue: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<MaxValue>(MaxValue::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): MaxValue {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    MaxValue(string = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                    MaxValue(number = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
                        0 -> MaxValue(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<MaxValue>(MaxValue::class) {

                override fun serialize(
                    value: MaxValue,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.number != null -> generator.writeObject(value.number)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid MaxValue")
                    }
                }
            }
        }

        /**
         * Minimum value of the field. Only set if field type is `Date` or `Number`. For `Date` type
         * field, the value will be in ISO8601 string format. For `Number` type field, it will be a
         * numeric value.
         */
        @JsonDeserialize(using = MinValue.Deserializer::class)
        @JsonSerialize(using = MinValue.Serializer::class)
        class MinValue
        private constructor(
            private val string: String? = null,
            private val number: Double? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun number(): Optional<Double> = Optional.ofNullable(number)

            fun isString(): Boolean = string != null

            fun isNumber(): Boolean = number != null

            fun asString(): String = string.getOrThrow("string")

            fun asNumber(): Double = number.getOrThrow("number")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    number != null -> visitor.visitNumber(number)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): MinValue = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitNumber(number: Double) {}
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
                        override fun visitString(string: String) = 1

                        override fun visitNumber(number: Double) = 1

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is MinValue && string == other.string && number == other.number
            }

            override fun hashCode(): Int = Objects.hash(string, number)

            override fun toString(): String =
                when {
                    string != null -> "MinValue{string=$string}"
                    number != null -> "MinValue{number=$number}"
                    _json != null -> "MinValue{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid MinValue")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = MinValue(string = string)

                @JvmStatic fun ofNumber(number: Double) = MinValue(number = number)
            }

            /**
             * An interface that defines how to map each variant of [MinValue] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitNumber(number: Double): T

                /**
                 * Maps an unknown variant of [MinValue] to a value of type [T].
                 *
                 * An instance of [MinValue] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws ImageKitInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw ImageKitInvalidDataException("Unknown MinValue: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<MinValue>(MinValue::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): MinValue {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    MinValue(string = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                    MinValue(number = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
                        0 -> MinValue(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<MinValue>(MinValue::class) {

                override fun serialize(
                    value: MinValue,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.number != null -> generator.writeObject(value.number)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid MinValue")
                    }
                }
            }
        }

        @JsonDeserialize(using = SelectOption.Deserializer::class)
        @JsonSerialize(using = SelectOption.Serializer::class)
        class SelectOption
        private constructor(
            private val string: String? = null,
            private val number: Double? = null,
            private val bool: Boolean? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun number(): Optional<Double> = Optional.ofNullable(number)

            fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

            fun isString(): Boolean = string != null

            fun isNumber(): Boolean = number != null

            fun isBool(): Boolean = bool != null

            fun asString(): String = string.getOrThrow("string")

            fun asNumber(): Double = number.getOrThrow("number")

            fun asBool(): Boolean = bool.getOrThrow("bool")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    number != null -> visitor.visitNumber(number)
                    bool != null -> visitor.visitBool(bool)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): SelectOption = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitNumber(number: Double) {}

                        override fun visitBool(bool: Boolean) {}
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
                        override fun visitString(string: String) = 1

                        override fun visitNumber(number: Double) = 1

                        override fun visitBool(bool: Boolean) = 1

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is SelectOption &&
                    string == other.string &&
                    number == other.number &&
                    bool == other.bool
            }

            override fun hashCode(): Int = Objects.hash(string, number, bool)

            override fun toString(): String =
                when {
                    string != null -> "SelectOption{string=$string}"
                    number != null -> "SelectOption{number=$number}"
                    bool != null -> "SelectOption{bool=$bool}"
                    _json != null -> "SelectOption{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid SelectOption")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = SelectOption(string = string)

                @JvmStatic fun ofNumber(number: Double) = SelectOption(number = number)

                @JvmStatic fun ofBool(bool: Boolean) = SelectOption(bool = bool)
            }

            /**
             * An interface that defines how to map each variant of [SelectOption] to a value of
             * type [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitNumber(number: Double): T

                fun visitBool(bool: Boolean): T

                /**
                 * Maps an unknown variant of [SelectOption] to a value of type [T].
                 *
                 * An instance of [SelectOption] can contain an unknown variant if it was
                 * deserialized from data that doesn't match any known variant. For example, if the
                 * SDK is on an older version than the API, then the API may respond with new
                 * variants that the SDK is unaware of.
                 *
                 * @throws ImageKitInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw ImageKitInvalidDataException("Unknown SelectOption: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<SelectOption>(SelectOption::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): SelectOption {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    SelectOption(string = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                    SelectOption(number = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                    SelectOption(bool = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
                        0 -> SelectOption(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<SelectOption>(SelectOption::class) {

                override fun serialize(
                    value: SelectOption,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.number != null -> generator.writeObject(value.number)
                        value.bool != null -> generator.writeObject(value.bool)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid SelectOption")
                    }
                }
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Schema &&
                type == other.type &&
                defaultValue == other.defaultValue &&
                isValueRequired == other.isValueRequired &&
                maxLength == other.maxLength &&
                maxValue == other.maxValue &&
                minLength == other.minLength &&
                minValue == other.minValue &&
                selectOptions == other.selectOptions &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                type,
                defaultValue,
                isValueRequired,
                maxLength,
                maxValue,
                minLength,
                minValue,
                selectOptions,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Schema{type=$type, defaultValue=$defaultValue, isValueRequired=$isValueRequired, maxLength=$maxLength, maxValue=$maxValue, minLength=$minLength, minValue=$minValue, selectOptions=$selectOptions, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CustomMetadataFieldCreateResponse &&
            id == other.id &&
            label == other.label &&
            name == other.name &&
            schema == other.schema &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, label, name, schema, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CustomMetadataFieldCreateResponse{id=$id, label=$label, name=$name, schema=$schema, additionalProperties=$additionalProperties}"
}
