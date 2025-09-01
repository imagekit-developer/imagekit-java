// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.folders

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.Params
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.http.Headers
import com.imagekit.api.core.http.QueryParams
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects

/**
 * This will create a new folder. You can specify the folder name and location of the parent folder
 * where this new folder should be created.
 */
class FolderCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The folder will be created with this name.
     *
     * All characters except alphabets and numbers (inclusive of unicode letters, marks, and
     * numerals in other languages) will be replaced by an underscore i.e. `_`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun folderName(): String = body.folderName()

    /**
     * The folder where the new folder should be created, for root use `/` else the path e.g.
     * `containing/folder/`.
     *
     * Note: If any folder(s) is not present in the parentFolderPath parameter, it will be
     * automatically created. For example, if you pass `/product/images/summer`, then `product`,
     * `images`, and `summer` folders will be created if they don't already exist.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun parentFolderPath(): String = body.parentFolderPath()

    /**
     * Returns the raw JSON value of [folderName].
     *
     * Unlike [folderName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _folderName(): JsonField<String> = body._folderName()

    /**
     * Returns the raw JSON value of [parentFolderPath].
     *
     * Unlike [parentFolderPath], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _parentFolderPath(): JsonField<String> = body._parentFolderPath()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FolderCreateParams].
         *
         * The following fields are required:
         * ```java
         * .folderName()
         * .parentFolderPath()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FolderCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(folderCreateParams: FolderCreateParams) = apply {
            body = folderCreateParams.body.toBuilder()
            additionalHeaders = folderCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = folderCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [folderName]
         * - [parentFolderPath]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The folder will be created with this name.
         *
         * All characters except alphabets and numbers (inclusive of unicode letters, marks, and
         * numerals in other languages) will be replaced by an underscore i.e. `_`.
         */
        fun folderName(folderName: String) = apply { body.folderName(folderName) }

        /**
         * Sets [Builder.folderName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.folderName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun folderName(folderName: JsonField<String>) = apply { body.folderName(folderName) }

        /**
         * The folder where the new folder should be created, for root use `/` else the path e.g.
         * `containing/folder/`.
         *
         * Note: If any folder(s) is not present in the parentFolderPath parameter, it will be
         * automatically created. For example, if you pass `/product/images/summer`, then `product`,
         * `images`, and `summer` folders will be created if they don't already exist.
         */
        fun parentFolderPath(parentFolderPath: String) = apply {
            body.parentFolderPath(parentFolderPath)
        }

        /**
         * Sets [Builder.parentFolderPath] to an arbitrary JSON value.
         *
         * You should usually call [Builder.parentFolderPath] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun parentFolderPath(parentFolderPath: JsonField<String>) = apply {
            body.parentFolderPath(parentFolderPath)
        }

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
         * Returns an immutable instance of [FolderCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .folderName()
         * .parentFolderPath()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FolderCreateParams =
            FolderCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val folderName: JsonField<String>,
        private val parentFolderPath: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("folderName")
            @ExcludeMissing
            folderName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("parentFolderPath")
            @ExcludeMissing
            parentFolderPath: JsonField<String> = JsonMissing.of(),
        ) : this(folderName, parentFolderPath, mutableMapOf())

        /**
         * The folder will be created with this name.
         *
         * All characters except alphabets and numbers (inclusive of unicode letters, marks, and
         * numerals in other languages) will be replaced by an underscore i.e. `_`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun folderName(): String = folderName.getRequired("folderName")

        /**
         * The folder where the new folder should be created, for root use `/` else the path e.g.
         * `containing/folder/`.
         *
         * Note: If any folder(s) is not present in the parentFolderPath parameter, it will be
         * automatically created. For example, if you pass `/product/images/summer`, then `product`,
         * `images`, and `summer` folders will be created if they don't already exist.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun parentFolderPath(): String = parentFolderPath.getRequired("parentFolderPath")

        /**
         * Returns the raw JSON value of [folderName].
         *
         * Unlike [folderName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("folderName")
        @ExcludeMissing
        fun _folderName(): JsonField<String> = folderName

        /**
         * Returns the raw JSON value of [parentFolderPath].
         *
         * Unlike [parentFolderPath], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("parentFolderPath")
        @ExcludeMissing
        fun _parentFolderPath(): JsonField<String> = parentFolderPath

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
             * .folderName()
             * .parentFolderPath()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var folderName: JsonField<String>? = null
            private var parentFolderPath: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                folderName = body.folderName
                parentFolderPath = body.parentFolderPath
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The folder will be created with this name.
             *
             * All characters except alphabets and numbers (inclusive of unicode letters, marks, and
             * numerals in other languages) will be replaced by an underscore i.e. `_`.
             */
            fun folderName(folderName: String) = folderName(JsonField.of(folderName))

            /**
             * Sets [Builder.folderName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.folderName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun folderName(folderName: JsonField<String>) = apply { this.folderName = folderName }

            /**
             * The folder where the new folder should be created, for root use `/` else the path
             * e.g. `containing/folder/`.
             *
             * Note: If any folder(s) is not present in the parentFolderPath parameter, it will be
             * automatically created. For example, if you pass `/product/images/summer`, then
             * `product`, `images`, and `summer` folders will be created if they don't already
             * exist.
             */
            fun parentFolderPath(parentFolderPath: String) =
                parentFolderPath(JsonField.of(parentFolderPath))

            /**
             * Sets [Builder.parentFolderPath] to an arbitrary JSON value.
             *
             * You should usually call [Builder.parentFolderPath] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun parentFolderPath(parentFolderPath: JsonField<String>) = apply {
                this.parentFolderPath = parentFolderPath
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .folderName()
             * .parentFolderPath()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("folderName", folderName),
                    checkRequired("parentFolderPath", parentFolderPath),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            folderName()
            parentFolderPath()
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
            (if (folderName.asKnown().isPresent) 1 else 0) +
                (if (parentFolderPath.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                folderName == other.folderName &&
                parentFolderPath == other.parentFolderPath &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(folderName, parentFolderPath, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{folderName=$folderName, parentFolderPath=$parentFolderPath, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FolderCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FolderCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
