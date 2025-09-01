// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.accounts.origins

import com.imagekit.api.core.Params
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.http.Headers
import com.imagekit.api.core.http.QueryParams
import java.util.Objects

/** **Note:** This API is currently in beta. Creates a new origin and returns the origin object. */
class OriginCreateParams
private constructor(
    private val origin: OriginRequest,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Schema for origin request resources. */
    fun origin(): OriginRequest = origin

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [OriginCreateParams].
         *
         * The following fields are required:
         * ```java
         * .origin()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OriginCreateParams]. */
    class Builder internal constructor() {

        private var origin: OriginRequest? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(originCreateParams: OriginCreateParams) = apply {
            origin = originCreateParams.origin
            additionalHeaders = originCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = originCreateParams.additionalQueryParams.toBuilder()
        }

        /** Schema for origin request resources. */
        fun origin(origin: OriginRequest) = apply { this.origin = origin }

        /** Alias for calling [origin] with `OriginRequest.ofS3(s3)`. */
        fun origin(s3: OriginRequest.S3) = origin(OriginRequest.ofS3(s3))

        /** Alias for calling [origin] with `OriginRequest.ofS3Compatible(s3Compatible)`. */
        fun origin(s3Compatible: OriginRequest.S3Compatible) =
            origin(OriginRequest.ofS3Compatible(s3Compatible))

        /** Alias for calling [origin] with `OriginRequest.ofCloudinaryBackup(cloudinaryBackup)`. */
        fun origin(cloudinaryBackup: OriginRequest.CloudinaryBackup) =
            origin(OriginRequest.ofCloudinaryBackup(cloudinaryBackup))

        /** Alias for calling [origin] with `OriginRequest.ofWebFolder(webFolder)`. */
        fun origin(webFolder: OriginRequest.WebFolder) =
            origin(OriginRequest.ofWebFolder(webFolder))

        /** Alias for calling [origin] with `OriginRequest.ofWebProxy(webProxy)`. */
        fun origin(webProxy: OriginRequest.WebProxy) = origin(OriginRequest.ofWebProxy(webProxy))

        /**
         * Alias for calling [origin] with the following:
         * ```java
         * OriginRequest.WebProxy.builder()
         *     .name(name)
         *     .build()
         * ```
         */
        fun webProxyOrigin(name: String) =
            origin(OriginRequest.WebProxy.builder().name(name).build())

        /** Alias for calling [origin] with `OriginRequest.ofGcs(gcs)`. */
        fun origin(gcs: OriginRequest.Gcs) = origin(OriginRequest.ofGcs(gcs))

        /** Alias for calling [origin] with `OriginRequest.ofAzureBlob(azureBlob)`. */
        fun origin(azureBlob: OriginRequest.AzureBlob) =
            origin(OriginRequest.ofAzureBlob(azureBlob))

        /** Alias for calling [origin] with `OriginRequest.ofAkeneoPim(akeneoPim)`. */
        fun origin(akeneoPim: OriginRequest.AkeneoPim) =
            origin(OriginRequest.ofAkeneoPim(akeneoPim))

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
         * Returns an immutable instance of [OriginCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .origin()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OriginCreateParams =
            OriginCreateParams(
                checkRequired("origin", origin),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): OriginRequest = origin

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OriginCreateParams &&
            origin == other.origin &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(origin, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "OriginCreateParams{origin=$origin, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
