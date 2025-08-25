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
    private val origin: Origin,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Schema for origin resources. */
    fun origin(): Origin = origin

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

        private var origin: Origin? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(originCreateParams: OriginCreateParams) = apply {
            origin = originCreateParams.origin
            additionalHeaders = originCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = originCreateParams.additionalQueryParams.toBuilder()
        }

        /** Schema for origin resources. */
        fun origin(origin: Origin) = apply { this.origin = origin }

        /** Alias for calling [origin] with `Origin.ofS3(s3)`. */
        fun origin(s3: Origin.S3) = origin(Origin.ofS3(s3))

        /** Alias for calling [origin] with `Origin.ofS3Compatible(s3Compatible)`. */
        fun origin(s3Compatible: Origin.S3Compatible) = origin(Origin.ofS3Compatible(s3Compatible))

        /** Alias for calling [origin] with `Origin.ofCloudinaryBackup(cloudinaryBackup)`. */
        fun origin(cloudinaryBackup: Origin.CloudinaryBackup) =
            origin(Origin.ofCloudinaryBackup(cloudinaryBackup))

        /** Alias for calling [origin] with `Origin.ofWebFolder(webFolder)`. */
        fun origin(webFolder: Origin.WebFolder) = origin(Origin.ofWebFolder(webFolder))

        /** Alias for calling [origin] with `Origin.ofWebProxy(webProxy)`. */
        fun origin(webProxy: Origin.WebProxy) = origin(Origin.ofWebProxy(webProxy))

        /**
         * Alias for calling [origin] with the following:
         * ```java
         * Origin.WebProxy.builder()
         *     .name(name)
         *     .build()
         * ```
         */
        fun webProxyOrigin(name: String) = origin(Origin.WebProxy.builder().name(name).build())

        /** Alias for calling [origin] with `Origin.ofGcs(gcs)`. */
        fun origin(gcs: Origin.Gcs) = origin(Origin.ofGcs(gcs))

        /** Alias for calling [origin] with `Origin.ofAzureBlob(azureBlob)`. */
        fun origin(azureBlob: Origin.AzureBlob) = origin(Origin.ofAzureBlob(azureBlob))

        /** Alias for calling [origin] with `Origin.ofAkeneoPim(akeneoPim)`. */
        fun origin(akeneoPim: Origin.AkeneoPim) = origin(Origin.ofAkeneoPim(akeneoPim))

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

    fun _body(): Origin = origin

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
