// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models.files

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.api.core.ExcludeMissing
import io.imagekit.api.core.JsonField
import io.imagekit.api.core.JsonMissing
import io.imagekit.api.core.JsonValue
import io.imagekit.api.core.Params
import io.imagekit.api.core.checkRequired
import io.imagekit.api.core.http.Headers
import io.imagekit.api.core.http.QueryParams
import io.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * You can rename an already existing file in the media library using rename file API. This
 * operation would rename all file versions of the file.
 *
 * Note: The old URLs will stop working. The file/file version URLs cached on CDN will continue to
 * work unless a purge is requested.
 */
class FileRenameParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The full path of the file you want to rename.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun filePath(): String = body.filePath()

    /**
     * The new name of the file. A filename can contain:
     *
     * Alphanumeric Characters: `a-z`, `A-Z`, `0-9` (including Unicode letters, marks, and numerals
     * in other languages). Special Characters: `.`, `_`, and `-`.
     *
     * Any other character, including space, will be replaced by `_`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun newFileName(): String = body.newFileName()

    /**
     * Option to purge cache for the old file and its versions' URLs.
     *
     * When set to true, it will internally issue a purge cache request on CDN to remove cached
     * content of old file and its versions. This purge request is counted against your monthly
     * purge quota.
     *
     * Note: If the old file were accessible at `https://ik.imagekit.io/demo/old-filename.jpg`, a
     * purge cache request would be issued against `https://ik.imagekit.io/demo/old-filename.jpg*`
     * (with a wildcard at the end). It will remove the file and its versions' URLs and any
     * transformations made using query parameters on this file or its versions. However, the cache
     * for file transformations made using path parameters will persist. You can purge them using
     * the purge API. For more details, refer to the purge API documentation.
     *
     * Default value - `false`
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun purgeCache(): Optional<Boolean> = body.purgeCache()

    /**
     * Returns the raw JSON value of [filePath].
     *
     * Unlike [filePath], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _filePath(): JsonField<String> = body._filePath()

    /**
     * Returns the raw JSON value of [newFileName].
     *
     * Unlike [newFileName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _newFileName(): JsonField<String> = body._newFileName()

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
         * Returns a mutable builder for constructing an instance of [FileRenameParams].
         *
         * The following fields are required:
         * ```java
         * .filePath()
         * .newFileName()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileRenameParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fileRenameParams: FileRenameParams) = apply {
            body = fileRenameParams.body.toBuilder()
            additionalHeaders = fileRenameParams.additionalHeaders.toBuilder()
            additionalQueryParams = fileRenameParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [filePath]
         * - [newFileName]
         * - [purgeCache]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The full path of the file you want to rename. */
        fun filePath(filePath: String) = apply { body.filePath(filePath) }

        /**
         * Sets [Builder.filePath] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filePath] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filePath(filePath: JsonField<String>) = apply { body.filePath(filePath) }

        /**
         * The new name of the file. A filename can contain:
         *
         * Alphanumeric Characters: `a-z`, `A-Z`, `0-9` (including Unicode letters, marks, and
         * numerals in other languages). Special Characters: `.`, `_`, and `-`.
         *
         * Any other character, including space, will be replaced by `_`.
         */
        fun newFileName(newFileName: String) = apply { body.newFileName(newFileName) }

        /**
         * Sets [Builder.newFileName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.newFileName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun newFileName(newFileName: JsonField<String>) = apply { body.newFileName(newFileName) }

        /**
         * Option to purge cache for the old file and its versions' URLs.
         *
         * When set to true, it will internally issue a purge cache request on CDN to remove cached
         * content of old file and its versions. This purge request is counted against your monthly
         * purge quota.
         *
         * Note: If the old file were accessible at `https://ik.imagekit.io/demo/old-filename.jpg`,
         * a purge cache request would be issued against
         * `https://ik.imagekit.io/demo/old-filename.jpg*` (with a wildcard at the end). It will
         * remove the file and its versions' URLs and any transformations made using query
         * parameters on this file or its versions. However, the cache for file transformations made
         * using path parameters will persist. You can purge them using the purge API. For more
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
         * Returns an immutable instance of [FileRenameParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .filePath()
         * .newFileName()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileRenameParams =
            FileRenameParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val filePath: JsonField<String>,
        private val newFileName: JsonField<String>,
        private val purgeCache: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("filePath")
            @ExcludeMissing
            filePath: JsonField<String> = JsonMissing.of(),
            @JsonProperty("newFileName")
            @ExcludeMissing
            newFileName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("purgeCache")
            @ExcludeMissing
            purgeCache: JsonField<Boolean> = JsonMissing.of(),
        ) : this(filePath, newFileName, purgeCache, mutableMapOf())

        /**
         * The full path of the file you want to rename.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun filePath(): String = filePath.getRequired("filePath")

        /**
         * The new name of the file. A filename can contain:
         *
         * Alphanumeric Characters: `a-z`, `A-Z`, `0-9` (including Unicode letters, marks, and
         * numerals in other languages). Special Characters: `.`, `_`, and `-`.
         *
         * Any other character, including space, will be replaced by `_`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun newFileName(): String = newFileName.getRequired("newFileName")

        /**
         * Option to purge cache for the old file and its versions' URLs.
         *
         * When set to true, it will internally issue a purge cache request on CDN to remove cached
         * content of old file and its versions. This purge request is counted against your monthly
         * purge quota.
         *
         * Note: If the old file were accessible at `https://ik.imagekit.io/demo/old-filename.jpg`,
         * a purge cache request would be issued against
         * `https://ik.imagekit.io/demo/old-filename.jpg*` (with a wildcard at the end). It will
         * remove the file and its versions' URLs and any transformations made using query
         * parameters on this file or its versions. However, the cache for file transformations made
         * using path parameters will persist. You can purge them using the purge API. For more
         * details, refer to the purge API documentation.
         *
         * Default value - `false`
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun purgeCache(): Optional<Boolean> = purgeCache.getOptional("purgeCache")

        /**
         * Returns the raw JSON value of [filePath].
         *
         * Unlike [filePath], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("filePath") @ExcludeMissing fun _filePath(): JsonField<String> = filePath

        /**
         * Returns the raw JSON value of [newFileName].
         *
         * Unlike [newFileName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("newFileName")
        @ExcludeMissing
        fun _newFileName(): JsonField<String> = newFileName

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
             * .filePath()
             * .newFileName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var filePath: JsonField<String>? = null
            private var newFileName: JsonField<String>? = null
            private var purgeCache: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                filePath = body.filePath
                newFileName = body.newFileName
                purgeCache = body.purgeCache
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The full path of the file you want to rename. */
            fun filePath(filePath: String) = filePath(JsonField.of(filePath))

            /**
             * Sets [Builder.filePath] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filePath] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filePath(filePath: JsonField<String>) = apply { this.filePath = filePath }

            /**
             * The new name of the file. A filename can contain:
             *
             * Alphanumeric Characters: `a-z`, `A-Z`, `0-9` (including Unicode letters, marks, and
             * numerals in other languages). Special Characters: `.`, `_`, and `-`.
             *
             * Any other character, including space, will be replaced by `_`.
             */
            fun newFileName(newFileName: String) = newFileName(JsonField.of(newFileName))

            /**
             * Sets [Builder.newFileName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.newFileName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun newFileName(newFileName: JsonField<String>) = apply {
                this.newFileName = newFileName
            }

            /**
             * Option to purge cache for the old file and its versions' URLs.
             *
             * When set to true, it will internally issue a purge cache request on CDN to remove
             * cached content of old file and its versions. This purge request is counted against
             * your monthly purge quota.
             *
             * Note: If the old file were accessible at
             * `https://ik.imagekit.io/demo/old-filename.jpg`, a purge cache request would be issued
             * against `https://ik.imagekit.io/demo/old-filename.jpg*` (with a wildcard at the end).
             * It will remove the file and its versions' URLs and any transformations made using
             * query parameters on this file or its versions. However, the cache for file
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
             * .filePath()
             * .newFileName()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("filePath", filePath),
                    checkRequired("newFileName", newFileName),
                    purgeCache,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            filePath()
            newFileName()
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
            (if (filePath.asKnown().isPresent) 1 else 0) +
                (if (newFileName.asKnown().isPresent) 1 else 0) +
                (if (purgeCache.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                filePath == other.filePath &&
                newFileName == other.newFileName &&
                purgeCache == other.purgeCache &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(filePath, newFileName, purgeCache, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{filePath=$filePath, newFileName=$newFileName, purgeCache=$purgeCache, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileRenameParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FileRenameParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
