// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.urlendpoints

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
import com.imagekit.api.core.Params
import com.imagekit.api.core.allMaxBy
import com.imagekit.api.core.checkKnown
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.core.http.Headers
import com.imagekit.api.core.http.QueryParams
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * **Note:** This API is currently in beta. Creates a new URL‑endpoint and returns the resulting
 * object.
 */
class UrlEndpointCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Description of the URL endpoint.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun description(): String = body.description()

    /**
     * Ordered list of origin IDs to try when the file isn’t in the Media Library; ImageKit checks
     * them in the sequence provided. Origin must be created before it can be used in a URL
     * endpoint.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun origins(): Optional<List<String>> = body.origins()

    /**
     * Path segment appended to your base URL to form the endpoint (letters, digits, and hyphens
     * only — or empty for the default endpoint).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun urlPrefix(): Optional<String> = body.urlPrefix()

    /**
     * Configuration for third-party URL rewriting.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun urlRewriter(): Optional<UrlRewriter> = body.urlRewriter()

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _description(): JsonField<String> = body._description()

    /**
     * Returns the raw JSON value of [origins].
     *
     * Unlike [origins], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _origins(): JsonField<List<String>> = body._origins()

    /**
     * Returns the raw JSON value of [urlPrefix].
     *
     * Unlike [urlPrefix], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _urlPrefix(): JsonField<String> = body._urlPrefix()

    /**
     * Returns the raw JSON value of [urlRewriter].
     *
     * Unlike [urlRewriter], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _urlRewriter(): JsonField<UrlRewriter> = body._urlRewriter()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UrlEndpointCreateParams].
         *
         * The following fields are required:
         * ```java
         * .description()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UrlEndpointCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(urlEndpointCreateParams: UrlEndpointCreateParams) = apply {
            body = urlEndpointCreateParams.body.toBuilder()
            additionalHeaders = urlEndpointCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = urlEndpointCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [description]
         * - [origins]
         * - [urlPrefix]
         * - [urlRewriter]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Description of the URL endpoint. */
        fun description(description: String) = apply { body.description(description) }

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { body.description(description) }

        /**
         * Ordered list of origin IDs to try when the file isn’t in the Media Library; ImageKit
         * checks them in the sequence provided. Origin must be created before it can be used in a
         * URL endpoint.
         */
        fun origins(origins: List<String>) = apply { body.origins(origins) }

        /**
         * Sets [Builder.origins] to an arbitrary JSON value.
         *
         * You should usually call [Builder.origins] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun origins(origins: JsonField<List<String>>) = apply { body.origins(origins) }

        /**
         * Adds a single [String] to [origins].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addOrigin(origin: String) = apply { body.addOrigin(origin) }

        /**
         * Path segment appended to your base URL to form the endpoint (letters, digits, and hyphens
         * only — or empty for the default endpoint).
         */
        fun urlPrefix(urlPrefix: String) = apply { body.urlPrefix(urlPrefix) }

        /**
         * Sets [Builder.urlPrefix] to an arbitrary JSON value.
         *
         * You should usually call [Builder.urlPrefix] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun urlPrefix(urlPrefix: JsonField<String>) = apply { body.urlPrefix(urlPrefix) }

        /** Configuration for third-party URL rewriting. */
        fun urlRewriter(urlRewriter: UrlRewriter) = apply { body.urlRewriter(urlRewriter) }

        /**
         * Sets [Builder.urlRewriter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.urlRewriter] with a well-typed [UrlRewriter] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun urlRewriter(urlRewriter: JsonField<UrlRewriter>) = apply {
            body.urlRewriter(urlRewriter)
        }

        /** Alias for calling [urlRewriter] with `UrlRewriter.ofCloudinary(cloudinary)`. */
        fun urlRewriter(cloudinary: UrlRewriter.CloudinaryUrlRewriter) = apply {
            body.urlRewriter(cloudinary)
        }

        /** Alias for calling [urlRewriter] with `UrlRewriter.ofImgix(imgix)`. */
        fun urlRewriter(imgix: UrlRewriter.ImgixUrlRewriter) = apply { body.urlRewriter(imgix) }

        /** Alias for calling [urlRewriter] with `UrlRewriter.ofAkamai(akamai)`. */
        fun urlRewriter(akamai: UrlRewriter.AkamaiUrlRewriter) = apply { body.urlRewriter(akamai) }

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
         * Returns an immutable instance of [UrlEndpointCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .description()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UrlEndpointCreateParams =
            UrlEndpointCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Schema for URL endpoint resource. */
    class Body
    private constructor(
        private val description: JsonField<String>,
        private val origins: JsonField<List<String>>,
        private val urlPrefix: JsonField<String>,
        private val urlRewriter: JsonField<UrlRewriter>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("origins")
            @ExcludeMissing
            origins: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("urlPrefix")
            @ExcludeMissing
            urlPrefix: JsonField<String> = JsonMissing.of(),
            @JsonProperty("urlRewriter")
            @ExcludeMissing
            urlRewriter: JsonField<UrlRewriter> = JsonMissing.of(),
        ) : this(description, origins, urlPrefix, urlRewriter, mutableMapOf())

        /**
         * Description of the URL endpoint.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun description(): String = description.getRequired("description")

        /**
         * Ordered list of origin IDs to try when the file isn’t in the Media Library; ImageKit
         * checks them in the sequence provided. Origin must be created before it can be used in a
         * URL endpoint.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun origins(): Optional<List<String>> = origins.getOptional("origins")

        /**
         * Path segment appended to your base URL to form the endpoint (letters, digits, and hyphens
         * only — or empty for the default endpoint).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun urlPrefix(): Optional<String> = urlPrefix.getOptional("urlPrefix")

        /**
         * Configuration for third-party URL rewriting.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun urlRewriter(): Optional<UrlRewriter> = urlRewriter.getOptional("urlRewriter")

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [origins].
         *
         * Unlike [origins], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("origins") @ExcludeMissing fun _origins(): JsonField<List<String>> = origins

        /**
         * Returns the raw JSON value of [urlPrefix].
         *
         * Unlike [urlPrefix], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("urlPrefix") @ExcludeMissing fun _urlPrefix(): JsonField<String> = urlPrefix

        /**
         * Returns the raw JSON value of [urlRewriter].
         *
         * Unlike [urlRewriter], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("urlRewriter")
        @ExcludeMissing
        fun _urlRewriter(): JsonField<UrlRewriter> = urlRewriter

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
             * .description()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var description: JsonField<String>? = null
            private var origins: JsonField<MutableList<String>>? = null
            private var urlPrefix: JsonField<String> = JsonMissing.of()
            private var urlRewriter: JsonField<UrlRewriter> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                description = body.description
                origins = body.origins.map { it.toMutableList() }
                urlPrefix = body.urlPrefix
                urlRewriter = body.urlRewriter
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Description of the URL endpoint. */
            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /**
             * Ordered list of origin IDs to try when the file isn’t in the Media Library; ImageKit
             * checks them in the sequence provided. Origin must be created before it can be used in
             * a URL endpoint.
             */
            fun origins(origins: List<String>) = origins(JsonField.of(origins))

            /**
             * Sets [Builder.origins] to an arbitrary JSON value.
             *
             * You should usually call [Builder.origins] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun origins(origins: JsonField<List<String>>) = apply {
                this.origins = origins.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [origins].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addOrigin(origin: String) = apply {
                origins =
                    (origins ?: JsonField.of(mutableListOf())).also {
                        checkKnown("origins", it).add(origin)
                    }
            }

            /**
             * Path segment appended to your base URL to form the endpoint (letters, digits, and
             * hyphens only — or empty for the default endpoint).
             */
            fun urlPrefix(urlPrefix: String) = urlPrefix(JsonField.of(urlPrefix))

            /**
             * Sets [Builder.urlPrefix] to an arbitrary JSON value.
             *
             * You should usually call [Builder.urlPrefix] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun urlPrefix(urlPrefix: JsonField<String>) = apply { this.urlPrefix = urlPrefix }

            /** Configuration for third-party URL rewriting. */
            fun urlRewriter(urlRewriter: UrlRewriter) = urlRewriter(JsonField.of(urlRewriter))

            /**
             * Sets [Builder.urlRewriter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.urlRewriter] with a well-typed [UrlRewriter] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun urlRewriter(urlRewriter: JsonField<UrlRewriter>) = apply {
                this.urlRewriter = urlRewriter
            }

            /** Alias for calling [urlRewriter] with `UrlRewriter.ofCloudinary(cloudinary)`. */
            fun urlRewriter(cloudinary: UrlRewriter.CloudinaryUrlRewriter) =
                urlRewriter(UrlRewriter.ofCloudinary(cloudinary))

            /** Alias for calling [urlRewriter] with `UrlRewriter.ofImgix(imgix)`. */
            fun urlRewriter(imgix: UrlRewriter.ImgixUrlRewriter) =
                urlRewriter(UrlRewriter.ofImgix(imgix))

            /** Alias for calling [urlRewriter] with `UrlRewriter.ofAkamai(akamai)`. */
            fun urlRewriter(akamai: UrlRewriter.AkamaiUrlRewriter) =
                urlRewriter(UrlRewriter.ofAkamai(akamai))

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
             * .description()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("description", description),
                    (origins ?: JsonMissing.of()).map { it.toImmutable() },
                    urlPrefix,
                    urlRewriter,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            description()
            origins()
            urlPrefix()
            urlRewriter().ifPresent { it.validate() }
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
            (if (description.asKnown().isPresent) 1 else 0) +
                (origins.asKnown().getOrNull()?.size ?: 0) +
                (if (urlPrefix.asKnown().isPresent) 1 else 0) +
                (urlRewriter.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                description == other.description &&
                origins == other.origins &&
                urlPrefix == other.urlPrefix &&
                urlRewriter == other.urlRewriter &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(description, origins, urlPrefix, urlRewriter, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{description=$description, origins=$origins, urlPrefix=$urlPrefix, urlRewriter=$urlRewriter, additionalProperties=$additionalProperties}"
    }

    /** Configuration for third-party URL rewriting. */
    @JsonDeserialize(using = UrlRewriter.Deserializer::class)
    @JsonSerialize(using = UrlRewriter.Serializer::class)
    class UrlRewriter
    private constructor(
        private val cloudinary: CloudinaryUrlRewriter? = null,
        private val imgix: ImgixUrlRewriter? = null,
        private val akamai: AkamaiUrlRewriter? = null,
        private val _json: JsonValue? = null,
    ) {

        fun cloudinary(): Optional<CloudinaryUrlRewriter> = Optional.ofNullable(cloudinary)

        fun imgix(): Optional<ImgixUrlRewriter> = Optional.ofNullable(imgix)

        fun akamai(): Optional<AkamaiUrlRewriter> = Optional.ofNullable(akamai)

        fun isCloudinary(): Boolean = cloudinary != null

        fun isImgix(): Boolean = imgix != null

        fun isAkamai(): Boolean = akamai != null

        fun asCloudinary(): CloudinaryUrlRewriter = cloudinary.getOrThrow("cloudinary")

        fun asImgix(): ImgixUrlRewriter = imgix.getOrThrow("imgix")

        fun asAkamai(): AkamaiUrlRewriter = akamai.getOrThrow("akamai")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                cloudinary != null -> visitor.visitCloudinary(cloudinary)
                imgix != null -> visitor.visitImgix(imgix)
                akamai != null -> visitor.visitAkamai(akamai)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): UrlRewriter = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitCloudinary(cloudinary: CloudinaryUrlRewriter) {
                        cloudinary.validate()
                    }

                    override fun visitImgix(imgix: ImgixUrlRewriter) {
                        imgix.validate()
                    }

                    override fun visitAkamai(akamai: AkamaiUrlRewriter) {
                        akamai.validate()
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
                    override fun visitCloudinary(cloudinary: CloudinaryUrlRewriter) =
                        cloudinary.validity()

                    override fun visitImgix(imgix: ImgixUrlRewriter) = imgix.validity()

                    override fun visitAkamai(akamai: AkamaiUrlRewriter) = akamai.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UrlRewriter &&
                cloudinary == other.cloudinary &&
                imgix == other.imgix &&
                akamai == other.akamai
        }

        override fun hashCode(): Int = Objects.hash(cloudinary, imgix, akamai)

        override fun toString(): String =
            when {
                cloudinary != null -> "UrlRewriter{cloudinary=$cloudinary}"
                imgix != null -> "UrlRewriter{imgix=$imgix}"
                akamai != null -> "UrlRewriter{akamai=$akamai}"
                _json != null -> "UrlRewriter{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid UrlRewriter")
            }

        companion object {

            @JvmStatic
            fun ofCloudinary(cloudinary: CloudinaryUrlRewriter) =
                UrlRewriter(cloudinary = cloudinary)

            @JvmStatic fun ofImgix(imgix: ImgixUrlRewriter) = UrlRewriter(imgix = imgix)

            @JvmStatic fun ofAkamai(akamai: AkamaiUrlRewriter) = UrlRewriter(akamai = akamai)
        }

        /**
         * An interface that defines how to map each variant of [UrlRewriter] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitCloudinary(cloudinary: CloudinaryUrlRewriter): T

            fun visitImgix(imgix: ImgixUrlRewriter): T

            fun visitAkamai(akamai: AkamaiUrlRewriter): T

            /**
             * Maps an unknown variant of [UrlRewriter] to a value of type [T].
             *
             * An instance of [UrlRewriter] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown UrlRewriter: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<UrlRewriter>(UrlRewriter::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): UrlRewriter {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<CloudinaryUrlRewriter>())?.let {
                                UrlRewriter(cloudinary = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ImgixUrlRewriter>())?.let {
                                UrlRewriter(imgix = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<AkamaiUrlRewriter>())?.let {
                                UrlRewriter(akamai = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> UrlRewriter(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<UrlRewriter>(UrlRewriter::class) {

            override fun serialize(
                value: UrlRewriter,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.cloudinary != null -> generator.writeObject(value.cloudinary)
                    value.imgix != null -> generator.writeObject(value.imgix)
                    value.akamai != null -> generator.writeObject(value.akamai)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid UrlRewriter")
                }
            }
        }

        class CloudinaryUrlRewriter
        private constructor(
            private val type: JsonField<Type>,
            private val preserveAssetDeliveryTypes: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("preserveAssetDeliveryTypes")
                @ExcludeMissing
                preserveAssetDeliveryTypes: JsonField<Boolean> = JsonMissing.of(),
            ) : this(type, preserveAssetDeliveryTypes, mutableMapOf())

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Whether to preserve `<asset_type>/<delivery_type>` in the rewritten URL.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun preserveAssetDeliveryTypes(): Optional<Boolean> =
                preserveAssetDeliveryTypes.getOptional("preserveAssetDeliveryTypes")

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [preserveAssetDeliveryTypes].
             *
             * Unlike [preserveAssetDeliveryTypes], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("preserveAssetDeliveryTypes")
            @ExcludeMissing
            fun _preserveAssetDeliveryTypes(): JsonField<Boolean> = preserveAssetDeliveryTypes

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
                 * [CloudinaryUrlRewriter].
                 *
                 * The following fields are required:
                 * ```java
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CloudinaryUrlRewriter]. */
            class Builder internal constructor() {

                private var type: JsonField<Type>? = null
                private var preserveAssetDeliveryTypes: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(cloudinaryUrlRewriter: CloudinaryUrlRewriter) = apply {
                    type = cloudinaryUrlRewriter.type
                    preserveAssetDeliveryTypes = cloudinaryUrlRewriter.preserveAssetDeliveryTypes
                    additionalProperties = cloudinaryUrlRewriter.additionalProperties.toMutableMap()
                }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** Whether to preserve `<asset_type>/<delivery_type>` in the rewritten URL. */
                fun preserveAssetDeliveryTypes(preserveAssetDeliveryTypes: Boolean) =
                    preserveAssetDeliveryTypes(JsonField.of(preserveAssetDeliveryTypes))

                /**
                 * Sets [Builder.preserveAssetDeliveryTypes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.preserveAssetDeliveryTypes] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun preserveAssetDeliveryTypes(preserveAssetDeliveryTypes: JsonField<Boolean>) =
                    apply {
                        this.preserveAssetDeliveryTypes = preserveAssetDeliveryTypes
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
                 * Returns an immutable instance of [CloudinaryUrlRewriter].
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
                fun build(): CloudinaryUrlRewriter =
                    CloudinaryUrlRewriter(
                        checkRequired("type", type),
                        preserveAssetDeliveryTypes,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): CloudinaryUrlRewriter = apply {
                if (validated) {
                    return@apply
                }

                type().validate()
                preserveAssetDeliveryTypes()
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
                    (if (preserveAssetDeliveryTypes.asKnown().isPresent) 1 else 0)

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

                    @JvmField val CLOUDINARY = of("CLOUDINARY")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    CLOUDINARY
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
                    CLOUDINARY,
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
                        CLOUDINARY -> Value.CLOUDINARY
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
                        CLOUDINARY -> Known.CLOUDINARY
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

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CloudinaryUrlRewriter &&
                    type == other.type &&
                    preserveAssetDeliveryTypes == other.preserveAssetDeliveryTypes &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(type, preserveAssetDeliveryTypes, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CloudinaryUrlRewriter{type=$type, preserveAssetDeliveryTypes=$preserveAssetDeliveryTypes, additionalProperties=$additionalProperties}"
        }

        class ImgixUrlRewriter
        private constructor(
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of()
            ) : this(type, mutableMapOf())

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                 * Returns a mutable builder for constructing an instance of [ImgixUrlRewriter].
                 *
                 * The following fields are required:
                 * ```java
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ImgixUrlRewriter]. */
            class Builder internal constructor() {

                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(imgixUrlRewriter: ImgixUrlRewriter) = apply {
                    type = imgixUrlRewriter.type
                    additionalProperties = imgixUrlRewriter.additionalProperties.toMutableMap()
                }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

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
                 * Returns an immutable instance of [ImgixUrlRewriter].
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
                fun build(): ImgixUrlRewriter =
                    ImgixUrlRewriter(
                        checkRequired("type", type),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ImgixUrlRewriter = apply {
                if (validated) {
                    return@apply
                }

                type().validate()
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
            internal fun validity(): Int = (type.asKnown().getOrNull()?.validity() ?: 0)

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

                    @JvmField val IMGIX = of("IMGIX")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    IMGIX
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
                    IMGIX,
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
                        IMGIX -> Value.IMGIX
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
                        IMGIX -> Known.IMGIX
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

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ImgixUrlRewriter &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ImgixUrlRewriter{type=$type, additionalProperties=$additionalProperties}"
        }

        class AkamaiUrlRewriter
        private constructor(
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of()
            ) : this(type, mutableMapOf())

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                 * Returns a mutable builder for constructing an instance of [AkamaiUrlRewriter].
                 *
                 * The following fields are required:
                 * ```java
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [AkamaiUrlRewriter]. */
            class Builder internal constructor() {

                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(akamaiUrlRewriter: AkamaiUrlRewriter) = apply {
                    type = akamaiUrlRewriter.type
                    additionalProperties = akamaiUrlRewriter.additionalProperties.toMutableMap()
                }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

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
                 * Returns an immutable instance of [AkamaiUrlRewriter].
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
                fun build(): AkamaiUrlRewriter =
                    AkamaiUrlRewriter(
                        checkRequired("type", type),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): AkamaiUrlRewriter = apply {
                if (validated) {
                    return@apply
                }

                type().validate()
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
            internal fun validity(): Int = (type.asKnown().getOrNull()?.validity() ?: 0)

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

                    @JvmField val AKAMAI = of("AKAMAI")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    AKAMAI
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
                    AKAMAI,
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
                        AKAMAI -> Value.AKAMAI
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
                        AKAMAI -> Known.AKAMAI
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

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is AkamaiUrlRewriter &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "AkamaiUrlRewriter{type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UrlEndpointCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "UrlEndpointCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
