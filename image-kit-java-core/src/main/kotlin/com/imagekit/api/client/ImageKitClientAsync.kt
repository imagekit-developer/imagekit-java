// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.client

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.services.async.AccountServiceAsync
import com.imagekit.api.services.async.BulkJobServiceAsync
import com.imagekit.api.services.async.CustomMetadataFieldServiceAsync
import com.imagekit.api.services.async.FileServiceAsync
import com.imagekit.api.services.async.FolderServiceAsync
import java.util.function.Consumer

/**
 * A client for interacting with the Image Kit REST API asynchronously. You can also switch to
 * synchronous execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface ImageKitClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): ImageKitClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ImageKitClientAsync

    fun customMetadataFields(): CustomMetadataFieldServiceAsync

    fun files(): FileServiceAsync

    fun folder(): FolderServiceAsync

    fun bulkJobs(): BulkJobServiceAsync

    fun accounts(): AccountServiceAsync

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /**
     * A view of [ImageKitClientAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ImageKitClientAsync.WithRawResponse

        fun customMetadataFields(): CustomMetadataFieldServiceAsync.WithRawResponse

        fun files(): FileServiceAsync.WithRawResponse

        fun folder(): FolderServiceAsync.WithRawResponse

        fun bulkJobs(): BulkJobServiceAsync.WithRawResponse

        fun accounts(): AccountServiceAsync.WithRawResponse
    }
}
