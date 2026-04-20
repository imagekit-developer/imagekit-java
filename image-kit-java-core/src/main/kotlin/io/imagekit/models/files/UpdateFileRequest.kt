// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files

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
import io.imagekit.core.BaseDeserializer
import io.imagekit.core.BaseSerializer
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.core.allMaxBy
import io.imagekit.core.checkKnown
import io.imagekit.core.checkRequired
import io.imagekit.core.getOrThrow
import io.imagekit.core.toImmutable
import io.imagekit.errors.ImageKitInvalidDataException
import io.imagekit.models.ExtensionItem
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
        private val extensions: JsonField<List<ExtensionItem>>,
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
            extensions: JsonField<List<ExtensionItem>> = JsonMissing.of(),
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
        fun extensions(): Optional<List<ExtensionItem>> = extensions.getOptional("extensions")

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
        fun _extensions(): JsonField<List<ExtensionItem>> = extensions

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
            private var extensions: JsonField<MutableList<ExtensionItem>>? = null
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
            fun extensions(extensions: List<ExtensionItem>) = extensions(JsonField.of(extensions))

            /**
             * Sets [Builder.extensions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.extensions] with a well-typed `List<ExtensionItem>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun extensions(extensions: JsonField<List<ExtensionItem>>) = apply {
                this.extensions = extensions.map { it.toMutableList() }
            }

            /**
             * Adds a single [ExtensionItem] to [extensions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addExtension(extension: ExtensionItem) = apply {
                extensions =
                    (extensions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("extensions", it).add(extension)
                    }
            }

            /** Alias for calling [addExtension] with `ExtensionItem.ofRemoveBg(removeBg)`. */
            fun addExtension(removeBg: ExtensionItem.RemoveBg) =
                addExtension(ExtensionItem.ofRemoveBg(removeBg))

            /**
             * Alias for calling [addExtension] with
             * `ExtensionItem.ofAutoTaggingExtension(autoTaggingExtension)`.
             */
            fun addExtension(autoTaggingExtension: ExtensionItem.AutoTaggingExtension) =
                addExtension(ExtensionItem.ofAutoTaggingExtension(autoTaggingExtension))

            /** Alias for calling [addExtension] with `ExtensionItem.ofAiAutoDescription()`. */
            fun addExtensionAiAutoDescription() = addExtension(ExtensionItem.ofAiAutoDescription())

            /** Alias for calling [addExtension] with `ExtensionItem.ofAiTasks(aiTasks)`. */
            fun addExtension(aiTasks: ExtensionItem.AiTasks) =
                addExtension(ExtensionItem.ofAiTasks(aiTasks))

            /**
             * Alias for calling [addExtension] with the following:
             * ```java
             * ExtensionItem.AiTasks.builder()
             *     .tasks(tasks)
             *     .build()
             * ```
             */
            fun addAiTasksExtension(tasks: List<ExtensionItem.AiTasks.Task>) =
                addExtension(ExtensionItem.AiTasks.builder().tasks(tasks).build())

            /**
             * Alias for calling [addExtension] with
             * `ExtensionItem.ofSavedExtension(savedExtension)`.
             */
            fun addExtension(savedExtension: ExtensionItem.SavedExtension) =
                addExtension(ExtensionItem.ofSavedExtension(savedExtension))

            /**
             * Alias for calling [addExtension] with the following:
             * ```java
             * ExtensionItem.SavedExtension.builder()
             *     .id(id)
             *     .build()
             * ```
             */
            fun addSavedExtensionExtension(id: String) =
                addExtension(ExtensionItem.SavedExtension.builder().id(id).build())

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
