// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.origins

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
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.core.http.Headers
import com.imagekit.api.core.http.QueryParams
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** **Note:** This API is currently in beta. Creates a new origin and returns the origin object. */
class OriginCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Schema for origin resources. */
    fun body(): Body = body

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [OriginCreateParams].
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OriginCreateParams]. */
    class Builder internal constructor() {

        private var body: Body? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(originCreateParams: OriginCreateParams) = apply {
            body = originCreateParams.body
            additionalHeaders = originCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = originCreateParams.additionalQueryParams.toBuilder()
        }

        /** Schema for origin resources. */
        fun body(body: Body) = apply { this.body = body }

        /** Alias for calling [body] with `Body.ofS3Origin(s3Origin)`. */
        fun body(s3Origin: Body.S3Origin) = body(Body.ofS3Origin(s3Origin))

        /** Alias for calling [body] with `Body.ofS3CompatibleOrigin(s3CompatibleOrigin)`. */
        fun body(s3CompatibleOrigin: Body.S3CompatibleOrigin) =
            body(Body.ofS3CompatibleOrigin(s3CompatibleOrigin))

        /**
         * Alias for calling [body] with `Body.ofCloudinaryBackupOrigin(cloudinaryBackupOrigin)`.
         */
        fun body(cloudinaryBackupOrigin: Body.CloudinaryBackupOrigin) =
            body(Body.ofCloudinaryBackupOrigin(cloudinaryBackupOrigin))

        /** Alias for calling [body] with `Body.ofWebFolderOrigin(webFolderOrigin)`. */
        fun body(webFolderOrigin: Body.WebFolderOrigin) =
            body(Body.ofWebFolderOrigin(webFolderOrigin))

        /** Alias for calling [body] with `Body.ofWebProxyOrigin(webProxyOrigin)`. */
        fun body(webProxyOrigin: Body.WebProxyOrigin) = body(Body.ofWebProxyOrigin(webProxyOrigin))

        /** Alias for calling [body] with `Body.ofGcsOrigin(gcsOrigin)`. */
        fun body(gcsOrigin: Body.GcsOrigin) = body(Body.ofGcsOrigin(gcsOrigin))

        /** Alias for calling [body] with `Body.ofAzureBlobOrigin(azureBlobOrigin)`. */
        fun body(azureBlobOrigin: Body.AzureBlobOrigin) =
            body(Body.ofAzureBlobOrigin(azureBlobOrigin))

        /** Alias for calling [body] with `Body.ofAkeneoPimOrigin(akeneoPimOrigin)`. */
        fun body(akeneoPimOrigin: Body.AkeneoPimOrigin) =
            body(Body.ofAkeneoPimOrigin(akeneoPimOrigin))

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
         * Returns an immutable instance of [OriginCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OriginCreateParams =
            OriginCreateParams(
                checkRequired("body", body),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Schema for origin resources. */
    @JsonDeserialize(using = Body.Deserializer::class)
    @JsonSerialize(using = Body.Serializer::class)
    class Body
    private constructor(
        private val s3Origin: S3Origin? = null,
        private val s3CompatibleOrigin: S3CompatibleOrigin? = null,
        private val cloudinaryBackupOrigin: CloudinaryBackupOrigin? = null,
        private val webFolderOrigin: WebFolderOrigin? = null,
        private val webProxyOrigin: WebProxyOrigin? = null,
        private val gcsOrigin: GcsOrigin? = null,
        private val azureBlobOrigin: AzureBlobOrigin? = null,
        private val akeneoPimOrigin: AkeneoPimOrigin? = null,
        private val _json: JsonValue? = null,
    ) {

        fun s3Origin(): Optional<S3Origin> = Optional.ofNullable(s3Origin)

        fun s3CompatibleOrigin(): Optional<S3CompatibleOrigin> =
            Optional.ofNullable(s3CompatibleOrigin)

        fun cloudinaryBackupOrigin(): Optional<CloudinaryBackupOrigin> =
            Optional.ofNullable(cloudinaryBackupOrigin)

        fun webFolderOrigin(): Optional<WebFolderOrigin> = Optional.ofNullable(webFolderOrigin)

        fun webProxyOrigin(): Optional<WebProxyOrigin> = Optional.ofNullable(webProxyOrigin)

        fun gcsOrigin(): Optional<GcsOrigin> = Optional.ofNullable(gcsOrigin)

        fun azureBlobOrigin(): Optional<AzureBlobOrigin> = Optional.ofNullable(azureBlobOrigin)

        fun akeneoPimOrigin(): Optional<AkeneoPimOrigin> = Optional.ofNullable(akeneoPimOrigin)

        fun isS3Origin(): Boolean = s3Origin != null

        fun isS3CompatibleOrigin(): Boolean = s3CompatibleOrigin != null

        fun isCloudinaryBackupOrigin(): Boolean = cloudinaryBackupOrigin != null

        fun isWebFolderOrigin(): Boolean = webFolderOrigin != null

        fun isWebProxyOrigin(): Boolean = webProxyOrigin != null

        fun isGcsOrigin(): Boolean = gcsOrigin != null

        fun isAzureBlobOrigin(): Boolean = azureBlobOrigin != null

        fun isAkeneoPimOrigin(): Boolean = akeneoPimOrigin != null

        fun asS3Origin(): S3Origin = s3Origin.getOrThrow("s3Origin")

        fun asS3CompatibleOrigin(): S3CompatibleOrigin =
            s3CompatibleOrigin.getOrThrow("s3CompatibleOrigin")

        fun asCloudinaryBackupOrigin(): CloudinaryBackupOrigin =
            cloudinaryBackupOrigin.getOrThrow("cloudinaryBackupOrigin")

        fun asWebFolderOrigin(): WebFolderOrigin = webFolderOrigin.getOrThrow("webFolderOrigin")

        fun asWebProxyOrigin(): WebProxyOrigin = webProxyOrigin.getOrThrow("webProxyOrigin")

        fun asGcsOrigin(): GcsOrigin = gcsOrigin.getOrThrow("gcsOrigin")

        fun asAzureBlobOrigin(): AzureBlobOrigin = azureBlobOrigin.getOrThrow("azureBlobOrigin")

        fun asAkeneoPimOrigin(): AkeneoPimOrigin = akeneoPimOrigin.getOrThrow("akeneoPimOrigin")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                s3Origin != null -> visitor.visitS3Origin(s3Origin)
                s3CompatibleOrigin != null -> visitor.visitS3CompatibleOrigin(s3CompatibleOrigin)
                cloudinaryBackupOrigin != null ->
                    visitor.visitCloudinaryBackupOrigin(cloudinaryBackupOrigin)
                webFolderOrigin != null -> visitor.visitWebFolderOrigin(webFolderOrigin)
                webProxyOrigin != null -> visitor.visitWebProxyOrigin(webProxyOrigin)
                gcsOrigin != null -> visitor.visitGcsOrigin(gcsOrigin)
                azureBlobOrigin != null -> visitor.visitAzureBlobOrigin(azureBlobOrigin)
                akeneoPimOrigin != null -> visitor.visitAkeneoPimOrigin(akeneoPimOrigin)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitS3Origin(s3Origin: S3Origin) {
                        s3Origin.validate()
                    }

                    override fun visitS3CompatibleOrigin(s3CompatibleOrigin: S3CompatibleOrigin) {
                        s3CompatibleOrigin.validate()
                    }

                    override fun visitCloudinaryBackupOrigin(
                        cloudinaryBackupOrigin: CloudinaryBackupOrigin
                    ) {
                        cloudinaryBackupOrigin.validate()
                    }

                    override fun visitWebFolderOrigin(webFolderOrigin: WebFolderOrigin) {
                        webFolderOrigin.validate()
                    }

                    override fun visitWebProxyOrigin(webProxyOrigin: WebProxyOrigin) {
                        webProxyOrigin.validate()
                    }

                    override fun visitGcsOrigin(gcsOrigin: GcsOrigin) {
                        gcsOrigin.validate()
                    }

                    override fun visitAzureBlobOrigin(azureBlobOrigin: AzureBlobOrigin) {
                        azureBlobOrigin.validate()
                    }

                    override fun visitAkeneoPimOrigin(akeneoPimOrigin: AkeneoPimOrigin) {
                        akeneoPimOrigin.validate()
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
                    override fun visitS3Origin(s3Origin: S3Origin) = s3Origin.validity()

                    override fun visitS3CompatibleOrigin(s3CompatibleOrigin: S3CompatibleOrigin) =
                        s3CompatibleOrigin.validity()

                    override fun visitCloudinaryBackupOrigin(
                        cloudinaryBackupOrigin: CloudinaryBackupOrigin
                    ) = cloudinaryBackupOrigin.validity()

                    override fun visitWebFolderOrigin(webFolderOrigin: WebFolderOrigin) =
                        webFolderOrigin.validity()

                    override fun visitWebProxyOrigin(webProxyOrigin: WebProxyOrigin) =
                        webProxyOrigin.validity()

                    override fun visitGcsOrigin(gcsOrigin: GcsOrigin) = gcsOrigin.validity()

                    override fun visitAzureBlobOrigin(azureBlobOrigin: AzureBlobOrigin) =
                        azureBlobOrigin.validity()

                    override fun visitAkeneoPimOrigin(akeneoPimOrigin: AkeneoPimOrigin) =
                        akeneoPimOrigin.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                s3Origin == other.s3Origin &&
                s3CompatibleOrigin == other.s3CompatibleOrigin &&
                cloudinaryBackupOrigin == other.cloudinaryBackupOrigin &&
                webFolderOrigin == other.webFolderOrigin &&
                webProxyOrigin == other.webProxyOrigin &&
                gcsOrigin == other.gcsOrigin &&
                azureBlobOrigin == other.azureBlobOrigin &&
                akeneoPimOrigin == other.akeneoPimOrigin
        }

        override fun hashCode(): Int =
            Objects.hash(
                s3Origin,
                s3CompatibleOrigin,
                cloudinaryBackupOrigin,
                webFolderOrigin,
                webProxyOrigin,
                gcsOrigin,
                azureBlobOrigin,
                akeneoPimOrigin,
            )

        override fun toString(): String =
            when {
                s3Origin != null -> "Body{s3Origin=$s3Origin}"
                s3CompatibleOrigin != null -> "Body{s3CompatibleOrigin=$s3CompatibleOrigin}"
                cloudinaryBackupOrigin != null ->
                    "Body{cloudinaryBackupOrigin=$cloudinaryBackupOrigin}"
                webFolderOrigin != null -> "Body{webFolderOrigin=$webFolderOrigin}"
                webProxyOrigin != null -> "Body{webProxyOrigin=$webProxyOrigin}"
                gcsOrigin != null -> "Body{gcsOrigin=$gcsOrigin}"
                azureBlobOrigin != null -> "Body{azureBlobOrigin=$azureBlobOrigin}"
                akeneoPimOrigin != null -> "Body{akeneoPimOrigin=$akeneoPimOrigin}"
                _json != null -> "Body{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Body")
            }

        companion object {

            @JvmStatic fun ofS3Origin(s3Origin: S3Origin) = Body(s3Origin = s3Origin)

            @JvmStatic
            fun ofS3CompatibleOrigin(s3CompatibleOrigin: S3CompatibleOrigin) =
                Body(s3CompatibleOrigin = s3CompatibleOrigin)

            @JvmStatic
            fun ofCloudinaryBackupOrigin(cloudinaryBackupOrigin: CloudinaryBackupOrigin) =
                Body(cloudinaryBackupOrigin = cloudinaryBackupOrigin)

            @JvmStatic
            fun ofWebFolderOrigin(webFolderOrigin: WebFolderOrigin) =
                Body(webFolderOrigin = webFolderOrigin)

            @JvmStatic
            fun ofWebProxyOrigin(webProxyOrigin: WebProxyOrigin) =
                Body(webProxyOrigin = webProxyOrigin)

            @JvmStatic fun ofGcsOrigin(gcsOrigin: GcsOrigin) = Body(gcsOrigin = gcsOrigin)

            @JvmStatic
            fun ofAzureBlobOrigin(azureBlobOrigin: AzureBlobOrigin) =
                Body(azureBlobOrigin = azureBlobOrigin)

            @JvmStatic
            fun ofAkeneoPimOrigin(akeneoPimOrigin: AkeneoPimOrigin) =
                Body(akeneoPimOrigin = akeneoPimOrigin)
        }

        /** An interface that defines how to map each variant of [Body] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitS3Origin(s3Origin: S3Origin): T

            fun visitS3CompatibleOrigin(s3CompatibleOrigin: S3CompatibleOrigin): T

            fun visitCloudinaryBackupOrigin(cloudinaryBackupOrigin: CloudinaryBackupOrigin): T

            fun visitWebFolderOrigin(webFolderOrigin: WebFolderOrigin): T

            fun visitWebProxyOrigin(webProxyOrigin: WebProxyOrigin): T

            fun visitGcsOrigin(gcsOrigin: GcsOrigin): T

            fun visitAzureBlobOrigin(azureBlobOrigin: AzureBlobOrigin): T

            fun visitAkeneoPimOrigin(akeneoPimOrigin: AkeneoPimOrigin): T

            /**
             * Maps an unknown variant of [Body] to a value of type [T].
             *
             * An instance of [Body] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Body: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Body>(Body::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Body {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {}

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<S3Origin>())?.let {
                                Body(s3Origin = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<S3CompatibleOrigin>())?.let {
                                Body(s3CompatibleOrigin = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<CloudinaryBackupOrigin>())?.let {
                                Body(cloudinaryBackupOrigin = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<WebFolderOrigin>())?.let {
                                Body(webFolderOrigin = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<WebProxyOrigin>())?.let {
                                Body(webProxyOrigin = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<GcsOrigin>())?.let {
                                Body(gcsOrigin = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<AzureBlobOrigin>())?.let {
                                Body(azureBlobOrigin = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<AkeneoPimOrigin>())?.let {
                                Body(akeneoPimOrigin = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Body(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Body>(Body::class) {

            override fun serialize(
                value: Body,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.s3Origin != null -> generator.writeObject(value.s3Origin)
                    value.s3CompatibleOrigin != null ->
                        generator.writeObject(value.s3CompatibleOrigin)
                    value.cloudinaryBackupOrigin != null ->
                        generator.writeObject(value.cloudinaryBackupOrigin)
                    value.webFolderOrigin != null -> generator.writeObject(value.webFolderOrigin)
                    value.webProxyOrigin != null -> generator.writeObject(value.webProxyOrigin)
                    value.gcsOrigin != null -> generator.writeObject(value.gcsOrigin)
                    value.azureBlobOrigin != null -> generator.writeObject(value.azureBlobOrigin)
                    value.akeneoPimOrigin != null -> generator.writeObject(value.akeneoPimOrigin)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Body")
                }
            }
        }

        class S3Origin
        private constructor(
            private val accessKey: JsonField<String>,
            private val bucket: JsonField<String>,
            private val name: JsonField<String>,
            private val secretKey: JsonField<String>,
            private val type: JsonField<Type>,
            private val baseUrlForCanonicalHeader: JsonField<String>,
            private val includeCanonicalHeader: JsonField<Boolean>,
            private val prefix: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("accessKey")
                @ExcludeMissing
                accessKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("bucket")
                @ExcludeMissing
                bucket: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("secretKey")
                @ExcludeMissing
                secretKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("baseUrlForCanonicalHeader")
                @ExcludeMissing
                baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
                @JsonProperty("includeCanonicalHeader")
                @ExcludeMissing
                includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("prefix") @ExcludeMissing prefix: JsonField<String> = JsonMissing.of(),
            ) : this(
                accessKey,
                bucket,
                name,
                secretKey,
                type,
                baseUrlForCanonicalHeader,
                includeCanonicalHeader,
                prefix,
                mutableMapOf(),
            )

            /**
             * Access key for the bucket.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun accessKey(): String = accessKey.getRequired("accessKey")

            /**
             * S3 bucket name.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bucket(): String = bucket.getRequired("bucket")

            /**
             * Display name of the origin.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Secret key for the bucket.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun secretKey(): String = secretKey.getRequired("secretKey")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * URL used in the Canonical header (if enabled).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun baseUrlForCanonicalHeader(): Optional<String> =
                baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

            /**
             * Whether to send a Canonical header.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun includeCanonicalHeader(): Optional<Boolean> =
                includeCanonicalHeader.getOptional("includeCanonicalHeader")

            /**
             * Path prefix inside the bucket.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun prefix(): Optional<String> = prefix.getOptional("prefix")

            /**
             * Returns the raw JSON value of [accessKey].
             *
             * Unlike [accessKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("accessKey")
            @ExcludeMissing
            fun _accessKey(): JsonField<String> = accessKey

            /**
             * Returns the raw JSON value of [bucket].
             *
             * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("bucket") @ExcludeMissing fun _bucket(): JsonField<String> = bucket

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [secretKey].
             *
             * Unlike [secretKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("secretKey")
            @ExcludeMissing
            fun _secretKey(): JsonField<String> = secretKey

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [baseUrlForCanonicalHeader].
             *
             * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

            /**
             * Returns the raw JSON value of [includeCanonicalHeader].
             *
             * Unlike [includeCanonicalHeader], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            fun _includeCanonicalHeader(): JsonField<Boolean> = includeCanonicalHeader

            /**
             * Returns the raw JSON value of [prefix].
             *
             * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

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
                 * Returns a mutable builder for constructing an instance of [S3Origin].
                 *
                 * The following fields are required:
                 * ```java
                 * .accessKey()
                 * .bucket()
                 * .name()
                 * .secretKey()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [S3Origin]. */
            class Builder internal constructor() {

                private var accessKey: JsonField<String>? = null
                private var bucket: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var secretKey: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
                private var includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of()
                private var prefix: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(s3Origin: S3Origin) = apply {
                    accessKey = s3Origin.accessKey
                    bucket = s3Origin.bucket
                    name = s3Origin.name
                    secretKey = s3Origin.secretKey
                    type = s3Origin.type
                    baseUrlForCanonicalHeader = s3Origin.baseUrlForCanonicalHeader
                    includeCanonicalHeader = s3Origin.includeCanonicalHeader
                    prefix = s3Origin.prefix
                    additionalProperties = s3Origin.additionalProperties.toMutableMap()
                }

                /** Access key for the bucket. */
                fun accessKey(accessKey: String) = accessKey(JsonField.of(accessKey))

                /**
                 * Sets [Builder.accessKey] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.accessKey] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun accessKey(accessKey: JsonField<String>) = apply { this.accessKey = accessKey }

                /** S3 bucket name. */
                fun bucket(bucket: String) = bucket(JsonField.of(bucket))

                /**
                 * Sets [Builder.bucket] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bucket] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bucket(bucket: JsonField<String>) = apply { this.bucket = bucket }

                /** Display name of the origin. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Secret key for the bucket. */
                fun secretKey(secretKey: String) = secretKey(JsonField.of(secretKey))

                /**
                 * Sets [Builder.secretKey] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.secretKey] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun secretKey(secretKey: JsonField<String>) = apply { this.secretKey = secretKey }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** URL used in the Canonical header (if enabled). */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: String) =
                    baseUrlForCanonicalHeader(JsonField.of(baseUrlForCanonicalHeader))

                /**
                 * Sets [Builder.baseUrlForCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.baseUrlForCanonicalHeader] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) =
                    apply {
                        this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
                    }

                /** Whether to send a Canonical header. */
                fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                    includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

                /**
                 * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.includeCanonicalHeader] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                    this.includeCanonicalHeader = includeCanonicalHeader
                }

                /** Path prefix inside the bucket. */
                fun prefix(prefix: String) = prefix(JsonField.of(prefix))

                /**
                 * Sets [Builder.prefix] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.prefix] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

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
                 * Returns an immutable instance of [S3Origin].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .accessKey()
                 * .bucket()
                 * .name()
                 * .secretKey()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): S3Origin =
                    S3Origin(
                        checkRequired("accessKey", accessKey),
                        checkRequired("bucket", bucket),
                        checkRequired("name", name),
                        checkRequired("secretKey", secretKey),
                        checkRequired("type", type),
                        baseUrlForCanonicalHeader,
                        includeCanonicalHeader,
                        prefix,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): S3Origin = apply {
                if (validated) {
                    return@apply
                }

                accessKey()
                bucket()
                name()
                secretKey()
                type().validate()
                baseUrlForCanonicalHeader()
                includeCanonicalHeader()
                prefix()
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
                (if (accessKey.asKnown().isPresent) 1 else 0) +
                    (if (bucket.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (secretKey.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (prefix.asKnown().isPresent) 1 else 0)

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

                    @JvmField val S3 = of("S3")

                    @JvmField val S3_COMPATIBLE = of("S3_COMPATIBLE")

                    @JvmField val CLOUDINARY_BACKUP = of("CLOUDINARY_BACKUP")

                    @JvmField val WEB_FOLDER = of("WEB_FOLDER")

                    @JvmField val WEB_PROXY = of("WEB_PROXY")

                    @JvmField val GCS = of("GCS")

                    @JvmField val AZURE_BLOB = of("AZURE_BLOB")

                    @JvmField val AKENEO_PIM = of("AKENEO_PIM")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    WEB_PROXY,
                    GCS,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    WEB_PROXY,
                    GCS,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                        S3 -> Value.S3
                        S3_COMPATIBLE -> Value.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Value.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Value.WEB_FOLDER
                        WEB_PROXY -> Value.WEB_PROXY
                        GCS -> Value.GCS
                        AZURE_BLOB -> Value.AZURE_BLOB
                        AKENEO_PIM -> Value.AKENEO_PIM
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
                        S3 -> Known.S3
                        S3_COMPATIBLE -> Known.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Known.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Known.WEB_FOLDER
                        WEB_PROXY -> Known.WEB_PROXY
                        GCS -> Known.GCS
                        AZURE_BLOB -> Known.AZURE_BLOB
                        AKENEO_PIM -> Known.AKENEO_PIM
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

                return other is S3Origin &&
                    accessKey == other.accessKey &&
                    bucket == other.bucket &&
                    name == other.name &&
                    secretKey == other.secretKey &&
                    type == other.type &&
                    baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                    includeCanonicalHeader == other.includeCanonicalHeader &&
                    prefix == other.prefix &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    accessKey,
                    bucket,
                    name,
                    secretKey,
                    type,
                    baseUrlForCanonicalHeader,
                    includeCanonicalHeader,
                    prefix,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "S3Origin{accessKey=$accessKey, bucket=$bucket, name=$name, secretKey=$secretKey, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, includeCanonicalHeader=$includeCanonicalHeader, prefix=$prefix, additionalProperties=$additionalProperties}"
        }

        class S3CompatibleOrigin
        private constructor(
            private val accessKey: JsonField<String>,
            private val bucket: JsonField<String>,
            private val endpoint: JsonField<String>,
            private val name: JsonField<String>,
            private val secretKey: JsonField<String>,
            private val type: JsonField<Type>,
            private val baseUrlForCanonicalHeader: JsonField<String>,
            private val includeCanonicalHeader: JsonField<Boolean>,
            private val prefix: JsonField<String>,
            private val s3ForcePathStyle: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("accessKey")
                @ExcludeMissing
                accessKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("bucket")
                @ExcludeMissing
                bucket: JsonField<String> = JsonMissing.of(),
                @JsonProperty("endpoint")
                @ExcludeMissing
                endpoint: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("secretKey")
                @ExcludeMissing
                secretKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("baseUrlForCanonicalHeader")
                @ExcludeMissing
                baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
                @JsonProperty("includeCanonicalHeader")
                @ExcludeMissing
                includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("prefix")
                @ExcludeMissing
                prefix: JsonField<String> = JsonMissing.of(),
                @JsonProperty("s3ForcePathStyle")
                @ExcludeMissing
                s3ForcePathStyle: JsonField<Boolean> = JsonMissing.of(),
            ) : this(
                accessKey,
                bucket,
                endpoint,
                name,
                secretKey,
                type,
                baseUrlForCanonicalHeader,
                includeCanonicalHeader,
                prefix,
                s3ForcePathStyle,
                mutableMapOf(),
            )

            /**
             * Access key for the bucket.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun accessKey(): String = accessKey.getRequired("accessKey")

            /**
             * S3 bucket name.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bucket(): String = bucket.getRequired("bucket")

            /**
             * Custom S3-compatible endpoint.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun endpoint(): String = endpoint.getRequired("endpoint")

            /**
             * Display name of the origin.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Secret key for the bucket.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun secretKey(): String = secretKey.getRequired("secretKey")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * URL used in the Canonical header (if enabled).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun baseUrlForCanonicalHeader(): Optional<String> =
                baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

            /**
             * Whether to send a Canonical header.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun includeCanonicalHeader(): Optional<Boolean> =
                includeCanonicalHeader.getOptional("includeCanonicalHeader")

            /**
             * Path prefix inside the bucket.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun prefix(): Optional<String> = prefix.getOptional("prefix")

            /**
             * Use path-style S3 URLs?
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun s3ForcePathStyle(): Optional<Boolean> =
                s3ForcePathStyle.getOptional("s3ForcePathStyle")

            /**
             * Returns the raw JSON value of [accessKey].
             *
             * Unlike [accessKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("accessKey")
            @ExcludeMissing
            fun _accessKey(): JsonField<String> = accessKey

            /**
             * Returns the raw JSON value of [bucket].
             *
             * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("bucket") @ExcludeMissing fun _bucket(): JsonField<String> = bucket

            /**
             * Returns the raw JSON value of [endpoint].
             *
             * Unlike [endpoint], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("endpoint") @ExcludeMissing fun _endpoint(): JsonField<String> = endpoint

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [secretKey].
             *
             * Unlike [secretKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("secretKey")
            @ExcludeMissing
            fun _secretKey(): JsonField<String> = secretKey

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [baseUrlForCanonicalHeader].
             *
             * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

            /**
             * Returns the raw JSON value of [includeCanonicalHeader].
             *
             * Unlike [includeCanonicalHeader], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            fun _includeCanonicalHeader(): JsonField<Boolean> = includeCanonicalHeader

            /**
             * Returns the raw JSON value of [prefix].
             *
             * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

            /**
             * Returns the raw JSON value of [s3ForcePathStyle].
             *
             * Unlike [s3ForcePathStyle], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("s3ForcePathStyle")
            @ExcludeMissing
            fun _s3ForcePathStyle(): JsonField<Boolean> = s3ForcePathStyle

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
                 * Returns a mutable builder for constructing an instance of [S3CompatibleOrigin].
                 *
                 * The following fields are required:
                 * ```java
                 * .accessKey()
                 * .bucket()
                 * .endpoint()
                 * .name()
                 * .secretKey()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [S3CompatibleOrigin]. */
            class Builder internal constructor() {

                private var accessKey: JsonField<String>? = null
                private var bucket: JsonField<String>? = null
                private var endpoint: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var secretKey: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
                private var includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of()
                private var prefix: JsonField<String> = JsonMissing.of()
                private var s3ForcePathStyle: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(s3CompatibleOrigin: S3CompatibleOrigin) = apply {
                    accessKey = s3CompatibleOrigin.accessKey
                    bucket = s3CompatibleOrigin.bucket
                    endpoint = s3CompatibleOrigin.endpoint
                    name = s3CompatibleOrigin.name
                    secretKey = s3CompatibleOrigin.secretKey
                    type = s3CompatibleOrigin.type
                    baseUrlForCanonicalHeader = s3CompatibleOrigin.baseUrlForCanonicalHeader
                    includeCanonicalHeader = s3CompatibleOrigin.includeCanonicalHeader
                    prefix = s3CompatibleOrigin.prefix
                    s3ForcePathStyle = s3CompatibleOrigin.s3ForcePathStyle
                    additionalProperties = s3CompatibleOrigin.additionalProperties.toMutableMap()
                }

                /** Access key for the bucket. */
                fun accessKey(accessKey: String) = accessKey(JsonField.of(accessKey))

                /**
                 * Sets [Builder.accessKey] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.accessKey] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun accessKey(accessKey: JsonField<String>) = apply { this.accessKey = accessKey }

                /** S3 bucket name. */
                fun bucket(bucket: String) = bucket(JsonField.of(bucket))

                /**
                 * Sets [Builder.bucket] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bucket] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bucket(bucket: JsonField<String>) = apply { this.bucket = bucket }

                /** Custom S3-compatible endpoint. */
                fun endpoint(endpoint: String) = endpoint(JsonField.of(endpoint))

                /**
                 * Sets [Builder.endpoint] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.endpoint] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun endpoint(endpoint: JsonField<String>) = apply { this.endpoint = endpoint }

                /** Display name of the origin. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Secret key for the bucket. */
                fun secretKey(secretKey: String) = secretKey(JsonField.of(secretKey))

                /**
                 * Sets [Builder.secretKey] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.secretKey] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun secretKey(secretKey: JsonField<String>) = apply { this.secretKey = secretKey }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** URL used in the Canonical header (if enabled). */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: String) =
                    baseUrlForCanonicalHeader(JsonField.of(baseUrlForCanonicalHeader))

                /**
                 * Sets [Builder.baseUrlForCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.baseUrlForCanonicalHeader] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) =
                    apply {
                        this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
                    }

                /** Whether to send a Canonical header. */
                fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                    includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

                /**
                 * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.includeCanonicalHeader] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                    this.includeCanonicalHeader = includeCanonicalHeader
                }

                /** Path prefix inside the bucket. */
                fun prefix(prefix: String) = prefix(JsonField.of(prefix))

                /**
                 * Sets [Builder.prefix] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.prefix] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

                /** Use path-style S3 URLs? */
                fun s3ForcePathStyle(s3ForcePathStyle: Boolean) =
                    s3ForcePathStyle(JsonField.of(s3ForcePathStyle))

                /**
                 * Sets [Builder.s3ForcePathStyle] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.s3ForcePathStyle] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun s3ForcePathStyle(s3ForcePathStyle: JsonField<Boolean>) = apply {
                    this.s3ForcePathStyle = s3ForcePathStyle
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
                 * Returns an immutable instance of [S3CompatibleOrigin].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .accessKey()
                 * .bucket()
                 * .endpoint()
                 * .name()
                 * .secretKey()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): S3CompatibleOrigin =
                    S3CompatibleOrigin(
                        checkRequired("accessKey", accessKey),
                        checkRequired("bucket", bucket),
                        checkRequired("endpoint", endpoint),
                        checkRequired("name", name),
                        checkRequired("secretKey", secretKey),
                        checkRequired("type", type),
                        baseUrlForCanonicalHeader,
                        includeCanonicalHeader,
                        prefix,
                        s3ForcePathStyle,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): S3CompatibleOrigin = apply {
                if (validated) {
                    return@apply
                }

                accessKey()
                bucket()
                endpoint()
                name()
                secretKey()
                type().validate()
                baseUrlForCanonicalHeader()
                includeCanonicalHeader()
                prefix()
                s3ForcePathStyle()
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
                (if (accessKey.asKnown().isPresent) 1 else 0) +
                    (if (bucket.asKnown().isPresent) 1 else 0) +
                    (if (endpoint.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (secretKey.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (prefix.asKnown().isPresent) 1 else 0) +
                    (if (s3ForcePathStyle.asKnown().isPresent) 1 else 0)

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

                    @JvmField val S3_COMPATIBLE = of("S3_COMPATIBLE")

                    @JvmField val S3 = of("S3")

                    @JvmField val CLOUDINARY_BACKUP = of("CLOUDINARY_BACKUP")

                    @JvmField val WEB_FOLDER = of("WEB_FOLDER")

                    @JvmField val WEB_PROXY = of("WEB_PROXY")

                    @JvmField val GCS = of("GCS")

                    @JvmField val AZURE_BLOB = of("AZURE_BLOB")

                    @JvmField val AKENEO_PIM = of("AKENEO_PIM")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    S3_COMPATIBLE,
                    S3,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    WEB_PROXY,
                    GCS,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                    S3_COMPATIBLE,
                    S3,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    WEB_PROXY,
                    GCS,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                        S3_COMPATIBLE -> Value.S3_COMPATIBLE
                        S3 -> Value.S3
                        CLOUDINARY_BACKUP -> Value.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Value.WEB_FOLDER
                        WEB_PROXY -> Value.WEB_PROXY
                        GCS -> Value.GCS
                        AZURE_BLOB -> Value.AZURE_BLOB
                        AKENEO_PIM -> Value.AKENEO_PIM
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
                        S3_COMPATIBLE -> Known.S3_COMPATIBLE
                        S3 -> Known.S3
                        CLOUDINARY_BACKUP -> Known.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Known.WEB_FOLDER
                        WEB_PROXY -> Known.WEB_PROXY
                        GCS -> Known.GCS
                        AZURE_BLOB -> Known.AZURE_BLOB
                        AKENEO_PIM -> Known.AKENEO_PIM
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

                return other is S3CompatibleOrigin &&
                    accessKey == other.accessKey &&
                    bucket == other.bucket &&
                    endpoint == other.endpoint &&
                    name == other.name &&
                    secretKey == other.secretKey &&
                    type == other.type &&
                    baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                    includeCanonicalHeader == other.includeCanonicalHeader &&
                    prefix == other.prefix &&
                    s3ForcePathStyle == other.s3ForcePathStyle &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    accessKey,
                    bucket,
                    endpoint,
                    name,
                    secretKey,
                    type,
                    baseUrlForCanonicalHeader,
                    includeCanonicalHeader,
                    prefix,
                    s3ForcePathStyle,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "S3CompatibleOrigin{accessKey=$accessKey, bucket=$bucket, endpoint=$endpoint, name=$name, secretKey=$secretKey, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, includeCanonicalHeader=$includeCanonicalHeader, prefix=$prefix, s3ForcePathStyle=$s3ForcePathStyle, additionalProperties=$additionalProperties}"
        }

        class CloudinaryBackupOrigin
        private constructor(
            private val accessKey: JsonField<String>,
            private val bucket: JsonField<String>,
            private val name: JsonField<String>,
            private val secretKey: JsonField<String>,
            private val type: JsonField<Type>,
            private val baseUrlForCanonicalHeader: JsonField<String>,
            private val includeCanonicalHeader: JsonField<Boolean>,
            private val prefix: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("accessKey")
                @ExcludeMissing
                accessKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("bucket")
                @ExcludeMissing
                bucket: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("secretKey")
                @ExcludeMissing
                secretKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("baseUrlForCanonicalHeader")
                @ExcludeMissing
                baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
                @JsonProperty("includeCanonicalHeader")
                @ExcludeMissing
                includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("prefix") @ExcludeMissing prefix: JsonField<String> = JsonMissing.of(),
            ) : this(
                accessKey,
                bucket,
                name,
                secretKey,
                type,
                baseUrlForCanonicalHeader,
                includeCanonicalHeader,
                prefix,
                mutableMapOf(),
            )

            /**
             * Access key for the bucket.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun accessKey(): String = accessKey.getRequired("accessKey")

            /**
             * S3 bucket name.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bucket(): String = bucket.getRequired("bucket")

            /**
             * Display name of the origin.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Secret key for the bucket.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun secretKey(): String = secretKey.getRequired("secretKey")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * URL used in the Canonical header (if enabled).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun baseUrlForCanonicalHeader(): Optional<String> =
                baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

            /**
             * Whether to send a Canonical header.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun includeCanonicalHeader(): Optional<Boolean> =
                includeCanonicalHeader.getOptional("includeCanonicalHeader")

            /**
             * Path prefix inside the bucket.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun prefix(): Optional<String> = prefix.getOptional("prefix")

            /**
             * Returns the raw JSON value of [accessKey].
             *
             * Unlike [accessKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("accessKey")
            @ExcludeMissing
            fun _accessKey(): JsonField<String> = accessKey

            /**
             * Returns the raw JSON value of [bucket].
             *
             * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("bucket") @ExcludeMissing fun _bucket(): JsonField<String> = bucket

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [secretKey].
             *
             * Unlike [secretKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("secretKey")
            @ExcludeMissing
            fun _secretKey(): JsonField<String> = secretKey

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [baseUrlForCanonicalHeader].
             *
             * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

            /**
             * Returns the raw JSON value of [includeCanonicalHeader].
             *
             * Unlike [includeCanonicalHeader], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            fun _includeCanonicalHeader(): JsonField<Boolean> = includeCanonicalHeader

            /**
             * Returns the raw JSON value of [prefix].
             *
             * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

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
                 * [CloudinaryBackupOrigin].
                 *
                 * The following fields are required:
                 * ```java
                 * .accessKey()
                 * .bucket()
                 * .name()
                 * .secretKey()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CloudinaryBackupOrigin]. */
            class Builder internal constructor() {

                private var accessKey: JsonField<String>? = null
                private var bucket: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var secretKey: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
                private var includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of()
                private var prefix: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(cloudinaryBackupOrigin: CloudinaryBackupOrigin) = apply {
                    accessKey = cloudinaryBackupOrigin.accessKey
                    bucket = cloudinaryBackupOrigin.bucket
                    name = cloudinaryBackupOrigin.name
                    secretKey = cloudinaryBackupOrigin.secretKey
                    type = cloudinaryBackupOrigin.type
                    baseUrlForCanonicalHeader = cloudinaryBackupOrigin.baseUrlForCanonicalHeader
                    includeCanonicalHeader = cloudinaryBackupOrigin.includeCanonicalHeader
                    prefix = cloudinaryBackupOrigin.prefix
                    additionalProperties =
                        cloudinaryBackupOrigin.additionalProperties.toMutableMap()
                }

                /** Access key for the bucket. */
                fun accessKey(accessKey: String) = accessKey(JsonField.of(accessKey))

                /**
                 * Sets [Builder.accessKey] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.accessKey] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun accessKey(accessKey: JsonField<String>) = apply { this.accessKey = accessKey }

                /** S3 bucket name. */
                fun bucket(bucket: String) = bucket(JsonField.of(bucket))

                /**
                 * Sets [Builder.bucket] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bucket] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bucket(bucket: JsonField<String>) = apply { this.bucket = bucket }

                /** Display name of the origin. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Secret key for the bucket. */
                fun secretKey(secretKey: String) = secretKey(JsonField.of(secretKey))

                /**
                 * Sets [Builder.secretKey] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.secretKey] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun secretKey(secretKey: JsonField<String>) = apply { this.secretKey = secretKey }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** URL used in the Canonical header (if enabled). */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: String) =
                    baseUrlForCanonicalHeader(JsonField.of(baseUrlForCanonicalHeader))

                /**
                 * Sets [Builder.baseUrlForCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.baseUrlForCanonicalHeader] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) =
                    apply {
                        this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
                    }

                /** Whether to send a Canonical header. */
                fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                    includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

                /**
                 * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.includeCanonicalHeader] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                    this.includeCanonicalHeader = includeCanonicalHeader
                }

                /** Path prefix inside the bucket. */
                fun prefix(prefix: String) = prefix(JsonField.of(prefix))

                /**
                 * Sets [Builder.prefix] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.prefix] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

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
                 * Returns an immutable instance of [CloudinaryBackupOrigin].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .accessKey()
                 * .bucket()
                 * .name()
                 * .secretKey()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): CloudinaryBackupOrigin =
                    CloudinaryBackupOrigin(
                        checkRequired("accessKey", accessKey),
                        checkRequired("bucket", bucket),
                        checkRequired("name", name),
                        checkRequired("secretKey", secretKey),
                        checkRequired("type", type),
                        baseUrlForCanonicalHeader,
                        includeCanonicalHeader,
                        prefix,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): CloudinaryBackupOrigin = apply {
                if (validated) {
                    return@apply
                }

                accessKey()
                bucket()
                name()
                secretKey()
                type().validate()
                baseUrlForCanonicalHeader()
                includeCanonicalHeader()
                prefix()
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
                (if (accessKey.asKnown().isPresent) 1 else 0) +
                    (if (bucket.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (secretKey.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (prefix.asKnown().isPresent) 1 else 0)

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

                    @JvmField val CLOUDINARY_BACKUP = of("CLOUDINARY_BACKUP")

                    @JvmField val S3 = of("S3")

                    @JvmField val S3_COMPATIBLE = of("S3_COMPATIBLE")

                    @JvmField val WEB_FOLDER = of("WEB_FOLDER")

                    @JvmField val WEB_PROXY = of("WEB_PROXY")

                    @JvmField val GCS = of("GCS")

                    @JvmField val AZURE_BLOB = of("AZURE_BLOB")

                    @JvmField val AKENEO_PIM = of("AKENEO_PIM")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    CLOUDINARY_BACKUP,
                    S3,
                    S3_COMPATIBLE,
                    WEB_FOLDER,
                    WEB_PROXY,
                    GCS,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                    CLOUDINARY_BACKUP,
                    S3,
                    S3_COMPATIBLE,
                    WEB_FOLDER,
                    WEB_PROXY,
                    GCS,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                        CLOUDINARY_BACKUP -> Value.CLOUDINARY_BACKUP
                        S3 -> Value.S3
                        S3_COMPATIBLE -> Value.S3_COMPATIBLE
                        WEB_FOLDER -> Value.WEB_FOLDER
                        WEB_PROXY -> Value.WEB_PROXY
                        GCS -> Value.GCS
                        AZURE_BLOB -> Value.AZURE_BLOB
                        AKENEO_PIM -> Value.AKENEO_PIM
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
                        CLOUDINARY_BACKUP -> Known.CLOUDINARY_BACKUP
                        S3 -> Known.S3
                        S3_COMPATIBLE -> Known.S3_COMPATIBLE
                        WEB_FOLDER -> Known.WEB_FOLDER
                        WEB_PROXY -> Known.WEB_PROXY
                        GCS -> Known.GCS
                        AZURE_BLOB -> Known.AZURE_BLOB
                        AKENEO_PIM -> Known.AKENEO_PIM
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

                return other is CloudinaryBackupOrigin &&
                    accessKey == other.accessKey &&
                    bucket == other.bucket &&
                    name == other.name &&
                    secretKey == other.secretKey &&
                    type == other.type &&
                    baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                    includeCanonicalHeader == other.includeCanonicalHeader &&
                    prefix == other.prefix &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    accessKey,
                    bucket,
                    name,
                    secretKey,
                    type,
                    baseUrlForCanonicalHeader,
                    includeCanonicalHeader,
                    prefix,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CloudinaryBackupOrigin{accessKey=$accessKey, bucket=$bucket, name=$name, secretKey=$secretKey, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, includeCanonicalHeader=$includeCanonicalHeader, prefix=$prefix, additionalProperties=$additionalProperties}"
        }

        class WebFolderOrigin
        private constructor(
            private val baseUrl: JsonField<String>,
            private val name: JsonField<String>,
            private val type: JsonField<Type>,
            private val baseUrlForCanonicalHeader: JsonField<String>,
            private val forwardHostHeaderToOrigin: JsonField<Boolean>,
            private val includeCanonicalHeader: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("baseUrl")
                @ExcludeMissing
                baseUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("baseUrlForCanonicalHeader")
                @ExcludeMissing
                baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
                @JsonProperty("forwardHostHeaderToOrigin")
                @ExcludeMissing
                forwardHostHeaderToOrigin: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("includeCanonicalHeader")
                @ExcludeMissing
                includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            ) : this(
                baseUrl,
                name,
                type,
                baseUrlForCanonicalHeader,
                forwardHostHeaderToOrigin,
                includeCanonicalHeader,
                mutableMapOf(),
            )

            /**
             * Root URL for the web folder origin.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun baseUrl(): String = baseUrl.getRequired("baseUrl")

            /**
             * Display name of the origin.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * URL used in the Canonical header (if enabled).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun baseUrlForCanonicalHeader(): Optional<String> =
                baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

            /**
             * Forward the Host header to origin?
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun forwardHostHeaderToOrigin(): Optional<Boolean> =
                forwardHostHeaderToOrigin.getOptional("forwardHostHeaderToOrigin")

            /**
             * Whether to send a Canonical header.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun includeCanonicalHeader(): Optional<Boolean> =
                includeCanonicalHeader.getOptional("includeCanonicalHeader")

            /**
             * Returns the raw JSON value of [baseUrl].
             *
             * Unlike [baseUrl], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("baseUrl") @ExcludeMissing fun _baseUrl(): JsonField<String> = baseUrl

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [baseUrlForCanonicalHeader].
             *
             * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

            /**
             * Returns the raw JSON value of [forwardHostHeaderToOrigin].
             *
             * Unlike [forwardHostHeaderToOrigin], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("forwardHostHeaderToOrigin")
            @ExcludeMissing
            fun _forwardHostHeaderToOrigin(): JsonField<Boolean> = forwardHostHeaderToOrigin

            /**
             * Returns the raw JSON value of [includeCanonicalHeader].
             *
             * Unlike [includeCanonicalHeader], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            fun _includeCanonicalHeader(): JsonField<Boolean> = includeCanonicalHeader

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
                 * Returns a mutable builder for constructing an instance of [WebFolderOrigin].
                 *
                 * The following fields are required:
                 * ```java
                 * .baseUrl()
                 * .name()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [WebFolderOrigin]. */
            class Builder internal constructor() {

                private var baseUrl: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
                private var forwardHostHeaderToOrigin: JsonField<Boolean> = JsonMissing.of()
                private var includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(webFolderOrigin: WebFolderOrigin) = apply {
                    baseUrl = webFolderOrigin.baseUrl
                    name = webFolderOrigin.name
                    type = webFolderOrigin.type
                    baseUrlForCanonicalHeader = webFolderOrigin.baseUrlForCanonicalHeader
                    forwardHostHeaderToOrigin = webFolderOrigin.forwardHostHeaderToOrigin
                    includeCanonicalHeader = webFolderOrigin.includeCanonicalHeader
                    additionalProperties = webFolderOrigin.additionalProperties.toMutableMap()
                }

                /** Root URL for the web folder origin. */
                fun baseUrl(baseUrl: String) = baseUrl(JsonField.of(baseUrl))

                /**
                 * Sets [Builder.baseUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.baseUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun baseUrl(baseUrl: JsonField<String>) = apply { this.baseUrl = baseUrl }

                /** Display name of the origin. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** URL used in the Canonical header (if enabled). */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: String) =
                    baseUrlForCanonicalHeader(JsonField.of(baseUrlForCanonicalHeader))

                /**
                 * Sets [Builder.baseUrlForCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.baseUrlForCanonicalHeader] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) =
                    apply {
                        this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
                    }

                /** Forward the Host header to origin? */
                fun forwardHostHeaderToOrigin(forwardHostHeaderToOrigin: Boolean) =
                    forwardHostHeaderToOrigin(JsonField.of(forwardHostHeaderToOrigin))

                /**
                 * Sets [Builder.forwardHostHeaderToOrigin] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.forwardHostHeaderToOrigin] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun forwardHostHeaderToOrigin(forwardHostHeaderToOrigin: JsonField<Boolean>) =
                    apply {
                        this.forwardHostHeaderToOrigin = forwardHostHeaderToOrigin
                    }

                /** Whether to send a Canonical header. */
                fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                    includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

                /**
                 * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.includeCanonicalHeader] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                    this.includeCanonicalHeader = includeCanonicalHeader
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
                 * Returns an immutable instance of [WebFolderOrigin].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .baseUrl()
                 * .name()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): WebFolderOrigin =
                    WebFolderOrigin(
                        checkRequired("baseUrl", baseUrl),
                        checkRequired("name", name),
                        checkRequired("type", type),
                        baseUrlForCanonicalHeader,
                        forwardHostHeaderToOrigin,
                        includeCanonicalHeader,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): WebFolderOrigin = apply {
                if (validated) {
                    return@apply
                }

                baseUrl()
                name()
                type().validate()
                baseUrlForCanonicalHeader()
                forwardHostHeaderToOrigin()
                includeCanonicalHeader()
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
                (if (baseUrl.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (forwardHostHeaderToOrigin.asKnown().isPresent) 1 else 0) +
                    (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0)

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

                    @JvmField val WEB_FOLDER = of("WEB_FOLDER")

                    @JvmField val S3 = of("S3")

                    @JvmField val S3_COMPATIBLE = of("S3_COMPATIBLE")

                    @JvmField val CLOUDINARY_BACKUP = of("CLOUDINARY_BACKUP")

                    @JvmField val WEB_PROXY = of("WEB_PROXY")

                    @JvmField val GCS = of("GCS")

                    @JvmField val AZURE_BLOB = of("AZURE_BLOB")

                    @JvmField val AKENEO_PIM = of("AKENEO_PIM")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    WEB_FOLDER,
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_PROXY,
                    GCS,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                    WEB_FOLDER,
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_PROXY,
                    GCS,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                        WEB_FOLDER -> Value.WEB_FOLDER
                        S3 -> Value.S3
                        S3_COMPATIBLE -> Value.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Value.CLOUDINARY_BACKUP
                        WEB_PROXY -> Value.WEB_PROXY
                        GCS -> Value.GCS
                        AZURE_BLOB -> Value.AZURE_BLOB
                        AKENEO_PIM -> Value.AKENEO_PIM
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
                        WEB_FOLDER -> Known.WEB_FOLDER
                        S3 -> Known.S3
                        S3_COMPATIBLE -> Known.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Known.CLOUDINARY_BACKUP
                        WEB_PROXY -> Known.WEB_PROXY
                        GCS -> Known.GCS
                        AZURE_BLOB -> Known.AZURE_BLOB
                        AKENEO_PIM -> Known.AKENEO_PIM
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

                return other is WebFolderOrigin &&
                    baseUrl == other.baseUrl &&
                    name == other.name &&
                    type == other.type &&
                    baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                    forwardHostHeaderToOrigin == other.forwardHostHeaderToOrigin &&
                    includeCanonicalHeader == other.includeCanonicalHeader &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    baseUrl,
                    name,
                    type,
                    baseUrlForCanonicalHeader,
                    forwardHostHeaderToOrigin,
                    includeCanonicalHeader,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "WebFolderOrigin{baseUrl=$baseUrl, name=$name, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, forwardHostHeaderToOrigin=$forwardHostHeaderToOrigin, includeCanonicalHeader=$includeCanonicalHeader, additionalProperties=$additionalProperties}"
        }

        class WebProxyOrigin
        private constructor(
            private val name: JsonField<String>,
            private val type: JsonField<Type>,
            private val baseUrlForCanonicalHeader: JsonField<String>,
            private val includeCanonicalHeader: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("baseUrlForCanonicalHeader")
                @ExcludeMissing
                baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
                @JsonProperty("includeCanonicalHeader")
                @ExcludeMissing
                includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            ) : this(name, type, baseUrlForCanonicalHeader, includeCanonicalHeader, mutableMapOf())

            /**
             * Display name of the origin.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * URL used in the Canonical header (if enabled).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun baseUrlForCanonicalHeader(): Optional<String> =
                baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

            /**
             * Whether to send a Canonical header.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun includeCanonicalHeader(): Optional<Boolean> =
                includeCanonicalHeader.getOptional("includeCanonicalHeader")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [baseUrlForCanonicalHeader].
             *
             * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

            /**
             * Returns the raw JSON value of [includeCanonicalHeader].
             *
             * Unlike [includeCanonicalHeader], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            fun _includeCanonicalHeader(): JsonField<Boolean> = includeCanonicalHeader

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
                 * Returns a mutable builder for constructing an instance of [WebProxyOrigin].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [WebProxyOrigin]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
                private var includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(webProxyOrigin: WebProxyOrigin) = apply {
                    name = webProxyOrigin.name
                    type = webProxyOrigin.type
                    baseUrlForCanonicalHeader = webProxyOrigin.baseUrlForCanonicalHeader
                    includeCanonicalHeader = webProxyOrigin.includeCanonicalHeader
                    additionalProperties = webProxyOrigin.additionalProperties.toMutableMap()
                }

                /** Display name of the origin. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** URL used in the Canonical header (if enabled). */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: String) =
                    baseUrlForCanonicalHeader(JsonField.of(baseUrlForCanonicalHeader))

                /**
                 * Sets [Builder.baseUrlForCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.baseUrlForCanonicalHeader] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) =
                    apply {
                        this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
                    }

                /** Whether to send a Canonical header. */
                fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                    includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

                /**
                 * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.includeCanonicalHeader] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                    this.includeCanonicalHeader = includeCanonicalHeader
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
                 * Returns an immutable instance of [WebProxyOrigin].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): WebProxyOrigin =
                    WebProxyOrigin(
                        checkRequired("name", name),
                        checkRequired("type", type),
                        baseUrlForCanonicalHeader,
                        includeCanonicalHeader,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): WebProxyOrigin = apply {
                if (validated) {
                    return@apply
                }

                name()
                type().validate()
                baseUrlForCanonicalHeader()
                includeCanonicalHeader()
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
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0)

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

                    @JvmField val WEB_PROXY = of("WEB_PROXY")

                    @JvmField val S3 = of("S3")

                    @JvmField val S3_COMPATIBLE = of("S3_COMPATIBLE")

                    @JvmField val CLOUDINARY_BACKUP = of("CLOUDINARY_BACKUP")

                    @JvmField val WEB_FOLDER = of("WEB_FOLDER")

                    @JvmField val GCS = of("GCS")

                    @JvmField val AZURE_BLOB = of("AZURE_BLOB")

                    @JvmField val AKENEO_PIM = of("AKENEO_PIM")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    WEB_PROXY,
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    GCS,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                    WEB_PROXY,
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    GCS,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                        WEB_PROXY -> Value.WEB_PROXY
                        S3 -> Value.S3
                        S3_COMPATIBLE -> Value.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Value.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Value.WEB_FOLDER
                        GCS -> Value.GCS
                        AZURE_BLOB -> Value.AZURE_BLOB
                        AKENEO_PIM -> Value.AKENEO_PIM
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
                        WEB_PROXY -> Known.WEB_PROXY
                        S3 -> Known.S3
                        S3_COMPATIBLE -> Known.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Known.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Known.WEB_FOLDER
                        GCS -> Known.GCS
                        AZURE_BLOB -> Known.AZURE_BLOB
                        AKENEO_PIM -> Known.AKENEO_PIM
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

                return other is WebProxyOrigin &&
                    name == other.name &&
                    type == other.type &&
                    baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                    includeCanonicalHeader == other.includeCanonicalHeader &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    name,
                    type,
                    baseUrlForCanonicalHeader,
                    includeCanonicalHeader,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "WebProxyOrigin{name=$name, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, includeCanonicalHeader=$includeCanonicalHeader, additionalProperties=$additionalProperties}"
        }

        class GcsOrigin
        private constructor(
            private val bucket: JsonField<String>,
            private val clientEmail: JsonField<String>,
            private val name: JsonField<String>,
            private val privateKey: JsonField<String>,
            private val type: JsonField<Type>,
            private val baseUrlForCanonicalHeader: JsonField<String>,
            private val includeCanonicalHeader: JsonField<Boolean>,
            private val prefix: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bucket")
                @ExcludeMissing
                bucket: JsonField<String> = JsonMissing.of(),
                @JsonProperty("clientEmail")
                @ExcludeMissing
                clientEmail: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("privateKey")
                @ExcludeMissing
                privateKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("baseUrlForCanonicalHeader")
                @ExcludeMissing
                baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
                @JsonProperty("includeCanonicalHeader")
                @ExcludeMissing
                includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("prefix") @ExcludeMissing prefix: JsonField<String> = JsonMissing.of(),
            ) : this(
                bucket,
                clientEmail,
                name,
                privateKey,
                type,
                baseUrlForCanonicalHeader,
                includeCanonicalHeader,
                prefix,
                mutableMapOf(),
            )

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bucket(): String = bucket.getRequired("bucket")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun clientEmail(): String = clientEmail.getRequired("clientEmail")

            /**
             * Display name of the origin.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun privateKey(): String = privateKey.getRequired("privateKey")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * URL used in the Canonical header (if enabled).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun baseUrlForCanonicalHeader(): Optional<String> =
                baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

            /**
             * Whether to send a Canonical header.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun includeCanonicalHeader(): Optional<Boolean> =
                includeCanonicalHeader.getOptional("includeCanonicalHeader")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun prefix(): Optional<String> = prefix.getOptional("prefix")

            /**
             * Returns the raw JSON value of [bucket].
             *
             * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("bucket") @ExcludeMissing fun _bucket(): JsonField<String> = bucket

            /**
             * Returns the raw JSON value of [clientEmail].
             *
             * Unlike [clientEmail], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("clientEmail")
            @ExcludeMissing
            fun _clientEmail(): JsonField<String> = clientEmail

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [privateKey].
             *
             * Unlike [privateKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("privateKey")
            @ExcludeMissing
            fun _privateKey(): JsonField<String> = privateKey

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [baseUrlForCanonicalHeader].
             *
             * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

            /**
             * Returns the raw JSON value of [includeCanonicalHeader].
             *
             * Unlike [includeCanonicalHeader], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            fun _includeCanonicalHeader(): JsonField<Boolean> = includeCanonicalHeader

            /**
             * Returns the raw JSON value of [prefix].
             *
             * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

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
                 * Returns a mutable builder for constructing an instance of [GcsOrigin].
                 *
                 * The following fields are required:
                 * ```java
                 * .bucket()
                 * .clientEmail()
                 * .name()
                 * .privateKey()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [GcsOrigin]. */
            class Builder internal constructor() {

                private var bucket: JsonField<String>? = null
                private var clientEmail: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var privateKey: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
                private var includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of()
                private var prefix: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(gcsOrigin: GcsOrigin) = apply {
                    bucket = gcsOrigin.bucket
                    clientEmail = gcsOrigin.clientEmail
                    name = gcsOrigin.name
                    privateKey = gcsOrigin.privateKey
                    type = gcsOrigin.type
                    baseUrlForCanonicalHeader = gcsOrigin.baseUrlForCanonicalHeader
                    includeCanonicalHeader = gcsOrigin.includeCanonicalHeader
                    prefix = gcsOrigin.prefix
                    additionalProperties = gcsOrigin.additionalProperties.toMutableMap()
                }

                fun bucket(bucket: String) = bucket(JsonField.of(bucket))

                /**
                 * Sets [Builder.bucket] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bucket] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bucket(bucket: JsonField<String>) = apply { this.bucket = bucket }

                fun clientEmail(clientEmail: String) = clientEmail(JsonField.of(clientEmail))

                /**
                 * Sets [Builder.clientEmail] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.clientEmail] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun clientEmail(clientEmail: JsonField<String>) = apply {
                    this.clientEmail = clientEmail
                }

                /** Display name of the origin. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun privateKey(privateKey: String) = privateKey(JsonField.of(privateKey))

                /**
                 * Sets [Builder.privateKey] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.privateKey] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun privateKey(privateKey: JsonField<String>) = apply {
                    this.privateKey = privateKey
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

                /** URL used in the Canonical header (if enabled). */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: String) =
                    baseUrlForCanonicalHeader(JsonField.of(baseUrlForCanonicalHeader))

                /**
                 * Sets [Builder.baseUrlForCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.baseUrlForCanonicalHeader] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) =
                    apply {
                        this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
                    }

                /** Whether to send a Canonical header. */
                fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                    includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

                /**
                 * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.includeCanonicalHeader] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                    this.includeCanonicalHeader = includeCanonicalHeader
                }

                fun prefix(prefix: String) = prefix(JsonField.of(prefix))

                /**
                 * Sets [Builder.prefix] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.prefix] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

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
                 * Returns an immutable instance of [GcsOrigin].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bucket()
                 * .clientEmail()
                 * .name()
                 * .privateKey()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): GcsOrigin =
                    GcsOrigin(
                        checkRequired("bucket", bucket),
                        checkRequired("clientEmail", clientEmail),
                        checkRequired("name", name),
                        checkRequired("privateKey", privateKey),
                        checkRequired("type", type),
                        baseUrlForCanonicalHeader,
                        includeCanonicalHeader,
                        prefix,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): GcsOrigin = apply {
                if (validated) {
                    return@apply
                }

                bucket()
                clientEmail()
                name()
                privateKey()
                type().validate()
                baseUrlForCanonicalHeader()
                includeCanonicalHeader()
                prefix()
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
                (if (bucket.asKnown().isPresent) 1 else 0) +
                    (if (clientEmail.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (privateKey.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (prefix.asKnown().isPresent) 1 else 0)

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

                    @JvmField val GCS = of("GCS")

                    @JvmField val S3 = of("S3")

                    @JvmField val S3_COMPATIBLE = of("S3_COMPATIBLE")

                    @JvmField val CLOUDINARY_BACKUP = of("CLOUDINARY_BACKUP")

                    @JvmField val WEB_FOLDER = of("WEB_FOLDER")

                    @JvmField val WEB_PROXY = of("WEB_PROXY")

                    @JvmField val AZURE_BLOB = of("AZURE_BLOB")

                    @JvmField val AKENEO_PIM = of("AKENEO_PIM")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    GCS,
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    WEB_PROXY,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                    GCS,
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    WEB_PROXY,
                    AZURE_BLOB,
                    AKENEO_PIM,
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
                        GCS -> Value.GCS
                        S3 -> Value.S3
                        S3_COMPATIBLE -> Value.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Value.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Value.WEB_FOLDER
                        WEB_PROXY -> Value.WEB_PROXY
                        AZURE_BLOB -> Value.AZURE_BLOB
                        AKENEO_PIM -> Value.AKENEO_PIM
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
                        GCS -> Known.GCS
                        S3 -> Known.S3
                        S3_COMPATIBLE -> Known.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Known.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Known.WEB_FOLDER
                        WEB_PROXY -> Known.WEB_PROXY
                        AZURE_BLOB -> Known.AZURE_BLOB
                        AKENEO_PIM -> Known.AKENEO_PIM
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

                return other is GcsOrigin &&
                    bucket == other.bucket &&
                    clientEmail == other.clientEmail &&
                    name == other.name &&
                    privateKey == other.privateKey &&
                    type == other.type &&
                    baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                    includeCanonicalHeader == other.includeCanonicalHeader &&
                    prefix == other.prefix &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    bucket,
                    clientEmail,
                    name,
                    privateKey,
                    type,
                    baseUrlForCanonicalHeader,
                    includeCanonicalHeader,
                    prefix,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "GcsOrigin{bucket=$bucket, clientEmail=$clientEmail, name=$name, privateKey=$privateKey, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, includeCanonicalHeader=$includeCanonicalHeader, prefix=$prefix, additionalProperties=$additionalProperties}"
        }

        class AzureBlobOrigin
        private constructor(
            private val accountName: JsonField<String>,
            private val container: JsonField<String>,
            private val name: JsonField<String>,
            private val sasToken: JsonField<String>,
            private val type: JsonField<Type>,
            private val baseUrlForCanonicalHeader: JsonField<String>,
            private val includeCanonicalHeader: JsonField<Boolean>,
            private val prefix: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("accountName")
                @ExcludeMissing
                accountName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("container")
                @ExcludeMissing
                container: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("sasToken")
                @ExcludeMissing
                sasToken: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("baseUrlForCanonicalHeader")
                @ExcludeMissing
                baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
                @JsonProperty("includeCanonicalHeader")
                @ExcludeMissing
                includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("prefix") @ExcludeMissing prefix: JsonField<String> = JsonMissing.of(),
            ) : this(
                accountName,
                container,
                name,
                sasToken,
                type,
                baseUrlForCanonicalHeader,
                includeCanonicalHeader,
                prefix,
                mutableMapOf(),
            )

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun accountName(): String = accountName.getRequired("accountName")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun container(): String = container.getRequired("container")

            /**
             * Display name of the origin.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun sasToken(): String = sasToken.getRequired("sasToken")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * URL used in the Canonical header (if enabled).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun baseUrlForCanonicalHeader(): Optional<String> =
                baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

            /**
             * Whether to send a Canonical header.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun includeCanonicalHeader(): Optional<Boolean> =
                includeCanonicalHeader.getOptional("includeCanonicalHeader")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun prefix(): Optional<String> = prefix.getOptional("prefix")

            /**
             * Returns the raw JSON value of [accountName].
             *
             * Unlike [accountName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("accountName")
            @ExcludeMissing
            fun _accountName(): JsonField<String> = accountName

            /**
             * Returns the raw JSON value of [container].
             *
             * Unlike [container], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("container")
            @ExcludeMissing
            fun _container(): JsonField<String> = container

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [sasToken].
             *
             * Unlike [sasToken], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("sasToken") @ExcludeMissing fun _sasToken(): JsonField<String> = sasToken

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [baseUrlForCanonicalHeader].
             *
             * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

            /**
             * Returns the raw JSON value of [includeCanonicalHeader].
             *
             * Unlike [includeCanonicalHeader], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            fun _includeCanonicalHeader(): JsonField<Boolean> = includeCanonicalHeader

            /**
             * Returns the raw JSON value of [prefix].
             *
             * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

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
                 * Returns a mutable builder for constructing an instance of [AzureBlobOrigin].
                 *
                 * The following fields are required:
                 * ```java
                 * .accountName()
                 * .container()
                 * .name()
                 * .sasToken()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [AzureBlobOrigin]. */
            class Builder internal constructor() {

                private var accountName: JsonField<String>? = null
                private var container: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var sasToken: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
                private var includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of()
                private var prefix: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(azureBlobOrigin: AzureBlobOrigin) = apply {
                    accountName = azureBlobOrigin.accountName
                    container = azureBlobOrigin.container
                    name = azureBlobOrigin.name
                    sasToken = azureBlobOrigin.sasToken
                    type = azureBlobOrigin.type
                    baseUrlForCanonicalHeader = azureBlobOrigin.baseUrlForCanonicalHeader
                    includeCanonicalHeader = azureBlobOrigin.includeCanonicalHeader
                    prefix = azureBlobOrigin.prefix
                    additionalProperties = azureBlobOrigin.additionalProperties.toMutableMap()
                }

                fun accountName(accountName: String) = accountName(JsonField.of(accountName))

                /**
                 * Sets [Builder.accountName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.accountName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun accountName(accountName: JsonField<String>) = apply {
                    this.accountName = accountName
                }

                fun container(container: String) = container(JsonField.of(container))

                /**
                 * Sets [Builder.container] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.container] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun container(container: JsonField<String>) = apply { this.container = container }

                /** Display name of the origin. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun sasToken(sasToken: String) = sasToken(JsonField.of(sasToken))

                /**
                 * Sets [Builder.sasToken] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sasToken] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun sasToken(sasToken: JsonField<String>) = apply { this.sasToken = sasToken }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** URL used in the Canonical header (if enabled). */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: String) =
                    baseUrlForCanonicalHeader(JsonField.of(baseUrlForCanonicalHeader))

                /**
                 * Sets [Builder.baseUrlForCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.baseUrlForCanonicalHeader] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) =
                    apply {
                        this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
                    }

                /** Whether to send a Canonical header. */
                fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                    includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

                /**
                 * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.includeCanonicalHeader] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                    this.includeCanonicalHeader = includeCanonicalHeader
                }

                fun prefix(prefix: String) = prefix(JsonField.of(prefix))

                /**
                 * Sets [Builder.prefix] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.prefix] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

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
                 * Returns an immutable instance of [AzureBlobOrigin].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .accountName()
                 * .container()
                 * .name()
                 * .sasToken()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): AzureBlobOrigin =
                    AzureBlobOrigin(
                        checkRequired("accountName", accountName),
                        checkRequired("container", container),
                        checkRequired("name", name),
                        checkRequired("sasToken", sasToken),
                        checkRequired("type", type),
                        baseUrlForCanonicalHeader,
                        includeCanonicalHeader,
                        prefix,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): AzureBlobOrigin = apply {
                if (validated) {
                    return@apply
                }

                accountName()
                container()
                name()
                sasToken()
                type().validate()
                baseUrlForCanonicalHeader()
                includeCanonicalHeader()
                prefix()
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
                (if (accountName.asKnown().isPresent) 1 else 0) +
                    (if (container.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (sasToken.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (prefix.asKnown().isPresent) 1 else 0)

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

                    @JvmField val AZURE_BLOB = of("AZURE_BLOB")

                    @JvmField val S3 = of("S3")

                    @JvmField val S3_COMPATIBLE = of("S3_COMPATIBLE")

                    @JvmField val CLOUDINARY_BACKUP = of("CLOUDINARY_BACKUP")

                    @JvmField val WEB_FOLDER = of("WEB_FOLDER")

                    @JvmField val WEB_PROXY = of("WEB_PROXY")

                    @JvmField val GCS = of("GCS")

                    @JvmField val AKENEO_PIM = of("AKENEO_PIM")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    AZURE_BLOB,
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    WEB_PROXY,
                    GCS,
                    AKENEO_PIM,
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
                    AZURE_BLOB,
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    WEB_PROXY,
                    GCS,
                    AKENEO_PIM,
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
                        AZURE_BLOB -> Value.AZURE_BLOB
                        S3 -> Value.S3
                        S3_COMPATIBLE -> Value.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Value.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Value.WEB_FOLDER
                        WEB_PROXY -> Value.WEB_PROXY
                        GCS -> Value.GCS
                        AKENEO_PIM -> Value.AKENEO_PIM
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
                        AZURE_BLOB -> Known.AZURE_BLOB
                        S3 -> Known.S3
                        S3_COMPATIBLE -> Known.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Known.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Known.WEB_FOLDER
                        WEB_PROXY -> Known.WEB_PROXY
                        GCS -> Known.GCS
                        AKENEO_PIM -> Known.AKENEO_PIM
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

                return other is AzureBlobOrigin &&
                    accountName == other.accountName &&
                    container == other.container &&
                    name == other.name &&
                    sasToken == other.sasToken &&
                    type == other.type &&
                    baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                    includeCanonicalHeader == other.includeCanonicalHeader &&
                    prefix == other.prefix &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    accountName,
                    container,
                    name,
                    sasToken,
                    type,
                    baseUrlForCanonicalHeader,
                    includeCanonicalHeader,
                    prefix,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "AzureBlobOrigin{accountName=$accountName, container=$container, name=$name, sasToken=$sasToken, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, includeCanonicalHeader=$includeCanonicalHeader, prefix=$prefix, additionalProperties=$additionalProperties}"
        }

        class AkeneoPimOrigin
        private constructor(
            private val baseUrl: JsonField<String>,
            private val clientId: JsonField<String>,
            private val clientSecret: JsonField<String>,
            private val name: JsonField<String>,
            private val password: JsonField<String>,
            private val type: JsonField<Type>,
            private val username: JsonField<String>,
            private val baseUrlForCanonicalHeader: JsonField<String>,
            private val includeCanonicalHeader: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("baseUrl")
                @ExcludeMissing
                baseUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("clientId")
                @ExcludeMissing
                clientId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("clientSecret")
                @ExcludeMissing
                clientSecret: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("password")
                @ExcludeMissing
                password: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("username")
                @ExcludeMissing
                username: JsonField<String> = JsonMissing.of(),
                @JsonProperty("baseUrlForCanonicalHeader")
                @ExcludeMissing
                baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
                @JsonProperty("includeCanonicalHeader")
                @ExcludeMissing
                includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            ) : this(
                baseUrl,
                clientId,
                clientSecret,
                name,
                password,
                type,
                username,
                baseUrlForCanonicalHeader,
                includeCanonicalHeader,
                mutableMapOf(),
            )

            /**
             * Akeneo instance base URL.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun baseUrl(): String = baseUrl.getRequired("baseUrl")

            /**
             * Akeneo API client ID.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun clientId(): String = clientId.getRequired("clientId")

            /**
             * Akeneo API client secret.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun clientSecret(): String = clientSecret.getRequired("clientSecret")

            /**
             * Display name of the origin.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Akeneo API password.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun password(): String = password.getRequired("password")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Akeneo API username.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun username(): String = username.getRequired("username")

            /**
             * URL used in the Canonical header (if enabled).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun baseUrlForCanonicalHeader(): Optional<String> =
                baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

            /**
             * Whether to send a Canonical header.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun includeCanonicalHeader(): Optional<Boolean> =
                includeCanonicalHeader.getOptional("includeCanonicalHeader")

            /**
             * Returns the raw JSON value of [baseUrl].
             *
             * Unlike [baseUrl], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("baseUrl") @ExcludeMissing fun _baseUrl(): JsonField<String> = baseUrl

            /**
             * Returns the raw JSON value of [clientId].
             *
             * Unlike [clientId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("clientId") @ExcludeMissing fun _clientId(): JsonField<String> = clientId

            /**
             * Returns the raw JSON value of [clientSecret].
             *
             * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("clientSecret")
            @ExcludeMissing
            fun _clientSecret(): JsonField<String> = clientSecret

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [password].
             *
             * Unlike [password], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("password") @ExcludeMissing fun _password(): JsonField<String> = password

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [username].
             *
             * Unlike [username], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

            /**
             * Returns the raw JSON value of [baseUrlForCanonicalHeader].
             *
             * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

            /**
             * Returns the raw JSON value of [includeCanonicalHeader].
             *
             * Unlike [includeCanonicalHeader], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            fun _includeCanonicalHeader(): JsonField<Boolean> = includeCanonicalHeader

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
                 * Returns a mutable builder for constructing an instance of [AkeneoPimOrigin].
                 *
                 * The following fields are required:
                 * ```java
                 * .baseUrl()
                 * .clientId()
                 * .clientSecret()
                 * .name()
                 * .password()
                 * .type()
                 * .username()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [AkeneoPimOrigin]. */
            class Builder internal constructor() {

                private var baseUrl: JsonField<String>? = null
                private var clientId: JsonField<String>? = null
                private var clientSecret: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var password: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var username: JsonField<String>? = null
                private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
                private var includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(akeneoPimOrigin: AkeneoPimOrigin) = apply {
                    baseUrl = akeneoPimOrigin.baseUrl
                    clientId = akeneoPimOrigin.clientId
                    clientSecret = akeneoPimOrigin.clientSecret
                    name = akeneoPimOrigin.name
                    password = akeneoPimOrigin.password
                    type = akeneoPimOrigin.type
                    username = akeneoPimOrigin.username
                    baseUrlForCanonicalHeader = akeneoPimOrigin.baseUrlForCanonicalHeader
                    includeCanonicalHeader = akeneoPimOrigin.includeCanonicalHeader
                    additionalProperties = akeneoPimOrigin.additionalProperties.toMutableMap()
                }

                /** Akeneo instance base URL. */
                fun baseUrl(baseUrl: String) = baseUrl(JsonField.of(baseUrl))

                /**
                 * Sets [Builder.baseUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.baseUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun baseUrl(baseUrl: JsonField<String>) = apply { this.baseUrl = baseUrl }

                /** Akeneo API client ID. */
                fun clientId(clientId: String) = clientId(JsonField.of(clientId))

                /**
                 * Sets [Builder.clientId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.clientId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun clientId(clientId: JsonField<String>) = apply { this.clientId = clientId }

                /** Akeneo API client secret. */
                fun clientSecret(clientSecret: String) = clientSecret(JsonField.of(clientSecret))

                /**
                 * Sets [Builder.clientSecret] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.clientSecret] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun clientSecret(clientSecret: JsonField<String>) = apply {
                    this.clientSecret = clientSecret
                }

                /** Display name of the origin. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Akeneo API password. */
                fun password(password: String) = password(JsonField.of(password))

                /**
                 * Sets [Builder.password] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.password] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun password(password: JsonField<String>) = apply { this.password = password }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** Akeneo API username. */
                fun username(username: String) = username(JsonField.of(username))

                /**
                 * Sets [Builder.username] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.username] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun username(username: JsonField<String>) = apply { this.username = username }

                /** URL used in the Canonical header (if enabled). */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: String) =
                    baseUrlForCanonicalHeader(JsonField.of(baseUrlForCanonicalHeader))

                /**
                 * Sets [Builder.baseUrlForCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.baseUrlForCanonicalHeader] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) =
                    apply {
                        this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
                    }

                /** Whether to send a Canonical header. */
                fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                    includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

                /**
                 * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.includeCanonicalHeader] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                    this.includeCanonicalHeader = includeCanonicalHeader
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
                 * Returns an immutable instance of [AkeneoPimOrigin].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .baseUrl()
                 * .clientId()
                 * .clientSecret()
                 * .name()
                 * .password()
                 * .type()
                 * .username()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): AkeneoPimOrigin =
                    AkeneoPimOrigin(
                        checkRequired("baseUrl", baseUrl),
                        checkRequired("clientId", clientId),
                        checkRequired("clientSecret", clientSecret),
                        checkRequired("name", name),
                        checkRequired("password", password),
                        checkRequired("type", type),
                        checkRequired("username", username),
                        baseUrlForCanonicalHeader,
                        includeCanonicalHeader,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): AkeneoPimOrigin = apply {
                if (validated) {
                    return@apply
                }

                baseUrl()
                clientId()
                clientSecret()
                name()
                password()
                type().validate()
                username()
                baseUrlForCanonicalHeader()
                includeCanonicalHeader()
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
                (if (baseUrl.asKnown().isPresent) 1 else 0) +
                    (if (clientId.asKnown().isPresent) 1 else 0) +
                    (if (clientSecret.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (password.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (username.asKnown().isPresent) 1 else 0) +
                    (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0) +
                    (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0)

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

                    @JvmField val AKENEO_PIM = of("AKENEO_PIM")

                    @JvmField val S3 = of("S3")

                    @JvmField val S3_COMPATIBLE = of("S3_COMPATIBLE")

                    @JvmField val CLOUDINARY_BACKUP = of("CLOUDINARY_BACKUP")

                    @JvmField val WEB_FOLDER = of("WEB_FOLDER")

                    @JvmField val WEB_PROXY = of("WEB_PROXY")

                    @JvmField val GCS = of("GCS")

                    @JvmField val AZURE_BLOB = of("AZURE_BLOB")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    AKENEO_PIM,
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    WEB_PROXY,
                    GCS,
                    AZURE_BLOB,
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
                    AKENEO_PIM,
                    S3,
                    S3_COMPATIBLE,
                    CLOUDINARY_BACKUP,
                    WEB_FOLDER,
                    WEB_PROXY,
                    GCS,
                    AZURE_BLOB,
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
                        AKENEO_PIM -> Value.AKENEO_PIM
                        S3 -> Value.S3
                        S3_COMPATIBLE -> Value.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Value.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Value.WEB_FOLDER
                        WEB_PROXY -> Value.WEB_PROXY
                        GCS -> Value.GCS
                        AZURE_BLOB -> Value.AZURE_BLOB
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
                        AKENEO_PIM -> Known.AKENEO_PIM
                        S3 -> Known.S3
                        S3_COMPATIBLE -> Known.S3_COMPATIBLE
                        CLOUDINARY_BACKUP -> Known.CLOUDINARY_BACKUP
                        WEB_FOLDER -> Known.WEB_FOLDER
                        WEB_PROXY -> Known.WEB_PROXY
                        GCS -> Known.GCS
                        AZURE_BLOB -> Known.AZURE_BLOB
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

                return other is AkeneoPimOrigin &&
                    baseUrl == other.baseUrl &&
                    clientId == other.clientId &&
                    clientSecret == other.clientSecret &&
                    name == other.name &&
                    password == other.password &&
                    type == other.type &&
                    username == other.username &&
                    baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                    includeCanonicalHeader == other.includeCanonicalHeader &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    baseUrl,
                    clientId,
                    clientSecret,
                    name,
                    password,
                    type,
                    username,
                    baseUrlForCanonicalHeader,
                    includeCanonicalHeader,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "AkeneoPimOrigin{baseUrl=$baseUrl, clientId=$clientId, clientSecret=$clientSecret, name=$name, password=$password, type=$type, username=$username, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, includeCanonicalHeader=$includeCanonicalHeader, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OriginCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "OriginCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
