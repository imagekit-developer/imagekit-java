// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.client

import io.imagekit.api.core.ClientOptions
import io.imagekit.api.services.blocking.AccountService
import io.imagekit.api.services.blocking.AssetService
import io.imagekit.api.services.blocking.BetaService
import io.imagekit.api.services.blocking.CacheService
import io.imagekit.api.services.blocking.CustomMetadataFieldService
import io.imagekit.api.services.blocking.FileService
import io.imagekit.api.services.blocking.FolderService
import io.imagekit.api.services.blocking.SavedExtensionService
import io.imagekit.api.services.blocking.WebhookService
import java.util.function.Consumer

/**
 * A client for interacting with the Image Kit REST API synchronously. You can also switch to
 * asynchronous execution via the [async] method.
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
interface ImageKitClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): ImageKitClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ImageKitClient

    fun customMetadataFields(): CustomMetadataFieldService

    fun files(): FileService

    fun savedExtensions(): SavedExtensionService

    fun assets(): AssetService

    fun cache(): CacheService

    fun folders(): FolderService

    fun accounts(): AccountService

    fun beta(): BetaService

    fun webhooks(): WebhookService

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

    /** A view of [ImageKitClient] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ImageKitClient.WithRawResponse

        fun customMetadataFields(): CustomMetadataFieldService.WithRawResponse

        fun files(): FileService.WithRawResponse

        fun savedExtensions(): SavedExtensionService.WithRawResponse

        fun assets(): AssetService.WithRawResponse

        fun cache(): CacheService.WithRawResponse

        fun folders(): FolderService.WithRawResponse

        fun accounts(): AccountService.WithRawResponse

        fun beta(): BetaService.WithRawResponse

        fun webhooks(): WebhookService.WithRawResponse
    }
}
