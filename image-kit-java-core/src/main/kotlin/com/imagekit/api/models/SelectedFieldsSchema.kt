// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Objects

/**
 * This field is included in the response only if the Path policy feature is available in the plan.
 * It contains schema definitions for the custom metadata fields selected for the specified file
 * path. Field selection can only be done when the Path policy feature is enabled.
 *
 * Keys are the names of the custom metadata fields; the value object has details about the custom
 * metadata schema.
 */
class SelectedFieldsSchema
@JsonCreator
private constructor(
    @com.fasterxml.jackson.annotation.JsonValue
    private val additionalProperties: Map<String, JsonValue>
) {

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [SelectedFieldsSchema]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SelectedFieldsSchema]. */
    class Builder internal constructor() {

        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(selectedFieldsSchema: SelectedFieldsSchema) = apply {
            additionalProperties = selectedFieldsSchema.additionalProperties.toMutableMap()
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
         * Returns an immutable instance of [SelectedFieldsSchema].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SelectedFieldsSchema = SelectedFieldsSchema(additionalProperties.toImmutable())
    }

    private var validated: Boolean = false

    fun validate(): SelectedFieldsSchema = apply {
        if (validated) {
            return@apply
        }

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
        additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SelectedFieldsSchema && additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() = "SelectedFieldsSchema{additionalProperties=$additionalProperties}"
}
