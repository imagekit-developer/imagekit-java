// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.core.Enum
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.core.checkRequired
import io.imagekit.errors.ImageKitInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Triggered when an asynchronous image transformation is finished and the transformed image is
 * ready to be served. Listen to this webhook and update any flags in your database or CMS so your
 * application can start displaying the transformed image to users.
 */
class ImageAsyncTransformationReadyEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val data: JsonField<Data>,
    private val request: JsonField<Request>,
    private val type: JsonValue,
    private val timings: JsonField<Timings>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("request") @ExcludeMissing request: JsonField<Request> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("timings") @ExcludeMissing timings: JsonField<Timings> = JsonMissing.of(),
    ) : this(id, createdAt, data, request, type, timings, mutableMapOf())

    fun toBaseWebhookEvent(): BaseWebhookEvent = BaseWebhookEvent.builder().id(id).build()

    /**
     * Unique identifier for the event.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Timestamp when the event was created in ISO8601 format.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("created_at")

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): Data = data.getRequired("data")

    /**
     * Information about the original request that triggered the image transformation.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun request(): Request = request.getRequired("request")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("image.async-transformation.ready")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Performance metrics for the transformation process.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timings(): Optional<Timings> = timings.getOptional("timings")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [request].
     *
     * Unlike [request], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("request") @ExcludeMissing fun _request(): JsonField<Request> = request

    /**
     * Returns the raw JSON value of [timings].
     *
     * Unlike [timings], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("timings") @ExcludeMissing fun _timings(): JsonField<Timings> = timings

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
         * [ImageAsyncTransformationReadyEvent].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .data()
         * .request()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImageAsyncTransformationReadyEvent]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var data: JsonField<Data>? = null
        private var request: JsonField<Request>? = null
        private var type: JsonValue = JsonValue.from("image.async-transformation.ready")
        private var timings: JsonField<Timings> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageAsyncTransformationReadyEvent: ImageAsyncTransformationReadyEvent) =
            apply {
                id = imageAsyncTransformationReadyEvent.id
                createdAt = imageAsyncTransformationReadyEvent.createdAt
                data = imageAsyncTransformationReadyEvent.data
                request = imageAsyncTransformationReadyEvent.request
                type = imageAsyncTransformationReadyEvent.type
                timings = imageAsyncTransformationReadyEvent.timings
                additionalProperties =
                    imageAsyncTransformationReadyEvent.additionalProperties.toMutableMap()
            }

        /** Unique identifier for the event. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Timestamp when the event was created in ISO8601 format. */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun data(data: Data) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /** Information about the original request that triggered the image transformation. */
        fun request(request: Request) = request(JsonField.of(request))

        /**
         * Sets [Builder.request] to an arbitrary JSON value.
         *
         * You should usually call [Builder.request] with a well-typed [Request] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun request(request: JsonField<Request>) = apply { this.request = request }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("image.async-transformation.ready")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Performance metrics for the transformation process. */
        fun timings(timings: Timings) = timings(JsonField.of(timings))

        /**
         * Sets [Builder.timings] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timings] with a well-typed [Timings] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun timings(timings: JsonField<Timings>) = apply { this.timings = timings }

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
         * Returns an immutable instance of [ImageAsyncTransformationReadyEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .data()
         * .request()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ImageAsyncTransformationReadyEvent =
            ImageAsyncTransformationReadyEvent(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("data", data),
                checkRequired("request", request),
                type,
                timings,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): ImageAsyncTransformationReadyEvent = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        data().validate()
        request().validate()
        _type().let {
            if (it != JsonValue.from("image.async-transformation.ready")) {
                throw ImageKitInvalidDataException("'type' is invalid, received $it")
            }
        }
        timings().ifPresent { it.validate() }
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (data.asKnown().getOrNull()?.validity() ?: 0) +
            (request.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("image.async-transformation.ready")) 1 else 0 } +
            (timings.asKnown().getOrNull()?.validity() ?: 0)

    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val asset: JsonField<Asset>,
        private val transformation: JsonField<Transformation>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("asset") @ExcludeMissing asset: JsonField<Asset> = JsonMissing.of(),
            @JsonProperty("transformation")
            @ExcludeMissing
            transformation: JsonField<Transformation> = JsonMissing.of(),
        ) : this(asset, transformation, mutableMapOf())

        /**
         * Information about the source image asset being transformed.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun asset(): Asset = asset.getRequired("asset")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun transformation(): Transformation = transformation.getRequired("transformation")

        /**
         * Returns the raw JSON value of [asset].
         *
         * Unlike [asset], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("asset") @ExcludeMissing fun _asset(): JsonField<Asset> = asset

        /**
         * Returns the raw JSON value of [transformation].
         *
         * Unlike [transformation], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("transformation")
        @ExcludeMissing
        fun _transformation(): JsonField<Transformation> = transformation

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
             * Returns a mutable builder for constructing an instance of [Data].
             *
             * The following fields are required:
             * ```java
             * .asset()
             * .transformation()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var asset: JsonField<Asset>? = null
            private var transformation: JsonField<Transformation>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                asset = data.asset
                transformation = data.transformation
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /** Information about the source image asset being transformed. */
            fun asset(asset: Asset) = asset(JsonField.of(asset))

            /**
             * Sets [Builder.asset] to an arbitrary JSON value.
             *
             * You should usually call [Builder.asset] with a well-typed [Asset] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun asset(asset: JsonField<Asset>) = apply { this.asset = asset }

            fun transformation(transformation: Transformation) =
                transformation(JsonField.of(transformation))

            /**
             * Sets [Builder.transformation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.transformation] with a well-typed [Transformation]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun transformation(transformation: JsonField<Transformation>) = apply {
                this.transformation = transformation
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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .asset()
             * .transformation()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Data =
                Data(
                    checkRequired("asset", asset),
                    checkRequired("transformation", transformation),
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
        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            asset().validate()
            transformation().validate()
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
            (asset.asKnown().getOrNull()?.validity() ?: 0) +
                (transformation.asKnown().getOrNull()?.validity() ?: 0)

        /** Information about the source image asset being transformed. */
        class Asset
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val url: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of()
            ) : this(url, mutableMapOf())

            /**
             * URL of the source image, without the transformation.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun url(): String = url.getRequired("url")

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
                 * Returns a mutable builder for constructing an instance of [Asset].
                 *
                 * The following fields are required:
                 * ```java
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Asset]. */
            class Builder internal constructor() {

                private var url: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(asset: Asset) = apply {
                    url = asset.url
                    additionalProperties = asset.additionalProperties.toMutableMap()
                }

                /** URL of the source image, without the transformation. */
                fun url(url: String) = url(JsonField.of(url))

                /**
                 * Sets [Builder.url] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.url] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun url(url: JsonField<String>) = apply { this.url = url }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Asset].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .url()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Asset =
                    Asset(checkRequired("url", url), additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): Asset = apply {
                if (validated) {
                    return@apply
                }

                url()
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
            @JvmSynthetic internal fun validity(): Int = (if (url.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Asset &&
                    url == other.url &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(url, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Asset{url=$url, additionalProperties=$additionalProperties}"
        }

        class Transformation
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val type: JsonField<Type>,
            private val options: JsonField<Options>,
            private val output: JsonField<Output>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("options")
                @ExcludeMissing
                options: JsonField<Options> = JsonMissing.of(),
                @JsonProperty("output") @ExcludeMissing output: JsonField<Output> = JsonMissing.of(),
            ) : this(type, options, output, mutableMapOf())

            /**
             * Type of transformation. Always `image-transformation`.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Options of the requested transformation.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun options(): Optional<Options> = options.getOptional("options")

            /**
             * Information about the transformed output image.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun output(): Optional<Output> = output.getOptional("output")

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [options].
             *
             * Unlike [options], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("options") @ExcludeMissing fun _options(): JsonField<Options> = options

            /**
             * Returns the raw JSON value of [output].
             *
             * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<Output> = output

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
                 * Returns a mutable builder for constructing an instance of [Transformation].
                 *
                 * The following fields are required:
                 * ```java
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Transformation]. */
            class Builder internal constructor() {

                private var type: JsonField<Type>? = null
                private var options: JsonField<Options> = JsonMissing.of()
                private var output: JsonField<Output> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(transformation: Transformation) = apply {
                    type = transformation.type
                    options = transformation.options
                    output = transformation.output
                    additionalProperties = transformation.additionalProperties.toMutableMap()
                }

                /** Type of transformation. Always `image-transformation`. */
                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** Options of the requested transformation. */
                fun options(options: Options) = options(JsonField.of(options))

                /**
                 * Sets [Builder.options] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.options] with a well-typed [Options] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun options(options: JsonField<Options>) = apply { this.options = options }

                /** Information about the transformed output image. */
                fun output(output: Output) = output(JsonField.of(output))

                /**
                 * Sets [Builder.output] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.output] with a well-typed [Output] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun output(output: JsonField<Output>) = apply { this.output = output }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Transformation].
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
                fun build(): Transformation =
                    Transformation(
                        checkRequired("type", type),
                        options,
                        output,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): Transformation = apply {
                if (validated) {
                    return@apply
                }

                type().validate()
                options().ifPresent { it.validate() }
                output().ifPresent { it.validate() }
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
                    (options.asKnown().getOrNull()?.validity() ?: 0) +
                    (output.asKnown().getOrNull()?.validity() ?: 0)

            /** Type of transformation. Always `image-transformation`. */
            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val IMAGE_TRANSFORMATION = of("image-transformation")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    IMAGE_TRANSFORMATION
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    IMAGE_TRANSFORMATION,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        IMAGE_TRANSFORMATION -> Value.IMAGE_TRANSFORMATION
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws ImageKitInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        IMAGE_TRANSFORMATION -> Known.IMAGE_TRANSFORMATION
                        else -> throw ImageKitInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws ImageKitInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        ImageKitInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws ImageKitInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
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

            /** Options of the requested transformation. */
            class Options
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val transformation: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("transformation")
                    @ExcludeMissing
                    transformation: JsonField<String> = JsonMissing.of()
                ) : this(transformation, mutableMapOf())

                /**
                 * The transformation string from the request URL, for example `e-removedotbg`. Not
                 * present if the URL has no transformation.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun transformation(): Optional<String> =
                    transformation.getOptional("transformation")

                /**
                 * Returns the raw JSON value of [transformation].
                 *
                 * Unlike [transformation], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("transformation")
                @ExcludeMissing
                fun _transformation(): JsonField<String> = transformation

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

                    private var transformation: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(options: Options) = apply {
                        transformation = options.transformation
                        additionalProperties = options.additionalProperties.toMutableMap()
                    }

                    /**
                     * The transformation string from the request URL, for example `e-removedotbg`.
                     * Not present if the URL has no transformation.
                     */
                    fun transformation(transformation: String) =
                        transformation(JsonField.of(transformation))

                    /**
                     * Sets [Builder.transformation] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.transformation] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun transformation(transformation: JsonField<String>) = apply {
                        this.transformation = transformation
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Options].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Options =
                        Options(transformation, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws ImageKitInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
                fun validate(): Options = apply {
                    if (validated) {
                        return@apply
                    }

                    transformation()
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
                internal fun validity(): Int = (if (transformation.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Options &&
                        transformation == other.transformation &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(transformation, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Options{transformation=$transformation, additionalProperties=$additionalProperties}"
            }

            /** Information about the transformed output image. */
            class Output
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val url: JsonField<String>,
                private val imageMetadata: JsonField<ImageMetadata>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("image_metadata")
                    @ExcludeMissing
                    imageMetadata: JsonField<ImageMetadata> = JsonMissing.of(),
                ) : this(url, imageMetadata, mutableMapOf())

                /**
                 * URL to access the transformed image.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun url(): String = url.getRequired("url")

                /**
                 * Metadata of the output image.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun imageMetadata(): Optional<ImageMetadata> =
                    imageMetadata.getOptional("image_metadata")

                /**
                 * Returns the raw JSON value of [url].
                 *
                 * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                /**
                 * Returns the raw JSON value of [imageMetadata].
                 *
                 * Unlike [imageMetadata], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("image_metadata")
                @ExcludeMissing
                fun _imageMetadata(): JsonField<ImageMetadata> = imageMetadata

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
                     * Returns a mutable builder for constructing an instance of [Output].
                     *
                     * The following fields are required:
                     * ```java
                     * .url()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Output]. */
                class Builder internal constructor() {

                    private var url: JsonField<String>? = null
                    private var imageMetadata: JsonField<ImageMetadata> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(output: Output) = apply {
                        url = output.url
                        imageMetadata = output.imageMetadata
                        additionalProperties = output.additionalProperties.toMutableMap()
                    }

                    /** URL to access the transformed image. */
                    fun url(url: String) = url(JsonField.of(url))

                    /**
                     * Sets [Builder.url] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.url] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun url(url: JsonField<String>) = apply { this.url = url }

                    /** Metadata of the output image. */
                    fun imageMetadata(imageMetadata: ImageMetadata) =
                        imageMetadata(JsonField.of(imageMetadata))

                    /**
                     * Sets [Builder.imageMetadata] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.imageMetadata] with a well-typed
                     * [ImageMetadata] value instead. This method is primarily for setting the field
                     * to an undocumented or not yet supported value.
                     */
                    fun imageMetadata(imageMetadata: JsonField<ImageMetadata>) = apply {
                        this.imageMetadata = imageMetadata
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Output].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .url()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Output =
                        Output(
                            checkRequired("url", url),
                            imageMetadata,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws ImageKitInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
                fun validate(): Output = apply {
                    if (validated) {
                        return@apply
                    }

                    url()
                    imageMetadata().ifPresent { it.validate() }
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
                    (if (url.asKnown().isPresent) 1 else 0) +
                        (imageMetadata.asKnown().getOrNull()?.validity() ?: 0)

                /** Metadata of the output image. */
                class ImageMetadata
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val size: JsonField<Long>,
                    private val format: JsonField<String>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("size")
                        @ExcludeMissing
                        size: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("format")
                        @ExcludeMissing
                        format: JsonField<String> = JsonMissing.of(),
                    ) : this(size, format, mutableMapOf())

                    /**
                     * Size of the output image in bytes.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun size(): Long = size.getRequired("size")

                    /**
                     * Format of the output image, for example `webp` or `png`.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun format(): Optional<String> = format.getOptional("format")

                    /**
                     * Returns the raw JSON value of [size].
                     *
                     * Unlike [size], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<Long> = size

                    /**
                     * Returns the raw JSON value of [format].
                     *
                     * Unlike [format], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("format")
                    @ExcludeMissing
                    fun _format(): JsonField<String> = format

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
                         * [ImageMetadata].
                         *
                         * The following fields are required:
                         * ```java
                         * .size()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [ImageMetadata]. */
                    class Builder internal constructor() {

                        private var size: JsonField<Long>? = null
                        private var format: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(imageMetadata: ImageMetadata) = apply {
                            size = imageMetadata.size
                            format = imageMetadata.format
                            additionalProperties = imageMetadata.additionalProperties.toMutableMap()
                        }

                        /** Size of the output image in bytes. */
                        fun size(size: Long) = size(JsonField.of(size))

                        /**
                         * Sets [Builder.size] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.size] with a well-typed [Long] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun size(size: JsonField<Long>) = apply { this.size = size }

                        /** Format of the output image, for example `webp` or `png`. */
                        fun format(format: String) = format(JsonField.of(format))

                        /**
                         * Sets [Builder.format] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.format] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun format(format: JsonField<String>) = apply { this.format = format }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [ImageMetadata].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .size()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): ImageMetadata =
                            ImageMetadata(
                                checkRequired("size", size),
                                format,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws ImageKitInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): ImageMetadata = apply {
                        if (validated) {
                            return@apply
                        }

                        size()
                        format()
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
                        (if (size.asKnown().isPresent) 1 else 0) +
                            (if (format.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is ImageMetadata &&
                            size == other.size &&
                            format == other.format &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(size, format, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "ImageMetadata{size=$size, format=$format, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Output &&
                        url == other.url &&
                        imageMetadata == other.imageMetadata &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(url, imageMetadata, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Output{url=$url, imageMetadata=$imageMetadata, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Transformation &&
                    type == other.type &&
                    options == other.options &&
                    output == other.output &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(type, options, output, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Transformation{type=$type, options=$options, output=$output, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                asset == other.asset &&
                transformation == other.transformation &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(asset, transformation, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{asset=$asset, transformation=$transformation, additionalProperties=$additionalProperties}"
    }

    /** Information about the original request that triggered the image transformation. */
    class Request
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val url: JsonField<String>,
        private val xRequestId: JsonField<String>,
        private val userAgent: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("x_request_id")
            @ExcludeMissing
            xRequestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("user_agent")
            @ExcludeMissing
            userAgent: JsonField<String> = JsonMissing.of(),
        ) : this(url, xRequestId, userAgent, mutableMapOf())

        /**
         * Full URL of the transformation request that was submitted.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun url(): String = url.getRequired("url")

        /**
         * Unique identifier for the originating transformation request.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun xRequestId(): String = xRequestId.getRequired("x_request_id")

        /**
         * User-Agent header from the original request that triggered the transformation.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun userAgent(): Optional<String> = userAgent.getOptional("user_agent")

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [xRequestId].
         *
         * Unlike [xRequestId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("x_request_id")
        @ExcludeMissing
        fun _xRequestId(): JsonField<String> = xRequestId

        /**
         * Returns the raw JSON value of [userAgent].
         *
         * Unlike [userAgent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("user_agent") @ExcludeMissing fun _userAgent(): JsonField<String> = userAgent

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
             * Returns a mutable builder for constructing an instance of [Request].
             *
             * The following fields are required:
             * ```java
             * .url()
             * .xRequestId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Request]. */
        class Builder internal constructor() {

            private var url: JsonField<String>? = null
            private var xRequestId: JsonField<String>? = null
            private var userAgent: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(request: Request) = apply {
                url = request.url
                xRequestId = request.xRequestId
                userAgent = request.userAgent
                additionalProperties = request.additionalProperties.toMutableMap()
            }

            /** Full URL of the transformation request that was submitted. */
            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /** Unique identifier for the originating transformation request. */
            fun xRequestId(xRequestId: String) = xRequestId(JsonField.of(xRequestId))

            /**
             * Sets [Builder.xRequestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.xRequestId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun xRequestId(xRequestId: JsonField<String>) = apply { this.xRequestId = xRequestId }

            /** User-Agent header from the original request that triggered the transformation. */
            fun userAgent(userAgent: String) = userAgent(JsonField.of(userAgent))

            /**
             * Sets [Builder.userAgent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userAgent] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userAgent(userAgent: JsonField<String>) = apply { this.userAgent = userAgent }

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
             * Returns an immutable instance of [Request].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .url()
             * .xRequestId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Request =
                Request(
                    checkRequired("url", url),
                    checkRequired("xRequestId", xRequestId),
                    userAgent,
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
        fun validate(): Request = apply {
            if (validated) {
                return@apply
            }

            url()
            xRequestId()
            userAgent()
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
            (if (url.asKnown().isPresent) 1 else 0) +
                (if (xRequestId.asKnown().isPresent) 1 else 0) +
                (if (userAgent.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Request &&
                url == other.url &&
                xRequestId == other.xRequestId &&
                userAgent == other.userAgent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(url, xRequestId, userAgent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Request{url=$url, xRequestId=$xRequestId, userAgent=$userAgent, additionalProperties=$additionalProperties}"
    }

    /** Performance metrics for the transformation process. */
    class Timings
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val processingDuration: JsonField<Long>,
        private val queueDuration: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("processing_duration")
            @ExcludeMissing
            processingDuration: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("queue_duration")
            @ExcludeMissing
            queueDuration: JsonField<Long> = JsonMissing.of(),
        ) : this(processingDuration, queueDuration, mutableMapOf())

        /**
         * Time spent processing the transformation, in milliseconds.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun processingDuration(): Optional<Long> =
            processingDuration.getOptional("processing_duration")

        /**
         * Time the request waited in the queue before processing started, in milliseconds.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun queueDuration(): Optional<Long> = queueDuration.getOptional("queue_duration")

        /**
         * Returns the raw JSON value of [processingDuration].
         *
         * Unlike [processingDuration], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("processing_duration")
        @ExcludeMissing
        fun _processingDuration(): JsonField<Long> = processingDuration

        /**
         * Returns the raw JSON value of [queueDuration].
         *
         * Unlike [queueDuration], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("queue_duration")
        @ExcludeMissing
        fun _queueDuration(): JsonField<Long> = queueDuration

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

            /** Returns a mutable builder for constructing an instance of [Timings]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Timings]. */
        class Builder internal constructor() {

            private var processingDuration: JsonField<Long> = JsonMissing.of()
            private var queueDuration: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(timings: Timings) = apply {
                processingDuration = timings.processingDuration
                queueDuration = timings.queueDuration
                additionalProperties = timings.additionalProperties.toMutableMap()
            }

            /** Time spent processing the transformation, in milliseconds. */
            fun processingDuration(processingDuration: Long) =
                processingDuration(JsonField.of(processingDuration))

            /**
             * Sets [Builder.processingDuration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.processingDuration] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun processingDuration(processingDuration: JsonField<Long>) = apply {
                this.processingDuration = processingDuration
            }

            /** Time the request waited in the queue before processing started, in milliseconds. */
            fun queueDuration(queueDuration: Long) = queueDuration(JsonField.of(queueDuration))

            /**
             * Sets [Builder.queueDuration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.queueDuration] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun queueDuration(queueDuration: JsonField<Long>) = apply {
                this.queueDuration = queueDuration
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
             * Returns an immutable instance of [Timings].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Timings =
                Timings(processingDuration, queueDuration, additionalProperties.toMutableMap())
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
        fun validate(): Timings = apply {
            if (validated) {
                return@apply
            }

            processingDuration()
            queueDuration()
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
            (if (processingDuration.asKnown().isPresent) 1 else 0) +
                (if (queueDuration.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Timings &&
                processingDuration == other.processingDuration &&
                queueDuration == other.queueDuration &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(processingDuration, queueDuration, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Timings{processingDuration=$processingDuration, queueDuration=$queueDuration, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ImageAsyncTransformationReadyEvent &&
            id == other.id &&
            createdAt == other.createdAt &&
            data == other.data &&
            request == other.request &&
            type == other.type &&
            timings == other.timings &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, createdAt, data, request, type, timings, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImageAsyncTransformationReadyEvent{id=$id, createdAt=$createdAt, data=$data, request=$request, type=$type, timings=$timings, additionalProperties=$additionalProperties}"
}
