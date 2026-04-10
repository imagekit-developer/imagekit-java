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
import com.imagekit.api.models.UnnamedSchemaWithArrayParent4
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Schema for update file update request. */
@JsonDeserialize(using = UpdateFileRequest.Deserializer::class)
@JsonSerialize(using = UpdateFileRequest.Serializer::class)
class UpdateFileRequest
private constructor(
    private val details: UpdateFileDetails? = null,
    private val changePublicationStatus: ChangePublicationStatus? = null,
    private val _json: JsonValue? = null,
) {

    fun details(): Optional<UpdateFileDetails> = Optional.ofNullable(details)

    fun changePublicationStatus(): Optional<ChangePublicationStatus> =
        Optional.ofNullable(changePublicationStatus)

    fun isDetails(): Boolean = details != null

    fun isChangePublicationStatus(): Boolean = changePublicationStatus != null

    fun asDetails(): UpdateFileDetails = details.getOrThrow("details")

    fun asChangePublicationStatus(): ChangePublicationStatus =
        changePublicationStatus.getOrThrow("changePublicationStatus")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            details != null -> visitor.visitDetails(details)
            changePublicationStatus != null ->
                visitor.visitChangePublicationStatus(changePublicationStatus)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): UpdateFileRequest = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitDetails(details: UpdateFileDetails) {
                    details.validate()
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
                override fun visitDetails(details: UpdateFileDetails) = details.validity()

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

        return other is UpdateFileRequest &&
            details == other.details &&
            changePublicationStatus == other.changePublicationStatus
    }

    override fun hashCode(): Int = Objects.hash(details, changePublicationStatus)

    override fun toString(): String =
        when {
            details != null -> "UpdateFileRequest{details=$details}"
            changePublicationStatus != null ->
                "UpdateFileRequest{changePublicationStatus=$changePublicationStatus}"
            _json != null -> "UpdateFileRequest{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid UpdateFileRequest")
        }

    companion object {

        @JvmStatic fun ofDetails(details: UpdateFileDetails) = UpdateFileRequest(details = details)

        @JvmStatic
        fun ofChangePublicationStatus(changePublicationStatus: ChangePublicationStatus) =
            UpdateFileRequest(changePublicationStatus = changePublicationStatus)
    }

    /**
     * An interface that defines how to map each variant of [UpdateFileRequest] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitDetails(details: UpdateFileDetails): T

        fun visitChangePublicationStatus(changePublicationStatus: ChangePublicationStatus): T

        /**
         * Maps an unknown variant of [UpdateFileRequest] to a value of type [T].
         *
         * An instance of [UpdateFileRequest] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws ImageKitInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw ImageKitInvalidDataException("Unknown UpdateFileRequest: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<UpdateFileRequest>(UpdateFileRequest::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): UpdateFileRequest {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<UpdateFileDetails>())?.let {
                            UpdateFileRequest(details = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<ChangePublicationStatus>())?.let {
                            UpdateFileRequest(changePublicationStatus = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> UpdateFileRequest(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<UpdateFileRequest>(UpdateFileRequest::class) {

        override fun serialize(
            value: UpdateFileRequest,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.details != null -> generator.writeObject(value.details)
                value.changePublicationStatus != null ->
                    generator.writeObject(value.changePublicationStatus)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid UpdateFileRequest")
            }
        }
    }

    class UpdateFileDetails
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val customCoordinates: JsonField<String>,
        private val customMetadata: JsonField<CustomMetadata>,
        private val description: JsonField<String>,
        private val extensions: JsonField<List<UnnamedSchemaWithArrayParent4>>,
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
            extensions: JsonField<List<UnnamedSchemaWithArrayParent4>> = JsonMissing.of(),
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
        fun extensions(): Optional<List<UnnamedSchemaWithArrayParent4>> =
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
        fun _extensions(): JsonField<List<UnnamedSchemaWithArrayParent4>> = extensions

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
            private var extensions: JsonField<MutableList<UnnamedSchemaWithArrayParent4>>? = null
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
            fun extensions(extensions: List<UnnamedSchemaWithArrayParent4>) =
                extensions(JsonField.of(extensions))

            /**
             * Sets [Builder.extensions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.extensions] with a well-typed
             * `List<UnnamedSchemaWithArrayParent4>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun extensions(extensions: JsonField<List<UnnamedSchemaWithArrayParent4>>) = apply {
                this.extensions = extensions.map { it.toMutableList() }
            }

            /**
             * Adds a single [UnnamedSchemaWithArrayParent4] to [extensions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addExtension(extension: UnnamedSchemaWithArrayParent4) = apply {
                extensions =
                    (extensions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("extensions", it).add(extension)
                    }
            }

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent4.ofRemoveBg(removeBg)`.
             */
            fun addExtension(removeBg: UnnamedSchemaWithArrayParent4.RemoveBg) =
                addExtension(UnnamedSchemaWithArrayParent4.ofRemoveBg(removeBg))

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(autoTaggingExtension)`.
             */
            fun addExtension(
                autoTaggingExtension: UnnamedSchemaWithArrayParent4.AutoTaggingExtension
            ) =
                addExtension(
                    UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(autoTaggingExtension)
                )

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent4.ofAiAutoDescription()`.
             */
            fun addExtensionAiAutoDescription() =
                addExtension(UnnamedSchemaWithArrayParent4.ofAiAutoDescription())

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent4.ofAiTasks(aiTasks)`.
             */
            fun addExtension(aiTasks: UnnamedSchemaWithArrayParent4.AiTasks) =
                addExtension(UnnamedSchemaWithArrayParent4.ofAiTasks(aiTasks))

            /**
             * Alias for calling [addExtension] with the following:
             * ```java
             * UnnamedSchemaWithArrayParent4.AiTasks.builder()
             *     .tasks(tasks)
             *     .build()
             * ```
             */
            fun addAiTasksExtension(tasks: List<UnnamedSchemaWithArrayParent4.AiTasks.Task>) =
                addExtension(UnnamedSchemaWithArrayParent4.AiTasks.builder().tasks(tasks).build())

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent4.ofSavedExtension(savedExtension)`.
             */
            fun addExtension(savedExtension: UnnamedSchemaWithArrayParent4.SavedExtension) =
                addExtension(UnnamedSchemaWithArrayParent4.ofSavedExtension(savedExtension))

            /**
             * Alias for calling [addExtension] with the following:
             * ```java
             * UnnamedSchemaWithArrayParent4.SavedExtension.builder()
             *     .id(id)
             *     .build()
             * ```
             */
            fun addSavedExtensionExtension(id: String) =
                addExtension(UnnamedSchemaWithArrayParent4.SavedExtension.builder().id(id).build())

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

        @JsonDeserialize(using = UnnamedSchemaWithArrayParent4.Deserializer::class)
        @JsonSerialize(using = UnnamedSchemaWithArrayParent4.Serializer::class)
        class UnnamedSchemaWithArrayParent4
        private constructor(
            private val removeBg: RemoveBg? = null,
            private val autoTaggingExtension: AutoTaggingExtension? = null,
            private val aiAutoDescription: JsonValue? = null,
            private val aiTasks: AiTasks? = null,
            private val savedExtension: SavedExtension? = null,
            private val _json: JsonValue? = null,
        ) {

            fun removeBg(): Optional<RemoveBg> = Optional.ofNullable(removeBg)

            fun autoTaggingExtension(): Optional<AutoTaggingExtension> =
                Optional.ofNullable(autoTaggingExtension)

            fun aiAutoDescription(): Optional<JsonValue> = Optional.ofNullable(aiAutoDescription)

            fun aiTasks(): Optional<AiTasks> = Optional.ofNullable(aiTasks)

            fun savedExtension(): Optional<SavedExtension> = Optional.ofNullable(savedExtension)

            fun isRemoveBg(): Boolean = removeBg != null

            fun isAutoTaggingExtension(): Boolean = autoTaggingExtension != null

            fun isAiAutoDescription(): Boolean = aiAutoDescription != null

            fun isAiTasks(): Boolean = aiTasks != null

            fun isSavedExtension(): Boolean = savedExtension != null

            fun asRemoveBg(): RemoveBg = removeBg.getOrThrow("removeBg")

            fun asAutoTaggingExtension(): AutoTaggingExtension =
                autoTaggingExtension.getOrThrow("autoTaggingExtension")

            fun asAiAutoDescription(): JsonValue = aiAutoDescription.getOrThrow("aiAutoDescription")

            fun asAiTasks(): AiTasks = aiTasks.getOrThrow("aiTasks")

            fun asSavedExtension(): SavedExtension = savedExtension.getOrThrow("savedExtension")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    removeBg != null -> visitor.visitRemoveBg(removeBg)
                    autoTaggingExtension != null ->
                        visitor.visitAutoTaggingExtension(autoTaggingExtension)
                    aiAutoDescription != null -> visitor.visitAiAutoDescription(aiAutoDescription)
                    aiTasks != null -> visitor.visitAiTasks(aiTasks)
                    savedExtension != null -> visitor.visitSavedExtension(savedExtension)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): UnnamedSchemaWithArrayParent4 = apply {
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

                        override fun visitAiTasks(aiTasks: AiTasks) {
                            aiTasks.validate()
                        }

                        override fun visitSavedExtension(savedExtension: SavedExtension) {
                            savedExtension.validate()
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

                        override fun visitAiTasks(aiTasks: AiTasks) = aiTasks.validity()

                        override fun visitSavedExtension(savedExtension: SavedExtension) =
                            savedExtension.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UnnamedSchemaWithArrayParent4 &&
                    removeBg == other.removeBg &&
                    autoTaggingExtension == other.autoTaggingExtension &&
                    aiAutoDescription == other.aiAutoDescription &&
                    aiTasks == other.aiTasks &&
                    savedExtension == other.savedExtension
            }

            override fun hashCode(): Int =
                Objects.hash(
                    removeBg,
                    autoTaggingExtension,
                    aiAutoDescription,
                    aiTasks,
                    savedExtension,
                )

            override fun toString(): String =
                when {
                    removeBg != null -> "UnnamedSchemaWithArrayParent4{removeBg=$removeBg}"
                    autoTaggingExtension != null ->
                        "UnnamedSchemaWithArrayParent4{autoTaggingExtension=$autoTaggingExtension}"
                    aiAutoDescription != null ->
                        "UnnamedSchemaWithArrayParent4{aiAutoDescription=$aiAutoDescription}"
                    aiTasks != null -> "UnnamedSchemaWithArrayParent4{aiTasks=$aiTasks}"
                    savedExtension != null ->
                        "UnnamedSchemaWithArrayParent4{savedExtension=$savedExtension}"
                    _json != null -> "UnnamedSchemaWithArrayParent4{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent4")
                }

            companion object {

                @JvmStatic
                fun ofRemoveBg(removeBg: RemoveBg) =
                    UnnamedSchemaWithArrayParent4(removeBg = removeBg)

                @JvmStatic
                fun ofAutoTaggingExtension(autoTaggingExtension: AutoTaggingExtension) =
                    UnnamedSchemaWithArrayParent4(autoTaggingExtension = autoTaggingExtension)

                @JvmStatic
                fun ofAiAutoDescription() =
                    UnnamedSchemaWithArrayParent4(
                        aiAutoDescription = JsonValue.from(mapOf("name" to "ai-auto-description"))
                    )

                @JvmStatic
                fun ofAiTasks(aiTasks: AiTasks) = UnnamedSchemaWithArrayParent4(aiTasks = aiTasks)

                @JvmStatic
                fun ofSavedExtension(savedExtension: SavedExtension) =
                    UnnamedSchemaWithArrayParent4(savedExtension = savedExtension)
            }

            /**
             * An interface that defines how to map each variant of [UnnamedSchemaWithArrayParent4]
             * to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitRemoveBg(removeBg: RemoveBg): T

                fun visitAutoTaggingExtension(autoTaggingExtension: AutoTaggingExtension): T

                fun visitAiAutoDescription(aiAutoDescription: JsonValue): T

                fun visitAiTasks(aiTasks: AiTasks): T

                fun visitSavedExtension(savedExtension: SavedExtension): T

                /**
                 * Maps an unknown variant of [UnnamedSchemaWithArrayParent4] to a value of type
                 * [T].
                 *
                 * An instance of [UnnamedSchemaWithArrayParent4] can contain an unknown variant if
                 * it was deserialized from data that doesn't match any known variant. For example,
                 * if the SDK is on an older version than the API, then the API may respond with new
                 * variants that the SDK is unaware of.
                 *
                 * @throws ImageKitInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw ImageKitInvalidDataException(
                        "Unknown UnnamedSchemaWithArrayParent4: $json"
                    )
                }
            }

            internal class Deserializer :
                BaseDeserializer<UnnamedSchemaWithArrayParent4>(
                    UnnamedSchemaWithArrayParent4::class
                ) {

                override fun ObjectCodec.deserialize(
                    node: JsonNode
                ): UnnamedSchemaWithArrayParent4 {
                    val json = JsonValue.fromJsonNode(node)
                    val name = json.asObject().getOrNull()?.get("name")?.asString()?.getOrNull()

                    when (name) {
                        "remove-bg" -> {
                            return tryDeserialize(node, jacksonTypeRef<RemoveBg>())?.let {
                                UnnamedSchemaWithArrayParent4(removeBg = it, _json = json)
                            } ?: UnnamedSchemaWithArrayParent4(_json = json)
                        }
                        "ai-auto-description" -> {
                            return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let {
                                    UnnamedSchemaWithArrayParent4(
                                        aiAutoDescription = it,
                                        _json = json,
                                    )
                                }
                                ?.takeIf { it.isValid() }
                                ?: UnnamedSchemaWithArrayParent4(_json = json)
                        }
                        "ai-tasks" -> {
                            return tryDeserialize(node, jacksonTypeRef<AiTasks>())?.let {
                                UnnamedSchemaWithArrayParent4(aiTasks = it, _json = json)
                            } ?: UnnamedSchemaWithArrayParent4(_json = json)
                        }
                        "saved-extension" -> {
                            return tryDeserialize(node, jacksonTypeRef<SavedExtension>())?.let {
                                UnnamedSchemaWithArrayParent4(savedExtension = it, _json = json)
                            } ?: UnnamedSchemaWithArrayParent4(_json = json)
                        }
                    }

                    return tryDeserialize(node, jacksonTypeRef<AutoTaggingExtension>())?.let {
                        UnnamedSchemaWithArrayParent4(autoTaggingExtension = it, _json = json)
                    } ?: UnnamedSchemaWithArrayParent4(_json = json)
                }
            }

            internal class Serializer :
                BaseSerializer<UnnamedSchemaWithArrayParent4>(
                    UnnamedSchemaWithArrayParent4::class
                ) {

                override fun serialize(
                    value: UnnamedSchemaWithArrayParent4,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.removeBg != null -> generator.writeObject(value.removeBg)
                        value.autoTaggingExtension != null ->
                            generator.writeObject(value.autoTaggingExtension)
                        value.aiAutoDescription != null ->
                            generator.writeObject(value.aiAutoDescription)
                        value.aiTasks != null -> generator.writeObject(value.aiTasks)
                        value.savedExtension != null -> generator.writeObject(value.savedExtension)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent4")
                    }
                }
            }

            class RemoveBg
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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

            class AiTasks
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val name: JsonValue,
                private val tasks: JsonField<List<Task>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("name") @ExcludeMissing name: JsonValue = JsonMissing.of(),
                    @JsonProperty("tasks")
                    @ExcludeMissing
                    tasks: JsonField<List<Task>> = JsonMissing.of(),
                ) : this(name, tasks, mutableMapOf())

                /**
                 * Specifies the AI tasks extension for automated image analysis using AI models.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("ai-tasks")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonValue = name

                /**
                 * Array of task objects defining AI operations to perform on the asset.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun tasks(): List<Task> = tasks.getRequired("tasks")

                /**
                 * Returns the raw JSON value of [tasks].
                 *
                 * Unlike [tasks], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("tasks") @ExcludeMissing fun _tasks(): JsonField<List<Task>> = tasks

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
                     * Returns a mutable builder for constructing an instance of [AiTasks].
                     *
                     * The following fields are required:
                     * ```java
                     * .tasks()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [AiTasks]. */
                class Builder internal constructor() {

                    private var name: JsonValue = JsonValue.from("ai-tasks")
                    private var tasks: JsonField<MutableList<Task>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(aiTasks: AiTasks) = apply {
                        name = aiTasks.name
                        tasks = aiTasks.tasks.map { it.toMutableList() }
                        additionalProperties = aiTasks.additionalProperties.toMutableMap()
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("ai-tasks")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun name(name: JsonValue) = apply { this.name = name }

                    /** Array of task objects defining AI operations to perform on the asset. */
                    fun tasks(tasks: List<Task>) = tasks(JsonField.of(tasks))

                    /**
                     * Sets [Builder.tasks] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.tasks] with a well-typed `List<Task>` value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun tasks(tasks: JsonField<List<Task>>) = apply {
                        this.tasks = tasks.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Task] to [tasks].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addTask(task: Task) = apply {
                        tasks =
                            (tasks ?: JsonField.of(mutableListOf())).also {
                                checkKnown("tasks", it).add(task)
                            }
                    }

                    /** Alias for calling [addTask] with `Task.ofSelectTags(selectTags)`. */
                    fun addTask(selectTags: Task.SelectTags) =
                        addTask(Task.ofSelectTags(selectTags))

                    /**
                     * Alias for calling [addTask] with the following:
                     * ```java
                     * Task.SelectTags.builder()
                     *     .instruction(instruction)
                     *     .build()
                     * ```
                     */
                    fun addSelectTagsTask(instruction: String) =
                        addTask(Task.SelectTags.builder().instruction(instruction).build())

                    /** Alias for calling [addTask] with `Task.ofSelectMetadata(selectMetadata)`. */
                    fun addTask(selectMetadata: Task.SelectMetadata) =
                        addTask(Task.ofSelectMetadata(selectMetadata))

                    /** Alias for calling [addTask] with `Task.ofYesNo(yesNo)`. */
                    fun addTask(yesNo: Task.YesNo) = addTask(Task.ofYesNo(yesNo))

                    /**
                     * Alias for calling [addTask] with the following:
                     * ```java
                     * Task.YesNo.builder()
                     *     .instruction(instruction)
                     *     .build()
                     * ```
                     */
                    fun addYesNoTask(instruction: String) =
                        addTask(Task.YesNo.builder().instruction(instruction).build())

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
                     * Returns an immutable instance of [AiTasks].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .tasks()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): AiTasks =
                        AiTasks(
                            name,
                            checkRequired("tasks", tasks).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): AiTasks = apply {
                    if (validated) {
                        return@apply
                    }

                    _name().let {
                        if (it != JsonValue.from("ai-tasks")) {
                            throw ImageKitInvalidDataException("'name' is invalid, received $it")
                        }
                    }
                    tasks().forEach { it.validate() }
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
                    name.let { if (it == JsonValue.from("ai-tasks")) 1 else 0 } +
                        (tasks.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

                @JsonDeserialize(using = Task.Deserializer::class)
                @JsonSerialize(using = Task.Serializer::class)
                class Task
                private constructor(
                    private val selectTags: SelectTags? = null,
                    private val selectMetadata: SelectMetadata? = null,
                    private val yesNo: YesNo? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun selectTags(): Optional<SelectTags> = Optional.ofNullable(selectTags)

                    fun selectMetadata(): Optional<SelectMetadata> =
                        Optional.ofNullable(selectMetadata)

                    fun yesNo(): Optional<YesNo> = Optional.ofNullable(yesNo)

                    fun isSelectTags(): Boolean = selectTags != null

                    fun isSelectMetadata(): Boolean = selectMetadata != null

                    fun isYesNo(): Boolean = yesNo != null

                    fun asSelectTags(): SelectTags = selectTags.getOrThrow("selectTags")

                    fun asSelectMetadata(): SelectMetadata =
                        selectMetadata.getOrThrow("selectMetadata")

                    fun asYesNo(): YesNo = yesNo.getOrThrow("yesNo")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T =
                        when {
                            selectTags != null -> visitor.visitSelectTags(selectTags)
                            selectMetadata != null -> visitor.visitSelectMetadata(selectMetadata)
                            yesNo != null -> visitor.visitYesNo(yesNo)
                            else -> visitor.unknown(_json)
                        }

                    private var validated: Boolean = false

                    fun validate(): Task = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitSelectTags(selectTags: SelectTags) {
                                    selectTags.validate()
                                }

                                override fun visitSelectMetadata(selectMetadata: SelectMetadata) {
                                    selectMetadata.validate()
                                }

                                override fun visitYesNo(yesNo: YesNo) {
                                    yesNo.validate()
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
                                override fun visitSelectTags(selectTags: SelectTags) =
                                    selectTags.validity()

                                override fun visitSelectMetadata(selectMetadata: SelectMetadata) =
                                    selectMetadata.validity()

                                override fun visitYesNo(yesNo: YesNo) = yesNo.validity()

                                override fun unknown(json: JsonValue?) = 0
                            }
                        )

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Task &&
                            selectTags == other.selectTags &&
                            selectMetadata == other.selectMetadata &&
                            yesNo == other.yesNo
                    }

                    override fun hashCode(): Int = Objects.hash(selectTags, selectMetadata, yesNo)

                    override fun toString(): String =
                        when {
                            selectTags != null -> "Task{selectTags=$selectTags}"
                            selectMetadata != null -> "Task{selectMetadata=$selectMetadata}"
                            yesNo != null -> "Task{yesNo=$yesNo}"
                            _json != null -> "Task{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid Task")
                        }

                    companion object {

                        @JvmStatic
                        fun ofSelectTags(selectTags: SelectTags) = Task(selectTags = selectTags)

                        @JvmStatic
                        fun ofSelectMetadata(selectMetadata: SelectMetadata) =
                            Task(selectMetadata = selectMetadata)

                        @JvmStatic fun ofYesNo(yesNo: YesNo) = Task(yesNo = yesNo)
                    }

                    /**
                     * An interface that defines how to map each variant of [Task] to a value of
                     * type [T].
                     */
                    interface Visitor<out T> {

                        fun visitSelectTags(selectTags: SelectTags): T

                        fun visitSelectMetadata(selectMetadata: SelectMetadata): T

                        fun visitYesNo(yesNo: YesNo): T

                        /**
                         * Maps an unknown variant of [Task] to a value of type [T].
                         *
                         * An instance of [Task] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
                         *
                         * @throws ImageKitInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw ImageKitInvalidDataException("Unknown Task: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<Task>(Task::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): Task {
                            val json = JsonValue.fromJsonNode(node)
                            val type =
                                json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                            when (type) {
                                "select_tags" -> {
                                    return tryDeserialize(node, jacksonTypeRef<SelectTags>())?.let {
                                        Task(selectTags = it, _json = json)
                                    } ?: Task(_json = json)
                                }
                                "select_metadata" -> {
                                    return tryDeserialize(node, jacksonTypeRef<SelectMetadata>())
                                        ?.let { Task(selectMetadata = it, _json = json) }
                                        ?: Task(_json = json)
                                }
                                "yes_no" -> {
                                    return tryDeserialize(node, jacksonTypeRef<YesNo>())?.let {
                                        Task(yesNo = it, _json = json)
                                    } ?: Task(_json = json)
                                }
                            }

                            return Task(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<Task>(Task::class) {

                        override fun serialize(
                            value: Task,
                            generator: JsonGenerator,
                            provider: SerializerProvider,
                        ) {
                            when {
                                value.selectTags != null -> generator.writeObject(value.selectTags)
                                value.selectMetadata != null ->
                                    generator.writeObject(value.selectMetadata)
                                value.yesNo != null -> generator.writeObject(value.yesNo)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid Task")
                            }
                        }
                    }

                    class SelectTags
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val instruction: JsonField<String>,
                        private val type: JsonValue,
                        private val maxSelections: JsonField<Long>,
                        private val minSelections: JsonField<Long>,
                        private val vocabulary: JsonField<List<String>>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("instruction")
                            @ExcludeMissing
                            instruction: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonValue = JsonMissing.of(),
                            @JsonProperty("max_selections")
                            @ExcludeMissing
                            maxSelections: JsonField<Long> = JsonMissing.of(),
                            @JsonProperty("min_selections")
                            @ExcludeMissing
                            minSelections: JsonField<Long> = JsonMissing.of(),
                            @JsonProperty("vocabulary")
                            @ExcludeMissing
                            vocabulary: JsonField<List<String>> = JsonMissing.of(),
                        ) : this(
                            instruction,
                            type,
                            maxSelections,
                            minSelections,
                            vocabulary,
                            mutableMapOf(),
                        )

                        /**
                         * The question or instruction for the AI to analyze the image.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun instruction(): String = instruction.getRequired("instruction")

                        /**
                         * Task type that analyzes the image and adds matching tags from a
                         * vocabulary.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("select_tags")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Maximum number of tags to select from the vocabulary.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun maxSelections(): Optional<Long> =
                            maxSelections.getOptional("max_selections")

                        /**
                         * Minimum number of tags to select from the vocabulary.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun minSelections(): Optional<Long> =
                            minSelections.getOptional("min_selections")

                        /**
                         * Array of possible tag values. The combined length of all strings must not
                         * exceed 500 characters, and values cannot include the `%` character. When
                         * providing large vocabularies (more than 30 items), the AI may not follow
                         * the list strictly.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun vocabulary(): Optional<List<String>> =
                            vocabulary.getOptional("vocabulary")

                        /**
                         * Returns the raw JSON value of [instruction].
                         *
                         * Unlike [instruction], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("instruction")
                        @ExcludeMissing
                        fun _instruction(): JsonField<String> = instruction

                        /**
                         * Returns the raw JSON value of [maxSelections].
                         *
                         * Unlike [maxSelections], this method doesn't throw if the JSON field has
                         * an unexpected type.
                         */
                        @JsonProperty("max_selections")
                        @ExcludeMissing
                        fun _maxSelections(): JsonField<Long> = maxSelections

                        /**
                         * Returns the raw JSON value of [minSelections].
                         *
                         * Unlike [minSelections], this method doesn't throw if the JSON field has
                         * an unexpected type.
                         */
                        @JsonProperty("min_selections")
                        @ExcludeMissing
                        fun _minSelections(): JsonField<Long> = minSelections

                        /**
                         * Returns the raw JSON value of [vocabulary].
                         *
                         * Unlike [vocabulary], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("vocabulary")
                        @ExcludeMissing
                        fun _vocabulary(): JsonField<List<String>> = vocabulary

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
                             * [SelectTags].
                             *
                             * The following fields are required:
                             * ```java
                             * .instruction()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [SelectTags]. */
                        class Builder internal constructor() {

                            private var instruction: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("select_tags")
                            private var maxSelections: JsonField<Long> = JsonMissing.of()
                            private var minSelections: JsonField<Long> = JsonMissing.of()
                            private var vocabulary: JsonField<MutableList<String>>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(selectTags: SelectTags) = apply {
                                instruction = selectTags.instruction
                                type = selectTags.type
                                maxSelections = selectTags.maxSelections
                                minSelections = selectTags.minSelections
                                vocabulary = selectTags.vocabulary.map { it.toMutableList() }
                                additionalProperties =
                                    selectTags.additionalProperties.toMutableMap()
                            }

                            /** The question or instruction for the AI to analyze the image. */
                            fun instruction(instruction: String) =
                                instruction(JsonField.of(instruction))

                            /**
                             * Sets [Builder.instruction] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.instruction] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun instruction(instruction: JsonField<String>) = apply {
                                this.instruction = instruction
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("select_tags")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            /** Maximum number of tags to select from the vocabulary. */
                            fun maxSelections(maxSelections: Long) =
                                maxSelections(JsonField.of(maxSelections))

                            /**
                             * Sets [Builder.maxSelections] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.maxSelections] with a well-typed
                             * [Long] value instead. This method is primarily for setting the field
                             * to an undocumented or not yet supported value.
                             */
                            fun maxSelections(maxSelections: JsonField<Long>) = apply {
                                this.maxSelections = maxSelections
                            }

                            /** Minimum number of tags to select from the vocabulary. */
                            fun minSelections(minSelections: Long) =
                                minSelections(JsonField.of(minSelections))

                            /**
                             * Sets [Builder.minSelections] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.minSelections] with a well-typed
                             * [Long] value instead. This method is primarily for setting the field
                             * to an undocumented or not yet supported value.
                             */
                            fun minSelections(minSelections: JsonField<Long>) = apply {
                                this.minSelections = minSelections
                            }

                            /**
                             * Array of possible tag values. The combined length of all strings must
                             * not exceed 500 characters, and values cannot include the `%`
                             * character. When providing large vocabularies (more than 30 items),
                             * the AI may not follow the list strictly.
                             */
                            fun vocabulary(vocabulary: List<String>) =
                                vocabulary(JsonField.of(vocabulary))

                            /**
                             * Sets [Builder.vocabulary] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.vocabulary] with a well-typed
                             * `List<String>` value instead. This method is primarily for setting
                             * the field to an undocumented or not yet supported value.
                             */
                            fun vocabulary(vocabulary: JsonField<List<String>>) = apply {
                                this.vocabulary = vocabulary.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [String] to [Builder.vocabulary].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addVocabulary(vocabulary: String) = apply {
                                this.vocabulary =
                                    (this.vocabulary ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("vocabulary", it).add(vocabulary)
                                    }
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
                             * Returns an immutable instance of [SelectTags].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .instruction()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): SelectTags =
                                SelectTags(
                                    checkRequired("instruction", instruction),
                                    type,
                                    maxSelections,
                                    minSelections,
                                    (vocabulary ?: JsonMissing.of()).map { it.toImmutable() },
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): SelectTags = apply {
                            if (validated) {
                                return@apply
                            }

                            instruction()
                            _type().let {
                                if (it != JsonValue.from("select_tags")) {
                                    throw ImageKitInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            maxSelections()
                            minSelections()
                            vocabulary()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (instruction.asKnown().isPresent) 1 else 0) +
                                type.let { if (it == JsonValue.from("select_tags")) 1 else 0 } +
                                (if (maxSelections.asKnown().isPresent) 1 else 0) +
                                (if (minSelections.asKnown().isPresent) 1 else 0) +
                                (vocabulary.asKnown().getOrNull()?.size ?: 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is SelectTags &&
                                instruction == other.instruction &&
                                type == other.type &&
                                maxSelections == other.maxSelections &&
                                minSelections == other.minSelections &&
                                vocabulary == other.vocabulary &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                instruction,
                                type,
                                maxSelections,
                                minSelections,
                                vocabulary,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "SelectTags{instruction=$instruction, type=$type, maxSelections=$maxSelections, minSelections=$minSelections, vocabulary=$vocabulary, additionalProperties=$additionalProperties}"
                    }

                    class SelectMetadata
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val field: JsonField<String>,
                        private val instruction: JsonField<String>,
                        private val type: JsonValue,
                        private val maxSelections: JsonField<Long>,
                        private val minSelections: JsonField<Long>,
                        private val vocabulary: JsonField<List<Vocabulary>>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("field")
                            @ExcludeMissing
                            field: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("instruction")
                            @ExcludeMissing
                            instruction: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonValue = JsonMissing.of(),
                            @JsonProperty("max_selections")
                            @ExcludeMissing
                            maxSelections: JsonField<Long> = JsonMissing.of(),
                            @JsonProperty("min_selections")
                            @ExcludeMissing
                            minSelections: JsonField<Long> = JsonMissing.of(),
                            @JsonProperty("vocabulary")
                            @ExcludeMissing
                            vocabulary: JsonField<List<Vocabulary>> = JsonMissing.of(),
                        ) : this(
                            field,
                            instruction,
                            type,
                            maxSelections,
                            minSelections,
                            vocabulary,
                            mutableMapOf(),
                        )

                        /**
                         * Name of the custom metadata field to set. The field must exist in your
                         * account.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun field(): String = field.getRequired("field")

                        /**
                         * The question or instruction for the AI to analyze the image.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun instruction(): String = instruction.getRequired("instruction")

                        /**
                         * Task type that analyzes the image and sets a custom metadata field value
                         * from a vocabulary.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("select_metadata")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Maximum number of values to select from the vocabulary.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun maxSelections(): Optional<Long> =
                            maxSelections.getOptional("max_selections")

                        /**
                         * Minimum number of values to select from the vocabulary.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun minSelections(): Optional<Long> =
                            minSelections.getOptional("min_selections")

                        /**
                         * An array of possible values matching the custom metadata field type. If
                         * not provided for SingleSelect or MultiSelect field types, all values from
                         * the custom metadata field definition will be used. When providing large
                         * vocabularies (above 30 items), the AI may not strictly adhere to the
                         * list.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun vocabulary(): Optional<List<Vocabulary>> =
                            vocabulary.getOptional("vocabulary")

                        /**
                         * Returns the raw JSON value of [field].
                         *
                         * Unlike [field], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("field")
                        @ExcludeMissing
                        fun _field(): JsonField<String> = field

                        /**
                         * Returns the raw JSON value of [instruction].
                         *
                         * Unlike [instruction], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("instruction")
                        @ExcludeMissing
                        fun _instruction(): JsonField<String> = instruction

                        /**
                         * Returns the raw JSON value of [maxSelections].
                         *
                         * Unlike [maxSelections], this method doesn't throw if the JSON field has
                         * an unexpected type.
                         */
                        @JsonProperty("max_selections")
                        @ExcludeMissing
                        fun _maxSelections(): JsonField<Long> = maxSelections

                        /**
                         * Returns the raw JSON value of [minSelections].
                         *
                         * Unlike [minSelections], this method doesn't throw if the JSON field has
                         * an unexpected type.
                         */
                        @JsonProperty("min_selections")
                        @ExcludeMissing
                        fun _minSelections(): JsonField<Long> = minSelections

                        /**
                         * Returns the raw JSON value of [vocabulary].
                         *
                         * Unlike [vocabulary], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("vocabulary")
                        @ExcludeMissing
                        fun _vocabulary(): JsonField<List<Vocabulary>> = vocabulary

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
                             * [SelectMetadata].
                             *
                             * The following fields are required:
                             * ```java
                             * .field()
                             * .instruction()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [SelectMetadata]. */
                        class Builder internal constructor() {

                            private var field: JsonField<String>? = null
                            private var instruction: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("select_metadata")
                            private var maxSelections: JsonField<Long> = JsonMissing.of()
                            private var minSelections: JsonField<Long> = JsonMissing.of()
                            private var vocabulary: JsonField<MutableList<Vocabulary>>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(selectMetadata: SelectMetadata) = apply {
                                field = selectMetadata.field
                                instruction = selectMetadata.instruction
                                type = selectMetadata.type
                                maxSelections = selectMetadata.maxSelections
                                minSelections = selectMetadata.minSelections
                                vocabulary = selectMetadata.vocabulary.map { it.toMutableList() }
                                additionalProperties =
                                    selectMetadata.additionalProperties.toMutableMap()
                            }

                            /**
                             * Name of the custom metadata field to set. The field must exist in
                             * your account.
                             */
                            fun field(field: String) = field(JsonField.of(field))

                            /**
                             * Sets [Builder.field] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.field] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun field(field: JsonField<String>) = apply { this.field = field }

                            /** The question or instruction for the AI to analyze the image. */
                            fun instruction(instruction: String) =
                                instruction(JsonField.of(instruction))

                            /**
                             * Sets [Builder.instruction] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.instruction] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun instruction(instruction: JsonField<String>) = apply {
                                this.instruction = instruction
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("select_metadata")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            /** Maximum number of values to select from the vocabulary. */
                            fun maxSelections(maxSelections: Long) =
                                maxSelections(JsonField.of(maxSelections))

                            /**
                             * Sets [Builder.maxSelections] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.maxSelections] with a well-typed
                             * [Long] value instead. This method is primarily for setting the field
                             * to an undocumented or not yet supported value.
                             */
                            fun maxSelections(maxSelections: JsonField<Long>) = apply {
                                this.maxSelections = maxSelections
                            }

                            /** Minimum number of values to select from the vocabulary. */
                            fun minSelections(minSelections: Long) =
                                minSelections(JsonField.of(minSelections))

                            /**
                             * Sets [Builder.minSelections] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.minSelections] with a well-typed
                             * [Long] value instead. This method is primarily for setting the field
                             * to an undocumented or not yet supported value.
                             */
                            fun minSelections(minSelections: JsonField<Long>) = apply {
                                this.minSelections = minSelections
                            }

                            /**
                             * An array of possible values matching the custom metadata field type.
                             * If not provided for SingleSelect or MultiSelect field types, all
                             * values from the custom metadata field definition will be used. When
                             * providing large vocabularies (above 30 items), the AI may not
                             * strictly adhere to the list.
                             */
                            fun vocabulary(vocabulary: List<Vocabulary>) =
                                vocabulary(JsonField.of(vocabulary))

                            /**
                             * Sets [Builder.vocabulary] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.vocabulary] with a well-typed
                             * `List<Vocabulary>` value instead. This method is primarily for
                             * setting the field to an undocumented or not yet supported value.
                             */
                            fun vocabulary(vocabulary: JsonField<List<Vocabulary>>) = apply {
                                this.vocabulary = vocabulary.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [Vocabulary] to [Builder.vocabulary].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addVocabulary(vocabulary: Vocabulary) = apply {
                                this.vocabulary =
                                    (this.vocabulary ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("vocabulary", it).add(vocabulary)
                                    }
                            }

                            /**
                             * Alias for calling [addVocabulary] with `Vocabulary.ofString(string)`.
                             */
                            fun addVocabulary(string: String) =
                                addVocabulary(Vocabulary.ofString(string))

                            /**
                             * Alias for calling [addVocabulary] with `Vocabulary.ofNumber(number)`.
                             */
                            fun addVocabulary(number: Double) =
                                addVocabulary(Vocabulary.ofNumber(number))

                            /** Alias for calling [addVocabulary] with `Vocabulary.ofBool(bool)`. */
                            fun addVocabulary(bool: Boolean) =
                                addVocabulary(Vocabulary.ofBool(bool))

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
                             * Returns an immutable instance of [SelectMetadata].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .field()
                             * .instruction()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): SelectMetadata =
                                SelectMetadata(
                                    checkRequired("field", field),
                                    checkRequired("instruction", instruction),
                                    type,
                                    maxSelections,
                                    minSelections,
                                    (vocabulary ?: JsonMissing.of()).map { it.toImmutable() },
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): SelectMetadata = apply {
                            if (validated) {
                                return@apply
                            }

                            field()
                            instruction()
                            _type().let {
                                if (it != JsonValue.from("select_metadata")) {
                                    throw ImageKitInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            maxSelections()
                            minSelections()
                            vocabulary().ifPresent { it.forEach { it.validate() } }
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (field.asKnown().isPresent) 1 else 0) +
                                (if (instruction.asKnown().isPresent) 1 else 0) +
                                type.let { if (it == JsonValue.from("select_metadata")) 1 else 0 } +
                                (if (maxSelections.asKnown().isPresent) 1 else 0) +
                                (if (minSelections.asKnown().isPresent) 1 else 0) +
                                (vocabulary.asKnown().getOrNull()?.sumOf { it.validity().toInt() }
                                    ?: 0)

                        @JsonDeserialize(using = Vocabulary.Deserializer::class)
                        @JsonSerialize(using = Vocabulary.Serializer::class)
                        class Vocabulary
                        private constructor(
                            private val string: String? = null,
                            private val number: Double? = null,
                            private val bool: Boolean? = null,
                            private val _json: JsonValue? = null,
                        ) {

                            fun string(): Optional<String> = Optional.ofNullable(string)

                            fun number(): Optional<Double> = Optional.ofNullable(number)

                            fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                            fun isString(): Boolean = string != null

                            fun isNumber(): Boolean = number != null

                            fun isBool(): Boolean = bool != null

                            fun asString(): String = string.getOrThrow("string")

                            fun asNumber(): Double = number.getOrThrow("number")

                            fun asBool(): Boolean = bool.getOrThrow("bool")

                            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                            fun <T> accept(visitor: Visitor<T>): T =
                                when {
                                    string != null -> visitor.visitString(string)
                                    number != null -> visitor.visitNumber(number)
                                    bool != null -> visitor.visitBool(bool)
                                    else -> visitor.unknown(_json)
                                }

                            private var validated: Boolean = false

                            fun validate(): Vocabulary = apply {
                                if (validated) {
                                    return@apply
                                }

                                accept(
                                    object : Visitor<Unit> {
                                        override fun visitString(string: String) {}

                                        override fun visitNumber(number: Double) {}

                                        override fun visitBool(bool: Boolean) {}
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                accept(
                                    object : Visitor<Int> {
                                        override fun visitString(string: String) = 1

                                        override fun visitNumber(number: Double) = 1

                                        override fun visitBool(bool: Boolean) = 1

                                        override fun unknown(json: JsonValue?) = 0
                                    }
                                )

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Vocabulary &&
                                    string == other.string &&
                                    number == other.number &&
                                    bool == other.bool
                            }

                            override fun hashCode(): Int = Objects.hash(string, number, bool)

                            override fun toString(): String =
                                when {
                                    string != null -> "Vocabulary{string=$string}"
                                    number != null -> "Vocabulary{number=$number}"
                                    bool != null -> "Vocabulary{bool=$bool}"
                                    _json != null -> "Vocabulary{_unknown=$_json}"
                                    else -> throw IllegalStateException("Invalid Vocabulary")
                                }

                            companion object {

                                @JvmStatic
                                fun ofString(string: String) = Vocabulary(string = string)

                                @JvmStatic
                                fun ofNumber(number: Double) = Vocabulary(number = number)

                                @JvmStatic fun ofBool(bool: Boolean) = Vocabulary(bool = bool)
                            }

                            /**
                             * An interface that defines how to map each variant of [Vocabulary] to
                             * a value of type [T].
                             */
                            interface Visitor<out T> {

                                fun visitString(string: String): T

                                fun visitNumber(number: Double): T

                                fun visitBool(bool: Boolean): T

                                /**
                                 * Maps an unknown variant of [Vocabulary] to a value of type [T].
                                 *
                                 * An instance of [Vocabulary] can contain an unknown variant if it
                                 * was deserialized from data that doesn't match any known variant.
                                 * For example, if the SDK is on an older version than the API, then
                                 * the API may respond with new variants that the SDK is unaware of.
                                 *
                                 * @throws ImageKitInvalidDataException in the default
                                 *   implementation.
                                 */
                                fun unknown(json: JsonValue?): T {
                                    throw ImageKitInvalidDataException("Unknown Vocabulary: $json")
                                }
                            }

                            internal class Deserializer :
                                BaseDeserializer<Vocabulary>(Vocabulary::class) {

                                override fun ObjectCodec.deserialize(node: JsonNode): Vocabulary {
                                    val json = JsonValue.fromJsonNode(node)

                                    val bestMatches =
                                        sequenceOf(
                                                tryDeserialize(node, jacksonTypeRef<String>())
                                                    ?.let { Vocabulary(string = it, _json = json) },
                                                tryDeserialize(node, jacksonTypeRef<Double>())
                                                    ?.let { Vocabulary(number = it, _json = json) },
                                                tryDeserialize(node, jacksonTypeRef<Boolean>())
                                                    ?.let { Vocabulary(bool = it, _json = json) },
                                            )
                                            .filterNotNull()
                                            .allMaxBy { it.validity() }
                                            .toList()
                                    return when (bestMatches.size) {
                                        // This can happen if what we're deserializing is completely
                                        // incompatible with all the possible variants (e.g.
                                        // deserializing from object).
                                        0 -> Vocabulary(_json = json)
                                        1 -> bestMatches.single()
                                        // If there's more than one match with the highest validity,
                                        // then use the first completely valid match, or simply the
                                        // first match if none are completely valid.
                                        else ->
                                            bestMatches.firstOrNull { it.isValid() }
                                                ?: bestMatches.first()
                                    }
                                }
                            }

                            internal class Serializer :
                                BaseSerializer<Vocabulary>(Vocabulary::class) {

                                override fun serialize(
                                    value: Vocabulary,
                                    generator: JsonGenerator,
                                    provider: SerializerProvider,
                                ) {
                                    when {
                                        value.string != null -> generator.writeObject(value.string)
                                        value.number != null -> generator.writeObject(value.number)
                                        value.bool != null -> generator.writeObject(value.bool)
                                        value._json != null -> generator.writeObject(value._json)
                                        else -> throw IllegalStateException("Invalid Vocabulary")
                                    }
                                }
                            }
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is SelectMetadata &&
                                field == other.field &&
                                instruction == other.instruction &&
                                type == other.type &&
                                maxSelections == other.maxSelections &&
                                minSelections == other.minSelections &&
                                vocabulary == other.vocabulary &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                field,
                                instruction,
                                type,
                                maxSelections,
                                minSelections,
                                vocabulary,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "SelectMetadata{field=$field, instruction=$instruction, type=$type, maxSelections=$maxSelections, minSelections=$minSelections, vocabulary=$vocabulary, additionalProperties=$additionalProperties}"
                    }

                    class YesNo
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val instruction: JsonField<String>,
                        private val type: JsonValue,
                        private val onNo: JsonField<OnNo>,
                        private val onUnknown: JsonField<OnUnknown>,
                        private val onYes: JsonField<OnYes>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("instruction")
                            @ExcludeMissing
                            instruction: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonValue = JsonMissing.of(),
                            @JsonProperty("on_no")
                            @ExcludeMissing
                            onNo: JsonField<OnNo> = JsonMissing.of(),
                            @JsonProperty("on_unknown")
                            @ExcludeMissing
                            onUnknown: JsonField<OnUnknown> = JsonMissing.of(),
                            @JsonProperty("on_yes")
                            @ExcludeMissing
                            onYes: JsonField<OnYes> = JsonMissing.of(),
                        ) : this(instruction, type, onNo, onUnknown, onYes, mutableMapOf())

                        /**
                         * The yes/no question for the AI to answer about the image.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun instruction(): String = instruction.getRequired("instruction")

                        /**
                         * Task type that asks a yes/no question and executes actions based on the
                         * answer.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("yes_no")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Actions to execute if the AI answers no.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun onNo(): Optional<OnNo> = onNo.getOptional("on_no")

                        /**
                         * Actions to execute if the AI cannot determine the answer.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun onUnknown(): Optional<OnUnknown> = onUnknown.getOptional("on_unknown")

                        /**
                         * Actions to execute if the AI answers yes.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun onYes(): Optional<OnYes> = onYes.getOptional("on_yes")

                        /**
                         * Returns the raw JSON value of [instruction].
                         *
                         * Unlike [instruction], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("instruction")
                        @ExcludeMissing
                        fun _instruction(): JsonField<String> = instruction

                        /**
                         * Returns the raw JSON value of [onNo].
                         *
                         * Unlike [onNo], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("on_no") @ExcludeMissing fun _onNo(): JsonField<OnNo> = onNo

                        /**
                         * Returns the raw JSON value of [onUnknown].
                         *
                         * Unlike [onUnknown], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("on_unknown")
                        @ExcludeMissing
                        fun _onUnknown(): JsonField<OnUnknown> = onUnknown

                        /**
                         * Returns the raw JSON value of [onYes].
                         *
                         * Unlike [onYes], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("on_yes")
                        @ExcludeMissing
                        fun _onYes(): JsonField<OnYes> = onYes

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
                             * Returns a mutable builder for constructing an instance of [YesNo].
                             *
                             * The following fields are required:
                             * ```java
                             * .instruction()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [YesNo]. */
                        class Builder internal constructor() {

                            private var instruction: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("yes_no")
                            private var onNo: JsonField<OnNo> = JsonMissing.of()
                            private var onUnknown: JsonField<OnUnknown> = JsonMissing.of()
                            private var onYes: JsonField<OnYes> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(yesNo: YesNo) = apply {
                                instruction = yesNo.instruction
                                type = yesNo.type
                                onNo = yesNo.onNo
                                onUnknown = yesNo.onUnknown
                                onYes = yesNo.onYes
                                additionalProperties = yesNo.additionalProperties.toMutableMap()
                            }

                            /** The yes/no question for the AI to answer about the image. */
                            fun instruction(instruction: String) =
                                instruction(JsonField.of(instruction))

                            /**
                             * Sets [Builder.instruction] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.instruction] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun instruction(instruction: JsonField<String>) = apply {
                                this.instruction = instruction
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("yes_no")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            /** Actions to execute if the AI answers no. */
                            fun onNo(onNo: OnNo) = onNo(JsonField.of(onNo))

                            /**
                             * Sets [Builder.onNo] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.onNo] with a well-typed [OnNo] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun onNo(onNo: JsonField<OnNo>) = apply { this.onNo = onNo }

                            /** Actions to execute if the AI cannot determine the answer. */
                            fun onUnknown(onUnknown: OnUnknown) = onUnknown(JsonField.of(onUnknown))

                            /**
                             * Sets [Builder.onUnknown] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.onUnknown] with a well-typed
                             * [OnUnknown] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun onUnknown(onUnknown: JsonField<OnUnknown>) = apply {
                                this.onUnknown = onUnknown
                            }

                            /** Actions to execute if the AI answers yes. */
                            fun onYes(onYes: OnYes) = onYes(JsonField.of(onYes))

                            /**
                             * Sets [Builder.onYes] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.onYes] with a well-typed [OnYes]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun onYes(onYes: JsonField<OnYes>) = apply { this.onYes = onYes }

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
                             * Returns an immutable instance of [YesNo].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .instruction()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): YesNo =
                                YesNo(
                                    checkRequired("instruction", instruction),
                                    type,
                                    onNo,
                                    onUnknown,
                                    onYes,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): YesNo = apply {
                            if (validated) {
                                return@apply
                            }

                            instruction()
                            _type().let {
                                if (it != JsonValue.from("yes_no")) {
                                    throw ImageKitInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            onNo().ifPresent { it.validate() }
                            onUnknown().ifPresent { it.validate() }
                            onYes().ifPresent { it.validate() }
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (instruction.asKnown().isPresent) 1 else 0) +
                                type.let { if (it == JsonValue.from("yes_no")) 1 else 0 } +
                                (onNo.asKnown().getOrNull()?.validity() ?: 0) +
                                (onUnknown.asKnown().getOrNull()?.validity() ?: 0) +
                                (onYes.asKnown().getOrNull()?.validity() ?: 0)

                        /** Actions to execute if the AI answers no. */
                        class OnNo
                        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                        private constructor(
                            private val addTags: JsonField<List<String>>,
                            private val removeTags: JsonField<List<String>>,
                            private val setMetadata: JsonField<List<SetMetadata>>,
                            private val unsetMetadata: JsonField<List<UnsetMetadata>>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("add_tags")
                                @ExcludeMissing
                                addTags: JsonField<List<String>> = JsonMissing.of(),
                                @JsonProperty("remove_tags")
                                @ExcludeMissing
                                removeTags: JsonField<List<String>> = JsonMissing.of(),
                                @JsonProperty("set_metadata")
                                @ExcludeMissing
                                setMetadata: JsonField<List<SetMetadata>> = JsonMissing.of(),
                                @JsonProperty("unset_metadata")
                                @ExcludeMissing
                                unsetMetadata: JsonField<List<UnsetMetadata>> = JsonMissing.of(),
                            ) : this(
                                addTags,
                                removeTags,
                                setMetadata,
                                unsetMetadata,
                                mutableMapOf(),
                            )

                            /**
                             * Array of tag strings to add to the asset.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun addTags(): Optional<List<String>> = addTags.getOptional("add_tags")

                            /**
                             * Array of tag strings to remove from the asset.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun removeTags(): Optional<List<String>> =
                                removeTags.getOptional("remove_tags")

                            /**
                             * Array of custom metadata field updates.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun setMetadata(): Optional<List<SetMetadata>> =
                                setMetadata.getOptional("set_metadata")

                            /**
                             * Array of custom metadata fields to remove.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun unsetMetadata(): Optional<List<UnsetMetadata>> =
                                unsetMetadata.getOptional("unset_metadata")

                            /**
                             * Returns the raw JSON value of [addTags].
                             *
                             * Unlike [addTags], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("add_tags")
                            @ExcludeMissing
                            fun _addTags(): JsonField<List<String>> = addTags

                            /**
                             * Returns the raw JSON value of [removeTags].
                             *
                             * Unlike [removeTags], this method doesn't throw if the JSON field has
                             * an unexpected type.
                             */
                            @JsonProperty("remove_tags")
                            @ExcludeMissing
                            fun _removeTags(): JsonField<List<String>> = removeTags

                            /**
                             * Returns the raw JSON value of [setMetadata].
                             *
                             * Unlike [setMetadata], this method doesn't throw if the JSON field has
                             * an unexpected type.
                             */
                            @JsonProperty("set_metadata")
                            @ExcludeMissing
                            fun _setMetadata(): JsonField<List<SetMetadata>> = setMetadata

                            /**
                             * Returns the raw JSON value of [unsetMetadata].
                             *
                             * Unlike [unsetMetadata], this method doesn't throw if the JSON field
                             * has an unexpected type.
                             */
                            @JsonProperty("unset_metadata")
                            @ExcludeMissing
                            fun _unsetMetadata(): JsonField<List<UnsetMetadata>> = unsetMetadata

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
                                 * Returns a mutable builder for constructing an instance of [OnNo].
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [OnNo]. */
                            class Builder internal constructor() {

                                private var addTags: JsonField<MutableList<String>>? = null
                                private var removeTags: JsonField<MutableList<String>>? = null
                                private var setMetadata: JsonField<MutableList<SetMetadata>>? = null
                                private var unsetMetadata: JsonField<MutableList<UnsetMetadata>>? =
                                    null
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(onNo: OnNo) = apply {
                                    addTags = onNo.addTags.map { it.toMutableList() }
                                    removeTags = onNo.removeTags.map { it.toMutableList() }
                                    setMetadata = onNo.setMetadata.map { it.toMutableList() }
                                    unsetMetadata = onNo.unsetMetadata.map { it.toMutableList() }
                                    additionalProperties = onNo.additionalProperties.toMutableMap()
                                }

                                /** Array of tag strings to add to the asset. */
                                fun addTags(addTags: List<String>) = addTags(JsonField.of(addTags))

                                /**
                                 * Sets [Builder.addTags] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.addTags] with a well-typed
                                 * `List<String>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun addTags(addTags: JsonField<List<String>>) = apply {
                                    this.addTags = addTags.map { it.toMutableList() }
                                }

                                /**
                                 * Adds a single [String] to [addTags].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addAddTag(addTag: String) = apply {
                                    addTags =
                                        (addTags ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("addTags", it).add(addTag)
                                        }
                                }

                                /** Array of tag strings to remove from the asset. */
                                fun removeTags(removeTags: List<String>) =
                                    removeTags(JsonField.of(removeTags))

                                /**
                                 * Sets [Builder.removeTags] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.removeTags] with a well-typed
                                 * `List<String>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun removeTags(removeTags: JsonField<List<String>>) = apply {
                                    this.removeTags = removeTags.map { it.toMutableList() }
                                }

                                /**
                                 * Adds a single [String] to [removeTags].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addRemoveTag(removeTag: String) = apply {
                                    removeTags =
                                        (removeTags ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("removeTags", it).add(removeTag)
                                        }
                                }

                                /** Array of custom metadata field updates. */
                                fun setMetadata(setMetadata: List<SetMetadata>) =
                                    setMetadata(JsonField.of(setMetadata))

                                /**
                                 * Sets [Builder.setMetadata] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.setMetadata] with a well-typed
                                 * `List<SetMetadata>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun setMetadata(setMetadata: JsonField<List<SetMetadata>>) = apply {
                                    this.setMetadata = setMetadata.map { it.toMutableList() }
                                }

                                /**
                                 * Adds a single [SetMetadata] to [Builder.setMetadata].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addSetMetadata(setMetadata: SetMetadata) = apply {
                                    this.setMetadata =
                                        (this.setMetadata ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("setMetadata", it).add(setMetadata)
                                        }
                                }

                                /** Array of custom metadata fields to remove. */
                                fun unsetMetadata(unsetMetadata: List<UnsetMetadata>) =
                                    unsetMetadata(JsonField.of(unsetMetadata))

                                /**
                                 * Sets [Builder.unsetMetadata] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.unsetMetadata] with a well-typed
                                 * `List<UnsetMetadata>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun unsetMetadata(unsetMetadata: JsonField<List<UnsetMetadata>>) =
                                    apply {
                                        this.unsetMetadata =
                                            unsetMetadata.map { it.toMutableList() }
                                    }

                                /**
                                 * Adds a single [UnsetMetadata] to [Builder.unsetMetadata].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addUnsetMetadata(unsetMetadata: UnsetMetadata) = apply {
                                    this.unsetMetadata =
                                        (this.unsetMetadata ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("unsetMetadata", it).add(unsetMetadata)
                                        }
                                }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [OnNo].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 */
                                fun build(): OnNo =
                                    OnNo(
                                        (addTags ?: JsonMissing.of()).map { it.toImmutable() },
                                        (removeTags ?: JsonMissing.of()).map { it.toImmutable() },
                                        (setMetadata ?: JsonMissing.of()).map { it.toImmutable() },
                                        (unsetMetadata ?: JsonMissing.of()).map {
                                            it.toImmutable()
                                        },
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): OnNo = apply {
                                if (validated) {
                                    return@apply
                                }

                                addTags()
                                removeTags()
                                setMetadata().ifPresent { it.forEach { it.validate() } }
                                unsetMetadata().ifPresent { it.forEach { it.validate() } }
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                (addTags.asKnown().getOrNull()?.size ?: 0) +
                                    (removeTags.asKnown().getOrNull()?.size ?: 0) +
                                    (setMetadata.asKnown().getOrNull()?.sumOf {
                                        it.validity().toInt()
                                    } ?: 0) +
                                    (unsetMetadata.asKnown().getOrNull()?.sumOf {
                                        it.validity().toInt()
                                    } ?: 0)

                            class SetMetadata
                            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                            private constructor(
                                private val field: JsonField<String>,
                                private val value: JsonField<Value>,
                                private val additionalProperties: MutableMap<String, JsonValue>,
                            ) {

                                @JsonCreator
                                private constructor(
                                    @JsonProperty("field")
                                    @ExcludeMissing
                                    field: JsonField<String> = JsonMissing.of(),
                                    @JsonProperty("value")
                                    @ExcludeMissing
                                    value: JsonField<Value> = JsonMissing.of(),
                                ) : this(field, value, mutableMapOf())

                                /**
                                 * Name of the custom metadata field to set.
                                 *
                                 * @throws ImageKitInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun field(): String = field.getRequired("field")

                                /**
                                 * Value to set for the custom metadata field. The value type should
                                 * match the custom metadata field type.
                                 *
                                 * @throws ImageKitInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun value(): Value = value.getRequired("value")

                                /**
                                 * Returns the raw JSON value of [field].
                                 *
                                 * Unlike [field], this method doesn't throw if the JSON field has
                                 * an unexpected type.
                                 */
                                @JsonProperty("field")
                                @ExcludeMissing
                                fun _field(): JsonField<String> = field

                                /**
                                 * Returns the raw JSON value of [value].
                                 *
                                 * Unlike [value], this method doesn't throw if the JSON field has
                                 * an unexpected type.
                                 */
                                @JsonProperty("value")
                                @ExcludeMissing
                                fun _value(): JsonField<Value> = value

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
                                     * [SetMetadata].
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * .value()
                                     * ```
                                     */
                                    @JvmStatic fun builder() = Builder()
                                }

                                /** A builder for [SetMetadata]. */
                                class Builder internal constructor() {

                                    private var field: JsonField<String>? = null
                                    private var value: JsonField<Value>? = null
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    @JvmSynthetic
                                    internal fun from(setMetadata: SetMetadata) = apply {
                                        field = setMetadata.field
                                        value = setMetadata.value
                                        additionalProperties =
                                            setMetadata.additionalProperties.toMutableMap()
                                    }

                                    /** Name of the custom metadata field to set. */
                                    fun field(field: String) = field(JsonField.of(field))

                                    /**
                                     * Sets [Builder.field] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.field] with a well-typed
                                     * [String] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun field(field: JsonField<String>) = apply {
                                        this.field = field
                                    }

                                    /**
                                     * Value to set for the custom metadata field. The value type
                                     * should match the custom metadata field type.
                                     */
                                    fun value(value: Value) = value(JsonField.of(value))

                                    /**
                                     * Sets [Builder.value] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.value] with a well-typed
                                     * [Value] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun value(value: JsonField<Value>) = apply {
                                        this.value = value
                                    }

                                    /** Alias for calling [value] with `Value.ofString(string)`. */
                                    fun value(string: String) = value(Value.ofString(string))

                                    /** Alias for calling [value] with `Value.ofNumber(number)`. */
                                    fun value(number: Double) = value(Value.ofNumber(number))

                                    /** Alias for calling [value] with `Value.ofBool(bool)`. */
                                    fun value(bool: Boolean) = value(Value.ofBool(bool))

                                    /** Alias for calling [value] with `Value.ofMixed(mixed)`. */
                                    fun valueOfMixed(
                                        mixed: List<Value.UnnamedSchemaWithArrayParent5>
                                    ) = value(Value.ofMixed(mixed))

                                    fun additionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.clear()
                                        putAllAdditionalProperties(additionalProperties)
                                    }

                                    fun putAdditionalProperty(key: String, value: JsonValue) =
                                        apply {
                                            additionalProperties.put(key, value)
                                        }

                                    fun putAllAdditionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.putAll(additionalProperties)
                                    }

                                    fun removeAdditionalProperty(key: String) = apply {
                                        additionalProperties.remove(key)
                                    }

                                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                        keys.forEach(::removeAdditionalProperty)
                                    }

                                    /**
                                     * Returns an immutable instance of [SetMetadata].
                                     *
                                     * Further updates to this [Builder] will not mutate the
                                     * returned instance.
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * .value()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): SetMetadata =
                                        SetMetadata(
                                            checkRequired("field", field),
                                            checkRequired("value", value),
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): SetMetadata = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    field()
                                    value().validate()
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                @JvmSynthetic
                                internal fun validity(): Int =
                                    (if (field.asKnown().isPresent) 1 else 0) +
                                        (value.asKnown().getOrNull()?.validity() ?: 0)

                                /**
                                 * Value to set for the custom metadata field. The value type should
                                 * match the custom metadata field type.
                                 */
                                @JsonDeserialize(using = Value.Deserializer::class)
                                @JsonSerialize(using = Value.Serializer::class)
                                class Value
                                private constructor(
                                    private val string: String? = null,
                                    private val number: Double? = null,
                                    private val bool: Boolean? = null,
                                    private val mixed: List<UnnamedSchemaWithArrayParent5>? = null,
                                    private val _json: JsonValue? = null,
                                ) {

                                    fun string(): Optional<String> = Optional.ofNullable(string)

                                    fun number(): Optional<Double> = Optional.ofNullable(number)

                                    fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                    fun mixed(): Optional<List<UnnamedSchemaWithArrayParent5>> =
                                        Optional.ofNullable(mixed)

                                    fun isString(): Boolean = string != null

                                    fun isNumber(): Boolean = number != null

                                    fun isBool(): Boolean = bool != null

                                    fun isMixed(): Boolean = mixed != null

                                    fun asString(): String = string.getOrThrow("string")

                                    fun asNumber(): Double = number.getOrThrow("number")

                                    fun asBool(): Boolean = bool.getOrThrow("bool")

                                    fun asMixed(): List<UnnamedSchemaWithArrayParent5> =
                                        mixed.getOrThrow("mixed")

                                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                                    fun <T> accept(visitor: Visitor<T>): T =
                                        when {
                                            string != null -> visitor.visitString(string)
                                            number != null -> visitor.visitNumber(number)
                                            bool != null -> visitor.visitBool(bool)
                                            mixed != null -> visitor.visitMixed(mixed)
                                            else -> visitor.unknown(_json)
                                        }

                                    private var validated: Boolean = false

                                    fun validate(): Value = apply {
                                        if (validated) {
                                            return@apply
                                        }

                                        accept(
                                            object : Visitor<Unit> {
                                                override fun visitString(string: String) {}

                                                override fun visitNumber(number: Double) {}

                                                override fun visitBool(bool: Boolean) {}

                                                override fun visitMixed(
                                                    mixed: List<UnnamedSchemaWithArrayParent5>
                                                ) {
                                                    mixed.forEach { it.validate() }
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
                                     * Returns a score indicating how many valid values are
                                     * contained in this object recursively.
                                     *
                                     * Used for best match union deserialization.
                                     */
                                    @JvmSynthetic
                                    internal fun validity(): Int =
                                        accept(
                                            object : Visitor<Int> {
                                                override fun visitString(string: String) = 1

                                                override fun visitNumber(number: Double) = 1

                                                override fun visitBool(bool: Boolean) = 1

                                                override fun visitMixed(
                                                    mixed: List<UnnamedSchemaWithArrayParent5>
                                                ) = mixed.sumOf { it.validity().toInt() }

                                                override fun unknown(json: JsonValue?) = 0
                                            }
                                        )

                                    override fun equals(other: Any?): Boolean {
                                        if (this === other) {
                                            return true
                                        }

                                        return other is Value &&
                                            string == other.string &&
                                            number == other.number &&
                                            bool == other.bool &&
                                            mixed == other.mixed
                                    }

                                    override fun hashCode(): Int =
                                        Objects.hash(string, number, bool, mixed)

                                    override fun toString(): String =
                                        when {
                                            string != null -> "Value{string=$string}"
                                            number != null -> "Value{number=$number}"
                                            bool != null -> "Value{bool=$bool}"
                                            mixed != null -> "Value{mixed=$mixed}"
                                            _json != null -> "Value{_unknown=$_json}"
                                            else -> throw IllegalStateException("Invalid Value")
                                        }

                                    companion object {

                                        @JvmStatic
                                        fun ofString(string: String) = Value(string = string)

                                        @JvmStatic
                                        fun ofNumber(number: Double) = Value(number = number)

                                        @JvmStatic fun ofBool(bool: Boolean) = Value(bool = bool)

                                        @JvmStatic
                                        fun ofMixed(mixed: List<UnnamedSchemaWithArrayParent5>) =
                                            Value(mixed = mixed.toImmutable())
                                    }

                                    /**
                                     * An interface that defines how to map each variant of [Value]
                                     * to a value of type [T].
                                     */
                                    interface Visitor<out T> {

                                        fun visitString(string: String): T

                                        fun visitNumber(number: Double): T

                                        fun visitBool(bool: Boolean): T

                                        fun visitMixed(
                                            mixed: List<UnnamedSchemaWithArrayParent5>
                                        ): T

                                        /**
                                         * Maps an unknown variant of [Value] to a value of type
                                         * [T].
                                         *
                                         * An instance of [Value] can contain an unknown variant if
                                         * it was deserialized from data that doesn't match any
                                         * known variant. For example, if the SDK is on an older
                                         * version than the API, then the API may respond with new
                                         * variants that the SDK is unaware of.
                                         *
                                         * @throws ImageKitInvalidDataException in the default
                                         *   implementation.
                                         */
                                        fun unknown(json: JsonValue?): T {
                                            throw ImageKitInvalidDataException(
                                                "Unknown Value: $json"
                                            )
                                        }
                                    }

                                    internal class Deserializer :
                                        BaseDeserializer<Value>(Value::class) {

                                        override fun ObjectCodec.deserialize(
                                            node: JsonNode
                                        ): Value {
                                            val json = JsonValue.fromJsonNode(node)

                                            val bestMatches =
                                                sequenceOf(
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<String>(),
                                                            )
                                                            ?.let {
                                                                Value(string = it, _json = json)
                                                            },
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<Double>(),
                                                            )
                                                            ?.let {
                                                                Value(number = it, _json = json)
                                                            },
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<Boolean>(),
                                                            )
                                                            ?.let {
                                                                Value(bool = it, _json = json)
                                                            },
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<
                                                                    List<
                                                                        UnnamedSchemaWithArrayParent5
                                                                    >
                                                                >(),
                                                            )
                                                            ?.let {
                                                                Value(mixed = it, _json = json)
                                                            },
                                                    )
                                                    .filterNotNull()
                                                    .allMaxBy { it.validity() }
                                                    .toList()
                                            return when (bestMatches.size) {
                                                // This can happen if what we're deserializing is
                                                // completely incompatible with all the possible
                                                // variants (e.g. deserializing from object).
                                                0 -> Value(_json = json)
                                                1 -> bestMatches.single()
                                                // If there's more than one match with the highest
                                                // validity, then use the first completely valid
                                                // match, or simply the first match if none are
                                                // completely valid.
                                                else ->
                                                    bestMatches.firstOrNull { it.isValid() }
                                                        ?: bestMatches.first()
                                            }
                                        }
                                    }

                                    internal class Serializer :
                                        BaseSerializer<Value>(Value::class) {

                                        override fun serialize(
                                            value: Value,
                                            generator: JsonGenerator,
                                            provider: SerializerProvider,
                                        ) {
                                            when {
                                                value.string != null ->
                                                    generator.writeObject(value.string)
                                                value.number != null ->
                                                    generator.writeObject(value.number)
                                                value.bool != null ->
                                                    generator.writeObject(value.bool)
                                                value.mixed != null ->
                                                    generator.writeObject(value.mixed)
                                                value._json != null ->
                                                    generator.writeObject(value._json)
                                                else -> throw IllegalStateException("Invalid Value")
                                            }
                                        }
                                    }

                                    @JsonDeserialize(
                                        using = UnnamedSchemaWithArrayParent5.Deserializer::class
                                    )
                                    @JsonSerialize(
                                        using = UnnamedSchemaWithArrayParent5.Serializer::class
                                    )
                                    class UnnamedSchemaWithArrayParent5
                                    private constructor(
                                        private val string: String? = null,
                                        private val number: Double? = null,
                                        private val bool: Boolean? = null,
                                        private val _json: JsonValue? = null,
                                    ) {

                                        fun string(): Optional<String> = Optional.ofNullable(string)

                                        fun number(): Optional<Double> = Optional.ofNullable(number)

                                        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                        fun isString(): Boolean = string != null

                                        fun isNumber(): Boolean = number != null

                                        fun isBool(): Boolean = bool != null

                                        fun asString(): String = string.getOrThrow("string")

                                        fun asNumber(): Double = number.getOrThrow("number")

                                        fun asBool(): Boolean = bool.getOrThrow("bool")

                                        fun _json(): Optional<JsonValue> =
                                            Optional.ofNullable(_json)

                                        fun <T> accept(visitor: Visitor<T>): T =
                                            when {
                                                string != null -> visitor.visitString(string)
                                                number != null -> visitor.visitNumber(number)
                                                bool != null -> visitor.visitBool(bool)
                                                else -> visitor.unknown(_json)
                                            }

                                        private var validated: Boolean = false

                                        fun validate(): UnnamedSchemaWithArrayParent5 = apply {
                                            if (validated) {
                                                return@apply
                                            }

                                            accept(
                                                object : Visitor<Unit> {
                                                    override fun visitString(string: String) {}

                                                    override fun visitNumber(number: Double) {}

                                                    override fun visitBool(bool: Boolean) {}
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
                                         * Returns a score indicating how many valid values are
                                         * contained in this object recursively.
                                         *
                                         * Used for best match union deserialization.
                                         */
                                        @JvmSynthetic
                                        internal fun validity(): Int =
                                            accept(
                                                object : Visitor<Int> {
                                                    override fun visitString(string: String) = 1

                                                    override fun visitNumber(number: Double) = 1

                                                    override fun visitBool(bool: Boolean) = 1

                                                    override fun unknown(json: JsonValue?) = 0
                                                }
                                            )

                                        override fun equals(other: Any?): Boolean {
                                            if (this === other) {
                                                return true
                                            }

                                            return other is UnnamedSchemaWithArrayParent5 &&
                                                string == other.string &&
                                                number == other.number &&
                                                bool == other.bool
                                        }

                                        override fun hashCode(): Int =
                                            Objects.hash(string, number, bool)

                                        override fun toString(): String =
                                            when {
                                                string != null ->
                                                    "UnnamedSchemaWithArrayParent5{string=$string}"
                                                number != null ->
                                                    "UnnamedSchemaWithArrayParent5{number=$number}"
                                                bool != null ->
                                                    "UnnamedSchemaWithArrayParent5{bool=$bool}"
                                                _json != null ->
                                                    "UnnamedSchemaWithArrayParent5{_unknown=$_json}"
                                                else ->
                                                    throw IllegalStateException(
                                                        "Invalid UnnamedSchemaWithArrayParent5"
                                                    )
                                            }

                                        companion object {

                                            @JvmStatic
                                            fun ofString(string: String) =
                                                UnnamedSchemaWithArrayParent5(string = string)

                                            @JvmStatic
                                            fun ofNumber(number: Double) =
                                                UnnamedSchemaWithArrayParent5(number = number)

                                            @JvmStatic
                                            fun ofBool(bool: Boolean) =
                                                UnnamedSchemaWithArrayParent5(bool = bool)
                                        }

                                        /**
                                         * An interface that defines how to map each variant of
                                         * [UnnamedSchemaWithArrayParent5] to a value of type [T].
                                         */
                                        interface Visitor<out T> {

                                            fun visitString(string: String): T

                                            fun visitNumber(number: Double): T

                                            fun visitBool(bool: Boolean): T

                                            /**
                                             * Maps an unknown variant of
                                             * [UnnamedSchemaWithArrayParent5] to a value of type
                                             * [T].
                                             *
                                             * An instance of [UnnamedSchemaWithArrayParent5] can
                                             * contain an unknown variant if it was deserialized
                                             * from data that doesn't match any known variant. For
                                             * example, if the SDK is on an older version than the
                                             * API, then the API may respond with new variants that
                                             * the SDK is unaware of.
                                             *
                                             * @throws ImageKitInvalidDataException in the default
                                             *   implementation.
                                             */
                                            fun unknown(json: JsonValue?): T {
                                                throw ImageKitInvalidDataException(
                                                    "Unknown UnnamedSchemaWithArrayParent5: $json"
                                                )
                                            }
                                        }

                                        internal class Deserializer :
                                            BaseDeserializer<UnnamedSchemaWithArrayParent5>(
                                                UnnamedSchemaWithArrayParent5::class
                                            ) {

                                            override fun ObjectCodec.deserialize(
                                                node: JsonNode
                                            ): UnnamedSchemaWithArrayParent5 {
                                                val json = JsonValue.fromJsonNode(node)

                                                val bestMatches =
                                                    sequenceOf(
                                                            tryDeserialize(
                                                                    node,
                                                                    jacksonTypeRef<String>(),
                                                                )
                                                                ?.let {
                                                                    UnnamedSchemaWithArrayParent5(
                                                                        string = it,
                                                                        _json = json,
                                                                    )
                                                                },
                                                            tryDeserialize(
                                                                    node,
                                                                    jacksonTypeRef<Double>(),
                                                                )
                                                                ?.let {
                                                                    UnnamedSchemaWithArrayParent5(
                                                                        number = it,
                                                                        _json = json,
                                                                    )
                                                                },
                                                            tryDeserialize(
                                                                    node,
                                                                    jacksonTypeRef<Boolean>(),
                                                                )
                                                                ?.let {
                                                                    UnnamedSchemaWithArrayParent5(
                                                                        bool = it,
                                                                        _json = json,
                                                                    )
                                                                },
                                                        )
                                                        .filterNotNull()
                                                        .allMaxBy { it.validity() }
                                                        .toList()
                                                return when (bestMatches.size) {
                                                    // This can happen if what we're deserializing
                                                    // is completely incompatible with all the
                                                    // possible variants (e.g. deserializing from
                                                    // object).
                                                    0 -> UnnamedSchemaWithArrayParent5(_json = json)
                                                    1 -> bestMatches.single()
                                                    // If there's more than one match with the
                                                    // highest validity, then use the first
                                                    // completely valid match, or simply the first
                                                    // match if none are completely valid.
                                                    else ->
                                                        bestMatches.firstOrNull { it.isValid() }
                                                            ?: bestMatches.first()
                                                }
                                            }
                                        }

                                        internal class Serializer :
                                            BaseSerializer<UnnamedSchemaWithArrayParent5>(
                                                UnnamedSchemaWithArrayParent5::class
                                            ) {

                                            override fun serialize(
                                                value: UnnamedSchemaWithArrayParent5,
                                                generator: JsonGenerator,
                                                provider: SerializerProvider,
                                            ) {
                                                when {
                                                    value.string != null ->
                                                        generator.writeObject(value.string)
                                                    value.number != null ->
                                                        generator.writeObject(value.number)
                                                    value.bool != null ->
                                                        generator.writeObject(value.bool)
                                                    value._json != null ->
                                                        generator.writeObject(value._json)
                                                    else ->
                                                        throw IllegalStateException(
                                                            "Invalid UnnamedSchemaWithArrayParent5"
                                                        )
                                                }
                                            }
                                        }
                                    }
                                }

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is SetMetadata &&
                                        field == other.field &&
                                        value == other.value &&
                                        additionalProperties == other.additionalProperties
                                }

                                private val hashCode: Int by lazy {
                                    Objects.hash(field, value, additionalProperties)
                                }

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "SetMetadata{field=$field, value=$value, additionalProperties=$additionalProperties}"
                            }

                            class UnsetMetadata
                            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                            private constructor(
                                private val field: JsonField<String>,
                                private val additionalProperties: MutableMap<String, JsonValue>,
                            ) {

                                @JsonCreator
                                private constructor(
                                    @JsonProperty("field")
                                    @ExcludeMissing
                                    field: JsonField<String> = JsonMissing.of()
                                ) : this(field, mutableMapOf())

                                /**
                                 * Name of the custom metadata field to remove.
                                 *
                                 * @throws ImageKitInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun field(): String = field.getRequired("field")

                                /**
                                 * Returns the raw JSON value of [field].
                                 *
                                 * Unlike [field], this method doesn't throw if the JSON field has
                                 * an unexpected type.
                                 */
                                @JsonProperty("field")
                                @ExcludeMissing
                                fun _field(): JsonField<String> = field

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
                                     * [UnsetMetadata].
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * ```
                                     */
                                    @JvmStatic fun builder() = Builder()
                                }

                                /** A builder for [UnsetMetadata]. */
                                class Builder internal constructor() {

                                    private var field: JsonField<String>? = null
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    @JvmSynthetic
                                    internal fun from(unsetMetadata: UnsetMetadata) = apply {
                                        field = unsetMetadata.field
                                        additionalProperties =
                                            unsetMetadata.additionalProperties.toMutableMap()
                                    }

                                    /** Name of the custom metadata field to remove. */
                                    fun field(field: String) = field(JsonField.of(field))

                                    /**
                                     * Sets [Builder.field] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.field] with a well-typed
                                     * [String] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun field(field: JsonField<String>) = apply {
                                        this.field = field
                                    }

                                    fun additionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.clear()
                                        putAllAdditionalProperties(additionalProperties)
                                    }

                                    fun putAdditionalProperty(key: String, value: JsonValue) =
                                        apply {
                                            additionalProperties.put(key, value)
                                        }

                                    fun putAllAdditionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.putAll(additionalProperties)
                                    }

                                    fun removeAdditionalProperty(key: String) = apply {
                                        additionalProperties.remove(key)
                                    }

                                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                        keys.forEach(::removeAdditionalProperty)
                                    }

                                    /**
                                     * Returns an immutable instance of [UnsetMetadata].
                                     *
                                     * Further updates to this [Builder] will not mutate the
                                     * returned instance.
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): UnsetMetadata =
                                        UnsetMetadata(
                                            checkRequired("field", field),
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): UnsetMetadata = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    field()
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                @JvmSynthetic
                                internal fun validity(): Int =
                                    (if (field.asKnown().isPresent) 1 else 0)

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is UnsetMetadata &&
                                        field == other.field &&
                                        additionalProperties == other.additionalProperties
                                }

                                private val hashCode: Int by lazy {
                                    Objects.hash(field, additionalProperties)
                                }

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "UnsetMetadata{field=$field, additionalProperties=$additionalProperties}"
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is OnNo &&
                                    addTags == other.addTags &&
                                    removeTags == other.removeTags &&
                                    setMetadata == other.setMetadata &&
                                    unsetMetadata == other.unsetMetadata &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(
                                    addTags,
                                    removeTags,
                                    setMetadata,
                                    unsetMetadata,
                                    additionalProperties,
                                )
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "OnNo{addTags=$addTags, removeTags=$removeTags, setMetadata=$setMetadata, unsetMetadata=$unsetMetadata, additionalProperties=$additionalProperties}"
                        }

                        /** Actions to execute if the AI cannot determine the answer. */
                        class OnUnknown
                        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                        private constructor(
                            private val addTags: JsonField<List<String>>,
                            private val removeTags: JsonField<List<String>>,
                            private val setMetadata: JsonField<List<SetMetadata>>,
                            private val unsetMetadata: JsonField<List<UnsetMetadata>>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("add_tags")
                                @ExcludeMissing
                                addTags: JsonField<List<String>> = JsonMissing.of(),
                                @JsonProperty("remove_tags")
                                @ExcludeMissing
                                removeTags: JsonField<List<String>> = JsonMissing.of(),
                                @JsonProperty("set_metadata")
                                @ExcludeMissing
                                setMetadata: JsonField<List<SetMetadata>> = JsonMissing.of(),
                                @JsonProperty("unset_metadata")
                                @ExcludeMissing
                                unsetMetadata: JsonField<List<UnsetMetadata>> = JsonMissing.of(),
                            ) : this(
                                addTags,
                                removeTags,
                                setMetadata,
                                unsetMetadata,
                                mutableMapOf(),
                            )

                            /**
                             * Array of tag strings to add to the asset.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun addTags(): Optional<List<String>> = addTags.getOptional("add_tags")

                            /**
                             * Array of tag strings to remove from the asset.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun removeTags(): Optional<List<String>> =
                                removeTags.getOptional("remove_tags")

                            /**
                             * Array of custom metadata field updates.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun setMetadata(): Optional<List<SetMetadata>> =
                                setMetadata.getOptional("set_metadata")

                            /**
                             * Array of custom metadata fields to remove.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun unsetMetadata(): Optional<List<UnsetMetadata>> =
                                unsetMetadata.getOptional("unset_metadata")

                            /**
                             * Returns the raw JSON value of [addTags].
                             *
                             * Unlike [addTags], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("add_tags")
                            @ExcludeMissing
                            fun _addTags(): JsonField<List<String>> = addTags

                            /**
                             * Returns the raw JSON value of [removeTags].
                             *
                             * Unlike [removeTags], this method doesn't throw if the JSON field has
                             * an unexpected type.
                             */
                            @JsonProperty("remove_tags")
                            @ExcludeMissing
                            fun _removeTags(): JsonField<List<String>> = removeTags

                            /**
                             * Returns the raw JSON value of [setMetadata].
                             *
                             * Unlike [setMetadata], this method doesn't throw if the JSON field has
                             * an unexpected type.
                             */
                            @JsonProperty("set_metadata")
                            @ExcludeMissing
                            fun _setMetadata(): JsonField<List<SetMetadata>> = setMetadata

                            /**
                             * Returns the raw JSON value of [unsetMetadata].
                             *
                             * Unlike [unsetMetadata], this method doesn't throw if the JSON field
                             * has an unexpected type.
                             */
                            @JsonProperty("unset_metadata")
                            @ExcludeMissing
                            fun _unsetMetadata(): JsonField<List<UnsetMetadata>> = unsetMetadata

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
                                 * [OnUnknown].
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [OnUnknown]. */
                            class Builder internal constructor() {

                                private var addTags: JsonField<MutableList<String>>? = null
                                private var removeTags: JsonField<MutableList<String>>? = null
                                private var setMetadata: JsonField<MutableList<SetMetadata>>? = null
                                private var unsetMetadata: JsonField<MutableList<UnsetMetadata>>? =
                                    null
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(onUnknown: OnUnknown) = apply {
                                    addTags = onUnknown.addTags.map { it.toMutableList() }
                                    removeTags = onUnknown.removeTags.map { it.toMutableList() }
                                    setMetadata = onUnknown.setMetadata.map { it.toMutableList() }
                                    unsetMetadata =
                                        onUnknown.unsetMetadata.map { it.toMutableList() }
                                    additionalProperties =
                                        onUnknown.additionalProperties.toMutableMap()
                                }

                                /** Array of tag strings to add to the asset. */
                                fun addTags(addTags: List<String>) = addTags(JsonField.of(addTags))

                                /**
                                 * Sets [Builder.addTags] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.addTags] with a well-typed
                                 * `List<String>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun addTags(addTags: JsonField<List<String>>) = apply {
                                    this.addTags = addTags.map { it.toMutableList() }
                                }

                                /**
                                 * Adds a single [String] to [addTags].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addAddTag(addTag: String) = apply {
                                    addTags =
                                        (addTags ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("addTags", it).add(addTag)
                                        }
                                }

                                /** Array of tag strings to remove from the asset. */
                                fun removeTags(removeTags: List<String>) =
                                    removeTags(JsonField.of(removeTags))

                                /**
                                 * Sets [Builder.removeTags] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.removeTags] with a well-typed
                                 * `List<String>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun removeTags(removeTags: JsonField<List<String>>) = apply {
                                    this.removeTags = removeTags.map { it.toMutableList() }
                                }

                                /**
                                 * Adds a single [String] to [removeTags].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addRemoveTag(removeTag: String) = apply {
                                    removeTags =
                                        (removeTags ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("removeTags", it).add(removeTag)
                                        }
                                }

                                /** Array of custom metadata field updates. */
                                fun setMetadata(setMetadata: List<SetMetadata>) =
                                    setMetadata(JsonField.of(setMetadata))

                                /**
                                 * Sets [Builder.setMetadata] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.setMetadata] with a well-typed
                                 * `List<SetMetadata>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun setMetadata(setMetadata: JsonField<List<SetMetadata>>) = apply {
                                    this.setMetadata = setMetadata.map { it.toMutableList() }
                                }

                                /**
                                 * Adds a single [SetMetadata] to [Builder.setMetadata].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addSetMetadata(setMetadata: SetMetadata) = apply {
                                    this.setMetadata =
                                        (this.setMetadata ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("setMetadata", it).add(setMetadata)
                                        }
                                }

                                /** Array of custom metadata fields to remove. */
                                fun unsetMetadata(unsetMetadata: List<UnsetMetadata>) =
                                    unsetMetadata(JsonField.of(unsetMetadata))

                                /**
                                 * Sets [Builder.unsetMetadata] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.unsetMetadata] with a well-typed
                                 * `List<UnsetMetadata>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun unsetMetadata(unsetMetadata: JsonField<List<UnsetMetadata>>) =
                                    apply {
                                        this.unsetMetadata =
                                            unsetMetadata.map { it.toMutableList() }
                                    }

                                /**
                                 * Adds a single [UnsetMetadata] to [Builder.unsetMetadata].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addUnsetMetadata(unsetMetadata: UnsetMetadata) = apply {
                                    this.unsetMetadata =
                                        (this.unsetMetadata ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("unsetMetadata", it).add(unsetMetadata)
                                        }
                                }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [OnUnknown].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 */
                                fun build(): OnUnknown =
                                    OnUnknown(
                                        (addTags ?: JsonMissing.of()).map { it.toImmutable() },
                                        (removeTags ?: JsonMissing.of()).map { it.toImmutable() },
                                        (setMetadata ?: JsonMissing.of()).map { it.toImmutable() },
                                        (unsetMetadata ?: JsonMissing.of()).map {
                                            it.toImmutable()
                                        },
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): OnUnknown = apply {
                                if (validated) {
                                    return@apply
                                }

                                addTags()
                                removeTags()
                                setMetadata().ifPresent { it.forEach { it.validate() } }
                                unsetMetadata().ifPresent { it.forEach { it.validate() } }
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                (addTags.asKnown().getOrNull()?.size ?: 0) +
                                    (removeTags.asKnown().getOrNull()?.size ?: 0) +
                                    (setMetadata.asKnown().getOrNull()?.sumOf {
                                        it.validity().toInt()
                                    } ?: 0) +
                                    (unsetMetadata.asKnown().getOrNull()?.sumOf {
                                        it.validity().toInt()
                                    } ?: 0)

                            class SetMetadata
                            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                            private constructor(
                                private val field: JsonField<String>,
                                private val value: JsonField<Value>,
                                private val additionalProperties: MutableMap<String, JsonValue>,
                            ) {

                                @JsonCreator
                                private constructor(
                                    @JsonProperty("field")
                                    @ExcludeMissing
                                    field: JsonField<String> = JsonMissing.of(),
                                    @JsonProperty("value")
                                    @ExcludeMissing
                                    value: JsonField<Value> = JsonMissing.of(),
                                ) : this(field, value, mutableMapOf())

                                /**
                                 * Name of the custom metadata field to set.
                                 *
                                 * @throws ImageKitInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun field(): String = field.getRequired("field")

                                /**
                                 * Value to set for the custom metadata field. The value type should
                                 * match the custom metadata field type.
                                 *
                                 * @throws ImageKitInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun value(): Value = value.getRequired("value")

                                /**
                                 * Returns the raw JSON value of [field].
                                 *
                                 * Unlike [field], this method doesn't throw if the JSON field has
                                 * an unexpected type.
                                 */
                                @JsonProperty("field")
                                @ExcludeMissing
                                fun _field(): JsonField<String> = field

                                /**
                                 * Returns the raw JSON value of [value].
                                 *
                                 * Unlike [value], this method doesn't throw if the JSON field has
                                 * an unexpected type.
                                 */
                                @JsonProperty("value")
                                @ExcludeMissing
                                fun _value(): JsonField<Value> = value

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
                                     * [SetMetadata].
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * .value()
                                     * ```
                                     */
                                    @JvmStatic fun builder() = Builder()
                                }

                                /** A builder for [SetMetadata]. */
                                class Builder internal constructor() {

                                    private var field: JsonField<String>? = null
                                    private var value: JsonField<Value>? = null
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    @JvmSynthetic
                                    internal fun from(setMetadata: SetMetadata) = apply {
                                        field = setMetadata.field
                                        value = setMetadata.value
                                        additionalProperties =
                                            setMetadata.additionalProperties.toMutableMap()
                                    }

                                    /** Name of the custom metadata field to set. */
                                    fun field(field: String) = field(JsonField.of(field))

                                    /**
                                     * Sets [Builder.field] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.field] with a well-typed
                                     * [String] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun field(field: JsonField<String>) = apply {
                                        this.field = field
                                    }

                                    /**
                                     * Value to set for the custom metadata field. The value type
                                     * should match the custom metadata field type.
                                     */
                                    fun value(value: Value) = value(JsonField.of(value))

                                    /**
                                     * Sets [Builder.value] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.value] with a well-typed
                                     * [Value] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun value(value: JsonField<Value>) = apply {
                                        this.value = value
                                    }

                                    /** Alias for calling [value] with `Value.ofString(string)`. */
                                    fun value(string: String) = value(Value.ofString(string))

                                    /** Alias for calling [value] with `Value.ofNumber(number)`. */
                                    fun value(number: Double) = value(Value.ofNumber(number))

                                    /** Alias for calling [value] with `Value.ofBool(bool)`. */
                                    fun value(bool: Boolean) = value(Value.ofBool(bool))

                                    /** Alias for calling [value] with `Value.ofMixed(mixed)`. */
                                    fun valueOfMixed(
                                        mixed: List<Value.UnnamedSchemaWithArrayParent6>
                                    ) = value(Value.ofMixed(mixed))

                                    fun additionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.clear()
                                        putAllAdditionalProperties(additionalProperties)
                                    }

                                    fun putAdditionalProperty(key: String, value: JsonValue) =
                                        apply {
                                            additionalProperties.put(key, value)
                                        }

                                    fun putAllAdditionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.putAll(additionalProperties)
                                    }

                                    fun removeAdditionalProperty(key: String) = apply {
                                        additionalProperties.remove(key)
                                    }

                                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                        keys.forEach(::removeAdditionalProperty)
                                    }

                                    /**
                                     * Returns an immutable instance of [SetMetadata].
                                     *
                                     * Further updates to this [Builder] will not mutate the
                                     * returned instance.
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * .value()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): SetMetadata =
                                        SetMetadata(
                                            checkRequired("field", field),
                                            checkRequired("value", value),
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): SetMetadata = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    field()
                                    value().validate()
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                @JvmSynthetic
                                internal fun validity(): Int =
                                    (if (field.asKnown().isPresent) 1 else 0) +
                                        (value.asKnown().getOrNull()?.validity() ?: 0)

                                /**
                                 * Value to set for the custom metadata field. The value type should
                                 * match the custom metadata field type.
                                 */
                                @JsonDeserialize(using = Value.Deserializer::class)
                                @JsonSerialize(using = Value.Serializer::class)
                                class Value
                                private constructor(
                                    private val string: String? = null,
                                    private val number: Double? = null,
                                    private val bool: Boolean? = null,
                                    private val mixed: List<UnnamedSchemaWithArrayParent6>? = null,
                                    private val _json: JsonValue? = null,
                                ) {

                                    fun string(): Optional<String> = Optional.ofNullable(string)

                                    fun number(): Optional<Double> = Optional.ofNullable(number)

                                    fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                    fun mixed(): Optional<List<UnnamedSchemaWithArrayParent6>> =
                                        Optional.ofNullable(mixed)

                                    fun isString(): Boolean = string != null

                                    fun isNumber(): Boolean = number != null

                                    fun isBool(): Boolean = bool != null

                                    fun isMixed(): Boolean = mixed != null

                                    fun asString(): String = string.getOrThrow("string")

                                    fun asNumber(): Double = number.getOrThrow("number")

                                    fun asBool(): Boolean = bool.getOrThrow("bool")

                                    fun asMixed(): List<UnnamedSchemaWithArrayParent6> =
                                        mixed.getOrThrow("mixed")

                                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                                    fun <T> accept(visitor: Visitor<T>): T =
                                        when {
                                            string != null -> visitor.visitString(string)
                                            number != null -> visitor.visitNumber(number)
                                            bool != null -> visitor.visitBool(bool)
                                            mixed != null -> visitor.visitMixed(mixed)
                                            else -> visitor.unknown(_json)
                                        }

                                    private var validated: Boolean = false

                                    fun validate(): Value = apply {
                                        if (validated) {
                                            return@apply
                                        }

                                        accept(
                                            object : Visitor<Unit> {
                                                override fun visitString(string: String) {}

                                                override fun visitNumber(number: Double) {}

                                                override fun visitBool(bool: Boolean) {}

                                                override fun visitMixed(
                                                    mixed: List<UnnamedSchemaWithArrayParent6>
                                                ) {
                                                    mixed.forEach { it.validate() }
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
                                     * Returns a score indicating how many valid values are
                                     * contained in this object recursively.
                                     *
                                     * Used for best match union deserialization.
                                     */
                                    @JvmSynthetic
                                    internal fun validity(): Int =
                                        accept(
                                            object : Visitor<Int> {
                                                override fun visitString(string: String) = 1

                                                override fun visitNumber(number: Double) = 1

                                                override fun visitBool(bool: Boolean) = 1

                                                override fun visitMixed(
                                                    mixed: List<UnnamedSchemaWithArrayParent6>
                                                ) = mixed.sumOf { it.validity().toInt() }

                                                override fun unknown(json: JsonValue?) = 0
                                            }
                                        )

                                    override fun equals(other: Any?): Boolean {
                                        if (this === other) {
                                            return true
                                        }

                                        return other is Value &&
                                            string == other.string &&
                                            number == other.number &&
                                            bool == other.bool &&
                                            mixed == other.mixed
                                    }

                                    override fun hashCode(): Int =
                                        Objects.hash(string, number, bool, mixed)

                                    override fun toString(): String =
                                        when {
                                            string != null -> "Value{string=$string}"
                                            number != null -> "Value{number=$number}"
                                            bool != null -> "Value{bool=$bool}"
                                            mixed != null -> "Value{mixed=$mixed}"
                                            _json != null -> "Value{_unknown=$_json}"
                                            else -> throw IllegalStateException("Invalid Value")
                                        }

                                    companion object {

                                        @JvmStatic
                                        fun ofString(string: String) = Value(string = string)

                                        @JvmStatic
                                        fun ofNumber(number: Double) = Value(number = number)

                                        @JvmStatic fun ofBool(bool: Boolean) = Value(bool = bool)

                                        @JvmStatic
                                        fun ofMixed(mixed: List<UnnamedSchemaWithArrayParent6>) =
                                            Value(mixed = mixed.toImmutable())
                                    }

                                    /**
                                     * An interface that defines how to map each variant of [Value]
                                     * to a value of type [T].
                                     */
                                    interface Visitor<out T> {

                                        fun visitString(string: String): T

                                        fun visitNumber(number: Double): T

                                        fun visitBool(bool: Boolean): T

                                        fun visitMixed(
                                            mixed: List<UnnamedSchemaWithArrayParent6>
                                        ): T

                                        /**
                                         * Maps an unknown variant of [Value] to a value of type
                                         * [T].
                                         *
                                         * An instance of [Value] can contain an unknown variant if
                                         * it was deserialized from data that doesn't match any
                                         * known variant. For example, if the SDK is on an older
                                         * version than the API, then the API may respond with new
                                         * variants that the SDK is unaware of.
                                         *
                                         * @throws ImageKitInvalidDataException in the default
                                         *   implementation.
                                         */
                                        fun unknown(json: JsonValue?): T {
                                            throw ImageKitInvalidDataException(
                                                "Unknown Value: $json"
                                            )
                                        }
                                    }

                                    internal class Deserializer :
                                        BaseDeserializer<Value>(Value::class) {

                                        override fun ObjectCodec.deserialize(
                                            node: JsonNode
                                        ): Value {
                                            val json = JsonValue.fromJsonNode(node)

                                            val bestMatches =
                                                sequenceOf(
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<String>(),
                                                            )
                                                            ?.let {
                                                                Value(string = it, _json = json)
                                                            },
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<Double>(),
                                                            )
                                                            ?.let {
                                                                Value(number = it, _json = json)
                                                            },
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<Boolean>(),
                                                            )
                                                            ?.let {
                                                                Value(bool = it, _json = json)
                                                            },
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<
                                                                    List<
                                                                        UnnamedSchemaWithArrayParent6
                                                                    >
                                                                >(),
                                                            )
                                                            ?.let {
                                                                Value(mixed = it, _json = json)
                                                            },
                                                    )
                                                    .filterNotNull()
                                                    .allMaxBy { it.validity() }
                                                    .toList()
                                            return when (bestMatches.size) {
                                                // This can happen if what we're deserializing is
                                                // completely incompatible with all the possible
                                                // variants (e.g. deserializing from object).
                                                0 -> Value(_json = json)
                                                1 -> bestMatches.single()
                                                // If there's more than one match with the highest
                                                // validity, then use the first completely valid
                                                // match, or simply the first match if none are
                                                // completely valid.
                                                else ->
                                                    bestMatches.firstOrNull { it.isValid() }
                                                        ?: bestMatches.first()
                                            }
                                        }
                                    }

                                    internal class Serializer :
                                        BaseSerializer<Value>(Value::class) {

                                        override fun serialize(
                                            value: Value,
                                            generator: JsonGenerator,
                                            provider: SerializerProvider,
                                        ) {
                                            when {
                                                value.string != null ->
                                                    generator.writeObject(value.string)
                                                value.number != null ->
                                                    generator.writeObject(value.number)
                                                value.bool != null ->
                                                    generator.writeObject(value.bool)
                                                value.mixed != null ->
                                                    generator.writeObject(value.mixed)
                                                value._json != null ->
                                                    generator.writeObject(value._json)
                                                else -> throw IllegalStateException("Invalid Value")
                                            }
                                        }
                                    }

                                    @JsonDeserialize(
                                        using = UnnamedSchemaWithArrayParent6.Deserializer::class
                                    )
                                    @JsonSerialize(
                                        using = UnnamedSchemaWithArrayParent6.Serializer::class
                                    )
                                    class UnnamedSchemaWithArrayParent6
                                    private constructor(
                                        private val string: String? = null,
                                        private val number: Double? = null,
                                        private val bool: Boolean? = null,
                                        private val _json: JsonValue? = null,
                                    ) {

                                        fun string(): Optional<String> = Optional.ofNullable(string)

                                        fun number(): Optional<Double> = Optional.ofNullable(number)

                                        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                        fun isString(): Boolean = string != null

                                        fun isNumber(): Boolean = number != null

                                        fun isBool(): Boolean = bool != null

                                        fun asString(): String = string.getOrThrow("string")

                                        fun asNumber(): Double = number.getOrThrow("number")

                                        fun asBool(): Boolean = bool.getOrThrow("bool")

                                        fun _json(): Optional<JsonValue> =
                                            Optional.ofNullable(_json)

                                        fun <T> accept(visitor: Visitor<T>): T =
                                            when {
                                                string != null -> visitor.visitString(string)
                                                number != null -> visitor.visitNumber(number)
                                                bool != null -> visitor.visitBool(bool)
                                                else -> visitor.unknown(_json)
                                            }

                                        private var validated: Boolean = false

                                        fun validate(): UnnamedSchemaWithArrayParent6 = apply {
                                            if (validated) {
                                                return@apply
                                            }

                                            accept(
                                                object : Visitor<Unit> {
                                                    override fun visitString(string: String) {}

                                                    override fun visitNumber(number: Double) {}

                                                    override fun visitBool(bool: Boolean) {}
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
                                         * Returns a score indicating how many valid values are
                                         * contained in this object recursively.
                                         *
                                         * Used for best match union deserialization.
                                         */
                                        @JvmSynthetic
                                        internal fun validity(): Int =
                                            accept(
                                                object : Visitor<Int> {
                                                    override fun visitString(string: String) = 1

                                                    override fun visitNumber(number: Double) = 1

                                                    override fun visitBool(bool: Boolean) = 1

                                                    override fun unknown(json: JsonValue?) = 0
                                                }
                                            )

                                        override fun equals(other: Any?): Boolean {
                                            if (this === other) {
                                                return true
                                            }

                                            return other is UnnamedSchemaWithArrayParent6 &&
                                                string == other.string &&
                                                number == other.number &&
                                                bool == other.bool
                                        }

                                        override fun hashCode(): Int =
                                            Objects.hash(string, number, bool)

                                        override fun toString(): String =
                                            when {
                                                string != null ->
                                                    "UnnamedSchemaWithArrayParent6{string=$string}"
                                                number != null ->
                                                    "UnnamedSchemaWithArrayParent6{number=$number}"
                                                bool != null ->
                                                    "UnnamedSchemaWithArrayParent6{bool=$bool}"
                                                _json != null ->
                                                    "UnnamedSchemaWithArrayParent6{_unknown=$_json}"
                                                else ->
                                                    throw IllegalStateException(
                                                        "Invalid UnnamedSchemaWithArrayParent6"
                                                    )
                                            }

                                        companion object {

                                            @JvmStatic
                                            fun ofString(string: String) =
                                                UnnamedSchemaWithArrayParent6(string = string)

                                            @JvmStatic
                                            fun ofNumber(number: Double) =
                                                UnnamedSchemaWithArrayParent6(number = number)

                                            @JvmStatic
                                            fun ofBool(bool: Boolean) =
                                                UnnamedSchemaWithArrayParent6(bool = bool)
                                        }

                                        /**
                                         * An interface that defines how to map each variant of
                                         * [UnnamedSchemaWithArrayParent6] to a value of type [T].
                                         */
                                        interface Visitor<out T> {

                                            fun visitString(string: String): T

                                            fun visitNumber(number: Double): T

                                            fun visitBool(bool: Boolean): T

                                            /**
                                             * Maps an unknown variant of
                                             * [UnnamedSchemaWithArrayParent6] to a value of type
                                             * [T].
                                             *
                                             * An instance of [UnnamedSchemaWithArrayParent6] can
                                             * contain an unknown variant if it was deserialized
                                             * from data that doesn't match any known variant. For
                                             * example, if the SDK is on an older version than the
                                             * API, then the API may respond with new variants that
                                             * the SDK is unaware of.
                                             *
                                             * @throws ImageKitInvalidDataException in the default
                                             *   implementation.
                                             */
                                            fun unknown(json: JsonValue?): T {
                                                throw ImageKitInvalidDataException(
                                                    "Unknown UnnamedSchemaWithArrayParent6: $json"
                                                )
                                            }
                                        }

                                        internal class Deserializer :
                                            BaseDeserializer<UnnamedSchemaWithArrayParent6>(
                                                UnnamedSchemaWithArrayParent6::class
                                            ) {

                                            override fun ObjectCodec.deserialize(
                                                node: JsonNode
                                            ): UnnamedSchemaWithArrayParent6 {
                                                val json = JsonValue.fromJsonNode(node)

                                                val bestMatches =
                                                    sequenceOf(
                                                            tryDeserialize(
                                                                    node,
                                                                    jacksonTypeRef<String>(),
                                                                )
                                                                ?.let {
                                                                    UnnamedSchemaWithArrayParent6(
                                                                        string = it,
                                                                        _json = json,
                                                                    )
                                                                },
                                                            tryDeserialize(
                                                                    node,
                                                                    jacksonTypeRef<Double>(),
                                                                )
                                                                ?.let {
                                                                    UnnamedSchemaWithArrayParent6(
                                                                        number = it,
                                                                        _json = json,
                                                                    )
                                                                },
                                                            tryDeserialize(
                                                                    node,
                                                                    jacksonTypeRef<Boolean>(),
                                                                )
                                                                ?.let {
                                                                    UnnamedSchemaWithArrayParent6(
                                                                        bool = it,
                                                                        _json = json,
                                                                    )
                                                                },
                                                        )
                                                        .filterNotNull()
                                                        .allMaxBy { it.validity() }
                                                        .toList()
                                                return when (bestMatches.size) {
                                                    // This can happen if what we're deserializing
                                                    // is completely incompatible with all the
                                                    // possible variants (e.g. deserializing from
                                                    // object).
                                                    0 -> UnnamedSchemaWithArrayParent6(_json = json)
                                                    1 -> bestMatches.single()
                                                    // If there's more than one match with the
                                                    // highest validity, then use the first
                                                    // completely valid match, or simply the first
                                                    // match if none are completely valid.
                                                    else ->
                                                        bestMatches.firstOrNull { it.isValid() }
                                                            ?: bestMatches.first()
                                                }
                                            }
                                        }

                                        internal class Serializer :
                                            BaseSerializer<UnnamedSchemaWithArrayParent6>(
                                                UnnamedSchemaWithArrayParent6::class
                                            ) {

                                            override fun serialize(
                                                value: UnnamedSchemaWithArrayParent6,
                                                generator: JsonGenerator,
                                                provider: SerializerProvider,
                                            ) {
                                                when {
                                                    value.string != null ->
                                                        generator.writeObject(value.string)
                                                    value.number != null ->
                                                        generator.writeObject(value.number)
                                                    value.bool != null ->
                                                        generator.writeObject(value.bool)
                                                    value._json != null ->
                                                        generator.writeObject(value._json)
                                                    else ->
                                                        throw IllegalStateException(
                                                            "Invalid UnnamedSchemaWithArrayParent6"
                                                        )
                                                }
                                            }
                                        }
                                    }
                                }

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is SetMetadata &&
                                        field == other.field &&
                                        value == other.value &&
                                        additionalProperties == other.additionalProperties
                                }

                                private val hashCode: Int by lazy {
                                    Objects.hash(field, value, additionalProperties)
                                }

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "SetMetadata{field=$field, value=$value, additionalProperties=$additionalProperties}"
                            }

                            class UnsetMetadata
                            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                            private constructor(
                                private val field: JsonField<String>,
                                private val additionalProperties: MutableMap<String, JsonValue>,
                            ) {

                                @JsonCreator
                                private constructor(
                                    @JsonProperty("field")
                                    @ExcludeMissing
                                    field: JsonField<String> = JsonMissing.of()
                                ) : this(field, mutableMapOf())

                                /**
                                 * Name of the custom metadata field to remove.
                                 *
                                 * @throws ImageKitInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun field(): String = field.getRequired("field")

                                /**
                                 * Returns the raw JSON value of [field].
                                 *
                                 * Unlike [field], this method doesn't throw if the JSON field has
                                 * an unexpected type.
                                 */
                                @JsonProperty("field")
                                @ExcludeMissing
                                fun _field(): JsonField<String> = field

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
                                     * [UnsetMetadata].
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * ```
                                     */
                                    @JvmStatic fun builder() = Builder()
                                }

                                /** A builder for [UnsetMetadata]. */
                                class Builder internal constructor() {

                                    private var field: JsonField<String>? = null
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    @JvmSynthetic
                                    internal fun from(unsetMetadata: UnsetMetadata) = apply {
                                        field = unsetMetadata.field
                                        additionalProperties =
                                            unsetMetadata.additionalProperties.toMutableMap()
                                    }

                                    /** Name of the custom metadata field to remove. */
                                    fun field(field: String) = field(JsonField.of(field))

                                    /**
                                     * Sets [Builder.field] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.field] with a well-typed
                                     * [String] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun field(field: JsonField<String>) = apply {
                                        this.field = field
                                    }

                                    fun additionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.clear()
                                        putAllAdditionalProperties(additionalProperties)
                                    }

                                    fun putAdditionalProperty(key: String, value: JsonValue) =
                                        apply {
                                            additionalProperties.put(key, value)
                                        }

                                    fun putAllAdditionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.putAll(additionalProperties)
                                    }

                                    fun removeAdditionalProperty(key: String) = apply {
                                        additionalProperties.remove(key)
                                    }

                                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                        keys.forEach(::removeAdditionalProperty)
                                    }

                                    /**
                                     * Returns an immutable instance of [UnsetMetadata].
                                     *
                                     * Further updates to this [Builder] will not mutate the
                                     * returned instance.
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): UnsetMetadata =
                                        UnsetMetadata(
                                            checkRequired("field", field),
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): UnsetMetadata = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    field()
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                @JvmSynthetic
                                internal fun validity(): Int =
                                    (if (field.asKnown().isPresent) 1 else 0)

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is UnsetMetadata &&
                                        field == other.field &&
                                        additionalProperties == other.additionalProperties
                                }

                                private val hashCode: Int by lazy {
                                    Objects.hash(field, additionalProperties)
                                }

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "UnsetMetadata{field=$field, additionalProperties=$additionalProperties}"
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is OnUnknown &&
                                    addTags == other.addTags &&
                                    removeTags == other.removeTags &&
                                    setMetadata == other.setMetadata &&
                                    unsetMetadata == other.unsetMetadata &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(
                                    addTags,
                                    removeTags,
                                    setMetadata,
                                    unsetMetadata,
                                    additionalProperties,
                                )
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "OnUnknown{addTags=$addTags, removeTags=$removeTags, setMetadata=$setMetadata, unsetMetadata=$unsetMetadata, additionalProperties=$additionalProperties}"
                        }

                        /** Actions to execute if the AI answers yes. */
                        class OnYes
                        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                        private constructor(
                            private val addTags: JsonField<List<String>>,
                            private val removeTags: JsonField<List<String>>,
                            private val setMetadata: JsonField<List<SetMetadata>>,
                            private val unsetMetadata: JsonField<List<UnsetMetadata>>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("add_tags")
                                @ExcludeMissing
                                addTags: JsonField<List<String>> = JsonMissing.of(),
                                @JsonProperty("remove_tags")
                                @ExcludeMissing
                                removeTags: JsonField<List<String>> = JsonMissing.of(),
                                @JsonProperty("set_metadata")
                                @ExcludeMissing
                                setMetadata: JsonField<List<SetMetadata>> = JsonMissing.of(),
                                @JsonProperty("unset_metadata")
                                @ExcludeMissing
                                unsetMetadata: JsonField<List<UnsetMetadata>> = JsonMissing.of(),
                            ) : this(
                                addTags,
                                removeTags,
                                setMetadata,
                                unsetMetadata,
                                mutableMapOf(),
                            )

                            /**
                             * Array of tag strings to add to the asset.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun addTags(): Optional<List<String>> = addTags.getOptional("add_tags")

                            /**
                             * Array of tag strings to remove from the asset.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun removeTags(): Optional<List<String>> =
                                removeTags.getOptional("remove_tags")

                            /**
                             * Array of custom metadata field updates.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun setMetadata(): Optional<List<SetMetadata>> =
                                setMetadata.getOptional("set_metadata")

                            /**
                             * Array of custom metadata fields to remove.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun unsetMetadata(): Optional<List<UnsetMetadata>> =
                                unsetMetadata.getOptional("unset_metadata")

                            /**
                             * Returns the raw JSON value of [addTags].
                             *
                             * Unlike [addTags], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("add_tags")
                            @ExcludeMissing
                            fun _addTags(): JsonField<List<String>> = addTags

                            /**
                             * Returns the raw JSON value of [removeTags].
                             *
                             * Unlike [removeTags], this method doesn't throw if the JSON field has
                             * an unexpected type.
                             */
                            @JsonProperty("remove_tags")
                            @ExcludeMissing
                            fun _removeTags(): JsonField<List<String>> = removeTags

                            /**
                             * Returns the raw JSON value of [setMetadata].
                             *
                             * Unlike [setMetadata], this method doesn't throw if the JSON field has
                             * an unexpected type.
                             */
                            @JsonProperty("set_metadata")
                            @ExcludeMissing
                            fun _setMetadata(): JsonField<List<SetMetadata>> = setMetadata

                            /**
                             * Returns the raw JSON value of [unsetMetadata].
                             *
                             * Unlike [unsetMetadata], this method doesn't throw if the JSON field
                             * has an unexpected type.
                             */
                            @JsonProperty("unset_metadata")
                            @ExcludeMissing
                            fun _unsetMetadata(): JsonField<List<UnsetMetadata>> = unsetMetadata

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
                                 * [OnYes].
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [OnYes]. */
                            class Builder internal constructor() {

                                private var addTags: JsonField<MutableList<String>>? = null
                                private var removeTags: JsonField<MutableList<String>>? = null
                                private var setMetadata: JsonField<MutableList<SetMetadata>>? = null
                                private var unsetMetadata: JsonField<MutableList<UnsetMetadata>>? =
                                    null
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(onYes: OnYes) = apply {
                                    addTags = onYes.addTags.map { it.toMutableList() }
                                    removeTags = onYes.removeTags.map { it.toMutableList() }
                                    setMetadata = onYes.setMetadata.map { it.toMutableList() }
                                    unsetMetadata = onYes.unsetMetadata.map { it.toMutableList() }
                                    additionalProperties = onYes.additionalProperties.toMutableMap()
                                }

                                /** Array of tag strings to add to the asset. */
                                fun addTags(addTags: List<String>) = addTags(JsonField.of(addTags))

                                /**
                                 * Sets [Builder.addTags] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.addTags] with a well-typed
                                 * `List<String>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun addTags(addTags: JsonField<List<String>>) = apply {
                                    this.addTags = addTags.map { it.toMutableList() }
                                }

                                /**
                                 * Adds a single [String] to [addTags].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addAddTag(addTag: String) = apply {
                                    addTags =
                                        (addTags ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("addTags", it).add(addTag)
                                        }
                                }

                                /** Array of tag strings to remove from the asset. */
                                fun removeTags(removeTags: List<String>) =
                                    removeTags(JsonField.of(removeTags))

                                /**
                                 * Sets [Builder.removeTags] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.removeTags] with a well-typed
                                 * `List<String>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun removeTags(removeTags: JsonField<List<String>>) = apply {
                                    this.removeTags = removeTags.map { it.toMutableList() }
                                }

                                /**
                                 * Adds a single [String] to [removeTags].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addRemoveTag(removeTag: String) = apply {
                                    removeTags =
                                        (removeTags ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("removeTags", it).add(removeTag)
                                        }
                                }

                                /** Array of custom metadata field updates. */
                                fun setMetadata(setMetadata: List<SetMetadata>) =
                                    setMetadata(JsonField.of(setMetadata))

                                /**
                                 * Sets [Builder.setMetadata] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.setMetadata] with a well-typed
                                 * `List<SetMetadata>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun setMetadata(setMetadata: JsonField<List<SetMetadata>>) = apply {
                                    this.setMetadata = setMetadata.map { it.toMutableList() }
                                }

                                /**
                                 * Adds a single [SetMetadata] to [Builder.setMetadata].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addSetMetadata(setMetadata: SetMetadata) = apply {
                                    this.setMetadata =
                                        (this.setMetadata ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("setMetadata", it).add(setMetadata)
                                        }
                                }

                                /** Array of custom metadata fields to remove. */
                                fun unsetMetadata(unsetMetadata: List<UnsetMetadata>) =
                                    unsetMetadata(JsonField.of(unsetMetadata))

                                /**
                                 * Sets [Builder.unsetMetadata] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.unsetMetadata] with a well-typed
                                 * `List<UnsetMetadata>` value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun unsetMetadata(unsetMetadata: JsonField<List<UnsetMetadata>>) =
                                    apply {
                                        this.unsetMetadata =
                                            unsetMetadata.map { it.toMutableList() }
                                    }

                                /**
                                 * Adds a single [UnsetMetadata] to [Builder.unsetMetadata].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addUnsetMetadata(unsetMetadata: UnsetMetadata) = apply {
                                    this.unsetMetadata =
                                        (this.unsetMetadata ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("unsetMetadata", it).add(unsetMetadata)
                                        }
                                }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [OnYes].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 */
                                fun build(): OnYes =
                                    OnYes(
                                        (addTags ?: JsonMissing.of()).map { it.toImmutable() },
                                        (removeTags ?: JsonMissing.of()).map { it.toImmutable() },
                                        (setMetadata ?: JsonMissing.of()).map { it.toImmutable() },
                                        (unsetMetadata ?: JsonMissing.of()).map {
                                            it.toImmutable()
                                        },
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): OnYes = apply {
                                if (validated) {
                                    return@apply
                                }

                                addTags()
                                removeTags()
                                setMetadata().ifPresent { it.forEach { it.validate() } }
                                unsetMetadata().ifPresent { it.forEach { it.validate() } }
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                (addTags.asKnown().getOrNull()?.size ?: 0) +
                                    (removeTags.asKnown().getOrNull()?.size ?: 0) +
                                    (setMetadata.asKnown().getOrNull()?.sumOf {
                                        it.validity().toInt()
                                    } ?: 0) +
                                    (unsetMetadata.asKnown().getOrNull()?.sumOf {
                                        it.validity().toInt()
                                    } ?: 0)

                            class SetMetadata
                            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                            private constructor(
                                private val field: JsonField<String>,
                                private val value: JsonField<Value>,
                                private val additionalProperties: MutableMap<String, JsonValue>,
                            ) {

                                @JsonCreator
                                private constructor(
                                    @JsonProperty("field")
                                    @ExcludeMissing
                                    field: JsonField<String> = JsonMissing.of(),
                                    @JsonProperty("value")
                                    @ExcludeMissing
                                    value: JsonField<Value> = JsonMissing.of(),
                                ) : this(field, value, mutableMapOf())

                                /**
                                 * Name of the custom metadata field to set.
                                 *
                                 * @throws ImageKitInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun field(): String = field.getRequired("field")

                                /**
                                 * Value to set for the custom metadata field. The value type should
                                 * match the custom metadata field type.
                                 *
                                 * @throws ImageKitInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun value(): Value = value.getRequired("value")

                                /**
                                 * Returns the raw JSON value of [field].
                                 *
                                 * Unlike [field], this method doesn't throw if the JSON field has
                                 * an unexpected type.
                                 */
                                @JsonProperty("field")
                                @ExcludeMissing
                                fun _field(): JsonField<String> = field

                                /**
                                 * Returns the raw JSON value of [value].
                                 *
                                 * Unlike [value], this method doesn't throw if the JSON field has
                                 * an unexpected type.
                                 */
                                @JsonProperty("value")
                                @ExcludeMissing
                                fun _value(): JsonField<Value> = value

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
                                     * [SetMetadata].
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * .value()
                                     * ```
                                     */
                                    @JvmStatic fun builder() = Builder()
                                }

                                /** A builder for [SetMetadata]. */
                                class Builder internal constructor() {

                                    private var field: JsonField<String>? = null
                                    private var value: JsonField<Value>? = null
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    @JvmSynthetic
                                    internal fun from(setMetadata: SetMetadata) = apply {
                                        field = setMetadata.field
                                        value = setMetadata.value
                                        additionalProperties =
                                            setMetadata.additionalProperties.toMutableMap()
                                    }

                                    /** Name of the custom metadata field to set. */
                                    fun field(field: String) = field(JsonField.of(field))

                                    /**
                                     * Sets [Builder.field] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.field] with a well-typed
                                     * [String] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun field(field: JsonField<String>) = apply {
                                        this.field = field
                                    }

                                    /**
                                     * Value to set for the custom metadata field. The value type
                                     * should match the custom metadata field type.
                                     */
                                    fun value(value: Value) = value(JsonField.of(value))

                                    /**
                                     * Sets [Builder.value] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.value] with a well-typed
                                     * [Value] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun value(value: JsonField<Value>) = apply {
                                        this.value = value
                                    }

                                    /** Alias for calling [value] with `Value.ofString(string)`. */
                                    fun value(string: String) = value(Value.ofString(string))

                                    /** Alias for calling [value] with `Value.ofNumber(number)`. */
                                    fun value(number: Double) = value(Value.ofNumber(number))

                                    /** Alias for calling [value] with `Value.ofBool(bool)`. */
                                    fun value(bool: Boolean) = value(Value.ofBool(bool))

                                    /** Alias for calling [value] with `Value.ofMixed(mixed)`. */
                                    fun valueOfMixed(
                                        mixed: List<Value.UnnamedSchemaWithArrayParent7>
                                    ) = value(Value.ofMixed(mixed))

                                    fun additionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.clear()
                                        putAllAdditionalProperties(additionalProperties)
                                    }

                                    fun putAdditionalProperty(key: String, value: JsonValue) =
                                        apply {
                                            additionalProperties.put(key, value)
                                        }

                                    fun putAllAdditionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.putAll(additionalProperties)
                                    }

                                    fun removeAdditionalProperty(key: String) = apply {
                                        additionalProperties.remove(key)
                                    }

                                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                        keys.forEach(::removeAdditionalProperty)
                                    }

                                    /**
                                     * Returns an immutable instance of [SetMetadata].
                                     *
                                     * Further updates to this [Builder] will not mutate the
                                     * returned instance.
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * .value()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): SetMetadata =
                                        SetMetadata(
                                            checkRequired("field", field),
                                            checkRequired("value", value),
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): SetMetadata = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    field()
                                    value().validate()
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                @JvmSynthetic
                                internal fun validity(): Int =
                                    (if (field.asKnown().isPresent) 1 else 0) +
                                        (value.asKnown().getOrNull()?.validity() ?: 0)

                                /**
                                 * Value to set for the custom metadata field. The value type should
                                 * match the custom metadata field type.
                                 */
                                @JsonDeserialize(using = Value.Deserializer::class)
                                @JsonSerialize(using = Value.Serializer::class)
                                class Value
                                private constructor(
                                    private val string: String? = null,
                                    private val number: Double? = null,
                                    private val bool: Boolean? = null,
                                    private val mixed: List<UnnamedSchemaWithArrayParent7>? = null,
                                    private val _json: JsonValue? = null,
                                ) {

                                    fun string(): Optional<String> = Optional.ofNullable(string)

                                    fun number(): Optional<Double> = Optional.ofNullable(number)

                                    fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                    fun mixed(): Optional<List<UnnamedSchemaWithArrayParent7>> =
                                        Optional.ofNullable(mixed)

                                    fun isString(): Boolean = string != null

                                    fun isNumber(): Boolean = number != null

                                    fun isBool(): Boolean = bool != null

                                    fun isMixed(): Boolean = mixed != null

                                    fun asString(): String = string.getOrThrow("string")

                                    fun asNumber(): Double = number.getOrThrow("number")

                                    fun asBool(): Boolean = bool.getOrThrow("bool")

                                    fun asMixed(): List<UnnamedSchemaWithArrayParent7> =
                                        mixed.getOrThrow("mixed")

                                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                                    fun <T> accept(visitor: Visitor<T>): T =
                                        when {
                                            string != null -> visitor.visitString(string)
                                            number != null -> visitor.visitNumber(number)
                                            bool != null -> visitor.visitBool(bool)
                                            mixed != null -> visitor.visitMixed(mixed)
                                            else -> visitor.unknown(_json)
                                        }

                                    private var validated: Boolean = false

                                    fun validate(): Value = apply {
                                        if (validated) {
                                            return@apply
                                        }

                                        accept(
                                            object : Visitor<Unit> {
                                                override fun visitString(string: String) {}

                                                override fun visitNumber(number: Double) {}

                                                override fun visitBool(bool: Boolean) {}

                                                override fun visitMixed(
                                                    mixed: List<UnnamedSchemaWithArrayParent7>
                                                ) {
                                                    mixed.forEach { it.validate() }
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
                                     * Returns a score indicating how many valid values are
                                     * contained in this object recursively.
                                     *
                                     * Used for best match union deserialization.
                                     */
                                    @JvmSynthetic
                                    internal fun validity(): Int =
                                        accept(
                                            object : Visitor<Int> {
                                                override fun visitString(string: String) = 1

                                                override fun visitNumber(number: Double) = 1

                                                override fun visitBool(bool: Boolean) = 1

                                                override fun visitMixed(
                                                    mixed: List<UnnamedSchemaWithArrayParent7>
                                                ) = mixed.sumOf { it.validity().toInt() }

                                                override fun unknown(json: JsonValue?) = 0
                                            }
                                        )

                                    override fun equals(other: Any?): Boolean {
                                        if (this === other) {
                                            return true
                                        }

                                        return other is Value &&
                                            string == other.string &&
                                            number == other.number &&
                                            bool == other.bool &&
                                            mixed == other.mixed
                                    }

                                    override fun hashCode(): Int =
                                        Objects.hash(string, number, bool, mixed)

                                    override fun toString(): String =
                                        when {
                                            string != null -> "Value{string=$string}"
                                            number != null -> "Value{number=$number}"
                                            bool != null -> "Value{bool=$bool}"
                                            mixed != null -> "Value{mixed=$mixed}"
                                            _json != null -> "Value{_unknown=$_json}"
                                            else -> throw IllegalStateException("Invalid Value")
                                        }

                                    companion object {

                                        @JvmStatic
                                        fun ofString(string: String) = Value(string = string)

                                        @JvmStatic
                                        fun ofNumber(number: Double) = Value(number = number)

                                        @JvmStatic fun ofBool(bool: Boolean) = Value(bool = bool)

                                        @JvmStatic
                                        fun ofMixed(mixed: List<UnnamedSchemaWithArrayParent7>) =
                                            Value(mixed = mixed.toImmutable())
                                    }

                                    /**
                                     * An interface that defines how to map each variant of [Value]
                                     * to a value of type [T].
                                     */
                                    interface Visitor<out T> {

                                        fun visitString(string: String): T

                                        fun visitNumber(number: Double): T

                                        fun visitBool(bool: Boolean): T

                                        fun visitMixed(
                                            mixed: List<UnnamedSchemaWithArrayParent7>
                                        ): T

                                        /**
                                         * Maps an unknown variant of [Value] to a value of type
                                         * [T].
                                         *
                                         * An instance of [Value] can contain an unknown variant if
                                         * it was deserialized from data that doesn't match any
                                         * known variant. For example, if the SDK is on an older
                                         * version than the API, then the API may respond with new
                                         * variants that the SDK is unaware of.
                                         *
                                         * @throws ImageKitInvalidDataException in the default
                                         *   implementation.
                                         */
                                        fun unknown(json: JsonValue?): T {
                                            throw ImageKitInvalidDataException(
                                                "Unknown Value: $json"
                                            )
                                        }
                                    }

                                    internal class Deserializer :
                                        BaseDeserializer<Value>(Value::class) {

                                        override fun ObjectCodec.deserialize(
                                            node: JsonNode
                                        ): Value {
                                            val json = JsonValue.fromJsonNode(node)

                                            val bestMatches =
                                                sequenceOf(
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<String>(),
                                                            )
                                                            ?.let {
                                                                Value(string = it, _json = json)
                                                            },
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<Double>(),
                                                            )
                                                            ?.let {
                                                                Value(number = it, _json = json)
                                                            },
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<Boolean>(),
                                                            )
                                                            ?.let {
                                                                Value(bool = it, _json = json)
                                                            },
                                                        tryDeserialize(
                                                                node,
                                                                jacksonTypeRef<
                                                                    List<
                                                                        UnnamedSchemaWithArrayParent7
                                                                    >
                                                                >(),
                                                            )
                                                            ?.let {
                                                                Value(mixed = it, _json = json)
                                                            },
                                                    )
                                                    .filterNotNull()
                                                    .allMaxBy { it.validity() }
                                                    .toList()
                                            return when (bestMatches.size) {
                                                // This can happen if what we're deserializing is
                                                // completely incompatible with all the possible
                                                // variants (e.g. deserializing from object).
                                                0 -> Value(_json = json)
                                                1 -> bestMatches.single()
                                                // If there's more than one match with the highest
                                                // validity, then use the first completely valid
                                                // match, or simply the first match if none are
                                                // completely valid.
                                                else ->
                                                    bestMatches.firstOrNull { it.isValid() }
                                                        ?: bestMatches.first()
                                            }
                                        }
                                    }

                                    internal class Serializer :
                                        BaseSerializer<Value>(Value::class) {

                                        override fun serialize(
                                            value: Value,
                                            generator: JsonGenerator,
                                            provider: SerializerProvider,
                                        ) {
                                            when {
                                                value.string != null ->
                                                    generator.writeObject(value.string)
                                                value.number != null ->
                                                    generator.writeObject(value.number)
                                                value.bool != null ->
                                                    generator.writeObject(value.bool)
                                                value.mixed != null ->
                                                    generator.writeObject(value.mixed)
                                                value._json != null ->
                                                    generator.writeObject(value._json)
                                                else -> throw IllegalStateException("Invalid Value")
                                            }
                                        }
                                    }

                                    @JsonDeserialize(
                                        using = UnnamedSchemaWithArrayParent7.Deserializer::class
                                    )
                                    @JsonSerialize(
                                        using = UnnamedSchemaWithArrayParent7.Serializer::class
                                    )
                                    class UnnamedSchemaWithArrayParent7
                                    private constructor(
                                        private val string: String? = null,
                                        private val number: Double? = null,
                                        private val bool: Boolean? = null,
                                        private val _json: JsonValue? = null,
                                    ) {

                                        fun string(): Optional<String> = Optional.ofNullable(string)

                                        fun number(): Optional<Double> = Optional.ofNullable(number)

                                        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                        fun isString(): Boolean = string != null

                                        fun isNumber(): Boolean = number != null

                                        fun isBool(): Boolean = bool != null

                                        fun asString(): String = string.getOrThrow("string")

                                        fun asNumber(): Double = number.getOrThrow("number")

                                        fun asBool(): Boolean = bool.getOrThrow("bool")

                                        fun _json(): Optional<JsonValue> =
                                            Optional.ofNullable(_json)

                                        fun <T> accept(visitor: Visitor<T>): T =
                                            when {
                                                string != null -> visitor.visitString(string)
                                                number != null -> visitor.visitNumber(number)
                                                bool != null -> visitor.visitBool(bool)
                                                else -> visitor.unknown(_json)
                                            }

                                        private var validated: Boolean = false

                                        fun validate(): UnnamedSchemaWithArrayParent7 = apply {
                                            if (validated) {
                                                return@apply
                                            }

                                            accept(
                                                object : Visitor<Unit> {
                                                    override fun visitString(string: String) {}

                                                    override fun visitNumber(number: Double) {}

                                                    override fun visitBool(bool: Boolean) {}
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
                                         * Returns a score indicating how many valid values are
                                         * contained in this object recursively.
                                         *
                                         * Used for best match union deserialization.
                                         */
                                        @JvmSynthetic
                                        internal fun validity(): Int =
                                            accept(
                                                object : Visitor<Int> {
                                                    override fun visitString(string: String) = 1

                                                    override fun visitNumber(number: Double) = 1

                                                    override fun visitBool(bool: Boolean) = 1

                                                    override fun unknown(json: JsonValue?) = 0
                                                }
                                            )

                                        override fun equals(other: Any?): Boolean {
                                            if (this === other) {
                                                return true
                                            }

                                            return other is UnnamedSchemaWithArrayParent7 &&
                                                string == other.string &&
                                                number == other.number &&
                                                bool == other.bool
                                        }

                                        override fun hashCode(): Int =
                                            Objects.hash(string, number, bool)

                                        override fun toString(): String =
                                            when {
                                                string != null ->
                                                    "UnnamedSchemaWithArrayParent7{string=$string}"
                                                number != null ->
                                                    "UnnamedSchemaWithArrayParent7{number=$number}"
                                                bool != null ->
                                                    "UnnamedSchemaWithArrayParent7{bool=$bool}"
                                                _json != null ->
                                                    "UnnamedSchemaWithArrayParent7{_unknown=$_json}"
                                                else ->
                                                    throw IllegalStateException(
                                                        "Invalid UnnamedSchemaWithArrayParent7"
                                                    )
                                            }

                                        companion object {

                                            @JvmStatic
                                            fun ofString(string: String) =
                                                UnnamedSchemaWithArrayParent7(string = string)

                                            @JvmStatic
                                            fun ofNumber(number: Double) =
                                                UnnamedSchemaWithArrayParent7(number = number)

                                            @JvmStatic
                                            fun ofBool(bool: Boolean) =
                                                UnnamedSchemaWithArrayParent7(bool = bool)
                                        }

                                        /**
                                         * An interface that defines how to map each variant of
                                         * [UnnamedSchemaWithArrayParent7] to a value of type [T].
                                         */
                                        interface Visitor<out T> {

                                            fun visitString(string: String): T

                                            fun visitNumber(number: Double): T

                                            fun visitBool(bool: Boolean): T

                                            /**
                                             * Maps an unknown variant of
                                             * [UnnamedSchemaWithArrayParent7] to a value of type
                                             * [T].
                                             *
                                             * An instance of [UnnamedSchemaWithArrayParent7] can
                                             * contain an unknown variant if it was deserialized
                                             * from data that doesn't match any known variant. For
                                             * example, if the SDK is on an older version than the
                                             * API, then the API may respond with new variants that
                                             * the SDK is unaware of.
                                             *
                                             * @throws ImageKitInvalidDataException in the default
                                             *   implementation.
                                             */
                                            fun unknown(json: JsonValue?): T {
                                                throw ImageKitInvalidDataException(
                                                    "Unknown UnnamedSchemaWithArrayParent7: $json"
                                                )
                                            }
                                        }

                                        internal class Deserializer :
                                            BaseDeserializer<UnnamedSchemaWithArrayParent7>(
                                                UnnamedSchemaWithArrayParent7::class
                                            ) {

                                            override fun ObjectCodec.deserialize(
                                                node: JsonNode
                                            ): UnnamedSchemaWithArrayParent7 {
                                                val json = JsonValue.fromJsonNode(node)

                                                val bestMatches =
                                                    sequenceOf(
                                                            tryDeserialize(
                                                                    node,
                                                                    jacksonTypeRef<String>(),
                                                                )
                                                                ?.let {
                                                                    UnnamedSchemaWithArrayParent7(
                                                                        string = it,
                                                                        _json = json,
                                                                    )
                                                                },
                                                            tryDeserialize(
                                                                    node,
                                                                    jacksonTypeRef<Double>(),
                                                                )
                                                                ?.let {
                                                                    UnnamedSchemaWithArrayParent7(
                                                                        number = it,
                                                                        _json = json,
                                                                    )
                                                                },
                                                            tryDeserialize(
                                                                    node,
                                                                    jacksonTypeRef<Boolean>(),
                                                                )
                                                                ?.let {
                                                                    UnnamedSchemaWithArrayParent7(
                                                                        bool = it,
                                                                        _json = json,
                                                                    )
                                                                },
                                                        )
                                                        .filterNotNull()
                                                        .allMaxBy { it.validity() }
                                                        .toList()
                                                return when (bestMatches.size) {
                                                    // This can happen if what we're deserializing
                                                    // is completely incompatible with all the
                                                    // possible variants (e.g. deserializing from
                                                    // object).
                                                    0 -> UnnamedSchemaWithArrayParent7(_json = json)
                                                    1 -> bestMatches.single()
                                                    // If there's more than one match with the
                                                    // highest validity, then use the first
                                                    // completely valid match, or simply the first
                                                    // match if none are completely valid.
                                                    else ->
                                                        bestMatches.firstOrNull { it.isValid() }
                                                            ?: bestMatches.first()
                                                }
                                            }
                                        }

                                        internal class Serializer :
                                            BaseSerializer<UnnamedSchemaWithArrayParent7>(
                                                UnnamedSchemaWithArrayParent7::class
                                            ) {

                                            override fun serialize(
                                                value: UnnamedSchemaWithArrayParent7,
                                                generator: JsonGenerator,
                                                provider: SerializerProvider,
                                            ) {
                                                when {
                                                    value.string != null ->
                                                        generator.writeObject(value.string)
                                                    value.number != null ->
                                                        generator.writeObject(value.number)
                                                    value.bool != null ->
                                                        generator.writeObject(value.bool)
                                                    value._json != null ->
                                                        generator.writeObject(value._json)
                                                    else ->
                                                        throw IllegalStateException(
                                                            "Invalid UnnamedSchemaWithArrayParent7"
                                                        )
                                                }
                                            }
                                        }
                                    }
                                }

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is SetMetadata &&
                                        field == other.field &&
                                        value == other.value &&
                                        additionalProperties == other.additionalProperties
                                }

                                private val hashCode: Int by lazy {
                                    Objects.hash(field, value, additionalProperties)
                                }

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "SetMetadata{field=$field, value=$value, additionalProperties=$additionalProperties}"
                            }

                            class UnsetMetadata
                            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                            private constructor(
                                private val field: JsonField<String>,
                                private val additionalProperties: MutableMap<String, JsonValue>,
                            ) {

                                @JsonCreator
                                private constructor(
                                    @JsonProperty("field")
                                    @ExcludeMissing
                                    field: JsonField<String> = JsonMissing.of()
                                ) : this(field, mutableMapOf())

                                /**
                                 * Name of the custom metadata field to remove.
                                 *
                                 * @throws ImageKitInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun field(): String = field.getRequired("field")

                                /**
                                 * Returns the raw JSON value of [field].
                                 *
                                 * Unlike [field], this method doesn't throw if the JSON field has
                                 * an unexpected type.
                                 */
                                @JsonProperty("field")
                                @ExcludeMissing
                                fun _field(): JsonField<String> = field

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
                                     * [UnsetMetadata].
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * ```
                                     */
                                    @JvmStatic fun builder() = Builder()
                                }

                                /** A builder for [UnsetMetadata]. */
                                class Builder internal constructor() {

                                    private var field: JsonField<String>? = null
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    @JvmSynthetic
                                    internal fun from(unsetMetadata: UnsetMetadata) = apply {
                                        field = unsetMetadata.field
                                        additionalProperties =
                                            unsetMetadata.additionalProperties.toMutableMap()
                                    }

                                    /** Name of the custom metadata field to remove. */
                                    fun field(field: String) = field(JsonField.of(field))

                                    /**
                                     * Sets [Builder.field] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.field] with a well-typed
                                     * [String] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun field(field: JsonField<String>) = apply {
                                        this.field = field
                                    }

                                    fun additionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.clear()
                                        putAllAdditionalProperties(additionalProperties)
                                    }

                                    fun putAdditionalProperty(key: String, value: JsonValue) =
                                        apply {
                                            additionalProperties.put(key, value)
                                        }

                                    fun putAllAdditionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.putAll(additionalProperties)
                                    }

                                    fun removeAdditionalProperty(key: String) = apply {
                                        additionalProperties.remove(key)
                                    }

                                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                        keys.forEach(::removeAdditionalProperty)
                                    }

                                    /**
                                     * Returns an immutable instance of [UnsetMetadata].
                                     *
                                     * Further updates to this [Builder] will not mutate the
                                     * returned instance.
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .field()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): UnsetMetadata =
                                        UnsetMetadata(
                                            checkRequired("field", field),
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): UnsetMetadata = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    field()
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                @JvmSynthetic
                                internal fun validity(): Int =
                                    (if (field.asKnown().isPresent) 1 else 0)

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is UnsetMetadata &&
                                        field == other.field &&
                                        additionalProperties == other.additionalProperties
                                }

                                private val hashCode: Int by lazy {
                                    Objects.hash(field, additionalProperties)
                                }

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "UnsetMetadata{field=$field, additionalProperties=$additionalProperties}"
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is OnYes &&
                                    addTags == other.addTags &&
                                    removeTags == other.removeTags &&
                                    setMetadata == other.setMetadata &&
                                    unsetMetadata == other.unsetMetadata &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(
                                    addTags,
                                    removeTags,
                                    setMetadata,
                                    unsetMetadata,
                                    additionalProperties,
                                )
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "OnYes{addTags=$addTags, removeTags=$removeTags, setMetadata=$setMetadata, unsetMetadata=$unsetMetadata, additionalProperties=$additionalProperties}"
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is YesNo &&
                                instruction == other.instruction &&
                                type == other.type &&
                                onNo == other.onNo &&
                                onUnknown == other.onUnknown &&
                                onYes == other.onYes &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                instruction,
                                type,
                                onNo,
                                onUnknown,
                                onYes,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "YesNo{instruction=$instruction, type=$type, onNo=$onNo, onUnknown=$onUnknown, onYes=$onYes, additionalProperties=$additionalProperties}"
                    }
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is AiTasks &&
                        name == other.name &&
                        tasks == other.tasks &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(name, tasks, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "AiTasks{name=$name, tasks=$tasks, additionalProperties=$additionalProperties}"
            }

            class SavedExtension
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val id: JsonField<String>,
                private val name: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("name") @ExcludeMissing name: JsonValue = JsonMissing.of(),
                ) : this(id, name, mutableMapOf())

                /**
                 * The unique ID of the saved extension to apply.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun id(): String = id.getRequired("id")

                /**
                 * Indicates this is a reference to a saved extension.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("saved-extension")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonValue = name

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
                     * Returns a mutable builder for constructing an instance of [SavedExtension].
                     *
                     * The following fields are required:
                     * ```java
                     * .id()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [SavedExtension]. */
                class Builder internal constructor() {

                    private var id: JsonField<String>? = null
                    private var name: JsonValue = JsonValue.from("saved-extension")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(savedExtension: SavedExtension) = apply {
                        id = savedExtension.id
                        name = savedExtension.name
                        additionalProperties = savedExtension.additionalProperties.toMutableMap()
                    }

                    /** The unique ID of the saved extension to apply. */
                    fun id(id: String) = id(JsonField.of(id))

                    /**
                     * Sets [Builder.id] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.id] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("saved-extension")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun name(name: JsonValue) = apply { this.name = name }

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
                     * Returns an immutable instance of [SavedExtension].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .id()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): SavedExtension =
                        SavedExtension(
                            checkRequired("id", id),
                            name,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): SavedExtension = apply {
                    if (validated) {
                        return@apply
                    }

                    id()
                    _name().let {
                        if (it != JsonValue.from("saved-extension")) {
                            throw ImageKitInvalidDataException("'name' is invalid, received $it")
                        }
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
                    (if (id.asKnown().isPresent) 1 else 0) +
                        name.let { if (it == JsonValue.from("saved-extension")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is SavedExtension &&
                        id == other.id &&
                        name == other.name &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "SavedExtension{id=$id, name=$name, additionalProperties=$additionalProperties}"
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
                        // with all the possible variants (e.g. deserializing from boolean).
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
