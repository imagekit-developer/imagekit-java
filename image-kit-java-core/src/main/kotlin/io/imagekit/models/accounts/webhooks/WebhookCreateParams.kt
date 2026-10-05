// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.core.Params
import io.imagekit.core.checkKnown
import io.imagekit.core.checkRequired
import io.imagekit.core.http.Headers
import io.imagekit.core.http.QueryParams
import io.imagekit.core.toImmutable
import io.imagekit.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Creates a new webhook and returns the created object, including the generated signing `secret`.
 *
 * ImageKit sends a `POST` request to the webhook `endpoint` whenever one of the subscribed `events`
 * occurs. Use the `secret` to verify the signature of each request. Learn more about
 * [webhooks](https://imagekit.io/docs/webhooks).
 *
 * You can create up to 3 webhooks per account.
 */
class WebhookCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The URL where ImageKit sends webhook events as `POST` requests. Must use the `http` or
     * `https` protocol, and must be unique across all webhooks for your account.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun endpoint(): String = body.endpoint()

    /**
     * The event types this webhook is subscribed to. ImageKit sends a request to the `endpoint`
     * only for these events.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun events(): List<WebhookEventType> = body.events()

    /**
     * Whether the webhook is enabled. When `false`, ImageKit doesn't send any events to the
     * `endpoint`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun enabled(): Optional<Boolean> = body.enabled()

    /**
     * Returns the raw JSON value of [endpoint].
     *
     * Unlike [endpoint], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _endpoint(): JsonField<String> = body._endpoint()

    /**
     * Returns the raw JSON value of [events].
     *
     * Unlike [events], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _events(): JsonField<List<WebhookEventType>> = body._events()

    /**
     * Returns the raw JSON value of [enabled].
     *
     * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _enabled(): JsonField<Boolean> = body._enabled()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WebhookCreateParams].
         *
         * The following fields are required:
         * ```java
         * .endpoint()
         * .events()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(webhookCreateParams: WebhookCreateParams) = apply {
            body = webhookCreateParams.body.toBuilder()
            additionalHeaders = webhookCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = webhookCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [endpoint]
         * - [events]
         * - [enabled]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The URL where ImageKit sends webhook events as `POST` requests. Must use the `http` or
         * `https` protocol, and must be unique across all webhooks for your account.
         */
        fun endpoint(endpoint: String) = apply { body.endpoint(endpoint) }

        /**
         * Sets [Builder.endpoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endpoint] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun endpoint(endpoint: JsonField<String>) = apply { body.endpoint(endpoint) }

        /**
         * The event types this webhook is subscribed to. ImageKit sends a request to the `endpoint`
         * only for these events.
         */
        fun events(events: List<WebhookEventType>) = apply { body.events(events) }

        /**
         * Sets [Builder.events] to an arbitrary JSON value.
         *
         * You should usually call [Builder.events] with a well-typed `List<WebhookEventType>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun events(events: JsonField<List<WebhookEventType>>) = apply { body.events(events) }

        /**
         * Adds a single [WebhookEventType] to [events].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEvent(event: WebhookEventType) = apply { body.addEvent(event) }

        /**
         * Whether the webhook is enabled. When `false`, ImageKit doesn't send any events to the
         * `endpoint`.
         */
        fun enabled(enabled: Boolean) = apply { body.enabled(enabled) }

        /**
         * Sets [Builder.enabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun enabled(enabled: JsonField<Boolean>) = apply { body.enabled(enabled) }

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
         * Returns an immutable instance of [WebhookCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .endpoint()
         * .events()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WebhookCreateParams =
            WebhookCreateParams(
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
        private val endpoint: JsonField<String>,
        private val events: JsonField<List<WebhookEventType>>,
        private val enabled: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("endpoint")
            @ExcludeMissing
            endpoint: JsonField<String> = JsonMissing.of(),
            @JsonProperty("events")
            @ExcludeMissing
            events: JsonField<List<WebhookEventType>> = JsonMissing.of(),
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
        ) : this(endpoint, events, enabled, mutableMapOf())

        /**
         * The URL where ImageKit sends webhook events as `POST` requests. Must use the `http` or
         * `https` protocol, and must be unique across all webhooks for your account.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun endpoint(): String = endpoint.getRequired("endpoint")

        /**
         * The event types this webhook is subscribed to. ImageKit sends a request to the `endpoint`
         * only for these events.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun events(): List<WebhookEventType> = events.getRequired("events")

        /**
         * Whether the webhook is enabled. When `false`, ImageKit doesn't send any events to the
         * `endpoint`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun enabled(): Optional<Boolean> = enabled.getOptional("enabled")

        /**
         * Returns the raw JSON value of [endpoint].
         *
         * Unlike [endpoint], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("endpoint") @ExcludeMissing fun _endpoint(): JsonField<String> = endpoint

        /**
         * Returns the raw JSON value of [events].
         *
         * Unlike [events], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("events")
        @ExcludeMissing
        fun _events(): JsonField<List<WebhookEventType>> = events

        /**
         * Returns the raw JSON value of [enabled].
         *
         * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

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
             * .endpoint()
             * .events()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var endpoint: JsonField<String>? = null
            private var events: JsonField<MutableList<WebhookEventType>>? = null
            private var enabled: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                endpoint = body.endpoint
                events = body.events.map { it.toMutableList() }
                enabled = body.enabled
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The URL where ImageKit sends webhook events as `POST` requests. Must use the `http`
             * or `https` protocol, and must be unique across all webhooks for your account.
             */
            fun endpoint(endpoint: String) = endpoint(JsonField.of(endpoint))

            /**
             * Sets [Builder.endpoint] to an arbitrary JSON value.
             *
             * You should usually call [Builder.endpoint] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun endpoint(endpoint: JsonField<String>) = apply { this.endpoint = endpoint }

            /**
             * The event types this webhook is subscribed to. ImageKit sends a request to the
             * `endpoint` only for these events.
             */
            fun events(events: List<WebhookEventType>) = events(JsonField.of(events))

            /**
             * Sets [Builder.events] to an arbitrary JSON value.
             *
             * You should usually call [Builder.events] with a well-typed `List<WebhookEventType>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun events(events: JsonField<List<WebhookEventType>>) = apply {
                this.events = events.map { it.toMutableList() }
            }

            /**
             * Adds a single [WebhookEventType] to [events].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addEvent(event: WebhookEventType) = apply {
                events =
                    (events ?: JsonField.of(mutableListOf())).also {
                        checkKnown("events", it).add(event)
                    }
            }

            /**
             * Whether the webhook is enabled. When `false`, ImageKit doesn't send any events to the
             * `endpoint`.
             */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

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
             * .endpoint()
             * .events()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("endpoint", endpoint),
                    checkRequired("events", events).map { it.toImmutable() },
                    enabled,
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

            endpoint()
            events().forEach { it.validate() }
            enabled()
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
            (if (endpoint.asKnown().isPresent) 1 else 0) +
                (events.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (enabled.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                endpoint == other.endpoint &&
                events == other.events &&
                enabled == other.enabled &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(endpoint, events, enabled, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{endpoint=$endpoint, events=$events, enabled=$enabled, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "WebhookCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
