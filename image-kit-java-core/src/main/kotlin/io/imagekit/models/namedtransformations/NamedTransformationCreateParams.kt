// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.namedtransformations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.core.Params
import io.imagekit.core.checkRequired
import io.imagekit.core.http.Headers
import io.imagekit.core.http.QueryParams
import io.imagekit.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * Creates a new named transformation and returns the created object.
 *
 * Named transformations let you assign a short, reusable name to a complex transformation string,
 * so it can be applied in image and video URLs as `tr:n-<name>` and later updated without changing
 * any existing URLs.
 *
 * Learn more about
 * [named transformations](https://imagekit.io/docs/transformations#named-transformations).
 */
class NamedTransformationCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Name of the named transformation. This is the alias used to refer to the transformation
     * string in image and video URLs, for example `tr:n-<name>`. Can only contain alphanumeric
     * characters, `_` and `-`, and must be unique for your account (case-insensitive).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = body.name()

    /**
     * The transformation string this name refers to. It must start with `tr:` followed by one or
     * more transformation parameters, for example `tr:w-150,h-150,fo-center,cm-resize`. Learn more
     * about the [transformation syntax](https://imagekit.io/docs/transformations).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transformation(): String = body.transformation()

    /**
     * Whether this named transformation is disabled. Set to `true` to temporarily disable it
     * without deleting it — requests using a disabled named transformation fail at delivery time.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun disabled(): Optional<Boolean> = body.disabled()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [transformation].
     *
     * Unlike [transformation], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _transformation(): JsonField<String> = body._transformation()

    /**
     * Returns the raw JSON value of [disabled].
     *
     * Unlike [disabled], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _disabled(): JsonField<Boolean> = body._disabled()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [NamedTransformationCreateParams].
         *
         * The following fields are required:
         * ```java
         * .name()
         * .transformation()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamedTransformationCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namedTransformationCreateParams: NamedTransformationCreateParams) =
            apply {
                body = namedTransformationCreateParams.body.toBuilder()
                additionalHeaders = namedTransformationCreateParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    namedTransformationCreateParams.additionalQueryParams.toBuilder()
            }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [name]
         * - [transformation]
         * - [disabled]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Name of the named transformation. This is the alias used to refer to the transformation
         * string in image and video URLs, for example `tr:n-<name>`. Can only contain alphanumeric
         * characters, `_` and `-`, and must be unique for your account (case-insensitive).
         */
        fun name(name: String) = apply { body.name(name) }

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /**
         * The transformation string this name refers to. It must start with `tr:` followed by one
         * or more transformation parameters, for example `tr:w-150,h-150,fo-center,cm-resize`.
         * Learn more about the [transformation syntax](https://imagekit.io/docs/transformations).
         */
        fun transformation(transformation: String) = apply { body.transformation(transformation) }

        /**
         * Sets [Builder.transformation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transformation] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun transformation(transformation: JsonField<String>) = apply {
            body.transformation(transformation)
        }

        /**
         * Whether this named transformation is disabled. Set to `true` to temporarily disable it
         * without deleting it — requests using a disabled named transformation fail at delivery
         * time.
         */
        fun disabled(disabled: Boolean) = apply { body.disabled(disabled) }

        /**
         * Sets [Builder.disabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.disabled] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun disabled(disabled: JsonField<Boolean>) = apply { body.disabled(disabled) }

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
         * Returns an immutable instance of [NamedTransformationCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .name()
         * .transformation()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): NamedTransformationCreateParams =
            NamedTransformationCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val name: JsonField<String>,
        private val transformation: JsonField<String>,
        private val disabled: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("transformation")
            @ExcludeMissing
            transformation: JsonField<String> = JsonMissing.of(),
            @JsonProperty("disabled")
            @ExcludeMissing
            disabled: JsonField<Boolean> = JsonMissing.of(),
        ) : this(name, transformation, disabled, mutableMapOf())

        /**
         * Name of the named transformation. This is the alias used to refer to the transformation
         * string in image and video URLs, for example `tr:n-<name>`. Can only contain alphanumeric
         * characters, `_` and `-`, and must be unique for your account (case-insensitive).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * The transformation string this name refers to. It must start with `tr:` followed by one
         * or more transformation parameters, for example `tr:w-150,h-150,fo-center,cm-resize`.
         * Learn more about the [transformation syntax](https://imagekit.io/docs/transformations).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun transformation(): String = transformation.getRequired("transformation")

        /**
         * Whether this named transformation is disabled. Set to `true` to temporarily disable it
         * without deleting it — requests using a disabled named transformation fail at delivery
         * time.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun disabled(): Optional<Boolean> = disabled.getOptional("disabled")

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [transformation].
         *
         * Unlike [transformation], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("transformation")
        @ExcludeMissing
        fun _transformation(): JsonField<String> = transformation

        /**
         * Returns the raw JSON value of [disabled].
         *
         * Unlike [disabled], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("disabled") @ExcludeMissing fun _disabled(): JsonField<Boolean> = disabled

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .name()
             * .transformation()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var transformation: JsonField<String>? = null
            private var disabled: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                name = body.name
                transformation = body.transformation
                disabled = body.disabled
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Name of the named transformation. This is the alias used to refer to the
             * transformation string in image and video URLs, for example `tr:n-<name>`. Can only
             * contain alphanumeric characters, `_` and `-`, and must be unique for your account
             * (case-insensitive).
             */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * The transformation string this name refers to. It must start with `tr:` followed by
             * one or more transformation parameters, for example
             * `tr:w-150,h-150,fo-center,cm-resize`. Learn more about the
             * [transformation syntax](https://imagekit.io/docs/transformations).
             */
            fun transformation(transformation: String) =
                transformation(JsonField.of(transformation))

            /**
             * Sets [Builder.transformation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.transformation] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun transformation(transformation: JsonField<String>) = apply {
                this.transformation = transformation
            }

            /**
             * Whether this named transformation is disabled. Set to `true` to temporarily disable
             * it without deleting it — requests using a disabled named transformation fail at
             * delivery time.
             */
            fun disabled(disabled: Boolean) = disabled(JsonField.of(disabled))

            /**
             * Sets [Builder.disabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.disabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun disabled(disabled: JsonField<Boolean>) = apply { this.disabled = disabled }

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
             *
             * The following fields are required:
             * ```java
             * .name()
             * .transformation()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("name", name),
                    checkRequired("transformation", transformation),
                    disabled,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            name()
            transformation()
            disabled()
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
            (if (name.asKnown().isPresent) 1 else 0) +
                (if (transformation.asKnown().isPresent) 1 else 0) +
                (if (disabled.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                name == other.name &&
                transformation == other.transformation &&
                disabled == other.disabled &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(name, transformation, disabled, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{name=$name, transformation=$transformation, disabled=$disabled, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamedTransformationCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "NamedTransformationCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
