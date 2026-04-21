// File generated from our OpenAPI spec by Stainless.

package io.imagekit.client

import io.imagekit.core.ClientOptions
import io.imagekit.core.getPackageVersion
import io.imagekit.lib.Helper
import io.imagekit.lib.HelperService
import io.imagekit.services.async.AccountServiceAsync
import io.imagekit.services.async.AccountServiceAsyncImpl
import io.imagekit.services.async.AssetServiceAsync
import io.imagekit.services.async.AssetServiceAsyncImpl
import io.imagekit.services.async.BetaServiceAsync
import io.imagekit.services.async.BetaServiceAsyncImpl
import io.imagekit.services.async.CacheServiceAsync
import io.imagekit.services.async.CacheServiceAsyncImpl
import io.imagekit.services.async.CustomMetadataFieldServiceAsync
import io.imagekit.services.async.CustomMetadataFieldServiceAsyncImpl
import io.imagekit.services.async.FileServiceAsync
import io.imagekit.services.async.FileServiceAsyncImpl
import io.imagekit.services.async.FolderServiceAsync
import io.imagekit.services.async.FolderServiceAsyncImpl
import io.imagekit.services.async.SavedExtensionServiceAsync
import io.imagekit.services.async.SavedExtensionServiceAsyncImpl
import io.imagekit.services.async.WebhookServiceAsync
import io.imagekit.services.async.WebhookServiceAsyncImpl
import java.util.function.Consumer

class ImageKitClientAsyncImpl(private val clientOptions: ClientOptions) : ImageKitClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: ImageKitClient by lazy { ImageKitClientImpl(clientOptions) }

    private val withRawResponse: ImageKitClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val customMetadataFields: CustomMetadataFieldServiceAsync by lazy {
        CustomMetadataFieldServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val files: FileServiceAsync by lazy { FileServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val savedExtensions: SavedExtensionServiceAsync by lazy {
        SavedExtensionServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val assets: AssetServiceAsync by lazy {
        AssetServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val cache: CacheServiceAsync by lazy {
        CacheServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val folders: FolderServiceAsync by lazy {
        FolderServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val accounts: AccountServiceAsync by lazy {
        AccountServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val beta: BetaServiceAsync by lazy { BetaServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val webhooks: WebhookServiceAsync by lazy {
        WebhookServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val helper: Helper by lazy { Helper.create(clientOptions) }

    override fun sync(): ImageKitClient = sync

    override fun withRawResponse(): ImageKitClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ImageKitClientAsync =
        ImageKitClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun customMetadataFields(): CustomMetadataFieldServiceAsync = customMetadataFields

    override fun files(): FileServiceAsync = files

    override fun savedExtensions(): SavedExtensionServiceAsync = savedExtensions

    override fun assets(): AssetServiceAsync = assets

    override fun cache(): CacheServiceAsync = cache

    override fun folders(): FolderServiceAsync = folders

    override fun accounts(): AccountServiceAsync = accounts

    override fun beta(): BetaServiceAsync = beta

    override fun webhooks(): WebhookServiceAsync = webhooks

    override fun helper(): HelperService = helper

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ImageKitClientAsync.WithRawResponse {

        private val customMetadataFields: CustomMetadataFieldServiceAsync.WithRawResponse by lazy {
            CustomMetadataFieldServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val files: FileServiceAsync.WithRawResponse by lazy {
            FileServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val savedExtensions: SavedExtensionServiceAsync.WithRawResponse by lazy {
            SavedExtensionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val assets: AssetServiceAsync.WithRawResponse by lazy {
            AssetServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val cache: CacheServiceAsync.WithRawResponse by lazy {
            CacheServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val folders: FolderServiceAsync.WithRawResponse by lazy {
            FolderServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountServiceAsync.WithRawResponse by lazy {
            AccountServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val beta: BetaServiceAsync.WithRawResponse by lazy {
            BetaServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val webhooks: WebhookServiceAsync.WithRawResponse by lazy {
            WebhookServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ImageKitClientAsync.WithRawResponse =
            ImageKitClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun customMetadataFields(): CustomMetadataFieldServiceAsync.WithRawResponse =
            customMetadataFields

        override fun files(): FileServiceAsync.WithRawResponse = files

        override fun savedExtensions(): SavedExtensionServiceAsync.WithRawResponse = savedExtensions

        override fun assets(): AssetServiceAsync.WithRawResponse = assets

        override fun cache(): CacheServiceAsync.WithRawResponse = cache

        override fun folders(): FolderServiceAsync.WithRawResponse = folders

        override fun accounts(): AccountServiceAsync.WithRawResponse = accounts

        override fun beta(): BetaServiceAsync.WithRawResponse = beta

        override fun webhooks(): WebhookServiceAsync.WithRawResponse = webhooks
    }
}
