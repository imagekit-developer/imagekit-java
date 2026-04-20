// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.cache.invalidation

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.io.core.ExcludeMissing
import io.imagekit.io.core.JsonField
import io.imagekit.io.core.JsonMissing
import io.imagekit.io.core.JsonValue
import io.imagekit.io.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class InvalidationCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val requestId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("requestId") @ExcludeMissing requestId: JsonField<String> = JsonMissing.of()
    ) : this(requestId, mutableMapOf())

    /**
     * Unique identifier of the purge request. This can be used to check the status of the purge
     * request.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun requestId(): Optional<String> = requestId.getOptional("requestId")

    /**
     * Returns the raw JSON value of [requestId].
     *
     * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("requestId") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

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
         * Returns a mutable builder for constructing an instance of [InvalidationCreateResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InvalidationCreateResponse]. */
    class Builder internal constructor() {

        private var requestId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(invalidationCreateResponse: InvalidationCreateResponse) = apply {
            requestId = invalidationCreateResponse.requestId
            additionalProperties = invalidationCreateResponse.additionalProperties.toMutableMap()
        }

        /**
         * Unique identifier of the purge request. This can be used to check the status of the purge
         * request.
         */
        fun requestId(requestId: String) = requestId(JsonField.of(requestId))

        /**
         * Sets [Builder.requestId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

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
         * Returns an immutable instance of [InvalidationCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): InvalidationCreateResponse =
            InvalidationCreateResponse(requestId, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): InvalidationCreateResponse = apply {
        if (validated) {
            return@apply
        }

        requestId()
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
    @JvmSynthetic internal fun validity(): Int = (if (requestId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InvalidationCreateResponse &&
            requestId == other.requestId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(requestId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InvalidationCreateResponse{requestId=$requestId, additionalProperties=$additionalProperties}"
}
