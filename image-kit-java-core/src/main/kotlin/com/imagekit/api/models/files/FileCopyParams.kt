// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

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
import java.util.Optional

/**
 * This will copy a file from one folder to another.
 *
 * Note: If any file at the destination has the same name as the source file, then the source file
 * and its versions (if `includeFileVersions` is set to true) will be appended to the destination
 * file version history.
 */
class FileCopyParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Full path to the folder you want to copy the above file into.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun destinationPath(): String = body.destinationPath()

    /**
     * The full path of the file you want to copy.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sourceFilePath(): String = body.sourceFilePath()

    /**
     * Option to copy all versions of a file. By default, only the current version of the file is
     * copied. When set to true, all versions of the file will be copied. Default value - `false`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun includeFileVersions(): Optional<Boolean> = body.includeFileVersions()

    /**
     * Returns the raw JSON value of [destinationPath].
     *
     * Unlike [destinationPath], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _destinationPath(): JsonField<String> = body._destinationPath()

    /**
     * Returns the raw JSON value of [sourceFilePath].
     *
     * Unlike [sourceFilePath], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sourceFilePath(): JsonField<String> = body._sourceFilePath()

    /**
     * Returns the raw JSON value of [includeFileVersions].
     *
     * Unlike [includeFileVersions], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _includeFileVersions(): JsonField<Boolean> = body._includeFileVersions()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileCopyParams].
         *
         * The following fields are required:
         * ```java
         * .destinationPath()
         * .sourceFilePath()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileCopyParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fileCopyParams: FileCopyParams) = apply {
            body = fileCopyParams.body.toBuilder()
            additionalHeaders = fileCopyParams.additionalHeaders.toBuilder()
            additionalQueryParams = fileCopyParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [destinationPath]
         * - [sourceFilePath]
         * - [includeFileVersions]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Full path to the folder you want to copy the above file into. */
        fun destinationPath(destinationPath: String) = apply {
            body.destinationPath(destinationPath)
        }

        /**
         * Sets [Builder.destinationPath] to an arbitrary JSON value.
         *
         * You should usually call [Builder.destinationPath] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun destinationPath(destinationPath: JsonField<String>) = apply {
            body.destinationPath(destinationPath)
        }

        /** The full path of the file you want to copy. */
        fun sourceFilePath(sourceFilePath: String) = apply { body.sourceFilePath(sourceFilePath) }

        /**
         * Sets [Builder.sourceFilePath] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceFilePath] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sourceFilePath(sourceFilePath: JsonField<String>) = apply {
            body.sourceFilePath(sourceFilePath)
        }

        /**
         * Option to copy all versions of a file. By default, only the current version of the file
         * is copied. When set to true, all versions of the file will be copied. Default value -
         * `false`.
         */
        fun includeFileVersions(includeFileVersions: Boolean) = apply {
            body.includeFileVersions(includeFileVersions)
        }

        /**
         * Sets [Builder.includeFileVersions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeFileVersions] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun includeFileVersions(includeFileVersions: JsonField<Boolean>) = apply {
            body.includeFileVersions(includeFileVersions)
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
         * Returns an immutable instance of [FileCopyParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .destinationPath()
         * .sourceFilePath()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileCopyParams =
            FileCopyParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val destinationPath: JsonField<String>,
        private val sourceFilePath: JsonField<String>,
        private val includeFileVersions: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("destinationPath")
            @ExcludeMissing
            destinationPath: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sourceFilePath")
            @ExcludeMissing
            sourceFilePath: JsonField<String> = JsonMissing.of(),
            @JsonProperty("includeFileVersions")
            @ExcludeMissing
            includeFileVersions: JsonField<Boolean> = JsonMissing.of(),
        ) : this(destinationPath, sourceFilePath, includeFileVersions, mutableMapOf())

        /**
         * Full path to the folder you want to copy the above file into.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun destinationPath(): String = destinationPath.getRequired("destinationPath")

        /**
         * The full path of the file you want to copy.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sourceFilePath(): String = sourceFilePath.getRequired("sourceFilePath")

        /**
         * Option to copy all versions of a file. By default, only the current version of the file
         * is copied. When set to true, all versions of the file will be copied. Default value -
         * `false`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun includeFileVersions(): Optional<Boolean> =
            includeFileVersions.getOptional("includeFileVersions")

        /**
         * Returns the raw JSON value of [destinationPath].
         *
         * Unlike [destinationPath], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("destinationPath")
        @ExcludeMissing
        fun _destinationPath(): JsonField<String> = destinationPath

        /**
         * Returns the raw JSON value of [sourceFilePath].
         *
         * Unlike [sourceFilePath], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sourceFilePath")
        @ExcludeMissing
        fun _sourceFilePath(): JsonField<String> = sourceFilePath

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .destinationPath()
             * .sourceFilePath()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var destinationPath: JsonField<String>? = null
            private var sourceFilePath: JsonField<String>? = null
            private var includeFileVersions: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                destinationPath = body.destinationPath
                sourceFilePath = body.sourceFilePath
                includeFileVersions = body.includeFileVersions
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Full path to the folder you want to copy the above file into. */
            fun destinationPath(destinationPath: String) =
                destinationPath(JsonField.of(destinationPath))

            /**
             * Sets [Builder.destinationPath] to an arbitrary JSON value.
             *
             * You should usually call [Builder.destinationPath] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun destinationPath(destinationPath: JsonField<String>) = apply {
                this.destinationPath = destinationPath
            }

            /** The full path of the file you want to copy. */
            fun sourceFilePath(sourceFilePath: String) =
                sourceFilePath(JsonField.of(sourceFilePath))

            /**
             * Sets [Builder.sourceFilePath] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sourceFilePath] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sourceFilePath(sourceFilePath: JsonField<String>) = apply {
                this.sourceFilePath = sourceFilePath
            }

            /**
             * Option to copy all versions of a file. By default, only the current version of the
             * file is copied. When set to true, all versions of the file will be copied. Default
             * value - `false`.
             */
            fun includeFileVersions(includeFileVersions: Boolean) =
                includeFileVersions(JsonField.of(includeFileVersions))

            /**
             * Sets [Builder.includeFileVersions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeFileVersions] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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
             * .destinationPath()
             * .sourceFilePath()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("destinationPath", destinationPath),
                    checkRequired("sourceFilePath", sourceFilePath),
                    includeFileVersions,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            destinationPath()
            sourceFilePath()
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
            (if (destinationPath.asKnown().isPresent) 1 else 0) +
                (if (sourceFilePath.asKnown().isPresent) 1 else 0) +
                (if (includeFileVersions.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                destinationPath == other.destinationPath &&
                sourceFilePath == other.sourceFilePath &&
                includeFileVersions == other.includeFileVersions &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(destinationPath, sourceFilePath, includeFileVersions, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{destinationPath=$destinationPath, sourceFilePath=$sourceFilePath, includeFileVersions=$includeFileVersions, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileCopyParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FileCopyParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
