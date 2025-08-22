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
import com.imagekit.api.core.allMaxBy
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Origin object as returned by the API (sensitive fields removed). */
@JsonDeserialize(using = OriginListResponse.Deserializer::class)
@JsonSerialize(using = OriginListResponse.Serializer::class)
class OriginListResponse
private constructor(
    private val s3: S3? = null,
    private val s3Compatible: S3Compatible? = null,
    private val cloudinaryBackup: CloudinaryBackup? = null,
    private val webFolder: WebFolder? = null,
    private val webProxy: WebProxy? = null,
    private val googleCloudStorageGcs: GoogleCloudStorageGcs? = null,
    private val azureBlobStorage: AzureBlobStorage? = null,
    private val akeneoPim: AkeneoPim? = null,
    private val _json: JsonValue? = null,
) {

    fun s3(): Optional<S3> = Optional.ofNullable(s3)

    fun s3Compatible(): Optional<S3Compatible> = Optional.ofNullable(s3Compatible)

    fun cloudinaryBackup(): Optional<CloudinaryBackup> = Optional.ofNullable(cloudinaryBackup)

    fun webFolder(): Optional<WebFolder> = Optional.ofNullable(webFolder)

    fun webProxy(): Optional<WebProxy> = Optional.ofNullable(webProxy)

    fun googleCloudStorageGcs(): Optional<GoogleCloudStorageGcs> =
        Optional.ofNullable(googleCloudStorageGcs)

    fun azureBlobStorage(): Optional<AzureBlobStorage> = Optional.ofNullable(azureBlobStorage)

    fun akeneoPim(): Optional<AkeneoPim> = Optional.ofNullable(akeneoPim)

    fun isS3(): Boolean = s3 != null

    fun isS3Compatible(): Boolean = s3Compatible != null

    fun isCloudinaryBackup(): Boolean = cloudinaryBackup != null

    fun isWebFolder(): Boolean = webFolder != null

    fun isWebProxy(): Boolean = webProxy != null

    fun isGoogleCloudStorageGcs(): Boolean = googleCloudStorageGcs != null

    fun isAzureBlobStorage(): Boolean = azureBlobStorage != null

    fun isAkeneoPim(): Boolean = akeneoPim != null

    fun asS3(): S3 = s3.getOrThrow("s3")

    fun asS3Compatible(): S3Compatible = s3Compatible.getOrThrow("s3Compatible")

    fun asCloudinaryBackup(): CloudinaryBackup = cloudinaryBackup.getOrThrow("cloudinaryBackup")

    fun asWebFolder(): WebFolder = webFolder.getOrThrow("webFolder")

    fun asWebProxy(): WebProxy = webProxy.getOrThrow("webProxy")

    fun asGoogleCloudStorageGcs(): GoogleCloudStorageGcs =
        googleCloudStorageGcs.getOrThrow("googleCloudStorageGcs")

    fun asAzureBlobStorage(): AzureBlobStorage = azureBlobStorage.getOrThrow("azureBlobStorage")

    fun asAkeneoPim(): AkeneoPim = akeneoPim.getOrThrow("akeneoPim")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            s3 != null -> visitor.visitS3(s3)
            s3Compatible != null -> visitor.visitS3Compatible(s3Compatible)
            cloudinaryBackup != null -> visitor.visitCloudinaryBackup(cloudinaryBackup)
            webFolder != null -> visitor.visitWebFolder(webFolder)
            webProxy != null -> visitor.visitWebProxy(webProxy)
            googleCloudStorageGcs != null ->
                visitor.visitGoogleCloudStorageGcs(googleCloudStorageGcs)
            azureBlobStorage != null -> visitor.visitAzureBlobStorage(azureBlobStorage)
            akeneoPim != null -> visitor.visitAkeneoPim(akeneoPim)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): OriginListResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitS3(s3: S3) {
                    s3.validate()
                }

                override fun visitS3Compatible(s3Compatible: S3Compatible) {
                    s3Compatible.validate()
                }

                override fun visitCloudinaryBackup(cloudinaryBackup: CloudinaryBackup) {
                    cloudinaryBackup.validate()
                }

                override fun visitWebFolder(webFolder: WebFolder) {
                    webFolder.validate()
                }

                override fun visitWebProxy(webProxy: WebProxy) {
                    webProxy.validate()
                }

                override fun visitGoogleCloudStorageGcs(
                    googleCloudStorageGcs: GoogleCloudStorageGcs
                ) {
                    googleCloudStorageGcs.validate()
                }

                override fun visitAzureBlobStorage(azureBlobStorage: AzureBlobStorage) {
                    azureBlobStorage.validate()
                }

                override fun visitAkeneoPim(akeneoPim: AkeneoPim) {
                    akeneoPim.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitS3(s3: S3) = s3.validity()

                override fun visitS3Compatible(s3Compatible: S3Compatible) = s3Compatible.validity()

                override fun visitCloudinaryBackup(cloudinaryBackup: CloudinaryBackup) =
                    cloudinaryBackup.validity()

                override fun visitWebFolder(webFolder: WebFolder) = webFolder.validity()

                override fun visitWebProxy(webProxy: WebProxy) = webProxy.validity()

                override fun visitGoogleCloudStorageGcs(
                    googleCloudStorageGcs: GoogleCloudStorageGcs
                ) = googleCloudStorageGcs.validity()

                override fun visitAzureBlobStorage(azureBlobStorage: AzureBlobStorage) =
                    azureBlobStorage.validity()

                override fun visitAkeneoPim(akeneoPim: AkeneoPim) = akeneoPim.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OriginListResponse &&
            s3 == other.s3 &&
            s3Compatible == other.s3Compatible &&
            cloudinaryBackup == other.cloudinaryBackup &&
            webFolder == other.webFolder &&
            webProxy == other.webProxy &&
            googleCloudStorageGcs == other.googleCloudStorageGcs &&
            azureBlobStorage == other.azureBlobStorage &&
            akeneoPim == other.akeneoPim
    }

    override fun hashCode(): Int =
        Objects.hash(
            s3,
            s3Compatible,
            cloudinaryBackup,
            webFolder,
            webProxy,
            googleCloudStorageGcs,
            azureBlobStorage,
            akeneoPim,
        )

    override fun toString(): String =
        when {
            s3 != null -> "OriginListResponse{s3=$s3}"
            s3Compatible != null -> "OriginListResponse{s3Compatible=$s3Compatible}"
            cloudinaryBackup != null -> "OriginListResponse{cloudinaryBackup=$cloudinaryBackup}"
            webFolder != null -> "OriginListResponse{webFolder=$webFolder}"
            webProxy != null -> "OriginListResponse{webProxy=$webProxy}"
            googleCloudStorageGcs != null ->
                "OriginListResponse{googleCloudStorageGcs=$googleCloudStorageGcs}"
            azureBlobStorage != null -> "OriginListResponse{azureBlobStorage=$azureBlobStorage}"
            akeneoPim != null -> "OriginListResponse{akeneoPim=$akeneoPim}"
            _json != null -> "OriginListResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid OriginListResponse")
        }

    companion object {

        @JvmStatic fun ofS3(s3: S3) = OriginListResponse(s3 = s3)

        @JvmStatic
        fun ofS3Compatible(s3Compatible: S3Compatible) =
            OriginListResponse(s3Compatible = s3Compatible)

        @JvmStatic
        fun ofCloudinaryBackup(cloudinaryBackup: CloudinaryBackup) =
            OriginListResponse(cloudinaryBackup = cloudinaryBackup)

        @JvmStatic fun ofWebFolder(webFolder: WebFolder) = OriginListResponse(webFolder = webFolder)

        @JvmStatic fun ofWebProxy(webProxy: WebProxy) = OriginListResponse(webProxy = webProxy)

        @JvmStatic
        fun ofGoogleCloudStorageGcs(googleCloudStorageGcs: GoogleCloudStorageGcs) =
            OriginListResponse(googleCloudStorageGcs = googleCloudStorageGcs)

        @JvmStatic
        fun ofAzureBlobStorage(azureBlobStorage: AzureBlobStorage) =
            OriginListResponse(azureBlobStorage = azureBlobStorage)

        @JvmStatic fun ofAkeneoPim(akeneoPim: AkeneoPim) = OriginListResponse(akeneoPim = akeneoPim)
    }

    /**
     * An interface that defines how to map each variant of [OriginListResponse] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitS3(s3: S3): T

        fun visitS3Compatible(s3Compatible: S3Compatible): T

        fun visitCloudinaryBackup(cloudinaryBackup: CloudinaryBackup): T

        fun visitWebFolder(webFolder: WebFolder): T

        fun visitWebProxy(webProxy: WebProxy): T

        fun visitGoogleCloudStorageGcs(googleCloudStorageGcs: GoogleCloudStorageGcs): T

        fun visitAzureBlobStorage(azureBlobStorage: AzureBlobStorage): T

        fun visitAkeneoPim(akeneoPim: AkeneoPim): T

        /**
         * Maps an unknown variant of [OriginListResponse] to a value of type [T].
         *
         * An instance of [OriginListResponse] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws ImageKitInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw ImageKitInvalidDataException("Unknown OriginListResponse: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<OriginListResponse>(OriginListResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): OriginListResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<S3>())?.let {
                            OriginListResponse(s3 = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<S3Compatible>())?.let {
                            OriginListResponse(s3Compatible = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<CloudinaryBackup>())?.let {
                            OriginListResponse(cloudinaryBackup = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<WebFolder>())?.let {
                            OriginListResponse(webFolder = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<WebProxy>())?.let {
                            OriginListResponse(webProxy = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<GoogleCloudStorageGcs>())?.let {
                            OriginListResponse(googleCloudStorageGcs = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<AzureBlobStorage>())?.let {
                            OriginListResponse(azureBlobStorage = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<AkeneoPim>())?.let {
                            OriginListResponse(akeneoPim = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> OriginListResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<OriginListResponse>(OriginListResponse::class) {

        override fun serialize(
            value: OriginListResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.s3 != null -> generator.writeObject(value.s3)
                value.s3Compatible != null -> generator.writeObject(value.s3Compatible)
                value.cloudinaryBackup != null -> generator.writeObject(value.cloudinaryBackup)
                value.webFolder != null -> generator.writeObject(value.webFolder)
                value.webProxy != null -> generator.writeObject(value.webProxy)
                value.googleCloudStorageGcs != null ->
                    generator.writeObject(value.googleCloudStorageGcs)
                value.azureBlobStorage != null -> generator.writeObject(value.azureBlobStorage)
                value.akeneoPim != null -> generator.writeObject(value.akeneoPim)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid OriginListResponse")
            }
        }
    }

    class S3
    private constructor(
        private val id: JsonField<String>,
        private val bucket: JsonField<String>,
        private val includeCanonicalHeader: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val prefix: JsonField<String>,
        private val type: JsonField<Type>,
        private val baseUrlForCanonicalHeader: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bucket") @ExcludeMissing bucket: JsonField<String> = JsonMissing.of(),
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("prefix") @ExcludeMissing prefix: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            bucket,
            includeCanonicalHeader,
            name,
            prefix,
            type,
            baseUrlForCanonicalHeader,
            mutableMapOf(),
        )

        /**
         * Unique identifier for the origin. This is generated by ImageKit when you create a new
         * origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * S3 bucket name.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun bucket(): String = bucket.getRequired("bucket")

        /**
         * Whether to send a Canonical header.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun includeCanonicalHeader(): Boolean =
            includeCanonicalHeader.getRequired("includeCanonicalHeader")

        /**
         * Display name of the origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Path prefix inside the bucket.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun prefix(): String = prefix.getRequired("prefix")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * URL used in the Canonical header (if enabled).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun baseUrlForCanonicalHeader(): Optional<String> =
            baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [bucket].
         *
         * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bucket") @ExcludeMissing fun _bucket(): JsonField<String> = bucket

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
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [prefix].
         *
         * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [baseUrlForCanonicalHeader].
         *
         * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("baseUrlForCanonicalHeader")
        @ExcludeMissing
        fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

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
             * Returns a mutable builder for constructing an instance of [S3].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .bucket()
             * .includeCanonicalHeader()
             * .name()
             * .prefix()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [S3]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var bucket: JsonField<String>? = null
            private var includeCanonicalHeader: JsonField<Boolean>? = null
            private var name: JsonField<String>? = null
            private var prefix: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(s3: S3) = apply {
                id = s3.id
                bucket = s3.bucket
                includeCanonicalHeader = s3.includeCanonicalHeader
                name = s3.name
                prefix = s3.prefix
                type = s3.type
                baseUrlForCanonicalHeader = s3.baseUrlForCanonicalHeader
                additionalProperties = s3.additionalProperties.toMutableMap()
            }

            /**
             * Unique identifier for the origin. This is generated by ImageKit when you create a new
             * origin.
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** S3 bucket name. */
            fun bucket(bucket: String) = bucket(JsonField.of(bucket))

            /**
             * Sets [Builder.bucket] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bucket] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bucket(bucket: JsonField<String>) = apply { this.bucket = bucket }

            /** Whether to send a Canonical header. */
            fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

            /**
             * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeCanonicalHeader] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                this.includeCanonicalHeader = includeCanonicalHeader
            }

            /** Display name of the origin. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Path prefix inside the bucket. */
            fun prefix(prefix: String) = prefix(JsonField.of(prefix))

            /**
             * Sets [Builder.prefix] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prefix] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) = apply {
                this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
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
             * Returns an immutable instance of [S3].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .bucket()
             * .includeCanonicalHeader()
             * .name()
             * .prefix()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): S3 =
                S3(
                    checkRequired("id", id),
                    checkRequired("bucket", bucket),
                    checkRequired("includeCanonicalHeader", includeCanonicalHeader),
                    checkRequired("name", name),
                    checkRequired("prefix", prefix),
                    checkRequired("type", type),
                    baseUrlForCanonicalHeader,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): S3 = apply {
            if (validated) {
                return@apply
            }

            id()
            bucket()
            includeCanonicalHeader()
            name()
            prefix()
            type().validate()
            baseUrlForCanonicalHeader()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (bucket.asKnown().isPresent) 1 else 0) +
                (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (prefix.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0)

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

                @JvmField val S3 = of("S3")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                S3
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
                S3,
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
                    S3 -> Value.S3
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
                    S3 -> Known.S3
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is S3 &&
                id == other.id &&
                bucket == other.bucket &&
                includeCanonicalHeader == other.includeCanonicalHeader &&
                name == other.name &&
                prefix == other.prefix &&
                type == other.type &&
                baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                bucket,
                includeCanonicalHeader,
                name,
                prefix,
                type,
                baseUrlForCanonicalHeader,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "S3{id=$id, bucket=$bucket, includeCanonicalHeader=$includeCanonicalHeader, name=$name, prefix=$prefix, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, additionalProperties=$additionalProperties}"
    }

    class S3Compatible
    private constructor(
        private val id: JsonField<String>,
        private val bucket: JsonField<String>,
        private val endpoint: JsonField<String>,
        private val includeCanonicalHeader: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val prefix: JsonField<String>,
        private val s3ForcePathStyle: JsonField<Boolean>,
        private val type: JsonField<Type>,
        private val baseUrlForCanonicalHeader: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bucket") @ExcludeMissing bucket: JsonField<String> = JsonMissing.of(),
            @JsonProperty("endpoint")
            @ExcludeMissing
            endpoint: JsonField<String> = JsonMissing.of(),
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("prefix") @ExcludeMissing prefix: JsonField<String> = JsonMissing.of(),
            @JsonProperty("s3ForcePathStyle")
            @ExcludeMissing
            s3ForcePathStyle: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            bucket,
            endpoint,
            includeCanonicalHeader,
            name,
            prefix,
            s3ForcePathStyle,
            type,
            baseUrlForCanonicalHeader,
            mutableMapOf(),
        )

        /**
         * Unique identifier for the origin. This is generated by ImageKit when you create a new
         * origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * S3 bucket name.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun bucket(): String = bucket.getRequired("bucket")

        /**
         * Custom S3-compatible endpoint.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun endpoint(): String = endpoint.getRequired("endpoint")

        /**
         * Whether to send a Canonical header.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun includeCanonicalHeader(): Boolean =
            includeCanonicalHeader.getRequired("includeCanonicalHeader")

        /**
         * Display name of the origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Path prefix inside the bucket.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun prefix(): String = prefix.getRequired("prefix")

        /**
         * Use path-style S3 URLs?
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun s3ForcePathStyle(): Boolean = s3ForcePathStyle.getRequired("s3ForcePathStyle")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * URL used in the Canonical header (if enabled).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun baseUrlForCanonicalHeader(): Optional<String> =
            baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [bucket].
         *
         * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bucket") @ExcludeMissing fun _bucket(): JsonField<String> = bucket

        /**
         * Returns the raw JSON value of [endpoint].
         *
         * Unlike [endpoint], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("endpoint") @ExcludeMissing fun _endpoint(): JsonField<String> = endpoint

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
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [prefix].
         *
         * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

        /**
         * Returns the raw JSON value of [s3ForcePathStyle].
         *
         * Unlike [s3ForcePathStyle], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("s3ForcePathStyle")
        @ExcludeMissing
        fun _s3ForcePathStyle(): JsonField<Boolean> = s3ForcePathStyle

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [baseUrlForCanonicalHeader].
         *
         * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("baseUrlForCanonicalHeader")
        @ExcludeMissing
        fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

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
             * Returns a mutable builder for constructing an instance of [S3Compatible].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .bucket()
             * .endpoint()
             * .includeCanonicalHeader()
             * .name()
             * .prefix()
             * .s3ForcePathStyle()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [S3Compatible]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var bucket: JsonField<String>? = null
            private var endpoint: JsonField<String>? = null
            private var includeCanonicalHeader: JsonField<Boolean>? = null
            private var name: JsonField<String>? = null
            private var prefix: JsonField<String>? = null
            private var s3ForcePathStyle: JsonField<Boolean>? = null
            private var type: JsonField<Type>? = null
            private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(s3Compatible: S3Compatible) = apply {
                id = s3Compatible.id
                bucket = s3Compatible.bucket
                endpoint = s3Compatible.endpoint
                includeCanonicalHeader = s3Compatible.includeCanonicalHeader
                name = s3Compatible.name
                prefix = s3Compatible.prefix
                s3ForcePathStyle = s3Compatible.s3ForcePathStyle
                type = s3Compatible.type
                baseUrlForCanonicalHeader = s3Compatible.baseUrlForCanonicalHeader
                additionalProperties = s3Compatible.additionalProperties.toMutableMap()
            }

            /**
             * Unique identifier for the origin. This is generated by ImageKit when you create a new
             * origin.
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** S3 bucket name. */
            fun bucket(bucket: String) = bucket(JsonField.of(bucket))

            /**
             * Sets [Builder.bucket] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bucket] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bucket(bucket: JsonField<String>) = apply { this.bucket = bucket }

            /** Custom S3-compatible endpoint. */
            fun endpoint(endpoint: String) = endpoint(JsonField.of(endpoint))

            /**
             * Sets [Builder.endpoint] to an arbitrary JSON value.
             *
             * You should usually call [Builder.endpoint] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun endpoint(endpoint: JsonField<String>) = apply { this.endpoint = endpoint }

            /** Whether to send a Canonical header. */
            fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

            /**
             * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeCanonicalHeader] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                this.includeCanonicalHeader = includeCanonicalHeader
            }

            /** Display name of the origin. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Path prefix inside the bucket. */
            fun prefix(prefix: String) = prefix(JsonField.of(prefix))

            /**
             * Sets [Builder.prefix] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prefix] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

            /** Use path-style S3 URLs? */
            fun s3ForcePathStyle(s3ForcePathStyle: Boolean) =
                s3ForcePathStyle(JsonField.of(s3ForcePathStyle))

            /**
             * Sets [Builder.s3ForcePathStyle] to an arbitrary JSON value.
             *
             * You should usually call [Builder.s3ForcePathStyle] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun s3ForcePathStyle(s3ForcePathStyle: JsonField<Boolean>) = apply {
                this.s3ForcePathStyle = s3ForcePathStyle
            }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) = apply {
                this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
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
             * Returns an immutable instance of [S3Compatible].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .bucket()
             * .endpoint()
             * .includeCanonicalHeader()
             * .name()
             * .prefix()
             * .s3ForcePathStyle()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): S3Compatible =
                S3Compatible(
                    checkRequired("id", id),
                    checkRequired("bucket", bucket),
                    checkRequired("endpoint", endpoint),
                    checkRequired("includeCanonicalHeader", includeCanonicalHeader),
                    checkRequired("name", name),
                    checkRequired("prefix", prefix),
                    checkRequired("s3ForcePathStyle", s3ForcePathStyle),
                    checkRequired("type", type),
                    baseUrlForCanonicalHeader,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): S3Compatible = apply {
            if (validated) {
                return@apply
            }

            id()
            bucket()
            endpoint()
            includeCanonicalHeader()
            name()
            prefix()
            s3ForcePathStyle()
            type().validate()
            baseUrlForCanonicalHeader()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (bucket.asKnown().isPresent) 1 else 0) +
                (if (endpoint.asKnown().isPresent) 1 else 0) +
                (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (prefix.asKnown().isPresent) 1 else 0) +
                (if (s3ForcePathStyle.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0)

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

                @JvmField val S3_COMPATIBLE = of("S3_COMPATIBLE")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                S3_COMPATIBLE
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
                S3_COMPATIBLE,
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
                    S3_COMPATIBLE -> Value.S3_COMPATIBLE
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
                    S3_COMPATIBLE -> Known.S3_COMPATIBLE
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is S3Compatible &&
                id == other.id &&
                bucket == other.bucket &&
                endpoint == other.endpoint &&
                includeCanonicalHeader == other.includeCanonicalHeader &&
                name == other.name &&
                prefix == other.prefix &&
                s3ForcePathStyle == other.s3ForcePathStyle &&
                type == other.type &&
                baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                bucket,
                endpoint,
                includeCanonicalHeader,
                name,
                prefix,
                s3ForcePathStyle,
                type,
                baseUrlForCanonicalHeader,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "S3Compatible{id=$id, bucket=$bucket, endpoint=$endpoint, includeCanonicalHeader=$includeCanonicalHeader, name=$name, prefix=$prefix, s3ForcePathStyle=$s3ForcePathStyle, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, additionalProperties=$additionalProperties}"
    }

    class CloudinaryBackup
    private constructor(
        private val id: JsonField<String>,
        private val bucket: JsonField<String>,
        private val includeCanonicalHeader: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val prefix: JsonField<String>,
        private val type: JsonField<Type>,
        private val baseUrlForCanonicalHeader: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bucket") @ExcludeMissing bucket: JsonField<String> = JsonMissing.of(),
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("prefix") @ExcludeMissing prefix: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            bucket,
            includeCanonicalHeader,
            name,
            prefix,
            type,
            baseUrlForCanonicalHeader,
            mutableMapOf(),
        )

        /**
         * Unique identifier for the origin. This is generated by ImageKit when you create a new
         * origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * S3 bucket name.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun bucket(): String = bucket.getRequired("bucket")

        /**
         * Whether to send a Canonical header.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun includeCanonicalHeader(): Boolean =
            includeCanonicalHeader.getRequired("includeCanonicalHeader")

        /**
         * Display name of the origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Path prefix inside the bucket.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun prefix(): String = prefix.getRequired("prefix")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * URL used in the Canonical header (if enabled).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun baseUrlForCanonicalHeader(): Optional<String> =
            baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [bucket].
         *
         * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bucket") @ExcludeMissing fun _bucket(): JsonField<String> = bucket

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
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [prefix].
         *
         * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [baseUrlForCanonicalHeader].
         *
         * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("baseUrlForCanonicalHeader")
        @ExcludeMissing
        fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

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
             * Returns a mutable builder for constructing an instance of [CloudinaryBackup].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .bucket()
             * .includeCanonicalHeader()
             * .name()
             * .prefix()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CloudinaryBackup]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var bucket: JsonField<String>? = null
            private var includeCanonicalHeader: JsonField<Boolean>? = null
            private var name: JsonField<String>? = null
            private var prefix: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(cloudinaryBackup: CloudinaryBackup) = apply {
                id = cloudinaryBackup.id
                bucket = cloudinaryBackup.bucket
                includeCanonicalHeader = cloudinaryBackup.includeCanonicalHeader
                name = cloudinaryBackup.name
                prefix = cloudinaryBackup.prefix
                type = cloudinaryBackup.type
                baseUrlForCanonicalHeader = cloudinaryBackup.baseUrlForCanonicalHeader
                additionalProperties = cloudinaryBackup.additionalProperties.toMutableMap()
            }

            /**
             * Unique identifier for the origin. This is generated by ImageKit when you create a new
             * origin.
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** S3 bucket name. */
            fun bucket(bucket: String) = bucket(JsonField.of(bucket))

            /**
             * Sets [Builder.bucket] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bucket] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bucket(bucket: JsonField<String>) = apply { this.bucket = bucket }

            /** Whether to send a Canonical header. */
            fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

            /**
             * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeCanonicalHeader] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                this.includeCanonicalHeader = includeCanonicalHeader
            }

            /** Display name of the origin. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Path prefix inside the bucket. */
            fun prefix(prefix: String) = prefix(JsonField.of(prefix))

            /**
             * Sets [Builder.prefix] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prefix] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) = apply {
                this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
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
             * Returns an immutable instance of [CloudinaryBackup].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .bucket()
             * .includeCanonicalHeader()
             * .name()
             * .prefix()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): CloudinaryBackup =
                CloudinaryBackup(
                    checkRequired("id", id),
                    checkRequired("bucket", bucket),
                    checkRequired("includeCanonicalHeader", includeCanonicalHeader),
                    checkRequired("name", name),
                    checkRequired("prefix", prefix),
                    checkRequired("type", type),
                    baseUrlForCanonicalHeader,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CloudinaryBackup = apply {
            if (validated) {
                return@apply
            }

            id()
            bucket()
            includeCanonicalHeader()
            name()
            prefix()
            type().validate()
            baseUrlForCanonicalHeader()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (bucket.asKnown().isPresent) 1 else 0) +
                (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (prefix.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0)

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

                @JvmField val CLOUDINARY_BACKUP = of("CLOUDINARY_BACKUP")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                CLOUDINARY_BACKUP
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
                CLOUDINARY_BACKUP,
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
                    CLOUDINARY_BACKUP -> Value.CLOUDINARY_BACKUP
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
                    CLOUDINARY_BACKUP -> Known.CLOUDINARY_BACKUP
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CloudinaryBackup &&
                id == other.id &&
                bucket == other.bucket &&
                includeCanonicalHeader == other.includeCanonicalHeader &&
                name == other.name &&
                prefix == other.prefix &&
                type == other.type &&
                baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                bucket,
                includeCanonicalHeader,
                name,
                prefix,
                type,
                baseUrlForCanonicalHeader,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CloudinaryBackup{id=$id, bucket=$bucket, includeCanonicalHeader=$includeCanonicalHeader, name=$name, prefix=$prefix, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, additionalProperties=$additionalProperties}"
    }

    class WebFolder
    private constructor(
        private val id: JsonField<String>,
        private val baseUrl: JsonField<String>,
        private val forwardHostHeaderToOrigin: JsonField<Boolean>,
        private val includeCanonicalHeader: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val type: JsonField<Type>,
        private val baseUrlForCanonicalHeader: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("baseUrl") @ExcludeMissing baseUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("forwardHostHeaderToOrigin")
            @ExcludeMissing
            forwardHostHeaderToOrigin: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            baseUrl,
            forwardHostHeaderToOrigin,
            includeCanonicalHeader,
            name,
            type,
            baseUrlForCanonicalHeader,
            mutableMapOf(),
        )

        /**
         * Unique identifier for the origin. This is generated by ImageKit when you create a new
         * origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Root URL for the web folder origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun baseUrl(): String = baseUrl.getRequired("baseUrl")

        /**
         * Forward the Host header to origin?
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun forwardHostHeaderToOrigin(): Boolean =
            forwardHostHeaderToOrigin.getRequired("forwardHostHeaderToOrigin")

        /**
         * Whether to send a Canonical header.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun includeCanonicalHeader(): Boolean =
            includeCanonicalHeader.getRequired("includeCanonicalHeader")

        /**
         * Display name of the origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * URL used in the Canonical header (if enabled).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun baseUrlForCanonicalHeader(): Optional<String> =
            baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [baseUrl].
         *
         * Unlike [baseUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("baseUrl") @ExcludeMissing fun _baseUrl(): JsonField<String> = baseUrl

        /**
         * Returns the raw JSON value of [forwardHostHeaderToOrigin].
         *
         * Unlike [forwardHostHeaderToOrigin], this method doesn't throw if the JSON field has an
         * unexpected type.
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
         * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("baseUrlForCanonicalHeader")
        @ExcludeMissing
        fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

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
             * Returns a mutable builder for constructing an instance of [WebFolder].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .baseUrl()
             * .forwardHostHeaderToOrigin()
             * .includeCanonicalHeader()
             * .name()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [WebFolder]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var baseUrl: JsonField<String>? = null
            private var forwardHostHeaderToOrigin: JsonField<Boolean>? = null
            private var includeCanonicalHeader: JsonField<Boolean>? = null
            private var name: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(webFolder: WebFolder) = apply {
                id = webFolder.id
                baseUrl = webFolder.baseUrl
                forwardHostHeaderToOrigin = webFolder.forwardHostHeaderToOrigin
                includeCanonicalHeader = webFolder.includeCanonicalHeader
                name = webFolder.name
                type = webFolder.type
                baseUrlForCanonicalHeader = webFolder.baseUrlForCanonicalHeader
                additionalProperties = webFolder.additionalProperties.toMutableMap()
            }

            /**
             * Unique identifier for the origin. This is generated by ImageKit when you create a new
             * origin.
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Root URL for the web folder origin. */
            fun baseUrl(baseUrl: String) = baseUrl(JsonField.of(baseUrl))

            /**
             * Sets [Builder.baseUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.baseUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun baseUrl(baseUrl: JsonField<String>) = apply { this.baseUrl = baseUrl }

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
            fun forwardHostHeaderToOrigin(forwardHostHeaderToOrigin: JsonField<Boolean>) = apply {
                this.forwardHostHeaderToOrigin = forwardHostHeaderToOrigin
            }

            /** Whether to send a Canonical header. */
            fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

            /**
             * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeCanonicalHeader] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                this.includeCanonicalHeader = includeCanonicalHeader
            }

            /** Display name of the origin. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) = apply {
                this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
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
             * Returns an immutable instance of [WebFolder].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .baseUrl()
             * .forwardHostHeaderToOrigin()
             * .includeCanonicalHeader()
             * .name()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): WebFolder =
                WebFolder(
                    checkRequired("id", id),
                    checkRequired("baseUrl", baseUrl),
                    checkRequired("forwardHostHeaderToOrigin", forwardHostHeaderToOrigin),
                    checkRequired("includeCanonicalHeader", includeCanonicalHeader),
                    checkRequired("name", name),
                    checkRequired("type", type),
                    baseUrlForCanonicalHeader,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): WebFolder = apply {
            if (validated) {
                return@apply
            }

            id()
            baseUrl()
            forwardHostHeaderToOrigin()
            includeCanonicalHeader()
            name()
            type().validate()
            baseUrlForCanonicalHeader()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (baseUrl.asKnown().isPresent) 1 else 0) +
                (if (forwardHostHeaderToOrigin.asKnown().isPresent) 1 else 0) +
                (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0)

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

                @JvmField val WEB_FOLDER = of("WEB_FOLDER")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                WEB_FOLDER
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
                WEB_FOLDER,
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
                    WEB_FOLDER -> Value.WEB_FOLDER
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
                    WEB_FOLDER -> Known.WEB_FOLDER
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is WebFolder &&
                id == other.id &&
                baseUrl == other.baseUrl &&
                forwardHostHeaderToOrigin == other.forwardHostHeaderToOrigin &&
                includeCanonicalHeader == other.includeCanonicalHeader &&
                name == other.name &&
                type == other.type &&
                baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                baseUrl,
                forwardHostHeaderToOrigin,
                includeCanonicalHeader,
                name,
                type,
                baseUrlForCanonicalHeader,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "WebFolder{id=$id, baseUrl=$baseUrl, forwardHostHeaderToOrigin=$forwardHostHeaderToOrigin, includeCanonicalHeader=$includeCanonicalHeader, name=$name, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, additionalProperties=$additionalProperties}"
    }

    class WebProxy
    private constructor(
        private val id: JsonField<String>,
        private val includeCanonicalHeader: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val type: JsonField<Type>,
        private val baseUrlForCanonicalHeader: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
        ) : this(id, includeCanonicalHeader, name, type, baseUrlForCanonicalHeader, mutableMapOf())

        /**
         * Unique identifier for the origin. This is generated by ImageKit when you create a new
         * origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Whether to send a Canonical header.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun includeCanonicalHeader(): Boolean =
            includeCanonicalHeader.getRequired("includeCanonicalHeader")

        /**
         * Display name of the origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * URL used in the Canonical header (if enabled).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun baseUrlForCanonicalHeader(): Optional<String> =
            baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
         * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("baseUrlForCanonicalHeader")
        @ExcludeMissing
        fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

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
             * Returns a mutable builder for constructing an instance of [WebProxy].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .includeCanonicalHeader()
             * .name()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [WebProxy]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var includeCanonicalHeader: JsonField<Boolean>? = null
            private var name: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(webProxy: WebProxy) = apply {
                id = webProxy.id
                includeCanonicalHeader = webProxy.includeCanonicalHeader
                name = webProxy.name
                type = webProxy.type
                baseUrlForCanonicalHeader = webProxy.baseUrlForCanonicalHeader
                additionalProperties = webProxy.additionalProperties.toMutableMap()
            }

            /**
             * Unique identifier for the origin. This is generated by ImageKit when you create a new
             * origin.
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Whether to send a Canonical header. */
            fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

            /**
             * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeCanonicalHeader] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                this.includeCanonicalHeader = includeCanonicalHeader
            }

            /** Display name of the origin. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) = apply {
                this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
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
             * Returns an immutable instance of [WebProxy].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .includeCanonicalHeader()
             * .name()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): WebProxy =
                WebProxy(
                    checkRequired("id", id),
                    checkRequired("includeCanonicalHeader", includeCanonicalHeader),
                    checkRequired("name", name),
                    checkRequired("type", type),
                    baseUrlForCanonicalHeader,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): WebProxy = apply {
            if (validated) {
                return@apply
            }

            id()
            includeCanonicalHeader()
            name()
            type().validate()
            baseUrlForCanonicalHeader()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0)

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

                @JvmField val WEB_PROXY = of("WEB_PROXY")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                WEB_PROXY
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
                WEB_PROXY,
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
                    WEB_PROXY -> Value.WEB_PROXY
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
                    WEB_PROXY -> Known.WEB_PROXY
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is WebProxy &&
                id == other.id &&
                includeCanonicalHeader == other.includeCanonicalHeader &&
                name == other.name &&
                type == other.type &&
                baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                includeCanonicalHeader,
                name,
                type,
                baseUrlForCanonicalHeader,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "WebProxy{id=$id, includeCanonicalHeader=$includeCanonicalHeader, name=$name, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, additionalProperties=$additionalProperties}"
    }

    class GoogleCloudStorageGcs
    private constructor(
        private val id: JsonField<String>,
        private val bucket: JsonField<String>,
        private val clientEmail: JsonField<String>,
        private val includeCanonicalHeader: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val prefix: JsonField<String>,
        private val type: JsonField<Type>,
        private val baseUrlForCanonicalHeader: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bucket") @ExcludeMissing bucket: JsonField<String> = JsonMissing.of(),
            @JsonProperty("clientEmail")
            @ExcludeMissing
            clientEmail: JsonField<String> = JsonMissing.of(),
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("prefix") @ExcludeMissing prefix: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            bucket,
            clientEmail,
            includeCanonicalHeader,
            name,
            prefix,
            type,
            baseUrlForCanonicalHeader,
            mutableMapOf(),
        )

        /**
         * Unique identifier for the origin. This is generated by ImageKit when you create a new
         * origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun bucket(): String = bucket.getRequired("bucket")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun clientEmail(): String = clientEmail.getRequired("clientEmail")

        /**
         * Whether to send a Canonical header.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun includeCanonicalHeader(): Boolean =
            includeCanonicalHeader.getRequired("includeCanonicalHeader")

        /**
         * Display name of the origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun prefix(): String = prefix.getRequired("prefix")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * URL used in the Canonical header (if enabled).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun baseUrlForCanonicalHeader(): Optional<String> =
            baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [bucket].
         *
         * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bucket") @ExcludeMissing fun _bucket(): JsonField<String> = bucket

        /**
         * Returns the raw JSON value of [clientEmail].
         *
         * Unlike [clientEmail], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("clientEmail")
        @ExcludeMissing
        fun _clientEmail(): JsonField<String> = clientEmail

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
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [prefix].
         *
         * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [baseUrlForCanonicalHeader].
         *
         * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("baseUrlForCanonicalHeader")
        @ExcludeMissing
        fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

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
             * Returns a mutable builder for constructing an instance of [GoogleCloudStorageGcs].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .bucket()
             * .clientEmail()
             * .includeCanonicalHeader()
             * .name()
             * .prefix()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [GoogleCloudStorageGcs]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var bucket: JsonField<String>? = null
            private var clientEmail: JsonField<String>? = null
            private var includeCanonicalHeader: JsonField<Boolean>? = null
            private var name: JsonField<String>? = null
            private var prefix: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(googleCloudStorageGcs: GoogleCloudStorageGcs) = apply {
                id = googleCloudStorageGcs.id
                bucket = googleCloudStorageGcs.bucket
                clientEmail = googleCloudStorageGcs.clientEmail
                includeCanonicalHeader = googleCloudStorageGcs.includeCanonicalHeader
                name = googleCloudStorageGcs.name
                prefix = googleCloudStorageGcs.prefix
                type = googleCloudStorageGcs.type
                baseUrlForCanonicalHeader = googleCloudStorageGcs.baseUrlForCanonicalHeader
                additionalProperties = googleCloudStorageGcs.additionalProperties.toMutableMap()
            }

            /**
             * Unique identifier for the origin. This is generated by ImageKit when you create a new
             * origin.
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun bucket(bucket: String) = bucket(JsonField.of(bucket))

            /**
             * Sets [Builder.bucket] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bucket] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bucket(bucket: JsonField<String>) = apply { this.bucket = bucket }

            fun clientEmail(clientEmail: String) = clientEmail(JsonField.of(clientEmail))

            /**
             * Sets [Builder.clientEmail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clientEmail] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clientEmail(clientEmail: JsonField<String>) = apply {
                this.clientEmail = clientEmail
            }

            /** Whether to send a Canonical header. */
            fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

            /**
             * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeCanonicalHeader] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                this.includeCanonicalHeader = includeCanonicalHeader
            }

            /** Display name of the origin. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun prefix(prefix: String) = prefix(JsonField.of(prefix))

            /**
             * Sets [Builder.prefix] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prefix] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) = apply {
                this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
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
             * Returns an immutable instance of [GoogleCloudStorageGcs].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .bucket()
             * .clientEmail()
             * .includeCanonicalHeader()
             * .name()
             * .prefix()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): GoogleCloudStorageGcs =
                GoogleCloudStorageGcs(
                    checkRequired("id", id),
                    checkRequired("bucket", bucket),
                    checkRequired("clientEmail", clientEmail),
                    checkRequired("includeCanonicalHeader", includeCanonicalHeader),
                    checkRequired("name", name),
                    checkRequired("prefix", prefix),
                    checkRequired("type", type),
                    baseUrlForCanonicalHeader,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): GoogleCloudStorageGcs = apply {
            if (validated) {
                return@apply
            }

            id()
            bucket()
            clientEmail()
            includeCanonicalHeader()
            name()
            prefix()
            type().validate()
            baseUrlForCanonicalHeader()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (bucket.asKnown().isPresent) 1 else 0) +
                (if (clientEmail.asKnown().isPresent) 1 else 0) +
                (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (prefix.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0)

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

                @JvmField val GCS = of("GCS")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                GCS
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
                GCS,
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
                    GCS -> Value.GCS
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
                    GCS -> Known.GCS
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is GoogleCloudStorageGcs &&
                id == other.id &&
                bucket == other.bucket &&
                clientEmail == other.clientEmail &&
                includeCanonicalHeader == other.includeCanonicalHeader &&
                name == other.name &&
                prefix == other.prefix &&
                type == other.type &&
                baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                bucket,
                clientEmail,
                includeCanonicalHeader,
                name,
                prefix,
                type,
                baseUrlForCanonicalHeader,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "GoogleCloudStorageGcs{id=$id, bucket=$bucket, clientEmail=$clientEmail, includeCanonicalHeader=$includeCanonicalHeader, name=$name, prefix=$prefix, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, additionalProperties=$additionalProperties}"
    }

    class AzureBlobStorage
    private constructor(
        private val id: JsonField<String>,
        private val accountName: JsonField<String>,
        private val container: JsonField<String>,
        private val includeCanonicalHeader: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val prefix: JsonField<String>,
        private val type: JsonField<Type>,
        private val baseUrlForCanonicalHeader: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("accountName")
            @ExcludeMissing
            accountName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("container")
            @ExcludeMissing
            container: JsonField<String> = JsonMissing.of(),
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("prefix") @ExcludeMissing prefix: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            accountName,
            container,
            includeCanonicalHeader,
            name,
            prefix,
            type,
            baseUrlForCanonicalHeader,
            mutableMapOf(),
        )

        /**
         * Unique identifier for the origin. This is generated by ImageKit when you create a new
         * origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun accountName(): String = accountName.getRequired("accountName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun container(): String = container.getRequired("container")

        /**
         * Whether to send a Canonical header.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun includeCanonicalHeader(): Boolean =
            includeCanonicalHeader.getRequired("includeCanonicalHeader")

        /**
         * Display name of the origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun prefix(): String = prefix.getRequired("prefix")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * URL used in the Canonical header (if enabled).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun baseUrlForCanonicalHeader(): Optional<String> =
            baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [accountName].
         *
         * Unlike [accountName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("accountName")
        @ExcludeMissing
        fun _accountName(): JsonField<String> = accountName

        /**
         * Returns the raw JSON value of [container].
         *
         * Unlike [container], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("container") @ExcludeMissing fun _container(): JsonField<String> = container

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
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [prefix].
         *
         * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [baseUrlForCanonicalHeader].
         *
         * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("baseUrlForCanonicalHeader")
        @ExcludeMissing
        fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

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
             * Returns a mutable builder for constructing an instance of [AzureBlobStorage].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .accountName()
             * .container()
             * .includeCanonicalHeader()
             * .name()
             * .prefix()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AzureBlobStorage]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var accountName: JsonField<String>? = null
            private var container: JsonField<String>? = null
            private var includeCanonicalHeader: JsonField<Boolean>? = null
            private var name: JsonField<String>? = null
            private var prefix: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(azureBlobStorage: AzureBlobStorage) = apply {
                id = azureBlobStorage.id
                accountName = azureBlobStorage.accountName
                container = azureBlobStorage.container
                includeCanonicalHeader = azureBlobStorage.includeCanonicalHeader
                name = azureBlobStorage.name
                prefix = azureBlobStorage.prefix
                type = azureBlobStorage.type
                baseUrlForCanonicalHeader = azureBlobStorage.baseUrlForCanonicalHeader
                additionalProperties = azureBlobStorage.additionalProperties.toMutableMap()
            }

            /**
             * Unique identifier for the origin. This is generated by ImageKit when you create a new
             * origin.
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun accountName(accountName: String) = accountName(JsonField.of(accountName))

            /**
             * Sets [Builder.accountName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.accountName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun accountName(accountName: JsonField<String>) = apply {
                this.accountName = accountName
            }

            fun container(container: String) = container(JsonField.of(container))

            /**
             * Sets [Builder.container] to an arbitrary JSON value.
             *
             * You should usually call [Builder.container] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun container(container: JsonField<String>) = apply { this.container = container }

            /** Whether to send a Canonical header. */
            fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

            /**
             * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeCanonicalHeader] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                this.includeCanonicalHeader = includeCanonicalHeader
            }

            /** Display name of the origin. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun prefix(prefix: String) = prefix(JsonField.of(prefix))

            /**
             * Sets [Builder.prefix] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prefix] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) = apply {
                this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
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
             * Returns an immutable instance of [AzureBlobStorage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .accountName()
             * .container()
             * .includeCanonicalHeader()
             * .name()
             * .prefix()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AzureBlobStorage =
                AzureBlobStorage(
                    checkRequired("id", id),
                    checkRequired("accountName", accountName),
                    checkRequired("container", container),
                    checkRequired("includeCanonicalHeader", includeCanonicalHeader),
                    checkRequired("name", name),
                    checkRequired("prefix", prefix),
                    checkRequired("type", type),
                    baseUrlForCanonicalHeader,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): AzureBlobStorage = apply {
            if (validated) {
                return@apply
            }

            id()
            accountName()
            container()
            includeCanonicalHeader()
            name()
            prefix()
            type().validate()
            baseUrlForCanonicalHeader()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (accountName.asKnown().isPresent) 1 else 0) +
                (if (container.asKnown().isPresent) 1 else 0) +
                (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (prefix.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0)

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

                @JvmField val AZURE_BLOB = of("AZURE_BLOB")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                AZURE_BLOB
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
                AZURE_BLOB,
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
                    AZURE_BLOB -> Value.AZURE_BLOB
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
                    AZURE_BLOB -> Known.AZURE_BLOB
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AzureBlobStorage &&
                id == other.id &&
                accountName == other.accountName &&
                container == other.container &&
                includeCanonicalHeader == other.includeCanonicalHeader &&
                name == other.name &&
                prefix == other.prefix &&
                type == other.type &&
                baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                accountName,
                container,
                includeCanonicalHeader,
                name,
                prefix,
                type,
                baseUrlForCanonicalHeader,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AzureBlobStorage{id=$id, accountName=$accountName, container=$container, includeCanonicalHeader=$includeCanonicalHeader, name=$name, prefix=$prefix, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, additionalProperties=$additionalProperties}"
    }

    class AkeneoPim
    private constructor(
        private val id: JsonField<String>,
        private val baseUrl: JsonField<String>,
        private val includeCanonicalHeader: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val type: JsonField<Type>,
        private val baseUrlForCanonicalHeader: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("baseUrl") @ExcludeMissing baseUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            baseUrl,
            includeCanonicalHeader,
            name,
            type,
            baseUrlForCanonicalHeader,
            mutableMapOf(),
        )

        /**
         * Unique identifier for the origin. This is generated by ImageKit when you create a new
         * origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Akeneo instance base URL.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun baseUrl(): String = baseUrl.getRequired("baseUrl")

        /**
         * Whether to send a Canonical header.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun includeCanonicalHeader(): Boolean =
            includeCanonicalHeader.getRequired("includeCanonicalHeader")

        /**
         * Display name of the origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * URL used in the Canonical header (if enabled).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun baseUrlForCanonicalHeader(): Optional<String> =
            baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [baseUrl].
         *
         * Unlike [baseUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("baseUrl") @ExcludeMissing fun _baseUrl(): JsonField<String> = baseUrl

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
         * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("baseUrlForCanonicalHeader")
        @ExcludeMissing
        fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

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
             * Returns a mutable builder for constructing an instance of [AkeneoPim].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .baseUrl()
             * .includeCanonicalHeader()
             * .name()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AkeneoPim]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var baseUrl: JsonField<String>? = null
            private var includeCanonicalHeader: JsonField<Boolean>? = null
            private var name: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(akeneoPim: AkeneoPim) = apply {
                id = akeneoPim.id
                baseUrl = akeneoPim.baseUrl
                includeCanonicalHeader = akeneoPim.includeCanonicalHeader
                name = akeneoPim.name
                type = akeneoPim.type
                baseUrlForCanonicalHeader = akeneoPim.baseUrlForCanonicalHeader
                additionalProperties = akeneoPim.additionalProperties.toMutableMap()
            }

            /**
             * Unique identifier for the origin. This is generated by ImageKit when you create a new
             * origin.
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Akeneo instance base URL. */
            fun baseUrl(baseUrl: String) = baseUrl(JsonField.of(baseUrl))

            /**
             * Sets [Builder.baseUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.baseUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun baseUrl(baseUrl: JsonField<String>) = apply { this.baseUrl = baseUrl }

            /** Whether to send a Canonical header. */
            fun includeCanonicalHeader(includeCanonicalHeader: Boolean) =
                includeCanonicalHeader(JsonField.of(includeCanonicalHeader))

            /**
             * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeCanonicalHeader] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
                this.includeCanonicalHeader = includeCanonicalHeader
            }

            /** Display name of the origin. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) = apply {
                this.baseUrlForCanonicalHeader = baseUrlForCanonicalHeader
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
             * Returns an immutable instance of [AkeneoPim].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .baseUrl()
             * .includeCanonicalHeader()
             * .name()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AkeneoPim =
                AkeneoPim(
                    checkRequired("id", id),
                    checkRequired("baseUrl", baseUrl),
                    checkRequired("includeCanonicalHeader", includeCanonicalHeader),
                    checkRequired("name", name),
                    checkRequired("type", type),
                    baseUrlForCanonicalHeader,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): AkeneoPim = apply {
            if (validated) {
                return@apply
            }

            id()
            baseUrl()
            includeCanonicalHeader()
            name()
            type().validate()
            baseUrlForCanonicalHeader()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (baseUrl.asKnown().isPresent) 1 else 0) +
                (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0)

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

                @JvmField val AKENEO_PIM = of("AKENEO_PIM")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                AKENEO_PIM
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
                AKENEO_PIM,
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
                    AKENEO_PIM -> Value.AKENEO_PIM
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
                    AKENEO_PIM -> Known.AKENEO_PIM
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AkeneoPim &&
                id == other.id &&
                baseUrl == other.baseUrl &&
                includeCanonicalHeader == other.includeCanonicalHeader &&
                name == other.name &&
                type == other.type &&
                baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                baseUrl,
                includeCanonicalHeader,
                name,
                type,
                baseUrlForCanonicalHeader,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AkeneoPim{id=$id, baseUrl=$baseUrl, includeCanonicalHeader=$includeCanonicalHeader, name=$name, type=$type, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, additionalProperties=$additionalProperties}"
    }
}
