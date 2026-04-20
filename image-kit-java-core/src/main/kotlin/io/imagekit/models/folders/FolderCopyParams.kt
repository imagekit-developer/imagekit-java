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
 * This will copy one folder into another. The selected folder, its nested folders, files, and their
 * versions (in `includeVersions` is set to true) are copied in this operation. Note: If any file at
 * the destination has the same name as the source file, then the source file and its versions will
 * be appended to the destination file version history.
 */
class FolderCopyParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Full path to the destination folder where you want to copy the source folder into.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun destinationPath(): String = body.destinationPath()

    /**
     * The full path to the source folder you want to copy.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sourceFolderPath(): String = body.sourceFolderPath()

    /**
     * Option to copy all versions of files that are nested inside the selected folder. By default,
     * only the current version of each file will be copied. When set to true, all versions of each
     * file will be copied. Default value - `false`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun includeVersions(): Optional<Boolean> = body.includeVersions()

    /**
     * Returns the raw JSON value of [destinationPath].
     *
     * Unlike [destinationPath], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _destinationPath(): JsonField<String> = body._destinationPath()

    /**
     * Returns the raw JSON value of [sourceFolderPath].
     *
     * Unlike [sourceFolderPath], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _sourceFolderPath(): JsonField<String> = body._sourceFolderPath()

    /**
     * Returns the raw JSON value of [includeVersions].
     *
     * Unlike [includeVersions], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _includeVersions(): JsonField<Boolean> = body._includeVersions()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FolderCopyParams].
         *
         * The following fields are required:
         * ```java
         * .destinationPath()
         * .sourceFolderPath()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FolderCopyParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(folderCopyParams: FolderCopyParams) = apply {
            body = folderCopyParams.body.toBuilder()
            additionalHeaders = folderCopyParams.additionalHeaders.toBuilder()
            additionalQueryParams = folderCopyParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [destinationPath]
         * - [sourceFolderPath]
         * - [includeVersions]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Full path to the destination folder where you want to copy the source folder into. */
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

        /** The full path to the source folder you want to copy. */
        fun sourceFolderPath(sourceFolderPath: String) = apply {
            body.sourceFolderPath(sourceFolderPath)
        }

        /**
         * Sets [Builder.sourceFolderPath] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceFolderPath] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sourceFolderPath(sourceFolderPath: JsonField<String>) = apply {
            body.sourceFolderPath(sourceFolderPath)
        }

        /**
         * Option to copy all versions of files that are nested inside the selected folder. By
         * default, only the current version of each file will be copied. When set to true, all
         * versions of each file will be copied. Default value - `false`.
         */
        fun includeVersions(includeVersions: Boolean) = apply {
            body.includeVersions(includeVersions)
        }

        /**
         * Sets [Builder.includeVersions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeVersions] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun includeVersions(includeVersions: JsonField<Boolean>) = apply {
            body.includeVersions(includeVersions)
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
         * Returns an immutable instance of [FolderCopyParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .destinationPath()
         * .sourceFolderPath()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FolderCopyParams =
            FolderCopyParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val destinationPath: JsonField<String>,
        private val sourceFolderPath: JsonField<String>,
        private val includeVersions: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("destinationPath")
            @ExcludeMissing
            destinationPath: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sourceFolderPath")
            @ExcludeMissing
            sourceFolderPath: JsonField<String> = JsonMissing.of(),
            @JsonProperty("includeVersions")
            @ExcludeMissing
            includeVersions: JsonField<Boolean> = JsonMissing.of(),
        ) : this(destinationPath, sourceFolderPath, includeVersions, mutableMapOf())

        /**
         * Full path to the destination folder where you want to copy the source folder into.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun destinationPath(): String = destinationPath.getRequired("destinationPath")

        /**
         * The full path to the source folder you want to copy.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sourceFolderPath(): String = sourceFolderPath.getRequired("sourceFolderPath")

        /**
         * Option to copy all versions of files that are nested inside the selected folder. By
         * default, only the current version of each file will be copied. When set to true, all
         * versions of each file will be copied. Default value - `false`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun includeVersions(): Optional<Boolean> = includeVersions.getOptional("includeVersions")

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
         * Returns the raw JSON value of [sourceFolderPath].
         *
         * Unlike [sourceFolderPath], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sourceFolderPath")
        @ExcludeMissing
        fun _sourceFolderPath(): JsonField<String> = sourceFolderPath

        /**
         * Returns the raw JSON value of [includeVersions].
         *
         * Unlike [includeVersions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("includeVersions")
        @ExcludeMissing
        fun _includeVersions(): JsonField<Boolean> = includeVersions

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
             * .sourceFolderPath()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var destinationPath: JsonField<String>? = null
            private var sourceFolderPath: JsonField<String>? = null
            private var includeVersions: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                destinationPath = body.destinationPath
                sourceFolderPath = body.sourceFolderPath
                includeVersions = body.includeVersions
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Full path to the destination folder where you want to copy the source folder into.
             */
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

            /** The full path to the source folder you want to copy. */
            fun sourceFolderPath(sourceFolderPath: String) =
                sourceFolderPath(JsonField.of(sourceFolderPath))

            /**
             * Sets [Builder.sourceFolderPath] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sourceFolderPath] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sourceFolderPath(sourceFolderPath: JsonField<String>) = apply {
                this.sourceFolderPath = sourceFolderPath
            }

            /**
             * Option to copy all versions of files that are nested inside the selected folder. By
             * default, only the current version of each file will be copied. When set to true, all
             * versions of each file will be copied. Default value - `false`.
             */
            fun includeVersions(includeVersions: Boolean) =
                includeVersions(JsonField.of(includeVersions))

            /**
             * Sets [Builder.includeVersions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeVersions] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun includeVersions(includeVersions: JsonField<Boolean>) = apply {
                this.includeVersions = includeVersions
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
             * .sourceFolderPath()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("destinationPath", destinationPath),
                    checkRequired("sourceFolderPath", sourceFolderPath),
                    includeVersions,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            destinationPath()
            sourceFolderPath()
            includeVersions()
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
                (if (sourceFolderPath.asKnown().isPresent) 1 else 0) +
                (if (includeVersions.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                destinationPath == other.destinationPath &&
                sourceFolderPath == other.sourceFolderPath &&
                includeVersions == other.includeVersions &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(destinationPath, sourceFolderPath, includeVersions, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{destinationPath=$destinationPath, sourceFolderPath=$sourceFolderPath, includeVersions=$includeVersions, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FolderCopyParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FolderCopyParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
