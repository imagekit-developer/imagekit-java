// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.origins

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.imagekit.api.core.Enum
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.Params
import com.imagekit.api.core.checkRequired
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

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = body.name()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = body.type()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun accessKey(): Optional<String> = body.accessKey()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun accountName(): Optional<String> = body.accountName()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun baseUrl(): Optional<String> = body.baseUrl()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun baseUrlForCanonicalHeader(): Optional<String> = body.baseUrlForCanonicalHeader()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bucket(): Optional<String> = body.bucket()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clientEmail(): Optional<String> = body.clientEmail()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clientId(): Optional<String> = body.clientId()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clientSecret(): Optional<String> = body.clientSecret()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun container(): Optional<String> = body.container()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun endpoint(): Optional<String> = body.endpoint()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun forwardHostHeaderToOrigin(): Optional<Boolean> = body.forwardHostHeaderToOrigin()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun includeCanonicalHeader(): Optional<Boolean> = body.includeCanonicalHeader()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun password(): Optional<String> = body.password()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun prefix(): Optional<String> = body.prefix()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun privateKey(): Optional<String> = body.privateKey()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun s3ForcePathStyle(): Optional<Boolean> = body.s3ForcePathStyle()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sasToken(): Optional<String> = body.sasToken()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun secretKey(): Optional<String> = body.secretKey()

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun username(): Optional<String> = body.username()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _type(): JsonField<Type> = body._type()

    /**
     * Returns the raw JSON value of [accessKey].
     *
     * Unlike [accessKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _accessKey(): JsonField<String> = body._accessKey()

    /**
     * Returns the raw JSON value of [accountName].
     *
     * Unlike [accountName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _accountName(): JsonField<String> = body._accountName()

    /**
     * Returns the raw JSON value of [baseUrl].
     *
     * Unlike [baseUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _baseUrl(): JsonField<String> = body._baseUrl()

    /**
     * Returns the raw JSON value of [baseUrlForCanonicalHeader].
     *
     * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _baseUrlForCanonicalHeader(): JsonField<String> = body._baseUrlForCanonicalHeader()

    /**
     * Returns the raw JSON value of [bucket].
     *
     * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _bucket(): JsonField<String> = body._bucket()

    /**
     * Returns the raw JSON value of [clientEmail].
     *
     * Unlike [clientEmail], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _clientEmail(): JsonField<String> = body._clientEmail()

    /**
     * Returns the raw JSON value of [clientId].
     *
     * Unlike [clientId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _clientId(): JsonField<String> = body._clientId()

    /**
     * Returns the raw JSON value of [clientSecret].
     *
     * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _clientSecret(): JsonField<String> = body._clientSecret()

    /**
     * Returns the raw JSON value of [container].
     *
     * Unlike [container], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _container(): JsonField<String> = body._container()

    /**
     * Returns the raw JSON value of [endpoint].
     *
     * Unlike [endpoint], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _endpoint(): JsonField<String> = body._endpoint()

    /**
     * Returns the raw JSON value of [forwardHostHeaderToOrigin].
     *
     * Unlike [forwardHostHeaderToOrigin], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _forwardHostHeaderToOrigin(): JsonField<Boolean> = body._forwardHostHeaderToOrigin()

    /**
     * Returns the raw JSON value of [includeCanonicalHeader].
     *
     * Unlike [includeCanonicalHeader], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _includeCanonicalHeader(): JsonField<Boolean> = body._includeCanonicalHeader()

    /**
     * Returns the raw JSON value of [password].
     *
     * Unlike [password], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _password(): JsonField<String> = body._password()

    /**
     * Returns the raw JSON value of [prefix].
     *
     * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _prefix(): JsonField<String> = body._prefix()

    /**
     * Returns the raw JSON value of [privateKey].
     *
     * Unlike [privateKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _privateKey(): JsonField<String> = body._privateKey()

    /**
     * Returns the raw JSON value of [s3ForcePathStyle].
     *
     * Unlike [s3ForcePathStyle], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _s3ForcePathStyle(): JsonField<Boolean> = body._s3ForcePathStyle()

    /**
     * Returns the raw JSON value of [sasToken].
     *
     * Unlike [sasToken], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sasToken(): JsonField<String> = body._sasToken()

    /**
     * Returns the raw JSON value of [secretKey].
     *
     * Unlike [secretKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _secretKey(): JsonField<String> = body._secretKey()

    /**
     * Returns the raw JSON value of [username].
     *
     * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _username(): JsonField<String> = body._username()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

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
         * .name()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OriginCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(originCreateParams: OriginCreateParams) = apply {
            body = originCreateParams.body.toBuilder()
            additionalHeaders = originCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = originCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [name]
         * - [type]
         * - [accessKey]
         * - [accountName]
         * - [baseUrl]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun name(name: String) = apply { body.name(name) }

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        fun type(type: Type) = apply { body.type(type) }

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { body.type(type) }

        fun accessKey(accessKey: String) = apply { body.accessKey(accessKey) }

        /**
         * Sets [Builder.accessKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accessKey] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accessKey(accessKey: JsonField<String>) = apply { body.accessKey(accessKey) }

        fun accountName(accountName: String) = apply { body.accountName(accountName) }

        /**
         * Sets [Builder.accountName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountName(accountName: JsonField<String>) = apply { body.accountName(accountName) }

        fun baseUrl(baseUrl: String) = apply { body.baseUrl(baseUrl) }

        /**
         * Sets [Builder.baseUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.baseUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun baseUrl(baseUrl: JsonField<String>) = apply { body.baseUrl(baseUrl) }

        fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: String) = apply {
            body.baseUrlForCanonicalHeader(baseUrlForCanonicalHeader)
        }

        /**
         * Sets [Builder.baseUrlForCanonicalHeader] to an arbitrary JSON value.
         *
         * You should usually call [Builder.baseUrlForCanonicalHeader] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun baseUrlForCanonicalHeader(baseUrlForCanonicalHeader: JsonField<String>) = apply {
            body.baseUrlForCanonicalHeader(baseUrlForCanonicalHeader)
        }

        fun bucket(bucket: String) = apply { body.bucket(bucket) }

        /**
         * Sets [Builder.bucket] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bucket] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bucket(bucket: JsonField<String>) = apply { body.bucket(bucket) }

        fun clientEmail(clientEmail: String) = apply { body.clientEmail(clientEmail) }

        /**
         * Sets [Builder.clientEmail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientEmail] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun clientEmail(clientEmail: JsonField<String>) = apply { body.clientEmail(clientEmail) }

        fun clientId(clientId: String) = apply { body.clientId(clientId) }

        /**
         * Sets [Builder.clientId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun clientId(clientId: JsonField<String>) = apply { body.clientId(clientId) }

        fun clientSecret(clientSecret: String) = apply { body.clientSecret(clientSecret) }

        /**
         * Sets [Builder.clientSecret] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientSecret] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun clientSecret(clientSecret: JsonField<String>) = apply {
            body.clientSecret(clientSecret)
        }

        fun container(container: String) = apply { body.container(container) }

        /**
         * Sets [Builder.container] to an arbitrary JSON value.
         *
         * You should usually call [Builder.container] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun container(container: JsonField<String>) = apply { body.container(container) }

        fun endpoint(endpoint: String) = apply { body.endpoint(endpoint) }

        /**
         * Sets [Builder.endpoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endpoint] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun endpoint(endpoint: JsonField<String>) = apply { body.endpoint(endpoint) }

        fun forwardHostHeaderToOrigin(forwardHostHeaderToOrigin: Boolean) = apply {
            body.forwardHostHeaderToOrigin(forwardHostHeaderToOrigin)
        }

        /**
         * Sets [Builder.forwardHostHeaderToOrigin] to an arbitrary JSON value.
         *
         * You should usually call [Builder.forwardHostHeaderToOrigin] with a well-typed [Boolean]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun forwardHostHeaderToOrigin(forwardHostHeaderToOrigin: JsonField<Boolean>) = apply {
            body.forwardHostHeaderToOrigin(forwardHostHeaderToOrigin)
        }

        fun includeCanonicalHeader(includeCanonicalHeader: Boolean) = apply {
            body.includeCanonicalHeader(includeCanonicalHeader)
        }

        /**
         * Sets [Builder.includeCanonicalHeader] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeCanonicalHeader] with a well-typed [Boolean]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun includeCanonicalHeader(includeCanonicalHeader: JsonField<Boolean>) = apply {
            body.includeCanonicalHeader(includeCanonicalHeader)
        }

        fun password(password: String) = apply { body.password(password) }

        /**
         * Sets [Builder.password] to an arbitrary JSON value.
         *
         * You should usually call [Builder.password] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun password(password: JsonField<String>) = apply { body.password(password) }

        fun prefix(prefix: String) = apply { body.prefix(prefix) }

        /**
         * Sets [Builder.prefix] to an arbitrary JSON value.
         *
         * You should usually call [Builder.prefix] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun prefix(prefix: JsonField<String>) = apply { body.prefix(prefix) }

        fun privateKey(privateKey: String) = apply { body.privateKey(privateKey) }

        /**
         * Sets [Builder.privateKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.privateKey] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun privateKey(privateKey: JsonField<String>) = apply { body.privateKey(privateKey) }

        fun s3ForcePathStyle(s3ForcePathStyle: Boolean) = apply {
            body.s3ForcePathStyle(s3ForcePathStyle)
        }

        /**
         * Sets [Builder.s3ForcePathStyle] to an arbitrary JSON value.
         *
         * You should usually call [Builder.s3ForcePathStyle] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun s3ForcePathStyle(s3ForcePathStyle: JsonField<Boolean>) = apply {
            body.s3ForcePathStyle(s3ForcePathStyle)
        }

        fun sasToken(sasToken: String) = apply { body.sasToken(sasToken) }

        /**
         * Sets [Builder.sasToken] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sasToken] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sasToken(sasToken: JsonField<String>) = apply { body.sasToken(sasToken) }

        fun secretKey(secretKey: String) = apply { body.secretKey(secretKey) }

        /**
         * Sets [Builder.secretKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.secretKey] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun secretKey(secretKey: JsonField<String>) = apply { body.secretKey(secretKey) }

        fun username(username: String) = apply { body.username(username) }

        /**
         * Sets [Builder.username] to an arbitrary JSON value.
         *
         * You should usually call [Builder.username] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun username(username: JsonField<String>) = apply { body.username(username) }

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
         * Returns an immutable instance of [OriginCreateParams].
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
        fun build(): OriginCreateParams =
            OriginCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val name: JsonField<String>,
        private val type: JsonField<Type>,
        private val accessKey: JsonField<String>,
        private val accountName: JsonField<String>,
        private val baseUrl: JsonField<String>,
        private val baseUrlForCanonicalHeader: JsonField<String>,
        private val bucket: JsonField<String>,
        private val clientEmail: JsonField<String>,
        private val clientId: JsonField<String>,
        private val clientSecret: JsonField<String>,
        private val container: JsonField<String>,
        private val endpoint: JsonField<String>,
        private val forwardHostHeaderToOrigin: JsonField<Boolean>,
        private val includeCanonicalHeader: JsonField<Boolean>,
        private val password: JsonField<String>,
        private val prefix: JsonField<String>,
        private val privateKey: JsonField<String>,
        private val s3ForcePathStyle: JsonField<Boolean>,
        private val sasToken: JsonField<String>,
        private val secretKey: JsonField<String>,
        private val username: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("accessKey")
            @ExcludeMissing
            accessKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("accountName")
            @ExcludeMissing
            accountName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("baseUrl") @ExcludeMissing baseUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("baseUrlForCanonicalHeader")
            @ExcludeMissing
            baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bucket") @ExcludeMissing bucket: JsonField<String> = JsonMissing.of(),
            @JsonProperty("clientEmail")
            @ExcludeMissing
            clientEmail: JsonField<String> = JsonMissing.of(),
            @JsonProperty("clientId")
            @ExcludeMissing
            clientId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("clientSecret")
            @ExcludeMissing
            clientSecret: JsonField<String> = JsonMissing.of(),
            @JsonProperty("container")
            @ExcludeMissing
            container: JsonField<String> = JsonMissing.of(),
            @JsonProperty("endpoint")
            @ExcludeMissing
            endpoint: JsonField<String> = JsonMissing.of(),
            @JsonProperty("forwardHostHeaderToOrigin")
            @ExcludeMissing
            forwardHostHeaderToOrigin: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("includeCanonicalHeader")
            @ExcludeMissing
            includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("password")
            @ExcludeMissing
            password: JsonField<String> = JsonMissing.of(),
            @JsonProperty("prefix") @ExcludeMissing prefix: JsonField<String> = JsonMissing.of(),
            @JsonProperty("privateKey")
            @ExcludeMissing
            privateKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("s3ForcePathStyle")
            @ExcludeMissing
            s3ForcePathStyle: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("sasToken")
            @ExcludeMissing
            sasToken: JsonField<String> = JsonMissing.of(),
            @JsonProperty("secretKey")
            @ExcludeMissing
            secretKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("username") @ExcludeMissing username: JsonField<String> = JsonMissing.of(),
        ) : this(
            name,
            type,
            accessKey,
            accountName,
            baseUrl,
            baseUrlForCanonicalHeader,
            bucket,
            clientEmail,
            clientId,
            clientSecret,
            container,
            endpoint,
            forwardHostHeaderToOrigin,
            includeCanonicalHeader,
            password,
            prefix,
            privateKey,
            s3ForcePathStyle,
            sasToken,
            secretKey,
            username,
            mutableMapOf(),
        )

        /**
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
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun accessKey(): Optional<String> = accessKey.getOptional("accessKey")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun accountName(): Optional<String> = accountName.getOptional("accountName")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun baseUrl(): Optional<String> = baseUrl.getOptional("baseUrl")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun baseUrlForCanonicalHeader(): Optional<String> =
            baseUrlForCanonicalHeader.getOptional("baseUrlForCanonicalHeader")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun bucket(): Optional<String> = bucket.getOptional("bucket")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun clientEmail(): Optional<String> = clientEmail.getOptional("clientEmail")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun clientId(): Optional<String> = clientId.getOptional("clientId")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun clientSecret(): Optional<String> = clientSecret.getOptional("clientSecret")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun container(): Optional<String> = container.getOptional("container")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun endpoint(): Optional<String> = endpoint.getOptional("endpoint")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun forwardHostHeaderToOrigin(): Optional<Boolean> =
            forwardHostHeaderToOrigin.getOptional("forwardHostHeaderToOrigin")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun includeCanonicalHeader(): Optional<Boolean> =
            includeCanonicalHeader.getOptional("includeCanonicalHeader")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun password(): Optional<String> = password.getOptional("password")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun prefix(): Optional<String> = prefix.getOptional("prefix")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun privateKey(): Optional<String> = privateKey.getOptional("privateKey")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun s3ForcePathStyle(): Optional<Boolean> = s3ForcePathStyle.getOptional("s3ForcePathStyle")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sasToken(): Optional<String> = sasToken.getOptional("sasToken")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun secretKey(): Optional<String> = secretKey.getOptional("secretKey")

        /**
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun username(): Optional<String> = username.getOptional("username")

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
         * Returns the raw JSON value of [accessKey].
         *
         * Unlike [accessKey], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("accessKey") @ExcludeMissing fun _accessKey(): JsonField<String> = accessKey

        /**
         * Returns the raw JSON value of [accountName].
         *
         * Unlike [accountName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("accountName")
        @ExcludeMissing
        fun _accountName(): JsonField<String> = accountName

        /**
         * Returns the raw JSON value of [baseUrl].
         *
         * Unlike [baseUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("baseUrl") @ExcludeMissing fun _baseUrl(): JsonField<String> = baseUrl

        /**
         * Returns the raw JSON value of [baseUrlForCanonicalHeader].
         *
         * Unlike [baseUrlForCanonicalHeader], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("baseUrlForCanonicalHeader")
        @ExcludeMissing
        fun _baseUrlForCanonicalHeader(): JsonField<String> = baseUrlForCanonicalHeader

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
         * Returns the raw JSON value of [clientId].
         *
         * Unlike [clientId], this method doesn't throw if the JSON field has an unexpected type.
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
         * Returns the raw JSON value of [container].
         *
         * Unlike [container], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("container") @ExcludeMissing fun _container(): JsonField<String> = container

        /**
         * Returns the raw JSON value of [endpoint].
         *
         * Unlike [endpoint], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("endpoint") @ExcludeMissing fun _endpoint(): JsonField<String> = endpoint

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
         * Returns the raw JSON value of [password].
         *
         * Unlike [password], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("password") @ExcludeMissing fun _password(): JsonField<String> = password

        /**
         * Returns the raw JSON value of [prefix].
         *
         * Unlike [prefix], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

        /**
         * Returns the raw JSON value of [privateKey].
         *
         * Unlike [privateKey], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("privateKey")
        @ExcludeMissing
        fun _privateKey(): JsonField<String> = privateKey

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
         * Returns the raw JSON value of [sasToken].
         *
         * Unlike [sasToken], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sasToken") @ExcludeMissing fun _sasToken(): JsonField<String> = sasToken

        /**
         * Returns the raw JSON value of [secretKey].
         *
         * Unlike [secretKey], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("secretKey") @ExcludeMissing fun _secretKey(): JsonField<String> = secretKey

        /**
         * Returns the raw JSON value of [username].
         *
         * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

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
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var accessKey: JsonField<String> = JsonMissing.of()
            private var accountName: JsonField<String> = JsonMissing.of()
            private var baseUrl: JsonField<String> = JsonMissing.of()
            private var baseUrlForCanonicalHeader: JsonField<String> = JsonMissing.of()
            private var bucket: JsonField<String> = JsonMissing.of()
            private var clientEmail: JsonField<String> = JsonMissing.of()
            private var clientId: JsonField<String> = JsonMissing.of()
            private var clientSecret: JsonField<String> = JsonMissing.of()
            private var container: JsonField<String> = JsonMissing.of()
            private var endpoint: JsonField<String> = JsonMissing.of()
            private var forwardHostHeaderToOrigin: JsonField<Boolean> = JsonMissing.of()
            private var includeCanonicalHeader: JsonField<Boolean> = JsonMissing.of()
            private var password: JsonField<String> = JsonMissing.of()
            private var prefix: JsonField<String> = JsonMissing.of()
            private var privateKey: JsonField<String> = JsonMissing.of()
            private var s3ForcePathStyle: JsonField<Boolean> = JsonMissing.of()
            private var sasToken: JsonField<String> = JsonMissing.of()
            private var secretKey: JsonField<String> = JsonMissing.of()
            private var username: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                name = body.name
                type = body.type
                accessKey = body.accessKey
                accountName = body.accountName
                baseUrl = body.baseUrl
                baseUrlForCanonicalHeader = body.baseUrlForCanonicalHeader
                bucket = body.bucket
                clientEmail = body.clientEmail
                clientId = body.clientId
                clientSecret = body.clientSecret
                container = body.container
                endpoint = body.endpoint
                forwardHostHeaderToOrigin = body.forwardHostHeaderToOrigin
                includeCanonicalHeader = body.includeCanonicalHeader
                password = body.password
                prefix = body.prefix
                privateKey = body.privateKey
                s3ForcePathStyle = body.s3ForcePathStyle
                sasToken = body.sasToken
                secretKey = body.secretKey
                username = body.username
                additionalProperties = body.additionalProperties.toMutableMap()
            }

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

            fun accessKey(accessKey: String) = accessKey(JsonField.of(accessKey))

            /**
             * Sets [Builder.accessKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.accessKey] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun accessKey(accessKey: JsonField<String>) = apply { this.accessKey = accessKey }

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

            fun baseUrl(baseUrl: String) = baseUrl(JsonField.of(baseUrl))

            /**
             * Sets [Builder.baseUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.baseUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun baseUrl(baseUrl: JsonField<String>) = apply { this.baseUrl = baseUrl }

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

            fun clientId(clientId: String) = clientId(JsonField.of(clientId))

            /**
             * Sets [Builder.clientId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clientId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clientId(clientId: JsonField<String>) = apply { this.clientId = clientId }

            fun clientSecret(clientSecret: String) = clientSecret(JsonField.of(clientSecret))

            /**
             * Sets [Builder.clientSecret] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clientSecret] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clientSecret(clientSecret: JsonField<String>) = apply {
                this.clientSecret = clientSecret
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

            fun endpoint(endpoint: String) = endpoint(JsonField.of(endpoint))

            /**
             * Sets [Builder.endpoint] to an arbitrary JSON value.
             *
             * You should usually call [Builder.endpoint] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun endpoint(endpoint: JsonField<String>) = apply { this.endpoint = endpoint }

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

            fun password(password: String) = password(JsonField.of(password))

            /**
             * Sets [Builder.password] to an arbitrary JSON value.
             *
             * You should usually call [Builder.password] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun password(password: JsonField<String>) = apply { this.password = password }

            fun prefix(prefix: String) = prefix(JsonField.of(prefix))

            /**
             * Sets [Builder.prefix] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prefix] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

            fun privateKey(privateKey: String) = privateKey(JsonField.of(privateKey))

            /**
             * Sets [Builder.privateKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.privateKey] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun privateKey(privateKey: JsonField<String>) = apply { this.privateKey = privateKey }

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

            fun sasToken(sasToken: String) = sasToken(JsonField.of(sasToken))

            /**
             * Sets [Builder.sasToken] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sasToken] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sasToken(sasToken: JsonField<String>) = apply { this.sasToken = sasToken }

            fun secretKey(secretKey: String) = secretKey(JsonField.of(secretKey))

            /**
             * Sets [Builder.secretKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.secretKey] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun secretKey(secretKey: JsonField<String>) = apply { this.secretKey = secretKey }

            fun username(username: String) = username(JsonField.of(username))

            /**
             * Sets [Builder.username] to an arbitrary JSON value.
             *
             * You should usually call [Builder.username] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun username(username: JsonField<String>) = apply { this.username = username }

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
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("name", name),
                    checkRequired("type", type),
                    accessKey,
                    accountName,
                    baseUrl,
                    baseUrlForCanonicalHeader,
                    bucket,
                    clientEmail,
                    clientId,
                    clientSecret,
                    container,
                    endpoint,
                    forwardHostHeaderToOrigin,
                    includeCanonicalHeader,
                    password,
                    prefix,
                    privateKey,
                    s3ForcePathStyle,
                    sasToken,
                    secretKey,
                    username,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            name()
            type().validate()
            accessKey()
            accountName()
            baseUrl()
            baseUrlForCanonicalHeader()
            bucket()
            clientEmail()
            clientId()
            clientSecret()
            container()
            endpoint()
            forwardHostHeaderToOrigin()
            includeCanonicalHeader()
            password()
            prefix()
            privateKey()
            s3ForcePathStyle()
            sasToken()
            secretKey()
            username()
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
                (if (accessKey.asKnown().isPresent) 1 else 0) +
                (if (accountName.asKnown().isPresent) 1 else 0) +
                (if (baseUrl.asKnown().isPresent) 1 else 0) +
                (if (baseUrlForCanonicalHeader.asKnown().isPresent) 1 else 0) +
                (if (bucket.asKnown().isPresent) 1 else 0) +
                (if (clientEmail.asKnown().isPresent) 1 else 0) +
                (if (clientId.asKnown().isPresent) 1 else 0) +
                (if (clientSecret.asKnown().isPresent) 1 else 0) +
                (if (container.asKnown().isPresent) 1 else 0) +
                (if (endpoint.asKnown().isPresent) 1 else 0) +
                (if (forwardHostHeaderToOrigin.asKnown().isPresent) 1 else 0) +
                (if (includeCanonicalHeader.asKnown().isPresent) 1 else 0) +
                (if (password.asKnown().isPresent) 1 else 0) +
                (if (prefix.asKnown().isPresent) 1 else 0) +
                (if (privateKey.asKnown().isPresent) 1 else 0) +
                (if (s3ForcePathStyle.asKnown().isPresent) 1 else 0) +
                (if (sasToken.asKnown().isPresent) 1 else 0) +
                (if (secretKey.asKnown().isPresent) 1 else 0) +
                (if (username.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                name == other.name &&
                type == other.type &&
                accessKey == other.accessKey &&
                accountName == other.accountName &&
                baseUrl == other.baseUrl &&
                baseUrlForCanonicalHeader == other.baseUrlForCanonicalHeader &&
                bucket == other.bucket &&
                clientEmail == other.clientEmail &&
                clientId == other.clientId &&
                clientSecret == other.clientSecret &&
                container == other.container &&
                endpoint == other.endpoint &&
                forwardHostHeaderToOrigin == other.forwardHostHeaderToOrigin &&
                includeCanonicalHeader == other.includeCanonicalHeader &&
                password == other.password &&
                prefix == other.prefix &&
                privateKey == other.privateKey &&
                s3ForcePathStyle == other.s3ForcePathStyle &&
                sasToken == other.sasToken &&
                secretKey == other.secretKey &&
                username == other.username &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                name,
                type,
                accessKey,
                accountName,
                baseUrl,
                baseUrlForCanonicalHeader,
                bucket,
                clientEmail,
                clientId,
                clientSecret,
                container,
                endpoint,
                forwardHostHeaderToOrigin,
                includeCanonicalHeader,
                password,
                prefix,
                privateKey,
                s3ForcePathStyle,
                sasToken,
                secretKey,
                username,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{name=$name, type=$type, accessKey=$accessKey, accountName=$accountName, baseUrl=$baseUrl, baseUrlForCanonicalHeader=$baseUrlForCanonicalHeader, bucket=$bucket, clientEmail=$clientEmail, clientId=$clientId, clientSecret=$clientSecret, container=$container, endpoint=$endpoint, forwardHostHeaderToOrigin=$forwardHostHeaderToOrigin, includeCanonicalHeader=$includeCanonicalHeader, password=$password, prefix=$prefix, privateKey=$privateKey, s3ForcePathStyle=$s3ForcePathStyle, sasToken=$sasToken, secretKey=$secretKey, username=$username, additionalProperties=$additionalProperties}"
    }

    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val S3 = of("S3")

            @JvmField val S3_COMPATIBLE = of("S3_COMPATIBLE")

            @JvmField val WEB_FOLDER = of("WEB_FOLDER")

            @JvmField val WEB_PROXY = of("WEB_PROXY")

            @JvmField val GCS = of("GCS")

            @JvmField val AZURE_BLOB = of("AZURE_BLOB")

            @JvmField val CLOUDINARY_BACKUP = of("CLOUDINARY_BACKUP")

            @JvmField val AKENEO_PIM = of("AKENEO_PIM")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            S3,
            S3_COMPATIBLE,
            WEB_FOLDER,
            WEB_PROXY,
            GCS,
            AZURE_BLOB,
            CLOUDINARY_BACKUP,
            AKENEO_PIM,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            S3,
            S3_COMPATIBLE,
            WEB_FOLDER,
            WEB_PROXY,
            GCS,
            AZURE_BLOB,
            CLOUDINARY_BACKUP,
            AKENEO_PIM,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                S3 -> Value.S3
                S3_COMPATIBLE -> Value.S3_COMPATIBLE
                WEB_FOLDER -> Value.WEB_FOLDER
                WEB_PROXY -> Value.WEB_PROXY
                GCS -> Value.GCS
                AZURE_BLOB -> Value.AZURE_BLOB
                CLOUDINARY_BACKUP -> Value.CLOUDINARY_BACKUP
                AKENEO_PIM -> Value.AKENEO_PIM
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                S3 -> Known.S3
                S3_COMPATIBLE -> Known.S3_COMPATIBLE
                WEB_FOLDER -> Known.WEB_FOLDER
                WEB_PROXY -> Known.WEB_PROXY
                GCS -> Known.GCS
                AZURE_BLOB -> Known.AZURE_BLOB
                CLOUDINARY_BACKUP -> Known.CLOUDINARY_BACKUP
                AKENEO_PIM -> Known.AKENEO_PIM
                else -> throw ImageKitInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
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

        return other is OriginCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "OriginCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
