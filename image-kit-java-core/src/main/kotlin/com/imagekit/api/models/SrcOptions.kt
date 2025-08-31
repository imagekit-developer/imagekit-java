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

/**
 * Options for generating ImageKit URLs with transformations. See the
 * [Transformations guide](https://imagekit.io/docs/transformations).
 */
class SrcOptions
private constructor(
    private val src: JsonField<String>,
    private val urlEndpoint: JsonField<String>,
    private val queryParameters: JsonField<QueryParameters>,
    private val transformation: JsonField<List<Transformation>>,
    private val transformationPosition: JsonField<TransformationPosition>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("src") @ExcludeMissing src: JsonField<String> = JsonMissing.of(),
        @JsonProperty("urlEndpoint")
        @ExcludeMissing
        urlEndpoint: JsonField<String> = JsonMissing.of(),
        @JsonProperty("queryParameters")
        @ExcludeMissing
        queryParameters: JsonField<QueryParameters> = JsonMissing.of(),
        @JsonProperty("transformation")
        @ExcludeMissing
        transformation: JsonField<List<Transformation>> = JsonMissing.of(),
        @JsonProperty("transformationPosition")
        @ExcludeMissing
        transformationPosition: JsonField<TransformationPosition> = JsonMissing.of(),
    ) : this(
        src,
        urlEndpoint,
        queryParameters,
        transformation,
        transformationPosition,
        mutableMapOf(),
    )

    /**
     * Accepts a relative or absolute path of the resource. If a relative path is provided, it is
     * appended to the `urlEndpoint`. If an absolute path is provided, `urlEndpoint` is ignored.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun src(): String = src.getRequired("src")

    /**
     * Get your urlEndpoint from the
     * [ImageKit dashboard](https://imagekit.io/dashboard/url-endpoints).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun urlEndpoint(): String = urlEndpoint.getRequired("urlEndpoint")

    /**
     * These are additional query parameters that you want to add to the final URL. They can be any
     * query parameters and not necessarily related to ImageKit. This is especially useful if you
     * want to add a versioning parameter to your URLs.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun queryParameters(): Optional<QueryParameters> =
        queryParameters.getOptional("queryParameters")

    /**
     * An array of objects specifying the transformations to be applied in the URL. If more than one
     * transformation is specified, they are applied in the order they are specified as chained
     * transformations. See
     * [Chained transformations](https://imagekit.io/docs/transformations#chained-transformations).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun transformation(): Optional<List<Transformation>> =
        transformation.getOptional("transformation")

    /**
     * By default, the transformation string is added as a query parameter in the URL, e.g.,
     * `?tr=w-100,h-100`. If you want to add the transformation string in the path of the URL, set
     * this to `path`. Learn more in the
     * [Transformations guide](https://imagekit.io/docs/transformations).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun transformationPosition(): Optional<TransformationPosition> =
        transformationPosition.getOptional("transformationPosition")

    /**
     * Returns the raw JSON value of [src].
     *
     * Unlike [src], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("src") @ExcludeMissing fun _src(): JsonField<String> = src

    /**
     * Returns the raw JSON value of [urlEndpoint].
     *
     * Unlike [urlEndpoint], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("urlEndpoint") @ExcludeMissing fun _urlEndpoint(): JsonField<String> = urlEndpoint

    /**
     * Returns the raw JSON value of [queryParameters].
     *
     * Unlike [queryParameters], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("queryParameters")
    @ExcludeMissing
    fun _queryParameters(): JsonField<QueryParameters> = queryParameters

    /**
     * Returns the raw JSON value of [transformation].
     *
     * Unlike [transformation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transformation")
    @ExcludeMissing
    fun _transformation(): JsonField<List<Transformation>> = transformation

    /**
     * Returns the raw JSON value of [transformationPosition].
     *
     * Unlike [transformationPosition], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("transformationPosition")
    @ExcludeMissing
    fun _transformationPosition(): JsonField<TransformationPosition> = transformationPosition

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
         * Returns a mutable builder for constructing an instance of [SrcOptions].
         *
         * The following fields are required:
         * ```java
         * .src()
         * .urlEndpoint()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SrcOptions]. */
    class Builder internal constructor() {

        private var src: JsonField<String>? = null
        private var urlEndpoint: JsonField<String>? = null
        private var queryParameters: JsonField<QueryParameters> = JsonMissing.of()
        private var transformation: JsonField<MutableList<Transformation>>? = null
        private var transformationPosition: JsonField<TransformationPosition> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(srcOptions: SrcOptions) = apply {
            src = srcOptions.src
            urlEndpoint = srcOptions.urlEndpoint
            queryParameters = srcOptions.queryParameters
            transformation = srcOptions.transformation.map { it.toMutableList() }
            transformationPosition = srcOptions.transformationPosition
            additionalProperties = srcOptions.additionalProperties.toMutableMap()
        }

        /**
         * Accepts a relative or absolute path of the resource. If a relative path is provided, it
         * is appended to the `urlEndpoint`. If an absolute path is provided, `urlEndpoint` is
         * ignored.
         */
        fun src(src: String) = src(JsonField.of(src))

        /**
         * Sets [Builder.src] to an arbitrary JSON value.
         *
         * You should usually call [Builder.src] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun src(src: JsonField<String>) = apply { this.src = src }

        /**
         * Get your urlEndpoint from the
         * [ImageKit dashboard](https://imagekit.io/dashboard/url-endpoints).
         */
        fun urlEndpoint(urlEndpoint: String) = urlEndpoint(JsonField.of(urlEndpoint))

        /**
         * Sets [Builder.urlEndpoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.urlEndpoint] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun urlEndpoint(urlEndpoint: JsonField<String>) = apply { this.urlEndpoint = urlEndpoint }

        /**
         * These are additional query parameters that you want to add to the final URL. They can be
         * any query parameters and not necessarily related to ImageKit. This is especially useful
         * if you want to add a versioning parameter to your URLs.
         */
        fun queryParameters(queryParameters: QueryParameters) =
            queryParameters(JsonField.of(queryParameters))

        /**
         * Sets [Builder.queryParameters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.queryParameters] with a well-typed [QueryParameters]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun queryParameters(queryParameters: JsonField<QueryParameters>) = apply {
            this.queryParameters = queryParameters
        }

        /**
         * An array of objects specifying the transformations to be applied in the URL. If more than
         * one transformation is specified, they are applied in the order they are specified as
         * chained transformations. See
         * [Chained transformations](https://imagekit.io/docs/transformations#chained-transformations).
         */
        fun transformation(transformation: List<Transformation>) =
            transformation(JsonField.of(transformation))

        /**
         * Sets [Builder.transformation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transformation] with a well-typed `List<Transformation>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun transformation(transformation: JsonField<List<Transformation>>) = apply {
            this.transformation = transformation.map { it.toMutableList() }
        }

        /**
         * Adds a single [Transformation] to [Builder.transformation].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTransformation(transformation: Transformation) = apply {
            this.transformation =
                (this.transformation ?: JsonField.of(mutableListOf())).also {
                    checkKnown("transformation", it).add(transformation)
                }
        }

        /**
         * By default, the transformation string is added as a query parameter in the URL, e.g.,
         * `?tr=w-100,h-100`. If you want to add the transformation string in the path of the URL,
         * set this to `path`. Learn more in the
         * [Transformations guide](https://imagekit.io/docs/transformations).
         */
        fun transformationPosition(transformationPosition: TransformationPosition) =
            transformationPosition(JsonField.of(transformationPosition))

        /**
         * Sets [Builder.transformationPosition] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transformationPosition] with a well-typed
         * [TransformationPosition] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun transformationPosition(transformationPosition: JsonField<TransformationPosition>) =
            apply {
                this.transformationPosition = transformationPosition
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
         * Returns an immutable instance of [SrcOptions].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .src()
         * .urlEndpoint()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SrcOptions =
            SrcOptions(
                checkRequired("src", src),
                checkRequired("urlEndpoint", urlEndpoint),
                queryParameters,
                (transformation ?: JsonMissing.of()).map { it.toImmutable() },
                transformationPosition,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SrcOptions = apply {
        if (validated) {
            return@apply
        }

        src()
        urlEndpoint()
        queryParameters().ifPresent { it.validate() }
        transformation().ifPresent { it.forEach { it.validate() } }
        transformationPosition().ifPresent { it.validate() }
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
            (if (urlEndpoint.asKnown().isPresent) 1 else 0) +
            (queryParameters.asKnown().getOrNull()?.validity() ?: 0) +
            (transformation.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (transformationPosition.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * These are additional query parameters that you want to add to the final URL. They can be any
     * query parameters and not necessarily related to ImageKit. This is especially useful if you
     * want to add a versioning parameter to your URLs.
     */
    class QueryParameters
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [QueryParameters]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [QueryParameters]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(queryParameters: QueryParameters) = apply {
                additionalProperties = queryParameters.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [QueryParameters].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): QueryParameters = QueryParameters(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): QueryParameters = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is QueryParameters && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "QueryParameters{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SrcOptions &&
            src == other.src &&
            urlEndpoint == other.urlEndpoint &&
            queryParameters == other.queryParameters &&
            transformation == other.transformation &&
            transformationPosition == other.transformationPosition &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            src,
            urlEndpoint,
            queryParameters,
            transformation,
            transformationPosition,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SrcOptions{src=$src, urlEndpoint=$urlEndpoint, queryParameters=$queryParameters, transformation=$transformation, transformationPosition=$transformationPosition, additionalProperties=$additionalProperties}"
}
