// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.Params
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.http.Headers
import com.imagekit.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * This API updates the details or attributes of the current version of the file. You can update
 * `tags`, `customCoordinates`, `customMetadata`, publication status, remove existing `AITags` and
 * apply extensions using this API.
 */
class FileUpdateParams
private constructor(
    private val fileId: String?,
    private val updateFileRequest: UpdateFileRequest,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun fileId(): Optional<String> = Optional.ofNullable(fileId)

    /** Schema for update file update request. */
    fun updateFileRequest(): UpdateFileRequest = updateFileRequest

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileUpdateParams].
         *
         * The following fields are required:
         * ```java
         * .updateFileRequest()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileUpdateParams]. */
    class Builder internal constructor() {

        private var fileId: String? = null
        private var updateFileRequest: UpdateFileRequest? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fileUpdateParams: FileUpdateParams) = apply {
            fileId = fileUpdateParams.fileId
            updateFileRequest = fileUpdateParams.updateFileRequest
            additionalHeaders = fileUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = fileUpdateParams.additionalQueryParams.toBuilder()
        }

        fun fileId(fileId: String?) = apply { this.fileId = fileId }

        /** Alias for calling [Builder.fileId] with `fileId.orElse(null)`. */
        fun fileId(fileId: Optional<String>) = fileId(fileId.getOrNull())

        /** Schema for update file update request. */
        fun updateFileRequest(updateFileRequest: UpdateFileRequest) = apply {
            this.updateFileRequest = updateFileRequest
        }

        /** Alias for calling [updateFileRequest] with `UpdateFileRequest.ofDetails(details)`. */
        fun updateFileRequest(details: UpdateFileRequest.UpdateFileDetails) =
            updateFileRequest(UpdateFileRequest.ofDetails(details))

        /**
         * Alias for calling [updateFileRequest] with
         * `UpdateFileRequest.ofChangePublicationStatus(changePublicationStatus)`.
         */
        fun updateFileRequest(changePublicationStatus: JsonValue) =
            updateFileRequest(UpdateFileRequest.ofChangePublicationStatus(changePublicationStatus))

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
         * Returns an immutable instance of [FileUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .updateFileRequest()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileUpdateParams =
            FileUpdateParams(
                fileId,
                checkRequired("updateFileRequest", updateFileRequest),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): UpdateFileRequest = updateFileRequest

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> fileId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileUpdateParams &&
            fileId == other.fileId &&
            updateFileRequest == other.updateFileRequest &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(fileId, updateFileRequest, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FileUpdateParams{fileId=$fileId, updateFileRequest=$updateFileRequest, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
