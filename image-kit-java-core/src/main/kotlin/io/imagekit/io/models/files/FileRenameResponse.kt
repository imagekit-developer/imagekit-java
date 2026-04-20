// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.models.files

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

class FileRenameResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val purgeRequestId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("purgeRequestId")
        @ExcludeMissing
        purgeRequestId: JsonField<String> = JsonMissing.of()
    ) : this(purgeRequestId, mutableMapOf())

    /**
     * Unique identifier of the purge request. This can be used to check the status of the purge
     * request.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun purgeRequestId(): Optional<String> = purgeRequestId.getOptional("purgeRequestId")

    /**
     * Returns the raw JSON value of [purgeRequestId].
     *
     * Unlike [purgeRequestId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("purgeRequestId")
    @ExcludeMissing
    fun _purgeRequestId(): JsonField<String> = purgeRequestId

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

        /** Returns a mutable builder for constructing an instance of [FileRenameResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileRenameResponse]. */
    class Builder internal constructor() {

        private var purgeRequestId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileRenameResponse: FileRenameResponse) = apply {
            purgeRequestId = fileRenameResponse.purgeRequestId
            additionalProperties = fileRenameResponse.additionalProperties.toMutableMap()
        }

        /**
         * Unique identifier of the purge request. This can be used to check the status of the purge
         * request.
         */
        fun purgeRequestId(purgeRequestId: String) = purgeRequestId(JsonField.of(purgeRequestId))

        /**
         * Sets [Builder.purgeRequestId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.purgeRequestId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun purgeRequestId(purgeRequestId: JsonField<String>) = apply {
            this.purgeRequestId = purgeRequestId
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
         * Returns an immutable instance of [FileRenameResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FileRenameResponse =
            FileRenameResponse(purgeRequestId, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): FileRenameResponse = apply {
        if (validated) {
            return@apply
        }

        purgeRequestId()
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
    @JvmSynthetic internal fun validity(): Int = (if (purgeRequestId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileRenameResponse &&
            purgeRequestId == other.purgeRequestId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(purgeRequestId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileRenameResponse{purgeRequestId=$purgeRequestId, additionalProperties=$additionalProperties}"
}
