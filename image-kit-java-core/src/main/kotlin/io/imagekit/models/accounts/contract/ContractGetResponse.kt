// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.contract

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.core.checkRequired
import io.imagekit.errors.ImageKitInvalidDataException
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ContractGetResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasContract: JsonField<Boolean>,
    private val asOf: JsonField<OffsetDateTime>,
    private val consumed: JsonField<ContractUnits>,
    private val contractMonths: JsonField<Long>,
    private val effectiveContractEndDate: JsonField<LocalDate>,
    private val effectiveContractStartDate: JsonField<LocalDate>,
    private val originalContractStartDate: JsonField<LocalDate>,
    private val quota: JsonField<ContractUnits>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("hasContract")
        @ExcludeMissing
        hasContract: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("asOf") @ExcludeMissing asOf: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("consumed")
        @ExcludeMissing
        consumed: JsonField<ContractUnits> = JsonMissing.of(),
        @JsonProperty("contractMonths")
        @ExcludeMissing
        contractMonths: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("effectiveContractEndDate")
        @ExcludeMissing
        effectiveContractEndDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("effectiveContractStartDate")
        @ExcludeMissing
        effectiveContractStartDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("originalContractStartDate")
        @ExcludeMissing
        originalContractStartDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("quota") @ExcludeMissing quota: JsonField<ContractUnits> = JsonMissing.of(),
    ) : this(
        hasContract,
        asOf,
        consumed,
        contractMonths,
        effectiveContractEndDate,
        effectiveContractStartDate,
        originalContractStartDate,
        quota,
        mutableMapOf(),
    )

    /**
     * Whether the account has an active contract. The other fields are present only when it does.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasContract(): Boolean = hasContract.getRequired("hasContract")

    /**
     * When `consumed` was last computed. `null` if it has not been computed for the contract yet;
     * `consumed` is then all zeros.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun asOf(): Optional<OffsetDateTime> = asOf.getOptional("asOf")

    /**
     * Usage consumed in the current contract term. For an agency account, this includes the child
     * accounts billed to it.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun consumed(): Optional<ContractUnits> = consumed.getOptional("consumed")

    /**
     * Length of each contract term in months.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contractMonths(): Optional<Long> = contractMonths.getOptional("contractMonths")

    /**
     * End date of the current contract term.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun effectiveContractEndDate(): Optional<LocalDate> =
        effectiveContractEndDate.getOptional("effectiveContractEndDate")

    /**
     * Start date of the current contract term. It moves forward when the contract renews.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun effectiveContractStartDate(): Optional<LocalDate> =
        effectiveContractStartDate.getOptional("effectiveContractStartDate")

    /**
     * Start date of the first contract term.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun originalContractStartDate(): Optional<LocalDate> =
        originalContractStartDate.getOptional("originalContractStartDate")

    /**
     * Usage included in the current contract term.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun quota(): Optional<ContractUnits> = quota.getOptional("quota")

    /**
     * Returns the raw JSON value of [hasContract].
     *
     * Unlike [hasContract], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hasContract")
    @ExcludeMissing
    fun _hasContract(): JsonField<Boolean> = hasContract

    /**
     * Returns the raw JSON value of [asOf].
     *
     * Unlike [asOf], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("asOf") @ExcludeMissing fun _asOf(): JsonField<OffsetDateTime> = asOf

    /**
     * Returns the raw JSON value of [consumed].
     *
     * Unlike [consumed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("consumed") @ExcludeMissing fun _consumed(): JsonField<ContractUnits> = consumed

    /**
     * Returns the raw JSON value of [contractMonths].
     *
     * Unlike [contractMonths], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contractMonths")
    @ExcludeMissing
    fun _contractMonths(): JsonField<Long> = contractMonths

    /**
     * Returns the raw JSON value of [effectiveContractEndDate].
     *
     * Unlike [effectiveContractEndDate], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("effectiveContractEndDate")
    @ExcludeMissing
    fun _effectiveContractEndDate(): JsonField<LocalDate> = effectiveContractEndDate

    /**
     * Returns the raw JSON value of [effectiveContractStartDate].
     *
     * Unlike [effectiveContractStartDate], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("effectiveContractStartDate")
    @ExcludeMissing
    fun _effectiveContractStartDate(): JsonField<LocalDate> = effectiveContractStartDate

    /**
     * Returns the raw JSON value of [originalContractStartDate].
     *
     * Unlike [originalContractStartDate], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("originalContractStartDate")
    @ExcludeMissing
    fun _originalContractStartDate(): JsonField<LocalDate> = originalContractStartDate

    /**
     * Returns the raw JSON value of [quota].
     *
     * Unlike [quota], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quota") @ExcludeMissing fun _quota(): JsonField<ContractUnits> = quota

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
         * Returns a mutable builder for constructing an instance of [ContractGetResponse].
         *
         * The following fields are required:
         * ```java
         * .hasContract()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContractGetResponse]. */
    class Builder internal constructor() {

        private var hasContract: JsonField<Boolean>? = null
        private var asOf: JsonField<OffsetDateTime> = JsonMissing.of()
        private var consumed: JsonField<ContractUnits> = JsonMissing.of()
        private var contractMonths: JsonField<Long> = JsonMissing.of()
        private var effectiveContractEndDate: JsonField<LocalDate> = JsonMissing.of()
        private var effectiveContractStartDate: JsonField<LocalDate> = JsonMissing.of()
        private var originalContractStartDate: JsonField<LocalDate> = JsonMissing.of()
        private var quota: JsonField<ContractUnits> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contractGetResponse: ContractGetResponse) = apply {
            hasContract = contractGetResponse.hasContract
            asOf = contractGetResponse.asOf
            consumed = contractGetResponse.consumed
            contractMonths = contractGetResponse.contractMonths
            effectiveContractEndDate = contractGetResponse.effectiveContractEndDate
            effectiveContractStartDate = contractGetResponse.effectiveContractStartDate
            originalContractStartDate = contractGetResponse.originalContractStartDate
            quota = contractGetResponse.quota
            additionalProperties = contractGetResponse.additionalProperties.toMutableMap()
        }

        /**
         * Whether the account has an active contract. The other fields are present only when it
         * does.
         */
        fun hasContract(hasContract: Boolean) = hasContract(JsonField.of(hasContract))

        /**
         * Sets [Builder.hasContract] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasContract] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hasContract(hasContract: JsonField<Boolean>) = apply { this.hasContract = hasContract }

        /**
         * When `consumed` was last computed. `null` if it has not been computed for the contract
         * yet; `consumed` is then all zeros.
         */
        fun asOf(asOf: OffsetDateTime?) = asOf(JsonField.ofNullable(asOf))

        /** Alias for calling [Builder.asOf] with `asOf.orElse(null)`. */
        fun asOf(asOf: Optional<OffsetDateTime>) = asOf(asOf.getOrNull())

        /**
         * Sets [Builder.asOf] to an arbitrary JSON value.
         *
         * You should usually call [Builder.asOf] with a well-typed [OffsetDateTime] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun asOf(asOf: JsonField<OffsetDateTime>) = apply { this.asOf = asOf }

        /**
         * Usage consumed in the current contract term. For an agency account, this includes the
         * child accounts billed to it.
         */
        fun consumed(consumed: ContractUnits) = consumed(JsonField.of(consumed))

        /**
         * Sets [Builder.consumed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.consumed] with a well-typed [ContractUnits] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun consumed(consumed: JsonField<ContractUnits>) = apply { this.consumed = consumed }

        /** Length of each contract term in months. */
        fun contractMonths(contractMonths: Long) = contractMonths(JsonField.of(contractMonths))

        /**
         * Sets [Builder.contractMonths] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contractMonths] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contractMonths(contractMonths: JsonField<Long>) = apply {
            this.contractMonths = contractMonths
        }

        /** End date of the current contract term. */
        fun effectiveContractEndDate(effectiveContractEndDate: LocalDate) =
            effectiveContractEndDate(JsonField.of(effectiveContractEndDate))

        /**
         * Sets [Builder.effectiveContractEndDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.effectiveContractEndDate] with a well-typed [LocalDate]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun effectiveContractEndDate(effectiveContractEndDate: JsonField<LocalDate>) = apply {
            this.effectiveContractEndDate = effectiveContractEndDate
        }

        /** Start date of the current contract term. It moves forward when the contract renews. */
        fun effectiveContractStartDate(effectiveContractStartDate: LocalDate) =
            effectiveContractStartDate(JsonField.of(effectiveContractStartDate))

        /**
         * Sets [Builder.effectiveContractStartDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.effectiveContractStartDate] with a well-typed
         * [LocalDate] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun effectiveContractStartDate(effectiveContractStartDate: JsonField<LocalDate>) = apply {
            this.effectiveContractStartDate = effectiveContractStartDate
        }

        /** Start date of the first contract term. */
        fun originalContractStartDate(originalContractStartDate: LocalDate) =
            originalContractStartDate(JsonField.of(originalContractStartDate))

        /**
         * Sets [Builder.originalContractStartDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.originalContractStartDate] with a well-typed [LocalDate]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun originalContractStartDate(originalContractStartDate: JsonField<LocalDate>) = apply {
            this.originalContractStartDate = originalContractStartDate
        }

        /** Usage included in the current contract term. */
        fun quota(quota: ContractUnits) = quota(JsonField.of(quota))

        /**
         * Sets [Builder.quota] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quota] with a well-typed [ContractUnits] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun quota(quota: JsonField<ContractUnits>) = apply { this.quota = quota }

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
         * Returns an immutable instance of [ContractGetResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .hasContract()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ContractGetResponse =
            ContractGetResponse(
                checkRequired("hasContract", hasContract),
                asOf,
                consumed,
                contractMonths,
                effectiveContractEndDate,
                effectiveContractStartDate,
                originalContractStartDate,
                quota,
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
    fun validate(): ContractGetResponse = apply {
        if (validated) {
            return@apply
        }

        hasContract()
        asOf()
        consumed().ifPresent { it.validate() }
        contractMonths()
        effectiveContractEndDate()
        effectiveContractStartDate()
        originalContractStartDate()
        quota().ifPresent { it.validate() }
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
        (if (hasContract.asKnown().isPresent) 1 else 0) +
            (if (asOf.asKnown().isPresent) 1 else 0) +
            (consumed.asKnown().getOrNull()?.validity() ?: 0) +
            (if (contractMonths.asKnown().isPresent) 1 else 0) +
            (if (effectiveContractEndDate.asKnown().isPresent) 1 else 0) +
            (if (effectiveContractStartDate.asKnown().isPresent) 1 else 0) +
            (if (originalContractStartDate.asKnown().isPresent) 1 else 0) +
            (quota.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContractGetResponse &&
            hasContract == other.hasContract &&
            asOf == other.asOf &&
            consumed == other.consumed &&
            contractMonths == other.contractMonths &&
            effectiveContractEndDate == other.effectiveContractEndDate &&
            effectiveContractStartDate == other.effectiveContractStartDate &&
            originalContractStartDate == other.originalContractStartDate &&
            quota == other.quota &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            hasContract,
            asOf,
            consumed,
            contractMonths,
            effectiveContractEndDate,
            effectiveContractStartDate,
            originalContractStartDate,
            quota,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContractGetResponse{hasContract=$hasContract, asOf=$asOf, consumed=$consumed, contractMonths=$contractMonths, effectiveContractEndDate=$effectiveContractEndDate, effectiveContractStartDate=$effectiveContractStartDate, originalContractStartDate=$originalContractStartDate, quota=$quota, additionalProperties=$additionalProperties}"
}
