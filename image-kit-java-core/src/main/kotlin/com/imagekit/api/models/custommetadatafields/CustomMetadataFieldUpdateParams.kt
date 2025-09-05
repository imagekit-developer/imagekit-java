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
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.Params
import com.imagekit.api.core.allMaxBy
import com.imagekit.api.core.checkKnown
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.core.http.Headers
import com.imagekit.api.core.http.QueryParams
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** This API updates the label or schema of an existing custom metadata field. */
class CustomMetadataFieldUpdateParams
private constructor(
    private val id: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    /**
     * Human readable name of the custom metadata field. This should be unique across all non
     * deleted custom metadata fields. This name is displayed as form field label to the users while
     * setting field value on an asset in the media library UI. This parameter is required if
     * `schema` is not provided.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun label(): Optional<String> = body.label()

    /**
     * An object that describes the rules for the custom metadata key. This parameter is required if
     * `label` is not provided. Note: `type` cannot be updated and will be ignored if sent with the
     * `schema`. The schema will be validated as per the existing `type`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun schema(): Optional<Schema> = body.schema()

    /**
     * Returns the raw JSON value of [label].
     *
     * Unlike [label], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _label(): JsonField<String> = body._label()

    /**
     * Returns the raw JSON value of [schema].
     *
     * Unlike [schema], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _schema(): JsonField<Schema> = body._schema()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): CustomMetadataFieldUpdateParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [CustomMetadataFieldUpdateParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CustomMetadataFieldUpdateParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(customMetadataFieldUpdateParams: CustomMetadataFieldUpdateParams) =
            apply {
                id = customMetadataFieldUpdateParams.id
                body = customMetadataFieldUpdateParams.body.toBuilder()
                additionalHeaders = customMetadataFieldUpdateParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    customMetadataFieldUpdateParams.additionalQueryParams.toBuilder()
            }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [label]
         * - [schema]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Human readable name of the custom metadata field. This should be unique across all non
         * deleted custom metadata fields. This name is displayed as form field label to the users
         * while setting field value on an asset in the media library UI. This parameter is required
         * if `schema` is not provided.
         */
        fun label(label: String) = apply { body.label(label) }

        /**
         * Sets [Builder.label] to an arbitrary JSON value.
         *
         * You should usually call [Builder.label] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun label(label: JsonField<String>) = apply { body.label(label) }

        /**
         * An object that describes the rules for the custom metadata key. This parameter is
         * required if `label` is not provided. Note: `type` cannot be updated and will be ignored
         * if sent with the `schema`. The schema will be validated as per the existing `type`.
         */
        fun schema(schema: Schema) = apply { body.schema(schema) }

        /**
         * Sets [Builder.schema] to an arbitrary JSON value.
         *
         * You should usually call [Builder.schema] with a well-typed [Schema] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun schema(schema: JsonField<Schema>) = apply { body.schema(schema) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [CustomMetadataFieldUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CustomMetadataFieldUpdateParams =
            CustomMetadataFieldUpdateParams(
                id,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val label: JsonField<String>,
        private val schema: JsonField<Schema>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("label") @ExcludeMissing label: JsonField<String> = JsonMissing.of(),
            @JsonProperty("schema") @ExcludeMissing schema: JsonField<Schema> = JsonMissing.of(),
        ) : this(label, schema, mutableMapOf())

        /**
         * Human readable name of the custom metadata field. This should be unique across all non
         * deleted custom metadata fields. This name is displayed as form field label to the users
         * while setting field value on an asset in the media library UI. This parameter is required
         * if `schema` is not provided.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun label(): Optional<String> = label.getOptional("label")

        /**
         * An object that describes the rules for the custom metadata key. This parameter is
         * required if `label` is not provided. Note: `type` cannot be updated and will be ignored
         * if sent with the `schema`. The schema will be validated as per the existing `type`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun schema(): Optional<Schema> = schema.getOptional("schema")

        /**
         * Returns the raw JSON value of [label].
         *
         * Unlike [label], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var label: JsonField<String> = JsonMissing.of()
            private var schema: JsonField<Schema> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                label = body.label
                schema = body.schema
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Human readable name of the custom metadata field. This should be unique across all
             * non deleted custom metadata fields. This name is displayed as form field label to the
             * users while setting field value on an asset in the media library UI. This parameter
             * is required if `schema` is not provided.
             */
            fun label(label: String) = label(JsonField.of(label))

            /**
             * Sets [Builder.label] to an arbitrary JSON value.
             *
             * You should usually call [Builder.label] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun label(label: JsonField<String>) = apply { this.label = label }

            /**
             * An object that describes the rules for the custom metadata key. This parameter is
             * required if `label` is not provided. Note: `type` cannot be updated and will be
             * ignored if sent with the `schema`. The schema will be validated as per the existing
             * `type`.
             */
            fun schema(schema: Schema) = schema(JsonField.of(schema))

            /**
             * Sets [Builder.schema] to an arbitrary JSON value.
             *
             * You should usually call [Builder.schema] with a well-typed [Schema] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body = Body(label, schema, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            label()
            schema().ifPresent { it.validate() }
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
            (if (label.asKnown().isPresent) 1 else 0) +
                (schema.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                label == other.label &&
                schema == other.schema &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(label, schema, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{label=$label, schema=$schema, additionalProperties=$additionalProperties}"
    }

    /**
     * An object that describes the rules for the custom metadata key. This parameter is required if
     * `label` is not provided. Note: `type` cannot be updated and will be ignored if sent with the
     * `schema`. The schema will be validated as per the existing `type`.
     */
    class Schema
    private constructor(
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
         * The default value for this custom metadata field. This property is only required if
         * `isValueRequired` property is set to `true`. The value should match the `type` of custom
         * metadata field.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun defaultValue(): Optional<DefaultValue> = defaultValue.getOptional("defaultValue")

        /**
         * Sets this custom metadata field as required. Setting custom metadata fields on an asset
         * will throw error if the value for all required fields are not present in upload or update
         * asset API request body.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun isValueRequired(): Optional<Boolean> = isValueRequired.getOptional("isValueRequired")

        /**
         * Maximum length of string. Only set this property if `type` is set to `Text` or
         * `Textarea`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun maxLength(): Optional<Double> = maxLength.getOptional("maxLength")

        /**
         * Maximum value of the field. Only set this property if field type is `Date` or `Number`.
         * For `Date` type field, set the minimum date in ISO8601 string format. For `Number` type
         * field, set the minimum numeric value.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun maxValue(): Optional<MaxValue> = maxValue.getOptional("maxValue")

        /**
         * Minimum length of string. Only set this property if `type` is set to `Text` or
         * `Textarea`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun minLength(): Optional<Double> = minLength.getOptional("minLength")

        /**
         * Minimum value of the field. Only set this property if field type is `Date` or `Number`.
         * For `Date` type field, set the minimum date in ISO8601 string format. For `Number` type
         * field, set the minimum numeric value.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun minValue(): Optional<MinValue> = minValue.getOptional("minValue")

        /**
         * An array of allowed values. This property is only required if `type` property is set to
         * `SingleSelect` or `MultiSelect`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun selectOptions(): Optional<List<SelectOption>> =
            selectOptions.getOptional("selectOptions")

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

            /** Returns a mutable builder for constructing an instance of [Schema]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Schema]. */
        class Builder internal constructor() {

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
                defaultValue = schema.defaultValue
                isValueRequired = schema.isValueRequired
                maxLength = schema.maxLength
                maxValue = schema.maxValue
                minLength = schema.minLength
                minValue = schema.minValue
                selectOptions = schema.selectOptions.map { it.toMutableList() }
                additionalProperties = schema.additionalProperties.toMutableMap()
            }

            /**
             * The default value for this custom metadata field. This property is only required if
             * `isValueRequired` property is set to `true`. The value should match the `type` of
             * custom metadata field.
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

            /** Alias for calling [defaultValue] with `DefaultValue.ofString(string)`. */
            fun defaultValue(string: String) = defaultValue(DefaultValue.ofString(string))

            /** Alias for calling [defaultValue] with `DefaultValue.ofNumber(number)`. */
            fun defaultValue(number: Double) = defaultValue(DefaultValue.ofNumber(number))

            /** Alias for calling [defaultValue] with `DefaultValue.ofBool(bool)`. */
            fun defaultValue(bool: Boolean) = defaultValue(DefaultValue.ofBool(bool))

            /** Alias for calling [defaultValue] with `DefaultValue.ofMixed(mixed)`. */
            fun defaultValueOfMixed(mixed: List<DefaultValue.UnnamedSchemaWithArrayParent3>) =
                defaultValue(DefaultValue.ofMixed(mixed))

            /**
             * Sets this custom metadata field as required. Setting custom metadata fields on an
             * asset will throw error if the value for all required fields are not present in upload
             * or update asset API request body.
             */
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

            /**
             * Maximum length of string. Only set this property if `type` is set to `Text` or
             * `Textarea`.
             */
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
             * Maximum value of the field. Only set this property if field type is `Date` or
             * `Number`. For `Date` type field, set the minimum date in ISO8601 string format. For
             * `Number` type field, set the minimum numeric value.
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

            /**
             * Minimum length of string. Only set this property if `type` is set to `Text` or
             * `Textarea`.
             */
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
             * Minimum value of the field. Only set this property if field type is `Date` or
             * `Number`. For `Date` type field, set the minimum date in ISO8601 string format. For
             * `Number` type field, set the minimum numeric value.
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

            /**
             * An array of allowed values. This property is only required if `type` property is set
             * to `SingleSelect` or `MultiSelect`.
             */
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
             */
            fun build(): Schema =
                Schema(
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
            (defaultValue.asKnown().getOrNull()?.validity() ?: 0) +
                (if (isValueRequired.asKnown().isPresent) 1 else 0) +
                (if (maxLength.asKnown().isPresent) 1 else 0) +
                (maxValue.asKnown().getOrNull()?.validity() ?: 0) +
                (if (minLength.asKnown().isPresent) 1 else 0) +
                (minValue.asKnown().getOrNull()?.validity() ?: 0) +
                (selectOptions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /**
         * The default value for this custom metadata field. This property is only required if
         * `isValueRequired` property is set to `true`. The value should match the `type` of custom
         * metadata field.
         */
        @JsonDeserialize(using = DefaultValue.Deserializer::class)
        @JsonSerialize(using = DefaultValue.Serializer::class)
        class DefaultValue
        private constructor(
            private val string: String? = null,
            private val number: Double? = null,
            private val bool: Boolean? = null,
            private val mixed: List<UnnamedSchemaWithArrayParent3>? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun number(): Optional<Double> = Optional.ofNullable(number)

            fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

            /**
             * Default value should be of type array when custom metadata field type is set to
             * `MultiSelect`.
             */
            fun mixed(): Optional<List<UnnamedSchemaWithArrayParent3>> = Optional.ofNullable(mixed)

            fun isString(): Boolean = string != null

            fun isNumber(): Boolean = number != null

            fun isBool(): Boolean = bool != null

            fun isMixed(): Boolean = mixed != null

            fun asString(): String = string.getOrThrow("string")

            fun asNumber(): Double = number.getOrThrow("number")

            fun asBool(): Boolean = bool.getOrThrow("bool")

            /**
             * Default value should be of type array when custom metadata field type is set to
             * `MultiSelect`.
             */
            fun asMixed(): List<UnnamedSchemaWithArrayParent3> = mixed.getOrThrow("mixed")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    number != null -> visitor.visitNumber(number)
                    bool != null -> visitor.visitBool(bool)
                    mixed != null -> visitor.visitMixed(mixed)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): DefaultValue = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitNumber(number: Double) {}

                        override fun visitBool(bool: Boolean) {}

                        override fun visitMixed(mixed: List<UnnamedSchemaWithArrayParent3>) {
                            mixed.forEach { it.validate() }
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
                        override fun visitString(string: String) = 1

                        override fun visitNumber(number: Double) = 1

                        override fun visitBool(bool: Boolean) = 1

                        override fun visitMixed(mixed: List<UnnamedSchemaWithArrayParent3>) =
                            mixed.sumOf { it.validity().toInt() }

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is DefaultValue &&
                    string == other.string &&
                    number == other.number &&
                    bool == other.bool &&
                    mixed == other.mixed
            }

            override fun hashCode(): Int = Objects.hash(string, number, bool, mixed)

            override fun toString(): String =
                when {
                    string != null -> "DefaultValue{string=$string}"
                    number != null -> "DefaultValue{number=$number}"
                    bool != null -> "DefaultValue{bool=$bool}"
                    mixed != null -> "DefaultValue{mixed=$mixed}"
                    _json != null -> "DefaultValue{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid DefaultValue")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = DefaultValue(string = string)

                @JvmStatic fun ofNumber(number: Double) = DefaultValue(number = number)

                @JvmStatic fun ofBool(bool: Boolean) = DefaultValue(bool = bool)

                /**
                 * Default value should be of type array when custom metadata field type is set to
                 * `MultiSelect`.
                 */
                @JvmStatic
                fun ofMixed(mixed: List<UnnamedSchemaWithArrayParent3>) =
                    DefaultValue(mixed = mixed.toImmutable())
            }

            /**
             * An interface that defines how to map each variant of [DefaultValue] to a value of
             * type [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitNumber(number: Double): T

                fun visitBool(bool: Boolean): T

                /**
                 * Default value should be of type array when custom metadata field type is set to
                 * `MultiSelect`.
                 */
                fun visitMixed(mixed: List<UnnamedSchemaWithArrayParent3>): T

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
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    DefaultValue(string = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                    DefaultValue(number = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                    DefaultValue(bool = it, _json = json)
                                },
                                tryDeserialize(
                                        node,
                                        jacksonTypeRef<List<UnnamedSchemaWithArrayParent3>>(),
                                    )
                                    ?.let { DefaultValue(mixed = it, _json = json) },
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
                        value.string != null -> generator.writeObject(value.string)
                        value.number != null -> generator.writeObject(value.number)
                        value.bool != null -> generator.writeObject(value.bool)
                        value.mixed != null -> generator.writeObject(value.mixed)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid DefaultValue")
                    }
                }
            }

            @JsonDeserialize(using = UnnamedSchemaWithArrayParent3.Deserializer::class)
            @JsonSerialize(using = UnnamedSchemaWithArrayParent3.Serializer::class)
            class UnnamedSchemaWithArrayParent3
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

                fun validate(): UnnamedSchemaWithArrayParent3 = apply {
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

                    return other is UnnamedSchemaWithArrayParent3 &&
                        string == other.string &&
                        number == other.number &&
                        bool == other.bool
                }

                override fun hashCode(): Int = Objects.hash(string, number, bool)

                override fun toString(): String =
                    when {
                        string != null -> "UnnamedSchemaWithArrayParent3{string=$string}"
                        number != null -> "UnnamedSchemaWithArrayParent3{number=$number}"
                        bool != null -> "UnnamedSchemaWithArrayParent3{bool=$bool}"
                        _json != null -> "UnnamedSchemaWithArrayParent3{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent3")
                    }

                companion object {

                    @JvmStatic
                    fun ofString(string: String) = UnnamedSchemaWithArrayParent3(string = string)

                    @JvmStatic
                    fun ofNumber(number: Double) = UnnamedSchemaWithArrayParent3(number = number)

                    @JvmStatic
                    fun ofBool(bool: Boolean) = UnnamedSchemaWithArrayParent3(bool = bool)
                }

                /**
                 * An interface that defines how to map each variant of
                 * [UnnamedSchemaWithArrayParent3] to a value of type [T].
                 */
                interface Visitor<out T> {

                    fun visitString(string: String): T

                    fun visitNumber(number: Double): T

                    fun visitBool(bool: Boolean): T

                    /**
                     * Maps an unknown variant of [UnnamedSchemaWithArrayParent3] to a value of type
                     * [T].
                     *
                     * An instance of [UnnamedSchemaWithArrayParent3] can contain an unknown variant
                     * if it was deserialized from data that doesn't match any known variant. For
                     * example, if the SDK is on an older version than the API, then the API may
                     * respond with new variants that the SDK is unaware of.
                     *
                     * @throws ImageKitInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw ImageKitInvalidDataException(
                            "Unknown UnnamedSchemaWithArrayParent3: $json"
                        )
                    }
                }

                internal class Deserializer :
                    BaseDeserializer<UnnamedSchemaWithArrayParent3>(
                        UnnamedSchemaWithArrayParent3::class
                    ) {

                    override fun ObjectCodec.deserialize(
                        node: JsonNode
                    ): UnnamedSchemaWithArrayParent3 {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                        UnnamedSchemaWithArrayParent3(string = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                        UnnamedSchemaWithArrayParent3(number = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                        UnnamedSchemaWithArrayParent3(bool = it, _json = json)
                                    },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // object).
                            0 -> UnnamedSchemaWithArrayParent3(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer :
                    BaseSerializer<UnnamedSchemaWithArrayParent3>(
                        UnnamedSchemaWithArrayParent3::class
                    ) {

                    override fun serialize(
                        value: UnnamedSchemaWithArrayParent3,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.string != null -> generator.writeObject(value.string)
                            value.number != null -> generator.writeObject(value.number)
                            value.bool != null -> generator.writeObject(value.bool)
                            value._json != null -> generator.writeObject(value._json)
                            else ->
                                throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent3")
                        }
                    }
                }
            }
        }

        /**
         * Maximum value of the field. Only set this property if field type is `Date` or `Number`.
         * For `Date` type field, set the minimum date in ISO8601 string format. For `Number` type
         * field, set the minimum numeric value.
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
         * Minimum value of the field. Only set this property if field type is `Date` or `Number`.
         * For `Date` type field, set the minimum date in ISO8601 string format. For `Number` type
         * field, set the minimum numeric value.
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
            "Schema{defaultValue=$defaultValue, isValueRequired=$isValueRequired, maxLength=$maxLength, maxValue=$maxValue, minLength=$minLength, minValue=$minValue, selectOptions=$selectOptions, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CustomMetadataFieldUpdateParams &&
            id == other.id &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(id, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "CustomMetadataFieldUpdateParams{id=$id, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
