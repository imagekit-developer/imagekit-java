// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files.bulk

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.checkKnown
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BulkDeleteResponse
private constructor(
    private val successfullyDeletedFileIds: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("successfullyDeletedFileIds")
        @ExcludeMissing
        successfullyDeletedFileIds: JsonField<List<String>> = JsonMissing.of()
    ) : this(successfullyDeletedFileIds, mutableMapOf())

    /**
     * An array of fileIds that were successfully deleted.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun successfullyDeletedFileIds(): Optional<List<String>> =
        successfullyDeletedFileIds.getOptional("successfullyDeletedFileIds")

    /**
     * Returns the raw JSON value of [successfullyDeletedFileIds].
     *
     * Unlike [successfullyDeletedFileIds], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("successfullyDeletedFileIds")
    @ExcludeMissing
    fun _successfullyDeletedFileIds(): JsonField<List<String>> = successfullyDeletedFileIds

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

        /** Returns a mutable builder for constructing an instance of [BulkDeleteResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BulkDeleteResponse]. */
    class Builder internal constructor() {

        private var successfullyDeletedFileIds: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(bulkDeleteResponse: BulkDeleteResponse) = apply {
            successfullyDeletedFileIds =
                bulkDeleteResponse.successfullyDeletedFileIds.map { it.toMutableList() }
            additionalProperties = bulkDeleteResponse.additionalProperties.toMutableMap()
        }

        /** An array of fileIds that were successfully deleted. */
        fun successfullyDeletedFileIds(successfullyDeletedFileIds: List<String>) =
            successfullyDeletedFileIds(JsonField.of(successfullyDeletedFileIds))

        /**
         * Sets [Builder.successfullyDeletedFileIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.successfullyDeletedFileIds] with a well-typed
         * `List<String>` value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun successfullyDeletedFileIds(successfullyDeletedFileIds: JsonField<List<String>>) =
            apply {
                this.successfullyDeletedFileIds =
                    successfullyDeletedFileIds.map { it.toMutableList() }
            }

        /**
         * Adds a single [String] to [successfullyDeletedFileIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSuccessfullyDeletedFileId(successfullyDeletedFileId: String) = apply {
            successfullyDeletedFileIds =
                (successfullyDeletedFileIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("successfullyDeletedFileIds", it).add(successfullyDeletedFileId)
                }
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
         * Returns an immutable instance of [BulkDeleteResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BulkDeleteResponse =
            BulkDeleteResponse(
                (successfullyDeletedFileIds ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BulkDeleteResponse = apply {
        if (validated) {
            return@apply
        }

        successfullyDeletedFileIds()
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
    internal fun validity(): Int = (successfullyDeletedFileIds.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BulkDeleteResponse &&
            successfullyDeletedFileIds == other.successfullyDeletedFileIds &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(successfullyDeletedFileIds, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BulkDeleteResponse{successfullyDeletedFileIds=$successfullyDeletedFileIds, additionalProperties=$additionalProperties}"
}
