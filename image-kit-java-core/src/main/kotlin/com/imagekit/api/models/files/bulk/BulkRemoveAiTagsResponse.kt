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

class BulkRemoveAiTagsResponse
private constructor(
    private val successfullyUpdatedFileIds: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("successfullyUpdatedFileIds")
        @ExcludeMissing
        successfullyUpdatedFileIds: JsonField<List<String>> = JsonMissing.of()
    ) : this(successfullyUpdatedFileIds, mutableMapOf())

    /**
     * An array of fileIds that in which AITags were successfully removed.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun successfullyUpdatedFileIds(): Optional<List<String>> =
        successfullyUpdatedFileIds.getOptional("successfullyUpdatedFileIds")

    /**
     * Returns the raw JSON value of [successfullyUpdatedFileIds].
     *
     * Unlike [successfullyUpdatedFileIds], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("successfullyUpdatedFileIds")
    @ExcludeMissing
    fun _successfullyUpdatedFileIds(): JsonField<List<String>> = successfullyUpdatedFileIds

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

        /** Returns a mutable builder for constructing an instance of [BulkRemoveAiTagsResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BulkRemoveAiTagsResponse]. */
    class Builder internal constructor() {

        private var successfullyUpdatedFileIds: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(bulkRemoveAiTagsResponse: BulkRemoveAiTagsResponse) = apply {
            successfullyUpdatedFileIds =
                bulkRemoveAiTagsResponse.successfullyUpdatedFileIds.map { it.toMutableList() }
            additionalProperties = bulkRemoveAiTagsResponse.additionalProperties.toMutableMap()
        }

        /** An array of fileIds that in which AITags were successfully removed. */
        fun successfullyUpdatedFileIds(successfullyUpdatedFileIds: List<String>) =
            successfullyUpdatedFileIds(JsonField.of(successfullyUpdatedFileIds))

        /**
         * Sets [Builder.successfullyUpdatedFileIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.successfullyUpdatedFileIds] with a well-typed
         * `List<String>` value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun successfullyUpdatedFileIds(successfullyUpdatedFileIds: JsonField<List<String>>) =
            apply {
                this.successfullyUpdatedFileIds =
                    successfullyUpdatedFileIds.map { it.toMutableList() }
            }

        /**
         * Adds a single [String] to [successfullyUpdatedFileIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSuccessfullyUpdatedFileId(successfullyUpdatedFileId: String) = apply {
            successfullyUpdatedFileIds =
                (successfullyUpdatedFileIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("successfullyUpdatedFileIds", it).add(successfullyUpdatedFileId)
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
         * Returns an immutable instance of [BulkRemoveAiTagsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BulkRemoveAiTagsResponse =
            BulkRemoveAiTagsResponse(
                (successfullyUpdatedFileIds ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BulkRemoveAiTagsResponse = apply {
        if (validated) {
            return@apply
        }

        successfullyUpdatedFileIds()
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
    internal fun validity(): Int = (successfullyUpdatedFileIds.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BulkRemoveAiTagsResponse &&
            successfullyUpdatedFileIds == other.successfullyUpdatedFileIds &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(successfullyUpdatedFileIds, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BulkRemoveAiTagsResponse{successfullyUpdatedFileIds=$successfullyUpdatedFileIds, additionalProperties=$additionalProperties}"
}
