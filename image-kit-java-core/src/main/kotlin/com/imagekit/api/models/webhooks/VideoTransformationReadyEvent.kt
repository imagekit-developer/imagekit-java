// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.imagekit.api.core.Enum
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.checkKnown
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Triggered when video encoding is finished and the transformed resource is ready to be served.
 * This is the key event to listen for - update your database or CMS flags when you receive this so
 * your application can start showing the transformed video to users.
 */
class VideoTransformationReadyEvent
private constructor(
    private val id: JsonField<String>,
    private val type: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val data: JsonField<Data>,
    private val request: JsonField<Request>,
    private val timings: JsonField<Timings>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("request") @ExcludeMissing request: JsonField<Request> = JsonMissing.of(),
        @JsonProperty("timings") @ExcludeMissing timings: JsonField<Timings> = JsonMissing.of(),
    ) : this(id, type, createdAt, data, request, timings, mutableMapOf())

    fun toBaseWebhookEvent(): BaseWebhookEvent =
        BaseWebhookEvent.builder().id(id).type(type).build()

    /**
     * Unique identifier for the event.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The type of webhook event.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): String = type.getRequired("type")

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
     * Information about the original request that triggered the video transformation.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun request(): Request = request.getRequired("request")

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
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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
         * [VideoTransformationReadyEvent].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .type()
         * .createdAt()
         * .data()
         * .request()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VideoTransformationReadyEvent]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var type: JsonField<String>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var data: JsonField<Data>? = null
        private var request: JsonField<Request>? = null
        private var timings: JsonField<Timings> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(videoTransformationReadyEvent: VideoTransformationReadyEvent) = apply {
            id = videoTransformationReadyEvent.id
            type = videoTransformationReadyEvent.type
            createdAt = videoTransformationReadyEvent.createdAt
            data = videoTransformationReadyEvent.data
            request = videoTransformationReadyEvent.request
            timings = videoTransformationReadyEvent.timings
            additionalProperties = videoTransformationReadyEvent.additionalProperties.toMutableMap()
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

        /** The type of webhook event. */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

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

        /** Information about the original request that triggered the video transformation. */
        fun request(request: Request) = request(JsonField.of(request))

        /**
         * Sets [Builder.request] to an arbitrary JSON value.
         *
         * You should usually call [Builder.request] with a well-typed [Request] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun request(request: JsonField<Request>) = apply { this.request = request }

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
         * Returns an immutable instance of [VideoTransformationReadyEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .type()
         * .createdAt()
         * .data()
         * .request()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): VideoTransformationReadyEvent =
            VideoTransformationReadyEvent(
                checkRequired("id", id),
                checkRequired("type", type),
                checkRequired("createdAt", createdAt),
                checkRequired("data", data),
                checkRequired("request", request),
                timings,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): VideoTransformationReadyEvent = apply {
        if (validated) {
            return@apply
        }

        id()
        type()
        createdAt()
        data().validate()
        request().validate()
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
            (if (type.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (data.asKnown().getOrNull()?.validity() ?: 0) +
            (request.asKnown().getOrNull()?.validity() ?: 0) +
            (timings.asKnown().getOrNull()?.validity() ?: 0)

    class Data
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
         * Information about the source video asset being transformed.
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

            /** Information about the source video asset being transformed. */
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

        /** Information about the source video asset being transformed. */
        class Asset
        private constructor(
            private val url: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of()
            ) : this(url, mutableMapOf())

            /**
             * URL to download or access the source video file.
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

                /** URL to download or access the source video file. */
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
             * Type of video transformation:
             * - `video-transformation`: Standard video processing (resize, format conversion, etc.)
             * - `gif-to-video`: Convert animated GIF to video format
             * - `video-thumbnail`: Generate thumbnail image from video
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Configuration options for video transformations.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun options(): Optional<Options> = options.getOptional("options")

            /**
             * Information about the transformed output video.
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

                /**
                 * Type of video transformation:
                 * - `video-transformation`: Standard video processing (resize, format conversion,
                 *   etc.)
                 * - `gif-to-video`: Convert animated GIF to video format
                 * - `video-thumbnail`: Generate thumbnail image from video
                 */
                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** Configuration options for video transformations. */
                fun options(options: Options) = options(JsonField.of(options))

                /**
                 * Sets [Builder.options] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.options] with a well-typed [Options] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun options(options: JsonField<Options>) = apply { this.options = options }

                /** Information about the transformed output video. */
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

            /**
             * Type of video transformation:
             * - `video-transformation`: Standard video processing (resize, format conversion, etc.)
             * - `gif-to-video`: Convert animated GIF to video format
             * - `video-thumbnail`: Generate thumbnail image from video
             */
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

                    @JvmField val VIDEO_TRANSFORMATION = of("video-transformation")

                    @JvmField val GIF_TO_VIDEO = of("gif-to-video")

                    @JvmField val VIDEO_THUMBNAIL = of("video-thumbnail")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    VIDEO_TRANSFORMATION,
                    GIF_TO_VIDEO,
                    VIDEO_THUMBNAIL,
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
                    VIDEO_TRANSFORMATION,
                    GIF_TO_VIDEO,
                    VIDEO_THUMBNAIL,
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
                        VIDEO_TRANSFORMATION -> Value.VIDEO_TRANSFORMATION
                        GIF_TO_VIDEO -> Value.GIF_TO_VIDEO
                        VIDEO_THUMBNAIL -> Value.VIDEO_THUMBNAIL
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
                        VIDEO_TRANSFORMATION -> Known.VIDEO_TRANSFORMATION
                        GIF_TO_VIDEO -> Known.GIF_TO_VIDEO
                        VIDEO_THUMBNAIL -> Known.VIDEO_THUMBNAIL
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

            /** Configuration options for video transformations. */
            class Options
            private constructor(
                private val audioCodec: JsonField<AudioCodec>,
                private val autoRotate: JsonField<Boolean>,
                private val format: JsonField<Format>,
                private val quality: JsonField<Long>,
                private val streamProtocol: JsonField<StreamProtocol>,
                private val variants: JsonField<List<String>>,
                private val videoCodec: JsonField<VideoCodec>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("audio_codec")
                    @ExcludeMissing
                    audioCodec: JsonField<AudioCodec> = JsonMissing.of(),
                    @JsonProperty("auto_rotate")
                    @ExcludeMissing
                    autoRotate: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("format")
                    @ExcludeMissing
                    format: JsonField<Format> = JsonMissing.of(),
                    @JsonProperty("quality")
                    @ExcludeMissing
                    quality: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("stream_protocol")
                    @ExcludeMissing
                    streamProtocol: JsonField<StreamProtocol> = JsonMissing.of(),
                    @JsonProperty("variants")
                    @ExcludeMissing
                    variants: JsonField<List<String>> = JsonMissing.of(),
                    @JsonProperty("video_codec")
                    @ExcludeMissing
                    videoCodec: JsonField<VideoCodec> = JsonMissing.of(),
                ) : this(
                    audioCodec,
                    autoRotate,
                    format,
                    quality,
                    streamProtocol,
                    variants,
                    videoCodec,
                    mutableMapOf(),
                )

                /**
                 * Audio codec used for encoding (aac or opus).
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun audioCodec(): Optional<AudioCodec> = audioCodec.getOptional("audio_codec")

                /**
                 * Whether to automatically rotate the video based on metadata.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun autoRotate(): Optional<Boolean> = autoRotate.getOptional("auto_rotate")

                /**
                 * Output format for the transformed video or thumbnail.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun format(): Optional<Format> = format.getOptional("format")

                /**
                 * Quality setting for the output video.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun quality(): Optional<Long> = quality.getOptional("quality")

                /**
                 * Streaming protocol for adaptive bitrate streaming.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun streamProtocol(): Optional<StreamProtocol> =
                    streamProtocol.getOptional("stream_protocol")

                /**
                 * Array of quality representations for adaptive bitrate streaming.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun variants(): Optional<List<String>> = variants.getOptional("variants")

                /**
                 * Video codec used for encoding (h264, vp9, or av1).
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun videoCodec(): Optional<VideoCodec> = videoCodec.getOptional("video_codec")

                /**
                 * Returns the raw JSON value of [audioCodec].
                 *
                 * Unlike [audioCodec], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("audio_codec")
                @ExcludeMissing
                fun _audioCodec(): JsonField<AudioCodec> = audioCodec

                /**
                 * Returns the raw JSON value of [autoRotate].
                 *
                 * Unlike [autoRotate], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("auto_rotate")
                @ExcludeMissing
                fun _autoRotate(): JsonField<Boolean> = autoRotate

                /**
                 * Returns the raw JSON value of [format].
                 *
                 * Unlike [format], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<Format> = format

                /**
                 * Returns the raw JSON value of [quality].
                 *
                 * Unlike [quality], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("quality") @ExcludeMissing fun _quality(): JsonField<Long> = quality

                /**
                 * Returns the raw JSON value of [streamProtocol].
                 *
                 * Unlike [streamProtocol], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("stream_protocol")
                @ExcludeMissing
                fun _streamProtocol(): JsonField<StreamProtocol> = streamProtocol

                /**
                 * Returns the raw JSON value of [variants].
                 *
                 * Unlike [variants], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("variants")
                @ExcludeMissing
                fun _variants(): JsonField<List<String>> = variants

                /**
                 * Returns the raw JSON value of [videoCodec].
                 *
                 * Unlike [videoCodec], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("video_codec")
                @ExcludeMissing
                fun _videoCodec(): JsonField<VideoCodec> = videoCodec

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

                    private var audioCodec: JsonField<AudioCodec> = JsonMissing.of()
                    private var autoRotate: JsonField<Boolean> = JsonMissing.of()
                    private var format: JsonField<Format> = JsonMissing.of()
                    private var quality: JsonField<Long> = JsonMissing.of()
                    private var streamProtocol: JsonField<StreamProtocol> = JsonMissing.of()
                    private var variants: JsonField<MutableList<String>>? = null
                    private var videoCodec: JsonField<VideoCodec> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(options: Options) = apply {
                        audioCodec = options.audioCodec
                        autoRotate = options.autoRotate
                        format = options.format
                        quality = options.quality
                        streamProtocol = options.streamProtocol
                        variants = options.variants.map { it.toMutableList() }
                        videoCodec = options.videoCodec
                        additionalProperties = options.additionalProperties.toMutableMap()
                    }

                    /** Audio codec used for encoding (aac or opus). */
                    fun audioCodec(audioCodec: AudioCodec) = audioCodec(JsonField.of(audioCodec))

                    /**
                     * Sets [Builder.audioCodec] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.audioCodec] with a well-typed [AudioCodec]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun audioCodec(audioCodec: JsonField<AudioCodec>) = apply {
                        this.audioCodec = audioCodec
                    }

                    /** Whether to automatically rotate the video based on metadata. */
                    fun autoRotate(autoRotate: Boolean) = autoRotate(JsonField.of(autoRotate))

                    /**
                     * Sets [Builder.autoRotate] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.autoRotate] with a well-typed [Boolean]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun autoRotate(autoRotate: JsonField<Boolean>) = apply {
                        this.autoRotate = autoRotate
                    }

                    /** Output format for the transformed video or thumbnail. */
                    fun format(format: Format) = format(JsonField.of(format))

                    /**
                     * Sets [Builder.format] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.format] with a well-typed [Format] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun format(format: JsonField<Format>) = apply { this.format = format }

                    /** Quality setting for the output video. */
                    fun quality(quality: Long) = quality(JsonField.of(quality))

                    /**
                     * Sets [Builder.quality] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.quality] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun quality(quality: JsonField<Long>) = apply { this.quality = quality }

                    /** Streaming protocol for adaptive bitrate streaming. */
                    fun streamProtocol(streamProtocol: StreamProtocol) =
                        streamProtocol(JsonField.of(streamProtocol))

                    /**
                     * Sets [Builder.streamProtocol] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.streamProtocol] with a well-typed
                     * [StreamProtocol] value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun streamProtocol(streamProtocol: JsonField<StreamProtocol>) = apply {
                        this.streamProtocol = streamProtocol
                    }

                    /** Array of quality representations for adaptive bitrate streaming. */
                    fun variants(variants: List<String>) = variants(JsonField.of(variants))

                    /**
                     * Sets [Builder.variants] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.variants] with a well-typed `List<String>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun variants(variants: JsonField<List<String>>) = apply {
                        this.variants = variants.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [String] to [variants].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addVariant(variant: String) = apply {
                        variants =
                            (variants ?: JsonField.of(mutableListOf())).also {
                                checkKnown("variants", it).add(variant)
                            }
                    }

                    /** Video codec used for encoding (h264, vp9, or av1). */
                    fun videoCodec(videoCodec: VideoCodec) = videoCodec(JsonField.of(videoCodec))

                    /**
                     * Sets [Builder.videoCodec] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.videoCodec] with a well-typed [VideoCodec]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun videoCodec(videoCodec: JsonField<VideoCodec>) = apply {
                        this.videoCodec = videoCodec
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
                        Options(
                            audioCodec,
                            autoRotate,
                            format,
                            quality,
                            streamProtocol,
                            (variants ?: JsonMissing.of()).map { it.toImmutable() },
                            videoCodec,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Options = apply {
                    if (validated) {
                        return@apply
                    }

                    audioCodec().ifPresent { it.validate() }
                    autoRotate()
                    format().ifPresent { it.validate() }
                    quality()
                    streamProtocol().ifPresent { it.validate() }
                    variants()
                    videoCodec().ifPresent { it.validate() }
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
                    (audioCodec.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (autoRotate.asKnown().isPresent) 1 else 0) +
                        (format.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (quality.asKnown().isPresent) 1 else 0) +
                        (streamProtocol.asKnown().getOrNull()?.validity() ?: 0) +
                        (variants.asKnown().getOrNull()?.size ?: 0) +
                        (videoCodec.asKnown().getOrNull()?.validity() ?: 0)

                /** Audio codec used for encoding (aac or opus). */
                class AudioCodec
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val AAC = of("aac")

                        @JvmField val OPUS = of("opus")

                        @JvmStatic fun of(value: String) = AudioCodec(JsonField.of(value))
                    }

                    /** An enum containing [AudioCodec]'s known values. */
                    enum class Known {
                        AAC,
                        OPUS,
                    }

                    /**
                     * An enum containing [AudioCodec]'s known values, as well as an [_UNKNOWN]
                     * member.
                     *
                     * An instance of [AudioCodec] can contain an unknown value in a couple of
                     * cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        AAC,
                        OPUS,
                        /**
                         * An enum member indicating that [AudioCodec] was instantiated with an
                         * unknown value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            AAC -> Value.AAC
                            OPUS -> Value.OPUS
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value is a not
                     *   a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            AAC -> Known.AAC
                            OPUS -> Known.OPUS
                            else -> throw ImageKitInvalidDataException("Unknown AudioCodec: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            ImageKitInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): AudioCodec = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is AudioCodec && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                /** Output format for the transformed video or thumbnail. */
                class Format
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val MP4 = of("mp4")

                        @JvmField val WEBM = of("webm")

                        @JvmField val JPG = of("jpg")

                        @JvmField val PNG = of("png")

                        @JvmField val WEBP = of("webp")

                        @JvmStatic fun of(value: String) = Format(JsonField.of(value))
                    }

                    /** An enum containing [Format]'s known values. */
                    enum class Known {
                        MP4,
                        WEBM,
                        JPG,
                        PNG,
                        WEBP,
                    }

                    /**
                     * An enum containing [Format]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Format] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        MP4,
                        WEBM,
                        JPG,
                        PNG,
                        WEBP,
                        /**
                         * An enum member indicating that [Format] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            MP4 -> Value.MP4
                            WEBM -> Value.WEBM
                            JPG -> Value.JPG
                            PNG -> Value.PNG
                            WEBP -> Value.WEBP
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value is a not
                     *   a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            MP4 -> Known.MP4
                            WEBM -> Known.WEBM
                            JPG -> Known.JPG
                            PNG -> Known.PNG
                            WEBP -> Known.WEBP
                            else -> throw ImageKitInvalidDataException("Unknown Format: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            ImageKitInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): Format = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Format && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                /** Streaming protocol for adaptive bitrate streaming. */
                class StreamProtocol
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val HLS = of("HLS")

                        @JvmField val DASH = of("DASH")

                        @JvmStatic fun of(value: String) = StreamProtocol(JsonField.of(value))
                    }

                    /** An enum containing [StreamProtocol]'s known values. */
                    enum class Known {
                        HLS,
                        DASH,
                    }

                    /**
                     * An enum containing [StreamProtocol]'s known values, as well as an [_UNKNOWN]
                     * member.
                     *
                     * An instance of [StreamProtocol] can contain an unknown value in a couple of
                     * cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        HLS,
                        DASH,
                        /**
                         * An enum member indicating that [StreamProtocol] was instantiated with an
                         * unknown value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            HLS -> Value.HLS
                            DASH -> Value.DASH
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value is a not
                     *   a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            HLS -> Known.HLS
                            DASH -> Known.DASH
                            else ->
                                throw ImageKitInvalidDataException("Unknown StreamProtocol: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            ImageKitInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): StreamProtocol = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is StreamProtocol && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                /** Video codec used for encoding (h264, vp9, or av1). */
                class VideoCodec
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val H264 = of("h264")

                        @JvmField val VP9 = of("vp9")

                        @JvmField val AV1 = of("av1")

                        @JvmStatic fun of(value: String) = VideoCodec(JsonField.of(value))
                    }

                    /** An enum containing [VideoCodec]'s known values. */
                    enum class Known {
                        H264,
                        VP9,
                        AV1,
                    }

                    /**
                     * An enum containing [VideoCodec]'s known values, as well as an [_UNKNOWN]
                     * member.
                     *
                     * An instance of [VideoCodec] can contain an unknown value in a couple of
                     * cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        H264,
                        VP9,
                        AV1,
                        /**
                         * An enum member indicating that [VideoCodec] was instantiated with an
                         * unknown value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            H264 -> Value.H264
                            VP9 -> Value.VP9
                            AV1 -> Value.AV1
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value is a not
                     *   a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            H264 -> Known.H264
                            VP9 -> Known.VP9
                            AV1 -> Known.AV1
                            else -> throw ImageKitInvalidDataException("Unknown VideoCodec: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            ImageKitInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): VideoCodec = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is VideoCodec && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Options &&
                        audioCodec == other.audioCodec &&
                        autoRotate == other.autoRotate &&
                        format == other.format &&
                        quality == other.quality &&
                        streamProtocol == other.streamProtocol &&
                        variants == other.variants &&
                        videoCodec == other.videoCodec &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        audioCodec,
                        autoRotate,
                        format,
                        quality,
                        streamProtocol,
                        variants,
                        videoCodec,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Options{audioCodec=$audioCodec, autoRotate=$autoRotate, format=$format, quality=$quality, streamProtocol=$streamProtocol, variants=$variants, videoCodec=$videoCodec, additionalProperties=$additionalProperties}"
            }

            /** Information about the transformed output video. */
            class Output
            private constructor(
                private val url: JsonField<String>,
                private val videoMetadata: JsonField<VideoMetadata>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("video_metadata")
                    @ExcludeMissing
                    videoMetadata: JsonField<VideoMetadata> = JsonMissing.of(),
                ) : this(url, videoMetadata, mutableMapOf())

                /**
                 * URL to access the transformed video.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun url(): String = url.getRequired("url")

                /**
                 * Metadata of the output video file.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun videoMetadata(): Optional<VideoMetadata> =
                    videoMetadata.getOptional("video_metadata")

                /**
                 * Returns the raw JSON value of [url].
                 *
                 * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                /**
                 * Returns the raw JSON value of [videoMetadata].
                 *
                 * Unlike [videoMetadata], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("video_metadata")
                @ExcludeMissing
                fun _videoMetadata(): JsonField<VideoMetadata> = videoMetadata

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
                    private var videoMetadata: JsonField<VideoMetadata> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(output: Output) = apply {
                        url = output.url
                        videoMetadata = output.videoMetadata
                        additionalProperties = output.additionalProperties.toMutableMap()
                    }

                    /** URL to access the transformed video. */
                    fun url(url: String) = url(JsonField.of(url))

                    /**
                     * Sets [Builder.url] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.url] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun url(url: JsonField<String>) = apply { this.url = url }

                    /** Metadata of the output video file. */
                    fun videoMetadata(videoMetadata: VideoMetadata) =
                        videoMetadata(JsonField.of(videoMetadata))

                    /**
                     * Sets [Builder.videoMetadata] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.videoMetadata] with a well-typed
                     * [VideoMetadata] value instead. This method is primarily for setting the field
                     * to an undocumented or not yet supported value.
                     */
                    fun videoMetadata(videoMetadata: JsonField<VideoMetadata>) = apply {
                        this.videoMetadata = videoMetadata
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
                            videoMetadata,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Output = apply {
                    if (validated) {
                        return@apply
                    }

                    url()
                    videoMetadata().ifPresent { it.validate() }
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
                        (videoMetadata.asKnown().getOrNull()?.validity() ?: 0)

                /** Metadata of the output video file. */
                class VideoMetadata
                private constructor(
                    private val bitrate: JsonField<Long>,
                    private val duration: JsonField<Double>,
                    private val height: JsonField<Long>,
                    private val width: JsonField<Long>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("bitrate")
                        @ExcludeMissing
                        bitrate: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("duration")
                        @ExcludeMissing
                        duration: JsonField<Double> = JsonMissing.of(),
                        @JsonProperty("height")
                        @ExcludeMissing
                        height: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("width")
                        @ExcludeMissing
                        width: JsonField<Long> = JsonMissing.of(),
                    ) : this(bitrate, duration, height, width, mutableMapOf())

                    /**
                     * Bitrate of the output video in bits per second.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun bitrate(): Long = bitrate.getRequired("bitrate")

                    /**
                     * Duration of the output video in seconds.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun duration(): Double = duration.getRequired("duration")

                    /**
                     * Height of the output video in pixels.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun height(): Long = height.getRequired("height")

                    /**
                     * Width of the output video in pixels.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun width(): Long = width.getRequired("width")

                    /**
                     * Returns the raw JSON value of [bitrate].
                     *
                     * Unlike [bitrate], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("bitrate")
                    @ExcludeMissing
                    fun _bitrate(): JsonField<Long> = bitrate

                    /**
                     * Returns the raw JSON value of [duration].
                     *
                     * Unlike [duration], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("duration")
                    @ExcludeMissing
                    fun _duration(): JsonField<Double> = duration

                    /**
                     * Returns the raw JSON value of [height].
                     *
                     * Unlike [height], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

                    /**
                     * Returns the raw JSON value of [width].
                     *
                     * Unlike [width], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("width") @ExcludeMissing fun _width(): JsonField<Long> = width

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
                         * [VideoMetadata].
                         *
                         * The following fields are required:
                         * ```java
                         * .bitrate()
                         * .duration()
                         * .height()
                         * .width()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [VideoMetadata]. */
                    class Builder internal constructor() {

                        private var bitrate: JsonField<Long>? = null
                        private var duration: JsonField<Double>? = null
                        private var height: JsonField<Long>? = null
                        private var width: JsonField<Long>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(videoMetadata: VideoMetadata) = apply {
                            bitrate = videoMetadata.bitrate
                            duration = videoMetadata.duration
                            height = videoMetadata.height
                            width = videoMetadata.width
                            additionalProperties = videoMetadata.additionalProperties.toMutableMap()
                        }

                        /** Bitrate of the output video in bits per second. */
                        fun bitrate(bitrate: Long) = bitrate(JsonField.of(bitrate))

                        /**
                         * Sets [Builder.bitrate] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.bitrate] with a well-typed [Long] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun bitrate(bitrate: JsonField<Long>) = apply { this.bitrate = bitrate }

                        /** Duration of the output video in seconds. */
                        fun duration(duration: Double) = duration(JsonField.of(duration))

                        /**
                         * Sets [Builder.duration] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.duration] with a well-typed [Double]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun duration(duration: JsonField<Double>) = apply {
                            this.duration = duration
                        }

                        /** Height of the output video in pixels. */
                        fun height(height: Long) = height(JsonField.of(height))

                        /**
                         * Sets [Builder.height] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.height] with a well-typed [Long] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun height(height: JsonField<Long>) = apply { this.height = height }

                        /** Width of the output video in pixels. */
                        fun width(width: Long) = width(JsonField.of(width))

                        /**
                         * Sets [Builder.width] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.width] with a well-typed [Long] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun width(width: JsonField<Long>) = apply { this.width = width }

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
                         * Returns an immutable instance of [VideoMetadata].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .bitrate()
                         * .duration()
                         * .height()
                         * .width()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): VideoMetadata =
                            VideoMetadata(
                                checkRequired("bitrate", bitrate),
                                checkRequired("duration", duration),
                                checkRequired("height", height),
                                checkRequired("width", width),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): VideoMetadata = apply {
                        if (validated) {
                            return@apply
                        }

                        bitrate()
                        duration()
                        height()
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
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    @JvmSynthetic
                    internal fun validity(): Int =
                        (if (bitrate.asKnown().isPresent) 1 else 0) +
                            (if (duration.asKnown().isPresent) 1 else 0) +
                            (if (height.asKnown().isPresent) 1 else 0) +
                            (if (width.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is VideoMetadata &&
                            bitrate == other.bitrate &&
                            duration == other.duration &&
                            height == other.height &&
                            width == other.width &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(bitrate, duration, height, width, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "VideoMetadata{bitrate=$bitrate, duration=$duration, height=$height, width=$width, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Output &&
                        url == other.url &&
                        videoMetadata == other.videoMetadata &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(url, videoMetadata, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Output{url=$url, videoMetadata=$videoMetadata, additionalProperties=$additionalProperties}"
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

    /** Information about the original request that triggered the video transformation. */
    class Request
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
    private constructor(
        private val downloadDuration: JsonField<Long>,
        private val encodingDuration: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("download_duration")
            @ExcludeMissing
            downloadDuration: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("encoding_duration")
            @ExcludeMissing
            encodingDuration: JsonField<Long> = JsonMissing.of(),
        ) : this(downloadDuration, encodingDuration, mutableMapOf())

        /**
         * Time spent downloading the source video from your origin or media library, in
         * milliseconds.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun downloadDuration(): Optional<Long> = downloadDuration.getOptional("download_duration")

        /**
         * Time spent encoding the video, in milliseconds.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun encodingDuration(): Optional<Long> = encodingDuration.getOptional("encoding_duration")

        /**
         * Returns the raw JSON value of [downloadDuration].
         *
         * Unlike [downloadDuration], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("download_duration")
        @ExcludeMissing
        fun _downloadDuration(): JsonField<Long> = downloadDuration

        /**
         * Returns the raw JSON value of [encodingDuration].
         *
         * Unlike [encodingDuration], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("encoding_duration")
        @ExcludeMissing
        fun _encodingDuration(): JsonField<Long> = encodingDuration

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

            private var downloadDuration: JsonField<Long> = JsonMissing.of()
            private var encodingDuration: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(timings: Timings) = apply {
                downloadDuration = timings.downloadDuration
                encodingDuration = timings.encodingDuration
                additionalProperties = timings.additionalProperties.toMutableMap()
            }

            /**
             * Time spent downloading the source video from your origin or media library, in
             * milliseconds.
             */
            fun downloadDuration(downloadDuration: Long) =
                downloadDuration(JsonField.of(downloadDuration))

            /**
             * Sets [Builder.downloadDuration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.downloadDuration] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun downloadDuration(downloadDuration: JsonField<Long>) = apply {
                this.downloadDuration = downloadDuration
            }

            /** Time spent encoding the video, in milliseconds. */
            fun encodingDuration(encodingDuration: Long) =
                encodingDuration(JsonField.of(encodingDuration))

            /**
             * Sets [Builder.encodingDuration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.encodingDuration] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun encodingDuration(encodingDuration: JsonField<Long>) = apply {
                this.encodingDuration = encodingDuration
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
                Timings(downloadDuration, encodingDuration, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Timings = apply {
            if (validated) {
                return@apply
            }

            downloadDuration()
            encodingDuration()
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
            (if (downloadDuration.asKnown().isPresent) 1 else 0) +
                (if (encodingDuration.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Timings &&
                downloadDuration == other.downloadDuration &&
                encodingDuration == other.encodingDuration &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(downloadDuration, encodingDuration, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Timings{downloadDuration=$downloadDuration, encodingDuration=$encodingDuration, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VideoTransformationReadyEvent &&
            id == other.id &&
            type == other.type &&
            createdAt == other.createdAt &&
            data == other.data &&
            request == other.request &&
            timings == other.timings &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, type, createdAt, data, request, timings, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VideoTransformationReadyEvent{id=$id, type=$type, createdAt=$createdAt, data=$data, request=$request, timings=$timings, additionalProperties=$additionalProperties}"
}
