// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.folders

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.core.Params
import io.imagekit.core.checkRequired
import io.imagekit.core.http.Headers
import io.imagekit.core.http.QueryParams
import io.imagekit.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * This API allows you to rename an existing folder. The folder and all its nested assets and
 * sub-folders will remain unchanged, but their paths will be updated to reflect the new folder
 * name.
 */
class FolderRenameParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The full path to the folder you want to rename.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun folderPath(): String = body.folderPath()

    /**
     * The new name for the folder.
     *
     * All characters except alphabets and numbers (inclusive of unicode letters, marks, and
     * numerals in other languages) and `-` will be replaced by an underscore i.e. `_`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun newFolderName(): String = body.newFolderName()

    /**
     * Option to purge cache for the old nested files and their versions' URLs.
     *
     * When set to true, it will internally issue a purge cache request on CDN to remove the cached
     * content of the old nested files and their versions. There will only be one purge request for
     * all the nested files, which will be counted against your monthly purge quota.
     *
     * Note: A purge cache request will be issued against `https://ik.imagekit.io/old/folder/path*`
     * (with a wildcard at the end). This will remove all nested files, their versions' URLs, and
     * any transformations made using query parameters on these files or their versions. However,
     * the cache for file transformations made using path parameters will persist. You can purge
     * them using the purge API. For more details, refer to the purge API documentation.
     *
     * Default value - `false`
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun purgeCache(): Optional<Boolean> = body.purgeCache()

    /**
     * Returns the raw JSON value of [folderPath].
     *
     * Unlike [folderPath], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _folderPath(): JsonField<String> = body._folderPath()

    /**
     * Returns the raw JSON value of [newFolderName].
     *
     * Unlike [newFolderName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _newFolderName(): JsonField<String> = body._newFolderName()

    /**
     * Returns the raw JSON value of [purgeCache].
     *
     * Unlike [purgeCache], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _purgeCache(): JsonField<Boolean> = body._purgeCache()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FolderRenameParams].
         *
         * The following fields are required:
         * ```java
         * .folderPath()
         * .newFolderName()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FolderRenameParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(folderRenameParams: FolderRenameParams) = apply {
            body = folderRenameParams.body.toBuilder()
            additionalHeaders = folderRenameParams.additionalHeaders.toBuilder()
            additionalQueryParams = folderRenameParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [folderPath]
         * - [newFolderName]
         * - [purgeCache]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The full path to the folder you want to rename. */
        fun folderPath(folderPath: String) = apply { body.folderPath(folderPath) }

        /**
         * Sets [Builder.folderPath] to an arbitrary JSON value.
         *
         * You should usually call [Builder.folderPath] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun folderPath(folderPath: JsonField<String>) = apply { body.folderPath(folderPath) }

        /**
         * The new name for the folder.
         *
         * All characters except alphabets and numbers (inclusive of unicode letters, marks, and
         * numerals in other languages) and `-` will be replaced by an underscore i.e. `_`.
         */
        fun newFolderName(newFolderName: String) = apply { body.newFolderName(newFolderName) }

        /**
         * Sets [Builder.newFolderName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.newFolderName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun newFolderName(newFolderName: JsonField<String>) = apply {
            body.newFolderName(newFolderName)
        }

        /**
         * Option to purge cache for the old nested files and their versions' URLs.
         *
         * When set to true, it will internally issue a purge cache request on CDN to remove the
         * cached content of the old nested files and their versions. There will only be one purge
         * request for all the nested files, which will be counted against your monthly purge quota.
         *
         * Note: A purge cache request will be issued against
         * `https://ik.imagekit.io/old/folder/path*` (with a wildcard at the end). This will remove
         * all nested files, their versions' URLs, and any transformations made using query
         * parameters on these files or their versions. However, the cache for file transformations
         * made using path parameters will persist. You can purge them using the purge API. For more
         * details, refer to the purge API documentation.
         *
         * Default value - `false`
         */
        fun purgeCache(purgeCache: Boolean) = apply { body.purgeCache(purgeCache) }

        /**
         * Sets [Builder.purgeCache] to an arbitrary JSON value.
         *
         * You should usually call [Builder.purgeCache] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun purgeCache(purgeCache: JsonField<Boolean>) = apply { body.purgeCache(purgeCache) }

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
         * Returns an immutable instance of [FolderRenameParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .folderPath()
         * .newFolderName()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FolderRenameParams =
            FolderRenameParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val folderPath: JsonField<String>,
        private val newFolderName: JsonField<String>,
        private val purgeCache: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("folderPath")
            @ExcludeMissing
            folderPath: JsonField<String> = JsonMissing.of(),
            @JsonProperty("newFolderName")
            @ExcludeMissing
            newFolderName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("purgeCache")
            @ExcludeMissing
            purgeCache: JsonField<Boolean> = JsonMissing.of(),
        ) : this(folderPath, newFolderName, purgeCache, mutableMapOf())

        /**
         * The full path to the folder you want to rename.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun folderPath(): String = folderPath.getRequired("folderPath")

        /**
         * The new name for the folder.
         *
         * All characters except alphabets and numbers (inclusive of unicode letters, marks, and
         * numerals in other languages) and `-` will be replaced by an underscore i.e. `_`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun newFolderName(): String = newFolderName.getRequired("newFolderName")

        /**
         * Option to purge cache for the old nested files and their versions' URLs.
         *
         * When set to true, it will internally issue a purge cache request on CDN to remove the
         * cached content of the old nested files and their versions. There will only be one purge
         * request for all the nested files, which will be counted against your monthly purge quota.
         *
         * Note: A purge cache request will be issued against
         * `https://ik.imagekit.io/old/folder/path*` (with a wildcard at the end). This will remove
         * all nested files, their versions' URLs, and any transformations made using query
         * parameters on these files or their versions. However, the cache for file transformations
         * made using path parameters will persist. You can purge them using the purge API. For more
         * details, refer to the purge API documentation.
         *
         * Default value - `false`
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun purgeCache(): Optional<Boolean> = purgeCache.getOptional("purgeCache")

        /**
         * Returns the raw JSON value of [folderPath].
         *
         * Unlike [folderPath], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("folderPath")
        @ExcludeMissing
        fun _folderPath(): JsonField<String> = folderPath

        /**
         * Returns the raw JSON value of [newFolderName].
         *
         * Unlike [newFolderName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("newFolderName")
        @ExcludeMissing
        fun _newFolderName(): JsonField<String> = newFolderName

        /**
         * Returns the raw JSON value of [purgeCache].
         *
         * Unlike [purgeCache], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("purgeCache")
        @ExcludeMissing
        fun _purgeCache(): JsonField<Boolean> = purgeCache

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
             * .folderPath()
             * .newFolderName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var folderPath: JsonField<String>? = null
            private var newFolderName: JsonField<String>? = null
            private var purgeCache: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                folderPath = body.folderPath
                newFolderName = body.newFolderName
                purgeCache = body.purgeCache
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The full path to the folder you want to rename. */
            fun folderPath(folderPath: String) = folderPath(JsonField.of(folderPath))

            /**
             * Sets [Builder.folderPath] to an arbitrary JSON value.
             *
             * You should usually call [Builder.folderPath] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun folderPath(folderPath: JsonField<String>) = apply { this.folderPath = folderPath }

            /**
             * The new name for the folder.
             *
             * All characters except alphabets and numbers (inclusive of unicode letters, marks, and
             * numerals in other languages) and `-` will be replaced by an underscore i.e. `_`.
             */
            fun newFolderName(newFolderName: String) = newFolderName(JsonField.of(newFolderName))

            /**
             * Sets [Builder.newFolderName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.newFolderName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun newFolderName(newFolderName: JsonField<String>) = apply {
                this.newFolderName = newFolderName
            }

            /**
             * Option to purge cache for the old nested files and their versions' URLs.
             *
             * When set to true, it will internally issue a purge cache request on CDN to remove the
             * cached content of the old nested files and their versions. There will only be one
             * purge request for all the nested files, which will be counted against your monthly
             * purge quota.
             *
             * Note: A purge cache request will be issued against
             * `https://ik.imagekit.io/old/folder/path*` (with a wildcard at the end). This will
             * remove all nested files, their versions' URLs, and any transformations made using
             * query parameters on these files or their versions. However, the cache for file
             * transformations made using path parameters will persist. You can purge them using the
             * purge API. For more details, refer to the purge API documentation.
             *
             * Default value - `false`
             */
            fun purgeCache(purgeCache: Boolean) = purgeCache(JsonField.of(purgeCache))

            /**
             * Sets [Builder.purgeCache] to an arbitrary JSON value.
             *
             * You should usually call [Builder.purgeCache] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun purgeCache(purgeCache: JsonField<Boolean>) = apply { this.purgeCache = purgeCache }

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
             * .folderPath()
             * .newFolderName()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("folderPath", folderPath),
                    checkRequired("newFolderName", newFolderName),
                    purgeCache,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            folderPath()
            newFolderName()
            purgeCache()
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
            (if (folderPath.asKnown().isPresent) 1 else 0) +
                (if (newFolderName.asKnown().isPresent) 1 else 0) +
                (if (purgeCache.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                folderPath == other.folderPath &&
                newFolderName == other.newFolderName &&
                purgeCache == other.purgeCache &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(folderPath, newFolderName, purgeCache, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{folderPath=$folderPath, newFolderName=$newFolderName, purgeCache=$purgeCache, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FolderRenameParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FolderRenameParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
