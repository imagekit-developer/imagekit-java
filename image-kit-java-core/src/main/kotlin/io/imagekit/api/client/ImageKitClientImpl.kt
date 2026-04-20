// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.client

import io.imagekit.api.core.ClientOptions
import io.imagekit.api.core.getPackageVersion
import io.imagekit.api.services.blocking.AccountService
import io.imagekit.api.services.blocking.AccountServiceImpl
import io.imagekit.api.services.blocking.AssetService
import io.imagekit.api.services.blocking.AssetServiceImpl
import io.imagekit.api.services.blocking.BetaService
import io.imagekit.api.services.blocking.BetaServiceImpl
import io.imagekit.api.services.blocking.CacheService
import io.imagekit.api.services.blocking.CacheServiceImpl
import io.imagekit.api.services.blocking.CustomMetadataFieldService
import io.imagekit.api.services.blocking.CustomMetadataFieldServiceImpl
import io.imagekit.api.services.blocking.FileService
import io.imagekit.api.services.blocking.FileServiceImpl
import io.imagekit.api.services.blocking.FolderService
import io.imagekit.api.services.blocking.FolderServiceImpl
import io.imagekit.api.services.blocking.SavedExtensionService
import io.imagekit.api.services.blocking.SavedExtensionServiceImpl
import io.imagekit.api.services.blocking.WebhookService
import io.imagekit.api.services.blocking.WebhookServiceImpl
import java.util.function.Consumer

class ImageKitClientImpl(private val clientOptions: ClientOptions) : ImageKitClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: ImageKitClientAsync by lazy { ImageKitClientAsyncImpl(clientOptions) }

    private val withRawResponse: ImageKitClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val customMetadataFields: CustomMetadataFieldService by lazy {
        CustomMetadataFieldServiceImpl(clientOptionsWithUserAgent)
    }

    private val files: FileService by lazy { FileServiceImpl(clientOptionsWithUserAgent) }

    private val savedExtensions: SavedExtensionService by lazy {
        SavedExtensionServiceImpl(clientOptionsWithUserAgent)
    }

    private val assets: AssetService by lazy { AssetServiceImpl(clientOptionsWithUserAgent) }

    private val cache: CacheService by lazy { CacheServiceImpl(clientOptionsWithUserAgent) }

    private val folders: FolderService by lazy { FolderServiceImpl(clientOptionsWithUserAgent) }

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptionsWithUserAgent) }

    private val beta: BetaService by lazy { BetaServiceImpl(clientOptionsWithUserAgent) }

    private val webhooks: WebhookService by lazy { WebhookServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): ImageKitClientAsync = async

    override fun withRawResponse(): ImageKitClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ImageKitClient =
        ImageKitClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun customMetadataFields(): CustomMetadataFieldService = customMetadataFields

    override fun files(): FileService = files

    override fun savedExtensions(): SavedExtensionService = savedExtensions

    override fun assets(): AssetService = assets

    override fun cache(): CacheService = cache

    override fun folders(): FolderService = folders

    override fun accounts(): AccountService = accounts

    override fun beta(): BetaService = beta

    override fun webhooks(): WebhookService = webhooks

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ImageKitClient.WithRawResponse {

        private val customMetadataFields: CustomMetadataFieldService.WithRawResponse by lazy {
            CustomMetadataFieldServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val files: FileService.WithRawResponse by lazy {
            FileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val savedExtensions: SavedExtensionService.WithRawResponse by lazy {
            SavedExtensionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val assets: AssetService.WithRawResponse by lazy {
            AssetServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val cache: CacheService.WithRawResponse by lazy {
            CacheServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val folders: FolderService.WithRawResponse by lazy {
            FolderServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountService.WithRawResponse by lazy {
            AccountServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val beta: BetaService.WithRawResponse by lazy {
            BetaServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val webhooks: WebhookService.WithRawResponse by lazy {
            WebhookServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ImageKitClient.WithRawResponse =
            ImageKitClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun customMetadataFields(): CustomMetadataFieldService.WithRawResponse =
            customMetadataFields

        override fun files(): FileService.WithRawResponse = files

        override fun savedExtensions(): SavedExtensionService.WithRawResponse = savedExtensions

        override fun assets(): AssetService.WithRawResponse = assets

        override fun cache(): CacheService.WithRawResponse = cache

        override fun folders(): FolderService.WithRawResponse = folders

        override fun accounts(): AccountService.WithRawResponse = accounts

        override fun beta(): BetaService.WithRawResponse = beta

        override fun webhooks(): WebhookService.WithRawResponse = webhooks
    }
}
