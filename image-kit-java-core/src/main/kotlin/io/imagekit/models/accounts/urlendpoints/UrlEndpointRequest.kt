// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.urlendpoints

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
import io.imagekit.core.BaseDeserializer
import io.imagekit.core.BaseSerializer
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.core.checkKnown
import io.imagekit.core.checkRequired
import io.imagekit.core.getOrThrow
import io.imagekit.core.toImmutable
import io.imagekit.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Schema for URL endpoint resource. */
class UrlEndpointRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
        @JsonProperty("urlPrefix") @ExcludeMissing urlPrefix: JsonField<String> = JsonMissing.of(),
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
     * Ordered list of origin IDs to try when the file isn’t in the Media Library; ImageKit checks
     * them in the sequence provided. Origin must be created before it can be used in a URL
     * endpoint.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun origins(): Optional<List<String>> = origins.getOptional("origins")

    /**
     * Path segment appended to your base URL to form the endpoint (letters, digits, and hyphens
     * only — or empty for the default endpoint).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun urlPrefix(): Optional<String> = urlPrefix.getOptional("urlPrefix")

    /**
     * Configuration for third-party URL rewriting.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun urlRewriter(): Optional<UrlRewriter> = urlRewriter.getOptional("urlRewriter")

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

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
         * Returns a mutable builder for constructing an instance of [UrlEndpointRequest].
         *
         * The following fields are required:
         * ```java
         * .description()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UrlEndpointRequest]. */
    class Builder internal constructor() {

        private var description: JsonField<String>? = null
        private var origins: JsonField<MutableList<String>>? = null
        private var urlPrefix: JsonField<String> = JsonMissing.of()
        private var urlRewriter: JsonField<UrlRewriter> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(urlEndpointRequest: UrlEndpointRequest) = apply {
            description = urlEndpointRequest.description
            origins = urlEndpointRequest.origins.map { it.toMutableList() }
            urlPrefix = urlEndpointRequest.urlPrefix
            urlRewriter = urlEndpointRequest.urlRewriter
            additionalProperties = urlEndpointRequest.additionalProperties.toMutableMap()
        }

        /** Description of the URL endpoint. */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /**
         * Ordered list of origin IDs to try when the file isn’t in the Media Library; ImageKit
         * checks them in the sequence provided. Origin must be created before it can be used in a
         * URL endpoint.
         */
        fun origins(origins: List<String>) = origins(JsonField.of(origins))

        /**
         * Sets [Builder.origins] to an arbitrary JSON value.
         *
         * You should usually call [Builder.origins] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Path segment appended to your base URL to form the endpoint (letters, digits, and hyphens
         * only — or empty for the default endpoint).
         */
        fun urlPrefix(urlPrefix: String) = urlPrefix(JsonField.of(urlPrefix))

        /**
         * Sets [Builder.urlPrefix] to an arbitrary JSON value.
         *
         * You should usually call [Builder.urlPrefix] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
        fun urlRewriter(cloudinary: UrlRewriter.Cloudinary) =
            urlRewriter(UrlRewriter.ofCloudinary(cloudinary))

        /** Alias for calling [urlRewriter] with `UrlRewriter.ofImgix()`. */
        fun urlRewriterImgix() = urlRewriter(UrlRewriter.ofImgix())

        /** Alias for calling [urlRewriter] with `UrlRewriter.ofAkamai()`. */
        fun urlRewriterAkamai() = urlRewriter(UrlRewriter.ofAkamai())

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
         * Returns an immutable instance of [UrlEndpointRequest].
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
        fun build(): UrlEndpointRequest =
            UrlEndpointRequest(
                checkRequired("description", description),
                (origins ?: JsonMissing.of()).map { it.toImmutable() },
                urlPrefix,
                urlRewriter,
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
    fun validate(): UrlEndpointRequest = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (description.asKnown().isPresent) 1 else 0) +
            (origins.asKnown().getOrNull()?.size ?: 0) +
            (if (urlPrefix.asKnown().isPresent) 1 else 0) +
            (urlRewriter.asKnown().getOrNull()?.validity() ?: 0)

    /** Configuration for third-party URL rewriting. */
    @JsonDeserialize(using = UrlRewriter.Deserializer::class)
    @JsonSerialize(using = UrlRewriter.Serializer::class)
    class UrlRewriter
    private constructor(
        private val cloudinary: Cloudinary? = null,
        private val imgix: JsonValue? = null,
        private val akamai: JsonValue? = null,
        private val _json: JsonValue? = null,
    ) {

        fun cloudinary(): Optional<Cloudinary> = Optional.ofNullable(cloudinary)

        fun imgix(): Optional<JsonValue> = Optional.ofNullable(imgix)

        fun akamai(): Optional<JsonValue> = Optional.ofNullable(akamai)

        fun isCloudinary(): Boolean = cloudinary != null

        fun isImgix(): Boolean = imgix != null

        fun isAkamai(): Boolean = akamai != null

        fun asCloudinary(): Cloudinary = cloudinary.getOrThrow("cloudinary")

        fun asImgix(): JsonValue = imgix.getOrThrow("imgix")

        fun asAkamai(): JsonValue = akamai.getOrThrow("akamai")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import io.imagekit.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = urlRewriter.accept(new UrlRewriter.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitCloudinary(Cloudinary cloudinary) {
         *         return Optional.of(cloudinary.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws ImageKitInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                cloudinary != null -> visitor.visitCloudinary(cloudinary)
                imgix != null -> visitor.visitImgix(imgix)
                akamai != null -> visitor.visitAkamai(akamai)
                else -> visitor.unknown(_json)
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
        fun validate(): UrlRewriter = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitCloudinary(cloudinary: Cloudinary) {
                        cloudinary.validate()
                    }

                    override fun visitImgix(imgix: JsonValue) {
                        imgix.let {
                            if (it != JsonValue.from(mapOf("type" to "IMGIX"))) {
                                throw ImageKitInvalidDataException(
                                    "'imgix' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitAkamai(akamai: JsonValue) {
                        akamai.let {
                            if (it != JsonValue.from(mapOf("type" to "AKAMAI"))) {
                                throw ImageKitInvalidDataException(
                                    "'akamai' is invalid, received $it"
                                )
                            }
                        }
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
                    override fun visitCloudinary(cloudinary: Cloudinary) = cloudinary.validity()

                    override fun visitImgix(imgix: JsonValue) = imgix.let {
                        if (it == JsonValue.from(mapOf("type" to "IMGIX"))) 1 else 0
                    }

                    override fun visitAkamai(akamai: JsonValue) = akamai.let {
                        if (it == JsonValue.from(mapOf("type" to "AKAMAI"))) 1 else 0
                    }

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
            fun ofCloudinary(cloudinary: Cloudinary) = UrlRewriter(cloudinary = cloudinary)

            @JvmStatic fun ofImgix() = UrlRewriter(imgix = JsonValue.from(mapOf("type" to "IMGIX")))

            @JvmStatic
            fun ofAkamai() = UrlRewriter(akamai = JsonValue.from(mapOf("type" to "AKAMAI")))
        }

        /**
         * An interface that defines how to map each variant of [UrlRewriter] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitCloudinary(cloudinary: Cloudinary): T

            fun visitImgix(imgix: JsonValue): T

            fun visitAkamai(akamai: JsonValue): T

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
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "CLOUDINARY" -> {
                        return tryDeserialize(node, jacksonTypeRef<Cloudinary>())?.let {
                            UrlRewriter(cloudinary = it, _json = json)
                        } ?: UrlRewriter(_json = json)
                    }
                    "IMGIX" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { UrlRewriter(imgix = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: UrlRewriter(_json = json)
                    }
                    "AKAMAI" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { UrlRewriter(akamai = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: UrlRewriter(_json = json)
                    }
                }

                return UrlRewriter(_json = json)
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

        class Cloudinary
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val type: JsonValue,
            private val preserveAssetDeliveryTypes: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("preserveAssetDeliveryTypes")
                @ExcludeMissing
                preserveAssetDeliveryTypes: JsonField<Boolean> = JsonMissing.of(),
            ) : this(type, preserveAssetDeliveryTypes, mutableMapOf())

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("CLOUDINARY")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Whether to preserve `<asset_type>/<delivery_type>` in the rewritten URL.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun preserveAssetDeliveryTypes(): Optional<Boolean> =
                preserveAssetDeliveryTypes.getOptional("preserveAssetDeliveryTypes")

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

                /** Returns a mutable builder for constructing an instance of [Cloudinary]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Cloudinary]. */
            class Builder internal constructor() {

                private var type: JsonValue = JsonValue.from("CLOUDINARY")
                private var preserveAssetDeliveryTypes: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(cloudinary: Cloudinary) = apply {
                    type = cloudinary.type
                    preserveAssetDeliveryTypes = cloudinary.preserveAssetDeliveryTypes
                    additionalProperties = cloudinary.additionalProperties.toMutableMap()
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("CLOUDINARY")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

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
                 * Returns an immutable instance of [Cloudinary].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Cloudinary =
                    Cloudinary(
                        type,
                        preserveAssetDeliveryTypes,
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
            fun validate(): Cloudinary = apply {
                if (validated) {
                    return@apply
                }

                _type().let {
                    if (it != JsonValue.from("CLOUDINARY")) {
                        throw ImageKitInvalidDataException("'type' is invalid, received $it")
                    }
                }
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
                type.let { if (it == JsonValue.from("CLOUDINARY")) 1 else 0 } +
                    (if (preserveAssetDeliveryTypes.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Cloudinary &&
                    type == other.type &&
                    preserveAssetDeliveryTypes == other.preserveAssetDeliveryTypes &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(type, preserveAssetDeliveryTypes, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Cloudinary{type=$type, preserveAssetDeliveryTypes=$preserveAssetDeliveryTypes, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UrlEndpointRequest &&
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
        "UrlEndpointRequest{description=$description, origins=$origins, urlPrefix=$urlPrefix, urlRewriter=$urlRewriter, additionalProperties=$additionalProperties}"
}
