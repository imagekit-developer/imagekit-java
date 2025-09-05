// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

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
import com.imagekit.api.core.checkKnown
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import com.imagekit.api.models.UnnamedSchemaWithArrayParent1
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = UpdateFileDetailsRequest.Deserializer::class)
@JsonSerialize(using = UpdateFileDetailsRequest.Serializer::class)
class UpdateFileDetailsRequest
private constructor(
    private val updateFileDetails: UpdateFileDetails? = null,
    private val changePublicationStatus: ChangePublicationStatus? = null,
    private val _json: JsonValue? = null,
) {

    fun updateFileDetails(): Optional<UpdateFileDetails> = Optional.ofNullable(updateFileDetails)

    fun changePublicationStatus(): Optional<ChangePublicationStatus> =
        Optional.ofNullable(changePublicationStatus)

    fun isUpdateFileDetails(): Boolean = updateFileDetails != null

    fun isChangePublicationStatus(): Boolean = changePublicationStatus != null

    fun asUpdateFileDetails(): UpdateFileDetails = updateFileDetails.getOrThrow("updateFileDetails")

    fun asChangePublicationStatus(): ChangePublicationStatus =
        changePublicationStatus.getOrThrow("changePublicationStatus")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            updateFileDetails != null -> visitor.visitUpdateFileDetails(updateFileDetails)
            changePublicationStatus != null ->
                visitor.visitChangePublicationStatus(changePublicationStatus)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): UpdateFileDetailsRequest = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitUpdateFileDetails(updateFileDetails: UpdateFileDetails) {
                    updateFileDetails.validate()
                }

                override fun visitChangePublicationStatus(
                    changePublicationStatus: ChangePublicationStatus
                ) {
                    changePublicationStatus.validate()
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
                override fun visitUpdateFileDetails(updateFileDetails: UpdateFileDetails) =
                    updateFileDetails.validity()

                override fun visitChangePublicationStatus(
                    changePublicationStatus: ChangePublicationStatus
                ) = changePublicationStatus.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UpdateFileDetailsRequest &&
            updateFileDetails == other.updateFileDetails &&
            changePublicationStatus == other.changePublicationStatus
    }

    override fun hashCode(): Int = Objects.hash(updateFileDetails, changePublicationStatus)

    override fun toString(): String =
        when {
            updateFileDetails != null ->
                "UpdateFileDetailsRequest{updateFileDetails=$updateFileDetails}"
            changePublicationStatus != null ->
                "UpdateFileDetailsRequest{changePublicationStatus=$changePublicationStatus}"
            _json != null -> "UpdateFileDetailsRequest{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid UpdateFileDetailsRequest")
        }

    companion object {

        @JvmStatic
        fun ofUpdateFileDetails(updateFileDetails: UpdateFileDetails) =
            UpdateFileDetailsRequest(updateFileDetails = updateFileDetails)

        @JvmStatic
        fun ofChangePublicationStatus(changePublicationStatus: ChangePublicationStatus) =
            UpdateFileDetailsRequest(changePublicationStatus = changePublicationStatus)
    }

    /**
     * An interface that defines how to map each variant of [UpdateFileDetailsRequest] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        fun visitUpdateFileDetails(updateFileDetails: UpdateFileDetails): T

        fun visitChangePublicationStatus(changePublicationStatus: ChangePublicationStatus): T

        /**
         * Maps an unknown variant of [UpdateFileDetailsRequest] to a value of type [T].
         *
         * An instance of [UpdateFileDetailsRequest] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws ImageKitInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw ImageKitInvalidDataException("Unknown UpdateFileDetailsRequest: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<UpdateFileDetailsRequest>(UpdateFileDetailsRequest::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): UpdateFileDetailsRequest {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<UpdateFileDetails>())?.let {
                            UpdateFileDetailsRequest(updateFileDetails = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<ChangePublicationStatus>())?.let {
                            UpdateFileDetailsRequest(changePublicationStatus = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> UpdateFileDetailsRequest(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<UpdateFileDetailsRequest>(UpdateFileDetailsRequest::class) {

        override fun serialize(
            value: UpdateFileDetailsRequest,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.updateFileDetails != null -> generator.writeObject(value.updateFileDetails)
                value.changePublicationStatus != null ->
                    generator.writeObject(value.changePublicationStatus)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid UpdateFileDetailsRequest")
            }
        }
    }

    class UpdateFileDetails
    private constructor(
        private val customCoordinates: JsonField<String>,
        private val customMetadata: JsonField<CustomMetadata>,
        private val description: JsonField<String>,
        private val extensions: JsonField<List<UnnamedSchemaWithArrayParent1>>,
        private val removeAiTags: JsonField<RemoveAiTags>,
        private val tags: JsonField<List<String>>,
        private val webhookUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("customCoordinates")
            @ExcludeMissing
            customCoordinates: JsonField<String> = JsonMissing.of(),
            @JsonProperty("customMetadata")
            @ExcludeMissing
            customMetadata: JsonField<CustomMetadata> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("extensions")
            @ExcludeMissing
            extensions: JsonField<List<UnnamedSchemaWithArrayParent1>> = JsonMissing.of(),
            @JsonProperty("removeAITags")
            @ExcludeMissing
            removeAiTags: JsonField<RemoveAiTags> = JsonMissing.of(),
            @JsonProperty("tags") @ExcludeMissing tags: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("webhookUrl")
            @ExcludeMissing
            webhookUrl: JsonField<String> = JsonMissing.of(),
        ) : this(
            customCoordinates,
            customMetadata,
            description,
            extensions,
            removeAiTags,
            tags,
            webhookUrl,
            mutableMapOf(),
        )

        /**
         * Define an important area in the image in the format `x,y,width,height` e.g.
         * `10,10,100,100`. Send `null` to unset this value.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun customCoordinates(): Optional<String> =
            customCoordinates.getOptional("customCoordinates")

        /**
         * A key-value data to be associated with the asset. To unset a key, send `null` value for
         * that key. Before setting any custom metadata on an asset you have to create the field
         * using custom metadata fields API.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun customMetadata(): Optional<CustomMetadata> =
            customMetadata.getOptional("customMetadata")

        /**
         * Optional text to describe the contents of the file.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Array of extensions to be applied to the asset. Each extension can be configured with
         * specific parameters based on the extension type.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun extensions(): Optional<List<UnnamedSchemaWithArrayParent1>> =
            extensions.getOptional("extensions")

        /**
         * An array of AITags associated with the file that you want to remove, e.g. `["car",
         * "vehicle", "motorsports"]`.
         *
         * If you want to remove all AITags associated with the file, send a string - "all".
         *
         * Note: The remove operation for `AITags` executes before any of the `extensions` are
         * processed.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun removeAiTags(): Optional<RemoveAiTags> = removeAiTags.getOptional("removeAITags")

        /**
         * An array of tags associated with the file, such as `["tag1", "tag2"]`. Send `null` to
         * unset all tags associated with the file.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun tags(): Optional<List<String>> = tags.getOptional("tags")

        /**
         * The final status of extensions after they have completed execution will be delivered to
         * this endpoint as a POST request.
         * [Learn more](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#webhook-payload-structure)
         * about the webhook payload structure.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun webhookUrl(): Optional<String> = webhookUrl.getOptional("webhookUrl")

        /**
         * Returns the raw JSON value of [customCoordinates].
         *
         * Unlike [customCoordinates], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("customCoordinates")
        @ExcludeMissing
        fun _customCoordinates(): JsonField<String> = customCoordinates

        /**
         * Returns the raw JSON value of [customMetadata].
         *
         * Unlike [customMetadata], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("customMetadata")
        @ExcludeMissing
        fun _customMetadata(): JsonField<CustomMetadata> = customMetadata

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [extensions].
         *
         * Unlike [extensions], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("extensions")
        @ExcludeMissing
        fun _extensions(): JsonField<List<UnnamedSchemaWithArrayParent1>> = extensions

        /**
         * Returns the raw JSON value of [removeAiTags].
         *
         * Unlike [removeAiTags], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("removeAITags")
        @ExcludeMissing
        fun _removeAiTags(): JsonField<RemoveAiTags> = removeAiTags

        /**
         * Returns the raw JSON value of [tags].
         *
         * Unlike [tags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tags") @ExcludeMissing fun _tags(): JsonField<List<String>> = tags

        /**
         * Returns the raw JSON value of [webhookUrl].
         *
         * Unlike [webhookUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("webhookUrl")
        @ExcludeMissing
        fun _webhookUrl(): JsonField<String> = webhookUrl

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

            /** Returns a mutable builder for constructing an instance of [UpdateFileDetails]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UpdateFileDetails]. */
        class Builder internal constructor() {

            private var customCoordinates: JsonField<String> = JsonMissing.of()
            private var customMetadata: JsonField<CustomMetadata> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var extensions: JsonField<MutableList<UnnamedSchemaWithArrayParent1>>? = null
            private var removeAiTags: JsonField<RemoveAiTags> = JsonMissing.of()
            private var tags: JsonField<MutableList<String>>? = null
            private var webhookUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(updateFileDetails: UpdateFileDetails) = apply {
                customCoordinates = updateFileDetails.customCoordinates
                customMetadata = updateFileDetails.customMetadata
                description = updateFileDetails.description
                extensions = updateFileDetails.extensions.map { it.toMutableList() }
                removeAiTags = updateFileDetails.removeAiTags
                tags = updateFileDetails.tags.map { it.toMutableList() }
                webhookUrl = updateFileDetails.webhookUrl
                additionalProperties = updateFileDetails.additionalProperties.toMutableMap()
            }

            /**
             * Define an important area in the image in the format `x,y,width,height` e.g.
             * `10,10,100,100`. Send `null` to unset this value.
             */
            fun customCoordinates(customCoordinates: String?) =
                customCoordinates(JsonField.ofNullable(customCoordinates))

            /**
             * Alias for calling [Builder.customCoordinates] with `customCoordinates.orElse(null)`.
             */
            fun customCoordinates(customCoordinates: Optional<String>) =
                customCoordinates(customCoordinates.getOrNull())

            /**
             * Sets [Builder.customCoordinates] to an arbitrary JSON value.
             *
             * You should usually call [Builder.customCoordinates] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun customCoordinates(customCoordinates: JsonField<String>) = apply {
                this.customCoordinates = customCoordinates
            }

            /**
             * A key-value data to be associated with the asset. To unset a key, send `null` value
             * for that key. Before setting any custom metadata on an asset you have to create the
             * field using custom metadata fields API.
             */
            fun customMetadata(customMetadata: CustomMetadata) =
                customMetadata(JsonField.of(customMetadata))

            /**
             * Sets [Builder.customMetadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.customMetadata] with a well-typed [CustomMetadata]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun customMetadata(customMetadata: JsonField<CustomMetadata>) = apply {
                this.customMetadata = customMetadata
            }

            /** Optional text to describe the contents of the file. */
            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /**
             * Array of extensions to be applied to the asset. Each extension can be configured with
             * specific parameters based on the extension type.
             */
            fun extensions(extensions: List<UnnamedSchemaWithArrayParent1>) =
                extensions(JsonField.of(extensions))

            /**
             * Sets [Builder.extensions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.extensions] with a well-typed
             * `List<UnnamedSchemaWithArrayParent1>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun extensions(extensions: JsonField<List<UnnamedSchemaWithArrayParent1>>) = apply {
                this.extensions = extensions.map { it.toMutableList() }
            }

            /**
             * Adds a single [UnnamedSchemaWithArrayParent1] to [extensions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addExtension(extension: UnnamedSchemaWithArrayParent1) = apply {
                extensions =
                    (extensions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("extensions", it).add(extension)
                    }
            }

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent1.ofRemoveBg(removeBg)`.
             */
            fun addExtension(removeBg: UnnamedSchemaWithArrayParent1.RemoveBg) =
                addExtension(UnnamedSchemaWithArrayParent1.ofRemoveBg(removeBg))

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent1.ofAutoTaggingExtension(autoTaggingExtension)`.
             */
            fun addExtension(
                autoTaggingExtension: UnnamedSchemaWithArrayParent1.AutoTaggingExtension
            ) =
                addExtension(
                    UnnamedSchemaWithArrayParent1.ofAutoTaggingExtension(autoTaggingExtension)
                )

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent1.ofAiAutoDescription()`.
             */
            fun addExtensionAiAutoDescription() =
                addExtension(UnnamedSchemaWithArrayParent1.ofAiAutoDescription())

            /**
             * An array of AITags associated with the file that you want to remove, e.g. `["car",
             * "vehicle", "motorsports"]`.
             *
             * If you want to remove all AITags associated with the file, send a string - "all".
             *
             * Note: The remove operation for `AITags` executes before any of the `extensions` are
             * processed.
             */
            fun removeAiTags(removeAiTags: RemoveAiTags) = removeAiTags(JsonField.of(removeAiTags))

            /**
             * Sets [Builder.removeAiTags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.removeAiTags] with a well-typed [RemoveAiTags] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun removeAiTags(removeAiTags: JsonField<RemoveAiTags>) = apply {
                this.removeAiTags = removeAiTags
            }

            /** Alias for calling [removeAiTags] with `RemoveAiTags.ofStrings(strings)`. */
            fun removeAiTagsOfStrings(strings: List<String>) =
                removeAiTags(RemoveAiTags.ofStrings(strings))

            /** Alias for calling [removeAiTags] with `RemoveAiTags.ofAll()`. */
            fun removeAiTagsAll() = removeAiTags(RemoveAiTags.ofAll())

            /**
             * An array of tags associated with the file, such as `["tag1", "tag2"]`. Send `null` to
             * unset all tags associated with the file.
             */
            fun tags(tags: List<String>?) = tags(JsonField.ofNullable(tags))

            /** Alias for calling [Builder.tags] with `tags.orElse(null)`. */
            fun tags(tags: Optional<List<String>>) = tags(tags.getOrNull())

            /**
             * Sets [Builder.tags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tags] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tags(tags: JsonField<List<String>>) = apply {
                this.tags = tags.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [tags].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTag(tag: String) = apply {
                tags =
                    (tags ?: JsonField.of(mutableListOf())).also { checkKnown("tags", it).add(tag) }
            }

            /**
             * The final status of extensions after they have completed execution will be delivered
             * to this endpoint as a POST request.
             * [Learn more](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#webhook-payload-structure)
             * about the webhook payload structure.
             */
            fun webhookUrl(webhookUrl: String) = webhookUrl(JsonField.of(webhookUrl))

            /**
             * Sets [Builder.webhookUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.webhookUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun webhookUrl(webhookUrl: JsonField<String>) = apply { this.webhookUrl = webhookUrl }

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
             * Returns an immutable instance of [UpdateFileDetails].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): UpdateFileDetails =
                UpdateFileDetails(
                    customCoordinates,
                    customMetadata,
                    description,
                    (extensions ?: JsonMissing.of()).map { it.toImmutable() },
                    removeAiTags,
                    (tags ?: JsonMissing.of()).map { it.toImmutable() },
                    webhookUrl,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): UpdateFileDetails = apply {
            if (validated) {
                return@apply
            }

            customCoordinates()
            customMetadata().ifPresent { it.validate() }
            description()
            extensions().ifPresent { it.forEach { it.validate() } }
            removeAiTags().ifPresent { it.validate() }
            tags()
            webhookUrl()
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
            (if (customCoordinates.asKnown().isPresent) 1 else 0) +
                (customMetadata.asKnown().getOrNull()?.validity() ?: 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (extensions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (removeAiTags.asKnown().getOrNull()?.validity() ?: 0) +
                (tags.asKnown().getOrNull()?.size ?: 0) +
                (if (webhookUrl.asKnown().isPresent) 1 else 0)

        /**
         * A key-value data to be associated with the asset. To unset a key, send `null` value for
         * that key. Before setting any custom metadata on an asset you have to create the field
         * using custom metadata fields API.
         */
        class CustomMetadata
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

                /** Returns a mutable builder for constructing an instance of [CustomMetadata]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CustomMetadata]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(customMetadata: CustomMetadata) = apply {
                    additionalProperties = customMetadata.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [CustomMetadata].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): CustomMetadata = CustomMetadata(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): CustomMetadata = apply {
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
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

                return other is CustomMetadata && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "CustomMetadata{additionalProperties=$additionalProperties}"
        }

        @JsonDeserialize(using = UnnamedSchemaWithArrayParent1.Deserializer::class)
        @JsonSerialize(using = UnnamedSchemaWithArrayParent1.Serializer::class)
        class UnnamedSchemaWithArrayParent1
        private constructor(
            private val removeBg: RemoveBg? = null,
            private val autoTaggingExtension: AutoTaggingExtension? = null,
            private val aiAutoDescription: JsonValue? = null,
            private val _json: JsonValue? = null,
        ) {

            fun removeBg(): Optional<RemoveBg> = Optional.ofNullable(removeBg)

            fun autoTaggingExtension(): Optional<AutoTaggingExtension> =
                Optional.ofNullable(autoTaggingExtension)

            fun aiAutoDescription(): Optional<JsonValue> = Optional.ofNullable(aiAutoDescription)

            fun isRemoveBg(): Boolean = removeBg != null

            fun isAutoTaggingExtension(): Boolean = autoTaggingExtension != null

            fun isAiAutoDescription(): Boolean = aiAutoDescription != null

            fun asRemoveBg(): RemoveBg = removeBg.getOrThrow("removeBg")

            fun asAutoTaggingExtension(): AutoTaggingExtension =
                autoTaggingExtension.getOrThrow("autoTaggingExtension")

            fun asAiAutoDescription(): JsonValue = aiAutoDescription.getOrThrow("aiAutoDescription")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    removeBg != null -> visitor.visitRemoveBg(removeBg)
                    autoTaggingExtension != null ->
                        visitor.visitAutoTaggingExtension(autoTaggingExtension)
                    aiAutoDescription != null -> visitor.visitAiAutoDescription(aiAutoDescription)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): UnnamedSchemaWithArrayParent1 = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitRemoveBg(removeBg: RemoveBg) {
                            removeBg.validate()
                        }

                        override fun visitAutoTaggingExtension(
                            autoTaggingExtension: AutoTaggingExtension
                        ) {
                            autoTaggingExtension.validate()
                        }

                        override fun visitAiAutoDescription(aiAutoDescription: JsonValue) {
                            aiAutoDescription.let {
                                if (it != JsonValue.from(mapOf("name" to "ai-auto-description"))) {
                                    throw ImageKitInvalidDataException(
                                        "'aiAutoDescription' is invalid, received $it"
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
                        override fun visitRemoveBg(removeBg: RemoveBg) = removeBg.validity()

                        override fun visitAutoTaggingExtension(
                            autoTaggingExtension: AutoTaggingExtension
                        ) = autoTaggingExtension.validity()

                        override fun visitAiAutoDescription(aiAutoDescription: JsonValue) =
                            aiAutoDescription.let {
                                if (it == JsonValue.from(mapOf("name" to "ai-auto-description"))) 1
                                else 0
                            }

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UnnamedSchemaWithArrayParent1 &&
                    removeBg == other.removeBg &&
                    autoTaggingExtension == other.autoTaggingExtension &&
                    aiAutoDescription == other.aiAutoDescription
            }

            override fun hashCode(): Int =
                Objects.hash(removeBg, autoTaggingExtension, aiAutoDescription)

            override fun toString(): String =
                when {
                    removeBg != null -> "UnnamedSchemaWithArrayParent1{removeBg=$removeBg}"
                    autoTaggingExtension != null ->
                        "UnnamedSchemaWithArrayParent1{autoTaggingExtension=$autoTaggingExtension}"
                    aiAutoDescription != null ->
                        "UnnamedSchemaWithArrayParent1{aiAutoDescription=$aiAutoDescription}"
                    _json != null -> "UnnamedSchemaWithArrayParent1{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent1")
                }

            companion object {

                @JvmStatic
                fun ofRemoveBg(removeBg: RemoveBg) =
                    UnnamedSchemaWithArrayParent1(removeBg = removeBg)

                @JvmStatic
                fun ofAutoTaggingExtension(autoTaggingExtension: AutoTaggingExtension) =
                    UnnamedSchemaWithArrayParent1(autoTaggingExtension = autoTaggingExtension)

                @JvmStatic
                fun ofAiAutoDescription() =
                    UnnamedSchemaWithArrayParent1(
                        aiAutoDescription = JsonValue.from(mapOf("name" to "ai-auto-description"))
                    )
            }

            /**
             * An interface that defines how to map each variant of [UnnamedSchemaWithArrayParent1]
             * to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitRemoveBg(removeBg: RemoveBg): T

                fun visitAutoTaggingExtension(autoTaggingExtension: AutoTaggingExtension): T

                fun visitAiAutoDescription(aiAutoDescription: JsonValue): T

                /**
                 * Maps an unknown variant of [UnnamedSchemaWithArrayParent1] to a value of type
                 * [T].
                 *
                 * An instance of [UnnamedSchemaWithArrayParent1] can contain an unknown variant if
                 * it was deserialized from data that doesn't match any known variant. For example,
                 * if the SDK is on an older version than the API, then the API may respond with new
                 * variants that the SDK is unaware of.
                 *
                 * @throws ImageKitInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw ImageKitInvalidDataException(
                        "Unknown UnnamedSchemaWithArrayParent1: $json"
                    )
                }
            }

            internal class Deserializer :
                BaseDeserializer<UnnamedSchemaWithArrayParent1>(
                    UnnamedSchemaWithArrayParent1::class
                ) {

                override fun ObjectCodec.deserialize(
                    node: JsonNode
                ): UnnamedSchemaWithArrayParent1 {
                    val json = JsonValue.fromJsonNode(node)
                    val name = json.asObject().getOrNull()?.get("name")?.asString()?.getOrNull()

                    when (name) {
                        "remove-bg" -> {
                            return tryDeserialize(node, jacksonTypeRef<RemoveBg>())?.let {
                                UnnamedSchemaWithArrayParent1(removeBg = it, _json = json)
                            } ?: UnnamedSchemaWithArrayParent1(_json = json)
                        }
                        "ai-auto-description" -> {
                            return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let {
                                    UnnamedSchemaWithArrayParent1(
                                        aiAutoDescription = it,
                                        _json = json,
                                    )
                                }
                                ?.takeIf { it.isValid() }
                                ?: UnnamedSchemaWithArrayParent1(_json = json)
                        }
                    }

                    return tryDeserialize(node, jacksonTypeRef<AutoTaggingExtension>())?.let {
                        UnnamedSchemaWithArrayParent1(autoTaggingExtension = it, _json = json)
                    } ?: UnnamedSchemaWithArrayParent1(_json = json)
                }
            }

            internal class Serializer :
                BaseSerializer<UnnamedSchemaWithArrayParent1>(
                    UnnamedSchemaWithArrayParent1::class
                ) {

                override fun serialize(
                    value: UnnamedSchemaWithArrayParent1,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.removeBg != null -> generator.writeObject(value.removeBg)
                        value.autoTaggingExtension != null ->
                            generator.writeObject(value.autoTaggingExtension)
                        value.aiAutoDescription != null ->
                            generator.writeObject(value.aiAutoDescription)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent1")
                    }
                }
            }

            class RemoveBg
            private constructor(
                private val name: JsonValue,
                private val options: JsonField<Options>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("name") @ExcludeMissing name: JsonValue = JsonMissing.of(),
                    @JsonProperty("options")
                    @ExcludeMissing
                    options: JsonField<Options> = JsonMissing.of(),
                ) : this(name, options, mutableMapOf())

                /**
                 * Specifies the background removal extension.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("remove-bg")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonValue = name

                /**
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun options(): Optional<Options> = options.getOptional("options")

                /**
                 * Returns the raw JSON value of [options].
                 *
                 * Unlike [options], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("options")
                @ExcludeMissing
                fun _options(): JsonField<Options> = options

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

                    /** Returns a mutable builder for constructing an instance of [RemoveBg]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [RemoveBg]. */
                class Builder internal constructor() {

                    private var name: JsonValue = JsonValue.from("remove-bg")
                    private var options: JsonField<Options> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(removeBg: RemoveBg) = apply {
                        name = removeBg.name
                        options = removeBg.options
                        additionalProperties = removeBg.additionalProperties.toMutableMap()
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("remove-bg")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun name(name: JsonValue) = apply { this.name = name }

                    fun options(options: Options) = options(JsonField.of(options))

                    /**
                     * Sets [Builder.options] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.options] with a well-typed [Options] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun options(options: JsonField<Options>) = apply { this.options = options }

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
                     * Returns an immutable instance of [RemoveBg].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): RemoveBg =
                        RemoveBg(name, options, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): RemoveBg = apply {
                    if (validated) {
                        return@apply
                    }

                    _name().let {
                        if (it != JsonValue.from("remove-bg")) {
                            throw ImageKitInvalidDataException("'name' is invalid, received $it")
                        }
                    }
                    options().ifPresent { it.validate() }
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
                    name.let { if (it == JsonValue.from("remove-bg")) 1 else 0 } +
                        (options.asKnown().getOrNull()?.validity() ?: 0)

                class Options
                private constructor(
                    private val addShadow: JsonField<Boolean>,
                    private val bgColor: JsonField<String>,
                    private val bgImageUrl: JsonField<String>,
                    private val semitransparency: JsonField<Boolean>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("add_shadow")
                        @ExcludeMissing
                        addShadow: JsonField<Boolean> = JsonMissing.of(),
                        @JsonProperty("bg_color")
                        @ExcludeMissing
                        bgColor: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("bg_image_url")
                        @ExcludeMissing
                        bgImageUrl: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("semitransparency")
                        @ExcludeMissing
                        semitransparency: JsonField<Boolean> = JsonMissing.of(),
                    ) : this(addShadow, bgColor, bgImageUrl, semitransparency, mutableMapOf())

                    /**
                     * Whether to add an artificial shadow to the result. Default is false. Note:
                     * Adding shadows is currently only supported for car photos.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun addShadow(): Optional<Boolean> = addShadow.getOptional("add_shadow")

                    /**
                     * Specifies a solid color background using hex code (e.g., "81d4fa", "fff") or
                     * color name (e.g., "green"). If this parameter is set, `bg_image_url` must be
                     * empty.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun bgColor(): Optional<String> = bgColor.getOptional("bg_color")

                    /**
                     * Sets a background image from a URL. If this parameter is set, `bg_color` must
                     * be empty.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun bgImageUrl(): Optional<String> = bgImageUrl.getOptional("bg_image_url")

                    /**
                     * Allows semi-transparent regions in the result. Default is true. Note:
                     * Semitransparency is currently only supported for car windows.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun semitransparency(): Optional<Boolean> =
                        semitransparency.getOptional("semitransparency")

                    /**
                     * Returns the raw JSON value of [addShadow].
                     *
                     * Unlike [addShadow], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("add_shadow")
                    @ExcludeMissing
                    fun _addShadow(): JsonField<Boolean> = addShadow

                    /**
                     * Returns the raw JSON value of [bgColor].
                     *
                     * Unlike [bgColor], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("bg_color")
                    @ExcludeMissing
                    fun _bgColor(): JsonField<String> = bgColor

                    /**
                     * Returns the raw JSON value of [bgImageUrl].
                     *
                     * Unlike [bgImageUrl], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("bg_image_url")
                    @ExcludeMissing
                    fun _bgImageUrl(): JsonField<String> = bgImageUrl

                    /**
                     * Returns the raw JSON value of [semitransparency].
                     *
                     * Unlike [semitransparency], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("semitransparency")
                    @ExcludeMissing
                    fun _semitransparency(): JsonField<Boolean> = semitransparency

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

                        /** Returns a mutable builder for constructing an instance of [Options]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Options]. */
                    class Builder internal constructor() {

                        private var addShadow: JsonField<Boolean> = JsonMissing.of()
                        private var bgColor: JsonField<String> = JsonMissing.of()
                        private var bgImageUrl: JsonField<String> = JsonMissing.of()
                        private var semitransparency: JsonField<Boolean> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(options: Options) = apply {
                            addShadow = options.addShadow
                            bgColor = options.bgColor
                            bgImageUrl = options.bgImageUrl
                            semitransparency = options.semitransparency
                            additionalProperties = options.additionalProperties.toMutableMap()
                        }

                        /**
                         * Whether to add an artificial shadow to the result. Default is false.
                         * Note: Adding shadows is currently only supported for car photos.
                         */
                        fun addShadow(addShadow: Boolean) = addShadow(JsonField.of(addShadow))

                        /**
                         * Sets [Builder.addShadow] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.addShadow] with a well-typed [Boolean]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun addShadow(addShadow: JsonField<Boolean>) = apply {
                            this.addShadow = addShadow
                        }

                        /**
                         * Specifies a solid color background using hex code (e.g., "81d4fa", "fff")
                         * or color name (e.g., "green"). If this parameter is set, `bg_image_url`
                         * must be empty.
                         */
                        fun bgColor(bgColor: String) = bgColor(JsonField.of(bgColor))

                        /**
                         * Sets [Builder.bgColor] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.bgColor] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun bgColor(bgColor: JsonField<String>) = apply { this.bgColor = bgColor }

                        /**
                         * Sets a background image from a URL. If this parameter is set, `bg_color`
                         * must be empty.
                         */
                        fun bgImageUrl(bgImageUrl: String) = bgImageUrl(JsonField.of(bgImageUrl))

                        /**
                         * Sets [Builder.bgImageUrl] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.bgImageUrl] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun bgImageUrl(bgImageUrl: JsonField<String>) = apply {
                            this.bgImageUrl = bgImageUrl
                        }

                        /**
                         * Allows semi-transparent regions in the result. Default is true. Note:
                         * Semitransparency is currently only supported for car windows.
                         */
                        fun semitransparency(semitransparency: Boolean) =
                            semitransparency(JsonField.of(semitransparency))

                        /**
                         * Sets [Builder.semitransparency] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.semitransparency] with a well-typed
                         * [Boolean] value instead. This method is primarily for setting the field
                         * to an undocumented or not yet supported value.
                         */
                        fun semitransparency(semitransparency: JsonField<Boolean>) = apply {
                            this.semitransparency = semitransparency
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Options].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Options =
                            Options(
                                addShadow,
                                bgColor,
                                bgImageUrl,
                                semitransparency,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): Options = apply {
                        if (validated) {
                            return@apply
                        }

                        addShadow()
                        bgColor()
                        bgImageUrl()
                        semitransparency()
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
                        (if (addShadow.asKnown().isPresent) 1 else 0) +
                            (if (bgColor.asKnown().isPresent) 1 else 0) +
                            (if (bgImageUrl.asKnown().isPresent) 1 else 0) +
                            (if (semitransparency.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Options &&
                            addShadow == other.addShadow &&
                            bgColor == other.bgColor &&
                            bgImageUrl == other.bgImageUrl &&
                            semitransparency == other.semitransparency &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            addShadow,
                            bgColor,
                            bgImageUrl,
                            semitransparency,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Options{addShadow=$addShadow, bgColor=$bgColor, bgImageUrl=$bgImageUrl, semitransparency=$semitransparency, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is RemoveBg &&
                        name == other.name &&
                        options == other.options &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(name, options, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "RemoveBg{name=$name, options=$options, additionalProperties=$additionalProperties}"
            }

            class AutoTaggingExtension
            private constructor(
                private val maxTags: JsonField<Long>,
                private val minConfidence: JsonField<Long>,
                private val name: JsonField<Name>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("maxTags")
                    @ExcludeMissing
                    maxTags: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("minConfidence")
                    @ExcludeMissing
                    minConfidence: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("name") @ExcludeMissing name: JsonField<Name> = JsonMissing.of(),
                ) : this(maxTags, minConfidence, name, mutableMapOf())

                /**
                 * Maximum number of tags to attach to the asset.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun maxTags(): Long = maxTags.getRequired("maxTags")

                /**
                 * Minimum confidence level for tags to be considered valid.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun minConfidence(): Long = minConfidence.getRequired("minConfidence")

                /**
                 * Specifies the auto-tagging extension used.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun name(): Name = name.getRequired("name")

                /**
                 * Returns the raw JSON value of [maxTags].
                 *
                 * Unlike [maxTags], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("maxTags") @ExcludeMissing fun _maxTags(): JsonField<Long> = maxTags

                /**
                 * Returns the raw JSON value of [minConfidence].
                 *
                 * Unlike [minConfidence], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("minConfidence")
                @ExcludeMissing
                fun _minConfidence(): JsonField<Long> = minConfidence

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<Name> = name

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
                     * Returns a mutable builder for constructing an instance of
                     * [AutoTaggingExtension].
                     *
                     * The following fields are required:
                     * ```java
                     * .maxTags()
                     * .minConfidence()
                     * .name()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [AutoTaggingExtension]. */
                class Builder internal constructor() {

                    private var maxTags: JsonField<Long>? = null
                    private var minConfidence: JsonField<Long>? = null
                    private var name: JsonField<Name>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(autoTaggingExtension: AutoTaggingExtension) = apply {
                        maxTags = autoTaggingExtension.maxTags
                        minConfidence = autoTaggingExtension.minConfidence
                        name = autoTaggingExtension.name
                        additionalProperties =
                            autoTaggingExtension.additionalProperties.toMutableMap()
                    }

                    /** Maximum number of tags to attach to the asset. */
                    fun maxTags(maxTags: Long) = maxTags(JsonField.of(maxTags))

                    /**
                     * Sets [Builder.maxTags] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.maxTags] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun maxTags(maxTags: JsonField<Long>) = apply { this.maxTags = maxTags }

                    /** Minimum confidence level for tags to be considered valid. */
                    fun minConfidence(minConfidence: Long) =
                        minConfidence(JsonField.of(minConfidence))

                    /**
                     * Sets [Builder.minConfidence] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.minConfidence] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun minConfidence(minConfidence: JsonField<Long>) = apply {
                        this.minConfidence = minConfidence
                    }

                    /** Specifies the auto-tagging extension used. */
                    fun name(name: Name) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [Name] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<Name>) = apply { this.name = name }

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
                     * Returns an immutable instance of [AutoTaggingExtension].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .maxTags()
                     * .minConfidence()
                     * .name()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): AutoTaggingExtension =
                        AutoTaggingExtension(
                            checkRequired("maxTags", maxTags),
                            checkRequired("minConfidence", minConfidence),
                            checkRequired("name", name),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): AutoTaggingExtension = apply {
                    if (validated) {
                        return@apply
                    }

                    maxTags()
                    minConfidence()
                    name().validate()
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
                    (if (maxTags.asKnown().isPresent) 1 else 0) +
                        (if (minConfidence.asKnown().isPresent) 1 else 0) +
                        (name.asKnown().getOrNull()?.validity() ?: 0)

                /** Specifies the auto-tagging extension used. */
                class Name @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val GOOGLE_AUTO_TAGGING = of("google-auto-tagging")

                        @JvmField val AWS_AUTO_TAGGING = of("aws-auto-tagging")

                        @JvmStatic fun of(value: String) = Name(JsonField.of(value))
                    }

                    /** An enum containing [Name]'s known values. */
                    enum class Known {
                        GOOGLE_AUTO_TAGGING,
                        AWS_AUTO_TAGGING,
                    }

                    /**
                     * An enum containing [Name]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Name] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        GOOGLE_AUTO_TAGGING,
                        AWS_AUTO_TAGGING,
                        /**
                         * An enum member indicating that [Name] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            GOOGLE_AUTO_TAGGING -> Value.GOOGLE_AUTO_TAGGING
                            AWS_AUTO_TAGGING -> Value.AWS_AUTO_TAGGING
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value is a not
                     *   a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            GOOGLE_AUTO_TAGGING -> Known.GOOGLE_AUTO_TAGGING
                            AWS_AUTO_TAGGING -> Known.AWS_AUTO_TAGGING
                            else -> throw ImageKitInvalidDataException("Unknown Name: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            ImageKitInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): Name = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Name && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is AutoTaggingExtension &&
                        maxTags == other.maxTags &&
                        minConfidence == other.minConfidence &&
                        name == other.name &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(maxTags, minConfidence, name, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "AutoTaggingExtension{maxTags=$maxTags, minConfidence=$minConfidence, name=$name, additionalProperties=$additionalProperties}"
            }
        }

        /**
         * An array of AITags associated with the file that you want to remove, e.g. `["car",
         * "vehicle", "motorsports"]`.
         *
         * If you want to remove all AITags associated with the file, send a string - "all".
         *
         * Note: The remove operation for `AITags` executes before any of the `extensions` are
         * processed.
         */
        @JsonDeserialize(using = RemoveAiTags.Deserializer::class)
        @JsonSerialize(using = RemoveAiTags.Serializer::class)
        class RemoveAiTags
        private constructor(
            private val strings: List<String>? = null,
            private val all: JsonValue? = null,
            private val _json: JsonValue? = null,
        ) {

            fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

            fun all(): Optional<JsonValue> = Optional.ofNullable(all)

            fun isStrings(): Boolean = strings != null

            fun isAll(): Boolean = all != null

            fun asStrings(): List<String> = strings.getOrThrow("strings")

            fun asAll(): JsonValue = all.getOrThrow("all")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    strings != null -> visitor.visitStrings(strings)
                    all != null -> visitor.visitAll(all)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): RemoveAiTags = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitStrings(strings: List<String>) {}

                        override fun visitAll(all: JsonValue) {
                            all.let {
                                if (it != JsonValue.from("all")) {
                                    throw ImageKitInvalidDataException(
                                        "'all' is invalid, received $it"
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
                        override fun visitStrings(strings: List<String>) = strings.size

                        override fun visitAll(all: JsonValue) =
                            all.let { if (it == JsonValue.from("all")) 1 else 0 }

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RemoveAiTags && strings == other.strings && all == other.all
            }

            override fun hashCode(): Int = Objects.hash(strings, all)

            override fun toString(): String =
                when {
                    strings != null -> "RemoveAiTags{strings=$strings}"
                    all != null -> "RemoveAiTags{all=$all}"
                    _json != null -> "RemoveAiTags{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid RemoveAiTags")
                }

            companion object {

                @JvmStatic
                fun ofStrings(strings: List<String>) = RemoveAiTags(strings = strings.toImmutable())

                @JvmStatic fun ofAll() = RemoveAiTags(all = JsonValue.from("all"))
            }

            /**
             * An interface that defines how to map each variant of [RemoveAiTags] to a value of
             * type [T].
             */
            interface Visitor<out T> {

                fun visitStrings(strings: List<String>): T

                fun visitAll(all: JsonValue): T

                /**
                 * Maps an unknown variant of [RemoveAiTags] to a value of type [T].
                 *
                 * An instance of [RemoveAiTags] can contain an unknown variant if it was
                 * deserialized from data that doesn't match any known variant. For example, if the
                 * SDK is on an older version than the API, then the API may respond with new
                 * variants that the SDK is unaware of.
                 *
                 * @throws ImageKitInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw ImageKitInvalidDataException("Unknown RemoveAiTags: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<RemoveAiTags>(RemoveAiTags::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): RemoveAiTags {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { RemoveAiTags(all = it, _json = json) }
                                    ?.takeIf { it.isValid() },
                                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                    RemoveAiTags(strings = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
                        0 -> RemoveAiTags(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<RemoveAiTags>(RemoveAiTags::class) {

                override fun serialize(
                    value: RemoveAiTags,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.strings != null -> generator.writeObject(value.strings)
                        value.all != null -> generator.writeObject(value.all)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid RemoveAiTags")
                    }
                }
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UpdateFileDetails &&
                customCoordinates == other.customCoordinates &&
                customMetadata == other.customMetadata &&
                description == other.description &&
                extensions == other.extensions &&
                removeAiTags == other.removeAiTags &&
                tags == other.tags &&
                webhookUrl == other.webhookUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                customCoordinates,
                customMetadata,
                description,
                extensions,
                removeAiTags,
                tags,
                webhookUrl,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UpdateFileDetails{customCoordinates=$customCoordinates, customMetadata=$customMetadata, description=$description, extensions=$extensions, removeAiTags=$removeAiTags, tags=$tags, webhookUrl=$webhookUrl, additionalProperties=$additionalProperties}"
    }

    class ChangePublicationStatus
    private constructor(
        private val publish: JsonField<Publish>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("publish") @ExcludeMissing publish: JsonField<Publish> = JsonMissing.of()
        ) : this(publish, mutableMapOf())

        /**
         * Configure the publication status of a file and its versions.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun publish(): Optional<Publish> = publish.getOptional("publish")

        /**
         * Returns the raw JSON value of [publish].
         *
         * Unlike [publish], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("publish") @ExcludeMissing fun _publish(): JsonField<Publish> = publish

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
             * Returns a mutable builder for constructing an instance of [ChangePublicationStatus].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ChangePublicationStatus]. */
        class Builder internal constructor() {

            private var publish: JsonField<Publish> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(changePublicationStatus: ChangePublicationStatus) = apply {
                publish = changePublicationStatus.publish
                additionalProperties = changePublicationStatus.additionalProperties.toMutableMap()
            }

            /** Configure the publication status of a file and its versions. */
            fun publish(publish: Publish) = publish(JsonField.of(publish))

            /**
             * Sets [Builder.publish] to an arbitrary JSON value.
             *
             * You should usually call [Builder.publish] with a well-typed [Publish] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun publish(publish: JsonField<Publish>) = apply { this.publish = publish }

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
             * Returns an immutable instance of [ChangePublicationStatus].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ChangePublicationStatus =
                ChangePublicationStatus(publish, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ChangePublicationStatus = apply {
            if (validated) {
                return@apply
            }

            publish().ifPresent { it.validate() }
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
        internal fun validity(): Int = (publish.asKnown().getOrNull()?.validity() ?: 0)

        /** Configure the publication status of a file and its versions. */
        class Publish
        private constructor(
            private val isPublished: JsonField<Boolean>,
            private val includeFileVersions: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("isPublished")
                @ExcludeMissing
                isPublished: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("includeFileVersions")
                @ExcludeMissing
                includeFileVersions: JsonField<Boolean> = JsonMissing.of(),
            ) : this(isPublished, includeFileVersions, mutableMapOf())

            /**
             * Set to `true` to publish the file. Set to `false` to unpublish the file.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun isPublished(): Boolean = isPublished.getRequired("isPublished")

            /**
             * Set to `true` to publish/unpublish all versions of the file. Set to `false` to
             * publish/unpublish only the current version of the file.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun includeFileVersions(): Optional<Boolean> =
                includeFileVersions.getOptional("includeFileVersions")

            /**
             * Returns the raw JSON value of [isPublished].
             *
             * Unlike [isPublished], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("isPublished")
            @ExcludeMissing
            fun _isPublished(): JsonField<Boolean> = isPublished

            /**
             * Returns the raw JSON value of [includeFileVersions].
             *
             * Unlike [includeFileVersions], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("includeFileVersions")
            @ExcludeMissing
            fun _includeFileVersions(): JsonField<Boolean> = includeFileVersions

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
                 * Returns a mutable builder for constructing an instance of [Publish].
                 *
                 * The following fields are required:
                 * ```java
                 * .isPublished()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Publish]. */
            class Builder internal constructor() {

                private var isPublished: JsonField<Boolean>? = null
                private var includeFileVersions: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(publish: Publish) = apply {
                    isPublished = publish.isPublished
                    includeFileVersions = publish.includeFileVersions
                    additionalProperties = publish.additionalProperties.toMutableMap()
                }

                /** Set to `true` to publish the file. Set to `false` to unpublish the file. */
                fun isPublished(isPublished: Boolean) = isPublished(JsonField.of(isPublished))

                /**
                 * Sets [Builder.isPublished] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.isPublished] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun isPublished(isPublished: JsonField<Boolean>) = apply {
                    this.isPublished = isPublished
                }

                /**
                 * Set to `true` to publish/unpublish all versions of the file. Set to `false` to
                 * publish/unpublish only the current version of the file.
                 */
                fun includeFileVersions(includeFileVersions: Boolean) =
                    includeFileVersions(JsonField.of(includeFileVersions))

                /**
                 * Sets [Builder.includeFileVersions] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.includeFileVersions] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun includeFileVersions(includeFileVersions: JsonField<Boolean>) = apply {
                    this.includeFileVersions = includeFileVersions
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
                 * Returns an immutable instance of [Publish].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .isPublished()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Publish =
                    Publish(
                        checkRequired("isPublished", isPublished),
                        includeFileVersions,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Publish = apply {
                if (validated) {
                    return@apply
                }

                isPublished()
                includeFileVersions()
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
                (if (isPublished.asKnown().isPresent) 1 else 0) +
                    (if (includeFileVersions.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Publish &&
                    isPublished == other.isPublished &&
                    includeFileVersions == other.includeFileVersions &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(isPublished, includeFileVersions, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Publish{isPublished=$isPublished, includeFileVersions=$includeFileVersions, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ChangePublicationStatus &&
                publish == other.publish &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(publish, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ChangePublicationStatus{publish=$publish, additionalProperties=$additionalProperties}"
    }
}
